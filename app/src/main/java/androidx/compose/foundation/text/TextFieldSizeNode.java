package androidx.compose.foundation.text;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.network.sockets.DatagramKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSizeNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public TypefaceResult fontResolutionState;
    public TextFieldSize minSizeState;
    public final TextStyle style;

    public TextFieldSizeNode(TextStyle textStyle) {
        this.style = textStyle;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        TextFieldSize textFieldSize = this.minSizeState;
        if (textFieldSize == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m("Min size state is not set.");
        }
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSize.dirty$delegate;
        TypefaceResult typefaceResult = this.fontResolutionState;
        if (typefaceResult == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m("Font resolution state is not set.");
        }
        Object value = typefaceResult.getValue();
        if (!Intrinsics.areEqual(value, textFieldSize.typeface)) {
            textFieldSize.typeface = value;
            parcelableSnapshotMutableState.setValue(Boolean.TRUE);
        }
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            textFieldSize.minSize = TextFieldDelegateKt.computeSizeForDefaultText$default(textFieldSize.resolvedStyle, textFieldSize.density, textFieldSize.fontFamilyResolver);
            parcelableSnapshotMutableState.setValue(Boolean.FALSE);
        }
        long j2 = textFieldSize.minSize;
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.m790constrainN9IONVI(j, ConstraintsKt.Constraints$default((int) (j2 >> 32), 0, (int) (j2 & 4294967295L), 0, 10)));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 13));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        TextStyle textStyleResolveDefaults = TextRangeKt.resolveDefaults(this.style, HitTestResultKt.requireLayoutNode(this).layoutDirection);
        FontFamily.Resolver resolver = (FontFamily.Resolver) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalFontFamilyResolver);
        updateFontResolutionState$1(textStyleResolveDefaults, resolver);
        LayoutDirection layoutDirection = HitTestResultKt.requireLayoutNode(this).layoutDirection;
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        TypefaceResult typefaceResult = this.fontResolutionState;
        if (typefaceResult == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m("Font resolution state is not set.");
        }
        this.minSizeState = new TextFieldSize(layoutDirection, density, resolver, textStyleResolveDefaults, typefaceResult.getValue());
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        TextFieldSize textFieldSize = this.minSizeState;
        if (textFieldSize != null) {
            TextFieldSize.update$default(textFieldSize, null, HitTestResultKt.requireLayoutNode(this).density, null, 29);
        }
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.fontResolutionState = null;
        this.minSizeState = null;
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public final void onLayoutDirectionChange() {
        TextFieldSize textFieldSize = this.minSizeState;
        if (textFieldSize != null) {
            TextFieldSize.update$default(textFieldSize, HitTestResultKt.requireLayoutNode(this).layoutDirection, null, null, 30);
        }
        HitTestResultKt.invalidateMeasurement(this);
    }

    public final void updateFontResolutionState$1(TextStyle textStyle, FontFamily.Resolver resolver) {
        SpanStyle spanStyle = textStyle.spanStyle;
        FontFamily fontFamily = spanStyle.fontFamily;
        FontWeight fontWeight = spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = FontWeight.Normal;
        }
        FontStyle fontStyle = spanStyle.fontStyle;
        int i = fontStyle != null ? fontStyle.value : 0;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        this.fontResolutionState = ((FontFamilyResolverImpl) resolver).m753resolveDPcqOEQ(fontFamily, fontWeight, i, fontSynthesis != null ? fontSynthesis.value : DatagramKt.MAX_DATAGRAM_SIZE);
        HitTestResultKt.invalidateMeasurement(this);
    }
}
