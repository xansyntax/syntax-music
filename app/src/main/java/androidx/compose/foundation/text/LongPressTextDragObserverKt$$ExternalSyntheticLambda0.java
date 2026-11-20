package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LongPressTextDragObserverKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextDragObserver f$0;

    public /* synthetic */ LongPressTextDragObserverKt$$ExternalSyntheticLambda0(TextDragObserver textDragObserver, byte b) {
        this.$r8$classId = b;
        this.f$0 = textDragObserver;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        TextDragObserver textDragObserver = this.f$0;
        switch (b) {
            case 0:
                textDragObserver.mo202onStart3MmeM6k(((Offset) obj).packedValue, SelectionAdjustment$Companion.None);
                break;
            case 1:
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                textDragObserver.mo201onDragk4lQ0M(PointerIconKt.positionChangeInternal(pointerInputChange, false));
                pointerInputChange.consume();
                break;
            default:
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                textDragObserver.mo201onDragk4lQ0M(PointerIconKt.positionChangeInternal(pointerInputChange2, false));
                pointerInputChange2.consume();
                break;
        }
        return unit;
    }
}
