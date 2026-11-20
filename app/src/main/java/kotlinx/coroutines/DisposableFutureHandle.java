package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DisposableFutureHandle implements DisposableHandle {
    public final ScheduledFuture future;

    public DisposableFutureHandle(ScheduledFuture scheduledFuture) {
        this.future = scheduledFuture;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        this.future.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.future + ']';
    }
}
