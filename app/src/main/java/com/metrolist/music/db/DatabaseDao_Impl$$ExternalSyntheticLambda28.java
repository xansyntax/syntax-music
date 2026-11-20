package com.metrolist.music.db;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import io.ktor.http.ContentDisposition;
import java.time.LocalDateTime;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda28 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda28(int i, String str) {
        this.f$1 = i;
        this.f$2 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        int i = this.f$1;
        String str = this.f$2;
        switch (b) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE playlist_song_map SET position = position + ? WHERE playlistId = ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, i);
                    sQLiteStatementPrepare.bindText(2, str);
                    sQLiteStatementPrepare.step();
                    return Unit.INSTANCE;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            default:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE name LIKE '%' || ? || '%' AND songCount > 0 LIMIT ?");
                try {
                    sQLiteStatementPrepare2.bindText(1, str);
                    sQLiteStatementPrepare2.bindLong(2, i);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "channelId");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lastUpdateTime");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "bookmarkedAt");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isPodcastChannel");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "cachedPageJson");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "songCount");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        int i2 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow10);
                        String text = sQLiteStatementPrepare2.getText(columnIndexOrThrow);
                        String text2 = sQLiteStatementPrepare2.getText(columnIndexOrThrow2);
                        String text3 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow3);
                        String text4 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow4);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow5)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        int i3 = columnIndexOrThrow3;
                        int i4 = columnIndexOrThrow4;
                        arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow6) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow6))), ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare2.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow9)), i2, null));
                        columnIndexOrThrow3 = i3;
                        columnIndexOrThrow4 = i4;
                    }
                    sQLiteStatementPrepare2.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare2.close();
                    throw th;
                }
        }
    }

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda28(String str, int i, DatabaseDao_Impl databaseDao_Impl) {
        this.f$2 = str;
        this.f$1 = i;
    }
}
