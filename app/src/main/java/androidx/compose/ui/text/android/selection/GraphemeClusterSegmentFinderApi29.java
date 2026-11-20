package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
import coil3.util.LifecyclesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphemeClusterSegmentFinderApi29 extends LifecyclesKt {
    public final CharSequence text;
    public final TextPaint textPaint;

    public GraphemeClusterSegmentFinderApi29(CharSequence charSequence, TextPaint textPaint) {
        this.text = charSequence;
        this.textPaint = textPaint;
    }

    @Override // coil3.util.LifecyclesKt
    public final int next(int i) {
        CharSequence charSequence = this.text;
        return this.textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 0);
    }

    @Override // coil3.util.LifecyclesKt
    public final int previous(int i) {
        CharSequence charSequence = this.text;
        return this.textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 2);
    }
}
