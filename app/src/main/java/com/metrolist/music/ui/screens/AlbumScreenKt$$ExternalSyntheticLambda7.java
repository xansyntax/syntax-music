package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda18;
import com.metrolist.music.ui.menu.LyricsMenuKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.SyncUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumScreenKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$12;
    public final /* synthetic */ Object f$13;
    public final /* synthetic */ CoroutineScope f$14;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ PlayerConnection f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ MusicDatabase f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ MutableState f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda7(AlbumItem albumItem, boolean z, Function0 function0, MutableState mutableState, PlayerConnection playerConnection, Context context, MutableState mutableState2, CoroutineScope coroutineScope, MutableState mutableState3, MusicDatabase musicDatabase, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, NavHostController navHostController, MutableState mutableState4, Map map) {
        this.f$0 = albumItem;
        this.f$2 = z;
        this.f$7 = function0;
        this.f$1 = mutableState;
        this.f$3 = playerConnection;
        this.f$10 = context;
        this.f$8 = mutableState2;
        this.f$14 = coroutineScope;
        this.f$4 = mutableState3;
        this.f$5 = musicDatabase;
        this.f$11 = downloadUtil;
        this.f$12 = parcelableSnapshotMutableIntState;
        this.f$13 = navHostController;
        this.f$6 = mutableState4;
        this.f$9 = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        HapticFeedback hapticFeedback;
        State state;
        State state2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$13;
        Object obj3 = this.f$9;
        Object obj4 = this.f$6;
        Object obj5 = this.f$12;
        Object obj6 = this.f$11;
        Object obj7 = this.f$10;
        Object obj8 = this.f$4;
        Object obj9 = this.f$7;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                List list = (List) obj10;
                State state3 = (State) obj8;
                MenuState menuState = (MenuState) obj4;
                List list2 = (List) obj9;
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj3;
                State state4 = (State) obj7;
                State state5 = (State) obj6;
                State state6 = (State) obj5;
                NavHostController navHostController = (NavHostController) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) this.f$1.getValue();
                if (albumWithSongs == null || albumWithSongs.songs.isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, "loading", null, AlbumScreenKt.f299lambda$1104261441, 2);
                } else {
                    boolean z = this.f$2;
                    PlayerConnection playerConnection = this.f$3;
                    LazyListIntervalContent.item$default(lazyListIntervalContent, "album_header", null, new ComposableLambdaImpl(true, 1214581928, new AlbumMenuKt$$ExternalSyntheticLambda16(albumWithSongs, z, playerConnection, state3, this.f$5, menuState)), 2);
                    if (list.isEmpty()) {
                        hapticFeedback = hapticFeedback2;
                        state = state5;
                        state2 = state4;
                    } else {
                        hapticFeedback = hapticFeedback2;
                        state = state5;
                        state2 = state4;
                        lazyListIntervalContent.items(list.size(), new Latch$await$2$2(new QueueKt$$ExternalSyntheticLambda3((byte) 6), list, (byte) 24), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 19), new ComposableLambdaImpl(true, 2039820996, new AlbumScreenKt$AlbumScreen$lambda$22$0$$inlined$itemsIndexed$3(list, list2, this.f$8, hapticFeedback, z, state4, playerConnection, state3, albumWithSongs, state, menuState)));
                    }
                    if (!((List) state6.getValue()).isEmpty()) {
                        LazyListIntervalContent.item$default(lazyListIntervalContent, "other_versions_title", null, AlbumScreenKt.f324lambda$412220394, 2);
                        State state7 = state;
                        LazyListIntervalContent.item$default(lazyListIntervalContent, "other_versions_list", null, new ComposableLambdaImpl(true, 336212159, new SongMenuKt$$ExternalSyntheticLambda8(state6, state2, state7, hapticFeedback, menuState, navHostController, this.f$14, (byte) 7)), 2);
                    }
                }
                break;
            case 1:
                AlbumItem albumItem = (AlbumItem) obj10;
                Function0 function0 = (Function0) obj9;
                Context context = (Context) obj7;
                DownloadUtil downloadUtil = (DownloadUtil) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj5;
                NavHostController navHostController2 = (NavHostController) obj2;
                MutableState mutableState = (MutableState) obj4;
                Map map = (Map) obj3;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                boolean z2 = this.f$2;
                MutableState mutableState2 = this.f$1;
                PlayerConnection playerConnection2 = this.f$3;
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, -2062225749, new AlbumMenuKt$$ExternalSyntheticLambda16(z2, function0, mutableState2, playerConnection2, albumItem, context)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 1302546004, new AlbumMenuKt$$ExternalSyntheticLambda17(z2, mutableState2, playerConnection2, function0, this.f$8, this.f$14, (State) obj8, this.f$5, albumItem)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, AlbumMenuKt.lambda$1587681907, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 1872817810, new AlbumMenuKt$$ExternalSyntheticLambda18(mutableState2, context, downloadUtil, parcelableSnapshotMutableIntState)), 3);
                List list3 = albumItem.artists;
                if (list3 != null) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, AlbumMenuKt.f263lambda$822381794, 3);
                    LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, -2011061035, new QueueMenuKt$$ExternalSyntheticLambda9(list3, (Object) navHostController2, function0, (Object) mutableState, (Object) map, (byte) 7)), 3);
                }
                break;
            case 2:
                PlaylistItem playlistItem = (PlaylistItem) obj9;
                Function0 function1 = (Function0) obj7;
                List list4 = (List) obj10;
                LazyListIntervalContent lazyListIntervalContent3 = (LazyListIntervalContent) obj;
                lazyListIntervalContent3.getClass();
                boolean z3 = this.f$2;
                PlayerConnection playerConnection3 = this.f$3;
                LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, new ComposableLambdaImpl(true, -382758614, new HomeScreenKt$$ExternalSyntheticLambda29(z3, playlistItem, playerConnection3, function1)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, new ComposableLambdaImpl(true, -290900383, new AlbumMenuKt$$ExternalSyntheticLambda17(z3, list4, this.f$14, playlistItem, playerConnection3, function1, this.f$1, (State) obj8, this.f$5)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, AlbumMenuKt.lambda$1199668322, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, new ComposableLambdaImpl(true, -1604730269, new LyricsMenuKt$$ExternalSyntheticLambda0(list4, (DownloadUtil) obj6, playlistItem, (Context) obj5, function1, (Function0) obj4, (ParcelableSnapshotMutableIntState) obj3, this.f$8, (MutableState) obj2)), 3);
                break;
            default:
                final String str = (String) obj10;
                final ArrayList arrayList = (ArrayList) obj9;
                final Function0 function2 = (Function0) obj8;
                final Function0 function3 = (Function0) obj7;
                final DownloadUtil downloadUtil2 = (DownloadUtil) obj6;
                final MutableState mutableState3 = (MutableState) obj5;
                final SyncUtils syncUtils = (SyncUtils) obj4;
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj3;
                final MutableState mutableState4 = (MutableState) obj2;
                LazyListIntervalContent lazyListIntervalContent4 = (LazyListIntervalContent) obj;
                lazyListIntervalContent4.getClass();
                final boolean z4 = this.f$2;
                final PlayerConnection playerConnection4 = this.f$3;
                final MutableState mutableState5 = this.f$1;
                final MutableState mutableState6 = this.f$8;
                final MusicDatabase musicDatabase = this.f$5;
                final CoroutineScope coroutineScope = this.f$14;
                LazyListIntervalContent.item$default(lazyListIntervalContent4, null, null, new ComposableLambdaImpl(true, -441712937, new Function3() { // from class: com.metrolist.music.ui.menu.YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj11, Object obj12, Object obj13) {
                        Material3MenuItemData material3MenuItemData;
                        Material3MenuItemData material3MenuItemData2;
                        ArrayList arrayList2;
                        Material3MenuItemData material3MenuItemData3;
                        Composer composer = (Composer) obj12;
                        int iIntValue = ((Integer) obj13).intValue();
                        ((LazyItemScopeImpl) obj11).getClass();
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                            boolean z5 = z4;
                            final PlayerConnection playerConnection5 = playerConnection4;
                            final String str2 = str;
                            final ArrayList arrayList3 = arrayList;
                            final Function0 function4 = function2;
                            final Function0 function5 = function3;
                            Material3MenuItemData material3MenuItemData4 = null;
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            if (z5) {
                                gapComposer.startReplaceGroup(710541527);
                                gapComposer.end(false);
                                material3MenuItemData = null;
                            } else {
                                gapComposer.startReplaceGroup(709810330);
                                ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$869729355;
                                ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f157lambda$1961599924;
                                boolean zChangedInstance = gapComposer.changedInstance(playerConnection5) | gapComposer.changed(str2) | gapComposer.changedInstance(arrayList3) | gapComposer.changed(function4) | gapComposer.changed(function5);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                    final byte b2 = 0;
                                    objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b3 = b2;
                                            Unit unit2 = Unit.INSTANCE;
                                            int i = 0;
                                            Function0 function6 = function5;
                                            Function0 function7 = function4;
                                            ArrayList arrayList4 = arrayList3;
                                            PlayerConnection playerConnection6 = playerConnection5;
                                            switch (b3) {
                                                case 0:
                                                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10));
                                                    int size = arrayList4.size();
                                                    while (i < size) {
                                                        Object obj14 = arrayList4.get(i);
                                                        i++;
                                                        arrayList5.add(UuidKt.toMediaItem((SongItem) obj14));
                                                    }
                                                    playerConnection6.playQueue(new ListQueue(str2, arrayList5, 0, 0L, 12, null));
                                                    function7.invoke();
                                                    function6.invoke();
                                                    break;
                                                default:
                                                    List mutableList = CollectionsKt.toMutableList((Iterable) arrayList4);
                                                    Collections.shuffle(mutableList);
                                                    ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                                                    ArrayList arrayList7 = (ArrayList) mutableList;
                                                    int size2 = arrayList7.size();
                                                    while (i < size2) {
                                                        Object obj15 = arrayList7.get(i);
                                                        i++;
                                                        arrayList6.add(UuidKt.toMediaItem((SongItem) obj15));
                                                    }
                                                    playerConnection6.playQueue(new ListQueue(str2, arrayList6, 0, 0L, 12, null));
                                                    function7.invoke();
                                                    function6.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    function5 = function5;
                                    function4 = function4;
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                Material3MenuItemData material3MenuItemData5 = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, null, 52);
                                gapComposer.end(false);
                                material3MenuItemData = material3MenuItemData5;
                            }
                            if (z5) {
                                gapComposer.startReplaceGroup(711398615);
                                gapComposer.end(false);
                                material3MenuItemData2 = null;
                            } else {
                                gapComposer.startReplaceGroup(710651081);
                                ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f269lambda$845869236;
                                ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$617768781;
                                boolean zChangedInstance2 = gapComposer.changedInstance(playerConnection5) | gapComposer.changed(str2) | gapComposer.changedInstance(arrayList3) | gapComposer.changed(function4) | gapComposer.changed(function5);
                                Object objRememberedValue2 = gapComposer.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                                    final Function0 function6 = function5;
                                    final byte b3 = 1;
                                    final Function0 function7 = function4;
                                    Function0 function8 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            byte b4 = b3;
                                            Unit unit2 = Unit.INSTANCE;
                                            int i = 0;
                                            Function0 function9 = function6;
                                            Function0 function10 = function7;
                                            ArrayList arrayList4 = arrayList3;
                                            PlayerConnection playerConnection6 = playerConnection5;
                                            switch (b4) {
                                                case 0:
                                                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10));
                                                    int size = arrayList4.size();
                                                    while (i < size) {
                                                        Object obj14 = arrayList4.get(i);
                                                        i++;
                                                        arrayList5.add(UuidKt.toMediaItem((SongItem) obj14));
                                                    }
                                                    playerConnection6.playQueue(new ListQueue(str2, arrayList5, 0, 0L, 12, null));
                                                    function10.invoke();
                                                    function9.invoke();
                                                    break;
                                                default:
                                                    List mutableList = CollectionsKt.toMutableList((Iterable) arrayList4);
                                                    Collections.shuffle(mutableList);
                                                    ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                                                    ArrayList arrayList7 = (ArrayList) mutableList;
                                                    int size2 = arrayList7.size();
                                                    while (i < size2) {
                                                        Object obj15 = arrayList7.get(i);
                                                        i++;
                                                        arrayList6.add(UuidKt.toMediaItem((SongItem) obj15));
                                                    }
                                                    playerConnection6.playQueue(new ListQueue(str2, arrayList6, 0, 0L, 12, null));
                                                    function10.invoke();
                                                    function9.invoke();
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    };
                                    function5 = function6;
                                    function4 = function7;
                                    gapComposer.updateRememberedValue(function8);
                                    objRememberedValue2 = function8;
                                }
                                Material3MenuItemData material3MenuItemData6 = new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, null, (Function0) objRememberedValue2, null, null, 52);
                                gapComposer.end(false);
                                material3MenuItemData2 = material3MenuItemData6;
                            }
                            if (z5) {
                                gapComposer.startReplaceGroup(712021591);
                                gapComposer.end(false);
                            } else {
                                gapComposer.startReplaceGroup(711500853);
                                ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$1733499469;
                                ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f51lambda$1097829810;
                                boolean zChangedInstance3 = gapComposer.changedInstance(playerConnection5) | gapComposer.changedInstance(arrayList3) | gapComposer.changed(function4) | gapComposer.changed(function5);
                                Object objRememberedValue3 = gapComposer.rememberedValue();
                                if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                                    objRememberedValue3 = new SelectionSongsMenuKt$$ExternalSyntheticLambda40(playerConnection5, arrayList3, function4, function5);
                                    gapComposer.updateRememberedValue(objRememberedValue3);
                                }
                                Material3MenuItemData material3MenuItemData7 = new Material3MenuItemData(composableLambdaImpl5, composableLambdaImpl6, null, (Function0) objRememberedValue3, null, null, 52);
                                gapComposer.end(false);
                                material3MenuItemData4 = material3MenuItemData7;
                            }
                            ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.f239lambda$630408013;
                            ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$1461121524;
                            MutableState mutableState7 = mutableState5;
                            boolean zChanged = gapComposer.changed(mutableState7);
                            Object objRememberedValue4 = gapComposer.rememberedValue();
                            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                                objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState7, (byte) 20);
                                gapComposer.updateRememberedValue(objRememberedValue4);
                            }
                            Material3MenuItemData material3MenuItemData8 = new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, null, (Function0) objRememberedValue4, null, null, 52);
                            MutableState mutableState8 = mutableState6;
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1948960692, new SongMenuKt$$ExternalSyntheticLambda37(mutableState8, (byte) 27), gapComposer);
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-254477067, new SongMenuKt$$ExternalSyntheticLambda37(mutableState8, (byte) 28), gapComposer);
                            boolean zChanged2 = gapComposer.changed(mutableState8);
                            MusicDatabase musicDatabase2 = musicDatabase;
                            boolean zChangedInstance4 = zChanged2 | gapComposer.changedInstance(musicDatabase2) | gapComposer.changedInstance(arrayList3);
                            CoroutineScope coroutineScope2 = coroutineScope;
                            boolean zChangedInstance5 = zChangedInstance4 | gapComposer.changedInstance(coroutineScope2) | gapComposer.changed(function4) | gapComposer.changed(function5);
                            Object objRememberedValue5 = gapComposer.rememberedValue();
                            if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                                Function0 function9 = function5;
                                Function0 function10 = function4;
                                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73(musicDatabase2, coroutineScope2, function10, function9, mutableState8, arrayList3);
                                function4 = function10;
                                function5 = function9;
                                arrayList2 = arrayList3;
                                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                                objRememberedValue5 = songMenuKt$$ExternalSyntheticLambda73;
                            } else {
                                arrayList2 = arrayList3;
                            }
                            Material3MenuItemData material3MenuItemData9 = new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue5, null, null, 52);
                            int intValue = parcelableSnapshotMutableIntState2.getIntValue();
                            MutableState mutableState9 = mutableState4;
                            if (intValue == 0 || intValue == 2) {
                                gapComposer.startReplaceGroup(716073911);
                                ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f130lambda$1765449770;
                                ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.f225lambda$542847145;
                                Object objRememberedValue6 = gapComposer.rememberedValue();
                                if (objRememberedValue6 == neverEqualPolicy) {
                                    objRememberedValue6 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState9, (byte) 22);
                                    gapComposer.updateRememberedValue(objRememberedValue6);
                                }
                                material3MenuItemData3 = new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, null, (Function0) objRememberedValue6, null, null, 52);
                                gapComposer.end(false);
                            } else if (intValue != 3) {
                                gapComposer.startReplaceGroup(716766172);
                                ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.lambda$1896331638;
                                ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f277lambda$934997641;
                                boolean zChangedInstance6 = gapComposer.changedInstance(arrayList2);
                                ArrayList arrayList4 = arrayList2;
                                DownloadUtil downloadUtil3 = downloadUtil2;
                                boolean zChangedInstance7 = zChangedInstance6 | gapComposer.changedInstance(downloadUtil3) | gapComposer.changed(function4) | gapComposer.changed(function5);
                                Object objRememberedValue7 = gapComposer.rememberedValue();
                                if (zChangedInstance7 || objRememberedValue7 == neverEqualPolicy) {
                                    SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63(arrayList4, function4, function5, downloadUtil3, (byte) 18);
                                    arrayList2 = arrayList4;
                                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                                    objRememberedValue7 = songMenuKt$$ExternalSyntheticLambda63;
                                } else {
                                    arrayList2 = arrayList4;
                                }
                                material3MenuItemData3 = new Material3MenuItemData(composableLambdaImpl11, composableLambdaImpl12, null, (Function0) objRememberedValue7, null, null, 52);
                                gapComposer.end(false);
                            } else {
                                gapComposer.startReplaceGroup(715195712);
                                ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.f79lambda$1307262291;
                                ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$794566254;
                                Object objRememberedValue8 = gapComposer.rememberedValue();
                                if (objRememberedValue8 == neverEqualPolicy) {
                                    objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState9, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue8);
                                }
                                material3MenuItemData3 = new Material3MenuItemData(composableLambdaImpl13, composableLambdaImpl14, null, (Function0) objRememberedValue8, null, null, 52);
                                gapComposer.end(false);
                            }
                            MutableState mutableState10 = mutableState3;
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1482236490, new SongMenuKt$$ExternalSyntheticLambda37(mutableState10, (byte) 25), gapComposer);
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(609293047, new SongMenuKt$$ExternalSyntheticLambda37(mutableState10, (byte) 26), gapComposer);
                            boolean zChangedInstance8 = gapComposer.changedInstance(musicDatabase2) | gapComposer.changedInstance(arrayList2) | gapComposer.changed(mutableState10);
                            SyncUtils syncUtils2 = syncUtils;
                            boolean zChangedInstance9 = gapComposer.changedInstance(syncUtils2) | zChangedInstance8 | gapComposer.changed(function4) | gapComposer.changed(function5);
                            Object objRememberedValue9 = gapComposer.rememberedValue();
                            if (zChangedInstance9 || objRememberedValue9 == neverEqualPolicy) {
                                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda74 = new SongMenuKt$$ExternalSyntheticLambda73(musicDatabase2, function4, function5, arrayList2, syncUtils2, mutableState10);
                                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda74);
                                objRememberedValue9 = songMenuKt$$ExternalSyntheticLambda74;
                            }
                            MenuKt.Material3MenuGroup(ArraysKt.filterNotNull(new Material3MenuItemData[]{material3MenuItemData, material3MenuItemData2, material3MenuItemData4, material3MenuItemData8, material3MenuItemData9, material3MenuItemData3, new Material3MenuItemData(composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, null, (Function0) objRememberedValue9, null, null, 52)}), gapComposer, 0);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), 3);
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda7(List list, MutableState mutableState, boolean z, PlayerConnection playerConnection, MutableState mutableState2, MusicDatabase musicDatabase, MenuState menuState, List list2, MutableState mutableState3, HapticFeedback hapticFeedback, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, NavHostController navHostController, CoroutineScope coroutineScope) {
        this.f$0 = list;
        this.f$1 = mutableState;
        this.f$2 = z;
        this.f$3 = playerConnection;
        this.f$4 = mutableState2;
        this.f$5 = musicDatabase;
        this.f$6 = menuState;
        this.f$7 = list2;
        this.f$8 = mutableState3;
        this.f$9 = hapticFeedback;
        this.f$10 = mutableState4;
        this.f$11 = mutableState5;
        this.f$12 = mutableState6;
        this.f$13 = navHostController;
        this.f$14 = coroutineScope;
    }

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda7(boolean z, PlaylistItem playlistItem, PlayerConnection playerConnection, Function0 function0, List list, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MusicDatabase musicDatabase, DownloadUtil downloadUtil, Context context, Function0 function1, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState3, MutableState mutableState4) {
        this.f$2 = z;
        this.f$7 = playlistItem;
        this.f$3 = playerConnection;
        this.f$10 = function0;
        this.f$0 = list;
        this.f$14 = coroutineScope;
        this.f$1 = mutableState;
        this.f$4 = mutableState2;
        this.f$5 = musicDatabase;
        this.f$11 = downloadUtil;
        this.f$12 = context;
        this.f$6 = function1;
        this.f$9 = parcelableSnapshotMutableIntState;
        this.f$8 = mutableState3;
        this.f$13 = mutableState4;
    }

    public /* synthetic */ AlbumScreenKt$$ExternalSyntheticLambda7(boolean z, PlayerConnection playerConnection, String str, ArrayList arrayList, Function0 function0, Function0 function1, MutableState mutableState, MutableState mutableState2, MusicDatabase musicDatabase, CoroutineScope coroutineScope, DownloadUtil downloadUtil, MutableState mutableState3, SyncUtils syncUtils, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState4) {
        this.f$2 = z;
        this.f$3 = playerConnection;
        this.f$0 = str;
        this.f$7 = arrayList;
        this.f$4 = function0;
        this.f$10 = function1;
        this.f$1 = mutableState;
        this.f$8 = mutableState2;
        this.f$5 = musicDatabase;
        this.f$14 = coroutineScope;
        this.f$11 = downloadUtil;
        this.f$12 = mutableState3;
        this.f$6 = syncUtils;
        this.f$9 = parcelableSnapshotMutableIntState;
        this.f$13 = mutableState4;
    }
}
