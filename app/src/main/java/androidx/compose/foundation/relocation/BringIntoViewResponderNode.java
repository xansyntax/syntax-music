package androidx.compose.foundation.relocation;

import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewResponderNode extends Modifier.Node implements BringIntoViewModifierNode, LayoutAwareModifierNode {
    public boolean hasBeenPlaced;
    public ContentInViewNode responder;

    public static final Rect bringIntoView$localRect(BringIntoViewResponderNode bringIntoViewResponderNode, NodeCoordinator nodeCoordinator, ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2) {
        Rect rect;
        if (bringIntoViewResponderNode.isAttached && bringIntoViewResponderNode.hasBeenPlaced) {
            NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(bringIntoViewResponderNode);
            if (!nodeCoordinator.getTail().isAttached) {
                nodeCoordinator = null;
            }
            if (nodeCoordinator != null && (rect = (Rect) componentRegistry$Builder$$ExternalSyntheticLambda2.invoke()) != null) {
                return rect.m446translatek4lQ0M(nodeCoordinatorRequireLayoutCoordinates.localBoundingBoxOf(nodeCoordinator, false).m445getTopLeftF1C5BW0());
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
    public final Object bringIntoView(NodeCoordinator nodeCoordinator, ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2, ContinuationImpl continuationImpl) {
        Object objCoroutineScope = AwaitKt.coroutineScope(new NavHostKt$NavHost$33$1(this, nodeCoordinator, componentRegistry$Builder$$ExternalSyntheticLambda2, new GapComposer$$ExternalSyntheticLambda0(this, nodeCoordinator, componentRegistry$Builder$$ExternalSyntheticLambda2, (byte) 3), null), continuationImpl);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
        this.hasBeenPlaced = true;
    }
}
