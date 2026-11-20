package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DispatchedCoroutine extends ScopeCoroutine {
    public static final /* synthetic */ long _decision$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(DispatchedCoroutine.class.getDeclaredField("_decision$volatile"));
    private volatile /* synthetic */ int _decision$volatile;

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void afterCompletion(Object obj) throws DispatchException {
        afterResume(obj);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void afterResume(Object obj) throws DispatchException {
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _decision$volatile$FU$offset;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile != 0) {
                if (intVolatile != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already resumed");
                    return;
                } else {
                    InlineList.resumeCancellableWithInternal(AwaitKt.recoverResult(obj), Okio__OkioKt.intercepted(this.uCont));
                    return;
                }
            }
            DispatchedCoroutine dispatchedCoroutine = this;
            if (unsafe.compareAndSwapInt(dispatchedCoroutine, j, 0, 2)) {
                return;
            } else {
                this = dispatchedCoroutine;
            }
        }
    }
}
