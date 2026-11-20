package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableAnchorsNode extends Modifier.Node implements LayoutModifierNode {
    public Function2 anchors;
    public boolean didInitializeAnchors;
    public Orientation orientation;
    public NodeChain state;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        boolean z = true;
        if (!measureScope.isLookingAhead() || !this.didInitializeAnchors) {
            Pair pair = (Pair) this.anchors.invoke(new IntSize((((long) placeableMo598measureBRTryo0.width) << 32) | (((long) placeableMo598measureBRTryo0.height) & 4294967295L)), new Constraints(j));
            DefaultDraggableAnchors defaultDraggableAnchors = (DefaultDraggableAnchors) pair.first;
            Object obj = pair.second;
            NodeChain nodeChain = this.state;
            DefaultDraggableAnchors anchors = nodeChain.getAnchors();
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) nodeChain.buffers;
            if (!Intrinsics.areEqual(anchors, defaultDraggableAnchors)) {
                ((ParcelableSnapshotMutableState) nodeChain.stack).setValue(defaultDraggableAnchors);
                MutatorMutex mutatorMutex = (MutatorMutex) nodeChain.sentinelHead;
                MutexImpl mutexImpl = mutatorMutex.mutex;
                MutexImpl mutexImpl2 = mutatorMutex.mutex;
                boolean zTryLock = mutexImpl.tryLock();
                if (zTryLock) {
                    try {
                        AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) nodeChain.cachedDiffer;
                        float fPositionOf = nodeChain.getAnchors().positionOf(obj);
                        if (!Float.isNaN(fPositionOf)) {
                            anchoredDraggableState$anchoredDragScope$1.dragTo(fPositionOf, CropImageView.DEFAULT_ASPECT_RATIO);
                            parcelableSnapshotMutableState.setValue(null);
                        }
                        ((ParcelableSnapshotMutableState) nodeChain.innerCoordinator).setValue(obj);
                        ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).setValue(obj);
                        mutexImpl2.unlock(null);
                    } catch (Throwable th) {
                        mutexImpl2.unlock(null);
                        throw th;
                    }
                }
                if (!zTryLock) {
                    parcelableSnapshotMutableState.setValue(obj);
                }
            }
            this.didInitializeAnchors = true;
        }
        if (!measureScope.isLookingAhead() && !this.didInitializeAnchors) {
            z = false;
        }
        this.didInitializeAnchors = z;
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new UtilsKt$$ExternalSyntheticLambda0((Object) measureScope, (Object) this, (Object) placeableMo598measureBRTryo0, (byte) 19));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.didInitializeAnchors = false;
    }
}
