package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FilterChipDefaults {
    public static final PaddingValuesImpl ContentPadding = OffsetKt.m127PaddingValuesYgX7TsA$default(2, 8.0f);

    /* JADX INFO: renamed from: filterChipBorder-_7El2pE, reason: not valid java name */
    public static BorderStroke m287filterChipBorder_7El2pE(boolean z, Composer composer, int i) {
        long value = ColorSchemeKt.getValue(24, composer);
        long value2 = ColorSchemeKt.getValue(17, composer);
        ColorKt.Color(Color.m485getRedimpl(value2), Color.m484getGreenimpl(value2), Color.m482getBlueimpl(value2), 0.12f, Color.m483getColorSpaceimpl(value2));
        int i2 = i & 64;
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        float f2 = i2 != 0 ? 1.0f : 0.0f;
        if (z) {
            value = 0;
        }
        if (!z) {
            f = f2;
        }
        return ImageKt.m38BorderStrokecXLIe8U(value, f);
    }

    /* JADX INFO: renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public static SelectableChipColors m288filterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, Composer composer, int i) {
        long jColor = (i & 2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j2;
        Rgb rgb = ColorSpaces.Unspecified;
        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor3 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor4 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor5 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor6 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor7 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor8 = (i & 1024) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j5;
        long jColor9 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        SelectableChipColors defaultFilterChipColors$material3 = getDefaultFilterChipColors$material3(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
        long j6 = j != 16 ? j : defaultFilterChipColors$material3.containerColor;
        if (jColor == r1) {
            jColor = defaultFilterChipColors$material3.labelColor;
        }
        long j7 = jColor;
        long j8 = jColor2 != r1 ? jColor2 : defaultFilterChipColors$material3.leadingIconColor;
        if (jColor2 == r1) {
            jColor2 = defaultFilterChipColors$material3.trailingIconColor;
        }
        long j9 = jColor2;
        if (jColor3 == r1) {
            jColor3 = defaultFilterChipColors$material3.disabledContainerColor;
        }
        long j10 = jColor3;
        if (jColor4 == r1) {
            jColor4 = defaultFilterChipColors$material3.disabledLabelColor;
        }
        long j11 = jColor4;
        if (jColor5 == r1) {
            jColor5 = defaultFilterChipColors$material3.disabledLeadingIconColor;
        }
        long j12 = jColor5;
        if (jColor6 == r1) {
            jColor6 = defaultFilterChipColors$material3.disabledTrailingIconColor;
        }
        return new SelectableChipColors(j6, j7, j8, j9, j10, j11, j12, jColor6, j3 != r1 ? j3 : defaultFilterChipColors$material3.selectedContainerColor, jColor7 != r1 ? jColor7 : defaultFilterChipColors$material3.disabledSelectedContainerColor, j4 != r1 ? j4 : defaultFilterChipColors$material3.selectedLabelColor, jColor8 != r1 ? jColor8 : defaultFilterChipColors$material3.selectedLeadingIconColor, jColor9 != 16 ? jColor9 : defaultFilterChipColors$material3.selectedTrailingIconColor);
    }

    public static SelectableChipColors getDefaultFilterChipColors$material3(ColorScheme colorScheme) {
        SelectableChipColors selectableChipColors = colorScheme.defaultFilterChipColorsCached;
        if (selectableChipColors != null) {
            return selectableChipColors;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4));
        long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor2 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A5), Color.m484getGreenimpl(jM284fromToken_Htp75A5), Color.m482getBlueimpl(jM284fromToken_Htp75A5), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A5));
        long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A6), Color.m484getGreenimpl(jM284fromToken_Htp75A6), Color.m482getBlueimpl(jM284fromToken_Htp75A6), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A6));
        long jM284fromToken_Htp75A7 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
        long jM284fromToken_Htp75A8 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        SelectableChipColors selectableChipColors2 = new SelectableChipColors(0L, jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jM284fromToken_Htp75A3, 0L, jColor, jColor2, jColor3, jM284fromToken_Htp75A7, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A8), Color.m484getGreenimpl(jM284fromToken_Htp75A8), Color.m482getBlueimpl(jM284fromToken_Htp75A8), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A8)), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14));
        colorScheme.defaultFilterChipColorsCached = selectableChipColors2;
        return selectableChipColors2;
    }
}
