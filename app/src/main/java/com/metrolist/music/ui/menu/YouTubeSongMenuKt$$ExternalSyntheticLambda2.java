package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubePlaylistQueue;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$3$4$3;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.OnlinePlaylistViewModel;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeSongMenuKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ PlayerConnection f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ CoroutineScope f$12;
    public final /* synthetic */ State f$13;
    public final /* synthetic */ Object f$14;
    public final /* synthetic */ State f$15;
    public final /* synthetic */ Object f$16;
    public final /* synthetic */ MutableState f$17;
    public final /* synthetic */ Object f$18;
    public final /* synthetic */ Object f$19;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ List f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ State f$9;

    public /* synthetic */ YouTubeSongMenuKt$$ExternalSyntheticLambda2(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, OnlinePlaylistViewModel onlinePlaylistViewModel, List list, MutableState mutableState5, CoroutineScope coroutineScope, boolean z, MutableState mutableState6, SnapshotStateList snapshotStateList, HapticFeedback hapticFeedback, MutableState mutableState7, PlayerConnection playerConnection, MutableState mutableState8, MutableState mutableState9, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState10, MenuState menuState, MutableState mutableState11) {
        this.f$9 = mutableState;
        this.f$4 = mutableState2;
        this.f$13 = mutableState3;
        this.f$15 = mutableState4;
        this.f$2 = onlinePlaylistViewModel;
        this.f$7 = list;
        this.f$17 = mutableState5;
        this.f$12 = coroutineScope;
        this.f$0 = z;
        this.f$3 = mutableState6;
        this.f$11 = snapshotStateList;
        this.f$5 = hapticFeedback;
        this.f$6 = mutableState7;
        this.f$1 = playerConnection;
        this.f$8 = mutableState8;
        this.f$10 = mutableState9;
        this.f$14 = dataStoreKt$rememberPreference$1$1;
        this.f$16 = mutableState10;
        this.f$18 = menuState;
        this.f$19 = mutableState11;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$19;
        Object obj3 = this.f$18;
        Object obj4 = this.f$16;
        Object obj5 = this.f$14;
        Object obj6 = this.f$10;
        Object obj7 = this.f$8;
        Object obj8 = this.f$6;
        Object obj9 = this.f$5;
        Object obj10 = this.f$11;
        Object obj11 = this.f$3;
        Object obj12 = this.f$2;
        switch (b) {
            case 0:
                SongItem songItem = (SongItem) obj12;
                Function0 function0 = (Function0) obj11;
                Context context = (Context) obj9;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj8;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                boolean z = this.f$0;
                PlayerConnection playerConnection = this.f$1;
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -2001415359, new AlbumMenuKt$$ExternalSyntheticLambda16(z, playerConnection, songItem, function0, this.f$4, context)), 3);
                List list = this.f$7;
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1102234760, new AlbumMenuKt$$ExternalSyntheticLambda16(listenTogetherManager, songItem, list, function0, z, playerConnection)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1090279033, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1012174470, new AlbumMenuKt$$ExternalSyntheticLambda20(songItem, (MusicDatabase) obj7, this.f$9, (SyncUtils) obj6, function0, (Function0) obj10, this.f$12, this.f$13)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1180339323, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -922114180, new SongMenuKt$$ExternalSyntheticLambda34(context, songItem, (DownloadUtil) obj5, this.f$15, (byte) 10)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1270399613, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -832053890, new SongMenuKt$$ExternalSyntheticLambda8(songItem, list, (NavHostController) obj4, function0, this.f$17, (BottomSheetPageState) obj3, (Map) obj2)), 3);
                break;
            default:
                final OnlinePlaylistViewModel onlinePlaylistViewModel = (OnlinePlaylistViewModel) obj12;
                State state = (State) obj11;
                final SnapshotStateList snapshotStateList = (SnapshotStateList) obj10;
                final HapticFeedback hapticFeedback = (HapticFeedback) obj9;
                final State state2 = (State) obj8;
                final State state3 = (State) obj7;
                final MutableState mutableState = (MutableState) obj6;
                final MutableState mutableState2 = (MutableState) obj5;
                final MutableState mutableState3 = (MutableState) obj4;
                final MenuState menuState = (MenuState) obj3;
                State state4 = (State) obj2;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                State state5 = this.f$9;
                PlaylistItem playlistItem = (PlaylistItem) state5.getValue();
                MutableState mutableState4 = this.f$4;
                if (playlistItem == null || ((List) mutableState4.getValue()).isEmpty()) {
                    State state6 = this.f$13;
                    if (!((Boolean) state6.getValue()).booleanValue()) {
                        State state7 = this.f$15;
                        if (((String) state7.getValue()) != null) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent2, "error_placeholder", null, new ComposableLambdaImpl(true, 1794000656, new AlbumMenuKt$$ExternalSyntheticLambda11(onlinePlaylistViewModel, state7, (byte) 25)), 2);
                        } else if (!((Boolean) state6.getValue()).booleanValue() && ((List) mutableState4.getValue()).isEmpty()) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent2, "empty_placeholder", null, TopPlaylistScreenKt.lambda$729033425, 2);
                        }
                    } else {
                        LazyListIntervalContent.item$default(lazyListIntervalContent2, "loading_placeholder", null, TopPlaylistScreenKt.f396lambda$1817020967, 2);
                    }
                } else {
                    final PlaylistItem playlistItem2 = (PlaylistItem) state5.getValue();
                    if (playlistItem2 != null) {
                        if (!((Boolean) this.f$17.getValue()).booleanValue()) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent2, "playlist_header", null, new ComposableLambdaImpl(true, 232028530, new AlbumMenuKt$$ExternalSyntheticLambda16(playlistItem2, this.f$12, onlinePlaylistViewModel, this.f$0, mutableState4, state)), 2);
                        }
                        TopPlaylistScreenKt$$ExternalSyntheticLambda8 topPlaylistScreenKt$$ExternalSyntheticLambda8 = new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 8);
                        final List list2 = this.f$7;
                        int size = list2.size();
                        ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(topPlaylistScreenKt$$ExternalSyntheticLambda8, list2, (byte) 5);
                        AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3 = new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list2, (byte) 8);
                        final PlayerConnection playerConnection2 = this.f$1;
                        lazyListIntervalContent2.items(size, scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1, alarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3, new ComposableLambdaImpl(true, 2039820996, new Function4() { // from class: com.metrolist.music.ui.screens.playlist.OnlinePlaylistScreenKt$OnlinePlaylistScreen$lambda$31$0$0$1$$inlined$itemsIndexed$3
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj13, Object obj14, Object obj15, Object obj16) {
                                int i;
                                int i2;
                                State state8;
                                NeverEqualPolicy neverEqualPolicy;
                                List list3;
                                int i3;
                                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj13;
                                int iIntValue = ((Number) obj14).intValue();
                                Composer composer = (Composer) obj15;
                                int iIntValue2 = ((Number) obj16).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    i = (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                                } else {
                                    i = iIntValue2;
                                }
                                if ((iIntValue2 & 48) == 0) {
                                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                                }
                                GapComposer gapComposer = (GapComposer) composer;
                                if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                                    Pair pair = (Pair) list2.get(iIntValue);
                                    gapComposer.startReplaceGroup(925729811);
                                    final SongItem songItem2 = (SongItem) pair.second;
                                    boolean zChangedInstance = gapComposer.changedInstance(songItem2);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    SnapshotStateList snapshotStateList2 = snapshotStateList;
                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                    if (zChangedInstance || objRememberedValue == neverEqualPolicy2) {
                                        objRememberedValue = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(snapshotStateList2, songItem2, (byte) 4);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    final Function1 function1 = (Function1) objRememberedValue;
                                    State state9 = state2;
                                    MediaMetadata mediaMetadata = (MediaMetadata) state9.getValue();
                                    boolean zAreEqual = Intrinsics.areEqual(mediaMetadata != null ? mediaMetadata.id : null, songItem2.id);
                                    boolean zBooleanValue = ((Boolean) state3.getValue()).booleanValue();
                                    boolean z2 = TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState) && snapshotStateList2.contains(songItem2.id);
                                    boolean z3 = (((Boolean) mutableState2.getValue()).booleanValue() && songItem2.explicit) ? false : true;
                                    boolean zChangedInstance2 = gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(function1) | gapComposer.changedInstance(songItem2);
                                    List list4 = list2;
                                    int i4 = (i & 112) ^ 48;
                                    boolean zChangedInstance3 = zChangedInstance2 | gapComposer.changedInstance(list4) | ((i4 > 32 && gapComposer.changed(iIntValue)) || (i & 48) == 32);
                                    Object objRememberedValue2 = gapComposer.rememberedValue();
                                    if (zChangedInstance3 || objRememberedValue2 == neverEqualPolicy2) {
                                        i2 = iIntValue;
                                        state8 = state9;
                                        neverEqualPolicy = neverEqualPolicy2;
                                        list3 = list4;
                                        i3 = i4;
                                        OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 = new OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1(hapticFeedback, function1, songItem2, i2, list2, snapshotStateList, mutableState, mutableState3, (byte) 0);
                                        function1 = function1;
                                        gapComposer.updateRememberedValue(onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1);
                                        objRememberedValue2 = onlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1;
                                    } else {
                                        state8 = state9;
                                        neverEqualPolicy = neverEqualPolicy2;
                                        list3 = list4;
                                        i3 = i4;
                                        i2 = iIntValue;
                                    }
                                    Function0 function2 = (Function0) objRememberedValue2;
                                    boolean zChanged = gapComposer.changed(state8) | gapComposer.changed(function1) | gapComposer.changedInstance(songItem2);
                                    final PlayerConnection playerConnection3 = playerConnection2;
                                    boolean zChangedInstance4 = zChanged | gapComposer.changedInstance(playerConnection3);
                                    final PlaylistItem playlistItem3 = playlistItem2;
                                    boolean zChangedInstance5 = zChangedInstance4 | gapComposer.changedInstance(playlistItem3) | gapComposer.changedInstance(list3);
                                    final OnlinePlaylistViewModel onlinePlaylistViewModel2 = onlinePlaylistViewModel;
                                    boolean zChangedInstance6 = zChangedInstance5 | gapComposer.changedInstance(onlinePlaylistViewModel2) | ((i3 > 32 && gapComposer.changed(i2)) || (i & 48) == 32);
                                    Object objRememberedValue3 = gapComposer.rememberedValue();
                                    if (zChangedInstance6 || objRememberedValue3 == neverEqualPolicy) {
                                        final int i5 = i2;
                                        final MutableState mutableState5 = mutableState;
                                        final State state10 = state2;
                                        final SnapshotStateList snapshotStateList3 = snapshotStateList;
                                        final List list5 = list2;
                                        Function0 function3 = new Function0() { // from class: com.metrolist.music.ui.screens.playlist.OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$2$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                String str = songItem2.id;
                                                if (TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState5)) {
                                                    function1.invoke(Boolean.valueOf(!snapshotStateList3.contains(str)));
                                                } else {
                                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state10.getValue();
                                                    boolean zAreEqual2 = Intrinsics.areEqual(str, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                                    PlayerConnection playerConnection4 = playerConnection3;
                                                    if (zAreEqual2) {
                                                        playerConnection4.togglePlayPause();
                                                    } else {
                                                        PlaylistItem playlistItem4 = playlistItem3;
                                                        String str2 = playlistItem4.id;
                                                        String str3 = playlistItem4.title;
                                                        List list6 = list5;
                                                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                                                        Iterator it = list6.iterator();
                                                        while (it.hasNext()) {
                                                            arrayList.add((SongItem) ((Pair) it.next()).second);
                                                        }
                                                        playerConnection4.playQueue(new YouTubePlaylistQueue(str2, str3, arrayList, onlinePlaylistViewModel2.continuation, i5, null, 32, null));
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        gapComposer.updateRememberedValue(function3);
                                        objRememberedValue3 = function3;
                                    }
                                    MenuKt.YouTubeListItem(songItem2, ImageKt.m48combinedClickablehoGz1lA$default(Modifier.Companion.$$INSTANCE, z3, function2, (Function0) objRememberedValue3, 238), z2, zAreEqual, zBooleanValue, false, null, Expect_jvmKt.rememberComposableLambda(308118872, new HistoryScreenKt$HistoryScreen$4$1$1$3$4$3(snapshotStateList, songItem2, function1, menuState, mutableState, (byte) 1), gapComposer), null, gapComposer, 100663296, 708);
                                    gapComposer.end(false);
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }));
                        if (((Boolean) state4.getValue()).booleanValue()) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent2, "loading_more", null, TopPlaylistScreenKt.f393lambda$1782810391, 2);
                        }
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ YouTubeSongMenuKt$$ExternalSyntheticLambda2(boolean z, PlayerConnection playerConnection, SongItem songItem, Function0 function0, MutableState mutableState, Context context, ListenTogetherManager listenTogetherManager, List list, MusicDatabase musicDatabase, MutableState mutableState2, SyncUtils syncUtils, Function0 function1, CoroutineScope coroutineScope, MutableState mutableState3, DownloadUtil downloadUtil, MutableState mutableState4, NavHostController navHostController, MutableState mutableState5, BottomSheetPageState bottomSheetPageState, Map map) {
        this.f$0 = z;
        this.f$1 = playerConnection;
        this.f$2 = songItem;
        this.f$3 = function0;
        this.f$4 = mutableState;
        this.f$5 = context;
        this.f$6 = listenTogetherManager;
        this.f$7 = list;
        this.f$8 = musicDatabase;
        this.f$9 = mutableState2;
        this.f$10 = syncUtils;
        this.f$11 = function1;
        this.f$12 = coroutineScope;
        this.f$13 = mutableState3;
        this.f$14 = downloadUtil;
        this.f$15 = mutableState4;
        this.f$16 = navHostController;
        this.f$17 = mutableState5;
        this.f$18 = bottomSheetPageState;
        this.f$19 = map;
    }
}
