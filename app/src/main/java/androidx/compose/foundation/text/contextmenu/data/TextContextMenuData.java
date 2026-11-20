package androidx.compose.foundation.text.contextmenu.data;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuData {
    public static final TextContextMenuData Empty = new TextContextMenuData(EmptyList.INSTANCE);
    public final List components;

    public TextContextMenuData(List list) {
        this.components = list;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("TextContextMenuData(components=", ListUtilsKt.fastJoinToString$default(this.components, "\n\t", null, 56), ")");
    }
}
