package com.metrolist.music.ui.menu;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$3;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistDialogKt$AddToPlaylistDialog$lambda$24$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ Object $addToPlaylistPosition$inlined;
    public final /* synthetic */ Object $coroutineScope$inlined;
    public final /* synthetic */ Object $database$inlined;
    public final /* synthetic */ State $duplicates$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ Object $onDismiss$inlined;
    public final /* synthetic */ Object $onGetSong$inlined;
    public final /* synthetic */ MutableState $playlistsContainingSong$delegate$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $selectedPlaylist$delegate$inlined;
    public final /* synthetic */ Object $showDuplicateDialog$delegate$inlined;
    public final /* synthetic */ MutableState $songIds$delegate$inlined;
    public final /* synthetic */ Object $syncUtils$inlined;

    public AddToPlaylistDialogKt$AddToPlaylistDialog$lambda$24$0$$inlined$items$default$4(List list, CoroutineScope coroutineScope, Function1 function1, MusicDatabase musicDatabase, AddToPlaylistPosition addToPlaylistPosition, SyncUtils syncUtils, Function0 function0, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        this.$r8$classId = (byte) 0;
        this.$items = list;
        this.$coroutineScope$inlined = coroutineScope;
        this.$onGetSong$inlined = function1;
        this.$database$inlined = musicDatabase;
        this.$addToPlaylistPosition$inlined = addToPlaylistPosition;
        this.$syncUtils$inlined = syncUtils;
        this.$onDismiss$inlined = function0;
        this.$playlistsContainingSong$delegate$inlined = mutableState;
        this.$selectedPlaylist$delegate$inlined = mutableState2;
        this.$songIds$delegate$inlined = mutableState3;
        this.$duplicates$delegate$inlined = mutableState4;
        this.$showDuplicateDialog$delegate$inlined = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        long j;
        Playlist playlist;
        int i2;
        GapComposer gapComposer;
        int i3;
        Song song;
        Song song2;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        State state = this.$duplicates$delegate$inlined;
        List list = this.$items;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.$playlistsContainingSong$delegate$inlined;
        Object obj5 = this.$syncUtils$inlined;
        Object obj6 = this.$onDismiss$inlined;
        Object obj7 = this.$database$inlined;
        Object obj8 = this.$onGetSong$inlined;
        Object obj9 = this.$addToPlaylistPosition$inlined;
        Object obj10 = this.$coroutineScope$inlined;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i = iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2);
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(i & 1, (i & 147) != 146)) {
                    final Playlist playlist2 = (Playlist) list.get(iIntValue);
                    gapComposer2.startReplaceGroup(1819285733);
                    if (((Set) mutableState.getValue()).contains(playlist2.playlist.id)) {
                        gapComposer2.startReplaceGroup(1721259977);
                        j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(1721261508);
                        gapComposer2.end(false);
                        j = 0;
                    }
                    Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(OffsetKt.m136paddingVpY3zN4(companion, 8.0f, 2.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f)), ((Color) SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), "playlistBg", gapComposer2, 432, 8).getValue()).value, ColorKt.RectangleShape);
                    boolean zChanged = gapComposer2.changed(playlist2) | gapComposer2.changedInstance((CoroutineScope) obj10) | gapComposer2.changedInstance((Function1) obj8) | gapComposer2.changedInstance((MusicDatabase) obj7) | gapComposer2.changed(((AddToPlaylistPosition) obj9).ordinal()) | gapComposer2.changedInstance((SyncUtils) obj5) | gapComposer2.changed((Function0) obj6);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        final CoroutineScope coroutineScope = (CoroutineScope) obj10;
                        final Function1 function1 = (Function1) obj8;
                        final MusicDatabase musicDatabase = (MusicDatabase) obj7;
                        final MutableState mutableState2 = (MutableState) state;
                        final MutableState mutableState3 = (MutableState) this.$showDuplicateDialog$delegate$inlined;
                        final AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj9;
                        final SyncUtils syncUtils = (SyncUtils) obj5;
                        final Function0 function0 = (Function0) obj6;
                        final MutableState mutableState4 = this.$selectedPlaylist$delegate$inlined;
                        final MutableState mutableState5 = this.$songIds$delegate$inlined;
                        objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$3$1$4$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                MutableState mutableState6 = mutableState4;
                                Playlist playlist3 = playlist2;
                                mutableState6.setValue(playlist3);
                                DefaultScheduler defaultScheduler = Dispatchers.Default;
                                AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new SyncUtils.C01852(function1, musicDatabase, playlist3, mutableState5, mutableState2, mutableState3, addToPlaylistPosition, syncUtils, function0, null), 2);
                                return Unit.INSTANCE;
                            }
                        };
                        playlist = playlist2;
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        playlist = playlist2;
                    }
                    MenuKt.PlaylistListItem(playlist, ImageKt.m46clickableoSLSa3U$default(modifierM39backgroundbw27NRU, false, null, (Function0) objRememberedValue, 15), false, null, null, gapComposer2, 0, 28);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 1:
                PlayerConnection playerConnection = (PlayerConnection) obj5;
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                State state2 = (State) obj9;
                List list2 = (List) obj10;
                if ((iIntValue4 & 6) == 0) {
                    i2 = iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2);
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    Song song3 = (Song) list.get(iIntValue3);
                    gapComposer3.startReplaceGroup(655519595);
                    boolean zChangedInstance = gapComposer3.changedInstance(list2) | gapComposer3.changed(song3);
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1(list2, song3, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function2 = (Function1) objRememberedValue2;
                    String str = song3.song.id;
                    int i4 = i2;
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    boolean zAreEqual = Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null);
                    boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged2 = gapComposer3.changed(mutableState) | gapComposer3.changedInstance((HapticFeedback) obj8) | gapComposer3.changed(function2) | gapComposer3.changed(this.$selectedPlaylist$delegate$inlined) | gapComposer3.changed(song3) | gapComposer3.changedInstance(r1) | ((((i4 & 112) ^ 48) > 32 && gapComposer3.changed(iIntValue3)) || (i4 & 48) == 32) | gapComposer3.changedInstance(list2);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1((HapticFeedback) obj8, function2, song3, iIntValue3, (List) obj7, (List) obj10, this.$playlistsContainingSong$delegate$inlined, this.$selectedPlaylist$delegate$inlined, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function3 = (Function0) objRememberedValue3;
                    boolean zChanged3 = gapComposer3.changed(mutableState) | gapComposer3.changed(function2) | gapComposer3.changedInstance(list2) | gapComposer3.changed(song3) | gapComposer3.changed(state2) | gapComposer3.changedInstance(playerConnection) | gapComposer3.changed((String) obj6);
                    MutableState mutableState6 = this.$songIds$delegate$inlined;
                    boolean zChanged4 = zChanged3 | gapComposer3.changed(mutableState6);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        gapComposer = gapComposer3;
                        TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(function2, (List) obj10, song3, playerConnection, (String) obj6, this.$playlistsContainingSong$delegate$inlined, (State) obj9, mutableState6, (byte) 1);
                        gapComposer.updateRememberedValue(topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1);
                        objRememberedValue4 = topPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1;
                    } else {
                        gapComposer = gapComposer3;
                    }
                    MenuKt.SongListItem(song3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function3, (Function0) objRememberedValue4, 239), null, false, true, false, null, null, zAreEqual, zBooleanValue, false, Expect_jvmKt.rememberComposableLambda(1545537461, new AlbumScreenKt$AlbumScreen$3$1$4$3((List) obj10, song3, function2, (MenuState) this.$showDuplicateDialog$delegate$inlined, this.$playlistsContainingSong$delegate$inlined, (byte) 1), gapComposer), null, gapComposer, 24576, 384, 10732);
                    gapComposer.end(false);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            default:
                String str2 = (String) obj6;
                PlayerConnection playerConnection2 = (PlayerConnection) obj5;
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                State state3 = (State) obj9;
                List list3 = (List) obj10;
                if ((iIntValue6 & 6) == 0) {
                    i3 = iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl3) ? 4 : 2);
                } else {
                    i3 = iIntValue6;
                }
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                int i5 = i3;
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(i5 & 1, (i3 & 147) != 146)) {
                    Song song4 = (Song) list.get(iIntValue5);
                    gapComposer4.startReplaceGroup(504400138);
                    boolean zChangedInstance2 = gapComposer4.changedInstance(list3) | gapComposer4.changed(song4);
                    Object objRememberedValue5 = gapComposer4.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1(list3, song4, (byte) 3);
                        gapComposer4.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function4 = (Function1) objRememberedValue5;
                    int i6 = iIntValue5 + 1;
                    String str3 = song4.song.id;
                    MediaMetadata mediaMetadata2 = (MediaMetadata) state3.getValue();
                    boolean zAreEqual2 = Intrinsics.areEqual(str3, mediaMetadata2 != null ? mediaMetadata2.id : null);
                    boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged5 = gapComposer4.changed(mutableState) | gapComposer4.changedInstance((HapticFeedback) obj8) | gapComposer4.changed(function4) | gapComposer4.changed(this.$selectedPlaylist$delegate$inlined) | gapComposer4.changed(song4) | gapComposer4.changedInstance((List) obj7) | ((((i5 & 112) ^ 48) > 32 && gapComposer4.changed(iIntValue5)) || (i5 & 48) == 32) | gapComposer4.changedInstance(list3);
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    if (zChanged5 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1((HapticFeedback) obj8, function4, song4, iIntValue5, (List) obj7, (List) obj10, this.$playlistsContainingSong$delegate$inlined, this.$selectedPlaylist$delegate$inlined, (byte) 0);
                        song = song4;
                        gapComposer4.updateRememberedValue(objRememberedValue6);
                    } else {
                        song = song4;
                    }
                    Function0 function5 = (Function0) objRememberedValue6;
                    boolean zChangedInstance3 = gapComposer4.changedInstance(list3) | gapComposer4.changed(mutableState) | gapComposer4.changed(function4) | gapComposer4.changed(song) | gapComposer4.changed(state3) | gapComposer4.changedInstance(playerConnection2) | gapComposer4.changed(str2);
                    MutableState mutableState7 = this.$songIds$delegate$inlined;
                    boolean zChanged6 = zChangedInstance3 | gapComposer4.changed(mutableState7);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (zChanged6 || objRememberedValue7 == neverEqualPolicy) {
                        song2 = song;
                        objRememberedValue7 = new TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(function4, (List) obj10, song2, playerConnection2, str2, this.$playlistsContainingSong$delegate$inlined, (State) obj9, mutableState7, (byte) 0);
                        gapComposer4.updateRememberedValue(objRememberedValue7);
                    } else {
                        song2 = song;
                    }
                    MenuKt.SongListItem(song2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, function5, (Function0) objRememberedValue7, 239), Integer.valueOf(i6), false, true, false, null, null, zAreEqual2, zBooleanValue2, false, Expect_jvmKt.rememberComposableLambda(-1356742251, new AlbumScreenKt$AlbumScreen$3$1$4$3((List) obj10, song2, function4, (MenuState) this.$showDuplicateDialog$delegate$inlined, this.$playlistsContainingSong$delegate$inlined, (byte) 3), gapComposer4), null, gapComposer4, 24576, 384, 10728);
                    gapComposer4.end(false);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ AddToPlaylistDialogKt$AddToPlaylistDialog$lambda$24$0$$inlined$items$default$4(List list, List list2, MutableState mutableState, HapticFeedback hapticFeedback, MutableState mutableState2, List list3, State state, PlayerConnection playerConnection, String str, MutableState mutableState3, State state2, MenuState menuState, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$coroutineScope$inlined = list2;
        this.$playlistsContainingSong$delegate$inlined = mutableState;
        this.$onGetSong$inlined = hapticFeedback;
        this.$selectedPlaylist$delegate$inlined = mutableState2;
        this.$database$inlined = list3;
        this.$addToPlaylistPosition$inlined = state;
        this.$syncUtils$inlined = playerConnection;
        this.$onDismiss$inlined = str;
        this.$songIds$delegate$inlined = mutableState3;
        this.$duplicates$delegate$inlined = state2;
        this.$showDuplicateDialog$delegate$inlined = menuState;
    }
}
