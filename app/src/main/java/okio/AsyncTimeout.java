package okio;

import android.os.Process;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.text.RegexKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {
    public static final char IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static final Condition condition;
    public static AsyncTimeout idleSentinel;
    public static final ReentrantLock lock;
    public static final PriorityQueue queue;
    public int index = -1;
    public byte state;
    public long timeoutAt;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PriorityQueue priorityQueue = new PriorityQueue((byte) 0, (boolean) (0 == true ? 1 : 0));
        priorityQueue.array = new AsyncTimeout[8];
        queue = priorityQueue;
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        condition = conditionNewCondition;
        IDLE_TIMEOUT_MILLIS = (char) 60000;
        IDLE_TIMEOUT_NANOS = 60000000000L;
    }

    public final void enter() {
        long j = this.timeoutNanos;
        boolean z = this.hasDeadline;
        if (j != 0 || z) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = (byte) 1;
                RegexKt.insertIntoQueue(this);
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            byte b = this.state;
            this.state = (byte) 0;
            if (b != 1) {
                return b == 2;
            }
            queue.remove(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Watchdog extends Thread {
        public final /* synthetic */ byte $r8$classId = 1;

        public /* synthetic */ Watchdog(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    break;
                default:
                    Process.setThreadPriority(10);
                    super.run();
                    return;
            }
            while (true) {
                try {
                    ReentrantLock reentrantLock = AsyncTimeout.lock;
                    reentrantLock.lock();
                    try {
                        AsyncTimeout asyncTimeoutAwaitTimeout = RegexKt.awaitTimeout();
                        if (asyncTimeoutAwaitTimeout == AsyncTimeout.idleSentinel) {
                            AsyncTimeout.idleSentinel = null;
                            reentrantLock.unlock();
                            return;
                        } else {
                            reentrantLock.unlock();
                            if (asyncTimeoutAwaitTimeout != null) {
                                asyncTimeoutAwaitTimeout.timedOut();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }

        public /* synthetic */ Watchdog(String str) {
            super(str);
        }
    }

    public void timedOut() {
    }
}
