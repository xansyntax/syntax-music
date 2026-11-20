package coil3.request;

import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BaseRequestDelegate implements RequestDelegate {
    public final Job job;

    public /* synthetic */ BaseRequestDelegate(Job job) {
        this.job = job;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BaseRequestDelegate) {
            return this.job.equals(((BaseRequestDelegate) obj).job);
        }
        return false;
    }

    public final int hashCode() {
        return this.job.hashCode();
    }

    public final String toString() {
        return "BaseRequestDelegate(job=" + this.job + ")";
    }
}
