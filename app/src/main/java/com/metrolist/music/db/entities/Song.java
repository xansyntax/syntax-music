package com.metrolist.music.db.entities;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.palette.graphics.ColorCutQuantizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Song extends LocalItem {
    public final AlbumEntity album;
    public final List artistMaps;
    public final List artists;
    public final FormatEntity format;
    public final SongEntity song;

    public /* synthetic */ Song(SongEntity songEntity, ArrayList arrayList, AlbumEntity albumEntity, int i) {
        this(songEntity, arrayList, EmptyList.INSTANCE, (i & 8) != 0 ? null : albumEntity, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Song)) {
            return false;
        }
        Song song = (Song) obj;
        return Intrinsics.areEqual(this.song, song.song) && Intrinsics.areEqual(this.artists, song.artists) && Intrinsics.areEqual(this.artistMaps, song.artistMaps) && Intrinsics.areEqual(this.album, song.album) && Intrinsics.areEqual(this.format, song.format);
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getId() {
        return this.song.id;
    }

    public final List getOrderedArtists() {
        List list = this.artistMaps;
        boolean zIsEmpty = list.isEmpty();
        List list2 = this.artists;
        if (zIsEmpty) {
            return list2;
        }
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (Object obj : list2) {
            linkedHashMap.put(((ArtistEntity) obj).id, obj);
        }
        List listSortedWith = CollectionsKt.sortedWith(list, new ColorCutQuantizer.AnonymousClass1((byte) 8));
        ArrayList arrayList = new ArrayList();
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            ArtistEntity artistEntity = (ArtistEntity) linkedHashMap.get(((SongArtistMap) it.next()).artistId);
            if (artistEntity != null) {
                arrayList.add(artistEntity);
            }
        }
        return arrayList.isEmpty() ? list2 : arrayList;
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getThumbnailUrl() {
        return this.song.thumbnailUrl;
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getTitle() {
        return this.song.title;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.song.hashCode() * 31, 31, this.artists), 31, this.artistMaps);
        AlbumEntity albumEntity = this.album;
        int iHashCode = (iM + (albumEntity == null ? 0 : albumEntity.hashCode())) * 31;
        FormatEntity formatEntity = this.format;
        return iHashCode + (formatEntity != null ? formatEntity.hashCode() : 0);
    }

    public final String toString() {
        return "Song(song=" + this.song + ", artists=" + this.artists + ", artistMaps=" + this.artistMaps + ", album=" + this.album + ", format=" + this.format + ")";
    }

    public Song(SongEntity songEntity, List list, List list2, AlbumEntity albumEntity, FormatEntity formatEntity) {
        this.song = songEntity;
        this.artists = list;
        this.artistMaps = list2;
        this.album = albumEntity;
        this.format = formatEntity;
    }
}
