package androidx.compose.ui.platform;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAccessibilityManager implements AccessibilityManager {
    public final android.view.accessibility.AccessibilityManager accessibilityManager;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api29Impl {
        public static final int getRecommendedTimeoutMillis(android.view.accessibility.AccessibilityManager accessibilityManager, int i, int i2) {
            return accessibilityManager.getRecommendedTimeoutMillis(i, i2);
        }
    }

    public AndroidAccessibilityManager(Context context) {
        Object systemService = context.getSystemService("accessibility");
        systemService.getClass();
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
    }
}
