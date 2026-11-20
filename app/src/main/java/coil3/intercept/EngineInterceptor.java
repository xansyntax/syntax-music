package coil3.intercept;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.BitmapImage;
import coil3.ComponentRegistry;
import coil3.EventListener$Companion$NONE$1;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.fetch.FetchResult;
import coil3.fetch.ImageFetchResult;
import coil3.fetch.SourceFetchResult;
import coil3.map.FileMapper;
import coil3.memory.MemoryCache$Key;
import coil3.memory.MemoryCache$Value;
import coil3.network.HttpException;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.SuccessResult;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import com.google.common.base.Splitter;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.extraction.PlayerClientDirector;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.PlayerConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KClass;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EngineInterceptor {
    public final RealImageLoader imageLoader;
    public final ConnectionPool memoryCacheService;
    public final Splitter requestService;
    public final Cache.RealCacheRequest systemCallbacks;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExecuteResult {
        public final DataSource dataSource;
        public final String diskCacheKey;
        public final Image image;
        public final boolean isSampled;

        public ExecuteResult(Image image, boolean z, DataSource dataSource, String str) {
            this.image = image;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExecuteResult)) {
                return false;
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            return Intrinsics.areEqual(this.image, executeResult.image) && this.isSampled == executeResult.isSampled && this.dataSource == executeResult.dataSource && Intrinsics.areEqual(this.diskCacheKey, executeResult.diskCacheKey);
        }

        public final int hashCode() {
            int iHashCode = (this.dataSource.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.image.hashCode() * 31, this.isSampled, 31)) * 31;
            String str = this.diskCacheKey;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return "ExecuteResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ", diskCacheKey=" + this.diskCacheKey + ")";
        }
    }

    /* JADX INFO: renamed from: coil3.intercept.EngineInterceptor$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public SourceFetchResult L$0;
        public ComponentRegistry L$1;
        public ImageRequest L$2;
        public Object L$3;
        public Options L$4;
        public EventListener$Companion$NONE$1 L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.decode(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.intercept.EngineInterceptor$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00521 extends ContinuationImpl {
        public ImageRequest L$0;
        public Object L$1;
        public EventListener$Companion$NONE$1 L$3;
        public Ref$ObjectRef L$4;
        public Ref$ObjectRef L$5;
        public Ref$ObjectRef L$6;
        public Ref$ObjectRef L$7;
        public int label;
        public /* synthetic */ Object result;

        public C00521(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.execute(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.intercept.EngineInterceptor$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00531 extends ContinuationImpl {
        public int I$0;
        public ComponentRegistry L$0;
        public ImageRequest L$1;
        public Object L$2;
        public Options L$3;
        public EventListener$Companion$NONE$1 L$4;
        public int label;
        public /* synthetic */ Object result;

        public C00531(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.fetch(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.intercept.EngineInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00541 extends ContinuationImpl {
        public RealInterceptorChain L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00541(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    public EngineInterceptor(RealImageLoader realImageLoader, Cache.RealCacheRequest realCacheRequest, Splitter splitter) {
        this.imageLoader = realImageLoader;
        this.systemCallbacks = realCacheRequest;
        this.requestService = splitter;
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.delegate = realImageLoader;
        this.memoryCacheService = connectionPool;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x0070 A[LOOP:0: B:16:0x0050->B:20:0x0070, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009f -> B:27:0x00a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object decode(coil3.fetch.SourceFetchResult r6, coil3.ComponentRegistry r7, coil3.request.ImageRequest r8, java.lang.Object r9, coil3.request.Options r10, coil3.EventListener$Companion$NONE$1 r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.decode(coil3.fetch.SourceFetchResult, coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener$Companion$NONE$1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0118  */
    /* JADX WARN: Code duplicated, block: B:50:0x011b  */
    /* JADX WARN: Code duplicated, block: B:52:0x011e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0163  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0140, code lost:
    
        if (r1 == r12) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1, ContinuationImpl continuationImpl) throws Throwable {
        C00521 c00521;
        SourceFetchResult sourceFetchResult;
        ImageSource imageSource;
        Ref$ObjectRef ref$ObjectRef;
        ImageRequest imageRequest2;
        Object obj2;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$ObjectRef ref$ObjectRef4;
        EventListener$Companion$NONE$1 eventListener$Companion$NONE$2;
        Ref$ObjectRef ref$ObjectRef5;
        ExecuteResult executeResult;
        Ref$ObjectRef ref$ObjectRef6;
        EventListener$Companion$NONE$1 eventListener$Companion$NONE$3;
        Object obj3;
        SourceFetchResult sourceFetchResult2;
        ImageSource imageSource2;
        if (continuationImpl instanceof C00521) {
            c00521 = (C00521) continuationImpl;
            int i = c00521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00521.label = i - Integer.MIN_VALUE;
            } else {
                c00521 = new C00521(continuationImpl);
            }
        } else {
            c00521 = new C00521(continuationImpl);
        }
        C00521 c00522 = c00521;
        Object objFetch = c00522.result;
        Ref$ObjectRef ref$ObjectRef7 = c00522.label;
        Object obj4 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (ref$ObjectRef7 == 0) {
                Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(objFetch);
                ref$ObjectRefM5m.element = options;
                ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = this.imageLoader.components;
                Ref$ObjectRef ref$ObjectRef8 = new Ref$ObjectRef();
                try {
                    ref$ObjectRefM5m.element = this.requestService.updateOptions((Options) ref$ObjectRefM5m.element);
                    imageRequest.getClass();
                    ComponentRegistry componentRegistry = (ComponentRegistry) ref$ObjectRef.element;
                    Options options2 = (Options) ref$ObjectRefM5m.element;
                    c00522.L$0 = imageRequest;
                    c00522.L$1 = obj;
                    c00522.L$3 = eventListener$Companion$NONE$1;
                    c00522.L$4 = ref$ObjectRefM5m;
                    c00522.L$5 = ref$ObjectRef;
                    c00522.L$6 = ref$ObjectRef8;
                    c00522.L$7 = ref$ObjectRef8;
                    c00522.label = 1;
                    objFetch = fetch(componentRegistry, imageRequest, obj, options2, eventListener$Companion$NONE$1, c00522);
                    if (objFetch != obj4) {
                        imageRequest2 = imageRequest;
                        obj2 = obj;
                        ref$ObjectRef2 = ref$ObjectRefM5m;
                        ref$ObjectRef3 = ref$ObjectRef8;
                        ref$ObjectRef4 = ref$ObjectRef3;
                        eventListener$Companion$NONE$2 = eventListener$Companion$NONE$1;
                    }
                    return obj4;
                } catch (Throwable th) {
                    th = th;
                    ref$ObjectRef7 = ref$ObjectRef8;
                    Object obj5 = ref$ObjectRef7.element;
                    if (obj5 instanceof SourceFetchResult) {
                    }
                    if (sourceFetchResult != null) {
                        Format$$ExternalSyntheticOutline0.m(imageSource);
                    }
                    throw th;
                }
            }
            if (ref$ObjectRef7 == 1) {
                ref$ObjectRef3 = c00522.L$7;
                ref$ObjectRef4 = c00522.L$6;
                Ref$ObjectRef ref$ObjectRef9 = c00522.L$5;
                Ref$ObjectRef ref$ObjectRef10 = c00522.L$4;
                eventListener$Companion$NONE$2 = c00522.L$3;
                Object obj6 = c00522.L$1;
                ImageRequest imageRequest3 = c00522.L$0;
                try {
                    ResultKt.throwOnFailure(objFetch);
                    ref$ObjectRef2 = ref$ObjectRef10;
                    obj2 = obj6;
                    ref$ObjectRef = ref$ObjectRef9;
                    imageRequest2 = imageRequest3;
                } catch (Throwable th2) {
                    th = th2;
                    ref$ObjectRef7 = ref$ObjectRef4;
                    Object obj7 = ref$ObjectRef7.element;
                    sourceFetchResult = obj7 instanceof SourceFetchResult ? (SourceFetchResult) obj7 : null;
                    if (sourceFetchResult != null && (imageSource = sourceFetchResult.source) != null) {
                        try {
                            Format$$ExternalSyntheticOutline0.m(imageSource);
                        } catch (RuntimeException e) {
                            throw e;
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } else if (ref$ObjectRef7 == 2) {
                ref$ObjectRef5 = c00522.L$6;
                ref$ObjectRef6 = c00522.L$4;
                eventListener$Companion$NONE$3 = c00522.L$3;
                imageRequest2 = c00522.L$0;
                ResultKt.throwOnFailure(objFetch);
                c00522 = c00522;
                executeResult = (ExecuteResult) objFetch;
                ref$ObjectRef2 = ref$ObjectRef6;
                eventListener$Companion$NONE$2 = eventListener$Companion$NONE$3;
                obj3 = ref$ObjectRef5.element;
                if (obj3 instanceof SourceFetchResult) {
                    sourceFetchResult2 = (SourceFetchResult) obj3;
                } else {
                    sourceFetchResult2 = null;
                }
                if (sourceFetchResult2 != null && (imageSource2 = sourceFetchResult2.source) != null) {
                    try {
                        Format$$ExternalSyntheticOutline0.m(imageSource2);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                Options options3 = (Options) ref$ObjectRef2.element;
                c00522.L$0 = null;
                c00522.L$1 = null;
                c00522.L$3 = null;
                c00522.L$4 = null;
                c00522.L$5 = null;
                c00522.L$6 = null;
                c00522.L$7 = null;
                c00522.label = 3;
                objFetch = FileSystemsKt.transform(executeResult, imageRequest2, options3, eventListener$Companion$NONE$2, c00522);
            } else {
                if (ref$ObjectRef7 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objFetch);
            }
            ExecuteResult executeResult2 = (ExecuteResult) objFetch;
            Image image = executeResult2.image;
            Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
            if (image instanceof BitmapImage) {
                ((BitmapImage) image).bitmap.prepareToDraw();
            }
            return executeResult2;
            ref$ObjectRef3.element = objFetch;
            Object obj8 = ref$ObjectRef4.element;
            FetchResult fetchResult = (FetchResult) obj8;
            if (fetchResult instanceof SourceFetchResult) {
                CoroutineContext coroutineContext = imageRequest2.decoderCoroutineContext;
                ref$ObjectRef5 = ref$ObjectRef4;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, ref$ObjectRef5, ref$ObjectRef, imageRequest2, obj2, ref$ObjectRef2, eventListener$Companion$NONE$2, null);
                c00522.L$0 = imageRequest2;
                c00522.L$1 = null;
                c00522.L$3 = eventListener$Companion$NONE$2;
                c00522.L$4 = ref$ObjectRef2;
                c00522.L$5 = null;
                c00522.L$6 = ref$ObjectRef5;
                c00522.L$7 = null;
                c00522.label = 2;
                objFetch = AwaitKt.withContext(coroutineContext, anonymousClass2, c00522);
                if (objFetch != obj4) {
                    ref$ObjectRef6 = ref$ObjectRef2;
                    eventListener$Companion$NONE$3 = eventListener$Companion$NONE$2;
                    executeResult = (ExecuteResult) objFetch;
                    ref$ObjectRef2 = ref$ObjectRef6;
                    eventListener$Companion$NONE$2 = eventListener$Companion$NONE$3;
                    obj3 = ref$ObjectRef5.element;
                    if (obj3 instanceof SourceFetchResult) {
                        sourceFetchResult2 = (SourceFetchResult) obj3;
                    } else {
                        sourceFetchResult2 = null;
                    }
                    if (sourceFetchResult2 != null) {
                        Format$$ExternalSyntheticOutline0.m(imageSource2);
                    }
                    Options options4 = (Options) ref$ObjectRef2.element;
                    c00522.L$0 = null;
                    c00522.L$1 = null;
                    c00522.L$3 = null;
                    c00522.L$4 = null;
                    c00522.L$5 = null;
                    c00522.L$6 = null;
                    c00522.L$7 = null;
                    c00522.label = 3;
                    objFetch = FileSystemsKt.transform(executeResult, imageRequest2, options4, eventListener$Companion$NONE$2, c00522);
                }
            } else {
                ref$ObjectRef5 = ref$ObjectRef4;
                if (!(fetchResult instanceof ImageFetchResult)) {
                    throw new HttpException();
                }
                executeResult = new ExecuteResult(((ImageFetchResult) obj8).image, ((ImageFetchResult) obj8).isSampled, ((ImageFetchResult) obj8).dataSource, null);
                obj3 = ref$ObjectRef5.element;
                if (obj3 instanceof SourceFetchResult) {
                    sourceFetchResult2 = (SourceFetchResult) obj3;
                } else {
                    sourceFetchResult2 = null;
                }
                if (sourceFetchResult2 != null) {
                    Format$$ExternalSyntheticOutline0.m(imageSource2);
                }
                Options options5 = (Options) ref$ObjectRef2.element;
                c00522.L$0 = null;
                c00522.L$1 = null;
                c00522.L$3 = null;
                c00522.L$4 = null;
                c00522.L$5 = null;
                c00522.L$6 = null;
                c00522.L$7 = null;
                c00522.label = 3;
                objFetch = FileSystemsKt.transform(executeResult, imageRequest2, options5, eventListener$Companion$NONE$2, c00522);
            }
            return obj4;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0070  */
    /* JADX WARN: Code duplicated, block: B:25:0x008b  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:52:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x007b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00af -> B:28:0x00b2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetch(coil3.ComponentRegistry r8, coil3.request.ImageRequest r9, java.lang.Object r10, coil3.request.Options r11, coil3.EventListener$Companion$NONE$1 r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.fetch(coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener$Companion$NONE$1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final Object intercept(RealInterceptorChain realInterceptorChain, ContinuationImpl continuationImpl) {
        C00541 c00541;
        RealInterceptorChain realInterceptorChain2 = realInterceptorChain;
        ConnectionPool connectionPool = this.memoryCacheService;
        if (continuationImpl instanceof C00541) {
            c00541 = (C00541) continuationImpl;
            int i = c00541.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00541.label = i - Integer.MIN_VALUE;
            } else {
                c00541 = new C00541(continuationImpl);
            }
        } else {
            c00541 = new C00541(continuationImpl);
        }
        C00541 c00542 = c00541;
        Object obj = c00542.result;
        int i2 = c00542.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ImageRequest imageRequest = (ImageRequest) realInterceptorChain2.request;
                Object obj2 = imageRequest.data;
                Size size = (Size) realInterceptorChain2.size;
                EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = (EventListener$Companion$NONE$1) realInterceptorChain2.eventListener;
                Options options = this.requestService.options(imageRequest, size);
                Scale scale = options.scale;
                List list = this.imageLoader.components.mappers;
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Pair pair = (Pair) list.get(i3);
                    FileMapper fileMapper = (FileMapper) pair.first;
                    if (((KClass) pair.second).isInstance(obj2)) {
                        fileMapper.getClass();
                        Uri map = fileMapper.map(obj2, options);
                        if (map != null) {
                            obj2 = map;
                        }
                    }
                }
                MemoryCache$Key memoryCache$KeyNewCacheKey = connectionPool.newCacheKey(imageRequest, obj2, options, eventListener$Companion$NONE$1);
                MemoryCache$Value cacheValue = memoryCache$KeyNewCacheKey != null ? connectionPool.getCacheValue(imageRequest, memoryCache$KeyNewCacheKey, size, scale) : null;
                if (cacheValue == null) {
                    CoroutineContext coroutineContext = imageRequest.fetcherCoroutineContext;
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, imageRequest, obj2, options, eventListener$Companion$NONE$1, memoryCache$KeyNewCacheKey, realInterceptorChain2, null, (byte) 0);
                    c00542.L$0 = realInterceptorChain2;
                    c00542.label = 1;
                    Object objWithContext = AwaitKt.withContext(coroutineContext, anonymousClass2, c00542);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    return objWithContext == coroutineSingletons ? coroutineSingletons : objWithContext;
                }
                Map map2 = cacheValue.extras;
                Image image = cacheValue.image;
                DataSource dataSource = DataSource.MEMORY_CACHE;
                Object obj3 = map2.get("coil#disk_cache_key");
                String str = obj3 instanceof String ? (String) obj3 : null;
                Object obj4 = map2.get("coil#is_sampled");
                Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
                return new SuccessResult(image, imageRequest, dataSource, memoryCache$KeyNewCacheKey, str, bool != null ? bool.booleanValue() : false, realInterceptorChain2.isPlaceholderCached);
            } catch (Throwable th) {
                th = th;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            RealInterceptorChain realInterceptorChain3 = c00542.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (Throwable th2) {
                th = th2;
                realInterceptorChain2 = realInterceptorChain3;
            }
        }
        if (th instanceof CancellationException) {
            throw th;
        }
        return UtilsKt.ErrorResult((ImageRequest) realInterceptorChain2.request, th);
    }

    /* JADX INFO: renamed from: coil3.intercept.EngineInterceptor$intercept$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $cacheKey;
        public final /* synthetic */ Object $chain;
        public final /* synthetic */ Object $eventListener;
        public /* synthetic */ Object $mappedData;
        public final /* synthetic */ Object $options;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object $request;
        public boolean label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(EngineInterceptor engineInterceptor, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, ImageRequest imageRequest, Object obj, Ref$ObjectRef ref$ObjectRef3, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 1;
            this.this$0 = engineInterceptor;
            this.$options = ref$ObjectRef;
            this.$cacheKey = ref$ObjectRef2;
            this.$request = imageRequest;
            this.$mappedData = obj;
            this.$chain = ref$ObjectRef3;
            this.$eventListener = eventListener$Companion$NONE$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$chain;
            Object obj3 = this.$cacheKey;
            Object obj4 = this.$eventListener;
            Object obj5 = this.$options;
            Object obj6 = this.$request;
            Object obj7 = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((EngineInterceptor) obj7, (ImageRequest) obj6, this.$mappedData, (Options) obj5, (EventListener$Companion$NONE$1) obj4, (MemoryCache$Key) obj3, (RealInterceptorChain) obj2, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2((EngineInterceptor) obj7, (Ref$ObjectRef) obj5, (Ref$ObjectRef) obj3, (ImageRequest) obj6, this.$mappedData, (Ref$ObjectRef) obj2, (EventListener$Companion$NONE$1) obj4, continuation);
                case 2:
                    return new AnonymousClass2((PlayerClientDirector) obj7, (YouTubeClient) obj6, (String) this.$mappedData, (Integer) obj5, (String) obj4, (InnerTube.SessionSnapshot) obj3, (String) obj2, continuation, (byte) 2);
                case 3:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((PlayerConnection) obj7, (MutableState) obj6, (MutableState) obj5, (MutableState) obj4, (ParcelableSnapshotMutableLongState) obj3, (ParcelableSnapshotMutableLongState) obj2, continuation);
                    anonymousClass2.$mappedData = obj;
                    return anonymousClass2;
                default:
                    return new AnonymousClass2((MutableState) obj7, (Playlist) obj6, (MutableState) this.$mappedData, (Ref$BooleanRef) obj5, (MusicDatabase) obj4, (Context) obj3, (SnackbarHostState) obj2, continuation, (byte) 4);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:36:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:38:0x00e7  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00af -> B:31:0x00b3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 678
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PlayerConnection playerConnection, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 3;
            this.this$0 = playerConnection;
            this.$request = mutableState;
            this.$options = mutableState2;
            this.$eventListener = mutableState3;
            this.$cacheKey = parcelableSnapshotMutableLongState;
            this.$chain = parcelableSnapshotMutableLongState2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$request = obj2;
            this.$mappedData = obj3;
            this.$options = obj4;
            this.$eventListener = obj5;
            this.$cacheKey = obj6;
            this.$chain = obj7;
        }
    }
}
