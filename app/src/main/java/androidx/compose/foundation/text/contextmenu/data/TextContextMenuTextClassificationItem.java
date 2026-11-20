package androidx.compose.foundation.text.contextmenu.data;

import android.graphics.drawable.Drawable;
import android.view.textclassifier.TextClassification;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuTextClassificationItem extends TextContextMenuComponent {
    public final Drawable icon;
    public final int index;
    public final TextClassification textClassification;

    public TextContextMenuTextClassificationItem(Object obj, TextClassification textClassification, int i, Drawable drawable) {
        super(obj);
        this.textClassification = textClassification;
        this.index = i;
        this.icon = drawable;
    }

    public final String toString() {
        return "TextContextMenuTextClassificationItem(key=" + this.key + ", textClassification=" + this.textClassification + ", index=" + this.index + ", icon=" + this.icon + ")";
    }
}
