package kotlinx.coroutines.guava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import dagger.hilt.EntryPoints;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class JobListenableFuture implements ListenableFuture {
    public final SettableFuture auxFuture = new SettableFuture();
    public boolean auxFutureIsFailed;
    public final ListenableFutureCoroutine jobToCancel;

    public JobListenableFuture(ListenableFutureCoroutine listenableFutureCoroutine) {
        this.jobToCancel = listenableFutureCoroutine;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.auxFuture.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        if (!this.auxFuture.cancel(z)) {
            return false;
        }
        this.jobToCancel.cancel(null);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws Throwable {
        Object obj = this.auxFuture.get();
        if (obj instanceof Cancelled) {
            throw new CancellationException().initCause(((Cancelled) obj).exception);
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        boolean z;
        SettableFuture settableFuture = this.auxFuture;
        if (settableFuture.isCancelled()) {
            return true;
        }
        if (settableFuture.isDone() && !this.auxFutureIsFailed) {
            try {
                z = EntryPoints.getUninterruptibly(settableFuture) instanceof Cancelled;
            } catch (CancellationException unused) {
                z = true;
            } catch (ExecutionException unused2) {
                this.auxFutureIsFailed = true;
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.auxFuture.isDone();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        SettableFuture settableFuture = this.auxFuture;
        if (settableFuture.isDone()) {
            try {
                Object uninterruptibly = EntryPoints.getUninterruptibly(settableFuture);
                if (uninterruptibly instanceof Cancelled) {
                    sb.append("CANCELLED, cause=[" + ((Cancelled) uninterruptibly).exception + ']');
                } else {
                    sb.append("SUCCESS, result=[" + uninterruptibly + ']');
                }
            } catch (CancellationException unused) {
                sb.append("CANCELLED");
            } catch (ExecutionException e) {
                sb.append("FAILURE, cause=[" + e.getCause() + ']');
            } catch (Throwable th) {
                sb.append("UNKNOWN, cause=[" + th.getClass() + " thrown from get()]");
            }
        } else {
            sb.append("PENDING, delegate=[" + settableFuture + ']');
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws Throwable {
        Object obj = this.auxFuture.get(j, timeUnit);
        if (obj instanceof Cancelled) {
            throw new CancellationException().initCause(((Cancelled) obj).exception);
        }
        return obj;
    }
}
