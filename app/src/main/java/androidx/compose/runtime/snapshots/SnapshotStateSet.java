package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import androidx.customview.view.AbsSavedState;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateSet implements Parcelable, StateObject, Set, RandomAccess, KMutableSet {
    public static final Parcelable.Creator<SnapshotStateSet> CREATOR = new AbsSavedState.AnonymousClass2(3);
    public StateSetStateRecord firstStateRecord;

    public SnapshotStateSet() {
        PersistentOrderedSet persistentOrderedSet = PersistentOrderedSet.EMPTY;
        StateSetStateRecord stateSetStateRecord = new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), persistentOrderedSet);
        if (SnapshotKt.threadSnapshot.get() != null) {
            stateSetStateRecord.next = new StateSetStateRecord(1L, persistentOrderedSet);
        }
        this.firstStateRecord = stateSetStateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        PersistentOrderedSet persistentOrderedSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                i = stateSetStateRecord.modification;
                persistentOrderedSet = stateSetStateRecord.set;
            }
            persistentOrderedSet.getClass();
            PersistentOrderedSet persistentOrderedSetAdd = persistentOrderedSet.add(obj);
            if (persistentOrderedSetAdd.equals(persistentOrderedSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetAdd);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        PersistentOrderedSet persistentOrderedSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                i = stateSetStateRecord.modification;
                persistentOrderedSet = stateSetStateRecord.set;
            }
            persistentOrderedSet.getClass();
            PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder(persistentOrderedSet);
            persistentOrderedSetBuilder.addAll(collection);
            PersistentOrderedSet persistentOrderedSetBuild = persistentOrderedSetBuilder.build();
            if (persistentOrderedSetBuild.equals(persistentOrderedSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        Snapshot snapshotCurrentSnapshot;
        StateSetStateRecord stateSetStateRecord = this.firstStateRecord;
        synchronized (SnapshotKt.lock) {
            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord, this, snapshotCurrentSnapshot);
            synchronized (SnapshotId_jvmKt.sync$2) {
                stateSetStateRecord2.set = PersistentOrderedSet.EMPTY;
                stateSetStateRecord2.modification++;
            }
        }
        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return SnapshotId_jvmKt.getReadable(this).set.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return SnapshotId_jvmKt.getReadable(this).set.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return SnapshotId_jvmKt.getReadable(this).set.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new StateSetIterator(this, ((StateSetStateRecord) SnapshotKt.readable(this.firstStateRecord, this)).set.iterator());
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        stateRecord.next = this.firstStateRecord;
        this.firstStateRecord = (StateSetStateRecord) stateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        PersistentOrderedSet persistentOrderedSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                i = stateSetStateRecord.modification;
                persistentOrderedSet = stateSetStateRecord.set;
            }
            persistentOrderedSet.getClass();
            PersistentOrderedSet persistentOrderedSetRemove = persistentOrderedSet.remove(obj);
            if (persistentOrderedSetRemove.equals(persistentOrderedSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetRemove);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        PersistentOrderedSet persistentOrderedSet;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                i = stateSetStateRecord.modification;
                persistentOrderedSet = stateSetStateRecord.set;
            }
            persistentOrderedSet.getClass();
            PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder(persistentOrderedSet);
            persistentOrderedSetBuilder.removeAll(collection);
            PersistentOrderedSet persistentOrderedSetBuild = persistentOrderedSetBuilder.build();
            if (persistentOrderedSetBuild.equals(persistentOrderedSet)) {
                return false;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        PersistentOrderedSet persistentOrderedSet;
        boolean zRetainAll;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$2) {
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current(this.firstStateRecord, this);
                i = stateSetStateRecord.modification;
                persistentOrderedSet = stateSetStateRecord.set;
            }
            if (persistentOrderedSet == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No set to mutate");
                return false;
            }
            PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder(persistentOrderedSet);
            zRetainAll = persistentOrderedSetBuilder.retainAll(CollectionsKt.toSet(collection));
            PersistentOrderedSet persistentOrderedSetBuild = persistentOrderedSetBuilder.build();
            if (persistentOrderedSetBuild.equals(persistentOrderedSet)) {
                break;
            }
            StateSetStateRecord stateSetStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, this, snapshotCurrentSnapshot), i, persistentOrderedSetBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return zRetainAll;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return SnapshotId_jvmKt.getReadable(this).set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    public final String toString() {
        return "SnapshotStateSet(value=" + ((StateSetStateRecord) SnapshotKt.current(this.firstStateRecord, this)).set + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        PersistentOrderedSet persistentOrderedSet = SnapshotId_jvmKt.getReadable(this).set;
        parcel.writeInt(persistentOrderedSet.size());
        Iterator it = persistentOrderedSet.iterator();
        while (it.hasNext()) {
            parcel.writeValue(it.next());
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }
}
