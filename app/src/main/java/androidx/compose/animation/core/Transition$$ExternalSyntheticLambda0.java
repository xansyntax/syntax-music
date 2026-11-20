package androidx.compose.animation.core;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Transition$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Transition f$0;

    public /* synthetic */ Transition$$ExternalSyntheticLambda0(Transition transition, byte b) {
        this.$r8$classId = b;
        this.f$0 = transition;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Transition transition = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf((Intrinsics.areEqual(transition.targetState$delegate.getValue(), transition.transitionState.getCurrentState()) && transition.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE && !((Boolean) transition.updateChildrenNeeded$delegate.getValue()).booleanValue()) ? false : true);
            default:
                return Long.valueOf(transition.calculateTotalDurationNanos());
        }
    }
}
