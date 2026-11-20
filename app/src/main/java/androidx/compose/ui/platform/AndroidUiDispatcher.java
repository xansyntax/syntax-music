package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.BroadcastFrameClock;
import java.util.ArrayList;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.random.FallbackThreadLocalRandom$implStorage$1;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidUiDispatcher extends CoroutineDispatcher {
    public static final SynchronizedLazyImpl Main$delegate = new SynchronizedLazyImpl(new TextKt$$ExternalSyntheticLambda3(27));
    public static final FallbackThreadLocalRandom$implStorage$1 currentThread = new FallbackThreadLocalRandom$implStorage$1((byte) 1);
    public final Choreographer choreographer;
    public final BroadcastFrameClock frameClock;
    public final Handler handler;
    public boolean scheduledFrameDispatch;
    public boolean scheduledTrampolineDispatch;
    public final Object lock = new Object();
    public final ArrayDeque toRunTrampolined = new ArrayDeque();
    public ArrayList toRunOnFrame = new ArrayList();
    public ArrayList spareToRunOnFrame = new ArrayList();
    public final AndroidUiDispatcher$dispatchCallback$1 dispatchCallback = new AndroidUiDispatcher$dispatchCallback$1(this);

    public AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.choreographer = choreographer;
        this.handler = handler;
        this.frameClock = new BroadcastFrameClock(choreographer, this);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        synchronized (this.lock) {
            this.toRunTrampolined.addLast(runnable);
            if (!this.scheduledTrampolineDispatch) {
                this.scheduledTrampolineDispatch = true;
                this.handler.post(this.dispatchCallback);
                if (!this.scheduledFrameDispatch) {
                    this.scheduledFrameDispatch = true;
                    this.choreographer.postFrameCallback(this.dispatchCallback);
                }
            }
        }
    }

    public final void performTrampolineDispatch() {
        Runnable runnable;
        boolean z;
        do {
            synchronized (this.lock) {
                ArrayDeque arrayDeque = this.toRunTrampolined;
                runnable = (Runnable) (arrayDeque.isEmpty() ? null : arrayDeque.removeFirst());
            }
            while (runnable != null) {
                runnable.run();
                synchronized (this.lock) {
                    ArrayDeque arrayDeque2 = this.toRunTrampolined;
                    runnable = (Runnable) (arrayDeque2.isEmpty() ? null : arrayDeque2.removeFirst());
                }
            }
            synchronized (this.lock) {
                if (this.toRunTrampolined.isEmpty()) {
                    z = false;
                    this.scheduledTrampolineDispatch = false;
                } else {
                    z = true;
                }
            }
        } while (z);
    }
}
