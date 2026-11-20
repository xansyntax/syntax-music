package kotlin.text;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.Converters;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.db.entities.SongArtistMap;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.eq.data.SavedEQProfile;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import io.ktor.http.ParametersBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StringsKt__IndentKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ StringsKt__IndentKt$$ExternalSyntheticLambda0(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Object artistEntity = null;
        Unit unit = Unit.INSTANCE;
        String str = this.f$0;
        switch (b) {
            case 0:
                String str2 = (String) obj;
                str2.getClass();
                if (StringsKt.isBlank(str2)) {
                    return str2.length() < str.length() ? str : str2;
                }
                return str.concat(str2);
            case 1:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT * FROM song_artist_map WHERE songId = ?");
                try {
                    sQLiteStatementPrepare.bindText(1, str);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songId");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "artistId");
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "position");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        arrayList.add(new SongArtistMap(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3)));
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            case 2:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT * FROM artist WHERE name = ?");
                try {
                    sQLiteStatementPrepare2.bindText(1, str);
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "thumbnailUrl");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "channelId");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "lastUpdateTime");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "bookmarkedAt");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isLocal");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "isPodcastChannel");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "cachedPageJson");
                    if (sQLiteStatementPrepare2.step()) {
                        String text = sQLiteStatementPrepare2.getText(columnIndexOrThrow4);
                        String text2 = sQLiteStatementPrepare2.getText(columnIndexOrThrow5);
                        String text3 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow6);
                        String text4 = sQLiteStatementPrepare2.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow7);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow8) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow8)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        artistEntity = new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare2.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare2.getLong(columnIndexOrThrow9))), ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare2.getLong(columnIndexOrThrow11)) != 0, sQLiteStatementPrepare2.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare2.getText(columnIndexOrThrow12));
                    }
                    sQLiteStatementPrepare2.close();
                    return artistEntity;
                } catch (Throwable th2) {
                    sQLiteStatementPrepare2.close();
                    throw th2;
                }
            case 3:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("SELECT playbackPosition FROM song WHERE id = ?");
                try {
                    sQLiteStatementPrepare3.bindText(1, str);
                    if (sQLiteStatementPrepare3.step() && !sQLiteStatementPrepare3.isNull(0)) {
                        artistEntity = Long.valueOf(sQLiteStatementPrepare3.getLong(0));
                        break;
                    }
                    return artistEntity;
                } finally {
                    sQLiteStatementPrepare3.close();
                }
            case 4:
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                SQLiteStatement sQLiteStatementPrepare4 = sQLiteConnection4.prepare("SELECT * FROM song WHERE id = ? LIMIT 1");
                try {
                    sQLiteStatementPrepare4.bindText(1, str);
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "id");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "duration");
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "thumbnailUrl");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "albumId");
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "albumName");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "explicit");
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "year");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "date");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "dateModified");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "liked");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "likedDate");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "totalPlayTime");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "inLibrary");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "dateDownload");
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isLocal");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "libraryAddToken");
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "libraryRemoveToken");
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "lyricsOffset");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "romanizeLyrics");
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isDownloaded");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isUploaded");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isVideo");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isEpisode");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "playbackPosition");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "uploadEntityId");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "isCached");
                    if (sQLiteStatementPrepare4.step()) {
                        artistEntity = new SongEntity(sQLiteStatementPrepare4.getText(columnIndexOrThrow13), sQLiteStatementPrepare4.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow15), sQLiteStatementPrepare4.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow16), sQLiteStatementPrepare4.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow17), sQLiteStatementPrepare4.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow18), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow19)) != 0, sQLiteStatementPrepare4.isNull(columnIndexOrThrow20) ? null : Integer.valueOf((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow20)), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow21) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow21))), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow22) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow22))), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow23)) != 0, Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow24) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow24))), sQLiteStatementPrepare4.getLong(columnIndexOrThrow25), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow26) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow26))), Converters.fromTimestamp(sQLiteStatementPrepare4.isNull(columnIndexOrThrow27) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow27))), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow28)) != 0, sQLiteStatementPrepare4.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow29), sQLiteStatementPrepare4.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow30), (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow31), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow32)) != 0, ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow33)) != 0, ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow34)) != 0, ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow35)) != 0, ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow36)) != 0, sQLiteStatementPrepare4.isNull(columnIndexOrThrow37) ? null : Long.valueOf(sQLiteStatementPrepare4.getLong(columnIndexOrThrow37)), sQLiteStatementPrepare4.isNull(columnIndexOrThrow38) ? null : sQLiteStatementPrepare4.getText(columnIndexOrThrow38), ((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow39)) != 0);
                    }
                    return artistEntity;
                } finally {
                    sQLiteStatementPrepare4.close();
                }
            case 5:
                SQLiteConnection sQLiteConnection5 = (SQLiteConnection) obj;
                sQLiteConnection5.getClass();
                SQLiteStatement sQLiteStatementPrepare5 = sQLiteConnection5.prepare("SELECT * FROM podcast WHERE id = ?");
                try {
                    sQLiteStatementPrepare5.bindText(1, str);
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "id");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "author");
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "thumbnailUrl");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "channelId");
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "bookmarkedAt");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "lastUpdateTime");
                    int columnIndexOrThrow47 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "libraryAddToken");
                    int columnIndexOrThrow48 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare5, "libraryRemoveToken");
                    if (sQLiteStatementPrepare5.step()) {
                        String text5 = sQLiteStatementPrepare5.getText(columnIndexOrThrow40);
                        String text6 = sQLiteStatementPrepare5.getText(columnIndexOrThrow41);
                        String text7 = sQLiteStatementPrepare5.isNull(columnIndexOrThrow42) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow42);
                        String text8 = sQLiteStatementPrepare5.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow43);
                        String text9 = sQLiteStatementPrepare5.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow44);
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare5.isNull(columnIndexOrThrow45) ? null : Long.valueOf(sQLiteStatementPrepare5.getLong(columnIndexOrThrow45)));
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare5.isNull(columnIndexOrThrow46) ? null : Long.valueOf(sQLiteStatementPrepare5.getLong(columnIndexOrThrow46)));
                        if (localDateTimeFromTimestamp3 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        artistEntity = new PodcastEntity(text5, text6, text7, text8, text9, localDateTimeFromTimestamp2, localDateTimeFromTimestamp3, sQLiteStatementPrepare5.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow47), sQLiteStatementPrepare5.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare5.getText(columnIndexOrThrow48));
                    }
                    sQLiteStatementPrepare5.close();
                    return artistEntity;
                } catch (Throwable th3) {
                    sQLiteStatementPrepare5.close();
                    throw th3;
                }
            case 6:
                SQLiteConnection sQLiteConnection6 = (SQLiteConnection) obj;
                sQLiteConnection6.getClass();
                SQLiteStatement sQLiteStatementPrepare6 = sQLiteConnection6.prepare("SELECT * FROM artist WHERE id = ? LIMIT 1");
                try {
                    sQLiteStatementPrepare6.bindText(1, str);
                    int columnIndexOrThrow49 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "id");
                    int columnIndexOrThrow50 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow51 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "thumbnailUrl");
                    int columnIndexOrThrow52 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "channelId");
                    int columnIndexOrThrow53 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "lastUpdateTime");
                    int columnIndexOrThrow54 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "bookmarkedAt");
                    int columnIndexOrThrow55 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isLocal");
                    int columnIndexOrThrow56 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isPodcastChannel");
                    int columnIndexOrThrow57 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "cachedPageJson");
                    if (sQLiteStatementPrepare6.step()) {
                        String text10 = sQLiteStatementPrepare6.getText(columnIndexOrThrow49);
                        String text11 = sQLiteStatementPrepare6.getText(columnIndexOrThrow50);
                        String text12 = sQLiteStatementPrepare6.isNull(columnIndexOrThrow51) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow51);
                        String text13 = sQLiteStatementPrepare6.isNull(columnIndexOrThrow52) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow52);
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow53) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow53)));
                        if (localDateTimeFromTimestamp4 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        artistEntity = new ArtistEntity(text10, text11, text12, text13, localDateTimeFromTimestamp4, Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow54) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow54))), ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow55)) != 0, ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow56)) != 0, sQLiteStatementPrepare6.isNull(columnIndexOrThrow57) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow57));
                    }
                    sQLiteStatementPrepare6.close();
                    return artistEntity;
                } catch (Throwable th4) {
                    sQLiteStatementPrepare6.close();
                    throw th4;
                }
            case 7:
                SQLiteConnection sQLiteConnection7 = (SQLiteConnection) obj;
                sQLiteConnection7.getClass();
                SQLiteStatement sQLiteStatementPrepare7 = sQLiteConnection7.prepare("SELECT * FROM playlist_song_map WHERE playlistId = ? AND position >= ? ORDER BY position");
                try {
                    sQLiteStatementPrepare7.bindText(1, str);
                    sQLiteStatementPrepare7.bindLong(2, 0L);
                    int columnIndexOrThrow58 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare7, "id");
                    int columnIndexOrThrow59 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare7, "playlistId");
                    int columnIndexOrThrow60 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare7, "songId");
                    int columnIndexOrThrow61 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare7, "position");
                    int columnIndexOrThrow62 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare7, "setVideoId");
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare7.step()) {
                        arrayList2.add(new PlaylistSongMap((int) sQLiteStatementPrepare7.getLong(columnIndexOrThrow58), sQLiteStatementPrepare7.getText(columnIndexOrThrow59), sQLiteStatementPrepare7.getText(columnIndexOrThrow60), (int) sQLiteStatementPrepare7.getLong(columnIndexOrThrow61), sQLiteStatementPrepare7.isNull(columnIndexOrThrow62) ? null : sQLiteStatementPrepare7.getText(columnIndexOrThrow62)));
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare7.close();
                }
            case 8:
                SQLiteConnection sQLiteConnection8 = (SQLiteConnection) obj;
                sQLiteConnection8.getClass();
                SQLiteStatement sQLiteStatementPrepare8 = sQLiteConnection8.prepare("DELETE FROM format WHERE id = ?");
                try {
                    sQLiteStatementPrepare8.bindText(1, str);
                    sQLiteStatementPrepare8.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare8.close();
                }
            case 9:
                SQLiteConnection sQLiteConnection9 = (SQLiteConnection) obj;
                sQLiteConnection9.getClass();
                SQLiteStatement sQLiteStatementPrepare9 = sQLiteConnection9.prepare("\n        SELECT song.id FROM song\n        JOIN playlist_song_map ON playlist_song_map.songId = song.id\n        WHERE playlist_song_map.playlistId = ?\n          AND NOT EXISTS (\n              SELECT 1 FROM song_artist_map WHERE song_artist_map.songId = song.id\n          )\n        ");
                try {
                    sQLiteStatementPrepare9.bindText(1, str);
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare9.step()) {
                        arrayList3.add(sQLiteStatementPrepare9.getText(0));
                    }
                    sQLiteStatementPrepare9.close();
                    return arrayList3;
                } catch (Throwable th5) {
                    sQLiteStatementPrepare9.close();
                    throw th5;
                }
            case 10:
                SQLiteConnection sQLiteConnection10 = (SQLiteConnection) obj;
                sQLiteConnection10.getClass();
                SQLiteStatement sQLiteStatementPrepare10 = sQLiteConnection10.prepare("SELECT EXISTS(SELECT * FROM speed_dial_item WHERE id = ?)");
                try {
                    sQLiteStatementPrepare10.bindText(1, str);
                    return Boolean.valueOf(sQLiteStatementPrepare10.step() && ((int) sQLiteStatementPrepare10.getLong(0)) != 0);
                } finally {
                    sQLiteStatementPrepare10.close();
                }
            case 11:
                SQLiteConnection sQLiteConnection11 = (SQLiteConnection) obj;
                sQLiteConnection11.getClass();
                SQLiteStatement sQLiteStatementPrepare11 = sQLiteConnection11.prepare("DELETE FROM speed_dial_item WHERE id = ?");
                try {
                    sQLiteStatementPrepare11.bindText(1, str);
                    sQLiteStatementPrepare11.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare11.close();
                }
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ParametersBuilder parametersBuilder = (ParametersBuilder) obj;
                parametersBuilder.getClass();
                parametersBuilder.append("refresh_token", str);
                return unit;
            case 13:
                return Boolean.valueOf(Intrinsics.areEqual(((SavedEQProfile) obj).id, str));
            case 14:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                SearchHistory searchHistory = new SearchHistory(0L, str);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.insert(searchHistory);
                return unit;
            case 15:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                SearchHistory searchHistory2 = new SearchHistory(0L, str);
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.insert(searchHistory2);
                return unit;
            case 16:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                semanticsPropertyReceiver.getClass();
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                return unit;
            case 17:
                SemanticsPropertyReceiver semanticsPropertyReceiver2 = (SemanticsPropertyReceiver) obj;
                semanticsPropertyReceiver2.getClass();
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver2, str);
                return unit;
            default:
                IntRange intRange = (IntRange) obj;
                intRange.getClass();
                return StringsKt.substring((CharSequence) str, intRange);
        }
    }

    public /* synthetic */ StringsKt__IndentKt$$ExternalSyntheticLambda0(String str, DatabaseDao_Impl databaseDao_Impl, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }
}
