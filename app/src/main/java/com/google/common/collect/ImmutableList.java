package com.google.common.collect;

import coil3.util.UtilsKt;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableList extends ImmutableCollection implements List, RandomAccess {
    public static final Itr EMPTY_ITR = new Itr(RegularImmutableList.EMPTY, 0);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder extends ImmutableCollection.ArrayBasedBuilder {
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public final ImmutableCollection.Builder add(Object obj) {
            add(obj);
            return this;
        }

        public final RegularImmutableList build() {
            this.forceCopy = true;
            return ImmutableList.asImmutableList(this.size, this.contents);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Itr extends AbstractIndexedListIterator {
        public final ImmutableList list;

        public Itr(ImmutableList immutableList, int i) {
            super(immutableList.size(), i);
            this.list = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public final Object get(int i) {
            return this.list.get(i);
        }
    }

    public static RegularImmutableList asImmutableList(int i, Object[] objArr) {
        return i == 0 ? RegularImmutableList.EMPTY : new RegularImmutableList(i, objArr);
    }

    public static Builder builder() {
        return new Builder(4);
    }

    public static ImmutableList copyOf(Collection collection) {
        if (!(collection instanceof ImmutableCollection)) {
            Object[] array = collection.toArray();
            Maps.checkElementsNotNull(array.length, array);
            return asImmutableList(array.length, array);
        }
        ImmutableList immutableListAsList = ((ImmutableCollection) collection).asList();
        if (!immutableListAsList.isPartialView()) {
            return immutableListAsList;
        }
        Object[] array2 = immutableListAsList.toArray(ImmutableCollection.EMPTY_ARRAY);
        return asImmutableList(array2.length, array2);
    }

    public static RegularImmutableList of(Object obj) {
        Object[] objArr = {obj};
        Maps.checkElementsNotNull(1, objArr);
        return asImmutableList(1, objArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static RegularImmutableList sortedCopyOf(Ordering ordering, List list) {
        ordering.getClass();
        if (list == null) {
            list = Maps.newArrayList(list.iterator());
        }
        Object[] array = list.toArray();
        Maps.checkElementsNotNull(array.length, array);
        Arrays.sort(array, ordering);
        return asImmutableList(array.length, array);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(int i, Object[] objArr) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator it = iterator();
                        Iterator it2 = list.iterator();
                        while (it.hasNext()) {
                            if (it2.hasNext() && Objects.equals(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i = 0; i < size; i++) {
                        if (Objects.equals(get(i), list.get(i))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final Itr listIterator(int i) {
        UtilsKt.checkPositionIndex(i, size());
        return isEmpty() ? EMPTY_ITR : new Itr(this, i);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ImmutableList subList(int i, int i2) {
        UtilsKt.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? RegularImmutableList.EMPTY : new SubList(i, i3);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SubList extends ImmutableList {
        public final transient int length;
        public final transient int offset;

        public SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        @Override // java.util.List
        public final Object get(int i) {
            UtilsKt.checkElementIndex(i, this.length);
            return ImmutableList.this.get(i + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ImmutableList subList(int i, int i2) {
            UtilsKt.checkPositionIndexes(i, i2, this.length);
            int i3 = this.offset;
            return ImmutableList.this.subList(i + i3, i2 + i3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return listIterator(i);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    public static RegularImmutableList of(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        Maps.checkElementsNotNull(2, objArr);
        return asImmutableList(2, objArr);
    }

    public static RegularImmutableList of(Long l, Long l2, Long l3, Long l4, Long l5) {
        Object[] objArr = {l, l2, l3, l4, l5};
        Maps.checkElementsNotNull(5, objArr);
        return asImmutableList(5, objArr);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return this;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    public static RegularImmutableList copyOf(Object[] objArr) {
        if (objArr.length == 0) {
            return RegularImmutableList.EMPTY;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        Maps.checkElementsNotNull(objArr2.length, objArr2);
        return asImmutableList(objArr2.length, objArr2);
    }
}
