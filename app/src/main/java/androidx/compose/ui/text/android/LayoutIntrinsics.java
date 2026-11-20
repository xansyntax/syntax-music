package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutIntrinsics {
    public BoringLayout.Metrics _boringMetrics;
    public CharSequence _charSequenceForIntrinsicWidth;
    public float _maxIntrinsicWidth = Float.NaN;
    public float _minIntrinsicWidth = Float.NaN;
    public boolean boringMetricsIsInit;
    public final CharSequence charSequence;
    public final int textDirectionHeuristic;
    public final TextPaint textPaint;

    public LayoutIntrinsics(CharSequence charSequence, TextPaint textPaint, int i) {
        this.charSequence = charSequence;
        this.textPaint = textPaint;
        this.textDirectionHeuristic = i;
    }

    public final BoringLayout.Metrics getBoringMetrics() {
        BoringLayout.Metrics metricsIsBoring;
        if (!this.boringMetricsIsInit) {
            TextDirectionHeuristic textDirectionHeuristic = TextLayout_androidKt.getTextDirectionHeuristic(this.textDirectionHeuristic);
            int i = Build.VERSION.SDK_INT;
            CharSequence charSequence = this.charSequence;
            TextPaint textPaint = this.textPaint;
            if (i >= 33) {
                metricsIsBoring = BoringLayoutFactory33.isBoring(charSequence, textPaint, textDirectionHeuristic);
            } else {
                metricsIsBoring = !textDirectionHeuristic.isRtl(charSequence, 0, charSequence.length()) ? BoringLayout.isBoring(charSequence, textPaint, null) : null;
            }
            this._boringMetrics = metricsIsBoring;
            this.boringMetricsIsInit = true;
        }
        return this._boringMetrics;
    }

    public final CharSequence getCharSequenceForIntrinsicWidth() {
        CharSequence charSequence = this._charSequenceForIntrinsicWidth;
        if (charSequence != null) {
            charSequence.getClass();
            return charSequence;
        }
        CharSequence charSequence2 = this.charSequence;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            if (StaticLayoutFactory.hasSpan(spanned, CharacterStyle.class)) {
                CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, charSequence2.length(), CharacterStyle.class);
                if (characterStyleArr != null && characterStyleArr.length != 0) {
                    SpannableString spannableString = null;
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        if (!(characterStyle instanceof MetricAffectingSpan)) {
                            if (spannableString == null) {
                                spannableString = new SpannableString(charSequence2);
                            }
                            spannableString.removeSpan(characterStyle);
                        }
                    }
                    if (spannableString != null) {
                        charSequence2 = spannableString;
                    }
                }
            }
        }
        this._charSequenceForIntrinsicWidth = charSequence2;
        return charSequence2;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0051  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    public final float getMaxIntrinsicWidth() {
        if (!Float.isNaN(this._maxIntrinsicWidth)) {
            return this._maxIntrinsicWidth;
        }
        BoringLayout.Metrics boringMetrics = getBoringMetrics();
        float fCeil = boringMetrics != null ? boringMetrics.width : -1;
        TextPaint textPaint = this.textPaint;
        if (fCeil < CropImageView.DEFAULT_ASPECT_RATIO) {
            fCeil = (float) Math.ceil(Layout.getDesiredWidth(getCharSequenceForIntrinsicWidth(), 0, getCharSequenceForIntrinsicWidth().length(), textPaint));
        }
        if (fCeil != CropImageView.DEFAULT_ASPECT_RATIO) {
            CharSequence charSequence = this.charSequence;
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (StaticLayoutFactory.hasSpan(spanned, LetterSpacingSpanPx.class) || StaticLayoutFactory.hasSpan(spanned, LetterSpacingSpanEm.class)) {
                    fCeil += 0.5f;
                } else if (textPaint.getLetterSpacing() != CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCeil += 0.5f;
                }
            } else if (textPaint.getLetterSpacing() != CropImageView.DEFAULT_ASPECT_RATIO) {
                fCeil += 0.5f;
            }
        }
        this._maxIntrinsicWidth = fCeil;
        return fCeil;
    }
}
