package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaceholderSpan extends ReplacementSpan {
    public Paint.FontMetricsInt fontMetrics;
    public boolean isLaidOut;

    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        throw null;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        this.isLaidOut = true;
        paint.getTextSize();
        this.fontMetrics = paint.getFontMetricsInt();
        if (getFontMetrics().descent <= getFontMetrics().ascent) {
            InlineClassHelperKt.throwIllegalArgumentException("Invalid fontMetrics: line height can not be negative.");
        }
        throw null;
    }

    public final int getWidthPx() {
        if (this.isLaidOut) {
            return 0;
        }
        InlineClassHelperKt.throwIllegalStateException("PlaceholderSpan is not laid out yet.");
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
    }
}
