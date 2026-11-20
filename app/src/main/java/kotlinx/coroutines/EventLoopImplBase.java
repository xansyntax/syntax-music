package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import java.util.concurrent.locks.LockSupport;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EventLoopImplBase extends EventLoop implements Delay {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final /* synthetic */ long _delayed$volatile$FU$offset;
    public static final /* synthetic */ long _isCompleted$volatile$FU$offset;
    public static final /* synthetic */ long _queue$volatile$FU$offset;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuationImpl cont;

        public DelayedResumeTask(long j, CancellableContinuationImpl cancellableContinuationImpl) {
            super(j);
            this.cont = cancellableContinuationImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.cont;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DelayedRunnableTask extends DelayedTask {
        public final Runnable block;

        public DelayedRunnableTask(long j, Runnable runnable) {
            super(j);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.block;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class DelayedTask implements Runnable, Comparable, DisposableHandle {
        private volatile Object _heap;
        public int index = -1;
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            long j = this.nanoTime - ((DelayedTask) obj).nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    Joiner joiner = AwaitKt.DISPOSED_TASK;
                    if (obj == joiner) {
                        return;
                    }
                    DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                    if (delayedTaskQueue != null) {
                        synchronized (delayedTaskQueue) {
                            Object obj2 = this._heap;
                            if ((obj2 instanceof ThreadSafeHeap ? (ThreadSafeHeap) obj2 : null) != null) {
                                delayedTaskQueue.removeAtImpl(this.index);
                            }
                        }
                    }
                    this._heap = joiner;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int scheduleTask(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == AwaitKt.DISPOSED_TASK) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    try {
                        DelayedTask[] delayedTaskArr = delayedTaskQueue.a;
                        DelayedTask delayedTask = delayedTaskArr != null ? delayedTaskArr[0] : null;
                        int i = EventLoopImplBase.$r8$clinit;
                        if (ArtificialStackFramesUnsafe.unsafe.getIntVolatile(eventLoopImplBase, EventLoopImplBase._isCompleted$volatile$FU$offset) == 1) {
                            return 1;
                        }
                        if (delayedTask == null) {
                            delayedTaskQueue.timeNow = j;
                        } else {
                            long j2 = delayedTask.nanoTime;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            long j3 = delayedTaskQueue.timeNow;
                            if (j - j3 > 0) {
                                delayedTaskQueue.timeNow = j;
                            } else {
                                j = j3;
                            }
                        }
                        if (this.nanoTime - j < 0) {
                            this.nanoTime = j;
                        }
                        delayedTaskQueue.addImpl(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final void setHeap(DelayedTaskQueue delayedTaskQueue) {
            if (this._heap != AwaitKt.DISPOSED_TASK) {
                this._heap = delayedTaskQueue;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DelayedTaskQueue extends ThreadSafeHeap {
        public long timeNow;
    }

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        _queue$volatile$FU$offset = unsafe.objectFieldOffset(EventLoopImplBase.class.getDeclaredField("_queue$volatile"));
        _delayed$volatile$FU$offset = unsafe.objectFieldOffset(EventLoopImplBase.class.getDeclaredField("_delayed$volatile"));
        _isCompleted$volatile$FU$offset = unsafe.objectFieldOffset(EventLoopImplBase.class.getDeclaredField("_isCompleted$volatile"));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        enqueueDelayedTasks();
        if (!enqueueImpl(runnable)) {
            DefaultExecutor.INSTANCE.enqueue(runnable);
            return;
        }
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            LockSupport.unpark(thread);
        }
    }

    public final void enqueueDelayedTasks() {
        DelayedTask delayedTaskRemoveAtImpl;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _delayed$volatile$FU$offset);
        if (delayedTaskQueue == null || delayedTaskQueue.getSize() == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (delayedTaskQueue) {
                try {
                    DelayedTask[] delayedTaskArr = delayedTaskQueue.a;
                    delayedTaskRemoveAtImpl = null;
                    DelayedTask delayedTask = delayedTaskArr != null ? delayedTaskArr[0] : null;
                    if (delayedTask != null) {
                        if (jNanoTime - delayedTask.nanoTime >= 0 ? enqueueImpl(delayedTask) : false) {
                            delayedTaskRemoveAtImpl = delayedTaskQueue.removeAtImpl(0);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (delayedTaskRemoveAtImpl != null);
    }

    public final boolean enqueueImpl(Runnable runnable) {
        Unsafe unsafe;
        Unsafe unsafe2;
        Unsafe unsafe3;
        while (true) {
            Unsafe unsafe4 = ArtificialStackFramesUnsafe.unsafe;
            long j = _queue$volatile$FU$offset;
            Object objectVolatile = unsafe4.getObjectVolatile(this, j);
            if (unsafe4.getIntVolatile(this, _isCompleted$volatile$FU$offset) == 1) {
                return false;
            }
            if (objectVolatile == null) {
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    if (unsafe.compareAndSwapObject(this, _queue$volatile$FU$offset, (Object) null, runnable)) {
                        return true;
                    }
                } while (unsafe.getObjectVolatile(this, j) == null);
            } else if (objectVolatile instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) objectVolatile;
                int iAddLast = lockFreeTaskQueueCore.addLast(runnable);
                if (iAddLast == 0) {
                    return true;
                }
                if (iAddLast == 1) {
                    LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                    do {
                        unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe2.compareAndSwapObject(this, _queue$volatile$FU$offset, objectVolatile, next)) {
                            break;
                        }
                    } while (unsafe2.getObjectVolatile(this, j) == objectVolatile);
                } else if (iAddLast == 2) {
                    return false;
                }
            } else {
                if (objectVolatile == AwaitKt.CLOSED_EMPTY) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.addLast((Runnable) objectVolatile);
                lockFreeTaskQueueCore2.addLast(runnable);
                do {
                    unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                    if (unsafe3.compareAndSwapObject(this, _queue$volatile$FU$offset, objectVolatile, lockFreeTaskQueueCore2)) {
                        return true;
                    }
                } while (unsafe3.getObjectVolatile(this, j) == objectVolatile);
            }
        }
    }

    public abstract Thread getThread();

    public final boolean isEmpty() {
        ArrayDeque arrayDeque = this.unconfinedQueue;
        if (arrayDeque != null ? arrayDeque.isEmpty() : true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) unsafe.getObjectVolatile(this, _delayed$volatile$FU$offset);
            if (delayedTaskQueue != null && delayedTaskQueue.getSize() != 0) {
                return false;
            }
            Object objectVolatile = unsafe.getObjectVolatile(this, _queue$volatile$FU$offset);
            if (objectVolatile != null) {
                if (objectVolatile instanceof LockFreeTaskQueueCore) {
                    long longVolatile = unsafe.getLongVolatile((LockFreeTaskQueueCore) objectVolatile, LockFreeTaskQueueCore._state$volatile$FU$offset);
                    return ((int) (1073741823 & longVolatile)) == ((int) ((longVolatile & 1152921503533105152L) >> 30));
                }
                if (objectVolatile == AwaitKt.CLOSED_EMPTY) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.EventLoop
    public final long processNextEvent() {
        Unsafe unsafe;
        EventLoopImplBase eventLoopImplBase;
        Unsafe unsafe2;
        Runnable runnable;
        DelayedTask delayedTask;
        Joiner joiner = AwaitKt.CLOSED_EMPTY;
        long j = _queue$volatile$FU$offset;
        if (!processUnconfinedEvent()) {
            enqueueDelayedTasks();
            loop0: while (true) {
                unsafe = ArtificialStackFramesUnsafe.unsafe;
                Object objectVolatile = unsafe.getObjectVolatile(this, j);
                if (objectVolatile == null) {
                    eventLoopImplBase = this;
                } else if (objectVolatile instanceof LockFreeTaskQueueCore) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) objectVolatile;
                    Object objRemoveFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                    if (objRemoveFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                        Runnable runnable2 = (Runnable) objRemoveFirstOrNull;
                        eventLoopImplBase = this;
                        runnable = runnable2;
                        unsafe2 = unsafe;
                        break;
                    }
                    LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                    while (true) {
                        Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                        eventLoopImplBase = this;
                        if (unsafe3.compareAndSwapObject(eventLoopImplBase, _queue$volatile$FU$offset, objectVolatile, next) || unsafe3.getObjectVolatile(eventLoopImplBase, j) != objectVolatile) {
                            break;
                        }
                        this = eventLoopImplBase;
                    }
                    this = eventLoopImplBase;
                } else {
                    eventLoopImplBase = this;
                    if (objectVolatile != joiner) {
                        do {
                            unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                            if (unsafe2.compareAndSwapObject(eventLoopImplBase, _queue$volatile$FU$offset, objectVolatile, (Object) null)) {
                                runnable = (Runnable) objectVolatile;
                                unsafe = unsafe2;
                                break loop0;
                            }
                        } while (unsafe2.getObjectVolatile(eventLoopImplBase, j) == objectVolatile);
                        this = eventLoopImplBase;
                    }
                }
                unsafe2 = unsafe;
                runnable = null;
                break;
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            ArrayDeque arrayDeque = eventLoopImplBase.unconfinedQueue;
            if (((arrayDeque == null || arrayDeque.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object objectVolatile2 = unsafe.getObjectVolatile(eventLoopImplBase, j);
                if (objectVolatile2 != null) {
                    if (objectVolatile2 instanceof LockFreeTaskQueueCore) {
                        long longVolatile = unsafe2.getLongVolatile((LockFreeTaskQueueCore) objectVolatile2, LockFreeTaskQueueCore._state$volatile$FU$offset);
                        if (((int) (1073741823 & longVolatile)) != ((int) ((longVolatile & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (objectVolatile2 == joiner) {
                        return Long.MAX_VALUE;
                    }
                }
                DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) unsafe.getObjectVolatile(eventLoopImplBase, _delayed$volatile$FU$offset);
                if (delayedTaskQueue != null) {
                    synchronized (delayedTaskQueue) {
                        DelayedTask[] delayedTaskArr = delayedTaskQueue.a;
                        delayedTask = delayedTaskArr != null ? delayedTaskArr[0] : null;
                    }
                    if (delayedTask != null) {
                        long jNanoTime = delayedTask.nanoTime - System.nanoTime();
                        if (jNanoTime >= 0) {
                            return jNanoTime;
                        }
                    }
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    public void reschedule(long j, DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }

    public final void schedule(long j, DelayedTask delayedTask) {
        EventLoopImplBase eventLoopImplBase;
        int iScheduleTask;
        Unsafe unsafe;
        Thread thread;
        long j2 = _delayed$volatile$FU$offset;
        Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
        if (unsafe2.getIntVolatile(this, _isCompleted$volatile$FU$offset) == 1) {
            eventLoopImplBase = this;
            iScheduleTask = 1;
        } else {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) unsafe2.getObjectVolatile(this, j2);
            if (delayedTaskQueue == null) {
                DelayedTaskQueue delayedTaskQueue2 = new DelayedTaskQueue();
                delayedTaskQueue2.timeNow = j;
                while (true) {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    eventLoopImplBase = this;
                    if (unsafe.compareAndSwapObject(eventLoopImplBase, _delayed$volatile$FU$offset, (Object) null, delayedTaskQueue2) || unsafe.getObjectVolatile(eventLoopImplBase, j2) != null) {
                        break;
                    } else {
                        this = eventLoopImplBase;
                    }
                }
                Object objectVolatile = unsafe.getObjectVolatile(eventLoopImplBase, j2);
                objectVolatile.getClass();
                delayedTaskQueue = (DelayedTaskQueue) objectVolatile;
                unsafe2 = unsafe;
            } else {
                eventLoopImplBase = this;
            }
            iScheduleTask = delayedTask.scheduleTask(j, delayedTaskQueue, eventLoopImplBase);
        }
        if (iScheduleTask != 0) {
            if (iScheduleTask == 1) {
                eventLoopImplBase.reschedule(j, delayedTask);
                return;
            } else {
                if (iScheduleTask == 2) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected result");
                return;
            }
        }
        DelayedTaskQueue delayedTaskQueue3 = (DelayedTaskQueue) unsafe2.getObjectVolatile(eventLoopImplBase, j2);
        DelayedTask delayedTask2 = null;
        if (delayedTaskQueue3 != null) {
            synchronized (delayedTaskQueue3) {
                DelayedTask[] delayedTaskArr = delayedTaskQueue3.a;
                delayedTask2 = delayedTaskArr != null ? delayedTaskArr[0] : null;
            }
        }
        if (delayedTask2 != delayedTask || Thread.currentThread() == (thread = eventLoopImplBase.getThread())) {
            return;
        }
        LockSupport.unpark(thread);
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        long j2 = 0;
        if (j > 0) {
            j2 = j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j;
        }
        if (j2 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(j2 + jNanoTime, cancellableContinuationImpl);
            schedule(jNanoTime, delayedResumeTask);
            cancellableContinuationImpl.invokeOnCancellationImpl(new DisposeOnCancel((byte) 0, delayedResumeTask));
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        Joiner joiner;
        Unsafe unsafe;
        DelayedTask delayedTaskRemoveAtImpl;
        ThreadLocalEventLoop.ref.set(null);
        ArtificialStackFramesUnsafe.unsafe.putIntVolatile(this, _isCompleted$volatile$FU$offset, 1);
        Joiner joiner2 = AwaitKt.CLOSED_EMPTY;
        long j = _queue$volatile$FU$offset;
        loop0: while (true) {
            Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, j);
            if (objectVolatile == null) {
                while (true) {
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    joiner = joiner2;
                    if (unsafe2.compareAndSwapObject(this, _queue$volatile$FU$offset, (Object) null, joiner2)) {
                        break loop0;
                    } else if (unsafe2.getObjectVolatile(this, j) != null) {
                        break;
                    } else {
                        joiner2 = joiner;
                    }
                }
                joiner2 = joiner;
            } else {
                joiner = joiner2;
                if (objectVolatile instanceof LockFreeTaskQueueCore) {
                    ((LockFreeTaskQueueCore) objectVolatile).close();
                    break;
                }
                if (objectVolatile == joiner) {
                    break;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) objectVolatile);
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    if (unsafe.compareAndSwapObject(this, _queue$volatile$FU$offset, objectVolatile, lockFreeTaskQueueCore)) {
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(this, j) == objectVolatile);
                joiner2 = joiner;
            }
        }
        while (processNextEvent() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _delayed$volatile$FU$offset);
            if (delayedTaskQueue == null) {
                return;
            }
            synchronized (delayedTaskQueue) {
                delayedTaskRemoveAtImpl = delayedTaskQueue.getSize() > 0 ? delayedTaskQueue.removeAtImpl(0) : null;
            }
            if (delayedTaskRemoveAtImpl == null) {
                return;
            } else {
                reschedule(jNanoTime, delayedTaskRemoveAtImpl);
            }
        }
    }
}
