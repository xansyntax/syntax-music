package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/IndicatorLineElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/IndicatorLineNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class IndicatorLineElement extends ModifierNodeElement {
    public final TextFieldColors colors;
    public final boolean enabled;
    public final InteractionSource interactionSource;
    public final Shape textFieldShape;

    public IndicatorLineElement(boolean z, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape) {
        this.enabled = z;
        this.interactionSource = interactionSource;
        this.colors = textFieldColors;
        this.textFieldShape = shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new IndicatorLineNode(this.enabled, this.interactionSource, this.colors, this.textFieldShape);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicatorLineElement)) {
            return false;
        }
        IndicatorLineElement indicatorLineElement = (IndicatorLineElement) obj;
        return this.enabled == indicatorLineElement.enabled && Intrinsics.areEqual(this.interactionSource, indicatorLineElement.interactionSource) && this.colors.equals(indicatorLineElement.colors) && Intrinsics.areEqual(this.textFieldShape, indicatorLineElement.textFieldShape) && Dp.m796equalsimpl0(2.0f, 2.0f) && Dp.m796equalsimpl0(1.0f, 1.0f);
    }

    public final int hashCode() {
        int iHashCode = (this.colors.hashCode() + ((this.interactionSource.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.enabled) * 31, false, 31)) * 31)) * 31;
        Shape shape = this.textFieldShape;
        return Float.hashCode(1.0f) + IntIntPair$$ExternalSyntheticOutline0.m(2.0f, (iHashCode + (shape != null ? shape.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(2.0f);
        String strM797toStringimpl2 = Dp.m797toStringimpl(1.0f);
        StringBuilder sb = new StringBuilder("IndicatorLineElement(enabled=");
        sb.append(this.enabled);
        sb.append(", isError=false, interactionSource=");
        sb.append(this.interactionSource);
        sb.append(", colors=");
        sb.append(this.colors);
        sb.append(", textFieldShape=");
        sb.append(this.textFieldShape);
        sb.append(", focusedIndicatorLineThickness=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strM797toStringimpl, ", unfocusedIndicatorLineThickness=", strM797toStringimpl2, ")");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        IndicatorLineNode indicatorLineNode = (IndicatorLineNode) node;
        boolean z2 = indicatorLineNode.enabled;
        boolean z3 = this.enabled;
        boolean z4 = true;
        byte b = 0;
        if (z2 != z3) {
            indicatorLineNode.enabled = z3;
            z = true;
        } else {
            z = false;
        }
        InteractionSource interactionSource = indicatorLineNode.interactionSource;
        InteractionSource interactionSource2 = this.interactionSource;
        if (interactionSource != interactionSource2) {
            indicatorLineNode.interactionSource = interactionSource2;
            StandaloneCoroutine standaloneCoroutine = indicatorLineNode.trackFocusStateJob;
            Continuation continuation = null;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            indicatorLineNode.trackFocusStateJob = AwaitKt.launch$default(indicatorLineNode.getCoroutineScope(), null, null, new IndicatorLineNode$update$1(indicatorLineNode, continuation, b), 3);
        }
        TextFieldColors textFieldColors = indicatorLineNode._colors;
        TextFieldColors textFieldColors2 = this.colors;
        if (!Intrinsics.areEqual(textFieldColors, textFieldColors2)) {
            indicatorLineNode._colors = textFieldColors2;
            z = true;
        }
        Shape shape = indicatorLineNode._shape;
        Shape shape2 = this.textFieldShape;
        if (!Intrinsics.areEqual(shape, shape2)) {
            if (!Intrinsics.areEqual(indicatorLineNode._shape, shape2)) {
                indicatorLineNode._shape = shape2;
                indicatorLineNode.drawWithCacheModifierNode.invalidateDrawCache();
            }
            z = true;
        }
        if (!Dp.m796equalsimpl0(indicatorLineNode.focusedIndicatorWidth, 2.0f)) {
            indicatorLineNode.focusedIndicatorWidth = 2.0f;
            z = true;
        }
        if (Dp.m796equalsimpl0(indicatorLineNode.unfocusedIndicatorWidth, 1.0f)) {
            z4 = z;
        } else {
            indicatorLineNode.unfocusedIndicatorWidth = 1.0f;
        }
        if (z4) {
            indicatorLineNode.invalidateIndicator();
        }
    }
}
