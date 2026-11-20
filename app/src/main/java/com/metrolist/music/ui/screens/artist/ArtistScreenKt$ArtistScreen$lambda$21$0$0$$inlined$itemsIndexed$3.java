package com.metrolist.music.ui.screens.artist;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
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
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$3$1$1;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$1$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3 implements Function4 {
    public final /* synthetic */ Object $displayArtistName$inlined;
    public final /* synthetic */ HapticFeedback $haptic$inlined;
    public final /* synthetic */ boolean $isGuest$inlined;
    public final /* synthetic */ Object $isPlaying$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ State $librarySongs$delegate$inlined;
    public final /* synthetic */ State $mediaMetadata$delegate$inlined;
    public final /* synthetic */ MenuState $menuState$inlined;
    public final /* synthetic */ PlayerConnection $playerConnection$inlined;
    public final /* synthetic */ byte $r8$classId = 1;

    public ArtistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3(List list, HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, boolean z, PlayerConnection playerConnection, NavHostController navHostController, State state, State state2) {
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$isPlaying$delegate$inlined = coroutineScope;
        this.$isGuest$inlined = z;
        this.$playerConnection$inlined = playerConnection;
        this.$displayArtistName$inlined = navHostController;
        this.$mediaMetadata$delegate$inlined = state;
        this.$librarySongs$delegate$inlined = state2;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean z;
        boolean zAreEqual;
        MediaMetadata.Album album;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        State state = this.$librarySongs$delegate$inlined;
        List list = this.$items;
        State state2 = this.$mediaMetadata$delegate$inlined;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final boolean z2 = this.$isGuest$inlined;
        boolean z3 = true;
        Object obj5 = this.$isPlaying$delegate$inlined;
        Object obj6 = this.$displayArtistName$inlined;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                final int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    final Song song = (Song) list.get(iIntValue);
                    gapComposer.startReplaceGroup(459079798);
                    String str = song.song.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    boolean zAreEqual2 = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                    boolean zBooleanValue = ((Boolean) ((State) obj5).getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    HapticFeedback hapticFeedback = this.$haptic$inlined;
                    boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback);
                    MenuState menuState = this.$menuState$inlined;
                    boolean zChanged = zChangedInstance | gapComposer.changed(menuState) | gapComposer.changed(song);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ArtistScreenKt$ArtistScreen$2$1$1$6$1$1(hapticFeedback, menuState, song, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChanged2 = gapComposer.changed(z2) | gapComposer.changed(song) | gapComposer.changed(state2);
                    final PlayerConnection playerConnection = this.$playerConnection$inlined;
                    boolean zChanged3 = gapComposer.changed(state) | zChanged2 | gapComposer.changedInstance(playerConnection) | gapComposer.changed((String) obj6);
                    if ((((i & 112) ^ 48) <= 32 || !gapComposer.changed(iIntValue)) && (i & 48) != 32) {
                        z3 = false;
                    }
                    boolean z4 = zChanged3 | z3;
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (z4 || objRememberedValue2 == neverEqualPolicy) {
                        final String str2 = (String) obj6;
                        final State state3 = this.$mediaMetadata$delegate$inlined;
                        final State state4 = this.$librarySongs$delegate$inlined;
                        final boolean z5 = this.$isGuest$inlined;
                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$2$1$1$6$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                if (!z5) {
                                    String str3 = song.song.id;
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state3.getValue();
                                    boolean zAreEqual3 = Intrinsics.areEqual(str3, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                    PlayerConnection playerConnection2 = playerConnection;
                                    if (zAreEqual3) {
                                        playerConnection2.togglePlayPause();
                                    } else {
                                        String str4 = str2;
                                        if (str4 == null) {
                                            str4 = "Unknown Artist";
                                        }
                                        String str5 = str4;
                                        List list2 = (List) state4.getValue();
                                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                        Iterator it = list2.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                                        }
                                        playerConnection2.playQueue(new ListQueue(str5, arrayList, iIntValue, 0L, 8, null));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.SongListItem(song, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) objRememberedValue2, 239), null, false, true, false, null, null, zAreEqual2, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(290494965, new AlbumScreenKt$AlbumScreen$3$1$4$3$1$1.AnonymousClass1(menuState, song, (byte) 4), gapComposer), null, gapComposer, 24576, 384, 10732);
                    gapComposer.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                final NavHostController navHostController = (NavHostController) obj6;
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final YTItem yTItem = (YTItem) list.get(iIntValue3);
                    gapComposer2.startReplaceGroup(-902842562);
                    if (yTItem != null) {
                        if (yTItem instanceof SongItem) {
                            MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                            zAreEqual = Intrinsics.areEqual(mediaMetadata2 != null ? mediaMetadata2.id : null, ((SongItem) yTItem).id);
                        } else if (yTItem instanceof AlbumItem) {
                            MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                            zAreEqual = Intrinsics.areEqual((mediaMetadata3 == null || (album = mediaMetadata3.album) == null) ? null : album.id, ((AlbumItem) yTItem).id);
                        } else {
                            z = false;
                        }
                        z = zAreEqual;
                    } else {
                        z = false;
                    }
                    boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                    HapticFeedback hapticFeedback2 = this.$haptic$inlined;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(hapticFeedback2);
                    MenuState menuState2 = this.$menuState$inlined;
                    boolean zChanged4 = zChangedInstance2 | gapComposer2.changed(menuState2) | gapComposer2.changedInstance(yTItem) | gapComposer2.changedInstance(coroutineScope);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new YouTubeBrowseScreenKt$YouTubeBrowseScreen$1$1$3$1$1(hapticFeedback2, menuState2, yTItem, coroutineScope, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1 = (Function0) objRememberedValue3;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(yTItem) | gapComposer2.changed(z2);
                    final PlayerConnection playerConnection2 = this.$playerConnection$inlined;
                    boolean zChangedInstance4 = zChangedInstance3 | gapComposer2.changedInstance(playerConnection2) | gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$2$1$1$9$5$1$1$3$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                YTItem yTItem2 = yTItem;
                                if (yTItem2 != null) {
                                    boolean z6 = yTItem2 instanceof SongItem;
                                    PlayerConnection playerConnection3 = playerConnection2;
                                    boolean z7 = z2;
                                    if (!z6) {
                                        boolean z8 = yTItem2 instanceof AlbumItem;
                                        NavHostController navHostController2 = navHostController;
                                        if (z8) {
                                            Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof ArtistItem) {
                                            Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof PlaylistItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof PodcastItem) {
                                            Format$$ExternalSyntheticOutline0.m("online_podcast/", ((PodcastItem) yTItem2).id, navHostController2);
                                        } else if (yTItem2 instanceof EpisodeItem) {
                                            if (!z7) {
                                                EpisodeItem episodeItem = (EpisodeItem) yTItem2;
                                                playerConnection3.playQueue(new YouTubeQueue(new WatchEndpoint(62, episodeItem.id, null, null), HexFormatKt.toMediaMetadata(episodeItem)));
                                            }
                                        }
                                    } else if (!z7) {
                                        SongItem songItem = (SongItem) yTItem2;
                                        playerConnection3.playQueue(new YouTubeQueue(new WatchEndpoint(62, songItem.id, null, null), HexFormatKt.toMediaMetadata(songItem)));
                                    }
                                    return Unit.INSTANCE;
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.YouTubeGridItem(yTItem, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function1, (Function0) objRememberedValue4, 239), (CoroutineScope) obj5, null, 1.0f, z, zBooleanValue2, false, gapComposer2, 24576, 136);
                    gapComposer2.end(false);
                }
                break;
        }
        return unit;
    }

    public ArtistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3(List list, HapticFeedback hapticFeedback, MenuState menuState, boolean z, State state, PlayerConnection playerConnection, String str, State state2, State state3) {
        this.$items = list;
        this.$haptic$inlined = hapticFeedback;
        this.$menuState$inlined = menuState;
        this.$isGuest$inlined = z;
        this.$mediaMetadata$delegate$inlined = state;
        this.$playerConnection$inlined = playerConnection;
        this.$displayArtistName$inlined = str;
        this.$librarySongs$delegate$inlined = state2;
        this.$isPlaying$delegate$inlined = state3;
    }
}
