package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1 implements Function0 {
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ State $mediaMetadata$delegate;
    public final /* synthetic */ Object $name;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;
    public final /* synthetic */ Object $song;
    public final /* synthetic */ MutableState $songs$delegate;

    public TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(Function1 function1, SnapshotStateList snapshotStateList, PlaylistSong playlistSong, PlayerConnection playerConnection, MutableState mutableState, State state, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 2;
        this.$onCheckedChange = function1;
        this.$selection = snapshotStateList;
        this.$song = playlistSong;
        this.$playerConnection = playerConnection;
        this.$inSelectMode$delegate = mutableState;
        this.$mediaMetadata$delegate = state;
        this.$songs$delegate = mutableState2;
        this.$name = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i;
        int i2;
        int i3;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i4 = 0;
        MutableState mutableState = this.$songs$delegate;
        PlayerConnection playerConnection = this.$playerConnection;
        State state = this.$mediaMetadata$delegate;
        List list = this.$selection;
        Function1 function1 = this.$onCheckedChange;
        MutableState mutableState2 = this.$inSelectMode$delegate;
        Object obj = this.$song;
        Object obj2 = this.$name;
        switch (b) {
            case 0:
                SongEntity songEntity = ((Song) obj).song;
                if (!TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState2)) {
                    String str = songEntity.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                    if (!Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null)) {
                        String str2 = (String) obj2;
                        List list2 = (List) mutableState.getValue();
                        list2.getClass();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UuidKt.toMediaItem((Song) it.next()));
                        }
                        List list3 = (List) mutableState.getValue();
                        list3.getClass();
                        Iterator it2 = list3.iterator();
                        while (it2.hasNext()) {
                            if (Intrinsics.areEqual(((Song) it2.next()).song.id, songEntity.id)) {
                                i = i4;
                                playerConnection.playQueue(new ListQueue(str2, arrayList, i, 0L, 8, null));
                            } else {
                                i4++;
                            }
                            break;
                        }
                        i = -1;
                        playerConnection.playQueue(new ListQueue(str2, arrayList, i, 0L, 8, null));
                    } else {
                        playerConnection.togglePlayPause();
                    }
                } else {
                    function1.invoke(Boolean.valueOf(!list.contains(songEntity.id)));
                }
                break;
            case 1:
                SongEntity songEntity2 = ((Song) obj).song;
                if (!TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState2)) {
                    String str3 = songEntity2.id;
                    MediaMetadata mediaMetadata2 = (MediaMetadata) state.getValue();
                    if (!Intrinsics.areEqual(str3, mediaMetadata2 != null ? mediaMetadata2.id : null)) {
                        String str4 = (String) obj2;
                        List list4 = (List) mutableState.getValue();
                        list4.getClass();
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                        Iterator it3 = list4.iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(UuidKt.toMediaItem((Song) it3.next()));
                        }
                        List list5 = (List) mutableState.getValue();
                        list5.getClass();
                        Iterator it4 = list5.iterator();
                        while (it4.hasNext()) {
                            if (Intrinsics.areEqual(((Song) it4.next()).song.id, songEntity2.id)) {
                                i2 = i4;
                                playerConnection.playQueue(new ListQueue(str4, arrayList2, i2, 0L, 8, null));
                            } else {
                                i4++;
                            }
                            break;
                        }
                        i2 = -1;
                        playerConnection.playQueue(new ListQueue(str4, arrayList2, i2, 0L, 8, null));
                    } else {
                        playerConnection.togglePlayPause();
                    }
                } else {
                    function1.invoke(Boolean.valueOf(!list.contains(songEntity2.id)));
                }
                break;
            default:
                MutableState mutableState3 = (MutableState) obj2;
                PlaylistSong playlistSong = (PlaylistSong) obj;
                PlaylistSongMap playlistSongMap = playlistSong.map;
                if (!LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState2)) {
                    String str5 = playlistSong.song.song.id;
                    MediaMetadata mediaMetadata3 = (MediaMetadata) state.getValue();
                    if (!Intrinsics.areEqual(str5, mediaMetadata3 != null ? mediaMetadata3.id : null)) {
                        Playlist playlist = (Playlist) mutableState.getValue();
                        playlist.getClass();
                        String str6 = playlist.playlist.name;
                        List list6 = (List) mutableState3.getValue();
                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                        Iterator it5 = list6.iterator();
                        while (it5.hasNext()) {
                            arrayList3.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it5.next()).song)));
                        }
                        Iterator it6 = ((List) mutableState3.getValue()).iterator();
                        while (it6.hasNext()) {
                            if (((PlaylistSong) it6.next()).map.id == playlistSongMap.id) {
                                i3 = i4;
                                playerConnection.playQueue(new ListQueue(str6, arrayList3, i3, 0L, 8, null));
                            } else {
                                i4++;
                            }
                            break;
                        }
                        i3 = -1;
                        playerConnection.playQueue(new ListQueue(str6, arrayList3, i3, 0L, 8, null));
                    } else {
                        playerConnection.togglePlayPause();
                    }
                } else {
                    function1.invoke(Boolean.valueOf(!((SnapshotStateList) list).contains(Integer.valueOf(playlistSongMap.id))));
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$2$1(Function1 function1, List list, Song song, PlayerConnection playerConnection, String str, MutableState mutableState, State state, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.$onCheckedChange = function1;
        this.$selection = list;
        this.$song = song;
        this.$playerConnection = playerConnection;
        this.$name = str;
        this.$inSelectMode$delegate = mutableState;
        this.$mediaMetadata$delegate = state;
        this.$songs$delegate = mutableState2;
    }
}
