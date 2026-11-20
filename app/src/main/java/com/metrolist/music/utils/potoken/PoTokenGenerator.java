package com.metrolist.music.utils.potoken;

import android.content.Context;
import android.webkit.CookieManager;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/metrolist/music/utils/potoken/PoTokenGenerator;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "applicationContext", "kotlin.jvm.PlatformType", "webViewSupported", "", "getWebViewSupported", "()Z", "webViewSupported$delegate", "Lkotlin/Lazy;", "webViewBadImpl", "webPoTokenGenLock", "Lkotlinx/coroutines/sync/Mutex;", "webPoTokenSessionId", "webPoTokenStreamingPot", "webPoTokenGenerator", "Lcom/metrolist/music/utils/potoken/PoTokenWebView;", "getWebClientPoToken", "Lcom/metrolist/music/utils/potoken/PoTokenResult;", "videoId", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearGenerator", "forceRecreate", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PoTokenGenerator {

    @Deprecated
    public static final long POTOKEN_TIMEOUT_MS = 8000;
    private final String TAG;
    private final Context applicationContext;
    private final Mutex webPoTokenGenLock;
    private PoTokenWebView webPoTokenGenerator;
    private String webPoTokenSessionId;
    private String webPoTokenStreamingPot;
    private boolean webViewBadImpl;

    /* JADX INFO: renamed from: webViewSupported$delegate, reason: from kotlin metadata */
    private final Lazy webViewSupported;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenGenerator$clearGenerator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 560)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenGenerator", f = "PoTokenGenerator.kt", l = {163, 64}, m = "clearGenerator", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PoTokenGenerator.this.clearGenerator(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenGenerator$getWebClientPoToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 560)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenGenerator", f = "PoTokenGenerator.kt", l = {34, 43}, m = "getWebClientPoToken", v = 2)
    public static final class C01951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C01951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PoTokenGenerator.this.getWebClientPoToken(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenGenerator$getWebClientPoToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/utils/potoken/PoTokenResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenGenerator$getWebClientPoToken$2", f = "PoTokenGenerator.kt", l = {35}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $sessionId;
        final /* synthetic */ String $videoId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.$videoId = str;
            this.$sessionId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PoTokenGenerator.this.new AnonymousClass2(this.$videoId, this.$sessionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            PoTokenGenerator poTokenGenerator = PoTokenGenerator.this;
            String str = this.$videoId;
            String str2 = this.$sessionId;
            this.label = 1;
            Object webClientPoToken = poTokenGenerator.getWebClientPoToken(str, str2, false, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return webClientPoToken == coroutineSingletons ? coroutineSingletons : webClientPoToken;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenGenerator$getWebClientPoToken$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 560)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenGenerator", f = "PoTokenGenerator.kt", l = {163, 101, 113, 118, 135, 146}, m = "getWebClientPoToken", v = 2)
    public static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PoTokenGenerator.this.getWebClientPoToken(null, null, false, this);
        }
    }

    public PoTokenGenerator(Context context) {
        context.getClass();
        this.TAG = "PoTokenGenerator";
        this.applicationContext = context.getApplicationContext();
        this.webViewSupported = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 18, this));
        this.webPoTokenGenLock = new MutexImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x008b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.metrolist.music.utils.potoken.PoTokenGenerator$clearGenerator$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object] */
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
    public final Object clearGenerator(Continuation continuation) throws Throwable {
        ?? anonymousClass1;
        ?? r9;
        ?? r10;
        ?? r1;
        Exception e;
        String simpleName;
        if (continuation instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass2 = (AnonymousClass1) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
                anonymousClass1 = anonymousClass2;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    r9 = this.webPoTokenGenLock;
                    anonymousClass1.L$0 = r9;
                    anonymousClass1.label = 1;
                    if (r9.lock(anonymousClass1) != coroutineSingletons) {
                    }
                    r10 = r9;
                    return coroutineSingletons;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    r1 = (Mutex) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r1 = r1;
                        anonymousClass1 = r1;
                    } catch (Exception e2) {
                        e = e2;
                        Timber.Forest.tag(this.TAG);
                        simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                        if (simpleName == null) {
                            simpleName = "unknown";
                        }
                        "PO token WebView cleanup failed type=".concat(simpleName);
                        ConnectionPool.e(new Object[0]);
                        anonymousClass1 = r1;
                    }
                    this.webPoTokenGenerator = null;
                    this.webPoTokenStreamingPot = null;
                    this.webPoTokenSessionId = null;
                    anonymousClass1.unlock(null);
                    return Unit.INSTANCE;
                }
                Mutex mutex = (Mutex) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                r10 = mutex;
                r10 = r9;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
                PoTokenGenerator$clearGenerator$2$1 poTokenGenerator$clearGenerator$2$1 = new PoTokenGenerator$clearGenerator$2$1(this, null);
                anonymousClass1.L$0 = r10;
                anonymousClass1.label = 2;
                Object objWithContext = AwaitKt.withContext(handlerContext, poTokenGenerator$clearGenerator$2$1, anonymousClass1);
                if (objWithContext != coroutineSingletons) {
                    r1 = r10;
                    obj = objWithContext;
                    anonymousClass1 = r1;
                    this.webPoTokenGenerator = null;
                    this.webPoTokenStreamingPot = null;
                    this.webPoTokenSessionId = null;
                    anonymousClass1.unlock(null);
                    return Unit.INSTANCE;
                }
                r10 = r9;
                return coroutineSingletons;
            } catch (Exception e3) {
                r1 = r10;
                e = e3;
                Timber.Forest.tag(this.TAG);
                simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                if (simpleName == null) {
                    simpleName = "unknown";
                }
                "PO token WebView cleanup failed type=".concat(simpleName);
                ConnectionPool.e(new Object[0]);
                anonymousClass1 = r1;
            } catch (Throwable th) {
                th = th;
                anonymousClass1 = r10;
                anonymousClass1.unlock(null);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x008d A[PHI: r1 r6 r11 r12 r13 r14
      0x008d: PHI (r1v18 java.lang.String) = (r1v15 java.lang.String), (r1v21 java.lang.String) binds: [B:56:0x014b, B:25:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008d: PHI (r6v10 java.lang.String) = (r6v7 java.lang.String), (r6v13 java.lang.String) binds: [B:56:0x014b, B:25:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008d: PHI (r11v8 int) = (r11v6 int), (r11v9 int) binds: [B:56:0x014b, B:25:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008d: PHI (r12v8 ??) = (r12v22 ??), (r12v23 ??) binds: [B:56:0x014b, B:25:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008d: PHI (r13v13 kotlinx.coroutines.sync.Mutex) = (r13v10 kotlinx.coroutines.sync.Mutex), (r13v17 kotlinx.coroutines.sync.Mutex) binds: [B:56:0x014b, B:25:0x008a] A[DONT_GENERATE, DONT_INLINE]
      0x008d: PHI (r14v7 java.lang.Object) = (r14v6 java.lang.Object), (r14v1 java.lang.Object) binds: [B:56:0x014b, B:25:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fe A[Catch: all -> 0x00f7, TRY_LEAVE, TryCatch #2 {all -> 0x00f7, blocks: (B:37:0x00d7, B:39:0x00db, B:41:0x00e1, B:43:0x00ec, B:51:0x00fe), top: B:95:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0128  */
    /* JADX WARN: Code duplicated, block: B:61:0x0167  */
    /* JADX WARN: Code duplicated, block: B:62:0x0169 A[Catch: all -> 0x0077, PHI: r1 r6 r7 r11 r12 r13 r14
      0x0169: PHI (r1v28 ??) = (r1v41 ??), (r1v42 ??) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0169: PHI (r6v17 java.lang.String) = (r6v11 java.lang.String), (r6v19 java.lang.String) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0169: PHI (r7v5 java.lang.String) = (r7v3 java.lang.String), (r7v7 java.lang.String) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0169: PHI (r11v13 int) = (r11v8 int), (r11v15 int) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0169: PHI (r12v11 ??) = (r12v19 ??), (r12v20 ??) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0169: PHI (r13v23 ??) = (r13v36 ??), (r13v37 ??) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0169: PHI (r14v12 java.lang.Object) = (r14v9 java.lang.Object), (r14v1 java.lang.Object) binds: [B:60:0x0165, B:20:0x0072] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x0077, blocks: (B:20:0x0072, B:62:0x0169, B:59:0x0152), top: B:93:0x0021, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0189  */
    /* JADX WARN: Code duplicated, block: B:72:0x0198  */
    /* JADX WARN: Code duplicated, block: B:73:0x019a  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:85:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:95:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.metrolist.music.utils.potoken.PoTokenGenerator] */
    /* JADX WARN: Type inference failed for: r12v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.metrolist.music.utils.potoken.PoTokenWebView] */
    /* JADX WARN: Type inference failed for: r13v18, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v23, types: [com.metrolist.music.utils.potoken.PoTokenWebView] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    public final Object getWebClientPoToken(String str, String str2, boolean z, Continuation continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        Mutex mutex;
        ?? r13;
        PoTokenWebView poTokenWebView;
        int i;
        String str3;
        ?? r12;
        HandlerContext handlerContext;
        PoTokenGenerator$getWebClientPoToken$4$1 poTokenGenerator$getWebClientPoToken$4$1;
        String str4;
        int i2;
        String str5;
        ?? r14;
        Mutex mutex2;
        ?? r15;
        String str6;
        String str7;
        boolean z2;
        String str8;
        boolean z3;
        String str9;
        String str10;
        ?? r16;
        Object webClientPoToken;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i3 = anonymousClass3.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object newPoTokenGenerator = anonymousClass3.result;
        ?? r1 = anonymousClass3.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    switch (r1) {
                        case 0:
                            ResultKt.throwOnFailure(newPoTokenGenerator);
                            mutex = this.webPoTokenGenLock;
                            anonymousClass3.L$0 = str;
                            anonymousClass3.L$1 = str2;
                            anonymousClass3.L$2 = mutex;
                            anonymousClass3.Z$0 = z;
                            anonymousClass3.label = 1;
                            r13 = z;
                            if (mutex.lock(anonymousClass3) != coroutineSingletons) {
                                if (r13 == 0) {
                                    try {
                                        poTokenWebView = this.webPoTokenGenerator;
                                        if (poTokenWebView != null || poTokenWebView.isExpired()) {
                                            i = 1;
                                        } else {
                                            PoTokenWebView poTokenWebView2 = this.webPoTokenGenerator;
                                            poTokenWebView2.getClass();
                                            if (poTokenWebView2.getIsDead() || !Intrinsics.areEqual(this.webPoTokenSessionId, str2)) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                        }
                                        if (i != 0) {
                                            Timber.Forest.tag(this.TAG);
                                            ConnectionPool.d(new Object[0]);
                                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                                            handlerContext = MainDispatcherLoader.dispatcher;
                                            poTokenGenerator$getWebClientPoToken$4$1 = new PoTokenGenerator$getWebClientPoToken$4$1(this, null);
                                            anonymousClass3.L$0 = str;
                                            anonymousClass3.L$1 = str2;
                                            anonymousClass3.L$2 = mutex;
                                            anonymousClass3.Z$0 = r13;
                                            anonymousClass3.I$0 = i;
                                            anonymousClass3.label = 2;
                                            if (AwaitKt.withContext(handlerContext, poTokenGenerator$getWebClientPoToken$4$1, anonymousClass3) != coroutineSingletons) {
                                                str4 = str;
                                                i2 = i;
                                                str5 = str2;
                                                r14 = r13;
                                                mutex2 = mutex;
                                                this.webPoTokenGenerator = null;
                                                this.webPoTokenStreamingPot = null;
                                                this.webPoTokenSessionId = null;
                                                PoTokenWebView.Companion companion = PoTokenWebView.INSTANCE;
                                                Context context = this.applicationContext;
                                                context.getClass();
                                                anonymousClass3.L$0 = str4;
                                                anonymousClass3.L$1 = str5;
                                                anonymousClass3.L$2 = mutex2;
                                                anonymousClass3.Z$0 = r14;
                                                anonymousClass3.I$0 = i2;
                                                anonymousClass3.label = 3;
                                                newPoTokenGenerator = companion.getNewPoTokenGenerator(context, anonymousClass3);
                                                r15 = r14;
                                                if (newPoTokenGenerator != coroutineSingletons) {
                                                    str6 = str4;
                                                    str3 = str5;
                                                    Mutex mutex3 = mutex2;
                                                    PoTokenWebView poTokenWebView3 = (PoTokenWebView) newPoTokenGenerator;
                                                    anonymousClass3.L$0 = str6;
                                                    anonymousClass3.L$1 = str3;
                                                    anonymousClass3.L$2 = mutex3;
                                                    anonymousClass3.L$3 = poTokenWebView3;
                                                    anonymousClass3.Z$0 = r15;
                                                    anonymousClass3.I$0 = i2;
                                                    anonymousClass3.label = 4;
                                                    newPoTokenGenerator = poTokenWebView3.generatePoToken(str3, anonymousClass3);
                                                    r1 = mutex3;
                                                    r16 = r15;
                                                    z = poTokenWebView3;
                                                    if (newPoTokenGenerator == coroutineSingletons) {
                                                        String str11 = (String) newPoTokenGenerator;
                                                        this.webPoTokenGenerator = z;
                                                        this.webPoTokenStreamingPot = str11;
                                                        this.webPoTokenSessionId = str3;
                                                        Timber.Forest.tag(this.TAG);
                                                        ConnectionPool.d(new Object[0]);
                                                        z = r1;
                                                        i = i2;
                                                        str = str6;
                                                        r12 = r16;
                                                        PoTokenWebView poTokenWebView4 = this.webPoTokenGenerator;
                                                        poTokenWebView4.getClass();
                                                        str7 = this.webPoTokenStreamingPot;
                                                        str7.getClass();
                                                        if (i != 0) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        z.unlock(null);
                                                        try {
                                                            anonymousClass3.L$0 = str;
                                                            anonymousClass3.L$1 = str3;
                                                            anonymousClass3.L$2 = null;
                                                            anonymousClass3.L$3 = str7;
                                                            anonymousClass3.Z$0 = r12;
                                                            anonymousClass3.Z$1 = z2;
                                                            anonymousClass3.label = 5;
                                                            newPoTokenGenerator = poTokenWebView4.generatePoToken(str, anonymousClass3);
                                                            if (newPoTokenGenerator != coroutineSingletons) {
                                                                String str12 = str3;
                                                                str8 = str;
                                                                z3 = z2;
                                                                str9 = str12;
                                                                str10 = str7;
                                                                r12 = r12;
                                                                String str13 = (String) newPoTokenGenerator;
                                                                Timber.Forest.tag(this.TAG);
                                                                ConnectionPool.d(new Object[0]);
                                                                return new PoTokenResult(str10, str13);
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            String str14 = str3;
                                                            str8 = str;
                                                            z3 = z2;
                                                            str9 = str14;
                                                            if (!z3) {
                                                                throw th;
                                                            }
                                                            Timber.Forest.tag(this.TAG);
                                                            ConnectionPool.e(new Object[0]);
                                                            anonymousClass3.L$0 = null;
                                                            anonymousClass3.L$1 = null;
                                                            anonymousClass3.L$2 = null;
                                                            anonymousClass3.L$3 = null;
                                                            anonymousClass3.L$4 = null;
                                                            anonymousClass3.Z$0 = r12;
                                                            anonymousClass3.Z$1 = z3;
                                                            anonymousClass3.label = 6;
                                                            webClientPoToken = getWebClientPoToken(str8, str9, true, anonymousClass3);
                                                            if (webClientPoToken != coroutineSingletons) {
                                                                return webClientPoToken;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            str3 = str2;
                                            r12 = r13;
                                            z = mutex;
                                            PoTokenWebView poTokenWebView5 = this.webPoTokenGenerator;
                                            poTokenWebView5.getClass();
                                            str7 = this.webPoTokenStreamingPot;
                                            str7.getClass();
                                            if (i != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            z.unlock(null);
                                            anonymousClass3.L$0 = str;
                                            anonymousClass3.L$1 = str3;
                                            anonymousClass3.L$2 = null;
                                            anonymousClass3.L$3 = str7;
                                            anonymousClass3.Z$0 = r12;
                                            anonymousClass3.Z$1 = z2;
                                            anonymousClass3.label = 5;
                                            newPoTokenGenerator = poTokenWebView5.generatePoToken(str, anonymousClass3);
                                            if (newPoTokenGenerator != coroutineSingletons) {
                                                String str15 = str3;
                                                str8 = str;
                                                z3 = z2;
                                                str9 = str15;
                                                str10 = str7;
                                                r12 = r12;
                                                String str16 = (String) newPoTokenGenerator;
                                                Timber.Forest.tag(this.TAG);
                                                ConnectionPool.d(new Object[0]);
                                                return new PoTokenResult(str10, str16);
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z = mutex;
                                        z.unlock(null);
                                        throw th;
                                    }
                                } else {
                                    i = 1;
                                    if (i != 0) {
                                        Timber.Forest.tag(this.TAG);
                                        ConnectionPool.d(new Object[0]);
                                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                        handlerContext = MainDispatcherLoader.dispatcher;
                                        poTokenGenerator$getWebClientPoToken$4$1 = new PoTokenGenerator$getWebClientPoToken$4$1(this, null);
                                        anonymousClass3.L$0 = str;
                                        anonymousClass3.L$1 = str2;
                                        anonymousClass3.L$2 = mutex;
                                        anonymousClass3.Z$0 = r13;
                                        anonymousClass3.I$0 = i;
                                        anonymousClass3.label = 2;
                                        if (AwaitKt.withContext(handlerContext, poTokenGenerator$getWebClientPoToken$4$1, anonymousClass3) != coroutineSingletons) {
                                            str4 = str;
                                            i2 = i;
                                            str5 = str2;
                                            r14 = r13;
                                            mutex2 = mutex;
                                            this.webPoTokenGenerator = null;
                                            this.webPoTokenStreamingPot = null;
                                            this.webPoTokenSessionId = null;
                                            PoTokenWebView.Companion companion2 = PoTokenWebView.INSTANCE;
                                            Context context2 = this.applicationContext;
                                            context2.getClass();
                                            anonymousClass3.L$0 = str4;
                                            anonymousClass3.L$1 = str5;
                                            anonymousClass3.L$2 = mutex2;
                                            anonymousClass3.Z$0 = r14;
                                            anonymousClass3.I$0 = i2;
                                            anonymousClass3.label = 3;
                                            newPoTokenGenerator = companion2.getNewPoTokenGenerator(context2, anonymousClass3);
                                            r15 = r14;
                                            if (newPoTokenGenerator != coroutineSingletons) {
                                                str6 = str4;
                                                str3 = str5;
                                                Mutex mutex4 = mutex2;
                                                PoTokenWebView poTokenWebView6 = (PoTokenWebView) newPoTokenGenerator;
                                                anonymousClass3.L$0 = str6;
                                                anonymousClass3.L$1 = str3;
                                                anonymousClass3.L$2 = mutex4;
                                                anonymousClass3.L$3 = poTokenWebView6;
                                                anonymousClass3.Z$0 = r15;
                                                anonymousClass3.I$0 = i2;
                                                anonymousClass3.label = 4;
                                                newPoTokenGenerator = poTokenWebView6.generatePoToken(str3, anonymousClass3);
                                                r1 = mutex4;
                                                r16 = r15;
                                                z = poTokenWebView6;
                                                if (newPoTokenGenerator == coroutineSingletons) {
                                                    String str17 = (String) newPoTokenGenerator;
                                                    this.webPoTokenGenerator = z;
                                                    this.webPoTokenStreamingPot = str17;
                                                    this.webPoTokenSessionId = str3;
                                                    Timber.Forest.tag(this.TAG);
                                                    ConnectionPool.d(new Object[0]);
                                                    z = r1;
                                                    i = i2;
                                                    str = str6;
                                                    r12 = r16;
                                                    PoTokenWebView poTokenWebView7 = this.webPoTokenGenerator;
                                                    poTokenWebView7.getClass();
                                                    str7 = this.webPoTokenStreamingPot;
                                                    str7.getClass();
                                                    if (i != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    z.unlock(null);
                                                    anonymousClass3.L$0 = str;
                                                    anonymousClass3.L$1 = str3;
                                                    anonymousClass3.L$2 = null;
                                                    anonymousClass3.L$3 = str7;
                                                    anonymousClass3.Z$0 = r12;
                                                    anonymousClass3.Z$1 = z2;
                                                    anonymousClass3.label = 5;
                                                    newPoTokenGenerator = poTokenWebView7.generatePoToken(str, anonymousClass3);
                                                    if (newPoTokenGenerator != coroutineSingletons) {
                                                        String str18 = str3;
                                                        str8 = str;
                                                        z3 = z2;
                                                        str9 = str18;
                                                        str10 = str7;
                                                        r12 = r12;
                                                        String str19 = (String) newPoTokenGenerator;
                                                        Timber.Forest.tag(this.TAG);
                                                        ConnectionPool.d(new Object[0]);
                                                        return new PoTokenResult(str10, str19);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        str3 = str2;
                                        r12 = r13;
                                        z = mutex;
                                        PoTokenWebView poTokenWebView8 = this.webPoTokenGenerator;
                                        poTokenWebView8.getClass();
                                        str7 = this.webPoTokenStreamingPot;
                                        str7.getClass();
                                        if (i != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        z.unlock(null);
                                        anonymousClass3.L$0 = str;
                                        anonymousClass3.L$1 = str3;
                                        anonymousClass3.L$2 = null;
                                        anonymousClass3.L$3 = str7;
                                        anonymousClass3.Z$0 = r12;
                                        anonymousClass3.Z$1 = z2;
                                        anonymousClass3.label = 5;
                                        newPoTokenGenerator = poTokenWebView8.generatePoToken(str, anonymousClass3);
                                        if (newPoTokenGenerator != coroutineSingletons) {
                                            String str110 = str3;
                                            str8 = str;
                                            z3 = z2;
                                            str9 = str110;
                                            str10 = str7;
                                            r12 = r12;
                                            String str111 = (String) newPoTokenGenerator;
                                            Timber.Forest.tag(this.TAG);
                                            ConnectionPool.d(new Object[0]);
                                            return new PoTokenResult(str10, str111);
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons;
                        case 1:
                            boolean z4 = anonymousClass3.Z$0;
                            Mutex mutex5 = (Mutex) anonymousClass3.L$2;
                            str2 = (String) anonymousClass3.L$1;
                            String str20 = (String) anonymousClass3.L$0;
                            ResultKt.throwOnFailure(newPoTokenGenerator);
                            mutex = mutex5;
                            str = str20;
                            r13 = z4;
                            if (r13 == 0) {
                                poTokenWebView = this.webPoTokenGenerator;
                                if (poTokenWebView != null) {
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                                if (i != 0) {
                                    Timber.Forest.tag(this.TAG);
                                    ConnectionPool.d(new Object[0]);
                                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                                    handlerContext = MainDispatcherLoader.dispatcher;
                                    poTokenGenerator$getWebClientPoToken$4$1 = new PoTokenGenerator$getWebClientPoToken$4$1(this, null);
                                    anonymousClass3.L$0 = str;
                                    anonymousClass3.L$1 = str2;
                                    anonymousClass3.L$2 = mutex;
                                    anonymousClass3.Z$0 = r13;
                                    anonymousClass3.I$0 = i;
                                    anonymousClass3.label = 2;
                                    if (AwaitKt.withContext(handlerContext, poTokenGenerator$getWebClientPoToken$4$1, anonymousClass3) != coroutineSingletons) {
                                        str4 = str;
                                        i2 = i;
                                        str5 = str2;
                                        r14 = r13;
                                        mutex2 = mutex;
                                        this.webPoTokenGenerator = null;
                                        this.webPoTokenStreamingPot = null;
                                        this.webPoTokenSessionId = null;
                                        PoTokenWebView.Companion companion3 = PoTokenWebView.INSTANCE;
                                        Context context3 = this.applicationContext;
                                        context3.getClass();
                                        anonymousClass3.L$0 = str4;
                                        anonymousClass3.L$1 = str5;
                                        anonymousClass3.L$2 = mutex2;
                                        anonymousClass3.Z$0 = r14;
                                        anonymousClass3.I$0 = i2;
                                        anonymousClass3.label = 3;
                                        newPoTokenGenerator = companion3.getNewPoTokenGenerator(context3, anonymousClass3);
                                        r15 = r14;
                                        if (newPoTokenGenerator != coroutineSingletons) {
                                            str6 = str4;
                                            str3 = str5;
                                            Mutex mutex6 = mutex2;
                                            PoTokenWebView poTokenWebView9 = (PoTokenWebView) newPoTokenGenerator;
                                            anonymousClass3.L$0 = str6;
                                            anonymousClass3.L$1 = str3;
                                            anonymousClass3.L$2 = mutex6;
                                            anonymousClass3.L$3 = poTokenWebView9;
                                            anonymousClass3.Z$0 = r15;
                                            anonymousClass3.I$0 = i2;
                                            anonymousClass3.label = 4;
                                            newPoTokenGenerator = poTokenWebView9.generatePoToken(str3, anonymousClass3);
                                            r1 = mutex6;
                                            r16 = r15;
                                            z = poTokenWebView9;
                                            if (newPoTokenGenerator == coroutineSingletons) {
                                                String str112 = (String) newPoTokenGenerator;
                                                this.webPoTokenGenerator = z;
                                                this.webPoTokenStreamingPot = str112;
                                                this.webPoTokenSessionId = str3;
                                                Timber.Forest.tag(this.TAG);
                                                ConnectionPool.d(new Object[0]);
                                                z = r1;
                                                i = i2;
                                                str = str6;
                                                r12 = r16;
                                                PoTokenWebView poTokenWebView10 = this.webPoTokenGenerator;
                                                poTokenWebView10.getClass();
                                                str7 = this.webPoTokenStreamingPot;
                                                str7.getClass();
                                                if (i != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                z.unlock(null);
                                                anonymousClass3.L$0 = str;
                                                anonymousClass3.L$1 = str3;
                                                anonymousClass3.L$2 = null;
                                                anonymousClass3.L$3 = str7;
                                                anonymousClass3.Z$0 = r12;
                                                anonymousClass3.Z$1 = z2;
                                                anonymousClass3.label = 5;
                                                newPoTokenGenerator = poTokenWebView10.generatePoToken(str, anonymousClass3);
                                                if (newPoTokenGenerator != coroutineSingletons) {
                                                    String str113 = str3;
                                                    str8 = str;
                                                    z3 = z2;
                                                    str9 = str113;
                                                    str10 = str7;
                                                    r12 = r12;
                                                    String str114 = (String) newPoTokenGenerator;
                                                    Timber.Forest.tag(this.TAG);
                                                    ConnectionPool.d(new Object[0]);
                                                    return new PoTokenResult(str10, str114);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    str3 = str2;
                                    r12 = r13;
                                    z = mutex;
                                    PoTokenWebView poTokenWebView11 = this.webPoTokenGenerator;
                                    poTokenWebView11.getClass();
                                    str7 = this.webPoTokenStreamingPot;
                                    str7.getClass();
                                    if (i != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    z.unlock(null);
                                    anonymousClass3.L$0 = str;
                                    anonymousClass3.L$1 = str3;
                                    anonymousClass3.L$2 = null;
                                    anonymousClass3.L$3 = str7;
                                    anonymousClass3.Z$0 = r12;
                                    anonymousClass3.Z$1 = z2;
                                    anonymousClass3.label = 5;
                                    newPoTokenGenerator = poTokenWebView11.generatePoToken(str, anonymousClass3);
                                    if (newPoTokenGenerator != coroutineSingletons) {
                                        String str115 = str3;
                                        str8 = str;
                                        z3 = z2;
                                        str9 = str115;
                                        str10 = str7;
                                        r12 = r12;
                                        String str116 = (String) newPoTokenGenerator;
                                        Timber.Forest.tag(this.TAG);
                                        ConnectionPool.d(new Object[0]);
                                        return new PoTokenResult(str10, str116);
                                    }
                                }
                            } else {
                                i = 1;
                                if (i != 0) {
                                    Timber.Forest.tag(this.TAG);
                                    ConnectionPool.d(new Object[0]);
                                    DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                                    handlerContext = MainDispatcherLoader.dispatcher;
                                    poTokenGenerator$getWebClientPoToken$4$1 = new PoTokenGenerator$getWebClientPoToken$4$1(this, null);
                                    anonymousClass3.L$0 = str;
                                    anonymousClass3.L$1 = str2;
                                    anonymousClass3.L$2 = mutex;
                                    anonymousClass3.Z$0 = r13;
                                    anonymousClass3.I$0 = i;
                                    anonymousClass3.label = 2;
                                    if (AwaitKt.withContext(handlerContext, poTokenGenerator$getWebClientPoToken$4$1, anonymousClass3) != coroutineSingletons) {
                                        str4 = str;
                                        i2 = i;
                                        str5 = str2;
                                        r14 = r13;
                                        mutex2 = mutex;
                                        this.webPoTokenGenerator = null;
                                        this.webPoTokenStreamingPot = null;
                                        this.webPoTokenSessionId = null;
                                        PoTokenWebView.Companion companion4 = PoTokenWebView.INSTANCE;
                                        Context context4 = this.applicationContext;
                                        context4.getClass();
                                        anonymousClass3.L$0 = str4;
                                        anonymousClass3.L$1 = str5;
                                        anonymousClass3.L$2 = mutex2;
                                        anonymousClass3.Z$0 = r14;
                                        anonymousClass3.I$0 = i2;
                                        anonymousClass3.label = 3;
                                        newPoTokenGenerator = companion4.getNewPoTokenGenerator(context4, anonymousClass3);
                                        r15 = r14;
                                        if (newPoTokenGenerator != coroutineSingletons) {
                                            str6 = str4;
                                            str3 = str5;
                                            Mutex mutex7 = mutex2;
                                            PoTokenWebView poTokenWebView12 = (PoTokenWebView) newPoTokenGenerator;
                                            anonymousClass3.L$0 = str6;
                                            anonymousClass3.L$1 = str3;
                                            anonymousClass3.L$2 = mutex7;
                                            anonymousClass3.L$3 = poTokenWebView12;
                                            anonymousClass3.Z$0 = r15;
                                            anonymousClass3.I$0 = i2;
                                            anonymousClass3.label = 4;
                                            newPoTokenGenerator = poTokenWebView12.generatePoToken(str3, anonymousClass3);
                                            r1 = mutex7;
                                            r16 = r15;
                                            z = poTokenWebView12;
                                            if (newPoTokenGenerator == coroutineSingletons) {
                                                String str117 = (String) newPoTokenGenerator;
                                                this.webPoTokenGenerator = z;
                                                this.webPoTokenStreamingPot = str117;
                                                this.webPoTokenSessionId = str3;
                                                Timber.Forest.tag(this.TAG);
                                                ConnectionPool.d(new Object[0]);
                                                z = r1;
                                                i = i2;
                                                str = str6;
                                                r12 = r16;
                                                PoTokenWebView poTokenWebView13 = this.webPoTokenGenerator;
                                                poTokenWebView13.getClass();
                                                str7 = this.webPoTokenStreamingPot;
                                                str7.getClass();
                                                if (i != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                z.unlock(null);
                                                anonymousClass3.L$0 = str;
                                                anonymousClass3.L$1 = str3;
                                                anonymousClass3.L$2 = null;
                                                anonymousClass3.L$3 = str7;
                                                anonymousClass3.Z$0 = r12;
                                                anonymousClass3.Z$1 = z2;
                                                anonymousClass3.label = 5;
                                                newPoTokenGenerator = poTokenWebView13.generatePoToken(str, anonymousClass3);
                                                if (newPoTokenGenerator != coroutineSingletons) {
                                                    String str118 = str3;
                                                    str8 = str;
                                                    z3 = z2;
                                                    str9 = str118;
                                                    str10 = str7;
                                                    r12 = r12;
                                                    String str119 = (String) newPoTokenGenerator;
                                                    Timber.Forest.tag(this.TAG);
                                                    ConnectionPool.d(new Object[0]);
                                                    return new PoTokenResult(str10, str119);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    str3 = str2;
                                    r12 = r13;
                                    z = mutex;
                                    PoTokenWebView poTokenWebView14 = this.webPoTokenGenerator;
                                    poTokenWebView14.getClass();
                                    str7 = this.webPoTokenStreamingPot;
                                    str7.getClass();
                                    if (i != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    z.unlock(null);
                                    anonymousClass3.L$0 = str;
                                    anonymousClass3.L$1 = str3;
                                    anonymousClass3.L$2 = null;
                                    anonymousClass3.L$3 = str7;
                                    anonymousClass3.Z$0 = r12;
                                    anonymousClass3.Z$1 = z2;
                                    anonymousClass3.label = 5;
                                    newPoTokenGenerator = poTokenWebView14.generatePoToken(str, anonymousClass3);
                                    if (newPoTokenGenerator != coroutineSingletons) {
                                        String str1110 = str3;
                                        str8 = str;
                                        z3 = z2;
                                        str9 = str1110;
                                        str10 = str7;
                                        r12 = r12;
                                        String str1111 = (String) newPoTokenGenerator;
                                        Timber.Forest.tag(this.TAG);
                                        ConnectionPool.d(new Object[0]);
                                        return new PoTokenResult(str10, str1111);
                                    }
                                }
                            }
                            return coroutineSingletons;
                        case 2:
                            i2 = anonymousClass3.I$0;
                            boolean z5 = anonymousClass3.Z$0;
                            mutex2 = (Mutex) anonymousClass3.L$2;
                            str5 = (String) anonymousClass3.L$1;
                            str4 = (String) anonymousClass3.L$0;
                            ResultKt.throwOnFailure(newPoTokenGenerator);
                            r14 = z5;
                            this.webPoTokenGenerator = null;
                            this.webPoTokenStreamingPot = null;
                            this.webPoTokenSessionId = null;
                            PoTokenWebView.Companion companion5 = PoTokenWebView.INSTANCE;
                            Context context5 = this.applicationContext;
                            context5.getClass();
                            anonymousClass3.L$0 = str4;
                            anonymousClass3.L$1 = str5;
                            anonymousClass3.L$2 = mutex2;
                            anonymousClass3.Z$0 = r14;
                            anonymousClass3.I$0 = i2;
                            anonymousClass3.label = 3;
                            newPoTokenGenerator = companion5.getNewPoTokenGenerator(context5, anonymousClass3);
                            r15 = r14;
                            if (newPoTokenGenerator != coroutineSingletons) {
                                str6 = str4;
                                str3 = str5;
                                Mutex mutex8 = mutex2;
                                PoTokenWebView poTokenWebView15 = (PoTokenWebView) newPoTokenGenerator;
                                anonymousClass3.L$0 = str6;
                                anonymousClass3.L$1 = str3;
                                anonymousClass3.L$2 = mutex8;
                                anonymousClass3.L$3 = poTokenWebView15;
                                anonymousClass3.Z$0 = r15;
                                anonymousClass3.I$0 = i2;
                                anonymousClass3.label = 4;
                                newPoTokenGenerator = poTokenWebView15.generatePoToken(str3, anonymousClass3);
                                r1 = mutex8;
                                r16 = r15;
                                z = poTokenWebView15;
                                if (newPoTokenGenerator == coroutineSingletons) {
                                    String str1112 = (String) newPoTokenGenerator;
                                    this.webPoTokenGenerator = z;
                                    this.webPoTokenStreamingPot = str1112;
                                    this.webPoTokenSessionId = str3;
                                    Timber.Forest.tag(this.TAG);
                                    ConnectionPool.d(new Object[0]);
                                    z = r1;
                                    i = i2;
                                    str = str6;
                                    r12 = r16;
                                    PoTokenWebView poTokenWebView16 = this.webPoTokenGenerator;
                                    poTokenWebView16.getClass();
                                    str7 = this.webPoTokenStreamingPot;
                                    str7.getClass();
                                    if (i != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    z.unlock(null);
                                    anonymousClass3.L$0 = str;
                                    anonymousClass3.L$1 = str3;
                                    anonymousClass3.L$2 = null;
                                    anonymousClass3.L$3 = str7;
                                    anonymousClass3.Z$0 = r12;
                                    anonymousClass3.Z$1 = z2;
                                    anonymousClass3.label = 5;
                                    newPoTokenGenerator = poTokenWebView16.generatePoToken(str, anonymousClass3);
                                    if (newPoTokenGenerator != coroutineSingletons) {
                                        String str1113 = str3;
                                        str8 = str;
                                        z3 = z2;
                                        str9 = str1113;
                                        str10 = str7;
                                        r12 = r12;
                                        String str1114 = (String) newPoTokenGenerator;
                                        Timber.Forest.tag(this.TAG);
                                        ConnectionPool.d(new Object[0]);
                                        return new PoTokenResult(str10, str1114);
                                    }
                                }
                            }
                            return coroutineSingletons;
                        case 3:
                            i2 = anonymousClass3.I$0;
                            boolean z6 = anonymousClass3.Z$0;
                            mutex2 = (Mutex) anonymousClass3.L$2;
                            str5 = (String) anonymousClass3.L$1;
                            str4 = (String) anonymousClass3.L$0;
                            ResultKt.throwOnFailure(newPoTokenGenerator);
                            r15 = z6;
                            str6 = str4;
                            str3 = str5;
                            Mutex mutex9 = mutex2;
                            PoTokenWebView poTokenWebView17 = (PoTokenWebView) newPoTokenGenerator;
                            anonymousClass3.L$0 = str6;
                            anonymousClass3.L$1 = str3;
                            anonymousClass3.L$2 = mutex9;
                            anonymousClass3.L$3 = poTokenWebView17;
                            anonymousClass3.Z$0 = r15;
                            anonymousClass3.I$0 = i2;
                            anonymousClass3.label = 4;
                            newPoTokenGenerator = poTokenWebView17.generatePoToken(str3, anonymousClass3);
                            r1 = mutex9;
                            r16 = r15;
                            z = poTokenWebView17;
                            if (newPoTokenGenerator == coroutineSingletons) {
                                String str1115 = (String) newPoTokenGenerator;
                                this.webPoTokenGenerator = z;
                                this.webPoTokenStreamingPot = str1115;
                                this.webPoTokenSessionId = str3;
                                Timber.Forest.tag(this.TAG);
                                ConnectionPool.d(new Object[0]);
                                z = r1;
                                i = i2;
                                str = str6;
                                r12 = r16;
                                PoTokenWebView poTokenWebView18 = this.webPoTokenGenerator;
                                poTokenWebView18.getClass();
                                str7 = this.webPoTokenStreamingPot;
                                str7.getClass();
                                if (i != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                z.unlock(null);
                                anonymousClass3.L$0 = str;
                                anonymousClass3.L$1 = str3;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.L$3 = str7;
                                anonymousClass3.Z$0 = r12;
                                anonymousClass3.Z$1 = z2;
                                anonymousClass3.label = 5;
                                newPoTokenGenerator = poTokenWebView18.generatePoToken(str, anonymousClass3);
                                if (newPoTokenGenerator != coroutineSingletons) {
                                    String str1116 = str3;
                                    str8 = str;
                                    z3 = z2;
                                    str9 = str1116;
                                    str10 = str7;
                                    r12 = r12;
                                    String str1117 = (String) newPoTokenGenerator;
                                    Timber.Forest.tag(this.TAG);
                                    ConnectionPool.d(new Object[0]);
                                    return new PoTokenResult(str10, str1117);
                                }
                            }
                            return coroutineSingletons;
                        case 4:
                            i2 = anonymousClass3.I$0;
                            boolean z7 = anonymousClass3.Z$0;
                            PoTokenWebView poTokenWebView19 = (PoTokenWebView) anonymousClass3.L$3;
                            Mutex mutex10 = (Mutex) anonymousClass3.L$2;
                            str3 = (String) anonymousClass3.L$1;
                            str6 = (String) anonymousClass3.L$0;
                            ResultKt.throwOnFailure(newPoTokenGenerator);
                            r1 = mutex10;
                            r16 = z7;
                            z = poTokenWebView19;
                            String str1118 = (String) newPoTokenGenerator;
                            this.webPoTokenGenerator = z;
                            this.webPoTokenStreamingPot = str1118;
                            this.webPoTokenSessionId = str3;
                            Timber.Forest.tag(this.TAG);
                            ConnectionPool.d(new Object[0]);
                            z = r1;
                            i = i2;
                            str = str6;
                            r12 = r16;
                            PoTokenWebView poTokenWebView110 = this.webPoTokenGenerator;
                            poTokenWebView110.getClass();
                            str7 = this.webPoTokenStreamingPot;
                            str7.getClass();
                            if (i != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z.unlock(null);
                            anonymousClass3.L$0 = str;
                            anonymousClass3.L$1 = str3;
                            anonymousClass3.L$2 = null;
                            anonymousClass3.L$3 = str7;
                            anonymousClass3.Z$0 = r12;
                            anonymousClass3.Z$1 = z2;
                            anonymousClass3.label = 5;
                            newPoTokenGenerator = poTokenWebView110.generatePoToken(str, anonymousClass3);
                            if (newPoTokenGenerator != coroutineSingletons) {
                                String str1119 = str3;
                                str8 = str;
                                z3 = z2;
                                str9 = str1119;
                                str10 = str7;
                                r12 = r12;
                                String str11110 = (String) newPoTokenGenerator;
                                Timber.Forest.tag(this.TAG);
                                ConnectionPool.d(new Object[0]);
                                return new PoTokenResult(str10, str11110);
                            }
                            return coroutineSingletons;
                        case 5:
                            z3 = anonymousClass3.Z$1;
                            r12 = anonymousClass3.Z$0;
                            str10 = (String) anonymousClass3.L$3;
                            str9 = (String) anonymousClass3.L$1;
                            str8 = (String) anonymousClass3.L$0;
                            try {
                                ResultKt.throwOnFailure(newPoTokenGenerator);
                                r12 = r12;
                                String str11111 = (String) newPoTokenGenerator;
                                Timber.Forest.tag(this.TAG);
                                ConnectionPool.d(new Object[0]);
                                return new PoTokenResult(str10, str11111);
                            } catch (Throwable th3) {
                                th = th3;
                                if (!z3) {
                                    throw th;
                                }
                                Timber.Forest.tag(this.TAG);
                                ConnectionPool.e(new Object[0]);
                                anonymousClass3.L$0 = null;
                                anonymousClass3.L$1 = null;
                                anonymousClass3.L$2 = null;
                                anonymousClass3.L$3 = null;
                                anonymousClass3.L$4 = null;
                                anonymousClass3.Z$0 = r12;
                                anonymousClass3.Z$1 = z3;
                                anonymousClass3.label = 6;
                                webClientPoToken = getWebClientPoToken(str8, str9, true, anonymousClass3);
                                if (webClientPoToken != coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                return webClientPoToken;
                            }
                        case 6:
                            ResultKt.throwOnFailure(newPoTokenGenerator);
                            return newPoTokenGenerator;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = r1;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            try {
                z.close();
            } catch (Throwable unused) {
            }
            throw th6;
        }
    }

    private final boolean getWebViewSupported() {
        return ((Boolean) this.webViewSupported.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean webViewSupported_delegate$lambda$0(PoTokenGenerator poTokenGenerator) {
        Object failure;
        try {
            failure = CookieManager.getInstance();
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        return !(failure instanceof Result.Failure);
    }

    public final Object close(Continuation continuation) throws Throwable {
        Object objClearGenerator = clearGenerator(continuation);
        return objClearGenerator == CoroutineSingletons.COROUTINE_SUSPENDED ? objClearGenerator : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/utils/potoken/PoTokenGenerator$Companion;", "", "<init>", "()V", "POTOKEN_TIMEOUT_MS", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getWebClientPoToken(String str, String str2, Continuation continuation) {
        C01951 c01951;
        if (continuation instanceof C01951) {
            c01951 = (C01951) continuation;
            int i = c01951.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01951.label = i - Integer.MIN_VALUE;
            } else {
                c01951 = new C01951(continuation);
            }
        } else {
            c01951 = new C01951(continuation);
        }
        Object objWithTimeout = c01951.result;
        int i2 = c01951.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                ConnectionPool connectionPool = Timber.Forest;
                connectionPool.tag(this.TAG);
                getWebViewSupported();
                ConnectionPool.d(new Object[0]);
                if (getWebViewSupported() && !this.webViewBadImpl) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, str2, null);
                    c01951.L$0 = null;
                    c01951.L$1 = null;
                    c01951.label = 1;
                    objWithTimeout = AwaitKt.withTimeout(POTOKEN_TIMEOUT_MS, anonymousClass2, c01951);
                    if (objWithTimeout == obj) {
                        return obj;
                    }
                } else {
                    connectionPool.tag(this.TAG);
                    getWebViewSupported();
                    ConnectionPool.d(new Object[0]);
                    return null;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objWithTimeout);
                    return null;
                }
                ResultKt.throwOnFailure(objWithTimeout);
            }
            return (PoTokenResult) objWithTimeout;
        } catch (BadWebViewException unused) {
            Timber.Forest.tag(this.TAG);
            ConnectionPool.e(new Object[0]);
            this.webViewBadImpl = true;
        } catch (TimeoutCancellationException unused2) {
            Timber.Forest.tag(this.TAG);
            ConnectionPool.w(new Object[0]);
            c01951.L$0 = null;
            c01951.L$1 = null;
            c01951.L$2 = null;
            c01951.label = 2;
            if (clearGenerator(c01951) == obj) {
                return obj;
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            Timber.Forest.tag(this.TAG);
            String simpleName = Reflection.getOrCreateKotlinClass(e2.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "unknown";
            }
            "PO token generation failed type=".concat(simpleName);
            ConnectionPool.e(new Object[0]);
            throw e2;
        }
    }
}
