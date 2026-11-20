package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultFlingBehavior implements FlingBehavior {
    public DecayAnimationSpecImpl flingDecay;
    public final AbstractScrollableNodeKt$DefaultScrollMotionDurationScale$1 motionDurationScale;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ float $initialVelocity;
        public final /* synthetic */ ScrollScope $this_performFling;
        public Ref$FloatRef L$0;
        public AnimationState L$1;
        public boolean label;
        public final /* synthetic */ DefaultFlingBehavior this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation continuation) {
            super(2, continuation);
            this.$initialVelocity = f;
            this.this$0 = defaultFlingBehavior;
            this.$this_performFling = scrollScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float f;
            Ref$FloatRef ref$FloatRef;
            AnimationState animationState;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                f = this.$initialVelocity;
                if (Math.abs(f) > 1.0f) {
                    Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                    ref$FloatRef2.element = f;
                    Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
                    AnimationState animationStateAnimationState$default = ArcSplineKt.AnimationState$default(CropImageView.DEFAULT_ASPECT_RATIO, f, 28);
                    try {
                        DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                        DecayAnimationSpecImpl decayAnimationSpecImpl = defaultFlingBehavior.flingDecay;
                        UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0(ref$FloatRef3, this.$this_performFling, ref$FloatRef2, defaultFlingBehavior);
                        this.L$0 = ref$FloatRef2;
                        this.L$1 = animationStateAnimationState$default;
                        this.label = true;
                        Object objAnimateDecay = ArcSplineKt.animateDecay(animationStateAnimationState$default, decayAnimationSpecImpl, false, utilsKt$$ExternalSyntheticLambda0, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateDecay == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        ref$FloatRef = ref$FloatRef2;
                        f = ref$FloatRef.element;
                    } catch (CancellationException unused) {
                        ref$FloatRef = ref$FloatRef2;
                        animationState = animationStateAnimationState$default;
                        ref$FloatRef.element = ((Number) animationState.getVelocity()).floatValue();
                    }
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                animationState = this.L$1;
                ref$FloatRef = this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused2) {
                    ref$FloatRef.element = ((Number) animationState.getVelocity()).floatValue();
                }
                f = ref$FloatRef.element;
            }
            return new Float(f);
        }
    }

    public DefaultFlingBehavior(DecayAnimationSpecImpl decayAnimationSpecImpl) {
        AbstractScrollableNodeKt$DefaultScrollMotionDurationScale$1 abstractScrollableNodeKt$DefaultScrollMotionDurationScale$1 = AbstractScrollableNodeKt.DefaultScrollMotionDurationScale;
        this.flingDecay = decayAnimationSpecImpl;
        this.motionDurationScale = abstractScrollableNodeKt$DefaultScrollMotionDurationScale$1;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        return AwaitKt.withContext(this.motionDurationScale, new AnonymousClass2(f, this, scrollScope, null), continuation);
    }
}
