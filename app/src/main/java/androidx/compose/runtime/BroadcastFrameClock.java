package androidx.compose.runtime;

import android.view.Choreographer;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import coil3.ImageLoader$Builder;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public final /* synthetic */ byte $r8$classId;
    public final Object onNewAwaiters;
    public final Object queue;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FrameAwaiter extends AwaiterQueue$Awaiter {
        public CancellableContinuationImpl continuation;
        public Function1 onFrame;

        @Override // androidx.compose.runtime.internal.AwaiterQueue$Awaiter
        public final void cancel() {
            this.onFrame = null;
            this.continuation = null;
        }

        public final void resume(long j) {
            CancellableContinuationImpl cancellableContinuationImpl;
            Object failure;
            Function1 function1 = this.onFrame;
            if (function1 == null || (cancellableContinuationImpl = this.continuation) == null) {
                return;
            }
            try {
                failure = function1.invoke(Long.valueOf(j));
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            cancellableContinuationImpl.resumeWith(failure);
        }

        @Override // androidx.compose.runtime.internal.AwaiterQueue$Awaiter
        public void resumeWithException(Throwable th) {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.resumeWith(ResultKt.createFailure(th));
            }
        }
    }

    public BroadcastFrameClock(Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1) {
        this.$r8$classId = (byte) 0;
        this.onNewAwaiters = recomposer$$ExternalSyntheticLambda1;
        this.queue = new ImageLoader$Builder();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final Object withFrameNanos(final Function1 function1, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
                cancellableContinuationImpl.initCancellability();
                ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) this.queue;
                FrameAwaiter frameAwaiter = new FrameAwaiter();
                frameAwaiter.continuation = cancellableContinuationImpl;
                frameAwaiter.onFrame = function1;
                cancellableContinuationImpl.invokeOnCancellation(new CallsKt$await$2$1((byte) 4, imageLoader$Builder.addAwaiter(frameAwaiter, (Recomposer$$ExternalSyntheticLambda1) this.onNewAwaiters)));
                return cancellableContinuationImpl.getResult();
            default:
                AndroidUiDispatcher androidUiDispatcher = (AndroidUiDispatcher) this.queue;
                final CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
                cancellableContinuationImpl2.initCancellability();
                Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback(this, function1) { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
                    public final /* synthetic */ Function1 $onFrame;

                    {
                        this.$onFrame = function1;
                    }

                    @Override // android.view.Choreographer.FrameCallback
                    public final void doFrame(long j) {
                        Object failure;
                        try {
                            failure = this.$onFrame.invoke(Long.valueOf(j));
                        } catch (Throwable th) {
                            failure = new Result.Failure(th);
                        }
                        this.$co.resumeWith(failure);
                    }
                };
                if (Intrinsics.areEqual(androidUiDispatcher.choreographer, (Choreographer) this.onNewAwaiters)) {
                    synchronized (androidUiDispatcher.lock) {
                        androidUiDispatcher.toRunOnFrame.add(frameCallback);
                        if (!androidUiDispatcher.scheduledFrameDispatch) {
                            androidUiDispatcher.scheduledFrameDispatch = true;
                            androidUiDispatcher.choreographer.postFrameCallback(androidUiDispatcher.dispatchCallback);
                        }
                        break;
                    }
                    cancellableContinuationImpl2.invokeOnCancellation(new Latch$await$2$2(androidUiDispatcher, frameCallback, (byte) 5));
                } else {
                    ((Choreographer) this.onNewAwaiters).postFrameCallback(frameCallback);
                    cancellableContinuationImpl2.invokeOnCancellation(new Latch$await$2$2(this, frameCallback, (byte) 6));
                }
                return cancellableContinuationImpl2.getResult();
        }
    }

    public BroadcastFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        this.$r8$classId = (byte) 1;
        this.onNewAwaiters = choreographer;
        this.queue = androidUiDispatcher;
    }
}
