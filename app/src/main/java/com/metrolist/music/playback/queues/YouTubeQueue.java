package com.metrolist.music.playback.queues;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/metrolist/music/playback/queues/YouTubeQueue;", "Lcom/metrolist/music/playback/queues/Queue;", "endpoint", "Lcom/metrolist/innertube/models/WatchEndpoint;", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "<init>", "(Lcom/metrolist/innertube/models/WatchEndpoint;Lcom/metrolist/music/models/MediaMetadata;)V", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "continuation", "", "retryCount", "", "maxRetries", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "", "nextPage", "", "Landroidx/media3/common/MediaItem;", "EmptyRadioQueueException", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class YouTubeQueue implements Queue {
    private String continuation;
    private WatchEndpoint endpoint;
    private final int maxRetries;
    private final MediaMetadata preloadItem;
    private int retryCount;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/metrolist/music/playback/queues/YouTubeQueue$EmptyRadioQueueException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class EmptyRadioQueueException extends IllegalStateException {
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.YouTubeQueue$getInitialStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/playback/queues/Queue$Status;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.YouTubeQueue$getInitialStatus$2", f = "YouTubeQueue.kt", l = {43, 52}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return YouTubeQueue.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:52:0x0112 A[Catch: Exception -> 0x0033, TryCatch #0 {Exception -> 0x0033, blocks: (B:7:0x0028, B:55:0x012b, B:58:0x0130, B:60:0x0134, B:62:0x013c, B:64:0x014c, B:66:0x0163, B:68:0x016a, B:69:0x016e, B:70:0x0193, B:72:0x0199, B:73:0x01a7, B:75:0x01ab, B:77:0x01b4, B:35:0x00ba, B:38:0x00df, B:40:0x00eb, B:42:0x00f3, B:44:0x00f9, B:46:0x0103, B:49:0x010a, B:50:0x010f, B:52:0x0112, B:14:0x0046), top: B:97:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:72:0x0199 A[Catch: Exception -> 0x0033, LOOP:1: B:70:0x0193->B:72:0x0199, LOOP_END, TryCatch #0 {Exception -> 0x0033, blocks: (B:7:0x0028, B:55:0x012b, B:58:0x0130, B:60:0x0134, B:62:0x013c, B:64:0x014c, B:66:0x0163, B:68:0x016a, B:69:0x016e, B:70:0x0193, B:72:0x0199, B:73:0x01a7, B:75:0x01ab, B:77:0x01b4, B:35:0x00ba, B:38:0x00df, B:40:0x00eb, B:42:0x00f3, B:44:0x00f9, B:46:0x0103, B:49:0x010a, B:50:0x010f, B:52:0x0112, B:14:0x0046), top: B:97:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:75:0x01ab A[Catch: Exception -> 0x0033, TryCatch #0 {Exception -> 0x0033, blocks: (B:7:0x0028, B:55:0x012b, B:58:0x0130, B:60:0x0134, B:62:0x013c, B:64:0x014c, B:66:0x0163, B:68:0x016a, B:69:0x016e, B:70:0x0193, B:72:0x0199, B:73:0x01a7, B:75:0x01ab, B:77:0x01b4, B:35:0x00ba, B:38:0x00df, B:40:0x00eb, B:42:0x00f3, B:44:0x00f9, B:46:0x0103, B:49:0x010a, B:50:0x010f, B:52:0x0112, B:14:0x0046), top: B:97:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:76:0x01b2  */
        /* JADX WARN: Code duplicated, block: B:91:0x0201  */
        /* JADX WARN: Code duplicated, block: B:92:0x0207  */
        /* JADX WARN: Code duplicated, block: B:95:0x020c  */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
        
            if (r12 == r7) goto L54;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x01ff: IF  (r9v0 ?? I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (r8 I:??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:92:0x0207 (LINE:512), block:B:90:0x01ff */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x01ff: IF  (r9 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (r8 I:??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:92:0x0207 (LINE:512), block:B:90:0x01ff */
        /* JADX WARN: Type inference failed for: r12v8, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18, types: [int] */
        /* JADX WARN: Type inference failed for: r3v20 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Exception {
            Exception exc;
            int i;
            int i2;
            int i3;
            String str;
            Object objM1024next0E7RQCE;
            int i4;
            NextResult nextResult;
            List listPlus;
            BrowseEndpoint browseEndpoint;
            String str2;
            Object objM1031relatedgIAlus;
            ArrayList arrayList;
            Iterator it;
            Integer num;
            int iIntValue;
            int i5 = this.label;
            int i6 = 2;
            boolean z = false;
            int i7 = 1;
            Exception exc2 = null;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (YouTubeQueue.this.endpoint.videoId != null && YouTubeQueue.this.endpoint.playlistId == null) {
                        YouTubeQueue.this.endpoint = new WatchEndpoint(60, YouTubeQueue.this.endpoint.videoId, Fragment$5$$ExternalSyntheticOutline0.m("RDAMVM", YouTubeQueue.this.endpoint.videoId), null);
                    }
                    String str3 = YouTubeQueue.this.endpoint.playlistId;
                    int i8 = ((str3 == null || !StringsKt__StringsJVMKt.startsWith(str3, "RDAMVM", false)) && (YouTubeQueue.this.endpoint.videoId == null || YouTubeQueue.this.endpoint.playlistId != null)) ? 0 : 1;
                    i2 = YouTubeQueue.this.maxRetries;
                    if (i2 < 0) {
                        if (exc2 == null) {
                            throw new Exception("Failed to get initial status");
                        }
                        throw exc2;
                    }
                    i4 = i8;
                    i3 = 0;
                    YouTube youTube = YouTube.INSTANCE;
                    WatchEndpoint watchEndpoint = YouTubeQueue.this.endpoint;
                    String str4 = YouTubeQueue.this.continuation;
                    this.L$0 = exc2;
                    this.L$1 = exc2;
                    this.L$2 = exc2;
                    this.L$3 = exc2;
                    this.I$0 = i4;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.label = i7;
                    objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, str4, this);
                    if (objM1024next0E7RQCE != coroutineSingletons) {
                        ResultKt.throwOnFailure(objM1024next0E7RQCE);
                        nextResult = (NextResult) objM1024next0E7RQCE;
                        listPlus = nextResult.items;
                        browseEndpoint = nextResult.relatedEndpoint;
                        if (i4 != 0) {
                            str2 = YouTubeQueue.this.endpoint.playlistId;
                            if (str2 != null) {
                                throw new EmptyRadioQueueException();
                            }
                            if (browseEndpoint != null) {
                                YouTube youTube2 = YouTube.INSTANCE;
                                this.L$0 = exc2;
                                this.L$1 = nextResult;
                                this.L$2 = listPlus;
                                this.L$3 = exc2;
                                this.I$0 = i4;
                                this.I$1 = i3;
                                this.I$2 = i2;
                                this.label = i6;
                                objM1031relatedgIAlus = youTube2.m1031relatedgIAlus(browseEndpoint, this);
                            }
                        }
                        YouTubeQueue.this.endpoint = nextResult.endpoint;
                        YouTubeQueue.this.continuation = nextResult.continuation;
                        YouTubeQueue.this.retryCount = 0;
                        String str5 = nextResult.title;
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listPlus, 10));
                        it = listPlus.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                        }
                        num = nextResult.currentIndex;
                        if (num != null) {
                            iIntValue = num.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        return new Queue.Status(str5, arrayList, iIntValue, 0L, 8, null);
                    }
                    return coroutineSingletons;
                }
                if (i5 == 1) {
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i4 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                    objM1024next0E7RQCE = ((Result) obj).value;
                    ResultKt.throwOnFailure(objM1024next0E7RQCE);
                    nextResult = (NextResult) objM1024next0E7RQCE;
                    listPlus = nextResult.items;
                    browseEndpoint = nextResult.relatedEndpoint;
                    if (i4 != 0 && YouTubeQueue.this.continuation == null && listPlus.size() <= i7) {
                        str2 = YouTubeQueue.this.endpoint.playlistId;
                        if (str2 != null && StringsKt__StringsJVMKt.startsWith(str2, "RDAMVM", z) == i7) {
                            throw new EmptyRadioQueueException();
                        }
                        if (browseEndpoint != null) {
                            YouTube youTube3 = YouTube.INSTANCE;
                            this.L$0 = exc2;
                            this.L$1 = nextResult;
                            this.L$2 = listPlus;
                            this.L$3 = exc2;
                            this.I$0 = i4;
                            this.I$1 = i3;
                            this.I$2 = i2;
                            this.label = i6;
                            objM1031relatedgIAlus = youTube3.m1031relatedgIAlus(browseEndpoint, this);
                        }
                    }
                    YouTubeQueue.this.endpoint = nextResult.endpoint;
                    YouTubeQueue.this.continuation = nextResult.continuation;
                    YouTubeQueue.this.retryCount = 0;
                    String str6 = nextResult.title;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listPlus, 10));
                    it = listPlus.iterator();
                    while (it.hasNext()) {
                        arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                    }
                    num = nextResult.currentIndex;
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    return new Queue.Status(str6, arrayList, iIntValue, 0L, 8, null);
                }
                if (i5 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i9 = this.I$2;
                int i10 = this.I$1;
                int i11 = this.I$0;
                listPlus = (List) this.L$2;
                nextResult = (NextResult) this.L$1;
                ResultKt.throwOnFailure(obj);
                objM1031relatedgIAlus = ((Result) obj).value;
            } catch (Exception e) {
                if (!(e instanceof EmptyRadioQueueException) || (str = YouTubeQueue.this.endpoint.playlistId) == null) {
                    z = false;
                    i7 = 1;
                } else {
                    z = false;
                    i7 = 1;
                    if (StringsKt__StringsJVMKt.startsWith(str, "RDAMVM", false) && YouTubeQueue.this.endpoint.videoId != null) {
                        exc = null;
                        YouTubeQueue.this.endpoint = new WatchEndpoint(62, YouTubeQueue.this.endpoint.videoId, null, null);
                    }
                    if (i != i2) {
                        exc2 = e;
                        if (exc2 == null) {
                            throw new Exception("Failed to get initial status");
                        }
                        throw exc2;
                    }
                    i3 = i + 1;
                    exc2 = exc;
                    i6 = 2;
                }
                exc = null;
                if (i != i2) {
                    exc2 = e;
                    if (exc2 == null) {
                        throw new Exception("Failed to get initial status");
                    }
                    throw exc2;
                }
                i3 = i + 1;
                exc2 = exc;
                i6 = 2;
            }
            if (objM1031relatedgIAlus instanceof Result.Failure) {
                objM1031relatedgIAlus = exc2;
            }
            RelatedPage relatedPage = (RelatedPage) objM1031relatedgIAlus;
            if (relatedPage != null && !relatedPage.songs.isEmpty()) {
                ?? r12 = relatedPage.songs;
                YouTubeQueue youTubeQueue = YouTubeQueue.this;
                ArrayList arrayList2 = new ArrayList();
                int size = r12.size();
                ?? r3 = z;
                while (r3 < size) {
                    Object obj2 = r12.get(r3);
                    int i12 = r3 + 1;
                    if (!Intrinsics.areEqual(((SongItem) obj2).id, youTubeQueue.endpoint.videoId)) {
                        arrayList2.add(obj2);
                    }
                    r3 = i12;
                }
                listPlus = CollectionsKt.plus((Iterable) arrayList2, (Collection) listPlus);
            }
            YouTubeQueue.this.endpoint = nextResult.endpoint;
            YouTubeQueue.this.continuation = nextResult.continuation;
            YouTubeQueue.this.retryCount = 0;
            String str7 = nextResult.title;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listPlus, 10));
            it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
            }
            num = nextResult.currentIndex;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = 0;
            }
            return new Queue.Status(str7, arrayList, iIntValue, 0L, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.queues.YouTubeQueue$nextPage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroidx/media3/common/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.playback.queues.YouTubeQueue$nextPage$2", f = "YouTubeQueue.kt", l = {92}, m = "invokeSuspend", v = 2)
    public static final class C01822 extends SuspendLambda implements Function2 {
        int I$0;
        int I$1;
        Object L$0;
        int label;

        public C01822(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return YouTubeQueue.this.new C01822(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C01822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004a -> B:19:0x004d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            int i;
            Object objM1024next0E7RQCE;
            int i2 = this.label;
            Exception exc = null;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i3 = YouTubeQueue.this.maxRetries;
                    if (i3 >= 0) {
                        i2 = i3;
                        i = 0;
                        YouTube youTube = YouTube.INSTANCE;
                        WatchEndpoint watchEndpoint = YouTubeQueue.this.endpoint;
                        String str = YouTubeQueue.this.continuation;
                        this.L$0 = null;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.label = 1;
                        objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, str, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objM1024next0E7RQCE == coroutineSingletons) {
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
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE = ((Result) obj).value;
            } catch (Exception e) {
                YouTubeQueue.this.retryCount++;
                if (YouTubeQueue.this.retryCount >= YouTubeQueue.this.maxRetries) {
                    YouTubeQueue.this.continuation = null;
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
            ResultKt.throwOnFailure(objM1024next0E7RQCE);
            NextResult nextResult = (NextResult) objM1024next0E7RQCE;
            YouTubeQueue.this.endpoint = nextResult.endpoint;
            YouTubeQueue.this.continuation = nextResult.continuation;
            YouTubeQueue.this.retryCount = 0;
            List list = nextResult.items;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
            }
            return arrayList;
        }
    }

    public YouTubeQueue(WatchEndpoint watchEndpoint, MediaMetadata mediaMetadata) {
        watchEndpoint.getClass();
        this.endpoint = watchEndpoint;
        this.preloadItem = mediaMetadata;
        this.maxRetries = 3;
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
        return AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new C01822(null), continuation);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/metrolist/music/playback/queues/YouTubeQueue$Companion;", "", "<init>", "()V", "radio", "Lcom/metrolist/music/playback/queues/YouTubeQueue;", "song", "Lcom/metrolist/music/models/MediaMetadata;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YouTubeQueue radio(MediaMetadata song) {
            song.getClass();
            String str = song.id;
            return new YouTubeQueue(new WatchEndpoint(60, str, Fragment$5$$ExternalSyntheticOutline0.m("RDAMVM", str), null), song);
        }

        private Companion() {
        }
    }

    public /* synthetic */ YouTubeQueue(WatchEndpoint watchEndpoint, MediaMetadata mediaMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(watchEndpoint, (i & 2) != 0 ? null : mediaMetadata);
    }
}
