package com.metrolist.music.ui.screens;

import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import com.metrolist.innertube.pages.HistoryPage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.constants.HistorySource;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.viewmodels.DateAgo;
import com.metrolist.music.viewmodels.HistoryViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HistoryScreenKt$$ExternalSyntheticLambda14 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ MutableState f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ State f$6;
    public final /* synthetic */ PlayerConnection f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ List f$9;

    public /* synthetic */ HistoryScreenKt$$ExternalSyntheticLambda14(List list, boolean z, Function0 function0, PlayerConnection playerConnection, Function0 function1, List list2, MutableState mutableState, MusicDatabase musicDatabase, MutableState mutableState2, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState3) {
        this.f$1 = list;
        this.f$0 = z;
        this.f$2 = function0;
        this.f$7 = playerConnection;
        this.f$3 = function1;
        this.f$9 = list2;
        this.f$10 = mutableState;
        this.f$4 = musicDatabase;
        this.f$6 = mutableState2;
        this.f$8 = downloadUtil;
        this.f$5 = parcelableSnapshotMutableIntState;
        this.f$11 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$11;
        Object obj3 = this.f$5;
        Object obj4 = this.f$8;
        Object obj5 = this.f$4;
        Object obj6 = this.f$3;
        Object obj7 = this.f$2;
        switch (b) {
            case 0:
                Map map = (Map) obj7;
                HistoryViewModel historyViewModel = (HistoryViewModel) obj6;
                State state = (State) obj5;
                MenuState menuState = (MenuState) obj3;
                State state2 = (State) obj4;
                HapticFeedback hapticFeedback = (HapticFeedback) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                boolean z = this.f$0;
                LazyListIntervalContent.item$default(lazyListIntervalContent, "chips_row", null, new ComposableLambdaImpl(true, -1595564018, new LoginScreenKt$$ExternalSyntheticLambda17(z, (Object) historyViewModel, (Object) state, (byte) 4)), 2);
                HistorySource historySource = (HistorySource) state.getValue();
                HistorySource historySource2 = HistorySource.REMOTE;
                State state3 = this.f$6;
                PlayerConnection playerConnection = this.f$7;
                int i = 2039820996;
                if (historySource == historySource2 && z) {
                    List<HistoryPage.HistorySection> list = this.f$1;
                    if (list != null) {
                        for (HistoryPage.HistorySection historySection : list) {
                            LazyListIntervalContent.stickyHeader$default(lazyListIntervalContent, new ComposableLambdaImpl(true, 1395147568, new HistoryScreenKt$$ExternalSyntheticLambda20((byte) 0, historySection)));
                            List list2 = historySection.songs;
                            int i2 = i;
                            State state4 = state3;
                            lazyListIntervalContent.items(list2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new MainActivity$$ExternalSyntheticLambda0((byte) 13, historySection), list2, (byte) 2), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 20), new ComposableLambdaImpl(true, i2, new LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3(list2, historyViewModel, menuState, state4, playerConnection, state2, (byte) 1)));
                            i = i2;
                            state3 = state4;
                        }
                    }
                } else {
                    State state5 = state3;
                    PlayerConnection playerConnection2 = playerConnection;
                    for (Map.Entry entry : map.entrySet()) {
                        DateAgo dateAgo = (DateAgo) entry.getKey();
                        List list3 = (List) entry.getValue();
                        LazyListIntervalContent.stickyHeader$default(lazyListIntervalContent, new ComposableLambdaImpl(true, 1296594787, new HistoryScreenKt$$ExternalSyntheticLambda20((byte) 5, dateAgo)));
                        MenuState menuState2 = menuState;
                        State state6 = state5;
                        PlayerConnection playerConnection3 = playerConnection2;
                        State state7 = state2;
                        state5 = state6;
                        playerConnection2 = playerConnection3;
                        state2 = state7;
                        menuState = menuState2;
                        lazyListIntervalContent.items(list3.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new MainActivity$$ExternalSyntheticLambda0((byte) 14, dateAgo), list3, (byte) 3), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list3, (byte) 21), new ComposableLambdaImpl(true, 2039820996, new HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(list3, this.f$9, dateAgo, this.f$10, hapticFeedback, state6, playerConnection3, list3, state7, menuState2)));
                    }
                }
                break;
            default:
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj3;
                MutableState mutableState = (MutableState) obj2;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                List list4 = this.f$1;
                boolean z2 = this.f$0;
                PlayerConnection playerConnection4 = this.f$7;
                List list5 = this.f$9;
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, -1084061354, new QueueMenuKt$$ExternalSyntheticLambda6(list4, z2, (Function0) obj7, playerConnection4, (Function0) obj6, list5, this.f$10)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, AlbumMenuKt.lambda$1598278719, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, -1934807266, new QueueMenuKt$$ExternalSyntheticLambda12((MusicDatabase) obj5, (MutableState) this.f$6, list5, (DownloadUtil) obj4, parcelableSnapshotMutableIntState, mutableState)), 3);
                break;
        }
        return unit;
    }

    public /* synthetic */ HistoryScreenKt$$ExternalSyntheticLambda14(boolean z, List list, Map map, HistoryViewModel historyViewModel, MutableState mutableState, MenuState menuState, MutableState mutableState2, PlayerConnection playerConnection, MutableState mutableState3, List list2, MutableState mutableState4, HapticFeedback hapticFeedback) {
        this.f$0 = z;
        this.f$1 = list;
        this.f$2 = map;
        this.f$3 = historyViewModel;
        this.f$4 = mutableState;
        this.f$5 = menuState;
        this.f$6 = mutableState2;
        this.f$7 = playerConnection;
        this.f$8 = mutableState3;
        this.f$9 = list2;
        this.f$10 = mutableState4;
        this.f$11 = hapticFeedback;
    }
}
