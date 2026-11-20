package kotlinx.coroutines.scheduling;

import _COROUTINE.ArtificialStackFramesUnsafe;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.base.Joiner;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.date.GMTDateParser;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final String schedulerName;
    public final ResizableAtomicArray workers;
    public static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
    public static final Joiner NOT_IN_STACK = new Joiner("NOT_IN_STACK", (byte) 5);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Worker extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        public static final /* synthetic */ long workerCtl$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(Worker.class.getDeclaredField("workerCtl$volatile"));
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        public int rngState;
        public WorkerState state;
        public final Ref$ObjectRef stolenTask;
        public long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        public Worker(int i) {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.class.getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref$ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            int iNanoTime = (int) System.nanoTime();
            this.rngState = iNanoTime == 0 ? 42 : iNanoTime;
            setIndexInArray(i);
        }

        public final Task findTask(boolean z) {
            Task taskPollGlobalQueues;
            Task taskPollGlobalQueues2;
            long j;
            Unsafe unsafe;
            WorkerState workerState = this.state;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            Task task = null;
            WorkQueue workQueue = this.localQueue;
            WorkerState workerState2 = WorkerState.CPU_ACQUIRED;
            if (workerState != workerState2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$volatile$FU;
                do {
                    j = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        workQueue.getClass();
                        long j2 = WorkQueue.lastScheduledTask$volatile$FU$offset;
                        loop1: while (true) {
                            Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                            Task task2 = (Task) unsafe2.getObjectVolatile(workQueue, j2);
                            if (task2 == null || !task2.taskContext) {
                                int intVolatile = unsafe2.getIntVolatile(workQueue, WorkQueue.consumerIndex$volatile$FU$offset);
                                int intVolatile2 = unsafe2.getIntVolatile(workQueue, WorkQueue.producerIndex$volatile$FU$offset);
                                while (intVolatile != intVolatile2 && ArtificialStackFramesUnsafe.unsafe.getIntVolatile(workQueue, WorkQueue.blockingTasksInBuffer$volatile$FU$offset) != 0) {
                                    intVolatile2--;
                                    Task taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(intVolatile2, true);
                                    if (taskTryExtractFromTheMiddle != null) {
                                        task = taskTryExtractFromTheMiddle;
                                        break;
                                    }
                                }
                                break;
                            }
                            do {
                                unsafe = ArtificialStackFramesUnsafe.unsafe;
                                if (unsafe.compareAndSwapObject(workQueue, WorkQueue.lastScheduledTask$volatile$FU$offset, task2, (Object) null)) {
                                    task = task2;
                                    break loop1;
                                }
                            } while (unsafe.getObjectVolatile(workQueue, j2) == task2);
                        }
                        if (task != null) {
                            return task;
                        }
                        Task task3 = (Task) coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
                        return task3 == null ? trySteal(1) : task3;
                    }
                } while (!CoroutineScheduler.controlState$volatile$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
                this.state = workerState2;
            }
            if (z) {
                boolean z2 = nextInt(coroutineScheduler.corePoolSize * 2) == 0;
                if (z2 && (taskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues2;
                }
                workQueue.getClass();
                Task taskPollBuffer = (Task) ArtificialStackFramesUnsafe.unsafe.getAndSetObject(workQueue, WorkQueue.lastScheduledTask$volatile$FU$offset, (Object) null);
                if (taskPollBuffer == null) {
                    taskPollBuffer = workQueue.pollBuffer();
                }
                if (taskPollBuffer != null) {
                    return taskPollBuffer;
                }
                if (!z2 && (taskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues;
                }
            } else {
                Task taskPollGlobalQueues3 = pollGlobalQueues();
                if (taskPollGlobalQueues3 != null) {
                    return taskPollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i;
        }

        public final Task pollGlobalQueues() {
            int iNextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            GlobalQueue globalQueue = coroutineScheduler.globalBlockingQueue;
            GlobalQueue globalQueue2 = coroutineScheduler.globalCpuQueue;
            if (iNextInt == 0) {
                Task task = (Task) globalQueue2.removeFirstOrNull();
                return task != null ? task : (Task) globalQueue.removeFirstOrNull();
            }
            Task task2 = (Task) globalQueue.removeFirstOrNull();
            return task2 != null ? task2 : (Task) globalQueue2.removeFirstOrNull();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    if (CoroutineScheduler._isTerminated$volatile$FU.get(CoroutineScheduler.this) != 1) {
                        WorkerState workerState = this.state;
                        WorkerState workerState2 = WorkerState.TERMINATED;
                        if (workerState == workerState2) {
                            break loop0;
                        }
                        Task taskFindTask = findTask(this.mayHaveLocalTasks);
                        if (taskFindTask != null) {
                            this.minDelayUntilStealableTaskNs = 0L;
                            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                            this.terminationDeadline = 0L;
                            if (this.state == WorkerState.PARKING) {
                                this.state = WorkerState.BLOCKING;
                            }
                            if (!taskFindTask.taskContext) {
                                try {
                                    taskFindTask.run();
                                    break;
                                } catch (Throwable th) {
                                    Thread threadCurrentThread = Thread.currentThread();
                                    threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                                    break;
                                }
                            }
                            if (tryReleaseCpu(WorkerState.BLOCKING) && !coroutineScheduler.tryUnpark() && !coroutineScheduler.tryCreateWorker(CoroutineScheduler.controlState$volatile$FU.get(coroutineScheduler))) {
                                coroutineScheduler.tryUnpark();
                            }
                            try {
                                taskFindTask.run();
                            } catch (Throwable th2) {
                                Thread threadCurrentThread2 = Thread.currentThread();
                                threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
                            }
                            CoroutineScheduler.controlState$volatile$FU.addAndGet(coroutineScheduler, -2097152L);
                            if (this.state == workerState2) {
                                break;
                            }
                            this.state = WorkerState.DORMANT;
                            break;
                        }
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            Object obj = this.nextParkedWorker;
                            Joiner joiner = CoroutineScheduler.NOT_IN_STACK;
                            if (obj != joiner) {
                                int i = -1;
                                ArtificialStackFramesUnsafe.unsafe.putIntVolatile(this, workerCtl$volatile$FU$offset, -1);
                                while (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                                    Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                                    long j = workerCtl$volatile$FU$offset;
                                    if (unsafe.getIntVolatile(this, j) != i) {
                                        break;
                                    }
                                    CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = CoroutineScheduler._isTerminated$volatile$FU;
                                    if (atomicIntegerFieldUpdater.get(coroutineScheduler2) == 1) {
                                        break;
                                    }
                                    WorkerState workerState3 = this.state;
                                    WorkerState workerState4 = WorkerState.TERMINATED;
                                    if (workerState3 == workerState4) {
                                        break;
                                    }
                                    tryReleaseCpu(WorkerState.PARKING);
                                    Thread.interrupted();
                                    if (this.terminationDeadline == 0) {
                                        this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                                    if (System.nanoTime() - this.terminationDeadline >= 0) {
                                        this.terminationDeadline = 0L;
                                        CoroutineScheduler coroutineScheduler3 = CoroutineScheduler.this;
                                        synchronized (coroutineScheduler3.workers) {
                                            try {
                                                if (!(atomicIntegerFieldUpdater.get(coroutineScheduler3) == 1)) {
                                                    AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$volatile$FU;
                                                    if (((int) (atomicLongFieldUpdater.get(coroutineScheduler3) & 2097151)) > coroutineScheduler3.corePoolSize && unsafe.compareAndSwapInt(this, j, -1, 1)) {
                                                        int i2 = this.indexInArray;
                                                        setIndexInArray(0);
                                                        coroutineScheduler3.parkedWorkersStackTopUpdate(this, i2, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(coroutineScheduler3) & 2097151);
                                                        if (andDecrement != i2) {
                                                            Object obj2 = coroutineScheduler3.workers.get(andDecrement);
                                                            obj2.getClass();
                                                            Worker worker = (Worker) obj2;
                                                            coroutineScheduler3.workers.setSynchronized(i2, worker);
                                                            worker.setIndexInArray(i2);
                                                            coroutineScheduler3.parkedWorkersStackTopUpdate(worker, andDecrement, i2);
                                                        }
                                                        coroutineScheduler3.workers.setSynchronized(andDecrement, null);
                                                        this.state = workerState4;
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                throw th3;
                                            }
                                        }
                                    }
                                    i = -1;
                                }
                            } else {
                                CoroutineScheduler coroutineScheduler4 = CoroutineScheduler.this;
                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = CoroutineScheduler.parkedWorkersStack$volatile$FU;
                                if (this.nextParkedWorker == joiner) {
                                    while (true) {
                                        long j2 = atomicLongFieldUpdater2.get(coroutineScheduler4);
                                        int i3 = this.indexInArray;
                                        this.nextParkedWorker = coroutineScheduler4.workers.get((int) (j2 & 2097151));
                                        CoroutineScheduler coroutineScheduler5 = coroutineScheduler4;
                                        AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
                                        if (atomicLongFieldUpdater3.compareAndSet(coroutineScheduler5, j2, ((j2 + 2097152) & (-2097152)) | ((long) i3))) {
                                            break;
                                        }
                                        atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
                                        coroutineScheduler4 = coroutineScheduler5;
                                    }
                                }
                            }
                        } else {
                            if (z) {
                                tryReleaseCpu(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = 0L;
                                break;
                            }
                            z = true;
                        }
                    } else {
                        break loop0;
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public final Task trySteal(int i) {
            int i2;
            long j;
            Task taskPollBuffer;
            long j2;
            long j3;
            Unsafe unsafe;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.controlState$volatile$FU;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i3 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            Task task = null;
            if (i3 < 2) {
                return null;
            }
            int iNextInt = nextInt(i3);
            int i4 = 0;
            long jMin = Long.MAX_VALUE;
            while (i4 < i3) {
                iNextInt++;
                if (iNextInt > i3) {
                    iNextInt = 1;
                }
                Worker worker = (Worker) coroutineScheduler.workers.get(iNextInt);
                if (worker == null || worker == this) {
                    i2 = i3;
                } else {
                    WorkQueue workQueue = worker.localQueue;
                    workQueue.getClass();
                    if (i != 3) {
                        boolean z = i == 1;
                        Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                        j = 0;
                        int intVolatile = unsafe2.getIntVolatile(workQueue, WorkQueue.consumerIndex$volatile$FU$offset);
                        int intVolatile2 = unsafe2.getIntVolatile(workQueue, WorkQueue.producerIndex$volatile$FU$offset);
                        while (true) {
                            if (intVolatile != intVolatile2) {
                                if (z) {
                                    i2 = i3;
                                    if (ArtificialStackFramesUnsafe.unsafe.getIntVolatile(workQueue, WorkQueue.blockingTasksInBuffer$volatile$FU$offset) == 0) {
                                    }
                                } else {
                                    i2 = i3;
                                }
                                int i5 = intVolatile + 1;
                                Task taskTryExtractFromTheMiddle = workQueue.tryExtractFromTheMiddle(intVolatile, z);
                                if (taskTryExtractFromTheMiddle != null) {
                                    taskPollBuffer = taskTryExtractFromTheMiddle;
                                    break;
                                }
                                intVolatile = i5;
                                i3 = i2;
                            } else {
                                i2 = i3;
                            }
                            taskPollBuffer = task;
                            break;
                        }
                    } else {
                        taskPollBuffer = workQueue.pollBuffer();
                        i2 = i3;
                        j = 0;
                    }
                    Ref$ObjectRef ref$ObjectRef = this.stolenTask;
                    if (taskPollBuffer == null) {
                        j2 = -1;
                        long j4 = WorkQueue.lastScheduledTask$volatile$FU$offset;
                        while (true) {
                            Task task2 = (Task) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(workQueue, j4);
                            if (task2 != null) {
                                if (((task2.taskContext ? 1 : 2) & i) != 0) {
                                    TasksKt.schedulerTimeSource.getClass();
                                    WorkQueue workQueue2 = workQueue;
                                    long jNanoTime = System.nanoTime() - task2.submissionTime;
                                    long j5 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
                                    if (jNanoTime < j5) {
                                        j3 = j5 - jNanoTime;
                                        break;
                                    }
                                    do {
                                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                                        if (unsafe.compareAndSwapObject(workQueue2, WorkQueue.lastScheduledTask$volatile$FU$offset, task2, (Object) null)) {
                                            ref$ObjectRef.element = task2;
                                            j3 = -1;
                                            break;
                                        }
                                    } while (unsafe.getObjectVolatile(workQueue2, j4) == task2);
                                    workQueue = workQueue2;
                                }
                            }
                            j3 = -2;
                            break;
                        }
                    } else {
                        ref$ObjectRef.element = taskPollBuffer;
                        j3 = -1;
                        j2 = -1;
                    }
                    if (j3 == j2) {
                        Task task3 = (Task) ref$ObjectRef.element;
                        ref$ObjectRef.element = null;
                        return task3;
                    }
                    if (j3 > j) {
                        jMin = Math.min(jMin, j3);
                    }
                }
                i4++;
                i3 = i2;
                task = null;
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class WorkerState {
        public static final /* synthetic */ WorkerState[] $VALUES;
        public static final WorkerState BLOCKING;
        public static final WorkerState CPU_ACQUIRED;
        public static final WorkerState DORMANT;
        public static final WorkerState PARKING;
        public static final WorkerState TERMINATED;

        static {
            WorkerState workerState = new WorkerState("CPU_ACQUIRED", 0);
            CPU_ACQUIRED = workerState;
            WorkerState workerState2 = new WorkerState("BLOCKING", 1);
            BLOCKING = workerState2;
            WorkerState workerState3 = new WorkerState("PARKING", 2);
            PARKING = workerState3;
            WorkerState workerState4 = new WorkerState("DORMANT", 3);
            DORMANT = workerState4;
            WorkerState workerState5 = new WorkerState("TERMINATED", 4);
            TERMINATED = workerState5;
            $VALUES = new WorkerState[]{workerState, workerState2, workerState3, workerState4, workerState5};
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i < 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Core pool size ", " should be at least 1"));
            throw null;
        }
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i2, i, "Max pool size ", " should be greater than or equals to core pool size "));
            throw null;
        }
        if (i2 > 2097150) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "Idle worker keep alive time ", " must be positive"));
            throw null;
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, int i) {
        coroutineScheduler.dispatch(runnable, false, (i & 4) == 0);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i;
        Task taskFindTask;
        if (_isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
            if (worker == null || CoroutineScheduler.this != this) {
                worker = null;
            }
            synchronized (this.workers) {
                i = (int) (controlState$volatile$FU.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object obj = this.workers.get(i2);
                    obj.getClass();
                    Worker worker2 = (Worker) obj;
                    if (worker2 != worker) {
                        while (worker2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker2);
                            worker2.join(10000L);
                        }
                        WorkQueue workQueue = worker2.localQueue;
                        GlobalQueue globalQueue = this.globalBlockingQueue;
                        workQueue.getClass();
                        Task task = (Task) ArtificialStackFramesUnsafe.unsafe.getAndSetObject(workQueue, WorkQueue.lastScheduledTask$volatile$FU$offset, (Object) null);
                        if (task != null) {
                            globalQueue.addLast(task);
                        }
                        while (true) {
                            Task taskPollBuffer = workQueue.pollBuffer();
                            if (taskPollBuffer == null) {
                                break;
                            } else {
                                globalQueue.addLast(taskPollBuffer);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (worker != null) {
                    taskFindTask = worker.findTask(true);
                    if (taskFindTask == null) {
                        taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                        if (taskFindTask == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    taskFindTask = (Task) this.globalCpuQueue.removeFirstOrNull();
                    if (taskFindTask == null && (taskFindTask = (Task) this.globalBlockingQueue.removeFirstOrNull()) == null) {
                        break;
                    }
                }
                try {
                    taskFindTask.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (worker != null) {
                worker.tryReleaseCpu(WorkerState.TERMINATED);
            }
            parkedWorkersStack$volatile$FU.set(this, 0L);
            controlState$volatile$FU.set(this, 0L);
        }
    }

    public final int createNewWorker() {
        synchronized (this.workers) {
            try {
                if (_isTerminated$volatile$FU.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$volatile$FU;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.workers.get(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(i3);
                this.workers.setSynchronized(i3, worker);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                worker.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void dispatch(Runnable runnable, boolean z, boolean z2) {
        Task taskImpl;
        WorkerState workerState;
        TasksKt.schedulerTimeSource.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            taskImpl = (Task) runnable;
            taskImpl.submissionTime = jNanoTime;
            taskImpl.taskContext = z;
        } else {
            taskImpl = new TaskImpl(runnable, jNanoTime, z);
        }
        boolean z3 = taskImpl.taskContext;
        AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$volatile$FU;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || CoroutineScheduler.this != this) {
            worker = null;
        }
        if (worker != null && (workerState = worker.state) != WorkerState.TERMINATED && (taskImpl.taskContext || workerState != WorkerState.BLOCKING)) {
            worker.mayHaveLocalTasks = true;
            WorkQueue workQueue = worker.localQueue;
            if (z2) {
                taskImpl = workQueue.addLast(taskImpl);
            } else {
                workQueue.getClass();
                Task task = (Task) ArtificialStackFramesUnsafe.unsafe.getAndSetObject(workQueue, WorkQueue.lastScheduledTask$volatile$FU$offset, taskImpl);
                taskImpl = task == null ? null : workQueue.addLast(task);
            }
        }
        if (taskImpl != null) {
            if (!(taskImpl.taskContext ? this.globalBlockingQueue.addLast(taskImpl) : this.globalCpuQueue.addLast(taskImpl))) {
                throw new RejectedExecutionException(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (z3) {
            if (tryUnpark() || tryCreateWorker(jAddAndGet)) {
                return;
            }
            tryUnpark();
            return;
        }
        if (tryUnpark() || tryCreateWorker(atomicLongFieldUpdater.get(this))) {
            return;
        }
        tryUnpark();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch$default(this, runnable, 6);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
            long j = atomicLongFieldUpdater.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object nextParkedWorker = worker.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            i3 = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            i3 = 0;
                            break;
                        }
                        Worker worker2 = (Worker) nextParkedWorker;
                        int indexInArray = worker2.getIndexInArray();
                        if (indexInArray != 0) {
                            i3 = indexInArray;
                            break;
                        }
                        nextParkedWorker = worker2.getNextParkedWorker();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                long j3 = j2 | ((long) i3);
                CoroutineScheduler coroutineScheduler = this;
                if (atomicLongFieldUpdater.compareAndSet(coroutineScheduler, j, j3)) {
                    return;
                } else {
                    this = coroutineScheduler;
                }
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray resizableAtomicArray = this.workers;
        int iCurrentLength = resizableAtomicArray.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iCurrentLength; i6++) {
            Worker worker = (Worker) resizableAtomicArray.get(i6);
            if (worker != null) {
                WorkQueue workQueue = worker.localQueue;
                workQueue.getClass();
                Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(workQueue, WorkQueue.lastScheduledTask$volatile$FU$offset);
                int bufferSize = workQueue.getBufferSize();
                if (objectVolatile != null) {
                    bufferSize++;
                }
                int iOrdinal = worker.state.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(bufferSize);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(bufferSize);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (bufferSize > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(bufferSize);
                        sb3.append(GMTDateParser.DAY_OF_MONTH);
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    i5++;
                }
            }
        }
        long j = controlState$volatile$FU.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(AwaitKt.getHexAddress(this));
        sb4.append("[Pool Size {core = ");
        int i7 = this.corePoolSize;
        sb4.append(i7);
        sb4.append(", max = ");
        sb4.append(this.maxPoolSize);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.globalCpuQueue.getSize());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.globalBlockingQueue.getSize());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i7 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final boolean tryCreateWorker(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.corePoolSize;
        if (i < i2) {
            int iCreateNewWorker = createNewWorker();
            if (iCreateNewWorker == 1 && i2 > 1) {
                createNewWorker();
            }
            if (iCreateNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        CoroutineScheduler coroutineScheduler;
        Joiner joiner;
        int indexInArray;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
            long j = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
                coroutineScheduler = this;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object nextParkedWorker = worker.getNextParkedWorker();
                while (true) {
                    joiner = NOT_IN_STACK;
                    if (nextParkedWorker == joiner) {
                        indexInArray = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        indexInArray = 0;
                        break;
                    }
                    Worker worker2 = (Worker) nextParkedWorker;
                    indexInArray = worker2.getIndexInArray();
                    if (indexInArray != 0) {
                        break;
                    }
                    nextParkedWorker = worker2.getNextParkedWorker();
                    atomicLongFieldUpdater = atomicLongFieldUpdater;
                    this = this;
                }
                if (indexInArray >= 0) {
                    CoroutineScheduler coroutineScheduler2 = this;
                    boolean zCompareAndSet = atomicLongFieldUpdater.compareAndSet(coroutineScheduler2, j, j2 | ((long) indexInArray));
                    coroutineScheduler = coroutineScheduler2;
                    if (zCompareAndSet) {
                        worker.setNextParkedWorker(joiner);
                    }
                    this = coroutineScheduler;
                } else {
                    continue;
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$volatile$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
            this = coroutineScheduler;
        }
    }
}
