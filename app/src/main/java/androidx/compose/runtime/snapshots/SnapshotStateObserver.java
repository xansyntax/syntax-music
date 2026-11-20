package androidx.compose.runtime.snapshots;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer$derivedStateObserver$1;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateObserver {
    public OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 applyUnsubscribe;
    public ObservedScopeMap currentMap;
    public final Function1 onChangedExecutor;
    public boolean sendingNotifications;
    public final AtomicReference pendingChanges = new AtomicReference(null);
    public final ComposerKt$$ExternalSyntheticLambda0 applyObserver = new ComposerKt$$ExternalSyntheticLambda0(24, this);
    public final TextKt$$ExternalSyntheticLambda2 readObserver = new TextKt$$ExternalSyntheticLambda2(17, this);
    public final MutableVector observedScopeMaps = new MutableVector(new ObservedScopeMap[16]);
    public final Object observedScopeMapsLock = new Object();
    public long currentMapThreadId = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ObservedScopeMap {
        public final MutableScatterMap _dependencyToDerivedStates;
        public final MutableScatterSet _invalidated;
        public final MutableScatterMap _recordedDerivedStateValues;
        public MutableScatterMap _scopeToValues;
        public MutableVector _statesToReread;
        public MutableScatterMap _valueToScopes;
        public Object currentScope;
        public MutableObjectIntMap currentScopeReads;
        public int currentToken = -1;
        public final MutableScatterMap dependencyToDerivedStates;
        public int deriveStateScopeCount;
        public final GapComposer$derivedStateObserver$1 derivedStateObserver;
        public final MutableScatterSet invalidated;
        public final Function1 onChanged;
        public boolean readingDerivedStates;
        public final MutableScatterMap recordedDerivedStateValues;

        public ObservedScopeMap(Function1 function1) {
            this.onChanged = function1;
            MutableScatterSet mutableScatterSet = this._invalidated;
            if (mutableScatterSet == null) {
                mutableScatterSet = new MutableScatterSet();
                this._invalidated = mutableScatterSet;
            }
            this.invalidated = mutableScatterSet;
            this.derivedStateObserver = new GapComposer$derivedStateObserver$1((byte) 1, this);
            MutableScatterMap mutableScatterMapM899constructorimpl$default = this._dependencyToDerivedStates;
            if (mutableScatterMapM899constructorimpl$default == null) {
                mutableScatterMapM899constructorimpl$default = IntMath.m899constructorimpl$default();
                this._dependencyToDerivedStates = mutableScatterMapM899constructorimpl$default;
            }
            this.dependencyToDerivedStates = mutableScatterMapM899constructorimpl$default;
            MutableScatterMap mutableScatterMap = this._recordedDerivedStateValues;
            if (mutableScatterMap == null) {
                mutableScatterMap = new MutableScatterMap();
                this._recordedDerivedStateValues = mutableScatterMap;
            }
            this.recordedDerivedStateValues = mutableScatterMap;
        }

        public final MutableScatterMap getScopeToValues() {
            MutableScatterMap mutableScatterMap = this._scopeToValues;
            if (mutableScatterMap != null) {
                return mutableScatterMap;
            }
            MutableScatterMap mutableScatterMap2 = new MutableScatterMap();
            this._scopeToValues = mutableScatterMap2;
            return mutableScatterMap2;
        }

        public final MutableVector getStatesToReread() {
            MutableVector mutableVector = this._statesToReread;
            if (mutableVector != null) {
                return mutableVector;
            }
            MutableVector mutableVector2 = new MutableVector(new DerivedSnapshotState[16]);
            this._statesToReread = mutableVector2;
            return mutableVector2;
        }

        /* JADX INFO: renamed from: getValueToScopes-afanTW4, reason: not valid java name */
        public final MutableScatterMap m394getValueToScopesafanTW4() {
            MutableScatterMap mutableScatterMap = this._valueToScopes;
            if (mutableScatterMap != null) {
                return mutableScatterMap;
            }
            MutableScatterMap mutableScatterMapM899constructorimpl$default = IntMath.m899constructorimpl$default();
            this._valueToScopes = mutableScatterMapM899constructorimpl$default;
            return mutableScatterMapM899constructorimpl$default;
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0234 A[DONT_INVERT, PHI: r21
          0x0234: PHI (r21v25 boolean) = (r21v24 boolean), (r21v26 boolean) binds: [B:93:0x020c, B:101:0x0232] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:103:0x0236 A[Catch: all -> 0x0126, LOOP:8: B:92:0x0202->B:103:0x0236, LOOP_END, TryCatch #0 {all -> 0x0126, blocks: (B:24:0x0074, B:26:0x007a, B:28:0x007e, B:31:0x0093, B:33:0x00a3, B:35:0x00ad, B:37:0x00b3, B:40:0x00ce, B:42:0x00dc, B:44:0x00e2, B:46:0x00e6, B:49:0x00f8, B:51:0x0108, B:53:0x0112, B:55:0x0118, B:59:0x012c, B:65:0x013e, B:72:0x017d, B:67:0x014e, B:68:0x015c, B:78:0x01ab, B:80:0x01c2, B:83:0x01de, B:85:0x01ea, B:87:0x01f0, B:89:0x01f4, B:92:0x0202, B:94:0x020e, B:96:0x021a, B:98:0x0220, B:99:0x022a, B:103:0x0236, B:104:0x0239, B:105:0x023f), top: B:319:0x0074 }] */
        /* JADX WARN: Code duplicated, block: B:130:0x02bb A[DONT_INVERT, PHI: r21
          0x02bb: PHI (r21v18 boolean) = (r21v17 boolean), (r21v19 boolean) binds: [B:121:0x0292, B:129:0x02b9] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:131:0x02bd A[LOOP:6: B:120:0x0288->B:131:0x02bd, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:246:0x050c A[EDGE_INSN: B:246:0x050c->B:247:0x050d BREAK  A[LOOP:20: B:230:0x04cb->B:243:0x0502], PHI: r2
          0x050c: PHI (r2v9 boolean) = (r2v2 boolean), (r2v2 boolean), (r2v13 boolean) binds: [B:224:0x04b6, B:228:0x04c7, B:244:0x0505] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:250:0x0518  */
        /* JADX WARN: Code duplicated, block: B:274:0x0575 A[DONT_INVERT, PHI: r0
          0x0575: PHI (r0v8 boolean) = (r0v7 boolean), (r0v9 boolean) binds: [B:265:0x054d, B:273:0x0573] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:275:0x0577 A[LOOP:18: B:264:0x0543->B:275:0x0577, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:335:0x02c5 A[EDGE_INSN: B:335:0x02c5->B:133:0x02c5 BREAK  A[LOOP:6: B:120:0x0288->B:131:0x02bd], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:340:0x01bf A[EDGE_INSN: B:340:0x01bf->B:79:0x01bf BREAK  A[LOOP:8: B:92:0x0202->B:103:0x0236], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:363:0x057e A[EDGE_INSN: B:363:0x057e->B:277:0x057e BREAK  A[LOOP:18: B:264:0x0543->B:275:0x0577], SYNTHETIC] */
        public final boolean recordInvalidation(Set set) {
            char c;
            long j;
            boolean z;
            Iterator it;
            int i;
            boolean z2;
            Object[] objArr;
            long[] jArr;
            Iterator it2;
            MutableScatterMap mutableScatterMap;
            int i2;
            Object[] objArr2;
            long j2;
            long[] jArr2;
            boolean z3;
            long[] jArr3;
            NeverEqualPolicy neverEqualPolicy;
            Object[] objArr3;
            MutableScatterMap mutableScatterMap2;
            int i3;
            long[] jArr4;
            NeverEqualPolicy neverEqualPolicy2;
            Object[] objArr4;
            MutableScatterMap mutableScatterMap3;
            int i4;
            int i5;
            long j3;
            int i6;
            int i7;
            Object[] objArr5;
            int i8;
            long j4;
            Object[] objArr6;
            int i9;
            int i10;
            long[] jArr5;
            NeverEqualPolicy neverEqualPolicy3 = NeverEqualPolicy.INSTANCE$3;
            MutableScatterMap mutableScatterMapM394getValueToScopesafanTW4 = m394getValueToScopesafanTW4();
            boolean z4 = set instanceof ScatterSetWrapper;
            MutableScatterMap mutableScatterMap4 = this.dependencyToDerivedStates;
            MutableScatterMap mutableScatterMap5 = this.recordedDerivedStateValues;
            MutableScatterSet mutableScatterSet = this.invalidated;
            if (z4) {
                MutableScatterSet mutableScatterSet2 = ((ScatterSetWrapper) set).set;
                Object[] objArr7 = mutableScatterSet2.elements;
                long[] jArr6 = mutableScatterSet2.metadata;
                int length = jArr6.length - 2;
                if (length >= 0) {
                    int i11 = 0;
                    c = 7;
                    z = false;
                    j = -9187201950435737472L;
                    while (true) {
                        long j5 = jArr6[i11];
                        int i12 = 8;
                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i13 = 8 - ((~(i11 - length)) >>> 31);
                            int i14 = 0;
                            while (i14 < i13) {
                                if ((j5 & 255) < 128) {
                                    Object obj = objArr7[(i11 << 3) + i14];
                                    if (obj instanceof StateObjectImpl) {
                                        jArr4 = jArr6;
                                        if (!((StateObjectImpl) obj).m395isReadInh_f27i8$runtime(2)) {
                                        }
                                        j5 = j3 >> 8;
                                        i14 = i7 + 1;
                                        jArr6 = jArr4;
                                        i12 = 8;
                                        neverEqualPolicy3 = neverEqualPolicy2;
                                        mutableScatterMap4 = mutableScatterMap3;
                                        objArr7 = objArr4;
                                        length = i4;
                                        i11 = i5;
                                        i13 = i6;
                                    } else {
                                        jArr4 = jArr6;
                                    }
                                    if (this.readingDerivedStates || !mutableScatterMap4.containsKey(obj)) {
                                        neverEqualPolicy2 = neverEqualPolicy3;
                                        objArr4 = objArr7;
                                        mutableScatterMap3 = mutableScatterMap4;
                                        i4 = length;
                                        i5 = i11;
                                        j3 = j5;
                                        i6 = i13;
                                        i7 = i14;
                                    } else {
                                        this.readingDerivedStates = true;
                                        try {
                                            Object obj2 = mutableScatterMap4.get(obj);
                                            if (obj2 != null) {
                                                if (obj2 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                                                    Object[] objArr8 = mutableScatterSet3.elements;
                                                    long[] jArr7 = mutableScatterSet3.metadata;
                                                    neverEqualPolicy2 = neverEqualPolicy3;
                                                    int length2 = jArr7.length - 2;
                                                    if (length2 >= 0) {
                                                        j3 = j5;
                                                        int i15 = 0;
                                                        Object[] objArr9 = objArr8;
                                                        while (true) {
                                                            long j6 = jArr7[i15];
                                                            objArr4 = objArr7;
                                                            mutableScatterMap3 = mutableScatterMap4;
                                                            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i16 = 8 - ((~(i15 - length2)) >>> 31);
                                                                int i17 = 0;
                                                                while (i17 < i16) {
                                                                    if ((j6 & 255) < 128) {
                                                                        i8 = i17;
                                                                        DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) objArr9[(i15 << 3) + i17];
                                                                        derivedSnapshotState.getClass();
                                                                        j4 = j6;
                                                                        Object obj3 = mutableScatterMap5.get(derivedSnapshotState);
                                                                        NeverEqualPolicy neverEqualPolicy4 = derivedSnapshotState.policy;
                                                                        if (neverEqualPolicy4 == null) {
                                                                            neverEqualPolicy4 = neverEqualPolicy2;
                                                                        }
                                                                        objArr6 = objArr9;
                                                                        if (neverEqualPolicy4.equivalent(derivedSnapshotState.getCurrentRecord().result, obj3)) {
                                                                            length = length;
                                                                            i11 = i11;
                                                                            i9 = i13;
                                                                            i10 = i14;
                                                                            getStatesToReread().add(derivedSnapshotState);
                                                                        } else {
                                                                            Object obj4 = mutableScatterMapM394getValueToScopesafanTW4.get(derivedSnapshotState);
                                                                            if (obj4 != null) {
                                                                                if (obj4 instanceof MutableScatterSet) {
                                                                                    MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj4;
                                                                                    Object[] objArr10 = mutableScatterSet4.elements;
                                                                                    long[] jArr8 = mutableScatterSet4.metadata;
                                                                                    int length3 = jArr8.length - 2;
                                                                                    if (length3 >= 0) {
                                                                                        length = length;
                                                                                        i11 = i11;
                                                                                        int i18 = 0;
                                                                                        while (true) {
                                                                                            long j7 = jArr8[i18];
                                                                                            i9 = i13;
                                                                                            i10 = i14;
                                                                                            if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                                int i19 = 8 - ((~(i18 - length3)) >>> 31);
                                                                                                int i20 = 0;
                                                                                                while (i20 < i19) {
                                                                                                    if ((j7 & 255) < 128) {
                                                                                                        mutableScatterSet.add(objArr10[(i18 << 3) + i20]);
                                                                                                        z = true;
                                                                                                    }
                                                                                                    j7 >>= i12;
                                                                                                    i20++;
                                                                                                    jArr8 = jArr8;
                                                                                                }
                                                                                                jArr5 = jArr8;
                                                                                                if (i19 != i12) {
                                                                                                    break;
                                                                                                }
                                                                                            } else {
                                                                                                jArr5 = jArr8;
                                                                                            }
                                                                                            if (i18 == length3) {
                                                                                                break;
                                                                                            }
                                                                                            i18++;
                                                                                            i13 = i9;
                                                                                            i14 = i10;
                                                                                            jArr8 = jArr5;
                                                                                            i12 = 8;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    length = length;
                                                                                    i11 = i11;
                                                                                    i9 = i13;
                                                                                    i10 = i14;
                                                                                    mutableScatterSet.add(obj4);
                                                                                    z = true;
                                                                                }
                                                                            }
                                                                        }
                                                                        j6 = j4 >> 8;
                                                                        i12 = 8;
                                                                        i17 = i8 + 1;
                                                                        objArr9 = objArr6;
                                                                        length = length;
                                                                        i11 = i11;
                                                                        i13 = i9;
                                                                        i14 = i10;
                                                                    } else {
                                                                        i8 = i17;
                                                                        j4 = j6;
                                                                        objArr6 = objArr9;
                                                                    }
                                                                    i9 = i13;
                                                                    i10 = i14;
                                                                    j6 = j4 >> 8;
                                                                    i12 = 8;
                                                                    i17 = i8 + 1;
                                                                    objArr9 = objArr6;
                                                                    length = length;
                                                                    i11 = i11;
                                                                    i13 = i9;
                                                                    i14 = i10;
                                                                }
                                                                i4 = length;
                                                                i5 = i11;
                                                                objArr5 = objArr9;
                                                                i6 = i13;
                                                                i7 = i14;
                                                                if (i16 != i12) {
                                                                    break;
                                                                }
                                                            } else {
                                                                i4 = length;
                                                                i5 = i11;
                                                                objArr5 = objArr9;
                                                                i6 = i13;
                                                                i7 = i14;
                                                            }
                                                            if (i15 == length2) {
                                                                break;
                                                            }
                                                            i15++;
                                                            mutableScatterMap4 = mutableScatterMap3;
                                                            objArr7 = objArr4;
                                                            objArr9 = objArr5;
                                                            length = i4;
                                                            i11 = i5;
                                                            i13 = i6;
                                                            i14 = i7;
                                                            i12 = 8;
                                                        }
                                                    }
                                                } else {
                                                    neverEqualPolicy2 = neverEqualPolicy3;
                                                    objArr4 = objArr7;
                                                    mutableScatterMap3 = mutableScatterMap4;
                                                    i4 = length;
                                                    i5 = i11;
                                                    j3 = j5;
                                                    i6 = i13;
                                                    i7 = i14;
                                                    DerivedSnapshotState derivedSnapshotState2 = (DerivedSnapshotState) obj2;
                                                    Object obj5 = mutableScatterMap5.get(derivedSnapshotState2);
                                                    NeverEqualPolicy neverEqualPolicy5 = derivedSnapshotState2.policy;
                                                    if (neverEqualPolicy5 == null) {
                                                        neverEqualPolicy5 = neverEqualPolicy2;
                                                    }
                                                    if (neverEqualPolicy5.equivalent(derivedSnapshotState2.getCurrentRecord().result, obj5)) {
                                                        getStatesToReread().add(derivedSnapshotState2);
                                                    } else {
                                                        Object obj6 = mutableScatterMapM394getValueToScopesafanTW4.get(derivedSnapshotState2);
                                                        if (obj6 != null) {
                                                            if (obj6 instanceof MutableScatterSet) {
                                                                MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj6;
                                                                Object[] objArr11 = mutableScatterSet5.elements;
                                                                long[] jArr9 = mutableScatterSet5.metadata;
                                                                int length4 = jArr9.length - 2;
                                                                if (length4 >= 0) {
                                                                    int i21 = 0;
                                                                    while (true) {
                                                                        long j8 = jArr9[i21];
                                                                        if ((((~j8) << 7) & j8 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                            if (i21 != length4) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            i21++;
                                                                        } else {
                                                                            int i22 = 8 - ((~(i21 - length4)) >>> 31);
                                                                            for (int i23 = 0; i23 < i22; i23++) {
                                                                                if ((j8 & 255) < 128) {
                                                                                    mutableScatterSet.add(objArr11[(i21 << 3) + i23]);
                                                                                    z = true;
                                                                                }
                                                                                j8 >>= 8;
                                                                            }
                                                                            if (i22 != 8) {
                                                                                break;
                                                                            }
                                                                            if (i21 != length4) {
                                                                                break;
                                                                            }
                                                                            i21++;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                mutableScatterSet.add(obj6);
                                                                z = true;
                                                            }
                                                        }
                                                    }
                                                }
                                                this.readingDerivedStates = false;
                                            } else {
                                                neverEqualPolicy2 = neverEqualPolicy3;
                                            }
                                            objArr4 = objArr7;
                                            mutableScatterMap3 = mutableScatterMap4;
                                            i4 = length;
                                            i5 = i11;
                                            j3 = j5;
                                            i6 = i13;
                                            i7 = i14;
                                            this.readingDerivedStates = false;
                                        } catch (Throwable th) {
                                            this.readingDerivedStates = false;
                                            throw th;
                                        }
                                    }
                                    Object obj7 = mutableScatterMapM394getValueToScopesafanTW4.get(obj);
                                    if (obj7 != null) {
                                        if (obj7 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj7;
                                            Object[] objArr12 = mutableScatterSet6.elements;
                                            long[] jArr10 = mutableScatterSet6.metadata;
                                            int length5 = jArr10.length - 2;
                                            if (length5 >= 0) {
                                                int i24 = 0;
                                                while (true) {
                                                    long j9 = jArr10[i24];
                                                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                        if (i24 != length5) {
                                                            break;
                                                            break;
                                                        }
                                                        i24++;
                                                    } else {
                                                        int i25 = 8 - ((~(i24 - length5)) >>> 31);
                                                        long j10 = j9;
                                                        for (int i26 = 0; i26 < i25; i26++) {
                                                            if ((j10 & 255) < 128) {
                                                                mutableScatterSet.add(objArr12[(i24 << 3) + i26]);
                                                                z = true;
                                                            }
                                                            j10 >>= 8;
                                                        }
                                                        if (i25 != 8) {
                                                            break;
                                                        }
                                                        if (i24 != length5) {
                                                            break;
                                                        }
                                                        i24++;
                                                    }
                                                }
                                            }
                                        } else {
                                            mutableScatterSet.add(obj7);
                                            z = true;
                                        }
                                    }
                                    j5 = j3 >> 8;
                                    i14 = i7 + 1;
                                    jArr6 = jArr4;
                                    i12 = 8;
                                    neverEqualPolicy3 = neverEqualPolicy2;
                                    mutableScatterMap4 = mutableScatterMap3;
                                    objArr7 = objArr4;
                                    length = i4;
                                    i11 = i5;
                                    i13 = i6;
                                } else {
                                    jArr4 = jArr6;
                                }
                                neverEqualPolicy2 = neverEqualPolicy3;
                                objArr4 = objArr7;
                                mutableScatterMap3 = mutableScatterMap4;
                                i4 = length;
                                i5 = i11;
                                j3 = j5;
                                i6 = i13;
                                i7 = i14;
                                j5 = j3 >> 8;
                                i14 = i7 + 1;
                                jArr6 = jArr4;
                                i12 = 8;
                                neverEqualPolicy3 = neverEqualPolicy2;
                                mutableScatterMap4 = mutableScatterMap3;
                                objArr7 = objArr4;
                                length = i4;
                                i11 = i5;
                                i13 = i6;
                            }
                            jArr3 = jArr6;
                            neverEqualPolicy = neverEqualPolicy3;
                            objArr3 = objArr7;
                            mutableScatterMap2 = mutableScatterMap4;
                            int i27 = length;
                            int i28 = i11;
                            if (i13 != i12) {
                                break;
                            }
                            length = i27;
                            i3 = i28;
                        } else {
                            jArr3 = jArr6;
                            neverEqualPolicy = neverEqualPolicy3;
                            objArr3 = objArr7;
                            mutableScatterMap2 = mutableScatterMap4;
                            i3 = i11;
                        }
                        if (i3 == length) {
                            break;
                        }
                        i11 = i3 + 1;
                        jArr6 = jArr3;
                        neverEqualPolicy3 = neverEqualPolicy;
                        mutableScatterMap4 = mutableScatterMap2;
                        objArr7 = objArr3;
                    }
                } else {
                    c = 7;
                    j = -9187201950435737472L;
                    z = false;
                }
            } else {
                MutableScatterMap mutableScatterMap6 = mutableScatterMap4;
                c = 7;
                j = -9187201950435737472L;
                Iterator it3 = set.iterator();
                boolean z5 = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (!(next instanceof StateObjectImpl) || ((StateObjectImpl) next).m395isReadInh_f27i8$runtime(2)) {
                        if (this.readingDerivedStates) {
                            it = it3;
                            i = 0;
                        } else {
                            MutableScatterMap mutableScatterMap7 = mutableScatterMap6;
                            if (mutableScatterMap7.containsKey(next)) {
                                this.readingDerivedStates = true;
                                try {
                                    Object obj8 = mutableScatterMap7.get(next);
                                    if (obj8 == null) {
                                        it = it3;
                                        mutableScatterMap6 = mutableScatterMap7;
                                    } else if (obj8 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj8;
                                        Object[] objArr13 = mutableScatterSet7.elements;
                                        long[] jArr11 = mutableScatterSet7.metadata;
                                        int length6 = jArr11.length - 2;
                                        if (length6 >= 0) {
                                            boolean z6 = z5;
                                            int i29 = 0;
                                            while (true) {
                                                long j11 = jArr11[i29];
                                                long[] jArr12 = jArr11;
                                                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i30 = 8 - ((~(i29 - length6)) >>> 31);
                                                    int i31 = 0;
                                                    while (i31 < i30) {
                                                        if ((j11 & 255) < 128) {
                                                            it2 = it3;
                                                            DerivedSnapshotState derivedSnapshotState3 = (DerivedSnapshotState) objArr13[(i29 << 3) + i31];
                                                            derivedSnapshotState3.getClass();
                                                            mutableScatterMap = mutableScatterMap7;
                                                            Object obj9 = mutableScatterMap5.get(derivedSnapshotState3);
                                                            i2 = i31;
                                                            NeverEqualPolicy neverEqualPolicy6 = derivedSnapshotState3.policy;
                                                            if (neverEqualPolicy6 == null) {
                                                                neverEqualPolicy6 = neverEqualPolicy3;
                                                            }
                                                            objArr2 = objArr13;
                                                            if (neverEqualPolicy6.equivalent(derivedSnapshotState3.getCurrentRecord().result, obj9)) {
                                                                j2 = j11;
                                                                jArr2 = jArr12;
                                                                getStatesToReread().add(derivedSnapshotState3);
                                                            } else {
                                                                Object obj10 = mutableScatterMapM394getValueToScopesafanTW4.get(derivedSnapshotState3);
                                                                if (obj10 != null) {
                                                                    if (obj10 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj10;
                                                                        Object[] objArr14 = mutableScatterSet8.elements;
                                                                        long[] jArr13 = mutableScatterSet8.metadata;
                                                                        int length7 = jArr13.length - 2;
                                                                        j2 = j11;
                                                                        if (length7 >= 0) {
                                                                            int i32 = 0;
                                                                            boolean z7 = z6;
                                                                            while (true) {
                                                                                long j12 = jArr13[i32];
                                                                                boolean z8 = z7;
                                                                                jArr2 = jArr12;
                                                                                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                    int i33 = 8 - ((~(i32 - length7)) >>> 31);
                                                                                    long j13 = j12;
                                                                                    for (int i34 = 0; i34 < i33; i34++) {
                                                                                        if ((j13 & 255) < 128) {
                                                                                            mutableScatterSet.add(objArr14[(i32 << 3) + i34]);
                                                                                            z8 = true;
                                                                                        }
                                                                                        j13 >>= 8;
                                                                                    }
                                                                                    if (i33 != 8) {
                                                                                        z3 = z8;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                z7 = z8;
                                                                                if (i32 != length7) {
                                                                                    i32++;
                                                                                    jArr12 = jArr2;
                                                                                } else {
                                                                                    z6 = z7;
                                                                                }
                                                                            }
                                                                        }
                                                                        z3 = z6;
                                                                        break;
                                                                    } else {
                                                                        j2 = j11;
                                                                        jArr2 = jArr12;
                                                                        mutableScatterSet.add(obj10);
                                                                        z3 = true;
                                                                    }
                                                                    z6 = z3;
                                                                } else {
                                                                    j2 = j11;
                                                                }
                                                                jArr2 = jArr12;
                                                                z3 = z6;
                                                                z6 = z3;
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            mutableScatterMap = mutableScatterMap7;
                                                            i2 = i31;
                                                            objArr2 = objArr13;
                                                            j2 = j11;
                                                            jArr2 = jArr12;
                                                        }
                                                        j11 = j2 >> 8;
                                                        i31 = i2 + 1;
                                                        it3 = it2;
                                                        objArr13 = objArr2;
                                                        mutableScatterMap7 = mutableScatterMap;
                                                        jArr12 = jArr2;
                                                    }
                                                    it = it3;
                                                    mutableScatterMap6 = mutableScatterMap7;
                                                    objArr = objArr13;
                                                    jArr = jArr12;
                                                    if (i30 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    it = it3;
                                                    mutableScatterMap6 = mutableScatterMap7;
                                                    objArr = objArr13;
                                                    jArr = jArr12;
                                                }
                                                if (i29 == length6) {
                                                    break;
                                                }
                                                i29++;
                                                it3 = it;
                                                objArr13 = objArr;
                                                mutableScatterMap7 = mutableScatterMap6;
                                                jArr11 = jArr;
                                            }
                                            z5 = z6;
                                        } else {
                                            it = it3;
                                            mutableScatterMap6 = mutableScatterMap7;
                                        }
                                    } else {
                                        it = it3;
                                        mutableScatterMap6 = mutableScatterMap7;
                                        DerivedSnapshotState derivedSnapshotState4 = (DerivedSnapshotState) obj8;
                                        Object obj11 = mutableScatterMap5.get(derivedSnapshotState4);
                                        NeverEqualPolicy neverEqualPolicy7 = derivedSnapshotState4.policy;
                                        if (neverEqualPolicy7 == null) {
                                            neverEqualPolicy7 = neverEqualPolicy3;
                                        }
                                        if (neverEqualPolicy7.equivalent(derivedSnapshotState4.getCurrentRecord().result, obj11)) {
                                            getStatesToReread().add(derivedSnapshotState4);
                                        } else {
                                            Object obj12 = mutableScatterMapM394getValueToScopesafanTW4.get(derivedSnapshotState4);
                                            if (obj12 == null) {
                                                z2 = z5;
                                                break;
                                            }
                                            if (obj12 instanceof MutableScatterSet) {
                                                MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj12;
                                                Object[] objArr15 = mutableScatterSet9.elements;
                                                long[] jArr14 = mutableScatterSet9.metadata;
                                                int length8 = jArr14.length - 2;
                                                if (length8 < 0) {
                                                    z2 = z5;
                                                    break;
                                                }
                                                boolean z9 = z5;
                                                int i35 = 0;
                                                while (true) {
                                                    long j14 = jArr14[i35];
                                                    if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i36 = 8 - ((~(i35 - length8)) >>> 31);
                                                        long j15 = j14;
                                                        for (int i37 = 0; i37 < i36; i37++) {
                                                            if ((j15 & 255) < 128) {
                                                                mutableScatterSet.add(objArr15[(i35 << 3) + i37]);
                                                                z9 = true;
                                                            }
                                                            j15 >>= 8;
                                                        }
                                                        if (i36 != 8) {
                                                            z2 = z9;
                                                            break;
                                                        }
                                                    }
                                                    if (i35 == length8) {
                                                        z5 = z9;
                                                        z2 = z5;
                                                        break;
                                                    }
                                                    i35++;
                                                }
                                            } else {
                                                mutableScatterSet.add(obj12);
                                                z2 = true;
                                            }
                                            z5 = z2;
                                        }
                                    }
                                    i = 0;
                                    this.readingDerivedStates = false;
                                } catch (Throwable th2) {
                                    this.readingDerivedStates = false;
                                    throw th2;
                                }
                            } else {
                                mutableScatterMap6 = mutableScatterMap7;
                                it = it3;
                                i = 0;
                            }
                        }
                        boolean z10 = z5;
                        Object obj13 = mutableScatterMapM394getValueToScopesafanTW4.get(next);
                        if (obj13 != null) {
                            if (obj13 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet10 = (MutableScatterSet) obj13;
                                Object[] objArr16 = mutableScatterSet10.elements;
                                long[] jArr15 = mutableScatterSet10.metadata;
                                int length9 = jArr15.length - 2;
                                if (length9 >= 0) {
                                    int i38 = i;
                                    while (true) {
                                        long j16 = jArr15[i38];
                                        if ((((~j16) << 7) & j16 & (-9187201950435737472L)) == -9187201950435737472L) {
                                            if (i38 != length9) {
                                                break;
                                                break;
                                            }
                                            i38++;
                                        } else {
                                            int i39 = 8 - ((~(i38 - length9)) >>> 31);
                                            long j17 = j16;
                                            for (int i40 = i; i40 < i39; i40++) {
                                                if ((j17 & 255) < 128) {
                                                    mutableScatterSet.add(objArr16[(i38 << 3) + i40]);
                                                    z10 = true;
                                                }
                                                j17 >>= 8;
                                            }
                                            if (i39 != 8) {
                                                break;
                                            }
                                            if (i38 != length9) {
                                                break;
                                            }
                                            i38++;
                                        }
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj13);
                                z10 = true;
                            }
                        }
                        z5 = z10;
                    } else {
                        it = it3;
                    }
                    it3 = it;
                }
                z = z5;
            }
            if (!this.readingDerivedStates && getStatesToReread().size != 0) {
                MutableVector statesToReread = getStatesToReread();
                Object[] objArr17 = statesToReread.content;
                int i41 = statesToReread.size;
                for (int i42 = 0; i42 < i41; i42++) {
                    DerivedSnapshotState derivedSnapshotState5 = (DerivedSnapshotState) objArr17[i42];
                    MutableScatterMap scopeToValues = getScopeToValues();
                    int iHashCode = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
                    Object obj14 = m394getValueToScopesafanTW4().get(derivedSnapshotState5);
                    if (obj14 != null) {
                        if (obj14 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet11 = (MutableScatterSet) obj14;
                            Object[] objArr18 = mutableScatterSet11.elements;
                            long[] jArr16 = mutableScatterSet11.metadata;
                            int length10 = jArr16.length - 2;
                            if (length10 >= 0) {
                                int i43 = 0;
                                while (true) {
                                    long j18 = jArr16[i43];
                                    if ((((~j18) << c) & j18 & j) != j) {
                                        int i44 = 8 - ((~(i43 - length10)) >>> 31);
                                        long j19 = j18;
                                        for (int i45 = 0; i45 < i44; i45++) {
                                            if ((j19 & 255) < 128) {
                                                Object obj15 = objArr18[(i43 << 3) + i45];
                                                MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) scopeToValues.get(obj15);
                                                if (mutableObjectIntMap == null) {
                                                    mutableObjectIntMap = new MutableObjectIntMap();
                                                    scopeToValues.set(obj15, mutableObjectIntMap);
                                                }
                                                recordRead(derivedSnapshotState5, iHashCode, obj15, mutableObjectIntMap);
                                            }
                                            j19 >>= 8;
                                        }
                                        if (i44 != 8) {
                                            break;
                                        }
                                    }
                                    if (i43 == length10) {
                                        break;
                                    }
                                    i43++;
                                }
                            }
                        } else {
                            MutableObjectIntMap mutableObjectIntMap2 = (MutableObjectIntMap) scopeToValues.get(obj14);
                            if (mutableObjectIntMap2 == null) {
                                mutableObjectIntMap2 = new MutableObjectIntMap();
                                scopeToValues.set(obj14, mutableObjectIntMap2);
                            }
                            recordRead(derivedSnapshotState5, iHashCode, obj14, mutableObjectIntMap2);
                        }
                    }
                }
                getStatesToReread().clear();
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x008b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x008d A[LOOP:0: B:15:0x0048->B:28:0x008d, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:37:0x0090 A[EDGE_INSN: B:37:0x0090->B:29:0x0090 BREAK  A[LOOP:0: B:15:0x0048->B:28:0x008d], SYNTHETIC] */
        public final void recordRead(Object obj, int i, Object obj2, MutableObjectIntMap mutableObjectIntMap) {
            int i2;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iFindIndex = mutableObjectIntMap.findIndex(obj);
            if (iFindIndex < 0) {
                iFindIndex = ~iFindIndex;
                i2 = -1;
            } else {
                i2 = mutableObjectIntMap.values[iFindIndex];
            }
            mutableObjectIntMap.keys[iFindIndex] = obj;
            mutableObjectIntMap.values[iFindIndex] = i;
            if ((obj instanceof DerivedSnapshotState) && i2 != i) {
                DerivedSnapshotState.ResultRecord currentRecord = ((DerivedSnapshotState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.set(obj, currentRecord.result);
                MutableObjectIntMap mutableObjectIntMap2 = currentRecord.dependencies;
                MutableScatterMap mutableScatterMap = this.dependencyToDerivedStates;
                IntMath.m903removeScopeimpl(mutableScatterMap, obj);
                Object[] objArr = mutableObjectIntMap2.keys;
                long[] jArr = mutableObjectIntMap2.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        long j = jArr[i3];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        } else {
                            int i4 = 8 - ((~(i3 - length)) >>> 31);
                            for (int i5 = 0; i5 < i4; i5++) {
                                if ((j & 255) < 128) {
                                    StateObject stateObject = (StateObject) objArr[(i3 << 3) + i5];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).m396recordReadInh_f27i8$runtime(2);
                                    }
                                    IntMath.m897addimpl(mutableScatterMap, stateObject, obj);
                                }
                                j >>= 8;
                            }
                            if (i4 != 8) {
                                break;
                            } else if (i3 != length) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            }
            if (i2 == -1) {
                if (obj instanceof StateObjectImpl) {
                    ((StateObjectImpl) obj).m396recordReadInh_f27i8$runtime(2);
                }
                IntMath.m897addimpl(m394getValueToScopesafanTW4(), obj, obj2);
            }
        }

        public final void removeObservation(Object obj, Object obj2) {
            IntMath.m902removeimpl(m394getValueToScopesafanTW4(), obj2, obj);
            if (!(obj2 instanceof DerivedSnapshotState) || m394getValueToScopesafanTW4().containsKey(obj2)) {
                return;
            }
            IntMath.m903removeScopeimpl(this.dependencyToDerivedStates, obj2);
            this.recordedDerivedStateValues.remove(obj2);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00b2  */
        public final void removeScopeIf(ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            MutableScatterMap scopeToValues = getScopeToValues();
            long[] jArr3 = scopeToValues.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j3 = jArr3[i2];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j3 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Object obj = scopeToValues.keys[i6];
                            c = c2;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) scopeToValues.values[i6];
                            j2 = j4;
                            Boolean bool = (Boolean) composedModifierKt$$ExternalSyntheticLambda0.invoke(obj);
                            if (bool.booleanValue()) {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j3;
                                    int i8 = 0;
                                    while (true) {
                                        long j5 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        if ((((~j5) << c) & j5 & j2) != j2) {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            int i10 = 0;
                                            while (i10 < i9) {
                                                if ((j5 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                }
                                                i10++;
                                                j5 >>= i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                        }
                                        if (i8 == length2) {
                                            break;
                                        }
                                        i8++;
                                        jArr4 = jArr5;
                                        i7 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j3;
                                }
                            } else {
                                jArr2 = jArr3;
                                j = j3;
                            }
                            if (bool.booleanValue()) {
                                scopeToValues.removeValueAt(i6);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            j = j3;
                            c = c2;
                            j2 = j4;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j3 = j >> i;
                        c2 = c;
                        j4 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }
    }

    public SnapshotStateObserver(Function1 function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:25:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0076 A[Catch: all -> 0x0095, LOOP:1: B:14:0x002f->B:26:0x0076, LOOP_END, TryCatch #0 {all -> 0x0095, blocks: (B:4:0x0007, B:8:0x0011, B:27:0x007a, B:32:0x0087, B:37:0x0097, B:34:0x008c, B:11:0x0023, B:14:0x002f, B:16:0x0043, B:18:0x0051, B:20:0x005b, B:22:0x006b, B:26:0x0076, B:38:0x009b), top: B:43:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x007a A[EDGE_INSN: B:50:0x007a->B:27:0x007a BREAK  A[LOOP:1: B:14:0x002f->B:26:0x0076], SYNTHETIC] */
    public final void clear(Object obj) {
        int i;
        synchronized (this.observedScopeMapsLock) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int i2 = mutableVector.size;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    Object[] objArr = mutableVector.content;
                    if (i3 < i2) {
                        ObservedScopeMap observedScopeMap = (ObservedScopeMap) objArr[i3];
                        MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) observedScopeMap.getScopeToValues().remove(obj);
                        if (mutableObjectIntMap == null) {
                            i = i3;
                        } else {
                            Object[] objArr2 = mutableObjectIntMap.keys;
                            int[] iArr = mutableObjectIntMap.values;
                            long[] jArr = mutableObjectIntMap.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i5 = 0;
                                while (true) {
                                    long j = jArr[i5];
                                    i = i3;
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                                        for (int i7 = 0; i7 < i6; i7++) {
                                            if ((j & 255) < 128) {
                                                int i8 = (i5 << 3) + i7;
                                                Object obj2 = objArr2[i8];
                                                int i9 = iArr[i8];
                                                observedScopeMap.removeObservation(obj, obj2);
                                            }
                                            j >>= 8;
                                        }
                                        if (i6 != 8) {
                                            break;
                                        }
                                        if (i5 != length) {
                                            break;
                                        }
                                        i5++;
                                        i3 = i;
                                    } else if (i5 != length) {
                                        break;
                                        break;
                                    } else {
                                        i5++;
                                        i3 = i;
                                    }
                                }
                            } else {
                                i = i3;
                            }
                        }
                        if (!(observedScopeMap.getScopeToValues()._size != 0)) {
                            i4++;
                        } else if (i4 > 0) {
                            Object[] objArr3 = mutableVector.content;
                            objArr3[i - i4] = objArr3[i];
                        }
                        i3 = i + 1;
                    } else {
                        int i10 = i2 - i4;
                        Arrays.fill(objArr, i10, i2, (Object) null);
                        mutableVector.size = i10;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean drainChanges() {
        boolean z;
        Set set;
        Set set2;
        synchronized (this.observedScopeMapsLock) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            AtomicReference atomicReference = this.pendingChanges;
            while (true) {
                Object obj = atomicReference.get();
                set = null;
                Object obj2 = null;
                Object objSubList = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof Set) {
                    set2 = (Set) obj;
                } else {
                    if (!(obj instanceof List)) {
                        ComposerKt.composeRuntimeError("Unexpected notification");
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                        return false;
                    }
                    List list = (List) obj;
                    Set set3 = (Set) list.get(0);
                    if (list.size() == 2) {
                        objSubList = list.get(1);
                    } else if (list.size() > 2) {
                        objSubList = list.subList(1, list.size());
                    }
                    set2 = set3;
                    obj2 = objSubList;
                }
                do {
                    if (atomicReference.compareAndSet(obj, obj2)) {
                        set = set2;
                        break;
                    }
                } while (atomicReference.get() == obj);
            }
            if (set == null) {
                return z2;
            }
            synchronized (this.observedScopeMapsLock) {
                MutableVector mutableVector = this.observedScopeMaps;
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    z2 = ((ObservedScopeMap) objArr[i2]).recordInvalidation(set) || z2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x021e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x01db  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void observeReads(Object obj, Function1 function1, Function0 function0) {
        MutableVector mutableVector;
        Object obj2;
        ObservedScopeMap observedScopeMap;
        boolean z;
        ObservedScopeMap observedScopeMap2;
        long j;
        long j2;
        ObservedScopeMap observedScopeMap3;
        Snapshot transparentObserverMutableSnapshot;
        long j3;
        MutableObjectIntMap mutableObjectIntMap;
        int i;
        long j4;
        MutableObjectIntMap mutableObjectIntMap2;
        long jCurrentThreadId = Expect_jvmKt.currentThreadId();
        synchronized (this.observedScopeMapsLock) {
            mutableVector = this.observedScopeMaps;
            Object[] objArr = mutableVector.content;
            int i2 = mutableVector.size;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    obj2 = null;
                    break;
                }
                obj2 = objArr[i3];
                if (((ObservedScopeMap) obj2).onChanged == function1) {
                    break;
                } else {
                    i3++;
                }
            }
            observedScopeMap = (ObservedScopeMap) obj2;
            z = true;
            if (observedScopeMap == null) {
                function1.getClass();
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function1);
                observedScopeMap = new ObservedScopeMap(function1);
                mutableVector.add(observedScopeMap);
            }
            observedScopeMap2 = this.currentMap;
            j = this.currentMapThreadId;
        }
        Object obj3 = mutableVector;
        if (j != -1 && j != jCurrentThreadId) {
            obj3 = mutableVector;
            String name = Thread.currentThread().getName();
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "Detected multithreaded access to SnapshotStateObserver: previousThreadId=", "), currentThread={id=");
            sbM.append(jCurrentThreadId);
            sbM.append(", name=");
            sbM.append(name);
            sbM.append("}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            PreconditionsKt.throwIllegalArgumentException(sbM.toString());
            obj3 = sbM;
        }
        try {
            obj3 = mutableVector;
            synchronized (this.observedScopeMapsLock) {
                try {
                    this.currentMap = observedScopeMap;
                    this.currentMapThreadId = jCurrentThreadId;
                } catch (Throwable th) {
                    th = th;
                    j2 = obj3;
                }
            }
            TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = this.readObserver;
            Object obj4 = observedScopeMap.currentScope;
            MutableObjectIntMap mutableObjectIntMap3 = observedScopeMap.currentScopeReads;
            int i4 = observedScopeMap.currentToken;
            observedScopeMap.currentScope = obj;
            observedScopeMap.currentScopeReads = (MutableObjectIntMap) observedScopeMap.getScopeToValues().get(obj);
            if (observedScopeMap.currentToken == -1) {
                observedScopeMap.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }
            GapComposer$derivedStateObserver$1 gapComposer$derivedStateObserver$1 = observedScopeMap.derivedStateObserver;
            MutableVector mutableVectorDerivedStateObservers = SnapshotStateKt__DerivedStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(gapComposer$derivedStateObserver$1);
                if (textKt$$ExternalSyntheticLambda2 == null) {
                    function0.invoke();
                    observedScopeMap3 = observedScopeMap;
                } else {
                    Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
                    if (snapshot instanceof TransparentObserverMutableSnapshot) {
                        observedScopeMap3 = observedScopeMap;
                        if (((TransparentObserverMutableSnapshot) snapshot).threadId == Expect_jvmKt.currentThreadId()) {
                            Function1 function2 = ((TransparentObserverMutableSnapshot) snapshot).readObserver;
                            Function1 function3 = ((TransparentObserverMutableSnapshot) snapshot).writeObserver;
                            try {
                                ((TransparentObserverMutableSnapshot) snapshot).readObserver = SnapshotKt.mergedReadObserver(textKt$$ExternalSyntheticLambda2, function2, true);
                                ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function3;
                                function0.invoke();
                                ((TransparentObserverMutableSnapshot) snapshot).readObserver = function2;
                                ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function3;
                            } catch (Throwable th2) {
                                ((TransparentObserverMutableSnapshot) snapshot).readObserver = function2;
                                ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function3;
                                throw th2;
                            }
                        }
                    } else {
                        observedScopeMap3 = observedScopeMap;
                    }
                    if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                        transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, textKt$$ExternalSyntheticLambda2, null, true, false);
                    } else {
                        transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(textKt$$ExternalSyntheticLambda2);
                    }
                    try {
                        Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                        try {
                            function0.invoke();
                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                            transparentObserverMutableSnapshot.dispose();
                        } catch (Throwable th3) {
                            try {
                                Snapshot.restoreCurrent(snapshotMakeCurrent);
                                throw th3;
                            } catch (Throwable th4) {
                                th = th4;
                                try {
                                    transparentObserverMutableSnapshot.dispose();
                                    throw th;
                                } catch (Throwable th5) {
                                    th = th5;
                                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.size - 1);
                ObservedScopeMap observedScopeMap4 = observedScopeMap3;
                Object obj5 = observedScopeMap4.currentScope;
                obj5.getClass();
                int i5 = observedScopeMap4.currentToken;
                MutableObjectIntMap mutableObjectIntMap4 = observedScopeMap4.currentScopeReads;
                if (mutableObjectIntMap4 != null) {
                    try {
                        long[] jArr = mutableObjectIntMap4.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i6 = 0;
                            while (true) {
                                long j5 = jArr[i6];
                                boolean z2 = z;
                                MutableObjectIntMap mutableObjectIntMap5 = mutableObjectIntMap4;
                                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                                    int i8 = 0;
                                    while (i8 < i7) {
                                        if ((j5 & 255) < 128) {
                                            i = i8;
                                            int i9 = (i6 << 3) + i;
                                            j4 = j5;
                                            mutableObjectIntMap2 = mutableObjectIntMap5;
                                            Object obj6 = mutableObjectIntMap2.keys[i9];
                                            j3 = j;
                                            try {
                                                boolean z3 = mutableObjectIntMap2.values[i9] != i5 ? z2 : false;
                                                if (z3) {
                                                    observedScopeMap4.removeObservation(obj5, obj6);
                                                }
                                                if (z3) {
                                                    mutableObjectIntMap2.removeValueAt(i9);
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                j2 = j3;
                                                synchronized (this.observedScopeMapsLock) {
                                                    this.currentMap = observedScopeMap2;
                                                    this.currentMapThreadId = j2;
                                                }
                                                throw th;
                                            }
                                        } else {
                                            i = i8;
                                            j4 = j5;
                                            mutableObjectIntMap2 = mutableObjectIntMap5;
                                            j3 = j;
                                        }
                                        i8 = i + 1;
                                        long j6 = j3;
                                        mutableObjectIntMap5 = mutableObjectIntMap2;
                                        j5 = j4 >> 8;
                                        j = j6;
                                    }
                                    mutableObjectIntMap = mutableObjectIntMap5;
                                    j3 = j;
                                    if (i7 != 8) {
                                        break;
                                    }
                                } else {
                                    mutableObjectIntMap = mutableObjectIntMap5;
                                    j3 = j;
                                }
                                if (i6 == length) {
                                    break;
                                }
                                i6++;
                                mutableObjectIntMap4 = mutableObjectIntMap;
                                z = z2;
                                j = j3;
                            }
                        } else {
                            j3 = j;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        j3 = j;
                        j2 = j3;
                        synchronized (this.observedScopeMapsLock) {
                            this.currentMap = observedScopeMap2;
                            this.currentMapThreadId = j2;
                            throw th;
                        }
                    }
                } else {
                    j3 = j;
                }
                observedScopeMap4.currentScope = obj4;
                observedScopeMap4.currentScopeReads = mutableObjectIntMap3;
                observedScopeMap4.currentToken = i4;
                synchronized (this.observedScopeMapsLock) {
                    this.currentMap = observedScopeMap2;
                    this.currentMapThreadId = j3;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        } catch (Throwable th10) {
            th = th10;
            j2 = j;
        }
    }

    public final void start() {
        ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0 = this.applyObserver;
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus(composerKt$$ExternalSyntheticLambda0, SnapshotKt.applyObservers);
        }
        this.applyUnsubscribe = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 3, (Object) composerKt$$ExternalSyntheticLambda0);
    }

    public final void clear() {
        synchronized (this.observedScopeMapsLock) {
            MutableVector mutableVector = this.observedScopeMaps;
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ObservedScopeMap observedScopeMap = (ObservedScopeMap) objArr[i2];
                observedScopeMap.m394getValueToScopesafanTW4().clear();
                observedScopeMap.getScopeToValues().clear();
                observedScopeMap.dependencyToDerivedStates.clear();
                observedScopeMap.recordedDerivedStateValues.clear();
            }
        }
    }
}
