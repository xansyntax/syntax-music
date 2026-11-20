package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpanStyle implements AnnotatedString.Annotation {
    public final long background;
    public final BaselineShift baselineShift;
    public final DrawStyle drawStyle;
    public final FontFamily fontFamily;
    public final String fontFeatureSettings;
    public final long fontSize;
    public final FontStyle fontStyle;
    public final FontSynthesis fontSynthesis;
    public final FontWeight fontWeight;
    public final long letterSpacing;
    public final LocaleList localeList;
    public final PlatformSpanStyle platformStyle;
    public final Shadow shadow;
    public final TextDecoration textDecoration;
    public final TextForegroundStyle textForegroundStyle;
    public final TextGeometricTransform textGeometricTransform;

    public SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, int i) {
        this((i & 1) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j, (i & 2) != 0 ? IntMath.pack(0L, Float.NaN) : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? IntMath.pack(0L, Float.NaN) : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & 1024) != 0 ? null : localeList, (i & 2048) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j4, (i & 4096) != 0 ? null : textDecoration, (i & 8192) != 0 ? null : shadow, (PlatformSpanStyle) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        return hasSameLayoutAffectingAttributes$ui_text(spanStyle) && hasSameNonLayoutAttributes$ui_text(spanStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text(SpanStyle spanStyle) {
        if (this == spanStyle) {
            return true;
        }
        return TextUnit.m812equalsimpl0(this.fontSize, spanStyle.fontSize) && Intrinsics.areEqual(this.fontWeight, spanStyle.fontWeight) && Intrinsics.areEqual(this.fontStyle, spanStyle.fontStyle) && Intrinsics.areEqual(this.fontSynthesis, spanStyle.fontSynthesis) && Intrinsics.areEqual(this.fontFamily, spanStyle.fontFamily) && Intrinsics.areEqual(this.fontFeatureSettings, spanStyle.fontFeatureSettings) && TextUnit.m812equalsimpl0(this.letterSpacing, spanStyle.letterSpacing) && Intrinsics.areEqual(this.baselineShift, spanStyle.baselineShift) && Intrinsics.areEqual(this.textGeometricTransform, spanStyle.textGeometricTransform) && Intrinsics.areEqual(this.localeList, spanStyle.localeList) && ULong.m1869equalsimpl0(this.background, spanStyle.background) && Intrinsics.areEqual(this.platformStyle, spanStyle.platformStyle);
    }

    public final boolean hasSameNonLayoutAttributes$ui_text(SpanStyle spanStyle) {
        return Intrinsics.areEqual(this.textForegroundStyle, spanStyle.textForegroundStyle) && Intrinsics.areEqual(this.textDecoration, spanStyle.textDecoration) && Intrinsics.areEqual(this.shadow, spanStyle.shadow) && Intrinsics.areEqual(this.drawStyle, spanStyle.drawStyle);
    }

    public final int hashCode() {
        TextForegroundStyle textForegroundStyle = this.textForegroundStyle;
        int iHashCode = Long.hashCode(textForegroundStyle.mo768getColor0d7_KjU()) * 31;
        Brush brush = textForegroundStyle.getBrush();
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((Float.hashCode(textForegroundStyle.getAlpha()) + ((iHashCode + (brush != null ? brush.hashCode() : 0)) * 31)) * 31, 31, this.fontSize);
        FontWeight fontWeight = this.fontWeight;
        int i = (iM + (fontWeight != null ? fontWeight.weight : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int iHashCode2 = (i + (fontStyle != null ? Integer.hashCode(fontStyle.value) : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        int iHashCode3 = (iHashCode2 + (fontSynthesis != null ? Integer.hashCode(fontSynthesis.value) : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int iHashCode4 = (iHashCode3 + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31, 31, this.letterSpacing);
        BaselineShift baselineShift = this.baselineShift;
        int iHashCode5 = (iM2 + (baselineShift != null ? Float.hashCode(baselineShift.multiplier) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        int iHashCode6 = (iHashCode5 + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.localeList;
        int iM3 = IntIntPair$$ExternalSyntheticOutline0.m((iHashCode6 + (localeList != null ? localeList.localeList.hashCode() : 0)) * 31, 31, this.background);
        TextDecoration textDecoration = this.textDecoration;
        int i2 = (iM3 + (textDecoration != null ? textDecoration.mask : 0)) * 31;
        Shadow shadow = this.shadow;
        int iHashCode7 = (i2 + (shadow != null ? shadow.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        int iHashCode8 = (iHashCode7 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31;
        DrawStyle drawStyle = this.drawStyle;
        return iHashCode8 + (drawStyle != null ? drawStyle.hashCode() : 0);
    }

    public final SpanStyle merge(SpanStyle spanStyle) {
        if (spanStyle == null) {
            return this;
        }
        TextForegroundStyle textForegroundStyle = spanStyle.textForegroundStyle;
        return SpanStyleKt.m734fastMergedSHsh3o(this, textForegroundStyle.mo768getColor0d7_KjU(), textForegroundStyle.getBrush(), textForegroundStyle.getAlpha(), spanStyle.fontSize, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, spanStyle.fontFamily, spanStyle.fontFeatureSettings, spanStyle.letterSpacing, spanStyle.baselineShift, spanStyle.textGeometricTransform, spanStyle.localeList, spanStyle.background, spanStyle.textDecoration, spanStyle.shadow, spanStyle.platformStyle, spanStyle.drawStyle);
    }

    public final String toString() {
        TextForegroundStyle textForegroundStyle = this.textForegroundStyle;
        String strM486toStringimpl = Color.m486toStringimpl(textForegroundStyle.mo768getColor0d7_KjU());
        Brush brush = textForegroundStyle.getBrush();
        float alpha = textForegroundStyle.getAlpha();
        String strM815toStringimpl = TextUnit.m815toStringimpl(this.fontSize);
        String strM815toStringimpl2 = TextUnit.m815toStringimpl(this.letterSpacing);
        String strM486toStringimpl2 = Color.m486toStringimpl(this.background);
        StringBuilder sb = new StringBuilder("SpanStyle(color=");
        sb.append(strM486toStringimpl);
        sb.append(", brush=");
        sb.append(brush);
        sb.append(", alpha=");
        sb.append(alpha);
        sb.append(", fontSize=");
        sb.append(strM815toStringimpl);
        sb.append(", fontWeight=");
        sb.append(this.fontWeight);
        sb.append(", fontStyle=");
        sb.append(this.fontStyle);
        sb.append(", fontSynthesis=");
        sb.append(this.fontSynthesis);
        sb.append(", fontFamily=");
        sb.append(this.fontFamily);
        sb.append(", fontFeatureSettings=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.fontFeatureSettings, ", letterSpacing=", strM815toStringimpl2, ", baselineShift=");
        sb.append(this.baselineShift);
        sb.append(", textGeometricTransform=");
        sb.append(this.textGeometricTransform);
        sb.append(", localeList=");
        sb.append(this.localeList);
        sb.append(", background=");
        sb.append(strM486toStringimpl2);
        sb.append(", textDecoration=");
        sb.append(this.textDecoration);
        sb.append(", shadow=");
        sb.append(this.shadow);
        sb.append(", platformStyle=");
        sb.append(this.platformStyle);
        sb.append(", drawStyle=");
        sb.append(this.drawStyle);
        sb.append(")");
        return sb.toString();
    }

    public SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle) {
        TextForegroundStyle colorStyle;
        if (j != 16) {
            colorStyle = new ColorStyle(j);
        } else {
            colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
        }
        this(colorStyle, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, null);
    }

    public SpanStyle(LinearGradient linearGradient, FontWeight fontWeight, int i) {
        this(new BrushStyle(linearGradient, Float.NaN), IntMath.pack(0L, Float.NaN), (i & 8) != 0 ? null : fontWeight, null, null, null, null, IntMath.pack(0L, Float.NaN), null, null, null, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), null, Shadow.None, null, null);
    }

    public SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this.textForegroundStyle = textForegroundStyle;
        this.fontSize = j;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j2;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j3;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
        this.platformStyle = platformSpanStyle;
        this.drawStyle = drawStyle;
    }
}
