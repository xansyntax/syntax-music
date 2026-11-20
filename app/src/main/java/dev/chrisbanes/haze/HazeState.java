package dev.chrisbanes.haze;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HazeState {
    public final SnapshotStateList _areas = new SnapshotStateList();
    public final ParcelableSnapshotMutableState blurEnabled$delegate;

    public HazeState(boolean z) {
        this.blurEnabled$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z));
    }
}
