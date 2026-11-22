package com.metrolist.music.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.hapticfeedback.HapticFeedback
import kotlinx.coroutines.CoroutineScope
import kotlin.math.roundToInt

class LensController(
    val n: Int,
    val scope: CoroutineScope,
    val haptics: HapticFeedback,
    initialIndex: Int = 0
) {
    val pos = Animatable(initialIndex.toFloat())
    val press = Animatable(0f)
    val stretch = Animatable(0f)

    var dragging by mutableStateOf(false)
    var selected by mutableIntStateOf(initialIndex)
    var onSelect: (Int) -> Unit = {}

    val nearest by derivedStateOf {
        pos.value.roundToInt().coerceIn(0, (n - 1).coerceAtLeast(0))
    }
}
