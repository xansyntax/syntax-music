package androidx.compose.foundation.text.modifiers;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphLayoutCache {
    public Density density;
    public boolean didOverflow;
    public FontFamily.Resolver fontFamilyResolver;
    public long historyFlag;
    public LayoutDirection intrinsicsLayoutDirection;
    public boolean isParagraphStale;
    public MinLinesConstrainer mMinLinesConstrainer;
    public int maxLines;
    public int minLines;
    public int overflow;
    public AndroidParagraph paragraph;
    public ParagraphIntrinsics paragraphIntrinsics;
    public boolean softWrap;
    public TextStyle style;
    public String text;
    public long lastDensity = SizeKt.m864constructorimpl(Float.NaN, Float.NaN);
    public long layoutSize = 0;
    public long prevConstraints = ConstraintsKt.createConstraints(0, 0, 0, 0);
    public int cachedIntrinsicHeightInputWidth = -1;
    public int cachedIntrinsicHeight = -1;

    public ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
    }

    /* JADX INFO: renamed from: useMinLinesConstrainer-euUD3Qg$default, reason: not valid java name */
    public static long m224useMinLinesConstrainereuUD3Qg$default(ParagraphLayoutCache paragraphLayoutCache, long j, LayoutDirection layoutDirection) {
        TextStyle textStyle = paragraphLayoutCache.style;
        MinLinesConstrainer minLinesConstrainer = paragraphLayoutCache.mMinLinesConstrainer;
        Density density = paragraphLayoutCache.density;
        density.getClass();
        FontFamily.Resolver resolver = paragraphLayoutCache.fontFamilyResolver;
        if (minLinesConstrainer == null || layoutDirection != minLinesConstrainer.layoutDirection || !TextRangeKt.resolveDefaults(textStyle, layoutDirection).equals(minLinesConstrainer.inputTextStyle) || density.getDensity() != minLinesConstrainer.density.density || resolver != minLinesConstrainer.fontFamilyResolver) {
            minLinesConstrainer = new MinLinesConstrainer(layoutDirection, TextRangeKt.resolveDefaults(textStyle, layoutDirection), new DensityImpl(density.getDensity(), density.getFontScale()), resolver);
        }
        paragraphLayoutCache.mMinLinesConstrainer = minLinesConstrainer;
        return minLinesConstrainer.m218coerceMinLinesOh53vG4$foundation(paragraphLayoutCache.minLines, j);
    }

    public final int intrinsicHeight(int i, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics;
        int i2 = this.cachedIntrinsicHeightInputWidth;
        int i3 = this.cachedIntrinsicHeight;
        if (i == i2 && i2 != -1 && layoutDirection == this.intrinsicsLayoutDirection && ((paragraphIntrinsics = this.paragraphIntrinsics) == null || !paragraphIntrinsics.getHasStaleResolvedFonts())) {
            return i3;
        }
        long jConstraints = ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE);
        if (this.minLines > 1) {
            jConstraints = m224useMinLinesConstrainereuUD3Qg$default(this, jConstraints, layoutDirection);
        }
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        long jM900finalConstraintstfFHcEY = IntMath.m900finalConstraintstfFHcEY(jConstraints, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth());
        boolean z = this.softWrap;
        int i4 = this.overflow;
        int i5 = this.maxLines;
        int iCeilToIntPx = BasicTextKt.ceilToIntPx(new AndroidParagraph((AndroidParagraphIntrinsics) layoutDirection2, ((z || !(i4 == 2 || i4 == 4 || i4 == 5)) && i5 >= 1) ? i5 : 1, i4, jM900finalConstraintstfFHcEY).resolvedLineHeight);
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jConstraints);
        if (iCeilToIntPx < iM785getMinHeightimpl) {
            iCeilToIntPx = iM785getMinHeightimpl;
        }
        this.cachedIntrinsicHeightInputWidth = i;
        this.cachedIntrinsicHeight = iCeilToIntPx;
        return iCeilToIntPx;
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m225layoutWithConstraintsK40F9xA(long j, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics;
        this.historyFlag = (this.historyFlag << 2) | 3;
        boolean z = true;
        long jM224useMinLinesConstrainereuUD3Qg$default = this.minLines > 1 ? m224useMinLinesConstrainereuUD3Qg$default(this, j, layoutDirection) : j;
        AndroidParagraph androidParagraph = this.paragraph;
        boolean z2 = false;
        if (androidParagraph != null && (paragraphIntrinsics = this.paragraphIntrinsics) != null && !this.isParagraphStale && !paragraphIntrinsics.getHasStaleResolvedFonts() && layoutDirection == this.intrinsicsLayoutDirection && (Constraints.m778equalsimpl0(jM224useMinLinesConstrainereuUD3Qg$default, this.prevConstraints) || (Constraints.m784getMaxWidthimpl(jM224useMinLinesConstrainereuUD3Qg$default) == Constraints.m784getMaxWidthimpl(this.prevConstraints) && Constraints.m786getMinWidthimpl(jM224useMinLinesConstrainereuUD3Qg$default) == Constraints.m786getMinWidthimpl(this.prevConstraints) && Constraints.m783getMaxHeightimpl(jM224useMinLinesConstrainereuUD3Qg$default) >= androidParagraph.resolvedLineHeight && !androidParagraph.layout.didExceedMaxLines))) {
            if (!Constraints.m778equalsimpl0(jM224useMinLinesConstrainereuUD3Qg$default, this.prevConstraints)) {
                AndroidParagraph androidParagraph2 = this.paragraph;
                androidParagraph2.getClass();
                long jM789constrain4WqzIAM = ConstraintsKt.m789constrain4WqzIAM(jM224useMinLinesConstrainereuUD3Qg$default, (((long) BasicTextKt.ceilToIntPx(Math.min(androidParagraph2.paragraphIntrinsics.layoutIntrinsics.getMaxIntrinsicWidth(), androidParagraph2.getWidth()))) << 32) | (((long) BasicTextKt.ceilToIntPx(androidParagraph2.resolvedLineHeight)) & 4294967295L));
                this.layoutSize = jM789constrain4WqzIAM;
                if (this.overflow == 3 || (((int) (jM789constrain4WqzIAM >> 32)) >= androidParagraph2.getWidth() && ((int) (4294967295L & jM789constrain4WqzIAM)) >= androidParagraph2.resolvedLineHeight)) {
                    z = false;
                }
                this.didOverflow = z;
                this.prevConstraints = jM224useMinLinesConstrainereuUD3Qg$default;
            }
            return false;
        }
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        long jM900finalConstraintstfFHcEY = IntMath.m900finalConstraintstfFHcEY(jM224useMinLinesConstrainereuUD3Qg$default, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth());
        boolean z3 = this.softWrap;
        int i = this.overflow;
        int i2 = this.maxLines;
        AndroidParagraph androidParagraph3 = new AndroidParagraph((AndroidParagraphIntrinsics) layoutDirection2, ((z3 || !(i == 2 || i == 4 || i == 5)) && i2 >= 1) ? i2 : 1, i, jM900finalConstraintstfFHcEY);
        this.isParagraphStale = false;
        this.prevConstraints = jM224useMinLinesConstrainereuUD3Qg$default;
        int iCeilToIntPx = BasicTextKt.ceilToIntPx(androidParagraph3.getWidth());
        float f = androidParagraph3.resolvedLineHeight;
        long jM789constrain4WqzIAM2 = ConstraintsKt.m789constrain4WqzIAM(jM224useMinLinesConstrainereuUD3Qg$default, (((long) BasicTextKt.ceilToIntPx(f)) & 4294967295L) | (((long) iCeilToIntPx) << 32));
        this.layoutSize = jM789constrain4WqzIAM2;
        if (this.overflow != 3 && (((int) (jM789constrain4WqzIAM2 >> 32)) < androidParagraph3.getWidth() || ((int) (jM789constrain4WqzIAM2 & 4294967295L)) < f)) {
            z2 = true;
        }
        this.didOverflow = z2;
        this.paragraph = androidParagraph3;
        return true;
    }

    public final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.isParagraphStale = false;
        this.prevConstraints = ConstraintsKt.createConstraints(0, 0, 0, 0);
        this.layoutSize = 0L;
        this.didOverflow = false;
    }

    public final void setDensity$foundation(Density density) {
        Density density2 = this.density;
        long jM864constructorimpl = density != null ? SizeKt.m864constructorimpl(density.getDensity(), density.getFontScale()) : SizeKt.m864constructorimpl(Float.NaN, Float.NaN);
        if (density2 == null) {
            this.density = density;
            this.lastDensity = jM864constructorimpl;
        } else if (density == null || this.lastDensity != jM864constructorimpl) {
            this.density = density;
            this.lastDensity = jM864constructorimpl;
            this.historyFlag = (this.historyFlag << 2) | 1;
            markDirty();
        }
    }

    public final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        if (androidParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || androidParagraphIntrinsics.getHasStaleResolvedFonts()) {
            if (androidParagraphIntrinsics != null && androidParagraphIntrinsics.getHasStaleResolvedFonts()) {
                this.isParagraphStale = true;
            }
            this.intrinsicsLayoutDirection = layoutDirection;
            this.cachedIntrinsicHeightInputWidth = -1;
            this.cachedIntrinsicHeight = -1;
            this.mMinLinesConstrainer = null;
            String str = this.text;
            TextStyle textStyleResolveDefaults = TextRangeKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            density.getClass();
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            boolean z = this.softWrap;
            EmptyList emptyList = EmptyList.INSTANCE;
            androidParagraphIntrinsics = new AndroidParagraphIntrinsics(str, textStyleResolveDefaults, emptyList, emptyList, resolver, density, z);
        }
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        return androidParagraphIntrinsics;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("ParagraphLayoutCache(paragraph=", this.paragraph != null ? "<paragraph>" : "null", ", lastDensity=", SizeKt.m877toStringimpl(this.lastDensity), ", history="), this.historyFlag, ", constraints=$)");
    }
}
