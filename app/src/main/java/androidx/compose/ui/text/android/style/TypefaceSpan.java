package androidx.compose.ui.text.android.style;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceSpan extends MetricAffectingSpan {
    public final /* synthetic */ byte $r8$classId;
    public final Object typeface;

    public /* synthetic */ TypefaceSpan(byte b, Object obj) {
        this.$r8$classId = b;
        this.typeface = obj;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        byte b = this.$r8$classId;
        Object obj = this.typeface;
        switch (b) {
            case 0:
                textPaint.setTypeface((Typeface) obj);
                break;
            default:
                textPaint.setFontFeatureSettings((String) obj);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        byte b = this.$r8$classId;
        Object obj = this.typeface;
        switch (b) {
            case 0:
                textPaint.setTypeface((Typeface) obj);
                break;
            default:
                textPaint.setFontFeatureSettings((String) obj);
                break;
        }
    }
}
