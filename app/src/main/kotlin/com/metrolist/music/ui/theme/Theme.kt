package com.metrolist.music.ui.theme

import android.graphics.Bitmap
import android.os.Build
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamiccolor.ColorSpec
import com.materialkolor.rememberDynamicColorScheme
import com.materialkolor.score.Score

val DefaultThemeColor = Color(0xFFED5564)

val EditorialShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(16.dp)
)

val GlassShapes = Shapes(
    extraSmall = RoundedCornerShape(10.dp),
    small = RoundedCornerShape(14.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(36.dp)
)

val PaperLight = lightColorScheme(
    primary = Color(0xFF984061),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFD9E2),
    onPrimaryContainer = Color(0xFF3E001D),
    surface = Color(0xFFFFF8F8),
    background = Color(0xFFFFF8F8),
    surfaceContainer = Color(0xFFFCEAEF),
    surfaceContainerHigh = Color(0xFFF6E4E9)
)

val PaperDark = darkColorScheme(
    primary = Color(0xFFFFB1C8),
    onPrimary = Color(0xFF5E1133),
    primaryContainer = Color(0xFF7B2949),
    onPrimaryContainer = Color(0xFFFFD9E2),
    surface = Color(0xFF191113),
    background = Color(0xFF191113),
    surfaceContainer = Color(0xFF261D1F),
    surfaceContainerHigh = Color(0xFF31282A)
)

val GlassLight = lightColorScheme(
    primary = Color(0xFF8F4A66),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFD9E4),
    onPrimaryContainer = Color(0xFF3B0721),
    surface = Color(0xFFF6F4F8),
    background = Color(0xFFF6F4F8),
    surfaceContainer = Color(0xFFEBE8F0),
    surfaceContainerHigh = Color(0xFFE2DFE8)
)

val GlassDark = darkColorScheme(
    primary = Color(0xFFFFB0CD),
    onPrimary = Color(0xFF561D37),
    primaryContainer = Color(0xFF72334E),
    onPrimaryContainer = Color(0xFFFFD9E4),
    surface = Color(0xFF0E0D12),
    background = Color(0xFF0E0D12),
    surfaceContainer = Color(0xFF1A1820),
    surfaceContainerHigh = Color(0xFF24222C)
)

private fun TextStyle.serif(weight: FontWeight, spacing: Float): TextStyle =
    copy(fontWeight = weight, fontFamily = NewsreaderFamily, letterSpacing = spacing.sp)

private fun TextStyle.sans(weight: FontWeight, spacing: Float): TextStyle =
    copy(fontWeight = weight, fontFamily = DmSansFamily, letterSpacing = spacing.sp)

private val BaseTypography = Typography()

val EditorialTypography = BaseTypography.copy(
    displayLarge = BaseTypography.displayLarge.serif(FontWeight.Normal, -0.7f),
    displayMedium = BaseTypography.displayMedium.serif(FontWeight.Normal, -0.6f),
    displaySmall = BaseTypography.displaySmall.serif(FontWeight.Normal, -0.5f),
    headlineLarge = BaseTypography.headlineLarge.serif(FontWeight.Normal, -0.4f),
    headlineMedium = BaseTypography.headlineMedium.serif(FontWeight.Medium, -0.2f),
    headlineSmall = BaseTypography.headlineSmall.serif(FontWeight.Medium, 0f),
    titleLarge = BaseTypography.titleLarge.serif(FontWeight.Medium, 0f),
    titleMedium = BaseTypography.titleMedium.sans(FontWeight.SemiBold, 0.1f),
    titleSmall = BaseTypography.titleSmall.sans(FontWeight.SemiBold, 0.1f),
    bodyLarge = BaseTypography.bodyLarge.sans(FontWeight.Normal, 0f),
    bodyMedium = BaseTypography.bodyMedium.sans(FontWeight.Normal, 0f),
    bodySmall = BaseTypography.bodySmall.sans(FontWeight.Normal, 0f),
    labelLarge = BaseTypography.labelLarge.sans(FontWeight.SemiBold, 0.5f),
    labelMedium = BaseTypography.labelMedium.sans(FontWeight.Medium, 0.9f),
    labelSmall = BaseTypography.labelSmall.sans(FontWeight.Bold, 1.2f)
)

val GlassTypography = BaseTypography.copy(
    displayLarge = BaseTypography.displayLarge.sans(FontWeight.Bold, -1.0f),
    displayMedium = BaseTypography.displayMedium.sans(FontWeight.Bold, -0.8f),
    displaySmall = BaseTypography.displaySmall.sans(FontWeight.Bold, -0.6f),
    headlineLarge = BaseTypography.headlineLarge.sans(FontWeight.Bold, -0.5f),
    headlineMedium = BaseTypography.headlineMedium.sans(FontWeight.Bold, -0.4f),
    headlineSmall = BaseTypography.headlineSmall.sans(FontWeight.SemiBold, -0.3f),
    titleLarge = BaseTypography.titleLarge.sans(FontWeight.SemiBold, -0.2f),
    titleMedium = BaseTypography.titleMedium.sans(FontWeight.SemiBold, 0f),
    titleSmall = BaseTypography.titleSmall.sans(FontWeight.SemiBold, 0f),
    bodyLarge = BaseTypography.bodyLarge.sans(FontWeight.Normal, 0f),
    bodyMedium = BaseTypography.bodyMedium.sans(FontWeight.Normal, 0f),
    bodySmall = BaseTypography.bodySmall.sans(FontWeight.Normal, 0f),
    labelLarge = BaseTypography.labelLarge.sans(FontWeight.SemiBold, 0.2f),
    labelMedium = BaseTypography.labelMedium.sans(FontWeight.Medium, 0.4f),
    labelSmall = BaseTypography.labelSmall.sans(FontWeight.Bold, 0.8f)
)

val ColorSaver = object : Saver<Color, Int> {
    override fun restore(value: Int): Color = Color(value)
    override fun SaverScope.save(value: Color): Int = value.toArgb()
}

@Composable
fun MetrolistTheme(
    darkTheme: Boolean = false,
    pureBlack: Boolean = false,
    themeColor: Color = DefaultThemeColor,
    uiStyle: UiStyle = UiStyle.GLASS,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val isGlass = uiStyle == UiStyle.GLASS

    val baseScheme = if (themeColor == DefaultThemeColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        } else {
            when {
                isGlass && darkTheme -> GlassDark
                isGlass -> GlassLight
                darkTheme -> PaperDark
                else -> PaperLight
            }
        }
    } else {
        rememberDynamicColorScheme(
            seedColor = themeColor,
            isDark = darkTheme,
            style = PaletteStyle.Fidelity,
            specVersion = ColorSpec.SpecVersion.SPEC_2025
        )
    }

    val colorScheme = remember(baseScheme, pureBlack, darkTheme) {
        if (darkTheme && pureBlack) {
            baseScheme.copy(surface = Color.Black, background = Color.Black)
        } else {
            baseScheme
        }
    }

    CompositionLocalProvider(LocalUiStyle provides uiStyle) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = if (isGlass) GlassTypography else EditorialTypography,
            shapes = if (isGlass) GlassShapes else EditorialShapes,
            content = content
        )
    }
}

fun Bitmap.extractThemeColor(): Color {
    val scaled = Bitmap.createScaledBitmap(this, 64, 64, false)
    val palette = Palette.from(scaled).maximumColorCount(16).generate()
    val swatches = palette.swatches
    if (swatches.isEmpty()) return DefaultThemeColor

    val colorToPopulation = swatches.associate { it.rgb to it.population }
    val fallbackRgb = palette.dominantSwatch?.rgb ?: DefaultThemeColor.toArgb()
    val ranked = Score.score(colorToPopulation, 1, fallbackRgb, false)
    return Color(ranked.first())
}
