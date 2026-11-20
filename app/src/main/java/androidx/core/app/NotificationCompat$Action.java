package androidx.core.app;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.os.HandlerCompat$Api28Impl;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Action {
    public final PendingIntent actionIntent;
    public final int icon;
    public final boolean mAllowGeneratedReplies;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mShowsUserInterface;
    public final CharSequence title;

    public NotificationCompat$Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        this.mShowsUserInterface = true;
        this.mIcon = iconCompat;
        if (iconCompat != null) {
            int iIntValue = iconCompat.mType;
            if (iIntValue == -1) {
                Object obj = iconCompat.mObj1;
                if (Build.VERSION.SDK_INT >= 28) {
                    iIntValue = HandlerCompat$Api28Impl.getType(obj);
                } else {
                    try {
                        iIntValue = ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
                    } catch (IllegalAccessException e) {
                        Log.e("IconCompat", "Unable to get icon type " + obj, e);
                        iIntValue = -1;
                    } catch (NoSuchMethodException e2) {
                        Log.e("IconCompat", "Unable to get icon type " + obj, e2);
                        iIntValue = -1;
                    } catch (InvocationTargetException e3) {
                        Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                        iIntValue = -1;
                    }
                }
            }
            if (iIntValue == 2) {
                this.icon = iconCompat.getResId();
            }
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
    }
}
