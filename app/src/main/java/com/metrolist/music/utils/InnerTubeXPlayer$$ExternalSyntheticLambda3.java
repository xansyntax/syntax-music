package com.metrolist.music.utils;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.LogEntry;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.screens.settings.AndroidAutoSection;
import com.metrolist.music.ui.screens.settings.ThemePalette;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InnerTubeXPlayer$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ InnerTubeXPlayer$$ExternalSyntheticLambda3(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                return entry.getKey() + "=" + entry.getValue();
            case 1:
                ((String) obj).getClass();
                return "suggestion";
            case 2:
                YTItem yTItem = (YTItem) obj;
                yTItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("item_", yTItem.getId());
            case 3:
                ((YTItem) obj).getClass();
                return "result_item";
            case 4:
                ((String) obj).getClass();
                return Boolean.TRUE;
            case 5:
                Playlist playlist = (Playlist) obj;
                playlist.getClass();
                return playlist.playlist.id;
            case 6:
                Pair pair = (Pair) obj;
                pair.getClass();
                return ((AndroidAutoSection) pair.first).id;
            case 7:
                Pair pair2 = (Pair) obj;
                pair2.getClass();
                AndroidAutoSection androidAutoSection = (AndroidAutoSection) pair2.first;
                return androidAutoSection.id + ServerSentEventKt.COLON + ((Boolean) pair2.second).booleanValue();
            case 8:
                ((Float) obj).getClass();
                return unit;
            case 9:
                ((Float) obj).getClass();
                return unit;
            case 10:
                ((Float) obj).getClass();
                return unit;
            case 11:
                ((Float) obj).getClass();
                return Float.valueOf(1.0f);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((String) obj).getClass();
                return unit;
            case 13:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.clearSearchHistory();
                return unit;
            case 14:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                musicDatabase2.clearListenHistory();
                return unit;
            case 15:
                Pair pair3 = (Pair) obj;
                pair3.getClass();
                return ((String) pair3.first) + ServerSentEventKt.COLON + ((Boolean) pair3.second).booleanValue();
            case 16:
                Pair pair4 = (Pair) obj;
                pair4.getClass();
                return ((String) pair4.first) + ServerSentEventKt.COLON + ((Boolean) pair4.second).booleanValue();
            case 17:
                ThemePalette themePalette = (ThemePalette) obj;
                themePalette.getClass();
                return Integer.valueOf(themePalette.nameRes);
            case 18:
                ArtistEntity artistEntity = (ArtistEntity) obj;
                artistEntity.getClass();
                return artistEntity.name;
            case 19:
                ((Float) obj).getClass();
                return Float.valueOf(1.0f);
            case 20:
                LogEntry logEntry = (LogEntry) obj;
                logEntry.getClass();
                StringBuilder sb = new StringBuilder(logEntry.timestamp);
                sb.append(" [");
                sb.append(logEntry.level.name());
                sb.append("] ");
                sb.append(logEntry.message);
                String str = logEntry.details;
                if (str != null) {
                    sb.append(" -- ".concat(str));
                }
                return sb.toString();
            case 21:
                ArtistEntity artistEntity2 = (ArtistEntity) obj;
                artistEntity2.getClass();
                return StringsKt__StringsJVMKt.replace(artistEntity2.name, "\"", "\"\"", false);
            case 22:
                ArtistEntity artistEntity3 = (ArtistEntity) obj;
                artistEntity3.getClass();
                return artistEntity3.name;
            case 23:
                Artist artist = (Artist) obj;
                artist.getClass();
                return StringsKt__StringsJVMKt.replace(artist.name, "\"", "\"\"", false);
            case 24:
                Artist artist2 = (Artist) obj;
                artist2.getClass();
                return artist2.name;
            case 25:
                return ((MediaMetadata.Artist) obj).name;
            case 26:
                return ((MediaMetadata.Artist) obj).name;
            case 27:
                return ((ArtistEntity) obj).name;
            case 28:
                return ((SongEntity) obj).toggleUploaded();
            default:
                return UByte.m1868toStringimpl(((Byte) obj).byteValue());
        }
    }
}
