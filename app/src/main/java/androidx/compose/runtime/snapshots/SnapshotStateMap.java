package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateMap implements StateObject, Map, KMutableMap {
    public final SnapshotMapKeySet entries;
    public StateMapStateRecord firstStateRecord;
    public final SnapshotMapKeySet keys;
    public final SnapshotMapKeySet values;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StateMapStateRecord extends StateRecord {
        public PersistentHashMap map;
        public int modification;

        public StateMapStateRecord(long j, PersistentHashMap persistentHashMap) {
            super(j);
            this.map = persistentHashMap;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord stateRecord) {
            stateRecord.getClass();
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) stateRecord;
            synchronized (SnapshotId_jvmKt.sync$1) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create(long j) {
            return new StateMapStateRecord(j, this.map);
        }
    }

    public SnapshotStateMap() {
        PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        StateMapStateRecord stateMapStateRecord = new StateMapStateRecord(snapshotCurrentSnapshot.getSnapshotId(), persistentHashMap);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            stateMapStateRecord.next = new StateMapStateRecord(1L, persistentHashMap);
        }
        this.firstStateRecord = stateMapStateRecord;
        this.entries = new SnapshotMapKeySet(this, (byte) 1);
        this.keys = new SnapshotMapKeySet(this, (byte) 0);
        this.values = new SnapshotMapKeySet(this, (byte) 2);
    }

    public static boolean attemptUpdate(StateMapStateRecord stateMapStateRecord, int i, PersistentHashMap persistentHashMap) {
        boolean z;
        synchronized (SnapshotId_jvmKt.sync$1) {
            int i2 = stateMapStateRecord.modification;
            if (i2 == i) {
                stateMapStateRecord.map = persistentHashMap;
                z = true;
                stateMapStateRecord.modification = i2 + 1;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // java.util.Map
    public final void clear() {
        Snapshot snapshotCurrentSnapshot;
        PersistentHashMap persistentHashMap = ((StateMapStateRecord) SnapshotKt.current(this.firstStateRecord, this)).map;
        PersistentHashMap persistentHashMap2 = PersistentHashMap.EMPTY;
        if (persistentHashMap2 != persistentHashMap) {
            StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord, this, snapshotCurrentSnapshot);
                synchronized (SnapshotId_jvmKt.sync$1) {
                    stateMapStateRecord2.map = persistentHashMap2;
                    stateMapStateRecord2.modification++;
                }
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        }
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return getReadable$runtime().map.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return getReadable$runtime().map.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.entries;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return getReadable$runtime().map.get(obj);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final StateMapStateRecord getReadable$runtime() {
        return (StateMapStateRecord) SnapshotKt.readable(this.firstStateRecord, this);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return getReadable$runtime().map.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.keys;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.firstStateRecord = (StateMapStateRecord) stateRecord;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        PersistentHashMap persistentHashMap;
        int i;
        Object objPut;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                persistentHashMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
            }
            persistentHashMap.getClass();
            PersistentHashMapBuilder persistentHashMapBuilderBuilder$1 = persistentHashMap.builder$1();
            objPut = persistentHashMapBuilderBuilder$1.put(obj, obj2);
            PersistentHashMap persistentHashMapBuild$1 = persistentHashMapBuilderBuilder$1.build$1();
            if (Intrinsics.areEqual(persistentHashMapBuild$1, persistentHashMap)) {
                break;
            }
            StateMapStateRecord stateMapStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = attemptUpdate((StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, snapshotCurrentSnapshot), i, persistentHashMapBuild$1);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return objPut;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        PersistentHashMap persistentHashMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                persistentHashMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
            }
            persistentHashMap.getClass();
            PersistentHashMapBuilder persistentHashMapBuilderBuilder$1 = persistentHashMap.builder$1();
            persistentHashMapBuilderBuilder$1.putAll(map);
            PersistentHashMap persistentHashMapBuild$1 = persistentHashMapBuilderBuilder$1.build$1();
            if (Intrinsics.areEqual(persistentHashMapBuild$1, persistentHashMap)) {
                return;
            }
            StateMapStateRecord stateMapStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = attemptUpdate((StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, snapshotCurrentSnapshot), i, persistentHashMapBuild$1);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        PersistentHashMap persistentHashMap;
        int i;
        V vRemove;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                persistentHashMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
            }
            persistentHashMap.getClass();
            PersistentHashMapBuilder persistentHashMapBuilderBuilder$1 = persistentHashMap.builder$1();
            vRemove = persistentHashMapBuilderBuilder$1.remove(obj);
            PersistentHashMap persistentHashMapBuild$1 = persistentHashMapBuilderBuilder$1.build$1();
            if (Intrinsics.areEqual(persistentHashMapBuild$1, persistentHashMap)) {
                break;
            }
            StateMapStateRecord stateMapStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = attemptUpdate((StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, snapshotCurrentSnapshot), i, persistentHashMapBuild$1);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return vRemove;
    }

    @Override // java.util.Map
    public final int size() {
        PersistentHashMap persistentHashMap = getReadable$runtime().map;
        persistentHashMap.getClass();
        return persistentHashMap.size;
    }

    public final String toString() {
        return "SnapshotStateMap(value=" + ((StateMapStateRecord) SnapshotKt.current(this.firstStateRecord, this)).map + ")@" + hashCode();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.values;
    }
}
