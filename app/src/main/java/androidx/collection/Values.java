package androidx.collection;

import dagger.hilt.EntryPoints;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SubSequence;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Values implements Collection, KMappedMarker {
    public final /* synthetic */ byte $r8$classId = 1;
    public final Object parent;

    public Values() {
        int i = OrderedScatterSetKt.$r8$clinit;
        this.parent = new MutableOrderedScatterSet(6);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((MutableOrderedScatterSet) this.parent).add(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ((MutableOrderedScatterSet) this.parent).clear();
                return;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.parent;
        switch (b) {
            case 0:
                return ((MutableScatterMap) obj2).containsValue(obj);
            default:
                return ((MutableOrderedScatterSet) obj2).contains(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        byte b = this.$r8$classId;
        Object obj = this.parent;
        switch (b) {
            case 0:
                collection.getClass();
                Collection collection2 = collection;
                if (collection2.isEmpty()) {
                    return true;
                }
                Iterator it = collection2.iterator();
                while (it.hasNext()) {
                    if (!((MutableScatterMap) obj).containsValue(it.next())) {
                        return false;
                    }
                }
                return true;
            default:
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!((MutableOrderedScatterSet) obj).contains(it2.next())) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        byte b = this.$r8$classId;
        Object obj = this.parent;
        switch (b) {
            case 0:
                return ((MutableScatterMap) obj).isEmpty();
            default:
                return ((MutableOrderedScatterSet) obj)._size == 0;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return EntryPoints.iterator(new Keys.AnonymousClass1(this, null, (byte) 2));
            default:
                return new SubSequence.AnonymousClass1(new MutableOrderedSetWrapper((MutableOrderedScatterSet) this.parent));
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((MutableOrderedScatterSet) this.parent).remove(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((MutableOrderedScatterSet) this.parent).remove(collection);
        }
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate predicate) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((MutableOrderedScatterSet) this.parent).retainAll(collection);
        }
    }

    @Override // java.util.Collection
    public final int size() {
        byte b = this.$r8$classId;
        Object obj = this.parent;
        switch (b) {
            case 0:
                return ((MutableScatterMap) obj)._size;
            default:
                return ((MutableOrderedScatterSet) obj)._size;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.$r8$classId) {
            case 0:
                objArr.getClass();
                break;
        }
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    public Values(MutableScatterMap mutableScatterMap) {
        this.parent = mutableScatterMap;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return Intrinsics.Kotlin.toArray(this);
    }
}
