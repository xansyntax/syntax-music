package androidx.media3.exoplayer.util;

import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReleasableExecutor$1 implements Executor {
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ FrameworkMediaDrm$$ExternalSyntheticLambda0 val$releaseCallback;

    public ReleasableExecutor$1(ExecutorService executorService, FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) {
        this.val$executor = executorService;
        this.val$releaseCallback = frameworkMediaDrm$$ExternalSyntheticLambda0;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.val$executor.execute(runnable);
    }
}
