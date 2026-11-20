package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextStyle {
    public static final TextStyle Default = new TextStyle(0, 0, null, null, null, 0, 0, 0, null, null, 16777215);
    public final ParagraphStyle paragraphStyle;
    public final PlatformTextStyle platformStyle;
    public final SpanStyle spanStyle;

    /* JADX WARN: Illegal instructions before constructor call */
    public TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontFamily fontFamily, long j3, int i, long j4, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i2) {
        long jColor = (i2 & 1) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j;
        long jPack = (i2 & 2) != 0 ? IntMath.pack(0L, Float.NaN) : j2;
        FontWeight fontWeight2 = (i2 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i2 & 8) != 0 ? null : fontStyle;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? null : fontFamily;
        long jPack2 = (i2 & 128) != 0 ? IntMath.pack(0L, Float.NaN) : j3;
        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
        int i3 = (32768 & i2) != 0 ? 0 : i;
        long jPack3 = (131072 & i2) != 0 ? IntMath.pack(0L, Float.NaN) : j4;
        PlatformTextStyle platformTextStyle2 = (524288 & i2) != 0 ? null : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i2 & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? null : lineHeightStyle;
        this(new SpanStyle(jColor, jPack, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, jPack2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, jColor2, (TextDecoration) null, (Shadow) null, platformTextStyle2 != null ? platformTextStyle2.spanStyle : null), new ParagraphStyle(i3, 0, jPack3, null, platformTextStyle2 != null ? platformTextStyle2.paragraphStyle : null, lineHeightStyle2, 0, 0, null), platformTextStyle2);
    }

    /* JADX INFO: renamed from: copy-p1EtxEg$default, reason: not valid java name */
    public static TextStyle m750copyp1EtxEg$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontFamily fontFamily, String str, long j3, long j4, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i) {
        TextForegroundStyle colorStyle;
        long jMo768getColor0d7_KjU = (i & 1) != 0 ? textStyle.spanStyle.textForegroundStyle.mo768getColor0d7_KjU() : j;
        long j5 = (i & 2) != 0 ? textStyle.spanStyle.fontSize : j2;
        FontWeight fontWeight2 = (i & 4) != 0 ? textStyle.spanStyle.fontWeight : fontWeight;
        FontStyle fontStyle2 = (i & 8) != 0 ? textStyle.spanStyle.fontStyle : fontStyle;
        SpanStyle spanStyle = textStyle.spanStyle;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        FontFamily fontFamily2 = (i & 32) != 0 ? spanStyle.fontFamily : fontFamily;
        String str2 = (i & 64) != 0 ? spanStyle.fontFeatureSettings : str;
        long j6 = (i & 128) != 0 ? spanStyle.letterSpacing : j3;
        BaselineShift baselineShift = spanStyle.baselineShift;
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        LocaleList localeList = spanStyle.localeList;
        long j7 = spanStyle.background;
        TextDecoration textDecoration = spanStyle.textDecoration;
        Shadow shadow = spanStyle.shadow;
        DrawStyle drawStyle = spanStyle.drawStyle;
        int i2 = (i & 32768) != 0 ? textStyle.paragraphStyle.textAlign : 3;
        int i3 = (i & 65536) != 0 ? textStyle.paragraphStyle.textDirection : 1;
        long j8 = (i & 131072) != 0 ? textStyle.paragraphStyle.lineHeight : j4;
        ParagraphStyle paragraphStyle = textStyle.paragraphStyle;
        TextIndent textIndent = paragraphStyle.textIndent;
        PlatformTextStyle platformTextStyle2 = (i & 524288) != 0 ? textStyle.platformStyle : platformTextStyle;
        LineHeightStyle lineHeightStyle2 = (i & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? paragraphStyle.lineHeightStyle : lineHeightStyle;
        int i4 = paragraphStyle.lineBreak;
        int i5 = paragraphStyle.hyphens;
        TextMotion textMotion = paragraphStyle.textMotion;
        if (ULong.m1869equalsimpl0(jMo768getColor0d7_KjU, spanStyle.textForegroundStyle.mo768getColor0d7_KjU())) {
            colorStyle = spanStyle.textForegroundStyle;
        } else {
            colorStyle = jMo768getColor0d7_KjU != 16 ? new ColorStyle(jMo768getColor0d7_KjU) : TextForegroundStyle.Unspecified.INSTANCE;
        }
        return new TextStyle(new SpanStyle(colorStyle, j5, fontWeight2, fontStyle2, fontSynthesis, fontFamily2, str2, j6, baselineShift, textGeometricTransform, localeList, j7, textDecoration, shadow, platformTextStyle2 != null ? platformTextStyle2.spanStyle : null, drawStyle), new ParagraphStyle(i2, i3, j8, textIndent, platformTextStyle2 != null ? platformTextStyle2.paragraphStyle : null, lineHeightStyle2, i4, i5, textMotion), platformTextStyle2);
    }

    /* JADX INFO: renamed from: merge-dA7vx0o$default, reason: not valid java name */
    public static TextStyle m751mergedA7vx0o$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontFamily fontFamily, long j3, int i, long j4, int i2) {
        long jPack = (i2 & 2) != 0 ? IntMath.pack(0L, Float.NaN) : j2;
        FontWeight fontWeight2 = (i2 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i2 & 8) != 0 ? null : fontStyle;
        FontFamily fontFamily2 = (i2 & 32) != 0 ? null : fontFamily;
        long jPack2 = (i2 & 128) != 0 ? IntMath.pack(0L, Float.NaN) : j3;
        long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
        int i3 = (32768 & i2) != 0 ? 0 : i;
        long jPack3 = (i2 & 131072) != 0 ? IntMath.pack(0L, Float.NaN) : j4;
        SpanStyle spanStyleM734fastMergedSHsh3o = SpanStyleKt.m734fastMergedSHsh3o(textStyle.spanStyle, j, null, Float.NaN, jPack, fontWeight2, fontStyle2, null, fontFamily2, null, jPack2, null, null, null, jColor, null, null, null, null);
        ParagraphStyle paragraphStyleM733fastMergej5T8yCg = ParagraphStyleKt.m733fastMergej5T8yCg(textStyle.paragraphStyle, i3, 0, jPack3, null, null, null, 0, 0, null);
        return (textStyle.spanStyle == spanStyleM734fastMergedSHsh3o && textStyle.paragraphStyle == paragraphStyleM733fastMergej5T8yCg) ? textStyle : new TextStyle(spanStyleM734fastMergedSHsh3o, paragraphStyleM733fastMergej5T8yCg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m752getColor0d7_KjU() {
        return this.spanStyle.textForegroundStyle.mo768getColor0d7_KjU();
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle textStyle) {
        if (this != textStyle) {
            return Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text(textStyle.spanStyle);
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = (this.paragraphStyle.hashCode() + (this.spanStyle.hashCode() * 31)) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return iHashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final TextStyle merge(TextStyle textStyle) {
        return (textStyle == null || textStyle.equals(Default)) ? this : new TextStyle(this.spanStyle.merge(textStyle.spanStyle), this.paragraphStyle.merge(textStyle.paragraphStyle));
    }

    public final String toString() {
        String strM486toStringimpl = Color.m486toStringimpl(m752getColor0d7_KjU());
        SpanStyle spanStyle = this.spanStyle;
        Brush brush = spanStyle.textForegroundStyle.getBrush();
        float alpha = spanStyle.textForegroundStyle.getAlpha();
        String strM815toStringimpl = TextUnit.m815toStringimpl(spanStyle.fontSize);
        FontWeight fontWeight = spanStyle.fontWeight;
        FontStyle fontStyle = spanStyle.fontStyle;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        FontFamily fontFamily = spanStyle.fontFamily;
        String str = spanStyle.fontFeatureSettings;
        String strM815toStringimpl2 = TextUnit.m815toStringimpl(spanStyle.letterSpacing);
        BaselineShift baselineShift = spanStyle.baselineShift;
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        LocaleList localeList = spanStyle.localeList;
        String strM486toStringimpl2 = Color.m486toStringimpl(spanStyle.background);
        TextDecoration textDecoration = spanStyle.textDecoration;
        Shadow shadow = spanStyle.shadow;
        DrawStyle drawStyle = spanStyle.drawStyle;
        ParagraphStyle paragraphStyle = this.paragraphStyle;
        String strM774toStringimpl = TextAlign.m774toStringimpl(paragraphStyle.textAlign);
        String strM775toStringimpl = TextDirection.m775toStringimpl(paragraphStyle.textDirection);
        String strM815toStringimpl3 = TextUnit.m815toStringimpl(paragraphStyle.lineHeight);
        TextIndent textIndent = paragraphStyle.textIndent;
        LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
        String strM770toStringimpl = LineBreak.m770toStringimpl(paragraphStyle.lineBreak);
        String strM769toStringimpl = Hyphens.m769toStringimpl(paragraphStyle.hyphens);
        TextMotion textMotion = paragraphStyle.textMotion;
        StringBuilder sb = new StringBuilder("TextStyle(color=");
        sb.append(strM486toStringimpl);
        sb.append(", brush=");
        sb.append(brush);
        sb.append(", alpha=");
        sb.append(alpha);
        sb.append(", fontSize=");
        sb.append(strM815toStringimpl);
        sb.append(", fontWeight=");
        sb.append(fontWeight);
        sb.append(", fontStyle=");
        sb.append(fontStyle);
        sb.append(", fontSynthesis=");
        sb.append(fontSynthesis);
        sb.append(", fontFamily=");
        sb.append(fontFamily);
        sb.append(", fontFeatureSettings=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, str, ", letterSpacing=", strM815toStringimpl2, ", baselineShift=");
        sb.append(baselineShift);
        sb.append(", textGeometricTransform=");
        sb.append(textGeometricTransform);
        sb.append(", localeList=");
        sb.append(localeList);
        sb.append(", background=");
        sb.append(strM486toStringimpl2);
        sb.append(", textDecoration=");
        sb.append(textDecoration);
        sb.append(", shadow=");
        sb.append(shadow);
        sb.append(", drawStyle=");
        sb.append(drawStyle);
        sb.append(", textAlign=");
        sb.append(strM774toStringimpl);
        sb.append(", textDirection=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, strM775toStringimpl, ", lineHeight=", strM815toStringimpl3, ", textIndent=");
        sb.append(textIndent);
        sb.append(", platformStyle=");
        sb.append(this.platformStyle);
        sb.append(", lineHeightStyle=");
        sb.append(lineHeightStyle);
        sb.append(", lineBreak=");
        sb.append(strM770toStringimpl);
        sb.append(", hyphens=");
        sb.append(strM769toStringimpl);
        sb.append(", textMotion=");
        sb.append(textMotion);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        PlatformSpanStyle platformSpanStyle = spanStyle.platformStyle;
        PlatformParagraphStyle platformParagraphStyle = paragraphStyle.platformStyle;
        this(spanStyle, paragraphStyle, (platformSpanStyle == null && platformParagraphStyle == null) ? null : new PlatformTextStyle(platformSpanStyle, platformParagraphStyle));
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }
}
