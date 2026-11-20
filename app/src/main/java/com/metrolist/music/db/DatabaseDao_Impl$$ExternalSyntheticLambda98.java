package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda98 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ DatabaseDao_Impl f$3;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda98(String str, int i, DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = str;
        this.f$2 = i;
        this.f$3 = databaseDao_Impl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda149(Object obj) throws Exception {
        String str = this.f$1;
        int i = this.f$2;
        DatabaseDao_Impl databaseDao_Impl = this.f$3;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE title LIKE '%' || ? || '%' AND inLibrary IS NOT NULL LIMIT ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
            sQLiteStatementPrepare.bindLong(2, i);
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "duration");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "albumId");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "albumName");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "explicit");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "year");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "date");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateModified");
            int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "liked");
            int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "likedDate");
            int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "totalPlayTime");
            int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "inLibrary");
            int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateDownload");
            int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryAddToken");
            int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryRemoveToken");
            int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lyricsOffset");
            int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "romanizeLyrics");
            int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDownloaded");
            int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isUploaded");
            int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isVideo");
            int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isEpisode");
            int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playbackPosition");
            int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "uploadEntityId");
            int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isCached");
            int i2 = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i3 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i4 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i5 = columnIndexOrThrow9;
            ArrayMap arrayMap4 = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap2.containsKey(text2)) {
                    arrayMap2.put(text2, new ArrayList());
                }
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                columnIndexOrThrow8 = columnIndexOrThrow8;
            }
            int i6 = columnIndexOrThrow8;
            String str2 = null;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i7 = columnIndexOrThrow2;
                int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i9 = i6;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i9) ? str2 : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i9));
                int i10 = i5;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i10)));
                int i11 = i4;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                i6 = i9;
                int i12 = i3;
                int i13 = columnIndexOrThrow3;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i12)) != 0;
                int i14 = i2;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                int i15 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i15);
                i2 = i14;
                int i16 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                columnIndexOrThrow14 = i16;
                int i17 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i17) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i17)));
                columnIndexOrThrow15 = i17;
                i5 = i10;
                int i18 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                int i19 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                int i20 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                int i21 = columnIndexOrThrow19;
                int i22 = (int) sQLiteStatementPrepare.getLong(i21);
                columnIndexOrThrow13 = i15;
                int i23 = columnIndexOrThrow20;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                int i24 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                columnIndexOrThrow21 = i24;
                int i25 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow22 = i25;
                int i26 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i26)) != 0;
                columnIndexOrThrow23 = i26;
                columnIndexOrThrow24 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                int i27 = columnIndexOrThrow26;
                SongEntity songEntity = new SongEntity(text3, text4, i8, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i22, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(i27) ? null : sQLiteStatementPrepare.getText(i27), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = columnIndexOrThrow27;
                columnIndexOrThrow2 = i7;
                i4 = i11;
                columnIndexOrThrow16 = i18;
                columnIndexOrThrow17 = i19;
                columnIndexOrThrow18 = i20;
                columnIndexOrThrow19 = i21;
                columnIndexOrThrow20 = i23;
                columnIndexOrThrow3 = i13;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                columnIndexOrThrow26 = i27;
                i3 = i12;
                str2 = null;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        DatabaseDao_Impl databaseDao_Impl = this.f$3;
        int i = this.f$2;
        String str = this.f$1;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE name LIKE '%' || ? || '%' LIMIT ?");
                try {
                    sQLiteStatementPrepare.bindText(1, str);
                    sQLiteStatementPrepare.bindLong(2, i);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "browseId");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isEditable");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "remoteSongCount");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playEndpointParams");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "shuffleEndpointParams");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "radioEndpointParams");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAutoSync");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
                    int i2 = columnIndexOrThrow14;
                    int i3 = columnIndexOrThrow12;
                    ArrayMap arrayMap = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap.containsKey(text)) {
                            arrayMap.put(text, new ArrayList());
                            columnIndexOrThrow10 = columnIndexOrThrow10;
                        }
                    }
                    int i4 = columnIndexOrThrow10;
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection, arrayMap);
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        ArrayMap arrayMap2 = arrayMap;
                        int i5 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15);
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4)));
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                        Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8));
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                        int i6 = i4;
                        String text6 = sQLiteStatementPrepare.isNull(i6) ? null : sQLiteStatementPrepare.getText(i6);
                        int i7 = columnIndexOrThrow11;
                        String text7 = sQLiteStatementPrepare.isNull(i7) ? null : sQLiteStatementPrepare.getText(i7);
                        i3 = i3;
                        String text8 = sQLiteStatementPrepare.isNull(i3) ? null : sQLiteStatementPrepare.getText(i3);
                        int i8 = columnIndexOrThrow13;
                        int i9 = columnIndexOrThrow5;
                        int i10 = i2;
                        int i11 = columnIndexOrThrow2;
                        PlaylistEntity playlistEntity = new PlaylistEntity(text2, text3, text4, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z, localDateTimeFromTimestamp3, numValueOf, text5, text6, text7, text8, ((int) sQLiteStatementPrepare.getLong(i8)) != 0, ((int) sQLiteStatementPrepare.getLong(i10)) != 0);
                        int i12 = columnIndexOrThrow;
                        Object value = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        arrayList.add(new Playlist(playlistEntity, i5, (List) value));
                        columnIndexOrThrow5 = i9;
                        columnIndexOrThrow13 = i8;
                        columnIndexOrThrow2 = i11;
                        columnIndexOrThrow = i12;
                        i2 = i10;
                        columnIndexOrThrow7 = columnIndexOrThrow7;
                        i4 = i6;
                        arrayMap = arrayMap2;
                        columnIndexOrThrow11 = i7;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 1:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("\n    SELECT * FROM song \n    WHERE (\n        title LIKE '%' || ? || '%' \n        OR EXISTS (\n            SELECT 1 FROM song_artist_map \n            JOIN artist ON song_artist_map.artistId = artist.id \n            WHERE song_artist_map.songId = song.id \n            AND artist.name LIKE '%' || ? || '%'\n        ) \n        OR EXISTS (\n            SELECT 1 FROM album \n            WHERE album.id = song.albumId \n            AND album.title LIKE '%' || ? || '%'\n        )\n        OR EXISTS (\n            SELECT 1 FROM playlist_song_map \n            JOIN playlist ON playlist_song_map.playlistId = playlist.id \n            WHERE playlist_song_map.songId = song.id \n            AND playlist.name LIKE '%' || ? || '%'\n        )\n    )\n    ORDER BY totalPlayTime DESC, id ASC\n    LIMIT ?\n    ");
                try {
                    sQLiteStatementPrepare2.bindText(1, str);
                    sQLiteStatementPrepare2.bindText(2, str);
                    sQLiteStatementPrepare2.bindText(3, str);
                    sQLiteStatementPrepare2.bindText(4, str);
                    sQLiteStatementPrepare2.bindLong(5, i);
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "duration");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "albumId");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "albumName");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "explicit");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "year");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "date");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "dateModified");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "liked");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "likedDate");
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "totalPlayTime");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "inLibrary");
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "dateDownload");
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "libraryAddToken");
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "libraryRemoveToken");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lyricsOffset");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "romanizeLyrics");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isDownloaded");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isUploaded");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isVideo");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isEpisode");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playbackPosition");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "uploadEntityId");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isCached");
                    int i13 = columnIndexOrThrow36;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i14 = columnIndexOrThrow30;
                    ArrayMap arrayMap4 = new ArrayMap(0);
                    int i15 = columnIndexOrThrow28;
                    ArrayMap arrayMap5 = new ArrayMap(0);
                    int i16 = columnIndexOrThrow26;
                    ArrayMap arrayMap6 = new ArrayMap(0);
                    while (sQLiteStatementPrepare2.step()) {
                        String text9 = sQLiteStatementPrepare2.getText(columnIndexOrThrow16);
                        if (!arrayMap3.containsKey(text9)) {
                            arrayMap3.put(text9, new ArrayList());
                        }
                        String text10 = sQLiteStatementPrepare2.getText(columnIndexOrThrow16);
                        if (!arrayMap4.containsKey(text10)) {
                            arrayMap4.put(text10, new ArrayList());
                        }
                        arrayMap5.put(sQLiteStatementPrepare2.getText(columnIndexOrThrow16), null);
                        arrayMap6.put(sQLiteStatementPrepare2.getText(columnIndexOrThrow16), null);
                        columnIndexOrThrow24 = columnIndexOrThrow24;
                    }
                    int i17 = columnIndexOrThrow24;
                    sQLiteStatementPrepare2.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection2, arrayMap3);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection2, arrayMap4);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection2, arrayMap5);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection2, arrayMap6);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        String text11 = sQLiteStatementPrepare2.getText(columnIndexOrThrow16);
                        String text12 = sQLiteStatementPrepare2.getText(columnIndexOrThrow17);
                        ArrayMap arrayMap7 = arrayMap6;
                        int i18 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow18);
                        String text13 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow19);
                        String text14 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow20);
                        String text15 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow21);
                        boolean z2 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow22)) != 0;
                        Integer numValueOf2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow23) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow23));
                        int i19 = i17;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i19) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i19)));
                        int i20 = columnIndexOrThrow25;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i20) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i20)));
                        int i21 = columnIndexOrThrow17;
                        i17 = i19;
                        int i22 = i16;
                        int i23 = columnIndexOrThrow22;
                        boolean z3 = ((int) sQLiteStatementPrepare2.getLong(i22)) != 0;
                        int i24 = columnIndexOrThrow27;
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i24) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i24)));
                        int i25 = i15;
                        long j = sQLiteStatementPrepare2.getLong(i25);
                        int i26 = columnIndexOrThrow29;
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i26) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i26)));
                        columnIndexOrThrow29 = i26;
                        int i27 = i14;
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i27) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i27)));
                        i14 = i27;
                        columnIndexOrThrow27 = i24;
                        int i28 = columnIndexOrThrow31;
                        boolean z4 = ((int) sQLiteStatementPrepare2.getLong(i28)) != 0;
                        int i29 = columnIndexOrThrow32;
                        String text16 = sQLiteStatementPrepare2.isNull(i29) ? null : sQLiteStatementPrepare2.getText(i29);
                        int i30 = columnIndexOrThrow33;
                        String text17 = sQLiteStatementPrepare2.isNull(i30) ? null : sQLiteStatementPrepare2.getText(i30);
                        int i31 = columnIndexOrThrow34;
                        int i32 = (int) sQLiteStatementPrepare2.getLong(i31);
                        int i33 = columnIndexOrThrow35;
                        int i34 = columnIndexOrThrow23;
                        boolean z5 = ((int) sQLiteStatementPrepare2.getLong(i33)) != 0;
                        int i35 = i13;
                        boolean z6 = ((int) sQLiteStatementPrepare2.getLong(i35)) != 0;
                        i13 = i35;
                        int i36 = columnIndexOrThrow37;
                        boolean z7 = ((int) sQLiteStatementPrepare2.getLong(i36)) != 0;
                        int i37 = columnIndexOrThrow38;
                        boolean z8 = ((int) sQLiteStatementPrepare2.getLong(i37)) != 0;
                        columnIndexOrThrow38 = i37;
                        int i38 = columnIndexOrThrow39;
                        columnIndexOrThrow40 = columnIndexOrThrow40;
                        columnIndexOrThrow41 = columnIndexOrThrow41;
                        int i39 = columnIndexOrThrow42;
                        SongEntity songEntity = new SongEntity(text11, text12, i18, text13, text14, text15, z2, numValueOf2, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, localDateTimeFromTimestamp6, j, localDateTimeFromTimestamp7, localDateTimeFromTimestamp8, z4, text16, text17, i32, z5, z6, z7, z8, ((int) sQLiteStatementPrepare2.getLong(i38)) != 0, sQLiteStatementPrepare2.isNull(columnIndexOrThrow40) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow40)), sQLiteStatementPrepare2.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow41), ((int) sQLiteStatementPrepare2.getLong(i39)) != 0);
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap3, sQLiteStatementPrepare2.getText(columnIndexOrThrow16));
                        value2.getClass();
                        List list = (List) value2;
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap4, sQLiteStatementPrepare2.getText(columnIndexOrThrow16));
                        value3.getClass();
                        arrayList2.add(new Song(songEntity, list, (List) value3, (AlbumEntity) arrayMap5.get(sQLiteStatementPrepare2.getText(columnIndexOrThrow16)), (FormatEntity) arrayMap7.get(sQLiteStatementPrepare2.getText(columnIndexOrThrow16))));
                        columnIndexOrThrow37 = i36;
                        columnIndexOrThrow23 = i34;
                        columnIndexOrThrow35 = i33;
                        columnIndexOrThrow42 = i39;
                        columnIndexOrThrow18 = columnIndexOrThrow18;
                        columnIndexOrThrow22 = i23;
                        columnIndexOrThrow17 = i21;
                        arrayMap6 = arrayMap7;
                        i16 = i22;
                        columnIndexOrThrow25 = i20;
                        i15 = i25;
                        columnIndexOrThrow31 = i28;
                        columnIndexOrThrow32 = i29;
                        columnIndexOrThrow33 = i30;
                        columnIndexOrThrow34 = i31;
                        columnIndexOrThrow39 = i38;
                        columnIndexOrThrow19 = columnIndexOrThrow19;
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 2:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda149(obj);
            default:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM album WHERE title LIKE '%' || ? || '%' AND EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) LIMIT ?");
                try {
                    sQLiteStatementPrepare3.bindText(1, str);
                    sQLiteStatementPrepare3.bindLong(2, i);
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "id");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "playlistId");
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "year");
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "thumbnailUrl");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "themeColor");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "songCount");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "duration");
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "explicit");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "lastUpdateTime");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "bookmarkedAt");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "likedDate");
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "inLibrary");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isLocal");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isUploaded");
                    int i40 = columnIndexOrThrow56;
                    ArrayMap arrayMap8 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        String text18 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        if (!arrayMap8.containsKey(text18)) {
                            arrayMap8.put(text18, new ArrayList());
                            columnIndexOrThrow55 = columnIndexOrThrow55;
                        }
                    }
                    int i41 = columnIndexOrThrow55;
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection3, arrayMap8);
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        String text19 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        String text20 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow44);
                        String text21 = sQLiteStatementPrepare3.getText(columnIndexOrThrow45);
                        Integer numValueOf3 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow46) ? null : Integer.valueOf((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow46));
                        String text22 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow47);
                        Integer numValueOf4 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow48) ? null : Integer.valueOf((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow48));
                        int i42 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow49);
                        int i43 = columnIndexOrThrow49;
                        int i44 = columnIndexOrThrow46;
                        int i45 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow50);
                        int i46 = columnIndexOrThrow50;
                        boolean z9 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow51)) != 0;
                        LocalDateTime localDateTimeFromTimestamp9 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(columnIndexOrThrow52) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow52)));
                        if (localDateTimeFromTimestamp9 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        LocalDateTime localDateTimeFromTimestamp10 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(columnIndexOrThrow53) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow53)));
                        LocalDateTime localDateTimeFromTimestamp11 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(columnIndexOrThrow54) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow54)));
                        int i47 = i41;
                        int i48 = columnIndexOrThrow54;
                        int i49 = i40;
                        int i50 = columnIndexOrThrow53;
                        int i51 = columnIndexOrThrow57;
                        int i52 = columnIndexOrThrow52;
                        AlbumEntity albumEntity = new AlbumEntity(text19, text20, text21, numValueOf3, text22, numValueOf4, i42, i45, z9, localDateTimeFromTimestamp9, localDateTimeFromTimestamp10, localDateTimeFromTimestamp11, Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i47) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i47))), ((int) sQLiteStatementPrepare3.getLong(i49)) != 0, ((int) sQLiteStatementPrepare3.getLong(i51)) != 0);
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap8, sQLiteStatementPrepare3.getText(columnIndexOrThrow43));
                        value4.getClass();
                        arrayList3.add(new Album(albumEntity, (List) value4, null, null));
                        columnIndexOrThrow45 = columnIndexOrThrow45;
                        columnIndexOrThrow52 = i52;
                        columnIndexOrThrow57 = i51;
                        columnIndexOrThrow53 = i50;
                        columnIndexOrThrow54 = i48;
                        i41 = i47;
                        i40 = i49;
                        columnIndexOrThrow50 = i46;
                        columnIndexOrThrow46 = i44;
                        columnIndexOrThrow49 = i43;
                    }
                    sQLiteStatementPrepare3.close();
                    return arrayList3;
                } catch (Throwable th) {
                    sQLiteStatementPrepare3.close();
                    throw th;
                }
        }
    }
}
