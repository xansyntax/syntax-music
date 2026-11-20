package com.metrolist.music.ui.screens;

import androidx.compose.runtime.State;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.LocalAlbumRadio;
import com.metrolist.music.playback.queues.YouTubeAlbumRadio;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.utils.DataStoreKt$get$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$10$1$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ State $allLocalItems$delegate;
    public final /* synthetic */ State $allYtItems$delegate;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ boolean $local;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeScreenKt$HomeScreen$10$1$2$1$1(boolean z, PlayerConnection playerConnection, State state, MusicDatabase musicDatabase, State state2, Continuation continuation) {
        super(2, continuation);
        this.$local = z;
        this.$playerConnection = playerConnection;
        this.$allLocalItems$delegate = state;
        this.$database = musicDatabase;
        this.$allYtItems$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HomeScreenKt$HomeScreen$10$1$2$1$1(this.$local, this.$playerConnection, this.$allLocalItems$delegate, this.$database, this.$allYtItems$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HomeScreenKt$HomeScreen$10$1$2$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if ((r14 instanceof com.metrolist.music.db.entities.Playlist) != false) goto L57;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        PlayerConnection playerConnection = this.$playerConnection;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            if (this.$local) {
                List list = HomeScreenKt.DailyDiscoverMessages;
                List list2 = (List) this.$allLocalItems$delegate.getValue();
                AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                LocalItem localItem = (LocalItem) CollectionsKt.random(list2);
                if (localItem != null) {
                    if (localItem instanceof Song) {
                        playerConnection.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata((Song) localItem)));
                    } else if (localItem instanceof Album) {
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        DataStoreKt$get$1 dataStoreKt$get$1 = new DataStoreKt$get$1(this.$database, localItem, (Continuation) null, (byte) 6);
                        this.label = true;
                        obj = AwaitKt.withContext(defaultIoScheduler, dataStoreKt$get$1, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else if (!(localItem instanceof Artist)) {
                    }
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            List list3 = HomeScreenKt.DailyDiscoverMessages;
            List list4 = (List) this.$allYtItems$delegate.getValue();
            AbstractPlatformRandom abstractPlatformRandom2 = Random.defaultRandom;
            YTItem yTItem = (YTItem) CollectionsKt.random(list4);
            if (yTItem != null) {
                if (yTItem instanceof SongItem) {
                    playerConnection.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata((SongItem) yTItem)));
                } else if (yTItem instanceof AlbumItem) {
                    playerConnection.playQueue(new YouTubeAlbumRadio(((AlbumItem) yTItem).playlistId));
                } else if (yTItem instanceof ArtistItem) {
                    WatchEndpoint watchEndpoint = ((ArtistItem) yTItem).radioEndpoint;
                    if (watchEndpoint != null) {
                        playerConnection.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                    }
                } else if (yTItem instanceof PlaylistItem) {
                    WatchEndpoint watchEndpoint2 = ((PlaylistItem) yTItem).playEndpoint;
                    if (watchEndpoint2 != null) {
                        playerConnection.playQueue(new YouTubeQueue(watchEndpoint2, null, 2, null));
                    }
                } else if (yTItem instanceof PodcastItem) {
                    WatchEndpoint watchEndpoint3 = ((PodcastItem) yTItem).playEndpoint;
                    if (watchEndpoint3 != null) {
                        playerConnection.playQueue(new YouTubeQueue(watchEndpoint3, null, 2, null));
                    }
                } else if (yTItem instanceof EpisodeItem) {
                    EpisodeItem episodeItem = (EpisodeItem) yTItem;
                    playerConnection.playQueue(new ListQueue(episodeItem.title, CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(episodeItem))), 0, 0L, 12, null));
                }
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
            return Unit.INSTANCE;
        }
        if (!z) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        AlbumWithSongs albumWithSongs = (AlbumWithSongs) obj;
        if (albumWithSongs != null) {
            playerConnection.playQueue(new LocalAlbumRadio(albumWithSongs, 0, 2, null));
        }
        return Unit.INSTANCE;
    }
}
