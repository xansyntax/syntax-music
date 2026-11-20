package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$onScrollStopped$performFling$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ long J$0;
    public long J$1;
    public byte label;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onScrollStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).packedValue;
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j = ((Velocity) obj).packedValue;
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, (Continuation) obj2);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = j;
        return scrollingLogic$onScrollStopped$performFling$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        byte b = this.label;
        ScrollingLogic scrollingLogic = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.J$0;
            NestedScrollDispatcher nestedScrollDispatcher = scrollingLogic.nestedScrollDispatcher;
            this.J$0 = j;
            this.label = (byte) 1;
            obj = nestedScrollDispatcher.m583dispatchPreFlingQWom1Mo(j, this);
            if (obj != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (b == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (b == 2) {
                j2 = this.J$1;
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
                j3 = ((Velocity) obj).packedValue;
                NestedScrollDispatcher nestedScrollDispatcher2 = scrollingLogic.nestedScrollDispatcher;
                long jM821minusAH228Gc = Velocity.m821minusAH228Gc(j2, j3);
                this.J$0 = j;
                this.J$1 = j3;
                this.label = (byte) 3;
                obj = nestedScrollDispatcher2.m582dispatchPostFlingRZ2iAVY(jM821minusAH228Gc, j3, this);
                if (obj != coroutineSingletons) {
                    j4 = j;
                    j5 = j3;
                }
                return coroutineSingletons;
            }
            if (b != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j5 = this.J$1;
            j4 = this.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Velocity(Velocity.m821minusAH228Gc(j4, Velocity.m821minusAH228Gc(j5, ((Velocity) obj).packedValue)));
        long jM821minusAH228Gc2 = Velocity.m821minusAH228Gc(j, ((Velocity) obj).packedValue);
        this.J$0 = j;
        this.J$1 = jM821minusAH228Gc2;
        this.label = (byte) 2;
        obj = scrollingLogic.m101doFlingAnimationQWom1Mo(jM821minusAH228Gc2, this);
        if (obj != coroutineSingletons) {
            j2 = jM821minusAH228Gc2;
            j3 = ((Velocity) obj).packedValue;
            NestedScrollDispatcher nestedScrollDispatcher3 = scrollingLogic.nestedScrollDispatcher;
            long jM821minusAH228Gc3 = Velocity.m821minusAH228Gc(j2, j3);
            this.J$0 = j;
            this.J$1 = j3;
            this.label = (byte) 3;
            obj = nestedScrollDispatcher3.m582dispatchPostFlingRZ2iAVY(jM821minusAH228Gc3, j3, this);
            if (obj != coroutineSingletons) {
                j4 = j;
                j5 = j3;
                return new Velocity(Velocity.m821minusAH228Gc(j4, Velocity.m821minusAH228Gc(j5, ((Velocity) obj).packedValue)));
            }
        }
        return coroutineSingletons;
    }
}
