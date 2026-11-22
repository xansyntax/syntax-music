package com.metrolist.music.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

enum class UiStyle {
    EDITORIAL,
    GLASS
}

val LocalUiStyle = staticCompositionLocalOf { UiStyle.GLASS }

@Composable
@ReadOnlyComposable
fun isGlassStyle(): Boolean = LocalUiStyle.current == UiStyle.GLASS

@Composable
@ReadOnlyComposable
fun styledRadius(glassRadius: Dp, editorialRadius: Dp): Dp =
    if (LocalUiStyle.current == UiStyle.GLASS) glassRadius else editorialRadius
