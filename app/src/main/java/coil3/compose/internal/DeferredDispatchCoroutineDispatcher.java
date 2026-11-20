package coil3.compose.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeferredDispatchCoroutineDispatcher extends CoroutineDispatcher {
    public static final /* synthetic */ long _unconfined$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(DeferredDispatchCoroutineDispatcher.class.getDeclaredField("_unconfined$volatile"));
    public volatile /* synthetic */ int _unconfined$volatile = 1;
    public final CoroutineDispatcher delegate;

    public DeferredDispatchCoroutineDispatcher(CoroutineDispatcher coroutineDispatcher) {
        this.delegate = coroutineDispatcher;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        getCurrentDispatcher().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        getCurrentDispatcher().dispatchYield(coroutineContext, runnable);
    }

    public final CoroutineDispatcher getCurrentDispatcher() {
        return ArtificialStackFramesUnsafe.unsafe.getIntVolatile(this, _unconfined$volatile$FU$offset) == 1 ? Dispatchers.Unconfined : this.delegate;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return getCurrentDispatcher().isDispatchNeeded(coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        return getCurrentDispatcher().limitedParallelism(i, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "DeferredDispatchCoroutineDispatcher(delegate=" + this.delegate + ")";
    }
}
