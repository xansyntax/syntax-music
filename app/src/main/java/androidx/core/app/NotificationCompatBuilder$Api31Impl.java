package androidx.core.app;

import android.app.Notification;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api31Impl {
    public static void setAuthenticationRequired(Notification.Action.Builder builder) {
        builder.setAuthenticationRequired(false);
    }

    public static void setForegroundServiceBehavior(Notification.Builder builder, int i) {
        builder.setForegroundServiceBehavior(i);
    }
}
