package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowCoroutine extends ScopeCoroutine {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th);
    }
}
