package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiInputFilter implements InputFilter {
    public InitCallbackImpl mInitCallback;
    public final TextView mTextView;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InitCallbackImpl extends EmojiCompat.InitCallback implements Runnable {
        public final WeakReference mEmojiInputFilterReference;
        public final WeakReference mViewRef;

        public InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.mViewRef = new WeakReference(textView);
            this.mEmojiInputFilterReference = new WeakReference(emojiInputFilter);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onInitialized() {
            Handler handler;
            TextView textView = (TextView) this.mViewRef.get();
            if (textView == null || (handler = textView.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            InputFilter[] filters;
            int length;
            TextView textView = (TextView) this.mViewRef.get();
            InputFilter inputFilter = (InputFilter) this.mEmojiInputFilterReference.get();
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (textView.isAttachedToWindow()) {
                        CharSequence text = textView.getText();
                        EmojiCompat emojiCompat = EmojiCompat.get();
                        if (text == null) {
                            length = 0;
                        } else {
                            emojiCompat.getClass();
                            length = text.length();
                        }
                        CharSequence charSequenceProcess = emojiCompat.process(0, length, 0, text);
                        if (text == charSequenceProcess) {
                            return;
                        }
                        int selectionStart = Selection.getSelectionStart(charSequenceProcess);
                        int selectionEnd = Selection.getSelectionEnd(charSequenceProcess);
                        textView.setText(charSequenceProcess);
                        if (charSequenceProcess instanceof Spannable) {
                            Spannable spannable = (Spannable) charSequenceProcess;
                            if (selectionStart >= 0 && selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionStart, selectionEnd);
                                return;
                            } else if (selectionStart >= 0) {
                                Selection.setSelection(spannable, selectionStart);
                                return;
                            } else {
                                if (selectionEnd >= 0) {
                                    Selection.setSelection(spannable, selectionEnd);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public EmojiInputFilter(TextView textView) {
        this.mTextView = textView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r1 != 3) goto L27;
     */
    @Override // android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.mTextView;
        if (!textView.isInEditMode()) {
            int loadState = EmojiCompat.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    if ((i4 != 0 || i3 != 0 || spanned.length() != 0 || charSequence != textView.getText()) && charSequence != null) {
                        if (i != 0 || i2 != charSequence.length()) {
                            charSequence = charSequence.subSequence(i, i2);
                        }
                        return EmojiCompat.get().process(0, charSequence.length(), 0, charSequence);
                    }
                }
            }
            EmojiCompat emojiCompat = EmojiCompat.get();
            InitCallbackImpl initCallbackImpl = this.mInitCallback;
            if (initCallbackImpl == null) {
                initCallbackImpl = new InitCallbackImpl(textView, this);
                this.mInitCallback = initCallbackImpl;
            }
            emojiCompat.registerInitCallback(initCallbackImpl);
            return charSequence;
        }
        return charSequence;
    }
}
