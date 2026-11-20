package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda5 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SheetState f$0;
    public final /* synthetic */ CoroutineScope f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda5(SheetState sheetState, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 1;
        this.f$0 = sheetState;
        this.f$2 = function0;
        this.f$1 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        SheetValue sheetValue = SheetValue.Hidden;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$2;
        CoroutineScope coroutineScope = this.f$1;
        SheetState sheetState = this.f$0;
        switch (b) {
            case 0:
                if (((Boolean) sheetState.confirmValueChange.invoke(sheetValue)).booleanValue()) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, (byte) 6), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, function0, (byte) 1));
                }
                break;
            case 1:
                int iOrdinal = sheetState.getCurrentValue().ordinal();
                if (iOrdinal == 1) {
                    function0.invoke();
                } else if (iOrdinal == 2) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, (byte) 0), 3);
                } else {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, (byte) 3), 3);
                }
                break;
            case 2:
                if (((Boolean) sheetState.confirmValueChange.invoke(sheetValue)).booleanValue()) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, (byte) 8), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, function0, (byte) 2));
                }
                break;
            default:
                if (sheetState.getCurrentValue() == SheetValue.Expanded && sheetState.anchoredDraggableState.getAnchors().hasPositionFor(SheetValue.PartiallyExpanded)) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, (byte) 9), 3);
                } else {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, (byte) 10), 3).invokeOnCompletion(new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 3));
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda5(SheetState sheetState, CoroutineScope coroutineScope, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = sheetState;
        this.f$1 = coroutineScope;
        this.f$2 = function0;
    }
}
