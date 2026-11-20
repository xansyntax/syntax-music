package androidx.compose.material3;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.Collections;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderDefaults {
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final AndroidPath trackPath = AndroidPath_androidKt.Path();

    public static SliderColors colors(Composer composer) {
        return getDefaultSliderColors$material3(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public static SliderColors m328colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i) {
        long jColor = (i & 16) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j5;
        long jColor2 = (i & 32) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j6;
        long jColor3 = (i & 64) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j7;
        Rgb rgb = ColorSpaces.Unspecified;
        long jColor4 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor5 = (i & 256) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j8;
        long jColor6 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        SliderColors defaultSliderColors$material3 = getDefaultSliderColors$material3(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
        long j9 = j != 16 ? j : defaultSliderColors$material3.thumbColor;
        long j10 = j2 != r13 ? j2 : defaultSliderColors$material3.activeTrackColor;
        long j11 = j3 != r13 ? j3 : defaultSliderColors$material3.activeTickColor;
        long j12 = j4 != r13 ? j4 : defaultSliderColors$material3.inactiveTrackColor;
        if (jColor == r13) {
            jColor = defaultSliderColors$material3.inactiveTickColor;
        }
        long j13 = jColor;
        if (jColor2 == r13) {
            jColor2 = defaultSliderColors$material3.disabledThumbColor;
        }
        long j14 = jColor2;
        if (jColor3 == r13) {
            jColor3 = defaultSliderColors$material3.disabledActiveTrackColor;
        }
        long j15 = jColor3;
        if (jColor4 == r13) {
            jColor4 = defaultSliderColors$material3.disabledActiveTickColor;
        }
        long j16 = jColor4;
        if (jColor5 == r13) {
            jColor5 = defaultSliderColors$material3.disabledInactiveTrackColor;
        }
        long j17 = jColor5;
        if (jColor6 == 16) {
            jColor6 = defaultSliderColors$material3.disabledInactiveTickColor;
        }
        return new SliderColors(j9, j10, j11, j12, j13, j14, j15, j16, j17, jColor6);
    }

    /* JADX INFO: renamed from: drawStopIndicator-x3O1jOs, reason: not valid java name */
    public static void m329drawStopIndicatorx3O1jOs(DrawScope drawScope, long j, long j2) {
        DrawScope.m543drawCircleVaOC9Bg$default(drawScope, j2, drawScope.mo81toPx0680j_4(4.0f) / 2.0f, j, null, 0, 120);
    }

    /* JADX INFO: renamed from: drawTrackPath-zXTsYAs, reason: not valid java name */
    public static void m330drawTrackPathzXTsYAs(DrawScope drawScope, Orientation orientation, long j, long j2, long j3, float f, float f2) {
        RoundRect roundRect;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
        if (orientation == Orientation.Vertical) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(j, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
            roundRect = new RoundRect(rectM896Recttz77jQw.left, rectM896Recttz77jQw.top, rectM896Recttz77jQw.right, rectM896Recttz77jQw.bottom, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits2);
        } else {
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
            Rect rectM896Recttz77jQw2 = IntMath.m896Recttz77jQw(j, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32));
            roundRect = new RoundRect(rectM896Recttz77jQw2.left, rectM896Recttz77jQw2.top, rectM896Recttz77jQw2.right, rectM896Recttz77jQw2.bottom, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits2, jFloatToRawIntBits);
        }
        AndroidPath androidPath = trackPath;
        AndroidPath.addRoundRect$default(androidPath, roundRect);
        DrawScope.m548drawPathLG529CI$default(drawScope, androidPath, j3, CropImageView.DEFAULT_ASPECT_RATIO, null, 60);
        androidPath.rewind();
    }

    public static SliderColors getDefaultSliderColors$material3(ColorScheme colorScheme) {
        SliderColors sliderColors = colorScheme.defaultSliderColorsCached;
        if (sliderColors != null) {
            return sliderColors;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
        long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
        long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM489compositeOverOWjLjI = ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A6), Color.m484getGreenimpl(jM284fromToken_Htp75A6), Color.m482getBlueimpl(jM284fromToken_Htp75A6), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A6)), colorScheme.surface);
        long jM284fromToken_Htp75A7 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A7), Color.m484getGreenimpl(jM284fromToken_Htp75A7), Color.m482getBlueimpl(jM284fromToken_Htp75A7), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A7));
        long jM284fromToken_Htp75A8 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor2 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A8), Color.m484getGreenimpl(jM284fromToken_Htp75A8), Color.m482getBlueimpl(jM284fromToken_Htp75A8), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A8));
        long jM284fromToken_Htp75A9 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A9), Color.m484getGreenimpl(jM284fromToken_Htp75A9), Color.m482getBlueimpl(jM284fromToken_Htp75A9), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A9));
        long jM284fromToken_Htp75A10 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        SliderColors sliderColors2 = new SliderColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jM284fromToken_Htp75A3, jM284fromToken_Htp75A4, jM284fromToken_Htp75A5, jM489compositeOverOWjLjI, jColor, jColor2, jColor3, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A10), Color.m484getGreenimpl(jM284fromToken_Htp75A10), Color.m482getBlueimpl(jM284fromToken_Htp75A10), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A10)));
        colorScheme.defaultSliderColorsCached = sliderColors2;
        return sliderColors2;
    }

    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m331Thumb9LiSoMs(final MutableInteractionSourceImpl mutableInteractionSourceImpl, Modifier modifier, final SliderColors sliderColors, final boolean z, long j, Composer composer, final int i) {
        final Modifier modifier2;
        final long j2;
        int i2;
        Modifier modifier3;
        long j3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-290277409);
        int i3 = i | (gapComposer.changed(mutableInteractionSourceImpl) ? 4 : 2) | 48 | (gapComposer.changed(sliderColors) ? 256 : 128) | (gapComposer.changed(z) ? 2048 : 1024) | 8192;
        if (gapComposer.shouldExecute(i3 & 1, (74899 & i3) != 74898)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                VerticalAlignmentLine verticalAlignmentLine = SliderKt.CornerSizeAlignmentLine;
                long jM890DpSizeYgX7TsA = UtilsKt.m890DpSizeYgX7TsA(4.0f, 44.0f);
                i2 = i3 & (-57345);
                modifier3 = Modifier.Companion.$$INSTANCE;
                j3 = jM890DpSizeYgX7TsA;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-57345);
                modifier3 = modifier;
                j3 = j;
            }
            gapComposer.endDefaults();
            int i4 = i2 & 14;
            int i5 = i2 << 3;
            m332ThumbHwbPF3A(mutableInteractionSourceImpl, modifier3, sliderColors, z, j3, gapComposer, (i5 & 57344) | i4 | 432 | (i5 & 7168) | 1572864);
            modifier2 = modifier3;
            j2 = j3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(mutableInteractionSourceImpl, modifier2, sliderColors, z, j2, i) { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda2
                public final /* synthetic */ MutableInteractionSourceImpl f$1;
                public final /* synthetic */ Modifier f$2;
                public final /* synthetic */ SliderColors f$3;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ long f$5;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(196609);
                    this.f$0.m331Thumb9LiSoMs(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: Thumb-HwbPF3A, reason: not valid java name */
    public final void m332ThumbHwbPF3A(MutableInteractionSourceImpl mutableInteractionSourceImpl, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-949601789);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(mutableInteractionSourceImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(false) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(sliderColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed(this) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            int i3 = i2 >> 3;
            SliderKt.m336ThumbContent9LiSoMs(mutableInteractionSourceImpl, modifier, sliderColors, z, j, gapComposer, (i2 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (i3 & 57344) | ((i2 << 12) & 458752));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderDefaults$$ExternalSyntheticLambda3(this, mutableInteractionSourceImpl, modifier, sliderColors, z, j, i);
        }
    }

    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    public final void m333Track4EFweAY(final SliderState sliderState, Modifier modifier, final boolean z, final SliderColors sliderColors, Function2 function2, Function3 function3, float f, float f2, Composer composer, final int i) {
        int i2;
        SliderDefaults sliderDefaults;
        final Modifier modifier2;
        final Function2 function4;
        final Function3 function5;
        final float f3;
        final float f4;
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(49984771);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i4 = i2 | 48;
        if ((i & 384) == 0) {
            i4 |= gapComposer.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= gapComposer.changed(sliderColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= 8192;
        }
        int i5 = 196608 | i4;
        if ((1572864 & i) == 0) {
            i5 = 720896 | i4;
        }
        if ((12582912 & i) == 0) {
            i5 |= 4194304;
        }
        if ((100663296 & i) == 0) {
            SliderDefaults sliderDefaults2 = this;
            i5 |= gapComposer.changed(sliderDefaults2) ? 67108864 : 33554432;
            sliderDefaults = sliderDefaults2;
        } else {
            sliderDefaults = this;
        }
        if (gapComposer.shouldExecute(i5 & 1, (38347923 & i5) != 38347922)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                boolean z2 = ((((i5 & 7168) ^ 3072) > 2048 && gapComposer.changed(sliderColors)) || (i5 & 3072) == 2048) | ((i5 & 896) == 256);
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (z2 || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new StringsKt__StringsKt$$ExternalSyntheticLambda1((Object) sliderColors, z, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function2 function6 = (Function2) objRememberedValue;
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = SliderDefaults$Track$4$1.INSTANCE;
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Function3 function7 = (Function3) objRememberedValue2;
                VerticalAlignmentLine verticalAlignmentLine = SliderKt.CornerSizeAlignmentLine;
                i3 = i5 & (-33087489);
                f3 = 6.0f;
                f4 = 2.0f;
                function4 = function6;
                modifier2 = Modifier.Companion.$$INSTANCE;
                function5 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i5 & (-33087489);
                modifier2 = modifier;
                function4 = function2;
                function5 = function3;
                f3 = f;
                f4 = f2;
            }
            gapComposer.endDefaults();
            int i6 = i3 << 3;
            sliderDefaults.m335TrackImplVvwgllI(sliderState, Float.NaN, modifier2, z, sliderColors, function4, function5, f3, f4, false, gapComposer, (i6 & 3670016) | 805306416 | (i3 & 14) | (i6 & 896) | (i6 & 7168) | (57344 & i6), ((i3 >> 21) & 112) | 6);
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            function4 = function2;
            function5 = function3;
            f3 = f;
            f4 = f2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    this.f$0.m333Track4EFweAY(sliderState, modifier2, z, sliderColors, function4, function5, f3, f4, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: Track-mnvyFg4, reason: not valid java name */
    public final void m334TrackmnvyFg4(SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, Function2 function2, Function3 function3, float f, Composer composer, int i) {
        int i2;
        GapComposer gapComposer;
        Function3 function4;
        float f2;
        int i3;
        Function3 function5;
        float f3;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1691224881);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changed(12.0f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function2) ? 131072 : 65536;
        }
        int i4 = i2 | 1572864;
        if ((12582912 & i) == 0) {
            i4 |= gapComposer2.changed(6.0f) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= 33554432;
        }
        if ((i & 805306368) == 0) {
            i4 |= gapComposer2.changed(this) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if (gapComposer2.shouldExecute(i4 & 1, (306783379 & i4) != 306783378)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = SliderDefaults$Track$4$1.INSTANCE$1;
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                VerticalAlignmentLine verticalAlignmentLine = SliderKt.CornerSizeAlignmentLine;
                i3 = i4 & (-234881025);
                function5 = (Function3) objRememberedValue;
                f3 = 2.0f;
            } else {
                gapComposer2.skipToGroupEnd();
                i3 = i4 & (-234881025);
                function5 = function3;
                f3 = f;
            }
            gapComposer2.endDefaults();
            gapComposer = gapComposer2;
            m335TrackImplVvwgllI(sliderState, 12.0f, modifier, z, sliderColors, function2, function5, 6.0f, f3, true, gapComposer, 805306368 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3), ((i3 >> 24) & 112) | 6);
            function4 = function5;
            f2 = f3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            function4 = function3;
            f2 = f;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderDefaults$$ExternalSyntheticLambda8(this, sliderState, modifier, z, sliderColors, function2, function4, f2, i);
        }
    }

    /* JADX INFO: renamed from: TrackImpl-VvwgllI, reason: not valid java name */
    public final void m335TrackImplVvwgllI(final SliderState sliderState, final float f, final Modifier modifier, final boolean z, final SliderColors sliderColors, final Function2 function2, final Function3 function3, final float f2, final float f3, final boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        float f4;
        int i4;
        GapComposer gapComposer;
        Modifier modifierM145height3ABfNKs;
        Object obj;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(133396521);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= gapComposer2.changedInstance(function3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            f4 = f2;
            i3 |= gapComposer2.changed(f4) ? 8388608 : 4194304;
        } else {
            f4 = f2;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer2.changed(f3) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer2.changed(z2) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer2.changed(false) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (gapComposer2.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true)) {
            final long jM327trackColorWaAFU9c$material3 = sliderColors.m327trackColorWaAFU9c$material3(z, false);
            final long jM327trackColorWaAFU9c$material4 = sliderColors.m327trackColorWaAFU9c$material3(z, true);
            long j = z ? sliderColors.inactiveTickColor : sliderColors.disabledInactiveTickColor;
            long j2 = z ? sliderColors.activeTickColor : sliderColors.disabledActiveTickColor;
            ((RippleThemeConfiguration) gapComposer2.consume(RippleKt.LocalRippleThemeConfiguration)).getClass();
            if (sliderState.isVertical()) {
                VerticalAlignmentLine verticalAlignmentLine = SliderKt.CornerSizeAlignmentLine;
                modifierM145height3ABfNKs = SizeKt.m155width3ABfNKs(modifier, 16.0f).then(SizeKt.FillWholeMaxHeight);
            } else {
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
                VerticalAlignmentLine verticalAlignmentLine2 = SliderKt.CornerSizeAlignmentLine;
                modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth, 16.0f);
            }
            int i5 = i3 & 112;
            boolean zChangedInstance = (i5 == 32) | gapComposer2.changedInstance(sliderState);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        int iMo75roundToPx0680j_4;
                        MeasureScope measureScope = (MeasureScope) obj2;
                        Placeable placeableMo598measureBRTryo0 = ((Measurable) obj3).mo598measureBRTryo0(((Constraints) obj4).value);
                        float f5 = f;
                        if (Dp.m796equalsimpl0(f5, Float.NaN)) {
                            iMo75roundToPx0680j_4 = sliderState.isVertical() ? placeableMo598measureBRTryo0.width / 2 : placeableMo598measureBRTryo0.height / 2;
                        } else {
                            iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(f5);
                        }
                        int i6 = placeableMo598measureBRTryo0.width;
                        int i7 = placeableMo598measureBRTryo0.height;
                        Map mapSingletonMap = Collections.singletonMap(SliderKt.CornerSizeAlignmentLine, Integer.valueOf(iMo75roundToPx0680j_4));
                        mapSingletonMap.getClass();
                        return measureScope.layout(i6, i7, mapSingletonMap, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 18));
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierThen = modifierM145height3ABfNKs.then(RulerKt.layout(Modifier.Companion.$$INSTANCE, (Function3) objRememberedValue));
            boolean zChangedInstance2 = ((i3 & 29360128) == 8388608) | (i5 == 32) | gapComposer2.changedInstance(sliderState) | ((i4 & 14) == 4) | gapComposer2.changed(jM327trackColorWaAFU9c$material3) | gapComposer2.changed(jM327trackColorWaAFU9c$material4) | gapComposer2.changed(j) | gapComposer2.changed(j2) | gapComposer2.changed(CropImageView.DEFAULT_ASPECT_RATIO) | ((234881024 & i3) == 67108864) | ((458752 & i3) == 131072) | ((3670016 & i3) == 1048576) | ((1879048192 & i3) == 536870912);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                final long j3 = j;
                final long j4 = j2;
                final float f5 = f4;
                obj = new Function1() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda5
                    /* JADX WARN: Code duplicated, block: B:117:0x0263  */
                    /* JADX WARN: Code duplicated, block: B:137:0x029b  */
                    /* JADX WARN: Code duplicated, block: B:144:0x02d1  */
                    /* JADX WARN: Code duplicated, block: B:146:0x02ef  */
                    /* JADX WARN: Code duplicated, block: B:148:0x02f3  */
                    /* JADX WARN: Code duplicated, block: B:150:0x030e  */
                    /* JADX WARN: Code duplicated, block: B:154:0x033d  */
                    /* JADX WARN: Code duplicated, block: B:158:0x0348  */
                    /* JADX WARN: Code duplicated, block: B:159:0x034d  */
                    /* JADX WARN: Code duplicated, block: B:161:0x0355  */
                    /* JADX WARN: Code duplicated, block: B:165:0x035c  */
                    /* JADX WARN: Code duplicated, block: B:167:0x037a  */
                    /* JADX WARN: Code duplicated, block: B:169:0x037f  */
                    /* JADX WARN: Code duplicated, block: B:171:0x03a1  */
                    /* JADX WARN: Code duplicated, block: B:174:0x03bf  */
                    /* JADX WARN: Code duplicated, block: B:177:0x03c6  */
                    /* JADX WARN: Code duplicated, block: B:65:0x0125  */
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        float fMo81toPx0680j_4;
                        float fMo81toPx0680j_5;
                        float fMo81toPx0680j_6;
                        float f6;
                        long j5;
                        char c;
                        float[] fArr;
                        boolean z3;
                        Orientation orientation;
                        Function2 function4;
                        float[] fArr2;
                        float f7;
                        float f8;
                        float f9;
                        float f10;
                        int length;
                        int i6;
                        int i7;
                        float f11;
                        float fLerp;
                        long jFloatToRawIntBits;
                        int iFloatToRawIntBits;
                        long jFloatToRawIntBits2;
                        long j6;
                        long jFloatToRawIntBits3;
                        int iFloatToRawIntBits2;
                        DrawScope drawScope;
                        long jFloatToRawIntBits4;
                        int iFloatToRawIntBits3;
                        long jFloatToRawIntBits5;
                        long jFloatToRawIntBits6;
                        int iFloatToRawIntBits4;
                        long jFloatToRawIntBits7;
                        int iFloatToRawIntBits5;
                        long jFloatToRawIntBits8;
                        int iFloatToRawIntBits6;
                        long jFloatToRawIntBits9;
                        DrawScope drawScope2 = (DrawScope) obj2;
                        float f12 = f;
                        boolean zM796equalsimpl0 = Dp.m796equalsimpl0(f12, Float.NaN);
                        SliderState sliderState2 = sliderState;
                        if (zM796equalsimpl0) {
                            fMo81toPx0680j_4 = (sliderState2.isVertical() ? Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> 32)) : Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() & 4294967295L))) / 2.0f;
                        } else {
                            fMo81toPx0680j_4 = drawScope2.mo81toPx0680j_4(f12);
                        }
                        sliderState2.getCoercedValueAsFraction();
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = sliderState2.thumbHeight$delegate;
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = sliderState2.thumbWidth$delegate;
                        sliderState2.getCoercedValueAsFraction();
                        float fMo78toDpu2uoSUM = drawScope2.mo78toDpu2uoSUM(parcelableSnapshotMutableIntState2.getIntValue());
                        float fMo78toDpu2uoSUM2 = drawScope2.mo78toDpu2uoSUM(parcelableSnapshotMutableIntState.getIntValue());
                        SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                        float[] fArr3 = sliderState2.tickFractions;
                        float coercedValueAsFraction = sliderState2.getCoercedValueAsFraction();
                        float f13 = f5 + CropImageView.DEFAULT_ASPECT_RATIO + CropImageView.DEFAULT_ASPECT_RATIO;
                        float fMo77toDpu2uoSUM = drawScope2.mo77toDpu2uoSUM(fMo81toPx0680j_4);
                        Orientation orientation2 = sliderState2.orientation;
                        boolean z4 = orientation2 == Orientation.Vertical;
                        boolean z5 = drawScope2.getLayoutDirection() == LayoutDirection.Rtl;
                        boolean z6 = z5 && !z4;
                        float fMo81toPx0680j_7 = drawScope2.mo81toPx0680j_4(fMo77toDpu2uoSUM);
                        long jMo556getSizeNHjbRc = drawScope2.mo556getSizeNHjbRc();
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (z4 ? jMo556getSizeNHjbRc & 4294967295L : jMo556getSizeNHjbRc >> 32));
                        fArr3.getClass();
                        if (Intrinsics.areEqual(CropImageView.DEFAULT_ASPECT_RATIO, fArr3.length == 0 ? null : Float.valueOf(fArr3[0])) || Intrinsics.areEqual(CropImageView.DEFAULT_ASPECT_RATIO, ArraysKt.lastOrNull(fArr3))) {
                        }
                        float f14 = (fArr3.length == 0 || (Intrinsics.areEqual(coercedValueAsFraction, fArr3.length != 0 ? Float.valueOf(fArr3[0]) : null) || Intrinsics.areEqual(coercedValueAsFraction, ArraysKt.lastOrNull(fArr3)))) ? ((fIntBitsToFloat - CropImageView.DEFAULT_ASPECT_RATIO) * coercedValueAsFraction) + CropImageView.DEFAULT_ASPECT_RATIO : (((fIntBitsToFloat - CropImageView.DEFAULT_ASPECT_RATIO) - (fMo81toPx0680j_7 * 2.0f)) * coercedValueAsFraction) + CropImageView.DEFAULT_ASPECT_RATIO + fMo81toPx0680j_7;
                        int length2 = fArr3.length;
                        float fMo81toPx0680j_8 = drawScope2.mo81toPx0680j_4(f3);
                        if (z4) {
                            if (Dp.m795compareTo0680j_4(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                                drawScope2.mo81toPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
                                drawScope2.mo81toPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            if (Dp.m795compareTo0680j_4(f13, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                                fMo81toPx0680j_5 = drawScope2.mo81toPx0680j_4(fMo78toDpu2uoSUM2) / 2.0f;
                                fMo81toPx0680j_6 = drawScope2.mo81toPx0680j_4(f13);
                                f6 = fMo81toPx0680j_6 + fMo81toPx0680j_5;
                            } else {
                                f6 = 0.0f;
                            }
                        } else {
                            if (Dp.m795compareTo0680j_4(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                                drawScope2.mo81toPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
                                drawScope2.mo81toPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            if (Dp.m795compareTo0680j_4(f13, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                                fMo81toPx0680j_5 = drawScope2.mo81toPx0680j_4(fMo78toDpu2uoSUM) / 2.0f;
                                fMo81toPx0680j_6 = drawScope2.mo81toPx0680j_4(f13);
                                f6 = fMo81toPx0680j_6 + fMo81toPx0680j_5;
                            } else {
                                f6 = 0.0f;
                            }
                        }
                        long jMo555getCenterF1C5BW0 = drawScope2.mo555getCenterF1C5BW0();
                        Float.intBitsToFloat((int) (z4 ? jMo555getCenterF1C5BW0 & 4294967295L : jMo555getCenterF1C5BW0 >> 32));
                        boolean z7 = z2;
                        if (z7) {
                            int length3 = fArr3.length;
                        }
                        float f15 = fIntBitsToFloat - f6;
                        if (!z7 || fArr3.length != 0) {
                            f15 -= fMo81toPx0680j_7;
                        }
                        Function2 function5 = function2;
                        if (f14 < f15) {
                            float f16 = z6 ? fMo81toPx0680j_7 : fMo81toPx0680j_8;
                            float f17 = z6 ? fMo81toPx0680j_8 : fMo81toPx0680j_7;
                            float f18 = f14 + f6;
                            float f19 = fIntBitsToFloat - f18;
                            if (z4) {
                                jFloatToRawIntBits6 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                j5 = 4294967295L;
                                iFloatToRawIntBits4 = Float.floatToRawIntBits(f18);
                            } else {
                                j5 = 4294967295L;
                                if (z5) {
                                    jFloatToRawIntBits6 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                    iFloatToRawIntBits4 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                } else {
                                    jFloatToRawIntBits6 = Float.floatToRawIntBits(f18);
                                    iFloatToRawIntBits4 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                }
                            }
                            long j7 = (jFloatToRawIntBits6 << 32) | (((long) iFloatToRawIntBits4) & j5);
                            if (z4) {
                                jFloatToRawIntBits7 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> 32)));
                                iFloatToRawIntBits5 = Float.floatToRawIntBits(f19);
                                c = ' ';
                                fArr = fArr3;
                            } else {
                                c = ' ';
                                fArr = fArr3;
                                if (z5) {
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> 32)) - f18;
                                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() & j5));
                                    jFloatToRawIntBits7 = Float.floatToRawIntBits(fIntBitsToFloat2);
                                    iFloatToRawIntBits5 = Float.floatToRawIntBits(fIntBitsToFloat3);
                                } else {
                                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() & j5));
                                    jFloatToRawIntBits7 = Float.floatToRawIntBits(f19);
                                    iFloatToRawIntBits5 = Float.floatToRawIntBits(fIntBitsToFloat4);
                                }
                            }
                            long j8 = (jFloatToRawIntBits7 << c) | (((long) iFloatToRawIntBits5) & j5);
                            orientation = orientation2;
                            function4 = function5;
                            z3 = z7;
                            SliderDefaults.m330drawTrackPathzXTsYAs(drawScope2, orientation, j7, j8, jM327trackColorWaAFU9c$material3, f16, f17);
                            if (z4) {
                                jFloatToRawIntBits8 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() >> c)));
                                iFloatToRawIntBits6 = Float.floatToRawIntBits(fIntBitsToFloat - fMo81toPx0680j_7);
                            } else {
                                if (z5) {
                                    jFloatToRawIntBits9 = (((long) Float.floatToRawIntBits(fMo81toPx0680j_7)) << c) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5)))) & j5);
                                } else {
                                    float fIntBitsToFloat5 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                    jFloatToRawIntBits8 = Float.floatToRawIntBits(fIntBitsToFloat - fMo81toPx0680j_7);
                                    iFloatToRawIntBits6 = Float.floatToRawIntBits(fIntBitsToFloat5);
                                }
                                if (function4 != null) {
                                    function4.invoke(drawScope2, new Offset(jFloatToRawIntBits9));
                                }
                            }
                            jFloatToRawIntBits9 = (((long) iFloatToRawIntBits6) & j5) | (jFloatToRawIntBits8 << c);
                            if (function4 != null) {
                                function4.invoke(drawScope2, new Offset(jFloatToRawIntBits9));
                            }
                        } else {
                            j5 = 4294967295L;
                            c = ' ';
                            fArr = fArr3;
                            z3 = z7;
                            orientation = orientation2;
                            function4 = function5;
                        }
                        float f20 = f14 - f6;
                        float f21 = !z6 ? fMo81toPx0680j_7 : fMo81toPx0680j_8;
                        float f22 = z6 ? fMo81toPx0680j_7 : fMo81toPx0680j_8;
                        float f23 = z6 ? f20 : f20 - CropImageView.DEFAULT_ASPECT_RATIO;
                        if (z3) {
                            fArr2 = fArr;
                            if (fArr2.length == 0) {
                                f7 = 0.0f;
                            }
                            if (f23 > f7) {
                                if (z4 && z5) {
                                    jFloatToRawIntBits3 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)) - f20);
                                    iFloatToRawIntBits2 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                } else {
                                    jFloatToRawIntBits3 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                    iFloatToRawIntBits2 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                }
                                long j9 = (jFloatToRawIntBits3 << c) | (((long) iFloatToRawIntBits2) & j5);
                                if (z4) {
                                    drawScope = drawScope2;
                                    jFloatToRawIntBits5 = (((long) Float.floatToRawIntBits(f23)) & j5) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)))) << c);
                                } else {
                                    drawScope = drawScope2;
                                    if (z5) {
                                        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & j5));
                                        jFloatToRawIntBits4 = Float.floatToRawIntBits(f20);
                                        iFloatToRawIntBits3 = Float.floatToRawIntBits(fIntBitsToFloat6);
                                    } else {
                                        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & j5));
                                        jFloatToRawIntBits4 = Float.floatToRawIntBits(f23);
                                        iFloatToRawIntBits3 = Float.floatToRawIntBits(fIntBitsToFloat7);
                                    }
                                    jFloatToRawIntBits5 = (jFloatToRawIntBits4 << c) | (((long) iFloatToRawIntBits3) & j5);
                                }
                                long j10 = jFloatToRawIntBits5;
                                drawScope2 = drawScope;
                                SliderDefaults.m330drawTrackPathzXTsYAs(drawScope2, orientation, j9, j10, jM327trackColorWaAFU9c$material4, f21, f22);
                            }
                            f8 = CropImageView.DEFAULT_ASPECT_RATIO + fMo81toPx0680j_7;
                            f9 = fIntBitsToFloat - fMo81toPx0680j_7;
                            f10 = f14 - f6;
                            float f24 = f14 + f6;
                            length = fArr2.length;
                            i6 = 0;
                            i7 = 0;
                            while (i6 < length) {
                                f11 = fArr2[i6];
                                int i8 = i7 + 1;
                                if (function4 == null && i7 == fArr2.length - 1) {
                                    f8 = f8;
                                    f9 = f9;
                                } else {
                                    fLerp = LifecyclesKt.lerp(f8, f9, f11);
                                    if (fLerp >= f10 || fLerp > f24) {
                                        if (z4) {
                                            jFloatToRawIntBits = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() >> c)));
                                            jFloatToRawIntBits2 = Float.floatToRawIntBits(fLerp);
                                        } else {
                                            if (z5) {
                                                float fIntBitsToFloat8 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)) - fLerp;
                                                float fIntBitsToFloat9 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                                jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat8);
                                                iFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat9);
                                            } else {
                                                float fIntBitsToFloat10 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                                jFloatToRawIntBits = Float.floatToRawIntBits(fLerp);
                                                iFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat10);
                                            }
                                            jFloatToRawIntBits2 = iFloatToRawIntBits;
                                        }
                                        Offset offset = new Offset((jFloatToRawIntBits2 & j5) | (jFloatToRawIntBits << c));
                                        if (fLerp >= CropImageView.DEFAULT_ASPECT_RATIO || fLerp > f20) {
                                            j6 = j3;
                                        } else {
                                            j6 = j4;
                                        }
                                        function3.invoke(drawScope2, offset, new Color(j6));
                                    } else {
                                        f8 = f8;
                                        f9 = f9;
                                    }
                                }
                                i6++;
                                f8 = f8;
                                i7 = i8;
                                f9 = f9;
                            }
                            return Unit.INSTANCE;
                        }
                        fArr2 = fArr;
                        f7 = f21;
                        if (f23 > f7) {
                            if (z4) {
                                jFloatToRawIntBits3 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                            } else {
                                jFloatToRawIntBits3 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)) - f20);
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            long j11 = (jFloatToRawIntBits3 << c) | (((long) iFloatToRawIntBits2) & j5);
                            if (z4) {
                                drawScope = drawScope2;
                                jFloatToRawIntBits5 = (((long) Float.floatToRawIntBits(f23)) & j5) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)))) << c);
                            } else {
                                drawScope = drawScope2;
                                if (z5) {
                                    float fIntBitsToFloat11 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & j5));
                                    jFloatToRawIntBits4 = Float.floatToRawIntBits(f20);
                                    iFloatToRawIntBits3 = Float.floatToRawIntBits(fIntBitsToFloat11);
                                } else {
                                    float fIntBitsToFloat12 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & j5));
                                    jFloatToRawIntBits4 = Float.floatToRawIntBits(f23);
                                    iFloatToRawIntBits3 = Float.floatToRawIntBits(fIntBitsToFloat12);
                                }
                                jFloatToRawIntBits5 = (jFloatToRawIntBits4 << c) | (((long) iFloatToRawIntBits3) & j5);
                            }
                            long j12 = jFloatToRawIntBits5;
                            drawScope2 = drawScope;
                            SliderDefaults.m330drawTrackPathzXTsYAs(drawScope2, orientation, j11, j12, jM327trackColorWaAFU9c$material4, f21, f22);
                        }
                        f8 = CropImageView.DEFAULT_ASPECT_RATIO + fMo81toPx0680j_7;
                        f9 = fIntBitsToFloat - fMo81toPx0680j_7;
                        f10 = f14 - f6;
                        float f25 = f14 + f6;
                        length = fArr2.length;
                        i6 = 0;
                        i7 = 0;
                        while (i6 < length) {
                            f11 = fArr2[i6];
                            int i9 = i7 + 1;
                            if (function4 == null) {
                                fLerp = LifecyclesKt.lerp(f8, f9, f11);
                                if (fLerp >= f10) {
                                }
                                if (z4) {
                                    jFloatToRawIntBits = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() >> c)));
                                    jFloatToRawIntBits2 = Float.floatToRawIntBits(fLerp);
                                } else {
                                    if (z5) {
                                        float fIntBitsToFloat13 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)) - fLerp;
                                        float fIntBitsToFloat14 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                        jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat13);
                                        iFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat14);
                                    } else {
                                        float fIntBitsToFloat15 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                        jFloatToRawIntBits = Float.floatToRawIntBits(fLerp);
                                        iFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat15);
                                    }
                                    jFloatToRawIntBits2 = iFloatToRawIntBits;
                                }
                                Offset offset2 = new Offset((jFloatToRawIntBits2 & j5) | (jFloatToRawIntBits << c));
                                if (fLerp >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    j6 = j3;
                                } else {
                                    j6 = j3;
                                }
                                function3.invoke(drawScope2, offset2, new Color(j6));
                            } else {
                                fLerp = LifecyclesKt.lerp(f8, f9, f11);
                                if (fLerp >= f10) {
                                }
                                if (z4) {
                                    jFloatToRawIntBits = Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() >> c)));
                                    jFloatToRawIntBits2 = Float.floatToRawIntBits(fLerp);
                                } else {
                                    if (z5) {
                                        float fIntBitsToFloat16 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> c)) - fLerp;
                                        float fIntBitsToFloat17 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                        jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat16);
                                        iFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat17);
                                    } else {
                                        float fIntBitsToFloat18 = Float.intBitsToFloat((int) (drawScope2.mo555getCenterF1C5BW0() & j5));
                                        jFloatToRawIntBits = Float.floatToRawIntBits(fLerp);
                                        iFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat18);
                                    }
                                    jFloatToRawIntBits2 = iFloatToRawIntBits;
                                }
                                Offset offset3 = new Offset((jFloatToRawIntBits2 & j5) | (jFloatToRawIntBits << c));
                                if (fLerp >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    j6 = j3;
                                } else {
                                    j6 = j3;
                                }
                                function3.invoke(drawScope2, offset3, new Color(j6));
                            }
                            i6++;
                            f8 = f8;
                            i7 = i9;
                            f9 = f9;
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer = gapComposer2;
                gapComposer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue2;
                gapComposer = gapComposer2;
            }
            ImageKt.Canvas(0, gapComposer, modifierThen, (Function1) obj);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    this.f$0.m335TrackImplVvwgllI(sliderState, f, modifier, z, sliderColors, function2, function3, f2, f3, z2, (Composer) obj2, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
