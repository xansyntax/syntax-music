package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSharedFlowSlot {
    public abstract boolean allocateLocked(AbstractSharedFlow abstractSharedFlow);

    public abstract Continuation[] freeLocked(AbstractSharedFlow abstractSharedFlow);
}
