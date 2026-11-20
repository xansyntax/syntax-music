package androidx.media3.session;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultMediaNotificationProvider$$ExternalSyntheticLambda1 implements Executor {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Handler f$0;

    public /* synthetic */ DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(Handler handler, byte b) {
        this.$r8$classId = b;
        this.f$0 = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        byte b = this.$r8$classId;
        this.f$0.post(runnable);
    }
}
