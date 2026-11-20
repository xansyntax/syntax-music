package com.metrolist.music.playback.queues;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001c"}, d2 = {"Lcom/metrolist/music/playback/queues/LocalAlbumRadio;", "Lcom/metrolist/music/playback/queues/Queue;", "albumWithSongs", "Lcom/metrolist/music/db/entities/AlbumWithSongs;", "startIndex", "", "<init>", "(Lcom/metrolist/music/db/entities/AlbumWithSongs;I)V", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "playlistId", "", "endpoint", "Lcom/metrolist/innertube/models/WatchEndpoint;", "getEndpoint", "()Lcom/metrolist/innertube/models/WatchEndpoint;", "continuation", "firstTimeLoaded", "", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "nextPage", "", "Landroidx/media3/common/MediaItem;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LocalAlbumRadio implements Queue {
    public static final int $stable = 8;
    private final AlbumWithSongs albumWithSongs;
    private String continuation;
    private boolean firstTimeLoaded;
    private String playlistId;
    private final MediaMetadata preloadItem;
    private final int startIndex;

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.LocalAlbumRadio$getInitialStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/playback/queues/Queue$Status;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.LocalAlbumRadio$getInitialStatus$2", f = "LocalAlbumRadio.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LocalAlbumRadio.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            String str = LocalAlbumRadio.this.albumWithSongs.album.title;
            List list = LocalAlbumRadio.this.albumWithSongs.songs;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(UuidKt.toMediaItem((Song) it.next()));
            }
            return new Queue.Status(str, arrayList, LocalAlbumRadio.this.startIndex, 0L, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.LocalAlbumRadio$nextPage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroidx/media3/common/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.LocalAlbumRadio$nextPage$2", f = "LocalAlbumRadio.kt", l = {44, 45, 53}, m = "invokeSuspend", v = 2)
    public static final class C01792 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        public C01792(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LocalAlbumRadio.this.new C01792(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
        
            if (r8 == r6) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00da, code lost:
        
            if (r8 == r6) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objM1024next0E7RQCE;
            LocalAlbumRadio localAlbumRadio;
            Object objM996album0E7RQCE;
            Object objM1024next0E7RQCE2;
            int i = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (LocalAlbumRadio.this.firstTimeLoaded) {
                    YouTube youTube = YouTube.INSTANCE;
                    WatchEndpoint endpoint = LocalAlbumRadio.this.getEndpoint();
                    String str = LocalAlbumRadio.this.continuation;
                    this.label = 3;
                    objM1024next0E7RQCE = youTube.m1024next0E7RQCE(endpoint, str, this);
                } else {
                    localAlbumRadio = LocalAlbumRadio.this;
                    YouTube youTube2 = YouTube.INSTANCE;
                    String str2 = localAlbumRadio.albumWithSongs.album.id;
                    this.L$0 = localAlbumRadio;
                    this.label = 1;
                    objM996album0E7RQCE = YouTube.INSTANCE.m996album0E7RQCE(str2, true, this);
                    if (objM996album0E7RQCE != coroutineSingletons) {
                        ResultKt.throwOnFailure(objM996album0E7RQCE);
                        localAlbumRadio.playlistId = ((AlbumPage) objM996album0E7RQCE).album.playlistId;
                        YouTube youTube3 = YouTube.INSTANCE;
                        WatchEndpoint endpoint2 = LocalAlbumRadio.this.getEndpoint();
                        String str3 = LocalAlbumRadio.this.continuation;
                        this.L$0 = null;
                        this.label = 2;
                        objM1024next0E7RQCE2 = youTube3.m1024next0E7RQCE(endpoint2, str3, this);
                    }
                }
                return coroutineSingletons;
            }
            if (i == 1) {
                localAlbumRadio = (LocalAlbumRadio) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM996album0E7RQCE = ((Result) obj).value;
                ResultKt.throwOnFailure(objM996album0E7RQCE);
                localAlbumRadio.playlistId = ((AlbumPage) objM996album0E7RQCE).album.playlistId;
                YouTube youTube4 = YouTube.INSTANCE;
                WatchEndpoint endpoint3 = LocalAlbumRadio.this.getEndpoint();
                String str4 = LocalAlbumRadio.this.continuation;
                this.L$0 = null;
                this.label = 2;
                objM1024next0E7RQCE2 = youTube4.m1024next0E7RQCE(endpoint3, str4, this);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1024next0E7RQCE = ((Result) obj).value;
                    ResultKt.throwOnFailure(objM1024next0E7RQCE);
                    NextResult nextResult = (NextResult) objM1024next0E7RQCE;
                    LocalAlbumRadio.this.continuation = nextResult.continuation;
                    List list = nextResult.items;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                    }
                    return arrayList;
                }
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE2 = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1024next0E7RQCE2);
            NextResult nextResult2 = (NextResult) objM1024next0E7RQCE2;
            LocalAlbumRadio localAlbumRadio2 = LocalAlbumRadio.this;
            String str5 = nextResult2.continuation;
            List list2 = nextResult2.items;
            localAlbumRadio2.continuation = str5;
            LocalAlbumRadio.this.firstTimeLoaded = true;
            List listSubList = list2.subList(LocalAlbumRadio.this.albumWithSongs.songs.size(), list2.size());
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSubList, 10));
            Iterator it2 = listSubList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(UuidKt.toMediaItem((SongItem) it2.next()));
            }
            return arrayList2;
        }
    }

    public LocalAlbumRadio(AlbumWithSongs albumWithSongs, int i) {
        albumWithSongs.getClass();
        this.albumWithSongs = albumWithSongs;
        this.startIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WatchEndpoint getEndpoint() {
        String str = this.playlistId;
        if (str != null) {
            return new WatchEndpoint(61, null, str, null);
        }
        Intrinsics.throwUninitializedPropertyAccessException("playlistId");
        throw null;
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
        return AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new C01792(null), continuation);
    }

    public /* synthetic */ LocalAlbumRadio(AlbumWithSongs albumWithSongs, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(albumWithSongs, (i2 & 2) != 0 ? 0 : i);
    }
}
