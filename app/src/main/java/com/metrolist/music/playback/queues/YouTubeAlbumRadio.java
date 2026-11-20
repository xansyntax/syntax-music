package com.metrolist.music.playback.queues;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0096@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/metrolist/music/playback/queues/YouTubeAlbumRadio;", "Lcom/metrolist/music/playback/queues/Queue;", "playlistId", "", "<init>", "(Ljava/lang/String;)V", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "endpoint", "Lcom/metrolist/innertube/models/WatchEndpoint;", "getEndpoint", "()Lcom/metrolist/innertube/models/WatchEndpoint;", "albumSongCount", "", "continuation", "firstTimeLoaded", "", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "nextPage", "", "Landroidx/media3/common/MediaItem;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class YouTubeAlbumRadio implements Queue {
    public static final int $stable = 8;
    private int albumSongCount;
    private String continuation;
    private boolean firstTimeLoaded;
    private String playlistId;
    private final MediaMetadata preloadItem;

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.YouTubeAlbumRadio$getInitialStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/playback/queues/Queue$Status;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.YouTubeAlbumRadio$getInitialStatus$2", f = "YouTubeAlbumRadio.kt", l = {31}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return YouTubeAlbumRadio.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM997albumSongs0E7RQCE;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                String str = YouTubeAlbumRadio.this.playlistId;
                this.label = 1;
                objM997albumSongs0E7RQCE = youTube.m997albumSongs0E7RQCE(str, null, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM997albumSongs0E7RQCE == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM997albumSongs0E7RQCE = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM997albumSongs0E7RQCE);
            List list = (List) objM997albumSongs0E7RQCE;
            YouTubeAlbumRadio.this.albumSongCount = list.size();
            Album album = ((SongItem) CollectionsKt.first(list)).album;
            String str2 = album != null ? album.name : null;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
            }
            return new Queue.Status(str3, arrayList, 0, 0L, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.YouTubeAlbumRadio$nextPage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroidx/media3/common/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.YouTubeAlbumRadio$nextPage$2", f = "YouTubeAlbumRadio.kt", l = {43}, m = "invokeSuspend", v = 2)
    public static final class C01802 extends SuspendLambda implements Function2 {
        int label;

        public C01802(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return YouTubeAlbumRadio.this.new C01802(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM1024next0E7RQCE;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                WatchEndpoint endpoint = YouTubeAlbumRadio.this.getEndpoint();
                String str = YouTubeAlbumRadio.this.continuation;
                this.label = 1;
                objM1024next0E7RQCE = youTube.m1024next0E7RQCE(endpoint, str, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM1024next0E7RQCE == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1024next0E7RQCE);
            NextResult nextResult = (NextResult) objM1024next0E7RQCE;
            YouTubeAlbumRadio youTubeAlbumRadio = YouTubeAlbumRadio.this;
            String str2 = nextResult.continuation;
            List list = nextResult.items;
            youTubeAlbumRadio.continuation = str2;
            if (YouTubeAlbumRadio.this.firstTimeLoaded) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                }
                return arrayList;
            }
            YouTubeAlbumRadio.this.firstTimeLoaded = true;
            List listSubList = list.subList(YouTubeAlbumRadio.this.albumSongCount, list.size());
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSubList, 10));
            Iterator it2 = listSubList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(UuidKt.toMediaItem((SongItem) it2.next()));
            }
            return arrayList2;
        }
    }

    public YouTubeAlbumRadio(String str) {
        str.getClass();
        this.playlistId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchEndpoint getEndpoint() {
        return new WatchEndpoint(61, null, this.playlistId, null);
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object getInitialStatus(Continuation continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new AnonymousClass2(null), continuation);
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public MediaMetadata getPreloadItem() {
        return this.preloadItem;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public boolean hasNextPage() {
        return (this.firstTimeLoaded && this.continuation == null) ? false : true;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object nextPage(Continuation continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new C01802(null), continuation);
    }
}
