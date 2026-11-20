package androidx.compose.foundation.lazy;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/ParentSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/ParentSizeNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParentSizeElement extends ModifierNodeElement {
    public final State heightState;
    public final State widthState;

    public ParentSizeElement(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2) {
        this.widthState = parcelableSnapshotMutableIntState;
        this.heightState = parcelableSnapshotMutableIntState2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ParentSizeNode parentSizeNode = new ParentSizeNode();
        parentSizeNode.fraction = 1.0f;
        parentSizeNode.widthState = this.widthState;
        parentSizeNode.heightState = this.heightState;
        return parentSizeNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentSizeElement)) {
            return false;
        }
        ParentSizeElement parentSizeElement = (ParentSizeElement) obj;
        return Intrinsics.areEqual(this.widthState, parentSizeElement.widthState) && Intrinsics.areEqual(this.heightState, parentSizeElement.heightState);
    }

    public final int hashCode() {
        State state = this.widthState;
        int iHashCode = (state != null ? state.hashCode() : 0) * 31;
        State state2 = this.heightState;
        return Float.hashCode(1.0f) + ((iHashCode + (state2 != null ? state2.hashCode() : 0)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ParentSizeNode parentSizeNode = (ParentSizeNode) node;
        parentSizeNode.fraction = 1.0f;
        parentSizeNode.widthState = this.widthState;
        parentSizeNode.heightState = this.heightState;
    }
}
