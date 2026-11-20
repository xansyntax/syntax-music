package androidx.room;

import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.appcompat.app.AppCompatDelegate;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TransactionExecutor implements Executor {
    public final /* synthetic */ byte $r8$classId;
    public Runnable active;
    public final Executor executor;
    public final Object syncLock;
    public final ArrayDeque tasks;

    public TransactionExecutor(Executor executor) {
        this.$r8$classId = (byte) 0;
        this.executor = executor;
        this.tasks = new ArrayDeque();
        this.syncLock = new Object();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                runnable.getClass();
                synchronized (this.syncLock) {
                    this.tasks.offer(new TransactionExecutor$$ExternalSyntheticLambda0((Object) runnable, (Object) this, (byte) 0));
                    if (this.active == null) {
                        scheduleNext();
                    }
                    break;
                }
                return;
            default:
                synchronized (this.syncLock) {
                    try {
                        this.tasks.add(new ComponentActivity$$ExternalSyntheticLambda10(this, runnable, (byte) 1));
                        if (this.active == null) {
                            scheduleNext();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    public final void scheduleNext() {
        switch (this.$r8$classId) {
            case 0:
                synchronized (this.syncLock) {
                    Object objPoll = this.tasks.poll();
                    Runnable runnable = (Runnable) objPoll;
                    this.active = runnable;
                    if (objPoll != null) {
                        this.executor.execute(runnable);
                    }
                    break;
                }
                return;
            default:
                synchronized (this.syncLock) {
                    try {
                        Runnable runnable2 = (Runnable) this.tasks.poll();
                        this.active = runnable2;
                        if (runnable2 != null) {
                            ((AppCompatDelegate.ThreadPerTaskExecutor) this.executor).execute(runnable2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    public TransactionExecutor(AppCompatDelegate.ThreadPerTaskExecutor threadPerTaskExecutor) {
        this.$r8$classId = (byte) 1;
        this.syncLock = new Object();
        this.tasks = new ArrayDeque();
        this.executor = threadPerTaskExecutor;
    }
}
