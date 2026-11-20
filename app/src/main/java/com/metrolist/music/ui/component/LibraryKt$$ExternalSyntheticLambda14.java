package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.room.RoomDatabase$closeBarrier$1;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda14 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MenuState f$0;
    public final /* synthetic */ Playlist f$1;
    public final /* synthetic */ CoroutineScope f$2;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda14(MenuState menuState, Playlist playlist, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 0;
        this.f$0 = menuState;
        this.f$1 = playlist;
        this.f$2 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MenuState menuState = this.f$0;
                    boolean zChanged = gapComposer.changed(menuState);
                    Playlist playlist = this.f$1;
                    boolean zChanged2 = zChanged | gapComposer.changed(playlist);
                    CoroutineScope coroutineScope = this.f$2;
                    boolean zChangedInstance = zChanged2 | gapComposer.changedInstance(coroutineScope);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LibraryKt$$ExternalSyntheticLambda7(b2, playlist, menuState, coroutineScope);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, DialogKt.f18lambda$1370294970, gapComposer, 1572864, 62);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Playlist playlist2 = this.f$1;
                    PlaylistEntity playlistEntity = playlist2.playlist;
                    boolean z = playlistEntity.isEditable;
                    CoroutineScope coroutineScope2 = this.f$2;
                    MenuState menuState2 = this.f$0;
                    if (!z && playlist2.songCount == 0) {
                        gapComposer2.startReplaceGroup(997434376);
                        String str = playlistEntity.browseId;
                        if (str == null) {
                            gapComposer2.startReplaceGroup(997434375);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(997434376);
                            String str2 = playlistEntity.name;
                            String str3 = (String) CollectionsKt.getOrNull(0, playlist2.getThumbnails());
                            PlaylistItem playlistItem = new PlaylistItem(str, str2, (Artist) null, (String) null, str3 == null ? "" : str3, new WatchEndpoint(53, null, str, playlistEntity.playEndpointParams), new WatchEndpoint(53, null, str, playlistEntity.shuffleEndpointParams), new WatchEndpoint(53, null, "RDAMPL".concat(str), playlistEntity.radioEndpointParams), false, (String) null, (String) null, 3584);
                            boolean zChanged3 = gapComposer2.changed(menuState2);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                                RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1 = new RoomDatabase$closeBarrier$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 15);
                                gapComposer2.updateRememberedValue(roomDatabase$closeBarrier$1);
                                objRememberedValue2 = roomDatabase$closeBarrier$1;
                            }
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, null, coroutineScope2, (Function0) ((KFunction) objRememberedValue2), null, gapComposer2, 0, 50);
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(997082588);
                        boolean zChanged4 = gapComposer2.changed(menuState2);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                            RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$2 = new RoomDatabase$closeBarrier$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 14);
                            gapComposer2.updateRememberedValue(roomDatabase$closeBarrier$2);
                            objRememberedValue3 = roomDatabase$closeBarrier$2;
                        }
                        AlbumMenuKt.PlaylistMenu(playlist2, coroutineScope2, (Function0) ((KFunction) objRememberedValue3), null, null, null, gapComposer2, 0);
                        gapComposer2.end(false);
                    }
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Playlist playlist3 = this.f$1;
                    PlaylistEntity playlistEntity2 = playlist3.playlist;
                    boolean z2 = playlistEntity2.isEditable;
                    CoroutineScope coroutineScope3 = this.f$2;
                    MenuState menuState3 = this.f$0;
                    if (!z2 && playlist3.songCount == 0) {
                        gapComposer3.startReplaceGroup(216364116);
                        String str4 = playlistEntity2.browseId;
                        if (str4 == null) {
                            gapComposer3.startReplaceGroup(216364115);
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(216364116);
                            String str5 = playlistEntity2.name;
                            String str6 = (String) CollectionsKt.getOrNull(0, playlist3.getThumbnails());
                            PlaylistItem playlistItem2 = new PlaylistItem(str4, str5, (Artist) null, (String) null, str6 == null ? "" : str6, new WatchEndpoint(53, null, str4, playlistEntity2.playEndpointParams), new WatchEndpoint(53, null, str4, playlistEntity2.shuffleEndpointParams), new WatchEndpoint(53, null, "RDAMPL".concat(str4), playlistEntity2.radioEndpointParams), false, (String) null, (String) null, 3584);
                            boolean zChanged5 = gapComposer3.changed(menuState3);
                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                            if (zChanged5 || objRememberedValue4 == neverEqualPolicy) {
                                RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$3 = new RoomDatabase$closeBarrier$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 17);
                                gapComposer3.updateRememberedValue(roomDatabase$closeBarrier$3);
                                objRememberedValue4 = roomDatabase$closeBarrier$3;
                            }
                            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem2, null, coroutineScope3, (Function0) ((KFunction) objRememberedValue4), null, gapComposer3, 0, 50);
                            gapComposer3.end(false);
                        }
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(216012328);
                        boolean zChanged6 = gapComposer3.changed(menuState3);
                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                        if (zChanged6 || objRememberedValue5 == neverEqualPolicy) {
                            RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$4 = new RoomDatabase$closeBarrier$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 16);
                            gapComposer3.updateRememberedValue(roomDatabase$closeBarrier$4);
                            objRememberedValue5 = roomDatabase$closeBarrier$4;
                        }
                        AlbumMenuKt.PlaylistMenu(playlist3, coroutineScope3, (Function0) ((KFunction) objRememberedValue5), null, null, null, gapComposer3, 0);
                        gapComposer3.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda14(byte b, Playlist playlist, MenuState menuState, CoroutineScope coroutineScope) {
        this.$r8$classId = b;
        this.f$1 = playlist;
        this.f$2 = coroutineScope;
        this.f$0 = menuState;
    }
}
