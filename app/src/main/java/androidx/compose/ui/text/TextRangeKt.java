package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.provider.CallbackWrapper;
import androidx.emoji2.text.EmojiProcessor;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextRangeKt {
    public static final CallbackWrapper LineBreakSaver;
    public static final CallbackWrapper PlatformParagraphStyleSaver;
    public static final CallbackWrapper TextMotionLinearitySaver;
    public static final CallbackWrapper TextMotionSaver;
    public static final CallbackWrapper emojiSupportMatchSaver;

    static {
        byte b = 7;
        PlatformParagraphStyleSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5((byte) 7), new SaversKt$$ExternalSyntheticLambda6((byte) 9), b);
        emojiSupportMatchSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5((byte) 8), new SaversKt$$ExternalSyntheticLambda6((byte) 10), b);
        LineBreakSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5((byte) 9), new SaversKt$$ExternalSyntheticLambda6((byte) 11), b);
        TextMotionSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5((byte) 10), new SaversKt$$ExternalSyntheticLambda6((byte) 12), b);
        TextMotionLinearitySaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5((byte) 11), new SaversKt$$ExternalSyntheticLambda6((byte) 13), b);
    }

    public static final long TextRange(int i, int i2) {
        if (i < 0 || i2 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start and end cannot be negative. [start: " + i + ", end: " + i2 + "]");
        }
        long j = (((long) i2) & 4294967295L) | (((long) i) << 32);
        int i3 = TextRange.$r8$clinit;
        return j;
    }

    /* JADX INFO: renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m747coerceIn8ffj60Q(int i, long j) {
        int i2 = TextRange.$r8$clinit;
        int i3 = (int) (j >> 32);
        int i4 = i3 < 0 ? 0 : i3;
        if (i4 > i) {
            i4 = i;
        }
        int i5 = (int) (4294967295L & j);
        int i6 = i5 >= 0 ? i5 : 0;
        if (i6 <= i) {
            i = i6;
        }
        return (i4 == i3 && i == i5) ? j : TextRange(i4, i);
    }

    /* JADX INFO: renamed from: drawText-d8-rzKo$default, reason: not valid java name */
    public static void m748drawTextd8rzKo$default(DrawScope drawScope, TextLayoutResult textLayoutResult, long j, long j2, int i) {
        long jColor = (i & 2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j;
        long j3 = (i & 4) != 0 ? 0L : j2;
        SpanStyle spanStyle = textLayoutResult.layoutInput.style.spanStyle;
        Shadow shadow = spanStyle.shadow;
        TextDecoration textDecoration = spanStyle.textDecoration;
        DrawStyle drawStyle = spanStyle.drawStyle;
        EmojiProcessor drawContext = drawScope.getDrawContext();
        long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawResult drawResult = (DrawResult) drawContext.mSpanFactory;
            drawResult.translate(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
            boolean hasVisualOverflow = textLayoutResult.getHasVisualOverflow();
            MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
            TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
            if (hasVisualOverflow && textLayoutInput.overflow != 3) {
                long j4 = textLayoutResult.size;
                DrawResult.m400clipRectN_I0leg$default(drawResult, (int) (j4 >> 32), (int) (j4 & 4294967295L), 16);
            }
            TextStyle textStyle = textLayoutInput.style;
            Brush brush = textStyle.spanStyle.textForegroundStyle.getBrush();
            if (brush == null || jColor != 16) {
                multiParagraph.m731paintLG529CI(drawScope.getDrawContext().getCanvas(), IntMath.m901modulateDxMtmZc(jColor != 16 ? jColor : textStyle.m752getColor0d7_KjU(), Float.NaN), shadow, textDecoration, drawStyle);
            } else {
                AndroidTextPaint_androidKt.m766drawMultiParagraph7AXcY_I(multiParagraph, drawScope.getDrawContext().getCanvas(), brush, Float.isNaN(Float.NaN) ? textStyle.spanStyle.textForegroundStyle.getAlpha() : Float.NaN, shadow, textDecoration, drawStyle);
            }
        } finally {
            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
        }
    }

    public static final int findParagraphByIndex(int i, List list) {
        int i2;
        byte b;
        int i3 = ((ParagraphInfo) CollectionsKt.last(list)).endIndex;
        if (i > ((ParagraphInfo) CollectionsKt.last(list)).endIndex) {
            InlineClassHelperKt.throwIllegalArgumentException("Index " + i + " should be less or equal than last line's end " + i3);
        }
        int size = list.size() - 1;
        int i4 = 0;
        while (true) {
            if (i4 > size) {
                i2 = -(i4 + 1);
                break;
            }
            i2 = (i4 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i2);
            if (paragraphInfo.startIndex > i) {
                b = 1;
            } else {
                b = paragraphInfo.endIndex <= i ? (byte) -1 : (byte) 0;
            }
            if (b >= 0) {
                if (b <= 0) {
                    break;
                }
                size = i2 - 1;
            } else {
                i4 = i2 + 1;
            }
        }
        if (i2 >= 0 && i2 < list.size()) {
            return i2;
        }
        int size2 = list.size();
        String strFastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, null, new SaversKt$$ExternalSyntheticLambda2((byte) 7), 31);
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i2, "Found paragraph index ", " should be in range [0, ", size2, ").\nDebug info: index=");
        sbM3m.append(i);
        sbM3m.append(", paragraphs=[");
        sbM3m.append(strFastJoinToString$default);
        sbM3m.append("]");
        InlineClassHelperKt.throwIllegalArgumentException(sbM3m.toString());
        return i2;
    }

    public static final int findParagraphByLineIndex(int i, List list) {
        byte b;
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i3);
            if (paragraphInfo.startLineIndex > i) {
                b = 1;
            } else {
                b = paragraphInfo.endLineIndex <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByY(ArrayList arrayList, float f) {
        byte b;
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0;
        }
        if (f >= ((ParagraphInfo) CollectionsKt.last(arrayList)).bottom) {
            return arrayList.size() - 1;
        }
        int size = arrayList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i2);
            if (paragraphInfo.top > f) {
                b = 1;
            } else {
                b = paragraphInfo.bottom <= f ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m749findParagraphsByRangeSbBc2M(ArrayList arrayList, long j, Function1 function1) {
        int size = arrayList.size();
        for (int iFindParagraphByIndex = findParagraphByIndex(TextRange.m744getMinimpl(j), arrayList); iFindParagraphByIndex < size; iFindParagraphByIndex++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iFindParagraphByIndex);
            if (paragraphInfo.startIndex >= TextRange.m743getMaximpl(j)) {
                return;
            }
            if (paragraphInfo.startIndex != paragraphInfo.endIndex) {
                function1.invoke(paragraphInfo);
            }
        }
    }

    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle platformParagraphStyle;
        PlatformTextStyle platformTextStyle = textStyle.platformStyle;
        EmojiSupportMatch emojiSupportMatch = (platformTextStyle == null || (platformParagraphStyle = platformTextStyle.paragraphStyle) == null) ? null : new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch);
        boolean z = false;
        if (emojiSupportMatch != null && emojiSupportMatch.value == 1) {
            z = true;
        }
        return !z;
    }

    public static final TextMeasurer rememberTextMeasurer(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        FontFamily.Resolver resolver = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
        boolean zChanged = gapComposer.changed(resolver) | gapComposer.changed(density) | gapComposer.changed(layoutDirection.ordinal()) | gapComposer.changed(8);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new TextMeasurer(resolver, density, layoutDirection);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (TextMeasurer) objRememberedValue;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0101  */
    /* JADX WARN: Code duplicated, block: B:84:0x010b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0116  */
    public static final TextStyle resolveDefaults(TextStyle textStyle, LayoutDirection layoutDirection) {
        long j;
        TextIndent textIndent;
        int i;
        int i2;
        TextMotion textMotion;
        SpanStyle spanStyle = textStyle.spanStyle;
        TextForegroundStyle textForegroundStyle = SpanStyleKt.DefaultColorForegroundStyle;
        TextForegroundStyle textForegroundStyle2 = spanStyle.textForegroundStyle;
        if (textForegroundStyle2.equals(TextForegroundStyle.Unspecified.INSTANCE)) {
            textForegroundStyle2 = SpanStyleKt.DefaultColorForegroundStyle;
        }
        TextForegroundStyle textForegroundStyle3 = textForegroundStyle2;
        long j2 = spanStyle.fontSize;
        if ((j2 & 1095216660480L) == 0) {
            j2 = SpanStyleKt.DefaultFontSize;
        }
        long j3 = j2;
        FontWeight fontWeight = spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.fontStyle;
        FontStyle fontStyle2 = new FontStyle(fontStyle != null ? fontStyle.value : 0);
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        FontSynthesis fontSynthesis2 = new FontSynthesis(fontSynthesis != null ? fontSynthesis.value : DatagramKt.MAX_DATAGRAM_SIZE);
        FontFamily fontFamily = spanStyle.fontFamily;
        if (fontFamily == null) {
            fontFamily = FontFamily.Default;
        }
        FontFamily fontFamily2 = fontFamily;
        String str = spanStyle.fontFeatureSettings;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long j4 = spanStyle.letterSpacing;
        if ((j4 & 1095216660480L) == 0) {
            j4 = SpanStyleKt.DefaultLetterSpacing;
        }
        long j5 = j4;
        BaselineShift baselineShift = spanStyle.baselineShift;
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        float f2 = baselineShift != null ? baselineShift.multiplier : 0.0f;
        if (!Float.isNaN(f2)) {
            f = f2;
        }
        BaselineShift baselineShift2 = new BaselineShift(f);
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.None;
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList current = spanStyle.localeList;
        if (current == null) {
            LocaleList localeList = LocaleList.Empty;
            current = PlatformLocaleKt.platformLocaleDelegate.getCurrent();
        }
        LocaleList localeList2 = current;
        long j6 = spanStyle.background;
        long j7 = j6 != 16 ? j6 : 0L;
        TextDecoration textDecoration = spanStyle.textDecoration;
        if (textDecoration == null) {
            textDecoration = TextDecoration.None;
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.shadow;
        if (shadow == null) {
            shadow = Shadow.None;
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformSpanStyle = spanStyle.platformStyle;
        DrawStyle drawStyle = spanStyle.drawStyle;
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyle3, j3, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j5, baselineShift2, textGeometricTransform2, localeList2, j7, textDecoration2, shadow2, platformSpanStyle, drawStyle);
        ParagraphStyle paragraphStyle = textStyle.paragraphStyle;
        int i3 = ParagraphStyleKt.$r8$clinit;
        int i4 = paragraphStyle.textAlign;
        int i5 = 5;
        if (i4 == 0) {
            i4 = 5;
        }
        int i6 = paragraphStyle.textDirection;
        if (i6 != 3) {
            if (i6 == 0) {
                int iOrdinal = layoutDirection.ordinal();
                if (iOrdinal == 0) {
                    i6 = 1;
                } else {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    i5 = 2;
                }
            }
            j = paragraphStyle.lineHeight;
            if ((j & 1095216660480L) == 0) {
                j = ParagraphStyleKt.DefaultLineHeight;
            }
            textIndent = paragraphStyle.textIndent;
            if (textIndent == null) {
                textIndent = TextIndent.None;
            }
            PlatformParagraphStyle platformParagraphStyle = paragraphStyle.platformStyle;
            LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
            i = paragraphStyle.lineBreak;
            if (i == 0) {
                i = LineBreak.Simple;
            }
            i2 = paragraphStyle.hyphens;
            if (i2 == 0) {
                i2 = 1;
            }
            textMotion = paragraphStyle.textMotion;
            if (textMotion == null) {
                textMotion = TextMotion.Static;
            }
            return new TextStyle(spanStyle2, new ParagraphStyle(i4, i6, j, textIndent, platformParagraphStyle, lineHeightStyle, i, i2, textMotion), textStyle.platformStyle);
        }
        int iOrdinal2 = layoutDirection.ordinal();
        if (iOrdinal2 == 0) {
            i5 = 4;
        } else if (iOrdinal2 != 1) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        i6 = i5;
        j = paragraphStyle.lineHeight;
        if ((j & 1095216660480L) == 0) {
            j = ParagraphStyleKt.DefaultLineHeight;
        }
        textIndent = paragraphStyle.textIndent;
        if (textIndent == null) {
            textIndent = TextIndent.None;
        }
        PlatformParagraphStyle platformParagraphStyle2 = paragraphStyle.platformStyle;
        LineHeightStyle lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        i = paragraphStyle.lineBreak;
        if (i == 0) {
            i = LineBreak.Simple;
        }
        i2 = paragraphStyle.hyphens;
        if (i2 == 0) {
            i2 = 1;
        }
        textMotion = paragraphStyle.textMotion;
        if (textMotion == null) {
            textMotion = TextMotion.Static;
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(i4, i6, j, textIndent, platformParagraphStyle2, lineHeightStyle2, i, i2, textMotion), textStyle.platformStyle);
    }
}
