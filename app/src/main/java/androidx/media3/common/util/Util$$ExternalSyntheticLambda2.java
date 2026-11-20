package androidx.media3.common.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Util$$ExternalSyntheticLambda2 implements ThreadFactory {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ Util$$ExternalSyntheticLambda2(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        byte b = this.$r8$classId;
        String str = this.f$0;
        switch (b) {
            case 0:
                return new Thread(runnable, str);
            default:
                Thread thread = new Thread(runnable, str);
                thread.setPriority(10);
                return thread;
        }
    }
}
