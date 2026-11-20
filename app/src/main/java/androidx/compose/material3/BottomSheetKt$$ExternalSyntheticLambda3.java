package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SheetState f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda3(SheetState sheetState, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = sheetState;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$1;
        SheetState sheetState = this.f$0;
        switch (b) {
            case 0:
                if (!sheetState.isVisible()) {
                    function0.invoke();
                }
                break;
            case 1:
                if (!sheetState.isVisible()) {
                    function0.invoke();
                }
                break;
            default:
                if (!sheetState.isVisible()) {
                    function0.invoke();
                }
                break;
        }
        return unit;
    }
}
