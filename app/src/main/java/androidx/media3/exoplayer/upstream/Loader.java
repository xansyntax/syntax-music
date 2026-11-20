package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda2;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.util.ReleasableExecutor$1;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import java.io.IOException;
import java.util.concurrent.Executors;
import kotlin.time.InstantParseResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Loader {
    public static final InstantParseResult.Success DONT_RETRY;
    public static final InstantParseResult.Success DONT_RETRY_FATAL;
    public LoadTask currentTask;
    public final ReleasableExecutor$1 downloadExecutor;
    public IOException fatalError;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Callback {
        void onLoadCanceled(Loadable loadable, long j, long j2, boolean z);

        void onLoadCompleted(Loadable loadable, long j, long j2);

        InstantParseResult.Success onLoadError(Loadable loadable, long j, long j2, IOException iOException, int i);

        void onLoadStarted(Loadable loadable, long j, long j2, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LoadTask extends Handler implements Runnable {
        public Callback callback;
        public boolean canceled;
        public IOException currentError;
        public final int defaultMinRetryCount;
        public int errorCount;
        public Thread executorThread;
        public final Loadable loadable;
        public volatile boolean released;
        public final long startTimeMs;

        public LoadTask(Looper looper, Loadable loadable, Callback callback, int i, long j) {
            super(looper);
            this.loadable = loadable;
            this.callback = callback;
            this.defaultMinRetryCount = i;
            this.startTimeMs = j;
        }

        public final void cancel(boolean z) {
            this.released = z;
            this.currentError = null;
            if (hasMessages(1)) {
                this.canceled = true;
                removeMessages(1);
                if (!z) {
                    sendEmptyMessage(2);
                }
            } else {
                synchronized (this) {
                    try {
                        this.canceled = true;
                        this.loadable.cancelLoad();
                        Thread thread = this.executorThread;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z) {
                Loader.this.currentTask = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Callback callback = this.callback;
                callback.getClass();
                callback.onLoadCanceled(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        public final void execute() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.startTimeMs;
            Callback callback = this.callback;
            callback.getClass();
            callback.onLoadStarted(this.loadable, jElapsedRealtime, j, this.errorCount);
            this.currentError = null;
            Loader loader = Loader.this;
            ReleasableExecutor$1 releasableExecutor$1 = loader.downloadExecutor;
            LoadTask loadTask = loader.currentTask;
            loadTask.getClass();
            releasableExecutor$1.execute(loadTask);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.released) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                execute();
                return;
            }
            if (i == 4) {
                throw ((Error) message.obj);
            }
            Loader.this.currentTask = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.startTimeMs;
            Callback callback = this.callback;
            callback.getClass();
            if (this.canceled) {
                callback.onLoadCanceled(this.loadable, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 2) {
                try {
                    callback.onLoadCompleted(this.loadable, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    Log.e("LoadTask", "Unexpected exception handling load completed", e);
                    Loader.this.fatalError = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.currentError = iOException;
            int i3 = this.errorCount + 1;
            this.errorCount = i3;
            InstantParseResult.Success successOnLoadError = callback.onLoadError(this.loadable, jElapsedRealtime, j, iOException, i3);
            int i4 = successOnLoadError.nanosecondsOfSecond;
            if (i4 == 3) {
                Loader.this.fatalError = this.currentError;
                return;
            }
            if (i4 != 2) {
                if (i4 == 1) {
                    this.errorCount = 1;
                }
                long jMin = successOnLoadError.epochSeconds;
                if (jMin == -9223372036854775807L) {
                    jMin = Math.min((this.errorCount - 1) * CIOKt.DEFAULT_HTTP_POOL_SIZE, 5000);
                }
                Loader loader = Loader.this;
                UtilsKt.checkState(loader.currentTask == null);
                loader.currentTask = this;
                if (jMin > 0) {
                    sendEmptyMessageDelayed(1, jMin);
                } else {
                    execute();
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = this.canceled;
                    this.executorThread = Thread.currentThread();
                }
                if (!z) {
                    Trace.beginSection("load:".concat(this.loadable.getClass().getSimpleName()));
                    try {
                        this.loadable.load();
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.executorThread = null;
                    Thread.interrupted();
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e) {
                if (this.released) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (Exception e2) {
                if (this.released) {
                    return;
                }
                Log.e("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(3, new UnexpectedLoaderException(e2)).sendToTarget();
            } catch (OutOfMemoryError e3) {
                if (this.released) {
                    return;
                }
                Log.e("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
            } catch (Error e4) {
                if (!this.released) {
                    Log.e("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Loadable {
        void cancelLoad();

        void load();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            String str;
            StringBuilder sb = new StringBuilder("Unexpected ");
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                str = ": " + th.getMessage();
            } else {
                str = "";
            }
            sb.append(str);
            super(sb.toString(), th);
        }
    }

    static {
        long j = -9223372036854775807L;
        DONT_RETRY = new InstantParseResult.Success(2, j);
        DONT_RETRY_FATAL = new InstantParseResult.Success(3, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Loader(String str) {
        String strConcat = "ExoPlayer:Loader:".concat(str);
        String str2 = Util.DEVICE_DEBUG_INFO;
        this(new ReleasableExecutor$1(Executors.newSingleThreadExecutor(new Util$$ExternalSyntheticLambda2(strConcat, (byte) 0)), new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 12)));
    }

    public final boolean isLoading() {
        return this.currentTask != null;
    }

    public Loader(ReleasableExecutor$1 releasableExecutor$1) {
        this.downloadExecutor = releasableExecutor$1;
    }
}
