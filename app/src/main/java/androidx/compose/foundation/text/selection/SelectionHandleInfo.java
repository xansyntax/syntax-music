package androidx.compose.foundation.text.selection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionHandleInfo {
    public final SelectionHandleAnchor anchor;
    public final Handle handle;
    public final long position;
    public final boolean visible;

    public SelectionHandleInfo(Handle handle, long j, SelectionHandleAnchor selectionHandleAnchor, boolean z) {
        this.handle = handle;
        this.position = j;
        this.anchor = selectionHandleAnchor;
        this.visible = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        return this.handle == selectionHandleInfo.handle && Offset.m434equalsimpl0(this.position, selectionHandleInfo.position) && this.anchor == selectionHandleInfo.anchor && this.visible == selectionHandleInfo.visible;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.visible) + ((this.anchor.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.handle.hashCode() * 31, 31, this.position)) * 31);
    }

    public final String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + Offset.m441toStringimpl(this.position) + ", anchor=" + this.anchor + ", visible=" + this.visible + ")";
    }
}
