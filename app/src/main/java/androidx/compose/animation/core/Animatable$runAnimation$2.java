package androidx.compose.animation.core;

import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Animatable$runAnimation$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ TargetBasedAnimation $animation;
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ Object $initialVelocity;
    public final /* synthetic */ long $startTime;
    public AnimationState L$0;
    public Ref$BooleanRef L$1;
    public boolean label;
    public final /* synthetic */ Animatable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Animatable$runAnimation$2(Animatable animatable, Object obj, TargetBasedAnimation targetBasedAnimation, long j, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = obj;
        this.$animation = targetBasedAnimation;
        this.$startTime = j;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((Animatable$runAnimation$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        AnimationState animationState;
        Ref$BooleanRef ref$BooleanRef;
        CancellationException cancellationException;
        TargetBasedAnimation targetBasedAnimation = this.$animation;
        boolean z = this.label;
        Animatable animatable2 = this.this$0;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            try {
                animatable2.internalState.velocityVector = (AnimationVector) animatable2.typeConverter.convertToVector.invoke(this.$initialVelocity);
                animatable2.targetValue$delegate.setValue(targetBasedAnimation.mutableTargetValue);
                animatable2.isRunning$delegate.setValue(Boolean.TRUE);
                AnimationState animationStateCopy$default = ArcSplineKt.copy$default(animatable2.internalState, null, 23);
                Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                long j = this.$startTime;
                MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59((Object) animatable2, (Object) animationStateCopy$default, (Object) this.$block, (Object) ref$BooleanRef2, (byte) 2);
                animatable = animatable2;
                try {
                    this.L$0 = animationStateCopy$default;
                    this.L$1 = ref$BooleanRef2;
                    this.label = true;
                    Object objAnimate = ArcSplineKt.animate(animationStateCopy$default, targetBasedAnimation, j, mainActivity$$ExternalSyntheticLambda59, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimate == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    animationState = animationStateCopy$default;
                    ref$BooleanRef = ref$BooleanRef2;
                } catch (CancellationException e) {
                    e = e;
                    cancellationException = e;
                    animatable.endAnimation();
                    throw cancellationException;
                }
            } catch (CancellationException e2) {
                e = e2;
                animatable = animatable2;
                cancellationException = e;
                animatable.endAnimation();
                throw cancellationException;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$BooleanRef = this.L$1;
            animationState = this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                animatable = animatable2;
            } catch (CancellationException e3) {
                cancellationException = e3;
                animatable = animatable2;
                animatable.endAnimation();
                throw cancellationException;
            }
        }
        AnimationEndReason animationEndReason = ref$BooleanRef.element ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
        animatable.endAnimation();
        return new AnimationResult(animationState, animationEndReason);
    }
}
