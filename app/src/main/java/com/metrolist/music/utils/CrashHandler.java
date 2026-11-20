package com.metrolist.music.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import com.metrolist.music.ui.screens.CrashActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public final Context applicationContext;
    public final Thread.UncaughtExceptionHandler defaultHandler = Thread.getDefaultUncaughtExceptionHandler();

    public CrashHandler(Context context) {
        this.applicationContext = context;
    }

    public static String buildCrashLog(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        string.getClass();
        StringBuilder sb = new StringBuilder("Auralys Crash Report\n");
        sb.append(StringsKt__StringsJVMKt.repeat(50, "="));
        sb.append("\n\n");
        sb.append("Manufacturer: " + Build.MANUFACTURER);
        sb.append('\n');
        sb.append("Device: " + Build.MODEL);
        sb.append('\n');
        sb.append("Android version: " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ")");
        sb.append("\nApp version: 4.1.0 (410)\n\n");
        sb.append(StringsKt__StringsJVMKt.repeat(50, "="));
        sb.append("\nStacktrace:\n");
        sb.append(StringsKt__StringsJVMKt.repeat(50, "="));
        sb.append("\n\n");
        sb.append(string);
        return sb.toString();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Context context = this.applicationContext;
        thread.getClass();
        th.getClass();
        try {
            String strBuildCrashLog = buildCrashLog(th);
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
            Intent intent = new Intent(context, (Class<?>) CrashActivity.class);
            intent.putExtra("crash_log", strBuildCrashLog);
            intent.addFlags(268468224);
            context.startActivity(intent);
            Process.killProcess(Process.myPid());
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        } catch (Exception unused) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
