package io.ktor.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NonceKt$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ byte $r8$classId;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                return NonceKt.nonceGeneratorDispatcher$lambda$0(runnable);
            case 1:
                return new Thread(runnable, "ExoPlayer:AudioTrackReleaseThread");
            default:
                Thread thread = new Thread(runnable, "InnerTubeX-QuickJS");
                thread.setDaemon(true);
                return thread;
        }
    }

    public /* synthetic */ NonceKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }
}
