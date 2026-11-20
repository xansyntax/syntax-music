package androidx.emoji2.viewsintegration;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiInputConnection extends InputConnectionWrapper {
    public final TextView mTextView;

    public EmojiInputConnection(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        super(inputConnection, false);
        this.mTextView = textView;
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        return EmojiProcessor.handleDeleteSurroundingText(this, this.mTextView.getEditableText(), i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return EmojiProcessor.handleDeleteSurroundingText(this, this.mTextView.getEditableText(), i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
