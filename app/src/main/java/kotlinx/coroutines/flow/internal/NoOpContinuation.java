package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NoOpContinuation implements Continuation {
    public static final NoOpContinuation INSTANCE = new NoOpContinuation();

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
    }
}
