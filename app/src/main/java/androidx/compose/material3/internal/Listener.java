package androidx.compose.material3.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, State {
    public final ParcelableSnapshotMutableState accessibilityEnabled$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public final boolean listenToSwitchAccessState;
    public final boolean listenToVoiceAccessState;
    public final Listener$otherA11yServicesListener$1 otherA11yServicesListener;
    public final Listener$touchExplorationListener$1 touchExplorationListener;

    public Listener(boolean z, boolean z2, boolean z3) {
        this.listenToSwitchAccessState = z2;
        this.listenToVoiceAccessState = z3;
        Listener$otherA11yServicesListener$1 listener$otherA11yServicesListener$1 = null;
        this.touchExplorationListener = z ? new Listener$touchExplorationListener$1() : null;
        if ((z2 || z3) && Build.VERSION.SDK_INT >= 33) {
            listener$otherA11yServicesListener$1 = new Listener$otherA11yServicesListener$1(this);
        }
        this.otherA11yServicesListener = listener$otherA11yServicesListener$1;
    }

    public static boolean getSwitchAccessEnabled(AccessibilityManager accessibilityManager) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16);
        int size = enabledAccessibilityServiceList.size();
        for (int i = 0; i < size; i++) {
            String settingsActivityName = enabledAccessibilityServiceList.get(i).getSettingsActivityName();
            if (settingsActivityName != null && StringsKt.contains(settingsActivityName, "SwitchAccess", true)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getVoiceAccessEnabled(AccessibilityManager accessibilityManager) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16);
        int size = enabledAccessibilityServiceList.size();
        for (int i = 0; i < size; i++) {
            String settingsActivityName = enabledAccessibilityServiceList.get(i).getSettingsActivityName();
            if (settingsActivityName != null && StringsKt.contains(settingsActivityName, "VoiceAccess", true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        boolean z;
        if (((Boolean) this.accessibilityEnabled$delegate.getValue()).booleanValue()) {
            z = true;
            Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.touchExplorationListener;
            if (listener$touchExplorationListener$1 == null || !((Boolean) listener$touchExplorationListener$1.enabled$delegate.getValue()).booleanValue()) {
                boolean z2 = this.listenToSwitchAccessState;
                Listener$otherA11yServicesListener$1 listener$otherA11yServicesListener$1 = this.otherA11yServicesListener;
                if ((!z2 || listener$otherA11yServicesListener$1 == null || !((Boolean) listener$otherA11yServicesListener$1.switchAccessEnabled$delegate.getValue()).booleanValue()) && (!this.listenToVoiceAccessState || listener$otherA11yServicesListener$1 == null || !((Boolean) listener$otherA11yServicesListener$1.voiceAccessEnabled$delegate.getValue()).booleanValue())) {
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    public final void register(AccessibilityManager accessibilityManager) {
        Listener$otherA11yServicesListener$1 listener$otherA11yServicesListener$1;
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(accessibilityManager.isEnabled()));
        accessibilityManager.addAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.touchExplorationListener;
        if (listener$touchExplorationListener$1 != null) {
            listener$touchExplorationListener$1.enabled$delegate.setValue(Boolean.valueOf(accessibilityManager.isTouchExplorationEnabled()));
            accessibilityManager.addTouchExplorationStateChangeListener(listener$touchExplorationListener$1);
        }
        if (Build.VERSION.SDK_INT < 33 || (listener$otherA11yServicesListener$1 = this.otherA11yServicesListener) == null) {
            return;
        }
        listener$otherA11yServicesListener$1.switchAccessEnabled$delegate.setValue(Boolean.valueOf(getSwitchAccessEnabled(accessibilityManager)));
        listener$otherA11yServicesListener$1.voiceAccessEnabled$delegate.setValue(Boolean.valueOf(getVoiceAccessEnabled(accessibilityManager)));
        accessibilityManager.addAccessibilityServicesStateChangeListener(listener$otherA11yServicesListener$1);
    }

    public final void unregister(AccessibilityManager accessibilityManager) {
        Listener$otherA11yServicesListener$1 listener$otherA11yServicesListener$1;
        accessibilityManager.removeAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 listener$touchExplorationListener$1 = this.touchExplorationListener;
        if (listener$touchExplorationListener$1 != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(listener$touchExplorationListener$1);
        }
        if (Build.VERSION.SDK_INT < 33 || (listener$otherA11yServicesListener$1 = this.otherA11yServicesListener) == null) {
            return;
        }
        accessibilityManager.removeAccessibilityServicesStateChangeListener(listener$otherA11yServicesListener$1);
    }
}
