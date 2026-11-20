package androidx.collection;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.MutableVectorKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableObjectList {
    public int _size;
    public Object[] content;
    public ObjectListMutableList list;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MutableObjectListIterator implements ListIterator, KMappedMarker {
        public final /* synthetic */ byte $r8$classId;
        public final List list;
        public int prevIndex;

        public MutableObjectListIterator(List list, int i, byte b) {
            this.$r8$classId = b;
            switch (b) {
                case 1:
                    this.list = list;
                    this.prevIndex = i;
                    break;
                default:
                    this.list = list;
                    this.prevIndex = i - 1;
                    break;
            }
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    int i = this.prevIndex + 1;
                    this.prevIndex = i;
                    list.add(i, obj);
                    break;
                default:
                    list.add(this.prevIndex, obj);
                    this.prevIndex++;
                    break;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    return this.prevIndex < list.size() - 1;
                default:
                    return this.prevIndex < list.size();
            }
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex >= 0;
                default:
                    return this.prevIndex > 0;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    int i = this.prevIndex + 1;
                    this.prevIndex = i;
                    return list.get(i);
                default:
                    int i2 = this.prevIndex;
                    this.prevIndex = i2 + 1;
                    return list.get(i2);
            }
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex + 1;
                default:
                    return this.prevIndex;
            }
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    int i = this.prevIndex;
                    this.prevIndex = i - 1;
                    return list.get(i);
                default:
                    int i2 = this.prevIndex - 1;
                    this.prevIndex = i2;
                    return list.get(i2);
            }
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            switch (this.$r8$classId) {
                case 0:
                    return this.prevIndex;
                default:
                    return this.prevIndex - 1;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    list.remove(this.prevIndex);
                    this.prevIndex--;
                    break;
                default:
                    int i = this.prevIndex - 1;
                    this.prevIndex = i;
                    list.remove(i);
                    break;
            }
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    list.set(this.prevIndex, obj);
                    break;
                default:
                    list.set(this.prevIndex, obj);
                    break;
            }
        }
    }

    public MutableObjectList(int i) {
        this.content = i == 0 ? ObjectListKt.EmptyArray : new Object[i];
    }

    public final void add(Object obj) {
        int i = this._size + 1;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        Object[] objArr2 = this.content;
        int i2 = this._size;
        objArr2[i2] = obj;
        this._size = i2 + 1;
    }

    public final void addAll(List list) {
        if (list.isEmpty()) {
            return;
        }
        int i = this._size;
        int size = list.size() + i;
        Object[] objArr = this.content;
        if (objArr.length < size) {
            resizeStorage(size, objArr);
        }
        Object[] objArr2 = this.content;
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            objArr2[i2 + i] = list.get(i2);
        }
        this._size = list.size() + this._size;
    }

    public final void clear() {
        ArraysKt.fill(0, this._size, null, this.content);
        this._size = 0;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) obj;
            int i = mutableObjectList._size;
            int i2 = this._size;
            if (i == i2) {
                Object[] objArr = this.content;
                Object[] objArr2 = mutableObjectList.content;
                IntRange intRangeUntil = UuidKt.until(0, i2);
                int i3 = intRangeUntil.first;
                int i4 = intRangeUntil.last;
                if (i3 > i4) {
                    return true;
                }
                while (Intrinsics.areEqual(objArr[i3], objArr2[i3])) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("ObjectList is empty.");
        return null;
    }

    public final Object get(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        throwIndexOutOfBoundsExclusiveException$collection(i);
        throw null;
    }

    public final int hashCode() {
        Object[] objArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(Object obj) {
        Object[] objArr = this.content;
        int i = 0;
        if (obj == null) {
            int i2 = this._size;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this._size;
        while (i < i3) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final Object removeAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            throwIndexOutOfBoundsExclusiveException$collection(i);
            throw null;
        }
        Object[] objArr = this.content;
        Object obj = objArr[i];
        if (i != i2 - 1) {
            ArraysKt.copyInto(i, i + 1, i2, objArr, objArr);
        }
        int i3 = this._size - 1;
        this._size = i3;
        objArr[i3] = null;
        return obj;
    }

    public final void removeRange(int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this._size) || i2 < 0 || i2 > i3) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m3m(i, "Start (", ") and end (", i2, ") must be in 0.."), this._size);
            return;
        }
        if (i2 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + ')');
        }
        if (i2 != i) {
            if (i2 < i3) {
                Object[] objArr = this.content;
                ArraysKt.copyInto(i, i2, i3, objArr, objArr);
            }
            int i4 = this._size;
            int i5 = i4 - (i2 - i);
            ArraysKt.fill(i5, i4, null, this.content);
            this._size = i5;
        }
    }

    public final void resizeStorage(int i, Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, (length * 3) / 2)];
        ArraysKt.copyInto(0, 0, length, objArr, objArr2);
        this.content = objArr2;
    }

    public final void throwIndexOutOfBoundsExclusiveException$collection(int i) {
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index ", " must be in 0..");
        sbM2m.append(this._size - 1);
        throw new IndexOutOfBoundsException(sbM2m.toString());
    }

    public final void throwIndexOutOfBoundsInclusiveException(int i) {
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index ", " must be in 0..");
        sbM2m.append(this._size);
        throw new IndexOutOfBoundsException(sbM2m.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) (obj == this ? "(this)" : String.valueOf(obj)));
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }

    public /* synthetic */ MutableObjectList() {
        this(16);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ObjectListMutableList implements List, KMutableList {
        public final /* synthetic */ byte $r8$classId;
        public final Object objectList;

        public /* synthetic */ ObjectListMutableList(byte b, Object obj) {
            this.$r8$classId = b;
            this.objectList = obj;
        }

        @Override // java.util.List
        public final void add(int i, Object obj) {
            int i2;
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) obj2;
                    if (i < 0 || i > (i2 = mutableObjectList._size)) {
                        mutableObjectList.throwIndexOutOfBoundsInclusiveException(i);
                        throw null;
                    }
                    int i3 = i2 + 1;
                    Object[] objArr = mutableObjectList.content;
                    if (objArr.length < i3) {
                        mutableObjectList.resizeStorage(i3, objArr);
                    }
                    Object[] objArr2 = mutableObjectList.content;
                    int i4 = mutableObjectList._size;
                    if (i != i4) {
                        ArraysKt.copyInto(i + 1, i, i4, objArr2, objArr2);
                    }
                    objArr2[i] = obj;
                    mutableObjectList._size++;
                    return;
                default:
                    ((MutableVector) obj2).add(i, obj);
                    return;
            }
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    collection.getClass();
                    MutableObjectList mutableObjectList = (MutableObjectList) obj;
                    if (i < 0 || i > mutableObjectList._size) {
                        mutableObjectList.throwIndexOutOfBoundsInclusiveException(i);
                        throw null;
                    }
                    int i2 = 0;
                    if (collection.isEmpty()) {
                        return false;
                    }
                    int size = collection.size() + mutableObjectList._size;
                    Object[] objArr = mutableObjectList.content;
                    if (objArr.length < size) {
                        mutableObjectList.resizeStorage(size, objArr);
                    }
                    Object[] objArr2 = mutableObjectList.content;
                    if (i != mutableObjectList._size) {
                        ArraysKt.copyInto(collection.size() + i, i, mutableObjectList._size, objArr2, objArr2);
                    }
                    for (Object obj2 : collection) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        objArr2[i2 + i] = obj2;
                        i2 = i3;
                    }
                    mutableObjectList._size = collection.size() + mutableObjectList._size;
                    return true;
                default:
                    return ((MutableVector) obj).addAll(i, collection);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    ((MutableObjectList) obj).clear();
                    break;
                default:
                    ((MutableVector) obj).clear();
                    break;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    return ((MutableObjectList) obj2).contains(obj);
                default:
                    return ((MutableVector) obj2).contains(obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection collection) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    collection.getClass();
                    MutableObjectList mutableObjectList = (MutableObjectList) obj;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        if (!mutableObjectList.contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                default:
                    MutableVector mutableVector = (MutableVector) obj;
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        if (!mutableVector.contains(it2.next())) {
                            return false;
                        }
                    }
                    return true;
            }
        }

        @Override // java.util.List
        public final Object get(int i) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    ObjectListKt.checkIndex(i, this);
                    return ((MutableObjectList) obj).get(i);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    return ((MutableVector) obj).content[i];
            }
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    return ((MutableObjectList) obj2).indexOf(obj);
                default:
                    return ((MutableVector) obj2).indexOf(obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    return ((MutableObjectList) obj).isEmpty();
                default:
                    return ((MutableVector) obj).size == 0;
            }
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, (byte) 0);
                default:
                    return new MutableObjectListIterator(this, 0, (byte) 1);
            }
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            int i;
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    MutableObjectList mutableObjectList = (MutableObjectList) obj2;
                    Object[] objArr = mutableObjectList.content;
                    int i2 = mutableObjectList._size;
                    if (obj == null) {
                        i = i2 - 1;
                        while (-1 < i) {
                            if (objArr[i] != null) {
                                i--;
                            }
                        }
                        return -1;
                    }
                    i = i2 - 1;
                    while (-1 < i) {
                        if (!obj.equals(objArr[i])) {
                            i--;
                        }
                    }
                    return -1;
                    return i;
                default:
                    MutableVector mutableVector = (MutableVector) obj2;
                    Object[] objArr2 = mutableVector.content;
                    for (int i3 = mutableVector.size - 1; i3 >= 0; i3--) {
                        if (Intrinsics.areEqual(obj, objArr2[i3])) {
                            return i3;
                        }
                    }
                    return -1;
            }
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, (byte) 0);
                default:
                    return new MutableObjectListIterator(this, 0, (byte) 1);
            }
        }

        @Override // java.util.List
        public final Object remove(int i) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    ObjectListKt.checkIndex(i, this);
                    return ((MutableObjectList) obj).removeAt(i);
                default:
                    MutableVectorKt.checkIndex(i, this);
                    return ((MutableVector) obj).removeAt(i);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection collection) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    collection.getClass();
                    MutableObjectList mutableObjectList = (MutableObjectList) obj;
                    int i = mutableObjectList._size;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        mutableObjectList.remove(it.next());
                    }
                    return i != mutableObjectList._size;
                default:
                    MutableVector mutableVector = (MutableVector) obj;
                    if (!collection.isEmpty()) {
                        int i2 = mutableVector.size;
                        Iterator it2 = collection.iterator();
                        while (it2.hasNext()) {
                            mutableVector.remove(it2.next());
                        }
                        if (i2 != mutableVector.size) {
                            return true;
                        }
                    }
                    return false;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection collection) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    collection.getClass();
                    MutableObjectList mutableObjectList = (MutableObjectList) obj;
                    int i = mutableObjectList._size;
                    Object[] objArr = mutableObjectList.content;
                    for (int i2 = i - 1; -1 < i2; i2--) {
                        if (!collection.contains(objArr[i2])) {
                            mutableObjectList.removeAt(i2);
                        }
                    }
                    return i != mutableObjectList._size;
                default:
                    MutableVector mutableVector = (MutableVector) obj;
                    int i3 = mutableVector.size;
                    for (int i4 = i3 - 1; -1 < i4; i4--) {
                        if (!collection.contains(mutableVector.content[i4])) {
                            mutableVector.removeAt(i4);
                        }
                    }
                    return i3 != mutableVector.size;
            }
        }

        @Override // java.util.List
        public final Object set(int i, Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    ObjectListKt.checkIndex(i, this);
                    MutableObjectList mutableObjectList = (MutableObjectList) obj2;
                    if (i < 0 || i >= mutableObjectList._size) {
                        mutableObjectList.throwIndexOutOfBoundsExclusiveException$collection(i);
                        throw null;
                    }
                    Object[] objArr = mutableObjectList.content;
                    Object obj3 = objArr[i];
                    objArr[i] = obj;
                    return obj3;
                default:
                    MutableVectorKt.checkIndex(i, this);
                    Object[] objArr2 = ((MutableVector) obj2).content;
                    Object obj4 = objArr2[i];
                    objArr2[i] = obj;
                    return obj4;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    return ((MutableObjectList) obj)._size;
                default:
                    return ((MutableVector) obj).size;
            }
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.checkSubIndex(i, i2, this);
                    return new SubList(this, i, i2, (byte) 0);
                default:
                    MutableVectorKt.checkSubIndex(i, i2, this);
                    return new SubList(this, i, i2, (byte) 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            switch (this.$r8$classId) {
                case 0:
                    objArr.getClass();
                    break;
            }
            return Intrinsics.Kotlin.toArray(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return Intrinsics.Kotlin.toArray(this);
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, i, (byte) 0);
                default:
                    return new MutableObjectListIterator(this, i, (byte) 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    return ((MutableObjectList) obj2).remove(obj);
                default:
                    return ((MutableVector) obj2).remove(obj);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.objectList;
            switch (b) {
                case 0:
                    ((MutableObjectList) obj2).add(obj);
                    break;
                default:
                    ((MutableVector) obj2).add(obj);
                    break;
            }
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection collection) {
            byte b = this.$r8$classId;
            Object obj = this.objectList;
            switch (b) {
                case 0:
                    collection.getClass();
                    MutableObjectList mutableObjectList = (MutableObjectList) obj;
                    int i = mutableObjectList._size;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        mutableObjectList.add(it.next());
                    }
                    return i != mutableObjectList._size;
                default:
                    MutableVector mutableVector = (MutableVector) obj;
                    return mutableVector.addAll(mutableVector.size, collection);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SubList implements List, KMutableList {
        public final /* synthetic */ byte $r8$classId;
        public int end;
        public final List list;
        public final int start;

        public /* synthetic */ SubList(List list, int i, int i2, byte b) {
            this.$r8$classId = b;
            this.list = list;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List
        public final void add(int i, Object obj) {
            byte b = this.$r8$classId;
            int i2 = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    list.add(i + i2, obj);
                    this.end++;
                    break;
                default:
                    list.add(i + i2, obj);
                    this.end++;
                    break;
            }
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            byte b = this.$r8$classId;
            int i2 = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    collection.getClass();
                    list.addAll(i + i2, collection);
                    this.end = collection.size() + this.end;
                    return collection.size() > 0;
                default:
                    list.addAll(i + i2, collection);
                    int size = collection.size();
                    this.end += size;
                    return size > 0;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            byte b = this.$r8$classId;
            List list = this.list;
            int i = this.start;
            switch (b) {
                case 0:
                    int i2 = this.end - 1;
                    if (i <= i2) {
                        while (true) {
                            list.remove(i2);
                            if (i2 != i) {
                                i2--;
                            }
                        }
                    }
                    this.end = i;
                    break;
                default:
                    int i3 = this.end - 1;
                    if (i <= i3) {
                        while (true) {
                            list.remove(i3);
                            if (i3 != i) {
                                i3--;
                            }
                        }
                    }
                    this.end = i;
                    break;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            byte b = this.$r8$classId;
            List list = this.list;
            int i = this.start;
            switch (b) {
                case 0:
                    int i2 = this.end;
                    while (i < i2) {
                        if (Intrinsics.areEqual(list.get(i), obj)) {
                            return true;
                        }
                        i++;
                    }
                    return false;
                default:
                    int i3 = this.end;
                    while (i < i3) {
                        if (Intrinsics.areEqual(list.get(i), obj)) {
                            return true;
                        }
                        i++;
                    }
                    return false;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    collection.getClass();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                default:
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        if (!contains(it2.next())) {
                            return false;
                        }
                    }
                    return true;
            }
        }

        @Override // java.util.List
        public final Object get(int i) {
            byte b = this.$r8$classId;
            int i2 = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    ObjectListKt.checkIndex(i, this);
                    break;
                default:
                    MutableVectorKt.checkIndex(i, this);
                    break;
            }
            return list.get(i + i2);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            byte b = this.$r8$classId;
            List list = this.list;
            int i = this.start;
            switch (b) {
                case 0:
                    int i2 = this.end;
                    for (int i3 = i; i3 < i2; i3++) {
                        if (Intrinsics.areEqual(list.get(i3), obj)) {
                            return i3 - i;
                        }
                    }
                    return -1;
                default:
                    int i4 = this.end;
                    for (int i5 = i; i5 < i4; i5++) {
                        if (Intrinsics.areEqual(list.get(i5), obj)) {
                            return i5 - i;
                        }
                    }
                    return -1;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            switch (this.$r8$classId) {
                case 0:
                    return this.end == this.start;
                default:
                    return this.end == this.start;
            }
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, (byte) 0);
                default:
                    return new MutableObjectListIterator(this, 0, (byte) 1);
            }
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            byte b = this.$r8$classId;
            List list = this.list;
            int i = this.start;
            switch (b) {
                case 0:
                    int i2 = this.end - 1;
                    if (i > i2) {
                        return -1;
                    }
                    while (!Intrinsics.areEqual(list.get(i2), obj)) {
                        if (i2 == i) {
                            return -1;
                        }
                        i2--;
                    }
                    return i2 - i;
                default:
                    int i3 = this.end - 1;
                    if (i > i3) {
                        return -1;
                    }
                    while (!Intrinsics.areEqual(list.get(i3), obj)) {
                        if (i3 == i) {
                            return -1;
                        }
                        i3--;
                    }
                    return i3 - i;
            }
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, 0, (byte) 0);
                default:
                    return new MutableObjectListIterator(this, 0, (byte) 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            byte b = this.$r8$classId;
            int i = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    int i2 = this.end;
                    while (i < i2) {
                        if (Intrinsics.areEqual(list.get(i), obj)) {
                            list.remove(i);
                            this.end--;
                            return true;
                        }
                        i++;
                    }
                    return false;
                default:
                    int i3 = this.end;
                    while (i < i3) {
                        if (Intrinsics.areEqual(list.get(i), obj)) {
                            list.remove(i);
                            this.end--;
                            return true;
                        }
                        i++;
                    }
                    return false;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    collection.getClass();
                    int i = this.end;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        remove(it.next());
                    }
                    return i != this.end;
                default:
                    int i2 = this.end;
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        remove(it2.next());
                    }
                    return i2 != this.end;
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection collection) {
            byte b = this.$r8$classId;
            int i = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    collection.getClass();
                    int i2 = this.end;
                    int i3 = i2 - 1;
                    if (i <= i3) {
                        while (true) {
                            if (!collection.contains(list.get(i3))) {
                                list.remove(i3);
                                this.end--;
                            }
                            if (i3 != i) {
                                i3--;
                            }
                        }
                    }
                    return i2 != this.end;
                default:
                    int i4 = this.end;
                    int i5 = i4 - 1;
                    if (i <= i5) {
                        while (true) {
                            if (!collection.contains(list.get(i5))) {
                                list.remove(i5);
                                this.end--;
                            }
                            if (i5 != i) {
                                i5--;
                            }
                        }
                    }
                    return i4 != this.end;
            }
        }

        @Override // java.util.List
        public final Object set(int i, Object obj) {
            byte b = this.$r8$classId;
            int i2 = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    ObjectListKt.checkIndex(i, this);
                    break;
                default:
                    MutableVectorKt.checkIndex(i, this);
                    break;
            }
            return list.set(i + i2, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            int i;
            int i2;
            switch (this.$r8$classId) {
                case 0:
                    i = this.end;
                    i2 = this.start;
                    break;
                default:
                    i = this.end;
                    i2 = this.start;
                    break;
            }
            return i - i2;
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            switch (this.$r8$classId) {
                case 0:
                    ObjectListKt.checkSubIndex(i, i2, this);
                    return new SubList(this, i, i2, (byte) 0);
                default:
                    MutableVectorKt.checkSubIndex(i, i2, this);
                    return new SubList(this, i, i2, (byte) 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            switch (this.$r8$classId) {
                case 0:
                    objArr.getClass();
                    break;
            }
            return Intrinsics.Kotlin.toArray(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return Intrinsics.Kotlin.toArray(this);
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new MutableObjectListIterator(this, i, (byte) 0);
                default:
                    return new MutableObjectListIterator(this, i, (byte) 1);
            }
        }

        @Override // java.util.List, java.util.Collection
        public final boolean add(Object obj) {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    int i = this.end;
                    this.end = i + 1;
                    list.add(i, obj);
                    break;
                default:
                    int i2 = this.end;
                    this.end = i2 + 1;
                    list.add(i2, obj);
                    break;
            }
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection collection) {
            byte b = this.$r8$classId;
            List list = this.list;
            switch (b) {
                case 0:
                    collection.getClass();
                    list.addAll(this.end, collection);
                    this.end = collection.size() + this.end;
                    return collection.size() > 0;
                default:
                    list.addAll(this.end, collection);
                    int size = collection.size();
                    this.end += size;
                    return size > 0;
            }
        }

        @Override // java.util.List
        public final Object remove(int i) {
            byte b = this.$r8$classId;
            int i2 = this.start;
            List list = this.list;
            switch (b) {
                case 0:
                    ObjectListKt.checkIndex(i, this);
                    Object objRemove = list.remove(i + i2);
                    this.end--;
                    return objRemove;
                default:
                    MutableVectorKt.checkIndex(i, this);
                    Object objRemove2 = list.remove(i + i2);
                    this.end--;
                    return objRemove2;
            }
        }
    }

    public final void addAll(MutableObjectList mutableObjectList) {
        mutableObjectList.getClass();
        if (mutableObjectList.isEmpty()) {
            return;
        }
        int i = this._size + mutableObjectList._size;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        ArraysKt.copyInto(this._size, 0, mutableObjectList._size, mutableObjectList.content, this.content);
        this._size += mutableObjectList._size;
    }
}
