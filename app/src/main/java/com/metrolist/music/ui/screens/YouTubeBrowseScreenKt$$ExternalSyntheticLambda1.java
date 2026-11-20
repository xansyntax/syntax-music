package com.metrolist.music.ui.screens;

import android.os.Trace;
import androidx.collection.MutableScatterSet;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.ImageLoader$Builder;
import com.metrolist.innertube.pages.BrowseResult;
import com.metrolist.innertubex.InnerTube$$ExternalSyntheticLambda2;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$11$1$1$1$1;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchResult;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeBrowseScreenKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;

    public /* synthetic */ YouTubeBrowseScreenKt$$ExternalSyntheticLambda1(MutableState mutableState, LocalSearchViewModel localSearchViewModel, MenuState menuState, Function0 function0, MutableState mutableState2, PlayerConnection playerConnection, String str, NavHostController navHostController, MutableState mutableState3) {
        this.f$5 = mutableState;
        this.f$0 = localSearchViewModel;
        this.f$3 = menuState;
        this.f$1 = function0;
        this.f$8 = mutableState2;
        this.f$6 = playerConnection;
        this.f$2 = str;
        this.f$7 = navHostController;
        this.f$4 = mutableState3;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x02a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x02a2 A[LOOP:6: B:270:0x0267->B:121:0x02a2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:156:0x032c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x032e A[LOOP:4: B:143:0x02ee->B:157:0x032e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:306:0x0334 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x02b6 A[SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean hasBroadcastFrameClockAwaitersLocked;
        int i;
        Unit unit;
        int i2;
        Snapshot transparentObserverSnapshot;
        Recomposer recomposer;
        long j;
        char c;
        boolean z;
        switch (this.$r8$classId) {
            case 0:
                List list = (List) this.f$0;
                MutableState mutableState = (MutableState) this.f$1;
                HapticFeedback hapticFeedback = (HapticFeedback) this.f$2;
                MenuState menuState = (MenuState) this.f$3;
                CoroutineScope coroutineScope = (CoroutineScope) this.f$4;
                State state = (State) this.f$5;
                PlayerConnection playerConnection = (PlayerConnection) this.f$6;
                NavHostController navHostController = (NavHostController) this.f$7;
                State state2 = (State) this.f$8;
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent.getClass();
                if (((BrowseResult) mutableState.getValue()) == null) {
                    LazyGridIntervalContent.items$default(lazyGridIntervalContent, 8, null, AlbumScreenKt.lambda$119295155, 14);
                }
                lazyGridIntervalContent.items(list.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 1), list, (byte) 25), null, new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 2), list, (byte) 26), new ComposableLambdaImpl(true, -1117249557, new YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(list, hapticFeedback, menuState, coroutineScope, state, playerConnection, navHostController, state2)));
                return Unit.INSTANCE;
            case 1:
                Unit unit2 = Unit.INSTANCE;
                Recomposer recomposer2 = (Recomposer) this.f$1;
                MutableScatterSet mutableScatterSet = (MutableScatterSet) this.f$2;
                MutableScatterSet mutableScatterSet2 = (MutableScatterSet) this.f$3;
                List list2 = (List) this.f$0;
                List list3 = (List) this.f$4;
                MutableScatterSet mutableScatterSet3 = (MutableScatterSet) this.f$5;
                List list4 = (List) this.f$8;
                MutableScatterSet mutableScatterSet4 = (MutableScatterSet) this.f$6;
                Set set = (Set) this.f$7;
                long jLongValue = ((Long) obj).longValue();
                StateFlowImpl stateFlowImpl = Recomposer._runningRecomposers;
                synchronized (recomposer2.stateLock) {
                    hasBroadcastFrameClockAwaitersLocked = recomposer2.getHasBroadcastFrameClockAwaitersLocked();
                }
                if (hasBroadcastFrameClockAwaitersLocked) {
                    Trace.beginSection("Recomposer:animation");
                    try {
                        i = 8;
                        ((ImageLoader$Builder) recomposer2.broadcastFrameClock.queue).flushAndDispatchAwaiters(new InnerTube$$ExternalSyntheticLambda2(jLongValue, (byte) 3));
                        synchronized (SnapshotKt.lock) {
                            MutableScatterSet mutableScatterSet5 = SnapshotKt.globalSnapshot.modified;
                            z = mutableScatterSet5 != null && mutableScatterSet5.isNotEmpty();
                        }
                        if (z) {
                            SnapshotKt.advanceGlobalSnapshot();
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    i = 8;
                }
                Trace.beginSection("Recomposer:recompose");
                try {
                    recomposer2.recordComposerModifications();
                    synchronized (recomposer2.stateLock) {
                        try {
                            MutableVector mutableVector = recomposer2.compositionInvalidations;
                            Object[] objArr = mutableVector.content;
                            int i3 = mutableVector.size;
                            for (int i4 = 0; i4 < i3; i4++) {
                                list2.add((CompositionImpl) objArr[i4]);
                            }
                            recomposer2.compositionInvalidations.clear();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    mutableScatterSet.clear();
                    mutableScatterSet2.clear();
                    while (true) {
                        if (list2.isEmpty() && list3.isEmpty()) {
                            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                            if (snapshotCurrentSnapshot instanceof MutableSnapshot) {
                                transparentObserverSnapshot = new TransparentObserverMutableSnapshot((MutableSnapshot) snapshotCurrentSnapshot, null, null, true, false);
                                i2 = 0;
                            } else {
                                i2 = 0;
                                transparentObserverSnapshot = new TransparentObserverSnapshot(snapshotCurrentSnapshot, null, true, false);
                            }
                            try {
                                Snapshot snapshotMakeCurrent = transparentObserverSnapshot.makeCurrent();
                                try {
                                    if (!list4.isEmpty()) {
                                        try {
                                            int size = list4.size();
                                            for (int i5 = i2; i5 < size; i5++) {
                                                mutableScatterSet4.add((CompositionImpl) list4.get(i5));
                                            }
                                            int size2 = list4.size();
                                            for (int i6 = i2; i6 < size2; i6++) {
                                                ((CompositionImpl) list4.get(i6)).applyChanges();
                                            }
                                            list4.clear();
                                        } catch (Throwable th3) {
                                            try {
                                                recomposer2.processCompositionError(th3, null);
                                                Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer2, list2, list3, list4, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                                list4.clear();
                                                Snapshot.restoreCurrent(snapshotMakeCurrent);
                                                transparentObserverSnapshot.dispose();
                                                Trace.endSection();
                                                return unit2;
                                            } catch (Throwable th4) {
                                                list4.clear();
                                                throw th4;
                                            }
                                        }
                                    }
                                    if (mutableScatterSet3.isNotEmpty()) {
                                        try {
                                            mutableScatterSet4.plusAssign(mutableScatterSet3);
                                            Object[] objArr2 = mutableScatterSet3.elements;
                                            long[] jArr = mutableScatterSet3.metadata;
                                            int length = jArr.length - 2;
                                            if (length >= 0) {
                                                recomposer = recomposer2;
                                                j = 128;
                                                int i7 = 0;
                                                c = 7;
                                                while (true) {
                                                    try {
                                                        long j2 = jArr[i7];
                                                        Object[] objArr3 = objArr2;
                                                        unit = unit2;
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i8 = 8 - ((~(i7 - length)) >>> 31);
                                                            for (int i9 = 0; i9 < i8; i9++) {
                                                                if ((j2 & 255) < 128) {
                                                                    try {
                                                                        ((CompositionImpl) objArr3[(i7 << 3) + i9]).applyLateChanges();
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                        recomposer2 = recomposer;
                                                                        try {
                                                                            recomposer2.processCompositionError(th, null);
                                                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer2, list2, list3, list4, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                                                            mutableScatterSet3.clear();
                                                                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                                                                            transparentObserverSnapshot.dispose();
                                                                            Trace.endSection();
                                                                            return unit;
                                                                        } catch (Throwable th6) {
                                                                            mutableScatterSet3.clear();
                                                                            throw th6;
                                                                        }
                                                                    }
                                                                }
                                                                j2 >>= i;
                                                            }
                                                            if (i8 == i) {
                                                                if (i7 != length) {
                                                                    i7++;
                                                                    unit2 = unit;
                                                                    objArr2 = objArr3;
                                                                    i = 8;
                                                                }
                                                            }
                                                        } else if (i7 != length) {
                                                            i7++;
                                                            unit2 = unit;
                                                            objArr2 = objArr3;
                                                            i = 8;
                                                        }
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        unit = unit2;
                                                    }
                                                }
                                            } else {
                                                unit = unit2;
                                                recomposer = recomposer2;
                                                j = 128;
                                                c = 7;
                                            }
                                            mutableScatterSet3.clear();
                                            recomposer2 = recomposer;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            unit = unit2;
                                        }
                                    } else {
                                        unit = unit2;
                                        j = 128;
                                        c = 7;
                                    }
                                    if (mutableScatterSet4.isNotEmpty()) {
                                        try {
                                            Object[] objArr4 = mutableScatterSet4.elements;
                                            long[] jArr2 = mutableScatterSet4.metadata;
                                            int length2 = jArr2.length - 2;
                                            if (length2 >= 0) {
                                                int i10 = 0;
                                                while (true) {
                                                    long j3 = jArr2[i10];
                                                    Object[] objArr5 = objArr4;
                                                    long[] jArr3 = jArr2;
                                                    if ((((~j3) << c) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                        for (int i12 = 0; i12 < i11; i12++) {
                                                            if ((j3 & 255) < j) {
                                                                ((CompositionImpl) objArr5[(i10 << 3) + i12]).changesApplied();
                                                            }
                                                            j3 >>= 8;
                                                            break;
                                                        }
                                                        if (i11 == 8) {
                                                            if (i10 != length2) {
                                                                i10++;
                                                                objArr4 = objArr5;
                                                                jArr2 = jArr3;
                                                            }
                                                        }
                                                    } else if (i10 != length2) {
                                                        i10++;
                                                        objArr4 = objArr5;
                                                        jArr2 = jArr3;
                                                    }
                                                }
                                            }
                                            mutableScatterSet4.clear();
                                        } catch (Throwable th9) {
                                            try {
                                                recomposer2.processCompositionError(th9, null);
                                                Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer2, list2, list3, list4, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                                mutableScatterSet4.clear();
                                                Snapshot.restoreCurrent(snapshotMakeCurrent);
                                                transparentObserverSnapshot.dispose();
                                                Trace.endSection();
                                                return unit;
                                            } catch (Throwable th10) {
                                                mutableScatterSet4.clear();
                                                throw th10;
                                            }
                                        }
                                    }
                                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                                    transparentObserverSnapshot.dispose();
                                    synchronized (recomposer2.stateLock) {
                                        if (recomposer2.deriveStateLocked() != null) {
                                            ComposerKt.composeImmediateRuntimeError("unexpected to get continuation here");
                                            break;
                                        }
                                    }
                                    SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
                                    mutableScatterSet2.clear();
                                    mutableScatterSet.clear();
                                    recomposer2.compositionsRemoved = null;
                                } catch (Throwable th11) {
                                    Snapshot.restoreCurrent(snapshotMakeCurrent);
                                    throw th11;
                                }
                            } catch (Throwable th12) {
                                transparentObserverSnapshot.dispose();
                                throw th12;
                            }
                        } else {
                            unit = unit2;
                            try {
                                int size3 = list2.size();
                                for (int i13 = 0; i13 < size3; i13++) {
                                    CompositionImpl compositionImpl = (CompositionImpl) list2.get(i13);
                                    CompositionImpl compositionImplPerformRecompose = recomposer2.performRecompose(compositionImpl, mutableScatterSet);
                                    if (compositionImplPerformRecompose != null) {
                                        list4.add(compositionImplPerformRecompose);
                                    }
                                    mutableScatterSet2.add(compositionImpl);
                                }
                                list2.clear();
                                if (mutableScatterSet.isNotEmpty() || recomposer2.compositionInvalidations.size != 0) {
                                    synchronized (recomposer2.stateLock) {
                                        try {
                                            List listKnownCompositionsLocked = recomposer2.knownCompositionsLocked();
                                            int size4 = listKnownCompositionsLocked.size();
                                            for (int i14 = 0; i14 < size4; i14++) {
                                                CompositionImpl compositionImpl2 = (CompositionImpl) listKnownCompositionsLocked.get(i14);
                                                if (!mutableScatterSet2.contains(compositionImpl2) && compositionImpl2.observesAnyOf(set)) {
                                                    list2.add(compositionImpl2);
                                                }
                                            }
                                            MutableVector mutableVector2 = recomposer2.compositionInvalidations;
                                            int i15 = mutableVector2.size;
                                            int i16 = 0;
                                            int i17 = 0;
                                            while (true) {
                                                Object[] objArr6 = mutableVector2.content;
                                                if (i16 < i15) {
                                                    CompositionImpl compositionImpl3 = (CompositionImpl) objArr6[i16];
                                                    if (!mutableScatterSet2.contains(compositionImpl3) && !list2.contains(compositionImpl3)) {
                                                        list2.add(compositionImpl3);
                                                        i17++;
                                                    } else if (i17 > 0) {
                                                        Object[] objArr7 = mutableVector2.content;
                                                        objArr7[i16 - i17] = objArr7[i16];
                                                    }
                                                    i16++;
                                                } else {
                                                    int i18 = i15 - i17;
                                                    Arrays.fill(objArr6, i18, i15, (Object) null);
                                                    mutableVector2.size = i18;
                                                }
                                            }
                                        } catch (Throwable th13) {
                                            throw th13;
                                        }
                                    }
                                }
                                if (list2.isEmpty()) {
                                    try {
                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list3, recomposer2);
                                        while (!list3.isEmpty()) {
                                            List listPerformInsertValues = recomposer2.performInsertValues(list3, mutableScatterSet);
                                            mutableScatterSet3.getClass();
                                            Iterator it = listPerformInsertValues.iterator();
                                            while (it.hasNext()) {
                                                mutableScatterSet3.plusAssign(it.next());
                                            }
                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list3, recomposer2);
                                        }
                                    } catch (Throwable th14) {
                                        recomposer2.processCompositionError(th14, null);
                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer2, list2, list3, list4, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                    }
                                }
                                unit2 = unit;
                                i = 8;
                            } catch (Throwable th15) {
                                try {
                                    recomposer2.processCompositionError(th15, null);
                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(recomposer2, list2, list3, list4, mutableScatterSet3, mutableScatterSet4, mutableScatterSet, mutableScatterSet2);
                                    list2.clear();
                                } catch (Throwable th16) {
                                    list2.clear();
                                    throw th16;
                                }
                            }
                        }
                        Trace.endSection();
                        return unit;
                    }
                } catch (Throwable th17) {
                    Trace.endSection();
                    throw th17;
                }
            default:
                final State state3 = (State) this.f$5;
                LocalSearchViewModel localSearchViewModel = (LocalSearchViewModel) this.f$0;
                final MenuState menuState2 = (MenuState) this.f$3;
                final Function0 function0 = (Function0) this.f$1;
                final State state4 = (State) this.f$8;
                final PlayerConnection playerConnection2 = (PlayerConnection) this.f$6;
                final String str = (String) this.f$2;
                final NavHostController navHostController2 = (NavHostController) this.f$7;
                final State state5 = (State) this.f$4;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                for (Map.Entry entry : ((LocalSearchResult) state3.getValue()).map.entrySet()) {
                    LocalFilter localFilter = (LocalFilter) entry.getKey();
                    List list5 = (List) entry.getValue();
                    if (((LocalSearchResult) state3.getValue()).filter == LocalFilter.ALL) {
                        lazyListIntervalContent.item(localFilter, "local_group_header", new ComposableLambdaImpl(true, -2076521119, new AlbumMenuKt$$ExternalSyntheticLambda11(localSearchViewModel, localFilter, (byte) 29)));
                    }
                    HashSet hashSet = new HashSet();
                    final ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list5) {
                        if (hashSet.add(((LocalItem) obj2).getId())) {
                            arrayList.add(obj2);
                        }
                    }
                    lazyListIntervalContent.items(arrayList.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 0), arrayList, (byte) 9), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 24), arrayList, (byte) 10), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$LocalSearchScreen$lambda$8$1$0$0$$inlined$items$3
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                            int i19;
                            GapComposer gapComposer;
                            MediaMetadata.Album album;
                            LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj3;
                            int iIntValue = ((Number) obj4).intValue();
                            Composer composer = (Composer) obj5;
                            int iIntValue2 = ((Number) obj6).intValue();
                            final byte b = 2;
                            if ((iIntValue2 & 6) == 0) {
                                i19 = (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                            } else {
                                i19 = iIntValue2;
                            }
                            if ((iIntValue2 & 48) == 0) {
                                i19 |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                            }
                            final byte b2 = 0;
                            final byte b3 = 1;
                            GapComposer gapComposer2 = (GapComposer) composer;
                            if (gapComposer2.shouldExecute(i19 & 1, (i19 & 147) != 146)) {
                                final LocalItem localItem = (LocalItem) arrayList.get(iIntValue);
                                gapComposer2.startReplaceGroup(1965664044);
                                if (localItem != null) {
                                    boolean z2 = localItem instanceof Song;
                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                    State state6 = state5;
                                    State state7 = state4;
                                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                    final Function0 function1 = function0;
                                    if (z2) {
                                        gapComposer2.startReplaceGroup(1965686084);
                                        Song song = (Song) localItem;
                                        String str2 = song.song.id;
                                        MediaMetadata mediaMetadata = (MediaMetadata) state7.getValue();
                                        boolean zAreEqual = Intrinsics.areEqual(str2, mediaMetadata != null ? mediaMetadata.id : null);
                                        boolean zBooleanValue = ((Boolean) state6.getValue()).booleanValue();
                                        MenuState menuState3 = menuState2;
                                        boolean zChanged = gapComposer2.changed(menuState3) | gapComposer2.changedInstance(localItem) | gapComposer2.changed(function1) | gapComposer2.changed(false);
                                        Object objRememberedValue = gapComposer2.rememberedValue();
                                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                                            objRememberedValue = new LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$1$1((byte) 0, localItem, menuState3, function1);
                                            gapComposer2.updateRememberedValue(objRememberedValue);
                                        }
                                        Function0 function2 = (Function0) objRememberedValue;
                                        boolean zChanged2 = gapComposer2.changed(state7) | gapComposer2.changedInstance(localItem);
                                        PlayerConnection playerConnection3 = playerConnection2;
                                        boolean zChangedInstance = zChanged2 | gapComposer2.changedInstance(playerConnection3) | gapComposer2.changed(state3) | gapComposer2.changed(str);
                                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                                            LyricsMenuKt$LyricsMenu$11$1$1$1$1 lyricsMenuKt$LyricsMenu$11$1$1$1$1 = new LyricsMenuKt$LyricsMenu$11$1$1$1$1(localItem, playerConnection3, str, state4, state3, (byte) 1);
                                            gapComposer2.updateRememberedValue(lyricsMenuKt$LyricsMenu$11$1$1$1$1);
                                            objRememberedValue2 = lyricsMenuKt$LyricsMenu$11$1$1$1$1;
                                        }
                                        MenuKt.SongListItem(song, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function2, (Function0) objRememberedValue2, 239), null, false, true, false, null, null, zAreEqual, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(786350632, new LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$3(menuState3, localItem, function1), gapComposer2), null, gapComposer2, 24576, 384, 10732);
                                        gapComposer = gapComposer2;
                                        gapComposer.end(false);
                                    } else {
                                        gapComposer = gapComposer2;
                                        boolean z3 = localItem instanceof Album;
                                        final NavHostController navHostController3 = navHostController2;
                                        if (z3) {
                                            gapComposer.startReplaceGroup(1969419414);
                                            Album album2 = (Album) localItem;
                                            String str3 = album2.album.id;
                                            MediaMetadata mediaMetadata2 = (MediaMetadata) state7.getValue();
                                            boolean zAreEqual2 = Intrinsics.areEqual(str3, (mediaMetadata2 == null || (album = mediaMetadata2.album) == null) ? null : album.id);
                                            boolean zBooleanValue2 = ((Boolean) state6.getValue()).booleanValue();
                                            boolean zChanged3 = gapComposer.changed(function1) | gapComposer.changedInstance(navHostController3) | gapComposer.changedInstance(localItem);
                                            Object objRememberedValue3 = gapComposer.rememberedValue();
                                            if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                                objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$4$1
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b4 = b2;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        LocalItem localItem2 = localItem;
                                                        NavHostController navHostController4 = navHostController3;
                                                        Function0 function3 = function1;
                                                        switch (b4) {
                                                            case 0:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("album/", ((Album) localItem2).album.id, navHostController4);
                                                                break;
                                                            case 1:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("artist/", ((Artist) localItem2).artist.id, navHostController4);
                                                                break;
                                                            default:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("local_playlist/", ((Playlist) localItem2).playlist.id, navHostController4);
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer.updateRememberedValue(objRememberedValue3);
                                            }
                                            MenuKt.AlbumListItem(album2, ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue3, 15), false, null, zAreEqual2, zBooleanValue2, null, gapComposer, 0, 76);
                                            gapComposer = gapComposer;
                                            gapComposer.end(false);
                                        } else if (localItem instanceof Artist) {
                                            gapComposer.startReplaceGroup(1970029122);
                                            Artist artist = (Artist) localItem;
                                            boolean zChanged4 = gapComposer.changed(function1) | gapComposer.changedInstance(navHostController3) | gapComposer.changedInstance(localItem);
                                            Object objRememberedValue4 = gapComposer.rememberedValue();
                                            if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                                objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$4$1
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b4 = b3;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        LocalItem localItem2 = localItem;
                                                        NavHostController navHostController4 = navHostController3;
                                                        Function0 function3 = function1;
                                                        switch (b4) {
                                                            case 0:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("album/", ((Album) localItem2).album.id, navHostController4);
                                                                break;
                                                            case 1:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("artist/", ((Artist) localItem2).artist.id, navHostController4);
                                                                break;
                                                            default:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("local_playlist/", ((Playlist) localItem2).playlist.id, navHostController4);
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer.updateRememberedValue(objRememberedValue4);
                                            }
                                            MenuKt.ArtistListItem(artist, ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue4, 15), null, null, gapComposer, 0, 12);
                                            gapComposer = gapComposer;
                                            gapComposer.end(false);
                                        } else if (localItem instanceof Playlist) {
                                            gapComposer.startReplaceGroup(1970542358);
                                            Playlist playlist = (Playlist) localItem;
                                            boolean zChanged5 = gapComposer.changed(function1) | gapComposer.changedInstance(navHostController3) | gapComposer.changedInstance(localItem);
                                            Object objRememberedValue5 = gapComposer.rememberedValue();
                                            if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                                                objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$LocalSearchScreen$4$2$1$1$5$4$1
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b4 = b;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        LocalItem localItem2 = localItem;
                                                        NavHostController navHostController4 = navHostController3;
                                                        Function0 function3 = function1;
                                                        switch (b4) {
                                                            case 0:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("album/", ((Album) localItem2).album.id, navHostController4);
                                                                break;
                                                            case 1:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("artist/", ((Artist) localItem2).artist.id, navHostController4);
                                                                break;
                                                            default:
                                                                function3.invoke();
                                                                Format$$ExternalSyntheticOutline0.m("local_playlist/", ((Playlist) localItem2).playlist.id, navHostController4);
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer.updateRememberedValue(objRememberedValue5);
                                            }
                                            MenuKt.PlaylistListItem(playlist, ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue5, 15), false, null, null, gapComposer, 0, 28);
                                            gapComposer.end(false);
                                        }
                                    }
                                    gapComposer.end(false);
                                } else {
                                    gapComposer = gapComposer2;
                                }
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer, 1725976503, false);
                            }
                            gapComposer2.skipToGroupEnd();
                            return Unit.INSTANCE;
                        }
                    }));
                    localSearchViewModel = localSearchViewModel;
                }
                if (((LocalSearchResult) state3.getValue()).query.length() > 0 && ((LocalSearchResult) state3.getValue()).map.isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, "no_result", null, LocalSearchScreenKt.lambda$1086635420, 2);
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ YouTubeBrowseScreenKt$$ExternalSyntheticLambda1(Recomposer recomposer, MutableScatterSet mutableScatterSet, MutableScatterSet mutableScatterSet2, List list, List list2, MutableScatterSet mutableScatterSet3, List list3, MutableScatterSet mutableScatterSet4, Set set) {
        this.f$1 = recomposer;
        this.f$2 = mutableScatterSet;
        this.f$3 = mutableScatterSet2;
        this.f$0 = list;
        this.f$4 = list2;
        this.f$5 = mutableScatterSet3;
        this.f$8 = list3;
        this.f$6 = mutableScatterSet4;
        this.f$7 = set;
    }

    public /* synthetic */ YouTubeBrowseScreenKt$$ExternalSyntheticLambda1(List list, MutableState mutableState, HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, MutableState mutableState2, PlayerConnection playerConnection, NavHostController navHostController, MutableState mutableState3) {
        this.f$0 = list;
        this.f$1 = mutableState;
        this.f$2 = hapticFeedback;
        this.f$3 = menuState;
        this.f$4 = coroutineScope;
        this.f$5 = mutableState2;
        this.f$6 = playerConnection;
        this.f$7 = navHostController;
        this.f$8 = mutableState3;
    }
}
