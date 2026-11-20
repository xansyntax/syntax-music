package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadLocalKey implements CoroutineContext.Key {
    public final ThreadLocal threadLocal;

    public ThreadLocalKey(ThreadLocal threadLocal) {
        this.threadLocal = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThreadLocalKey) && Intrinsics.areEqual(this.threadLocal, ((ThreadLocalKey) obj).threadLocal);
    }

    public final int hashCode() {
        return this.threadLocal.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + ')';
    }
}
