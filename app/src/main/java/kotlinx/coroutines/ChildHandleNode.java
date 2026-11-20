package kotlinx.coroutines;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChildHandleNode extends JobNode implements ChildHandle {
    public final JobSupport childJob;

    public ChildHandleNode(JobSupport jobSupport) {
        this.childJob = jobSupport;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return getJob().childCancelled(th);
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final Job getParent() {
        return getJob();
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        this.childJob.cancelImpl$kotlinx_coroutines_core(getJob());
    }
}
