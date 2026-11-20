package androidx.media3.session;

import androidx.compose.ui.platform.AndroidComposeView;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.room.RoomDatabase$closeBarrier$1;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerHolder$$ExternalSyntheticLambda1 implements Executor {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MediaControllerHolder$$ExternalSyntheticLambda1(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                Util.postOrRun(((MediaControllerHolder) obj).handler, runnable);
                break;
            case 1:
                AndroidComposeView outOfFrameExecutor = ((AndroidComposeView) obj).getOutOfFrameExecutor();
                if (outOfFrameExecutor != null) {
                    outOfFrameExecutor.schedule(new RoomDatabase$closeBarrier$1(0, runnable, Runnable.class, "run", "run()V", 0, (byte) 5));
                }
                break;
            case 2:
                ((SystemHandlerWrapper) obj).post(runnable);
                break;
            default:
                Util.postOrRun(((MediaNotificationManager) obj).mainHandler, runnable);
                break;
        }
    }
}
