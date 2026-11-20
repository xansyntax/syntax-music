package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Constraints;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheTextLayoutInput {
    public final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput) {
        this.textLayoutInput = textLayoutInput;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        AnnotatedString annotatedString = textLayoutInput.text;
        TextLayoutInput textLayoutInput2 = ((CacheTextLayoutInput) obj).textLayoutInput;
        return Intrinsics.areEqual(annotatedString, textLayoutInput2.text) && textLayoutInput.style.hasSameLayoutAffectingAttributes(textLayoutInput2.style) && Intrinsics.areEqual(textLayoutInput.placeholders, textLayoutInput2.placeholders) && textLayoutInput.maxLines == textLayoutInput2.maxLines && textLayoutInput.softWrap == textLayoutInput2.softWrap && textLayoutInput.overflow == textLayoutInput2.overflow && Intrinsics.areEqual(textLayoutInput.density, textLayoutInput2.density) && textLayoutInput.layoutDirection == textLayoutInput2.layoutDirection && textLayoutInput.fontFamilyResolver == textLayoutInput2.fontFamilyResolver && Constraints.m778equalsimpl0(textLayoutInput.constraints, textLayoutInput2.constraints);
    }

    public final int hashCode() {
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        int iHashCode = textLayoutInput.text.hashCode() * 31;
        TextStyle textStyle = textLayoutInput.style;
        SpanStyle spanStyle = textStyle.spanStyle;
        int iHashCode2 = Long.hashCode(spanStyle.fontSize) * 31;
        FontWeight fontWeight = spanStyle.fontWeight;
        int i = (iHashCode2 + (fontWeight != null ? fontWeight.weight : 0)) * 31;
        FontStyle fontStyle = spanStyle.fontStyle;
        int iHashCode3 = (i + (fontStyle != null ? Integer.hashCode(fontStyle.value) : 0)) * 31;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        int iHashCode4 = (iHashCode3 + (fontSynthesis != null ? Integer.hashCode(fontSynthesis.value) : 0)) * 31;
        FontFamily fontFamily = spanStyle.fontFamily;
        int iHashCode5 = (iHashCode4 + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = spanStyle.fontFeatureSettings;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode5 + (str != null ? str.hashCode() : 0)) * 31, 31, spanStyle.letterSpacing);
        BaselineShift baselineShift = spanStyle.baselineShift;
        int iHashCode6 = (iM + (baselineShift != null ? Float.hashCode(baselineShift.multiplier) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        int iHashCode7 = (iHashCode6 + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = spanStyle.localeList;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode7 + (localeList != null ? localeList.localeList.hashCode() : 0)) * 31, 31, spanStyle.background);
        PlatformSpanStyle platformSpanStyle = spanStyle.platformStyle;
        int iHashCode8 = (textStyle.paragraphStyle.hashCode() + ((iM2 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31)) * 31;
        PlatformTextStyle platformTextStyle = textStyle.platformStyle;
        return Long.hashCode(textLayoutInput.constraints) + ((textLayoutInput.fontFamilyResolver.hashCode() + ((textLayoutInput.layoutDirection.hashCode() + ((textLayoutInput.density.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(textLayoutInput.overflow, IntIntPair$$ExternalSyntheticOutline0.m((Fragment$5$$ExternalSyntheticOutline0.m((iHashCode8 + (platformTextStyle != null ? platformTextStyle.hashCode() : 0) + iHashCode) * 31, 31, textLayoutInput.placeholders) + textLayoutInput.maxLines) * 31, textLayoutInput.softWrap, 31), 31)) * 31)) * 31)) * 31);
    }
}
