package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SongWithStats;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$7$1$1$1;
import com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$ArtistSongsScreen$1$1$1$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$LibraryPodcastsScreen$4$3$1$5$channelName$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ Object $coroutineScope$inlined;
    public final /* synthetic */ Object $haptic$inlined;
    public final /* synthetic */ State $isPlaying$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ State $mediaMetadata$delegate$inlined;
    public final /* synthetic */ MenuState $menuState$inlined;
    public final /* synthetic */ Object $navController$inlined;
    public final /* synthetic */ byte $r8$classId = 3;

    public NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(ArrayList arrayList, State state, PlayerConnection playerConnection, NavHostController navHostController, State state2, MenuState menuState, CoroutineScope coroutineScope) {
        this.$items = arrayList;
        this.$mediaMetadata$delegate$inlined = state;
        this.$haptic$inlined = playerConnection;
        this.$navController$inlined = navHostController;
        this.$isPlaying$delegate$inlined = state2;
        this.$menuState$inlined = menuState;
        this.$coroutineScope$inlined = coroutineScope;
    }

    /* JADX WARN: Code duplicated, block: B:97:0x024a  */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws IOException {
        MediaMetadata.Album album;
        boolean z;
        boolean zAreEqual;
        MediaMetadata.Album album2;
        byte b = this.$r8$classId;
        MenuState menuState = this.$menuState$inlined;
        Unit unit = Unit.INSTANCE;
        State state = this.$isPlaying$delegate$inlined;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Object obj5 = this.$coroutineScope$inlined;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        List list = this.$items;
        final State state2 = this.$mediaMetadata$delegate$inlined;
        Object obj6 = this.$haptic$inlined;
        boolean z2 = true;
        Object obj7 = this.$navController$inlined;
        switch (b) {
            case 0:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                NavHostController navHostController = (NavHostController) obj7;
                HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    AlbumItem albumItem = (AlbumItem) list.get(iIntValue);
                    gapComposer.startReplaceGroup(769974640);
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    boolean zAreEqual2 = Intrinsics.areEqual((mediaMetadata == null || (album = mediaMetadata.album) == null) ? null : album.id, albumItem.id);
                    boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | gapComposer.changedInstance(albumItem);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AccountScreenKt$AccountScreen$1$1$8$1$1(hapticFeedback, menuState, albumItem, (byte) 2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer.changedInstance(navHostController) | gapComposer.changedInstance(albumItem);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AccountScreenKt$AccountScreen$1$1$8$2$1(navHostController, albumItem, (byte) 2);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.YouTubeGridItem(albumItem, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function0, (Function0) objRememberedValue2, 239), (CoroutineScope) obj5, null, CropImageView.DEFAULT_ASPECT_RATIO, zAreEqual2, zBooleanValue, true, gapComposer, 12582912, 24);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                final PlayerConnection playerConnection = (PlayerConnection) obj7;
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj6;
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final SongItem songItem = (SongItem) ((ArrayList) list).get(iIntValue3);
                    gapComposer2.startReplaceGroup(-330016327);
                    String str = songItem.id;
                    MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                    boolean zAreEqual3 = Intrinsics.areEqual(str, mediaMetadata2 != null ? mediaMetadata2.id : null);
                    boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance3 = gapComposer2.changedInstance(hapticFeedback2) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(songItem);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ChartsScreenKt$ChartsScreen$3$1$1$1$4$1$1$1$3$1$1(hapticFeedback2, menuState, songItem, (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1 = (Function0) objRememberedValue3;
                    boolean zChangedInstance4 = gapComposer2.changedInstance(songItem) | gapComposer2.changed(state2) | gapComposer2.changedInstance(playerConnection);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.ChartsScreenKt$ChartsScreen$3$1$1$1$4$1$1$1$3$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                SongItem songItem2 = songItem;
                                String str2 = songItem2.id;
                                MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                                boolean zAreEqual4 = Intrinsics.areEqual(str2, mediaMetadata3 != null ? mediaMetadata3.id : null);
                                PlayerConnection playerConnection2 = playerConnection;
                                if (zAreEqual4) {
                                    playerConnection2.togglePlayPause();
                                } else {
                                    playerConnection2.playQueue(new YouTubeQueue(new WatchEndpoint(62, str2, null, null), HexFormatKt.toMediaMetadata(songItem2)));
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.YouTubeGridItem(songItem, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function1, (Function0) objRememberedValue4, 239)), (CoroutineScope) obj5, null, CropImageView.DEFAULT_ASPECT_RATIO, zAreEqual3, zBooleanValue2, false, gapComposer2, 0, 152);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                final PlayerConnection playerConnection2 = (PlayerConnection) obj5;
                HapticFeedback hapticFeedback3 = (HapticFeedback) obj6;
                final MutableState mutableState = (MutableState) obj7;
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    final SongWithStats songWithStats = (SongWithStats) list.get(iIntValue5);
                    gapComposer3.startReplaceGroup(503760105);
                    String str2 = (iIntValue5 + 1) + ". " + songWithStats.title;
                    int i4 = songWithStats.songCountListened;
                    String strJoinByBullet = UtilsKt.joinByBullet(MathKt.pluralStringResource(R.plurals.n_time, i4, new Object[]{Integer.valueOf(i4)}, gapComposer3), UtilsKt.makeTimeString(songWithStats.timeListened));
                    String str3 = songWithStats.thumbnailUrl;
                    String str4 = songWithStats.id;
                    MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                    boolean zAreEqual4 = Intrinsics.areEqual(str4, mediaMetadata3 != null ? mediaMetadata3.id : null);
                    boolean zBooleanValue3 = ((Boolean) state.getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged = gapComposer3.changed(mutableState) | gapComposer3.changed(songWithStats) | gapComposer3.changedInstance(hapticFeedback3);
                    MenuState menuState2 = this.$menuState$inlined;
                    boolean zChanged2 = zChanged | gapComposer3.changed(menuState2);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new QueueKt$Queue$5$4$1$1$7$1$1$1(hapticFeedback3, menuState2, (Object) mutableState, (Object) songWithStats, (byte) 3);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function2 = (Function0) objRememberedValue5;
                    boolean zChanged3 = gapComposer3.changed(songWithStats) | gapComposer3.changed(state2) | gapComposer3.changedInstance(playerConnection2) | gapComposer3.changed(mutableState);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$4$2$1$2$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Object next;
                                String str5 = songWithStats.id;
                                MediaMetadata mediaMetadata4 = (MediaMetadata) state2.getValue();
                                boolean zAreEqual5 = Intrinsics.areEqual(str5, mediaMetadata4 != null ? mediaMetadata4.id : null);
                                PlayerConnection playerConnection3 = playerConnection2;
                                if (zAreEqual5) {
                                    playerConnection3.togglePlayPause();
                                } else {
                                    Iterator it = ((List) mutableState.getValue()).iterator();
                                    do {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                    } while (!Intrinsics.areEqual(((Song) next).song.id, str5));
                                    Song song = (Song) next;
                                    if (song != null) {
                                        playerConnection3.playQueue(new YouTubeQueue(new WatchEndpoint(62, str5, null, null), HexFormatKt.toMediaMetadata(song)));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    MenuKt.LocalSongsGrid(str2, strJoinByBullet, null, str3, zAreEqual4, zBooleanValue3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function2, (Function0) objRememberedValue6, 239), gapComposer3, 0);
                    gapComposer3.end(false);
                }
                break;
            case 3:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                final NavHostController navHostController2 = (NavHostController) obj7;
                final PlayerConnection playerConnection3 = (PlayerConnection) obj6;
                int i5 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i5 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    final YTItem yTItem = (YTItem) ((ArrayList) list).get(iIntValue7);
                    gapComposer4.startReplaceGroup(-265167592);
                    if (yTItem != null) {
                        if (yTItem instanceof SongItem) {
                            MediaMetadata mediaMetadata4 = (MediaMetadata) state2.getValue();
                            zAreEqual = Intrinsics.areEqual(mediaMetadata4 != null ? mediaMetadata4.id : null, ((SongItem) yTItem).id);
                        } else if (yTItem instanceof AlbumItem) {
                            MediaMetadata mediaMetadata5 = (MediaMetadata) state2.getValue();
                            zAreEqual = Intrinsics.areEqual((mediaMetadata5 == null || (album2 = mediaMetadata5.album) == null) ? null : album2.id, ((AlbumItem) yTItem).id);
                        } else {
                            z = false;
                        }
                        z = zAreEqual;
                    } else {
                        z = false;
                    }
                    boolean zBooleanValue4 = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance5 = gapComposer4.changedInstance(yTItem) | gapComposer4.changed(state2) | gapComposer4.changedInstance(playerConnection3) | gapComposer4.changedInstance(navHostController2);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$3$1$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                YTItem yTItem2 = yTItem;
                                if (yTItem2 != null) {
                                    boolean z3 = yTItem2 instanceof SongItem;
                                    PlayerConnection playerConnection4 = playerConnection3;
                                    State state3 = state2;
                                    if (z3) {
                                        SongItem songItem2 = (SongItem) yTItem2;
                                        String str5 = songItem2.id;
                                        MediaMetadata mediaMetadata6 = (MediaMetadata) state3.getValue();
                                        if (Intrinsics.areEqual(str5, mediaMetadata6 != null ? mediaMetadata6.id : null)) {
                                            playerConnection4.togglePlayPause();
                                        } else {
                                            WatchEndpoint watchEndpoint = songItem2.endpoint;
                                            if (watchEndpoint == null) {
                                                watchEndpoint = new WatchEndpoint(62, str5, null, null);
                                            }
                                            playerConnection4.playQueue(new YouTubeQueue(watchEndpoint, HexFormatKt.toMediaMetadata(songItem2)));
                                        }
                                    } else {
                                        boolean z4 = yTItem2 instanceof AlbumItem;
                                        NavHostController navHostController3 = navHostController2;
                                        if (z4) {
                                            Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem2).id, navHostController3);
                                        } else if (yTItem2 instanceof ArtistItem) {
                                            Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem2).id, navHostController3);
                                        } else if (yTItem2 instanceof PlaylistItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) yTItem2).id, navHostController3);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_podcast/", ((PodcastItem) yTItem2).id, navHostController3);
                                        } else if (yTItem2 instanceof EpisodeItem) {
                                            EpisodeItem episodeItem = (EpisodeItem) yTItem2;
                                            String str6 = episodeItem.id;
                                            MediaMetadata mediaMetadata7 = (MediaMetadata) state3.getValue();
                                            if (Intrinsics.areEqual(str6, mediaMetadata7 != null ? mediaMetadata7.id : null)) {
                                                playerConnection4.togglePlayPause();
                                            } else {
                                                WatchEndpoint watchEndpoint2 = episodeItem.endpoint;
                                                if (watchEndpoint2 == null) {
                                                    watchEndpoint2 = new WatchEndpoint(62, str6, null, null);
                                                }
                                                playerConnection4.playQueue(new YouTubeQueue(watchEndpoint2, HexFormatKt.toMediaMetadata(episodeItem)));
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                        };
                        gapComposer4.updateRememberedValue(objRememberedValue7);
                    }
                    MenuKt.YouTubeListItem(yTItem, ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue7, 15), false, z, zBooleanValue4, false, null, Expect_jvmKt.rememberComposableLambda(577005073, new BrowseScreenKt$BrowseScreen$1$1$1$4$1$1.AnonymousClass1(menuState, yTItem, (CoroutineScope) obj5), gapComposer4), null, gapComposer4, 100663296, 716);
                    gapComposer4.end(false);
                }
                break;
            default:
                PlayerConnection playerConnection4 = (PlayerConnection) obj6;
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                int iIntValue9 = ((Number) obj2).intValue();
                Composer composer5 = (Composer) obj3;
                int iIntValue10 = ((Number) obj4).intValue();
                int i6 = (iIntValue10 & 6) == 0 ? iIntValue10 | (((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2) : iIntValue10;
                if ((iIntValue10 & 48) == 0) {
                    i6 |= ((GapComposer) composer5).changed(iIntValue9) ? 32 : 16;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(i6 & 1, (i6 & 147) != 146)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    Song song = (Song) list.get(iIntValue9);
                    gapComposer5.startReplaceGroup(1329011039);
                    List list2 = song.artists;
                    SongEntity songEntity = song.song;
                    Object objRememberedValue8 = gapComposer5.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = LibraryPodcastsScreenKt$LibraryPodcastsScreen$4$3$1$5$channelName$1$1.INSTANCE;
                        gapComposer5.updateRememberedValue(objRememberedValue8);
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(list2, null, null, null, (Function1) objRememberedValue8, 31);
                    if (strJoinToString$default.length() == 0 && (strJoinToString$default = songEntity.albumName) == null) {
                        strJoinToString$default = "";
                    }
                    String strJoinByBullet2 = UtilsKt.joinByBullet(strJoinToString$default, UtilsKt.makeTimeString(Long.valueOf(((long) songEntity.duration) * 1000)));
                    String str5 = songEntity.id;
                    MediaMetadata mediaMetadata6 = (MediaMetadata) state2.getValue();
                    boolean zAreEqual5 = Intrinsics.areEqual(str5, mediaMetadata6 != null ? mediaMetadata6.id : null);
                    boolean zBooleanValue5 = ((Boolean) ((State) obj5).getValue()).booleanValue();
                    String str6 = strJoinByBullet2.length() == 0 ? null : strJoinByBullet2;
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged4 = gapComposer5.changed(song) | gapComposer5.changed(state2) | gapComposer5.changedInstance(playerConnection4) | gapComposer5.changed((String) obj7) | gapComposer5.changed(state);
                    if ((((i6 & 112) ^ 48) <= 32 || !gapComposer5.changed(iIntValue9)) && (i6 & 48) != 32) {
                        z2 = false;
                    }
                    boolean z3 = zChanged4 | z2;
                    Object objRememberedValue9 = gapComposer5.rememberedValue();
                    if (z3 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new ArtistSongsScreenKt$ArtistSongsScreen$1$1$1$3$2$1(song, playerConnection4, (String) obj7, iIntValue9, this.$mediaMetadata$delegate$inlined, this.$isPlaying$delegate$inlined, (byte) 1);
                        gapComposer5.updateRememberedValue(objRememberedValue9);
                    }
                    MenuKt.SongListItem(song, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue9, 15)), null, false, false, true, str6, null, zAreEqual5, zBooleanValue5, false, Expect_jvmKt.rememberComposableLambda(1955728380, new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1.AnonymousClass1(menuState, song, (byte) 9), gapComposer5), null, gapComposer5, 224256, 384, 10628);
                    gapComposer5.end(false);
                }
                break;
        }
        return unit;
    }

    public NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(ArrayList arrayList, HapticFeedback hapticFeedback, MenuState menuState, State state, PlayerConnection playerConnection, CoroutineScope coroutineScope, State state2) {
        this.$items = arrayList;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$mediaMetadata$delegate$inlined = state;
        this.$navController$inlined = playerConnection;
        this.$coroutineScope$inlined = coroutineScope;
        this.$isPlaying$delegate$inlined = state2;
    }

    public NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(List list, MutableState mutableState, HapticFeedback hapticFeedback, MenuState menuState, State state, PlayerConnection playerConnection, State state2) {
        this.$items = list;
        this.$navController$inlined = mutableState;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$mediaMetadata$delegate$inlined = state;
        this.$coroutineScope$inlined = playerConnection;
        this.$isPlaying$delegate$inlined = state2;
    }

    public NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(List list, State state, PlayerConnection playerConnection, String str, State state2, State state3, MenuState menuState) {
        this.$items = list;
        this.$mediaMetadata$delegate$inlined = state;
        this.$haptic$inlined = playerConnection;
        this.$navController$inlined = str;
        this.$isPlaying$delegate$inlined = state2;
        this.$coroutineScope$inlined = state3;
        this.$menuState$inlined = menuState;
    }

    public NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(List list, HapticFeedback hapticFeedback, MenuState menuState, NavHostController navHostController, CoroutineScope coroutineScope, State state, State state2) {
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$navController$inlined = navHostController;
        this.$coroutineScope$inlined = coroutineScope;
        this.$mediaMetadata$delegate$inlined = state;
        this.$isPlaying$delegate$inlined = state2;
    }
}
