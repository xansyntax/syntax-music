package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.NamedDispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UnlimitedIoScheduler extends CoroutineDispatcher {
    public static final UnlimitedIoScheduler INSTANCE = new UnlimitedIoScheduler();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.INSTANCE.coroutineScheduler.dispatch(runnable, true, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.INSTANCE.coroutineScheduler.dispatch(runnable, true, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        InlineList.checkParallelism(i);
        if (i >= TasksKt.MAX_POOL_SIZE) {
            return str != null ? new NamedDispatcher(this, str) : this;
        }
        return super.limitedParallelism(i, str);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }
}
