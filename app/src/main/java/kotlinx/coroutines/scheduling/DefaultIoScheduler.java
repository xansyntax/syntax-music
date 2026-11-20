package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    public static final DefaultIoScheduler INSTANCE = new DefaultIoScheduler();

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final CoroutineDispatcher f646default;

    static {
        UnlimitedIoScheduler unlimitedIoScheduler = UnlimitedIoScheduler.INSTANCE;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        if (64 >= i) {
            i = 64;
        }
        f646default = unlimitedIoScheduler.limitedParallelism(InlineList.systemProp$default(i, 12, "kotlinx.coroutines.io.parallelism"), null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f646default.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        return UnlimitedIoScheduler.INSTANCE.limitedParallelism(i, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }
}
