package kotlinx.coroutines.guava;

import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ListenableFutureCoroutine extends AbstractCoroutine {
    public final JobListenableFuture future;

    public ListenableFutureCoroutine(CoroutineContext coroutineContext) {
        super(coroutineContext, true);
        this.future = new JobListenableFuture(this);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        boolean z2 = th instanceof CancellationException;
        JobListenableFuture jobListenableFuture = this.future;
        SettableFuture settableFuture = jobListenableFuture.auxFuture;
        if (z2) {
            settableFuture.set(new Cancelled((CancellationException) th));
        } else if (settableFuture.setException(th)) {
            jobListenableFuture.auxFutureIsFailed = true;
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Object obj) {
        this.future.auxFuture.set(obj);
    }
}
