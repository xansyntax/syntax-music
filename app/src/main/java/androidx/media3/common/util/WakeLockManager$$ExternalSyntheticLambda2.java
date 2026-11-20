package androidx.media3.common.util;

import androidx.compose.ui.platform.WeakCache;
import androidx.core.provider.CallbackWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WakeLockManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ AtomicBoolean f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ WakeLockManager$$ExternalSyntheticLambda2(Object obj, AtomicBoolean atomicBoolean, boolean z, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = atomicBoolean;
        this.f$2 = z;
        this.f$3 = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        boolean z = this.f$3;
        boolean z2 = this.f$2;
        AtomicBoolean atomicBoolean = this.f$1;
        Exchange exchange = (Exchange) this.f$0;
        switch (b) {
            case 0:
                atomicBoolean.set(false);
                ((CallbackWrapper) exchange.call).updateWakeLock(z2, z);
                break;
            default:
                atomicBoolean.set(false);
                ((WeakCache) exchange.call).updateWifiLock(z2, z);
                break;
        }
    }
}
