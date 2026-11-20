package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SkewXSpan extends MetricAffectingSpan {
    public final /* synthetic */ byte $r8$classId;
    public final float skewX;

    public /* synthetic */ SkewXSpan(float f, byte b) {
        this.$r8$classId = b;
        this.skewX = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        byte b = this.$r8$classId;
        float f = this.skewX;
        switch (b) {
            case 0:
                textPaint.setTextSkewX(textPaint.getTextSkewX() + f);
                break;
            default:
                textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * f);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        byte b = this.$r8$classId;
        float f = this.skewX;
        switch (b) {
            case 0:
                textPaint.setTextSkewX(textPaint.getTextSkewX() + f);
                break;
            default:
                textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * f);
                break;
        }
    }
}
