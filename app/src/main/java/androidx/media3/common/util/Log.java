package androidx.media3.common.util;

import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Log {
    public static final Object lock = new Object();
    public static ExecutorService staticInstance;

    public static String appendThrowableString(String str, Throwable th) {
        String strReplace;
        if (th != null) {
            synchronized (lock) {
                Throwable cause = th;
                while (true) {
                    if (cause == null) {
                        strReplace = android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
                        break;
                    }
                    try {
                        if (cause instanceof UnknownHostException) {
                            strReplace = "UnknownHostException (no network)";
                            break;
                        }
                        cause = cause.getCause();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } else {
            strReplace = null;
        }
        if (TextUtils.isEmpty(strReplace)) {
            return str;
        }
        return str + "\n  " + strReplace.replace("\n", "\n  ") + '\n';
    }

    public static void d(String str) {
        synchronized (lock) {
            appendThrowableString(str, null);
        }
    }

    public static void e(String str, String str2) {
        synchronized (lock) {
            android.util.Log.e(str, appendThrowableString(str2, null));
        }
    }

    public static synchronized Executor get() {
        ExecutorService executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor = staticInstance;
        if (executorServiceNewSingleThreadExecutor == null) {
            String str = Util.DEVICE_DEBUG_INFO;
            executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new Util$$ExternalSyntheticLambda2("ExoPlayer:BackgroundExecutor", (byte) 0));
            staticInstance = executorServiceNewSingleThreadExecutor;
        }
        return executorServiceNewSingleThreadExecutor;
    }

    public static void i(String str, String str2) {
        synchronized (lock) {
            android.util.Log.i(str, appendThrowableString(str2, null));
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void setCsdBuffers(MediaFormat mediaFormat, List list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(IntIntPair$$ExternalSyntheticOutline0.m(i, "csd-"), ByteBuffer.wrap((byte[]) list.get(i)));
        }
    }

    public static void w(String str, String str2) {
        synchronized (lock) {
            android.util.Log.w(str, appendThrowableString(str2, null));
        }
    }

    public static void d(String str, Exception exc) {
        synchronized (lock) {
            appendThrowableString(str, exc);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        synchronized (lock) {
            android.util.Log.e(str, appendThrowableString(str2, th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        synchronized (lock) {
            android.util.Log.w(str, appendThrowableString(str2, th));
        }
    }
}
