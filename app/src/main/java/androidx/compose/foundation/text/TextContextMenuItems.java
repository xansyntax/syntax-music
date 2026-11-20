package androidx.compose.foundation.text;

import android.R;
import android.os.Build;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum TextContextMenuItems {
    /* JADX INFO: Fake field, exist only in values array */
    Cut(TextContextMenuKeys.CutKey, R.string.cut, R.attr.actionModeCutDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    Copy(TextContextMenuKeys.CopyKey, R.string.copy, R.attr.actionModeCopyDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    Paste(TextContextMenuKeys.PasteKey, R.string.paste, R.attr.actionModePasteDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    SelectAll(TextContextMenuKeys.SelectAllKey, R.string.selectAll, R.attr.actionModeSelectAllDrawable),
    Autofill(TextContextMenuKeys.AutofillKey, Build.VERSION.SDK_INT <= 26 ? com.yalantis.ucrop.R.string.androidx_compose_foundation_autofill : R.string.autofill, 0);

    public final int drawableId;
    public final Object key;
    public final int stringId;

    TextContextMenuItems(Object obj, int i, int i2) {
        this.key = obj;
        this.stringId = i;
        this.drawableId = i2;
    }
}
