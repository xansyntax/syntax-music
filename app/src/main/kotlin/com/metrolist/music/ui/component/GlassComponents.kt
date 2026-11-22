package com.metrolist.music.ui.component

import android.app.ActivityManager
import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.metrolist.music.ui.theme.LocalUiStyle
import com.metrolist.music.ui.theme.UiStyle
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeEffect

val LocalHazeState = staticCompositionLocalOf<HazeState?> { null }
val LocalGlassBlurEnabled = staticCompositionLocalOf { true }

val GlassCardShape = RoundedCornerShape(24.dp)
val GlassOverlayShape = RoundedCornerShape(32.dp)

@Composable
@ReadOnlyComposable
fun isGlass(): Boolean = LocalUiStyle.current == UiStyle.GLASS

@Composable
@ReadOnlyComposable
fun isDarkSurface(): Boolean = MaterialTheme.colorScheme.surface.luminance() < 0.5f

fun glassBlurDefault(context: Context): Boolean {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
        ?: return true
    return !activityManager.isLowRamDevice && activityManager.memoryClass >= 192
}

@Composable
@ReadOnlyComposable
fun glassFill(elevated: Boolean = false): Color {
    return if (isDarkSurface()) {
        Color.White.copy(alpha = if (elevated) 0.13f else 0.08f)
    } else {
        Color.White.copy(alpha = if (elevated) 0.78f else 0.55f)
    }
}

@Composable
fun glassRim(): Brush {
    val glass = isGlass()
    val dark = isDarkSurface()
    val outline = MaterialTheme.colorScheme.outlineVariant
    return remember(glass, dark, outline) {
        if (glass) {
            val topLeft = Color.White.copy(alpha = if (dark) 0.48f else 0.95f)
            val mid = Color.White.copy(alpha = if (dark) 0.05f else 0.25f)
            val bottomRight = Color.White.copy(alpha = if (dark) 0.22f else 0.65f)
            Brush.linearGradient(
                colors = listOf(topLeft, mid, mid, bottomRight),
                start = Offset.Zero,
                end = Offset.Infinite
            )
        } else {
            Brush.linearGradient(listOf(outline, outline))
        }
    }
}

@Composable
fun glassSheen(): Brush {
    val dark = isDarkSurface()
    return remember(dark) {
        Brush.verticalGradient(
            0.0f to Color.White.copy(alpha = if (dark) 0.10f else 0.35f),
            0.5f to Color.Transparent
        )
    }
}

fun Modifier.ambientGlow(): Modifier = composed {
    if (!isGlass()) return@composed this
    val colorScheme = MaterialTheme.colorScheme
    val dark = isDarkSurface()
    val spec = tween<Color>(durationMillis = 900)

    val glowA by animateColorAsState(
        targetValue = colorScheme.primary.copy(alpha = if (dark) 0.40f else 0.30f),
        animationSpec = spec,
        label = "glowA"
    )
    val glowB by animateColorAsState(
        targetValue = colorScheme.secondary.copy(alpha = if (dark) 0.20f else 0.30f),
        animationSpec = spec,
        label = "glowB"
    )
    val glowC by animateColorAsState(
        targetValue = colorScheme.tertiary.copy(alpha = if (dark) 0.26f else 0.22f),
        animationSpec = spec,
        label = "glowC"
    )

    drawWithCache {
        val brushA = Brush.radialGradient(
            colors = listOf(glowA, Color.Transparent),
            center = Offset(size.width * 0.2f, size.height * 0.15f),
            radius = size.maxDimension * 0.75f
        )
        val brushB = Brush.radialGradient(
            colors = listOf(glowB, Color.Transparent),
            center = Offset(size.width * 0.85f, size.height * 0.45f),
            radius = size.maxDimension * 0.65f
        )
        val brushC = Brush.radialGradient(
            colors = listOf(glowC, Color.Transparent),
            center = Offset(size.width * 0.5f, size.height * 0.9f),
            radius = size.maxDimension * 0.7f
        )
        onDrawBehind {
            drawRect(brushA)
            drawRect(brushB)
            drawRect(brushC)
        }
    }
}

fun Modifier.glass(
    shape: Shape = GlassCardShape,
    elevated: Boolean = false
): Modifier = composed {
    if (isGlass()) {
        val fill = glassFill(elevated)
        val rim = glassRim()
        val sheen = glassSheen()
        this
            .clip(shape)
            .background(fill)
            .drawBehind { drawRect(sheen) }
            .border(1.dp, rim, shape)
    } else {
        val colorScheme = MaterialTheme.colorScheme
        this
            .clip(shape)
            .background(colorScheme.surfaceContainer)
            .border(1.dp, colorScheme.outlineVariant, shape)
    }
}

fun Modifier.glassCard(shape: Shape = GlassCardShape): Modifier = composed {
    val colorScheme = MaterialTheme.colorScheme
    if (isGlass()) {
        val dark = isDarkSurface()
        this
            .clip(shape)
            .background(Color.White.copy(alpha = if (dark) 0.075f else 0.72f))
            .border(0.8.dp, Color.White.copy(alpha = if (dark) 0.10f else 0.85f), shape)
    } else {
        this
            .clip(shape)
            .background(colorScheme.surfaceContainer)
            .border(1.dp, colorScheme.outlineVariant, shape)
    }
}

fun Modifier.glassBlur(shape: RoundedCornerShape = GlassCardShape): Modifier = composed {
    val colorScheme = MaterialTheme.colorScheme
    if (isGlass()) {
        val hazeState = LocalHazeState.current
        val blurEnabled = hazeState != null && LocalGlassBlurEnabled.current
        if (!blurEnabled) {
            this
                .background(colorScheme.surface.copy(alpha = 0.86f), shape)
                .glass(shape = shape, elevated = true)
        } else {
            val fill = glassFill(elevated = true)
            val rim = glassRim()
            val sheen = glassSheen()
            this
                .clip(shape)
                .hazeEffect(
                    state = hazeState,
                    style = HazeStyle(
                        backgroundColor = colorScheme.surface,
                        tint = HazeTint(fill),
                        blurRadius = 16.dp
                    )
                )
                .drawBehind { drawRect(sheen) }
                .border(1.dp, rim, shape)
        }
    } else {
        this
            .clip(shape)
            .background(colorScheme.surfaceContainerHigh.compositeOver(colorScheme.surface))
            .border(1.dp, colorScheme.outlineVariant, shape)
    }
}

fun Modifier.glassOverlay(shape: Shape = GlassOverlayShape): Modifier = composed {
    val colorScheme = MaterialTheme.colorScheme
    if (isGlass()) {
        val rim = glassRim()
        val sheen = glassSheen()
        this
            .clip(shape)
            .background(colorScheme.surface)
            .ambientGlow()
            .background(glassFill(elevated = true))
            .drawBehind { drawRect(sheen) }
            .border(1.dp, rim, shape)
    } else {
        this
            .clip(shape)
            .background(colorScheme.surfaceContainerHigh.compositeOver(colorScheme.surface))
            .border(1.dp, colorScheme.outlineVariant, shape)
    }
}

fun Modifier.glassTinted(shape: Shape = GlassCardShape): Modifier = composed {
    val primary = MaterialTheme.colorScheme.primary
    if (isGlass()) {
        val rim = glassRim()
        val sheen = remember {
            Brush.verticalGradient(
                0.0f to Color.White.copy(alpha = 0.38f),
                0.55f to Color.Transparent
            )
        }
        this
            .clip(shape)
            .background(primary.copy(alpha = 0.86f))
            .drawBehind { drawRect(sheen) }
            .border(1.dp, rim, shape)
    } else {
        this
            .clip(shape)
            .background(primary)
    }
}

@Composable
@ReadOnlyComposable
fun glassShape(glassRadius: Dp, editorialRadius: Dp): RoundedCornerShape =
    RoundedCornerShape(if (isGlass()) glassRadius else editorialRadius)

@Composable
@ReadOnlyComposable
fun glassTopShape(editorialRadius: Dp): RoundedCornerShape {
    val radius = if (isGlass()) 32.dp else editorialRadius
    return RoundedCornerShape(
        topStart = CornerSize(radius),
        topEnd = CornerSize(radius),
        bottomEnd = CornerSize(0.dp),
        bottomStart = CornerSize(0.dp)
    )
}

@Composable
fun glassListItemColors(): ListItemColors =
    ListItemDefaults.colors(
        containerColor = if (isGlass()) Color.Transparent else Color.Unspecified
    )
