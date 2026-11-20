package com.google.common.collect;

import coil3.util.UtilsKt;
import com.google.common.collect.ObjectCountHashMap.MapEntry;
import com.google.common.collect.RegularImmutableMultiset.ElementSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableMultiset extends ImmutableCollection implements Collection {
    public static final /* synthetic */ int $r8$clinit = 0;
    public transient RegularImmutableList asList;
    public transient ImmutableSet entrySet;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder extends ImmutableCollection.Builder {
        public boolean buildInvoked;
        public ObjectCountHashMap contents;

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public final ImmutableCollection.Builder add(Object obj) {
            addCopies(1, obj);
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0023  */
        /* JADX WARN: Code duplicated, block: B:18:0x003f A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003c -> B:9:0x001e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:7:0x000d
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final void addCopies(int r8, java.lang.Object r9) {
            /*
                r7 = this;
                com.google.common.collect.ObjectCountHashMap r0 = r7.contents
                java.util.Objects.requireNonNull(r0)
                if (r8 != 0) goto L8
                return
            L8:
                boolean r0 = r7.buildInvoked
                r1 = 0
                if (r0 == 0) goto L41
                com.google.common.collect.ObjectCountHashMap r0 = new com.google.common.collect.ObjectCountHashMap
                com.google.common.collect.ObjectCountHashMap r2 = r7.contents
                r0.<init>()
                int r3 = r2.size
                r0.init(r3)
                int r3 = r2.size
                r4 = -1
                if (r3 != 0) goto L20
            L1e:
                r3 = r4
                goto L21
            L20:
                r3 = r1
            L21:
                if (r3 == r4) goto L3f
                int r5 = r2.size
                coil3.util.UtilsKt.checkElementIndex(r3, r5)
                java.lang.Object[] r5 = r2.keys
                r5 = r5[r3]
                int r6 = r2.size
                coil3.util.UtilsKt.checkElementIndex(r3, r6)
                int[] r6 = r2.values
                r6 = r6[r3]
                r0.put(r6, r5)
                int r3 = r3 + 1
                int r5 = r2.size
                if (r3 >= r5) goto L1e
                goto L21
            L3f:
                r7.contents = r0
            L41:
                r7.buildInvoked = r1
                r9.getClass()
                com.google.common.collect.ObjectCountHashMap r7 = r7.contents
                int r0 = r7.get(r9)
                int r0 = r0 + r8
                r7.put(r0, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableMultiset.Builder.addCopies(int, java.lang.Object):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EntrySet extends IndexedImmutableSet {
        public EntrySet() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof ObjectCountHashMap.MapEntry)) {
                return false;
            }
            ObjectCountHashMap.MapEntry mapEntry = (ObjectCountHashMap.MapEntry) obj;
            if (mapEntry.getCount() <= 0) {
                return false;
            }
            return ((RegularImmutableMultiset) ImmutableMultiset.this).contents.get(mapEntry.key) == mapEntry.getCount();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public final Object get(int i) {
            ObjectCountHashMap objectCountHashMap = ((RegularImmutableMultiset) ImmutableMultiset.this).contents;
            UtilsKt.checkElementIndex(i, objectCountHashMap.size);
            return objectCountHashMap.new MapEntry(i);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            RegularImmutableMultiset regularImmutableMultiset = (RegularImmutableMultiset) ImmutableMultiset.this;
            RegularImmutableMultiset.ElementSet elementSet = regularImmutableMultiset.elementSet;
            if (elementSet == null) {
                elementSet = regularImmutableMultiset.new ElementSet();
                regularImmutableMultiset.elementSet = elementSet;
            }
            return elementSet.size();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        RegularImmutableList regularImmutableList = this.asList;
        if (regularImmutableList != null) {
            return regularImmutableList;
        }
        ImmutableList immutableListAsList = super.asList();
        this.asList = (RegularImmutableList) immutableListAsList;
        return immutableListAsList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(int i, Object[] objArr) {
        UnmodifiableIterator it = entrySet().iterator();
        while (it.hasNext()) {
            ObjectCountHashMap.MapEntry mapEntry = (ObjectCountHashMap.MapEntry) it.next();
            Arrays.fill(objArr, i, mapEntry.getCount() + i, mapEntry.key);
            i += mapEntry.getCount();
        }
        return i;
    }

    public final ImmutableSet entrySet() {
        ImmutableSet entrySet = this.entrySet;
        if (entrySet == null) {
            entrySet = isEmpty() ? RegularImmutableSet.EMPTY : new EntrySet();
            this.entrySet = entrySet;
        }
        return entrySet;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableMultiset)) {
            return false;
        }
        ImmutableMultiset immutableMultiset = (ImmutableMultiset) obj;
        RegularImmutableMultiset regularImmutableMultiset = (RegularImmutableMultiset) this;
        if (regularImmutableMultiset.size() != immutableMultiset.size() || entrySet().size() != immutableMultiset.entrySet().size()) {
            return false;
        }
        for (ObjectCountHashMap.MapEntry mapEntry : immutableMultiset.entrySet()) {
            if (regularImmutableMultiset.contents.get(mapEntry.key) != mapEntry.getCount()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Maps.hashCodeImpl(entrySet());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final UnmodifiableIterator iterator() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator() { // from class: com.google.common.collect.ImmutableMultiset.1
            public Object element;
            public int remaining;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.remaining > 0 || it.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                int count = this.remaining;
                if (count <= 0) {
                    ObjectCountHashMap.MapEntry mapEntry = (ObjectCountHashMap.MapEntry) it.next();
                    this.element = mapEntry.key;
                    count = mapEntry.getCount();
                    this.remaining = count;
                }
                this.remaining = count - 1;
                Object obj = this.element;
                Objects.requireNonNull(obj);
                return obj;
            }
        };
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}
