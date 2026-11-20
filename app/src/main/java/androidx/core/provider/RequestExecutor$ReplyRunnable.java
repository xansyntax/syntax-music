package androidx.core.provider;

import android.os.Handler;
import androidx.core.app.ActivityRecreator;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RequestExecutor$ReplyRunnable implements Runnable {
    public final /* synthetic */ byte $r8$classId = 0;
    public Object mCallable;
    public Object mConsumer;
    public Object mHandler;

    public RequestExecutor$ReplyRunnable(CancellableContinuationImpl cancellableContinuationImpl, RoomDatabase roomDatabase, RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) {
        this.mCallable = cancellableContinuationImpl;
        this.mConsumer = roomDatabase;
        this.mHandler = roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        switch (this.$r8$classId) {
            case 0:
                try {
                    objCall = ((FontRequestWorker.AnonymousClass1) this.mCallable).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.mHandler).post(new ActivityRecreator.AnonymousClass1((FontRequestWorker.AnonymousClass2) this.mConsumer, objCall, (byte) 5));
                break;
            default:
                CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.mCallable;
                try {
                    AwaitKt.runBlockingK(cancellableContinuationImpl.context.minusKey(ContinuationInterceptor$Key.$$INSTANCE), new InnerTube$feedback$2(this.mConsumer, (Object) cancellableContinuationImpl, this.mHandler, (Continuation) null, (byte) 8));
                } catch (Throwable th) {
                    cancellableContinuationImpl.cancel(th);
                }
                break;
        }
    }

    public /* synthetic */ RequestExecutor$ReplyRunnable() {
    }
}
