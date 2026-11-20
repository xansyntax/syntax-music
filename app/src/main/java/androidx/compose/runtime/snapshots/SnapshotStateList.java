package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector;
import androidx.customview.view.AbsSavedState;
import io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateList implements Parcelable, StateObject, List, RandomAccess, KMutableList {
    public static final Parcelable.Creator<SnapshotStateList> CREATOR = new AbsSavedState.AnonymousClass2(1);
    public StateListStateRecord firstStateRecord;

    public SnapshotStateList(AbstractPersistentList abstractPersistentList) {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        StateListStateRecord stateListStateRecord = new StateListStateRecord(snapshotCurrentSnapshot.getSnapshotId(), abstractPersistentList);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            stateListStateRecord.next = new StateListStateRecord(1L, abstractPersistentList);
        }
        this.firstStateRecord = stateListStateRecord;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            AbstractPersistentList abstractPersistentListAdd = abstractPersistentList.add(obj);
            if (abstractPersistentListAdd.equals(abstractPersistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i, abstractPersistentListAdd, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            AbstractPersistentList abstractPersistentListAddAll = abstractPersistentList.addAll(collection);
            if (Intrinsics.areEqual(abstractPersistentListAddAll, abstractPersistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i, abstractPersistentListAddAll, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        Snapshot snapshotCurrentSnapshot;
        StateListStateRecord stateListStateRecord = this.firstStateRecord;
        stateListStateRecord.getClass();
        synchronized (SnapshotKt.lock) {
            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, snapshotCurrentSnapshot);
            synchronized (SnapshotId_jvmKt.sync) {
                stateListStateRecord2.list = SmallPersistentVector.EMPTY;
                stateListStateRecord2.modification++;
                stateListStateRecord2.structuralChange++;
            }
        }
        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return SnapshotId_jvmKt.getReadable(this).list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return SnapshotId_jvmKt.getReadable(this).list.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return SnapshotId_jvmKt.getReadable(this).list.get(i);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return SnapshotId_jvmKt.getReadable(this).list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return SnapshotId_jvmKt.getReadable(this).list.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return SnapshotId_jvmKt.getReadable(this).list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        stateRecord.next = this.firstStateRecord;
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            int iIndexOf = abstractPersistentList.indexOf(obj);
            AbstractPersistentList abstractPersistentListRemoveAt = iIndexOf != -1 ? abstractPersistentList.removeAt(iIndexOf) : abstractPersistentList;
            if (abstractPersistentListRemoveAt.equals(abstractPersistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i, abstractPersistentListRemoveAt, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            AbstractPersistentList abstractPersistentListRemoveAll = abstractPersistentList.removeAll(new SnapshotStateList$$ExternalSyntheticLambda0(collection, (byte) 1));
            if (Intrinsics.areEqual(abstractPersistentListRemoveAll, abstractPersistentList)) {
                return false;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i, abstractPersistentListRemoveAll, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return true;
    }

    public final void removeRange(int i, int i2) {
        int i3;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i3 = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            PersistentVectorBuilder persistentVectorBuilderBuilder = abstractPersistentList.builder();
            persistentVectorBuilderBuilder.subList(i, i2).clear();
            AbstractPersistentList abstractPersistentListBuild = persistentVectorBuilderBuilder.build();
            if (Intrinsics.areEqual(abstractPersistentListBuild, abstractPersistentList)) {
                return;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i3, abstractPersistentListBuild, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return SnapshotId_jvmKt.mutateBoolean(this, new SnapshotStateList$$ExternalSyntheticLambda0(collection, (byte) 0));
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        int i2;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        Object obj2 = get(i);
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i2 = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            AbstractPersistentList abstractPersistentList2 = abstractPersistentList.set(i, obj);
            if (abstractPersistentList2.equals(abstractPersistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i2, abstractPersistentList2, false);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return SnapshotId_jvmKt.getReadable(this).list.getSize();
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= size())) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        return new SubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    public final String toString() {
        StateListStateRecord stateListStateRecord = this.firstStateRecord;
        stateListStateRecord.getClass();
        return "SnapshotStateList(value=" + ((StateListStateRecord) SnapshotKt.current(stateListStateRecord, this)).list + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        AbstractPersistentList abstractPersistentList = SnapshotId_jvmKt.getReadable(this).list;
        int size = abstractPersistentList.getSize();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeValue(abstractPersistentList.get(i2));
        }
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new StateListIterator(this, i);
    }

    public SnapshotStateList() {
        this(SmallPersistentVector.EMPTY);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        int i2;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i2 = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            AbstractPersistentList abstractPersistentListAdd = abstractPersistentList.add(i, obj);
            if (abstractPersistentListAdd.equals(abstractPersistentList)) {
                return;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i2, abstractPersistentListAdd, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        return SnapshotId_jvmKt.mutateBoolean(this, new RawWebSocketCommonKt$$ExternalSyntheticLambda0(i, (Object) collection, (byte) 1));
    }

    @Override // java.util.List
    public final Object remove(int i) {
        int i2;
        AbstractPersistentList abstractPersistentList;
        Snapshot snapshotCurrentSnapshot;
        boolean zAttemptUpdate;
        Object obj = get(i);
        do {
            synchronized (SnapshotId_jvmKt.sync) {
                StateListStateRecord stateListStateRecord = this.firstStateRecord;
                stateListStateRecord.getClass();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, this);
                i2 = stateListStateRecord2.modification;
                abstractPersistentList = stateListStateRecord2.list;
            }
            abstractPersistentList.getClass();
            AbstractPersistentList abstractPersistentListRemoveAt = abstractPersistentList.removeAt(i);
            if (abstractPersistentListRemoveAt.equals(abstractPersistentList)) {
                break;
            }
            StateListStateRecord stateListStateRecord3 = this.firstStateRecord;
            stateListStateRecord3.getClass();
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAttemptUpdate = SnapshotId_jvmKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, snapshotCurrentSnapshot), i2, abstractPersistentListRemoveAt, true);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAttemptUpdate);
        return obj;
    }
}
