package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/key/KeyInputNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class KeyInputElement extends ModifierNodeElement {
    public final Function1 onKeyEvent;
    public final Function1 onPreKeyEvent;

    public KeyInputElement(Function1 function1, Function1 function2) {
        this.onKeyEvent = function1;
        this.onPreKeyEvent = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        KeyInputNode keyInputNode = new KeyInputNode();
        keyInputNode.onEvent = this.onKeyEvent;
        keyInputNode.onPreEvent = this.onPreKeyEvent;
        return keyInputNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return this.onKeyEvent == keyInputElement.onKeyEvent && this.onPreKeyEvent == keyInputElement.onPreKeyEvent;
    }

    public final int hashCode() {
        Function1 function1 = this.onKeyEvent;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function2 = this.onPreKeyEvent;
        return iHashCode + (function2 != null ? function2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        KeyInputNode keyInputNode = (KeyInputNode) node;
        keyInputNode.onEvent = this.onKeyEvent;
        keyInputNode.onPreEvent = this.onPreKeyEvent;
    }
}
