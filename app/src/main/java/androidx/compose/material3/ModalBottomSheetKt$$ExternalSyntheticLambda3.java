package androidx.compose.material3;

import androidx.compose.runtime.DerivedSnapshotState;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ModalBottomSheetKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SheetState f$0;

    public /* synthetic */ ModalBottomSheetKt$$ExternalSyntheticLambda3(SheetState sheetState, byte b) {
        this.$r8$classId = b;
        this.f$0 = sheetState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        SheetValue sheetValue = SheetValue.Hidden;
        SheetState sheetState = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(((SheetValue) ((DerivedSnapshotState) sheetState.anchoredDraggableState.tail).getValue()) != sheetValue);
            default:
                return Boolean.valueOf(((SheetValue) ((DerivedSnapshotState) sheetState.anchoredDraggableState.tail).getValue()) != sheetValue);
        }
    }
}
