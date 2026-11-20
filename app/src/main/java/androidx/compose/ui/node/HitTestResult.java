package androidx.compose.ui.node;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.ArraysKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HitTestResult implements List, KMappedMarker {
    public final MutableObjectList values = new MutableObjectList(16);
    public final MutableLongList distanceFromEdgeAndFlags = new MutableLongList(16);
    public int hitDepth = -1;

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ void addFirst(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ void addLast(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.hitDepth = -1;
        this.values.clear();
        this.distanceFromEdgeAndFlags._size = 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return (obj instanceof Modifier.Node) && indexOf((Modifier.Node) obj) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((Modifier.Node) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: findBestHitDistance-fn2tFes, reason: not valid java name */
    public final long m640findBestHitDistancefn2tFes() {
        long jDistanceAndFlags = HitTestResultKt.DistanceAndFlags(Float.POSITIVE_INFINITY, false, false);
        int i = this.hitDepth + 1;
        int i2 = this.values._size - 1;
        if (i > i2) {
            return jDistanceAndFlags;
        }
        while (i >= 0) {
            MutableLongList mutableLongList = this.distanceFromEdgeAndFlags;
            if (i >= mutableLongList._size) {
                break;
            }
            long j = mutableLongList.content[i];
            if (HitTestResultKt.m641compareTo9YPOF3E(j, jDistanceAndFlags) < 0) {
                jDistanceAndFlags = j;
            }
            if ((HitTestResultKt.m642getDistanceimpl(jDistanceAndFlags) < CropImageView.DEFAULT_ASPECT_RATIO && HitTestResultKt.m644isInLayerimpl(jDistanceAndFlags)) || i == i2) {
                return jDistanceAndFlags;
            }
            i++;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
        return 0L;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object obj = this.values.get(i);
        obj.getClass();
        return (Modifier.Node) obj;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Modifier.Node)) {
            return -1;
        }
        Modifier.Node node = (Modifier.Node) obj;
        MutableObjectList mutableObjectList = this.values;
        int i = mutableObjectList._size - 1;
        if (i < 0) {
            return -1;
        }
        int i2 = 0;
        while (!Intrinsics.areEqual(mutableObjectList.get(i2), node)) {
            if (i2 == i) {
                return -1;
            }
            i2++;
        }
        return i2;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new ListBuilder.Itr(this, 0, 7);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            Modifier.Node node = (Modifier.Node) obj;
            MutableObjectList mutableObjectList = this.values;
            for (int i = mutableObjectList._size - 1; -1 < i; i--) {
                if (Intrinsics.areEqual(mutableObjectList.get(i), node)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new ListBuilder.Itr(this, 0, 7);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void removeNodesInRange(int i, int i2) {
        MutableLongList mutableLongList;
        int i3;
        if (i >= i2) {
            return;
        }
        this.values.removeRange(i, i2);
        if (i < 0 || i > (i3 = (mutableLongList = this.distanceFromEdgeAndFlags)._size) || i2 < 0 || i2 > i3) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
            return;
        }
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The end index must be < start index");
        } else if (i2 != i) {
            if (i2 < i3) {
                long[] jArr = mutableLongList.content;
                ArraysKt.copyInto(jArr, jArr, i, i2, i3);
            }
            mutableLongList._size -= i2 - i;
        }
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.values._size;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        return new SubList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SubList implements List, KMappedMarker {
        public final int maxIndex;
        public final int minIndex;

        public SubList(int i, int i2) {
            this.minIndex = i;
            this.maxIndex = i2;
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ void addFirst(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ void addLast(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            return (obj instanceof Modifier.Node) && indexOf((Modifier.Node) obj) != -1;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains((Modifier.Node) it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final Object get(int i) {
            Object obj = HitTestResult.this.values.get(i + this.minIndex);
            obj.getClass();
            return (Modifier.Node) obj;
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Modifier.Node)) {
                return -1;
            }
            Modifier.Node node = (Modifier.Node) obj;
            int i = this.minIndex;
            int i2 = this.maxIndex;
            if (i > i2) {
                return -1;
            }
            int i3 = i;
            while (!Intrinsics.areEqual(HitTestResult.this.values.get(i3), node)) {
                if (i3 == i2) {
                    return -1;
                }
                i3++;
            }
            return i3 - i;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            int i = this.minIndex;
            return new ListBuilder.Itr(HitTestResult.this, i, i, this.maxIndex);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Modifier.Node)) {
                return -1;
            }
            Modifier.Node node = (Modifier.Node) obj;
            int i = this.maxIndex;
            int i2 = this.minIndex;
            if (i2 > i) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values.get(i), node)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - i2;
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            int i2 = this.minIndex;
            int i3 = this.maxIndex;
            return new ListBuilder.Itr(HitTestResult.this, i + i2, i2, i3);
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ Object remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ Object removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ Object removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final void replaceAll(UnaryOperator unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.maxIndex - this.minIndex;
        }

        @Override // java.util.List
        public final void sort(Comparator comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            int i3 = this.minIndex;
            return HitTestResult.this.new SubList(i + i3, i3 + i2);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return Intrinsics.Kotlin.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return Intrinsics.Kotlin.toArray(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            int i = this.minIndex;
            return new ListBuilder.Itr(HitTestResult.this, i, i, this.maxIndex);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new ListBuilder.Itr(this, i, 6);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
