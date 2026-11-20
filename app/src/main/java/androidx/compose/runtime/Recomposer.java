package androidx.compose.runtime;

import android.util.Log;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.WeakCache;
import androidx.emoji2.text.EmojiProcessor;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.ImageLoader$Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    public final ArrayList _knownCompositions;
    public List _knownCompositionsCache;
    public final StateFlowImpl _state;
    public final BroadcastFrameClock broadcastFrameClock;
    public Throwable closeCause;
    public final MutableVector compositionInvalidations;
    public final ArrayList compositionsAwaitingApply;
    public MutableScatterSet compositionsRemoved;
    public final CoroutineContext effectCoroutineContext;
    public final JobImpl effectJob;
    public final StateFlowImpl errorState;
    public ArrayList failedCompositions;
    public boolean frameClockPaused;
    public final ArrayList movableContentAwaitingInsert;
    public final MutableScatterMap movableContentNestedExtractionsPending;
    public final WeakCache movableContentNestedStatesAvailable;
    public final MutableScatterMap movableContentRemoved;
    public final MutableScatterMap movableContentStatesAvailable;
    public final EmojiProcessor nextFrameEndCallbackQueue;
    public final EmojiProcessor pausedScopes;
    public final NeverEqualPolicy recomposerInfo;
    public Job runnerJob;
    public MutableScatterSet snapshotInvalidations;
    public final Object stateLock;
    public CancellableContinuationImpl workContinuation;
    public static final StateFlowImpl _runningRecomposers = StateFlowKt.MutableStateFlow(PersistentOrderedSet.EMPTY);
    public static final AtomicReference _hotReloadEnabled = new AtomicReference(Boolean.FALSE);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RecomposerErrorState {
        public final Throwable cause;

        public RecomposerErrorState(Throwable th) {
            this.cause = th;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static final State Idle;
        public static final State Inactive;
        public static final State InactivePendingWork;
        public static final State PendingWork;
        public static final State ShutDown;
        public static final State ShuttingDown;

        static {
            State state = new State("ShutDown", 0);
            ShutDown = state;
            State state2 = new State("ShuttingDown", 1);
            ShuttingDown = state2;
            State state3 = new State("Inactive", 2);
            Inactive = state3;
            State state4 = new State("InactivePendingWork", 3);
            InactivePendingWork = state4;
            State state5 = new State("Idle", 4);
            Idle = state5;
            State state6 = new State("PendingWork", 5);
            PendingWork = state6;
            $VALUES = new State[]{state, state2, state3, state4, state5, state6};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Recomposer$$ExternalSyntheticLambda1(this, (byte) 0));
        this.broadcastFrameClock = broadcastFrameClock;
        this.nextFrameEndCallbackQueue = new EmojiProcessor(new Recomposer$$ExternalSyntheticLambda1(this, (byte) 1));
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet();
        this.compositionInvalidations = new MutableVector(new CompositionImpl[16]);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = new MutableScatterMap();
        this.movableContentNestedStatesAvailable = new WeakCache((byte) 6);
        this.movableContentStatesAvailable = new MutableScatterMap();
        this.movableContentNestedExtractionsPending = new MutableScatterMap();
        this.errorState = StateFlowKt.MutableStateFlow(null);
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new EmojiProcessor((byte) 6);
        JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        jobImpl.invokeOnCompletion(new TextKt$$ExternalSyntheticLambda2((byte) 11, this));
        this.effectJob = jobImpl;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(jobImpl);
        this.recomposerInfo = new NeverEqualPolicy((byte) 8);
    }

    public static void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult$Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
            mutableSnapshot.dispose();
        } catch (Throwable th) {
            mutableSnapshot.dispose();
            throw th;
        }
    }

    public static final void performInitialMovableContentInserts$fillToInsert(ArrayList arrayList, Recomposer recomposer, CompositionImpl compositionImpl) {
        arrayList.clear();
        synchronized (recomposer.stateLock) {
            Iterator it = recomposer.movableContentAwaitingInsert.iterator();
            if (it.hasNext()) {
                ((MovableContentStateReference) it.next()).getClass();
                throw null;
            }
        }
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (((State) this._state.getValue()).compareTo(State.Idle) >= 0) {
                StateFlowImpl stateFlowImpl = this._state;
                State state = State.ShuttingDown;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, state);
            }
        }
        this.effectJob.cancel(null);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void composeInitial$runtime(CompositionImpl compositionImpl, Function2 function2) throws Throwable {
        State state;
        boolean zContains;
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        boolean z = compositionImpl.composer.isComposing;
        synchronized (this.stateLock) {
            State state2 = (State) this._state.getValue();
            state = State.ShuttingDown;
            zContains = state2.compareTo(state) > 0 ? true ^ knownCompositionsLocked().contains(compositionImpl) : true;
        }
        try {
            TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 10, compositionImpl);
            ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0((Object) compositionImpl, (Object) null, (byte) 22);
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(textKt$$ExternalSyntheticLambda2, zIndexNode$$ExternalSyntheticLambda0)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                try {
                    compositionImpl.composeContent(function2);
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                    synchronized (this.stateLock) {
                        if (((State) this._state.getValue()).compareTo(state) > 0 && !knownCompositionsLocked().contains(compositionImpl)) {
                            this._knownCompositions.add(compositionImpl);
                            this._knownCompositionsCache = null;
                        }
                    }
                    if (!z) {
                        SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
                    }
                    try {
                        performInitialMovableContentInserts(compositionImpl);
                        try {
                            compositionImpl.applyChanges();
                            compositionImpl.applyLateChanges();
                            if (z) {
                                return;
                            }
                            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
                        } catch (Throwable th) {
                            processCompositionError(th, null);
                        }
                    } catch (Throwable th2) {
                        processCompositionError(th2, compositionImpl);
                    }
                } catch (Throwable th3) {
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th3;
                }
            } catch (Throwable th4) {
                applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                throw th4;
            }
        } catch (Throwable th5) {
            if (zContains) {
                synchronized (this.stateLock) {
                }
            }
            processCompositionError(th5, compositionImpl);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MutableScatterSet composeInitialPaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, Function2 function2) {
        EmojiProcessor emojiProcessor = this.pausedScopes;
        try {
            ShouldPauseCallback shouldPauseCallback2 = compositionImpl.shouldPause;
            compositionImpl.shouldPause = shouldPauseCallback;
            try {
                composeInitial$runtime(compositionImpl, function2);
                MutableScatterSet mutableScatterSet = (MutableScatterSet) emojiProcessor.get();
                if (mutableScatterSet == null) {
                    mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                    mutableScatterSet.getClass();
                }
                compositionImpl.shouldPause = shouldPauseCallback2;
                emojiProcessor.set(null);
                return mutableScatterSet;
            } catch (Throwable th) {
                compositionImpl.shouldPause = shouldPauseCallback2;
                throw th;
            }
        } catch (Throwable th2) {
            emojiProcessor.set(null);
            throw th2;
        }
    }

    public final CancellableContinuation deriveStateLocked() {
        StateFlowImpl stateFlowImpl = this._state;
        int iCompareTo = ((State) stateFlowImpl.getValue()).compareTo(State.ShuttingDown);
        StateFlowImpl stateFlowImpl2 = this.errorState;
        ArrayList arrayList = this.movableContentAwaitingInsert;
        ArrayList arrayList2 = this.compositionsAwaitingApply;
        MutableVector mutableVector = this.compositionInvalidations;
        if (iCompareTo > 0) {
            Object value = stateFlowImpl2.getValue();
            State state = State.PendingWork;
            State state2 = State.Inactive;
            if (value == null) {
                if (this.runnerJob == null) {
                    this.snapshotInvalidations = new MutableScatterSet();
                    mutableVector.clear();
                    if (getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked()) {
                        state2 = State.InactivePendingWork;
                    }
                } else {
                    state2 = (mutableVector.size == 0 && !this.snapshotInvalidations.isNotEmpty() && arrayList2.isEmpty() && arrayList.isEmpty() && !getHasBroadcastFrameClockAwaitersLocked() && !getHasNextFrameEndAwaitersLocked() && this.movableContentRemoved._size == 0) ? State.Idle : state;
                }
            }
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, state2);
            if (state2 != state) {
                return null;
            }
            CancellableContinuationImpl cancellableContinuationImpl = this.workContinuation;
            this.workContinuation = null;
            return cancellableContinuationImpl;
        }
        List listKnownCompositionsLocked = knownCompositionsLocked();
        int size = listKnownCompositionsLocked.size();
        for (int i = 0; i < size; i++) {
        }
        this._knownCompositions.clear();
        this._knownCompositionsCache = EmptyList.INSTANCE;
        this.snapshotInvalidations = new MutableScatterSet();
        mutableVector.clear();
        arrayList2.clear();
        arrayList.clear();
        this.failedCompositions = null;
        CancellableContinuationImpl cancellableContinuationImpl2 = this.workContinuation;
        if (cancellableContinuationImpl2 != null) {
            cancellableContinuationImpl2.cancel(null);
        }
        this.workContinuation = null;
        stateFlowImpl2.setValue(null);
        return null;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && (((AtomicInt) ((ImageLoader$Builder) this.broadcastFrameClock.queue).memoryCacheLazy).get() & 134217727) > 0;
    }

    public final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.size != 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked() || this.movableContentRemoved._size != 0;
    }

    public final boolean getHasNextFrameEndAwaitersLocked() {
        return !this.frameClockPaused && (((AtomicInt) ((ImageLoader$Builder) this.nextFrameEndCallbackQueue.mMetadataRepo).memoryCacheLazy).get() & 134217727) > 0;
    }

    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.size != 0 || getHasBroadcastFrameClockAwaitersLocked() || getHasNextFrameEndAwaitersLocked();
        }
        return z;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void invalidate$runtime(CompositionImpl compositionImpl) {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(compositionImpl)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(compositionImpl);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
        }
    }

    public final List knownCompositionsLocked() {
        List list = this._knownCompositionsCache;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = this._knownCompositions;
        List arrayList2 = arrayList.isEmpty() ? EmptyList.INSTANCE : new ArrayList(arrayList);
        this._knownCompositionsCache = arrayList2;
        return arrayList2;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference) {
        MovableContentState movableContentState;
        synchronized (this.stateLock) {
            movableContentState = (MovableContentState) this.movableContentStatesAvailable.remove(movableContentStateReference);
        }
        return movableContentState;
    }

    public final void onNewFrameAwaiter() {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
            if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                throw AwaitKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", this.closeCause);
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
        }
    }

    public final void performInitialMovableContentInserts(CompositionImpl compositionImpl) {
        synchronized (this.stateLock) {
            ArrayList arrayList = this.movableContentAwaitingInsert;
            if (arrayList.size() > 0) {
                ((MovableContentStateReference) arrayList.get(0)).getClass();
                throw null;
            }
        }
    }

    public final List performInsertValues(List list, MutableScatterSet mutableScatterSet) {
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            ((MovableContentStateReference) obj).getClass();
            Object arrayList2 = map.get(null);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(null, arrayList2);
            }
            ((ArrayList) arrayList2).add(obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            CompositionImpl compositionImpl = (CompositionImpl) entry.getKey();
            List list2 = (List) entry.getValue();
            if (compositionImpl.composer.isComposing) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 10, compositionImpl);
            ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0((Object) compositionImpl, (Object) mutableScatterSet, (byte) 22);
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(textKt$$ExternalSyntheticLambda2, zIndexNode$$ExternalSyntheticLambda0)) == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot create a mutable snapshot of an read-only snapshot");
                return null;
            }
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        try {
                            arrayList = new ArrayList(list2.size());
                            int size2 = list2.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) list2.get(i2);
                                MutableScatterMap mutableScatterMap = this.movableContentRemoved;
                                movableContentStateReference.getClass();
                                Object objM391removeLastimpl = MultiValueMap.m391removeLastimpl(mutableScatterMap);
                                arrayList.add(new Pair(movableContentStateReference, objM391removeLastimpl));
                            }
                            int size3 = arrayList.size();
                            for (int i3 = 0; i3 < size3; i3++) {
                                Pair pair = (Pair) arrayList.get(i3);
                                if (pair.second == null) {
                                    WeakCache weakCache = this.movableContentNestedStatesAvailable;
                                    ((MovableContentStateReference) pair.first).getClass();
                                    if (((MutableScatterMap) weakCache.values).contains(null)) {
                                        ArrayList arrayList3 = new ArrayList(arrayList.size());
                                        int size4 = arrayList.size();
                                        for (int i4 = 0; i4 < size4; i4++) {
                                            Pair pair2 = (Pair) arrayList.get(i4);
                                            if (pair2.second == null) {
                                                WeakCache weakCache2 = this.movableContentNestedStatesAvailable;
                                                ((MovableContentStateReference) pair2.first).getClass();
                                                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) weakCache2.values;
                                                if (mutableScatterMap2.isEmpty()) {
                                                    ((MutableScatterMap) weakCache2.referenceQueue).clear();
                                                }
                                            }
                                            arrayList3.add(pair2);
                                        }
                                        arrayList = arrayList3;
                                        break;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    int size5 = arrayList.size();
                    for (int i5 = 0; i5 < size5; i5++) {
                        if (((Pair) arrayList.get(i5)).second != null) {
                            int size6 = arrayList.size();
                            for (int i6 = 0; i6 < size6; i6++) {
                                if (((Pair) arrayList.get(i6)).second == null) {
                                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                                    int size7 = arrayList.size();
                                    for (int i7 = 0; i7 < size7; i7++) {
                                        Pair pair3 = (Pair) arrayList.get(i7);
                                        if (pair3.second == null) {
                                        }
                                    }
                                    synchronized (this.stateLock) {
                                        CollectionsKt__MutableCollectionsKt.addAll(arrayList4, this.movableContentAwaitingInsert);
                                    }
                                    ArrayList arrayList5 = new ArrayList(arrayList.size());
                                    int size8 = arrayList.size();
                                    for (int i8 = 0; i8 < size8; i8++) {
                                        Object obj2 = arrayList.get(i8);
                                        if (((Pair) obj2).second != null) {
                                            arrayList5.add(obj2);
                                        }
                                    }
                                    arrayList = arrayList5;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    compositionImpl.insertMovableContent(arrayList);
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                } catch (Throwable th2) {
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th2;
                }
            } catch (Throwable th3) {
                applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                throw th3;
            }
        }
        return CollectionsKt.toList(map.keySet());
    }

    public final CompositionImpl performRecompose(CompositionImpl compositionImpl, MutableScatterSet mutableScatterSet) {
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        if (compositionImpl.composer.isComposing || compositionImpl.state == 3) {
            return null;
        }
        MutableScatterSet mutableScatterSet2 = this.compositionsRemoved;
        if (mutableScatterSet2 == null || !mutableScatterSet2.contains(compositionImpl)) {
            TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 10, compositionImpl);
            ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0((Object) compositionImpl, (Object) mutableScatterSet, (byte) 22);
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(textKt$$ExternalSyntheticLambda2, zIndexNode$$ExternalSyntheticLambda0)) == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot create a mutable snapshot of an read-only snapshot");
            } else {
                try {
                    Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                    if (mutableScatterSet != null) {
                        try {
                            if (mutableScatterSet.isNotEmpty()) {
                                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6((Object) mutableScatterSet, (Object) compositionImpl, (byte) 0);
                                GapComposer gapComposer = compositionImpl.composer;
                                if (gapComposer.isComposing) {
                                    ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
                                }
                                gapComposer.isComposing = true;
                                try {
                                    recomposer$$ExternalSyntheticLambda6.invoke();
                                    gapComposer.isComposing = false;
                                } catch (Throwable th) {
                                    gapComposer.isComposing = false;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                            throw th2;
                        }
                    }
                    boolean zRecompose = compositionImpl.recompose();
                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                    if (zRecompose) {
                        return compositionImpl;
                    }
                } catch (Throwable th3) {
                    applyAndCheck(mutableSnapshotTakeNestedMutableSnapshot);
                    throw th3;
                }
            }
        }
        return null;
    }

    public final void processCompositionError(Throwable th, CompositionImpl compositionImpl) throws Throwable {
        if (!((Boolean) _hotReloadEnabled.get()).booleanValue() || (th instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                Log.e("ComposeInternal", "Error was captured in composition.", th);
                RecomposerErrorState recomposerErrorState = (RecomposerErrorState) this.errorState.getValue();
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.cause;
                }
                StateFlowImpl stateFlowImpl = this.errorState;
                RecomposerErrorState recomposerErrorState2 = new RecomposerErrorState(th);
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, recomposerErrorState2);
            }
            throw th;
        }
        synchronized (this.stateLock) {
            Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", th);
            this.compositionsAwaitingApply.clear();
            this.compositionInvalidations.clear();
            this.snapshotInvalidations = new MutableScatterSet();
            this.movableContentAwaitingInsert.clear();
            this.movableContentRemoved.clear();
            this.movableContentStatesAvailable.clear();
            StateFlowImpl stateFlowImpl2 = this.errorState;
            RecomposerErrorState recomposerErrorState3 = new RecomposerErrorState(th);
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, recomposerErrorState3);
            if (compositionImpl != null) {
                while (compositionImpl != null) {
                    recordFailedCompositionLocked(compositionImpl);
                    CompositionContext compositionContext = compositionImpl.parent;
                    Composition composition$runtime = compositionContext != null ? compositionContext.getComposition$runtime() : null;
                    compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
                }
            }
            if (deriveStateLocked() != null) {
                ComposerKt.composeImmediateRuntimeError("expected to go to inactive state due to composition error");
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final MutableScatterSet recomposePaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, MutableScatterSet mutableScatterSet) {
        EmojiProcessor emojiProcessor = this.pausedScopes;
        try {
            recordComposerModifications();
            compositionImpl.recordModificationsOf(new ScatterSetWrapper(mutableScatterSet));
            ShouldPauseCallback shouldPauseCallback2 = compositionImpl.shouldPause;
            compositionImpl.shouldPause = shouldPauseCallback;
            try {
                CompositionImpl compositionImplPerformRecompose = performRecompose(compositionImpl, null);
                if (compositionImplPerformRecompose != null) {
                    performInitialMovableContentInserts(compositionImpl);
                    compositionImplPerformRecompose.applyChanges();
                    compositionImplPerformRecompose.applyLateChanges();
                }
                MutableScatterSet mutableScatterSet2 = (MutableScatterSet) emojiProcessor.get();
                if (mutableScatterSet2 == null) {
                    mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                    mutableScatterSet2.getClass();
                }
                compositionImpl.shouldPause = shouldPauseCallback2;
                emojiProcessor.set(null);
                return mutableScatterSet2;
            } catch (Throwable th) {
                compositionImpl.shouldPause = shouldPauseCallback2;
                throw th;
            }
        } catch (Throwable th2) {
            emojiProcessor.set(null);
            throw th2;
        }
    }

    public final boolean recordComposerModifications() {
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            List listKnownCompositionsLocked = knownCompositionsLocked();
            ScatterSetWrapper scatterSetWrapper = new ScatterSetWrapper(this.snapshotInvalidations);
            this.snapshotInvalidations = new MutableScatterSet();
            try {
                int size = listKnownCompositionsLocked.size();
                for (int i = 0; i < size; i++) {
                    ((CompositionImpl) listKnownCompositionsLocked.get(i)).recordModificationsOf(scatterSetWrapper);
                    if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    MutableScatterSet mutableScatterSet = this.snapshotInvalidations;
                    int i2 = mutableScatterSet._size;
                    Iterator<E> it = scatterSetWrapper.iterator();
                    while (it.hasNext()) {
                        mutableScatterSet.plusAssign(it.next());
                    }
                    throw th;
                }
            }
        }
    }

    public final void recordFailedCompositionLocked(CompositionImpl compositionImpl) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(compositionImpl)) {
            arrayList.add(compositionImpl);
        }
        if (this._knownCompositions.remove(compositionImpl)) {
            this._knownCompositionsCache = null;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl) {
        EmojiProcessor emojiProcessor = this.pausedScopes;
        MutableScatterSet mutableScatterSet = (MutableScatterSet) emojiProcessor.get();
        if (mutableScatterSet == null) {
            MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
            mutableScatterSet = new MutableScatterSet();
            emojiProcessor.set(mutableScatterSet);
        }
        mutableScatterSet.add(recomposeScopeImpl);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void reportRemovedComposition$runtime(CompositionImpl compositionImpl) {
        synchronized (this.stateLock) {
            try {
                MutableScatterSet mutableScatterSet = this.compositionsRemoved;
                if (mutableScatterSet == null) {
                    MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                    mutableScatterSet = new MutableScatterSet();
                    this.compositionsRemoved = mutableScatterSet;
                }
                mutableScatterSet.add(compositionImpl);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final CancellationHandle scheduleFrameEndCallback(RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0) {
        EmojiProcessor emojiProcessor = this.nextFrameEndCallbackQueue;
        ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) emojiProcessor.mMetadataRepo;
        NextFrameEndCallbackQueue$NextFrameEndAwaiter nextFrameEndCallbackQueue$NextFrameEndAwaiter = new NextFrameEndCallbackQueue$NextFrameEndAwaiter();
        nextFrameEndCallbackQueue$NextFrameEndAwaiter.onNextFrameEnd = roomDatabase$$ExternalSyntheticLambda0;
        return imageLoader$Builder.addAwaiter(nextFrameEndCallbackQueue$NextFrameEndAwaiter, (Recomposer$$ExternalSyntheticLambda6) emojiProcessor.mGlyphChecker);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public final void unregisterComposition$runtime(CompositionImpl compositionImpl) {
        synchronized (this.stateLock) {
            if (this._knownCompositions.remove(compositionImpl)) {
                this._knownCompositionsCache = null;
            }
            this.compositionInvalidations.remove(compositionImpl);
            this.compositionsAwaitingApply.remove(compositionImpl);
        }
    }
}
