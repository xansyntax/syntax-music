package androidx.lifecycle.viewmodel.internal;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableCoroutineScope implements AutoCloseable, CoroutineScope {
    public final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(CoroutineContext coroutineContext) {
        coroutineContext.getClass();
        this.coroutineContext = coroutineContext;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        AwaitKt.cancel(this.coroutineContext, (CancellationException) null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
