package androidx.compose.runtime.snapshots;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SnapshotId_jvmKt {
    public static final Object sync = new Object();
    public static final Object sync$1 = new Object();
    public static final Object sync$2 = new Object();

    public static final boolean attemptUpdate(StateListStateRecord stateListStateRecord, int i, AbstractPersistentList abstractPersistentList, boolean z) {
        boolean z2;
        synchronized (sync) {
            try {
                int i2 = stateListStateRecord.modification;
                if (i2 == i) {
                    stateListStateRecord.list = abstractPersistentList;
                    z2 = true;
                    if (z) {
                        stateListStateRecord.structuralChange++;
                    }
                    stateListStateRecord.modification = i2 + 1;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public static final int binarySearch(long[] jArr, long j) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            long j2 = jArr[i2];
            if (j > j2) {
                i = i2 + 1;
            } else {
                if (j >= j2) {
                    return i2;
                }
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final StateListStateRecord getReadable(SnapshotStateList snapshotStateList) {
        StateListStateRecord stateListStateRecord = snapshotStateList.firstStateRecord;
        stateListStateRecord.getClass();
        return (StateListStateRecord) SnapshotKt.readable(stateListStateRecord, snapshotStateList);
    }

    public static final int getStructure(SnapshotStateList snapshotStateList) {
        StateListStateRecord stateListStateRecord = snapshotStateList.firstStateRecord;
        stateListStateRecord.getClass();
        return ((StateListStateRecord) SnapshotKt.current(stateListStateRecord, snapshotStateList)).structuralChange;
    }

    public static final boolean mutateBoolean(SnapshotStateList snapshotStateList, Function1 function1) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Object objInvoke;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateListStateRecord stateListStateRecord = snapshotStateList.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, snapshotStateList);
                i = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            PersistentVectorBuilder persistentVectorBuilderBuilder = abstractPersistentList.builder();
            objInvoke = function1.invoke(persistentVectorBuilderBuilder);
            AbstractPersistentList abstractPersistentListBuild = persistentVectorBuilderBuilder.build();
            if (Intrinsics.areEqual(abstractPersistentListBuild, abstractPersistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord3 = snapshotStateList.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, snapshotStateList, snapshotCurrentSnapshot), i, abstractPersistentListBuild, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateList);
        } while (!zAttemptUpdate);
        return ((Boolean) objInvoke).booleanValue();
    }

    public static final void unsupported() {
        throw new UnsupportedOperationException();
    }

    public static final void validateRange(int i, int i2) {
        if (i < 0 || i >= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i, "index (", ") is out of bound of [0, ", i2, ")"));
        }
    }

    public static final StateSetStateRecord getReadable(SnapshotStateSet snapshotStateSet) {
        return (StateSetStateRecord) SnapshotKt.readable(snapshotStateSet.firstStateRecord, snapshotStateSet);
    }

    public void check() {
    }

    public static final boolean attemptUpdate(StateSetStateRecord stateSetStateRecord, int i, PersistentOrderedSet persistentOrderedSet) {
        boolean z;
        synchronized (sync$2) {
            int i2 = stateSetStateRecord.modification;
            if (i2 == i) {
                stateSetStateRecord.set = persistentOrderedSet;
                z = true;
                stateSetStateRecord.modification = i2 + 1;
            } else {
                z = false;
            }
        }
        return z;
    }
}
