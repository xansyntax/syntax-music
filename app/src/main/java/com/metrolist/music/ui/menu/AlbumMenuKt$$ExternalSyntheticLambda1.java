package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.navigation.NavHostController;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.utils.SyncUtils;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ MutableState f$11;
    public final /* synthetic */ Object f$12;
    public final /* synthetic */ MutableState f$13;
    public final /* synthetic */ Object f$14;
    public final /* synthetic */ Object f$15;
    public final /* synthetic */ MutableState f$16;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ MutableState f$6;
    public final /* synthetic */ CoroutineScope f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ MusicDatabase f$9;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda1(MutableState mutableState, MutableState mutableState2, boolean z, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, PlaylistSortType playlistSortType, Function1 function1, CoroutineScope coroutineScope, Function1 function2, MusicDatabase musicDatabase, AddToPlaylistPosition addToPlaylistPosition, SyncUtils syncUtils, Function0 function0, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7) {
        this.f$4 = mutableState;
        this.f$6 = mutableState2;
        this.f$0 = z;
        this.f$2 = mimesKt$$ExternalSyntheticLambda0;
        this.f$3 = playlistSortType;
        this.f$5 = function1;
        this.f$7 = coroutineScope;
        this.f$14 = function2;
        this.f$9 = musicDatabase;
        this.f$8 = addToPlaylistPosition;
        this.f$15 = syncUtils;
        this.f$1 = function0;
        this.f$13 = mutableState3;
        this.f$10 = mutableState4;
        this.f$11 = mutableState5;
        this.f$12 = mutableState6;
        this.f$16 = mutableState7;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$12;
        Object obj3 = this.f$10;
        Object obj4 = this.f$15;
        Object obj5 = this.f$8;
        Object obj6 = this.f$14;
        Object obj7 = this.f$5;
        Object obj8 = this.f$3;
        Object obj9 = this.f$2;
        switch (b) {
            case 0:
                PlayerConnection playerConnection = (PlayerConnection) obj9;
                Album album = (Album) obj8;
                Context context = (Context) obj7;
                State state = (State) obj5;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.f$11;
                CoroutineScope coroutineScope = (CoroutineScope) obj6;
                State state2 = (State) obj4;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.f$16;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                boolean z = this.f$0;
                Function0 function0 = this.f$1;
                MutableState mutableState = this.f$4;
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1852890988, new AlbumMenuKt$$ExternalSyntheticLambda16(z, function0, playerConnection, album, mutableState, context)), 3);
                MutableState mutableState2 = this.f$6;
                CoroutineScope coroutineScope2 = this.f$7;
                MusicDatabase musicDatabase = this.f$9;
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 878051157, new AlbumMenuKt$$ExternalSyntheticLambda17(z, function0, playerConnection, mutableState2, coroutineScope2, state, musicDatabase, album, mutableState)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1047194932, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1216338707, new AlbumMenuKt$$ExternalSyntheticLambda18(context, (DownloadUtil) obj3, parcelableSnapshotMutableIntState, mutableState)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1385482482, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1554626257, new PlayerKt$$ExternalSyntheticLambda82(album, context, mutableState, (byte) 5)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1723770032, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1892913807, new AlbumMenuKt$$ExternalSyntheticLambda20(album, (NavHostController) obj2, function0, this.f$13, coroutineScope, musicDatabase, state2, parcelableSnapshotMutableFloatState)), 3);
                break;
            default:
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj9;
                PlaylistSortType playlistSortType = (PlaylistSortType) obj8;
                Function1 function1 = (Function1) obj7;
                Function1 function2 = (Function1) obj6;
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj5;
                SyncUtils syncUtils = (SyncUtils) obj4;
                MutableState mutableState3 = (MutableState) obj3;
                MutableState mutableState4 = (MutableState) obj2;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 446761309, new QueueKt$$ExternalSyntheticLambda21(this.f$4, (byte) 7)), 3);
                MutableState mutableState5 = this.f$6;
                if (!((List) mutableState5.getValue()).isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 793250850, new AddToPlaylistDialogKt$$ExternalSyntheticLambda8(this.f$0, mimesKt$$ExternalSyntheticLambda0, playlistSortType, function1, (byte) 0)), 3);
                }
                List list = (List) mutableState5.getValue();
                lazyListIntervalContent2.items(list.size(), new Latch$await$2$2(new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 22), list, (byte) 9), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 4), new ComposableLambdaImpl(true, 802480018, new AddToPlaylistDialogKt$AddToPlaylistDialog$lambda$24$0$$inlined$items$default$4(list, this.f$7, function2, this.f$9, addToPlaylistPosition, syncUtils, this.f$1, this.f$13, mutableState3, this.f$11, mutableState4, this.f$16)));
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda1(boolean z, Function0 function0, PlayerConnection playerConnection, Album album, MutableState mutableState, Context context, MutableState mutableState2, CoroutineScope coroutineScope, MutableState mutableState3, MusicDatabase musicDatabase, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, NavHostController navHostController, MutableState mutableState4, CoroutineScope coroutineScope2, AnimateAsState animateAsState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = playerConnection;
        this.f$3 = album;
        this.f$4 = mutableState;
        this.f$5 = context;
        this.f$6 = mutableState2;
        this.f$7 = coroutineScope;
        this.f$8 = mutableState3;
        this.f$9 = musicDatabase;
        this.f$10 = downloadUtil;
        this.f$11 = parcelableSnapshotMutableIntState;
        this.f$12 = navHostController;
        this.f$13 = mutableState4;
        this.f$14 = coroutineScope2;
        this.f$15 = animateAsState;
        this.f$16 = parcelableSnapshotMutableFloatState;
    }
}
