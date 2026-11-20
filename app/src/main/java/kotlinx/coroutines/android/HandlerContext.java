package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannel$$ExternalSyntheticLambda2;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HandlerContext extends CoroutineDispatcher implements Delay {
    public final Handler handler;
    public final HandlerContext immediate;
    public final boolean invokeImmediately;
    public final String name;

    public HandlerContext(Handler handler, String str, boolean z) {
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this.immediate = z ? this : new HandlerContext(handler, str, true);
    }

    public final void cancelOnRejection(CoroutineContext coroutineContext, Runnable runnable) {
        AwaitKt.cancel(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        DefaultIoScheduler.INSTANCE.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.handler.post(runnable)) {
            return;
        }
        cancelOnRejection(coroutineContext, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HandlerContext)) {
            return false;
        }
        HandlerContext handlerContext = (HandlerContext) obj;
        return handlerContext.handler == this.handler && handlerContext.invokeImmediately == this.invokeImmediately;
    }

    public final int hashCode() {
        return (this.invokeImmediately ? 1231 : 1237) ^ System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.handler.postDelayed(runnable, j)) {
            return new ByteChannel$$ExternalSyntheticLambda2(this, runnable, (byte) 1);
        }
        cancelOnRejection(coroutineContext, runnable);
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        InlineList.checkParallelism(i);
        return this;
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        TransactionExecutor$$ExternalSyntheticLambda0 transactionExecutor$$ExternalSyntheticLambda0 = new TransactionExecutor$$ExternalSyntheticLambda0((Object) cancellableContinuationImpl, (Object) this, (byte) 17);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.handler.postDelayed(transactionExecutor$$ExternalSyntheticLambda0, j)) {
            cancellableContinuationImpl.invokeOnCancellation(new FileChannelsKt$$ExternalSyntheticLambda1(this, transactionExecutor$$ExternalSyntheticLambda0, (byte) 9));
        } else {
            cancelOnRejection(cancellableContinuationImpl.context, transactionExecutor$$ExternalSyntheticLambda0);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        HandlerContext handlerContext;
        String str;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
        if (this == handlerContext2) {
            str = "Dispatchers.Main";
        } else {
            try {
                handlerContext = handlerContext2.immediate;
            } catch (UnsupportedOperationException unused) {
                handlerContext = null;
            }
            str = this == handlerContext ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        if (!this.invokeImmediately) {
            return string;
        }
        return string + ".immediate";
    }

    public HandlerContext(Handler handler) {
        this(handler, null, false);
    }
}
