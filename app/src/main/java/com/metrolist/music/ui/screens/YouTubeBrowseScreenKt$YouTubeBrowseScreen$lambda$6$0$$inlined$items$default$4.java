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
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$2$1$1$6$1$1;
import com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$ArtistSongsScreen$1$1$1$3$2$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ Object $coroutineScope$inlined;
    public final /* synthetic */ Object $haptic$inlined;
    public final /* synthetic */ State $isPlaying$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ State $mediaMetadata$delegate$inlined;
    public final /* synthetic */ MenuState $menuState$inlined;
    public final /* synthetic */ Object $navController$inlined;
    public final /* synthetic */ PlayerConnection $playerConnection$inlined;
    public final /* synthetic */ byte $r8$classId;

    public YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(ArrayList arrayList, State state, PlayerConnection playerConnection, String str, ArrayList arrayList2, State state2, MutableState mutableState, MenuState menuState) {
        this.$r8$classId = (byte) 3;
        this.$items = arrayList;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$haptic$inlined = str;
        this.$coroutineScope$inlined = arrayList2;
        this.$isPlaying$delegate$inlined = state2;
        this.$navController$inlined = mutableState;
        this.$menuState$inlined = menuState;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x0467  */
    /* JADX WARN: Code duplicated, block: B:231:0x0594  */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean zAreEqual;
        MediaMetadata.Album album;
        boolean zAreEqual2;
        MediaMetadata.Album album2;
        Object librarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1;
        Song song;
        byte b = this.$r8$classId;
        MenuState menuState = this.$menuState$inlined;
        Unit unit = Unit.INSTANCE;
        State state = this.$isPlaying$delegate$inlined;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Object obj5 = this.$navController$inlined;
        List list = this.$items;
        final State state2 = this.$mediaMetadata$delegate$inlined;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj6 = this.$haptic$inlined;
        Object obj7 = this.$coroutineScope$inlined;
        switch (b) {
            case 0:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                final NavHostController navHostController = (NavHostController) obj5;
                CoroutineScope coroutineScope = (CoroutineScope) obj7;
                HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    final YTItem yTItem = (YTItem) list.get(iIntValue);
                    gapComposer.startReplaceGroup(-379030337);
                    if (yTItem == null) {
                        zAreEqual = false;
                    } else if (yTItem instanceof SongItem) {
                        MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                        zAreEqual = Intrinsics.areEqual(mediaMetadata != null ? mediaMetadata.id : null, ((SongItem) yTItem).id);
                    } else if (yTItem instanceof AlbumItem) {
                        MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                        zAreEqual = Intrinsics.areEqual((mediaMetadata2 == null || (album = mediaMetadata2.album) == null) ? null : album.id, ((AlbumItem) yTItem).id);
                    } else {
                        zAreEqual = false;
                    }
                    boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback);
                    MenuState menuState2 = this.$menuState$inlined;
                    boolean zChanged = zChangedInstance | gapComposer.changed(menuState2) | gapComposer.changedInstance(yTItem) | gapComposer.changedInstance(coroutineScope);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$1$1(hapticFeedback, menuState2, yTItem, coroutineScope, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer.changedInstance(yTItem) | gapComposer.changed(state2);
                    final PlayerConnection playerConnection = this.$playerConnection$inlined;
                    boolean zChangedInstance3 = zChangedInstance2 | gapComposer.changedInstance(playerConnection) | gapComposer.changedInstance(navHostController);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                YTItem yTItem2 = yTItem;
                                if (yTItem2 != null) {
                                    boolean z = yTItem2 instanceof SongItem;
                                    PlayerConnection playerConnection2 = playerConnection;
                                    State state3 = state2;
                                    if (z) {
                                        SongItem songItem = (SongItem) yTItem2;
                                        String str = songItem.id;
                                        MediaMetadata mediaMetadata3 = (MediaMetadata) state3.getValue();
                                        if (Intrinsics.areEqual(str, mediaMetadata3 != null ? mediaMetadata3.id : null)) {
                                            playerConnection2.togglePlayPause();
                                        } else {
                                            playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(songItem)));
                                        }
                                    } else {
                                        boolean z2 = yTItem2 instanceof AlbumItem;
                                        NavHostController navHostController2 = navHostController;
                                        if (z2) {
                                            Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof ArtistItem) {
                                            Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof PlaylistItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_podcast/", ((PodcastItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof EpisodeItem) {
                                            EpisodeItem episodeItem = (EpisodeItem) yTItem2;
                                            String str2 = episodeItem.id;
                                            MediaMetadata mediaMetadata4 = (MediaMetadata) state3.getValue();
                                            if (Intrinsics.areEqual(str2, mediaMetadata4 != null ? mediaMetadata4.id : null)) {
                                                playerConnection2.togglePlayPause();
                                            } else {
                                                playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(episodeItem)));
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.YouTubeGridItem(yTItem, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function0, (Function0) objRememberedValue2, 239)), (CoroutineScope) obj7, null, CropImageView.DEFAULT_ASPECT_RATIO, zAreEqual, zBooleanValue, true, gapComposer, 12582912, 24);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                final NavHostController navHostController2 = (NavHostController) obj5;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj7;
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj6;
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyGridItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final YTItem yTItem2 = (YTItem) ((ArrayList) list).get(iIntValue3);
                    gapComposer2.startReplaceGroup(-211276957);
                    if (yTItem2 == null) {
                        zAreEqual2 = false;
                    } else if (yTItem2 instanceof SongItem) {
                        MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                        zAreEqual2 = Intrinsics.areEqual(mediaMetadata3 != null ? mediaMetadata3.id : null, ((SongItem) yTItem2).id);
                    } else if (yTItem2 instanceof AlbumItem) {
                        MediaMetadata mediaMetadata4 = (MediaMetadata) state2.getValue();
                        zAreEqual2 = Intrinsics.areEqual((mediaMetadata4 == null || (album2 = mediaMetadata4.album) == null) ? null : album2.id, ((AlbumItem) yTItem2).id);
                    } else {
                        zAreEqual2 = false;
                    }
                    boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                    boolean zChangedInstance4 = gapComposer2.changedInstance(hapticFeedback2);
                    MenuState menuState3 = this.$menuState$inlined;
                    boolean zChanged2 = zChangedInstance4 | gapComposer2.changed(menuState3) | gapComposer2.changedInstance(yTItem2) | gapComposer2.changedInstance(coroutineScope2);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$1$1(hapticFeedback2, menuState3, yTItem2, coroutineScope2, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1 = (Function0) objRememberedValue3;
                    boolean zChangedInstance5 = gapComposer2.changedInstance(yTItem2);
                    final PlayerConnection playerConnection2 = this.$playerConnection$inlined;
                    boolean zChangedInstance6 = zChangedInstance5 | gapComposer2.changedInstance(playerConnection2) | gapComposer2.changedInstance(navHostController2);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$4$1$3$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                YTItem yTItem3 = yTItem2;
                                if (yTItem3 != null) {
                                    boolean z = yTItem3 instanceof SongItem;
                                    PlayerConnection playerConnection3 = playerConnection2;
                                    if (z) {
                                        SongItem songItem = (SongItem) yTItem3;
                                        WatchEndpoint watchEndpoint = songItem.endpoint;
                                        if (watchEndpoint == null) {
                                            watchEndpoint = new WatchEndpoint(62, songItem.id, null, null);
                                        }
                                        playerConnection3.playQueue(new YouTubeQueue(watchEndpoint, HexFormatKt.toMediaMetadata(songItem)));
                                    } else {
                                        boolean z2 = yTItem3 instanceof AlbumItem;
                                        NavHostController navHostController3 = navHostController2;
                                        if (z2) {
                                            Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem3).id, navHostController3);
                                        } else if (yTItem3 instanceof ArtistItem) {
                                            Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem3).id, navHostController3);
                                        } else if (yTItem3 instanceof PlaylistItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) yTItem3).id, navHostController3);
                                        } else if (yTItem3 instanceof PodcastItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_podcast/", ((PodcastItem) yTItem3).id, navHostController3);
                                        } else if (yTItem3 instanceof EpisodeItem) {
                                            EpisodeItem episodeItem = (EpisodeItem) yTItem3;
                                            WatchEndpoint watchEndpoint2 = episodeItem.endpoint;
                                            if (watchEndpoint2 == null) {
                                                watchEndpoint2 = new WatchEndpoint(62, episodeItem.id, null, null);
                                            }
                                            playerConnection3.playQueue(new YouTubeQueue(watchEndpoint2, HexFormatKt.toMediaMetadata(episodeItem)));
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.YouTubeGridItem(yTItem2, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function1, (Function0) objRememberedValue4, 239), (CoroutineScope) obj7, null, CropImageView.DEFAULT_ASPECT_RATIO, zAreEqual2, zBooleanValue2, true, gapComposer2, 12582912, 24);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                HapticFeedback hapticFeedback3 = (HapticFeedback) obj6;
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Song song2 = (Song) list.get(iIntValue5);
                    gapComposer3.startReplaceGroup(-1331448916);
                    String str = song2.song.id;
                    MediaMetadata mediaMetadata5 = (MediaMetadata) state2.getValue();
                    boolean zAreEqual3 = Intrinsics.areEqual(str, mediaMetadata5 != null ? mediaMetadata5.id : null);
                    boolean zBooleanValue3 = ((Boolean) ((State) obj5).getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChangedInstance7 = gapComposer3.changedInstance(hapticFeedback3) | gapComposer3.changed(menuState) | gapComposer3.changed(song2);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new ArtistScreenKt$ArtistScreen$2$1$1$6$1$1(hapticFeedback3, menuState, song2, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function2 = (Function0) objRememberedValue5;
                    boolean zChanged3 = gapComposer3.changed(song2) | gapComposer3.changed(state2);
                    PlayerConnection playerConnection3 = this.$playerConnection$inlined;
                    boolean zChanged4 = gapComposer3.changed(state) | zChanged3 | gapComposer3.changedInstance(playerConnection3) | gapComposer3.changed((String) obj7) | ((((i3 & 112) ^ 48) > 32 && gapComposer3.changed(iIntValue5)) || (i3 & 48) == 32);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new ArtistSongsScreenKt$ArtistSongsScreen$1$1$1$3$2$1(song2, playerConnection3, (String) obj7, iIntValue5, this.$mediaMetadata$delegate$inlined, this.$isPlaying$delegate$inlined, (byte) 0);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    MenuKt.SongListItem(song2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function2, (Function0) objRememberedValue6, 239), null, false, true, false, null, null, zAreEqual3, zBooleanValue3, false, Expect_jvmKt.rememberComposableLambda(857214733, new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1.AnonymousClass1(menuState, song2, (byte) 7), gapComposer3), null, gapComposer3, 24576, 384, 10732);
                    gapComposer3.end(false);
                }
                break;
            case 3:
                ArrayList arrayList = (ArrayList) obj7;
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                int i4 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    Song song3 = (Song) ((ArrayList) list).get(iIntValue7);
                    gapComposer4.startReplaceGroup(1228916406);
                    String str2 = song3.song.id;
                    MediaMetadata mediaMetadata6 = (MediaMetadata) state2.getValue();
                    boolean zAreEqual4 = Intrinsics.areEqual(str2, mediaMetadata6 != null ? mediaMetadata6.id : null);
                    boolean zBooleanValue4 = ((Boolean) state.getValue()).booleanValue();
                    boolean z = ((SongFilter) ((MutableState) obj5).getValue()) != SongFilter.DOWNLOADED;
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged5 = gapComposer4.changed(song3) | gapComposer4.changed(state2);
                    PlayerConnection playerConnection4 = this.$playerConnection$inlined;
                    boolean zChangedInstance8 = zChanged5 | gapComposer4.changedInstance(playerConnection4) | gapComposer4.changed((String) obj6) | gapComposer4.changedInstance(arrayList) | ((((i4 & 112) ^ 48) > 32 && gapComposer4.changed(iIntValue7)) || (i4 & 48) == 32);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (zChangedInstance8 || objRememberedValue7 == neverEqualPolicy) {
                        song = song3;
                        librarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1 = new LibrarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1(song, playerConnection4, (String) obj6, arrayList, iIntValue7, this.$mediaMetadata$delegate$inlined);
                        gapComposer4.updateRememberedValue(librarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1);
                    } else {
                        librarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1 = objRememberedValue7;
                        song = song3;
                    }
                    MenuKt.SongListItem(song, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) librarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1, 15)), null, true, true, z, null, null, zAreEqual4, zBooleanValue4, false, Expect_jvmKt.rememberComposableLambda(934285107, new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1.AnonymousClass1(menuState, song, (byte) 11), gapComposer4), null, gapComposer4, 27648, 384, 10692);
                    gapComposer4.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue9 = ((Number) obj2).intValue();
                Composer composer5 = (Composer) obj3;
                int iIntValue10 = ((Number) obj4).intValue();
                HapticFeedback hapticFeedback4 = (HapticFeedback) obj6;
                int i5 = (iIntValue10 & 6) == 0 ? iIntValue10 | (((GapComposer) composer5).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue10;
                if ((iIntValue10 & 48) == 0) {
                    i5 |= ((GapComposer) composer5).changed(iIntValue9) ? 32 : 16;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    EpisodeItem episodeItem = (EpisodeItem) list.get(iIntValue9);
                    gapComposer5.startReplaceGroup(-108363700);
                    MediaMetadata mediaMetadata7 = (MediaMetadata) state2.getValue();
                    boolean zAreEqual5 = Intrinsics.areEqual(mediaMetadata7 != null ? mediaMetadata7.id : null, episodeItem.id);
                    boolean zBooleanValue5 = ((Boolean) ((State) obj5).getValue()).booleanValue();
                    boolean zChangedInstance9 = gapComposer5.changedInstance(hapticFeedback4) | gapComposer5.changed(menuState) | gapComposer5.changedInstance(episodeItem);
                    Object objRememberedValue8 = gapComposer5.rememberedValue();
                    if (zChangedInstance9 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new AccountScreenKt$AccountScreen$1$1$11$1$1((Object) hapticFeedback4, (Object) menuState, (Object) episodeItem, (byte) 5);
                        gapComposer5.updateRememberedValue(objRememberedValue8);
                    }
                    Function0 function3 = (Function0) objRememberedValue8;
                    boolean zChangedInstance10 = gapComposer5.changedInstance(episodeItem) | gapComposer5.changed(state2);
                    PlayerConnection playerConnection5 = this.$playerConnection$inlined;
                    boolean zChangedInstance11 = zChangedInstance10 | gapComposer5.changedInstance(playerConnection5) | ((((i5 & 112) ^ 48) > 32 && gapComposer5.changed(iIntValue9)) || (i5 & 48) == 32) | gapComposer5.changedInstance((List) obj7) | gapComposer5.changed(state);
                    Object objRememberedValue9 = gapComposer5.rememberedValue();
                    if (zChangedInstance11 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new LibrarySongsScreenKt$LibrarySongsScreen$6$1$1$5$1$1(episodeItem, playerConnection5, iIntValue9, (List) obj7, this.$mediaMetadata$delegate$inlined, this.$isPlaying$delegate$inlined);
                        gapComposer5.updateRememberedValue(objRememberedValue9);
                    }
                    MenuKt.YouTubeListItem(episodeItem, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function3, (Function0) objRememberedValue9, 239), false, zAreEqual5, zBooleanValue5, false, null, Expect_jvmKt.rememberComposableLambda(-420953808, new OnlinePodcastScreenKt$OnlinePodcastScreen$3$1$1$2$3$3(menuState, episodeItem), gapComposer5), null, gapComposer5, 100663296, 716);
                    gapComposer5.end(false);
                }
                break;
        }
        return unit;
    }

    public YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(ArrayList arrayList, HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, PlayerConnection playerConnection, NavHostController navHostController, State state, State state2) {
        this.$r8$classId = (byte) 1;
        this.$items = arrayList;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$coroutineScope$inlined = coroutineScope;
        this.$playerConnection$inlined = playerConnection;
        this.$navController$inlined = navHostController;
        this.$mediaMetadata$delegate$inlined = state;
        this.$isPlaying$delegate$inlined = state2;
    }

    public /* synthetic */ YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(List list, HapticFeedback hapticFeedback, MenuState menuState, State state, PlayerConnection playerConnection, Object obj, State state2, State state3, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$coroutineScope$inlined = obj;
        this.$isPlaying$delegate$inlined = state2;
        this.$navController$inlined = state3;
    }

    public YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(List list, HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, State state, PlayerConnection playerConnection, NavHostController navHostController, State state2) {
        this.$r8$classId = (byte) 0;
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$coroutineScope$inlined = coroutineScope;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$navController$inlined = navHostController;
        this.$isPlaying$delegate$inlined = state2;
    }
}
