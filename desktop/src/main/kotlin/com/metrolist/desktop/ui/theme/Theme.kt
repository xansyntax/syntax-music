package com.metrolist.desktop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val GlassCardShape = RoundedCornerShape(24.dp)
val GlassOverlayShape = RoundedCornerShape(32.dp)
val GlassPillShape = RoundedCornerShape(50.dp)

val GlassShapes = Shapes(
    extraSmall = RoundedCornerShape(10.dp),
    small = RoundedCornerShape(14.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(36.dp),
)

val GlassDark = darkColorScheme(
    primary = Color(0xFFFFB0CD),
    onPrimary = Color(0xFF561D37),
    primaryContainer = Color(0xFF72334E),
    onPrimaryContainer = Color(0xFFFFD9E4),
    secondary = Color(0xFFC4B5FD),
    tertiary = Color(0xFF8BE9FD),
    surface = Color(0xFF0E0D12),
    background = Color(0xFF0E0D12),
    surfaceVariant = Color(0xFF1A1820),
    onBackground = Color(0xFFF8F4F6),
    onSurface = Color(0xFFF8F4F6),
    onSurfaceVariant = Color(0xFFB5AAB2),
)

val AppFontFamily: FontFamily = try {
    FontFamily(
        Font("fonts/dm_sans.ttf", FontWeight.Normal),
        Font("fonts/dm_sans.ttf", FontWeight.Medium),
        Font("fonts/sf_pro_display_regular.otf", FontWeight.Normal),
        Font("fonts/sf_pro_text_medium.otf", FontWeight.Medium),
        Font("fonts/sf_pro_display_bold.otf", FontWeight.SemiBold),
        Font("fonts/sf_pro_display_bold.otf", FontWeight.Bold),
    )
} catch (_: Throwable) {
    FontFamily.SansSerif
}

val GlassTypography = Typography().let { base ->
    base.copy(
        displayLarge = base.displayLarge.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, letterSpacing = (-1.0).sp),
        displayMedium = base.displayMedium.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, letterSpacing = (-0.8).sp),
        displaySmall = base.displaySmall.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, letterSpacing = (-0.6).sp),
        headlineLarge = base.headlineLarge.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp),
        headlineMedium = base.headlineMedium.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, letterSpacing = (-0.3).sp),
        headlineSmall = base.headlineSmall.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, letterSpacing = (-0.2).sp),
        titleLarge = base.titleLarge.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold),
        titleMedium = base.titleMedium.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold),
        titleSmall = base.titleSmall.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold),
        bodyLarge = base.bodyLarge.copy(fontFamily = AppFontFamily),
        bodyMedium = base.bodyMedium.copy(fontFamily = AppFontFamily),
        bodySmall = base.bodySmall.copy(fontFamily = AppFontFamily),
        labelLarge = base.labelLarge.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold),
        labelMedium = base.labelMedium.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium),
        labelSmall = base.labelSmall.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold),
    )
}
