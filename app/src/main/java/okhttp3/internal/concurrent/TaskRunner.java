package okhttp3.internal.concurrent;

import androidx.appcompat.widget.Toolbar;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskRunner {
    public static final TaskRunner INSTANCE;
    public static final Logger logger;
    public final ConnectionPool backend;
    public final ArrayList busyQueues;
    public boolean coordinatorWaiting;
    public long coordinatorWakeUpAt;
    public int executeCallCount;
    public final Logger logger$1;
    public int nextQueueName;
    public final ArrayList readyQueues;
    public int runCallCount;
    public final Toolbar.AnonymousClass2 runnable;

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        logger2.getClass();
        logger = logger2;
        _UtilJvmKt$$ExternalSyntheticLambda1 _utiljvmkt__externalsyntheticlambda1 = new _UtilJvmKt$$ExternalSyntheticLambda1(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), _UtilJvmKt.okHttpName, " TaskRunner"), true);
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.delegate = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _utiljvmkt__externalsyntheticlambda1);
        INSTANCE = new TaskRunner(connectionPool);
    }

    public TaskRunner(ConnectionPool connectionPool) {
        Logger logger2 = logger;
        logger2.getClass();
        this.backend = connectionPool;
        this.logger$1 = logger2;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new Toolbar.AnonymousClass2((byte) 7, this);
    }

    public final void afterRun(Task task, long j, boolean z) {
        TimeZone timeZone = _UtilJvmKt.UTC;
        TaskQueue taskQueue = task.queue;
        taskQueue.getClass();
        if (taskQueue.activeTask != task) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return;
        }
        boolean z2 = taskQueue.cancelActiveTask;
        taskQueue.cancelActiveTask = false;
        taskQueue.activeTask = null;
        this.busyQueues.remove(taskQueue);
        if (j != -1 && !z2 && !taskQueue.shutdown) {
            taskQueue.scheduleAndDecide$okhttp(task, j, true);
        }
        if (taskQueue.futureTasks.isEmpty()) {
            return;
        }
        this.readyQueues.add(taskQueue);
        if (z) {
            return;
        }
        startAnotherThread();
    }

    public final Task awaitTaskToRun() {
        long j;
        Task task;
        boolean z;
        TimeZone timeZone = _UtilJvmKt.UTC;
        while (true) {
            ArrayList arrayList = this.readyQueues;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i = 0;
            Task task2 = null;
            while (true) {
                if (i >= size) {
                    j = jNanoTime;
                    task = null;
                    z = false;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                Task task3 = (Task) ((TaskQueue) obj).futureTasks.get(0);
                j = jNanoTime;
                task = null;
                long jMax = Math.max(0L, task3.nextExecuteNanoTime - j);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task2 != null) {
                        z = true;
                        break;
                    }
                    task2 = task3;
                }
                jNanoTime = j;
            }
            ArrayList arrayList2 = this.busyQueues;
            if (task2 != null) {
                TimeZone timeZone2 = _UtilJvmKt.UTC;
                task2.nextExecuteNanoTime = -1L;
                TaskQueue taskQueue = task2.queue;
                taskQueue.getClass();
                taskQueue.futureTasks.remove(task2);
                arrayList.remove(taskQueue);
                taskQueue.activeTask = task2;
                arrayList2.add(taskQueue);
                if (z || (!this.coordinatorWaiting && !arrayList.isEmpty())) {
                    startAnotherThread();
                }
                return task2;
            }
            if (this.coordinatorWaiting) {
                if (jMin >= this.coordinatorWakeUpAt - j) {
                    return task;
                }
                notify();
                return task;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = j + jMin;
            try {
                try {
                    TimeZone timeZone3 = _UtilJvmKt.UTC;
                    if (jMin > 0) {
                        long j2 = jMin / 1000000;
                        long j3 = jMin - (1000000 * j2);
                        if (j2 > 0 || jMin > 0) {
                            wait(j2, (int) j3);
                        }
                    }
                } catch (InterruptedException unused) {
                    TimeZone timeZone4 = _UtilJvmKt.UTC;
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((TaskQueue) arrayList2.get(size2)).cancelAllAndDecide$okhttp();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        TaskQueue taskQueue2 = (TaskQueue) arrayList.get(size3);
                        taskQueue2.cancelAllAndDecide$okhttp();
                        if (taskQueue2.futureTasks.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
                this.coordinatorWaiting = false;
            } catch (Throwable th) {
                this.coordinatorWaiting = false;
                throw th;
            }
        }
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        taskQueue.getClass();
        TimeZone timeZone = _UtilJvmKt.UTC;
        if (taskQueue.activeTask == null) {
            boolean zIsEmpty = taskQueue.futureTasks.isEmpty();
            ArrayList arrayList = this.readyQueues;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else {
                byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                if (!arrayList.contains(taskQueue)) {
                    arrayList.add(taskQueue);
                }
            }
        }
        if (this.coordinatorWaiting) {
            notify();
        } else {
            startAnotherThread();
        }
    }

    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.nextQueueName;
            this.nextQueueName = i + 1;
        }
        return new TaskQueue(this, IntIntPair$$ExternalSyntheticOutline0.m(i, "Q"));
    }

    public final void startAnotherThread() {
        TimeZone timeZone = _UtilJvmKt.UTC;
        int i = this.executeCallCount;
        if (i > this.runCallCount) {
            return;
        }
        this.executeCallCount = i + 1;
        ((ThreadPoolExecutor) this.backend.delegate).execute(this.runnable);
    }
}
