package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiCompat;
import coil3.util.FileSystemsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatEmojiTextHelper {
    public final AtomicInt mEmojiTextViewHelper;
    public final TextView mView;

    public AppCompatEmojiTextHelper(final TextView textView) {
        this.mView = textView;
        AtomicInt atomicInt = new AtomicInt();
        atomicInt.delegate = new FileSystemsKt(textView) { // from class: androidx.emoji2.viewsintegration.EmojiTextViewHelper$SkippingHelper19
            public final EmojiTextViewHelper$HelperInternal19 mHelperDelegate;

            {
                this.mHelperDelegate = new EmojiTextViewHelper$HelperInternal19(textView);
            }

            @Override // coil3.util.FileSystemsKt
            public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
                return !EmojiCompat.isConfigured() ? inputFilterArr : this.mHelperDelegate.getFilters(inputFilterArr);
            }

            @Override // coil3.util.FileSystemsKt
            public final boolean isEnabled() {
                return this.mHelperDelegate.mEnabled;
            }

            @Override // coil3.util.FileSystemsKt
            public final void setAllCaps(boolean z) {
                if (EmojiCompat.isConfigured()) {
                    this.mHelperDelegate.setAllCaps(z);
                }
            }

            @Override // coil3.util.FileSystemsKt
            public final void setEnabled(boolean z) {
                boolean zIsConfigured = EmojiCompat.isConfigured();
                EmojiTextViewHelper$HelperInternal19 emojiTextViewHelper$HelperInternal19 = this.mHelperDelegate;
                if (zIsConfigured) {
                    emojiTextViewHelper$HelperInternal19.setEnabled(z);
                } else {
                    emojiTextViewHelper$HelperInternal19.mEnabled = z;
                }
            }
        };
        this.mEmojiTextViewHelper = atomicInt;
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setAllCaps(boolean z) {
        ((FileSystemsKt) this.mEmojiTextViewHelper.delegate).setAllCaps(z);
    }

    public final void setEnabled(boolean z) {
        ((FileSystemsKt) this.mEmojiTextViewHelper.delegate).setEnabled(z);
    }
}
