package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MinLinesConstrainer {
    public final DensityImpl density;
    public final FontFamily.Resolver fontFamilyResolver;
    public final TextStyle inputTextStyle;
    public final LayoutDirection layoutDirection;
    public float lineHeightCache = Float.NaN;
    public float oneLineHeightCache = Float.NaN;
    public final TextStyle resolvedStyle;

    public MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, DensityImpl densityImpl, FontFamily.Resolver resolver) {
        this.layoutDirection = layoutDirection;
        this.inputTextStyle = textStyle;
        this.density = densityImpl;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = TextRangeKt.resolveDefaults(textStyle, layoutDirection);
    }

    /* JADX INFO: renamed from: coerceMinLines-Oh53vG4$foundation, reason: not valid java name */
    public final long m218coerceMinLinesOh53vG4$foundation(int i, long j) {
        int iM785getMinHeightimpl;
        float f = this.oneLineHeightCache;
        float f2 = this.lineHeightCache;
        int i2 = 1;
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            String str = MinLinesConstrainerKt.EmptyTextReplacement;
            TextStyle textStyle = this.resolvedStyle;
            EmptyList emptyList = EmptyList.INSTANCE;
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            DensityImpl densityImpl = this.density;
            AndroidParagraph androidParagraph = new AndroidParagraph(new AndroidParagraphIntrinsics(str, textStyle, emptyList, emptyList, resolver, densityImpl, false), 1, 1, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
            i2 = 1;
            float f3 = new AndroidParagraph(new AndroidParagraphIntrinsics(MinLinesConstrainerKt.TwoLineTextReplacement, textStyle, emptyList, emptyList, this.fontFamilyResolver, densityImpl, true), 2, 1, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15)).resolvedLineHeight;
            float f4 = androidParagraph.resolvedLineHeight;
            float f5 = f3 - f4;
            this.oneLineHeightCache = f4;
            this.lineHeightCache = f5;
            f2 = f5;
            f = f4;
        }
        if (i != i2) {
            int iRound = Math.round((f2 * (i - 1)) + f);
            iM785getMinHeightimpl = iRound >= 0 ? iRound : 0;
            int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
            if (iM785getMinHeightimpl > iM783getMaxHeightimpl) {
                iM785getMinHeightimpl = iM783getMaxHeightimpl;
            }
        } else {
            iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        }
        return ConstraintsKt.Constraints(Constraints.m786getMinWidthimpl(j), Constraints.m784getMaxWidthimpl(j), iM785getMinHeightimpl, Constraints.m783getMaxHeightimpl(j));
    }
}
