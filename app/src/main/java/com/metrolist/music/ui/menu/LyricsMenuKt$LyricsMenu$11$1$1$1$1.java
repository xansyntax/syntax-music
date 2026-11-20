package com.metrolist.music.ui.menu;

import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.media3.common.MediaItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.lyrics.LyricsResult;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchResult;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsMenuKt$LyricsMenu$11$1$1$1$1 implements Function0 {
    public final /* synthetic */ Object $database;
    public final /* synthetic */ Object $onDismiss;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $result;
    public final /* synthetic */ Object $searchMediaMetadata;
    public final /* synthetic */ Object $viewModel;

    public LyricsMenuKt$LyricsMenu$11$1$1$1$1(HapticFeedback hapticFeedback, MenuState menuState, YTItem yTItem, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 2;
        this.$viewModel = hapticFeedback;
        this.$database = menuState;
        this.$searchMediaMetadata = yTItem;
        this.$onDismiss = function0;
        this.$result = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        Object obj = this.$result;
        Object obj2 = this.$onDismiss;
        Object obj3 = this.$searchMediaMetadata;
        Object obj4 = this.$database;
        Object obj5 = this.$viewModel;
        switch (b) {
            case 0:
                ((Function0) obj2).invoke();
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj5;
                StandaloneCoroutine standaloneCoroutine = lyricsMenuViewModel.job;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                lyricsMenuViewModel.job = null;
                ((MusicDatabase) obj4).query(new Latch$await$2$2((MediaMetadata) obj3, (LyricsResult) obj, (byte) 12));
                break;
            case 1:
                PlayerConnection playerConnection = (PlayerConnection) obj5;
                Song song = (Song) ((LocalItem) obj2);
                String str = song.song.id;
                MediaMetadata mediaMetadata = (MediaMetadata) ((State) obj3).getValue();
                if (Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null)) {
                    playerConnection.togglePlayPause();
                } else {
                    Iterable iterable = (Iterable) ((LocalSearchResult) ((State) obj).getValue()).map.getOrDefault(LocalFilter.SONG, EmptyList.INSTANCE);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj6 : iterable) {
                        if (obj6 instanceof Song) {
                            arrayList.add(obj6);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj7 = arrayList.get(i2);
                        i2++;
                        arrayList2.add(UuidKt.toMediaItem((Song) obj7));
                    }
                    String str2 = (String) obj4;
                    int size2 = arrayList2.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size2) {
                            Object obj8 = arrayList2.get(i3);
                            i3++;
                            if (!Intrinsics.areEqual(((MediaItem) obj8).mediaId, song.song.id)) {
                                i++;
                            }
                        } else {
                            i = -1;
                        }
                    }
                    playerConnection.playQueue(new ListQueue(str2, arrayList2, i, 0L, 8, null));
                }
                break;
            default:
                ((PlatformHapticFeedback) ((HapticFeedback) obj5)).m578performHapticFeedbackCdsT49E(0);
                MenuState menuState = (MenuState) obj4;
                menuState.show(new ComposableLambdaImpl(true, 710046557, new OnlineSearchScreenKt$OnlineSearchScreen$3$1$10$3((YTItem) obj3, menuState, (Function0) obj2, (CoroutineScope) obj, (byte) 1)));
                break;
        }
        return unit;
    }

    public /* synthetic */ LyricsMenuKt$LyricsMenu$11$1$1$1$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.$onDismiss = obj;
        this.$viewModel = obj2;
        this.$database = obj3;
        this.$searchMediaMetadata = obj4;
        this.$result = obj5;
    }
}
