package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Listener$touchExplorationListener$1 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final ParcelableSnapshotMutableState enabled$delegate = Stack.mutableStateOf$default(Boolean.FALSE);

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.enabled$delegate.setValue(Boolean.valueOf(z));
    }
}
