package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlinx.serialization.json.internal.AbstractJsonLexer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMapKeySet implements Set, KMutableSet {
    public final /* synthetic */ byte $r8$classId;
    public final SnapshotStateMap map;

    public SnapshotMapKeySet(SnapshotStateMap snapshotStateMap, byte b) {
        this.$r8$classId = b;
        this.map = snapshotStateMap;
    }

    private final boolean retainAll$androidx$compose$runtime$snapshots$SnapshotMapEntrySet(Collection collection) {
        PersistentHashMap persistentHashMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        Collection<Map.Entry> collection2 = collection;
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (Map.Entry entry : collection2) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        SnapshotStateMap snapshotStateMap = this.map;
        boolean z = false;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord, snapshotStateMap);
                persistentHashMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
            }
            persistentHashMap.getClass();
            PersistentHashMapBuilder persistentHashMapBuilderBuilder$1 = persistentHashMap.builder$1();
            Object it = snapshotStateMap.entries.iterator();
            while (((AbstractJsonLexer) it).hasNext()) {
                Map.Entry entry2 = (Map.Entry) ((StateMapMutableKeysIterator) it).next();
                if (!linkedHashMap.containsKey(entry2.getKey()) || !Intrinsics.areEqual(linkedHashMap.get(entry2.getKey()), entry2.getValue())) {
                    persistentHashMapBuilderBuilder$1.remove(entry2.getKey());
                    z = true;
                }
            }
            PersistentHashMap persistentHashMapBuild$1 = persistentHashMapBuilderBuilder$1.build$1();
            if (Intrinsics.areEqual(persistentHashMapBuild$1, persistentHashMap)) {
                break;
            }
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotStateMap.attemptUpdate((SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentHashMapBuild$1);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
        } while (!zAttemptUpdate);
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                SnapshotId_jvmKt.unsupported();
                throw null;
            case 1:
                SnapshotId_jvmKt.unsupported();
                throw null;
            default:
                SnapshotId_jvmKt.unsupported();
                throw null;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                SnapshotId_jvmKt.unsupported();
                throw null;
            case 1:
                SnapshotId_jvmKt.unsupported();
                throw null;
            default:
                SnapshotId_jvmKt.unsupported();
                throw null;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.map.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        byte b = this.$r8$classId;
        SnapshotStateMap snapshotStateMap = this.map;
        switch (b) {
            case 0:
                return snapshotStateMap.containsKey(obj);
            case 1:
                if (!TypeIntrinsics.isMutableMapEntry(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return Intrinsics.areEqual(snapshotStateMap.get(entry.getKey()), entry.getValue());
            default:
                return snapshotStateMap.containsValue(obj);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        byte b = this.$r8$classId;
        SnapshotStateMap snapshotStateMap = this.map;
        switch (b) {
            case 0:
                Collection collection2 = collection;
                if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                    Iterator it = collection2.iterator();
                    while (it.hasNext()) {
                        if (!snapshotStateMap.containsKey(it.next())) {
                            return false;
                        }
                    }
                }
                return true;
            case 1:
                Collection collection3 = collection;
                if (!(collection3 instanceof Collection) || !collection3.isEmpty()) {
                    Iterator it2 = collection3.iterator();
                    while (it2.hasNext()) {
                        if (!contains((Map.Entry) it2.next())) {
                            return false;
                        }
                    }
                }
                return true;
            default:
                Collection collection4 = collection;
                if (!(collection4 instanceof Collection) || !collection4.isEmpty()) {
                    Iterator it3 = collection4.iterator();
                    while (it3.hasNext()) {
                        if (!snapshotStateMap.containsValue(it3.next())) {
                            return false;
                        }
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        SnapshotStateMap snapshotStateMap = this.map;
        switch (b) {
            case 0:
                return new StateMapMutableKeysIterator(snapshotStateMap, ((ImmutableSet) snapshotStateMap.getReadable$runtime().map.entrySet()).iterator(), (byte) 0);
            case 1:
                return new StateMapMutableKeysIterator(snapshotStateMap, ((ImmutableSet) snapshotStateMap.getReadable$runtime().map.entrySet()).iterator(), (byte) 1);
            default:
                return new StateMapMutableKeysIterator(snapshotStateMap, ((ImmutableSet) snapshotStateMap.getReadable$runtime().map.entrySet()).iterator(), (byte) 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v8 java.lang.Object, still in use, count: 2, list:
          (r3v8 java.lang.Object) from 0x002e: PHI (r3 I:??) = (r3v3 java.lang.Object), (r3v8 java.lang.Object) binds: [B:10:0x002d, B:27:0x002e] A[DONT_GENERATE, DONT_INLINE]
          (r3v8 java.lang.Object) from 0x0020: CHECK_CAST (java.util.Map$Entry) (r3v8 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // java.util.Set, java.util.Collection
    public final boolean remove(java.lang.Object r6) {
        /*
            r5 = this;
            byte r0 = r5.$r8$classId
            r1 = 0
            r2 = 1
            androidx.compose.runtime.snapshots.SnapshotStateMap r5 = r5.map
            switch(r0) {
                case 0: goto L50;
                case 1: goto L3b;
                default: goto L9;
            }
        L9:
            androidx.compose.runtime.snapshots.SnapshotMapKeySet r0 = r5.entries
            java.util.Iterator r0 = r0.iterator()
        Lf:
            r3 = r0
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = (kotlinx.serialization.json.internal.AbstractJsonLexer) r3
            boolean r3 = r3.hasNext()
            if (r3 == 0) goto L2d
            r3 = r0
            androidx.compose.runtime.snapshots.StateMapMutableKeysIterator r3 = (androidx.compose.runtime.snapshots.StateMapMutableKeysIterator) r3
            java.lang.Object r3 = r3.next()
            r4 = r3
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r4 == 0) goto Lf
            goto L2e
        L2d:
            r3 = 0
        L2e:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            if (r3 == 0) goto L3a
            java.lang.Object r6 = r3.getKey()
            r5.remove(r6)
            r1 = r2
        L3a:
            return r1
        L3b:
            boolean r0 = kotlin.jvm.internal.TypeIntrinsics.isMutableMapEntry(r6)
            if (r0 != 0) goto L42
            goto L4f
        L42:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r6 = r6.getKey()
            java.lang.Object r5 = r5.remove(r6)
            if (r5 == 0) goto L4f
            r1 = r2
        L4f:
            return r1
        L50:
            java.lang.Object r5 = r5.remove(r6)
            if (r5 == 0) goto L57
            r1 = r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotMapKeySet.remove(java.lang.Object):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        PersistentHashMap persistentHashMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                Iterator it = collection.iterator();
                while (true) {
                    boolean z2 = false;
                    while (it.hasNext()) {
                        if (this.map.remove(it.next()) != null || z2) {
                            z2 = true;
                        }
                    }
                    return z2;
                }
            case 1:
                Iterator it2 = collection.iterator();
                while (true) {
                    boolean z3 = false;
                    while (it2.hasNext()) {
                        if (this.map.remove(((Map.Entry) it2.next()).getKey()) != null || z3) {
                            z3 = true;
                        }
                    }
                    return z3;
                }
            default:
                Set set = CollectionsKt.toSet(collection);
                SnapshotStateMap snapshotStateMap = this.map;
                do {
                    synchronized (SnapshotId_jvmKt.sync$1) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord, snapshotStateMap);
                        persistentHashMap = stateMapStateRecord.map;
                        i = stateMapStateRecord.modification;
                    }
                    persistentHashMap.getClass();
                    PersistentHashMapBuilder persistentHashMapBuilderBuilder$1 = persistentHashMap.builder$1();
                    Object it3 = snapshotStateMap.entries.iterator();
                    while (((AbstractJsonLexer) it3).hasNext()) {
                        Map.Entry entry = (Map.Entry) ((StateMapMutableKeysIterator) it3).next();
                        if (set.contains(entry.getValue())) {
                            persistentHashMapBuilderBuilder$1.remove(entry.getKey());
                            z = true;
                        }
                    }
                    PersistentHashMap persistentHashMapBuild$1 = persistentHashMapBuilderBuilder$1.build$1();
                    if (!Intrinsics.areEqual(persistentHashMapBuild$1, persistentHashMap)) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
                        synchronized (SnapshotKt.lock) {
                            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                            zAttemptUpdate = SnapshotStateMap.attemptUpdate((SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentHashMapBuild$1);
                        }
                        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
                    }
                    return z;
                } while (!zAttemptUpdate);
                return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        PersistentHashMap persistentHashMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        PersistentHashMap persistentHashMap2;
        int i2;
        Snapshot snapshotCurrentSnapshot2;
        boolean zAttemptUpdate2;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                Set set = CollectionsKt.toSet(collection);
                SnapshotStateMap snapshotStateMap = this.map;
                do {
                    synchronized (SnapshotId_jvmKt.sync$1) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord, snapshotStateMap);
                        persistentHashMap = stateMapStateRecord.map;
                        i = stateMapStateRecord.modification;
                    }
                    persistentHashMap.getClass();
                    PersistentHashMapBuilder persistentHashMapBuilderBuilder$1 = persistentHashMap.builder$1();
                    Object it = snapshotStateMap.entries.iterator();
                    while (((AbstractJsonLexer) it).hasNext()) {
                        Map.Entry entry = (Map.Entry) ((StateMapMutableKeysIterator) it).next();
                        if (!set.contains(entry.getKey())) {
                            persistentHashMapBuilderBuilder$1.remove(entry.getKey());
                            z = true;
                        }
                    }
                    PersistentHashMap persistentHashMapBuild$1 = persistentHashMapBuilderBuilder$1.build$1();
                    if (!Intrinsics.areEqual(persistentHashMapBuild$1, persistentHashMap)) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
                        synchronized (SnapshotKt.lock) {
                            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                            zAttemptUpdate = SnapshotStateMap.attemptUpdate((SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentHashMapBuild$1);
                        }
                        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
                    }
                    return z;
                } while (!zAttemptUpdate);
                return z;
            case 1:
                return retainAll$androidx$compose$runtime$snapshots$SnapshotMapEntrySet(collection);
            default:
                Set set2 = CollectionsKt.toSet(collection);
                SnapshotStateMap snapshotStateMap2 = this.map;
                do {
                    synchronized (SnapshotId_jvmKt.sync$1) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord3 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap2.firstStateRecord, snapshotStateMap2);
                        persistentHashMap2 = stateMapStateRecord3.map;
                        i2 = stateMapStateRecord3.modification;
                    }
                    persistentHashMap2.getClass();
                    PersistentHashMapBuilder persistentHashMapBuilderBuilder$2 = persistentHashMap2.builder$1();
                    Object it2 = snapshotStateMap2.entries.iterator();
                    while (((AbstractJsonLexer) it2).hasNext()) {
                        Map.Entry entry2 = (Map.Entry) ((StateMapMutableKeysIterator) it2).next();
                        if (!set2.contains(entry2.getValue())) {
                            persistentHashMapBuilderBuilder$2.remove(entry2.getKey());
                            z = true;
                        }
                    }
                    PersistentHashMap persistentHashMapBuild$2 = persistentHashMapBuilderBuilder$2.build$1();
                    if (!Intrinsics.areEqual(persistentHashMapBuild$2, persistentHashMap2)) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord4 = snapshotStateMap2.firstStateRecord;
                        synchronized (SnapshotKt.lock) {
                            snapshotCurrentSnapshot2 = SnapshotKt.currentSnapshot();
                            zAttemptUpdate2 = SnapshotStateMap.attemptUpdate((SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord4, snapshotStateMap2, snapshotCurrentSnapshot2), i2, persistentHashMapBuild$2);
                        }
                        SnapshotKt.notifyWrite(snapshotCurrentSnapshot2, snapshotStateMap2);
                    }
                    return z;
                } while (!zAttemptUpdate2);
                return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }
}
