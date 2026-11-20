package kotlinx.coroutines.scheduling;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j, boolean z) {
        super(j, z);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.block.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.block;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AwaitKt.getHexAddress(runnable));
        sb.append(", ");
        sb.append(this.submissionTime);
        sb.append(", ");
        return Format$$ExternalSyntheticOutline0.m(sb, this.taskContext ? "Blocking" : "Non-blocking", ']');
    }
}
