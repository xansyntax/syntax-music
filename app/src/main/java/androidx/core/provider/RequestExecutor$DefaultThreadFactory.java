package androidx.core.provider;

import java.util.concurrent.ThreadFactory;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestExecutor$DefaultThreadFactory implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new AsyncTimeout.Watchdog(runnable, "fonts-androidx");
    }
}
