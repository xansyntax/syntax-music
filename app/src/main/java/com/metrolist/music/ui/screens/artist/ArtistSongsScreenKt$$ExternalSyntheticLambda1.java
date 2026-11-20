package com.metrolist.music.ui.screens.artist;

import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda32;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ArtistSongsScreenKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ State f$10;
    public final /* synthetic */ Function1 f$2;
    public final /* synthetic */ MimesKt$$ExternalSyntheticLambda0 f$3;
    public final /* synthetic */ State f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ MenuState f$6;
    public final /* synthetic */ State f$7;
    public final /* synthetic */ PlayerConnection f$8;
    public final /* synthetic */ String f$9;

    public /* synthetic */ ArtistSongsScreenKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, SongSortType songSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, MutableState mutableState, MutableState mutableState2, PlayerConnection playerConnection, String str, MutableState mutableState3, MenuState menuState) {
        this.f$0 = composableLambdaImpl;
        this.f$5 = songSortType;
        this.f$1 = z;
        this.f$2 = function1;
        this.f$3 = mimesKt$$ExternalSyntheticLambda0;
        this.f$4 = mutableState;
        this.f$7 = mutableState2;
        this.f$8 = playerConnection;
        this.f$9 = str;
        this.f$10 = mutableState3;
        this.f$6 = menuState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$5;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                boolean z = this.f$1;
                Function1 function1 = this.f$2;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = this.f$3;
                State state = this.f$4;
                lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 918676796, new SongMenuKt$$ExternalSyntheticLambda32((ArtistSongSortType) obj3, z, function1, mimesKt$$ExternalSyntheticLambda0, state, (byte) 4)));
                List list = (List) state.getValue();
                HomeScreenKt$$ExternalSyntheticLambda97 homeScreenKt$$ExternalSyntheticLambda97 = new HomeScreenKt$$ExternalSyntheticLambda97((byte) 19);
                lazyListIntervalContent.items(list.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(homeScreenKt$$ExternalSyntheticLambda97, list, (byte) 7), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 28), new ComposableLambdaImpl(true, 2039820996, new YouTubeBrowseScreenKt$YouTubeBrowseScreen$lambda$6$0$$inlined$items$default$4(list, (HapticFeedback) obj2, this.f$6, this.f$7, this.f$8, this.f$9, state, this.f$10, (byte) 2)));
                break;
            default:
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                lazyListIntervalContent2.item("filter", 0, new ComposableLambdaImpl(true, -1549748435, new ItemsKt$$ExternalSyntheticLambda9((ComposableLambdaImpl) obj3, (byte) 22)));
                boolean z2 = this.f$1;
                Function1 function2 = this.f$2;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = this.f$3;
                State state2 = this.f$4;
                lazyListIntervalContent2.item("sort_header", 0, new ComposableLambdaImpl(true, -2124527850, new SongMenuKt$$ExternalSyntheticLambda32((SongSortType) obj2, z2, function2, mimesKt$$ExternalSyntheticLambda1, state2, (byte) 6)));
                List list2 = (List) state2.getValue();
                lazyListIntervalContent2.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 16), list2, (byte) 26), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list2, (byte) 4), new ComposableLambdaImpl(true, 2039820996, new NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(list2, this.f$7, this.f$8, this.f$9, state2, this.f$10, this.f$6)));
                if (((List) state2.getValue()).isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent2, "empty", null, LibraryScreenKt.lambda$839618674, 2);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ArtistSongsScreenKt$$ExternalSyntheticLambda1(ArtistSongSortType artistSongSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, MutableState mutableState, HapticFeedback hapticFeedback, MenuState menuState, MutableState mutableState2, PlayerConnection playerConnection, String str, MutableState mutableState3) {
        this.f$0 = artistSongSortType;
        this.f$1 = z;
        this.f$2 = function1;
        this.f$3 = mimesKt$$ExternalSyntheticLambda0;
        this.f$4 = mutableState;
        this.f$5 = hapticFeedback;
        this.f$6 = menuState;
        this.f$7 = mutableState2;
        this.f$8 = playerConnection;
        this.f$9 = str;
        this.f$10 = mutableState3;
    }
}
