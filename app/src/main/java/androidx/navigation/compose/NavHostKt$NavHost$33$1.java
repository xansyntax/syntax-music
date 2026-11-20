package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.RealImageLoader;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.ArtistItemsPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.music.lyrics.LyricsProvider;
import com.metrolist.music.lyrics.LyricsProviderRegistry;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.LyricsViewModel;
import com.metrolist.music.viewmodels.LyricsViewModel$processLyrics$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$33$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $composeNavigator;
    public final /* synthetic */ Object $navController;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object $transition;
    public final /* synthetic */ Object $visibleEntries$delegate;
    public final /* synthetic */ Object $zIndices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$33$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$transition = obj;
        this.$navController = obj2;
        this.$zIndices = obj3;
        this.$visibleEntries$delegate = obj4;
        this.$composeNavigator = obj5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$composeNavigator;
        Object obj3 = this.$visibleEntries$delegate;
        Object obj4 = this.$zIndices;
        Object obj5 = this.$navController;
        switch (b) {
            case 0:
                return new NavHostKt$NavHost$33$1((Transition) this.$transition, (NavHostController) obj5, (MutableObjectFloatMap) obj4, (State) obj3, (ComposeNavigator) obj2, continuation, (byte) 0);
            case 1:
                NavHostKt$NavHost$33$1 navHostKt$NavHost$33$1 = new NavHostKt$NavHost$33$1((BringIntoViewResponderNode) obj5, (NodeCoordinator) obj4, (ComponentRegistry$Builder$$ExternalSyntheticLambda2) obj3, (GapComposer$$ExternalSyntheticLambda0) obj2, continuation);
                navHostKt$NavHost$33$1.$transition = obj;
                return navHostKt$NavHost$33$1;
            case 2:
                return new NavHostKt$NavHost$33$1((LyricsViewModel) this.$transition, (String) obj5, (List) obj4, (DataStoreKt$rememberPreference$1$1) obj3, (DataStoreKt$rememberPreference$1$1) obj2, continuation, (byte) 2);
            case 3:
                return new NavHostKt$NavHost$33$1((PlayerConnection) this.$transition, (MutableState) obj5, (ParcelableSnapshotMutableLongState) obj4, (MutableState) obj3, (ParcelableSnapshotMutableLongState) obj2, continuation, (byte) 3);
            case 4:
                return new NavHostKt$NavHost$33$1((ArtistItemsPage) this.$transition, (PlayerConnection) obj5, (String) obj4, (ArtistPage) obj3, (ArtistSection) obj2, continuation, (byte) 4);
            default:
                return new NavHostKt$NavHost$33$1((ArrayList) this.$transition, (SnapshotStateList) obj5, (Set) obj4, (Map) obj3, (Painter) obj2, continuation, (byte) 5);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 1:
                return ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 2:
                ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 3:
                ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 4:
                ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            default:
                ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:47:0x011b A[LOOP:5: B:46:0x0119->B:47:0x011b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x0131  */
    /* JADX WARN: Code duplicated, block: B:52:0x0135  */
    /* JADX WARN: Code duplicated, block: B:64:0x018f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        char c;
        Integer num;
        Unit unit;
        char c2;
        Integer num2;
        long duration;
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        int i;
        DraggableLyricsProviderItem draggableLyricsProviderItem;
        byte b = this.$r8$classId;
        char c3 = 3;
        Integer num3 = null;
        Unit unit2 = Unit.INSTANCE;
        Object obj2 = this.$composeNavigator;
        Object obj3 = this.$visibleEntries$delegate;
        Object obj4 = this.$zIndices;
        Object obj5 = this.$navController;
        switch (b) {
            case 0:
                NavHostController navHostController = (NavHostController) obj5;
                ResultKt.throwOnFailure(obj);
                Transition transition = (Transition) this.$transition;
                Object currentState = transition.transitionState.getCurrentState();
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition.targetState$delegate;
                if (Intrinsics.areEqual(currentState, parcelableSnapshotMutableState.getValue()) && (navHostController.impl.getCurrentBackStackEntry$navigation_runtime_release() == null || Intrinsics.areEqual(parcelableSnapshotMutableState.getValue(), navHostController.impl.getCurrentBackStackEntry$navigation_runtime_release()))) {
                    ComposeNavigator composeNavigator = (ComposeNavigator) obj2;
                    Iterator it = ((List) ((State) obj3).getValue()).iterator();
                    while (it.hasNext()) {
                        composeNavigator.getState().markTransitionComplete((NavBackStackEntry) it.next());
                    }
                    MutableObjectFloatMap mutableObjectFloatMap = (MutableObjectFloatMap) obj4;
                    long[] jArr = mutableObjectFloatMap.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i2 = 0;
                        while (true) {
                            long j = jArr[i2];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i3 = 8 - ((~(i2 - length)) >>> 31);
                                int i4 = 0;
                                while (i4 < i3) {
                                    if ((j & 255) < 128) {
                                        int i5 = (i2 << 3) + i4;
                                        c2 = c3;
                                        Object obj6 = mutableObjectFloatMap.keys[i5];
                                        float f = mutableObjectFloatMap.values[i5];
                                        if (!Intrinsics.areEqual((String) obj6, ((NavBackStackEntry) parcelableSnapshotMutableState.getValue()).id)) {
                                            mutableObjectFloatMap._size--;
                                            long[] jArr2 = mutableObjectFloatMap.metadata;
                                            int i6 = mutableObjectFloatMap._capacity;
                                            int i7 = i5 >> 3;
                                            int i8 = (i5 & 7) << 3;
                                            num2 = num3;
                                            long j2 = (jArr2[i7] & (~(255 << i8))) | (254 << i8);
                                            jArr2[i7] = j2;
                                            jArr2[(((i5 - 7) & i6) + (i6 & 7)) >> 3] = j2;
                                            mutableObjectFloatMap.keys[i5] = num2;
                                        }
                                        j >>= 8;
                                        i4++;
                                        c3 = c2;
                                        num3 = num2;
                                        unit2 = unit2;
                                    } else {
                                        c2 = c3;
                                    }
                                    num2 = num3;
                                    j >>= 8;
                                    i4++;
                                    c3 = c2;
                                    num3 = num2;
                                    unit2 = unit2;
                                }
                                c = c3;
                                num = num3;
                                unit = unit2;
                                if (i3 != 8) {
                                    return unit;
                                }
                            } else {
                                c = c3;
                                num = num3;
                                unit = unit2;
                            }
                            if (i2 == length) {
                                return unit;
                            }
                            i2++;
                            c3 = c;
                            num3 = num;
                            unit2 = unit;
                        }
                    }
                }
                return unit2;
            case 1:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.$transition;
                BringIntoViewResponderNode bringIntoViewResponderNode = (BringIntoViewResponderNode) obj5;
                Continuation continuation = null;
                AwaitKt.launch$default(coroutineScope, null, null, new RealImageLoader.AnonymousClass2(bringIntoViewResponderNode, (NodeCoordinator) obj4, (ComponentRegistry$Builder$$ExternalSyntheticLambda2) obj3, continuation, (byte) 16, false), 3);
                return AwaitKt.launch$default(coroutineScope, null, null, new SliderState.AnonymousClass2(bringIntoViewResponderNode, (GapComposer$$ExternalSyntheticLambda0) obj2, continuation, (byte) 9), 3);
            case 2:
                ResultKt.throwOnFailure(obj);
                LyricsViewModel lyricsViewModel = (LyricsViewModel) this.$transition;
                String str = (String) obj5;
                List list = (List) obj4;
                boolean zBooleanValue = ((Boolean) ((DataStoreKt$rememberPreference$1$1) obj3).$state.getValue()).booleanValue();
                boolean zBooleanValue2 = ((Boolean) ((DataStoreKt$rememberPreference$1$1) obj2).$state.getValue()).booleanValue();
                list.getClass();
                StandaloneCoroutine standaloneCoroutine = lyricsViewModel.processJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                lyricsViewModel.processJob = AwaitKt.launch$default(ViewModelKt.getViewModelScope(lyricsViewModel), null, null, new LyricsViewModel$processLyrics$1(lyricsViewModel, zBooleanValue2, str, list, zBooleanValue, null), 3);
                return unit2;
            case 3:
                PlayerConnection playerConnection = (PlayerConnection) this.$transition;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) ((MutableState) obj5).getValue()).booleanValue()) {
                    ((ParcelableSnapshotMutableLongState) obj4).setLongValue(playerConnection.getPlayerSafe().getCurrentPosition());
                    ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj2;
                    MediaMetadata mediaMetadata = (MediaMetadata) ((MutableState) obj3).getValue();
                    if (mediaMetadata != null) {
                        Integer num4 = new Integer(mediaMetadata.duration);
                        num3 = num4.intValue() > 0 ? num4 : null;
                        if (num3 != null) {
                            duration = ((long) num3.intValue()) * 1000;
                        } else {
                            duration = playerConnection.getPlayerSafe().getDuration();
                        }
                    } else {
                        duration = playerConnection.getPlayerSafe().getDuration();
                    }
                    parcelableSnapshotMutableLongState.setLongValue(duration);
                }
                return unit2;
            case 4:
                ArtistPage artistPage = (ArtistPage) obj3;
                String str2 = (String) obj4;
                PlayerConnection playerConnection2 = (PlayerConnection) obj5;
                ResultKt.throwOnFailure(obj);
                ArtistItemsPage artistItemsPage = (ArtistItemsPage) this.$transition;
                if (artistItemsPage != null) {
                    List list2 = artistItemsPage.items;
                    if (list2.isEmpty()) {
                        List list3 = ((ArtistSection) obj2).items;
                        arrayList = new ArrayList();
                        for (Object obj7 : list3) {
                            if (obj7 instanceof SongItem) {
                                arrayList.add(obj7);
                            }
                        }
                        arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                        size = arrayList.size();
                        i = 0;
                        while (i < size) {
                            Object obj8 = arrayList.get(i);
                            i++;
                            arrayList2.add(UuidKt.toMediaItem((SongItem) obj8));
                        }
                        if (!arrayList2.isEmpty()) {
                            if (str2 == null) {
                                str2 = artistPage.artist.title;
                            }
                            playerConnection2.playQueue(new ListQueue(str2, arrayList2, 0, 0L, 12, null));
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj9 : list2) {
                            if (obj9 instanceof SongItem) {
                                arrayList3.add(obj9);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                        int size2 = arrayList3.size();
                        int i9 = 0;
                        while (i9 < size2) {
                            Object obj10 = arrayList3.get(i9);
                            i9++;
                            arrayList4.add(UuidKt.toMediaItem((SongItem) obj10));
                        }
                        if (str2 == null) {
                            str2 = artistPage.artist.title;
                        }
                        playerConnection2.playQueue(new ListQueue(str2, arrayList4, 0, 0L, 12, null));
                    }
                } else {
                    List list4 = ((ArtistSection) obj2).items;
                    arrayList = new ArrayList();
                    while (r0.hasNext()) {
                        if (obj7 instanceof SongItem) {
                            arrayList.add(obj7);
                        }
                    }
                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    size = arrayList.size();
                    i = 0;
                    while (i < size) {
                        Object obj11 = arrayList.get(i);
                        i++;
                        arrayList2.add(UuidKt.toMediaItem((SongItem) obj11));
                    }
                    if (!arrayList2.isEmpty()) {
                        if (str2 == null) {
                            str2 = artistPage.artist.title;
                        }
                        playerConnection2.playQueue(new ListQueue(str2, arrayList2, 0, 0L, 12, null));
                    }
                }
                return unit2;
            default:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj5;
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList5 = (ArrayList) this.$transition;
                Set set = (Set) obj4;
                ArrayList arrayList6 = new ArrayList();
                int size3 = arrayList5.size();
                int i10 = 0;
                while (i10 < size3) {
                    Object obj12 = arrayList5.get(i10);
                    i10++;
                    if (set.contains((String) obj12)) {
                        arrayList6.add(obj12);
                    }
                }
                snapshotStateList.clear();
                Map map = (Map) obj3;
                Painter painter = (Painter) obj2;
                ArrayList arrayList7 = new ArrayList();
                int size4 = arrayList6.size();
                int i11 = 0;
                while (i11 < size4) {
                    Object obj13 = arrayList6.get(i11);
                    i11++;
                    String str3 = (String) obj13;
                    Map map2 = LyricsProviderRegistry.providerMap;
                    str3.getClass();
                    if (((LyricsProvider) LyricsProviderRegistry.providerMap.get(str3)) == null) {
                        draggableLyricsProviderItem = null;
                    } else {
                        String str4 = (String) map.get(str3);
                        if (str4 == null) {
                            str4 = str3;
                        }
                        draggableLyricsProviderItem = new DraggableLyricsProviderItem(str3, str4, painter);
                    }
                    if (draggableLyricsProviderItem != null) {
                        arrayList7.add(draggableLyricsProviderItem);
                    }
                }
                snapshotStateList.addAll(arrayList7);
                return unit2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$33$1(BringIntoViewResponderNode bringIntoViewResponderNode, NodeCoordinator nodeCoordinator, ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2, GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.$navController = bringIntoViewResponderNode;
        this.$zIndices = nodeCoordinator;
        this.$visibleEntries$delegate = componentRegistry$Builder$$ExternalSyntheticLambda2;
        this.$composeNavigator = gapComposer$$ExternalSyntheticLambda0;
    }
}
