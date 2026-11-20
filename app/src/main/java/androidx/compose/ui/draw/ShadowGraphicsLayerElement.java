package androidx.compose.ui.draw;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ShadowGraphicsLayerElement extends ModifierNodeElement {
    public final long ambientColor;
    public final boolean clip;
    public final float elevation;
    public final RoundedCornerShape shape;
    public final long spotColor;

    public ShadowGraphicsLayerElement(float f, RoundedCornerShape roundedCornerShape, boolean z, long j, long j2) {
        this.elevation = f;
        this.shape = roundedCornerShape;
        this.clip = z;
        this.ambientColor = j;
        this.spotColor = j2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new BlockGraphicsLayerModifier(new TextKt$$ExternalSyntheticLambda2((byte) 19, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) obj;
        return Dp.m796equalsimpl0(this.elevation, shadowGraphicsLayerElement.elevation) && this.shape.equals(shadowGraphicsLayerElement.shape) && this.clip == shadowGraphicsLayerElement.clip && ULong.m1869equalsimpl0(this.ambientColor, shadowGraphicsLayerElement.ambientColor) && ULong.m1869equalsimpl0(this.spotColor, shadowGraphicsLayerElement.spotColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.spotColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.shape.hashCode() + (Float.hashCode(this.elevation) * 31)) * 31, this.clip, 31), 31, this.ambientColor);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(this.elevation);
        String strM486toStringimpl = Color.m486toStringimpl(this.ambientColor);
        String strM486toStringimpl2 = Color.m486toStringimpl(this.spotColor);
        StringBuilder sb = new StringBuilder("ShadowGraphicsLayerElement(elevation=");
        sb.append(strM797toStringimpl);
        sb.append(", shape=");
        sb.append(this.shape);
        sb.append(", clip=");
        sb.append(this.clip);
        sb.append(", ambientColor=");
        sb.append(strM486toStringimpl);
        sb.append(", spotColor=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strM486toStringimpl2, ")");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        NodeCoordinator nodeCoordinator;
        BlockGraphicsLayerModifier blockGraphicsLayerModifier = (BlockGraphicsLayerModifier) node;
        TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 19, this);
        blockGraphicsLayerModifier.layerBlock = textKt$$ExternalSyntheticLambda2;
        if (blockGraphicsLayerModifier.node.isAttached && (nodeCoordinator = HitTestResultKt.m646requireCoordinator64DMado(blockGraphicsLayerModifier, 2).wrapped) != null) {
            nodeCoordinator.updateLayerBlock(textKt$$ExternalSyntheticLambda2, true);
        }
    }
}
