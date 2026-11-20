package androidx.compose.ui;

import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionMutex$Session {
    public final Job job;
    public final Object value;

    public SessionMutex$Session(Job job, Object obj) {
        this.job = job;
        this.value = obj;
    }
}
