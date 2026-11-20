package com.metrolist.music.playback.queues;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.PlaylistContinuationPage;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/metrolist/music/playback/queues/YouTubePlaylistQueue;", "Lcom/metrolist/music/playback/queues/Queue;", "playlistId", "", "playlistTitle", "initialSongs", "", "Lcom/metrolist/innertube/models/SongItem;", "initialContinuation", "startIndex", "", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILcom/metrolist/music/models/MediaMetadata;)V", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "continuation", "retryCount", "maxRetries", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "", "nextPage", "Landroidx/media3/common/MediaItem;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class YouTubePlaylistQueue implements Queue {
    public static final int $stable = 8;
    private String continuation;
    private final String initialContinuation;
    private final List<SongItem> initialSongs;
    private final int maxRetries;
    private final String playlistId;
    private final String playlistTitle;
    private final MediaMetadata preloadItem;
    private int retryCount;
    private final int startIndex;

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.YouTubePlaylistQueue$getInitialStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/playback/queues/Queue$Status;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.YouTubePlaylistQueue$getInitialStatus$2", f = "YouTubePlaylistQueue.kt", l = {37}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return YouTubePlaylistQueue.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM1025playlistgIAlus;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!YouTubePlaylistQueue.this.initialSongs.isEmpty()) {
                    String str = YouTubePlaylistQueue.this.playlistTitle;
                    List list = YouTubePlaylistQueue.this.initialSongs;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                    }
                    return new Queue.Status(str, arrayList, YouTubePlaylistQueue.this.startIndex, 0L, 8, null);
                }
                YouTube youTube = YouTube.INSTANCE;
                String str2 = YouTubePlaylistQueue.this.playlistId;
                this.label = 1;
                objM1025playlistgIAlus = youTube.m1025playlistgIAlus(str2, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM1025playlistgIAlus == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1025playlistgIAlus = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1025playlistgIAlus);
            PlaylistPage playlistPage = (PlaylistPage) objM1025playlistgIAlus;
            YouTubePlaylistQueue.this.continuation = playlistPage.songsContinuation;
            String str3 = playlistPage.playlist.title;
            List list2 = playlistPage.songs;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(UuidKt.toMediaItem((SongItem) it2.next()));
            }
            return new Queue.Status(str3, arrayList2, YouTubePlaylistQueue.this.startIndex, 0L, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.YouTubePlaylistQueue$nextPage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroidx/media3/common/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.YouTubePlaylistQueue$nextPage$2", f = "YouTubePlaylistQueue.kt", l = {57}, m = "invokeSuspend", v = 2)
    public static final class C01812 extends SuspendLambda implements Function2 {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public C01812(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return YouTubePlaylistQueue.this.new C01812(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00af  */
        /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x004f -> B:23:0x0052). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            int i;
            String str;
            Object objM1026playlistContinuationgIAlus;
            int i2 = this.label;
            Exception exc = null;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str2 = YouTubePlaylistQueue.this.continuation;
                    if (str2 == null) {
                        return EmptyList.INSTANCE;
                    }
                    i2 = YouTubePlaylistQueue.this.maxRetries;
                    if (i2 >= 0) {
                        str = str2;
                        i = 0;
                        YouTube youTube = YouTube.INSTANCE;
                        this.L$0 = str;
                        this.L$1 = null;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.label = 1;
                        objM1026playlistContinuationgIAlus = youTube.m1026playlistContinuationgIAlus(str, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objM1026playlistContinuationgIAlus == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    if (exc == null) {
                        throw new Exception("Failed to get next page");
                    }
                    throw exc;
                }
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i2 = this.I$1;
                i = this.I$0;
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM1026playlistContinuationgIAlus = ((Result) obj).value;
            } catch (Exception e) {
                YouTubePlaylistQueue.this.retryCount++;
                if (YouTubePlaylistQueue.this.retryCount >= YouTubePlaylistQueue.this.maxRetries) {
                    YouTubePlaylistQueue.this.continuation = null;
                }
                if (i == i2) {
                    exc = e;
                    if (exc == null) {
                        throw new Exception("Failed to get next page");
                    }
                    throw exc;
                }
                i++;
            }
            ResultKt.throwOnFailure(objM1026playlistContinuationgIAlus);
            PlaylistContinuationPage playlistContinuationPage = (PlaylistContinuationPage) objM1026playlistContinuationgIAlus;
            YouTubePlaylistQueue.this.continuation = playlistContinuationPage.continuation;
            YouTubePlaylistQueue.this.retryCount = 0;
            ArrayList arrayList = playlistContinuationPage.songs;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                arrayList2.add(UuidKt.toMediaItem((SongItem) obj2));
            }
            return arrayList2;
        }
    }

    public /* synthetic */ YouTubePlaylistQueue(String str, String str2, List list, String str3, int i, MediaMetadata mediaMetadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? EmptyList.INSTANCE : list, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? null : mediaMetadata);
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
        return this.continuation != null;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object nextPage(Continuation continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new C01812(null), continuation);
    }

    public YouTubePlaylistQueue(String str, String str2, List<SongItem> list, String str3, int i, MediaMetadata mediaMetadata) {
        str.getClass();
        list.getClass();
        this.playlistId = str;
        this.playlistTitle = str2;
        this.initialSongs = list;
        this.initialContinuation = str3;
        this.startIndex = i;
        this.preloadItem = mediaMetadata;
        this.continuation = str3;
        this.maxRetries = 3;
    }
}
