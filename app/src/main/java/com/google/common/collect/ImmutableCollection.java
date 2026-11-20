package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableCollection extends AbstractCollection implements Serializable {
    public static final Object[] EMPTY_ARRAY = new Object[0];

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class ArrayBasedBuilder extends Builder {
        public Object[] contents;
        public boolean forceCopy;
        public int size;

        public ArrayBasedBuilder(int i) {
            Maps.checkNonnegative(i, "initialCapacity");
            this.contents = new Object[i];
            this.size = 0;
        }

        public final void add(Object obj) {
            obj.getClass();
            ensureRoomFor(1);
            Object[] objArr = this.contents;
            int i = this.size;
            this.size = i + 1;
            objArr[i] = obj;
        }

        public final void addAll(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                ensureRoomFor(collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.size = ((ImmutableCollection) collection).copyIntoArray(this.size, this.contents);
                    return;
                }
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }

        public final void ensureRoomFor(int i) {
            Object[] objArr = this.contents;
            int iExpandedCapacity = Builder.expandedCapacity(objArr.length, this.size + i);
            if (iExpandedCapacity > objArr.length || this.forceCopy) {
                this.contents = Arrays.copyOf(this.contents, iExpandedCapacity);
                this.forceCopy = false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Builder {
        public static int expandedCapacity(int i, int i2) {
            if (i2 < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("cannot store more than Integer.MAX_VALUE elements");
                return 0;
            }
            if (i2 <= i) {
                return i;
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public abstract Builder add(Object obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList asList() {
        if (isEmpty()) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        Object[] array = toArray(EMPTY_ARRAY);
        ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
        return ImmutableList.asImmutableList(array.length, array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return ((RegularImmutableMultiset) this).contents.get(obj) > 0;
    }

    public int copyIntoArray(int i, Object[] objArr) {
        UnmodifiableIterator it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract UnmodifiableIterator iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        if (objArr.length < size) {
            Object[] objArrInternalArray = internalArray();
            if (objArrInternalArray != null) {
                return Arrays.copyOfRange(objArrInternalArray, internalArrayStart(), internalArrayEnd(), objArr.getClass());
            }
            if (objArr.length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        copyIntoArray(0, objArr);
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }
}
