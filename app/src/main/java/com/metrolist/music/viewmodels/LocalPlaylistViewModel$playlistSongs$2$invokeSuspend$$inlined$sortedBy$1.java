package com.metrolist.music.viewmodels;

import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import java.util.Comparator;
import kotlin.text.RegexKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalPlaylistViewModel$playlistSongs$2$invokeSuspend$$inlined$sortedBy$1 implements Comparator {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LocalPlaylistViewModel$playlistSongs$2$invokeSuspend$$inlined$sortedBy$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return Integer.valueOf(((PlaylistSong) obj).map.id).compareTo(Integer.valueOf(((PlaylistSong) obj2).map.id));
            case 1:
                return RegexKt.compareValues(((Song) obj2).song.dateDownload, ((Song) obj).song.dateDownload);
            default:
                return Long.valueOf(((PlaylistSong) obj).song.song.totalPlayTime).compareTo(Long.valueOf(((PlaylistSong) obj2).song.song.totalPlayTime));
        }
    }
}
