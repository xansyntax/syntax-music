package androidx.compose.ui.text;

import androidx.collection.LruCache;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import coil3.ImageLoader$Builder;
import coil3.util.FileSystemsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextMeasurer {
    public final Density defaultDensity;
    public final FontFamily.Resolver defaultFontFamilyResolver;
    public final LayoutDirection defaultLayoutDirection;
    public final EmojiProcessor textLayoutCache = new EmojiProcessor((byte) 11);

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection) {
        this.defaultFontFamilyResolver = resolver;
        this.defaultDensity = density;
        this.defaultLayoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: measure-wNUYSr0$default, reason: not valid java name */
    public static TextLayoutResult m737measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, long j, int i) {
        if ((i & 32) != 0) {
            j = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
        }
        LayoutDirection layoutDirection = textMeasurer.defaultLayoutDirection;
        Density density = textMeasurer.defaultDensity;
        FontFamily.Resolver resolver = textMeasurer.defaultFontFamilyResolver;
        textMeasurer.getClass();
        return m738measurexDpz5zY$default(textMeasurer, new AnnotatedString(str), textStyle, true, j, layoutDirection, density, resolver, 32);
    }

    /* JADX INFO: renamed from: measure-xDpz5zY$default, reason: not valid java name */
    public static TextLayoutResult m738measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, boolean z, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, int i) {
        TextLayoutResult textLayoutResult;
        boolean z2 = (i & 8) != 0 ? true : z;
        long jConstraints$default = (i & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15) : j;
        LayoutDirection layoutDirection2 = (i & 128) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection;
        Density density2 = (i & 256) != 0 ? textMeasurer.defaultDensity : density;
        FontFamily.Resolver resolver2 = (i & 512) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver;
        EmojiProcessor emojiProcessor = textMeasurer.textLayoutCache;
        EmptyList emptyList = EmptyList.INSTANCE;
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, emptyList, Integer.MAX_VALUE, z2, 1, density2, layoutDirection2, resolver2, jConstraints$default);
        TextLayoutResult textLayoutResult2 = null;
        if (emojiProcessor != null) {
            CacheTextLayoutInput cacheTextLayoutInput = new CacheTextLayoutInput(textLayoutInput);
            LruCache lruCache = (LruCache) emojiProcessor.mSpanFactory;
            if (lruCache != null) {
                textLayoutResult = (TextLayoutResult) lruCache.get(cacheTextLayoutInput);
            } else if (Intrinsics.areEqual((CacheTextLayoutInput) emojiProcessor.mMetadataRepo, cacheTextLayoutInput)) {
                textLayoutResult = (TextLayoutResult) emojiProcessor.mGlyphChecker;
            }
            if (textLayoutResult != null && !textLayoutResult.multiParagraph.intrinsics.getHasStaleResolvedFonts()) {
                textLayoutResult2 = textLayoutResult;
            }
        }
        if (textLayoutResult2 != null) {
            MultiParagraph multiParagraph = textLayoutResult2.multiParagraph;
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m789constrain4WqzIAM(jConstraints$default, (((long) ((int) Math.ceil(multiParagraph.width))) << 32) | (4294967295L & ((long) ((int) Math.ceil(multiParagraph.height))))));
        }
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(annotatedString, TextRangeKt.resolveDefaults(textStyle, layoutDirection2), resolver2, density2, emptyList, z2);
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jConstraints$default);
        int iM784getMaxWidthimpl = (z2 && Constraints.m780getHasBoundedWidthimpl(jConstraints$default)) ? Constraints.m784getMaxWidthimpl(jConstraints$default) : Integer.MAX_VALUE;
        if (iM786getMinWidthimpl != iM784getMaxWidthimpl) {
            iM784getMaxWidthimpl = UuidKt.coerceIn((int) Math.ceil(imageLoader$Builder.getMaxIntrinsicWidth()), iM786getMinWidthimpl, iM784getMaxWidthimpl);
        }
        MultiParagraph multiParagraph2 = new MultiParagraph(imageLoader$Builder, FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(0, iM784getMaxWidthimpl, 0, Constraints.m783getMaxHeightimpl(jConstraints$default)), Integer.MAX_VALUE, 1);
        TextLayoutResult textLayoutResult3 = new TextLayoutResult(textLayoutInput, multiParagraph2, ConstraintsKt.m789constrain4WqzIAM(jConstraints$default, (4294967295L & ((long) ((int) Math.ceil(multiParagraph2.height)))) | (((long) ((int) Math.ceil(multiParagraph2.width))) << 32)));
        if (emojiProcessor != null) {
            LruCache lruCache2 = (LruCache) emojiProcessor.mSpanFactory;
            if (lruCache2 != null) {
                lruCache2.put(new CacheTextLayoutInput(textLayoutInput), textLayoutResult3);
                return textLayoutResult3;
            }
            emojiProcessor.mMetadataRepo = new CacheTextLayoutInput(textLayoutInput);
            emojiProcessor.mGlyphChecker = textLayoutResult3;
        }
        return textLayoutResult3;
    }
}
