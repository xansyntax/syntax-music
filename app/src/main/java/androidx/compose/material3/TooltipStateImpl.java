package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$executeLikeSong$2$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipStateImpl {
    public CancellableContinuationImpl job;
    public final MutatorMutex mutatorMutex;
    public final MutableTransitionState transition = new MutableTransitionState(Boolean.FALSE);

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipStateImpl$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ SyncUtils$executeLikeSong$2$1 $cancellableShow;
        public final /* synthetic */ MutatePriority $mutatePriority;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, SyncUtils$executeLikeSong$2$1 syncUtils$executeLikeSong$2$1, Continuation continuation) {
            super(1, continuation);
            this.$mutatePriority = mutatePriority;
            this.$cancellableShow = syncUtils$executeLikeSong$2$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return TooltipStateImpl.this.new AnonymousClass2(this.$mutatePriority, this.$cancellableShow, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ((AnonymousClass2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        
            if (kotlinx.coroutines.AwaitKt.withTimeout(1500, r9, r8) == r7) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            byte b = this.label;
            Continuation continuation = null;
            MutatePriority mutatePriority = MutatePriority.PreventUserInput;
            MutatePriority mutatePriority2 = this.$mutatePriority;
            TooltipStateImpl tooltipStateImpl = TooltipStateImpl.this;
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutatePriority mutatePriority3 = MutatePriority.UserInput;
                    SyncUtils$executeLikeSong$2$1 syncUtils$executeLikeSong$2$1 = this.$cancellableShow;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (mutatePriority2 == mutatePriority3) {
                        this.label = (byte) 1;
                        if (syncUtils$executeLikeSong$2$1.invoke(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        SyncUtils.AnonymousClass2 anonymousClass2 = new SyncUtils.AnonymousClass2(syncUtils$executeLikeSong$2$1, continuation, (byte) 12);
                        this.label = (byte) 2;
                    }
                } else {
                    if (b != 1 && b != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (mutatePriority2 != mutatePriority) {
                    tooltipStateImpl.dismiss();
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                if (mutatePriority2 != mutatePriority) {
                    tooltipStateImpl.dismiss();
                }
                throw th;
            }
        }
    }

    public TooltipStateImpl(MutatorMutex mutatorMutex) {
        this.mutatorMutex = mutatorMutex;
    }

    public final void dismiss() {
        this.transition.targetState$delegate.setValue(Boolean.FALSE);
    }

    public final boolean isVisible() {
        MutableTransitionState mutableTransitionState = this.transition;
        return ((Boolean) mutableTransitionState.currentState$delegate.getValue()).booleanValue() || ((Boolean) mutableTransitionState.targetState$delegate.getValue()).booleanValue();
    }

    public final Object show(MutatePriority mutatePriority, SuspendLambda suspendLambda) {
        Object objMutate = this.mutatorMutex.mutate(mutatePriority, new AnonymousClass2(mutatePriority, new SyncUtils$executeLikeSong$2$1(this, null, (byte) 1), null), suspendLambda);
        return objMutate == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate : Unit.INSTANCE;
    }
}
