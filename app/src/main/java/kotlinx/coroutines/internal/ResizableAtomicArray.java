package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ResizableAtomicArray {
    private volatile AtomicReferenceArray<Object> array;

    public ResizableAtomicArray(int i) {
        this.array = new AtomicReferenceArray<>(i);
    }

    public final int currentLength() {
        return this.array.length();
    }

    public final Object get(int i) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i);
        }
        return null;
    }

    public final void setSynchronized(int i, CoroutineScheduler.Worker worker) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i < length) {
            atomicReferenceArray.set(i, worker);
            return;
        }
        int i2 = i + 1;
        int i3 = length * 2;
        if (i2 < i3) {
            i2 = i3;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i2);
        for (int i4 = 0; i4 < length; i4++) {
            atomicReferenceArray2.set(i4, atomicReferenceArray.get(i4));
        }
        atomicReferenceArray2.set(i, worker);
        this.array = atomicReferenceArray2;
    }
}
