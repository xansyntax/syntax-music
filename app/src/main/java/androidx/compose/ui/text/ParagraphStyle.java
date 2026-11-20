package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphStyle implements AnnotatedString.Annotation {
    public final int hyphens;
    public final int lineBreak;
    public final long lineHeight;
    public final LineHeightStyle lineHeightStyle;
    public final PlatformParagraphStyle platformStyle;
    public final int textAlign;
    public final int textDirection;
    public final TextIndent textIndent;
    public final TextMotion textMotion;

    public ParagraphStyle(int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        this.textAlign = i;
        this.textDirection = i2;
        this.lineHeight = j;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        this.lineBreak = i3;
        this.hyphens = i4;
        this.textMotion = textMotion;
        if (TextUnit.m812equalsimpl0(j, IntMath.pack(0L, Float.NaN))) {
            return;
        }
        if (TextUnit.m814getValueimpl(j) >= CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("lineHeight can't be negative (" + TextUnit.m814getValueimpl(j) + ")");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return this.textAlign == paragraphStyle.textAlign && this.textDirection == paragraphStyle.textDirection && TextUnit.m812equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual(this.textIndent, paragraphStyle.textIndent) && Intrinsics.areEqual(this.platformStyle, paragraphStyle.platformStyle) && Intrinsics.areEqual(this.lineHeightStyle, paragraphStyle.lineHeightStyle) && this.lineBreak == paragraphStyle.lineBreak && this.hyphens == paragraphStyle.hyphens && Intrinsics.areEqual(this.textMotion, paragraphStyle.textMotion);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.textDirection, Integer.hashCode(this.textAlign) * 31, 31), 31, this.lineHeight);
        TextIndent textIndent = this.textIndent;
        int iHashCode = (iM + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int iHashCode2 = (iHashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(this.hyphens, IntIntPair$$ExternalSyntheticOutline0.m(this.lineBreak, (iHashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0)) * 31, 31), 31);
        TextMotion textMotion = this.textMotion;
        return iM2 + (textMotion != null ? textMotion.hashCode() : 0);
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        return paragraphStyle == null ? this : ParagraphStyleKt.m733fastMergej5T8yCg(this, paragraphStyle.textAlign, paragraphStyle.textDirection, paragraphStyle.lineHeight, paragraphStyle.textIndent, paragraphStyle.platformStyle, paragraphStyle.lineHeightStyle, paragraphStyle.lineBreak, paragraphStyle.hyphens, paragraphStyle.textMotion);
    }

    public final String toString() {
        String strM774toStringimpl = TextAlign.m774toStringimpl(this.textAlign);
        String strM775toStringimpl = TextDirection.m775toStringimpl(this.textDirection);
        String strM815toStringimpl = TextUnit.m815toStringimpl(this.lineHeight);
        String strM770toStringimpl = LineBreak.m770toStringimpl(this.lineBreak);
        String strM769toStringimpl = Hyphens.m769toStringimpl(this.hyphens);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ParagraphStyle(textAlign=", strM774toStringimpl, ", textDirection=", strM775toStringimpl, ", lineHeight=");
        sbM.append(strM815toStringimpl);
        sbM.append(", textIndent=");
        sbM.append(this.textIndent);
        sbM.append(", platformStyle=");
        sbM.append(this.platformStyle);
        sbM.append(", lineHeightStyle=");
        sbM.append(this.lineHeightStyle);
        sbM.append(", lineBreak=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, strM770toStringimpl, ", hyphens=", strM769toStringimpl, ", textMotion=");
        sbM.append(this.textMotion);
        sbM.append(")");
        return sbM.toString();
    }
}
