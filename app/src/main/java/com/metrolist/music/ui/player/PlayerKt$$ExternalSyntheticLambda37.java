package com.metrolist.music.ui.player;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
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
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubePlaylistQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda37 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda37(YTItem yTItem, boolean z, PlayerConnection playerConnection, NavHostController navHostController, MutableState mutableState) {
        this.$r8$classId = (byte) 3;
        this.f$5 = yTItem;
        this.f$0 = z;
        this.f$1 = playerConnection;
        this.f$4 = navHostController;
        this.f$3 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str;
        String str2;
        Queue listQueue;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$4;
        Object obj2 = this.f$5;
        Object obj3 = this.f$1;
        Object obj4 = this.f$3;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                PlayerConnection playerConnection = (PlayerConnection) obj3;
                MutableState mutableState = (MutableState) obj4;
                State state = (State) obj;
                MutableState mutableState2 = (MutableState) obj2;
                if (z) {
                    playerConnection.toggleMute();
                } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                    ((Boolean) state.getValue()).booleanValue();
                } else if (((Number) mutableState2.getValue()).intValue() == 4) {
                    playerConnection.getPlayerSafe().seekTo(0, 0L, false);
                    playerConnection.getPlayerSafe().setPlayWhenReady(true);
                } else {
                    playerConnection.togglePlayPause();
                }
                return unit;
            case 1:
                NavHostController navHostController = (NavHostController) obj3;
                BottomSheetState bottomSheetState = (BottomSheetState) obj2;
                Function0 function0 = (Function0) obj;
                MediaMetadata.Album album = ((MediaMetadata) obj4).album;
                if (z) {
                    Format$$ExternalSyntheticOutline0.m("online_podcast/", album.id, navHostController);
                } else {
                    Format$$ExternalSyntheticOutline0.m("album/", album.id, navHostController);
                }
                bottomSheetState.collapseSoft();
                function0.invoke();
                return unit;
            case 2:
                Context context = (Context) obj2;
                Function0 function1 = (Function0) obj;
                String strM = z ? Fragment$5$$ExternalSyntheticOutline0.m("https://music.youtube.com/playlist?list=", ((Playlist) obj3).playlist.browseId) : CollectionsKt.joinToString$default((List) obj4, "\n", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 7), 30);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", strM);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, null));
                function1.invoke();
                return unit;
            case 3:
                YTItem yTItem = (YTItem) obj2;
                PlayerConnection playerConnection2 = (PlayerConnection) obj3;
                NavHostController navHostController2 = (NavHostController) obj;
                MutableState mutableState3 = (MutableState) obj4;
                if (yTItem instanceof SongItem) {
                    if (!z) {
                        if (((Boolean) mutableState3.getValue()).booleanValue()) {
                            SongItem songItem = (SongItem) yTItem;
                            WatchEndpoint watchEndpoint = songItem.endpoint;
                            if (watchEndpoint == null) {
                                watchEndpoint = new WatchEndpoint(62, songItem.id, null, null);
                            }
                            listQueue = new YouTubeQueue(watchEndpoint, HexFormatKt.toMediaMetadata(songItem));
                        } else {
                            SongItem songItem2 = (SongItem) yTItem;
                            listQueue = new ListQueue(songItem2.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem2))), 0, 0L, 12, null);
                        }
                        playerConnection2.playQueue(listQueue);
                    }
                } else if (yTItem instanceof AlbumItem) {
                    Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem).id, navHostController2);
                } else {
                    if (yTItem instanceof ArtistItem) {
                        str = ((ArtistItem) yTItem).id;
                        str2 = "artist/";
                    } else if (yTItem instanceof PlaylistItem) {
                        str = ((PlaylistItem) yTItem).id;
                        str2 = "online_playlist/";
                    } else if (yTItem instanceof PodcastItem) {
                        Format$$ExternalSyntheticOutline0.m("online_podcast/", ((PodcastItem) yTItem).id, navHostController2);
                    } else {
                        if (!(yTItem instanceof EpisodeItem)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        if (!z) {
                            EpisodeItem episodeItem = (EpisodeItem) yTItem;
                            playerConnection2.playQueue(new ListQueue(episodeItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(episodeItem))), 0, 0L, 12, null));
                        }
                    }
                    Format$$ExternalSyntheticOutline0.m(str2, str, navHostController2);
                }
                return unit;
            case 4:
                LocalItem localItem = (LocalItem) obj2;
                PlayerConnection playerConnection3 = (PlayerConnection) obj3;
                State state2 = (State) obj;
                MutableState mutableState4 = (MutableState) obj4;
                if (!z) {
                    Song song = (Song) localItem;
                    SongEntity songEntity = song.song;
                    String str3 = songEntity.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    if (Intrinsics.areEqual(str3, mediaMetadata != null ? mediaMetadata.id : null)) {
                        playerConnection3.togglePlayPause();
                    } else {
                        playerConnection3.playQueue(((Boolean) mutableState4.getValue()).booleanValue() ? YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(song)) : new ListQueue(songEntity.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song))), 0, 0L, 12, null));
                    }
                }
                return unit;
            default:
                List list = (List) obj4;
                PlayerConnection playerConnection4 = (PlayerConnection) obj3;
                PlaylistItem playlistItem = (PlaylistItem) obj2;
                String str4 = (String) obj;
                if (!z && !list.isEmpty()) {
                    playerConnection4.playQueue(new YouTubePlaylistQueue(playlistItem.id, playlistItem.title, list, str4, 0, null, 48, null));
                }
                return unit;
        }
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda37(boolean z, LocalItem localItem, PlayerConnection playerConnection, State state, MutableState mutableState) {
        this.$r8$classId = (byte) 4;
        this.f$0 = z;
        this.f$5 = localItem;
        this.f$1 = playerConnection;
        this.f$4 = state;
        this.f$3 = mutableState;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda37(boolean z, PlayerConnection playerConnection, CastConnectionHandler castConnectionHandler, MutableState mutableState, State state, MutableState mutableState2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = z;
        this.f$1 = playerConnection;
        this.f$3 = mutableState;
        this.f$4 = state;
        this.f$5 = mutableState2;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda37(boolean z, Object obj, Object obj2, Object obj3, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = obj;
        this.f$3 = obj2;
        this.f$5 = obj3;
        this.f$4 = function0;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda37(boolean z, List list, PlayerConnection playerConnection, PlaylistItem playlistItem, String str) {
        this.$r8$classId = (byte) 5;
        this.f$0 = z;
        this.f$3 = list;
        this.f$1 = playerConnection;
        this.f$5 = playlistItem;
        this.f$4 = str;
    }
}
