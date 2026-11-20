package androidx.compose.ui.input.indirect;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatableNode;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface IndirectPointerInputModifierNode extends DelegatableNode {
    void onCancelIndirectPointerInput();

    void onIndirectPointerEvent(StatusLine statusLine, PointerEventPass pointerEventPass);
}
