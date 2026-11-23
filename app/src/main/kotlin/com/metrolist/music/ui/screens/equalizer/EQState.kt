package com.metrolist.music.ui.screens.equalizer

import com.metrolist.music.eq.audio.DetectedAudioDevice
import com.metrolist.music.eq.audio.OutputDeviceCategory
import com.metrolist.music.eq.data.FilterType
import com.metrolist.music.eq.data.ParametricEQBand
import com.metrolist.music.eq.data.SavedEQProfile

data class EQState(
    val profiles: List<SavedEQProfile> = emptyList(),
    val activeProfileId: String? = null,
    val isCustom10BandEnabled: Boolean = false,
    val tenBandGains: List<Double> = List(10) { 0.0 },
    val tenBandQs: List<Double> = List(10) { OutputDeviceCategory.DEFAULT_ISO_Q },
    val tenBandTypes: List<FilterType> = List(10) { FilterType.PK },
    val selectedBandIndex: Int = 0,
    val tenBandPreamp: Double = 0.0,
    val activeBands: List<ParametricEQBand> = emptyList(),
    val activePreamp: Double = 0.0,
    val detectedDevice: DetectedAudioDevice = DetectedAudioDevice(
        name = "Phone Speaker",
        category = OutputDeviceCategory.PHONE_SPEAKER
    ),
    val autoSwitchPerDevice: Boolean = true,
    val importStatus: String? = null,
    val error: String? = null
)
