package androidx.compose.animation;

import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.websocket.ControlFramesKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnterExitTransitionKt {
    public static final SpringSpec DefaultOffsetAnimationSpec;
    public static final SpringSpec DefaultSizeAnimationSpec;
    public static final SystemBarStyle$Companion$$ExternalSyntheticLambda0 NeutralSlideOffset = new SystemBarStyle$Companion$$ExternalSyntheticLambda0(14);
    public static final SystemBarStyle$Companion$$ExternalSyntheticLambda0 NeutralChangeSize = new SystemBarStyle$Companion$$ExternalSyntheticLambda0(15);
    public static final TwoWayConverterImpl TransformOriginVectorConverter = new TwoWayConverterImpl(new SystemBarStyle$Companion$$ExternalSyntheticLambda0(16), new SystemBarStyle$Companion$$ExternalSyntheticLambda0(18));
    public static final SpringSpec DefaultAlphaSpring = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
    public static final SpringSpec DefaultScaleSpring = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, Float.valueOf(0.002f), 1);
    public static final SpringSpec DefaultColorAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);

    static {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        DefaultOffsetAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntOffset(4294967297L), 1);
        DefaultSizeAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
    }

    public static final void DeferredTransitionCleanupEffect(Transition transition, Function0 function0, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1186853286);
        int i2 = (gapComposer.changed(transition) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16);
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition.pendingTargetState$delegate;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transition.targetState$delegate;
            boolean z = parcelableSnapshotMutableState.getValue() != null;
            if (Intrinsics.areEqual(transition.transitionState.getCurrentState(), parcelableSnapshotMutableState2.getValue()) && !z) {
                function0.invoke();
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            Object obj = objRememberedValue;
            if (objRememberedValue == neverEqualPolicy) {
                boolean[] zArr = {z};
                gapComposer.updateRememberedValue(zArr);
                obj = zArr;
            }
            boolean[] zArr2 = (boolean[]) obj;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new Object[1];
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Object[] objArr = (Object[]) objRememberedValue2;
            if (!Intrinsics.areEqual(objArr[0], parcelableSnapshotMutableState2.getValue())) {
                if (!z && !zArr2[0]) {
                    function0.invoke();
                }
                objArr[0] = parcelableSnapshotMutableState2.getValue();
            }
            zArr2[0] = z;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda1(transition, function0, i, b);
        }
    }

    public static EnterTransitionImpl expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, BiasAlignment.Horizontal horizontal, int i) {
        BiasAlignment biasAlignment;
        BiasAlignment.Horizontal horizontal2 = Alignment.Companion.End;
        if ((i & 1) != 0) {
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            finiteAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
        }
        if ((i & 2) != 0) {
            horizontal = horizontal2;
        }
        SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda0 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 19);
        if (Intrinsics.areEqual(horizontal, Alignment.Companion.Start)) {
            biasAlignment = Alignment.Companion.CenterStart;
        } else {
            biasAlignment = Intrinsics.areEqual(horizontal, horizontal2) ? Alignment.Companion.CenterEnd : Alignment.Companion.Center;
        }
        return expandIn(finiteAnimationSpec, biasAlignment, new ScrollState$$ExternalSyntheticLambda0((byte) 4, systemBarStyle$Companion$$ExternalSyntheticLambda0));
    }

    public static final EnterTransitionImpl expandIn(FiniteAnimationSpec finiteAnimationSpec, BiasAlignment biasAlignment, Function1 function1) {
        return new EnterTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, (SlideConfig) null, new ChangeSizeConfig(biasAlignment, function1, finiteAnimationSpec, true), (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE));
    }

    public static EnterTransitionImpl expandIn$default() {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        return expandIn(ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1), Alignment.Companion.BottomEnd, new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 17));
    }

    public static EnterTransitionImpl expandVertically$default(SpringSpec springSpec, int i) {
        BiasAlignment biasAlignment;
        byte b = 1;
        if ((i & 1) != 0) {
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            springSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
        }
        BiasAlignment.Vertical vertical = Alignment.Companion.Bottom;
        SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda0 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 8);
        if (Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            biasAlignment = Alignment.Companion.TopCenter;
        } else {
            biasAlignment = Intrinsics.areEqual(vertical, vertical) ? Alignment.Companion.BottomCenter : Alignment.Companion.Center;
        }
        return expandIn(springSpec, biasAlignment, new ScrollState$$ExternalSyntheticLambda0(b, systemBarStyle$Companion$$ExternalSyntheticLambda0));
    }

    public static EnterTransitionImpl fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return new EnterTransitionImpl(new EnterExitTransitionConfig(new FadeConfig(f, finiteAnimationSpec), (SlideConfig) null, (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, 126));
    }

    public static ExitTransitionImpl fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return new ExitTransitionImpl(new EnterExitTransitionConfig(new FadeConfig(f, finiteAnimationSpec), (SlideConfig) null, (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, 126));
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static EnterTransitionImpl m15scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = DefaultScaleSpring;
        }
        return new EnterTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, (SlideConfig) null, (ChangeSizeConfig) null, new ScaleConfig(f, ColorKt.TransformOrigin(0.5f, 0.5f), finiteAnimationSpec), (VeilConfig) null, (LinkedHashMap) null, 119));
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static ExitTransitionImpl m16scaleOutL8ZKhE$default(TweenSpec tweenSpec, float f, int i) {
        FiniteAnimationSpec finiteAnimationSpec = tweenSpec;
        if ((i & 1) != 0) {
            finiteAnimationSpec = DefaultScaleSpring;
        }
        return new ExitTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, (SlideConfig) null, (ChangeSizeConfig) null, new ScaleConfig(f, ColorKt.TransformOrigin(0.5f, 0.5f), finiteAnimationSpec), (VeilConfig) null, (LinkedHashMap) null, 119));
    }

    public static ExitTransitionImpl shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, BiasAlignment.Horizontal horizontal, int i) {
        BiasAlignment biasAlignment;
        BiasAlignment.Horizontal horizontal2 = Alignment.Companion.End;
        if ((i & 1) != 0) {
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            finiteAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
        }
        if ((i & 2) != 0) {
            horizontal = horizontal2;
        }
        SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda0 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 13);
        if (Intrinsics.areEqual(horizontal, Alignment.Companion.Start)) {
            biasAlignment = Alignment.Companion.CenterStart;
        } else {
            biasAlignment = Intrinsics.areEqual(horizontal, horizontal2) ? Alignment.Companion.CenterEnd : Alignment.Companion.Center;
        }
        return shrinkOut(finiteAnimationSpec, biasAlignment, new ScrollState$$ExternalSyntheticLambda0((byte) 3, systemBarStyle$Companion$$ExternalSyntheticLambda0));
    }

    public static final ExitTransitionImpl shrinkOut(FiniteAnimationSpec finiteAnimationSpec, BiasAlignment biasAlignment, Function1 function1) {
        return new ExitTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, (SlideConfig) null, new ChangeSizeConfig(biasAlignment, function1, finiteAnimationSpec, true), (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE));
    }

    public static ExitTransitionImpl shrinkVertically$default(SpringSpec springSpec, int i) {
        BiasAlignment biasAlignment;
        BiasAlignment.Vertical vertical = Alignment.Companion.Bottom;
        BiasAlignment.Vertical vertical2 = Alignment.Companion.Top;
        if ((i & 1) != 0) {
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            springSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
        }
        byte b = 2;
        BiasAlignment.Vertical vertical3 = (i & 2) != 0 ? vertical : vertical2;
        SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda0 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 21);
        if (Intrinsics.areEqual(vertical3, vertical2)) {
            biasAlignment = Alignment.Companion.TopCenter;
        } else {
            biasAlignment = Intrinsics.areEqual(vertical3, vertical) ? Alignment.Companion.BottomCenter : Alignment.Companion.Center;
        }
        return shrinkOut(springSpec, biasAlignment, new ScrollState$$ExternalSyntheticLambda0(b, systemBarStyle$Companion$$ExternalSyntheticLambda0));
    }

    public static EnterTransitionImpl slideInHorizontally$default(AlbumMenuKt$$ExternalSyntheticLambda13 albumMenuKt$$ExternalSyntheticLambda13, int i) {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntOffset(4294967297L), 1);
        byte b = 2;
        Function1 systemBarStyle$Companion$$ExternalSyntheticLambda0 = albumMenuKt$$ExternalSyntheticLambda13;
        if ((i & 2) != 0) {
            systemBarStyle$Companion$$ExternalSyntheticLambda0 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 12);
        }
        return new EnterTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, new SlideConfig(new CodecsKt$$ExternalSyntheticLambda0(systemBarStyle$Companion$$ExternalSyntheticLambda0, b), springSpecSpring$default), (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE));
    }

    public static EnterTransitionImpl slideInVertically$default(int i, Function1 function1) {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntOffset(4294967297L), 1);
        if ((i & 2) != 0) {
            function1 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 7);
        }
        return new EnterTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, new SlideConfig(new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 4), springSpecSpring$default), (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE));
    }

    public static ExitTransitionImpl slideOutHorizontally$default(StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9, int i) {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntOffset(4294967297L), 1);
        Function1 systemBarStyle$Companion$$ExternalSyntheticLambda0 = statsScreenKt$$ExternalSyntheticLambda9;
        if ((i & 2) != 0) {
            systemBarStyle$Companion$$ExternalSyntheticLambda0 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 11);
        }
        return new ExitTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, new SlideConfig(new CodecsKt$$ExternalSyntheticLambda0(systemBarStyle$Companion$$ExternalSyntheticLambda0, (byte) 3), springSpecSpring$default), (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE));
    }

    public static ExitTransitionImpl slideOutVertically$default(int i, Function1 function1) {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        byte b = 1;
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntOffset(4294967297L), 1);
        if ((i & 2) != 0) {
            function1 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 10);
        }
        return new ExitTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, new SlideConfig(new CodecsKt$$ExternalSyntheticLambda0(function1, b), springSpecSpring$default), (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE));
    }
}
