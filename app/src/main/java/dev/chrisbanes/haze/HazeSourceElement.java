package dev.chrisbanes.haze;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ldev/chrisbanes/haze/HazeSourceElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Ldev/chrisbanes/haze/HazeSourceNode;", "haze_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HazeSourceElement extends ModifierNodeElement {
    public final HazeState state;

    public HazeSourceElement(HazeState hazeState) {
        this.state = hazeState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new HazeSourceNode(this.state);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HazeSourceElement) && this.state == ((HazeSourceElement) obj).state && Float.compare(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) == 0;
    }

    public final int hashCode() {
        return IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, this.state.hashCode() * 31, 31);
    }

    public final String toString() {
        return "HazeSourceElement(state=" + this.state + ", zIndex=0.0, key=null)";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        HazeSourceNode hazeSourceNode = (HazeSourceNode) node;
        hazeSourceNode.getClass();
        SnapshotStateList snapshotStateList = hazeSourceNode.state._areas;
        HazeArea hazeArea = hazeSourceNode.area;
        boolean zContains = snapshotStateList.contains(hazeArea);
        if (zContains) {
            HazeState hazeState = hazeSourceNode.state;
            hazeState.getClass();
            hazeArea.getClass();
            hazeState._areas.remove(hazeArea);
        }
        HazeState hazeState2 = this.state;
        hazeSourceNode.state = hazeState2;
        if (zContains) {
            hazeArea.getClass();
            hazeState2._areas.add(hazeArea);
        }
        hazeArea.zIndex$delegate.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
    }
}
