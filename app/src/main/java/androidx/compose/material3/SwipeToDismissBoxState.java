package androidx.compose.material3;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissBoxState {
    public final NodeChain anchoredDraggableState;
    public final Function1 positionalThreshold;

    public SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Function1 function1) {
        this.anchoredDraggableState = new NodeChain(swipeToDismissBoxValue);
        this.positionalThreshold = function1;
    }

    public final SwipeToDismissBoxValue getCurrentValue() {
        return (SwipeToDismissBoxValue) ((ParcelableSnapshotMutableState) this.anchoredDraggableState.innerCoordinator).getValue();
    }
}
