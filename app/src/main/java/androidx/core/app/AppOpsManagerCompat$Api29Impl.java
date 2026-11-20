package androidx.core.app;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppOpsManagerCompat$Api29Impl {
    public static String getOpPackageName(Context context) {
        return context.getOpPackageName();
    }

    public static void setAllowSystemGeneratedContextualActions(Notification.Builder builder) {
        builder.setAllowSystemGeneratedContextualActions(true);
    }

    public static void setBubbleMetadata(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void setContextual(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
