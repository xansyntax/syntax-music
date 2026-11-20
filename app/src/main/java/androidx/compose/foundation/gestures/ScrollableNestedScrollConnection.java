package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public boolean enabled;
    public final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public final Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) throws Throwable {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        long jM821minusAH228Gc;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            int i = scrollableNestedScrollConnection$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, (ContinuationImpl) continuation);
        }
        Object objM101doFlingAnimationQWom1Mo = scrollableNestedScrollConnection$onPostFling$1.result;
        int i2 = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM101doFlingAnimationQWom1Mo);
            jM821minusAH228Gc = 0;
            if (this.enabled) {
                ScrollingLogic scrollingLogic = this.scrollingLogic;
                if (!scrollingLogic.isFlinging) {
                    scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
                    scrollableNestedScrollConnection$onPostFling$1.label = 1;
                    objM101doFlingAnimationQWom1Mo = scrollingLogic.m101doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objM101doFlingAnimationQWom1Mo == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                jM821minusAH228Gc = Velocity.m821minusAH228Gc(j2, jM821minusAH228Gc);
            }
            return new Velocity(jM821minusAH228Gc);
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j2 = scrollableNestedScrollConnection$onPostFling$1.J$0;
        ResultKt.throwOnFailure(objM101doFlingAnimationQWom1Mo);
        jM821minusAH228Gc = ((Velocity) objM101doFlingAnimationQWom1Mo).packedValue;
        jM821minusAH228Gc = Velocity.m821minusAH228Gc(j2, jM821minusAH228Gc);
        return new Velocity(jM821minusAH228Gc);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        if (!this.enabled) {
            return 0L;
        }
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        if (scrollingLogic.scrollableState.isScrollInProgress()) {
            return 0L;
        }
        return scrollingLogic.m106toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(scrollingLogic.scrollableState.dispatchRawDelta(scrollingLogic.reverseIfNeeded(scrollingLogic.m105toFloatk4lQ0M(j2)))));
    }
}
