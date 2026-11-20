package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EventLoop extends CoroutineDispatcher {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean shared;
    public ArrayDeque unconfinedQueue;
    public long useCount;

    public final void decrementUseCount(boolean z) {
        long j = this.useCount - (z ? 4294967296L : 1L);
        this.useCount = j;
        if (j <= 0 && this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(DispatchedTask dispatchedTask) {
        ArrayDeque arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.unconfinedQueue = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    public final void incrementUseCount(boolean z) {
        this.useCount = (z ? 4294967296L : 1L) + this.useCount;
        if (z) {
            return;
        }
        this.shared = true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        InlineList.checkParallelism(i);
        return this;
    }

    public abstract long processNextEvent();

    public final boolean processUnconfinedEvent() {
        ArrayDeque arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return false;
        }
        DispatchedTask dispatchedTask = (DispatchedTask) (arrayDeque.isEmpty() ? null : arrayDeque.removeFirst());
        if (dispatchedTask == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public abstract void shutdown();
}
