package androidx.compose.runtime;

import android.os.Trace;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.MutableSetWrapper;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.node.UiApplier;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionImpl implements Composition {
    public final MutableSetWrapper abandonSet;
    public final UiApplier applier;
    public final ChangeList changes;
    public Function2 composable;
    public final GapComposer composer;
    public final MutableScatterSet conditionallyInvalidatedScopes;
    public final MutableScatterMap derivedStates;
    public final MutableScatterSet invalidatedScopes;
    public CompositionImpl invalidationDelegate;
    public int invalidationDelegateGroup;
    public MutableScatterMap invalidations;
    public final ChangeList lateChanges;
    public final MutableScatterMap observations;
    public final MutableScatterMap observationsProcessed;
    public final DrawResult observerHolder;
    public final CompositionContext parent;
    public boolean pendingInvalidScopes;
    public PausedCompositionImpl pendingPausedComposition;
    public final RememberEventDispatcher rememberManager;
    public ShouldPauseCallback shouldPause;
    public final SlotTable slotStorage;
    public byte state;
    public final AtomicReference pendingModifications = new AtomicReference(null);
    public final Object lock = new Object();

    public CompositionImpl(CompositionContext compositionContext, UiApplier uiApplier) {
        this.parent = compositionContext;
        this.applier = uiApplier;
        MutableSetWrapper mutableSetWrapper = new MutableSetWrapper(new MutableScatterSet());
        this.abandonSet = mutableSetWrapper;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable.calledByMap = new MutableIntObjectMap();
        }
        if (compositionContext.getCollectingSourceInformation$runtime()) {
            slotTable.collectSourceInformation();
        }
        this.slotStorage = slotTable;
        this.observations = IntMath.m899constructorimpl$default();
        this.invalidatedScopes = new MutableScatterSet();
        this.conditionallyInvalidatedScopes = new MutableScatterSet();
        this.derivedStates = IntMath.m899constructorimpl$default();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = IntMath.m899constructorimpl$default();
        this.invalidations = IntMath.m899constructorimpl$default();
        DrawResult drawResult = new DrawResult((byte) 19, (Object) compositionContext);
        this.observerHolder = drawResult;
        this.rememberManager = new RememberEventDispatcher();
        GapComposer gapComposer = new GapComposer(uiApplier, compositionContext, SlotTableKt.asGapBufferSlotTable(slotTable), mutableSetWrapper, changeList, changeList2, drawResult, this);
        compositionContext.registerComposer$runtime(gapComposer);
        this.composer = gapComposer;
        ComposableLambdaImpl composableLambdaImpl = Stack.lambda$954879418;
    }

    public final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        MutableSetWrapper mutableSetWrapper = this.abandonSet;
        if (mutableSetWrapper.parent$1.isEmpty()) {
            return;
        }
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(mutableSetWrapper, this.composer.getErrorContext$runtime());
            rememberEventDispatcher.dispatchAbandons();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x0122 A[EDGE_INSN: B:220:0x0122->B:215:0x0122 BREAK  A[LOOP:13: B:63:0x0151->B:74:0x0185], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0185 A[LOOP:13: B:63:0x0151->B:74:0x0185, LOOP_END] */
    public final void addPendingInvalidationsLocked(Set set, boolean z) {
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        long[] jArr2;
        long j4;
        boolean zContains;
        long[] jArr3;
        long j5;
        long[] jArr4;
        long[] jArr5;
        long j6;
        boolean zIsEmpty;
        long[] jArr6;
        long j7;
        long[] jArr7;
        long[] jArr8;
        char c2;
        long j8;
        int i;
        int i2;
        boolean z2 = set instanceof ScatterSetWrapper;
        MutableScatterMap mutableScatterMap = this.derivedStates;
        Object obj = null;
        int i3 = 8;
        if (z2) {
            MutableScatterSet mutableScatterSet = ((ScatterSetWrapper) set).set;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr9 = mutableScatterSet.metadata;
            int length = jArr9.length - 2;
            if (length >= 0) {
                int i4 = 0;
                j = 128;
                j2 = 255;
                while (true) {
                    long j9 = jArr9[i4];
                    char c3 = 7;
                    j3 = -9187201950435737472L;
                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((j9 & 255) < 128) {
                                Object obj2 = objArr[(i4 << 3) + i6];
                                c2 = c3;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                } else {
                                    addPendingInvalidationsLocked(obj2, z);
                                    Object obj3 = mutableScatterMap.get(obj2);
                                    if (obj3 != null) {
                                        if (obj3 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj3;
                                            Object[] objArr2 = mutableScatterSet2.elements;
                                            long[] jArr10 = mutableScatterSet2.metadata;
                                            int length2 = jArr10.length - 2;
                                            if (length2 >= 0) {
                                                int i7 = i3;
                                                i = length;
                                                int i8 = 0;
                                                while (true) {
                                                    long j10 = jArr10[i8];
                                                    j8 = j9;
                                                    long[] jArr11 = jArr10;
                                                    if ((((~j10) << c2) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                                        int i10 = 0;
                                                        while (i10 < i9) {
                                                            if ((j10 & 255) < 128) {
                                                                addPendingInvalidationsLocked((DerivedSnapshotState) objArr2[(i8 << 3) + i10], z);
                                                            }
                                                            j10 >>= i7;
                                                            i10++;
                                                            jArr9 = jArr9;
                                                        }
                                                        jArr8 = jArr9;
                                                        if (i9 != i7) {
                                                            break;
                                                        }
                                                    } else {
                                                        jArr8 = jArr9;
                                                    }
                                                    if (i8 == length2) {
                                                        break;
                                                    }
                                                    i8++;
                                                    jArr10 = jArr11;
                                                    j9 = j8;
                                                    jArr9 = jArr8;
                                                    i7 = 8;
                                                }
                                            }
                                        } else {
                                            jArr8 = jArr9;
                                            j8 = j9;
                                            i = length;
                                            addPendingInvalidationsLocked((DerivedSnapshotState) obj3, z);
                                        }
                                    }
                                    i2 = 8;
                                }
                                jArr8 = jArr9;
                                j8 = j9;
                                i = length;
                                i2 = 8;
                            } else {
                                jArr8 = jArr9;
                                c2 = c3;
                                j8 = j9;
                                i = length;
                                i2 = i3;
                            }
                            j9 = j8 >> i2;
                            i6++;
                            length = i;
                            i3 = i2;
                            c3 = c2;
                            jArr9 = jArr8;
                            obj = null;
                        }
                        jArr7 = jArr9;
                        c = c3;
                        int i11 = length;
                        if (i5 != i3) {
                            break;
                        } else {
                            length = i11;
                        }
                    } else {
                        jArr7 = jArr9;
                        c = 7;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    jArr9 = jArr7;
                    obj = null;
                    i3 = 8;
                }
            } else {
                j = 128;
                j2 = 255;
                j3 = -9187201950435737472L;
                c = 7;
            }
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
            c = 7;
            for (Object obj4 : set) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj4, z);
                    Object obj5 = mutableScatterMap.get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj5;
                            Object[] objArr3 = mutableScatterSet3.elements;
                            long[] jArr12 = mutableScatterSet3.metadata;
                            int length3 = jArr12.length - 2;
                            if (length3 >= 0) {
                                int i12 = 0;
                                while (true) {
                                    long j11 = jArr12[i12];
                                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i12 != length3) {
                                            break;
                                            break;
                                        }
                                        i12++;
                                    } else {
                                        int i13 = 8 - ((~(i12 - length3)) >>> 31);
                                        for (int i14 = 0; i14 < i13; i14++) {
                                            if ((j11 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedSnapshotState) objArr3[(i12 << 3) + i14], z);
                                            }
                                            j11 >>= 8;
                                        }
                                        if (i13 != 8) {
                                            break;
                                        } else if (i12 != length3) {
                                            break;
                                        } else {
                                            i12++;
                                        }
                                    }
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedSnapshotState) obj5, z);
                        }
                    }
                }
            }
        }
        MutableScatterMap mutableScatterMap2 = this.observations;
        MutableScatterSet mutableScatterSet4 = this.invalidatedScopes;
        if (z) {
            MutableScatterSet mutableScatterSet5 = this.conditionallyInvalidatedScopes;
            if (mutableScatterSet5.isNotEmpty()) {
                long[] jArr13 = mutableScatterMap2.metadata;
                int length4 = jArr13.length - 2;
                if (length4 >= 0) {
                    int i15 = 0;
                    while (true) {
                        long j12 = jArr13[i15];
                        if ((((~j12) << c) & j12 & j3) != j3) {
                            int i16 = 8 - ((~(i15 - length4)) >>> 31);
                            int i17 = 0;
                            while (i17 < i16) {
                                if ((j12 & j2) < j) {
                                    int i18 = (i15 << 3) + i17;
                                    Object obj6 = mutableScatterMap2.keys[i18];
                                    Object obj7 = mutableScatterMap2.values[i18];
                                    if (obj7 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj7;
                                        Object[] objArr4 = mutableScatterSet6.elements;
                                        long[] jArr14 = mutableScatterSet6.metadata;
                                        int length5 = jArr14.length - 2;
                                        if (length5 >= 0) {
                                            j6 = j12;
                                            int i19 = 0;
                                            while (true) {
                                                long j13 = jArr14[i19];
                                                Object[] objArr5 = objArr4;
                                                long[] jArr15 = jArr14;
                                                if ((((~j13) << c) & j13 & j3) != j3) {
                                                    int i20 = 8 - ((~(i19 - length5)) >>> 31);
                                                    int i21 = 0;
                                                    while (i21 < i20) {
                                                        if ((j13 & j2) < j) {
                                                            jArr6 = jArr13;
                                                            int i22 = (i19 << 3) + i21;
                                                            j7 = j13;
                                                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr5[i22];
                                                            if (mutableScatterSet5.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                                mutableScatterSet6.removeElementAt(i22);
                                                            }
                                                        } else {
                                                            jArr6 = jArr13;
                                                            j7 = j13;
                                                        }
                                                        j13 = j7 >> 8;
                                                        i21++;
                                                        jArr13 = jArr6;
                                                    }
                                                    jArr5 = jArr13;
                                                    if (i20 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    jArr5 = jArr13;
                                                }
                                                if (i19 == length5) {
                                                    break;
                                                }
                                                i19++;
                                                objArr4 = objArr5;
                                                jArr14 = jArr15;
                                                jArr13 = jArr5;
                                            }
                                        } else {
                                            jArr5 = jArr13;
                                            j6 = j12;
                                        }
                                        zIsEmpty = mutableScatterSet6.isEmpty();
                                    } else {
                                        jArr5 = jArr13;
                                        j6 = j12;
                                        obj7.getClass();
                                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj7;
                                        zIsEmpty = mutableScatterSet5.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                                    }
                                    if (zIsEmpty) {
                                        mutableScatterMap2.removeValueAt(i18);
                                    }
                                } else {
                                    jArr5 = jArr13;
                                    j6 = j12;
                                }
                                j12 = j6 >> 8;
                                i17++;
                                jArr13 = jArr5;
                            }
                            jArr4 = jArr13;
                            if (i16 != 8) {
                                break;
                            }
                        } else {
                            jArr4 = jArr13;
                        }
                        if (i15 == length4) {
                            break;
                        }
                        i15++;
                        jArr13 = jArr4;
                    }
                }
                mutableScatterSet5.clear();
                cleanUpDerivedStateObservations();
                return;
            }
        }
        if (mutableScatterSet4.isNotEmpty()) {
            long[] jArr16 = mutableScatterMap2.metadata;
            int length6 = jArr16.length - 2;
            if (length6 >= 0) {
                int i23 = 0;
                while (true) {
                    long j14 = jArr16[i23];
                    if ((((~j14) << c) & j14 & j3) != j3) {
                        int i24 = 8 - ((~(i23 - length6)) >>> 31);
                        int i25 = 0;
                        while (i25 < i24) {
                            if ((j14 & j2) < j) {
                                int i26 = (i23 << 3) + i25;
                                Object obj8 = mutableScatterMap2.keys[i26];
                                Object obj9 = mutableScatterMap2.values[i26];
                                if (obj9 instanceof MutableScatterSet) {
                                    MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj9;
                                    Object[] objArr6 = mutableScatterSet7.elements;
                                    long[] jArr17 = mutableScatterSet7.metadata;
                                    int length7 = jArr17.length - 2;
                                    if (length7 >= 0) {
                                        j4 = j14;
                                        int i27 = 0;
                                        while (true) {
                                            long j15 = jArr17[i27];
                                            Object[] objArr7 = objArr6;
                                            long[] jArr18 = jArr17;
                                            if ((((~j15) << c) & j15 & j3) != j3) {
                                                int i28 = 8 - ((~(i27 - length7)) >>> 31);
                                                int i29 = 0;
                                                while (i29 < i28) {
                                                    if ((j15 & j2) < j) {
                                                        jArr3 = jArr16;
                                                        int i30 = (i27 << 3) + i29;
                                                        j5 = j15;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr7[i30])) {
                                                            mutableScatterSet7.removeElementAt(i30);
                                                        }
                                                    } else {
                                                        jArr3 = jArr16;
                                                        j5 = j15;
                                                    }
                                                    j15 = j5 >> 8;
                                                    i29++;
                                                    jArr16 = jArr3;
                                                }
                                                jArr2 = jArr16;
                                                if (i28 != 8) {
                                                    break;
                                                }
                                            } else {
                                                jArr2 = jArr16;
                                            }
                                            if (i27 == length7) {
                                                break;
                                            }
                                            i27++;
                                            objArr6 = objArr7;
                                            jArr17 = jArr18;
                                            jArr16 = jArr2;
                                        }
                                    } else {
                                        jArr2 = jArr16;
                                        j4 = j14;
                                    }
                                    zContains = mutableScatterSet7.isEmpty();
                                } else {
                                    jArr2 = jArr16;
                                    j4 = j14;
                                    obj9.getClass();
                                    zContains = mutableScatterSet4.contains((RecomposeScopeImpl) obj9);
                                }
                                if (zContains) {
                                    mutableScatterMap2.removeValueAt(i26);
                                }
                            } else {
                                jArr2 = jArr16;
                                j4 = j14;
                            }
                            j14 = j4 >> 8;
                            i25++;
                            jArr16 = jArr2;
                        }
                        jArr = jArr16;
                        if (i24 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr16;
                    }
                    if (i23 == length6) {
                        break;
                    }
                    i23++;
                    jArr16 = jArr;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }

    public final void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:160:0x0136 A[EDGE_INSN: B:160:0x0136->B:78:0x0136 BREAK  A[LOOP:2: B:146:0x00e9->B:76:0x012c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x012c A[Catch: all -> 0x011c, LOOP:2: B:146:0x00e9->B:76:0x012c, LOOP_END, TryCatch #6 {all -> 0x011c, blocks: (B:60:0x00e9, B:62:0x00f8, B:64:0x0102, B:66:0x0108, B:68:0x0118, B:72:0x0121, B:78:0x0136, B:86:0x0158, B:89:0x016b, B:76:0x012c, B:81:0x0140, B:95:0x0189, B:97:0x0195), top: B:146:0x00e9 }] */
    public final void applyChangesInLocked(ChangeList changeList) throws Throwable {
        RememberEventDispatcher rememberEventDispatcher;
        long[] jArr;
        int i;
        long[] jArr2;
        RememberEventDispatcher rememberEventDispatcher2;
        long j;
        char c;
        long j2;
        int i2;
        boolean zIsEmpty;
        long j3;
        ChangeList changeList2 = this.lateChanges;
        GapComposer gapComposer = this.composer;
        CompositionErrorContextImpl errorContext$runtime = gapComposer.getErrorContext$runtime();
        RememberEventDispatcher rememberEventDispatcher3 = this.rememberManager;
        rememberEventDispatcher3.prepare(this.abandonSet, errorContext$runtime);
        try {
            if (changeList.operations.isEmpty()) {
                try {
                    if (changeList2.operations.isEmpty() && this.pendingPausedComposition == null) {
                        rememberEventDispatcher3.dispatchAbandons();
                    }
                    return;
                } finally {
                    rememberEventDispatcher3.clear();
                }
            }
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            Applier applier = pausedCompositionImpl != null ? pausedCompositionImpl.pausableApplier : this.applier;
            try {
                Trace.beginSection(applier.equals(pausedCompositionImpl != null ? pausedCompositionImpl.pausableApplier : null) ? "Compose:recordChanges" : "Compose:applyChanges");
                try {
                    PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                    RememberEventDispatcher rememberEventDispatcher4 = pausedCompositionImpl2 != null ? pausedCompositionImpl2.rememberManager : rememberEventDispatcher3;
                    SlotTable slotTable = this.slotStorage;
                    CompositionErrorContextImpl errorContext$runtime2 = gapComposer.getErrorContext$runtime();
                    SlotWriter slotWriterOpenWriter = SlotTableKt.asGapBufferSlotTable(slotTable).openWriter();
                    int i3 = 0;
                    try {
                        changeList.executeAndFlushAllPendingChanges(applier, slotWriterOpenWriter, rememberEventDispatcher4, errorContext$runtime2);
                        slotWriterOpenWriter.close(true);
                        applier.onEndChanges();
                        Trace.endSection();
                        rememberEventDispatcher3.dispatchRememberObservers();
                        rememberEventDispatcher3.dispatchSideEffects();
                        if (this.pendingInvalidScopes) {
                            Trace.beginSection("Compose:unobserve");
                            try {
                                this.pendingInvalidScopes = false;
                                MutableScatterMap mutableScatterMap = this.observations;
                                long[] jArr3 = mutableScatterMap.metadata;
                                int length = jArr3.length - 2;
                                if (length >= 0) {
                                    int i4 = 0;
                                    while (true) {
                                        long j4 = jArr3[i4];
                                        char c2 = 7;
                                        long j5 = -9187201950435737472L;
                                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i5 = 8;
                                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                                            int i7 = i3;
                                            while (i7 < i6) {
                                                if ((j4 & 255) < 128) {
                                                    c = c2;
                                                    int i8 = (i4 << 3) + i7;
                                                    j2 = j5;
                                                    Object obj = mutableScatterMap.keys[i8];
                                                    Object obj2 = mutableScatterMap.values[i8];
                                                    if (obj2 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                        Object[] objArr = mutableScatterSet.elements;
                                                        long[] jArr4 = mutableScatterSet.metadata;
                                                        int i9 = i5;
                                                        int length2 = jArr4.length - 2;
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        rememberEventDispatcher2 = rememberEventDispatcher3;
                                                        if (length2 >= 0) {
                                                            int i10 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j6 = jArr4[i10];
                                                                    j = j4;
                                                                    long[] jArr5 = jArr4;
                                                                    if ((((~j6) << c) & j6 & j2) == j2) {
                                                                        if (i10 != length2) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        jArr4 = jArr5;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    } else {
                                                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                                        for (int i12 = 0; i12 < i11; i12++) {
                                                                            if ((j6 & 255) < 128) {
                                                                                j3 = j6;
                                                                                int i13 = (i10 << 3) + i12;
                                                                                if (!((RecomposeScopeImpl) objArr[i13]).getValid()) {
                                                                                    mutableScatterSet.removeElementAt(i13);
                                                                                }
                                                                            } else {
                                                                                j3 = j6;
                                                                            }
                                                                            j6 = j3 >> i9;
                                                                        }
                                                                        if (i11 != i9) {
                                                                            break;
                                                                        }
                                                                        if (i10 != length2) {
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        jArr4 = jArr5;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    }
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    Trace.endSection();
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            j = j4;
                                                        }
                                                        zIsEmpty = mutableScatterSet.isEmpty();
                                                    } else {
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        rememberEventDispatcher2 = rememberEventDispatcher3;
                                                        j = j4;
                                                        obj2.getClass();
                                                        zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                    }
                                                    if (zIsEmpty) {
                                                        mutableScatterMap.removeValueAt(i8);
                                                    }
                                                    i2 = 8;
                                                } else {
                                                    i = i7;
                                                    jArr2 = jArr3;
                                                    rememberEventDispatcher2 = rememberEventDispatcher3;
                                                    j = j4;
                                                    c = c2;
                                                    j2 = j5;
                                                    i2 = i5;
                                                }
                                                j4 = j >> i2;
                                                i7 = i + 1;
                                                i5 = i2;
                                                c2 = c;
                                                j5 = j2;
                                                rememberEventDispatcher3 = rememberEventDispatcher2;
                                                jArr3 = jArr2;
                                            }
                                            jArr = jArr3;
                                            rememberEventDispatcher = rememberEventDispatcher3;
                                            if (i6 != i5) {
                                                break;
                                            }
                                        } else {
                                            jArr = jArr3;
                                            rememberEventDispatcher = rememberEventDispatcher3;
                                        }
                                        if (i4 == length) {
                                            break;
                                        }
                                        i4++;
                                        rememberEventDispatcher3 = rememberEventDispatcher;
                                        jArr3 = jArr;
                                        i3 = 0;
                                    }
                                } else {
                                    rememberEventDispatcher = rememberEventDispatcher3;
                                }
                                cleanUpDerivedStateObservations();
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            rememberEventDispatcher = rememberEventDispatcher3;
                        }
                        try {
                            if (changeList2.operations.isEmpty() && this.pendingPausedComposition == null) {
                                rememberEventDispatcher.dispatchAbandons();
                            }
                            return;
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    } catch (Throwable th3) {
                        try {
                            slotWriterOpenWriter.close(false);
                            throw th3;
                        } catch (Throwable th4) {
                            th = th4;
                            Trace.endSection();
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        try {
            if (changeList2.operations.isEmpty() && this.pendingPausedComposition == null) {
                rememberEventDispatcher3.dispatchAbandons();
            }
            throw th;
        } finally {
            rememberEventDispatcher3.clear();
        }
    }

    public final void applyLateChanges() {
        synchronized (this.lock) {
            try {
                ChangeList changeList = this.lateChanges;
                changeList.getClass();
                if (!changeList.operations.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    public final void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.providerUpdates = null;
                if (!this.abandonSet.parent$1.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th) {
                        rememberEventDispatcher.clear();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher2 = this.rememberManager;
                        try {
                            rememberEventDispatcher2.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher2.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher2.clear();
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    public final void cleanUpDerivedStateObservations() {
        long j;
        char c;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        long j4;
        char c2;
        long j5;
        long j6;
        int i3;
        boolean zIsEmpty;
        int i4;
        int i5;
        MutableScatterMap mutableScatterMap = this.derivedStates;
        long[] jArr3 = mutableScatterMap.metadata;
        int length = jArr3.length - 2;
        long j7 = 255;
        char c3 = 7;
        long j8 = -9187201950435737472L;
        int i6 = 8;
        if (length >= 0) {
            int i7 = 0;
            while (true) {
                long j9 = jArr3[i7];
                j3 = 128;
                if ((((~j9) << c3) & j9 & j8) != j8) {
                    int i8 = 8 - ((~(i7 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j9 & j7) < 128) {
                            j4 = j7;
                            int i10 = (i7 << 3) + i9;
                            Object obj = mutableScatterMap.keys[i10];
                            Object obj2 = mutableScatterMap.values[i10];
                            c2 = c3;
                            boolean z = obj2 instanceof MutableScatterSet;
                            j5 = j8;
                            MutableScatterMap mutableScatterMap2 = this.observations;
                            if (z) {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    int i11 = i6;
                                    j6 = j9;
                                    int i12 = 0;
                                    while (true) {
                                        long j10 = jArr4[i12];
                                        jArr2 = jArr3;
                                        i = length;
                                        if ((((~j10) << c2) & j10 & j5) != j5) {
                                            int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                            int i14 = 0;
                                            while (i14 < i13) {
                                                if ((j10 & j4) < 128) {
                                                    i4 = i14;
                                                    int i15 = (i12 << 3) + i4;
                                                    i5 = i9;
                                                    if (!mutableScatterMap2.containsKey((DerivedSnapshotState) objArr[i15])) {
                                                        mutableScatterSet.removeElementAt(i15);
                                                    }
                                                } else {
                                                    i4 = i14;
                                                    i5 = i9;
                                                }
                                                j10 >>= i11;
                                                i14 = i4 + 1;
                                                i9 = i5;
                                            }
                                            i2 = i9;
                                            if (i13 != i11) {
                                                break;
                                            }
                                        } else {
                                            i2 = i9;
                                        }
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12++;
                                        jArr3 = jArr2;
                                        length = i;
                                        i9 = i2;
                                        i11 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    i = length;
                                    i2 = i9;
                                    j6 = j9;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr3;
                                i = length;
                                i2 = i9;
                                j6 = j9;
                                obj2.getClass();
                                zIsEmpty = !mutableScatterMap2.containsKey((DerivedSnapshotState) obj2);
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i10);
                            }
                            i3 = 8;
                        } else {
                            jArr2 = jArr3;
                            i = length;
                            i2 = i9;
                            j4 = j7;
                            c2 = c3;
                            j5 = j8;
                            j6 = j9;
                            i3 = i6;
                        }
                        j9 = j6 >> i3;
                        i9 = i2 + 1;
                        i6 = i3;
                        c3 = c2;
                        j7 = j4;
                        j8 = j5;
                        jArr3 = jArr2;
                        length = i;
                    }
                    jArr = jArr3;
                    int i16 = length;
                    j = j7;
                    c = c3;
                    j2 = j8;
                    if (i8 != i6) {
                        break;
                    } else {
                        length = i16;
                    }
                } else {
                    jArr = jArr3;
                    j = j7;
                    c = c3;
                    j2 = j8;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                c3 = c;
                j7 = j;
                j8 = j2;
                jArr3 = jArr;
                i6 = 8;
            }
        } else {
            j = 255;
            c = 7;
            j2 = -9187201950435737472L;
            j3 = 128;
        }
        MutableScatterSet mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        if (!mutableScatterSet2.isNotEmpty()) {
            return;
        }
        Object[] objArr2 = mutableScatterSet2.elements;
        long[] jArr5 = mutableScatterSet2.metadata;
        int length3 = jArr5.length - 2;
        if (length3 < 0) {
            return;
        }
        int i17 = 0;
        while (true) {
            long j11 = jArr5[i17];
            if ((((~j11) << c) & j11 & j2) != j2) {
                int i18 = 8 - ((~(i17 - length3)) >>> 31);
                for (int i19 = 0; i19 < i18; i19++) {
                    if ((j11 & j) < j3) {
                        int i20 = (i17 << 3) + i19;
                        if (((RecomposeScopeImpl) objArr2[i20]).trackedDependencies == null) {
                            mutableScatterSet2.removeElementAt(i20);
                        }
                    }
                    j11 >>= 8;
                }
                if (i18 != 8) {
                    return;
                }
            }
            if (i17 == length3) {
                return;
            } else {
                i17++;
            }
        }
    }

    public final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = (byte) 0;
            }
        }
        return z;
    }

    public final void composeContent(Function2 function2) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap mutableScatterMap = this.invalidations;
                this.invalidations = IntMath.m899constructorimpl$default();
                try {
                    GapComposer gapComposer = this.composer;
                    ShouldPauseCallback shouldPauseCallback = this.shouldPause;
                    if (!gapComposer.changes.operations.isEmpty()) {
                        ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
                    }
                    gapComposer.shouldPauseCallback = shouldPauseCallback;
                    try {
                        gapComposer.m383doComposeaFTiNEg(mutableScatterMap, function2);
                        gapComposer.shouldPauseCallback = null;
                    } catch (Throwable th) {
                        gapComposer.shouldPauseCallback = null;
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.invalidations = mutableScatterMap;
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                if (!this.abandonSet.parent$1.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                throw th3;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final PausedCompositionImpl composeInitialPaused(boolean z, Function2 function2) {
        if (this.pendingPausedComposition != null) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, function2, z, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    public final void deactivate() {
        synchronized (this.lock) {
            try {
                if (this.pendingPausedComposition != null) {
                    PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
                }
                boolean z = this.slotStorage.groupsSize == 0;
                if (!z || !this.abandonSet.parent$1.isEmpty()) {
                    Trace.beginSection("Compose:deactivate");
                    try {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            if (!z) {
                                SlotTable slotTable = this.slotStorage;
                                RememberEventDispatcher rememberEventDispatcher2 = this.rememberManager;
                                SlotWriter slotWriterOpenWriter = slotTable.openWriter();
                                try {
                                    slotWriterOpenWriter.forAllDataInRememberOrder(slotWriterOpenWriter.currentGroup, new ButtonKt$$ExternalSyntheticLambda1(rememberEventDispatcher2, slotWriterOpenWriter, (byte) 26));
                                    slotWriterOpenWriter.close(true);
                                    this.applier.onEndChanges();
                                    rememberEventDispatcher.dispatchRememberObservers();
                                } catch (Throwable th) {
                                    slotWriterOpenWriter.close(false);
                                    throw th;
                                }
                            }
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                            Trace.endSection();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                this.observations.clear();
                this.derivedStates.clear();
                this.invalidations.clear();
                this.changes.clear();
                this.lateChanges.clear();
                GapComposer gapComposer = this.composer;
                gapComposer.invalidateStack.clear();
                gapComposer.invalidations.clear();
                gapComposer.changes.clear();
                gapComposer.providerUpdates = null;
                this.state = (byte) 1;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void dispose() {
        synchronized (this.lock) {
            try {
                if (this.composer.isComposing) {
                    PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (this.state != 3) {
                    this.state = (byte) 3;
                    this.composable = Stack.lambda$1918065384;
                    ChangeList changeList = this.composer.deferredChanges;
                    if (changeList != null) {
                        applyChangesInLocked(changeList);
                    }
                    byte b = 0;
                    boolean z = this.slotStorage.groupsSize == 0;
                    if (!z || !this.abandonSet.parent$1.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            if (!z) {
                                SlotTable slotTable = this.slotStorage;
                                RememberEventDispatcher rememberEventDispatcher2 = this.rememberManager;
                                SlotWriter slotWriterOpenWriter = slotTable.openWriter();
                                try {
                                    slotWriterOpenWriter.forAllDataInRememberOrder(slotWriterOpenWriter.currentGroup, new ComposerKt$$ExternalSyntheticLambda0(b, rememberEventDispatcher2));
                                    slotWriterOpenWriter.removeGroup();
                                    slotWriterOpenWriter.close(true);
                                    this.applier.clear();
                                    this.applier.onEndChanges();
                                    rememberEventDispatcher.dispatchRememberObservers();
                                } catch (Throwable th) {
                                    slotWriterOpenWriter.close(false);
                                    throw th;
                                }
                            }
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    this.observationsProcessed.clear();
                    GapComposer gapComposer = this.composer;
                    gapComposer.getClass();
                    Trace.beginSection("Compose:Composer.dispose");
                    try {
                        gapComposer.parentContext.unregisterComposer$runtime(gapComposer);
                        gapComposer.invalidateStack.clear();
                        gapComposer.invalidations.clear();
                        gapComposer.changes.clear();
                        gapComposer.providerUpdates = null;
                        gapComposer.applier.clear();
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        this.parent.unregisterComposition$runtime(this);
    }

    public final void drainPendingModificationsForCompositionLocked() {
        Object obj = Stack.PendingApplyNoModifications;
        AtomicReference atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (andSet.equals(obj)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return;
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return;
            }
            for (Set set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    public final void drainPendingModificationsLocked() {
        AtomicReference atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(null);
        if (Intrinsics.areEqual(andSet, Stack.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            if (this.pendingPausedComposition == null) {
                ComposerKt.composeImmediateRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        }
    }

    public final void drainPendingModificationsOutOfBandLocked() {
        EmptySet emptySet = EmptySet.INSTANCE;
        AtomicReference atomicReference = this.pendingModifications;
        Object andSet = atomicReference.getAndSet(emptySet);
        if (Intrinsics.areEqual(andSet, Stack.PendingApplyNoModifications) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + atomicReference);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return;
        }
        for (Set set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    public final void ensureRunning() {
        String str;
        byte b = this.state;
        if (b != 0) {
            if (b == 1) {
                str = "The composition should be activated before setting content.";
            } else if (b != 2) {
                str = b != 3 ? "" : "The composition is disposed";
            } else {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            }
            PreconditionsKt.throwIllegalStateException(str);
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    public final void insertMovableContent(ArrayList arrayList) {
        MutableSetWrapper mutableSetWrapper = this.abandonSet;
        GapComposer gapComposer = this.composer;
        if (arrayList.size() > 0) {
            ((MovableContentStateReference) ((Pair) arrayList.get(0)).first).getClass();
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            gapComposer.getClass();
            Trace.beginSection("Compose:insertMovableContent");
            try {
                try {
                    gapComposer.insertMovableContentGuarded(arrayList);
                    gapComposer.cleanUpCompose();
                    Trace.endSection();
                } catch (Throwable th) {
                    gapComposer.abortRoot();
                    throw th;
                }
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                if (!mutableSetWrapper.parent$1.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(mutableSetWrapper, gapComposer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                throw th3;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionImpl compositionImpl;
        int i = recomposeScopeImpl.flags;
        if ((i & 2) != 0) {
            recomposeScopeImpl.flags = i | 4;
        }
        GapAnchor gapAnchor = recomposeScopeImpl.anchor;
        if (gapAnchor == null || !gapAnchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        SlotTable slotTable = this.slotStorage;
        slotTable.getClass();
        GapAnchor gapAnchor2 = recomposeScopeImpl.anchor;
        if (gapAnchor2 != null && slotTable.ownsAnchor(FileSystemsKt.asGapAnchor(gapAnchor2))) {
            if (recomposeScopeImpl.block == null) {
                return InvalidationResult.IGNORED;
            }
            InvalidationResult invalidationResultInvalidateChecked = invalidateChecked(recomposeScopeImpl, gapAnchor, obj);
            if (invalidationResultInvalidateChecked != InvalidationResult.IGNORED) {
                this.observerHolder.current();
            }
            return invalidationResultInvalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null) {
            GapComposer gapComposer = compositionImpl.composer;
            if (gapComposer.isComposing && gapComposer.tryImminentInvalidation$runtime(recomposeScopeImpl, obj)) {
                return InvalidationResult.IMMINENT;
            }
        }
        return InvalidationResult.IGNORED;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c1 A[Catch: all -> 0x0044, LOOP:0: B:48:0x008a->B:60:0x00c1, LOOP_END, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0009, B:6:0x000e, B:8:0x0016, B:10:0x001d, B:14:0x0027, B:16:0x0031, B:13:0x0022, B:25:0x0049, B:27:0x004f, B:32:0x005a, B:36:0x0060, B:37:0x0068, B:40:0x006e, B:41:0x0074, B:43:0x007a, B:45:0x007e, B:48:0x008a, B:50:0x009a, B:52:0x00a6, B:54:0x00af, B:57:0x00b9, B:60:0x00c1, B:61:0x00c4, B:64:0x00c9), top: B:77:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00c9 A[Catch: all -> 0x0044, EDGE_INSN: B:64:0x00c9->B:65:0x00ce BREAK  A[LOOP:0: B:48:0x008a->B:60:0x00c1], TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0009, B:6:0x000e, B:8:0x0016, B:10:0x001d, B:14:0x0027, B:16:0x0031, B:13:0x0022, B:25:0x0049, B:27:0x004f, B:32:0x005a, B:36:0x0060, B:37:0x0068, B:40:0x006e, B:41:0x0074, B:43:0x007a, B:45:0x007e, B:48:0x008a, B:50:0x009a, B:52:0x00a6, B:54:0x00af, B:57:0x00b9, B:60:0x00c1, B:61:0x00c4, B:64:0x00c9), top: B:77:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00c9 A[SYNTHETIC] */
    public final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, GapAnchor gapAnchor, Object obj) {
        synchronized (this.lock) {
            try {
                CompositionImpl compositionImpl = this.invalidationDelegate;
                CompositionImpl compositionImpl2 = null;
                if (compositionImpl != null) {
                    SlotTable slotTable = this.slotStorage;
                    int i = this.invalidationDelegateGroup;
                    if (slotTable.writer) {
                        ComposerKt.composeImmediateRuntimeError("Writer is active");
                    }
                    if (i < 0 || i >= slotTable.groupsSize) {
                        ComposerKt.composeImmediateRuntimeError("Invalid group index");
                    }
                    GapAnchor gapAnchorAsGapAnchor = FileSystemsKt.asGapAnchor(gapAnchor);
                    if (slotTable.ownsAnchor(gapAnchorAsGapAnchor)) {
                        int i2 = slotTable.groups[(i * 5) + 3] + i;
                        int i3 = gapAnchorAsGapAnchor.location;
                        if (i > i3 || i3 >= i2) {
                            compositionImpl = null;
                        }
                    } else {
                        compositionImpl = null;
                    }
                    compositionImpl2 = compositionImpl;
                }
                if (compositionImpl2 == null) {
                    GapComposer gapComposer = this.composer;
                    if (gapComposer.isComposing && gapComposer.tryImminentInvalidation$runtime(recomposeScopeImpl, obj)) {
                        return InvalidationResult.IMMINENT;
                    }
                    if (obj != null) {
                        boolean z = obj instanceof DerivedSnapshotState;
                        MutableScatterMap mutableScatterMap = this.invalidations;
                        if (z) {
                            Object obj2 = mutableScatterMap.get(recomposeScopeImpl);
                            if (obj2 == null) {
                                IntMath.m897addimpl(this.invalidations, recomposeScopeImpl, obj);
                                break;
                            }
                            if (obj2 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    IntMath.m897addimpl(this.invalidations, recomposeScopeImpl, obj);
                                    break;
                                }
                                int i4 = 0;
                                loop0: while (true) {
                                    long j = jArr[i4];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                                        for (int i6 = 0; i6 < i5; i6++) {
                                            if ((255 & j) < 128 && objArr[(i4 << 3) + i6] == NeverEqualPolicy.INSTANCE$2) {
                                                break loop0;
                                            }
                                            j >>= 8;
                                        }
                                        if (i5 == 8) {
                                            if (i4 == length) {
                                                i4++;
                                            }
                                        }
                                        IntMath.m897addimpl(this.invalidations, recomposeScopeImpl, obj);
                                        break;
                                    }
                                    if (i4 == length) {
                                        IntMath.m897addimpl(this.invalidations, recomposeScopeImpl, obj);
                                        break;
                                    }
                                    i4++;
                                }
                            } else {
                                if (obj2 != NeverEqualPolicy.INSTANCE$2) {
                                    IntMath.m897addimpl(this.invalidations, recomposeScopeImpl, obj);
                                    break;
                                }
                            }
                        } else {
                            mutableScatterMap.set(recomposeScopeImpl, NeverEqualPolicy.INSTANCE$2);
                        }
                    } else {
                        this.invalidations.set(recomposeScopeImpl, NeverEqualPolicy.INSTANCE$2);
                    }
                }
                if (compositionImpl2 != null) {
                    return compositionImpl2.invalidateChecked(recomposeScopeImpl, gapAnchor, obj);
                }
                this.parent.invalidate$runtime(this);
                return this.composer.isComposing ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidateScopeOfLocked(Object obj) {
        Object obj2 = this.observations.get(obj);
        if (obj2 == null) {
            return;
        }
        boolean z = obj2 instanceof MutableScatterSet;
        InvalidationResult invalidationResult = InvalidationResult.IMMINENT;
        MutableScatterMap mutableScatterMap = this.observationsProcessed;
        if (!z) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
            if (recomposeScopeImpl.invalidateForResult(obj) != invalidationResult || (obj instanceof DerivedSnapshotState)) {
                return;
            }
            IntMath.m897addimpl(mutableScatterMap, obj, recomposeScopeImpl);
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                        if (recomposeScopeImpl2.invalidateForResult(obj) == invalidationResult && !(obj instanceof DerivedSnapshotState)) {
                            IntMath.m897addimpl(mutableScatterMap, obj, recomposeScopeImpl2);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[LOOP:0: B:7:0x001c->B:21:0x005b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x007b A[SYNTHETIC] */
    public final boolean observesAnyOf(Set set) {
        boolean z = set instanceof ScatterSetWrapper;
        MutableScatterMap mutableScatterMap = this.derivedStates;
        MutableScatterMap mutableScatterMap2 = this.observations;
        if (z) {
            MutableScatterSet mutableScatterSet = ((ScatterSetWrapper) set).set;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (mutableScatterMap2.containsKey(obj) || mutableScatterMap.containsKey(obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
                return true;
            }
        } else {
            for (Object obj2 : set) {
                if (mutableScatterMap2.containsKey(obj2) || mutableScatterMap.containsKey(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            boolean z = false;
            if (pausedCompositionImpl != null && (pausedCompositionImpl.state.get() != PausedCompositionState.Recomposing || pausedCompositionImpl.owningThread != Expect_jvmKt.currentThreadId())) {
                AtomicReference atomicReference = pausedCompositionImpl.state;
                PausedCompositionState pausedCompositionState = PausedCompositionState.ApplyPending;
                PausedCompositionState pausedCompositionState2 = PausedCompositionState.RecomposePending;
                while (!atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2) && atomicReference.get() == pausedCompositionState) {
                }
                pausedCompositionImpl.pausableApplier.operations.add(9);
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                MutableScatterMap mutableScatterMap = this.invalidations;
                this.invalidations = IntMath.m899constructorimpl$default();
                try {
                    GapComposer gapComposer = this.composer;
                    ShouldPauseCallback shouldPauseCallback = this.shouldPause;
                    Operations operations = gapComposer.changes.operations;
                    if (!operations.isEmpty()) {
                        ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
                    }
                    if (mutableScatterMap._size > 0 || !gapComposer.invalidations.isEmpty()) {
                        gapComposer.shouldPauseCallback = shouldPauseCallback;
                        try {
                            gapComposer.m383doComposeaFTiNEg(mutableScatterMap, null);
                            gapComposer.shouldPauseCallback = null;
                            z = !operations.isEmpty();
                        } catch (Throwable th) {
                            gapComposer.shouldPauseCallback = null;
                            throw th;
                        }
                    }
                    if (!z) {
                        drainPendingModificationsLocked();
                    }
                    return z;
                } catch (Throwable th2) {
                    this.invalidations = mutableScatterMap;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    if (!this.abandonSet.parent$1.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                        } finally {
                            rememberEventDispatcher.clear();
                        }
                    }
                    throw th3;
                } catch (Throwable th4) {
                    abandonChanges();
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void recordModificationsOf(ScatterSetWrapper scatterSetWrapper) {
        Object obj;
        while (true) {
            Object obj2 = this.pendingModifications.get();
            if (obj2 == null || obj2.equals(Stack.PendingApplyNoModifications)) {
                obj = scatterSetWrapper;
            } else if (obj2 instanceof Set) {
                obj = new Set[]{obj2, scatterSetWrapper};
            } else {
                if (!(obj2 instanceof Object[])) {
                    PathKt$$ExternalSyntheticBUOutline0.m((Object) this.pendingModifications, "corrupt pendingModifications: ");
                    return;
                }
                Set[] setArr = (Set[]) obj2;
                int length = setArr.length;
                Object[] objArrCopyOf = Arrays.copyOf(setArr, length + 1);
                objArrCopyOf[length] = scatterSetWrapper;
                obj = objArrCopyOf;
            }
            AtomicReference atomicReference = this.pendingModifications;
            do {
                if (atomicReference.compareAndSet(obj2, obj)) {
                    if (obj2 == null) {
                        synchronized (this.lock) {
                            drainPendingModificationsLocked();
                        }
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5 A[LOOP:0: B:30:0x0077->B:45:0x00c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c8 A[EDGE_INSN: B:52:0x00c8->B:46:0x00c8 BREAK  A[LOOP:0: B:30:0x0077->B:45:0x00c5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public final void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        int i;
        boolean z;
        GapComposer gapComposer = this.composer;
        if (gapComposer.childrenComposing <= 0 && (currentRecomposeScope$runtime = gapComposer.getCurrentRecomposeScope$runtime()) != null) {
            currentRecomposeScope$runtime.setUsed();
            if ((currentRecomposeScope$runtime.flags & 32) == 0) {
                MutableObjectIntMap mutableObjectIntMap = currentRecomposeScope$runtime.trackedInstances;
                if (mutableObjectIntMap == null) {
                    mutableObjectIntMap = new MutableObjectIntMap();
                    currentRecomposeScope$runtime.trackedInstances = mutableObjectIntMap;
                }
                int i2 = currentRecomposeScope$runtime.currentToken;
                int iFindIndex = mutableObjectIntMap.findIndex(obj);
                if (iFindIndex < 0) {
                    iFindIndex = ~iFindIndex;
                    i = -1;
                } else {
                    i = mutableObjectIntMap.values[iFindIndex];
                }
                mutableObjectIntMap.keys[iFindIndex] = obj;
                mutableObjectIntMap.values[iFindIndex] = i2;
                if (i == currentRecomposeScope$runtime.currentToken) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.observerHolder.current();
            if (z) {
                return;
            }
            if (obj instanceof StateObjectImpl) {
                ((StateObjectImpl) obj).m396recordReadInh_f27i8$runtime(1);
            }
            IntMath.m897addimpl(this.observations, obj, currentRecomposeScope$runtime);
            if (obj instanceof DerivedSnapshotState) {
                DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) obj;
                DerivedSnapshotState.ResultRecord currentRecord = derivedSnapshotState.getCurrentRecord();
                MutableScatterMap mutableScatterMap = this.derivedStates;
                IntMath.m903removeScopeimpl(mutableScatterMap, obj);
                MutableObjectIntMap mutableObjectIntMap2 = currentRecord.dependencies;
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
                            int i4 = 8;
                            int i5 = 8 - ((~(i3 - length)) >>> 31);
                            int i6 = 0;
                            while (i6 < i5) {
                                if ((j & 255) < 128) {
                                    StateObject stateObject = (StateObject) objArr[(i3 << 3) + i6];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).m396recordReadInh_f27i8$runtime(1);
                                    }
                                    IntMath.m897addimpl(mutableScatterMap, stateObject, obj);
                                }
                                j >>= i4;
                                i6++;
                                i4 = i4;
                            }
                            if (i5 != i4) {
                                break;
                            } else if (i3 != length) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                Object obj2 = currentRecord.result;
                MutableScatterMap mutableScatterMap2 = currentRecomposeScope$runtime.trackedDependencies;
                if (mutableScatterMap2 == null) {
                    mutableScatterMap2 = new MutableScatterMap();
                    currentRecomposeScope$runtime.trackedDependencies = mutableScatterMap2;
                }
                mutableScatterMap2.set(derivedSnapshotState, obj2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[Catch: all -> 0x004f, LOOP:0: B:11:0x001f->B:23:0x0059, LOOP_END, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:11:0x001f, B:13:0x002f, B:15:0x003b, B:17:0x0044, B:20:0x0051, B:23:0x0059, B:24:0x005c), top: B:29:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0061 A[EDGE_INSN: B:31:0x0061->B:25:0x0061 BREAK  A[LOOP:0: B:11:0x001f->B:23:0x0059], SYNTHETIC] */
    public final void recordWriteOf(Object obj) {
        synchronized (this.lock) {
            try {
                invalidateScopeOfLocked(obj);
                Object obj2 = this.derivedStates.get(obj);
                if (obj2 != null) {
                    if (obj2 instanceof MutableScatterSet) {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                        Object[] objArr = mutableScatterSet.elements;
                        long[] jArr = mutableScatterSet.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                    if (i != length) {
                                        break;
                                        break;
                                    }
                                    i++;
                                } else {
                                    int i2 = 8 - ((~(i - length)) >>> 31);
                                    for (int i3 = 0; i3 < i2; i3++) {
                                        if ((255 & j) < 128) {
                                            invalidateScopeOfLocked((DerivedSnapshotState) objArr[(i << 3) + i3]);
                                        }
                                        j >>= 8;
                                    }
                                    if (i2 != 8) {
                                        break;
                                    } else if (i != length) {
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        }
                    } else {
                        invalidateScopeOfLocked((DerivedSnapshotState) obj2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setContent(Function2 function2) {
        boolean zClearDeactivated = clearDeactivated();
        ensureRunning();
        CompositionContext compositionContext = this.parent;
        if (!zClearDeactivated) {
            this.composable = function2;
            compositionContext.composeInitial$runtime(this, function2);
            return;
        }
        GapComposer gapComposer = this.composer;
        gapComposer.reusingGroup = 0;
        gapComposer.reusing = true;
        this.composable = function2;
        compositionContext.composeInitial$runtime(this, function2);
        if (gapComposer.isComposing || gapComposer.reusingGroup != 0) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        gapComposer.reusingGroup = -1;
        gapComposer.reusing = false;
    }

    public final void addPendingInvalidationsLocked(Object obj, boolean z) {
        Object obj2 = this.observations.get(obj);
        if (obj2 == null) {
            return;
        }
        boolean z2 = obj2 instanceof MutableScatterSet;
        InvalidationResult invalidationResult = InvalidationResult.IGNORED;
        MutableScatterSet mutableScatterSet = this.invalidatedScopes;
        MutableScatterSet mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        MutableScatterMap mutableScatterMap = this.observationsProcessed;
        if (z2) {
            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
            Object[] objArr = mutableScatterSet3.elements;
            long[] jArr = mutableScatterSet3.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!IntMath.m902removeimpl(mutableScatterMap, obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != invalidationResult) {
                                if (recomposeScopeImpl.trackedDependencies != null && !z) {
                                    mutableScatterSet2.add(recomposeScopeImpl);
                                } else {
                                    mutableScatterSet.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (IntMath.m902removeimpl(mutableScatterMap, obj, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(obj) == invalidationResult) {
                return;
            }
            if (recomposeScopeImpl2.trackedDependencies != null && !z) {
                mutableScatterSet2.add(recomposeScopeImpl2);
            } else {
                mutableScatterSet.add(recomposeScopeImpl2);
            }
        }
    }
}
