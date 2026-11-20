package androidx.compose.material3.carousel;

import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeylineList implements List, KMappedMarker {
    public static final KeylineList Empty = new KeylineList(EmptyList.INSTANCE);
    public final /* synthetic */ List $$delegate_0;
    public final int firstFocalIndex;
    public final int firstNonAnchorIndex;
    public final int focalCount;
    public final int lastFocalIndex;
    public final int lastNonAnchorIndex;
    public final float maxSize;
    public final float minSize;
    public final int pivotIndex;

    public KeylineList(List list) {
        int iNextIndex;
        int iNextIndex2;
        this.$$delegate_0 = list;
        int size = list.size();
        float f = Float.MAX_VALUE;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            float f3 = ((Keyline) list.get(i2)).size;
            f = f3 < f ? f3 : f;
            if (f3 > f2) {
                f2 = f3;
            }
        }
        this.minSize = f;
        this.maxSize = f2;
        Iterator it = iterator();
        int i3 = 0;
        while (true) {
            iNextIndex = -1;
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (((Keyline) it.next()).isPivot) {
                break;
            } else {
                i3++;
            }
        }
        this.pivotIndex = i3;
        Iterator it2 = iterator();
        int i4 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i4 = -1;
                break;
            } else if (!((Keyline) it2.next()).isAnchor) {
                break;
            } else {
                i4++;
            }
        }
        this.firstNonAnchorIndex = i4;
        ListIterator listIterator = listIterator(size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (!((Keyline) listIterator.previous()).isAnchor) {
                    iNextIndex2 = listIterator.nextIndex();
                    break;
                }
            } else {
                iNextIndex2 = -1;
                break;
            }
        }
        this.lastNonAnchorIndex = iNextIndex2;
        Iterator it3 = iterator();
        while (true) {
            if (!it3.hasNext()) {
                i = -1;
                break;
            } else if (((Keyline) it3.next()).isFocal) {
                break;
            } else {
                i++;
            }
        }
        this.firstFocalIndex = i;
        ListIterator listIterator2 = listIterator(size());
        while (listIterator2.hasPrevious()) {
            if (((Keyline) listIterator2.previous()).isFocal) {
                iNextIndex = listIterator2.nextIndex();
                break;
            }
        }
        this.lastFocalIndex = iNextIndex;
        this.focalCount = (iNextIndex - this.firstFocalIndex) + 1;
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
        if (!(obj instanceof Keyline)) {
            return false;
        }
        return this.$$delegate_0.contains((Keyline) obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.$$delegate_0.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeylineList) {
            List list = this.$$delegate_0;
            KeylineList keylineList = (KeylineList) obj;
            if (list.size() == keylineList.$$delegate_0.size()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (Intrinsics.areEqual(get(i), keylineList.get(i))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public final Keyline get(int i) {
        return (Keyline) this.$$delegate_0.get(i);
    }

    public final Keyline getFirstFocal() {
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(this.firstFocalIndex, this);
        if (keyline != null) {
            return keyline;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("All KeylineLists must have at least one focal keyline");
        return null;
    }

    public final Keyline getLastFocal() {
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(this.lastFocalIndex, this);
        if (keyline != null) {
            return keyline;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("All KeylineLists must have at least one focal keyline");
        return null;
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        int size = size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((Keyline) get(i)).hashCode() * 31;
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Keyline)) {
            return -1;
        }
        return this.$$delegate_0.indexOf((Keyline) obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.$$delegate_0.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Keyline)) {
            return -1;
        }
        return this.$$delegate_0.lastIndexOf((Keyline) obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.$$delegate_0.listIterator();
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
        return this.$$delegate_0.size();
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        return this.$$delegate_0.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return this.$$delegate_0.listIterator(i);
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
}
