package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.EventWithSong;
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
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda25 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DatabaseDao_Impl f$1;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda25(DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = databaseDao_Impl;
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda174(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isUploaded = 1 ORDER BY totalPlayTime");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda180(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) ORDER BY title");
        try {
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                }
            }
            int i2 = columnIndexOrThrow11;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                Integer numValueOf2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                int i4 = columnIndexOrThrow2;
                int i5 = columnIndexOrThrow3;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i7 = i2;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i7)));
                int i8 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = columnIndexOrThrow13;
                int i10 = columnIndexOrThrow14;
                int i11 = columnIndexOrThrow15;
                int i12 = columnIndexOrThrow4;
                AlbumEntity albumEntity = new AlbumEntity(text2, text3, text4, numValueOf, text5, numValueOf2, i3, i6, z, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, localDateTimeFromTimestamp3, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9))), ((int) sQLiteStatementPrepare.getLong(i10)) != 0, ((int) sQLiteStatementPrepare.getLong(i11)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                arrayList.add(new Album(albumEntity, (List) value, null, null));
                i2 = i7;
                columnIndexOrThrow4 = i12;
                columnIndexOrThrow14 = i10;
                columnIndexOrThrow3 = i5;
                i = i8;
                columnIndexOrThrow15 = i11;
                columnIndexOrThrow2 = i4;
                columnIndexOrThrow13 = i9;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda181(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT album.*\n        FROM album\n                 JOIN song\n                      ON song.albumId = album.id\n        WHERE bookmarkedAt IS NOT NULL\n        GROUP BY album.id\n        ORDER BY SUM(song.totalPlayTime)\n    ");
        try {
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
            int i = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                }
            }
            int i2 = columnIndexOrThrow11;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                Integer numValueOf2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                int i3 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                int i4 = columnIndexOrThrow2;
                int i5 = columnIndexOrThrow3;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i7 = i2;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i7)));
                int i8 = i;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = columnIndexOrThrow13;
                int i10 = columnIndexOrThrow14;
                int i11 = columnIndexOrThrow15;
                int i12 = columnIndexOrThrow4;
                AlbumEntity albumEntity = new AlbumEntity(text2, text3, text4, numValueOf, text5, numValueOf2, i3, i6, z, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, localDateTimeFromTimestamp3, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9))), ((int) sQLiteStatementPrepare.getLong(i10)) != 0, ((int) sQLiteStatementPrepare.getLong(i11)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                arrayList.add(new Album(albumEntity, (List) value, null, null));
                i2 = i7;
                columnIndexOrThrow4 = i12;
                columnIndexOrThrow14 = i10;
                columnIndexOrThrow3 = i5;
                i = i8;
                columnIndexOrThrow15 = i11;
                columnIndexOrThrow2 = i4;
                columnIndexOrThrow13 = i9;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda182(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isUploaded = 1 ORDER BY title");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda184(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isUploaded = 1 ORDER BY rowId");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda186(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE inLibrary IS NOT NULL ORDER BY rowId");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda189(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isEpisode = 1 AND isDownloaded = 1 ORDER BY title");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda190(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT DISTINCT song.*\n        FROM song\n        JOIN playlist_song_map ON playlist_song_map.songId = song.id\n        JOIN playlist ON playlist.id = playlist_song_map.playlistId\n        WHERE playlist.bookmarkedAt IS NOT NULL\n        ");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda194(Object obj) throws Exception {
        EventWithSong eventWithSong;
        Long lValueOf;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM event ORDER BY rowId ASC LIMIT 1");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songId");
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playTime");
            ArrayMap arrayMap = new ArrayMap(0);
            while (true) {
                eventWithSong = null;
                lValueOf = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
            }
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong(sQLiteConnection, arrayMap);
            if (sQLiteStatementPrepare.step()) {
                long j = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                if (!sQLiteStatementPrepare.isNull(columnIndexOrThrow3)) {
                    lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow3));
                }
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(lValueOf);
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                Event event = new Event(j, text, localDateTimeFromTimestamp, sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                Song song = (Song) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                if (song == null) {
                    throw new IllegalStateException("Relationship item 'song' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'songId' and entityColumn named 'id'.");
                }
                eventWithSong = new EventWithSong(event, song);
            }
            sQLiteStatementPrepare.close();
            return eventWithSong;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda44(Object obj) throws Exception {
        int i;
        String text;
        int i2;
        String str;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE bookmarkedAt IS NOT NULL ORDER BY rowId");
        try {
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
            int i3 = columnIndexOrThrow12;
            int i4 = columnIndexOrThrow11;
            ArrayMap arrayMap = new ArrayMap(0);
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text2)) {
                    arrayMap.put(text2, new ArrayList());
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
            }
            int i5 = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow4)));
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                ArrayMap arrayMap2 = arrayMap;
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8));
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                int i7 = i5;
                if (sQLiteStatementPrepare.isNull(i7)) {
                    i = i4;
                    text = null;
                } else {
                    i = i4;
                    text = sQLiteStatementPrepare.getText(i7);
                }
                if (sQLiteStatementPrepare.isNull(i)) {
                    i2 = i3;
                    str = null;
                } else {
                    String text7 = sQLiteStatementPrepare.getText(i);
                    i2 = i3;
                    str = text7;
                }
                String text8 = sQLiteStatementPrepare.isNull(i2) ? null : sQLiteStatementPrepare.getText(i2);
                int i8 = columnIndexOrThrow13;
                int i9 = columnIndexOrThrow3;
                int i10 = columnIndexOrThrow14;
                int i11 = columnIndexOrThrow5;
                PlaylistEntity playlistEntity = new PlaylistEntity(text3, text4, text5, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z, localDateTimeFromTimestamp3, numValueOf, text6, text, str, text8, ((int) sQLiteStatementPrepare.getLong(i8)) != 0, ((int) sQLiteStatementPrepare.getLong(i10)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                arrayList.add(new Playlist(playlistEntity, i6, (List) value));
                columnIndexOrThrow5 = i11;
                columnIndexOrThrow14 = i10;
                arrayMap = arrayMap2;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                columnIndexOrThrow3 = i9;
                columnIndexOrThrow13 = i8;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                i4 = i;
                i3 = i2;
                i5 = i7;
                columnIndexOrThrow15 = columnIndexOrThrow15;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda48(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE liked ORDER BY likedDate");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda70(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE liked ORDER BY rowId");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda76(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE liked ORDER BY totalPlayTime");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda80(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda86(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE inLibrary IS NOT NULL ORDER BY inLibrary");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda90(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE liked ORDER BY title");
        try {
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
            sQLiteStatementPrepare.reset();
            databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
            databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
            databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
            databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                ArrayMap arrayMap5 = arrayMap;
                int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i7 = i5;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                int i8 = i4;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i8)));
                int i9 = i3;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
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
                int i20 = columnIndexOrThrow5;
                int i21 = columnIndexOrThrow20;
                int i22 = columnIndexOrThrow4;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                columnIndexOrThrow21 = i23;
                int i24 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                int i25 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                columnIndexOrThrow23 = i25;
                int i26 = columnIndexOrThrow24;
                columnIndexOrThrow25 = columnIndexOrThrow25;
                columnIndexOrThrow26 = columnIndexOrThrow26;
                int i27 = columnIndexOrThrow27;
                SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i19, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i26)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i27)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow27 = i27;
                columnIndexOrThrow13 = i12;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow17 = i16;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                i3 = i9;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow24 = i26;
                i5 = i7;
                i2 = i10;
                columnIndexOrThrow4 = i22;
                columnIndexOrThrow20 = i21;
                arrayMap = arrayMap5;
                columnIndexOrThrow22 = i24;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow5 = i20;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isDownloaded = 1 AND (isEpisode = 0 OR isEpisode IS NULL) ORDER BY dateDownload");
                try {
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
                    int i = columnIndexOrThrow13;
                    ArrayMap arrayMap = new ArrayMap(0);
                    int i2 = columnIndexOrThrow12;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    int i3 = columnIndexOrThrow11;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i4 = columnIndexOrThrow10;
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
                        columnIndexOrThrow9 = columnIndexOrThrow9;
                    }
                    int i5 = columnIndexOrThrow9;
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        int i6 = columnIndexOrThrow6;
                        int i7 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text7 = sQLiteStatementPrepare.isNull(i6) ? null : sQLiteStatementPrepare.getText(i6);
                        int i8 = columnIndexOrThrow4;
                        int i9 = columnIndexOrThrow2;
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8));
                        int i10 = i5;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i10)));
                        int i11 = i4;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                        i5 = i10;
                        int i12 = i3;
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(i12)) != 0;
                        int i13 = i2;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                        int i14 = i;
                        long j = sQLiteStatementPrepare.getLong(i14);
                        int i15 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i15)));
                        columnIndexOrThrow14 = i15;
                        int i16 = columnIndexOrThrow15;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                        columnIndexOrThrow15 = i16;
                        i = i14;
                        int i17 = columnIndexOrThrow16;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                        int i18 = columnIndexOrThrow17;
                        String text8 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                        int i19 = columnIndexOrThrow18;
                        String text9 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                        int i20 = columnIndexOrThrow19;
                        int i21 = (int) sQLiteStatementPrepare.getLong(i20);
                        i4 = i11;
                        int i22 = columnIndexOrThrow20;
                        boolean z4 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                        int i23 = columnIndexOrThrow21;
                        boolean z5 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                        columnIndexOrThrow21 = i23;
                        int i24 = columnIndexOrThrow22;
                        boolean z6 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                        columnIndexOrThrow22 = i24;
                        int i25 = columnIndexOrThrow23;
                        boolean z7 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                        columnIndexOrThrow23 = i25;
                        columnIndexOrThrow24 = columnIndexOrThrow24;
                        columnIndexOrThrow25 = columnIndexOrThrow25;
                        int i26 = columnIndexOrThrow26;
                        SongEntity songEntity = new SongEntity(text3, text4, i7, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i21, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(i26) ? null : sQLiteStatementPrepare.getText(i26), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow26 = i26;
                        columnIndexOrThrow2 = i9;
                        i3 = i12;
                        i2 = i13;
                        columnIndexOrThrow16 = i17;
                        columnIndexOrThrow17 = i18;
                        columnIndexOrThrow18 = i19;
                        columnIndexOrThrow19 = i20;
                        columnIndexOrThrow20 = i22;
                        columnIndexOrThrow27 = columnIndexOrThrow27;
                        columnIndexOrThrow6 = i6;
                        columnIndexOrThrow4 = i8;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 1:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda174(obj);
            case 2:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT * FROM album WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) ORDER BY duration");
                try {
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
                        int i31 = columnIndexOrThrow36;
                        int i32 = columnIndexOrThrow32;
                        int i33 = columnIndexOrThrow30;
                        boolean z8 = ((int) sQLiteStatementPrepare2.getLong(i31)) != 0;
                        int i34 = columnIndexOrThrow37;
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i34) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i34)));
                        if (localDateTimeFromTimestamp6 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow38) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow38)));
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow39) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow39)));
                        int i35 = i28;
                        LocalDateTime localDateTimeFromTimestamp9 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i35) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i35)));
                        columnIndexOrThrow37 = i34;
                        i28 = i35;
                        int i36 = i27;
                        int i37 = columnIndexOrThrow42;
                        AlbumEntity albumEntity = new AlbumEntity(text11, text12, text13, numValueOf2, text14, numValueOf3, i29, i30, z8, localDateTimeFromTimestamp6, localDateTimeFromTimestamp7, localDateTimeFromTimestamp8, localDateTimeFromTimestamp9, ((int) sQLiteStatementPrepare2.getLong(i36)) != 0, ((int) sQLiteStatementPrepare2.getLong(i37)) != 0);
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value3.getClass();
                        i27 = i36;
                        columnIndexOrThrow42 = i37;
                        arrayList2.add(new Album(albumEntity, (List) value3, null, null));
                        columnIndexOrThrow30 = i33;
                        columnIndexOrThrow36 = i31;
                        columnIndexOrThrow32 = i32;
                    }
                    sQLiteStatementPrepare2.close();
                    return arrayList2;
                } catch (Throwable th) {
                    sQLiteStatementPrepare2.close();
                    throw th;
                }
            case 3:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda180(obj);
            case 4:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda181(obj);
            case 5:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda182(obj);
            case 6:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda184(obj);
            case 7:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda186(obj);
            case 8:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda189(obj);
            case 9:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda190(obj);
            case 10:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda194(obj);
            case 11:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda44(obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda48(obj);
            case 13:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda70(obj);
            case 14:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda76(obj);
            case 15:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda80(obj);
            case 16:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda86(obj);
            case 17:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda90(obj);
            default:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM song WHERE isEpisode = 1 ORDER BY inLibrary");
                try {
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "id");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "duration");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "thumbnailUrl");
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "albumId");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "albumName");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "explicit");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "year");
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "date");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "dateModified");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "liked");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "likedDate");
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "totalPlayTime");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "inLibrary");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "dateDownload");
                    int columnIndexOrThrow58 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isLocal");
                    int columnIndexOrThrow59 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "libraryAddToken");
                    int columnIndexOrThrow60 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "libraryRemoveToken");
                    int columnIndexOrThrow61 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "lyricsOffset");
                    int columnIndexOrThrow62 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "romanizeLyrics");
                    int columnIndexOrThrow63 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isDownloaded");
                    int columnIndexOrThrow64 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isUploaded");
                    int columnIndexOrThrow65 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isVideo");
                    int columnIndexOrThrow66 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isEpisode");
                    int columnIndexOrThrow67 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "playbackPosition");
                    int columnIndexOrThrow68 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "uploadEntityId");
                    int columnIndexOrThrow69 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isCached");
                    int i38 = columnIndexOrThrow55;
                    ArrayMap arrayMap6 = new ArrayMap(0);
                    int i39 = columnIndexOrThrow54;
                    ArrayMap arrayMap7 = new ArrayMap(0);
                    int i40 = columnIndexOrThrow53;
                    ArrayMap arrayMap8 = new ArrayMap(0);
                    int i41 = columnIndexOrThrow52;
                    ArrayMap arrayMap9 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        String text15 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        if (!arrayMap6.containsKey(text15)) {
                            arrayMap6.put(text15, new ArrayList());
                        }
                        String text16 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        if (!arrayMap7.containsKey(text16)) {
                            arrayMap7.put(text16, new ArrayList());
                        }
                        arrayMap8.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow43), null);
                        arrayMap9.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow43), null);
                        columnIndexOrThrow51 = columnIndexOrThrow51;
                    }
                    int i42 = columnIndexOrThrow51;
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection3, arrayMap6);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection3, arrayMap7);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection3, arrayMap8);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection3, arrayMap9);
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        String text17 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        String text18 = sQLiteStatementPrepare3.getText(columnIndexOrThrow44);
                        ArrayMap arrayMap10 = arrayMap9;
                        int i43 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow45);
                        String text19 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow46);
                        String text20 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow47);
                        String text21 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow48);
                        boolean z9 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow49)) != 0;
                        Integer numValueOf4 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow50) ? null : Integer.valueOf((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow50));
                        int i44 = i42;
                        LocalDateTime localDateTimeFromTimestamp10 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i44) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i44)));
                        int i45 = i41;
                        LocalDateTime localDateTimeFromTimestamp11 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i45) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i45)));
                        int i46 = columnIndexOrThrow46;
                        i42 = i44;
                        int i47 = i40;
                        boolean z10 = ((int) sQLiteStatementPrepare3.getLong(i47)) != 0;
                        int i48 = i39;
                        LocalDateTime localDateTimeFromTimestamp12 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i48) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i48)));
                        int i49 = i38;
                        long j2 = sQLiteStatementPrepare3.getLong(i49);
                        int i50 = columnIndexOrThrow56;
                        LocalDateTime localDateTimeFromTimestamp13 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i50) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i50)));
                        columnIndexOrThrow56 = i50;
                        int i51 = columnIndexOrThrow57;
                        LocalDateTime localDateTimeFromTimestamp14 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i51) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i51)));
                        columnIndexOrThrow57 = i51;
                        i39 = i48;
                        int i52 = columnIndexOrThrow58;
                        boolean z11 = ((int) sQLiteStatementPrepare3.getLong(i52)) != 0;
                        int i53 = columnIndexOrThrow59;
                        String text22 = sQLiteStatementPrepare3.isNull(i53) ? null : sQLiteStatementPrepare3.getText(i53);
                        int i54 = columnIndexOrThrow60;
                        String text23 = sQLiteStatementPrepare3.isNull(i54) ? null : sQLiteStatementPrepare3.getText(i54);
                        int i55 = columnIndexOrThrow61;
                        int i56 = (int) sQLiteStatementPrepare3.getLong(i55);
                        int i57 = columnIndexOrThrow62;
                        int i58 = columnIndexOrThrow44;
                        boolean z12 = ((int) sQLiteStatementPrepare3.getLong(i57)) != 0;
                        int i59 = columnIndexOrThrow63;
                        boolean z13 = ((int) sQLiteStatementPrepare3.getLong(i59)) != 0;
                        columnIndexOrThrow63 = i59;
                        int i60 = columnIndexOrThrow64;
                        boolean z14 = ((int) sQLiteStatementPrepare3.getLong(i60)) != 0;
                        columnIndexOrThrow64 = i60;
                        int i61 = columnIndexOrThrow65;
                        boolean z15 = ((int) sQLiteStatementPrepare3.getLong(i61)) != 0;
                        columnIndexOrThrow65 = i61;
                        columnIndexOrThrow66 = columnIndexOrThrow66;
                        columnIndexOrThrow67 = columnIndexOrThrow67;
                        int i62 = columnIndexOrThrow68;
                        SongEntity songEntity2 = new SongEntity(text17, text18, i43, text19, text20, text21, z9, numValueOf4, localDateTimeFromTimestamp10, localDateTimeFromTimestamp11, z10, localDateTimeFromTimestamp12, j2, localDateTimeFromTimestamp13, localDateTimeFromTimestamp14, z11, text22, text23, i56, z12, z13, z14, z15, ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow66)) != 0, sQLiteStatementPrepare3.isNull(columnIndexOrThrow67) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow67)), sQLiteStatementPrepare3.isNull(i62) ? null : sQLiteStatementPrepare3.getText(i62), ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow69)) != 0);
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap6, sQLiteStatementPrepare3.getText(columnIndexOrThrow43));
                        value4.getClass();
                        List list2 = (List) value4;
                        Object value5 = MapsKt__MapsKt.getValue(arrayMap7, sQLiteStatementPrepare3.getText(columnIndexOrThrow43));
                        value5.getClass();
                        arrayMap9 = arrayMap10;
                        arrayList3.add(new Song(songEntity2, list2, (List) value5, (AlbumEntity) arrayMap8.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow43)), (FormatEntity) arrayMap9.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow43))));
                        columnIndexOrThrow68 = i62;
                        columnIndexOrThrow44 = i58;
                        columnIndexOrThrow62 = i57;
                        columnIndexOrThrow69 = columnIndexOrThrow69;
                        columnIndexOrThrow46 = i46;
                        i41 = i45;
                        i40 = i47;
                        i38 = i49;
                        columnIndexOrThrow58 = i52;
                        columnIndexOrThrow59 = i53;
                        columnIndexOrThrow60 = i54;
                        columnIndexOrThrow61 = i55;
                        break;
                    }
                    return arrayList3;
                } finally {
                    sQLiteStatementPrepare3.close();
                }
        }
    }
}
