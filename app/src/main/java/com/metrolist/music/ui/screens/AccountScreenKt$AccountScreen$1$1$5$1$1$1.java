package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.room.RoomDatabase$closeBarrier$1;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountScreenKt$AccountScreen$1$1$5$1$1$1 implements Function3 {
    public final /* synthetic */ Object $coroutineScope;
    public final /* synthetic */ Object $item;
    public final /* synthetic */ Object $menuState;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AccountScreenKt$AccountScreen$1$1$5$1$1$1(Object obj, MenuState menuState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.$item = obj;
        this.$menuState = menuState;
        this.$coroutineScope = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.$menuState;
        Object obj5 = this.$coroutineScope;
        Object obj6 = this.$item;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    PlaylistItem playlistItem = (PlaylistItem) obj6;
                    CoroutineScope coroutineScope = (CoroutineScope) obj5;
                    MenuState menuState = (MenuState) obj4;
                    boolean zChanged = gapComposer.changed(menuState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new RoomDatabase$closeBarrier$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 29);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, coroutineScope, (Function0) ((KFunction) objRememberedValue), null, gapComposer, 0, 50);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                MutableState mutableState = (MutableState) obj5;
                MenuState menuState2 = (MenuState) obj4;
                HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    boolean zChangedInstance = gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState2) | gapComposer2.changed(mutableState);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new HomeScreenKt$HomeScreen$10$1$1$1$9$4$2$1$1$3$1$1(hapticFeedback, menuState2, mutableState, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.IconButton((Function0) objRememberedValue2, null, false, null, null, AlbumScreenKt.lambda$1822988539, gapComposer2, 1572864, 62);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Artist artist = (Artist) obj6;
                    CoroutineScope coroutineScope2 = (CoroutineScope) obj5;
                    MenuState menuState3 = (MenuState) obj4;
                    boolean zChanged2 = gapComposer3.changed(menuState3);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 15);
                        gapComposer3.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                        objRememberedValue3 = loginScreenKt$LoginScreen$1$3$2$1;
                    }
                    AlbumMenuKt.ArtistMenu(artist, coroutineScope2, (Function0) ((KFunction) objRememberedValue3), gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    PodcastEntity podcastEntity = (PodcastEntity) obj6;
                    MusicDatabase musicDatabase = (MusicDatabase) obj5;
                    MenuState menuState4 = (MenuState) obj4;
                    boolean zChanged3 = gapComposer4.changed(menuState4);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 7);
                        gapComposer4.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                        objRememberedValue4 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                    }
                    LibraryScreenKt.PodcastEpisodePlaylistMenu(podcastEntity, musicDatabase, (Function0) ((KFunction) objRememberedValue4), gapComposer4, 64);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    PlaylistSong playlistSong = (PlaylistSong) obj6;
                    Song song = playlistSong.song;
                    Playlist playlist = (Playlist) ((MutableState) obj5).getValue();
                    String str = playlist != null ? playlist.playlist.browseId : null;
                    MenuState menuState5 = (MenuState) obj4;
                    boolean zChanged4 = gapComposer5.changed(menuState5);
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    if (zChanged4 || objRememberedValue5 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$2 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState5, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 16);
                        gapComposer5.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$2);
                        objRememberedValue5 = autoPlaylistScreenKt$AutoPlaylistScreen$12$2;
                    }
                    SongMenuKt.SongMenu(song, null, playlistSong, str, (Function0) ((KFunction) objRememberedValue5), false, gapComposer5, 0, 34);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            default:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    MutableState mutableState2 = (MutableState) obj6;
                    Enum r5 = (Enum) obj5;
                    for (MyTopFilter myTopFilter : MyTopFilter.values()) {
                        byte b2 = 10;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.AnonymousClass1(myTopFilter, b2), gapComposer6), new AccountScreenKt$AccountScreen$1$1$11$1$1((Object) myTopFilter, (Object) mutableState2, obj4, (byte) 4), null, null, Expect_jvmKt.rememberComposableLambda(737216264, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.AnonymousClass3(r5, myTopFilter, b2), gapComposer6), false, null, null, gapComposer6, 24582, 492);
                    }
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AccountScreenKt$AccountScreen$1$1$5$1$1$1(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$item = obj;
        this.$coroutineScope = obj2;
        this.$menuState = obj3;
    }
}
