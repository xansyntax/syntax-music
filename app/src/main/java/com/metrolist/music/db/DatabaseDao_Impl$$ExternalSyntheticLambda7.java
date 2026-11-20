package com.metrolist.music.db;

import androidx.media3.exoplayer.offline.Download;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Artist;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.SpeedDialItem;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.ArtistNameAliases;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda7(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        switch (this.$r8$classId) {
            case 0:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM event");
                try {
                    sQLiteStatementPrepare.step();
                    return Unit.INSTANCE;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 1:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT * FROM album WHERE bookmarkedAt IS NOT NULL ORDER BY title");
                try {
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "playlistId");
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "year");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "themeColor");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "songCount");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "duration");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "explicit");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lastUpdateTime");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "bookmarkedAt");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "likedDate");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "inLibrary");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isUploaded");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        String text = sQLiteStatementPrepare2.getText(columnIndexOrThrow);
                        String text2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow2);
                        String text3 = sQLiteStatementPrepare2.getText(columnIndexOrThrow3);
                        Integer numValueOf = sQLiteStatementPrepare2.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow4));
                        String text4 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow5);
                        Integer numValueOf2 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow6));
                        int i = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow7);
                        int i2 = columnIndexOrThrow7;
                        int i3 = columnIndexOrThrow6;
                        int i4 = (int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow8);
                        int i5 = columnIndexOrThrow8;
                        boolean z = ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow9)) != 0;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow10)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow13;
                        int i8 = columnIndexOrThrow12;
                        arrayList.add(new AlbumEntity(text, text2, text3, numValueOf, text4, numValueOf2, i, i4, z, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow11) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow11))), Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow12))), Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow13) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow13))), ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow14)) != 0, ((int) sQLiteStatementPrepare2.getLong(i6)) != 0));
                        columnIndexOrThrow12 = i8;
                        columnIndexOrThrow15 = i6;
                        columnIndexOrThrow13 = i7;
                        columnIndexOrThrow8 = i5;
                        columnIndexOrThrow6 = i3;
                        columnIndexOrThrow = columnIndexOrThrow;
                        columnIndexOrThrow2 = columnIndexOrThrow2;
                        columnIndexOrThrow7 = i2;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare2.close();
                }
            case 2:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT id FROM song WHERE liked");
                try {
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        arrayList2.add(sQLiteStatementPrepare3.getText(0));
                    }
                    sQLiteStatementPrepare3.close();
                    return arrayList2;
                } catch (Throwable th) {
                    sQLiteStatementPrepare3.close();
                    throw th;
                }
            case 3:
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                SQLiteStatement sQLiteStatementPrepare4 = sQLiteConnection4.prepare("SELECT * FROM album WHERE isUploaded = 1 ORDER BY title");
                try {
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "id");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "playlistId");
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "year");
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "thumbnailUrl");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "themeColor");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "songCount");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "duration");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "explicit");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "lastUpdateTime");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "bookmarkedAt");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "likedDate");
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "inLibrary");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isLocal");
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isUploaded");
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare4.step()) {
                        String text5 = sQLiteStatementPrepare4.getText(columnIndexOrThrow16);
                        String text6 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow17);
                        String text7 = sQLiteStatementPrepare4.getText(columnIndexOrThrow18);
                        Integer numValueOf3 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow19) ? null : Integer.valueOf((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow19));
                        String text8 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow20);
                        Integer numValueOf4 = sQLiteStatementPrepare4.isNull(columnIndexOrThrow21) ? null : Integer.valueOf((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow21));
                        int i9 = (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow22);
                        int i10 = columnIndexOrThrow22;
                        int i11 = columnIndexOrThrow21;
                        int i12 = (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow23);
                        int i13 = columnIndexOrThrow23;
                        boolean z2 = ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow24)) != 0;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow25) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow25)));
                        if (localDateTimeFromTimestamp2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        int i14 = columnIndexOrThrow30;
                        int i15 = columnIndexOrThrow28;
                        int i16 = columnIndexOrThrow27;
                        arrayList3.add(new AlbumEntity(text5, text6, text7, numValueOf3, text8, numValueOf4, i9, i12, z2, localDateTimeFromTimestamp2, Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow26) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow26))), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow27) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow27))), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow28) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow28))), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow29)) != 0, ((int) sQLiteStatementPrepare4.getLong(i14)) != 0));
                        columnIndexOrThrow27 = i16;
                        columnIndexOrThrow30 = i14;
                        columnIndexOrThrow28 = i15;
                        columnIndexOrThrow23 = i13;
                        columnIndexOrThrow21 = i11;
                        columnIndexOrThrow16 = columnIndexOrThrow16;
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        columnIndexOrThrow22 = i10;
                    }
                    return arrayList3;
                } finally {
                    sQLiteStatementPrepare4.close();
                }
            case 4:
                SQLiteConnection sQLiteConnection5 = (SQLiteConnection) obj;
                sQLiteConnection5.getClass();
                SQLiteStatement sQLiteStatementPrepare5 = sQLiteConnection5.prepare("SELECT * FROM artist WHERE bookmarkedAt IS NOT NULL ORDER BY name");
                try {
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "id");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "thumbnailUrl");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "channelId");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "lastUpdateTime");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "bookmarkedAt");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "isLocal");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "isPodcastChannel");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "cachedPageJson");
                    ArrayList arrayList4 = new ArrayList();
                    while (sQLiteStatementPrepare5.step()) {
                        String text9 = sQLiteStatementPrepare5.getText(columnIndexOrThrow31);
                        String text10 = sQLiteStatementPrepare5.getText(columnIndexOrThrow32);
                        String text11 = sQLiteStatementPrepare5.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow33);
                        String text12 = sQLiteStatementPrepare5.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow34);
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare5.isNull(columnIndexOrThrow35) ? null : Long.valueOf(sQLiteStatementPrepare5.getLong(columnIndexOrThrow35)));
                        if (localDateTimeFromTimestamp3 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        arrayList4.add(new ArtistEntity(text9, text10, text11, text12, localDateTimeFromTimestamp3, Converters.fromTimestamp(sQLiteStatementPrepare5.isNull(columnIndexOrThrow36) ? null : Long.valueOf(sQLiteStatementPrepare5.getLong(columnIndexOrThrow36))), ((int) sQLiteStatementPrepare5.getLong(columnIndexOrThrow37)) != 0, ((int) sQLiteStatementPrepare5.getLong(columnIndexOrThrow38)) != 0, sQLiteStatementPrepare5.isNull(columnIndexOrThrow39) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow39)));
                    }
                    return arrayList4;
                } finally {
                    sQLiteStatementPrepare5.close();
                }
            case 5:
                SQLiteConnection sQLiteConnection6 = (SQLiteConnection) obj;
                sQLiteConnection6.getClass();
                SQLiteStatement sQLiteStatementPrepare6 = sQLiteConnection6.prepare("SELECT * FROM speed_dial_item ORDER BY createDate ASC");
                try {
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "id");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "secondaryId");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "subtitle");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "subtitleIds");
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "thumbnailUrl");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, LinkHeader.Parameters.Type);
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "explicit");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "createDate");
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "albumId");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "albumName");
                    ArrayList arrayList5 = new ArrayList();
                    while (sQLiteStatementPrepare6.step()) {
                        arrayList5.add(new SpeedDialItem(sQLiteStatementPrepare6.getText(columnIndexOrThrow40), sQLiteStatementPrepare6.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow41), sQLiteStatementPrepare6.getText(columnIndexOrThrow42), sQLiteStatementPrepare6.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow43), sQLiteStatementPrepare6.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow44), sQLiteStatementPrepare6.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow45), sQLiteStatementPrepare6.getText(columnIndexOrThrow46), ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow47)) != 0, sQLiteStatementPrepare6.getLong(columnIndexOrThrow48), sQLiteStatementPrepare6.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow49), sQLiteStatementPrepare6.isNull(columnIndexOrThrow50) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow50)));
                        break;
                    }
                    return arrayList5;
                } finally {
                    sQLiteStatementPrepare6.close();
                }
            case 6:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.ignoreUnknownKeys = true;
                jsonBuilder.explicitNulls = false;
                jsonBuilder.encodeDefaults = true;
                return Unit.INSTANCE;
            case 7:
                Artist artist = (Artist) obj;
                artist.getClass();
                return artist.name;
            case 8:
                Artist artist2 = (Artist) obj;
                artist2.getClass();
                String str = artist2.id;
                return str != null ? str : "";
            case 9:
                Artist artist3 = (Artist) obj;
                artist3.getClass();
                return artist3.name;
            case 10:
                Artist artist4 = (Artist) obj;
                artist4.getClass();
                String str2 = artist4.id;
                return str2 != null ? str2 : "";
            case 11:
                MediaMetadata.Artist artist5 = (MediaMetadata.Artist) obj;
                artist5.getClass();
                return artist5.name;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MediaMetadata.Artist artist6 = (MediaMetadata.Artist) obj;
                artist6.getClass();
                return artist6.name;
            case 13:
                JsonBuilder jsonBuilder2 = (JsonBuilder) obj;
                jsonBuilder2.getClass();
                jsonBuilder2.ignoreUnknownKeys = true;
                jsonBuilder2.encodeDefaults = true;
                return Unit.INSTANCE;
            case 14:
                MediaMetadata.Artist artist7 = (MediaMetadata.Artist) obj;
                artist7.getClass();
                return artist7.name;
            case 15:
                MediaMetadata.Artist artist8 = (MediaMetadata.Artist) obj;
                artist8.getClass();
                return artist8.name;
            case 16:
                Listentogether.TrackInfo trackInfo = (Listentogether.TrackInfo) obj;
                trackInfo.getClass();
                return UuidKt.toMediaItem(ListenTogetherManager.toMediaMetadata(trackInfo));
            case 17:
                Listentogether.TrackInfo trackInfo2 = (Listentogether.TrackInfo) obj;
                trackInfo2.getClass();
                return trackInfo2.getId();
            case 18:
                JsonBuilder jsonBuilder3 = (JsonBuilder) obj;
                jsonBuilder3.getClass();
                jsonBuilder3.ignoreUnknownKeys = true;
                return Unit.INSTANCE;
            case 19:
                ArtistEntity artistEntity = (ArtistEntity) obj;
                artistEntity.getClass();
                ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity.id, artistEntity.name);
            case 20:
                ArtistEntity artistEntity2 = (ArtistEntity) obj;
                artistEntity2.getClass();
                ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity2.id, artistEntity2.name);
            case 21:
                ArtistEntity artistEntity3 = (ArtistEntity) obj;
                artistEntity3.getClass();
                ArtistNameAliases artistNameAliases3 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artistEntity3.id, artistEntity3.name);
            case 22:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                return Boolean.valueOf(((Download) entry.getValue()).state == 3);
            case 23:
                Map.Entry entry2 = (Map.Entry) obj;
                entry2.getClass();
                return (String) entry2.getKey();
            case 24:
                Artist artist9 = (Artist) obj;
                ArtistNameAliases artistNameAliases4 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist9.id, artist9.name);
            case 25:
                Artist artist10 = (Artist) obj;
                ArtistNameAliases artistNameAliases5 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist10.id, artist10.name);
            case 26:
                Artist artist11 = (Artist) obj;
                ArtistNameAliases artistNameAliases6 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist11.id, artist11.name);
            case 27:
                Artist artist12 = (Artist) obj;
                ArtistNameAliases artistNameAliases7 = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist12.id, artist12.name);
            case 28:
                MediaMetadata mediaMetadata = (MediaMetadata) obj;
                boolean z3 = MusicService.isRunning;
                if (mediaMetadata != null) {
                    return mediaMetadata.id;
                }
                return null;
            default:
                ArtistEntity artistEntity4 = (ArtistEntity) obj;
                boolean z4 = MusicService.isRunning;
                artistEntity4.getClass();
                return artistEntity4.name;
        }
    }

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda7(byte b, Object obj) {
        this.$r8$classId = b;
    }
}
