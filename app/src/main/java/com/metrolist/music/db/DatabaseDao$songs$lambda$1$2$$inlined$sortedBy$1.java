package com.metrolist.music.db;

import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseDao$songs$lambda$1$2$$inlined$sortedBy$1 implements Comparator {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DatabaseDao$songs$lambda$1$2$$inlined$sortedBy$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                List orderedArtists = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$1 = DatabaseDao$songs$2$1$1.INSTANCE$9;
                return CollectionsKt.joinToString$default(orderedArtists, "", null, null, databaseDao$songs$2$1$1, 30).compareTo(CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$1, 30));
            case 1:
                List orderedArtists2 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$2 = DatabaseDao$songs$2$1$1.INSTANCE$7;
                return CollectionsKt.joinToString$default(orderedArtists2, "", null, null, databaseDao$songs$2$1$2, 30).compareTo(CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$2, 30));
            case 2:
                List orderedArtists3 = ((Song) obj).getOrderedArtists();
                DatabaseDao$songs$2$1$1 databaseDao$songs$2$1$3 = DatabaseDao$songs$2$1$1.INSTANCE$11;
                return CollectionsKt.joinToString$default(orderedArtists3, "", null, null, databaseDao$songs$2$1$3, 30).compareTo(CollectionsKt.joinToString$default(((Song) obj2).getOrderedArtists(), "", null, null, databaseDao$songs$2$1$3, 30));
            default:
                return Integer.valueOf(((PlaylistSongMap) obj).position).compareTo(Integer.valueOf(((PlaylistSongMap) obj2).position));
        }
    }
}
