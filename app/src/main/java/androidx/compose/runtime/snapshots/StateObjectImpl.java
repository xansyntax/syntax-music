package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.AtomicInt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StateObjectImpl implements StateObject {
    public final AtomicInt readerKind = new AtomicInt(0);

    /* JADX INFO: renamed from: isReadIn-h_f27i8$runtime, reason: not valid java name */
    public final boolean m395isReadInh_f27i8$runtime(int i) {
        return (this.readerKind.get() & i) != 0;
    }

    /* JADX INFO: renamed from: recordReadIn-h_f27i8$runtime, reason: not valid java name */
    public final void m396recordReadInh_f27i8$runtime(int i) {
        AtomicInt atomicInt;
        int i2;
        do {
            atomicInt = this.readerKind;
            i2 = atomicInt.get();
            if ((i2 & i) != 0) {
                return;
            }
        } while (!atomicInt.compareAndSet(i2, i2 | i));
    }
}
