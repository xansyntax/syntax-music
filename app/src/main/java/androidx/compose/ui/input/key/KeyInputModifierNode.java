package androidx.compose.ui.input.key;

import androidx.compose.ui.node.DelegatableNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface KeyInputModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    boolean mo26onKeyEventZmokQxo(android.view.KeyEvent keyEvent);

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    boolean mo28onPreKeyEventZmokQxo(android.view.KeyEvent keyEvent);
}
