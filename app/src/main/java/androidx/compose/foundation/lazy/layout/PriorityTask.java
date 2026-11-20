package androidx.compose.foundation.lazy.layout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PriorityTask {
    public final boolean priority;
    public final PrefetchHandleProvider$HandleAndRequestImpl request;

    /* JADX WARN: Multi-variable type inference failed */
    public PriorityTask(int i, PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl) {
        this.priority = i;
        this.request = prefetchHandleProvider$HandleAndRequestImpl;
    }
}
