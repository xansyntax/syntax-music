package androidx.emoji2.text;

import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultGlyphChecker {
    public static final ThreadLocal sStringBuilder = new ThreadLocal();
    public final TextPaint mTextPaint;

    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
