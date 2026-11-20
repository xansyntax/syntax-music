package androidx.compose.ui.focus;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.room.RoomDatabase$closeBarrier$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusInvalidationManager {
    public final MutableScatterSet focusEventNodes;
    public final FocusOwnerImpl focusOwner;
    public final MutableScatterSet focusTargetNodes;
    public boolean isInvalidationScheduled;
    public final AndroidComposeView owner;

    public FocusInvalidationManager(FocusOwnerImpl focusOwnerImpl, AndroidComposeView androidComposeView) {
        this.focusOwner = focusOwnerImpl;
        this.owner = androidComposeView;
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.focusTargetNodes = new MutableScatterSet();
        this.focusEventNodes = new MutableScatterSet();
    }

    public final void scheduleInvalidation$2() {
        if (this.isInvalidationScheduled) {
            return;
        }
        RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1 = new RoomDatabase$closeBarrier$1(0, this, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0, (byte) 3);
        MutableObjectList mutableObjectList = this.owner.endApplyChangesListeners;
        if (!mutableObjectList.contains(roomDatabase$closeBarrier$1)) {
            mutableObjectList.add(roomDatabase$closeBarrier$1);
        }
        this.isInvalidationScheduled = true;
    }
}
