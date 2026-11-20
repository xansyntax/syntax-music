package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.MultiLaneCacheWindow;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import io.ktor.http.LinkHeader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda88 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda88(MultiLaneCacheWindow multiLaneCacheWindow, CacheWindowScope cacheWindowScope, int i, int i2) {
        this.$r8$classId = (byte) 3;
        this.f$1 = multiLaneCacheWindow;
        this.f$4 = cacheWindowScope;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        int i = this.f$3;
        int i2 = this.f$2;
        Object obj2 = this.f$4;
        Object obj3 = this.f$1;
        switch (b) {
            case 0:
                String str = (String) obj3;
                DatabaseDao_Impl databaseDao_Impl = (DatabaseDao_Impl) obj2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT song.* FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = ? AND inLibrary IS NOT NULL ORDER BY inLibrary, song.rowId LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare.bindText(1, str);
                    sQLiteStatementPrepare.bindLong(2, i2);
                    sQLiteStatementPrepare.bindLong(3, i);
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
                    int i3 = columnIndexOrThrow13;
                    ArrayMap arrayMap = new ArrayMap(0);
                    int i4 = columnIndexOrThrow12;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    int i5 = columnIndexOrThrow11;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i6 = columnIndexOrThrow10;
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
                    int i7 = columnIndexOrThrow9;
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
                        int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8));
                        int i9 = i7;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9)));
                        int i10 = i6;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i10)));
                        int i11 = columnIndexOrThrow2;
                        int i12 = i5;
                        int i13 = columnIndexOrThrow8;
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(i12)) != 0;
                        int i14 = i4;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                        int i15 = i3;
                        long j = sQLiteStatementPrepare.getLong(i15);
                        int i16 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                        columnIndexOrThrow14 = i16;
                        int i17 = columnIndexOrThrow15;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i17) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i17)));
                        columnIndexOrThrow15 = i17;
                        i3 = i15;
                        int i18 = columnIndexOrThrow16;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i18)) != 0;
                        int i19 = columnIndexOrThrow17;
                        String text8 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                        int i20 = columnIndexOrThrow18;
                        String text9 = sQLiteStatementPrepare.isNull(i20) ? null : sQLiteStatementPrepare.getText(i20);
                        int i21 = columnIndexOrThrow19;
                        int i22 = (int) sQLiteStatementPrepare.getLong(i21);
                        int i23 = columnIndexOrThrow20;
                        int i24 = columnIndexOrThrow3;
                        boolean z4 = ((int) sQLiteStatementPrepare.getLong(i23)) != 0;
                        int i25 = columnIndexOrThrow21;
                        boolean z5 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                        columnIndexOrThrow21 = i25;
                        int i26 = columnIndexOrThrow22;
                        boolean z6 = ((int) sQLiteStatementPrepare.getLong(i26)) != 0;
                        columnIndexOrThrow22 = i26;
                        int i27 = columnIndexOrThrow23;
                        boolean z7 = ((int) sQLiteStatementPrepare.getLong(i27)) != 0;
                        columnIndexOrThrow23 = i27;
                        columnIndexOrThrow24 = columnIndexOrThrow24;
                        columnIndexOrThrow25 = columnIndexOrThrow25;
                        int i28 = columnIndexOrThrow26;
                        SongEntity songEntity = new SongEntity(text3, text4, i8, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i22, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow24)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(i28) ? null : sQLiteStatementPrepare.getText(i28), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow27)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow26 = i28;
                        columnIndexOrThrow3 = i24;
                        columnIndexOrThrow20 = i23;
                        columnIndexOrThrow27 = columnIndexOrThrow27;
                        columnIndexOrThrow2 = i11;
                        i6 = i10;
                        arrayMap = arrayMap5;
                        columnIndexOrThrow8 = i13;
                        i5 = i12;
                        i4 = i14;
                        columnIndexOrThrow16 = i18;
                        columnIndexOrThrow17 = i19;
                        columnIndexOrThrow18 = i20;
                        columnIndexOrThrow19 = i21;
                        i7 = i9;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 1:
                String str2 = (String) obj3;
                DatabaseDao_Impl databaseDao_Impl2 = (DatabaseDao_Impl) obj2;
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT song.* FROM song JOIN song_album_map ON song.id = song_album_map.songId WHERE song_album_map.albumId = ? ORDER BY song_album_map.`index`, song.rowId LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare2.bindText(1, str2);
                    sQLiteStatementPrepare2.bindLong(2, i2);
                    sQLiteStatementPrepare2.bindLong(3, i);
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
                    int i29 = columnIndexOrThrow41;
                    ArrayMap arrayMap6 = new ArrayMap(0);
                    int i30 = columnIndexOrThrow40;
                    ArrayMap arrayMap7 = new ArrayMap(0);
                    int i31 = columnIndexOrThrow39;
                    ArrayMap arrayMap8 = new ArrayMap(0);
                    int i32 = columnIndexOrThrow38;
                    ArrayMap arrayMap9 = new ArrayMap(0);
                    while (sQLiteStatementPrepare2.step()) {
                        String text10 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        if (!arrayMap6.containsKey(text10)) {
                            arrayMap6.put(text10, new ArrayList());
                        }
                        String text11 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        if (!arrayMap7.containsKey(text11)) {
                            arrayMap7.put(text11, new ArrayList());
                        }
                        arrayMap8.put(sQLiteStatementPrepare2.getText(columnIndexOrThrow28), null);
                        arrayMap9.put(sQLiteStatementPrepare2.getText(columnIndexOrThrow28), null);
                        columnIndexOrThrow37 = columnIndexOrThrow37;
                    }
                    int i33 = columnIndexOrThrow37;
                    sQLiteStatementPrepare2.reset();
                    databaseDao_Impl2.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection2, arrayMap6);
                    databaseDao_Impl2.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection2, arrayMap7);
                    databaseDao_Impl2.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection2, arrayMap8);
                    databaseDao_Impl2.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection2, arrayMap9);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        String text12 = sQLiteStatementPrepare2.getText(columnIndexOrThrow28);
                        String text13 = sQLiteStatementPrepare2.getText(columnIndexOrThrow29);
                        ArrayMap arrayMap10 = arrayMap9;
                        ArrayList arrayList3 = arrayList2;
                        int i34 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow30);
                        String text14 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow31);
                        String text15 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow32);
                        String text16 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow33);
                        int i35 = columnIndexOrThrow29;
                        int i36 = columnIndexOrThrow30;
                        boolean z8 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow34)) != 0;
                        Integer numValueOf2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow35) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow35));
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow36) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow36)));
                        int i37 = i33;
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i37) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i37)));
                        int i38 = i32;
                        boolean z9 = ((int) sQLiteStatementPrepare2.getLong(i38)) != 0;
                        int i39 = i31;
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i39) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i39)));
                        int i40 = i30;
                        long j2 = sQLiteStatementPrepare2.getLong(i40);
                        i33 = i37;
                        int i41 = i29;
                        LocalDateTime localDateTimeFromTimestamp9 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i41) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i41)));
                        i29 = i41;
                        int i42 = columnIndexOrThrow42;
                        LocalDateTime localDateTimeFromTimestamp10 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i42) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i42)));
                        columnIndexOrThrow42 = i42;
                        i31 = i39;
                        i30 = i40;
                        columnIndexOrThrow43 = columnIndexOrThrow43;
                        boolean z10 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow43)) != 0;
                        columnIndexOrThrow44 = columnIndexOrThrow44;
                        String text17 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow44);
                        columnIndexOrThrow45 = columnIndexOrThrow45;
                        String text18 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow45);
                        int i43 = columnIndexOrThrow46;
                        int i44 = (int) sQLiteStatementPrepare2.getLong(i43);
                        columnIndexOrThrow46 = i43;
                        i32 = i38;
                        int i45 = columnIndexOrThrow47;
                        boolean z11 = ((int) sQLiteStatementPrepare2.getLong(i45)) != 0;
                        columnIndexOrThrow47 = i45;
                        int i46 = columnIndexOrThrow48;
                        boolean z12 = ((int) sQLiteStatementPrepare2.getLong(i46)) != 0;
                        int i47 = columnIndexOrThrow49;
                        boolean z13 = ((int) sQLiteStatementPrepare2.getLong(i47)) != 0;
                        columnIndexOrThrow48 = i46;
                        columnIndexOrThrow49 = i47;
                        int i48 = columnIndexOrThrow50;
                        boolean z14 = ((int) sQLiteStatementPrepare2.getLong(i48)) != 0;
                        columnIndexOrThrow50 = i48;
                        int i49 = columnIndexOrThrow51;
                        int i50 = columnIndexOrThrow52;
                        int i51 = columnIndexOrThrow53;
                        columnIndexOrThrow51 = i49;
                        columnIndexOrThrow52 = i50;
                        int i52 = columnIndexOrThrow54;
                        SongEntity songEntity2 = new SongEntity(text12, text13, i34, text14, text15, text16, z8, numValueOf2, localDateTimeFromTimestamp6, localDateTimeFromTimestamp7, z9, localDateTimeFromTimestamp8, j2, localDateTimeFromTimestamp9, localDateTimeFromTimestamp10, z10, text17, text18, i44, z11, z12, z13, z14, ((int) sQLiteStatementPrepare2.getLong(i49)) != 0, sQLiteStatementPrepare2.isNull(i50) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i50)), sQLiteStatementPrepare2.isNull(i51) ? null : sQLiteStatementPrepare2.getText(i51), ((int) sQLiteStatementPrepare2.getLong(i52)) != 0);
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap6, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value3.getClass();
                        List list2 = (List) value3;
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap7, sQLiteStatementPrepare2.getText(columnIndexOrThrow28));
                        value4.getClass();
                        Song song = new Song(songEntity2, list2, (List) value4, (AlbumEntity) arrayMap8.get(sQLiteStatementPrepare2.getText(columnIndexOrThrow28)), (FormatEntity) arrayMap10.get(sQLiteStatementPrepare2.getText(columnIndexOrThrow28)));
                        int i53 = columnIndexOrThrow28;
                        arrayList3.add(song);
                        columnIndexOrThrow53 = i51;
                        columnIndexOrThrow54 = i52;
                        columnIndexOrThrow29 = i35;
                        arrayList2 = arrayList3;
                        arrayMap9 = arrayMap10;
                        columnIndexOrThrow30 = i36;
                        columnIndexOrThrow28 = i53;
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 2:
                String str3 = (String) obj3;
                DatabaseDao_Impl databaseDao_Impl3 = (DatabaseDao_Impl) obj2;
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM playlist_song_map WHERE playlistId = ? ORDER BY position, id LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare3.bindText(1, str3);
                    sQLiteStatementPrepare3.bindLong(2, i2);
                    sQLiteStatementPrepare3.bindLong(3, i);
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "id");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "playlistId");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "songId");
                    int columnIndexOrThrow58 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "position");
                    int columnIndexOrThrow59 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "setVideoId");
                    ArrayMap arrayMap11 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        arrayMap11.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow57), null);
                    }
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl3.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong(sQLiteConnection3, arrayMap11);
                    ArrayList arrayList4 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        PlaylistSongMap playlistSongMap = new PlaylistSongMap((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow55), sQLiteStatementPrepare3.getText(columnIndexOrThrow56), sQLiteStatementPrepare3.getText(columnIndexOrThrow57), (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow58), sQLiteStatementPrepare3.isNull(columnIndexOrThrow59) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow59));
                        Song song2 = (Song) arrayMap11.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow57));
                        if (song2 == null) {
                            throw new IllegalStateException("Relationship item 'song' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'songId' and entityColumn named 'id'.");
                        }
                        arrayList4.add(new PlaylistSong(playlistSongMap, song2));
                    }
                    sQLiteStatementPrepare3.close();
                    return arrayList4;
                } catch (Throwable th) {
                    sQLiteStatementPrepare3.close();
                    throw th;
                }
            default:
                ((MultiLaneCacheWindow) obj3).onItemPrefetched((CacheWindowScope) obj2, i2, i, ((Integer) obj).intValue());
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda88(String str, int i, int i2, DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = str;
        this.f$2 = i;
        this.f$3 = i2;
        this.f$4 = databaseDao_Impl;
    }
}
