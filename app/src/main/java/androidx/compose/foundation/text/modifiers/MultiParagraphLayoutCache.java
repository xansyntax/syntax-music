package androidx.compose.foundation.text.modifiers;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.ImageLoader$Builder;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraphLayoutCache {
    public Density density;
    public FontFamily.Resolver fontFamilyResolver;
    public long historyFlag;
    public LayoutDirection intrinsicsLayoutDirection;
    public boolean isLayoutCacheStale;
    public TextLayoutResult layoutCache;
    public MinLinesConstrainer mMinLinesConstrainer;
    public int maxLines;
    public int minLines;
    public int overflow;
    public ImageLoader$Builder paragraphIntrinsics;
    public List placeholders;
    public boolean softWrap;
    public TextStyle style;
    public AnnotatedString text;
    public long lastDensity = SizeKt.m864constructorimpl(Float.NaN, Float.NaN);
    public int cachedIntrinsicHeightInputWidth = -1;
    public int cachedIntrinsicHeight = -1;

    public MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list) {
        this.text = annotatedString;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.style = textStyle;
    }

    public final int intrinsicHeight(int i, LayoutDirection layoutDirection) {
        ImageLoader$Builder imageLoader$Builder;
        int i2 = this.cachedIntrinsicHeightInputWidth;
        int i3 = this.cachedIntrinsicHeight;
        if (i == i2 && i2 != -1 && layoutDirection == this.intrinsicsLayoutDirection && ((imageLoader$Builder = this.paragraphIntrinsics) == null || !imageLoader$Builder.getHasStaleResolvedFonts())) {
            return i3;
        }
        long jConstraints = ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE);
        if (this.minLines > 1) {
            jConstraints = m223useMinLinesConstrainerOh53vG4(jConstraints, layoutDirection);
        }
        int iCeilToIntPx = BasicTextKt.ceilToIntPx(m219layoutTextK40F9xA(jConstraints, layoutDirection).height);
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jConstraints);
        if (iCeilToIntPx < iM785getMinHeightimpl) {
            iCeilToIntPx = iM785getMinHeightimpl;
        }
        this.cachedIntrinsicHeightInputWidth = i;
        this.cachedIntrinsicHeight = iCeilToIntPx;
        return iCeilToIntPx;
    }

    /* JADX INFO: renamed from: layoutText-K40F9xA, reason: not valid java name */
    public final MultiParagraph m219layoutTextK40F9xA(long j, LayoutDirection layoutDirection) {
        ImageLoader$Builder layoutDirection2 = setLayoutDirection(layoutDirection);
        long jM900finalConstraintstfFHcEY = IntMath.m900finalConstraintstfFHcEY(j, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth());
        boolean z = this.softWrap;
        int i = this.overflow;
        int i2 = this.maxLines;
        return new MultiParagraph(layoutDirection2, jM900finalConstraintstfFHcEY, ((z || !(i == 2 || i == 4 || i == 5)) && i2 >= 1) ? i2 : 1, i);
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m220layoutWithConstraintsK40F9xA(long j, LayoutDirection layoutDirection) {
        this.historyFlag = (this.historyFlag << 2) | 3;
        if (this.minLines > 1) {
            j = m223useMinLinesConstrainerOh53vG4(j, layoutDirection);
        }
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null) {
            MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
            TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
            if (!this.isLayoutCacheStale && !multiParagraph.intrinsics.getHasStaleResolvedFonts()) {
                LayoutDirection layoutDirection2 = textLayoutInput.layoutDirection;
                long j2 = textLayoutInput.constraints;
                if (layoutDirection == layoutDirection2 && (Constraints.m778equalsimpl0(j, j2) || (Constraints.m784getMaxWidthimpl(j) == Constraints.m784getMaxWidthimpl(j2) && Constraints.m786getMinWidthimpl(j) == Constraints.m786getMinWidthimpl(j2) && Constraints.m783getMaxHeightimpl(j) >= multiParagraph.height && !multiParagraph.didExceedMaxLines))) {
                    TextLayoutResult textLayoutResult2 = this.layoutCache;
                    textLayoutResult2.getClass();
                    if (Constraints.m778equalsimpl0(j, textLayoutResult2.layoutInput.constraints)) {
                        return false;
                    }
                    TextLayoutResult textLayoutResult3 = this.layoutCache;
                    textLayoutResult3.getClass();
                    this.layoutCache = m221textLayoutResultVKLhPVY(layoutDirection, j, textLayoutResult3.multiParagraph);
                    return true;
                }
            }
        }
        this.layoutCache = m221textLayoutResultVKLhPVY(layoutDirection, j, m219layoutTextK40F9xA(j, layoutDirection));
        this.isLayoutCacheStale = false;
        return true;
    }

    public final void setDensity$foundation(Density density) {
        Density density2 = this.density;
        long jM864constructorimpl = density != null ? SizeKt.m864constructorimpl(density.getDensity(), density.getFontScale()) : SizeKt.m864constructorimpl(Float.NaN, Float.NaN);
        if (density2 == null) {
            this.density = density;
            this.lastDensity = jM864constructorimpl;
            return;
        }
        if (density == null || this.lastDensity != jM864constructorimpl) {
            this.density = density;
            this.lastDensity = jM864constructorimpl;
            this.historyFlag = (this.historyFlag << 2) | 1;
            this.paragraphIntrinsics = null;
            this.layoutCache = null;
            this.cachedIntrinsicHeight = -1;
            this.cachedIntrinsicHeightInputWidth = -1;
            this.isLayoutCacheStale = false;
        }
    }

    public final ImageLoader$Builder setLayoutDirection(LayoutDirection layoutDirection) {
        ImageLoader$Builder imageLoader$Builder = this.paragraphIntrinsics;
        if (imageLoader$Builder == null || layoutDirection != this.intrinsicsLayoutDirection || imageLoader$Builder.getHasStaleResolvedFonts()) {
            if (imageLoader$Builder != null && imageLoader$Builder.getHasStaleResolvedFonts()) {
                this.isLayoutCacheStale = true;
            }
            this.intrinsicsLayoutDirection = layoutDirection;
            this.cachedIntrinsicHeightInputWidth = -1;
            this.cachedIntrinsicHeight = -1;
            this.mMinLinesConstrainer = null;
            AnnotatedString annotatedString = this.text;
            TextStyle textStyleResolveDefaults = TextRangeKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            density.getClass();
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            List list = this.placeholders;
            if (list == null) {
                list = EmptyList.INSTANCE;
            }
            imageLoader$Builder = new ImageLoader$Builder(annotatedString, textStyleResolveDefaults, resolver, density, list, this.softWrap);
        }
        this.paragraphIntrinsics = imageLoader$Builder;
        return imageLoader$Builder;
    }

    /* JADX INFO: renamed from: textLayoutResult-VKLhPVY, reason: not valid java name */
    public final TextLayoutResult m221textLayoutResultVKLhPVY(LayoutDirection layoutDirection, long j, MultiParagraph multiParagraph) {
        float fMin = Math.min(multiParagraph.intrinsics.getMaxIntrinsicWidth(), multiParagraph.width);
        AnnotatedString annotatedString = this.text;
        TextStyle textStyle = this.style;
        List list = this.placeholders;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        int i = this.maxLines;
        boolean z = this.softWrap;
        int i2 = this.overflow;
        Density density = this.density;
        density.getClass();
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, list, i, z, i2, density, layoutDirection, this.fontFamilyResolver, j), multiParagraph, ConstraintsKt.m789constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(fMin)) << 32) | (((long) BasicTextKt.ceilToIntPx(multiParagraph.height)) & 4294967295L)));
    }

    public final String toString() {
        TextLayoutInput textLayoutInput;
        Object constraints = "null";
        String str = this.layoutCache != null ? "<TextLayoutResult>" : "null";
        String strM877toStringimpl = SizeKt.m877toStringimpl(this.lastDensity);
        long j = this.historyFlag;
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null && (textLayoutInput = textLayoutResult.layoutInput) != null) {
            constraints = new Constraints(textLayoutInput.constraints);
        }
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("MultiParagraphLayoutCache(textLayoutResult=", str, ", lastDensity=", strM877toStringimpl, ", history=");
        sbM.append(j);
        sbM.append(", constraints=");
        sbM.append(constraints);
        sbM.append(")");
        return sbM.toString();
    }

    /* JADX INFO: renamed from: update-J2qo7bo, reason: not valid java name */
    public final void m222updateJ2qo7bo(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list) {
        this.text = annotatedString;
        boolean zHasSameLayoutAffectingAttributes = textStyle.hasSameLayoutAffectingAttributes(this.style);
        this.style = textStyle;
        if (!zHasSameLayoutAffectingAttributes) {
            this.historyFlag <<= 2;
            this.paragraphIntrinsics = null;
            this.layoutCache = null;
            this.cachedIntrinsicHeight = -1;
            this.cachedIntrinsicHeightInputWidth = -1;
            this.isLayoutCacheStale = false;
        }
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.historyFlag = (this.historyFlag << 2) | 2;
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.isLayoutCacheStale = false;
    }

    /* JADX INFO: renamed from: useMinLinesConstrainer-Oh53vG4, reason: not valid java name */
    public final long m223useMinLinesConstrainerOh53vG4(long j, LayoutDirection layoutDirection) {
        MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
        TextStyle textStyle = this.style;
        Density density = this.density;
        density.getClass();
        FontFamily.Resolver resolver = this.fontFamilyResolver;
        if (minLinesConstrainer == null || layoutDirection != minLinesConstrainer.layoutDirection || !TextRangeKt.resolveDefaults(textStyle, layoutDirection).equals(minLinesConstrainer.inputTextStyle) || density.getDensity() != minLinesConstrainer.density.density || resolver != minLinesConstrainer.fontFamilyResolver) {
            minLinesConstrainer = new MinLinesConstrainer(layoutDirection, TextRangeKt.resolveDefaults(textStyle, layoutDirection), new DensityImpl(density.getDensity(), density.getFontScale()), resolver);
        }
        this.mMinLinesConstrainer = minLinesConstrainer;
        return minLinesConstrainer.m218coerceMinLinesOh53vG4$foundation(this.minLines, j);
    }
}
