package androidx.compose.ui.graphics;

import androidx.collection.internal.Lock;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import coil3.size.SizeKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BlockGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {
    public Function1 layerBlock;

    public BlockGraphicsLayerModifier(Function1 function1) {
        this.layerBlock = function1;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Shape shape;
        boolean z;
        NodeCoordinator nodeCoordinatorM646requireCoordinator64DMado = HitTestResultKt.m646requireCoordinator64DMado(this, 2);
        if (nodeCoordinatorM646requireCoordinator64DMado.wasLayerBlockInvoked) {
            shape = nodeCoordinatorM646requireCoordinator64DMado.lastShape;
            z = nodeCoordinatorM646requireCoordinator64DMado.lastClip;
        } else {
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = ColorKt.reusableGraphicsLayerScope;
            if (reusableGraphicsLayerScope == null) {
                ColorKt.reusableGraphicsLayerScope = new ReusableGraphicsLayerScope();
            } else {
                reusableGraphicsLayerScope.reset$1$1();
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = ColorKt.reusableGraphicsLayerScope;
            reusableGraphicsLayerScope2.getClass();
            reusableGraphicsLayerScope2.graphicsDensity = nodeCoordinatorM646requireCoordinator64DMado.layoutNode.density;
            reusableGraphicsLayerScope2.size = SizeKt.m876toSizeozmzZPI(nodeCoordinatorM646requireCoordinator64DMado.measuredSize);
            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                this.layerBlock.invoke(reusableGraphicsLayerScope2);
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                shape = reusableGraphicsLayerScope2.shape;
                z = reusableGraphicsLayerScope2.clip;
            } catch (Throwable th) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
        if (z) {
            SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, shape);
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
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new ZIndexNode$$ExternalSyntheticLambda0((Object) placeableMo598measureBRTryo0, (Object) this, (byte) 24));
    }

    public final String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.layerBlock + ")";
    }
}
