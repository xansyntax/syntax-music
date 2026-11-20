package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
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
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ DatabaseDao_Impl f$2;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda9(String str, DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = str;
        this.f$2 = databaseDao_Impl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda119(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM (SELECT * from related_song_map GROUP BY relatedSongId) map JOIN song ON song.id = map.relatedSongId where songId = ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i2 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i3 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i4 = columnIndexOrThrow9;
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
            int i5 = columnIndexOrThrow8;
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
                ArrayMap arrayMap5 = arrayMap4;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? str2 : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                i4 = i8;
                int i10 = i2;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i10)) != 0;
                int i11 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                int i12 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i12);
                int i13 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                columnIndexOrThrow14 = i13;
                int i14 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                columnIndexOrThrow15 = i14;
                i = i11;
                int i15 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                int i16 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                int i18 = columnIndexOrThrow19;
                int i19 = (int) sQLiteStatementPrepare.getLong(i18);
                int i20 = columnIndexOrThrow20;
                int i21 = columnIndexOrThrow5;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i20)) != 0;
                int i22 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                columnIndexOrThrow21 = i22;
                int i23 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                int i24 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                columnIndexOrThrow23 = i24;
                int i25 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i26 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i25)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow22 = i23;
                columnIndexOrThrow5 = i21;
                columnIndexOrThrow20 = i20;
                columnIndexOrThrow27 = i26;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                arrayMap4 = arrayMap5;
                columnIndexOrThrow24 = i25;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i5 = i7;
                i2 = i10;
                str2 = null;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda121(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = ? AND inLibrary IS NOT NULL ORDER BY totalPlayTime");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i2 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i3 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i4 = columnIndexOrThrow9;
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
            int i5 = columnIndexOrThrow8;
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
                ArrayMap arrayMap5 = arrayMap4;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? str2 : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                i4 = i8;
                int i10 = i2;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i10)) != 0;
                int i11 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                int i12 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i12);
                int i13 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                columnIndexOrThrow14 = i13;
                int i14 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                columnIndexOrThrow15 = i14;
                i = i11;
                int i15 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                int i16 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                int i18 = columnIndexOrThrow19;
                int i19 = (int) sQLiteStatementPrepare.getLong(i18);
                int i20 = columnIndexOrThrow20;
                int i21 = columnIndexOrThrow5;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i20)) != 0;
                int i22 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                columnIndexOrThrow21 = i22;
                int i23 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                int i24 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                columnIndexOrThrow23 = i24;
                int i25 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i26 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i25)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow22 = i23;
                columnIndexOrThrow5 = i21;
                columnIndexOrThrow20 = i20;
                columnIndexOrThrow27 = i26;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                arrayMap4 = arrayMap5;
                columnIndexOrThrow24 = i25;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i5 = i7;
                i2 = i10;
                str2 = null;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda139(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = ? AND inLibrary IS NOT NULL LIMIT ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
            sQLiteStatementPrepare.bindLong(2, 3L);
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i2 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i3 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i4 = columnIndexOrThrow9;
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
            int i5 = columnIndexOrThrow8;
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
                ArrayMap arrayMap5 = arrayMap4;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? str2 : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                i4 = i8;
                int i10 = i2;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i10)) != 0;
                int i11 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                int i12 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i12);
                int i13 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                columnIndexOrThrow14 = i13;
                int i14 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                columnIndexOrThrow15 = i14;
                i = i11;
                int i15 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                int i16 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                int i18 = columnIndexOrThrow19;
                int i19 = (int) sQLiteStatementPrepare.getLong(i18);
                int i20 = columnIndexOrThrow20;
                int i21 = columnIndexOrThrow5;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i20)) != 0;
                int i22 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                columnIndexOrThrow21 = i22;
                int i23 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                int i24 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                columnIndexOrThrow23 = i24;
                int i25 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i26 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i25)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow22 = i23;
                columnIndexOrThrow5 = i21;
                columnIndexOrThrow20 = i20;
                columnIndexOrThrow27 = i26;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                arrayMap4 = arrayMap5;
                columnIndexOrThrow24 = i25;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i5 = i7;
                i2 = i10;
                str2 = null;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda168(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = ? AND inLibrary IS NOT NULL ORDER BY title");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i2 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i3 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i4 = columnIndexOrThrow9;
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
            int i5 = columnIndexOrThrow8;
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
                ArrayMap arrayMap5 = arrayMap4;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? str2 : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                i4 = i8;
                int i10 = i2;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i10)) != 0;
                int i11 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                int i12 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i12);
                int i13 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                columnIndexOrThrow14 = i13;
                int i14 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                columnIndexOrThrow15 = i14;
                i = i11;
                int i15 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                int i16 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                int i18 = columnIndexOrThrow19;
                int i19 = (int) sQLiteStatementPrepare.getLong(i18);
                int i20 = columnIndexOrThrow20;
                int i21 = columnIndexOrThrow5;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i20)) != 0;
                int i22 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                columnIndexOrThrow21 = i22;
                int i23 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                int i24 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                columnIndexOrThrow23 = i24;
                int i25 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i26 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i25)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow22 = i23;
                columnIndexOrThrow5 = i21;
                columnIndexOrThrow20 = i20;
                columnIndexOrThrow27 = i26;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                arrayMap4 = arrayMap5;
                columnIndexOrThrow24 = i25;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i5 = i7;
                i2 = i10;
                str2 = null;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda195(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE id = ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playlistId");
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "year");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "themeColor");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "duration");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "explicit");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "likedDate");
            int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "inLibrary");
            int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isUploaded");
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                }
            }
            int i = columnIndexOrThrow11;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection, arrayMap);
            Album album = null;
            if (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                Integer numValueOf2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                AlbumEntity albumEntity = new AlbumEntity(text2, text3, text4, numValueOf, text5, numValueOf2, i2, i3, z, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow12))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow13))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow14)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                album = new Album(albumEntity, (List) value, null, null);
            }
            sQLiteStatementPrepare.close();
            return album;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda32(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE browseId = ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
            }
            int i = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection, arrayMap);
            Object playlist = null;
            if (sQLiteStatementPrepare.step()) {
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15);
                PlaylistEntity playlistEntity = new PlaylistEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7))), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(i) ? null : sQLiteStatementPrepare.getText(i), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow14)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                playlist = new Playlist(playlistEntity, i2, (List) value);
            }
            return playlist;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda41(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE id = ?");
        String str = this.f$1;
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
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
            ArrayMap arrayMap = new ArrayMap(0);
            ArrayMap arrayMap2 = new ArrayMap(0);
            ArrayMap arrayMap3 = new ArrayMap(0);
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
            int i = columnIndexOrThrow8;
            Object song = null;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            if (sQLiteStatementPrepare.step()) {
                SongEntity songEntity = new SongEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.isNull(i) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i)), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow12))), sQLiteStatementPrepare.getLong(columnIndexOrThrow13), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow14))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow15))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow19), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow20)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow21)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow22)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow23)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                song = new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            sQLiteStatementPrepare.close();
            return song;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda42(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE id = ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
            }
            int i = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection, arrayMap);
            Object playlist = null;
            if (sQLiteStatementPrepare.step()) {
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15);
                PlaylistEntity playlistEntity = new PlaylistEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7))), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(i) ? null : sQLiteStatementPrepare.getText(i), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow14)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                playlist = new Playlist(playlistEntity, i2, (List) value);
            }
            return playlist;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda43(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE id = ? LIMIT 1");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            ArrayMap arrayMap = new ArrayMap(0);
            ArrayMap arrayMap2 = new ArrayMap(0);
            ArrayMap arrayMap3 = new ArrayMap(0);
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
            int i = columnIndexOrThrow8;
            Object song = null;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            if (sQLiteStatementPrepare.step()) {
                SongEntity songEntity = new SongEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.isNull(i) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i)), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow12))), sQLiteStatementPrepare.getLong(columnIndexOrThrow13), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow14))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow15))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow19), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow20)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow21)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow22)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow23)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                song = new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            return song;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda47(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE id = ? LIMIT 1");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            ArrayMap arrayMap = new ArrayMap(0);
            ArrayMap arrayMap2 = new ArrayMap(0);
            ArrayMap arrayMap3 = new ArrayMap(0);
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
            int i = columnIndexOrThrow8;
            Object song = null;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            if (sQLiteStatementPrepare.step()) {
                SongEntity songEntity = new SongEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.isNull(i) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i)), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow12))), sQLiteStatementPrepare.getLong(columnIndexOrThrow13), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow14))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow15))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow19), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow20)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow21)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow22)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow23)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                song = new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            return song;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda68(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE id = ?");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
            }
            int i = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection, arrayMap);
            Object playlist = null;
            if (sQLiteStatementPrepare.step()) {
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15);
                PlaylistEntity playlistEntity = new PlaylistEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7))), sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9), sQLiteStatementPrepare.isNull(i) ? null : sQLiteStatementPrepare.getText(i), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11), sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow14)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                playlist = new Playlist(playlistEntity, i2, (List) value);
            }
            return playlist;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda91(Object obj) throws Exception {
        String str = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = ? AND inLibrary IS NOT NULL ORDER BY inLibrary");
        try {
            sQLiteStatementPrepare.bindText(1, str);
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i2 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i3 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i4 = columnIndexOrThrow9;
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
            int i5 = columnIndexOrThrow8;
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
                ArrayMap arrayMap5 = arrayMap4;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? str2 : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? str2 : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                i4 = i8;
                int i10 = i2;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i10)) != 0;
                int i11 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                int i12 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i12);
                int i13 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                columnIndexOrThrow14 = i13;
                int i14 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                columnIndexOrThrow15 = i14;
                i = i11;
                int i15 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                int i16 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16);
                int i17 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17);
                int i18 = columnIndexOrThrow19;
                int i19 = (int) sQLiteStatementPrepare.getLong(i18);
                int i20 = columnIndexOrThrow20;
                int i21 = columnIndexOrThrow5;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i20)) != 0;
                int i22 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                columnIndexOrThrow21 = i22;
                int i23 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                int i24 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                columnIndexOrThrow23 = i24;
                int i25 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i26 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i25)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i26)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow22 = i23;
                columnIndexOrThrow5 = i21;
                columnIndexOrThrow20 = i20;
                columnIndexOrThrow27 = i26;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                arrayMap4 = arrayMap5;
                columnIndexOrThrow24 = i25;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i5 = i7;
                i2 = i10;
                str2 = null;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        AlbumWithSongs albumWithSongs;
        byte b = this.$r8$classId;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        String str = this.f$1;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM song JOIN song_album_map ON song.id = song_album_map.songId WHERE song_album_map.albumId = ?");
                try {
                    sQLiteStatementPrepare.bindText(1, str);
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
                    int i = columnIndexOrThrow21;
                    ArrayMap arrayMap = new ArrayMap(0);
                    int i2 = columnIndexOrThrow15;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    int i3 = columnIndexOrThrow13;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i4 = columnIndexOrThrow11;
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
                    int i5 = columnIndexOrThrow8;
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
                        int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str2 : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        columnIndexOrThrow6 = columnIndexOrThrow6;
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        int i7 = i5;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                        int i8 = columnIndexOrThrow9;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                        int i9 = columnIndexOrThrow10;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                        columnIndexOrThrow9 = i8;
                        int i10 = columnIndexOrThrow4;
                        int i11 = i4;
                        int i12 = columnIndexOrThrow7;
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(i11)) != 0;
                        int i13 = columnIndexOrThrow12;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                        int i14 = i3;
                        long j = sQLiteStatementPrepare.getLong(i14);
                        int i15 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i15)));
                        columnIndexOrThrow14 = i15;
                        int i16 = i2;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                        i2 = i16;
                        i3 = i14;
                        int i17 = columnIndexOrThrow16;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                        int i18 = columnIndexOrThrow17;
                        String text8 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                        int i19 = columnIndexOrThrow18;
                        String text9 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                        int i20 = columnIndexOrThrow19;
                        int i21 = (int) sQLiteStatementPrepare.getLong(i20);
                        int i22 = columnIndexOrThrow20;
                        boolean z4 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                        int i23 = i;
                        boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                        i = i23;
                        int i24 = columnIndexOrThrow22;
                        boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                        columnIndexOrThrow22 = i24;
                        int i25 = columnIndexOrThrow23;
                        boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                        columnIndexOrThrow23 = i25;
                        columnIndexOrThrow24 = columnIndexOrThrow24;
                        columnIndexOrThrow25 = columnIndexOrThrow25;
                        int i26 = columnIndexOrThrow26;
                        SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i21, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(i26) ? null : sQLiteStatementPrepare.getText(i26), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow4 = i10;
                        columnIndexOrThrow27 = columnIndexOrThrow27;
                        columnIndexOrThrow10 = i9;
                        columnIndexOrThrow20 = i22;
                        columnIndexOrThrow7 = i12;
                        columnIndexOrThrow26 = i26;
                        i4 = i11;
                        columnIndexOrThrow12 = i13;
                        columnIndexOrThrow16 = i17;
                        columnIndexOrThrow17 = i18;
                        columnIndexOrThrow18 = i19;
                        columnIndexOrThrow19 = i20;
                        i5 = i7;
                        str2 = null;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 1:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda119(obj);
            case 2:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda121(obj);
            case 3:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda139(obj);
            case 4:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("\n        SELECT album.*, count(song.dateDownload) downloadCount\n        FROM album_artist_map\n            JOIN album ON album_artist_map.albumId = album.id\n            JOIN song ON album_artist_map.albumId = song.albumId\n        WHERE artistId = ?\n        GROUP BY album.id\n        LIMIT ?\n    ");
                try {
                    sQLiteStatementPrepare2.bindText(1, str);
                    sQLiteStatementPrepare2.bindLong(2, 6L);
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playlistId");
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "year");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "themeColor");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "songCount");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "duration");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "explicit");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lastUpdateTime");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "bookmarkedAt");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "likedDate");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "inLibrary");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isUploaded");
                    int i27 = columnIndexOrThrow41;
                    ArrayMap arrayMap5 = new ArrayMap(0);
                    while (sQLiteStatementPrepare2.step()) {
                        String text10 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        if (!arrayMap5.containsKey(text10)) {
                            arrayMap5.put(text10, new ArrayList());
                            columnIndexOrThrow40 = columnIndexOrThrow40;
                        }
                    }
                    int i28 = columnIndexOrThrow40;
                    sQLiteStatementPrepare2.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection2, arrayMap5);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        String text11 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        String text12 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow29);
                        String text13 = sQLiteStatementPrepare2.getText(columnIndexOrThrow30);
                        Integer numValueOf2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow31) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow31));
                        String text14 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow32);
                        Integer numValueOf3 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow33) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow33));
                        int i29 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow34);
                        int i30 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow35);
                        boolean z8 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow36)) != 0;
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow37) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow37)));
                        if (localDateTimeFromTimestamp6 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow38) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow38)));
                        int i31 = i28;
                        int i32 = columnIndexOrThrow37;
                        int i33 = i27;
                        int i34 = columnIndexOrThrow38;
                        int i35 = columnIndexOrThrow42;
                        i28 = i31;
                        AlbumEntity albumEntity = new AlbumEntity(text11, text12, text13, numValueOf2, text14, numValueOf3, i29, i30, z8, localDateTimeFromTimestamp6, localDateTimeFromTimestamp7, Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow39) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow39))), Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i31) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i31))), ((int) sQLiteStatementPrepare2.getLong(i33)) != 0, ((int) sQLiteStatementPrepare2.getLong(i35)) != 0);
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value3.getClass();
                        arrayList2.add(new Album(albumEntity, (List) value3, null, null));
                        columnIndexOrThrow29 = columnIndexOrThrow29;
                        columnIndexOrThrow28 = columnIndexOrThrow28;
                        columnIndexOrThrow38 = i34;
                        columnIndexOrThrow42 = i35;
                        columnIndexOrThrow30 = columnIndexOrThrow30;
                        i27 = i33;
                        columnIndexOrThrow37 = i32;
                    }
                    sQLiteStatementPrepare2.close();
                    return arrayList2;
                } catch (Throwable th) {
                    sQLiteStatementPrepare2.close();
                    throw th;
                }
            case 5:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda168(obj);
            case 6:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda195(obj);
            case 7:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda32(obj);
            case 8:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda41(obj);
            case 9:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda42(obj);
            case 10:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda43(obj);
            case 11:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM playlist_song_map WHERE playlistId = ? ORDER BY position");
                try {
                    sQLiteStatementPrepare3.bindText(1, str);
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "id");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "playlistId");
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "songId");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "position");
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "setVideoId");
                    ArrayMap arrayMap6 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        arrayMap6.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow45), null);
                    }
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong(sQLiteConnection3, arrayMap6);
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        PlaylistSongMap playlistSongMap = new PlaylistSongMap((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow43), sQLiteStatementPrepare3.getText(columnIndexOrThrow44), sQLiteStatementPrepare3.getText(columnIndexOrThrow45), (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow46), sQLiteStatementPrepare3.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow47));
                        Song song = (Song) arrayMap6.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow45));
                        if (song == null) {
                            throw new IllegalStateException("Relationship item 'song' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'songId' and entityColumn named 'id'.");
                        }
                        arrayList3.add(new PlaylistSong(playlistSongMap, song));
                    }
                    sQLiteStatementPrepare3.close();
                    return arrayList3;
                } catch (Throwable th2) {
                    sQLiteStatementPrepare3.close();
                    throw th2;
                }
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda47(obj);
            case 13:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda68(obj);
            case 14:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda91(obj);
            default:
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                SQLiteStatement sQLiteStatementPrepare4 = sQLiteConnection4.prepare("SELECT * FROM album WHERE id = ?");
                try {
                    sQLiteStatementPrepare4.bindText(1, str);
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "id");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "playlistId");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "year");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "thumbnailUrl");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "themeColor");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "songCount");
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "duration");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "explicit");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "lastUpdateTime");
                    int columnIndexOrThrow58 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "bookmarkedAt");
                    int columnIndexOrThrow59 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "likedDate");
                    int columnIndexOrThrow60 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "inLibrary");
                    int columnIndexOrThrow61 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isLocal");
                    int columnIndexOrThrow62 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isUploaded");
                    ArrayMap arrayMap7 = new ArrayMap(0);
                    ArrayMap arrayMap8 = new ArrayMap(0);
                    while (sQLiteStatementPrepare4.step()) {
                        String text15 = sQLiteStatementPrepare4.getText(columnIndexOrThrow48);
                        if (!arrayMap7.containsKey(text15)) {
                            arrayMap7.put(text15, new ArrayList());
                        }
                        String text16 = sQLiteStatementPrepare4.getText(columnIndexOrThrow48);
                        if (!arrayMap8.containsKey(text16)) {
                            arrayMap8.put(text16, new ArrayList());
                        }
                        columnIndexOrThrow59 = columnIndexOrThrow59;
                    }
                    int i36 = columnIndexOrThrow59;
                    sQLiteStatementPrepare4.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection4, arrayMap7);
                    databaseDao_Impl.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong_1(sQLiteConnection4, arrayMap8);
                    if (sQLiteStatementPrepare4.step()) {
                        String text17 = sQLiteStatementPrepare4.getText(columnIndexOrThrow48);
                        String text18 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow49);
                        String text19 = sQLiteStatementPrepare4.getText(columnIndexOrThrow50);
                        Integer numValueOf4 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow51) ? null : Integer.valueOf((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow51));
                        String text20 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow52) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow52);
                        Integer numValueOf5 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow53) ? null : Integer.valueOf((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow53));
                        int i37 = (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow54);
                        int i38 = (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow55);
                        boolean z9 = ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow56)) != 0;
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow57) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow57)));
                        if (localDateTimeFromTimestamp8 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        AlbumEntity albumEntity2 = new AlbumEntity(text17, text18, text19, numValueOf4, text20, numValueOf5, i37, i38, z9, localDateTimeFromTimestamp8, Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow58) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow58))), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(i36) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(i36))), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow60) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow60))), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow61)) != 0, ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow62)) != 0);
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap7, sQLiteStatementPrepare4.getText(columnIndexOrThrow48));
                        value4.getClass();
                        Object value5 = MapsKt__MapsKt.getValue(arrayMap8, sQLiteStatementPrepare4.getText(columnIndexOrThrow48));
                        value5.getClass();
                        albumWithSongs = new AlbumWithSongs(albumEntity2, (List) value4, (List) value5);
                    } else {
                        albumWithSongs = null;
                    }
                    sQLiteStatementPrepare4.close();
                    return albumWithSongs;
                } catch (Throwable th3) {
                    sQLiteStatementPrepare4.close();
                    throw th3;
                }
        }
    }
}
