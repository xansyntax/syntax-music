package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class CompletedExceptionally {
    public static final /* synthetic */ long _handled$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(CompletedExceptionally.class.getDeclaredField("_handled$volatile"));
    private volatile /* synthetic */ int _handled$volatile;
    public final Throwable cause;

    public CompletedExceptionally(Throwable th, boolean z) {
        this.cause = th;
        this._handled$volatile = z ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.cause + ']';
    }
}
