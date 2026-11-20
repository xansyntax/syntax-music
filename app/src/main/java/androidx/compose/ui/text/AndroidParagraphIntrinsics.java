package androidx.compose.ui.text;

import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.compose.ui.text.platform.EmojiCompatStatus;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.TypefaceEmojiSpan;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda20;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    public final int _mayHaveNewLine;
    public final List annotations;
    public final CharSequence charSequence;
    public final Density density;
    public final boolean emojiCompatProcessed;
    public final FontFamily.Resolver fontFamilyResolver;
    public final LayoutIntrinsics layoutIntrinsics;
    public final List placeholders;
    public EmojiProcessor resolvedTypefaces;
    public final TextStyle style;
    public final String text;
    public final int textDirectionHeuristic;
    public final AndroidTextPaint textPaint;

    /* JADX WARN: Code duplicated, block: B:142:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:247:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:259:0x04df  */
    /* JADX WARN: Code duplicated, block: B:260:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:262:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:263:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:266:0x050a  */
    /* JADX WARN: Code duplicated, block: B:267:0x050f  */
    /* JADX WARN: Code duplicated, block: B:269:0x051a  */
    /* JADX WARN: Code duplicated, block: B:270:0x0520  */
    /* JADX WARN: Code duplicated, block: B:272:0x0540  */
    /* JADX WARN: Code duplicated, block: B:275:0x0552  */
    /* JADX WARN: Code duplicated, block: B:277:0x055e  */
    /* JADX WARN: Code duplicated, block: B:286:0x0574  */
    /* JADX WARN: Code duplicated, block: B:299:0x0591  */
    /* JADX WARN: Code duplicated, block: B:302:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:304:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:307:0x05df  */
    /* JADX WARN: Code duplicated, block: B:309:0x0600  */
    /* JADX WARN: Code duplicated, block: B:311:0x060f A[LOOP:8: B:310:0x060d->B:311:0x060f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:314:0x0625  */
    /* JADX WARN: Code duplicated, block: B:316:0x062a  */
    /* JADX WARN: Code duplicated, block: B:318:0x0631  */
    /* JADX WARN: Code duplicated, block: B:320:0x0635  */
    /* JADX WARN: Code duplicated, block: B:321:0x063c  */
    /* JADX WARN: Code duplicated, block: B:323:0x0644  */
    /* JADX WARN: Code duplicated, block: B:334:0x067c  */
    /* JADX WARN: Code duplicated, block: B:339:0x0697  */
    /* JADX WARN: Code duplicated, block: B:341:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:348:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:34:0x009e  */
    /* JADX WARN: Code duplicated, block: B:358:0x06e6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:405:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:407:0x0805  */
    /* JADX WARN: Code duplicated, block: B:409:0x0813  */
    /* JADX WARN: Code duplicated, block: B:416:0x0827  */
    /* JADX WARN: Code duplicated, block: B:429:0x086e  */
    /* JADX WARN: Code duplicated, block: B:431:0x087f  */
    /* JADX WARN: Code duplicated, block: B:432:0x0883  */
    /* JADX WARN: Code duplicated, block: B:434:0x088e  */
    /* JADX WARN: Code duplicated, block: B:437:0x0898 A[LOOP:6: B:436:0x0896->B:437:0x0898, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:440:0x08a9  */
    /* JADX WARN: Code duplicated, block: B:442:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:444:0x08c2 A[LOOP:7: B:443:0x08c0->B:444:0x08c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:447:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:451:0x08e1  */
    /* JADX WARN: Code duplicated, block: B:463:0x0577 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:442:0x08b4, please report this as an issue */
    /* JADX WARN: Not found block with instruction: 0x06e4: MOVE (r2v28 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DONT_GENERATE, REMOVE] (LINE:1765) */
    public AndroidParagraphIntrinsics(String str, TextStyle textStyle, List list, List list2, FontFamily.Resolver resolver, Density density, boolean z) throws Throwable {
        boolean zBooleanValue;
        int i;
        Object obj;
        HistoryScreenKt$$ExternalSyntheticLambda20 historyScreenKt$$ExternalSyntheticLambda20;
        Typeface typeface;
        boolean z2;
        CharSequence charSequence;
        float f;
        long j;
        int i2;
        TextIndent textIndent;
        ParagraphStyle paragraphStyle;
        ArrayList arrayList;
        int size;
        int i3;
        SpanStyle spanStyle;
        FontFamily fontFamily;
        SpanStyle spanStyle2;
        AlbumMenuKt$$ExternalSyntheticLambda11 albumMenuKt$$ExternalSyntheticLambda11;
        int size2;
        int i4;
        int[] iArr;
        int size3;
        int i5;
        int i6;
        int i7;
        int i8;
        int size4;
        SpanStyle spanStyleMerge;
        int i9;
        int i10;
        ArrayList arrayList2;
        SpanStyle spanStyle3;
        int i11;
        int i12;
        int size5;
        int i13;
        boolean z3;
        Density density2;
        TextIndent textIndent2;
        int size6;
        int i14;
        AnnotatedString.Range range;
        int i15;
        long j2;
        long jM813getTypeUIouoOA;
        int size7;
        int i16;
        AnnotatedString.Range range2;
        AnnotatedString.Annotation annotation;
        int i17;
        AnnotatedString.Range range3;
        Object obj2;
        Density density3;
        int i18;
        int i19;
        int i20;
        AnnotatedString.Range range4;
        Object obj3;
        SpanStyle spanStyle4;
        long j3;
        long j4;
        int i21;
        long jM813getTypeUIouoOA2;
        float fM814getValueimpl;
        long jM813getTypeUIouoOA3;
        float fM814getValueimpl2;
        PlatformParagraphStyle platformParagraphStyle;
        CharSequence charSequence2;
        PlatformParagraphStyle platformParagraphStyle2;
        Locale locale;
        this.text = str;
        this.style = textStyle;
        this.annotations = list;
        this.placeholders = list2;
        this.fontFamilyResolver = resolver;
        this.density = density;
        float density4 = density.getDensity();
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1);
        ((TextPaint) androidTextPaint).density = density4;
        androidTextPaint.textDecoration = TextDecoration.None;
        byte b = 3;
        androidTextPaint.backingBlendMode = (byte) 3;
        androidTextPaint.shadow = Shadow.None;
        this.textPaint = androidTextPaint;
        boolean hasEmojiCompat = TextRangeKt.getHasEmojiCompat(textStyle);
        SpanStyle spanStyle5 = textStyle.spanStyle;
        ParagraphStyle paragraphStyle2 = textStyle.paragraphStyle;
        if (hasEmojiCompat) {
            AtomicInt atomicInt = EmojiCompatStatus.delegate;
            AtomicInt atomicInt2 = EmojiCompatStatus.delegate;
            State fontLoadState = (State) atomicInt2.delegate;
            if (fontLoadState == null) {
                if (EmojiCompat.isConfigured()) {
                    fontLoadState = atomicInt2.getFontLoadState();
                    atomicInt2.delegate = fontLoadState;
                } else {
                    fontLoadState = AndroidTextPaint_androidKt.Falsey;
                }
            }
            zBooleanValue = ((Boolean) fontLoadState.getValue()).booleanValue();
        } else {
            zBooleanValue = false;
        }
        this.emojiCompatProcessed = zBooleanValue;
        int i22 = paragraphStyle2.textDirection;
        LocaleList localeList = spanStyle5.localeList;
        if (i22 == 4) {
            i = 2;
        } else if (i22 == 5) {
            i = 3;
        } else if (i22 == 1) {
            i = 0;
        } else if (i22 == 2) {
            i = 1;
        } else {
            if (i22 != 3 && i22 != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Invalid TextDirection.");
                throw null;
            }
            int layoutDirectionFromLocale = TextUtils.getLayoutDirectionFromLocale((localeList == null || (locale = ((androidx.compose.ui.text.intl.Locale) localeList.localeList.get(0)).platformLocale) == null) ? Locale.getDefault() : locale);
            if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                i = 2;
            } else {
                i = 3;
            }
        }
        this.textDirectionHeuristic = i;
        this._mayHaveNewLine = -1;
        HistoryScreenKt$$ExternalSyntheticLambda20 historyScreenKt$$ExternalSyntheticLambda21 = new HistoryScreenKt$$ExternalSyntheticLambda20(b, this);
        TextMotion textMotion = paragraphStyle2.textMotion;
        textMotion = textMotion == null ? TextMotion.Static : textMotion;
        androidTextPaint.setFlags(textMotion.subpixelTextPositioning ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int i23 = textMotion.linearity;
        if (i23 == 1) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (i23 == 2) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (i23 == 3) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
        int size8 = list.size();
        int i24 = 0;
        while (true) {
            if (i24 >= size8) {
                obj = null;
                break;
            }
            obj = list.get(i24);
            if (((AnnotatedString.Range) obj).item instanceof SpanStyle) {
                break;
            } else {
                i24++;
            }
        }
        boolean z4 = obj != null;
        long j5 = spanStyle5.fontSize;
        FontWeight fontWeight = spanStyle5.fontWeight;
        FontStyle fontStyle = spanStyle5.fontStyle;
        String str2 = spanStyle5.fontFeatureSettings;
        LocaleList localeList2 = spanStyle5.localeList;
        TextForegroundStyle textForegroundStyle = spanStyle5.textForegroundStyle;
        TextGeometricTransform textGeometricTransform = spanStyle5.textGeometricTransform;
        long j6 = spanStyle5.letterSpacing;
        long jM813getTypeUIouoOA4 = TextUnit.m813getTypeUIouoOA(j5);
        boolean z5 = z4;
        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA4, 4294967296L)) {
            androidTextPaint.setTextSize(density.mo80toPxR2X_6o(j5));
        } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA4, 8589934592L)) {
            androidTextPaint.setTextSize(TextUnit.m814getValueimpl(j5) * androidTextPaint.getTextSize());
        }
        FontFamily fontFamily2 = spanStyle5.fontFamily;
        if (fontFamily2 == null && fontStyle == null && fontWeight == null) {
            historyScreenKt$$ExternalSyntheticLambda20 = historyScreenKt$$ExternalSyntheticLambda21;
        } else {
            FontWeight fontWeight2 = fontWeight == null ? FontWeight.Normal : fontWeight;
            int i25 = fontStyle != null ? fontStyle.value : 0;
            FontSynthesis fontSynthesis = spanStyle5.fontSynthesis;
            int i26 = fontSynthesis != null ? fontSynthesis.value : DatagramKt.MAX_DATAGRAM_SIZE;
            historyScreenKt$$ExternalSyntheticLambda20 = historyScreenKt$$ExternalSyntheticLambda21;
            AndroidParagraphIntrinsics androidParagraphIntrinsics = (AndroidParagraphIntrinsics) historyScreenKt$$ExternalSyntheticLambda20.f$0;
            TypefaceResult typefaceResultM753resolveDPcqOEQ = ((FontFamilyResolverImpl) androidParagraphIntrinsics.fontFamilyResolver).m753resolveDPcqOEQ(fontFamily2, fontWeight2, i25, i26);
            if (typefaceResultM753resolveDPcqOEQ instanceof TypefaceResult.Immutable) {
                Object obj4 = ((TypefaceResult.Immutable) typefaceResultM753resolveDPcqOEQ).value;
                obj4.getClass();
                typeface = (Typeface) obj4;
            } else {
                EmojiProcessor emojiProcessor = new EmojiProcessor(typefaceResultM753resolveDPcqOEQ, androidParagraphIntrinsics.resolvedTypefaces);
                androidParagraphIntrinsics.resolvedTypefaces = emojiProcessor;
                Object obj5 = emojiProcessor.mGlyphChecker;
                obj5.getClass();
                typeface = (Typeface) obj5;
            }
            androidTextPaint.setTypeface(typeface);
        }
        if (localeList2 != null) {
            LocaleList localeList3 = LocaleList.Empty;
            if (!localeList2.equals(PlatformLocaleKt.platformLocaleDelegate.getCurrent())) {
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList2, 10));
                Iterator it = localeList2.localeList.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((androidx.compose.ui.text.intl.Locale) it.next()).platformLocale);
                }
                Locale[] localeArr = (Locale[]) arrayList3.toArray(new Locale[0]);
                androidTextPaint.setTextLocales(new android.os.LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
            }
        }
        if (str2 != null && !str2.equals("")) {
            androidTextPaint.setFontFeatureSettings(str2);
        }
        if (textGeometricTransform != null && !textGeometricTransform.equals(TextGeometricTransform.None)) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * textGeometricTransform.scaleX);
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + textGeometricTransform.skewX);
        }
        androidTextPaint.m765setColor8_81llA(textForegroundStyle.mo768getColor0d7_KjU());
        androidTextPaint.m764setBrush12SF9DM(textForegroundStyle.getBrush(), 9205357640488583168L, textForegroundStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle5.shadow);
        androidTextPaint.setTextDecoration(spanStyle5.textDecoration);
        androidTextPaint.setDrawStyle(spanStyle5.drawStyle);
        if (TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j6), 4294967296L) && TextUnit.m814getValueimpl(j6) != CropImageView.DEFAULT_ASPECT_RATIO) {
            float textScaleX = androidTextPaint.getTextScaleX() * androidTextPaint.getTextSize();
            float fMo80toPxR2X_6o = density.mo80toPxR2X_6o(j6);
            if (textScaleX != CropImageView.DEFAULT_ASPECT_RATIO) {
                androidTextPaint.setLetterSpacing(fMo80toPxR2X_6o / textScaleX);
            }
        } else if (TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j6), 8589934592L)) {
            androidTextPaint.setLetterSpacing(TextUnit.m814getValueimpl(j6));
        }
        long j7 = spanStyle5.background;
        BaselineShift baselineShift = spanStyle5.baselineShift;
        boolean z6 = z5 && TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j6), 4294967296L) && TextUnit.m814getValueimpl(j6) != CropImageView.DEFAULT_ASPECT_RATIO;
        Rgb rgb = ColorSpaces.Unspecified;
        boolean z7 = (ULong.m1869equalsimpl0(j7, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb)) || ULong.m1869equalsimpl0(j7, 0L)) ? false : true;
        if (baselineShift != null) {
            float f2 = baselineShift.multiplier;
            if (Math.abs(f2) > Float.MAX_VALUE || f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        SpanStyle spanStyle6 = (z6 || z7 || z2) ? new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, z6 ? j6 : IntMath.pack(0L, Float.NaN), z2 ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, z7 ? j7 : ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), (TextDecoration) null, (Shadow) null, 63103) : null;
        List list3 = this.annotations;
        if (spanStyle6 != null) {
            int size9 = list3.size() + 1;
            ArrayList arrayList4 = new ArrayList(size9);
            int i27 = 0;
            while (i27 < size9) {
                arrayList4.add(i27 == 0 ? new AnnotatedString.Range(0, this.text.length(), spanStyle6) : (AnnotatedString.Range) this.annotations.get(i27 - 1));
                i27++;
            }
            list3 = arrayList4;
        }
        String str3 = this.text;
        float textSize = this.textPaint.getTextSize();
        TextStyle textStyle2 = this.style;
        List list4 = this.placeholders;
        Density density5 = this.density;
        boolean z8 = this.emojiCompatProcessed;
        String str4 = this.text;
        if (this._mayHaveNewLine == -1) {
            this._mayHaveNewLine = (str4.length() > 512 || StringsKt.contains$default(str4, '\n')) ? 1 : 0;
        }
        AndroidParagraphHelper_androidKt$NoopSpan$1 androidParagraphHelper_androidKt$NoopSpan$1 = AndroidParagraphHelper_androidKt.NoopSpan;
        if (z8 && EmojiCompat.isConfigured()) {
            PlatformTextStyle platformTextStyle = textStyle2.platformStyle;
            EmojiSupportMatch emojiSupportMatch = (platformTextStyle == null || (platformParagraphStyle2 = platformTextStyle.paragraphStyle) == null) ? null : new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch);
            CharSequence charSequenceProcess = EmojiCompat.get().process(0, str3.length(), (emojiSupportMatch != null && emojiSupportMatch.value == 2) ? 1 : 0, str3);
            charSequenceProcess.getClass();
            charSequence = charSequenceProcess;
        } else {
            charSequence = str3;
        }
        if (!list3.isEmpty() || !list4.isEmpty() || !Intrinsics.areEqual(textStyle2.paragraphStyle.textIndent, TextIndent.None) || (textStyle2.paragraphStyle.lineHeight & 1095216660480L) != 0) {
            charSequence2 = charSequence;
            Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
            SpanStyle spanStyle7 = textStyle2.spanStyle;
            ParagraphStyle paragraphStyle3 = textStyle2.paragraphStyle;
            if (Intrinsics.areEqual(spanStyle7.textDecoration, TextDecoration.Underline)) {
                spannableString.setSpan(AndroidParagraphHelper_androidKt.NoopSpan, 0, str3.length(), 33);
            }
            PlatformTextStyle platformTextStyle2 = textStyle2.platformStyle;
            if (((platformTextStyle2 == null || (platformParagraphStyle = platformTextStyle2.paragraphStyle) == null) ? false : platformParagraphStyle.includeFontPadding) && paragraphStyle3.lineHeightStyle == null) {
                float fM869resolveLineHeightInPxo2QH7mI = SizeKt.m869resolveLineHeightInPxo2QH7mI(paragraphStyle3.lineHeight, textSize, density5);
                if (!Float.isNaN(fM869resolveLineHeightInPxo2QH7mI)) {
                    spannableString.setSpan(new LineHeightSpan(fM869resolveLineHeightInPxo2QH7mI), 0, spannableString.length(), 33);
                }
                f = Float.MAX_VALUE;
                j = 1095216660480L;
            } else {
                LineHeightStyle lineHeightStyle = paragraphStyle3.lineHeightStyle;
                lineHeightStyle = lineHeightStyle == null ? LineHeightStyle.Default : lineHeightStyle;
                f = Float.MAX_VALUE;
                j = 1095216660480L;
                float fM869resolveLineHeightInPxo2QH7mI2 = SizeKt.m869resolveLineHeightInPxo2QH7mI(paragraphStyle3.lineHeight, textSize, density5);
                if (!Float.isNaN(fM869resolveLineHeightInPxo2QH7mI2)) {
                    int length = (spannableString.length() == 0 || StringsKt.last(spannableString) == '\n') ? spannableString.length() + 1 : spannableString.length();
                    int i28 = lineHeightStyle.trim;
                    i2 = 0;
                    spannableString.setSpan(new LineHeightStyleSpan(fM869resolveLineHeightInPxo2QH7mI2, length, (i28 & 1) > 0, (i28 & 16) > 0, lineHeightStyle.alignment, lineHeightStyle.mode), 0, spannableString.length(), 33);
                }
                textIndent = paragraphStyle3.textIndent;
                if (textIndent != null) {
                    j3 = textIndent.firstLine;
                    j4 = textIndent.restLine;
                    i21 = i2;
                    if ((!TextUnit.m812equalsimpl0(j3, IntMath.getSp(i21)) && TextUnit.m812equalsimpl0(j4, IntMath.getSp(i21))) || (j3 & j) == 0 || (j4 & j) == 0) {
                        paragraphStyle = paragraphStyle3;
                    } else {
                        jM813getTypeUIouoOA2 = TextUnit.m813getTypeUIouoOA(j3);
                        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA2, 4294967296L)) {
                            fM814getValueimpl = density5.mo80toPxR2X_6o(j3);
                        } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA2, 8589934592L)) {
                            fM814getValueimpl = TextUnit.m814getValueimpl(j3) * textSize;
                        } else {
                            fM814getValueimpl = 0.0f;
                        }
                        jM813getTypeUIouoOA3 = TextUnit.m813getTypeUIouoOA(j4);
                        paragraphStyle = paragraphStyle3;
                        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA3, 4294967296L)) {
                            fM814getValueimpl2 = density5.mo80toPxR2X_6o(j4);
                        } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA3, 8589934592L)) {
                            fM814getValueimpl2 = TextUnit.m814getValueimpl(j4) * textSize;
                        } else {
                            fM814getValueimpl2 = 0.0f;
                        }
                        spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fM814getValueimpl), (int) Math.ceil(fM814getValueimpl2)), 0, spannableString.length(), 33);
                    }
                } else {
                    paragraphStyle = paragraphStyle3;
                }
                arrayList = new ArrayList(list3.size());
                size = list3.size();
                for (i3 = 0; i3 < size; i3++) {
                    range4 = (AnnotatedString.Range) list3.get(i3);
                    obj3 = range4.item;
                    if (obj3 instanceof SpanStyle) {
                        spanStyle4 = (SpanStyle) obj3;
                        if (spanStyle4.fontFamily == null || spanStyle4.fontStyle != null || spanStyle4.fontWeight != null || ((SpanStyle) obj3).fontSynthesis != null) {
                            arrayList.add(range4);
                        }
                    }
                }
                spanStyle = textStyle2.spanStyle;
                fontFamily = spanStyle.fontFamily;
                if (fontFamily != null && spanStyle.fontStyle == null && spanStyle.fontWeight == null && spanStyle.fontSynthesis == null) {
                    spanStyle2 = null;
                } else {
                    spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 65475);
                }
                albumMenuKt$$ExternalSyntheticLambda11 = new AlbumMenuKt$$ExternalSyntheticLambda11(spannableString, historyScreenKt$$ExternalSyntheticLambda20, (byte) 7);
                if (arrayList.size() <= 1) {
                    size2 = arrayList.size();
                    i4 = size2 * 2;
                    iArr = new int[i4];
                    size3 = arrayList.size();
                    for (i5 = 0; i5 < size3; i5++) {
                        AnnotatedString.Range range5 = (AnnotatedString.Range) arrayList.get(i5);
                        iArr[i5] = range5.start;
                        iArr[i5 + size2] = range5.end;
                    }
                    if (i4 > 1) {
                        Arrays.sort(iArr);
                    }
                    if (i4 != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
                        throw null;
                    }
                    i6 = iArr[0];
                    i7 = 0;
                    while (i7 < i4) {
                        i8 = iArr[i7];
                        if (i8 == i6) {
                            i10 = i7;
                            arrayList2 = arrayList;
                            spanStyle3 = spanStyle2;
                        } else {
                            size4 = arrayList.size();
                            spanStyleMerge = spanStyle2;
                            i9 = 0;
                            while (i9 < size4) {
                                int i29 = i7;
                                AnnotatedString.Range range6 = (AnnotatedString.Range) arrayList.get(i9);
                                ArrayList arrayList5 = arrayList;
                                i11 = range6.start;
                                SpanStyle spanStyle8 = spanStyle2;
                                i12 = range6.end;
                                if (i11 == i12 && AnnotatedStringKt.intersect(i6, i8, i11, i12)) {
                                    SpanStyle spanStyle9 = (SpanStyle) range6.item;
                                    spanStyleMerge = spanStyleMerge != null ? spanStyleMerge.merge(spanStyle9) : spanStyle9;
                                }
                                i9++;
                                arrayList = arrayList5;
                                i7 = i29;
                                spanStyle2 = spanStyle8;
                            }
                            i10 = i7;
                            arrayList2 = arrayList;
                            spanStyle3 = spanStyle2;
                            if (spanStyleMerge != null) {
                                albumMenuKt$$ExternalSyntheticLambda11.invoke(spanStyleMerge, Integer.valueOf(i6), Integer.valueOf(i8));
                            }
                            i6 = i8;
                        }
                        i7 = i10 + 1;
                        arrayList = arrayList2;
                        spanStyle2 = spanStyle3;
                    }
                } else if (!arrayList.isEmpty()) {
                    SpanStyle spanStyle10 = (SpanStyle) ((AnnotatedString.Range) arrayList.get(0)).item;
                    albumMenuKt$$ExternalSyntheticLambda11.invoke(spanStyle2 != null ? spanStyle2.merge(spanStyle10) : spanStyle10, Integer.valueOf(((AnnotatedString.Range) arrayList.get(0)).start), Integer.valueOf(((AnnotatedString.Range) arrayList.get(0)).end));
                }
                size5 = list3.size();
                i13 = 0;
                z3 = false;
                while (i13 < size5) {
                    range3 = (AnnotatedString.Range) list3.get(i13);
                    obj2 = range3.item;
                    if (obj2 instanceof SpanStyle) {
                        i18 = range3.start;
                        int i30 = range3.end;
                        if (i18 >= 0 || i18 >= spannableString.length() || i30 <= i18 || i30 > spannableString.length()) {
                            size5 = size5;
                            density3 = density5;
                        } else {
                            SpanStyle spanStyle11 = (SpanStyle) obj2;
                            long j8 = spanStyle11.letterSpacing;
                            BaselineShift baselineShift2 = spanStyle11.baselineShift;
                            TextForegroundStyle textForegroundStyle2 = spanStyle11.textForegroundStyle;
                            if (baselineShift2 != null) {
                                float f3 = baselineShift2.multiplier;
                                if (Math.abs(f3) <= f && f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                                    spannableString.setSpan(new SkewXSpan(f3, (byte) 1), i18, i30, 33);
                                }
                            }
                            SizeKt.m871setColorRPmYEkk(spannableString, textForegroundStyle2.mo768getColor0d7_KjU(), i18, i30);
                            Brush brush = textForegroundStyle2.getBrush();
                            float alpha = textForegroundStyle2.getAlpha();
                            if (brush != null) {
                                if (brush instanceof SolidColor) {
                                    SizeKt.m871setColorRPmYEkk(spannableString, ((SolidColor) brush).value, i18, i30);
                                } else {
                                    spannableString.setSpan(new ShaderBrushSpan((ShaderBrush) brush, alpha), i18, i30, 33);
                                }
                            }
                            TextDecoration textDecoration = spanStyle11.textDecoration;
                            if (textDecoration != null) {
                                int i31 = textDecoration.mask;
                                TextDecorationSpan textDecorationSpan = new TextDecorationSpan((i31 | 1) == i31, (i31 | 2) == i31);
                                i19 = 33;
                                spannableString.setSpan(textDecorationSpan, i18, i30, 33);
                            } else {
                                i19 = 33;
                            }
                            Density density6 = density5;
                            SizeKt.m872setFontSizeKmRG4DE(spannableString, spanStyle11.fontSize, density6, i18, i30);
                            density3 = density6;
                            String str5 = spanStyle11.fontFeatureSettings;
                            if (str5 != null) {
                                spannableString.setSpan(new TypefaceSpan((byte) 1, str5), i18, i30, i19);
                            }
                            TextGeometricTransform textGeometricTransform2 = spanStyle11.textGeometricTransform;
                            if (textGeometricTransform2 != null) {
                                spannableString.setSpan(new ScaleXSpan(textGeometricTransform2.scaleX), i18, i30, i19);
                                spannableString.setSpan(new SkewXSpan(textGeometricTransform2.skewX, (byte) 0), i18, i30, i19);
                            }
                            SizeKt.setLocaleList(spannableString, spanStyle11.localeList, i18, i30);
                            long j9 = spanStyle11.background;
                            if (j9 != 16) {
                                spannableString.setSpan(new BackgroundColorSpan(ColorKt.m498toArgb8_81llA(j9)), i18, i30, 33);
                            }
                            Shadow shadow = spanStyle11.shadow;
                            if (shadow != null) {
                                long j10 = shadow.offset;
                                int iM498toArgb8_81llA = ColorKt.m498toArgb8_81llA(shadow.color);
                                float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
                                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
                                float f4 = shadow.blurRadius;
                                ShadowSpan shadowSpan = new ShadowSpan(iM498toArgb8_81llA, fIntBitsToFloat, fIntBitsToFloat2, f4 == CropImageView.DEFAULT_ASPECT_RATIO ? Float.MIN_VALUE : f4);
                                i20 = 33;
                                spannableString.setSpan(shadowSpan, i18, i30, 33);
                            } else {
                                i20 = 33;
                            }
                            DrawStyle drawStyle = spanStyle11.drawStyle;
                            if (drawStyle != null) {
                                spannableString.setSpan(new DrawStyleSpan(drawStyle), i18, i30, i20);
                            }
                            if (TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j8), 4294967296L) || TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j8), 8589934592L)) {
                                z3 = true;
                            }
                        }
                    } else {
                        size5 = size5;
                        density3 = density5;
                    }
                    density5 = density3;
                    i13++;
                    size5 = size5;
                }
                density2 = density5;
                if (z3) {
                    size7 = list3.size();
                    for (i16 = 0; i16 < size7; i16++) {
                        range2 = (AnnotatedString.Range) list3.get(i16);
                        annotation = (AnnotatedString.Annotation) range2.item;
                        if (annotation instanceof SpanStyle) {
                            i17 = range2.start;
                            int i32 = range2.end;
                            if (i17 < 0 && i17 < spannableString.length() && i32 > i17 && i32 <= spannableString.length()) {
                                long j11 = ((SpanStyle) annotation).letterSpacing;
                                long jM813getTypeUIouoOA5 = TextUnit.m813getTypeUIouoOA(j11);
                                Object letterSpacingSpanPx = TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA5, 4294967296L) ? new LetterSpacingSpanPx(density2.mo80toPxR2X_6o(j11)) : TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA5, 8589934592L) ? new LetterSpacingSpanEm(TextUnit.m814getValueimpl(j11)) : null;
                                if (letterSpacingSpanPx != null) {
                                    spannableString.setSpan(letterSpacingSpanPx, i17, i32, 33);
                                }
                            }
                        }
                    }
                }
                textIndent2 = paragraphStyle.textIndent;
                if (textIndent2 != null) {
                    j2 = textIndent2.firstLine;
                    jM813getTypeUIouoOA = TextUnit.m813getTypeUIouoOA(j2);
                    if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 4294967296L)) {
                        density2.mo80toPxR2X_6o(j2);
                    } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 8589934592L)) {
                        TextUnit.m814getValueimpl(j2);
                    }
                }
                size6 = list3.size();
                for (i14 = 0; i14 < size6; i14++) {
                    Object obj6 = ((AnnotatedString.Range) list3.get(i14)).item;
                }
                charSequence2 = spannableString;
                if (list4.size() > 0) {
                    range = (AnnotatedString.Range) list4.get(0);
                    if (range.item == null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        throw null;
                    }
                    for (Object obj7 : spannableString.getSpans(range.start, range.end, TypefaceEmojiSpan.class)) {
                        spannableString.removeSpan((TypefaceEmojiSpan) obj7);
                    }
                    throw null;
                }
            }
            i2 = 0;
            textIndent = paragraphStyle3.textIndent;
            if (textIndent != null) {
                j3 = textIndent.firstLine;
                j4 = textIndent.restLine;
                i21 = i2;
                if (!TextUnit.m812equalsimpl0(j3, IntMath.getSp(i21))) {
                    jM813getTypeUIouoOA2 = TextUnit.m813getTypeUIouoOA(j3);
                    if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA2, 4294967296L)) {
                        fM814getValueimpl = density5.mo80toPxR2X_6o(j3);
                    } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA2, 8589934592L)) {
                        fM814getValueimpl = TextUnit.m814getValueimpl(j3) * textSize;
                    } else {
                        fM814getValueimpl = 0.0f;
                    }
                    jM813getTypeUIouoOA3 = TextUnit.m813getTypeUIouoOA(j4);
                    paragraphStyle = paragraphStyle3;
                    if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA3, 4294967296L)) {
                        fM814getValueimpl2 = density5.mo80toPxR2X_6o(j4);
                    } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA3, 8589934592L)) {
                        fM814getValueimpl2 = TextUnit.m814getValueimpl(j4) * textSize;
                    } else {
                        fM814getValueimpl2 = 0.0f;
                    }
                    spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fM814getValueimpl), (int) Math.ceil(fM814getValueimpl2)), 0, spannableString.length(), 33);
                } else {
                    jM813getTypeUIouoOA2 = TextUnit.m813getTypeUIouoOA(j3);
                    if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA2, 4294967296L)) {
                        fM814getValueimpl = density5.mo80toPxR2X_6o(j3);
                    } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA2, 8589934592L)) {
                        fM814getValueimpl = TextUnit.m814getValueimpl(j3) * textSize;
                    } else {
                        fM814getValueimpl = 0.0f;
                    }
                    jM813getTypeUIouoOA3 = TextUnit.m813getTypeUIouoOA(j4);
                    paragraphStyle = paragraphStyle3;
                    if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA3, 4294967296L)) {
                        fM814getValueimpl2 = density5.mo80toPxR2X_6o(j4);
                    } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA3, 8589934592L)) {
                        fM814getValueimpl2 = TextUnit.m814getValueimpl(j4) * textSize;
                    } else {
                        fM814getValueimpl2 = 0.0f;
                    }
                    spannableString.setSpan(new LeadingMarginSpan.Standard((int) Math.ceil(fM814getValueimpl), (int) Math.ceil(fM814getValueimpl2)), 0, spannableString.length(), 33);
                }
            } else {
                paragraphStyle = paragraphStyle3;
            }
            arrayList = new ArrayList(list3.size());
            size = list3.size();
            while (i3 < size) {
                range4 = (AnnotatedString.Range) list3.get(i3);
                obj3 = range4.item;
                if (obj3 instanceof SpanStyle) {
                    spanStyle4 = (SpanStyle) obj3;
                    if (spanStyle4.fontFamily == null) {
                        arrayList.add(range4);
                    } else {
                        arrayList.add(range4);
                    }
                }
            }
            spanStyle = textStyle2.spanStyle;
            fontFamily = spanStyle.fontFamily;
            if (fontFamily != null) {
                spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 65475);
            } else {
                spanStyle2 = new SpanStyle(0L, 0L, spanStyle.fontWeight, spanStyle.fontStyle, spanStyle.fontSynthesis, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 65475);
            }
            albumMenuKt$$ExternalSyntheticLambda11 = new AlbumMenuKt$$ExternalSyntheticLambda11(spannableString, historyScreenKt$$ExternalSyntheticLambda20, (byte) 7);
            if (arrayList.size() <= 1) {
                size2 = arrayList.size();
                i4 = size2 * 2;
                iArr = new int[i4];
                size3 = arrayList.size();
                while (i5 < size3) {
                    AnnotatedString.Range range7 = (AnnotatedString.Range) arrayList.get(i5);
                    iArr[i5] = range7.start;
                    iArr[i5 + size2] = range7.end;
                }
                if (i4 > 1) {
                    Arrays.sort(iArr);
                }
                if (i4 != 0) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
                    throw null;
                }
                i6 = iArr[0];
                i7 = 0;
                while (i7 < i4) {
                    i8 = iArr[i7];
                    if (i8 == i6) {
                        i10 = i7;
                        arrayList2 = arrayList;
                        spanStyle3 = spanStyle2;
                    } else {
                        size4 = arrayList.size();
                        spanStyleMerge = spanStyle2;
                        i9 = 0;
                        while (i9 < size4) {
                            int i210 = i7;
                            AnnotatedString.Range range8 = (AnnotatedString.Range) arrayList.get(i9);
                            ArrayList arrayList6 = arrayList;
                            i11 = range8.start;
                            SpanStyle spanStyle12 = spanStyle2;
                            i12 = range8.end;
                            if (i11 == i12) {
                            }
                            i9++;
                            arrayList = arrayList6;
                            i7 = i210;
                            spanStyle2 = spanStyle12;
                        }
                        i10 = i7;
                        arrayList2 = arrayList;
                        spanStyle3 = spanStyle2;
                        if (spanStyleMerge != null) {
                            albumMenuKt$$ExternalSyntheticLambda11.invoke(spanStyleMerge, Integer.valueOf(i6), Integer.valueOf(i8));
                        }
                        i6 = i8;
                    }
                    i7 = i10 + 1;
                    arrayList = arrayList2;
                    spanStyle2 = spanStyle3;
                }
            } else if (!arrayList.isEmpty()) {
                SpanStyle spanStyle13 = (SpanStyle) ((AnnotatedString.Range) arrayList.get(0)).item;
                albumMenuKt$$ExternalSyntheticLambda11.invoke(spanStyle2 != null ? spanStyle2.merge(spanStyle13) : spanStyle13, Integer.valueOf(((AnnotatedString.Range) arrayList.get(0)).start), Integer.valueOf(((AnnotatedString.Range) arrayList.get(0)).end));
            }
            size5 = list3.size();
            i13 = 0;
            z3 = false;
            while (i13 < size5) {
                range3 = (AnnotatedString.Range) list3.get(i13);
                obj2 = range3.item;
                if (obj2 instanceof SpanStyle) {
                    i18 = range3.start;
                    int i33 = range3.end;
                    if (i18 >= 0) {
                        size5 = size5;
                        density3 = density5;
                    } else {
                        size5 = size5;
                        density3 = density5;
                    }
                } else {
                    size5 = size5;
                    density3 = density5;
                }
                density5 = density3;
                i13++;
                size5 = size5;
            }
            density2 = density5;
            if (z3) {
                size7 = list3.size();
                while (i16 < size7) {
                    range2 = (AnnotatedString.Range) list3.get(i16);
                    annotation = (AnnotatedString.Annotation) range2.item;
                    if (annotation instanceof SpanStyle) {
                        i17 = range2.start;
                        int i34 = range2.end;
                        if (i17 < 0) {
                        }
                    }
                }
            }
            textIndent2 = paragraphStyle.textIndent;
            if (textIndent2 != null) {
                j2 = textIndent2.firstLine;
                jM813getTypeUIouoOA = TextUnit.m813getTypeUIouoOA(j2);
                if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 4294967296L)) {
                    density2.mo80toPxR2X_6o(j2);
                } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 8589934592L)) {
                    TextUnit.m814getValueimpl(j2);
                }
            }
            size6 = list3.size();
            while (i14 < size6) {
                Object obj8 = ((AnnotatedString.Range) list3.get(i14)).item;
            }
            charSequence2 = spannableString;
            if (list4.size() > 0) {
                range = (AnnotatedString.Range) list4.get(0);
                if (range.item == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    throw null;
                }
                while (i15 < r1) {
                    spannableString.removeSpan((TypefaceEmojiSpan) obj7);
                }
                throw null;
            }
        }
        charSequence2 = charSequence;
        this.charSequence = charSequence2;
        this.layoutIntrinsics = new LayoutIntrinsics(charSequence2, this.textPaint, this.textDirectionHeuristic);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final boolean getHasStaleResolvedFonts() {
        EmojiProcessor emojiProcessor = this.resolvedTypefaces;
        if (emojiProcessor != null ? emojiProcessor.isStaleResolvedFont() : false) {
            return true;
        }
        if (!this.emojiCompatProcessed && TextRangeKt.getHasEmojiCompat(this.style)) {
            AtomicInt atomicInt = EmojiCompatStatus.delegate;
            AtomicInt atomicInt2 = EmojiCompatStatus.delegate;
            State fontLoadState = (State) atomicInt2.delegate;
            if (fontLoadState == null) {
                if (EmojiCompat.isConfigured()) {
                    fontLoadState = atomicInt2.getFontLoadState();
                    atomicInt2.delegate = fontLoadState;
                } else {
                    fontLoadState = AndroidTextPaint_androidKt.Falsey;
                }
            }
            if (((Boolean) fontLoadState.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMinIntrinsicWidth() {
        LayoutIntrinsics layoutIntrinsics = this.layoutIntrinsics;
        float f = layoutIntrinsics._minIntrinsicWidth;
        TextPaint textPaint = layoutIntrinsics.textPaint;
        if (!Float.isNaN(f)) {
            return layoutIntrinsics._minIntrinsicWidth;
        }
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        CharSequence charSequence = layoutIntrinsics.charSequence;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, charSequence.length()));
        PriorityQueue priorityQueue = new PriorityQueue(10, StaticLayoutFactory.IntRangeComparator);
        int i = 0;
        for (int next = lineInstance.next(); next != -1; next = lineInstance.next()) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new IntRange(i, next, 1));
            } else {
                IntRange intRange = (IntRange) priorityQueue.peek();
                if (intRange != null && intRange.last - intRange.first < next - i) {
                    priorityQueue.poll();
                    priorityQueue.add(new IntRange(i, next, 1));
                }
            }
            i = next;
        }
        boolean zIsEmpty = priorityQueue.isEmpty();
        float desiredWidth = CropImageView.DEFAULT_ASPECT_RATIO;
        if (!zIsEmpty) {
            Iterator it = priorityQueue.iterator();
            if (!it.hasNext()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            IntRange intRange2 = (IntRange) it.next();
            desiredWidth = Layout.getDesiredWidth(layoutIntrinsics.getCharSequenceForIntrinsicWidth(), intRange2.first, intRange2.last, textPaint);
            while (it.hasNext()) {
                IntRange intRange3 = (IntRange) it.next();
                desiredWidth = Math.max(desiredWidth, Layout.getDesiredWidth(layoutIntrinsics.getCharSequenceForIntrinsicWidth(), intRange3.first, intRange3.last, textPaint));
            }
        }
        layoutIntrinsics._minIntrinsicWidth = desiredWidth;
        return desiredWidth;
    }
}
