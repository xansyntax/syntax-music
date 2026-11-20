package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$TooltipBox$$inlined$animateFloat$1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Transition $this_animateValue;

    public /* synthetic */ TooltipKt$TooltipBox$$inlined$animateFloat$1(Transition transition, byte b) {
        this.$r8$classId = b;
        this.$this_animateValue = transition;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Transition transition = this.$this_animateValue;
        switch (b) {
            case 0:
                return transition.targetState$delegate.getValue();
            case 1:
                return transition.targetState$delegate.getValue();
            case 2:
                return transition.getSegment();
            case 3:
                return transition.targetState$delegate.getValue();
            case 4:
                return transition.getSegment();
            case 5:
                return transition.getSegment();
            case 6:
                return transition.targetState$delegate.getValue();
            default:
                return transition.getSegment();
        }
    }
}
