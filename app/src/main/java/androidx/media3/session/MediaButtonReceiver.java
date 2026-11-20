package androidx.media3.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    public static final String[] ACTIONS = {"android.intent.action.MEDIA_BUTTON", "androidx.media3.session.MediaLibraryService", "androidx.media3.session.MediaSessionService"};

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ComponentName componentName;
        if (intent == null || !Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON") || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("Ignore unsupported intent: " + intent);
            return;
        }
        Bundle extras = intent.getExtras();
        extras.getClass();
        KeyEvent keyEvent = (KeyEvent) extras.getParcelable("android.intent.extra.KEY_EVENT");
        if (keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return;
        }
        if (keyEvent.getKeyCode() != 126 && keyEvent.getKeyCode() != 85 && keyEvent.getKeyCode() != 79) {
            Log.w("MediaButtonReceiver", "Ignore key event that is not a `play` command on API 26 or above to avoid an 'ForegroundServiceDidNotStartInTimeException'");
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = ACTIONS;
            if (i >= 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Arrays.toString(strArr), "Could not find any Service that handles any of the actions ");
                return;
            }
            String str = strArr[i];
            PackageManager packageManager = context.getPackageManager();
            Intent intent2 = new Intent(str);
            intent2.setPackage(context.getPackageName());
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent2, 0);
            if (listQueryIntentServices.size() == 1) {
                ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
            } else {
                if (!listQueryIntentServices.isEmpty()) {
                    StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Expected 1 service that handles ", str, ", found ");
                    sbM4m.append(listQueryIntentServices.size());
                    throw new IllegalStateException(sbM4m.toString());
                }
                componentName = null;
            }
            if (componentName != null) {
                Intent intent3 = new Intent();
                intent3.setComponent(componentName);
                intent3.fillIn(intent, 0);
                try {
                    context.startForegroundService(intent3);
                    return;
                } catch (IllegalStateException e) {
                    if (Build.VERSION.SDK_INT < 31 || !(e instanceof ForegroundServiceStartNotAllowedException)) {
                        throw e;
                    }
                    Log.e("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + ((ForegroundServiceStartNotAllowedException) e).getMessage());
                    return;
                }
            }
            i++;
        }
    }
}
