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
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda69 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ DatabaseDao_Impl f$3;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda69(int i, int i2, DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$1 = i;
        this.f$2 = i2;
        this.f$3 = databaseDao_Impl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda154(Object obj) throws Exception {
        int i = this.f$1;
        int i2 = this.f$2;
        DatabaseDao_Impl databaseDao_Impl = this.f$3;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song WHERE liked ORDER BY likedDate DESC, rowId DESC LIMIT ? OFFSET ?");
        try {
            sQLiteStatementPrepare.bindLong(1, i);
            sQLiteStatementPrepare.bindLong(2, i2);
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
            int i3 = columnIndexOrThrow12;
            ArrayMap arrayMap = new ArrayMap(0);
            int i4 = columnIndexOrThrow11;
            ArrayMap arrayMap2 = new ArrayMap(0);
            int i5 = columnIndexOrThrow10;
            ArrayMap arrayMap3 = new ArrayMap(0);
            int i6 = columnIndexOrThrow9;
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
            int i7 = columnIndexOrThrow8;
            String str = null;
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
                int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? str : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? str : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? str : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                int i9 = i7;
                Integer numValueOf = sQLiteStatementPrepare.isNull(i9) ? str : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i9));
                int i10 = i6;
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? str : Long.valueOf(sQLiteStatementPrepare.getLong(i10)));
                int i11 = i5;
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? str : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                i6 = i10;
                int i12 = i4;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(i12)) != 0;
                int i13 = i3;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                int i14 = columnIndexOrThrow13;
                long j = sQLiteStatementPrepare.getLong(i14);
                int i15 = columnIndexOrThrow14;
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i15) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i15)));
                columnIndexOrThrow14 = i15;
                int i16 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                columnIndexOrThrow15 = i16;
                i3 = i13;
                int i17 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                int i18 = columnIndexOrThrow17;
                String text8 = sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18);
                int i19 = columnIndexOrThrow18;
                String text9 = sQLiteStatementPrepare.isNull(i19) ? null : sQLiteStatementPrepare.getText(i19);
                int i20 = columnIndexOrThrow19;
                int i21 = (int) sQLiteStatementPrepare.getLong(i20);
                int i22 = columnIndexOrThrow20;
                int i23 = columnIndexOrThrow5;
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
                SongEntity songEntity = new SongEntity(text3, text4, i8, text5, text6, text7, z, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text8, text9, i21, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i27)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), ((int) sQLiteStatementPrepare.getLong(i28)) != 0);
                Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value.getClass();
                List list = (List) value;
                Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                value2.getClass();
                arrayList.add(new Song(songEntity, list, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow22 = i25;
                columnIndexOrThrow5 = i23;
                columnIndexOrThrow20 = i22;
                columnIndexOrThrow27 = i28;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow13 = i14;
                columnIndexOrThrow16 = i17;
                columnIndexOrThrow17 = i18;
                columnIndexOrThrow18 = i19;
                columnIndexOrThrow19 = i20;
                i5 = i11;
                arrayMap4 = arrayMap5;
                columnIndexOrThrow24 = i27;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i7 = i9;
                i4 = i12;
                str = null;
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
        int i2 = this.f$1;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM album WHERE EXISTS(SELECT * FROM song WHERE song.albumId = album.id AND song.inLibrary IS NOT NULL) ORDER BY rowId LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, i2);
                    sQLiteStatementPrepare.bindLong(2, i);
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
                    int i3 = columnIndexOrThrow13;
                    ArrayMap arrayMap = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap.containsKey(text)) {
                            arrayMap.put(text, new ArrayList());
                            columnIndexOrThrow12 = columnIndexOrThrow12;
                        }
                    }
                    int i4 = columnIndexOrThrow12;
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
                        int i5 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                        int i6 = columnIndexOrThrow2;
                        int i7 = columnIndexOrThrow3;
                        int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                        boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow11)));
                        int i9 = i4;
                        int i10 = i3;
                        int i11 = columnIndexOrThrow7;
                        int i12 = columnIndexOrThrow11;
                        int i13 = columnIndexOrThrow14;
                        int i14 = columnIndexOrThrow10;
                        int i15 = columnIndexOrThrow15;
                        AlbumEntity albumEntity = new AlbumEntity(text2, text3, text4, numValueOf, text5, numValueOf2, i5, i8, z, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i9))), Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i10))), ((int) sQLiteStatementPrepare.getLong(i13)) != 0, ((int) sQLiteStatementPrepare.getLong(i15)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        arrayList.add(new Album(albumEntity, (List) value, null, null));
                        columnIndexOrThrow10 = i14;
                        columnIndexOrThrow15 = i15;
                        columnIndexOrThrow2 = i6;
                        columnIndexOrThrow7 = i11;
                        columnIndexOrThrow11 = i12;
                        columnIndexOrThrow14 = i13;
                        i4 = i9;
                        i3 = i10;
                        columnIndexOrThrow3 = i7;
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            case 1:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT *, (SELECT COUNT(*) FROM playlist_song_map WHERE playlistId = playlist.id) AS songCount FROM playlist WHERE bookmarkedAt IS NOT NULL ORDER BY rowId LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare2.bindLong(1, i2);
                    sQLiteStatementPrepare2.bindLong(2, i);
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "browseId");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "createdAt");
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lastUpdateTime");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isEditable");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "bookmarkedAt");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "remoteSongCount");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playEndpointParams");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "shuffleEndpointParams");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "radioEndpointParams");
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isAutoSync");
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "songCount");
                    int i16 = columnIndexOrThrow27;
                    int i17 = columnIndexOrThrow26;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    while (sQLiteStatementPrepare2.step()) {
                        String text6 = sQLiteStatementPrepare2.getText(columnIndexOrThrow16);
                        if (!arrayMap2.containsKey(text6)) {
                            arrayMap2.put(text6, new ArrayList());
                            columnIndexOrThrow25 = columnIndexOrThrow25;
                        }
                    }
                    int i18 = columnIndexOrThrow25;
                    sQLiteStatementPrepare2.reset();
                    databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection2, arrayMap2);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        int i19 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow30);
                        String text7 = sQLiteStatementPrepare2.getText(columnIndexOrThrow16);
                        String text8 = sQLiteStatementPrepare2.getText(columnIndexOrThrow17);
                        String text9 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow18);
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow19) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow19)));
                        int i20 = columnIndexOrThrow18;
                        int i21 = columnIndexOrThrow19;
                        int i22 = i18;
                        int i23 = i17;
                        int i24 = i16;
                        int i25 = columnIndexOrThrow29;
                        int i26 = columnIndexOrThrow20;
                        PlaylistEntity playlistEntity = new PlaylistEntity(text7, text8, text9, localDateTimeFromTimestamp3, Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow20) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow20))), ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow21)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow22) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow22))), sQLiteStatementPrepare2.isNull(columnIndexOrThrow23) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow23)), sQLiteStatementPrepare2.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow24), sQLiteStatementPrepare2.isNull(i22) ? null : sQLiteStatementPrepare2.getText(i22), sQLiteStatementPrepare2.isNull(i23) ? null : sQLiteStatementPrepare2.getText(i23), sQLiteStatementPrepare2.isNull(i24) ? null : sQLiteStatementPrepare2.getText(i24), ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow28)) != 0, ((int) sQLiteStatementPrepare2.getLong(i25)) != 0);
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare2.getText(columnIndexOrThrow16));
                        value2.getClass();
                        int i27 = columnIndexOrThrow30;
                        arrayList2.add(new Playlist(playlistEntity, i19, (List) value2));
                        columnIndexOrThrow20 = i26;
                        columnIndexOrThrow29 = i25;
                        i18 = i22;
                        columnIndexOrThrow22 = columnIndexOrThrow22;
                        columnIndexOrThrow30 = i27;
                        columnIndexOrThrow18 = i20;
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        i17 = i23;
                        i16 = i24;
                        columnIndexOrThrow28 = columnIndexOrThrow28;
                        columnIndexOrThrow19 = i21;
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 2:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda154(obj);
            default:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM song WHERE inLibrary IS NOT NULL ORDER BY inLibrary, rowId LIMIT ? OFFSET ?");
                try {
                    sQLiteStatementPrepare3.bindLong(1, i2);
                    sQLiteStatementPrepare3.bindLong(2, i);
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "id");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "duration");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "thumbnailUrl");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "albumId");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "albumName");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "explicit");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "year");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "date");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "dateModified");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "liked");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "likedDate");
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "totalPlayTime");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "inLibrary");
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "dateDownload");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isLocal");
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "libraryAddToken");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "libraryRemoveToken");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "lyricsOffset");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "romanizeLyrics");
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isDownloaded");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isUploaded");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isVideo");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isEpisode");
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "playbackPosition");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "uploadEntityId");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isCached");
                    int i28 = columnIndexOrThrow45;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i29 = columnIndexOrThrow43;
                    ArrayMap arrayMap4 = new ArrayMap(0);
                    int i30 = columnIndexOrThrow41;
                    ArrayMap arrayMap5 = new ArrayMap(0);
                    int i31 = columnIndexOrThrow39;
                    ArrayMap arrayMap6 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        String text10 = sQLiteStatementPrepare3.getText(columnIndexOrThrow31);
                        if (!arrayMap3.containsKey(text10)) {
                            arrayMap3.put(text10, new ArrayList());
                        }
                        String text11 = sQLiteStatementPrepare3.getText(columnIndexOrThrow31);
                        if (!arrayMap4.containsKey(text11)) {
                            arrayMap4.put(text11, new ArrayList());
                        }
                        arrayMap5.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow31), null);
                        arrayMap6.put(sQLiteStatementPrepare3.getText(columnIndexOrThrow31), null);
                        columnIndexOrThrow38 = columnIndexOrThrow38;
                    }
                    int i32 = columnIndexOrThrow38;
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection3, arrayMap3);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection3, arrayMap4);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection3, arrayMap5);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection3, arrayMap6);
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        String text12 = sQLiteStatementPrepare3.getText(columnIndexOrThrow31);
                        String text13 = sQLiteStatementPrepare3.getText(columnIndexOrThrow32);
                        ArrayMap arrayMap7 = arrayMap6;
                        ArrayMap arrayMap8 = arrayMap5;
                        int i33 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow33);
                        String text14 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow34);
                        String text15 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow35);
                        String text16 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow36);
                        boolean z2 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow37)) != 0;
                        int i34 = i32;
                        Integer numValueOf3 = sQLiteStatementPrepare3.isNull(i34) ? null : Integer.valueOf((int) sQLiteStatementPrepare3.getLong(i34));
                        int i35 = i31;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i35) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i35)));
                        int i36 = columnIndexOrThrow40;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i36) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i36)));
                        i31 = i35;
                        columnIndexOrThrow40 = i36;
                        int i37 = i30;
                        boolean z3 = ((int) sQLiteStatementPrepare3.getLong(i37)) != 0;
                        int i38 = columnIndexOrThrow42;
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i38) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i38)));
                        int i39 = i29;
                        long j = sQLiteStatementPrepare3.getLong(i39);
                        int i40 = columnIndexOrThrow32;
                        int i41 = columnIndexOrThrow44;
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i41) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i41)));
                        columnIndexOrThrow44 = i41;
                        int i42 = i28;
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i42) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i42)));
                        i28 = i42;
                        i29 = i39;
                        int i43 = columnIndexOrThrow46;
                        boolean z4 = ((int) sQLiteStatementPrepare3.getLong(i43)) != 0;
                        int i44 = columnIndexOrThrow47;
                        String text17 = sQLiteStatementPrepare3.isNull(i44) ? null : sQLiteStatementPrepare3.getText(i44);
                        int i45 = columnIndexOrThrow48;
                        String text18 = sQLiteStatementPrepare3.isNull(i45) ? null : sQLiteStatementPrepare3.getText(i45);
                        int i46 = columnIndexOrThrow49;
                        int i47 = (int) sQLiteStatementPrepare3.getLong(i46);
                        int i48 = columnIndexOrThrow50;
                        int i49 = columnIndexOrThrow37;
                        boolean z5 = ((int) sQLiteStatementPrepare3.getLong(i48)) != 0;
                        int i50 = columnIndexOrThrow51;
                        boolean z6 = ((int) sQLiteStatementPrepare3.getLong(i50)) != 0;
                        int i51 = columnIndexOrThrow52;
                        boolean z7 = ((int) sQLiteStatementPrepare3.getLong(i51)) != 0;
                        columnIndexOrThrow51 = i50;
                        int i52 = columnIndexOrThrow53;
                        boolean z8 = ((int) sQLiteStatementPrepare3.getLong(i52)) != 0;
                        columnIndexOrThrow53 = i52;
                        int i53 = columnIndexOrThrow54;
                        columnIndexOrThrow55 = columnIndexOrThrow55;
                        columnIndexOrThrow56 = columnIndexOrThrow56;
                        int i54 = columnIndexOrThrow57;
                        SongEntity songEntity = new SongEntity(text12, text13, i33, text14, text15, text16, z2, numValueOf3, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, localDateTimeFromTimestamp6, j, localDateTimeFromTimestamp7, localDateTimeFromTimestamp8, z4, text17, text18, i47, z5, z6, z7, z8, ((int) sQLiteStatementPrepare3.getLong(i53)) != 0, sQLiteStatementPrepare3.isNull(columnIndexOrThrow55) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow55)), sQLiteStatementPrepare3.isNull(columnIndexOrThrow56) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow56), ((int) sQLiteStatementPrepare3.getLong(i54)) != 0);
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap3, sQLiteStatementPrepare3.getText(columnIndexOrThrow31));
                        value3.getClass();
                        List list = (List) value3;
                        Object value4 = MapsKt__MapsKt.getValue(arrayMap4, sQLiteStatementPrepare3.getText(columnIndexOrThrow31));
                        value4.getClass();
                        arrayMap6 = arrayMap7;
                        arrayList3.add(new Song(songEntity, list, (List) value4, (AlbumEntity) arrayMap8.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow31)), (FormatEntity) arrayMap6.get(sQLiteStatementPrepare3.getText(columnIndexOrThrow31))));
                        columnIndexOrThrow57 = i54;
                        columnIndexOrThrow52 = i51;
                        i30 = i37;
                        columnIndexOrThrow37 = i49;
                        columnIndexOrThrow33 = columnIndexOrThrow33;
                        columnIndexOrThrow32 = i40;
                        columnIndexOrThrow50 = i48;
                        i32 = i34;
                        columnIndexOrThrow42 = i38;
                        columnIndexOrThrow46 = i43;
                        columnIndexOrThrow47 = i44;
                        columnIndexOrThrow48 = i45;
                        columnIndexOrThrow49 = i46;
                        arrayMap5 = arrayMap8;
                        columnIndexOrThrow54 = i53;
                        columnIndexOrThrow34 = columnIndexOrThrow34;
                        break;
                    }
                    return arrayList3;
                } finally {
                    sQLiteStatementPrepare3.close();
                }
        }
    }
}
