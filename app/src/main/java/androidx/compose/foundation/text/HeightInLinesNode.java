package androidx.compose.foundation.text;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.unit.Constraints;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.network.sockets.DatagramKt;
import kotlin.collections.EmptyMap;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HeightInLinesNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode, ObserverModifierNode {
    public boolean dirty;
    public TypefaceResult fontResolutionState;
    public int maxLines;
    public boolean minLines;
    public int precomputedMaxLinesHeight;
    public int precomputedMinLinesHeight;
    public TextStyle resolvedStyle;
    public TextStyle textStyle;

    public final void computeHeights(MeasureScope measureScope, TextStyle textStyle, FontFamily.Resolver resolver) {
        TextLayout textLayout = TextFieldDelegateKt.paragraphForDefaultText(textStyle, measureScope, resolver, 3, true).layout;
        float lineHeight = textLayout.getLineHeight(0);
        float lineHeight2 = textLayout.getLineHeight(1);
        float lineHeight3 = textLayout.getLineHeight(2);
        this.precomputedMinLinesHeight = BasicTextKt.computeHeightFromThreeLines(lineHeight, lineHeight2, lineHeight3, this.minLines ? 1 : 0, 1);
        this.precomputedMaxLinesHeight = BasicTextKt.computeHeightFromThreeLines(lineHeight, lineHeight2, lineHeight3, this.maxLines, Integer.MAX_VALUE);
    }

    public final void getOrPrecomputeMinMaxHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        if (this.dirty) {
            computeHeights(lookaheadCapablePlaceable, requireResolvedStyle(), (FontFamily.Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver));
            this.dirty = false;
        }
        int i = this.precomputedMinLinesHeight;
        this.precomputedMinLinesHeight = i >= 0 ? i : 0;
        int i2 = this.precomputedMaxLinesHeight;
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        this.precomputedMaxLinesHeight = i2;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        getOrPrecomputeMinMaxHeight(lookaheadCapablePlaceable);
        int i2 = this.precomputedMinLinesHeight;
        int i3 = this.precomputedMaxLinesHeight;
        if (i2 == i3) {
            return i3;
        }
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(i);
        int i4 = this.precomputedMinLinesHeight;
        int i5 = this.precomputedMaxLinesHeight;
        if (iMaxIntrinsicHeight < i4) {
            iMaxIntrinsicHeight = i4;
        }
        return iMaxIntrinsicHeight > i5 ? i5 : iMaxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        if (this.dirty) {
            computeHeights(measureScope, requireResolvedStyle(), (FontFamily.Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver));
            this.dirty = false;
        }
        int i = this.precomputedMinLinesHeight;
        int iCoerceIn = i != -1 ? UuidKt.coerceIn(i, Constraints.m785getMinHeightimpl(j), Constraints.m783getMaxHeightimpl(j)) : Constraints.m785getMinHeightimpl(j);
        int i2 = this.precomputedMaxLinesHeight;
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, iCoerceIn, i2 != -1 ? UuidKt.coerceIn(i2, Constraints.m785getMinHeightimpl(j), Constraints.m783getMaxHeightimpl(j)) : Constraints.m783getMaxHeightimpl(j), 3, j));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 12));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        getOrPrecomputeMinMaxHeight(lookaheadCapablePlaceable);
        int i2 = this.precomputedMinLinesHeight;
        if (i2 == this.precomputedMaxLinesHeight) {
            return i2;
        }
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(i);
        int i3 = this.precomputedMinLinesHeight;
        int i4 = this.precomputedMaxLinesHeight;
        if (iMinIntrinsicHeight < i3) {
            iMinIntrinsicHeight = i3;
        }
        return iMinIntrinsicHeight > i4 ? i4 : iMinIntrinsicHeight;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        FontFamily.Resolver resolver = (FontFamily.Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver);
        this.resolvedStyle = TextRangeKt.resolveDefaults(this.textStyle, HitTestResultKt.requireLayoutNode(this).layoutDirection);
        FontFamily fontFamily = requireResolvedStyle().spanStyle.fontFamily;
        FontWeight fontWeight = requireResolvedStyle().spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontStyle fontStyle = requireResolvedStyle().spanStyle.fontStyle;
        int i = fontStyle != null ? fontStyle.value : 0;
        FontSynthesis fontSynthesis = requireResolvedStyle().spanStyle.fontSynthesis;
        this.fontResolutionState = ((FontFamilyResolverImpl) resolver).m753resolveDPcqOEQ(fontFamily, fontWeight, i, fontSynthesis != null ? fontSynthesis.value : DatagramKt.MAX_DATAGRAM_SIZE);
        HitTestResultKt.observeReads(this, new HeightInLinesNode$$ExternalSyntheticLambda0(this, (byte) 0));
        this.dirty = true;
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        this.dirty = true;
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.resolvedStyle = null;
        this.fontResolutionState = null;
        this.dirty = false;
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public final void onLayoutDirectionChange() {
        this.resolvedStyle = TextRangeKt.resolveDefaults(this.textStyle, HitTestResultKt.requireLayoutNode(this).layoutDirection);
        this.dirty = true;
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        if (this.fontResolutionState != null) {
            HitTestResultKt.observeReads(this, new HeightInLinesNode$$ExternalSyntheticLambda0(this, (byte) 1));
        }
        this.dirty = true;
        HitTestResultKt.invalidateMeasurement(this);
    }

    public final TextStyle requireResolvedStyle() {
        TextStyle textStyle = this.resolvedStyle;
        if (textStyle != null) {
            return textStyle;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m("Resolved style is not set.");
    }
}
