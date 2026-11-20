package coil3.network;

import android.content.Context;
import android.webkit.WebView;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.MutatePriority;
import androidx.compose.animation.core.MutationInterruptedException;
import androidx.compose.animation.core.MutatorMutex;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import coil3.decode.DataSource;
import coil3.decode.FileImageSource;
import coil3.decode.SourceImageSource;
import coil3.disk.RealDiskCache;
import coil3.fetch.SourceFetchResult;
import coil3.util.UtilsKt;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.extraction.PlayerClientDirector;
import com.metrolist.innertubex.extraction.PoTokenResult;
import com.metrolist.innertubex.extraction.TokenProvider;
import com.metrolist.innertubex.extraction.strategy.ClientRequestCapabilities;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientManifest;
import com.metrolist.innertubex.extraction.strategy.SelectedClient;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.player.QueueKt$Queue$5$1$1;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.AuthData;
import com.metrolist.music.ui.screens.LoginJsInterface;
import com.metrolist.music.ui.screens.LoginStage;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$scheduleRemoveFromPlaylist$1$1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkFetcher$doFetch$fetchResult$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object $cacheResponse;
    public final /* synthetic */ Object $networkRequest;
    public final /* synthetic */ byte $r8$classId;
    public Object $snapshot;
    public Object L$0;
    public Object L$1;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkFetcher$doFetch$fetchResult$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$1 = obj;
        this.$snapshot = obj2;
        this.$cacheResponse = obj3;
        this.L$0 = obj4;
        this.this$0 = obj5;
        this.$networkRequest = obj6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$networkRequest;
        Object obj3 = this.this$0;
        switch (b) {
            case 0:
                NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$1 = new NetworkFetcher$doFetch$fetchResult$1((Ref$ObjectRef) this.$snapshot, (NetworkFetcher) obj3, (Ref$ObjectRef) this.$cacheResponse, (NetworkRequest) obj2, continuation);
                networkFetcher$doFetch$fetchResult$1.L$0 = obj;
                return networkFetcher$doFetch$fetchResult$1;
            case 1:
                NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$2 = new NetworkFetcher$doFetch$fetchResult$1((MutatorMutex) obj3, (Function1) obj2, continuation);
                networkFetcher$doFetch$fetchResult$2.$cacheResponse = obj;
                return networkFetcher$doFetch$fetchResult$2;
            case 2:
                return new NetworkFetcher$doFetch$fetchResult$1((Deferred) this.L$1, (PlayerClientDirector) this.$snapshot, (String) this.$cacheResponse, (String) this.L$0, (InnerTube.SessionSnapshot) obj3, (SelectedClient) obj2, continuation, (byte) 2);
            case 3:
                return new NetworkFetcher$doFetch$fetchResult$1((Animatable) this.L$1, (Animatable) this.$snapshot, (Animatable) this.$cacheResponse, (Animatable) this.L$0, (MutableState) obj3, (MutableState) obj2, continuation, (byte) 3);
            case 4:
                return new NetworkFetcher$doFetch$fetchResult$1((MusicDatabase) this.$cacheResponse, (YTItem) obj3, (PlayerConnection) obj2, continuation);
            case 5:
                return new NetworkFetcher$doFetch$fetchResult$1((MutableState) this.L$1, (MutableState) this.$snapshot, (MusicDatabase) this.$cacheResponse, (AddToPlaylistPosition) this.L$0, (SyncUtils) obj3, (Function0) obj2, continuation, (byte) 5);
            case 6:
                NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$3 = new NetworkFetcher$doFetch$fetchResult$1((MutableState) this.L$1, (LoginJsInterface) this.$snapshot, (Context) this.$cacheResponse, (MutableState) obj3, (MutableState) obj2, continuation, (byte) 6);
                networkFetcher$doFetch$fetchResult$3.L$0 = obj;
                return networkFetcher$doFetch$fetchResult$3;
            default:
                NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$4 = new NetworkFetcher$doFetch$fetchResult$1((SyncUtils) this.L$1, (String) this.$snapshot, (String) this.$cacheResponse, (String) obj3, (Function1) obj2, continuation, (byte) 7);
                networkFetcher$doFetch$fetchResult$4.L$0 = obj;
                return networkFetcher$doFetch$fetchResult$4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((NetworkResponse) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 5:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 6:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((NetworkFetcher$doFetch$fetchResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x022b  */
    /* JADX WARN: Code duplicated, block: B:151:0x032c A[DONT_INVERT, PHI: r9
      0x032c: PHI (r9v8 com.metrolist.innertubex.extraction.PoTokenResult) = 
      (r9v22 com.metrolist.innertubex.extraction.PoTokenResult)
      (r9v23 com.metrolist.innertubex.extraction.PoTokenResult)
      (r9v24 com.metrolist.innertubex.extraction.PoTokenResult)
      (r9v25 com.metrolist.innertubex.extraction.PoTokenResult)
      (r9v9 com.metrolist.innertubex.extraction.PoTokenResult)
     binds: [B:134:0x0305, B:142:0x0314, B:147:0x0321, B:149:0x0329, B:150:0x032b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:152:0x032e  */
    /* JADX WARN: Code duplicated, block: B:154:0x033c  */
    /* JADX WARN: Code duplicated, block: B:273:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:93:0x0214  */
    /* JADX WARN: Code duplicated, block: B:95:0x021b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0222  */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0246, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withContext(r2, r3, r18) == r4) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02c6, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r2, r1, null, null, r18, 12) == r10) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x031c, code lost:
    
        if (r2 == r3) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0344, code lost:
    
        if (r0 == r3) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(3000, r18) == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x04d3, code lost:
    
        if (r1 == r10) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
    
        if (com.metrolist.music.ui.screens.AlbumScreenKt.LoginScreen$finalizeLogin(r0, r1, r2, r3, r4, r18) == r10) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014e, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withContext(r0, r1, r18) == r10) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v26 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Exception {
        Object objWriteToDiskCache;
        Ref$ObjectRef ref$ObjectRef;
        Object buffer;
        SourceFetchResult sourceFetchResult;
        NetworkHeaders networkHeaders;
        Function1 function1;
        MutatorMutex.Mutator mutator;
        Mutex mutex;
        MutatorMutex mutatorMutex;
        MutatorMutex mutatorMutex2;
        MutatorMutex.Mutator mutator2;
        Object objInvoke;
        Mutex mutex2;
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        Object objAwait;
        ClientRequestCapabilities clientRequestCapabilities;
        PlaybackClientManifest playbackClientManifest;
        Object poToken;
        Ref$ObjectRef ref$ObjectRefM5m;
        Object objFirst;
        Ref$ObjectRef ref$ObjectRef2;
        Object obj2;
        Ref$ObjectRef ref$ObjectRef3;
        Object objFirst2;
        Ref$ObjectRef ref$ObjectRef4;
        Object obj3;
        AlbumWithSongs albumWithSongs;
        Throwable thM1866exceptionOrNullimpl;
        Object objLoginScreen$extractAuthData;
        String str = 0;
        poTokenResult = null;
        poTokenResult = null;
        poTokenResult = null;
        PoTokenResult poTokenResult = null;
        str = 0;
        switch (this.$r8$classId) {
            case 0:
                DataSource dataSource = DataSource.NETWORK;
                Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) this.$cacheResponse;
                Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.$snapshot;
                NetworkFetcher networkFetcher = (NetworkFetcher) this.this$0;
                NetworkResponse networkResponse = (NetworkResponse) this.L$0;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b = this.label;
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    RealDiskCache.RealSnapshot realSnapshot = (RealDiskCache.RealSnapshot) ref$ObjectRef6.element;
                    NetworkResponse networkResponse2 = (NetworkResponse) ref$ObjectRef5.element;
                    this.L$0 = networkResponse;
                    this.L$1 = ref$ObjectRef6;
                    this.label = (byte) 1;
                    objWriteToDiskCache = networkFetcher.writeToDiskCache(realSnapshot, networkResponse2, networkResponse, this);
                    if (objWriteToDiskCache != coroutineSingletons) {
                        ref$ObjectRef = ref$ObjectRef6;
                    }
                    return coroutineSingletons;
                }
                if (b == 1) {
                    Ref$ObjectRef ref$ObjectRef7 = (Ref$ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    ref$ObjectRef = ref$ObjectRef7;
                    objWriteToDiskCache = obj;
                } else {
                    if (b != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    buffer = obj;
                }
                Buffer buffer2 = (Buffer) buffer;
                if (buffer2.size <= 0) {
                    return null;
                }
                sourceFetchResult = new SourceFetchResult(new SourceImageSource(buffer2, networkFetcher.getFileSystem(), null), NetworkFetcher.getMimeType(networkFetcher.url, networkResponse.headers.get()), dataSource);
                return sourceFetchResult;
                ref$ObjectRef.element = objWriteToDiskCache;
                networkFetcher.getClass();
                NetworkFetcher.throwIfFailureResponseCode(networkResponse);
                Object obj4 = ref$ObjectRef6.element;
                if (obj4 == null) {
                    SourceResponseBody sourceResponseBody = networkResponse.body;
                    if (sourceResponseBody == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("body == null");
                        return null;
                    }
                    this.L$0 = networkResponse;
                    this.L$1 = null;
                    this.label = (byte) 2;
                    buffer = UtilsKt.readBuffer(sourceResponseBody, this);
                    break;
                } else {
                    ref$ObjectRef5.element = networkFetcher.toNetworkResponseOrNull((RealDiskCache.RealSnapshot) obj4);
                    Object obj5 = ref$ObjectRef6.element;
                    obj5.getClass();
                    FileImageSource imageSource = networkFetcher.toImageSource((RealDiskCache.RealSnapshot) obj5);
                    String str2 = networkFetcher.url;
                    NetworkResponse networkResponse3 = (NetworkResponse) ref$ObjectRef5.element;
                    if (networkResponse3 != null && (networkHeaders = networkResponse3.headers) != null) {
                        str = networkHeaders.get();
                    }
                    sourceFetchResult = new SourceFetchResult(imageSource, NetworkFetcher.getMimeType(str2, str), dataSource);
                }
                return sourceFetchResult;
            case 1:
                MutatorMutex mutatorMutex3 = (MutatorMutex) this.this$0;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b2 = this.label;
                try {
                    try {
                        if (b2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            CoroutineContext.Element element = ((CoroutineScope) this.$cacheResponse).getCoroutineContext().get(Job.Key.$$INSTANCE);
                            element.getClass();
                            MutatorMutex.Mutator mutator3 = new MutatorMutex.Mutator((Job) element);
                            AtomicReference atomicReference3 = mutatorMutex3.currentMutator;
                            while (true) {
                                MutatorMutex.Mutator mutator4 = (MutatorMutex.Mutator) atomicReference3.get();
                                if (mutator4 != null) {
                                    MutatePriority mutatePriority = MutatePriority.Default;
                                    if (mutatePriority.compareTo(mutatePriority) < 0) {
                                        throw new CancellationException("Current mutation had a higher priority");
                                    }
                                }
                                while (true) {
                                    if (atomicReference3.compareAndSet(mutator4, mutator3)) {
                                        if (mutator4 != null) {
                                            mutator4.job.cancel(new MutationInterruptedException("Mutation interrupted"));
                                        }
                                        MutexImpl mutexImpl = mutatorMutex3.mutex;
                                        function1 = (Function1) this.$networkRequest;
                                        this.$cacheResponse = mutator3;
                                        this.L$1 = mutexImpl;
                                        this.L$0 = function1;
                                        this.$snapshot = mutatorMutex3;
                                        this.label = (byte) 1;
                                        if (mutexImpl.lock(this) != coroutineSingletons2) {
                                            mutator = mutator3;
                                            mutex = mutexImpl;
                                        }
                                        return coroutineSingletons2;
                                    }
                                    if (atomicReference3.get() != mutator4) {
                                    }
                                }
                            }
                        } else {
                            if (b2 != 1) {
                                if (b2 != 2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                mutatorMutex2 = (MutatorMutex) this.L$0;
                                mutex2 = (Mutex) this.L$1;
                                mutator2 = (MutatorMutex.Mutator) this.$cacheResponse;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objInvoke = obj;
                                    atomicReference2 = mutatorMutex2.currentMutator;
                                    while (!atomicReference2.compareAndSet(mutator2, null) && atomicReference2.get() == mutator2) {
                                    }
                                    mutex2.unlock(null);
                                    return objInvoke;
                                } catch (Throwable th) {
                                    th = th;
                                    atomicReference = mutatorMutex2.currentMutator;
                                    while (!atomicReference.compareAndSet(mutator2, null) && atomicReference.get() == mutator2) {
                                    }
                                    throw th;
                                }
                            }
                            mutatorMutex3 = (MutatorMutex) this.$snapshot;
                            Function1 function2 = (Function1) this.L$0;
                            mutex = (Mutex) this.L$1;
                            MutatorMutex.Mutator mutator5 = (MutatorMutex.Mutator) this.$cacheResponse;
                            ResultKt.throwOnFailure(obj);
                            mutator = mutator5;
                            function1 = function2;
                        }
                        this.$cacheResponse = mutator;
                        this.L$1 = mutex;
                        this.L$0 = mutatorMutex;
                        this.$snapshot = null;
                        this.label = (byte) 2;
                        objInvoke = function1.invoke(this);
                        if (objInvoke != coroutineSingletons2) {
                            mutatorMutex2 = mutatorMutex;
                            mutex2 = mutex;
                            mutator2 = mutator;
                            atomicReference2 = mutatorMutex2.currentMutator;
                            while (!atomicReference2.compareAndSet(mutator2, null)) {
                            }
                            mutex2.unlock(null);
                            return objInvoke;
                        }
                        return coroutineSingletons2;
                    } catch (Throwable th2) {
                        th = th2;
                        mutatorMutex2 = mutatorMutex;
                        mutator2 = mutator;
                        atomicReference = mutatorMutex2.currentMutator;
                        while (!atomicReference.compareAndSet(mutator2, null)) {
                        }
                        throw th;
                    }
                    mutatorMutex = mutatorMutex3;
                } catch (Throwable th3) {
                    "call to 'resume' before 'invoke' with coroutine".unlock(null);
                    throw th3;
                }
                break;
            case 2:
                String str3 = (String) this.L$0;
                SelectedClient selectedClient = (SelectedClient) this.$networkRequest;
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b3 = this.label;
                if (b3 != 0) {
                    if (b3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        objAwait = obj;
                    } else {
                        if (b3 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        poToken = obj;
                    }
                    return (PoTokenResult) poToken;
                }
                ResultKt.throwOnFailure(obj);
                Deferred deferred = (Deferred) this.L$1;
                if (deferred == null) {
                    if (poTokenResult != null) {
                        return poTokenResult;
                    }
                    TokenProvider tokenProvider = ((PlayerClientDirector) this.$snapshot).tokenProvider;
                    String str4 = (String) this.$cacheResponse;
                    playbackClientManifest = selectedClient.manifest;
                    if (playbackClientManifest != null) {
                        ClientRequestCapabilities clientRequestCapabilities2 = playbackClientManifest.request;
                    }
                    this.label = (byte) 2;
                    poToken = tokenProvider.getPoToken(str4, str3, this);
                    break;
                } else {
                    PlaybackClientManifest playbackClientManifest2 = selectedClient.manifest;
                    if (playbackClientManifest2 != null && (clientRequestCapabilities = playbackClientManifest2.request) != null && !clientRequestCapabilities.cookies) {
                        deferred = null;
                    }
                    if (deferred != null) {
                        this.label = (byte) 1;
                        objAwait = deferred.await(this);
                    } else {
                        if (poTokenResult != null) {
                            return poTokenResult;
                        }
                        TokenProvider tokenProvider2 = ((PlayerClientDirector) this.$snapshot).tokenProvider;
                        String str5 = (String) this.$cacheResponse;
                        playbackClientManifest = selectedClient.manifest;
                        if (playbackClientManifest != null) {
                            ClientRequestCapabilities clientRequestCapabilities3 = playbackClientManifest.request;
                        }
                        this.label = (byte) 2;
                        poToken = tokenProvider2.getPoToken(str5, str3, this);
                    }
                    break;
                }
                return coroutineSingletons3;
                PoTokenResult poTokenResult2 = (PoTokenResult) objAwait;
                if (poTokenResult2 != null && Intrinsics.areEqual(poTokenResult2.visitorData, str3)) {
                    poTokenResult = poTokenResult2;
                }
                if (poTokenResult != null) {
                    return poTokenResult;
                }
                TokenProvider tokenProvider3 = ((PlayerClientDirector) this.$snapshot).tokenProvider;
                String str6 = (String) this.$cacheResponse;
                playbackClientManifest = selectedClient.manifest;
                if (playbackClientManifest != null) {
                    ClientRequestCapabilities clientRequestCapabilities4 = playbackClientManifest.request;
                }
                this.label = (byte) 2;
                poToken = tokenProvider3.getPoToken(str6, str3, this);
                break;
                break;
            case 3:
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b4 = this.label;
                Continuation continuation = null;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    QueueKt$Queue$5$1$1 queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1(this.$snapshot, this.$cacheResponse, this.L$0, continuation, (byte) 2);
                    this.label = (byte) 1;
                    if (AwaitKt.coroutineScope(queueKt$Queue$5$1$1, this) != coroutineSingletons4) {
                    }
                    return coroutineSingletons4;
                }
                if (b4 != 1) {
                    if (b4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable = (Animatable) this.L$1;
                        Float f = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                        TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(240, 0, null, 6);
                        this.label = (byte) 3;
                    } else {
                        if (b4 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    break;
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                DialogKt.shown = true;
                ((Function0) ((MutableState) this.$networkRequest).getValue()).invoke();
                return Unit.INSTANCE;
                ((Function0) ((MutableState) this.this$0).getValue()).invoke();
                this.label = (byte) 2;
                if (AwaitKt.delay(420L, this) != coroutineSingletons4) {
                    Animatable animatable2 = (Animatable) this.L$1;
                    Float f2 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    TweenSpec tweenSpecTween$default2 = ArcSplineKt.tween$default(240, 0, null, 6);
                    this.label = (byte) 3;
                    break;
                }
                return coroutineSingletons4;
            case 4:
                MusicDatabase musicDatabase = (MusicDatabase) this.$cacheResponse;
                YTItem yTItem = (YTItem) this.this$0;
                CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b5 = this.label;
                if (b5 == 0) {
                    ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
                    Flow flowAlbumWithSongs = musicDatabase.albumWithSongs(yTItem.getId());
                    this.L$1 = ref$ObjectRefM5m;
                    this.L$0 = ref$ObjectRefM5m;
                    this.label = (byte) 1;
                    objFirst = StateFlowKt.first(flowAlbumWithSongs, this);
                    if (objFirst != coroutineSingletons5) {
                        ref$ObjectRef2 = ref$ObjectRefM5m;
                    }
                    return coroutineSingletons5;
                }
                if (b5 != 1) {
                    if (b5 == 2) {
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        obj2 = ((Result) obj).value;
                        if (!(obj2 instanceof Result.Failure)) {
                            ref$ObjectRef2 = ref$ObjectRef3;
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                            if (thM1866exceptionOrNullimpl != null) {
                                thM1866exceptionOrNullimpl.printStackTrace();
                            }
                            albumWithSongs = (AlbumWithSongs) ref$ObjectRef2.element;
                            if (albumWithSongs != null) {
                                PlayerConnection playerConnection = (PlayerConnection) this.$networkRequest;
                                DefaultScheduler defaultScheduler = Dispatchers.Default;
                                HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
                                DownloadUtil.AnonymousClass2 anonymousClass2 = new DownloadUtil.AnonymousClass2(playerConnection, albumWithSongs, str, (byte) 24);
                                this.L$1 = null;
                                this.L$0 = null;
                                this.$snapshot = null;
                                this.label = (byte) 4;
                            }
                            break;
                        } else {
                            musicDatabase.transaction(new ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0((AlbumPage) obj2, (byte) 0));
                            Flow flowAlbumWithSongs2 = musicDatabase.albumWithSongs(yTItem.getId());
                            this.L$1 = ref$ObjectRef3;
                            this.L$0 = obj2;
                            this.$snapshot = ref$ObjectRef3;
                            this.label = (byte) 3;
                            objFirst2 = StateFlowKt.first(flowAlbumWithSongs2, this);
                            if (objFirst2 != coroutineSingletons5) {
                                ref$ObjectRef4 = ref$ObjectRef3;
                                obj3 = obj2;
                                ref$ObjectRef3.element = objFirst2;
                                obj2 = obj3;
                                ref$ObjectRef2 = ref$ObjectRef4;
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                                if (thM1866exceptionOrNullimpl != null) {
                                    thM1866exceptionOrNullimpl.printStackTrace();
                                }
                                albumWithSongs = (AlbumWithSongs) ref$ObjectRef2.element;
                                if (albumWithSongs != null) {
                                    PlayerConnection playerConnection2 = (PlayerConnection) this.$networkRequest;
                                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                    HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
                                    DownloadUtil.AnonymousClass2 anonymousClass3 = new DownloadUtil.AnonymousClass2(playerConnection2, albumWithSongs, str, (byte) 24);
                                    this.L$1 = null;
                                    this.L$0 = null;
                                    this.$snapshot = null;
                                    this.label = (byte) 4;
                                }
                            }
                            break;
                        }
                        return coroutineSingletons5;
                    }
                    if (b5 == 3) {
                        Ref$ObjectRef ref$ObjectRef8 = (Ref$ObjectRef) this.$snapshot;
                        obj3 = this.L$0;
                        Ref$ObjectRef ref$ObjectRef9 = (Ref$ObjectRef) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        ref$ObjectRef4 = ref$ObjectRef9;
                        ref$ObjectRef3 = ref$ObjectRef8;
                        objFirst2 = obj;
                        ref$ObjectRef3.element = objFirst2;
                        obj2 = obj3;
                        ref$ObjectRef2 = ref$ObjectRef4;
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                        if (thM1866exceptionOrNullimpl != null) {
                            thM1866exceptionOrNullimpl.printStackTrace();
                        }
                        albumWithSongs = (AlbumWithSongs) ref$ObjectRef2.element;
                        if (albumWithSongs != null) {
                            PlayerConnection playerConnection3 = (PlayerConnection) this.$networkRequest;
                            DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                            HandlerContext handlerContext3 = MainDispatcherLoader.dispatcher;
                            DownloadUtil.AnonymousClass2 anonymousClass4 = new DownloadUtil.AnonymousClass2(playerConnection3, albumWithSongs, str, (byte) 24);
                            this.L$1 = null;
                            this.L$0 = null;
                            this.$snapshot = null;
                            this.label = (byte) 4;
                        }
                    } else {
                        if (b5 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    break;
                } else {
                    ref$ObjectRefM5m = (Ref$ObjectRef) this.L$0;
                    Ref$ObjectRef ref$ObjectRef10 = (Ref$ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    ref$ObjectRef2 = ref$ObjectRef10;
                    objFirst = obj;
                }
                return Unit.INSTANCE;
                ref$ObjectRefM5m.element = objFirst;
                AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) ref$ObjectRef2.element;
                List list = albumWithSongs2 != null ? albumWithSongs2.songs : null;
                if (list != null && !list.isEmpty()) {
                    albumWithSongs = (AlbumWithSongs) ref$ObjectRef2.element;
                    if (albumWithSongs != null) {
                        PlayerConnection playerConnection4 = (PlayerConnection) this.$networkRequest;
                        DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                        HandlerContext handlerContext4 = MainDispatcherLoader.dispatcher;
                        DownloadUtil.AnonymousClass2 anonymousClass5 = new DownloadUtil.AnonymousClass2(playerConnection4, albumWithSongs, str, (byte) 24);
                        this.L$1 = null;
                        this.L$0 = null;
                        this.$snapshot = null;
                        this.label = (byte) 4;
                        break;
                    }
                    return Unit.INSTANCE;
                }
                YouTube youTube = YouTube.INSTANCE;
                String id = yTItem.getId();
                this.L$1 = ref$ObjectRef2;
                this.L$0 = null;
                this.label = (byte) 2;
                Object objM996album0E7RQCE = YouTube.INSTANCE.m996album0E7RQCE(id, true, this);
                if (objM996album0E7RQCE != coroutineSingletons5) {
                    obj2 = objM996album0E7RQCE;
                    ref$ObjectRef3 = ref$ObjectRef2;
                    if (!(obj2 instanceof Result.Failure)) {
                        ref$ObjectRef2 = ref$ObjectRef3;
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                        if (thM1866exceptionOrNullimpl != null) {
                            thM1866exceptionOrNullimpl.printStackTrace();
                        }
                        albumWithSongs = (AlbumWithSongs) ref$ObjectRef2.element;
                        if (albumWithSongs != null) {
                            PlayerConnection playerConnection5 = (PlayerConnection) this.$networkRequest;
                            DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                            HandlerContext handlerContext5 = MainDispatcherLoader.dispatcher;
                            DownloadUtil.AnonymousClass2 anonymousClass6 = new DownloadUtil.AnonymousClass2(playerConnection5, albumWithSongs, str, (byte) 24);
                            this.L$1 = null;
                            this.L$0 = null;
                            this.$snapshot = null;
                            this.label = (byte) 4;
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                    musicDatabase.transaction(new ItemsKt$YouTubeGridItem$4$1$1$1$$ExternalSyntheticLambda0((AlbumPage) obj2, (byte) 0));
                    Flow flowAlbumWithSongs3 = musicDatabase.albumWithSongs(yTItem.getId());
                    this.L$1 = ref$ObjectRef3;
                    this.L$0 = obj2;
                    this.$snapshot = ref$ObjectRef3;
                    this.label = (byte) 3;
                    objFirst2 = StateFlowKt.first(flowAlbumWithSongs3, this);
                    if (objFirst2 != coroutineSingletons5) {
                        ref$ObjectRef4 = ref$ObjectRef3;
                        obj3 = obj2;
                        ref$ObjectRef3.element = objFirst2;
                        obj2 = obj3;
                        ref$ObjectRef2 = ref$ObjectRef4;
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                        if (thM1866exceptionOrNullimpl != null) {
                            thM1866exceptionOrNullimpl.printStackTrace();
                        }
                        albumWithSongs = (AlbumWithSongs) ref$ObjectRef2.element;
                        if (albumWithSongs != null) {
                            PlayerConnection playerConnection6 = (PlayerConnection) this.$networkRequest;
                            DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                            HandlerContext handlerContext6 = MainDispatcherLoader.dispatcher;
                            DownloadUtil.AnonymousClass2 anonymousClass7 = new DownloadUtil.AnonymousClass2(playerConnection6, albumWithSongs, str, (byte) 24);
                            this.L$1 = null;
                            this.L$0 = null;
                            this.$snapshot = null;
                            this.label = (byte) 4;
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutineSingletons5;
            case 5:
                CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b6 = this.label;
                if (b6 != 0) {
                    if (b6 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b6 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                MusicDatabase musicDatabase2 = (MusicDatabase) this.$cacheResponse;
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) this.L$0;
                SyncUtils syncUtils = (SyncUtils) this.this$0;
                Playlist playlist = (Playlist) ((MutableState) this.L$1).getValue();
                playlist.getClass();
                List list2 = (List) ((MutableState) this.$snapshot).getValue();
                list2.getClass();
                this.label = (byte) 1;
                if (AlbumMenuKt.AddToPlaylistDialog$addSongsAndSync(musicDatabase2, addToPlaylistPosition, syncUtils, playlist, list2, this) != coroutineSingletons6) {
                }
                return coroutineSingletons6;
                DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                HandlerContext handlerContext7 = MainDispatcherLoader.dispatcher;
                AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2 addToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2 = new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2((Function0) this.$networkRequest, null, (byte) 3);
                this.label = (byte) 2;
                break;
            case 6:
                MutableState mutableState = (MutableState) this.$networkRequest;
                Unit unit = Unit.INSTANCE;
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                CoroutineSingletons coroutineSingletons7 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b7 = this.label;
                if (b7 != 0) {
                    if (b7 == 1) {
                        ResultKt.throwOnFailure(obj);
                        objLoginScreen$extractAuthData = obj;
                    } else {
                        if (b7 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                LoginJsInterface loginJsInterface = (LoginJsInterface) this.$snapshot;
                WebView webView = (WebView) ((MutableState) this.L$1).getValue();
                this.L$0 = coroutineScope;
                this.label = (byte) 1;
                objLoginScreen$extractAuthData = AlbumScreenKt.LoginScreen$extractAuthData(loginJsInterface, webView, this);
                if (objLoginScreen$extractAuthData != coroutineSingletons7) {
                }
                return coroutineSingletons7;
                AuthData authData = (AuthData) objLoginScreen$extractAuthData;
                Context context = (Context) this.$cacheResponse;
                if (authData != null) {
                    MutableState mutableState2 = (MutableState) this.L$1;
                    MutableState mutableState3 = (MutableState) this.this$0;
                    this.L$0 = null;
                    this.label = (byte) 2;
                    break;
                } else {
                    ((MutableState) this.this$0).setValue(context.getString(R.string.authentication_data_extraction_failed));
                    mutableState.setValue(LoginStage.Authenticating);
                }
                return unit;
            default:
                String str7 = (String) this.this$0;
                SyncUtils syncUtils2 = (SyncUtils) this.L$1;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                CoroutineSingletons coroutineSingletons8 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b8 = this.label;
                try {
                    if (b8 != 0) {
                        if (b8 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b8 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    SyncUtils$scheduleRemoveFromPlaylist$1$1 syncUtils$scheduleRemoveFromPlaylist$1$1 = new SyncUtils$scheduleRemoveFromPlaylist$1$1((Function1) this.$networkRequest, coroutineScope2, (String) this.$snapshot, (String) this.$cacheResponse, null);
                    this.L$0 = null;
                    this.label = (byte) 1;
                    int i = SyncUtils.$r8$clinit;
                    if (syncUtils2.runQueuedPlaylistEdit(syncUtils$scheduleRemoveFromPlaylist$1$1, this) == coroutineSingletons8) {
                    }
                    return coroutineSingletons8;
                    this.L$0 = null;
                    this.label = (byte) 2;
                } catch (Exception unused) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                } finally {
                    int i2 = SyncUtils.$r8$clinit;
                    syncUtils2.unmarkPlaylistModifying(str7);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$doFetch$fetchResult$1(MusicDatabase musicDatabase, YTItem yTItem, PlayerConnection playerConnection, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 4;
        this.$cacheResponse = musicDatabase;
        this.this$0 = yTItem;
        this.$networkRequest = playerConnection;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$doFetch$fetchResult$1(MutatorMutex mutatorMutex, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.this$0 = mutatorMutex;
        this.$networkRequest = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkFetcher$doFetch$fetchResult$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$1 = obj;
        this.$snapshot = obj2;
        this.$cacheResponse = obj3;
        this.this$0 = obj4;
        this.$networkRequest = obj5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$doFetch$fetchResult$1(Ref$ObjectRef ref$ObjectRef, NetworkFetcher networkFetcher, Ref$ObjectRef ref$ObjectRef2, NetworkRequest networkRequest, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$snapshot = ref$ObjectRef;
        this.this$0 = networkFetcher;
        this.$cacheResponse = ref$ObjectRef2;
        this.$networkRequest = networkRequest;
    }
}
