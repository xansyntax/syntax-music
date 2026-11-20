package androidx.compose.foundation.gestures;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$anchoredDragScope$1 {
    public float distance = Float.NaN;
    public Object leftBound;
    public Object rightBound;
    public final /* synthetic */ NodeChain this$0;

    public AnchoredDraggableState$anchoredDragScope$1(NodeChain nodeChain) {
        this.this$0 = nodeChain;
    }

    public final void dragTo(float f, float f2) {
        NodeChain nodeChain = this.this$0;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) nodeChain.innerCoordinator;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) nodeChain.head;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
        parcelableSnapshotMutableFloatState.setFloatValue(f);
        ((ParcelableSnapshotMutableFloatState) nodeChain.current).setFloatValue(f2);
        if (Float.isNaN(floatValue)) {
            return;
        }
        boolean z = f >= floatValue;
        if (parcelableSnapshotMutableFloatState.getFloatValue() == nodeChain.getAnchors().positionOf(parcelableSnapshotMutableState.getValue())) {
            Object objClosestAnchor = nodeChain.getAnchors().closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue() + (z ? 1.0f : -1.0f), z);
            if (objClosestAnchor == null) {
                objClosestAnchor = parcelableSnapshotMutableState.getValue();
            }
            if (z) {
                this.leftBound = parcelableSnapshotMutableState.getValue();
                this.rightBound = objClosestAnchor;
            } else {
                this.leftBound = objClosestAnchor;
                this.rightBound = parcelableSnapshotMutableState.getValue();
            }
        } else {
            Object objClosestAnchor2 = nodeChain.getAnchors().closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue(), false);
            if (objClosestAnchor2 == null) {
                objClosestAnchor2 = parcelableSnapshotMutableState.getValue();
            }
            Object objClosestAnchor3 = nodeChain.getAnchors().closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue(), true);
            if (objClosestAnchor3 == null) {
                objClosestAnchor3 = parcelableSnapshotMutableState.getValue();
            }
            this.leftBound = objClosestAnchor2;
            this.rightBound = objClosestAnchor3;
        }
        DefaultDraggableAnchors anchors = nodeChain.getAnchors();
        Object obj = this.leftBound;
        obj.getClass();
        float fPositionOf = anchors.positionOf(obj);
        DefaultDraggableAnchors anchors2 = nodeChain.getAnchors();
        Object obj2 = this.rightBound;
        obj2.getClass();
        this.distance = Math.abs(fPositionOf - anchors2.positionOf(obj2));
        if (Math.abs(parcelableSnapshotMutableFloatState.getFloatValue() - nodeChain.getAnchors().positionOf(parcelableSnapshotMutableState.getValue())) >= this.distance / 2.0f) {
            Object value = z ? this.rightBound : this.leftBound;
            if (value == null) {
                value = parcelableSnapshotMutableState.getValue();
            }
            if (((Boolean) ((Function1) nodeChain.layoutNode).invoke(value)).booleanValue()) {
                parcelableSnapshotMutableState.setValue(value);
            }
        }
    }
}
