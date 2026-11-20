package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LetterSpacingSpanPx extends MetricAffectingSpan {
    public final float letterSpacing;

    public LetterSpacingSpanPx(float f) {
        this.letterSpacing = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        float textScaleX = textPaint.getTextScaleX() * textPaint.getTextSize();
        if (textScaleX == CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        textPaint.setLetterSpacing(this.letterSpacing / textScaleX);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        float textScaleX = textPaint.getTextScaleX() * textPaint.getTextSize();
        if (textScaleX == CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        textPaint.setLetterSpacing(this.letterSpacing / textScaleX);
    }
}
