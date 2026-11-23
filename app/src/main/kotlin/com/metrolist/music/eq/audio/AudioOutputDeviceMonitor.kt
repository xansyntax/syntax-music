package com.metrolist.music.eq.audio

import android.content.Context
import android.media.AudioDeviceCallback
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import com.metrolist.music.eq.data.FilterType
import com.metrolist.music.eq.data.ParametricEQBand
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

enum class OutputDeviceCategory(
    val displayType: String,
    val recommendation: String,
    val suggestedGains: List<Double>,
    val suggestedPreamp: Double
) {
    USB_DAC(
        displayType = "USB DAC / Hi-Res Dongle",
        recommendation = "ISO 10-Band Reference: Sub-Bass Extension (31Hz–62Hz) & Air (16kHz)",
        suggestedGains = listOf(1.5, 1.0, 0.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0, 2.5),
        suggestedPreamp = -2.5
    ),
    BLUETOOTH(
        displayType = "Bluetooth Wireless / TWS",
        recommendation = "ISO 10-Band Wireless: Vocal Clarity (2kHz–4kHz) & Tight Sub-Bass",
        suggestedGains = listOf(2.5, 2.0, 0.5, -1.0, 0.0, 1.5, 2.5, 3.0, 2.0, 1.5),
        suggestedPreamp = -3.0
    ),
    WIRED_HEADSET(
        displayType = "Wired IEM / Headphones",
        recommendation = "ISO 10-Band Harman: Clean Low-End & Natural Presence",
        suggestedGains = listOf(2.0, 1.5, 0.5, -0.5, 0.0, 0.5, 1.5, 2.0, 1.5, 1.0),
        suggestedPreamp = -2.0
    ),
    PHONE_SPEAKER(
        displayType = "Built-in Phone Speaker",
        recommendation = "ISO 10-Band Micro-Driver: Mid-Bass Punch (125Hz–250Hz) & Vocal Presence",
        suggestedGains = listOf(-2.0, 1.5, 3.5, 2.5, 1.0, 2.0, 3.0, 2.5, 1.5, 0.5),
        suggestedPreamp = -3.5
    );

    fun toParametricBands(): List<ParametricEQBand> =
        TEN_BAND_FREQUENCIES.mapIndexed { idx, freq ->
            ParametricEQBand(
                frequency = freq,
                gain = suggestedGains.getOrElse(idx) { 0.0 },
                q = DEFAULT_ISO_Q,
                filterType = FilterType.PK,
                enabled = true
            )
        }

    companion object {
        const val DEFAULT_ISO_Q = 2.87
        val TEN_BAND_FREQUENCIES = listOf(
            31.25, 62.5, 125.0, 250.0, 500.0,
            1000.0, 2000.0, 4000.0, 8000.0, 16000.0
        )
        val TEN_BAND_LABELS = listOf(
            "31Hz", "62Hz", "125Hz", "250Hz", "500Hz",
            "1kHz", "2kHz", "4kHz", "8kHz", "16kHz"
        )
    }
}

data class DetectedAudioDevice(
    val name: String,
    val category: OutputDeviceCategory,
    val sampleRates: List<Int> = emptyList(),
    val isExternal: Boolean = false
)

@Singleton
class AudioOutputDeviceMonitor @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    private val _currentDevice = MutableStateFlow(detectCurrentOutputDevice())
    val currentDevice: StateFlow<DetectedAudioDevice> = _currentDevice.asStateFlow()

    private val deviceCallback = object : AudioDeviceCallback() {
        override fun onAudioDevicesAdded(addedDevices: Array<out AudioDeviceInfo>?) {
            refreshDevice()
        }

        override fun onAudioDevicesRemoved(removedDevices: Array<out AudioDeviceInfo>?) {
            refreshDevice()
        }
    }

    init {
        audioManager.registerAudioDeviceCallback(deviceCallback, Handler(Looper.getMainLooper()))
    }

    fun refreshDevice() {
        _currentDevice.value = detectCurrentOutputDevice()
    }

    private fun detectCurrentOutputDevice(): DetectedAudioDevice {
        val outputs = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)

        val usbDevice = outputs.firstOrNull {
            it.type == AudioDeviceInfo.TYPE_USB_HEADSET ||
                it.type == AudioDeviceInfo.TYPE_USB_DEVICE ||
                it.type == AudioDeviceInfo.TYPE_USB_ACCESSORY
        }
        if (usbDevice != null) {
            return buildDeviceInfo(usbDevice, OutputDeviceCategory.USB_DAC, "USB Audio DAC", true)
        }

        val btDevice = outputs.firstOrNull {
            it.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP ||
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    (it.type == AudioDeviceInfo.TYPE_BLE_HEADSET || it.type == AudioDeviceInfo.TYPE_BLE_SPEAKER))
        }
        if (btDevice != null) {
            return buildDeviceInfo(btDevice, OutputDeviceCategory.BLUETOOTH, "Bluetooth Audio", true)
        }

        val wiredDevice = outputs.firstOrNull {
            it.type == AudioDeviceInfo.TYPE_WIRED_HEADSET ||
                it.type == AudioDeviceInfo.TYPE_WIRED_HEADPHONES ||
                it.type == AudioDeviceInfo.TYPE_LINE_ANALOG ||
                it.type == AudioDeviceInfo.TYPE_LINE_DIGITAL
        }
        if (wiredDevice != null) {
            return buildDeviceInfo(wiredDevice, OutputDeviceCategory.WIRED_HEADSET, "Wired Headphones / IEM", true)
        }

        val speakerDevice = outputs.firstOrNull { it.type == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER }
        return if (speakerDevice != null) {
            buildDeviceInfo(speakerDevice, OutputDeviceCategory.PHONE_SPEAKER, "Phone Speaker", false)
        } else {
            DetectedAudioDevice(
                name = "${Build.MANUFACTURER} ${Build.MODEL}".trim(),
                category = OutputDeviceCategory.PHONE_SPEAKER,
                isExternal = false
            )
        }
    }

    private fun buildDeviceInfo(
        info: AudioDeviceInfo,
        category: OutputDeviceCategory,
        fallbackName: String,
        isExternal: Boolean
    ): DetectedAudioDevice {
        val rawName = info.productName?.toString()?.trim().orEmpty()
        val resolvedName = when {
            category == OutputDeviceCategory.PHONE_SPEAKER ->
                "${Build.MODEL} Speaker".trim()
            rawName.isBlank() || rawName.equals(Build.MODEL, ignoreCase = true) ->
                fallbackName
            else -> rawName
        }
        return DetectedAudioDevice(
            name = resolvedName,
            category = category,
            sampleRates = info.sampleRates?.toList().orEmpty(),
            isExternal = isExternal
        )
    }
}
