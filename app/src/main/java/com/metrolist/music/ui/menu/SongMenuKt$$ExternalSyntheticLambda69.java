package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.LocalAlbumRadio;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.viewmodels.DailyDiscoverItem;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda69 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda69(Function0 function0, boolean z, NavHostController navHostController, Song song) {
        this.$r8$classId = (byte) 0;
        this.f$0 = function0;
        this.f$1 = z;
        this.f$2 = navHostController;
        this.f$3 = song;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Queue listQueue;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$0;
        boolean z = this.f$1;
        switch (b) {
            case 0:
                NavHostController navHostController = (NavHostController) obj2;
                ((Function0) obj3).invoke();
                SongEntity songEntity = ((Song) obj).song;
                if (!z) {
                    Format$$ExternalSyntheticOutline0.m("album/", songEntity.albumId, navHostController);
                } else {
                    Format$$ExternalSyntheticOutline0.m("online_podcast/", songEntity.albumId, navHostController);
                }
                break;
            case 1:
                NavHostController navHostController2 = (NavHostController) obj2;
                Album album = (Album) obj;
                Function0 function0 = (Function0) obj3;
                if (z) {
                    Format$$ExternalSyntheticOutline0.m("online_podcast/", album.id, navHostController2);
                } else {
                    Format$$ExternalSyntheticOutline0.m("album/", album.id, navHostController2);
                }
                function0.invoke();
                break;
            case 2:
                PlayerConnection playerConnection = (PlayerConnection) obj3;
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) obj2;
                State state = (State) obj;
                if (!z) {
                    playerConnection.service.getAutomix((String) state.getValue());
                    playerConnection.playQueue(new LocalAlbumRadio(albumWithSongs, 0, 2, null));
                }
                break;
            default:
                DailyDiscoverItem dailyDiscoverItem = (DailyDiscoverItem) obj3;
                PlayerConnection playerConnection2 = (PlayerConnection) obj2;
                MutableState mutableState = (MutableState) obj;
                if (!z) {
                    SongItem songItem = dailyDiscoverItem.recommendation;
                    MediaMetadata mediaMetadata = HexFormatKt.toMediaMetadata(songItem);
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        WatchEndpoint watchEndpoint = songItem.endpoint;
                        if (watchEndpoint == null) {
                            watchEndpoint = new WatchEndpoint(62, songItem.id, null, null);
                        }
                        listQueue = new YouTubeQueue(watchEndpoint, mediaMetadata);
                    } else {
                        listQueue = new ListQueue(songItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem))), 0, 0L, 12, null);
                    }
                    playerConnection2.playQueue(listQueue);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda69(boolean z, NavHostController navHostController, Album album, Function0 function0) {
        this.$r8$classId = (byte) 1;
        this.f$1 = z;
        this.f$2 = navHostController;
        this.f$3 = album;
        this.f$0 = function0;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda69(boolean z, Object obj, Object obj2, State state, byte b) {
        this.$r8$classId = b;
        this.f$1 = z;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$3 = state;
    }
}
