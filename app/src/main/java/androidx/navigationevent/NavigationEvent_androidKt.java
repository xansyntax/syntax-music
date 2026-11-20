package androidx.navigationevent;

import android.app.ActivityOptions;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEvent_androidKt {
    public static final NavigationEvent NavigationEvent(BackEvent backEvent) {
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        return new NavigationEvent(backEvent.getSwipeEdge(), backEvent.getProgress(), touchX, touchY, Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
    }

    public static int getChecked(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getChecked();
    }

    public static int getExpandedState(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExpandedState();
    }

    public static CharSequence getSupplementalDescription(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getSupplementalDescription();
    }

    public static boolean isFieldRequired(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isFieldRequired();
    }

    public static void setAllowPassThroughOnTouchOutside(ActivityOptions activityOptions, boolean z) {
        activityOptions.setAllowPassThroughOnTouchOutside(z);
    }
}
