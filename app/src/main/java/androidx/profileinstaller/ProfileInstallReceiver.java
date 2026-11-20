package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.metrolist.music.playback.DownloadUtil$$ExternalSyntheticLambda2;
import java.io.File;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            Encoding.writeProfile(context, new DownloadUtil$$ExternalSyntheticLambda2((byte) 3), new ConnectionPool(this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                ConnectionPool connectionPool = new ConnectionPool(this);
                try {
                    Encoding.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    connectionPool.onResultReceived(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    connectionPool.onResultReceived(7, e);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            Process.sendSignal(Process.myPid(), 10);
            setResultCode(12);
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        ConnectionPool connectionPool2 = new ConnectionPool(this);
        if ("DROP_SHADER_CACHE".equals(string2)) {
            if (Encoding.deleteFilesRecursively(Build.VERSION.SDK_INT >= 34 ? context.createDeviceProtectedStorageContext().getCacheDir() : context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
                connectionPool2.onResultReceived(14, null);
                return;
            } else {
                connectionPool2.onResultReceived(15, null);
                return;
            }
        }
        if (!"SAVE_PROFILE".equals(string2)) {
            connectionPool2.onResultReceived(16, null);
        } else {
            Process.sendSignal(extras.getInt("EXTRA_PID", Process.myPid()), 10);
            connectionPool2.onResultReceived(12, null);
        }
    }
}
