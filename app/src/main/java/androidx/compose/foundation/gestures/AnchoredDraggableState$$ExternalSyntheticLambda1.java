package androidx.compose.foundation.gestures;

import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AnchoredDraggableState$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NodeChain f$0;

    public /* synthetic */ AnchoredDraggableState$$ExternalSyntheticLambda1(NodeChain nodeChain, byte b) {
        this.$r8$classId = b;
        this.f$0 = nodeChain;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        NodeChain nodeChain = this.f$0;
        switch (b) {
            case 0:
                Object value = ((ParcelableSnapshotMutableState) nodeChain.buffers).getValue();
                if (value != null) {
                    return value;
                }
                float floatValue = ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) nodeChain.innerCoordinator;
                if (Float.isNaN(floatValue)) {
                    return parcelableSnapshotMutableState.getValue();
                }
                float fPositionOf = nodeChain.getAnchors().positionOf(parcelableSnapshotMutableState.getValue());
                if (Float.isNaN(fPositionOf) || floatValue == fPositionOf) {
                    return parcelableSnapshotMutableState.getValue();
                }
                Object objClosestAnchor = nodeChain.getAnchors().closestAnchor(floatValue);
                return objClosestAnchor == null ? parcelableSnapshotMutableState.getValue() : objClosestAnchor;
            case 1:
                return nodeChain.getAnchors();
            default:
                return new Pair(nodeChain.getAnchors(), ((DerivedSnapshotState) nodeChain.tail).getValue());
        }
    }
}
