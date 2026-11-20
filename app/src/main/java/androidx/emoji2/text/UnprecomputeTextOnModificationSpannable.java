package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.collection.internal.Lock;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnprecomputeTextOnModificationSpannable implements Spannable {
    public Spannable mDelegate;
    public boolean mSafeToWrite = false;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PrecomputedTextDetector_28 extends Lock {
        @Override // androidx.collection.internal.Lock
        public final boolean isPrecomputedText(CharSequence charSequence) {
            return charSequence instanceof PrecomputedText;
        }
    }

    public UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.mDelegate = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.mDelegate.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.mDelegate.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.mDelegate.codePoints();
    }

    public final void ensureSafeWrites() {
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite) {
            if ((Build.VERSION.SDK_INT < 28 ? new Lock((byte) 16) : new PrecomputedTextDetector_28((byte) 16)).isPrecomputedText(spannable)) {
                this.mDelegate = new SpannableString(spannable);
            }
        }
        this.mSafeToWrite = true;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i2, Class cls) {
        return this.mDelegate.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.mDelegate.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.mDelegate.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.mDelegate.toString();
    }
}
