package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public final int endIndex;
    public int firstAscentDiff;
    public int lastDescentDiff;
    public final float lineHeight;
    public final int mode;
    public final float topRatio;
    public final boolean trimFirstLineTop;
    public final boolean trimLastLineBottom;
    public int firstAscent = Integer.MIN_VALUE;
    public int ascent = Integer.MIN_VALUE;
    public int descent = Integer.MIN_VALUE;
    public int lastDescent = Integer.MIN_VALUE;

    public LineHeightStyleSpan(float f, int i, boolean z, boolean z2, float f2, int i2) {
        this.lineHeight = f;
        this.endIndex = i;
        this.trimFirstLineTop = z;
        this.trimLastLineBottom = z2;
        this.topRatio = f2;
        this.mode = i2;
        if ((CropImageView.DEFAULT_ASPECT_RATIO > f2 || f2 > 1.0f) && f2 != -1.0f) {
            InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
        }
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        double dCeil;
        int i5 = fontMetricsInt.descent;
        int i6 = fontMetricsInt.ascent;
        if (i5 - i6 <= 0) {
            return;
        }
        boolean z = i == 0;
        boolean z2 = i2 == this.endIndex;
        int i7 = this.mode;
        boolean z3 = this.trimLastLineBottom;
        boolean z4 = this.trimFirstLineTop;
        if (z && z2 && z4 && z3 && i7 != 2) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            int i8 = i5 - i6;
            int iCeil = (int) Math.ceil(this.lineHeight);
            int i9 = iCeil - i8;
            if (i7 != 1 || i9 > 0) {
                float fAbs = this.topRatio;
                if (fAbs == -1.0f) {
                    fAbs = Math.abs(fontMetricsInt.ascent) / (fontMetricsInt.descent - fontMetricsInt.ascent);
                }
                if (i9 <= 0) {
                    dCeil = Math.ceil(i9 * fAbs);
                } else {
                    dCeil = Math.ceil((1.0f - fAbs) * i9);
                }
                int i10 = (int) dCeil;
                int i11 = fontMetricsInt.descent;
                int i12 = i10 + i11;
                this.descent = i12;
                int i13 = i12 - iCeil;
                this.ascent = i13;
                if (i7 == 0 || i9 >= 0) {
                    if (z4) {
                        i13 = fontMetricsInt.ascent;
                    }
                    this.firstAscent = i13;
                    if (z3) {
                        i12 = i11;
                    }
                    this.lastDescent = i12;
                    this.firstAscentDiff = fontMetricsInt.ascent - i13;
                    this.lastDescentDiff = i12 - i11;
                } else if (i7 == 2) {
                    int i14 = fontMetricsInt.ascent;
                    this.firstAscent = z4 ? Math.max(i14, i13) : Math.min(i14, i13);
                    int i15 = fontMetricsInt.descent;
                    int i16 = this.descent;
                    this.lastDescent = z3 ? Math.min(i15, i16) : Math.max(i15, i16);
                    this.firstAscentDiff = 0;
                    this.lastDescentDiff = 0;
                }
            } else {
                int i17 = fontMetricsInt.ascent;
                this.ascent = i17;
                int i18 = fontMetricsInt.descent;
                this.descent = i18;
                this.firstAscent = i17;
                this.lastDescent = i18;
                this.firstAscentDiff = 0;
                this.lastDescentDiff = 0;
            }
        }
        fontMetricsInt.ascent = z ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z2 ? this.lastDescent : this.descent;
    }
}
