package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SuspendAnimationKt$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ SuspendAnimationKt$$ExternalSyntheticLambda6(Function2 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.f$0;
        switch (b) {
            case 0:
                AnimationScope animationScope = (AnimationScope) obj;
                function2.invoke(animationScope.value$delegate.getValue(), ArcSplineKt.FloatToVector.convertFromVector.invoke(animationScope.velocityVector));
                break;
            case 1:
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                function2.invoke(pointerInputChange, new Offset(PointerIconKt.positionChangeInternal(pointerInputChange, false)));
                pointerInputChange.consume();
                break;
            default:
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                function2.invoke(pointerInputChange2, Float.valueOf(Float.intBitsToFloat((int) (PointerIconKt.positionChangeInternal(pointerInputChange2, false) >> 32))));
                pointerInputChange2.consume();
                break;
        }
        return unit;
    }
}
