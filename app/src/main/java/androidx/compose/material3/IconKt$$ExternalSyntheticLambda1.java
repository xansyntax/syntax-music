package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.cipher.PlayerScriptParser;
import com.metrolist.music.db.Converters;
import com.metrolist.music.db.entities.AlbumArtistMap;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PlayCountEntity;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HttpHeaders;
import io.ktor.http.LinkHeader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.ReversedListReadOnly;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ IconKt$$ExternalSyntheticLambda1(byte b, Object obj, String str) {
        this.$r8$classId = b;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        String str;
        String str2;
        Artist artist;
        Long lValueOf;
        FormatEntity formatEntity;
        AlbumEntity albumEntity;
        SetVideoIdEntity setVideoIdEntity;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str3 = this.f$0;
        switch (b) {
            case 0:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str3);
                SemanticsPropertiesKt.m718setRolekuIjeqM(semanticsPropertyReceiver, 5);
                return unit;
            case 1:
                SemanticsPropertyReceiver semanticsPropertyReceiver2 = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver2, str3);
                SemanticsPropertiesKt.m718setRolekuIjeqM(semanticsPropertyReceiver2, 5);
                return unit;
            case 2:
                SemanticsPropertiesKt.setPaneTitle((SemanticsPropertyReceiver) obj, str3);
                return unit;
            case 3:
                SemanticsPropertiesKt.setContentDescription((SemanticsPropertyReceiver) obj, str3);
                return unit;
            case 4:
                SemanticsPropertyReceiver semanticsPropertyReceiver3 = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver3, str3);
                SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver3, CropImageView.DEFAULT_ASPECT_RATIO);
                return unit;
            case 5:
                SemanticsPropertyReceiver semanticsPropertyReceiver4 = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver4);
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver4, str3);
                return unit;
            case 6:
                SemanticsPropertyReceiver semanticsPropertyReceiver5 = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.m718setRolekuIjeqM(semanticsPropertyReceiver5, 3);
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver5, str3);
                return unit;
            case 7:
                SemanticsPropertiesKt.setContentDescription((SemanticsPropertyReceiver) obj, str3);
                return unit;
            case 8:
                SemanticsPropertiesKt.setContentDescription((SemanticsPropertyReceiver) obj, str3);
                return unit;
            case 9:
                SemanticsPropertyReceiver semanticsPropertyReceiver6 = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.m717setLiveRegionhR3wRGc(semanticsPropertyReceiver6, 1);
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver6, str3);
                return unit;
            case 10:
                SemanticsPropertyReceiver semanticsPropertyReceiver7 = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.m717setLiveRegionhR3wRGc(semanticsPropertyReceiver7, 1);
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver7, str3);
                return unit;
            case 11:
                SemanticsPropertiesKt.setContentDescription((SemanticsPropertyReceiver) obj, str3);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MatchResult matchResult = (MatchResult) obj;
                matchResult.getClass();
                Regex regex = PlayerScriptParser.functionPattern;
                MatcherMatchResult matcherMatchResult = (MatcherMatchResult) matchResult;
                int iFindFunctionEnd = PlayerScriptParser.findFunctionEnd(matcherMatchResult.getRange().first, str3);
                if (iFindFunctionEnd > matcherMatchResult.getRange().first) {
                    String strSubstring = str3.substring(matcherMatchResult.getRange().first, iFindFunctionEnd);
                    Pattern patternCompile = Pattern.compile("a\\s*=\\s*a\\.split\\s*\\(\\s*\"\"\\s*\\)");
                    patternCompile.getClass();
                    if (patternCompile.matcher(strSubstring).find()) {
                        Pattern patternCompile2 = Pattern.compile("return\\s+a\\.join\\s*\\(\\s*\"\"\\s*\\)");
                        patternCompile2.getClass();
                        if (patternCompile2.matcher(strSubstring).find()) {
                            return new PlayerScriptParser.FunctionMatch((String) ((ReversedListReadOnly) matcherMatchResult.getGroupValues()).get(1));
                        }
                    }
                }
                return null;
            case 13:
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) obj;
                httpRequestBuilder.getClass();
                UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, "okhttp/5.4.0");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "application/json");
                if (str3 != null) {
                    UtilsKt.header(httpRequestBuilder, HttpHeaders.IfNoneMatch, str3);
                }
                HttpTimeoutKt.timeout(httpRequestBuilder, new YouTube$$ExternalSyntheticLambda2((byte) 15));
                return unit;
            case 14:
                Regex regex2 = (Regex) obj;
                regex2.getClass();
                MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(regex2, str3);
                if (matcherMatchResultFind$default == null || (str = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(1)) == null) {
                    return null;
                }
                return StringsKt__StringsJVMKt.toIntOrNull(10, str);
            case 15:
                Regex regex3 = (Regex) obj;
                regex3.getClass();
                MatcherMatchResult matcherMatchResultFind$default2 = Regex.find$default(regex3, str3);
                if (matcherMatchResultFind$default2 == null || (str2 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(1)) == null) {
                    return null;
                }
                return StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(str2, "\\/", "/", false), "\\u0026", "&", false);
            case 16:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM playlist_song_map WHERE playlistId = ?");
                try {
                    sQLiteStatementPrepare.bindText(1, str3);
                    sQLiteStatementPrepare.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 17:
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("SELECT * FROM search_history WHERE `query` LIKE ? || '%' ORDER BY id DESC");
                try {
                    sQLiteStatementPrepare2.bindText(1, str3);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare2, "query");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare2.step()) {
                        arrayList.add(new SearchHistory(sQLiteStatementPrepare2.getLong(columnIndexOrThrow), sQLiteStatementPrepare2.getText(columnIndexOrThrow2)));
                    }
                    sQLiteStatementPrepare2.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare2.close();
                    throw th;
                }
            case 18:
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("DELETE FROM playCount WHERE song = ?");
                try {
                    sQLiteStatementPrepare3.bindText(1, str3);
                    sQLiteStatementPrepare3.step();
                    return Integer.valueOf(MathKt.getTotalChangedRows(sQLiteConnection3));
                } finally {
                    sQLiteStatementPrepare3.close();
                }
            case 19:
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                SQLiteStatement sQLiteStatementPrepare4 = sQLiteConnection4.prepare("SELECT * FROM playCount WHERE song = ?");
                try {
                    sQLiteStatementPrepare4.bindText(1, str3);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "song");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "year");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "month");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare4, "count");
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare4.step()) {
                        arrayList2.add(new PlayCountEntity((int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow5), (int) sQLiteStatementPrepare4.getLong(columnIndexOrThrow6), sQLiteStatementPrepare4.getText(columnIndexOrThrow3)));
                    }
                    sQLiteStatementPrepare4.close();
                    return arrayList2;
                } catch (Throwable th2) {
                    sQLiteStatementPrepare4.close();
                    throw th2;
                }
            case 20:
                SQLiteConnection sQLiteConnection5 = (SQLiteConnection) obj;
                sQLiteConnection5.getClass();
                SQLiteStatement sQLiteStatementPrepare5 = sQLiteConnection5.prepare("SELECT COUNT(1) FROM related_song_map WHERE songId = ? LIMIT 1");
                try {
                    sQLiteStatementPrepare5.bindText(1, str3);
                    return Boolean.valueOf(sQLiteStatementPrepare5.step() && ((int) sQLiteStatementPrepare5.getLong(0)) != 0);
                } finally {
                    sQLiteStatementPrepare5.close();
                }
            case 21:
                SQLiteConnection sQLiteConnection6 = (SQLiteConnection) obj;
                sQLiteConnection6.getClass();
                SQLiteStatement sQLiteStatementPrepare6 = sQLiteConnection6.prepare("SELECT *, (SELECT COUNT(1) FROM song_artist_map JOIN song ON song_artist_map.songId = song.id WHERE artistId = artist.id AND song.inLibrary IS NOT NULL) AS songCount FROM artist WHERE id = ?");
                try {
                    sQLiteStatementPrepare6.bindText(1, str3);
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "id");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "thumbnailUrl");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "channelId");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "lastUpdateTime");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "bookmarkedAt");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isLocal");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "isPodcastChannel");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "cachedPageJson");
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare6, "songCount");
                    if (sQLiteStatementPrepare6.step()) {
                        int i = (int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow16);
                        String text = sQLiteStatementPrepare6.getText(columnIndexOrThrow7);
                        String text2 = sQLiteStatementPrepare6.getText(columnIndexOrThrow8);
                        String text3 = sQLiteStatementPrepare6.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow9);
                        String text4 = sQLiteStatementPrepare6.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow10);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow11) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow11)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        artist = new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(sQLiteStatementPrepare6.isNull(columnIndexOrThrow12) ? null : Long.valueOf(sQLiteStatementPrepare6.getLong(columnIndexOrThrow12))), ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow13)) != 0, ((int) sQLiteStatementPrepare6.getLong(columnIndexOrThrow14)) != 0, sQLiteStatementPrepare6.isNull(columnIndexOrThrow15) ? null : sQLiteStatementPrepare6.getText(columnIndexOrThrow15)), i, null);
                    } else {
                        artist = null;
                    }
                    sQLiteStatementPrepare6.close();
                    return artist;
                } catch (Throwable th3) {
                    sQLiteStatementPrepare6.close();
                    throw th3;
                }
            case 22:
                SQLiteConnection sQLiteConnection7 = (SQLiteConnection) obj;
                sQLiteConnection7.getClass();
                SQLiteStatement sQLiteStatementPrepare7 = sQLiteConnection7.prepare("SELECT SUM(playTime) FROM event WHERE songId = ?");
                try {
                    sQLiteStatementPrepare7.bindText(1, str3);
                    if (sQLiteStatementPrepare7.step() && !sQLiteStatementPrepare7.isNull(0)) {
                        lValueOf = Long.valueOf(sQLiteStatementPrepare7.getLong(0));
                        break;
                    } else {
                        lValueOf = null;
                    }
                    return lValueOf;
                } finally {
                    sQLiteStatementPrepare7.close();
                }
            case 23:
                SQLiteConnection sQLiteConnection8 = (SQLiteConnection) obj;
                sQLiteConnection8.getClass();
                SQLiteStatement sQLiteStatementPrepare8 = sQLiteConnection8.prepare("SELECT * FROM album_artist_map WHERE albumId = ?");
                try {
                    sQLiteStatementPrepare8.bindText(1, str3);
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare8, "albumId");
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare8, "artistId");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare8, "order");
                    ArrayList arrayList3 = new ArrayList();
                    while (sQLiteStatementPrepare8.step()) {
                        arrayList3.add(new AlbumArtistMap(sQLiteStatementPrepare8.getText(columnIndexOrThrow17), sQLiteStatementPrepare8.getText(columnIndexOrThrow18), (int) sQLiteStatementPrepare8.getLong(columnIndexOrThrow19)));
                    }
                    sQLiteStatementPrepare8.close();
                    return arrayList3;
                } catch (Throwable th4) {
                    sQLiteStatementPrepare8.close();
                    throw th4;
                }
            case 24:
                SQLiteConnection sQLiteConnection9 = (SQLiteConnection) obj;
                sQLiteConnection9.getClass();
                SQLiteStatement sQLiteStatementPrepare9 = sQLiteConnection9.prepare("SELECT sum(count) from playCount WHERE song = ?");
                try {
                    if (str3 == null) {
                        sQLiteStatementPrepare9.bindNull(1);
                    } else {
                        sQLiteStatementPrepare9.bindText(1, str3);
                    }
                    int i2 = sQLiteStatementPrepare9.step() ? (int) sQLiteStatementPrepare9.getLong(0) : 0;
                    sQLiteStatementPrepare9.close();
                    return Integer.valueOf(i2);
                } catch (Throwable th5) {
                    sQLiteStatementPrepare9.close();
                    throw th5;
                }
            case 25:
                SQLiteConnection sQLiteConnection10 = (SQLiteConnection) obj;
                sQLiteConnection10.getClass();
                SQLiteStatement sQLiteStatementPrepare10 = sQLiteConnection10.prepare("SELECT * FROM lyrics WHERE id = ?");
                try {
                    if (str3 == null) {
                        sQLiteStatementPrepare10.bindNull(1);
                    } else {
                        sQLiteStatementPrepare10.bindText(1, str3);
                    }
                    LyricsEntity lyricsEntity = sQLiteStatementPrepare10.step() ? new LyricsEntity(sQLiteStatementPrepare10.getText(FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare10, "id")), sQLiteStatementPrepare10.getText(FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare10, "lyrics")), sQLiteStatementPrepare10.getText(FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare10, "provider")), sQLiteStatementPrepare10.getText(FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare10, "translatedLyrics")), sQLiteStatementPrepare10.getText(FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare10, "translationLanguage")), sQLiteStatementPrepare10.getText(FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare10, "translationMode"))) : null;
                    sQLiteStatementPrepare10.close();
                    return lyricsEntity;
                } catch (Throwable th6) {
                    sQLiteStatementPrepare10.close();
                    throw th6;
                }
            case 26:
                SQLiteConnection sQLiteConnection11 = (SQLiteConnection) obj;
                sQLiteConnection11.getClass();
                SQLiteStatement sQLiteStatementPrepare11 = sQLiteConnection11.prepare("SELECT * FROM format WHERE id = ?");
                try {
                    if (str3 == null) {
                        sQLiteStatementPrepare11.bindNull(1);
                    } else {
                        sQLiteStatementPrepare11.bindText(1, str3);
                    }
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "id");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "itag");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "mimeType");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "codecs");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "bitrate");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "sampleRate");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "contentLength");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "loudnessDb");
                    int columnIndexOrThrow28 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "perceptualLoudnessDb");
                    int columnIndexOrThrow29 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare11, "playbackUrl");
                    if (sQLiteStatementPrepare11.step()) {
                        formatEntity = new FormatEntity(sQLiteStatementPrepare11.getText(columnIndexOrThrow20), (int) sQLiteStatementPrepare11.getLong(columnIndexOrThrow21), sQLiteStatementPrepare11.getText(columnIndexOrThrow22), sQLiteStatementPrepare11.getText(columnIndexOrThrow23), (int) sQLiteStatementPrepare11.getLong(columnIndexOrThrow24), sQLiteStatementPrepare11.isNull(columnIndexOrThrow25) ? null : Integer.valueOf((int) sQLiteStatementPrepare11.getLong(columnIndexOrThrow25)), sQLiteStatementPrepare11.getLong(columnIndexOrThrow26), sQLiteStatementPrepare11.isNull(columnIndexOrThrow27) ? null : Double.valueOf(sQLiteStatementPrepare11.getDouble(columnIndexOrThrow27)), sQLiteStatementPrepare11.isNull(columnIndexOrThrow28) ? null : Double.valueOf(sQLiteStatementPrepare11.getDouble(columnIndexOrThrow28)), sQLiteStatementPrepare11.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare11.getText(columnIndexOrThrow29));
                    } else {
                        formatEntity = null;
                    }
                    sQLiteStatementPrepare11.close();
                    return formatEntity;
                } catch (Throwable th7) {
                    sQLiteStatementPrepare11.close();
                    throw th7;
                }
            case 27:
                SQLiteConnection sQLiteConnection12 = (SQLiteConnection) obj;
                sQLiteConnection12.getClass();
                SQLiteStatement sQLiteStatementPrepare12 = sQLiteConnection12.prepare("SELECT COALESCE(MAX(position) + 1, 0) FROM playlist_song_map WHERE playlistId = ?");
                try {
                    sQLiteStatementPrepare12.bindText(1, str3);
                    int i3 = sQLiteStatementPrepare12.step() ? (int) sQLiteStatementPrepare12.getLong(0) : 0;
                    sQLiteStatementPrepare12.close();
                    return Integer.valueOf(i3);
                } catch (Throwable th8) {
                    sQLiteStatementPrepare12.close();
                    throw th8;
                }
            case 28:
                SQLiteConnection sQLiteConnection13 = (SQLiteConnection) obj;
                sQLiteConnection13.getClass();
                SQLiteStatement sQLiteStatementPrepare13 = sQLiteConnection13.prepare("SELECT * FROM album WHERE id = ? LIMIT 1");
                try {
                    sQLiteStatementPrepare13.bindText(1, str3);
                    int columnIndexOrThrow30 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "id");
                    int columnIndexOrThrow31 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "playlistId");
                    int columnIndexOrThrow32 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow33 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "year");
                    int columnIndexOrThrow34 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "thumbnailUrl");
                    int columnIndexOrThrow35 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "themeColor");
                    int columnIndexOrThrow36 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "songCount");
                    int columnIndexOrThrow37 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "duration");
                    int columnIndexOrThrow38 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "explicit");
                    int columnIndexOrThrow39 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "lastUpdateTime");
                    int columnIndexOrThrow40 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "bookmarkedAt");
                    int columnIndexOrThrow41 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "likedDate");
                    int columnIndexOrThrow42 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "inLibrary");
                    int columnIndexOrThrow43 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "isLocal");
                    int columnIndexOrThrow44 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare13, "isUploaded");
                    if (sQLiteStatementPrepare13.step()) {
                        String text5 = sQLiteStatementPrepare13.getText(columnIndexOrThrow30);
                        String text6 = sQLiteStatementPrepare13.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare13.getText(columnIndexOrThrow31);
                        String text7 = sQLiteStatementPrepare13.getText(columnIndexOrThrow32);
                        Integer numValueOf = sQLiteStatementPrepare13.isNull(columnIndexOrThrow33) ? null : Integer.valueOf((int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow33));
                        String text8 = sQLiteStatementPrepare13.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare13.getText(columnIndexOrThrow34);
                        Integer numValueOf2 = sQLiteStatementPrepare13.isNull(columnIndexOrThrow35) ? null : Integer.valueOf((int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow35));
                        int i4 = (int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow36);
                        int i5 = (int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow37);
                        boolean z = ((int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow38)) != 0;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare13.isNull(columnIndexOrThrow39) ? null : Long.valueOf(sQLiteStatementPrepare13.getLong(columnIndexOrThrow39)));
                        if (localDateTimeFromTimestamp2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        albumEntity = new AlbumEntity(text5, text6, text7, numValueOf, text8, numValueOf2, i4, i5, z, localDateTimeFromTimestamp2, Converters.fromTimestamp(sQLiteStatementPrepare13.isNull(columnIndexOrThrow40) ? null : Long.valueOf(sQLiteStatementPrepare13.getLong(columnIndexOrThrow40))), Converters.fromTimestamp(sQLiteStatementPrepare13.isNull(columnIndexOrThrow41) ? null : Long.valueOf(sQLiteStatementPrepare13.getLong(columnIndexOrThrow41))), Converters.fromTimestamp(sQLiteStatementPrepare13.isNull(columnIndexOrThrow42) ? null : Long.valueOf(sQLiteStatementPrepare13.getLong(columnIndexOrThrow42))), ((int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow43)) != 0, ((int) sQLiteStatementPrepare13.getLong(columnIndexOrThrow44)) != 0);
                    } else {
                        albumEntity = null;
                    }
                    sQLiteStatementPrepare13.close();
                    return albumEntity;
                } catch (Throwable th9) {
                    sQLiteStatementPrepare13.close();
                    throw th9;
                }
            default:
                SQLiteConnection sQLiteConnection14 = (SQLiteConnection) obj;
                sQLiteConnection14.getClass();
                SQLiteStatement sQLiteStatementPrepare14 = sQLiteConnection14.prepare("SELECT * FROM set_video_id WHERE videoId = ?");
                try {
                    sQLiteStatementPrepare14.bindText(1, str3);
                    int columnIndexOrThrow45 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare14, "videoId");
                    int columnIndexOrThrow46 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare14, "setVideoId");
                    if (sQLiteStatementPrepare14.step()) {
                        setVideoIdEntity = new SetVideoIdEntity(sQLiteStatementPrepare14.getText(columnIndexOrThrow45), sQLiteStatementPrepare14.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare14.getText(columnIndexOrThrow46));
                    } else {
                        setVideoIdEntity = null;
                    }
                    return setVideoIdEntity;
                } finally {
                    sQLiteStatementPrepare14.close();
                }
        }
    }

    public /* synthetic */ IconKt$$ExternalSyntheticLambda1(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }
}
