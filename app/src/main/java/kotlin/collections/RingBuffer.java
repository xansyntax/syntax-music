package kotlin.collections;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RingBuffer extends AbstractList implements RandomAccess {
    public final Object[] buffer;
    public final int capacity;
    public int size;
    public int startIndex;

    public RingBuffer(int i, Object[] objArr) {
        this.buffer = objArr;
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "ring buffer filled size should not be negative but it is "));
            throw null;
        }
        if (i > objArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "ring buffer filled size: ", " cannot be larger than the buffer size: "), objArr.length);
            throw null;
        }
        this.capacity = objArr.length;
        this.size = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
            return null;
        }
        return this.buffer[(this.startIndex + i) % this.capacity];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AbstractIterator() { // from class: kotlin.collections.RingBuffer.iterator.1
            public int count;
            public int index;

            {
                this.count = RingBuffer.this.size;
                this.index = RingBuffer.this.startIndex;
            }

            @Override // kotlin.collections.AbstractIterator
            public final void computeNext() {
                int i = this.count;
                if (i == 0) {
                    this.state = (byte) 2;
                    return;
                }
                RingBuffer ringBuffer = RingBuffer.this;
                Object[] objArr = ringBuffer.buffer;
                int i2 = this.index;
                this.nextValue = objArr[i2];
                this.state = (byte) 1;
                this.index = (i2 + 1) % ringBuffer.capacity;
                this.count = i - 1;
            }
        };
    }

    public final void removeFirst(int i) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "n shouldn't be negative but it is "));
            return;
        }
        if (i > this.size) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "n shouldn't be greater than the buffer size: n = ", ", size = "), this.size);
            return;
        }
        if (i > 0) {
            int i2 = this.startIndex;
            int i3 = this.capacity;
            int i4 = (i2 + i) % i3;
            Object[] objArr = this.buffer;
            if (i2 > i4) {
                Arrays.fill(objArr, i2, i3, (Object) null);
                Arrays.fill(objArr, 0, i4, (Object) null);
            } else {
                Arrays.fill(objArr, i2, i4, (Object) null);
            }
            this.startIndex = i4;
            this.size -= i;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] objArr2;
        objArr.getClass();
        int length = objArr.length;
        int i = this.size;
        if (length < i) {
            objArr = Arrays.copyOf(objArr, i);
        }
        int i2 = this.size;
        int i3 = this.startIndex;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            objArr2 = this.buffer;
            if (i5 >= i2 || i3 >= this.capacity) {
                break;
            }
            objArr[i5] = objArr2[i3];
            i5++;
            i3++;
        }
        while (i5 < i2) {
            objArr[i5] = objArr2[i4];
            i5++;
            i4++;
        }
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[getSize()]);
    }
}
