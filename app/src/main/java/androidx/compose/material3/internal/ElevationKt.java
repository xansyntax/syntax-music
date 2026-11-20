package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ElevationKt {
    public static final TweenSpec DefaultIncomingSpec;
    public static final TweenSpec DefaultOutgoingSpec;
    public static final TweenSpec HoveredOutgoingSpec;

    static {
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.4f, CropImageView.DEFAULT_ASPECT_RATIO, 0.6f, 1.0f);
        DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.FastOutSlowInEasing);
        DefaultOutgoingSpec = new TweenSpec(150, 0, cubicBezierEasing);
        HoveredOutgoingSpec = new TweenSpec(120, 0, cubicBezierEasing);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0009 A[PHI: r1
      0x0009: PHI (r1v3 androidx.compose.animation.core.TweenSpec) = 
      (r1v0 androidx.compose.animation.core.TweenSpec)
      (r1v0 androidx.compose.animation.core.TweenSpec)
      (r1v0 androidx.compose.animation.core.TweenSpec)
      (r1v4 androidx.compose.animation.core.TweenSpec)
      (r1v4 androidx.compose.animation.core.TweenSpec)
      (r1v4 androidx.compose.animation.core.TweenSpec)
      (r1v4 androidx.compose.animation.core.TweenSpec)
     binds: [B:19:0x0022, B:22:0x0027, B:28:0x0033, B:5:0x0007, B:8:0x000d, B:11:0x0012, B:14:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: animateElevation-rAjV9yQ, reason: not valid java name */
    public static final Object m367animateElevationrAjV9yQ(Animatable animatable, float f, Interaction interaction, Interaction interaction2, ContinuationImpl continuationImpl) {
        TweenSpec tweenSpec;
        TweenSpec tweenSpec2 = null;
        if (interaction2 != null) {
            boolean z = interaction2 instanceof PressInteraction.Press;
            tweenSpec = DefaultIncomingSpec;
            if (z || (interaction2 instanceof DragInteraction$Start) || (interaction2 instanceof HoverInteraction$Enter) || (interaction2 instanceof FocusInteraction.Focus)) {
                tweenSpec2 = tweenSpec;
            }
        } else if (interaction != null) {
            boolean z2 = interaction instanceof PressInteraction.Press;
            tweenSpec = DefaultOutgoingSpec;
            if (z2 || (interaction instanceof DragInteraction$Start)) {
                tweenSpec2 = tweenSpec;
            } else if (interaction instanceof HoverInteraction$Enter) {
                tweenSpec2 = HoveredOutgoingSpec;
            } else if (interaction instanceof FocusInteraction.Focus) {
                tweenSpec2 = tweenSpec;
            }
        }
        TweenSpec tweenSpec3 = tweenSpec2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (tweenSpec3 != null) {
            Object objAnimateTo$default = Animatable.animateTo$default(animatable, new Dp(f), tweenSpec3, null, null, continuationImpl, 12);
            if (objAnimateTo$default == coroutineSingletons) {
                return objAnimateTo$default;
            }
        } else {
            Object objSnapTo = animatable.snapTo(new Dp(f), continuationImpl);
            if (objSnapTo == coroutineSingletons) {
                return objSnapTo;
            }
        }
        return Unit.INSTANCE;
    }
}
