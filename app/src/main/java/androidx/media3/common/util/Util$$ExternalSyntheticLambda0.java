package androidx.media3.common.util;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Util$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SettableFuture f$0;
    public final /* synthetic */ ListenableFuture f$1;

    public /* synthetic */ Util$$ExternalSyntheticLambda0(SettableFuture settableFuture, ListenableFuture listenableFuture, byte b) {
        this.$r8$classId = b;
        this.f$0 = settableFuture;
        this.f$1 = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        ListenableFuture listenableFuture = this.f$1;
        SettableFuture settableFuture = this.f$0;
        switch (b) {
            case 0:
                if (settableFuture.isCancelled()) {
                    listenableFuture.cancel(false);
                }
                break;
            default:
                if (settableFuture.isCancelled()) {
                    listenableFuture.cancel(false);
                }
                break;
        }
    }
}
