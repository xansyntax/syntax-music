package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.viewmodels.HomeViewModel;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$10$1$1$1$9$2$1$1$1$1$1$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $autoRadioQueue$delegate;
    public final /* synthetic */ NavHostController $navController;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ HomeViewModel $viewModel;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeScreenKt$HomeScreen$10$1$1$1$9$2$1$1$1$1$1$1$1$1$1(HomeViewModel homeViewModel, PlayerConnection playerConnection, NavHostController navHostController, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$viewModel = homeViewModel;
        this.$playerConnection = playerConnection;
        this.$navController = navHostController;
        this.$autoRadioQueue$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HomeScreenKt$HomeScreen$10$1$1$1$9$2$1$1$1$1$1$1$1$1$1(this.$viewModel, this.$playerConnection, this.$navController, this.$autoRadioQueue$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HomeScreenKt$HomeScreen$10$1$1$1$9$2$1$1$1$1$1$1$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Queue listQueue;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            this.label = true;
            obj = this.$viewModel.getRandomItem(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        YTItem yTItem = (YTItem) obj;
        if (yTItem != null) {
            boolean z2 = yTItem instanceof SongItem;
            PlayerConnection playerConnection = this.$playerConnection;
            if (z2) {
                if (((Boolean) this.$autoRadioQueue$delegate.getValue()).booleanValue()) {
                    SongItem songItem = (SongItem) yTItem;
                    WatchEndpoint watchEndpoint = songItem.endpoint;
                    if (watchEndpoint == null) {
                        watchEndpoint = new WatchEndpoint(62, songItem.id, null, null);
                    }
                    listQueue = new YouTubeQueue(watchEndpoint, HexFormatKt.toMediaMetadata(songItem));
                } else {
                    SongItem songItem2 = (SongItem) yTItem;
                    listQueue = new ListQueue(songItem2.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(songItem2))), 0, 0L, 12, null);
                }
                playerConnection.playQueue(listQueue);
            } else {
                boolean z3 = yTItem instanceof AlbumItem;
                NavHostController navHostController = this.$navController;
                if (z3) {
                    Format$$ExternalSyntheticOutline0.m("album/", ((AlbumItem) yTItem).id, navHostController);
                } else if (yTItem instanceof ArtistItem) {
                    Format$$ExternalSyntheticOutline0.m("artist/", ((ArtistItem) yTItem).id, navHostController);
                } else if (yTItem instanceof PlaylistItem) {
                    Format$$ExternalSyntheticOutline0.m("online_playlist/", ((PlaylistItem) yTItem).id, navHostController);
                } else if (yTItem instanceof PodcastItem) {
                    Format$$ExternalSyntheticOutline0.m("online_podcast/", ((PodcastItem) yTItem).id, navHostController);
                } else {
                    if (!(yTItem instanceof EpisodeItem)) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    EpisodeItem episodeItem = (EpisodeItem) yTItem;
                    playerConnection.playQueue(new ListQueue(episodeItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(episodeItem))), 0, 0L, 12, null));
                }
            }
        }
        return Unit.INSTANCE;
    }
}
