package androidx.compose.material3;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.ControlFramesKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSchemeKt {
    public static final StaticProvidableCompositionLocal LocalTonalElevationEnabled = new StaticProvidableCompositionLocal(new ScrollKt$$ExternalSyntheticLambda0(7), (byte) 0);

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m281contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        long j2 = colorScheme.primary;
        long j3 = colorScheme.onTertiaryFixed;
        long j4 = colorScheme.onSecondaryFixed;
        long j5 = colorScheme.onPrimaryFixed;
        long j6 = colorScheme.onSurface;
        if (ULong.m1869equalsimpl0(j, j2)) {
            return colorScheme.onPrimary;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.secondary)) {
            return colorScheme.onSecondary;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.tertiary)) {
            return colorScheme.onTertiary;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.background)) {
            return colorScheme.onBackground;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.error)) {
            return colorScheme.onError;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.primaryContainer)) {
            return colorScheme.onPrimaryContainer;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.secondaryContainer)) {
            return colorScheme.onSecondaryContainer;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.tertiaryContainer)) {
            return colorScheme.onTertiaryContainer;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.errorContainer)) {
            return colorScheme.onErrorContainer;
        }
        if (ULong.m1869equalsimpl0(j, colorScheme.inverseSurface)) {
            return colorScheme.inverseOnSurface;
        }
        if (!ULong.m1869equalsimpl0(j, colorScheme.surface)) {
            if (ULong.m1869equalsimpl0(j, colorScheme.surfaceVariant)) {
                return colorScheme.onSurfaceVariant;
            }
            if (!ULong.m1869equalsimpl0(j, colorScheme.surfaceBright) && !ULong.m1869equalsimpl0(j, colorScheme.surfaceContainer) && !ULong.m1869equalsimpl0(j, colorScheme.surfaceContainerHigh) && !ULong.m1869equalsimpl0(j, colorScheme.surfaceContainerHighest) && !ULong.m1869equalsimpl0(j, colorScheme.surfaceContainerLow) && !ULong.m1869equalsimpl0(j, colorScheme.surfaceContainerLowest) && !ULong.m1869equalsimpl0(j, colorScheme.surfaceDim)) {
                if (ULong.m1869equalsimpl0(j, colorScheme.primaryFixed) || ULong.m1869equalsimpl0(j, colorScheme.primaryFixedDim)) {
                    return j5;
                }
                if (ULong.m1869equalsimpl0(j, colorScheme.secondaryFixed) || ULong.m1869equalsimpl0(j, colorScheme.secondaryFixedDim)) {
                    return j4;
                }
                return (ULong.m1869equalsimpl0(j, colorScheme.tertiaryFixed) || ULong.m1869equalsimpl0(j, colorScheme.tertiaryFixedDim)) ? j3 : ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
            }
        }
        return j6;
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m282contentColorForek8zF_U(long j, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(89374138);
        long jM281contentColorFor4WTKRHQ = m281contentColorFor4WTKRHQ(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
        if (jM281contentColorFor4WTKRHQ == 16) {
            jM281contentColorFor4WTKRHQ = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
        }
        gapComposer.end(false);
        return jM281contentColorFor4WTKRHQ;
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI$default, reason: not valid java name */
    public static ColorScheme m283darkColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, int i, int i2) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, ColorKt.Color$default(242, 184, 181), ColorKt.Color$default(96, 20, 16), ColorKt.Color$default(140, 29, 24), ColorKt.Color$default(249, 222, 220), j23, j24, (i & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0 ? ColorKt.Color$default(0, 0, 0) : j25, j26, j32, j27, j28, j29, j30, j31, (i2 & 16) != 0 ? ColorKt.Color$default(234, 221, 255) : j33, (i2 & 32) != 0 ? ColorKt.Color$default(208, 188, 255) : j34, (i2 & 64) != 0 ? ColorKt.Color$default(33, 0, 93) : j35, (i2 & 128) != 0 ? ColorKt.Color$default(79, 55, 139) : j36, (i2 & 256) != 0 ? ColorKt.Color$default(232, 222, 248) : j37, (i2 & 512) != 0 ? ColorKt.Color$default(204, 194, 220) : j38, (i2 & 1024) != 0 ? ColorKt.Color$default(29, 25, 43) : j39, (i2 & 2048) != 0 ? ColorKt.Color$default(74, 68, 88) : j40, (i2 & 4096) != 0 ? ColorKt.Color$default(255, 216, 228) : j41, (i2 & 8192) != 0 ? ColorKt.Color$default(239, 184, 200) : j42, (i2 & 16384) != 0 ? ColorKt.Color$default(49, 17, 29) : j43, (i2 & 32768) != 0 ? ColorKt.Color$default(99, 59, 72) : j44);
    }

    /* JADX INFO: renamed from: fromToken-_Htp75A, reason: not valid java name */
    public static final long m284fromToken_Htp75A(ColorScheme colorScheme, int i) {
        if (i == 0) {
            return colorScheme.background;
        }
        if (i == 1) {
            return colorScheme.error;
        }
        if (i == 2) {
            return colorScheme.errorContainer;
        }
        if (i == 3) {
            return colorScheme.inverseOnSurface;
        }
        if (i == 4) {
            return colorScheme.inversePrimary;
        }
        if (i == 5) {
            return colorScheme.inverseSurface;
        }
        if (i == 6) {
            return colorScheme.onBackground;
        }
        if (i == 7) {
            return colorScheme.onError;
        }
        if (i == 8) {
            return colorScheme.onErrorContainer;
        }
        if (i == 9) {
            return colorScheme.onPrimary;
        }
        if (i == 10) {
            return colorScheme.onPrimaryContainer;
        }
        if (i == 13) {
            return colorScheme.onSecondary;
        }
        if (i == 14) {
            return colorScheme.onSecondaryContainer;
        }
        if (i == 17) {
            return colorScheme.onSurface;
        }
        if (i == 18) {
            return colorScheme.onSurfaceVariant;
        }
        if (i == 42) {
            return colorScheme.surfaceTint;
        }
        if (i == 19) {
            return colorScheme.onTertiary;
        }
        if (i == 20) {
            return colorScheme.onTertiaryContainer;
        }
        if (i == 23) {
            return colorScheme.outline;
        }
        if (i == 24) {
            return colorScheme.outlineVariant;
        }
        if (i == 25) {
            return colorScheme.primary;
        }
        if (i == 26) {
            return colorScheme.primaryContainer;
        }
        if (i == 29) {
            return colorScheme.scrim;
        }
        if (i == 30) {
            return colorScheme.secondary;
        }
        if (i == 31) {
            return colorScheme.secondaryContainer;
        }
        if (i == 34) {
            return colorScheme.surface;
        }
        if (i == 43) {
            return colorScheme.surfaceVariant;
        }
        if (i == 35) {
            return colorScheme.surfaceBright;
        }
        if (i == 36) {
            return colorScheme.surfaceContainer;
        }
        if (i == 37) {
            return colorScheme.surfaceContainerHigh;
        }
        if (i == 38) {
            return colorScheme.surfaceContainerHighest;
        }
        if (i == 39) {
            return colorScheme.surfaceContainerLow;
        }
        if (i == 40) {
            return colorScheme.surfaceContainerLowest;
        }
        if (i == 41) {
            return colorScheme.surfaceDim;
        }
        if (i == 44) {
            return colorScheme.tertiary;
        }
        if (i == 45) {
            return colorScheme.tertiaryContainer;
        }
        if (i == 27) {
            return colorScheme.primaryFixed;
        }
        if (i == 28) {
            return colorScheme.primaryFixedDim;
        }
        if (i == 11) {
            return colorScheme.onPrimaryFixed;
        }
        if (i == 12) {
            return colorScheme.onPrimaryFixedVariant;
        }
        if (i == 32) {
            return colorScheme.secondaryFixed;
        }
        if (i == 33) {
            return colorScheme.secondaryFixedDim;
        }
        if (i == 15) {
            return colorScheme.onSecondaryFixed;
        }
        if (i == 16) {
            return colorScheme.onSecondaryFixedVariant;
        }
        if (i == 46) {
            return colorScheme.tertiaryFixed;
        }
        if (i == 47) {
            return colorScheme.tertiaryFixedDim;
        }
        if (i == 21) {
            return colorScheme.onTertiaryFixed;
        }
        return i == 22 ? colorScheme.onTertiaryFixedVariant : ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
    }

    public static final long getValue(int i, Composer composer) {
        return m284fromToken_Htp75A(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme, i);
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI$default, reason: not valid java name */
    public static ColorScheme m285lightColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, int i, int i2) {
        long j46;
        long jColor$default;
        long jColor$default2 = ColorKt.Color$default(232, 222, 248);
        long jColor$default3 = ColorKt.Color$default(33, 0, 93);
        long jColor$default4 = ColorKt.Color$default(49, 17, 29);
        long jColor$default5 = ColorKt.Color$default(29, 25, 43);
        long jColor$default6 = ColorKt.Color$default(255, 216, 228);
        long jColor$default7 = ColorKt.Color$default(208, 188, 255);
        long jColor$default8 = ColorKt.Color$default(234, 221, 255);
        long jColor$default9 = ColorKt.Color$default(254, 247, 255);
        long jColor$default10 = ColorKt.Color$default(255, 255, 255);
        long jColor$default11 = ColorKt.Color$default(29, 27, 32);
        long jColor$default12 = (i & 1) != 0 ? ColorKt.Color$default(103, 80, 164) : j;
        long j47 = (i & 2) != 0 ? jColor$default10 : j2;
        long j48 = (i & 4) != 0 ? jColor$default8 : j3;
        long j49 = (i & 8) != 0 ? jColor$default3 : j4;
        long j50 = (i & 16) != 0 ? jColor$default7 : j5;
        long jColor$default13 = (i & 32) != 0 ? ColorKt.Color$default(98, 91, 113) : j6;
        long j51 = (i & 64) != 0 ? jColor$default10 : j7;
        long j52 = (i & 128) != 0 ? jColor$default2 : j8;
        long j53 = (i & 256) != 0 ? jColor$default5 : j9;
        long jColor$default14 = (i & 512) != 0 ? ColorKt.Color$default(ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, 82, 96) : j10;
        long j54 = (i & 1024) != 0 ? jColor$default10 : j11;
        long j55 = (i & 2048) != 0 ? jColor$default6 : j12;
        long j56 = (i & 4096) != 0 ? jColor$default4 : j13;
        long j57 = (i & 8192) != 0 ? jColor$default9 : j14;
        long j58 = (i & 16384) != 0 ? jColor$default11 : j15;
        long j59 = (i & 32768) != 0 ? jColor$default9 : j16;
        if ((65536 & i) == 0) {
            jColor$default11 = j17;
        }
        long jColor$default15 = (131072 & i) != 0 ? ColorKt.Color$default(231, 224, 236) : j18;
        long jColor$default16 = (262144 & i) != 0 ? ColorKt.Color$default(73, 69, 79) : j19;
        long j60 = (524288 & i) != 0 ? jColor$default12 : j20;
        long jColor$default17 = (1048576 & i) != 0 ? ColorKt.Color$default(50, 47, 53) : j21;
        long jColor$default18 = (2097152 & i) != 0 ? ColorKt.Color$default(245, 239, 247) : j22;
        long jColor$default19 = ColorKt.Color$default(179, 38, 30);
        long jColor$default20 = ColorKt.Color$default(249, 222, 220);
        long jColor$default21 = (33554432 & i) != 0 ? ColorKt.Color$default(65, 14, 11) : j23;
        long jColor$default22 = (67108864 & i) != 0 ? ColorKt.Color$default(121, 116, 126) : j24;
        long jColor$default23 = (134217728 & i) != 0 ? ColorKt.Color$default(202, 196, 208) : j25;
        long jColor$default24 = (268435456 & i) != 0 ? ColorKt.Color$default(0, 0, 0) : j26;
        long j61 = (536870912 & i) != 0 ? jColor$default9 : j27;
        long jColor$default25 = (1073741824 & i) != 0 ? ColorKt.Color$default(243, 237, 247) : j28;
        long jColor$default26 = (i & Integer.MIN_VALUE) != 0 ? ColorKt.Color$default(236, 230, 240) : j29;
        long jColor$default27 = (i2 & 1) != 0 ? ColorKt.Color$default(230, 224, 233) : j30;
        long jColor$default28 = (i2 & 2) != 0 ? ColorKt.Color$default(247, 242, 250) : j31;
        long j62 = (i2 & 4) != 0 ? jColor$default10 : j32;
        long jColor$default29 = (i2 & 8) != 0 ? ColorKt.Color$default(222, 216, 225) : j33;
        long j63 = (i2 & 16) != 0 ? jColor$default8 : j34;
        long j64 = (i2 & 32) != 0 ? jColor$default7 : j35;
        long j65 = (i2 & 64) != 0 ? jColor$default3 : j36;
        long jColor$default30 = (i2 & 128) != 0 ? ColorKt.Color$default(79, 55, 139) : j37;
        long j66 = (i2 & 256) != 0 ? jColor$default2 : j38;
        long jColor$default31 = (i2 & 512) != 0 ? ColorKt.Color$default(204, 194, 220) : j39;
        long j67 = (i2 & 1024) != 0 ? jColor$default5 : j40;
        long jColor$default32 = (i2 & 2048) != 0 ? ColorKt.Color$default(74, 68, 88) : j41;
        long j68 = (i2 & 4096) != 0 ? jColor$default6 : j42;
        long jColor$default33 = (i2 & 8192) != 0 ? ColorKt.Color$default(239, 184, 200) : j43;
        long j69 = (i2 & 16384) != 0 ? jColor$default4 : j44;
        if ((i2 & 32768) != 0) {
            j46 = j59;
            jColor$default = ColorKt.Color$default(99, 59, 72);
        } else {
            j46 = j59;
            jColor$default = j45;
        }
        return new ColorScheme(jColor$default12, j47, j48, j49, j50, jColor$default13, j51, j52, j53, jColor$default14, j54, j55, j56, j57, j58, j46, jColor$default11, jColor$default15, jColor$default16, j60, jColor$default17, jColor$default18, jColor$default19, jColor$default10, jColor$default20, jColor$default21, jColor$default22, jColor$default23, jColor$default24, j61, jColor$default29, jColor$default25, jColor$default26, jColor$default27, jColor$default28, j62, j63, j64, j65, jColor$default30, j66, jColor$default31, j67, jColor$default32, j68, jColor$default33, j69, jColor$default);
    }
}
