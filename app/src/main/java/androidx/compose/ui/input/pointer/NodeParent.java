package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class NodeParent {
    public final MutableVector children = new MutableVector(new Node[16]);
    public final MutableObjectList removeMatchingPointerInputModifierNodeList = new MutableObjectList(10);

    public boolean buildCache(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        MutableVector mutableVector = this.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z2 = ((Node) objArr[i2]).buildCache(longSparseArray, layoutCoordinates, internalPointerEvent, z) || z2;
        }
        return z2;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        MutableVector mutableVector = this.children;
        int i = mutableVector.size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            }
            if (((Node) mutableVector.content[i]).pointerIds.size == 0) {
                mutableVector.removeAt(i);
            }
        }
    }
}
