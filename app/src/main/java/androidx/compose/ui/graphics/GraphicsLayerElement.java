package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeCoordinator;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class GraphicsLayerElement extends ModifierNodeElement {
    public final float alpha;
    public final boolean clip;
    public final LayerOutsets outsets;
    public final float rotationZ;
    public final float scaleX;
    public final float scaleY;
    public final float shadowElevation;
    public final Shape shape;
    public final long transformOrigin;

    public GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, long j, Shape shape, boolean z, LayerOutsets layerOutsets) {
        this.scaleX = f;
        this.scaleY = f2;
        this.alpha = f3;
        this.shadowElevation = f4;
        this.rotationZ = f5;
        this.transformOrigin = j;
        this.shape = shape;
        this.clip = z;
        this.outsets = layerOutsets;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = new SimpleGraphicsLayerModifier();
        simpleGraphicsLayerModifier.scaleX = this.scaleX;
        simpleGraphicsLayerModifier.scaleY = this.scaleY;
        simpleGraphicsLayerModifier.alpha = this.alpha;
        simpleGraphicsLayerModifier.shadowElevation = this.shadowElevation;
        simpleGraphicsLayerModifier.rotationZ = this.rotationZ;
        simpleGraphicsLayerModifier.cameraDistance = 8.0f;
        simpleGraphicsLayerModifier.transformOrigin = this.transformOrigin;
        simpleGraphicsLayerModifier.shape = this.shape;
        simpleGraphicsLayerModifier.clip = this.clip;
        simpleGraphicsLayerModifier.ambientShadowColor = -72057594037927936L;
        simpleGraphicsLayerModifier.spotShadowColor = -72057594037927936L;
        simpleGraphicsLayerModifier.blendMode = (byte) 3;
        simpleGraphicsLayerModifier.outsets = this.outsets;
        simpleGraphicsLayerModifier.layerBlock = new TextKt$$ExternalSyntheticLambda2((byte) 20, simpleGraphicsLayerModifier);
        return simpleGraphicsLayerModifier;
    }

    public final boolean equals(Object obj) {
        boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(-72057594037927936L, -72057594037927936L);
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.scaleX, graphicsLayerElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerElement.alpha) == 0 && Float.compare(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) == 0 && Float.compare(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) == 0 && Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) == 0 && Float.compare(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) == 0 && Float.compare(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) == 0 && Float.compare(this.rotationZ, graphicsLayerElement.rotationZ) == 0 && Float.compare(8.0f, 8.0f) == 0 && TransformOrigin.m519equalsimpl0(this.transformOrigin, graphicsLayerElement.transformOrigin) && Intrinsics.areEqual(this.shape, graphicsLayerElement.shape) && this.clip == graphicsLayerElement.clip && zM1869equalsimpl0 && zM1869equalsimpl0 && Intrinsics.areEqual(this.outsets, graphicsLayerElement.outsets);
    }

    public final int hashCode() {
        return this.outsets.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(3, IntIntPair$$ExternalSyntheticOutline0.m(0, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.shape.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(8.0f, IntIntPair$$ExternalSyntheticOutline0.m(this.rotationZ, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(this.shadowElevation, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(this.alpha, IntIntPair$$ExternalSyntheticOutline0.m(this.scaleY, Float.hashCode(this.scaleX) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31, this.transformOrigin)) * 31, this.clip, 961), 31, -72057594037927936L), 31, -72057594037927936L), 31), 961);
    }

    public final String toString() {
        String strM520toStringimpl = TransformOrigin.m520toStringimpl(this.transformOrigin);
        String strM486toStringimpl = Color.m486toStringimpl(-72057594037927936L);
        String strM486toStringimpl2 = Color.m486toStringimpl(-72057594037927936L);
        String strM501toStringimpl = ColorKt.m501toStringimpl(3);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("GraphicsLayerElement(scaleX=", this.scaleX, ", scaleY=", this.scaleY, ", alpha=");
        sbM.append(this.alpha);
        sbM.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        sbM.append(this.shadowElevation);
        sbM.append(", rotationX=0.0, rotationY=0.0, rotationZ=");
        sbM.append(this.rotationZ);
        sbM.append(", cameraDistance=8.0, transformOrigin=");
        sbM.append(strM520toStringimpl);
        sbM.append(", shape=");
        sbM.append(this.shape);
        sbM.append(", clip=");
        sbM.append(this.clip);
        sbM.append(", renderEffect=null, ambientShadowColor=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, strM486toStringimpl, ", spotShadowColor=", strM486toStringimpl2, ", compositingStrategy=CompositingStrategy(value=0), blendMode=");
        sbM.append(strM501toStringimpl);
        sbM.append(", colorFilter=null, outsets=");
        sbM.append(this.outsets);
        sbM.append(")");
        return sbM.toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        NodeCoordinator nodeCoordinator;
        SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = (SimpleGraphicsLayerModifier) node;
        simpleGraphicsLayerModifier.scaleX = this.scaleX;
        simpleGraphicsLayerModifier.scaleY = this.scaleY;
        simpleGraphicsLayerModifier.alpha = this.alpha;
        simpleGraphicsLayerModifier.shadowElevation = this.shadowElevation;
        simpleGraphicsLayerModifier.rotationZ = this.rotationZ;
        simpleGraphicsLayerModifier.cameraDistance = 8.0f;
        simpleGraphicsLayerModifier.transformOrigin = this.transformOrigin;
        simpleGraphicsLayerModifier.shape = this.shape;
        simpleGraphicsLayerModifier.clip = this.clip;
        simpleGraphicsLayerModifier.ambientShadowColor = -72057594037927936L;
        simpleGraphicsLayerModifier.spotShadowColor = -72057594037927936L;
        simpleGraphicsLayerModifier.blendMode = (byte) 3;
        simpleGraphicsLayerModifier.outsets = this.outsets;
        TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = simpleGraphicsLayerModifier.layerBlock;
        if (simpleGraphicsLayerModifier.node.isAttached && (nodeCoordinator = HitTestResultKt.m646requireCoordinator64DMado(simpleGraphicsLayerModifier, 2).wrapped) != null) {
            nodeCoordinator.updateLayerBlock(textKt$$ExternalSyntheticLambda2, true);
        }
    }
}
