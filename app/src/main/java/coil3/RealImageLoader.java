package coil3;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
import androidx.compose.material3.FloatingActionButtonElevationAnimatable;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.datastore.core.DataStoreImpl;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.lifecycle.Lifecycle;
import androidx.media3.extractor.flv.TagPayloadReader;
import androidx.room.coroutines.Pool;
import coil3.RealImageLoader;
import coil3.decode.BitmapFactoryDecoder;
import coil3.decode.ExifOrientationStrategy$$ExternalSyntheticLambda0;
import coil3.decode.StaticImageDecoder;
import coil3.fetch.BitmapFetcher;
import coil3.intercept.EngineInterceptor;
import coil3.key.UriKeyer;
import coil3.map.FileMapper;
import coil3.memory.RealMemoryCache;
import coil3.memory.RealStrongMemoryCache$cache$1;
import coil3.network.HttpException;
import coil3.request.BaseRequestDelegate;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.LifecycleRequestDelegate;
import coil3.request.NullRequestData;
import coil3.request.NullRequestDataException;
import coil3.request.RequestDelegate;
import coil3.request.SuccessResult;
import coil3.request.ViewTargetRequestDelegate;
import coil3.size.Precision;
import coil3.size.RealViewSizeResolver;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.target.GenericViewTarget;
import coil3.target.Target;
import coil3.transition.NoneTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import coil3.util.AndroidSystemCallbacks$ActivityCallbacks;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.google.common.base.Splitter;
import com.google.common.math.IntMath;
import com.metrolist.innertubex.InnerTube$feedback$2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Cache;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ComponentRegistry components;
    public final Options options;
    public final Splitter requestService;
    public final ContextScope scope;
    public volatile /* synthetic */ int shutdown$volatile;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Options {
        public final Context application;
        public final ComponentRegistry componentRegistry;
        public final ImageRequest.Defaults defaults;
        public final Lazy diskCacheLazy;
        public final SynchronizedLazyImpl mainCoroutineContextLazy;
        public final SynchronizedLazyImpl memoryCacheLazy;

        public Options(Context context, ImageRequest.Defaults defaults, SynchronizedLazyImpl synchronizedLazyImpl, SynchronizedLazyImpl synchronizedLazyImpl2, Lazy lazy, ComponentRegistry componentRegistry) {
            this.application = context;
            this.defaults = defaults;
            this.mainCoroutineContextLazy = synchronizedLazyImpl;
            this.memoryCacheLazy = synchronizedLazyImpl2;
            this.diskCacheLazy = lazy;
            this.componentRegistry = componentRegistry;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Options) {
                Options options = (Options) obj;
                return Intrinsics.areEqual(this.application, options.application) && this.defaults.equals(options.defaults) && this.mainCoroutineContextLazy == options.mainCoroutineContextLazy && this.memoryCacheLazy == options.memoryCacheLazy && this.diskCacheLazy.equals(options.diskCacheLazy) && this.componentRegistry == options.componentRegistry;
            }
            return false;
        }

        public final int hashCode() {
            return (this.componentRegistry.hashCode() + ((EventListener$Factory$$ExternalSyntheticLambda0.NONE.hashCode() + ((this.diskCacheLazy.hashCode() + ((this.memoryCacheLazy.hashCode() + ((this.mainCoroutineContextLazy.hashCode() + ((this.defaults.hashCode() + (this.application.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        }

        public final String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", mainCoroutineContextLazy=" + this.mainCoroutineContextLazy + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + EventListener$Factory$$ExternalSyntheticLambda0.NONE + ", componentRegistry=" + this.componentRegistry + ", logger=null)";
        }
    }

    /* JADX INFO: renamed from: coil3.RealImageLoader$execute$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends ContinuationImpl {
        public int I$0;
        public RequestDelegate L$1;
        public ImageRequest L$2;
        public EventListener$Companion$NONE$1 L$3;
        public Image L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.this.execute(null, 0, this);
        }
    }

    static {
        AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "shutdown$volatile");
    }

    public RealImageLoader(Options options) {
        this.options = options;
        byte b = 0;
        this.scope = AwaitKt.CoroutineScope(StringsKt__IndentKt.plus(AwaitKt.SupervisorJob$default(), new RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE, b)));
        final Cache.RealCacheRequest realCacheRequest = new Cache.RealCacheRequest();
        realCacheRequest.editor = new WeakReference(this);
        realCacheRequest.cacheOut = new AndroidSystemCallbacks$ActivityCallbacks(realCacheRequest, this);
        realCacheRequest.body = new ComponentCallbacks2() { // from class: coil3.util.AndroidSystemCallbacks$ComponentCallbacks
            @Override // android.content.ComponentCallbacks
            public final void onConfigurationChanged(Configuration configuration) {
                Cache.RealCacheRequest realCacheRequest2 = realCacheRequest;
                synchronized (realCacheRequest2) {
                    if (((RealImageLoader) ((WeakReference) realCacheRequest2.editor).get()) == null) {
                        realCacheRequest2.shutdown();
                    }
                }
            }

            @Override // android.content.ComponentCallbacks
            public final void onLowMemory() {
                onTrimMemory(80);
            }

            @Override // android.content.ComponentCallbacks2
            public final void onTrimMemory(int i) {
                RealMemoryCache memoryCache;
                long size;
                Cache.RealCacheRequest realCacheRequest2 = realCacheRequest;
                synchronized (realCacheRequest2) {
                    try {
                        RealImageLoader realImageLoader = (RealImageLoader) ((WeakReference) realCacheRequest2.editor).get();
                        if (realImageLoader != null) {
                            RealImageLoader.Options options2 = realImageLoader.options;
                            if (i >= 40) {
                                RealMemoryCache memoryCache2 = realImageLoader.getMemoryCache();
                                if (memoryCache2 != null) {
                                    synchronized (memoryCache2.lock) {
                                        ((RealStrongMemoryCache$cache$1) memoryCache2.strongMemoryCache.cache).trimToSize(-1L);
                                        PriorityQueue priorityQueue = memoryCache2.weakMemoryCache;
                                        priorityQueue.size = 0;
                                        ((LinkedHashMap) priorityQueue.array).clear();
                                    }
                                }
                            } else if (i >= 20) {
                                ((AndroidSystemCallbacks$ActivityCallbacks) realCacheRequest2.cacheOut).register(options2.application);
                            } else if (i >= 10 && (memoryCache = realImageLoader.getMemoryCache()) != null) {
                                synchronized (memoryCache.lock) {
                                    size = ((RealStrongMemoryCache$cache$1) memoryCache.strongMemoryCache.cache).getSize();
                                }
                                long j = size / 2;
                                synchronized (memoryCache.lock) {
                                    ((RealStrongMemoryCache$cache$1) memoryCache.strongMemoryCache.cache).trimToSize(j);
                                }
                            }
                        } else {
                            realCacheRequest2.shutdown();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        Splitter splitter = new Splitter(this);
        this.requestService = splitter;
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(options.componentRegistry);
        ArrayList arrayList = (ArrayList) imageLoader$Builder.application;
        ArrayList arrayList2 = (ArrayList) imageLoader$Builder.diskCacheLazy;
        ArrayList arrayList3 = (ArrayList) imageLoader$Builder.memoryCacheLazy;
        ArrayList arrayList4 = (ArrayList) imageLoader$Builder.extras;
        ImageRequest.Defaults defaults = options.defaults;
        Object obj = defaults.extras.data.get(UriKt.serviceLoaderEnabledKey);
        byte b2 = 3;
        if (((Boolean) (obj == null ? Boolean.TRUE : obj)).booleanValue()) {
            arrayList2.add(new RealImageLoaderKt$$ExternalSyntheticLambda0(b));
            arrayList4.add(new RealImageLoaderKt$$ExternalSyntheticLambda0(b2));
        }
        byte b3 = 1;
        imageLoader$Builder.add(new FileMapper(b3), Reflection.getOrCreateKotlinClass(android.net.Uri.class));
        imageLoader$Builder.add(new FileMapper(b2), Reflection.getOrCreateKotlinClass(Integer.class));
        arrayList3.add(new Pair(new UriKeyer((byte) 1), Reflection.getOrCreateKotlinClass(Uri.class)));
        imageLoader$Builder.add(new BitmapFetcher.Factory(b3), Reflection.getOrCreateKotlinClass(Uri.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 4), Reflection.getOrCreateKotlinClass(Uri.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 9), Reflection.getOrCreateKotlinClass(Uri.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 6), Reflection.getOrCreateKotlinClass(Drawable.class));
        Extras.Key key = ImageLoaders_androidKt.bitmapFactoryMaxParallelismKey;
        Object obj2 = defaults.extras.data.get(ImageLoaders_androidKt.bitmapFactoryMaxParallelismKey);
        int iIntValue = ((Number) (obj2 == null ? 4 : obj2)).intValue();
        int i = SemaphoreKt.MAX_SPIN_CYCLES;
        SemaphoreImpl semaphoreImpl = new SemaphoreImpl(iIntValue);
        int i2 = Build.VERSION.SDK_INT;
        Object obj3 = ExifOrientationStrategy$$ExternalSyntheticLambda0.RESPECT_PERFORMANCE;
        if (i2 >= 29) {
            Object obj4 = defaults.extras.data.get(ImageLoaders_androidKt.imageDecoderEnabledKey);
            if (((Boolean) (obj4 == null ? Boolean.TRUE : obj4)).booleanValue()) {
                Object obj5 = defaults.extras.data.get(ImageLoaders_androidKt.bitmapFactoryExifOrientationStrategyKey);
                if (((ExifOrientationStrategy$$ExternalSyntheticLambda0) (obj5 == null ? obj3 : obj5)).equals(obj3)) {
                    arrayList4.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda1(new StaticImageDecoder.Factory(semaphoreImpl), b3));
                }
            }
        }
        Object obj6 = defaults.extras.data.get(ImageLoaders_androidKt.bitmapFactoryExifOrientationStrategyKey);
        arrayList4.add(new ComponentRegistry$Builder$$ExternalSyntheticLambda1(new BitmapFactoryDecoder.Factory(semaphoreImpl, (ExifOrientationStrategy$$ExternalSyntheticLambda0) (obj6 != null ? obj6 : obj3)), b3));
        imageLoader$Builder.add(new FileMapper(b), Reflection.getOrCreateKotlinClass(File.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 8), Reflection.getOrCreateKotlinClass(Uri.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 3), Reflection.getOrCreateKotlinClass(ByteBuffer.class));
        imageLoader$Builder.add(new FileMapper((byte) 4), Reflection.getOrCreateKotlinClass(String.class));
        byte b4 = 2;
        imageLoader$Builder.add(new FileMapper(b4), Reflection.getOrCreateKotlinClass(Path.class));
        arrayList3.add(new Pair(new UriKeyer((byte) 2), Reflection.getOrCreateKotlinClass(Uri.class)));
        arrayList3.add(new Pair(new UriKeyer((byte) 0), Reflection.getOrCreateKotlinClass(Uri.class)));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 7), Reflection.getOrCreateKotlinClass(Uri.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory(b4), Reflection.getOrCreateKotlinClass(byte[].class));
        imageLoader$Builder.add(new BitmapFetcher.Factory((byte) 5), Reflection.getOrCreateKotlinClass(Uri.class));
        imageLoader$Builder.add(new BitmapFetcher.Factory(b), Reflection.getOrCreateKotlinClass(Bitmap.class));
        arrayList.add(new EngineInterceptor(this, realCacheRequest, splitter));
        this.components = new ComponentRegistry(IntMath.toImmutableList(arrayList), IntMath.toImmutableList((ArrayList) imageLoader$Builder.defaults), IntMath.toImmutableList(arrayList3), IntMath.toImmutableList(arrayList2), IntMath.toImmutableList(arrayList4));
    }

    /* JADX WARN: Code duplicated, block: B:106:0x017d  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b4 A[Catch: all -> 0x003f, TryCatch #5 {all -> 0x003f, blocks: (B:15:0x003a, B:135:0x0215, B:137:0x021b, B:138:0x0224, B:140:0x0228, B:143:0x0234, B:144:0x0239, B:28:0x006a, B:119:0x01ad, B:121:0x01b4, B:123:0x01be, B:124:0x01c8, B:125:0x01cb), top: B:170:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01be A[Catch: all -> 0x003f, TryCatch #5 {all -> 0x003f, blocks: (B:15:0x003a, B:135:0x0215, B:137:0x021b, B:138:0x0224, B:140:0x0228, B:143:0x0234, B:144:0x0239, B:28:0x006a, B:119:0x01ad, B:121:0x01b4, B:123:0x01be, B:124:0x01c8, B:125:0x01cb), top: B:170:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:134:0x0211  */
    /* JADX WARN: Code duplicated, block: B:137:0x021b A[Catch: all -> 0x003f, TryCatch #5 {all -> 0x003f, blocks: (B:15:0x003a, B:135:0x0215, B:137:0x021b, B:138:0x0224, B:140:0x0228, B:143:0x0234, B:144:0x0239, B:28:0x006a, B:119:0x01ad, B:121:0x01b4, B:123:0x01be, B:124:0x01c8, B:125:0x01cb), top: B:170:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0224 A[Catch: all -> 0x003f, TryCatch #5 {all -> 0x003f, blocks: (B:15:0x003a, B:135:0x0215, B:137:0x021b, B:138:0x0224, B:140:0x0228, B:143:0x0234, B:144:0x0239, B:28:0x006a, B:119:0x01ad, B:121:0x01b4, B:123:0x01be, B:124:0x01c8, B:125:0x01cb), top: B:170:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0228 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #5 {all -> 0x003f, blocks: (B:15:0x003a, B:135:0x0215, B:137:0x021b, B:138:0x0224, B:140:0x0228, B:143:0x0234, B:144:0x0239, B:28:0x006a, B:119:0x01ad, B:121:0x01b4, B:123:0x01be, B:124:0x01c8, B:125:0x01cb), top: B:170:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0234 A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #5 {all -> 0x003f, blocks: (B:15:0x003a, B:135:0x0215, B:137:0x021b, B:138:0x0224, B:140:0x0228, B:143:0x0234, B:144:0x0239, B:28:0x006a, B:119:0x01ad, B:121:0x01b4, B:123:0x01be, B:124:0x01c8, B:125:0x01cb), top: B:170:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:153:0x024e A[Catch: all -> 0x025b, TRY_LEAVE, TryCatch #2 {all -> 0x025b, blocks: (B:151:0x024a, B:153:0x024e, B:158:0x025d, B:159:0x0263), top: B:165:0x024a }] */
    /* JADX WARN: Code duplicated, block: B:158:0x025d A[Catch: all -> 0x025b, TRY_ENTER, TryCatch #2 {all -> 0x025b, blocks: (B:151:0x024a, B:153:0x024e, B:158:0x025d, B:159:0x0263), top: B:165:0x024a }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01a4, code lost:
    
        if (r1.awaitStarted(r9) == r14) goto L133;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [coil3.RealImageLoader, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25, types: [coil3.request.ImageRequest, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v15, types: [coil3.EventListener$Companion$NONE$1] */
    /* JADX WARN: Type inference failed for: r3v17, types: [coil3.EventListener$Companion$NONE$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v18, types: [coil3.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [coil3.EventListener$Companion$NONE$1] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v4, types: [coil3.EventListener$Companion$NONE$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13, types: [coil3.request.ImageRequest, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [coil3.EventListener$Companion$NONE$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18, types: [coil3.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r4v2, types: [coil3.request.ImageRequest, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v9, types: [coil3.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r5v0, types: [coil3.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r5v1, types: [coil3.request.RequestDelegate] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r6v13, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r6v8, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, int i, Continuation continuation) {
        AnonymousClass3 anonymousClass3;
        ?? Build;
        RequestDelegate lifecycleRequestDelegate;
        SizeResolver realViewSizeResolver;
        RequestDelegate requestDelegate;
        Scale scale;
        ImageView.ScaleType scaleType;
        ?? r4;
        ?? r3;
        Target target;
        ?? r8;
        ?? r5;
        RequestDelegate requestDelegate2;
        Image image;
        Image image2;
        ?? r6;
        ?? r1;
        Object objWithContext;
        ?? r7;
        RequestDelegate requestDelegate3;
        ?? r9;
        ImageResult imageResult;
        int i2;
        ?? r10 = imageRequest;
        int i3 = i;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            i2 = anonymousClass3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                int i4 = i2 - Integer.MIN_VALUE;
                anonymousClass3.label = i4;
                Build = i4;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
                Build = i2;
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
            Build = i2;
        }
        AnonymousClass3 anonymousClass4 = anonymousClass3;
        Object size = anonymousClass4.result;
        ?? r11 = anonymousClass4.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (r11 == 0) {
                ResultKt.throwOnFailure(size);
                Job job = AwaitKt.getJob(anonymousClass4.getContext());
                boolean z = i3 == 0;
                Splitter splitter = this.requestService;
                splitter.getClass();
                RealImageLoader realImageLoader = (RealImageLoader) splitter.trimmer;
                Target target2 = r10.target;
                if (target2 instanceof GenericViewTarget) {
                    Lifecycle lifecycleFindLifecycle = (Lifecycle) UriKt.getExtra((ImageRequest) r10, ImageRequests_androidKt.lifecycleKey);
                    if (lifecycleFindLifecycle == null) {
                        lifecycleFindLifecycle = Splitter.findLifecycle(r10);
                    }
                    lifecycleRequestDelegate = new ViewTargetRequestDelegate(realImageLoader, r10, (GenericViewTarget) target2, lifecycleFindLifecycle, job);
                } else {
                    Lifecycle lifecycleFindLifecycle2 = (Lifecycle) UriKt.getExtra((ImageRequest) r10, ImageRequests_androidKt.lifecycleKey);
                    if (lifecycleFindLifecycle2 == null) {
                        lifecycleFindLifecycle2 = z ? Splitter.findLifecycle(r10) : null;
                    }
                    lifecycleRequestDelegate = lifecycleFindLifecycle2 != null ? new LifecycleRequestDelegate(lifecycleFindLifecycle2, job) : new BaseRequestDelegate(job);
                }
                lifecycleRequestDelegate.assertActive();
                ImageRequest.Builder builderNewBuilder$default = ImageRequest.newBuilder$default(r10);
                Target target3 = r10.target;
                builderNewBuilder$default.defaults = realImageLoader.options.defaults;
                ImageRequest.Defined defined = r10.defined;
                SizeResolver sizeResolver = defined.sizeResolver;
                if (sizeResolver == null) {
                    if (target3 instanceof GenericViewTarget) {
                        View view = ((GenericViewTarget) target3).getView();
                        realViewSizeResolver = ((view instanceof ImageView) && ((scaleType = ((ImageView) view).getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) ? SizeResolver.ORIGINAL : new RealViewSizeResolver(view);
                    } else {
                        realViewSizeResolver = SizeResolver.ORIGINAL;
                    }
                    builderNewBuilder$default.sizeResolver = realViewSizeResolver;
                } else {
                    realViewSizeResolver = sizeResolver;
                }
                if (defined.scale == null) {
                    GenericViewTarget genericViewTarget = target3 instanceof GenericViewTarget ? (GenericViewTarget) target3 : null;
                    View view2 = genericViewTarget != null ? genericViewTarget.getView() : null;
                    ImageView imageView = view2 instanceof ImageView ? (ImageView) view2 : null;
                    if (imageView != null) {
                        Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                        ImageView.ScaleType scaleType2 = imageView.getScaleType();
                        int i5 = scaleType2 == null ? -1 : Utils_androidKt.WhenMappings.$EnumSwitchMapping$1[scaleType2.ordinal()];
                        scale = (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) ? Scale.FIT : Scale.FILL;
                    } else {
                        scale = r10.scale;
                    }
                    builderNewBuilder$default.scale = scale;
                }
                if (defined.precision == null) {
                    Precision precision = Precision.INEXACT;
                    if (sizeResolver != null || !Intrinsics.areEqual(realViewSizeResolver, SizeResolver.ORIGINAL)) {
                        if ((target3 instanceof GenericViewTarget) && (realViewSizeResolver instanceof RealViewSizeResolver)) {
                            GenericViewTarget genericViewTarget2 = (GenericViewTarget) target3;
                            if (!(genericViewTarget2.getView() instanceof ImageView) || genericViewTarget2.getView() != ((RealViewSizeResolver) realViewSizeResolver).view) {
                                precision = Precision.EXACT;
                            }
                        } else {
                            precision = Precision.EXACT;
                        }
                    }
                    builderNewBuilder$default.precision = precision;
                }
                Build = builderNewBuilder$default.build();
                r11 = EventListener$Companion$NONE$1.NONE;
                try {
                    if (Build.data.equals(NullRequestData.INSTANCE)) {
                        throw new NullRequestDataException("The request's data is null.");
                    }
                    lifecycleRequestDelegate.start();
                    if (i3 == 0) {
                        anonymousClass4.L$1 = lifecycleRequestDelegate;
                        anonymousClass4.L$2 = Build;
                        anonymousClass4.L$3 = r11;
                        anonymousClass4.I$0 = i3;
                        anonymousClass4.label = 1;
                    }
                    requestDelegate = lifecycleRequestDelegate;
                    r3 = r11;
                    r4 = Build;
                    r4.getClass();
                    target = r4.target;
                    if (target != null) {
                        image2 = (Image) r4.placeholderFactory.invoke(r4);
                        if (image2 == null) {
                            image2 = (Image) r4.defaults.placeholderFactory.invoke(r4);
                        }
                        target.onStart(image2);
                    }
                    r3.getClass();
                    SizeResolver sizeResolver2 = r4.sizeResolver;
                    anonymousClass4.L$1 = requestDelegate;
                    anonymousClass4.L$2 = r4;
                    anonymousClass4.L$3 = r3;
                    anonymousClass4.L$4 = null;
                    anonymousClass4.I$0 = i3;
                    anonymousClass4.label = 2;
                    size = sizeResolver2.size(anonymousClass4);
                    if (size != coroutineSingletons) {
                        r8 = r4;
                        r5 = r3;
                        requestDelegate2 = requestDelegate;
                        image = null;
                        r6 = r8;
                        int i6 = i3;
                        Size size2 = (Size) size;
                        r5.getClass();
                        CoroutineContext coroutineContext = r6.interceptorCoroutineContext;
                        r1 = r6;
                        RealImageLoader$execute$result$1 realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1((Object) r1, (Object) this, (Object) size2, (Object) r5, (Object) image, (Continuation) null, (byte) 0);
                        anonymousClass4.L$1 = requestDelegate2;
                        anonymousClass4.L$2 = r1;
                        anonymousClass4.L$3 = r5;
                        anonymousClass4.L$4 = null;
                        anonymousClass4.I$0 = i6;
                        anonymousClass4.label = 3;
                        objWithContext = AwaitKt.withContext(coroutineContext, realImageLoader$execute$result$1, anonymousClass4);
                        if (objWithContext != coroutineSingletons) {
                            r7 = r5;
                            requestDelegate3 = requestDelegate2;
                            r9 = r1;
                            size = objWithContext;
                            imageResult = (ImageResult) size;
                            if (imageResult instanceof SuccessResult) {
                                onSuccess((SuccessResult) imageResult, r9.target, r7);
                            } else {
                                if (!(imageResult instanceof ErrorResult)) {
                                    throw new HttpException();
                                }
                                onError((ErrorResult) imageResult, r9.target, r7);
                            }
                            requestDelegate3.complete();
                            return imageResult;
                        }
                    }
                    return coroutineSingletons;
                } catch (Throwable th) {
                    th = th;
                    r10 = lifecycleRequestDelegate;
                    if (th instanceof CancellationException) {
                        r11.getClass();
                        Build.getClass();
                        throw th;
                    }
                    ErrorResult ErrorResult = UtilsKt.ErrorResult(Build, th);
                    onError(ErrorResult, Build.target, r11);
                    r10.complete();
                    return ErrorResult;
                }
            }
            if (r11 == 1) {
                i3 = anonymousClass4.I$0;
                EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = anonymousClass4.L$3;
                ImageRequest imageRequest2 = anonymousClass4.L$2;
                requestDelegate = anonymousClass4.L$1;
                ResultKt.throwOnFailure(size);
                r3 = eventListener$Companion$NONE$1;
                r4 = imageRequest2;
                r4.getClass();
                target = r4.target;
                if (target != null) {
                    image2 = (Image) r4.placeholderFactory.invoke(r4);
                    if (image2 == null) {
                        image2 = (Image) r4.defaults.placeholderFactory.invoke(r4);
                    }
                    target.onStart(image2);
                }
                r3.getClass();
                SizeResolver sizeResolver3 = r4.sizeResolver;
                anonymousClass4.L$1 = requestDelegate;
                anonymousClass4.L$2 = r4;
                anonymousClass4.L$3 = r3;
                anonymousClass4.L$4 = null;
                anonymousClass4.I$0 = i3;
                anonymousClass4.label = 2;
                size = sizeResolver3.size(anonymousClass4);
                if (size != coroutineSingletons) {
                    r8 = r4;
                    r5 = r3;
                    requestDelegate2 = requestDelegate;
                    image = null;
                    r6 = r8;
                    int i7 = i3;
                    Size size3 = (Size) size;
                    r5.getClass();
                    CoroutineContext coroutineContext2 = r6.interceptorCoroutineContext;
                    r1 = r6;
                    RealImageLoader$execute$result$1 realImageLoader$execute$result$2 = new RealImageLoader$execute$result$1((Object) r1, (Object) this, (Object) size3, (Object) r5, (Object) image, (Continuation) null, (byte) 0);
                    anonymousClass4.L$1 = requestDelegate2;
                    anonymousClass4.L$2 = r1;
                    anonymousClass4.L$3 = r5;
                    anonymousClass4.L$4 = null;
                    anonymousClass4.I$0 = i7;
                    anonymousClass4.label = 3;
                    objWithContext = AwaitKt.withContext(coroutineContext2, realImageLoader$execute$result$2, anonymousClass4);
                    if (objWithContext != coroutineSingletons) {
                        r7 = r5;
                        requestDelegate3 = requestDelegate2;
                        r9 = r1;
                        size = objWithContext;
                        imageResult = (ImageResult) size;
                        if (imageResult instanceof SuccessResult) {
                            onSuccess((SuccessResult) imageResult, r9.target, r7);
                        } else {
                            if (!(imageResult instanceof ErrorResult)) {
                                throw new HttpException();
                            }
                            onError((ErrorResult) imageResult, r9.target, r7);
                        }
                        requestDelegate3.complete();
                        return imageResult;
                    }
                }
                return coroutineSingletons;
            }
            if (r11 == 2) {
                i3 = anonymousClass4.I$0;
                Image image3 = anonymousClass4.L$4;
                EventListener$Companion$NONE$1 eventListener$Companion$NONE$2 = anonymousClass4.L$3;
                ImageRequest imageRequest3 = anonymousClass4.L$2;
                RequestDelegate requestDelegate4 = anonymousClass4.L$1;
                try {
                    ResultKt.throwOnFailure(size);
                    r8 = imageRequest3;
                    image = image3;
                    requestDelegate2 = requestDelegate4;
                    r5 = eventListener$Companion$NONE$2;
                    r6 = r8;
                    int i8 = i3;
                    try {
                        Size size4 = (Size) size;
                        r5.getClass();
                        CoroutineContext coroutineContext3 = r6.interceptorCoroutineContext;
                        r1 = r6;
                        try {
                            RealImageLoader$execute$result$1 realImageLoader$execute$result$3 = new RealImageLoader$execute$result$1((Object) r1, (Object) this, (Object) size4, (Object) r5, (Object) image, (Continuation) null, (byte) 0);
                            anonymousClass4.L$1 = requestDelegate2;
                            anonymousClass4.L$2 = r1;
                            anonymousClass4.L$3 = r5;
                            anonymousClass4.L$4 = null;
                            anonymousClass4.I$0 = i8;
                            anonymousClass4.label = 3;
                            objWithContext = AwaitKt.withContext(coroutineContext3, realImageLoader$execute$result$3, anonymousClass4);
                            if (objWithContext != coroutineSingletons) {
                                r7 = r5;
                                requestDelegate3 = requestDelegate2;
                                r9 = r1;
                                size = objWithContext;
                            }
                            return coroutineSingletons;
                        } catch (Throwable th2) {
                            th = th2;
                            r11 = r5;
                            r10 = requestDelegate2;
                            Build = r1;
                            try {
                                if (th instanceof CancellationException) {
                                    r11.getClass();
                                    Build.getClass();
                                    throw th;
                                }
                                ErrorResult ErrorResult2 = UtilsKt.ErrorResult(Build, th);
                                onError(ErrorResult2, Build.target, r11);
                                r10.complete();
                                return ErrorResult2;
                            } catch (Throwable th3) {
                                r10.complete();
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r1 = r6;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r11 = eventListener$Companion$NONE$2;
                    Build = imageRequest3;
                    r10 = requestDelegate4;
                    if (th instanceof CancellationException) {
                        r11.getClass();
                        Build.getClass();
                        throw th;
                    }
                    ErrorResult ErrorResult3 = UtilsKt.ErrorResult(Build, th);
                    onError(ErrorResult3, Build.target, r11);
                    r10.complete();
                    return ErrorResult3;
                }
            } else {
                if (r11 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                EventListener$Companion$NONE$1 eventListener$Companion$NONE$3 = anonymousClass4.L$3;
                ImageRequest imageRequest4 = anonymousClass4.L$2;
                requestDelegate3 = anonymousClass4.L$1;
                ResultKt.throwOnFailure(size);
                r7 = eventListener$Companion$NONE$3;
                r9 = imageRequest4;
            }
            imageResult = (ImageResult) size;
            if (imageResult instanceof SuccessResult) {
                onSuccess((SuccessResult) imageResult, r9.target, r7);
            } else {
                if (!(imageResult instanceof ErrorResult)) {
                    throw new HttpException();
                }
                onError((ErrorResult) imageResult, r9.target, r7);
            }
            requestDelegate3.complete();
            return imageResult;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final RealMemoryCache getMemoryCache() {
        return (RealMemoryCache) this.options.memoryCacheLazy.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    public final void onError(ErrorResult errorResult, Target target, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1) {
        ImageRequest imageRequest = errorResult.request;
        Image image = errorResult.image;
        if (target instanceof TransitionTarget) {
            Transition transitionCreate = ((Transition.Factory) UriKt.getExtra(imageRequest, ImageRequests_androidKt.transitionFactoryKey)).create((TransitionTarget) target, errorResult);
            if (transitionCreate instanceof NoneTransition) {
                target.onError(image);
            } else {
                eventListener$Companion$NONE$1.getClass();
                transitionCreate.transition();
            }
        } else if (target != null) {
            target.onError(image);
        }
        eventListener$Companion$NONE$1.getClass();
        imageRequest.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    public final void onSuccess(SuccessResult successResult, Target target, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1) {
        ImageRequest imageRequest = successResult.request;
        Image image = successResult.image;
        if (target instanceof TransitionTarget) {
            Transition transitionCreate = ((Transition.Factory) UriKt.getExtra(imageRequest, ImageRequests_androidKt.transitionFactoryKey)).create((TransitionTarget) target, successResult);
            if (transitionCreate instanceof NoneTransition) {
                target.onSuccess(image);
            } else {
                eventListener$Companion$NONE$1.getClass();
                transitionCreate.transition();
            }
        } else if (target != null) {
            target.onSuccess(image);
        }
        eventListener$Companion$NONE$1.getClass();
        imageRequest.getClass();
    }

    /* JADX INFO: renamed from: coil3.RealImageLoader$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object $request;
        public Object L$0;
        public boolean label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.L$0 = obj2;
            this.$request = obj3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$request;
            switch (b) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((RealImageLoader) this.this$0, (ImageRequest) obj2, continuation, (byte) 0);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((TransitionInstance) this.this$0, (MutableState) obj2, continuation, (byte) 1);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                case 2:
                    return new AnonymousClass2((AnimateAsState) this.this$0, this.L$0, (AnimationSpec) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass2((TagPayloadReader) obj2, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass2((MutableInteractionSourceImpl) this.L$0, (PressInteraction.Cancel) this.this$0, (DisposableHandle) obj2, continuation, (byte) 4, false);
                case 5:
                    return new AnonymousClass2((MutableInteractionSourceImpl) this.L$0, (FocusInteraction) this.this$0, (DisposableHandle) obj2, continuation, (byte) 5, false);
                case 6:
                    return new AnonymousClass2((Function2) this.this$0, this.L$0, (CoroutineScope) obj2, continuation, (byte) 6);
                case 7:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2((Function0) this.this$0, (Function2) obj2, continuation, (byte) 7);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
                case 8:
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2((Function3) this.this$0, (NodeChain) obj2, continuation, (byte) 8);
                    anonymousClass5.L$0 = obj;
                    return anonymousClass5;
                case 9:
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2((Function4) this.this$0, (NodeChain) obj2, continuation, (byte) 9);
                    anonymousClass6.L$0 = obj;
                    return anonymousClass6;
                case 10:
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2((DefaultScrollableState) this.this$0, (Function2) obj2, continuation, (byte) 10);
                    anonymousClass7.L$0 = obj;
                    return anonymousClass7;
                case 11:
                    return new AnonymousClass2((DefaultScrollableState) this.L$0, (MutatePriority) this.this$0, (Function2) obj2, continuation, (byte) 11, false);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2((InnerTube$feedback$2) this.this$0, (ScrollingLogic) obj2, continuation, (byte) 12);
                    anonymousClass8.L$0 = obj;
                    return anonymousClass8;
                case 13:
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2((ScrollingLogic) this.this$0, (Function2) obj2, continuation, (byte) 13);
                    anonymousClass9.L$0 = obj;
                    return anonymousClass9;
                case 14:
                    return new AnonymousClass2((TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) this.L$0, (PressGestureScopeImpl) this.this$0, (PointerInputChange) obj2, continuation, (byte) 14, false);
                case 15:
                    return new AnonymousClass2((LazyLayoutItemAnimation) this.L$0, (FiniteAnimationSpec) this.this$0, (GraphicsLayer) obj2, continuation, (byte) 15, false);
                case 16:
                    return new AnonymousClass2((BringIntoViewResponderNode) this.L$0, (NodeCoordinator) this.this$0, (ComponentRegistry$Builder$$ExternalSyntheticLambda2) obj2, continuation, (byte) 16, false);
                case 17:
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2((State) this.this$0, (Animatable) obj2, continuation, (byte) 17);
                    anonymousClass10.L$0 = obj;
                    return anonymousClass10;
                case 18:
                    AnonymousClass2 anonymousClass11 = new AnonymousClass2((InteractionSource) this.this$0, (FloatingActionButtonElevationAnimatable) obj2, continuation, (byte) 18);
                    anonymousClass11.L$0 = obj;
                    return anonymousClass11;
                case 19:
                    return new AnonymousClass2((PointerInputScope) this.L$0, (MutableInteractionSourceImpl) this.this$0, (SliderState) obj2, continuation, (byte) 19, false);
                case 20:
                    return new AnonymousClass2((FocusStateImpl) this.L$0, (MutableState) this.this$0, (TooltipStateImpl) obj2, continuation, (byte) 20, false);
                case 21:
                    AnonymousClass2 anonymousClass12 = new AnonymousClass2((Recomposer$runRecomposeAndApplyChanges$2) this.this$0, (MonotonicFrameClock) obj2, continuation, (byte) 21);
                    anonymousClass12.L$0 = obj;
                    return anonymousClass12;
                case 22:
                    return new AnonymousClass2((BufferedChannel) obj2, continuation, (byte) 22);
                case 23:
                    AnonymousClass2 anonymousClass13 = new AnonymousClass2((DataStoreImpl) this.this$0, (Function2) obj2, continuation, (byte) 23);
                    anonymousClass13.L$0 = obj;
                    return anonymousClass13;
                case 24:
                    AnonymousClass2 anonymousClass14 = new AnonymousClass2((Lifecycle) this.this$0, (SimpleActor$offer$2) obj2, continuation, (byte) 24);
                    anonymousClass14.L$0 = obj;
                    return anonymousClass14;
                case 25:
                    AnonymousClass2 anonymousClass15 = new AnonymousClass2((Lifecycle) this.this$0, (Flow) obj2, continuation, (byte) 25);
                    anonymousClass15.L$0 = obj;
                    return anonymousClass15;
                case 26:
                    return new AnonymousClass2((SeekableTransitionState) this.L$0, (MutableState) this.this$0, (ParcelableSnapshotMutableFloatState) obj2, continuation, (byte) 26, false);
                case 27:
                    return new AnonymousClass2((Ref$ObjectRef) this.this$0, (Pool) obj2, continuation, (byte) 27);
                case 28:
                    AnonymousClass2 anonymousClass16 = new AnonymousClass2((CompletableDeferredImpl) this.this$0, (Function2) obj2, continuation, (byte) 28);
                    anonymousClass16.L$0 = obj;
                    return anonymousClass16;
                default:
                    AnonymousClass2 anonymousClass17 = new AnonymousClass2((String) obj2, continuation, (byte) 29);
                    anonymousClass17.L$0 = obj;
                    return anonymousClass17;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass2) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 7:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 8:
                    return ((AnonymousClass2) create((DefaultDraggableAnchors) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 9:
                    return ((AnonymousClass2) create((Pair) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 10:
                    return ((AnonymousClass2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 11:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return ((AnonymousClass2) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 13:
                    return ((AnonymousClass2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 14:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 16:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 17:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 18:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 20:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 21:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 22:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 23:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 24:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 25:
                    return ((AnonymousClass2) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 26:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 27:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 28:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create((QuickJs) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0259 */
        /* JADX WARN: Code duplicated, block: B:119:0x027b  */
        /* JADX WARN: Code duplicated, block: B:122:0x0285 A[Catch: all -> 0x0259, TryCatch #6 {, blocks: (B:110:0x0253, B:120:0x027d, B:122:0x0285, B:123:0x0294, B:130:0x02a4, B:117:0x026f, B:132:0x02a7, B:134:0x02ac, B:135:0x02ad, B:116:0x026a, B:124:0x0295, B:126:0x029b), top: B:441:0x0247, inners: #7 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x029b A[Catch: all -> 0x02ab, TRY_LEAVE, TryCatch #7 {all -> 0x02ab, blocks: (B:124:0x0295, B:126:0x029b), top: B:443:0x0295, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:132:0x02a7 A[Catch: all -> 0x0259, TryCatch #6 {, blocks: (B:110:0x0253, B:120:0x027d, B:122:0x0285, B:123:0x0294, B:130:0x02a4, B:117:0x026f, B:132:0x02a7, B:134:0x02ac, B:135:0x02ad, B:116:0x026a, B:124:0x0295, B:126:0x029b), top: B:441:0x0247, inners: #7 }] */
        /* JADX WARN: Code duplicated, block: B:235:0x04cc  */
        /* JADX WARN: Code duplicated, block: B:443:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:126:0x029b, B:129:0x02a3], limit reached: 505 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v41, types: [kotlinx.coroutines.channels.ReceiveChannel] */
        /* JADX WARN: Type inference failed for: r3v43, types: [kotlinx.coroutines.channels.BufferedChannel] */
        /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v45, types: [kotlinx.coroutines.channels.ReceiveChannel] */
        /* JADX WARN: Type inference failed for: r3v69 */
        /* JADX WARN: Type inference failed for: r3v70 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0279 -> B:120:0x027d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r16) {
            /*
                Method dump skipped, instruction units count: 2306
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Object obj3, Continuation continuation, byte b, boolean z) {
            super(2, continuation);
            this.$r8$classId = b;
            this.L$0 = obj;
            this.this$0 = obj2;
            this.$request = obj3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$request = obj2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$request = obj;
        }
    }

    public final Object execute(ImageRequest imageRequest, Continuation continuation) {
        if (!(imageRequest.target instanceof GenericViewTarget) && !(imageRequest.sizeResolver instanceof RealViewSizeResolver) && ((Lifecycle) UriKt.getExtra(imageRequest, ImageRequests_androidKt.lifecycleKey)) == null) {
            return execute(imageRequest, 1, continuation);
        }
        return AwaitKt.coroutineScope(new AnonymousClass2(this, imageRequest, null, (byte) 0), continuation);
    }
}
