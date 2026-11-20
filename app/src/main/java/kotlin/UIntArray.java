package kotlin;

import androidx.collection.SparseArrayCompat;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.descriptors.SerialDescriptor;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UIntArray implements Collection, KMappedMarker {
    public final int[] storage;

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x001d A[RETURN] */
    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        int i = ((UInt) obj).data;
        int[] iArr = this.storage;
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (i == iArr[i2]) {
                if (i2 >= 0) {
                    return true;
                }
                return false;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (obj instanceof UInt) {
                int i = ((UInt) obj).data;
                int[] iArr = this.storage;
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    }
                    if (i == iArr[i2]) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= 0) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof UIntArray) {
            return this.storage.equals(((UIntArray) obj).storage);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.storage);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.storage.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        return new Iterator((byte) 0, this.storage);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.storage.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.storage) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Iterator implements java.util.Iterator, KMappedMarker {
        public final /* synthetic */ byte $r8$classId;
        public final Object array;
        public int index;

        public Iterator(SerialDescriptor serialDescriptor) {
            this.$r8$classId = (byte) 7;
            this.array = serialDescriptor;
            this.index = serialDescriptor.getElementsCount();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            byte b = this.$r8$classId;
            Object obj = this.array;
            switch (b) {
                case 0:
                    return this.index < ((int[]) obj).length;
                case 1:
                    return this.index < ((SparseArrayCompat) obj).size();
                case 2:
                    return this.index < ((byte[]) obj).length;
                case 3:
                    return this.index < ((long[]) obj).length;
                case 4:
                    return this.index < ((short[]) obj).length;
                case 5:
                    return this.index < ((AbstractList) obj).getSize();
                case 6:
                    return this.index < ((Object[]) obj).length;
                default:
                    return this.index > 0;
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            byte b = this.$r8$classId;
            Object obj = this.array;
            switch (b) {
                case 0:
                    int i = this.index;
                    int[] iArr = (int[]) obj;
                    if (i < iArr.length) {
                        this.index = i + 1;
                        return new UInt(iArr[i]);
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1(String.valueOf(i));
                    return null;
                case 1:
                    int i2 = this.index;
                    this.index = i2 + 1;
                    return ((SparseArrayCompat) obj).valueAt(i2);
                case 2:
                    int i3 = this.index;
                    byte[] bArr = (byte[]) obj;
                    if (i3 < bArr.length) {
                        this.index = i3 + 1;
                        return new UByte(bArr[i3]);
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1(String.valueOf(i3));
                    return null;
                case 3:
                    int i4 = this.index;
                    long[] jArr = (long[]) obj;
                    if (i4 < jArr.length) {
                        this.index = i4 + 1;
                        return new ULong(jArr[i4]);
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1(String.valueOf(i4));
                    return null;
                case 4:
                    int i5 = this.index;
                    short[] sArr = (short[]) obj;
                    if (i5 < sArr.length) {
                        this.index = i5 + 1;
                        return new UShort(sArr[i5]);
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1(String.valueOf(i5));
                    return null;
                case 5:
                    if (!hasNext()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                        return null;
                    }
                    int i6 = this.index;
                    this.index = i6 + 1;
                    return ((AbstractList) obj).get(i6);
                case 6:
                    try {
                        int i7 = this.index;
                        this.index = i7 + 1;
                        return ((Object[]) obj)[i7];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        this.index--;
                        PathKt$$ExternalSyntheticBUOutline0.m$1(e.getMessage());
                        return null;
                    }
                default:
                    SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                    int elementsCount = serialDescriptor.getElementsCount();
                    int i8 = this.index;
                    this.index = i8 - 1;
                    return serialDescriptor.getElementName(elementsCount - i8);
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 1:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 2:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 3:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 4:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 5:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 6:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public Iterator(Object[] objArr) {
            this.$r8$classId = (byte) 6;
            objArr.getClass();
            this.array = objArr;
        }

        public /* synthetic */ Iterator(byte b, Object obj) {
            this.$r8$classId = b;
            this.array = obj;
        }
    }
}
