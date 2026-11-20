package com.metrolist.music.playback;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DownloadUtil$$ExternalSyntheticLambda2 implements Executor {
    public final /* synthetic */ byte $r8$classId;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                runnable.getClass();
                runnable.run();
                break;
            case 1:
                ArchTaskExecutor.getInstance().mDelegate.mDiskIO.execute(runnable);
                break;
            case 2:
                break;
            default:
                runnable.run();
                break;
        }
    }

    private final void execute$androidx$media3$exoplayer$video$DefaultVideoSink$$ExternalSyntheticLambda0(Runnable runnable) {
    }
}
