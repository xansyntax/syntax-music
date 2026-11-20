package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$19$1;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsMenuKt$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Function f$12;
    public final /* synthetic */ Object f$13;
    public final /* synthetic */ Object f$14;
    public final /* synthetic */ Object f$15;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ boolean f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda8(MutableState mutableState, MutableState mutableState2, boolean z, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, PlaylistSortType playlistSortType, Function1 function1, Function1 function2, CoroutineScope coroutineScope, Function0 function0, SnapshotStateList snapshotStateList, Function1 function3, MusicDatabase musicDatabase, Function1 function4, AddToPlaylistPosition addToPlaylistPosition, MutableState mutableState3, MutableState mutableState4) {
        this.f$0 = mutableState;
        this.f$5 = mutableState2;
        this.f$7 = z;
        this.f$15 = mimesKt$$ExternalSyntheticLambda0;
        this.f$3 = playlistSortType;
        this.f$4 = function1;
        this.f$12 = function2;
        this.f$13 = coroutineScope;
        this.f$1 = function0;
        this.f$2 = snapshotStateList;
        this.f$6 = function3;
        this.f$9 = musicDatabase;
        this.f$8 = function4;
        this.f$14 = addToPlaylistPosition;
        this.f$10 = mutableState3;
        this.f$11 = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.f$0;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$14;
        Object obj3 = this.f$11;
        Object obj4 = this.f$9;
        Object obj5 = this.f$8;
        Object obj6 = this.f$10;
        Object obj7 = this.f$2;
        Object obj8 = this.f$13;
        Function function = this.f$12;
        Function function2 = this.f$4;
        Object obj9 = this.f$3;
        Object obj10 = this.f$1;
        Object obj11 = this.f$6;
        Object obj12 = this.f$15;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj10;
                Function0 function1 = (Function0) function2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -906561910, new SongMenuKt$$ExternalSyntheticLambda8(this.f$0, function0, (LyricsMenuViewModel) obj7, (Function0) obj9, function1, this.f$5, (Context) obj11)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1112586381, new LyricsMenuKt$$ExternalSyntheticLambda21(this.f$7, (State) obj5, function1, (MusicDatabase) obj4, (MutableState) obj6, (MutableState) obj3, (Function0) function, function0, (Function0) obj8, (ParcelableSnapshotMutableIntState) obj2, (MutableState) obj12)), 3);
                break;
            case 1:
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj12;
                PlaylistSortType playlistSortType = (PlaylistSortType) obj9;
                Function1 function3 = (Function1) function2;
                Function1 function4 = (Function1) function;
                CoroutineScope coroutineScope = (CoroutineScope) obj8;
                Function0 function5 = (Function0) obj10;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj7;
                Function1 function6 = (Function1) obj11;
                MusicDatabase musicDatabase = (MusicDatabase) obj4;
                Function1 function7 = (Function1) obj5;
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj2;
                MutableState mutableState2 = (MutableState) obj6;
                MutableState mutableState3 = (MutableState) obj3;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 2025776381, new QueueKt$$ExternalSyntheticLambda21(mutableState, (byte) 9)), 3);
                MutableState mutableState4 = this.f$5;
                if (!((List) mutableState4.getValue()).isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 942230402, new AddToPlaylistDialogKt$$ExternalSyntheticLambda8(this.f$7, mimesKt$$ExternalSyntheticLambda0, playlistSortType, function3, (byte) 1)), 3);
                }
                List list = (List) mutableState4.getValue();
                lazyListIntervalContent2.items(list.size(), new Latch$await$2$2(new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 24), list, (byte) 10), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 5), new ComposableLambdaImpl(true, 802480018, new ExperimentalLyricsKt$ExperimentalLyrics$19$1(list, function4, coroutineScope, function5, snapshotStateList, function6, musicDatabase, function7, addToPlaylistPosition, mutableState2, mutableState3)));
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 1832999718, new SongMenuKt$$ExternalSyntheticLambda8(snapshotStateList, musicDatabase, function5, function4, function6, function7, coroutineScope)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, AlbumMenuKt.f194lambda$366132027, 3);
                break;
            case 2:
                ArrayList arrayList = (ArrayList) obj6;
                State state = (State) obj5;
                State state2 = (State) obj8;
                PlayerConnection playerConnection = (PlayerConnection) obj7;
                String str = (String) obj11;
                State state3 = (State) obj4;
                MenuState menuState = (MenuState) obj2;
                LazyListIntervalContent lazyListIntervalContent3 = (LazyListIntervalContent) obj;
                lazyListIntervalContent3.getClass();
                MutableState mutableState5 = this.f$0;
                lazyListIntervalContent3.item("filter", 0, new ComposableLambdaImpl(true, 162785058, new AlbumMenuKt$$ExternalSyntheticLambda11((Function0) obj10, mutableState5, (byte) 24)));
                lazyListIntervalContent3.item("header", 0, new ComposableLambdaImpl(true, -733099687, new AlbumMenuKt$$ExternalSyntheticLambda17((LibrarySongsViewModel) obj3, this.f$5, (SoftwareKeyboardController) obj12, state, (SongSortType) obj9, this.f$7, (Function1) function2, (MimesKt$$ExternalSyntheticLambda0) function, arrayList)));
                if (arrayList.isEmpty() && !StringsKt.isBlank((String) state.getValue())) {
                    lazyListIntervalContent3.item("empty_search_result", 0, LibraryScreenKt.lambda$2135480189);
                }
                lazyListIntervalContent3.items(arrayList.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 18), arrayList, (byte) 27), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 26), new ComposableLambdaImpl(true, 2039820996, new YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(arrayList, state2, playerConnection, str, arrayList, state3, mutableState5, menuState)));
                break;
            default:
                List list2 = (List) obj12;
                Context context = (Context) obj11;
                MenuState menuState2 = (MenuState) obj10;
                SongSortType songSortType = (SongSortType) obj9;
                Function1 function8 = (Function1) function2;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = (MimesKt$$ExternalSyntheticLambda0) function;
                List list3 = (List) obj8;
                HapticFeedback hapticFeedback = (HapticFeedback) obj7;
                MutableState mutableState6 = (MutableState) obj6;
                State state4 = (State) obj5;
                PlayerConnection playerConnection2 = (PlayerConnection) obj4;
                MutableState mutableState7 = (MutableState) obj3;
                State state5 = (State) obj2;
                LazyListIntervalContent lazyListIntervalContent4 = (LazyListIntervalContent) obj;
                lazyListIntervalContent4.getClass();
                if (list2.isEmpty() && !((Boolean) mutableState.getValue()).booleanValue()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent4, "empty_placeholder", null, TopPlaylistScreenKt.lambda$1597280383, 2);
                }
                if (list2.isEmpty() && ((Boolean) mutableState.getValue()).booleanValue()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent4, "no_results", null, TopPlaylistScreenKt.f403lambda$803967690, 2);
                } else {
                    if (!list2.isEmpty() && !((Boolean) mutableState.getValue()).booleanValue()) {
                        LazyListIntervalContent.item$default(lazyListIntervalContent4, "playlist_header", null, new ComposableLambdaImpl(true, 56049370, new PlayerKt$$ExternalSyntheticLambda82(list2, context, menuState2, (byte) 15)), 2);
                    }
                    if (!list2.isEmpty()) {
                        LazyListIntervalContent.item$default(lazyListIntervalContent4, "sort_header", null, new ComposableLambdaImpl(true, 579855057, new HomeScreenKt$$ExternalSyntheticLambda29(songSortType, this.f$7, function8, (Function1) mimesKt$$ExternalSyntheticLambda1, (byte) 5)), 2);
                    }
                    lazyListIntervalContent4.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 21), list2, (byte) 29), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list2, (byte) 6), new ComposableLambdaImpl(true, 2039820996, new ExperimentalLyricsKt$ExperimentalLyrics$19$1(list2, list3, this.f$5, hapticFeedback, mutableState6, list2, state4, playerConnection2, mutableState7, state5, menuState2)));
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda8(MutableState mutableState, Function0 function0, LyricsMenuViewModel lyricsMenuViewModel, Function0 function1, Function0 function2, MutableState mutableState2, Context context, boolean z, MutableState mutableState3, MusicDatabase musicDatabase, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, Function0 function3, Function0 function4, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState4) {
        this.f$0 = mutableState;
        this.f$1 = function0;
        this.f$2 = lyricsMenuViewModel;
        this.f$3 = function1;
        this.f$4 = function2;
        this.f$5 = mutableState2;
        this.f$6 = context;
        this.f$7 = z;
        this.f$8 = mutableState3;
        this.f$9 = musicDatabase;
        this.f$10 = dataStoreKt$rememberPreference$1$1;
        this.f$11 = dataStoreKt$rememberPreference$1$2;
        this.f$12 = function3;
        this.f$13 = function4;
        this.f$14 = parcelableSnapshotMutableIntState;
        this.f$15 = mutableState4;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda8(ArrayList arrayList, Function0 function0, LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4, LibrarySongsViewModel librarySongsViewModel, MutableState mutableState, SoftwareKeyboardController softwareKeyboardController, MutableState mutableState2, SongSortType songSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, MutableState mutableState3, PlayerConnection playerConnection, String str, MutableState mutableState4, MenuState menuState) {
        this.f$10 = arrayList;
        this.f$1 = function0;
        this.f$0 = librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4;
        this.f$11 = librarySongsViewModel;
        this.f$5 = mutableState;
        this.f$15 = softwareKeyboardController;
        this.f$8 = mutableState2;
        this.f$3 = songSortType;
        this.f$7 = z;
        this.f$4 = function1;
        this.f$12 = mimesKt$$ExternalSyntheticLambda0;
        this.f$13 = mutableState3;
        this.f$2 = playerConnection;
        this.f$6 = str;
        this.f$9 = mutableState4;
        this.f$14 = menuState;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda8(List list, MutableState mutableState, Context context, MenuState menuState, SongSortType songSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, List list2, MutableState mutableState2, HapticFeedback hapticFeedback, MutableState mutableState3, MutableState mutableState4, PlayerConnection playerConnection, MutableState mutableState5, MutableState mutableState6) {
        this.f$15 = list;
        this.f$0 = mutableState;
        this.f$6 = context;
        this.f$1 = menuState;
        this.f$3 = songSortType;
        this.f$7 = z;
        this.f$4 = function1;
        this.f$12 = mimesKt$$ExternalSyntheticLambda0;
        this.f$13 = list2;
        this.f$5 = mutableState2;
        this.f$2 = hapticFeedback;
        this.f$10 = mutableState3;
        this.f$8 = mutableState4;
        this.f$9 = playerConnection;
        this.f$11 = mutableState5;
        this.f$14 = mutableState6;
    }
}
