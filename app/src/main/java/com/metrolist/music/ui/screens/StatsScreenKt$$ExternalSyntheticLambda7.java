package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.text.input.TextFieldValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.AlbumFilter;
import com.metrolist.music.constants.ArtistFilter;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.PodcastFilter;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Playlist;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda7(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                localDateTime.getClass();
                EventWithSong eventWithSong = (EventWithSong) mutableState.getValue();
                return Boolean.valueOf(localDateTime.isAfter(eventWithSong != null ? eventWithSong.event.timestamp.minusWeeks(1L) : null));
            case 1:
                AlbumFilter albumFilter = (AlbumFilter) obj;
                albumFilter.getClass();
                mutableState.setValue(albumFilter);
                return unit;
            case 2:
                ArtistFilter artistFilter = (ArtistFilter) obj;
                artistFilter.getClass();
                mutableState.setValue(artistFilter);
                return unit;
            case 3:
                PodcastFilter podcastFilter = (PodcastFilter) obj;
                podcastFilter.getClass();
                mutableState.setValue(podcastFilter);
                return unit;
            case 4:
                LibraryFilter libraryFilter = (LibraryFilter) obj;
                libraryFilter.getClass();
                if (((LibraryFilter) mutableState.getValue()) == libraryFilter) {
                    libraryFilter = LibraryFilter.LIBRARY;
                }
                mutableState.setValue(libraryFilter);
                return unit;
            case 5:
                SongFilter songFilter = (SongFilter) obj;
                songFilter.getClass();
                mutableState.setValue(songFilter);
                return unit;
            case 6:
                TextFieldValue textFieldValue = (TextFieldValue) obj;
                textFieldValue.getClass();
                mutableState.setValue(textFieldValue);
                return unit;
            case 7:
                TextFieldValue textFieldValue2 = (TextFieldValue) obj;
                textFieldValue2.getClass();
                mutableState.setValue(textFieldValue2);
                return unit;
            case 8:
                TextFieldValue textFieldValue3 = (TextFieldValue) obj;
                textFieldValue3.getClass();
                mutableState.setValue(textFieldValue3);
                return unit;
            case 9:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                Playlist playlist = (Playlist) mutableState.getValue();
                if (playlist != null) {
                    musicDatabase.$$delegate_0.delete(playlist.playlist);
                }
                return unit;
            case 10:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                Playlist playlist2 = (Playlist) mutableState.getValue();
                if (playlist2 != null && (str = playlist2.playlist.id) != null) {
                    musicDatabase2.$$delegate_0.clearPlaylist(str);
                }
                return unit;
            case 11:
                TextFieldValue textFieldValue4 = (TextFieldValue) obj;
                textFieldValue4.getClass();
                mutableState.setValue(textFieldValue4);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                TextFieldValue textFieldValue5 = (TextFieldValue) obj;
                textFieldValue5.getClass();
                mutableState.setValue(textFieldValue5);
                return unit;
            case 13:
                TextFieldValue textFieldValue6 = (TextFieldValue) obj;
                textFieldValue6.getClass();
                mutableState.setValue(textFieldValue6);
                return unit;
            case 14:
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                focusStateImpl.getClass();
                if (focusStateImpl.isFocused()) {
                    mutableState.setValue(Boolean.TRUE);
                }
                return unit;
            case 15:
                TextFieldValue textFieldValue7 = (TextFieldValue) obj;
                textFieldValue7.getClass();
                mutableState.setValue(textFieldValue7);
                return unit;
            case 16:
                TextFieldValue textFieldValue8 = (TextFieldValue) obj;
                textFieldValue8.getClass();
                mutableState.setValue(textFieldValue8);
                return unit;
            case 17:
                TextFieldValue textFieldValue9 = (TextFieldValue) obj;
                textFieldValue9.getClass();
                mutableState.setValue(textFieldValue9);
                return unit;
            case 18:
                TextFieldValue textFieldValue10 = (TextFieldValue) obj;
                textFieldValue10.getClass();
                mutableState.setValue(textFieldValue10);
                return unit;
            case 19:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                mutableState.setValue(bool);
                return unit;
            case 20:
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                mutableState.setValue(bool2);
                return unit;
            case 21:
                String str2 = (String) obj;
                str2.getClass();
                mutableState.setValue(str2);
                return unit;
            case 22:
                Boolean bool3 = (Boolean) obj;
                bool3.booleanValue();
                mutableState.setValue(bool3);
                return unit;
            case 23:
                String str3 = (String) obj;
                str3.getClass();
                mutableState.setValue(str3);
                return unit;
            case 24:
                String str4 = (String) obj;
                str4.getClass();
                mutableState.setValue(str4);
                return unit;
            case 25:
                ((Boolean) obj).getClass();
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                return unit;
            case 26:
                String str5 = (String) obj;
                str5.getClass();
                mutableState.setValue(str5);
                return unit;
            case 27:
                ((Boolean) obj).getClass();
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 28:
                String str6 = (String) obj;
                str6.getClass();
                mutableState.setValue(str6);
                return unit;
            default:
                Boolean bool4 = (Boolean) obj;
                bool4.booleanValue();
                mutableState.setValue(bool4);
                return unit;
        }
    }
}
