package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.internal.Lock;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.emoji2.text.EmojiProcessor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DerivedSnapshotState extends StateObjectImpl implements State {
    public final Function0 calculation;
    public ResultRecord first = new ResultRecord(SnapshotKt.currentSnapshot().getSnapshotId());
    public final NeverEqualPolicy policy;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ResultRecord extends StateRecord {
        public static final Object Unset = new Object();
        public MutableObjectIntMap dependencies;
        public Object result;
        public int resultHash;
        public long validSnapshotId;
        public int validSnapshotWriteCount;

        public ResultRecord(long j) {
            super(j);
            MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
            mutableObjectIntMap.getClass();
            this.dependencies = mutableObjectIntMap;
            this.result = Unset;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord stateRecord) {
            stateRecord.getClass();
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        public final boolean isValid(DerivedSnapshotState derivedSnapshotState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                z = true;
                z2 = (this.validSnapshotId == snapshot.getSnapshotId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime()) ? false : true;
            }
            if (this.result == Unset || (z2 && this.resultHash != readableHash(derivedSnapshotState, snapshot))) {
                z = false;
            }
            if (!z || !z2) {
                return z;
            }
            synchronized (obj) {
                this.validSnapshotId = snapshot.getSnapshotId();
                this.validSnapshotWriteCount = snapshot.getWriteCount$runtime();
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00d8 A[PHI: r11
          0x00d8: PHI (r11v1 int) = (r11v0 int), (r11v2 int) binds: [B:30:0x00a9, B:40:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:44:0x00de A[Catch: all -> 0x00cc, LOOP:3: B:29:0x009c->B:44:0x00de, LOOP_END, TryCatch #0 {all -> 0x00cc, blocks: (B:12:0x0025, B:15:0x0032, B:17:0x0041, B:19:0x004f, B:21:0x0059, B:24:0x0076, B:26:0x007a, B:29:0x009c, B:31:0x00ab, B:33:0x00b5, B:35:0x00bb, B:38:0x00cf, B:47:0x00f8, B:44:0x00de, B:46:0x00e8), top: B:74:0x0025 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x014c A[LOOP:5: B:62:0x014a->B:63:0x014c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:84:0x00f8 A[EDGE_INSN: B:84:0x00f8->B:47:0x00f8 BREAK  A[LOOP:3: B:29:0x009c->B:44:0x00de], SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v10, types: [androidx.compose.runtime.DerivedSnapshotState$ResultRecord] */
        /* JADX WARN: Type inference failed for: r13v5, types: [androidx.compose.runtime.snapshots.StateRecord] */
        /* JADX WARN: Type inference failed for: r13v6, types: [androidx.compose.runtime.snapshots.StateRecord, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r18v3, types: [int] */
        /* JADX WARN: Type inference failed for: r25v0 */
        /* JADX WARN: Type inference failed for: r25v1, types: [int] */
        /* JADX WARN: Type inference failed for: r25v2 */
        /* JADX WARN: Type inference failed for: r25v3 */
        /* JADX WARN: Type inference failed for: r25v4 */
        /* JADX WARN: Type inference failed for: r25v5 */
        /* JADX WARN: Type inference failed for: r25v6 */
        /* JADX WARN: Type inference failed for: r25v7 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8, types: [int] */
        public final int readableHash(DerivedSnapshotState derivedSnapshotState, Snapshot snapshot) {
            MutableObjectIntMap mutableObjectIntMap;
            int iIdentityHashCode;
            Object[] objArr;
            int i;
            int i2;
            long[] jArr;
            int i3;
            Object[] objArr2;
            long[] jArr2;
            ?? r25;
            Object[] objArr3;
            long j;
            long j2;
            int i4;
            ?? r26;
            ?? Current;
            synchronized (SnapshotKt.lock) {
                mutableObjectIntMap = this.dependencies;
            }
            int i5 = 7;
            if (mutableObjectIntMap._size == 0) {
                return 7;
            }
            MutableVector mutableVectorDerivedStateObservers = SnapshotStateKt__DerivedStateKt.derivedStateObservers();
            Object[] objArr4 = mutableVectorDerivedStateObservers.content;
            int i6 = mutableVectorDerivedStateObservers.size;
            boolean z = false;
            for (int i7 = 0; i7 < i6; i7++) {
                ((GapComposer$derivedStateObserver$1) objArr4[i7]).start();
            }
            try {
                Object[] objArr5 = mutableObjectIntMap.keys;
                int[] iArr = mutableObjectIntMap.values;
                long[] jArr3 = mutableObjectIntMap.metadata;
                int length = jArr3.length - 2;
                if (length >= 0) {
                    iIdentityHashCode = 7;
                    int i8 = 0;
                    while (true) {
                        long j3 = jArr3[i8];
                        long j4 = -9187201950435737472L;
                        if ((((~j3) << i5) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i9 = 8;
                            int i10 = 8 - ((~(i8 - length)) >>> 31);
                            i3 = i5;
                            ?? r3 = z;
                            while (r3 < i10) {
                                if ((j3 & 255) < 128) {
                                    ?? r18 = (i8 << 3) + r3;
                                    j2 = j4;
                                    StateObject stateObject = (StateObject) objArr5[r18];
                                    int i11 = i9;
                                    if (iArr[r18] != 1) {
                                        jArr2 = jArr3;
                                        r25 = r3;
                                        objArr3 = objArr5;
                                        j = j3;
                                    } else {
                                        if (stateObject instanceof DerivedSnapshotState) {
                                            DerivedSnapshotState derivedSnapshotState2 = (DerivedSnapshotState) stateObject;
                                            Current = derivedSnapshotState2.currentRecord((ResultRecord) SnapshotKt.current(derivedSnapshotState2.first, snapshot), snapshot, z, derivedSnapshotState2.calculation);
                                            MutableObjectIntMap mutableObjectIntMap2 = Current.dependencies;
                                            Object[] objArr6 = mutableObjectIntMap2.keys;
                                            long[] jArr4 = mutableObjectIntMap2.metadata;
                                            int length2 = jArr4.length - 2;
                                            jArr2 = jArr3;
                                            r26 = r3;
                                            objArr3 = objArr5;
                                            if (length2 >= 0) {
                                                int i12 = 0;
                                                while (true) {
                                                    long j5 = jArr4[i12];
                                                    j = j3;
                                                    int iIdentityHashCode2 = iIdentityHashCode;
                                                    if ((((~j5) << i3) & j5 & j2) == j2) {
                                                        iIdentityHashCode = iIdentityHashCode2;
                                                        if (i12 != length2) {
                                                            break;
                                                            break;
                                                        }
                                                        i12++;
                                                        j3 = j;
                                                        i11 = 8;
                                                    } else {
                                                        int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                                        for (int i14 = 0; i14 < i13; i14++) {
                                                            if ((j5 & 255) < 128) {
                                                                iIdentityHashCode2 = (iIdentityHashCode2 * 31) + System.identityHashCode((StateObject) objArr6[(i12 << 3) + i14]);
                                                            }
                                                            j5 >>= i11;
                                                        }
                                                        if (i13 != i11) {
                                                            iIdentityHashCode = iIdentityHashCode2;
                                                            break;
                                                        }
                                                        iIdentityHashCode = iIdentityHashCode2;
                                                        if (i12 != length2) {
                                                            break;
                                                        }
                                                        i12++;
                                                        j3 = j;
                                                        i11 = 8;
                                                    }
                                                }
                                            } else {
                                                j = j3;
                                            }
                                        } else {
                                            jArr2 = jArr3;
                                            r26 = r3;
                                            objArr3 = objArr5;
                                            j = j3;
                                            Current = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                                        }
                                        iIdentityHashCode = (((iIdentityHashCode * 31) + System.identityHashCode(Current)) * 31) + Long.hashCode(Current.snapshotId);
                                        r25 = r26;
                                    }
                                    i4 = 8;
                                } else {
                                    jArr2 = jArr3;
                                    r25 = r3;
                                    objArr3 = objArr5;
                                    j = j3;
                                    j2 = j4;
                                    i4 = i9;
                                }
                                j3 = j >> i4;
                                i9 = i4;
                                j4 = j2;
                                objArr5 = objArr3;
                                z = false;
                                r3 = r25 + 1;
                                jArr3 = jArr2;
                            }
                            jArr = jArr3;
                            objArr2 = objArr5;
                            if (i10 != i9) {
                                break;
                            }
                        } else {
                            jArr = jArr3;
                            i3 = i5;
                            objArr2 = objArr5;
                        }
                        if (i8 != length) {
                            i8++;
                            i5 = i3;
                            jArr3 = jArr;
                            objArr5 = objArr2;
                            z = false;
                        } else {
                            i5 = iIdentityHashCode;
                        }
                    }
                    objArr = mutableVectorDerivedStateObservers.content;
                    i = mutableVectorDerivedStateObservers.size;
                    for (i2 = 0; i2 < i; i2++) {
                        ((GapComposer$derivedStateObserver$1) objArr[i2]).done();
                    }
                    return iIdentityHashCode;
                }
                iIdentityHashCode = i5;
                objArr = mutableVectorDerivedStateObservers.content;
                i = mutableVectorDerivedStateObservers.size;
                while (i2 < i) {
                    ((GapComposer$derivedStateObserver$1) objArr[i2]).done();
                }
                return iIdentityHashCode;
            } catch (Throwable th) {
                Object[] objArr7 = mutableVectorDerivedStateObservers.content;
                int i15 = mutableVectorDerivedStateObservers.size;
                for (int i16 = 0; i16 < i15; i16++) {
                    ((GapComposer$derivedStateObserver$1) objArr7[i16]).done();
                }
                throw th;
            }
        }
    }

    public DerivedSnapshotState(Function0 function0, NeverEqualPolicy neverEqualPolicy) {
        this.calculation = function0;
        this.policy = neverEqualPolicy;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x009c A[EDGE_INSN: B:101:0x009c->B:31:0x009c BREAK  A[LOOP:1: B:16:0x0049->B:30:0x0099], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0099 A[Catch: all -> 0x0038, LOOP:1: B:16:0x0049->B:30:0x0099, LOOP_END, TryCatch #3 {all -> 0x0038, blocks: (B:8:0x0023, B:10:0x002f, B:13:0x003b, B:16:0x0049, B:18:0x0059, B:20:0x0065, B:22:0x006f, B:24:0x0087, B:26:0x008d, B:30:0x0099, B:31:0x009c), top: B:96:0x0023 }] */
    public final ResultRecord currentRecord(ResultRecord resultRecord, Snapshot snapshot, boolean z, Function0 function0) {
        ResultRecord resultRecord2;
        NeverEqualPolicy neverEqualPolicy;
        int i;
        if (resultRecord.isValid(this, snapshot)) {
            if (z) {
                MutableVector mutableVectorDerivedStateObservers = SnapshotStateKt__DerivedStateKt.derivedStateObservers();
                Object[] objArr = mutableVectorDerivedStateObservers.content;
                int i2 = mutableVectorDerivedStateObservers.size;
                for (int i3 = 0; i3 < i2; i3++) {
                    ((GapComposer$derivedStateObserver$1) objArr[i3]).start();
                }
                try {
                    MutableObjectIntMap mutableObjectIntMap = resultRecord.dependencies;
                    EmojiProcessor emojiProcessor = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    IntRef intRef = (IntRef) emojiProcessor.get();
                    if (intRef == null) {
                        intRef = new IntRef();
                        emojiProcessor.set(intRef);
                    }
                    int i4 = intRef.element;
                    Object[] objArr2 = mutableObjectIntMap.keys;
                    int[] iArr = mutableObjectIntMap.values;
                    long[] jArr = mutableObjectIntMap.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j = jArr[i5];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i5 != length) {
                                    break;
                                    break;
                                }
                                i5++;
                            } else {
                                int i6 = 8;
                                int i7 = 8 - ((~(i5 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((j & 255) < 128) {
                                        int i9 = (i5 << 3) + i8;
                                        StateObject stateObject = (StateObject) objArr2[i9];
                                        i = i6;
                                        intRef.element = i4 + iArr[i9];
                                        Function1 readObserver = snapshot.getReadObserver();
                                        if (readObserver != null) {
                                            readObserver.invoke(stateObject);
                                        }
                                    } else {
                                        i = i6;
                                    }
                                    j >>= i;
                                    i8++;
                                    i6 = i;
                                }
                                if (i7 != i6) {
                                    break;
                                }
                                if (i5 != length) {
                                    break;
                                }
                                i5++;
                            }
                        }
                    }
                    intRef.element = i4;
                } finally {
                    Object[] objArr3 = mutableVectorDerivedStateObservers.content;
                    int i10 = mutableVectorDerivedStateObservers.size;
                    for (int i11 = 0; i11 < i10; i11++) {
                        ((GapComposer$derivedStateObserver$1) objArr3[i11]).done();
                    }
                }
            }
            return resultRecord;
        }
        MutableObjectIntMap mutableObjectIntMap2 = new MutableObjectIntMap();
        EmojiProcessor emojiProcessor2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        IntRef intRef2 = (IntRef) emojiProcessor2.get();
        if (intRef2 == null) {
            intRef2 = new IntRef();
            emojiProcessor2.set(intRef2);
        }
        IntRef intRef3 = intRef2;
        int i12 = intRef3.element;
        MutableVector mutableVectorDerivedStateObservers2 = SnapshotStateKt__DerivedStateKt.derivedStateObservers();
        Object[] objArr4 = mutableVectorDerivedStateObservers2.content;
        int i13 = mutableVectorDerivedStateObservers2.size;
        for (int i14 = 0; i14 < i13; i14++) {
            ((GapComposer$derivedStateObserver$1) objArr4[i14]).start();
        }
        try {
            intRef3.element = i12 + 1;
            Object objObserve = Lock.observe(new DerivedSnapshotState$$ExternalSyntheticLambda0((byte) 0, i12, this, intRef3, mutableObjectIntMap2), function0);
            intRef3.element = i12;
            Object[] objArr5 = mutableVectorDerivedStateObservers2.content;
            int i15 = mutableVectorDerivedStateObservers2.size;
            for (int i16 = 0; i16 < i15; i16++) {
                ((GapComposer$derivedStateObserver$1) objArr5[i16]).done();
            }
            Object obj = SnapshotKt.lock;
            synchronized (obj) {
                try {
                    Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                    Object obj2 = resultRecord.result;
                    if (obj2 == ResultRecord.Unset || (neverEqualPolicy = this.policy) == null || !neverEqualPolicy.equivalent(objObserve, obj2)) {
                        ResultRecord resultRecord3 = this.first;
                        synchronized (obj) {
                            StateRecord stateRecordNewOverwritableRecordLocked = SnapshotKt.newOverwritableRecordLocked(resultRecord3, this);
                            stateRecordNewOverwritableRecordLocked.assign(resultRecord3);
                            stateRecordNewOverwritableRecordLocked.snapshotId = snapshotCurrentSnapshot.getSnapshotId();
                            resultRecord2 = (ResultRecord) stateRecordNewOverwritableRecordLocked;
                            resultRecord2.dependencies = mutableObjectIntMap2;
                            resultRecord2.resultHash = resultRecord2.readableHash(this, snapshotCurrentSnapshot);
                            resultRecord2.result = objObserve;
                        }
                        return resultRecord2;
                    }
                    resultRecord.dependencies = mutableObjectIntMap2;
                    resultRecord.resultHash = resultRecord.readableHash(this, snapshotCurrentSnapshot);
                    resultRecord2 = resultRecord;
                } catch (Throwable th) {
                    throw th;
                }
            }
            IntRef intRef4 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            if (intRef4 == null || intRef4.element != 0) {
                return resultRecord2;
            }
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
            synchronized (obj) {
                Snapshot snapshotCurrentSnapshot2 = SnapshotKt.currentSnapshot();
                resultRecord2.validSnapshotId = snapshotCurrentSnapshot2.getSnapshotId();
                resultRecord2.validSnapshotWriteCount = snapshotCurrentSnapshot2.getWriteCount$runtime();
                return resultRecord2;
            }
        } catch (Throwable th2) {
            Object[] objArr6 = mutableVectorDerivedStateObservers2.content;
            int i17 = mutableVectorDerivedStateObservers2.size;
            for (int i18 = 0; i18 < i17; i18++) {
                ((GapComposer$derivedStateObserver$1) objArr6[i18]).done();
            }
            throw th2;
        }
    }

    public final ResultRecord getCurrentRecord() {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshotCurrentSnapshot), snapshotCurrentSnapshot, false, this.calculation);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        Function1 readObserver = SnapshotKt.currentSnapshot().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshotCurrentSnapshot), snapshotCurrentSnapshot, true, this.calculation).result;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.first = (ResultRecord) stateRecord;
    }

    public final String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first, this);
        return "DerivedState(value=" + (resultRecord.isValid(this, SnapshotKt.currentSnapshot()) ? String.valueOf(resultRecord.result) : "<Not calculated>") + ")@" + hashCode();
    }
}
