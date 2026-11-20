package androidx.datastore.preferences.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProtobufArrayList extends AbstractList implements RandomAccess, Internal.ProtobufList {
    public static final ProtobufArrayList EMPTY_LIST = new ProtobufArrayList(new Object[0], 0, false);
    public Object[] array;
    public boolean isMutable;
    public int size;

    public ProtobufArrayList(Object[] objArr, int i, boolean z) {
        this.isMutable = z;
        this.array = objArr;
        this.size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
            return;
        }
        Object[] objArr = this.array;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.array, i, objArr2, i + 1, this.size - i);
            this.array = objArr2;
        }
        this.array[i] = obj;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ensureIsMutable();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        ensureIsMutable();
        super.clear();
    }

    public final void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
        }
    }

    public final void ensureIsMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    public final ProtobufArrayList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new ProtobufArrayList(Arrays.copyOf(this.array, i), this.size, true);
        }
        Path$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        Object[] objArr = this.array;
        Object obj = objArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        ensureIsMutable();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        ensureIsMutable();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        ensureIsMutable();
        ensureIndexInRange(i);
        Object[] objArr = this.array;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        ensureIsMutable();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ensureIsMutable();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ensureIsMutable();
        int i = this.size;
        Object[] objArrCopyOf = this.array;
        if (i == objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, ((i * 3) / 2) + 1);
            this.array = objArrCopyOf;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        objArrCopyOf[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
