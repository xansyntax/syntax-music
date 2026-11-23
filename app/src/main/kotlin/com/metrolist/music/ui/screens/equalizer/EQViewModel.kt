package com.metrolist.music.ui.screens.equalizer

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metrolist.music.eq.EqualizerService
import com.metrolist.music.eq.audio.AudioOutputDeviceMonitor
import com.metrolist.music.eq.audio.DetectedAudioDevice
import com.metrolist.music.eq.audio.OutputDeviceCategory
import com.metrolist.music.eq.data.EQProfileRepository
import com.metrolist.music.eq.data.FilterType
import com.metrolist.music.eq.data.ParametricEQBand
import com.metrolist.music.eq.data.ParametricEQParser
import com.metrolist.music.eq.data.SavedEQProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.InputStream
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class EQViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val eqProfileRepository: EQProfileRepository,
    private val equalizerService: EqualizerService,
    private val deviceMonitor: AudioOutputDeviceMonitor
) : ViewModel() {

    private val prefs = context.getSharedPreferences("syntax_10band_eq", Context.MODE_PRIVATE)

    private val _state = MutableStateFlow(
        EQState(
            autoSwitchPerDevice = prefs.getBoolean("auto_switch_device", true)
        )
    )
    val state: StateFlow<EQState> = _state.asStateFlow()

    init {
        loadSaved10BandState()
        observeProfiles()
        observeOutputDevice()
    }

    private fun loadSaved10BandState() {
        val enabled = prefs.getBoolean("custom_10band_enabled", false)
        val preamp = prefs.getFloat("custom_10band_preamp", 0f).toDouble()
        val gains = (0 until 10).map { idx ->
            prefs.getFloat("band_$idx", 0f).toDouble()
        }
        val qs = (0 until 10).map { idx ->
            prefs.getFloat("band_q_$idx", OutputDeviceCategory.DEFAULT_ISO_Q.toFloat()).toDouble()
        }
        val types = (0 until 10).map { idx ->
            val raw = prefs.getString("band_type_$idx", FilterType.PK.name) ?: FilterType.PK.name
            runCatching { FilterType.valueOf(raw) }.getOrDefault(FilterType.PK)
        }
        val bands = buildTenBands(gains, qs, types)

        _state.update {
            it.copy(
                isCustom10BandEnabled = enabled,
                tenBandGains = gains,
                tenBandQs = qs,
                tenBandTypes = types,
                tenBandPreamp = preamp,
                activeBands = if (enabled) bands else it.activeBands,
                activePreamp = if (enabled) preamp else it.activePreamp
            )
        }

        if (enabled) {
            applyCustomTenBandToEngine(gains, qs, types, preamp, savePrefs = false)
        }
    }

    private fun observeProfiles() {
        viewModelScope.launch {
            eqProfileRepository.profiles.collect {
                val sortedProfiles = eqProfileRepository.getSortedProfiles()
                _state.update { st -> st.copy(profiles = sortedProfiles) }
            }
        }

        viewModelScope.launch {
            eqProfileRepository.activeProfile.collect { activeProfile ->
                if (activeProfile != null) {
                    _state.update {
                        it.copy(
                            activeProfileId = activeProfile.id,
                            isCustom10BandEnabled = false,
                            activeBands = activeProfile.bands,
                            activePreamp = activeProfile.preamp
                        )
                    }
                } else {
                    _state.update {
                        it.copy(
                            activeProfileId = null,
                            activeBands = if (it.isCustom10BandEnabled) {
                                buildTenBands(it.tenBandGains, it.tenBandQs, it.tenBandTypes)
                            } else {
                                emptyList()
                            },
                            activePreamp = if (it.isCustom10BandEnabled) it.tenBandPreamp else 0.0
                        )
                    }
                }
            }
        }
    }

    private fun observeOutputDevice() {
        viewModelScope.launch {
            deviceMonitor.currentDevice.collect { device ->
                _state.update { it.copy(detectedDevice = device) }
                if (_state.value.autoSwitchPerDevice) {
                    autoLoadDevicePresetIfExists(device)
                }
            }
        }
    }

    private fun autoLoadDevicePresetIfExists(device: DetectedAudioDevice) {
        val matchingProfile = eqProfileRepository.profiles.value.firstOrNull {
            it.deviceModel.equals(device.name, ignoreCase = true)
        }
        if (matchingProfile != null) {
            if (matchingProfile.bands.size == 10) {
                val gains = matchingProfile.bands.map { it.gain }
                val qs = matchingProfile.bands.map { it.q }
                val types = matchingProfile.bands.map { it.filterType }
                updateAllTenBands(gains, qs, types, matchingProfile.preamp)
            } else {
                selectProfile(matchingProfile.id)
            }
        }
    }

    fun selectBandIndex(index: Int) {
        if (index in 0..9) {
            _state.update { it.copy(selectedBandIndex = index) }
        }
    }

    fun refreshDetectedDevice() {
        deviceMonitor.refreshDevice()
    }

    fun toggleAutoSwitchPerDevice(enabled: Boolean) {
        prefs.edit { putBoolean("auto_switch_device", enabled) }
        _state.update { it.copy(autoSwitchPerDevice = enabled) }
        if (enabled) {
            autoLoadDevicePresetIfExists(_state.value.detectedDevice)
        }
    }

    fun setCustom10BandEnabled(enabled: Boolean) {
        prefs.edit { putBoolean("custom_10band_enabled", enabled) }
        if (enabled) {
            viewModelScope.launch {
                eqProfileRepository.setActiveProfile(null)
            }
            val st = _state.value
            _state.update {
                it.copy(
                    isCustom10BandEnabled = true,
                    activeProfileId = null,
                    activeBands = buildTenBands(st.tenBandGains, st.tenBandQs, st.tenBandTypes),
                    activePreamp = st.tenBandPreamp
                )
            }
            applyCustomTenBandToEngine(st.tenBandGains, st.tenBandQs, st.tenBandTypes, st.tenBandPreamp, savePrefs = false)
        } else {
            _state.update {
                it.copy(
                    isCustom10BandEnabled = false,
                    activeBands = emptyList(),
                    activePreamp = 0.0
                )
            }
            equalizerService.disable()
        }
    }

    fun updateBandGain(bandIndex: Int, newGainDb: Double) {
        if (bandIndex !in 0..9) return
        val snapped = (newGainDb.coerceIn(-15.0, 15.0) * 10.0).roundToInt() / 10.0
        val updatedGains = _state.value.tenBandGains.toMutableList().apply {
            this[bandIndex] = snapped
        }
        _state.update { it.copy(selectedBandIndex = bandIndex) }
        updateAllTenBands(updatedGains, _state.value.tenBandQs, _state.value.tenBandTypes, _state.value.tenBandPreamp)
    }

    fun nudgeSelectedBandGain(deltaDb: Double) {
        val idx = _state.value.selectedBandIndex
        val current = _state.value.tenBandGains.getOrElse(idx) { 0.0 }
        updateBandGain(idx, current + deltaDb)
    }

    fun updateSelectedBandQ(newQ: Double) {
        val idx = _state.value.selectedBandIndex
        val snappedQ = (newQ.coerceIn(0.4, 8.0) * 100.0).roundToInt() / 100.0
        val updatedQs = _state.value.tenBandQs.toMutableList().apply {
            this[idx] = snappedQ
        }
        updateAllTenBands(_state.value.tenBandGains, updatedQs, _state.value.tenBandTypes, _state.value.tenBandPreamp)
    }

    fun updateSelectedBandType(newType: FilterType) {
        val idx = _state.value.selectedBandIndex
        val updatedTypes = _state.value.tenBandTypes.toMutableList().apply {
            this[idx] = newType
        }
        updateAllTenBands(_state.value.tenBandGains, _state.value.tenBandQs, updatedTypes, _state.value.tenBandPreamp)
    }

    fun updateTenBandPreamp(newPreampDb: Double) {
        val snapped = (newPreampDb.coerceIn(-15.0, 15.0) * 10.0).roundToInt() / 10.0
        updateAllTenBands(_state.value.tenBandGains, _state.value.tenBandQs, _state.value.tenBandTypes, snapped)
    }

    fun applyAutoTuneForCurrentDevice() {
        val category = _state.value.detectedDevice.category
        updateAllTenBands(
            gains = category.suggestedGains,
            qs = List(10) { OutputDeviceCategory.DEFAULT_ISO_Q },
            types = List(10) { FilterType.PK },
            preamp = category.suggestedPreamp
        )
    }

    fun resetTenBandFlat() {
        updateAllTenBands(
            gains = List(10) { 0.0 },
            qs = List(10) { OutputDeviceCategory.DEFAULT_ISO_Q },
            types = List(10) { FilterType.PK },
            preamp = 0.0
        )
    }

    fun saveCurrent10BandForDevice() {
        viewModelScope.launch {
            val st = _state.value
            val device = st.detectedDevice
            val existing = eqProfileRepository.profiles.value.firstOrNull {
                it.deviceModel.equals(device.name, ignoreCase = true)
            }
            val profile = SavedEQProfile(
                id = existing?.id ?: "device_10band_${device.name.lowercase().replace(Regex("[^a-z0-9]"), "_")}",
                name = "${device.name} (10-Band)",
                deviceModel = device.name,
                bands = buildTenBands(st.tenBandGains, st.tenBandQs, st.tenBandTypes),
                preamp = st.tenBandPreamp,
                source = device.category.displayType,
                rig = "EasyEffects ISO 10-Band",
                isCustom = true,
                isActive = true
            )
            eqProfileRepository.saveProfile(profile)
            _state.update {
                it.copy(importStatus = "Saved 10-Band EQ for ${device.name}")
            }
        }
    }

    private fun updateAllTenBands(
        gains: List<Double>,
        qs: List<Double>,
        types: List<FilterType>,
        preamp: Double
    ) {
        if (_state.value.activeProfileId != null) {
            viewModelScope.launch { eqProfileRepository.setActiveProfile(null) }
        }
        val bands = buildTenBands(gains, qs, types)
        _state.update {
            it.copy(
                isCustom10BandEnabled = true,
                activeProfileId = null,
                tenBandGains = gains,
                tenBandQs = qs,
                tenBandTypes = types,
                tenBandPreamp = preamp,
                activeBands = bands,
                activePreamp = preamp
            )
        }
        applyCustomTenBandToEngine(gains, qs, types, preamp, savePrefs = true)
    }

    private fun applyCustomTenBandToEngine(
        gains: List<Double>,
        qs: List<Double>,
        types: List<FilterType>,
        preamp: Double,
        savePrefs: Boolean
    ) {
        if (savePrefs) {
            prefs.edit {
                putBoolean("custom_10band_enabled", true)
                putFloat("custom_10band_preamp", preamp.toFloat())
                gains.forEachIndexed { idx, g -> putFloat("band_$idx", g.toFloat()) }
                qs.forEachIndexed { idx, q -> putFloat("band_q_$idx", q.toFloat()) }
                types.forEachIndexed { idx, t -> putString("band_type_$idx", t.name) }
            }
        }
        val profile = SavedEQProfile(
            id = "live_10band_custom",
            name = "10-Band Custom",
            deviceModel = _state.value.detectedDevice.name,
            bands = buildTenBands(gains, qs, types),
            preamp = preamp,
            isCustom = true,
            isActive = true
        )
        equalizerService.applyProfile(profile)
    }

    private fun buildTenBands(
        gains: List<Double>,
        qs: List<Double>,
        types: List<FilterType>
    ): List<ParametricEQBand> =
        OutputDeviceCategory.TEN_BAND_FREQUENCIES.mapIndexed { idx, freq ->
            ParametricEQBand(
                frequency = freq,
                gain = gains.getOrElse(idx) { 0.0 },
                q = qs.getOrElse(idx) { OutputDeviceCategory.DEFAULT_ISO_Q },
                filterType = types.getOrElse(idx) { FilterType.PK },
                enabled = true
            )
        }

    fun selectProfile(profileId: String?) {
        viewModelScope.launch {
            if (profileId == null) {
                prefs.edit { putBoolean("custom_10band_enabled", false) }
                equalizerService.disable()
                eqProfileRepository.setActiveProfile(null)
                _state.update {
                    it.copy(
                        isCustom10BandEnabled = false,
                        activeProfileId = null,
                        activeBands = emptyList(),
                        activePreamp = 0.0
                    )
                }
            } else {
                val profile = _state.value.profiles.find { it.id == profileId }
                if (profile != null) {
                    val result = equalizerService.applyProfile(profile)
                    result.onSuccess {
                        prefs.edit { putBoolean("custom_10band_enabled", false) }
                        eqProfileRepository.setActiveProfile(profileId)
                    }.onFailure { e ->
                        _state.update { it.copy(error = e.message ?: "Unknown error") }
                    }
                }
            }
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun clearImportStatus() {
        _state.update { it.copy(importStatus = null) }
    }

    fun deleteProfile(profileId: String) {
        viewModelScope.launch {
            eqProfileRepository.deleteProfile(profileId)
        }
    }

    fun importCustomProfile(
        fileName: String,
        inputStream: InputStream,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val content = inputStream.bufferedReader().use { it.readText() }
                inputStream.close()

                val parametricEQ = ParametricEQParser.parseText(content)
                val validationErrors = ParametricEQParser.validate(parametricEQ)
                if (validationErrors.isNotEmpty()) {
                    onError(Exception("Invalid EQ file: ${validationErrors.first()}"))
                    return@launch
                }

                val profileName = fileName.removeSuffix(".txt")
                eqProfileRepository.importCustomProfile(profileName, parametricEQ)

                _state.update { it.copy(importStatus = "Successfully imported $profileName") }
                onSuccess()
            } catch (e: Exception) {
                onError(Exception("Failed to import EQ profile: ${e.message}"))
            }
        }
    }
}
