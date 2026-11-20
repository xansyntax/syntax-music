package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.text.RegexKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskQueue {
    public Task activeTask;
    public boolean cancelActiveTask;
    public final ArrayList futureTasks = new ArrayList();
    public final String name;
    public boolean shutdown;
    public final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String str) {
        this.taskRunner = taskRunner;
        this.name = str;
    }

    public static void execute$default(TaskQueue taskQueue, String str, long j, Function0 function0, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        boolean z = (i & 4) != 0;
        taskQueue.getClass();
        str.getClass();
        function0.getClass();
        taskQueue.schedule(new TaskQueue$execute$1(str, z, function0), j);
    }

    public final void cancelAll() {
        TaskRunner taskRunner = this.taskRunner;
        TimeZone timeZone = _UtilJvmKt.UTC;
        synchronized (taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.cancelable) {
            this.cancelActiveTask = true;
        }
        ArrayList arrayList = this.futureTasks;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((Task) arrayList.get(size)).cancelable) {
                Logger logger = this.taskRunner.logger$1;
                Task task2 = (Task) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    RegexKt.log(logger, task2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void schedule(Task task, long j) {
        task.getClass();
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                return;
            }
            boolean z = task.cancelable;
            Logger logger = this.taskRunner.logger$1;
            if (z) {
                if (logger.isLoggable(Level.FINE)) {
                    RegexKt.log(logger, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (logger.isLoggable(Level.FINE)) {
                    RegexKt.log(logger, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[LOOP:0: B:23:0x0063->B:27:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0079 A[EDGE_INSN: B:39:0x0079->B:29:0x0079 BREAK  A[LOOP:0: B:23:0x0063->B:27:0x0075], SYNTHETIC] */
    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z) {
        int size;
        int size2;
        int i;
        Object obj;
        String strConcat;
        Logger logger = this.taskRunner.logger$1;
        task.getClass();
        TaskQueue taskQueue = task.queue;
        if (taskQueue != this) {
            if (taskQueue != null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("task is in multiple queues");
                return false;
            }
            task.queue = this;
        }
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime + j;
        ArrayList arrayList = this.futureTasks;
        int iIndexOf = arrayList.indexOf(task);
        if (iIndexOf == -1) {
            task.nextExecuteNanoTime = j2;
            if (logger.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = "run again after ".concat(RegexKt.formatDuration(j2 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(RegexKt.formatDuration(j2 - jNanoTime));
                }
                RegexKt.log(logger, task, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((Task) obj).nextExecuteNanoTime - jNanoTime > j) {
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, task);
            if (size2 == 0) {
                return true;
            }
        } else if (task.nextExecuteNanoTime > j2) {
            arrayList.remove(iIndexOf);
            task.nextExecuteNanoTime = j2;
            if (logger.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = "run again after ".concat(RegexKt.formatDuration(j2 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(RegexKt.formatDuration(j2 - jNanoTime));
                }
                RegexKt.log(logger, task, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((Task) obj).nextExecuteNanoTime - jNanoTime > j) {
                    break;
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, task);
            if (size2 == 0) {
                return true;
            }
        } else if (logger.isLoggable(Level.FINE)) {
            RegexKt.log(logger, task, this, "already scheduled");
            return false;
        }
        return false;
    }

    public final void shutdown() {
        TaskRunner taskRunner = this.taskRunner;
        TimeZone timeZone = _UtilJvmKt.UTC;
        synchronized (taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final String toString() {
        return this.name;
    }
}
