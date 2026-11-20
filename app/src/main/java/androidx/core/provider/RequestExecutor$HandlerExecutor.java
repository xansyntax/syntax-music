package androidx.core.provider;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RequestExecutor$HandlerExecutor implements Executor {
    public final Handler mHandler;

    public RequestExecutor$HandlerExecutor(Handler handler) {
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        Handler handler = this.mHandler;
        if (handler.post(runnable)) {
            return;
        }
        throw new RejectedExecutionException(handler + " is shutting down");
    }
}
