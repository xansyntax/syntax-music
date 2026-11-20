package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProgressIndicatorKt {
    public static final CubicBezierEasing LinearIndeterminateProgressEasing = new CubicBezierEasing(0.3f, CropImageView.DEFAULT_ASPECT_RATIO, 0.8f, 0.15f);
    public static final CubicBezierEasing CircularProgressEasing = new CubicBezierEasing(0.2f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);

    /* JADX INFO: renamed from: CircularProgressIndicator-4lLiAd8, reason: not valid java name */
    public static final void m307CircularProgressIndicator4lLiAd8(Modifier modifier, final long j, final float f, int i, float f2, Composer composer, final int i2) {
        Modifier modifier2;
        final int i3;
        final float f3;
        int i4;
        float f4;
        int i5;
        final float f5;
        int i6;
        final int i7;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(333154241);
        int i8 = i2 | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(f) ? 256 : 128) | 222208;
        if (gapComposer.shouldExecute(i8 & 1, (74899 & i8) != 74898)) {
            gapComposer.startDefaults();
            if ((i2 & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i4 = i8 & (-7169);
                f4 = 4.0f;
                i5 = 1;
            } else {
                gapComposer.skipToGroupEnd();
                i5 = i;
                i4 = i8 & (-7169);
                f4 = f2;
            }
            gapComposer.endDefaults();
            int i9 = i5;
            final Stroke stroke = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f), CropImageView.DEFAULT_ASPECT_RATIO, i9, 0, 26);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = ArcSplineKt.rememberInfiniteTransition(1, gapComposer);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 1080.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(6000, 0, EasingKt.LinearEasing, 2), null, 0L, 6), null, gapComposer, 4536, 8);
            TextKt$$ExternalSyntheticLambda0 textKt$$ExternalSyntheticLambda0 = new TextKt$$ExternalSyntheticLambda0((byte) 1);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
            textKt$$ExternalSyntheticLambda0.invoke(keyframesSpecConfig);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 360.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig), null, 0L, 6), null, gapComposer, 4536, 8);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig2 = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig2.durationMillis = 6000;
            keyframesSpecConfig2.at(3000, Float.valueOf(0.87f)).easing = CircularProgressEasing;
            keyframesSpecConfig2.at(6000, Float.valueOf(0.1f));
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat3 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.1f, 0.87f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig2), null, 0L, 6), null, gapComposer, 4536, 8);
            boolean z = true;
            modifier2 = modifier;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, new BorderKt$$ExternalSyntheticLambda1((byte) 17)), 40.0f);
            boolean zChanged = gapComposer.changed(transitionAnimationStateAnimateFloat3) | ((i4 & 896) == 256) | gapComposer.changed(transitionAnimationStateAnimateFloat) | gapComposer.changed(transitionAnimationStateAnimateFloat2) | gapComposer.changed(0L) | gapComposer.changedInstance(stroke);
            if ((((i4 & 112) ^ 48) <= 32 || !gapComposer.changed(j)) && (i4 & 48) != 32) {
                z = false;
            }
            boolean z2 = zChanged | z;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z2 || objRememberedValue == Composer.Companion.Empty) {
                f5 = f4;
                i6 = 0;
                i7 = i9;
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Stroke stroke2 = stroke;
                        long j2 = j;
                        DrawScope drawScope = (DrawScope) obj;
                        float fFloatValue = ((Number) transitionAnimationStateAnimateFloat3.getValue()).floatValue() * 360.0f;
                        boolean z3 = i7;
                        float f6 = f5;
                        if (z3 && Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) {
                            f6 = f6 + f + CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        float fMo77toDpu2uoSUM = (f6 / ((float) (((double) drawScope.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
                        float fFloatValue2 = ((Number) transitionAnimationStateAnimateFloat2.getValue()).floatValue() + ((Number) transitionAnimationStateAnimateFloat.getValue()).floatValue();
                        long jMo555getCenterF1C5BW0 = drawScope.mo555getCenterF1C5BW0();
                        EmojiProcessor drawContext = drawScope.getDrawContext();
                        long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            ((DrawResult) drawContext.mSpanFactory).m402rotateUv8p0NA(jMo555getCenterF1C5BW0, fFloatValue2);
                            ProgressIndicatorKt.m311drawCircularIndicator42QJj7c(drawScope, Math.min(fFloatValue, fMo77toDpu2uoSUM) + fFloatValue, (360.0f - fFloatValue) - (Math.min(fFloatValue, fMo77toDpu2uoSUM) * 2.0f), 0L, stroke2);
                            ProgressIndicatorKt.m311drawCircularIndicator42QJj7c(drawScope, CropImageView.DEFAULT_ASPECT_RATIO, fFloatValue, j2, stroke2);
                            return Unit.INSTANCE;
                        } finally {
                            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                        }
                    }
                };
                gapComposer.updateRememberedValue(function1);
                objRememberedValue = function1;
            } else {
                f5 = f4;
                i7 = i9;
                i6 = 0;
            }
            ImageKt.Canvas(i6, gapComposer, modifierM151size3ABfNKs, (Function1) objRememberedValue);
            i3 = i7;
            f3 = f5;
        } else {
            modifier2 = modifier;
            gapComposer.skipToGroupEnd();
            i3 = i;
            f3 = f2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            recomposeScopeImplEndRestartGroup.block = new Function2(j, f, i3, f3, i2) { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda8
                public final /* synthetic */ long f$1;
                public final /* synthetic */ float f$2;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ float f$5;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                    Modifier modifier4 = this.f$0;
                    long j2 = this.f$1;
                    float f6 = this.f$2;
                    boolean z3 = this.f$4;
                    float f7 = this.f$5;
                    ProgressIndicatorKt.m307CircularProgressIndicator4lLiAd8(modifier4, j2, f6, z3 ? 1 : 0, f7, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    public static final void m308CircularProgressIndicatorIyT6zlY(Function0 function0, Modifier modifier, final long j, final float f, final long j2, final int i, final float f2, Composer composer, int i2) {
        int i3;
        int i4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1798883595);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= gapComposer.changed(j2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 = i;
            i3 |= gapComposer.changed(i4) ? 131072 : 65536;
        } else {
            i4 = i;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= gapComposer.changed(f2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 599187) != 599186)) {
            gapComposer.startDefaults();
            if ((i2 & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new Handshake$$ExternalSyntheticLambda0(function0, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final Function0 function1 = (Function0) objRememberedValue;
            final Stroke stroke = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f), CropImageView.DEFAULT_ASPECT_RATIO, i4, 0, 26);
            boolean zChanged = gapComposer.changed(function1);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AppBarKt$$ExternalSyntheticLambda8(function1, (byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue2), 40.0f);
            boolean zChanged2 = ((i3 & 458752) == 131072) | gapComposer.changed(function1) | ((3670016 & i3) == 1048576) | ((i3 & 7168) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && gapComposer.changed(j2)) || (i3 & 24576) == 16384) | gapComposer.changedInstance(stroke) | ((((i3 & 896) ^ 384) > 256 && gapComposer.changed(j)) || (i3 & 384) == 256);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                Function1 function2 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DrawScope drawScope = (DrawScope) obj;
                        float fFloatValue = ((Number) function1.invoke()).floatValue() * 360.0f;
                        boolean z2 = i;
                        float f3 = f2;
                        if (z2 && Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) {
                            f3 = f3 + f + CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        float fMo77toDpu2uoSUM = (f3 / ((float) (((double) drawScope.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
                        float fMin = Math.min(fFloatValue, fMo77toDpu2uoSUM) + 270.0f + fFloatValue;
                        float fMin2 = (360.0f - fFloatValue) - (Math.min(fFloatValue, fMo77toDpu2uoSUM) * 2.0f);
                        long j3 = j2;
                        Stroke stroke2 = stroke;
                        ProgressIndicatorKt.m311drawCircularIndicator42QJj7c(drawScope, fMin, fMin2, j3, stroke2);
                        ProgressIndicatorKt.m311drawCircularIndicator42QJj7c(drawScope, 270.0f, fFloatValue, j, stroke2);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(function2);
                objRememberedValue3 = function2;
            }
            ImageKt.Canvas(0, gapComposer, modifierM151size3ABfNKs, (Function1) objRememberedValue3);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProgressIndicatorKt$$ExternalSyntheticLambda13(function0, modifier, j, f, j2, i, f2, i2, (byte) 0);
        }
    }

    /* JADX INFO: renamed from: LinearProgressIndicator-GJbTh5U, reason: not valid java name */
    public static final void m309LinearProgressIndicatorGJbTh5U(final Function0 function0, final Modifier modifier, long j, long j2, int i, float f, Function1 function1, Composer composer, final int i2, final int i3) {
        int i4;
        final int i5;
        int i6;
        final long j3;
        final float f2;
        final Function1 function2;
        final int i7;
        final long j4;
        int i8;
        final long value;
        final int i9;
        int i10;
        Function1 function3;
        final float f3;
        long j5;
        final Function1 function4;
        final long j6;
        final long j7;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-339970038);
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changedInstance(function0) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        int i11 = i4 | 1152;
        int i12 = i3 & 16;
        if (i12 != 0) {
            i6 = i4 | 25728;
            i5 = i;
        } else {
            i5 = i;
            i6 = i11 | (gapComposer.changed(i5) ? 16384 : 8192);
        }
        int i13 = i6 | 720896;
        if (gapComposer.shouldExecute(i13 & 1, (599187 & i13) != 599186)) {
            gapComposer.startDefaults();
            int i14 = i2 & 1;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (i14 == 0 || gapComposer.getDefaultsInvalid()) {
                i8 = 57344;
                value = ColorSchemeKt.getValue(25, gapComposer);
                long value2 = ColorSchemeKt.getValue(31, gapComposer);
                if (i12 != 0) {
                    i5 = 1;
                }
                boolean zChanged = gapComposer.changed(value) | ((i13 & 57344) == 16384);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DrawScope drawScope = (DrawScope) obj;
                            float fMin = Math.min(drawScope.mo81toPx0680j_4(4.0f), Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)));
                            float fMo81toPx0680j_4 = drawScope.mo81toPx0680j_4(6.0f);
                            float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) - fMin) / 2.0f;
                            float f4 = fIntBitsToFloat > fMo81toPx0680j_4 ? fMo81toPx0680j_4 : fIntBitsToFloat;
                            LayoutDirection layoutDirection = drawScope.getLayoutDirection();
                            LayoutDirection layoutDirection2 = LayoutDirection.Rtl;
                            long j8 = value;
                            int i15 = i5;
                            if (layoutDirection == layoutDirection2) {
                                long jMo555getCenterF1C5BW0 = drawScope.mo555getCenterF1C5BW0();
                                EmojiProcessor drawContext = drawScope.getDrawContext();
                                long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                                drawContext.getCanvas().save();
                                try {
                                    ((DrawResult) drawContext.mSpanFactory).m403scale0AR0LA0(-1.0f, 1.0f, jMo555getCenterF1C5BW0);
                                    CardKt.drawStopIndicator_EgI2THU$drawIndicator(drawScope, i15, j8, fMin, f4);
                                } finally {
                                    IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                                }
                            } else {
                                CardKt.drawStopIndicator_EgI2THU$drawIndicator(drawScope, i15, j8, fMin, f4);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function1 function5 = (Function1) objRememberedValue;
                i9 = i5;
                i10 = i13 & (-3678081);
                function3 = function5;
                f3 = 4.0f;
                j5 = value2;
            } else {
                gapComposer.skipToGroupEnd();
                value = j;
                f3 = f;
                i9 = i5;
                i10 = i13 & (-3678081);
                i8 = 57344;
                j5 = j2;
                function3 = function1;
            }
            gapComposer.endDefaults();
            boolean z = (i10 & 14) == 4;
            int i15 = i8;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new Handshake$$ExternalSyntheticLambda0(function0, (byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            final Function0 function6 = (Function0) objRememberedValue2;
            Modifier modifierThen = modifier.then(AccessibilityUtilKt.IncreaseVerticalSemanticsBounds);
            boolean zChanged2 = gapComposer.changed(function6);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new AppBarKt$$ExternalSyntheticLambda8(function6, (byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM152sizeVpY3zN4 = SizeKt.m152sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue3), 240.0f, 4.0f);
            boolean zChanged3 = gapComposer.changed(function6) | ((i10 & i15) == 16384) | gapComposer.changed(j5) | gapComposer.changed(value) | gapComposer.changed(function3);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                function4 = function3;
                j6 = j5;
                j7 = value;
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DrawScope drawScope = (DrawScope) obj;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
                        boolean z2 = i9;
                        float fMo77toDpu2uoSUM = f3;
                        if (z2 && Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) {
                            fMo77toDpu2uoSUM = CropImageView.DEFAULT_ASPECT_RATIO + drawScope.mo77toDpu2uoSUM(fIntBitsToFloat) + fMo77toDpu2uoSUM;
                        }
                        float fMo77toDpu2uoSUM2 = fMo77toDpu2uoSUM / drawScope.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)));
                        float fFloatValue = ((Number) function6.invoke()).floatValue();
                        float fMin = Math.min(fFloatValue, fMo77toDpu2uoSUM2) + fFloatValue;
                        if (fMin <= 1.0f) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, fMin, 1.0f, j6, fIntBitsToFloat, z2 ? 1 : 0);
                        }
                        ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, CropImageView.DEFAULT_ASPECT_RATIO, fFloatValue, j7, fIntBitsToFloat, z2 ? 1 : 0);
                        function4.invoke(drawScope);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue4);
            } else {
                function4 = function3;
                j6 = j5;
                j7 = value;
            }
            ImageKt.Canvas(0, gapComposer, modifierM152sizeVpY3zN4, (Function1) objRememberedValue4);
            i7 = i9;
            f2 = f3;
            j3 = j6;
            j4 = j7;
            function2 = function4;
        } else {
            gapComposer.skipToGroupEnd();
            j3 = j2;
            f2 = f;
            function2 = function1;
            i7 = i5;
            j4 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    Function0 function7 = function0;
                    Modifier modifier2 = modifier;
                    long j8 = j4;
                    long j9 = j3;
                    boolean z2 = i7;
                    float f4 = f2;
                    Function1 function8 = function2;
                    ProgressIndicatorKt.m309LinearProgressIndicatorGJbTh5U(function7, modifier2, j8, j9, z2 ? 1 : 0, f4, function8, (Composer) obj, iUpdateChangedFlags, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x018a A[PHI: r11
      0x018a: PHI (r11v18 long) = (r11v16 long), (r11v19 long) binds: [B:42:0x0188, B:38:0x0181] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x01ab  */
    /* JADX INFO: renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    public static final void m310LinearProgressIndicatorrIrjwxo(float f, int i, final int i2, final int i3, long j, long j2, Composer composer, final Modifier modifier) {
        int i4;
        final float f2;
        final int i5;
        final long j3;
        int i6;
        int i7;
        long value;
        final float f3;
        long j4;
        boolean z;
        boolean zChanged;
        Object objRememberedValue;
        final int i8;
        final long j5;
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO);
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(567589233);
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(modifier) ? 4 : 2);
        } else {
            i4 = i2;
        }
        final long value2 = j;
        int i9 = i4 | (((i3 & 2) == 0 && gapComposer.changed(value2)) ? 32 : 16) | 27776;
        if (gapComposer.shouldExecute(i9 & 1, (i9 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i2 & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                if ((i3 & 2) != 0) {
                    value2 = ColorSchemeKt.getValue(25, gapComposer);
                    i9 &= -113;
                }
                i6 = i9 & (-897);
                i7 = 1;
                value = ColorSchemeKt.getValue(31, gapComposer);
                f3 = 4.0f;
            } else {
                gapComposer.skipToGroupEnd();
                if ((i3 & 2) != 0) {
                    i9 &= -113;
                }
                f3 = f;
                value = j2;
                i6 = i9 & (-897);
                i7 = i;
            }
            gapComposer.endDefaults();
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = ArcSplineKt.rememberInfiniteTransition(1, gapComposer);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig.durationMillis = 1750;
            KeyframesSpec.KeyframeEntity keyframeEntityAt = keyframesSpecConfig.at(0, fValueOf2);
            CubicBezierEasing cubicBezierEasing = LinearIndeterminateProgressEasing;
            keyframeEntityAt.easing = cubicBezierEasing;
            keyframesSpecConfig.at(CIOKt.DEFAULT_HTTP_POOL_SIZE, fValueOf);
            long j6 = value2;
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig), null, 0L, 6), null, gapComposer, 4536, 8);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig2 = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig2.durationMillis = 1750;
            keyframesSpecConfig2.at(250, fValueOf2).easing = cubicBezierEasing;
            keyframesSpecConfig2.at(1250, fValueOf);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat2 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig2), null, 0L, 6), null, gapComposer, 4536, 8);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig3 = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig3.durationMillis = 1750;
            keyframesSpecConfig3.at(650, fValueOf2).easing = cubicBezierEasing;
            keyframesSpecConfig3.at(1500, fValueOf);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat3 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig3), null, 0L, 6), null, gapComposer, 4536, 8);
            KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig4 = new KeyframesSpec.KeyframesSpecConfig();
            keyframesSpecConfig4.durationMillis = 1750;
            keyframesSpecConfig4.at(900, fValueOf2).easing = cubicBezierEasing;
            keyframesSpecConfig4.at(1750, fValueOf);
            final InfiniteTransition.TransitionAnimationState transitionAnimationStateAnimateFloat4 = ArcSplineKt.animateFloat(infiniteTransitionRememberInfiniteTransition, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig4), null, 0L, 6), null, gapComposer, 4536, 8);
            Modifier modifierM152sizeVpY3zN4 = SizeKt.m152sizeVpY3zN4(SemanticsModifierKt.semantics(modifier.then(AccessibilityUtilKt.IncreaseVerticalSemanticsBounds), true, new BorderKt$$ExternalSyntheticLambda1((byte) 17)), 240.0f, 4.0f);
            j3 = value;
            boolean zChanged2 = gapComposer.changed(transitionAnimationStateAnimateFloat) | gapComposer.changed(j3) | gapComposer.changed(transitionAnimationStateAnimateFloat2);
            if (((i6 & 112) ^ 48) > 32) {
                j4 = j6;
                if (gapComposer.changed(j4)) {
                    z = true;
                }
                zChanged = zChanged2 | z | gapComposer.changed(transitionAnimationStateAnimateFloat3) | gapComposer.changed(transitionAnimationStateAnimateFloat4);
                objRememberedValue = gapComposer.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.Companion.Empty) {
                    i8 = i7;
                    j5 = j4;
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            long j7;
                            DrawScope drawScope = (DrawScope) obj;
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
                            boolean z2 = i8;
                            float fMo77toDpu2uoSUM = f3;
                            if (z2 && Float.intBitsToFloat((int) (4294967295L & drawScope.mo556getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) {
                                fMo77toDpu2uoSUM = drawScope.mo77toDpu2uoSUM(fIntBitsToFloat) + fMo77toDpu2uoSUM + CropImageView.DEFAULT_ASPECT_RATIO;
                            }
                            float fMo77toDpu2uoSUM2 = fMo77toDpu2uoSUM / drawScope.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)));
                            State state = transitionAnimationStateAnimateFloat;
                            float fFloatValue = ((Number) state.getValue()).floatValue();
                            float f4 = 1.0f - fMo77toDpu2uoSUM2;
                            long j8 = j3;
                            if (fFloatValue < f4) {
                                ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? ((Number) state.getValue()).floatValue() + fMo77toDpu2uoSUM2 : 0.0f, 1.0f, j8, fIntBitsToFloat, z2 ? 1 : 0);
                            }
                            long j9 = j8;
                            float fFloatValue2 = ((Number) state.getValue()).floatValue();
                            State state2 = transitionAnimationStateAnimateFloat2;
                            float fFloatValue3 = fFloatValue2 - ((Number) state2.getValue()).floatValue();
                            long j10 = j5;
                            if (fFloatValue3 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue(), ((Number) state2.getValue()).floatValue(), j10, fIntBitsToFloat, z2 ? 1 : 0);
                                j7 = j10;
                            } else {
                                j7 = j10;
                            }
                            float fFloatValue4 = ((Number) state2.getValue()).floatValue();
                            State state3 = transitionAnimationStateAnimateFloat3;
                            if (fFloatValue4 > fMo77toDpu2uoSUM2) {
                                ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? ((Number) state3.getValue()).floatValue() + fMo77toDpu2uoSUM2 : 0.0f, ((Number) state2.getValue()).floatValue() < 1.0f ? ((Number) state2.getValue()).floatValue() - fMo77toDpu2uoSUM2 : 1.0f, j9, fIntBitsToFloat, z2 ? 1 : 0);
                                j9 = j9;
                            }
                            float fFloatValue5 = ((Number) state3.getValue()).floatValue();
                            State state4 = transitionAnimationStateAnimateFloat4;
                            if (fFloatValue5 - ((Number) state4.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                                ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue(), ((Number) state4.getValue()).floatValue(), j7, fIntBitsToFloat, z2 ? 1 : 0);
                                drawScope = drawScope;
                                fIntBitsToFloat = fIntBitsToFloat;
                            }
                            if (((Number) state4.getValue()).floatValue() > fMo77toDpu2uoSUM2) {
                                ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, CropImageView.DEFAULT_ASPECT_RATIO, ((Number) state4.getValue()).floatValue() < 1.0f ? ((Number) state4.getValue()).floatValue() - fMo77toDpu2uoSUM2 : 1.0f, j9, fIntBitsToFloat, z2 ? 1 : 0);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    i8 = i7;
                    j5 = j4;
                }
                ImageKt.Canvas(0, gapComposer, modifierM152sizeVpY3zN4, (Function1) objRememberedValue);
                i5 = i8;
                f2 = f3;
                value2 = j5;
            } else {
                j4 = j6;
            }
            if ((i6 & 48) == 32) {
                z = true;
            } else {
                z = false;
            }
            zChanged = zChanged2 | z | gapComposer.changed(transitionAnimationStateAnimateFloat3) | gapComposer.changed(transitionAnimationStateAnimateFloat4);
            objRememberedValue = gapComposer.rememberedValue();
            if (zChanged) {
                i8 = i7;
                j5 = j4;
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        long j7;
                        DrawScope drawScope = (DrawScope) obj;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
                        boolean z2 = i8;
                        float fMo77toDpu2uoSUM = f3;
                        if (z2 && Float.intBitsToFloat((int) (4294967295L & drawScope.mo556getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) {
                            fMo77toDpu2uoSUM = drawScope.mo77toDpu2uoSUM(fIntBitsToFloat) + fMo77toDpu2uoSUM + CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        float fMo77toDpu2uoSUM2 = fMo77toDpu2uoSUM / drawScope.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)));
                        State state = transitionAnimationStateAnimateFloat;
                        float fFloatValue = ((Number) state.getValue()).floatValue();
                        float f4 = 1.0f - fMo77toDpu2uoSUM2;
                        long j8 = j3;
                        if (fFloatValue < f4) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? ((Number) state.getValue()).floatValue() + fMo77toDpu2uoSUM2 : 0.0f, 1.0f, j8, fIntBitsToFloat, z2 ? 1 : 0);
                        }
                        long j9 = j8;
                        float fFloatValue2 = ((Number) state.getValue()).floatValue();
                        State state2 = transitionAnimationStateAnimateFloat2;
                        float fFloatValue3 = fFloatValue2 - ((Number) state2.getValue()).floatValue();
                        long j10 = j5;
                        if (fFloatValue3 > CropImageView.DEFAULT_ASPECT_RATIO) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue(), ((Number) state2.getValue()).floatValue(), j10, fIntBitsToFloat, z2 ? 1 : 0);
                            j7 = j10;
                        } else {
                            j7 = j10;
                        }
                        float fFloatValue4 = ((Number) state2.getValue()).floatValue();
                        State state3 = transitionAnimationStateAnimateFloat3;
                        if (fFloatValue4 > fMo77toDpu2uoSUM2) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? ((Number) state3.getValue()).floatValue() + fMo77toDpu2uoSUM2 : 0.0f, ((Number) state2.getValue()).floatValue() < 1.0f ? ((Number) state2.getValue()).floatValue() - fMo77toDpu2uoSUM2 : 1.0f, j9, fIntBitsToFloat, z2 ? 1 : 0);
                            j9 = j9;
                        }
                        float fFloatValue5 = ((Number) state3.getValue()).floatValue();
                        State state4 = transitionAnimationStateAnimateFloat4;
                        if (fFloatValue5 - ((Number) state4.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue(), ((Number) state4.getValue()).floatValue(), j7, fIntBitsToFloat, z2 ? 1 : 0);
                            drawScope = drawScope;
                            fIntBitsToFloat = fIntBitsToFloat;
                        }
                        if (((Number) state4.getValue()).floatValue() > fMo77toDpu2uoSUM2) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, CropImageView.DEFAULT_ASPECT_RATIO, ((Number) state4.getValue()).floatValue() < 1.0f ? ((Number) state4.getValue()).floatValue() - fMo77toDpu2uoSUM2 : 1.0f, j9, fIntBitsToFloat, z2 ? 1 : 0);
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                i8 = i7;
                j5 = j4;
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        long j7;
                        DrawScope drawScope = (DrawScope) obj;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
                        boolean z2 = i8;
                        float fMo77toDpu2uoSUM = f3;
                        if (z2 && Float.intBitsToFloat((int) (4294967295L & drawScope.mo556getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32))) {
                            fMo77toDpu2uoSUM = drawScope.mo77toDpu2uoSUM(fIntBitsToFloat) + fMo77toDpu2uoSUM + CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        float fMo77toDpu2uoSUM2 = fMo77toDpu2uoSUM / drawScope.mo77toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)));
                        State state = transitionAnimationStateAnimateFloat;
                        float fFloatValue = ((Number) state.getValue()).floatValue();
                        float f4 = 1.0f - fMo77toDpu2uoSUM2;
                        long j8 = j3;
                        if (fFloatValue < f4) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? ((Number) state.getValue()).floatValue() + fMo77toDpu2uoSUM2 : 0.0f, 1.0f, j8, fIntBitsToFloat, z2 ? 1 : 0);
                        }
                        long j9 = j8;
                        float fFloatValue2 = ((Number) state.getValue()).floatValue();
                        State state2 = transitionAnimationStateAnimateFloat2;
                        float fFloatValue3 = fFloatValue2 - ((Number) state2.getValue()).floatValue();
                        long j10 = j5;
                        if (fFloatValue3 > CropImageView.DEFAULT_ASPECT_RATIO) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue(), ((Number) state2.getValue()).floatValue(), j10, fIntBitsToFloat, z2 ? 1 : 0);
                            j7 = j10;
                        } else {
                            j7 = j10;
                        }
                        float fFloatValue4 = ((Number) state2.getValue()).floatValue();
                        State state3 = transitionAnimationStateAnimateFloat3;
                        if (fFloatValue4 > fMo77toDpu2uoSUM2) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? ((Number) state3.getValue()).floatValue() + fMo77toDpu2uoSUM2 : 0.0f, ((Number) state2.getValue()).floatValue() < 1.0f ? ((Number) state2.getValue()).floatValue() - fMo77toDpu2uoSUM2 : 1.0f, j9, fIntBitsToFloat, z2 ? 1 : 0);
                            j9 = j9;
                        }
                        float fFloatValue5 = ((Number) state3.getValue()).floatValue();
                        State state4 = transitionAnimationStateAnimateFloat4;
                        if (fFloatValue5 - ((Number) state4.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue(), ((Number) state4.getValue()).floatValue(), j7, fIntBitsToFloat, z2 ? 1 : 0);
                            drawScope = drawScope;
                            fIntBitsToFloat = fIntBitsToFloat;
                        }
                        if (((Number) state4.getValue()).floatValue() > fMo77toDpu2uoSUM2) {
                            ProgressIndicatorKt.m312drawLinearIndicatorqYKTg0g(drawScope, CropImageView.DEFAULT_ASPECT_RATIO, ((Number) state4.getValue()).floatValue() < 1.0f ? ((Number) state4.getValue()).floatValue() - fMo77toDpu2uoSUM2 : 1.0f, j9, fIntBitsToFloat, z2 ? 1 : 0);
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ImageKt.Canvas(0, gapComposer, modifierM152sizeVpY3zN4, (Function1) objRememberedValue);
            i5 = i8;
            f2 = f3;
            value2 = j5;
        } else {
            gapComposer.skipToGroupEnd();
            f2 = f;
            i5 = i;
            j3 = j2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    float f4 = f2;
                    boolean z2 = i5;
                    byte b = i3;
                    long j7 = value2;
                    long j8 = j3;
                    ProgressIndicatorKt.m310LinearProgressIndicatorrIrjwxo(f4, z2 ? 1 : 0, iUpdateChangedFlags, b, j7, j8, (Composer) obj, modifier);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m311drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = stroke.width / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)) - (2.0f * f3);
        drawScope.mo531drawArcyD3GUKo(j, f, f2, (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L), (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), (768 & 64) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, stroke);
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m312drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L));
        float f4 = fIntBitsToFloat2 / 2.0f;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f5 = (z ? f : 1.0f - f2) * fIntBitsToFloat;
        float f6 = (z ? f2 : 1.0f - f) * fIntBitsToFloat;
        if (i == 0 || fIntBitsToFloat2 > fIntBitsToFloat) {
            drawScope.mo535drawLineNGM6Ib0(j, (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), f3, (496 & 16) != 0 ? 0 : 0, 3);
            return;
        }
        float f7 = f3 / 2.0f;
        float f8 = fIntBitsToFloat - f7;
        if (f5 < f7) {
            f5 = f7;
        }
        if (f5 > f8) {
            f5 = f8;
        }
        if (f6 < f7) {
            f6 = f7;
        }
        if (f6 <= f8) {
            f8 = f6;
        }
        if (Math.abs(f2 - f) > CropImageView.DEFAULT_ASPECT_RATIO) {
            drawScope.mo535drawLineNGM6Ib0(j, (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), (((long) Float.floatToRawIntBits(f8)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), f3, (496 & 16) != 0 ? 0 : i, 3);
        }
    }
}
