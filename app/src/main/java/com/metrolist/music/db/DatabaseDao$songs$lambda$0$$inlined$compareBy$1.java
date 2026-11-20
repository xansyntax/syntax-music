package com.metrolist.music.db;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel$playlistSongs$2$3$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseDao$songs$lambda$0$$inlined$compareBy$1 implements Comparator {
    public final /* synthetic */ Collator $comparator;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DatabaseDao$songs$lambda$0$$inlined$compareBy$1(Collator collator, byte b) {
        this.$r8$classId = b;
        this.$comparator = collator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        if ((r14 instanceof com.metrolist.music.db.entities.Song) != false) goto L35;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(Object obj, Object obj2) {
        String str;
        byte b = this.$r8$classId;
        Collator collator = this.$comparator;
        switch (b) {
            case 0:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 1:
                return collator.compare(((Album) obj).album.title, ((Album) obj2).album.title);
            case 2:
                List list = ((Album) obj).artists;
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$1 = DatabaseDao$songs$2$1$1.INSTANCE$1;
                return collator.compare(CollectionsKt.joinToString$default(list, "", null, null, databaseDao$songs$2$1$1, 30), CollectionsKt.joinToString$default(((Album) obj2).artists, "", null, null, databaseDao$songs$2$1$1, 30));
            case 3:
                return collator.compare(((Album) obj).album.title, ((Album) obj2).album.title);
            case 4:
                List list2 = ((Album) obj).artists;
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$2 = DatabaseDao$songs$2$1$1.INSTANCE$2;
                return collator.compare(CollectionsKt.joinToString$default(list2, "", null, null, databaseDao$songs$2$1$2, 30), CollectionsKt.joinToString$default(((Album) obj2).artists, "", null, null, databaseDao$songs$2$1$2, 30));
            case 5:
                return collator.compare(((Album) obj).album.title, ((Album) obj2).album.title);
            case 6:
                List list3 = ((Album) obj).artists;
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$3 = DatabaseDao$songs$2$1$1.INSTANCE$3;
                return collator.compare(CollectionsKt.joinToString$default(list3, "", null, null, databaseDao$songs$2$1$3, 30), CollectionsKt.joinToString$default(((Album) obj2).artists, "", null, null, databaseDao$songs$2$1$3, 30));
            case 7:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 8:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 9:
                List orderedArtists = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$4 = DatabaseDao$songs$2$1$1.INSTANCE$4;
                return collator.compare(CollectionsKt.joinToString$default(orderedArtists, "", null, null, databaseDao$songs$2$1$4, 30), CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$4, 30));
            case 10:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 11:
                List orderedArtists2 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$5 = DatabaseDao$songs$2$1$1.INSTANCE$5;
                return collator.compare(CollectionsKt.joinToString$default(orderedArtists2, "", null, null, databaseDao$songs$2$1$5, 30), CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$5, 30));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 13:
                List orderedArtists3 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$6 = DatabaseDao$songs$2$1$1.INSTANCE$6;
                return collator.compare(CollectionsKt.joinToString$default(orderedArtists3, "", null, null, databaseDao$songs$2$1$6, 30), CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$6, 30));
            case 14:
                return collator.compare(((Playlist) obj).playlist.name, ((Playlist) obj2).playlist.name);
            case 15:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 16:
                List orderedArtists4 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$7 = DatabaseDao$songs$2$1$1.INSTANCE$8;
                return collator.compare(CollectionsKt.joinToString$default(orderedArtists4, "", null, null, databaseDao$songs$2$1$7, 30), CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$7, 30));
            case 17:
                List orderedArtists5 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$8 = DatabaseDao$songs$2$1$1.INSTANCE;
                return collator.compare(CollectionsKt.joinToString$default(orderedArtists5, "", null, null, databaseDao$songs$2$1$8, 30), CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$8, 30));
            case 18:
                return collator.compare(((Song) obj).song.title, ((Song) obj2).song.title);
            case 19:
                List orderedArtists6 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$9 = DatabaseDao$songs$2$1$1.INSTANCE$10;
                return collator.compare(CollectionsKt.joinToString$default(orderedArtists6, "", null, null, databaseDao$songs$2$1$9, 30), CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$9, 30));
            case 20:
                LocalItem localItem = (LocalItem) obj;
                if (localItem != null) {
                    String str2 = "";
                    if (localItem instanceof Album) {
                        str = ((Album) localItem).album.title;
                    } else if (localItem instanceof Artist) {
                        str = ((Artist) localItem).artist.name;
                    } else if (localItem instanceof Playlist) {
                        str = ((Playlist) localItem).playlist.name;
                    } else if (localItem instanceof Song) {
                        str = "";
                    }
                    LocalItem localItem2 = (LocalItem) obj2;
                    if (localItem2 != null) {
                        if (!(localItem2 instanceof Album)) {
                            if (localItem2 instanceof Artist) {
                                str2 = ((Artist) localItem2).artist.name;
                            } else if (localItem2 instanceof Playlist) {
                                str2 = ((Playlist) localItem2).playlist.name;
                            }
                            break;
                        } else {
                            str2 = ((Album) localItem2).album.title;
                        }
                        return collator.compare(str, str2);
                    }
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0;
            case 21:
                return collator.compare(((PlaylistSong) obj).song.song.title, ((PlaylistSong) obj2).song.song.title);
            default:
                List list4 = ((PlaylistSong) obj).song.artists;
                LocalPlaylistViewModel$playlistSongs$2$3$1 localPlaylistViewModel$playlistSongs$2$3$1 = LocalPlaylistViewModel$playlistSongs$2$3$1.INSTANCE;
                return collator.compare(CollectionsKt.joinToString$default(list4, "", null, null, localPlaylistViewModel$playlistSongs$2$3$1, 30), CollectionsKt.joinToString$default(((PlaylistSong) obj2).song.artists, "", null, null, localPlaylistViewModel$playlistSongs$2$3$1, 30));
        }
    }
}
