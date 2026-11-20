package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonDefaults {
    public static final PaddingValuesImpl ContentPadding = new PaddingValuesImpl(24.0f, 8.0f, 24.0f, 8.0f);
    public static final float ExtraLargeContainerHeight;
    public static final float ExtraLargeIconSize;
    public static final float ExtraLargeIconSpacing;
    public static final float ExtraSmallIconSize;
    public static final float ExtraSmallIconSpacing;
    public static final float IconSpacing;
    public static final float LargeContainerHeight;
    public static final float LargeIconSize;
    public static final float LargeIconSpacing;
    public static final float LargeLeadingPadding;
    public static final float LargeTrailingPadding;
    public static final float LargeVerticalPadding;
    public static final float MediumContainerHeight;
    public static final float MediumIconSize;
    public static final float MediumIconSpacing;
    public static final float MediumLeadingPadding;
    public static final float MediumTrailingPadding;
    public static final float MediumVerticalPadding;
    public static final float MinWidth;
    public static final float SmallIconSize;
    public static final PaddingValuesImpl TextButtonContentPadding;

    static {
        if (!((16.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (8.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (24.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (8.0f >= CropImageView.DEFAULT_ASPECT_RATIO))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        TextButtonContentPadding = new PaddingValuesImpl(12.0f, 8.0f, 12.0f, 8.0f);
        if (!((12.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (8.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (16.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (8.0f >= CropImageView.DEFAULT_ASPECT_RATIO))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        MinWidth = 58.0f;
        MediumContainerHeight = 56.0f;
        LargeContainerHeight = 96.0f;
        ExtraLargeContainerHeight = 136.0f;
        ExtraSmallIconSize = 20.0f;
        SmallIconSize = 20.0f;
        MediumIconSize = 24.0f;
        LargeIconSize = 32.0f;
        ExtraLargeIconSize = 40.0f;
        IconSpacing = 8.0f;
        ExtraSmallIconSpacing = 4.0f;
        MediumIconSpacing = 8.0f;
        LargeIconSpacing = 12.0f;
        ExtraLargeIconSpacing = 16.0f;
        MediumLeadingPadding = 24.0f;
        MediumTrailingPadding = 24.0f;
        MediumVerticalPadding = 16.0f;
        LargeVerticalPadding = 32.0f;
        LargeLeadingPadding = 48.0f;
        LargeTrailingPadding = 48.0f;
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public static ButtonColors m247buttonColorsro_MJ88(long j, long j2, long j3, Composer composer, int i) {
        return getDefaultButtonColors$material3(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme).m246copyjRlVdoo(j, (i & 2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j2, (i & 4) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : 0L, (i & 8) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j3);
    }

    /* JADX INFO: renamed from: contentPaddingFor-8Feqmps$default, reason: not valid java name */
    public static PaddingValuesImpl m248contentPaddingFor8Feqmps$default(float f) {
        if (Dp.m795compareTo0680j_4(f, m250getMinHeightD9Ej5fM()) < 0) {
            return new PaddingValuesImpl(12.0f, 6.0f, 12.0f, 6.0f);
        }
        if (Dp.m795compareTo0680j_4(f, MediumContainerHeight) < 0) {
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
            return new PaddingValuesImpl(16.0f, ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 8.0f : 10.0f, 16.0f, ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 8.0f : 10.0f);
        }
        if (Dp.m795compareTo0680j_4(f, LargeContainerHeight) < 0) {
            float f2 = MediumLeadingPadding;
            float f3 = MediumVerticalPadding;
            return new PaddingValuesImpl(f2, f3, MediumTrailingPadding, f3);
        }
        if (Dp.m795compareTo0680j_4(f, ExtraLargeContainerHeight) >= 0) {
            return new PaddingValuesImpl(64.0f, 48.0f, 64.0f, 48.0f);
        }
        float f4 = LargeLeadingPadding;
        float f5 = LargeVerticalPadding;
        return new PaddingValuesImpl(f4, f5, LargeTrailingPadding, f5);
    }

    /* JADX INFO: renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public static ButtonColors m249filledTonalButtonColorsro_MJ88(long j, long j2, GapComposer gapComposer) {
        Rgb rgb = ColorSpaces.Unspecified;
        return getDefaultFilledTonalButtonColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme).m246copyjRlVdoo(j, j2, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb));
    }

    public static ButtonColors getDefaultButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors buttonColors = colorScheme.defaultButtonColorsCached;
        if (buttonColors != null) {
            return buttonColors;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 9);
        long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.1f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
        long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        ButtonColors buttonColors2 = new ButtonColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4)));
        colorScheme.defaultButtonColorsCached = buttonColors2;
        return buttonColors2;
    }

    public static ButtonColors getDefaultFilledTonalButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors buttonColors = colorScheme.defaultFilledTonalButtonColorsCached;
        if (buttonColors != null) {
            return buttonColors;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
        long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
        long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        ButtonColors buttonColors2 = new ButtonColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4)));
        colorScheme.defaultFilledTonalButtonColorsCached = buttonColors2;
        return buttonColors2;
    }

    public static ButtonColors getDefaultOutlinedButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors buttonColors = colorScheme.defaultOutlinedButtonColorsCached;
        if (buttonColors != null) {
            return buttonColors;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        ButtonColors buttonColors2 = new ButtonColors(0L, jM284fromToken_Htp75A, 0L, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A2), Color.m484getGreenimpl(jM284fromToken_Htp75A2), Color.m482getBlueimpl(jM284fromToken_Htp75A2), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A2)));
        colorScheme.defaultOutlinedButtonColorsCached = buttonColors2;
        return buttonColors2;
    }

    public static ButtonColors getDefaultTextButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors buttonColors = colorScheme.defaultTextButtonColorsCached;
        if (buttonColors != null) {
            return buttonColors;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        ButtonColors buttonColors2 = new ButtonColors(0L, jM284fromToken_Htp75A, 0L, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A2), Color.m484getGreenimpl(jM284fromToken_Htp75A2), Color.m482getBlueimpl(jM284fromToken_Htp75A2), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A2)));
        colorScheme.defaultTextButtonColorsCached = buttonColors2;
        return buttonColors2;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public static float m250getMinHeightD9Ej5fM() {
        return ((Boolean) PrecisionPointer.shouldUsePrecisionPointerComponentSizing.getValue()).booleanValue() ? 36.0f : 40.0f;
    }

    public static ButtonShapes shapes(GapComposer gapComposer) {
        Shapes shapes = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes;
        ButtonShapes buttonShapes = shapes.defaultButtonShapesCached;
        if (buttonShapes != null) {
            return buttonShapes;
        }
        ButtonShapes buttonShapes2 = new ButtonShapes(ShapesKt.m325fromTokenCLvlw10(shapes, 6), ShapesKt.m325fromTokenCLvlw10(shapes, 14));
        shapes.defaultButtonShapesCached = buttonShapes2;
        return buttonShapes2;
    }
}
