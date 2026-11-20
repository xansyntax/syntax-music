package kotlinx.coroutines;

import kotlin.ResultKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ResumeAwaitOnCompletion extends JobNode {
    public final JobSupport.AwaitContinuation continuation;

    public ResumeAwaitOnCompletion(JobSupport.AwaitContinuation awaitContinuation) {
        this.continuation = awaitContinuation;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean getOnCancelling() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        boolean z = state$kotlinx_coroutines_core instanceof CompletedExceptionally;
        JobSupport.AwaitContinuation awaitContinuation = this.continuation;
        if (z) {
            awaitContinuation.resumeWith(ResultKt.createFailure(((CompletedExceptionally) state$kotlinx_coroutines_core).cause));
        } else {
            awaitContinuation.resumeWith(AwaitKt.unboxState(state$kotlinx_coroutines_core));
        }
    }
}
