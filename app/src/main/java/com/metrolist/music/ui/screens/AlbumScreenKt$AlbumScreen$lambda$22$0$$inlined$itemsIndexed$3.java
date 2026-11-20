package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$11$1$1$1$1;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$lambda$22$0$$inlined$itemsIndexed$3 implements Function4 {
    public final /* synthetic */ Object $albumWithSongs$inlined;
    public final /* synthetic */ HapticFeedback $haptic$inlined;
    public final /* synthetic */ MutableState $inSelectMode$delegate$inlined;
    public final /* synthetic */ boolean $isListenTogetherGuest$inlined;
    public final /* synthetic */ Object $isPlaying$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ State $mediaMetadata$delegate$inlined;
    public final /* synthetic */ MenuState $menuState$inlined;
    public final /* synthetic */ PlayerConnection $playerConnection$inlined;
    public final /* synthetic */ State $playlistId$delegate$inlined;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object $selection$inlined;

    public AlbumScreenKt$AlbumScreen$lambda$22$0$$inlined$itemsIndexed$3(List list, HapticFeedback hapticFeedback, MenuState menuState, Function0 function0, CoroutineScope coroutineScope, State state, PlayerConnection playerConnection, MutableState mutableState, NavHostController navHostController, boolean z, State state2) {
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$selection$inlined = function0;
        this.$isPlaying$delegate$inlined = coroutineScope;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$inSelectMode$delegate$inlined = mutableState;
        this.$albumWithSongs$inlined = navHostController;
        this.$isListenTogetherGuest$inlined = z;
        this.$playlistId$delegate$inlined = state2;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00e3  */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        Song song;
        Function1 function1;
        MutableState mutableState;
        Function0 function0;
        int i2;
        boolean zAreEqual;
        long j;
        MediaMetadata.Album album;
        byte b = this.$r8$classId;
        boolean z = this.$isListenTogetherGuest$inlined;
        HapticFeedback hapticFeedback = this.$haptic$inlined;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        State state = this.$playlistId$delegate$inlined;
        List list = this.$items;
        State state2 = this.$mediaMetadata$delegate$inlined;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj5 = this.$albumWithSongs$inlined;
        Object obj6 = this.$isPlaying$delegate$inlined;
        Object obj7 = this.$selection$inlined;
        switch (b) {
            case 0:
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) obj5;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                List list2 = (List) obj7;
                if ((iIntValue2 & 6) == 0) {
                    i = iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2);
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    Song song2 = (Song) list.get(iIntValue);
                    gapComposer.startReplaceGroup(1024201831);
                    boolean zChangedInstance = gapComposer.changedInstance(list2) | gapComposer.changed(song2);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1(list2, song2, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function2 = (Function1) objRememberedValue;
                    int i3 = iIntValue + 1;
                    String str = song2.song.id;
                    int i4 = i;
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    boolean zAreEqual2 = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                    boolean zBooleanValue = ((Boolean) ((State) obj6).getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    MutableState mutableState2 = this.$inSelectMode$delegate$inlined;
                    boolean zChanged = gapComposer.changed(mutableState2) | gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(function2);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumScreenKt$AlbumScreen$3$1$4$1$1(hapticFeedback, function2, mutableState2, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function3 = (Function0) objRememberedValue2;
                    boolean zChanged2 = gapComposer.changed(z) | gapComposer.changed(mutableState2) | gapComposer.changed(function2) | gapComposer.changedInstance(list2) | gapComposer.changed(song2) | gapComposer.changed(state2);
                    PlayerConnection playerConnection = this.$playerConnection$inlined;
                    boolean zChangedInstance2 = zChanged2 | gapComposer.changedInstance(playerConnection) | gapComposer.changed(state) | gapComposer.changed(albumWithSongs) | ((((i4 & 112) ^ 48) > 32 && gapComposer.changed(iIntValue)) || (i4 & 48) == 32);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                        song = song2;
                        function1 = function2;
                        mutableState = mutableState2;
                        function0 = function3;
                        AlbumScreenKt$AlbumScreen$3$1$4$2$1 albumScreenKt$AlbumScreen$3$1$4$2$1 = new AlbumScreenKt$AlbumScreen$3$1$4$2$1(function1, (List) obj7, song, this.$isListenTogetherGuest$inlined, playerConnection, albumWithSongs, iIntValue, mutableState, this.$mediaMetadata$delegate$inlined, this.$playlistId$delegate$inlined);
                        gapComposer.updateRememberedValue(albumScreenKt$AlbumScreen$3$1$4$2$1);
                        objRememberedValue3 = albumScreenKt$AlbumScreen$3$1$4$2$1;
                    } else {
                        function0 = function3;
                        song = song2;
                        mutableState = mutableState2;
                        function1 = function2;
                    }
                    MenuKt.SongListItem(song, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) objRememberedValue3, 239), Integer.valueOf(i3), false, true, false, null, null, zAreEqual2, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(2104850684, new AlbumScreenKt$AlbumScreen$3$1$4$3((List) obj7, song, function1, this.$menuState$inlined, mutableState, (byte) 0), gapComposer), null, gapComposer, 24576, 384, 10728);
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                CoroutineScope coroutineScope = (CoroutineScope) obj6;
                Function0 function4 = (Function0) obj7;
                if ((iIntValue4 & 6) == 0) {
                    i2 = iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2);
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    final YTItem yTItem = (YTItem) list.get(iIntValue3);
                    gapComposer2.startReplaceGroup(2057241856);
                    if (yTItem == null) {
                        zAreEqual = false;
                    } else if (yTItem instanceof SongItem) {
                        MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                        zAreEqual = Intrinsics.areEqual(mediaMetadata2 != null ? mediaMetadata2.id : null, ((SongItem) yTItem).id);
                    } else if (yTItem instanceof AlbumItem) {
                        MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                        zAreEqual = Intrinsics.areEqual((mediaMetadata3 == null || (album = mediaMetadata3.album) == null) ? null : album.id, ((AlbumItem) yTItem).id);
                    } else if (yTItem instanceof EpisodeItem) {
                        MediaMetadata mediaMetadata4 = (MediaMetadata) state2.getValue();
                        zAreEqual = Intrinsics.areEqual(mediaMetadata4 != null ? mediaMetadata4.id : null, ((EpisodeItem) yTItem).id);
                    } else {
                        zAreEqual = false;
                    }
                    boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance3 = gapComposer2.changedInstance(hapticFeedback);
                    MenuState menuState = this.$menuState$inlined;
                    boolean zChanged3 = zChangedInstance3 | gapComposer2.changed(menuState) | gapComposer2.changedInstance(yTItem) | gapComposer2.changed(function4) | gapComposer2.changedInstance(coroutineScope);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new LyricsMenuKt$LyricsMenu$11$1$1$1$1(this.$haptic$inlined, this.$menuState$inlined, yTItem, (Function0) obj7, (CoroutineScope) obj6);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function5 = (Function0) objRememberedValue4;
                    boolean zChangedInstance4 = gapComposer2.changedInstance(yTItem) | gapComposer2.changed(state2);
                    final PlayerConnection playerConnection2 = this.$playerConnection$inlined;
                    boolean zChangedInstance5 = zChangedInstance4 | gapComposer2.changedInstance(playerConnection2) | gapComposer2.changed(this.$inSelectMode$delegate$inlined) | gapComposer2.changed(function4) | gapComposer2.changedInstance((NavHostController) obj5);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                        final Function0 function6 = (Function0) obj7;
                        final NavHostController navHostController = (NavHostController) obj5;
                        final State state3 = this.$mediaMetadata$delegate$inlined;
                        final MutableState mutableState3 = this.$inSelectMode$delegate$inlined;
                        objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                YTItem yTItem2 = yTItem;
                                if (yTItem2 != null) {
                                    boolean z2 = yTItem2 instanceof SongItem;
                                    PlayerConnection playerConnection3 = playerConnection2;
                                    State state4 = state3;
                                    Function0 function7 = function6;
                                    if (z2) {
                                        SongItem songItem = (SongItem) yTItem2;
                                        String str2 = songItem.id;
                                        MediaMetadata mediaMetadata5 = (MediaMetadata) state4.getValue();
                                        if (Intrinsics.areEqual(str2, mediaMetadata5 != null ? mediaMetadata5.id : null)) {
                                            playerConnection3.togglePlayPause();
                                        } else {
                                            playerConnection3.playQueue(((Boolean) mutableState3.getValue()).booleanValue() ? YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(songItem)) : new ListQueue(songItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem))), 0, 0L, 12, null));
                                            function7.invoke();
                                        }
                                    } else {
                                        boolean z3 = yTItem2 instanceof AlbumItem;
                                        NavHostController navHostController2 = navHostController;
                                        if (z3) {
                                            NavHostController.navigate$default(navHostController2, "album/" + ((AlbumItem) yTItem2).id);
                                            function7.invoke();
                                        } else if (yTItem2 instanceof ArtistItem) {
                                            NavHostController.navigate$default(navHostController2, "artist/" + ((ArtistItem) yTItem2).id);
                                            function7.invoke();
                                        } else if (yTItem2 instanceof PlaylistItem) {
                                            NavHostController.navigate$default(navHostController2, "online_playlist/" + ((PlaylistItem) yTItem2).id);
                                            function7.invoke();
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            NavHostController.navigate$default(navHostController2, "online_podcast/" + ((PodcastItem) yTItem2).id);
                                            function7.invoke();
                                        } else if (yTItem2 instanceof EpisodeItem) {
                                            EpisodeItem episodeItem = (EpisodeItem) yTItem2;
                                            String str3 = episodeItem.id;
                                            MediaMetadata mediaMetadata6 = (MediaMetadata) state4.getValue();
                                            if (Intrinsics.areEqual(str3, mediaMetadata6 != null ? mediaMetadata6.id : null)) {
                                                playerConnection3.togglePlayPause();
                                            } else {
                                                playerConnection3.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(episodeItem)));
                                                function7.invoke();
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function5, (Function0) objRememberedValue5, 239);
                    if (z) {
                        gapComposer2.startReplaceGroup(-1457327642);
                        gapComposer2.end(false);
                        j = -72057594037927936L;
                    } else {
                        gapComposer2.startReplaceGroup(-1457326453);
                        j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        gapComposer2.end(false);
                    }
                    MenuKt.YouTubeListItem(yTItem, ImageKt.m39backgroundbw27NRU(modifierM48combinedClickablehoGz1lA$default, j, ColorKt.RectangleShape), false, zAreEqual, zBooleanValue2, false, null, Expect_jvmKt.rememberComposableLambda(-2121781688, new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3(menuState, yTItem, function4, coroutineScope), gapComposer2), null, gapComposer2, 100663296, 716);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public AlbumScreenKt$AlbumScreen$lambda$22$0$$inlined$itemsIndexed$3(List list, List list2, MutableState mutableState, HapticFeedback hapticFeedback, boolean z, State state, PlayerConnection playerConnection, State state2, AlbumWithSongs albumWithSongs, State state3, MenuState menuState) {
        this.$items = list;
        this.$selection$inlined = list2;
        this.$inSelectMode$delegate$inlined = mutableState;
        this.$haptic$inlined = hapticFeedback;
        this.$isListenTogetherGuest$inlined = z;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$playlistId$delegate$inlined = state2;
        this.$albumWithSongs$inlined = albumWithSongs;
        this.$isPlaying$delegate$inlined = state3;
        this.$menuState$inlined = menuState;
    }
}
