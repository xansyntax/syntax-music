package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.metrolist.music.discord.DiscordRpcManager;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SeekableTransitionState$snapTo$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $targetState;
    public final /* synthetic */ Transition $transition;
    public boolean label;
    public final /* synthetic */ SeekableTransitionState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SeekableTransitionState$snapTo$2(SeekableTransitionState seekableTransitionState, Object obj, Transition transition, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = seekableTransitionState;
        this.$targetState = obj;
        this.$transition = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SeekableTransitionState$snapTo$2(this.this$0, this.$targetState, this.$transition, continuation, (byte) 0);
            default:
                return new SeekableTransitionState$snapTo$2(this.this$0, this.$targetState, this.$transition, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((SeekableTransitionState$snapTo$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Transition transition = this.$transition;
        Object obj2 = this.$targetState;
        SeekableTransitionState seekableTransitionState = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    seekableTransitionState.endAllAnimations();
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = seekableTransitionState.targetState$delegate;
                    seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                    seekableTransitionState.setFraction(CropImageView.DEFAULT_ASPECT_RATIO);
                    if (obj2.equals(seekableTransitionState.currentState$delegate.getValue())) {
                        f = -4.0f;
                    } else {
                        f = obj2.equals(parcelableSnapshotMutableState.getValue()) ? -5.0f : -3.0f;
                    }
                    transition.updateTarget$animation_core(obj2);
                    transition.setPlayTimeNanos(0L);
                    parcelableSnapshotMutableState.setValue(obj2);
                    seekableTransitionState.setFraction(CropImageView.DEFAULT_ASPECT_RATIO);
                    seekableTransitionState.setCurrentState$animation_core(obj2);
                    transition.resetAnimationFraction$animation_core(f);
                    if (f == -3.0f) {
                        this.label = true;
                        if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                transition.onTransitionEnd$animation_core();
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    DiscordRpcManager.AnonymousClass4 anonymousClass4 = new DiscordRpcManager.AnonymousClass4(seekableTransitionState, obj2, transition, (Continuation) null);
                    this.label = true;
                    return AwaitKt.coroutineScope(anonymousClass4, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
