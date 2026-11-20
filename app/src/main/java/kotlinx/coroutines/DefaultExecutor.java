package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final DefaultExecutor INSTANCE;
    public static final long KEEP_ALIVE_NANOS;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        defaultExecutor.incrementUseCount(false);
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = TimeUnit.MILLISECONDS.toNanos(l.longValue());
    }

    public final synchronized void acknowledgeShutdownIfNeeded() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            unsafe.putObjectVolatile(this, EventLoopImplBase._queue$volatile$FU$offset, (Object) null);
            unsafe.putObjectVolatile(this, EventLoopImplBase._delayed$volatile$FU$offset, (Object) null);
            notifyAll();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final void enqueue(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.enqueue(runnable);
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final Thread getThread() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(INSTANCE.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        long j2 = 0;
        if (j > 0) {
            j2 = j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j;
        }
        if (j2 >= 4611686018427387903L) {
            return NonDisposableHandle.INSTANCE;
        }
        long jNanoTime = System.nanoTime();
        EventLoopImplBase.DelayedRunnableTask delayedRunnableTask = new EventLoopImplBase.DelayedRunnableTask(j2 + jNanoTime, runnable);
        schedule(jNanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadLocalEventLoop.ref.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    _thread = null;
                    acknowledgeShutdownIfNeeded();
                    if (isEmpty()) {
                        return;
                    }
                    getThread();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jProcessNextEvent = processNextEvent();
                    if (jProcessNextEvent == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = KEEP_ALIVE_NANOS + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            if (isEmpty()) {
                                return;
                            }
                            getThread();
                            return;
                        }
                        if (jProcessNextEvent > j2) {
                            jProcessNextEvent = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jProcessNextEvent > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            if (isEmpty()) {
                                return;
                            }
                            getThread();
                            return;
                        }
                        LockSupport.parkNanos(this, jProcessNextEvent);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            if (!isEmpty()) {
                getThread();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "DefaultExecutor";
    }
}
