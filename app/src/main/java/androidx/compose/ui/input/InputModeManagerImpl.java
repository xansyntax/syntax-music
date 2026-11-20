package androidx.compose.ui.input;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InputModeManagerImpl implements InputModeManager {
    public final ParcelableSnapshotMutableState inputMode$delegate;

    public InputModeManagerImpl(int i) {
        this.inputMode$delegate = Stack.mutableStateOf$default(new InputMode(i));
    }
}
