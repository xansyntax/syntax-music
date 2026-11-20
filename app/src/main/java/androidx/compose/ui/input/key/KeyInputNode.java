package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInputNode extends Modifier.Node implements KeyInputModifierNode {
    public Function1 onEvent;
    public Function1 onPreEvent;

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public final boolean mo26onKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Function1 function1 = this.onEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(new KeyEvent(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public final boolean mo28onPreKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Function1 function1 = this.onPreEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(new KeyEvent(keyEvent))).booleanValue();
        }
        return false;
    }
}
