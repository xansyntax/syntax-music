package com.metrolist.music.db;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.betterlyrics.TTMLParser$ParsedLine;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.SongEntity;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.LinkHeader;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.time.LocalDateTime;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DatabaseDao$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda108(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE bookmarkedAt IS NOT NULL ORDER BY name");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda116(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT DISTINCT artist.*,\n               (SELECT COUNT(1)\n                FROM song_artist_map\n                         JOIN event ON song_artist_map.songId = event.songId\n                WHERE artistId = artist.id) AS songCount\n        FROM artist\n                 LEFT JOIN(SELECT artistId, SUM(songTotalPlayTime) AS totalPlayTime\n                      FROM song_artist_map\n                               JOIN (SELECT songId, SUM(playTime) AS songTotalPlayTime\n                                     FROM event\n                                     GROUP BY songId) AS e\n                                    ON song_artist_map.songId = e.songId\n                      GROUP BY artistId\n                      ORDER BY totalPlayTime DESC) AS artistTotalPlayTime\n                     ON artist.id = artistId\n                     OR artist.bookmarkedAt IS NOT NULL\n                     ORDER BY\n                      CASE\n                        WHEN artistTotalPlayTime.artistId IS NULL THEN 1\n                        ELSE 0\n                      END,\n                      artistTotalPlayTime.totalPlayTime DESC\n    ");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda137(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE bookmarkedAt IS NOT NULL ORDER BY songCount");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda147(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE bookmarkedAt IS NOT NULL ORDER BY bookmarkedAt");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda155(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE songCount > 0 ORDER BY songCount");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda156(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT artist.*,\n               (SELECT COUNT(1)\n                FROM song_artist_map\n                         JOIN song ON song_artist_map.songId = song.id\n                WHERE artistId = artist.id\n                  AND song.inLibrary IS NOT NULL) AS songCount\n        FROM artist\n                 JOIN(SELECT artistId, SUM(totalPlayTime) AS totalPlayTime\n                      FROM song_artist_map\n                               JOIN song\n                                    ON song_artist_map.songId = song.id\n                      GROUP BY artistId\n                      ORDER BY totalPlayTime)\n                     ON artist.id = artistId\n        WHERE bookmarkedAt IS NOT NULL\n    ");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda165(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE songCount > 0 ORDER BY rowId");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda176(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT artist.*,\n               (SELECT COUNT(1)\n                FROM song_artist_map\n                         JOIN song ON song_artist_map.songId = song.id\n                WHERE artistId = artist.id\n                  AND song.inLibrary IS NOT NULL) AS songCount\n        FROM artist\n                 JOIN(SELECT artistId, SUM(totalPlayTime) AS totalPlayTime\n                      FROM song_artist_map\n                               JOIN song\n                                    ON song_artist_map.songId = song.id\n                      GROUP BY artistId\n                      ORDER BY totalPlayTime)\n                     ON artist.id = artistId\n        WHERE songCount > 0\n    ");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda178(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount\n        FROM artist\n        WHERE artist.bookmarkedAt IS NOT NULL\n        AND artist.isPodcastChannel = 1\n        ORDER BY artist.name COLLATE NOCASE ASC\n    ");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda188(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE songCount > 0 ORDER BY name");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
            int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i2 = columnIndexOrThrow;
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                if (localDateTimeFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                int i3 = columnIndexOrThrow2;
                int i4 = columnIndexOrThrow3;
                int i5 = columnIndexOrThrow4;
                arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i, null));
                columnIndexOrThrow = i2;
                columnIndexOrThrow4 = i5;
                columnIndexOrThrow3 = i4;
                columnIndexOrThrow2 = i3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda34(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        UPDATE song\n        SET thumbnailUrl = REPLACE(thumbnailUrl, '/maxresdefault.jpg', '/hqdefault.jpg')\n        WHERE thumbnailUrl LIKE 'https://i.ytimg.com/%/maxresdefault.jpg%'\n        ");
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda5(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM recognition_history");
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda6(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM search_history");
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda64(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT browseId FROM playlist WHERE bookmarkedAt IS NOT NULL AND browseId IS NOT NULL");
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda66(Object obj) throws Exception {
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
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8));
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9)));
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)));
                int i3 = columnIndexOrThrow4;
                Integer num = numValueOf;
                boolean z2 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0;
                LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow12)));
                long j = sQLiteStatementPrepare.getLong(columnIndexOrThrow13);
                LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i)));
                int i4 = columnIndexOrThrow15;
                LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i4) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i4)));
                int i5 = columnIndexOrThrow;
                int i6 = columnIndexOrThrow16;
                boolean z3 = ((int) sQLiteStatementPrepare.getLong(i6)) != 0;
                int i7 = columnIndexOrThrow17;
                String text6 = sQLiteStatementPrepare.isNull(i7) ? null : sQLiteStatementPrepare.getText(i7);
                int i8 = columnIndexOrThrow18;
                String text7 = sQLiteStatementPrepare.isNull(i8) ? null : sQLiteStatementPrepare.getText(i8);
                int i9 = columnIndexOrThrow19;
                int i10 = (int) sQLiteStatementPrepare.getLong(i9);
                int i11 = columnIndexOrThrow20;
                int i12 = columnIndexOrThrow5;
                boolean z4 = ((int) sQLiteStatementPrepare.getLong(i11)) != 0;
                int i13 = columnIndexOrThrow21;
                boolean z5 = ((int) sQLiteStatementPrepare.getLong(i13)) != 0;
                columnIndexOrThrow21 = i13;
                int i14 = columnIndexOrThrow22;
                boolean z6 = ((int) sQLiteStatementPrepare.getLong(i14)) != 0;
                int i15 = columnIndexOrThrow23;
                boolean z7 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                columnIndexOrThrow23 = i15;
                int i16 = columnIndexOrThrow24;
                int i17 = columnIndexOrThrow25;
                int i18 = columnIndexOrThrow26;
                columnIndexOrThrow25 = i17;
                columnIndexOrThrow26 = i18;
                int i19 = columnIndexOrThrow27;
                arrayList2.add(new SongEntity(text, text2, i2, text3, text4, text5, z, num, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z2, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z3, text6, text7, i10, z4, z5, z6, z7, ((int) sQLiteStatementPrepare.getLong(i16)) != 0, sQLiteStatementPrepare.isNull(i17) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i17)), sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18), ((int) sQLiteStatementPrepare.getLong(i19)) != 0));
                columnIndexOrThrow22 = i14;
                columnIndexOrThrow5 = i12;
                columnIndexOrThrow20 = i11;
                columnIndexOrThrow14 = i;
                columnIndexOrThrow27 = i19;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                columnIndexOrThrow16 = i6;
                columnIndexOrThrow17 = i7;
                columnIndexOrThrow18 = i8;
                columnIndexOrThrow19 = i9;
                columnIndexOrThrow = i5;
                arrayList = arrayList2;
                columnIndexOrThrow24 = i16;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow15 = i4;
                columnIndexOrThrow4 = i3;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    private final Object invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda72(Object obj) throws Exception {
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM podcast WHERE bookmarkedAt IS NOT NULL ORDER BY bookmarkedAt DESC");
        try {
            int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
            int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "author");
            int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
            int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
            int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
            int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
            int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryAddToken");
            int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryRemoveToken");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow7)));
                if (localDateTimeFromTimestamp2 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                }
                arrayList.add(new PodcastEntity(text, text2, text3, text4, text5, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        int i;
        String text;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                SongEntity songEntity = (SongEntity) obj;
                songEntity.getClass();
                return songEntity;
            case 1:
                ContentNegotiationConfig contentNegotiationConfig = (ContentNegotiationConfig) obj;
                contentNegotiationConfig.getClass();
                JsonSupportKt.json$default(contentNegotiationConfig, UuidKt.Json$default(new DatabaseDao$$ExternalSyntheticLambda0((byte) 4)), null, 2, null);
                return unit;
            case 2:
                HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) obj;
                httpTimeoutConfig.getClass();
                httpTimeoutConfig.setRequestTimeoutMillis(15000L);
                httpTimeoutConfig.setConnectTimeoutMillis(10000L);
                httpTimeoutConfig.setSocketTimeoutMillis(15000L);
                return unit;
            case 3:
                DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = (DefaultRequest.DefaultRequestBuilder) obj;
                defaultRequestBuilder.getClass();
                defaultRequestBuilder.url("https://lyrics-api.boidu.dev");
                defaultRequestBuilder.headers(new DatabaseDao$$ExternalSyntheticLambda0((byte) 5));
                return unit;
            case 4:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.isLenient = true;
                jsonBuilder.ignoreUnknownKeys = true;
                return unit;
            case 5:
                HeadersBuilder headersBuilder = (HeadersBuilder) obj;
                headersBuilder.getClass();
                headersBuilder.append(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
                headersBuilder.append(HttpHeaders.Accept, "application/json");
                return unit;
            case 6:
                TTMLParser$ParsedLine tTMLParser$ParsedLine = (TTMLParser$ParsedLine) obj;
                tTMLParser$ParsedLine.getClass();
                return tTMLParser$ParsedLine.text;
            case 7:
                TTMLParser$ParsedLine tTMLParser$ParsedLine2 = (TTMLParser$ParsedLine) obj;
                tTMLParser$ParsedLine2.getClass();
                return tTMLParser$ParsedLine2.text;
            case 8:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM recognition_history ORDER BY recognizedAt DESC");
                try {
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "trackId");
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "artist");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "album");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "coverArtUrl");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "coverArtHqUrl");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "genre");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "releaseDate");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "label");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "shazamUrl");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "appleMusicUrl");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "spotifyUrl");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isrc");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "youtubeVideoId");
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "recognizedAt");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "liked");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        long j = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                        String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                        String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                        String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                        String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                        String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                        String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                        if (sQLiteStatementPrepare.isNull(columnIndexOrThrow13)) {
                            i = columnIndexOrThrow3;
                            text = null;
                        } else {
                            i = columnIndexOrThrow3;
                            text = sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                        }
                        String text13 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                        int i2 = columnIndexOrThrow14;
                        int i3 = columnIndexOrThrow15;
                        String text14 = sQLiteStatementPrepare.isNull(i3) ? null : sQLiteStatementPrepare.getText(i3);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow16)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        columnIndexOrThrow15 = i3;
                        int i4 = columnIndexOrThrow2;
                        int i5 = columnIndexOrThrow17;
                        int i6 = columnIndexOrThrow;
                        arrayList.add(new RecognitionHistory(j, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text, text13, text14, localDateTimeFromTimestamp, ((int) sQLiteStatementPrepare.getLong(i5)) != 0));
                        columnIndexOrThrow = i6;
                        columnIndexOrThrow2 = i4;
                        columnIndexOrThrow17 = i5;
                        columnIndexOrThrow3 = i;
                        columnIndexOrThrow14 = i2;
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            case 9:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT * FROM song WHERE isEpisode = 1 AND inLibrary IS NOT NULL ORDER BY inLibrary");
                try {
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "duration");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "albumId");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "albumName");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "explicit");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "year");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "date");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "dateModified");
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "liked");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "likedDate");
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "totalPlayTime");
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "inLibrary");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "dateDownload");
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "libraryAddToken");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "libraryRemoveToken");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lyricsOffset");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "romanizeLyrics");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isDownloaded");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isUploaded");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isVideo");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isEpisode");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playbackPosition");
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "uploadEntityId");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isCached");
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        String text15 = sQLiteStatementPrepare2.getText(columnIndexOrThrow18);
                        String text16 = sQLiteStatementPrepare2.getText(columnIndexOrThrow19);
                        int i7 = columnIndexOrThrow31;
                        int i8 = columnIndexOrThrow30;
                        int i9 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow20);
                        String text17 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow21);
                        String text18 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow22);
                        String text19 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow23);
                        int i10 = columnIndexOrThrow21;
                        int i11 = columnIndexOrThrow18;
                        boolean z = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow24)) != 0;
                        Integer numValueOf = sQLiteStatementPrepare2.isNull(columnIndexOrThrow25) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow25));
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow26) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow26)));
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow27) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow27)));
                        boolean z2 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow28)) != 0;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow29) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow29)));
                        long j2 = sQLiteStatementPrepare2.getLong(i8);
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i7) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i7)));
                        int i12 = columnIndexOrThrow19;
                        int i13 = columnIndexOrThrow32;
                        LocalDateTime localDateTimeFromTimestamp6 = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i13)));
                        columnIndexOrThrow32 = i13;
                        columnIndexOrThrow33 = columnIndexOrThrow33;
                        boolean z3 = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow33)) != 0;
                        columnIndexOrThrow34 = columnIndexOrThrow34;
                        String text20 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow34);
                        columnIndexOrThrow35 = columnIndexOrThrow35;
                        String text21 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow35);
                        int i14 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow36);
                        int i15 = columnIndexOrThrow20;
                        int i16 = columnIndexOrThrow37;
                        boolean z4 = ((int) sQLiteStatementPrepare2.getLong(i16)) != 0;
                        columnIndexOrThrow37 = i16;
                        int i17 = columnIndexOrThrow38;
                        boolean z5 = ((int) sQLiteStatementPrepare2.getLong(i17)) != 0;
                        columnIndexOrThrow38 = i17;
                        int i18 = columnIndexOrThrow39;
                        boolean z6 = ((int) sQLiteStatementPrepare2.getLong(i18)) != 0;
                        int i19 = columnIndexOrThrow40;
                        boolean z7 = ((int) sQLiteStatementPrepare2.getLong(i19)) != 0;
                        columnIndexOrThrow39 = i18;
                        columnIndexOrThrow40 = i19;
                        int i20 = columnIndexOrThrow41;
                        int i21 = columnIndexOrThrow42;
                        int i22 = columnIndexOrThrow43;
                        columnIndexOrThrow42 = i21;
                        columnIndexOrThrow43 = i22;
                        int i23 = columnIndexOrThrow44;
                        arrayList2.add(new SongEntity(text15, text16, i9, text17, text18, text19, z, numValueOf, localDateTimeFromTimestamp2, localDateTimeFromTimestamp3, z2, localDateTimeFromTimestamp4, j2, localDateTimeFromTimestamp5, localDateTimeFromTimestamp6, z3, text20, text21, i14, z4, z5, z6, z7, ((int) sQLiteStatementPrepare2.getLong(i20)) != 0, sQLiteStatementPrepare2.isNull(i21) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(i21)), sQLiteStatementPrepare2.isNull(i22) ? null : sQLiteStatementPrepare2.getText(i22), ((int) sQLiteStatementPrepare2.getLong(i23)) != 0));
                        columnIndexOrThrow41 = i20;
                        columnIndexOrThrow44 = i23;
                        columnIndexOrThrow18 = i11;
                        columnIndexOrThrow20 = i15;
                        columnIndexOrThrow30 = i8;
                        columnIndexOrThrow21 = i10;
                        columnIndexOrThrow31 = i7;
                        columnIndexOrThrow36 = columnIndexOrThrow36;
                        columnIndexOrThrow19 = i12;
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 10:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT * FROM song WHERE inLibrary IS NOT NULL ORDER BY title");
                try {
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "id");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "duration");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "thumbnailUrl");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "albumId");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "albumName");
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "explicit");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "year");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "date");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "dateModified");
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "liked");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "likedDate");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "totalPlayTime");
                    int columnIndexOrThrow58 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "inLibrary");
                    int columnIndexOrThrow59 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "dateDownload");
                    int columnIndexOrThrow60 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isLocal");
                    int columnIndexOrThrow61 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "libraryAddToken");
                    int columnIndexOrThrow62 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "libraryRemoveToken");
                    int columnIndexOrThrow63 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "lyricsOffset");
                    int columnIndexOrThrow64 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "romanizeLyrics");
                    int columnIndexOrThrow65 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isDownloaded");
                    int columnIndexOrThrow66 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isUploaded");
                    int columnIndexOrThrow67 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isVideo");
                    int columnIndexOrThrow68 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isEpisode");
                    int columnIndexOrThrow69 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "playbackPosition");
                    int columnIndexOrThrow70 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "uploadEntityId");
                    int columnIndexOrThrow71 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare3, "isCached");
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        String text22 = sQLiteStatementPrepare3.getText(columnIndexOrThrow45);
                        String text23 = sQLiteStatementPrepare3.getText(columnIndexOrThrow46);
                        int i24 = columnIndexOrThrow58;
                        int i25 = columnIndexOrThrow57;
                        int i26 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow47);
                        String text24 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow48);
                        String text25 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow49);
                        String text26 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow50) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow50);
                        int i27 = columnIndexOrThrow48;
                        int i28 = columnIndexOrThrow45;
                        boolean z8 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow51)) != 0;
                        Integer numValueOf2 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow52) ? null : Integer.valueOf((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow52));
                        LocalDateTime localDateTimeFromTimestamp7 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(columnIndexOrThrow53) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow53)));
                        LocalDateTime localDateTimeFromTimestamp8 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(columnIndexOrThrow54) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow54)));
                        boolean z9 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow55)) != 0;
                        LocalDateTime localDateTimeFromTimestamp9 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(columnIndexOrThrow56) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(columnIndexOrThrow56)));
                        long j3 = sQLiteStatementPrepare3.getLong(i25);
                        LocalDateTime localDateTimeFromTimestamp10 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i24) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i24)));
                        int i29 = columnIndexOrThrow59;
                        LocalDateTime localDateTimeFromTimestamp11 = Converters.fromTimestamp(sQLiteStatementPrepare3.isNull(i29) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i29)));
                        int i30 = columnIndexOrThrow46;
                        columnIndexOrThrow60 = columnIndexOrThrow60;
                        boolean z10 = ((int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow60)) != 0;
                        columnIndexOrThrow61 = columnIndexOrThrow61;
                        String text27 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow61) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow61);
                        columnIndexOrThrow62 = columnIndexOrThrow62;
                        String text28 = sQLiteStatementPrepare3.isNull(columnIndexOrThrow62) ? null : sQLiteStatementPrepare3.getText(columnIndexOrThrow62);
                        int i31 = (int) sQLiteStatementPrepare3.getLong(columnIndexOrThrow63);
                        int i32 = columnIndexOrThrow47;
                        int i33 = columnIndexOrThrow64;
                        boolean z11 = ((int) sQLiteStatementPrepare3.getLong(i33)) != 0;
                        columnIndexOrThrow64 = i33;
                        int i34 = columnIndexOrThrow65;
                        boolean z12 = ((int) sQLiteStatementPrepare3.getLong(i34)) != 0;
                        columnIndexOrThrow65 = i34;
                        int i35 = columnIndexOrThrow66;
                        boolean z13 = ((int) sQLiteStatementPrepare3.getLong(i35)) != 0;
                        int i36 = columnIndexOrThrow67;
                        boolean z14 = ((int) sQLiteStatementPrepare3.getLong(i36)) != 0;
                        columnIndexOrThrow66 = i35;
                        columnIndexOrThrow67 = i36;
                        int i37 = columnIndexOrThrow68;
                        int i38 = columnIndexOrThrow69;
                        int i39 = columnIndexOrThrow70;
                        columnIndexOrThrow69 = i38;
                        columnIndexOrThrow70 = i39;
                        int i40 = columnIndexOrThrow71;
                        arrayList3.add(new SongEntity(text22, text23, i26, text24, text25, text26, z8, numValueOf2, localDateTimeFromTimestamp7, localDateTimeFromTimestamp8, z9, localDateTimeFromTimestamp9, j3, localDateTimeFromTimestamp10, localDateTimeFromTimestamp11, z10, text27, text28, i31, z11, z12, z13, z14, ((int) sQLiteStatementPrepare3.getLong(i37)) != 0, sQLiteStatementPrepare3.isNull(i38) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(i38)), sQLiteStatementPrepare3.isNull(i39) ? null : sQLiteStatementPrepare3.getText(i39), ((int) sQLiteStatementPrepare3.getLong(i40)) != 0));
                        columnIndexOrThrow68 = i37;
                        columnIndexOrThrow71 = i40;
                        columnIndexOrThrow47 = i32;
                        columnIndexOrThrow58 = i24;
                        columnIndexOrThrow45 = i28;
                        columnIndexOrThrow48 = i27;
                        columnIndexOrThrow63 = columnIndexOrThrow63;
                        columnIndexOrThrow46 = i30;
                        columnIndexOrThrow59 = i29;
                        columnIndexOrThrow57 = i25;
                        break;
                    }
                    return arrayList3;
                } finally {
                    sQLiteStatementPrepare3.close();
                }
            case 11:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda108(obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda116(obj);
            case 13:
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                SQLiteStatement sQLiteStatementPrepare4 = sQLiteConnection4.prepare("SELECT COUNT(1) FROM song WHERE liked");
                try {
                    int i41 = sQLiteStatementPrepare4.step() ? (int) sQLiteStatementPrepare4.getLong(0) : 0;
                    sQLiteStatementPrepare4.close();
                    return Integer.valueOf(i41);
                } catch (Throwable th2) {
                    sQLiteStatementPrepare4.close();
                    throw th2;
                }
            case 14:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda137(obj);
            case 15:
                SQLiteConnection sQLiteConnection5 = (SQLiteConnection) obj;
                sQLiteConnection5.getClass();
                SQLiteStatement sQLiteStatementPrepare5 = sQLiteConnection5.prepare("SELECT COUNT(*) FROM event");
                try {
                    int i42 = sQLiteStatementPrepare5.step() ? (int) sQLiteStatementPrepare5.getLong(0) : 0;
                    sQLiteStatementPrepare5.close();
                    return Integer.valueOf(i42);
                } catch (Throwable th3) {
                    sQLiteStatementPrepare5.close();
                    throw th3;
                }
            case 16:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda147(obj);
            case 17:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda155(obj);
            case 18:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda156(obj);
            case 19:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda165(obj);
            case 20:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda176(obj);
            case 21:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda178(obj);
            case 22:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda188(obj);
            case 23:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda34(obj);
            case 24:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda5(obj);
            case 25:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda64(obj);
            case 26:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda66(obj);
            case 27:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda6(obj);
            case 28:
                return invoke$com$metrolist$music$db$DatabaseDao_Impl$$ExternalSyntheticLambda72(obj);
            default:
                SQLiteConnection sQLiteConnection6 = (SQLiteConnection) obj;
                sQLiteConnection6.getClass();
                SQLiteStatement sQLiteStatementPrepare6 = sQLiteConnection6.prepare("SELECT * FROM playlist ORDER BY name");
                try {
                    int columnIndexOrThrow72 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "id");
                    int columnIndexOrThrow73 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow74 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "browseId");
                    int columnIndexOrThrow75 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "createdAt");
                    int columnIndexOrThrow76 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "lastUpdateTime");
                    int columnIndexOrThrow77 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isEditable");
                    int columnIndexOrThrow78 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "bookmarkedAt");
                    int columnIndexOrThrow79 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "remoteSongCount");
                    int columnIndexOrThrow80 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "playEndpointParams");
                    int columnIndexOrThrow81 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "thumbnailUrl");
                    int columnIndexOrThrow82 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "shuffleEndpointParams");
                    int columnIndexOrThrow83 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "radioEndpointParams");
                    int columnIndexOrThrow84 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isLocal");
                    int columnIndexOrThrow85 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isAutoSync");
                    ArrayList arrayList4 = new ArrayList();
                    while (sQLiteStatementPrepare6.step()) {
                        int i43 = columnIndexOrThrow74;
                        int i44 = columnIndexOrThrow75;
                        arrayList4.add(new PlaylistEntity(sQLiteStatementPrepare6.getText(columnIndexOrThrow72), sQLiteStatementPrepare6.getText(columnIndexOrThrow73), sQLiteStatementPrepare6.isNull(columnIndexOrThrow74) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow74), Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow75) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow75))), Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow76) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow76))), ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow77)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow78) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow78))), sQLiteStatementPrepare6.isNull(columnIndexOrThrow79) ? null : Integer.valueOf((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow79)), sQLiteStatementPrepare6.isNull(columnIndexOrThrow80) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow80), sQLiteStatementPrepare6.isNull(columnIndexOrThrow81) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow81), sQLiteStatementPrepare6.isNull(columnIndexOrThrow82) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow82), sQLiteStatementPrepare6.isNull(columnIndexOrThrow83) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow83), ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow84)) != 0, ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow85)) != 0));
                        columnIndexOrThrow74 = i43;
                        columnIndexOrThrow75 = i44;
                        break;
                    }
                    return arrayList4;
                } finally {
                    sQLiteStatementPrepare6.close();
                }
        }
    }

    public /* synthetic */ DatabaseDao$$ExternalSyntheticLambda0(DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
    }
}
