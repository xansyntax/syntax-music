package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DisposeOnCancel implements CancelHandler {
    public final /* synthetic */ byte $r8$classId;
    public final Object handle;

    public /* synthetic */ DisposeOnCancel(byte b, Object obj) {
        this.$r8$classId = b;
        this.handle = obj;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void invoke(Throwable th) {
        byte b = this.$r8$classId;
        Object obj = this.handle;
        switch (b) {
            case 0:
                ((DisposableHandle) obj).dispose();
                break;
            case 1:
                ((ScheduledFuture) obj).cancel(false);
                break;
            default:
                ((Function1) obj).invoke(th);
                break;
        }
    }

    public final String toString() {
        byte b = this.$r8$classId;
        Object obj = this.handle;
        switch (b) {
            case 0:
                return "DisposeOnCancel[" + ((DisposableHandle) obj) + ']';
            case 1:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) obj) + ']';
            default:
                return "CancelHandler.UserSupplied[" + ((Function1) obj).getClass().getSimpleName() + '@' + AwaitKt.getHexAddress(this) + ']';
        }
    }
}
