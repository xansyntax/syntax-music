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
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda109 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DatabaseDao_Impl f$1;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda109(DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = databaseDao_Impl;
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda114(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isUploaded = 1 ORDER BY dateDownload");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda115(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) ORDER BY year");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda118(Object obj) throws Exception {
        EventWithSong eventWithSong;
        Long lValueOf;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM event ORDER BY rowId DESC LIMIT 1");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda123(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isEpisode = 1 AND inLibrary IS NOT NULL ORDER BY inLibrary DESC");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda124(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY rowId");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda125(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY title");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda128(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT album.*\n        FROM album\n                 JOIN song\n                      ON song.albumId = album.id\n        WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL)\n        GROUP BY album.id\n        ORDER BY SUM(song.totalPlayTime)\n    ");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda129(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY title");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda131(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isEpisode = 1 AND inLibrary IS NOT NULL ORDER BY title");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda132(Object obj) throws Exception {
        int i;
        String text;
        int i2;
        String str;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE bookmarkedAt IS NOT NULL ORDER BY name");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda133(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isDownloaded = 1 AND (isEpisode = 0 OR isEpisode IS NULL) ORDER BY title");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda134(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) ORDER BY songCount");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda135(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY songCount");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda136(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY year");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda140(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY duration");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda142(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY year");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda148(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE isUploaded = 1 ORDER BY rowId");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda152(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE inLibrary IS NOT NULL ORDER BY title");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda157(Object obj) throws Exception {
        int i;
        String text;
        int i2;
        String str;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE bookmarkedAt IS NOT NULL ORDER BY songCount");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda158(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY songCount");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda161(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isDownloaded = 1 AND (isEpisode = 0 OR isEpisode IS NULL) ORDER BY totalPlayTime");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda162(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY duration");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda163(Object obj) throws Exception {
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda167(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) ORDER BY rowId");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda170(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isEpisode = 1 AND isDownloaded = 1 ORDER BY dateDownload");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda171(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE inLibrary IS NOT NULL ORDER BY totalPlayTime");
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

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda172(Object obj) throws Exception {
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE isEpisode = 1 AND isDownloaded = 1 ORDER BY totalPlayTime");
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
        int i;
        String text;
        byte b = this.$r8$classId;
        DatabaseDao_Impl databaseDao_Impl = this.f$1;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE dateDownload IS NOT NULL AND isDownloaded = 0");
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
                    int i2 = columnIndexOrThrow13;
                    ArrayMap arrayMap = new ArrayMap(0);
                    int i3 = columnIndexOrThrow12;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    int i4 = columnIndexOrThrow11;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i5 = columnIndexOrThrow10;
                    ArrayMap arrayMap4 = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap.containsKey(text2)) {
                            arrayMap.put(text2, new ArrayList());
                        }
                        String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap2.containsKey(text3)) {
                            arrayMap2.put(text3, new ArrayList());
                        }
                        arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                        arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                        columnIndexOrThrow9 = columnIndexOrThrow9;
                    }
                    int i6 = columnIndexOrThrow9;
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        int i7 = columnIndexOrThrow8;
                        int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(i7) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i7));
                        int i9 = i6;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                        int i10 = i5;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i10)));
                        int i11 = columnIndexOrThrow2;
                        i6 = i9;
                        int i12 = i4;
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(i12)) != 0;
                        int i13 = i3;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                        int i14 = i2;
                        long j = sQLiteStatementPrepare.getLong(i14);
                        int i15 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i15)));
                        columnIndexOrThrow14 = i15;
                        int i16 = columnIndexOrThrow15;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                        columnIndexOrThrow15 = i16;
                        i2 = i14;
                        int i17 = columnIndexOrThrow16;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17);
                        int i18 = columnIndexOrThrow18;
                        String text10 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                        int i19 = columnIndexOrThrow19;
                        int i20 = (int) sQLiteStatementPrepare.getLong(i19);
                        int i21 = columnIndexOrThrow7;
                        int i22 = columnIndexOrThrow20;
                        int i23 = columnIndexOrThrow6;
                        boolean z4 = ((int) sQLiteStatementPrepare.getLong(i22)) != 0;
                        int i24 = columnIndexOrThrow21;
                        boolean z5 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                        columnIndexOrThrow21 = i24;
                        int i25 = columnIndexOrThrow22;
                        boolean z6 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                        int i26 = columnIndexOrThrow23;
                        boolean z7 = ((int) sQLiteStatementPrepare.getLong(i26)) != 0;
                        columnIndexOrThrow23 = i26;
                        int i27 = columnIndexOrThrow24;
                        columnIndexOrThrow25 = columnIndexOrThrow25;
                        columnIndexOrThrow26 = columnIndexOrThrow26;
                        int i28 = columnIndexOrThrow27;
                        SongEntity songEntity = new SongEntity(text4, text5, i8, text6, text7, text8, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text9, text10, i20, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i27)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i28)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow22 = i25;
                        columnIndexOrThrow6 = i23;
                        columnIndexOrThrow20 = i22;
                        columnIndexOrThrow27 = i28;
                        columnIndexOrThrow8 = i7;
                        columnIndexOrThrow2 = i11;
                        i5 = i10;
                        i4 = i12;
                        i3 = i13;
                        columnIndexOrThrow16 = i17;
                        columnIndexOrThrow18 = i18;
                        columnIndexOrThrow19 = i19;
                        columnIndexOrThrow24 = i27;
                        columnIndexOrThrow7 = i21;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 1:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE bookmarkedAt IS NOT NULL ORDER BY lastUpdateTime");
                try {
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "browseId");
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "createdAt");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lastUpdateTime");
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isEditable");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "bookmarkedAt");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "remoteSongCount");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playEndpointParams");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "shuffleEndpointParams");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "radioEndpointParams");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isAutoSync");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "songCount");
                    int i29 = columnIndexOrThrow39;
                    int i30 = columnIndexOrThrow38;
                    ArrayMap arrayMap5 = new ArrayMap(0);
                    while (sQLiteStatementPrepare2.step()) {
                        String text11 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        if (!arrayMap5.containsKey(text11)) {
                            arrayMap5.put(text11, new ArrayList());
                            columnIndexOrThrow37 = columnIndexOrThrow37;
                        }
                    }
                    int i31 = columnIndexOrThrow37;
                    sQLiteStatementPrepare2.reset();
                    databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection2, arrayMap5);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        ArrayMap arrayMap6 = arrayMap5;
                        int i32 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow42);
                        String text12 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        String text13 = sQLiteStatementPrepare2.getText(columnIndexOrThrow29);
                        String text14 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow30);
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow31) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow31)));
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow32) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow32)));
                        boolean z8 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow33)) != 0;
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow34) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow34)));
                        Integer numValueOf2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow35) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow35));
                        String text15 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow36);
                        int i33 = i31;
                        String text16 = sQLiteStatementPrepare2.isNull(i33) ? null : sQLiteStatementPrepare2.getText(i33);
                        int i34 = i30;
                        if (sQLiteStatementPrepare2.isNull(i34)) {
                            i = i29;
                            text = null;
                        } else {
                            i = i29;
                            text = sQLiteStatementPrepare2.getText(i34);
                        }
                        String text17 = sQLiteStatementPrepare2.isNull(i) ? null : sQLiteStatementPrepare2.getText(i);
                        int i35 = columnIndexOrThrow40;
                        int i36 = columnIndexOrThrow30;
                        int i37 = columnIndexOrThrow41;
                        int i38 = columnIndexOrThrow32;
                        PlaylistEntity playlistEntity = new PlaylistEntity(text12, text13, text14, localDateTimeFromTimestamp6, localDateTimeFromTimestamp7, z8, localDateTimeFromTimestamp8, numValueOf2, text15, text16, text, text17, ((int) sQLiteStatementPrepare2.getLong(i35)) != 0, ((int) sQLiteStatementPrepare2.getLong(i37)) != 0);
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap6, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value3.getClass();
                        arrayList2.add(new Playlist(playlistEntity, i32, (List) value3));
                        columnIndexOrThrow32 = i38;
                        columnIndexOrThrow41 = i37;
                        columnIndexOrThrow42 = columnIndexOrThrow42;
                        i29 = i;
                        columnIndexOrThrow31 = columnIndexOrThrow31;
                        columnIndexOrThrow30 = i36;
                        i31 = i33;
                        i30 = i34;
                        columnIndexOrThrow40 = i35;
                        arrayMap5 = arrayMap6;
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 2:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda114(obj);
            case 3:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda115(obj);
            case 4:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda118(obj);
            case 5:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda123(obj);
            case 6:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda124(obj);
            case 7:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda125(obj);
            case 8:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda128(obj);
            case 9:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda129(obj);
            case 10:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda131(obj);
            case 11:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda132(obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda133(obj);
            case 13:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda134(obj);
            case 14:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda135(obj);
            case 15:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda136(obj);
            case 16:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda140(obj);
            case 17:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda142(obj);
            case 18:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda148(obj);
            case 19:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda152(obj);
            case 20:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda157(obj);
            case 21:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda158(obj);
            case 22:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda161(obj);
            case 23:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda162(obj);
            case 24:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda163(obj);
            case 25:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda167(obj);
            case 26:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda170(obj);
            case 27:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda171(obj);
            case 28:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda172(obj);
            default:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM song WHERE isEpisode = 1 AND inLibrary IS NOT NULL ORDER BY totalPlayTime");
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
                    int i39 = columnIndexOrThrow55;
                    ArrayMap arrayMap7 = new ArrayMap(0);
                    int i40 = columnIndexOrThrow54;
                    ArrayMap arrayMap8 = new ArrayMap(0);
                    int i41 = columnIndexOrThrow53;
                    ArrayMap arrayMap9 = new ArrayMap(0);
                    int i42 = columnIndexOrThrow52;
                    ArrayMap arrayMap10 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        String text18 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        if (!arrayMap7.containsKey(text18)) {
                            arrayMap7.put(text18, new ArrayList());
                        }
                        String text19 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        if (!arrayMap8.containsKey(text19)) {
                            arrayMap8.put(text19, new ArrayList());
                        }
                        arrayMap9.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow43), null);
                        arrayMap10.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow43), null);
                        columnIndexOrThrow51 = columnIndexOrThrow51;
                    }
                    int i43 = columnIndexOrThrow51;
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection3, arrayMap7);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection3, arrayMap8);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection3, arrayMap9);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection3, arrayMap10);
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        String text20 = sQLiteStatementPrepare3.getText(columnIndexOrThrow43);
                        String text21 = sQLiteStatementPrepare3.getText(columnIndexOrThrow44);
                        ArrayList arrayList4 = arrayList3;
                        int i44 = columnIndexOrThrow44;
                        int i45 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow45);
                        String text22 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow46);
                        String text23 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow47);
                        String text24 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow48);
                        boolean z9 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow49)) != 0;
                        Integer numValueOf3 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow50) ? null : Integer.valueOf((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow50));
                        int i46 = i43;
                        LocalDateTime localDateTimeFromTimestamp9 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i46) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i46)));
                        int i47 = i42;
                        LocalDateTime localDateTimeFromTimestamp10 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i47) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i47)));
                        i43 = i46;
                        i42 = i47;
                        int i48 = i41;
                        boolean z10 = ((int) sQLiteStatementPrepare3.getLong(i48)) != 0;
                        int i49 = i40;
                        LocalDateTime localDateTimeFromTimestamp11 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i49) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i49)));
                        int i50 = i39;
                        long j2 = sQLiteStatementPrepare3.getLong(i50);
                        i40 = i49;
                        int i51 = columnIndexOrThrow56;
                        LocalDateTime localDateTimeFromTimestamp12 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i51) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i51)));
                        columnIndexOrThrow56 = i51;
                        int i52 = columnIndexOrThrow57;
                        LocalDateTime localDateTimeFromTimestamp13 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i52) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i52)));
                        columnIndexOrThrow57 = i52;
                        i41 = i48;
                        int i53 = columnIndexOrThrow58;
                        int i54 = columnIndexOrThrow50;
                        boolean z11 = ((int) sQLiteStatementPrepare3.getLong(i53)) != 0;
                        columnIndexOrThrow59 = columnIndexOrThrow59;
                        String text25 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow59) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow59);
                        int i55 = columnIndexOrThrow60;
                        String text26 = sQLiteStatementPrepare3.isNull(i55) ? null : sQLiteStatementPrepare3.getText(i55);
                        int i56 = columnIndexOrThrow61;
                        int i57 = (int) sQLiteStatementPrepare3.getLong(i56);
                        i39 = i50;
                        int i58 = columnIndexOrThrow62;
                        boolean z12 = ((int) sQLiteStatementPrepare3.getLong(i58)) != 0;
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
                        SongEntity songEntity2 = new SongEntity(text20, text21, i45, text22, text23, text24, z9, numValueOf3, localDateTimeFromTimestamp9, localDateTimeFromTimestamp10, z10, localDateTimeFromTimestamp11, j2, localDateTimeFromTimestamp12, localDateTimeFromTimestamp13, z11, text25, text26, i57, z12, z13, z14, z15, ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow66)) != 0, sQLiteStatementPrepare3.isNull(columnIndexOrThrow67) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow67)), sQLiteStatementPrepare3.isNull(i62) ? null : sQLiteStatementPrepare3.getText(i62), ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow69)) != 0);
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap7, sQLiteStatementPrepare3.getText(columnIndexOrThrow43));
                        value4.getClass();
                        List list2 = (List) value4;
                        Object value5 = MapsKt__MapsKt.getValue(arrayMap8, sQLiteStatementPrepare3.getText(columnIndexOrThrow43));
                        value5.getClass();
                        arrayList4.add(new Song(songEntity2, list2, (List) value5, (AlbumEntity) arrayMap9.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow43)), (FormatEntity) arrayMap10.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow43))));
                        columnIndexOrThrow69 = columnIndexOrThrow69;
                        arrayList3 = arrayList4;
                        columnIndexOrThrow50 = i54;
                        columnIndexOrThrow58 = i53;
                        columnIndexOrThrow60 = i55;
                        columnIndexOrThrow61 = i56;
                        columnIndexOrThrow62 = i58;
                        columnIndexOrThrow68 = i62;
                        columnIndexOrThrow44 = i44;
                        break;
                    }
                    return arrayList3;
                } finally {
                    sQLiteStatementPrepare3.close();
                }
        }
    }
}
