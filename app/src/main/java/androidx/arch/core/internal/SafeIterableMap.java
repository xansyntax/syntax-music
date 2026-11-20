package androidx.arch.core.internal;

import coil3.util.FileSystemsKt;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SafeIterableMap implements Iterable {
    public final WeakHashMap mIterators = new WeakHashMap();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AscendingIterator extends FileSystemsKt implements Iterator {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ Object next() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class IteratorWithAdditions extends FileSystemsKt implements Iterator {
        public boolean mBeforeStart;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.mBeforeStart) {
                return null;
            }
            this.mBeforeStart = false;
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        iterator();
        ((SafeIterableMap) obj).iterator();
        return true;
    }

    public final int hashCode() {
        iterator();
        return 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator();
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public final String toString() {
        iterator();
        return "[]";
    }
}
