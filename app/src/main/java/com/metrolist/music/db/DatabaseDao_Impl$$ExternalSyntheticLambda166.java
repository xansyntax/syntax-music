package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import io.ktor.http.LinkHeader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda166 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ DatabaseDao_Impl f$2;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda166(long j, DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = j;
        this.f$2 = databaseDao_Impl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        DatabaseDao_Impl databaseDao_Impl = this.f$2;
        long j = this.f$1;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT song.*\n        FROM (SELECT *, COUNT(1) AS referredCount\n              FROM related_song_map\n              GROUP BY relatedSongId) map\n                 JOIN song ON song.id = map.relatedSongId\n        WHERE songId IN (SELECT songId\n                         FROM (SELECT songId\n                               FROM event\n                               ORDER BY ROWID DESC\n                               LIMIT 5)\n                         UNION\n                         SELECT songId\n                         FROM (SELECT songId\n                               FROM event\n                               WHERE timestamp > ? - 86400000 * 7\n                               GROUP BY songId\n                               ORDER BY SUM(playTime) DESC\n                               LIMIT 5)\n                         UNION\n                         SELECT id\n                         FROM (SELECT id\n                               FROM song\n                               ORDER BY totalPlayTime DESC\n                               LIMIT 10))\n        ORDER BY referredCount DESC\n        LIMIT 100\n    ");
                try {
                    sQLiteStatementPrepare.bindLong(1, j);
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
                        int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        int i7 = columnIndexOrThrow3;
                        int i8 = columnIndexOrThrow2;
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8));
                        int i9 = i5;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                        int i10 = i4;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i10)));
                        i5 = i9;
                        int i11 = columnIndexOrThrow5;
                        int i12 = i3;
                        int i13 = columnIndexOrThrow4;
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(i12)) != 0;
                        int i14 = i2;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                        int i15 = i;
                        long j2 = sQLiteStatementPrepare.getLong(i15);
                        int i16 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                        columnIndexOrThrow14 = i16;
                        int i17 = columnIndexOrThrow15;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i17) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i17)));
                        columnIndexOrThrow15 = i17;
                        i = i15;
                        int i18 = columnIndexOrThrow16;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                        int i19 = columnIndexOrThrow17;
                        String text8 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                        int i20 = columnIndexOrThrow18;
                        String text9 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                        int i21 = columnIndexOrThrow19;
                        int i22 = (int) sQLiteStatementPrepare.getLong(i21);
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
                        SongEntity songEntity = new SongEntity(text3, text4, i6, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j2, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i22, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(i27) ? null : sQLiteStatementPrepare.getText(i27), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow27 = columnIndexOrThrow27;
                        columnIndexOrThrow4 = i13;
                        columnIndexOrThrow5 = i11;
                        columnIndexOrThrow3 = i7;
                        i3 = i12;
                        i4 = i10;
                        columnIndexOrThrow20 = i23;
                        columnIndexOrThrow26 = i27;
                        columnIndexOrThrow2 = i8;
                        i2 = i14;
                        columnIndexOrThrow16 = i18;
                        columnIndexOrThrow17 = i19;
                        columnIndexOrThrow18 = i20;
                        columnIndexOrThrow19 = i21;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            default:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("\n        SELECT song.*\n        FROM (SELECT n.songId      AS eid,\n                     SUM(playTime) AS oldPlayTime,\n                     newPlayTime\n              FROM event\n                       JOIN\n                   (SELECT songId, SUM(playTime) AS newPlayTime\n                    FROM event\n                    WHERE timestamp > (? - 86400000 * 30 * 1)\n                    GROUP BY songId\n                    ORDER BY newPlayTime) as n\n                   ON event.songId = n.songId\n              WHERE timestamp < (? - 86400000 * 30 * 1)\n              GROUP BY n.songId\n              ORDER BY oldPlayTime) AS t\n                 JOIN song on song.id = t.eid\n        WHERE 0.2 * t.oldPlayTime > t.newPlayTime\n        LIMIT 100\n    ");
                try {
                    sQLiteStatementPrepare2.bindLong(1, j);
                    sQLiteStatementPrepare2.bindLong(2, j);
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "duration");
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "albumId");
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "albumName");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "explicit");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "year");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "date");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "dateModified");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "liked");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "likedDate");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "totalPlayTime");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "inLibrary");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "dateDownload");
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "libraryAddToken");
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "libraryRemoveToken");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lyricsOffset");
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "romanizeLyrics");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isDownloaded");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isUploaded");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isVideo");
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isEpisode");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playbackPosition");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "uploadEntityId");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isCached");
                    int i28 = columnIndexOrThrow41;
                    ArrayMap arrayMap5 = new ArrayMap(0);
                    int i29 = columnIndexOrThrow40;
                    ArrayMap arrayMap6 = new ArrayMap(0);
                    int i30 = columnIndexOrThrow39;
                    ArrayMap arrayMap7 = new ArrayMap(0);
                    int i31 = columnIndexOrThrow38;
                    ArrayMap arrayMap8 = new ArrayMap(0);
                    while (sQLiteStatementPrepare2.step()) {
                        String text10 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        if (!arrayMap5.containsKey(text10)) {
                            arrayMap5.put(text10, new ArrayList());
                        }
                        String text11 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        if (!arrayMap6.containsKey(text11)) {
                            arrayMap6.put(text11, new ArrayList());
                        }
                        arrayMap7.put(sQLiteStatementPrepare2.getText(columnIndexOrThrow28), null);
                        arrayMap8.put(sQLiteStatementPrepare2.getText(columnIndexOrThrow28), null);
                        columnIndexOrThrow37 = columnIndexOrThrow37;
                    }
                    int i32 = columnIndexOrThrow37;
                    sQLiteStatementPrepare2.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection2, arrayMap5);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection2, arrayMap6);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection2, arrayMap7);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection2, arrayMap8);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        String text12 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        String text13 = sQLiteStatementPrepare2.getText(columnIndexOrThrow29);
                        ArrayMap arrayMap9 = arrayMap8;
                        ArrayList arrayList3 = arrayList2;
                        int i33 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow30);
                        String text14 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow31);
                        String text15 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow32);
                        String text16 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow33);
                        int i34 = columnIndexOrThrow30;
                        int i35 = columnIndexOrThrow29;
                        boolean z8 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow34)) != 0;
                        Integer numValueOf2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow35) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow35));
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow36) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow36)));
                        int i36 = i32;
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i36) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i36)));
                        int i37 = columnIndexOrThrow32;
                        int i38 = i31;
                        int i39 = columnIndexOrThrow31;
                        boolean z9 = ((int) sQLiteStatementPrepare2.getLong(i38)) != 0;
                        int i40 = i30;
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i40) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i40)));
                        int i41 = i29;
                        long j3 = sQLiteStatementPrepare2.getLong(i41);
                        int i42 = i28;
                        LocalDateTime localDateTimeFromTimestamp9 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i42) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i42)));
                        int i43 = columnIndexOrThrow42;
                        LocalDateTime localDateTimeFromTimestamp10 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i43) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i43)));
                        columnIndexOrThrow42 = i43;
                        i30 = i40;
                        int i44 = columnIndexOrThrow43;
                        boolean z10 = ((int) sQLiteStatementPrepare2.getLong(i44)) != 0;
                        int i45 = columnIndexOrThrow44;
                        String text17 = sQLiteStatementPrepare2.isNull(i45) ? null : sQLiteStatementPrepare2.getText(i45);
                        int i46 = columnIndexOrThrow45;
                        String text18 = sQLiteStatementPrepare2.isNull(i46) ? null : sQLiteStatementPrepare2.getText(i46);
                        int i47 = columnIndexOrThrow46;
                        int i48 = (int) sQLiteStatementPrepare2.getLong(i47);
                        int i49 = columnIndexOrThrow47;
                        boolean z11 = ((int) sQLiteStatementPrepare2.getLong(i49)) != 0;
                        int i50 = columnIndexOrThrow48;
                        boolean z12 = ((int) sQLiteStatementPrepare2.getLong(i50)) != 0;
                        i29 = i41;
                        int i51 = columnIndexOrThrow49;
                        boolean z13 = ((int) sQLiteStatementPrepare2.getLong(i51)) != 0;
                        columnIndexOrThrow49 = i51;
                        int i52 = columnIndexOrThrow50;
                        boolean z14 = ((int) sQLiteStatementPrepare2.getLong(i52)) != 0;
                        columnIndexOrThrow50 = i52;
                        columnIndexOrThrow51 = columnIndexOrThrow51;
                        boolean z15 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow51)) != 0;
                        columnIndexOrThrow52 = columnIndexOrThrow52;
                        columnIndexOrThrow53 = columnIndexOrThrow53;
                        int i53 = columnIndexOrThrow54;
                        SongEntity songEntity2 = new SongEntity(text12, text13, i33, text14, text15, text16, z8, numValueOf2, localDateTimeFromTimestamp6, localDateTimeFromTimestamp7, z9, localDateTimeFromTimestamp8, j3, localDateTimeFromTimestamp9, localDateTimeFromTimestamp10, z10, text17, text18, i48, z11, z12, z13, z14, z15, sQLiteStatementPrepare2.isNull(columnIndexOrThrow52) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow52)), sQLiteStatementPrepare2.isNull(columnIndexOrThrow53) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow53), ((int) sQLiteStatementPrepare2.getLong(i53)) != 0);
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value3.getClass();
                        List list2 = (List) value3;
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap6, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value4.getClass();
                        arrayList3.add(new Song(songEntity2, list2, (List) value4, (AlbumEntity) arrayMap7.get(sQLiteStatementPrepare2.getText(columnIndexOrThrow28)), (FormatEntity) arrayMap9.get(sQLiteStatementPrepare2.getText(columnIndexOrThrow28))));
                        columnIndexOrThrow54 = i53;
                        arrayMap8 = arrayMap9;
                        columnIndexOrThrow29 = i35;
                        columnIndexOrThrow31 = i39;
                        columnIndexOrThrow30 = i34;
                        i31 = i38;
                        columnIndexOrThrow43 = i44;
                        columnIndexOrThrow44 = i45;
                        columnIndexOrThrow45 = i46;
                        columnIndexOrThrow46 = i47;
                        columnIndexOrThrow47 = i49;
                        columnIndexOrThrow48 = i50;
                        columnIndexOrThrow32 = i37;
                        i32 = i36;
                        i28 = i42;
                        arrayList2 = arrayList3;
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
        }
    }
}
