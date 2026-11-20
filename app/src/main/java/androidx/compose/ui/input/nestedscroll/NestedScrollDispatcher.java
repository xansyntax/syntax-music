package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollDispatcher {
    public Function0 calculateNestedScrollScope = new RoomDatabase$$ExternalSyntheticLambda0(8, this);
    public NestedScrollNode lastKnownParentNode;
    public NestedScrollNode nestedScrollNode;
    public CoroutineScope scope;

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        if (r0 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        if (r0 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        return r1;
     */
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m582dispatchPostFlingRZ2iAVY(long j, long j2, ContinuationImpl continuationImpl) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        long j3;
        if (continuationImpl instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuationImpl;
            int i = nestedScrollDispatcher$dispatchPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuationImpl);
            }
        } else {
            nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuationImpl);
        }
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$2 = nestedScrollDispatcher$dispatchPostFling$1;
        Object objMo99onPostFlingRZ2iAVY = nestedScrollDispatcher$dispatchPostFling$2.result;
        int i2 = nestedScrollDispatcher$dispatchPostFling$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
            NestedScrollNode nestedScrollNode = this.nestedScrollNode;
            NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
            j3 = 0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (parentNestedScrollNode$ui == null) {
                NestedScrollNode nestedScrollNode2 = this.lastKnownParentNode;
                if (nestedScrollNode2 != null) {
                    nestedScrollDispatcher$dispatchPostFling$2.label = 1;
                    objMo99onPostFlingRZ2iAVY = nestedScrollNode2.mo99onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$2);
                }
            } else {
                NestedScrollNode nestedScrollNode3 = this.nestedScrollNode;
                NestedScrollNode parentNestedScrollNode$ui2 = nestedScrollNode3 != null ? nestedScrollNode3.getParentNestedScrollNode$ui() : null;
                if (parentNestedScrollNode$ui2 != null) {
                    nestedScrollDispatcher$dispatchPostFling$2.label = 2;
                    objMo99onPostFlingRZ2iAVY = parentNestedScrollNode$ui2.mo99onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$2);
                }
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
            j3 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
            j3 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
        }
        return new Velocity(j3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    public final Object m583dispatchPreFlingQWom1Mo(long j, ContinuationImpl continuationImpl) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long j2;
        if (continuationImpl instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuationImpl;
            int i = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuationImpl);
            }
        } else {
            nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuationImpl);
        }
        Object objMo326onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        int i2 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo326onPreFlingQWom1Mo);
            NestedScrollNode nestedScrollNode = this.nestedScrollNode;
            NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
            if (parentNestedScrollNode$ui != null) {
                nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                objMo326onPreFlingQWom1Mo = parentNestedScrollNode$ui.mo326onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objMo326onPreFlingQWom1Mo == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                j2 = 0;
            }
            return new Velocity(j2);
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(objMo326onPreFlingQWom1Mo);
        j2 = ((Velocity) objMo326onPreFlingQWom1Mo).packedValue;
        return new Velocity(j2);
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope = (CoroutineScope) this.calculateNestedScrollScope.invoke();
        return coroutineScope == null ? NestedScrollNodeKt.CancelledScope : coroutineScope;
    }
}
