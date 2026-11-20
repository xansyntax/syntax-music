package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager$AccessibilityServicesStateChangeListener;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Listener$otherA11yServicesListener$1 implements AccessibilityManager$AccessibilityServicesStateChangeListener {
    public final ParcelableSnapshotMutableState switchAccessEnabled$delegate;
    public final ParcelableSnapshotMutableState voiceAccessEnabled$delegate;

    public Listener$otherA11yServicesListener$1(Listener listener) {
        Boolean bool = Boolean.FALSE;
        this.switchAccessEnabled$delegate = Stack.mutableStateOf$default(bool);
        this.voiceAccessEnabled$delegate = Stack.mutableStateOf$default(bool);
    }

    public final void onAccessibilityServicesStateChanged(AccessibilityManager accessibilityManager) {
        this.switchAccessEnabled$delegate.setValue(Boolean.valueOf(Listener.getSwitchAccessEnabled(accessibilityManager)));
        this.voiceAccessEnabled$delegate.setValue(Boolean.valueOf(Listener.getVoiceAccessEnabled(accessibilityManager)));
    }
}
