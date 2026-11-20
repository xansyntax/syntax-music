package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.common.Timeline;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.LocalAlbumRadio;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$3$1$4$2$1 implements Function0 {
    public final /* synthetic */ Object $albumWithSongs;
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ int $index;
    public final /* synthetic */ boolean $isListenTogetherGuest;
    public final /* synthetic */ State $mediaMetadata$delegate;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ State $playlistId$delegate;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ List $selection;
    public final /* synthetic */ Object $song;

    public AlbumScreenKt$AlbumScreen$3$1$4$2$1(Function1 function1, List list, Timeline.Window window, boolean z, int i, CastConnectionHandler castConnectionHandler, PlayerConnection playerConnection, MutableState mutableState, State state, State state2, State state3) {
        this.$onCheckedChange = function1;
        this.$selection = list;
        this.$song = window;
        this.$isListenTogetherGuest = z;
        this.$index = i;
        this.$playerConnection = playerConnection;
        this.$inSelectMode$delegate = mutableState;
        this.$mediaMetadata$delegate = state;
        this.$playlistId$delegate = state2;
        this.$albumWithSongs = state3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.$albumWithSongs;
        State state = this.$playlistId$delegate;
        State state2 = this.$mediaMetadata$delegate;
        int i = this.$index;
        boolean z = this.$isListenTogetherGuest;
        List list = this.$selection;
        Function1 function1 = this.$onCheckedChange;
        MutableState mutableState = this.$inSelectMode$delegate;
        Object obj2 = this.$song;
        PlayerConnection playerConnection = this.$playerConnection;
        switch (b) {
            case 0:
                SongEntity songEntity = ((Song) obj2).song;
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    function1.invoke(Boolean.valueOf(!list.contains(songEntity.id)));
                } else if (!z) {
                    String str = songEntity.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    if (!Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null)) {
                        playerConnection.service.getAutomix((String) state.getValue());
                        playerConnection.playQueue(new LocalAlbumRadio((AlbumWithSongs) obj, i));
                    } else {
                        playerConnection.togglePlayPause();
                    }
                }
                break;
            default:
                Timeline.Window window = (Timeline.Window) obj2;
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    function1.invoke(Boolean.valueOf(!list.contains(window.mediaItem.mediaId)));
                } else if (!z) {
                    if (i != ((Number) state2.getValue()).intValue()) {
                        if (!((Boolean) state.getValue()).booleanValue()) {
                            playerConnection.getPlayerSafe().seekToDefaultPosition(window.firstPeriodIndex);
                            playerConnection.getPlayerSafe().setPlayWhenReady(true);
                        } else {
                            window.mediaItem.mediaId.getClass();
                            playerConnection.getPlayerSafe().seekToDefaultPosition(window.firstPeriodIndex);
                        }
                    } else if (!((Boolean) state.getValue()).booleanValue()) {
                        playerConnection.togglePlayPause();
                    } else {
                        ((Boolean) ((State) obj).getValue()).getClass();
                    }
                }
                break;
        }
        return unit;
    }

    public AlbumScreenKt$AlbumScreen$3$1$4$2$1(Function1 function1, List list, Song song, boolean z, PlayerConnection playerConnection, AlbumWithSongs albumWithSongs, int i, MutableState mutableState, State state, State state2) {
        this.$onCheckedChange = function1;
        this.$selection = list;
        this.$song = song;
        this.$isListenTogetherGuest = z;
        this.$playerConnection = playerConnection;
        this.$albumWithSongs = albumWithSongs;
        this.$index = i;
        this.$inSelectMode$delegate = mutableState;
        this.$mediaMetadata$delegate = state;
        this.$playlistId$delegate = state2;
    }
}
