package androidx.compose.foundation.text.contextmenu.data;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuItem extends TextContextMenuComponent {
    public final String label;
    public final int leadingIcon;
    public final Function1 onClick;

    public TextContextMenuItem(Object obj, String str, int i, Function1 function1) {
        super(obj);
        this.label = str;
        this.leadingIcon = i;
        this.onClick = function1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextContextMenuItem(key=");
        sb.append(this.key);
        sb.append(", label=\"");
        sb.append(this.label);
        sb.append("\", leadingIcon=");
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.leadingIcon, ")");
    }
}
