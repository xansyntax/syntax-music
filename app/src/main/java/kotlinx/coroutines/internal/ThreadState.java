package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadState {
    public final CoroutineContext context;
    public final ThreadContextElement[] elements;
    public int i;
    public final Object[] values;

    public ThreadState(int i, CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.values = new Object[i];
        this.elements = new ThreadContextElement[i];
    }
}
