package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.sqlite.SQLite;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionGesturesKt$touchSelectionSubsequentPress$1 extends ContinuationImpl {
    public long J$0;
    public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
    public TextDragObserver L$1;
    public Ref$LongRef L$2;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SQLite.touchSelectionSubsequentPress(null, null, null, 0, this);
    }
}
