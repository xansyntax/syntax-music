package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {
    public float alpha;
    public long ambientShadowColor;
    public byte blendMode;
    public float cameraDistance;
    public boolean clip;
    public TextKt$$ExternalSyntheticLambda2 layerBlock;
    public LayerOutsets outsets;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public float shadowElevation;
    public Shape shape;
    public long spotShadowColor;
    public long transformOrigin;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.clip) {
            SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean isImportantForBounds() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new ZIndexNode$$ExternalSyntheticLambda0((Object) placeableMo598measureBRTryo0, (Object) this, (byte) 25));
    }

    public final String toString() {
        float f = this.scaleX;
        float f2 = this.scaleY;
        float f3 = this.alpha;
        float f4 = this.shadowElevation;
        float f5 = this.rotationZ;
        float f6 = this.cameraDistance;
        String strM520toStringimpl = TransformOrigin.m520toStringimpl(this.transformOrigin);
        Shape shape = this.shape;
        boolean z = this.clip;
        String strM486toStringimpl = Color.m486toStringimpl(this.ambientShadowColor);
        String strM486toStringimpl2 = Color.m486toStringimpl(this.spotShadowColor);
        String strM501toStringimpl = ColorKt.m501toStringimpl(this.blendMode);
        LayerOutsets layerOutsets = this.outsets;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SimpleGraphicsLayerModifier(scaleX=", f, ", scaleY=", f2, ", alpha = ");
        sbM.append(f3);
        sbM.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sbM.append(f4);
        sbM.append(", rotationX=0.0, rotationY=0.0, rotationZ=");
        sbM.append(f5);
        sbM.append(", cameraDistance=");
        sbM.append(f6);
        sbM.append(", transformOrigin=");
        sbM.append(strM520toStringimpl);
        sbM.append(", shape=");
        sbM.append(shape);
        sbM.append(", clip=");
        sbM.append(z);
        sbM.append(", renderEffect=null, ambientShadowColor=");
        sbM.append(strM486toStringimpl);
        sbM.append(", spotShadowColor=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, strM486toStringimpl2, ", compositingStrategy=CompositingStrategy(value=0), blendMode=", strM501toStringimpl, ", colorFilter=nulloutsets=");
        sbM.append(layerOutsets);
        sbM.append(")");
        return sbM.toString();
    }
}
