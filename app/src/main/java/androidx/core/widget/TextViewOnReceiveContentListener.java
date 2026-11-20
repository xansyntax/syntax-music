package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ContentInfoCompat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewOnReceiveContentListener {
    public static ContentInfoCompat onReceiveContent(AppCompatEditText appCompatEditText, ContentInfoCompat contentInfoCompat) {
        CharSequence charSequenceCoerceToStyledText;
        if (Log.isLoggable("ReceiveContent", 3)) {
            Objects.toString(contentInfoCompat);
        }
        ContentInfoCompat.Compat compat = contentInfoCompat.mCompat;
        if (compat.getSource() == 2) {
            return contentInfoCompat;
        }
        ClipData clip = compat.getClip();
        int flags = compat.getFlags();
        Editable editable = (Editable) appCompatEditText.getText();
        Context context = appCompatEditText.getContext();
        boolean z = false;
        for (int i = 0; i < clip.getItemCount(); i++) {
            ClipData.Item itemAt = clip.getItemAt(i);
            if ((flags & 1) != 0) {
                charSequenceCoerceToStyledText = itemAt.coerceToText(context);
                if (charSequenceCoerceToStyledText instanceof Spanned) {
                    charSequenceCoerceToStyledText = charSequenceCoerceToStyledText.toString();
                }
            } else {
                charSequenceCoerceToStyledText = itemAt.coerceToStyledText(context);
            }
            if (charSequenceCoerceToStyledText != null) {
                if (z) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceCoerceToStyledText);
                } else {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, iMax2);
                    editable.replace(iMax, iMax2, charSequenceCoerceToStyledText);
                    z = true;
                }
            }
        }
        return null;
    }
}
