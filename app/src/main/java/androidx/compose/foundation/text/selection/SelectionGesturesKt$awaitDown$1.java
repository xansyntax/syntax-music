package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.sqlite.SQLite;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionGesturesKt$awaitDown$1 extends ContinuationImpl {
    public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SQLite.awaitDown(null, this);
    }
}
