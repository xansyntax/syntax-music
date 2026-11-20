package kotlinx.coroutines;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class CancellableContinuationImpl$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ CancellableContinuationImpl$$ExternalSyntheticLambda0(Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.f$0;
        switch (b) {
            case 0:
                function1.invoke((Throwable) obj);
                break;
            default:
                function1.invoke(new Offset(((PointerInputChange) obj2).position));
                break;
        }
        return unit;
    }
}
