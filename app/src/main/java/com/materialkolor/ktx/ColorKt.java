package com.materialkolor.ktx;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.github.ajalt.colormath.model.HSL;
import com.github.ajalt.colormath.model.LABColorSpaces;
import com.github.ajalt.colormath.model.RGB;
import com.github.ajalt.colormath.model.RGBColorSpaces;
import com.github.ajalt.colormath.model.SRGB;
import com.github.ajalt.colormath.model.XYZColorSpaces;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.utils.MathUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0007b\u0002\b\t¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\n\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007b\u0002\b\t¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007b\u0002\b\t¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\u0006*\u00020\u0002H\u0007b\u0002\b\t¢\u0006\u0004\b\u0012\u0010\b\u001a\u0017\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007b\u0002\b\t¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001c\u001aO\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e*\u00020\u00022\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00172\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0007b\u0002\b'¢\u0006\u0004\b%\u0010&\u001a\f\u0010(\u001a\u00020\u0017*\u00020)H\u0000\u001a\u001f\u0010*\u001a\u00020\u0002*\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0001b\u0002\b\t¢\u0006\u0004\b,\u0010-\u001a\u0017\u0010.\u001a\u00020/*\u00020\u0002H\u0001b\u0002\b\t¢\u0006\u0004\b0\u00101\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u00062"}, d2 = {"defaultColorSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/graphics/Color;", "getDefaultColorSpring", "()Landroidx/compose/animation/core/SpringSpec;", "isLight", "", "isLight-8_81llA", "(J)Z", "Landroidx/compose/runtime/Stable;", "lighten", "ratio", "", "lighten-DxMtmZc", "(JF)J", "darken", "darken-DxMtmZc", "isDisliked", "isDisliked-8_81llA", "fixIfDisliked", "fixIfDisliked-8_81llA", "(J)J", "toHex", "", "includePrefix", "prefix", "alwaysIncludeAlpha", "toHex-Iv8Zu3U", "(JZLjava/lang/String;Z)Ljava/lang/String;", "animate", "Landroidx/compose/runtime/State;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "label", "finishedListener", "Lkotlin/Function1;", "", "animate-euL9pac", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/Composable;", "format", "", "matchSaturation", "other", "matchSaturation--OWjLjI", "(JJ)J", "toTonalPalette", "Lcom/materialkolor/palettes/TonalPalette;", "toTonalPalette-8_81llA", "(J)Lcom/materialkolor/palettes/TonalPalette;", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ColorKt {
    public static final SpringSpec defaultColorSpring = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);

    /* JADX INFO: renamed from: animate-euL9pac, reason: not valid java name */
    public static final State m942animateeuL9pac(long j, AnimationSpec animationSpec, String str, Function1 function1, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            animationSpec = defaultColorSpring;
        }
        return SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j, animationSpec, null, composer, i & 126, 12);
    }

    /* JADX INFO: renamed from: darken-DxMtmZc, reason: not valid java name */
    public static final long m943darkenDxMtmZc(long j, float f) {
        Hct hctM973toHct8_81llA = HctKt.m973toHct8_81llA(j);
        double dDarker = HexFormatKt.darker(hctM973toHct8_81llA.tone, f);
        Double dValueOf = Double.valueOf(dDarker);
        if (dDarker <= -1.0d) {
            dValueOf = null;
        }
        if (dValueOf == null) {
            return j;
        }
        return HctKt.toColor(new Hct(HctSolver.solveToInt(hctM973toHct8_81llA.hue, hctM973toHct8_81llA.chroma, dValueOf.doubleValue())));
    }

    /* JADX INFO: renamed from: darken-DxMtmZc$default, reason: not valid java name */
    public static /* synthetic */ long m944darkenDxMtmZc$default(long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.1f;
        }
        return m943darkenDxMtmZc(j, f);
    }

    /* JADX INFO: renamed from: fixIfDisliked-8_81llA, reason: not valid java name */
    public static final long m945fixIfDisliked8_81llA(long j) {
        return HctKt.toColor(RegexKt.fixIfDisliked(HctKt.m973toHct8_81llA(j)));
    }

    public static final String format(int i) {
        CharsKt.checkRadix(16);
        String string = Integer.toString(i, 16);
        string.getClass();
        return StringsKt.padStart(2, string);
    }

    public static final SpringSpec getDefaultColorSpring() {
        return defaultColorSpring;
    }

    /* JADX INFO: renamed from: isDisliked-8_81llA, reason: not valid java name */
    public static final boolean m946isDisliked8_81llA(long j) {
        Hct hctM973toHct8_81llA = HctKt.m973toHct8_81llA(j);
        hctM973toHct8_81llA.getClass();
        double dRint = Math.rint(hctM973toHct8_81llA.hue);
        return ((90.0d > dRint ? 1 : (90.0d == dRint ? 0 : -1)) <= 0 && (dRint > 111.0d ? 1 : (dRint == 111.0d ? 0 : -1)) <= 0) && ((Math.rint(hctM973toHct8_81llA.chroma) > 16.0d ? 1 : (Math.rint(hctM973toHct8_81llA.chroma) == 16.0d ? 0 : -1)) > 0) && ((Math.rint(hctM973toHct8_81llA.tone) > 65.0d ? 1 : (Math.rint(hctM973toHct8_81llA.tone) == 65.0d ? 0 : -1)) < 0);
    }

    /* JADX INFO: renamed from: isLight-8_81llA, reason: not valid java name */
    public static final boolean m947isLight8_81llA(long j) {
        return !ULong.m1869equalsimpl0(j, 0L) && MathUtils.xyzFromArgb(androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j))[1] / 100.0d > 0.5d;
    }

    /* JADX INFO: renamed from: lighten-DxMtmZc, reason: not valid java name */
    public static final long m948lightenDxMtmZc(long j, float f) {
        Hct hctM973toHct8_81llA = HctKt.m973toHct8_81llA(j);
        double dLighter = HexFormatKt.lighter(hctM973toHct8_81llA.tone, f);
        Double dValueOf = Double.valueOf(dLighter);
        if (dLighter <= -1.0d) {
            dValueOf = null;
        }
        if (dValueOf == null) {
            return j;
        }
        return HctKt.toColor(new Hct(HctSolver.solveToInt(hctM973toHct8_81llA.hue, hctM973toHct8_81llA.chroma, dValueOf.doubleValue())));
    }

    /* JADX INFO: renamed from: lighten-DxMtmZc$default, reason: not valid java name */
    public static /* synthetic */ long m949lightenDxMtmZc$default(long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return m948lightenDxMtmZc(j, f);
    }

    /* JADX INFO: renamed from: matchSaturation--OWjLjI, reason: not valid java name */
    public static final long m950matchSaturationOWjLjI(long j, long j2) {
        ColorSpace colorSpace;
        HSL hsl = StringsKt__IndentKt.m1882toColormathColor8_81llA(j).toHSL();
        HSL hsl2 = StringsKt__IndentKt.m1882toColormathColor8_81llA(j2).toHSL();
        float f = hsl.h;
        float f2 = hsl2.s;
        float f3 = hsl2.l;
        HSL hsl3 = new HSL(f, f2, f3, 1.0f);
        HSL.Companion companion = HSL.Companion;
        if (companion == SRGB.INSTANCE) {
            colorSpace = ColorSpaces.Srgb;
        } else if (companion == RGBColorSpaces.ACES) {
            colorSpace = ColorSpaces.Aces;
        } else if (companion == RGBColorSpaces.ACEScg) {
            colorSpace = ColorSpaces.Acescg;
        } else if (companion == RGBColorSpaces.AdobeRGB) {
            colorSpace = ColorSpaces.AdobeRgb;
        } else if (companion == RGBColorSpaces.BT2020) {
            colorSpace = ColorSpaces.Bt2020;
        } else if (companion == RGBColorSpaces.BT709) {
            colorSpace = ColorSpaces.Bt709;
        } else if (companion == LABColorSpaces.LAB50) {
            colorSpace = ColorSpaces.CieLab;
        } else if (companion == XYZColorSpaces.XYZ50) {
            colorSpace = ColorSpaces.CieXyz;
        } else if (companion == RGBColorSpaces.DCI_P3) {
            colorSpace = ColorSpaces.DciP3;
        } else if (companion == RGBColorSpaces.DisplayP3) {
            colorSpace = ColorSpaces.DisplayP3;
        } else if (companion == RGBColorSpaces.LinearSRGB) {
            colorSpace = ColorSpaces.LinearSrgb;
        } else {
            colorSpace = companion == RGBColorSpaces.ROMM_RGB ? ColorSpaces.ProPhotoRgb : null;
        }
        if (colorSpace == null) {
            RGB srgb = hsl3.toSRGB();
            return androidx.compose.ui.graphics.ColorKt.Color(srgb.r, srgb.g, srgb.b, srgb.alpha, ColorSpaces.Srgb);
        }
        float[] fArr = {f, f2, f3, 1.0f};
        return androidx.compose.ui.graphics.ColorKt.Color(fArr[0], fArr[1], fArr[2], fArr[3], colorSpace);
    }

    /* JADX INFO: renamed from: toHex-Iv8Zu3U, reason: not valid java name */
    public static final String m951toHexIv8Zu3U(long j, boolean z, String str, boolean z2) {
        str.getClass();
        int iRoundToInt = MathKt.roundToInt(Color.m481getAlphaimpl(j) * 255.0f);
        int iRoundToInt2 = MathKt.roundToInt(Color.m485getRedimpl(j) * 255.0f);
        int iRoundToInt3 = MathKt.roundToInt(Color.m484getGreenimpl(j) * 255.0f);
        int iRoundToInt4 = MathKt.roundToInt(Color.m482getBlueimpl(j) * 255.0f);
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(str);
        }
        if (z2 || iRoundToInt < 255) {
            sb.append(format(iRoundToInt));
        }
        sb.append(format(iRoundToInt2));
        sb.append(format(iRoundToInt3));
        sb.append(format(iRoundToInt4));
        String upperCase = sb.toString().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return upperCase;
    }

    /* JADX INFO: renamed from: toHex-Iv8Zu3U$default, reason: not valid java name */
    public static /* synthetic */ String m952toHexIv8Zu3U$default(long j, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = "#";
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return m951toHexIv8Zu3U(j, z, str, z2);
    }

    /* JADX INFO: renamed from: toTonalPalette-8_81llA, reason: not valid java name */
    public static final TonalPalette m953toTonalPalette8_81llA(long j) {
        return TonalPaletteKt.m984from4WTKRHQ(TonalPalette.Companion, j);
    }
}
