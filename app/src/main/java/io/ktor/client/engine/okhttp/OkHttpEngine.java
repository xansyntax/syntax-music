package io.ktor.client.engine.okhttp;

import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.UCrop;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.io.PlatformStaticConfig_jvmKt;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.sse.SSECapability;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.plugins.websocket.WebSocketsKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.ResponseAdapter;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.CacheKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J7\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R$\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b0\u00101R\"\u00103\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0006028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "config", "<init>", "(Lio/ktor/client/engine/okhttp/OkHttpConfig;)V", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "callContext", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/client/request/HttpResponseData;", "executeWebSocketRequest", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeHttpRequest", "Lokhttp3/Response;", "response", "Lio/ktor/util/date/GMTDate;", "requestTime", "", "body", "buildResponseData", "(Lokhttp3/Response;Lio/ktor/util/date/GMTDate;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpResponseData;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutExtension", "createOkHttpClient", "(Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient;", "data", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "getConfig", "()Lio/ktor/client/engine/okhttp/OkHttpConfig;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "supportedCapabilities", "Ljava/util/Set;", "getSupportedCapabilities", "()Ljava/util/Set;", "requestsJob", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "", "clientCache", "Ljava/util/Map;", "Companion", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpEngine extends HttpClientEngineBase {
    private static final Companion Companion = new Companion(null);
    private static final Lazy okHttpClientPrototype$delegate = new SynchronizedLazyImpl(new Shazam$$ExternalSyntheticLambda0(23));
    private final Map<HttpTimeoutConfig, OkHttpClient> clientCache;
    private final OkHttpConfig config;
    private final CoroutineContext coroutineContext;
    private final CoroutineContext requestsJob;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", l = {52}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return OkHttpEngine.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.util.Iterator] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = AwaitKt.getJob(OkHttpEngine.this.requestsJob);
                    this.label = 1;
                    Object objJoin = job.join(this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objJoin == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (this.hasNext()) {
                    OkHttpClient okHttpClient = (OkHttpClient) ((Map.Entry) this.next()).getValue();
                    okHttpClient.connectionPool.evictAll();
                    okHttpClient.dispatcher.executorService().shutdown();
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                Iterator it = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (it.hasNext()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient2.connectionPool.evictAll();
                    okHttpClient2.dispatcher.executorService().shutdown();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {63, 70, 71}, m = "execute", v = 1)
    public static final class C02301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02301(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {107}, m = "executeHttpRequest", v = 1)
    public static final class C02311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C02311(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeHttpRequest(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2", f = "OkHttpEngine.kt", l = {115}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ResponseBody $body;
        final /* synthetic */ CoroutineContext $callContext;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CoroutineContext coroutineContext, ResponseBody responseBody, Continuation continuation) {
            super(2, continuation);
            this.$callContext = coroutineContext;
            this.$body = responseBody;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callContext, this.$body, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [okhttp3.ResponseBody] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = AwaitKt.getJob(this.$callContext);
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    Object objJoin = job.join(this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objJoin == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this = this.$body;
                try {
                    this.close();
                } catch (Throwable unused) {
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    this.$body.close();
                } catch (Throwable unused2) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {UCrop.RESULT_ERROR}, m = "executeWebSocketRequest", v = 1)
    public static final class C02321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C02321(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeWebSocketRequest(null, null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpConfig okHttpConfig) {
        super("ktor-okhttp");
        okHttpConfig.getClass();
        this.config = okHttpConfig;
        this.supportedCapabilities = ArraysKt.toSet(new HttpClientEngineCapability[]{HttpTimeoutCapability.INSTANCE, WebSocketCapability.INSTANCE, SSECapability.INSTANCE});
        this.clientCache = CacheKt.createLRUCache(new OkHttpEngine$clientCache$1(this), new HttpClient$$ExternalSyntheticLambda1((byte) 27), getConfig().getClientCacheSize());
        PlatformStaticConfig_jvmKt.configurePlatform();
        CoroutineContext coroutineContextSilentSupervisor = CoroutinesUtilsKt.SilentSupervisor(AwaitKt.getJob(super.getCoroutineContext()));
        this.requestsJob = coroutineContextSilentSupervisor;
        this.coroutineContext = super.getCoroutineContext().plus(coroutineContextSilentSupervisor);
        AwaitKt.launch(GlobalScope.INSTANCE, super.getCoroutineContext(), CoroutineStart.ATOMIC, new AnonymousClass1(null));
    }

    private final HttpResponseData buildResponseData(Response response, GMTDate requestTime, Object body, CoroutineContext callContext, HttpRequestData requestData) {
        CoroutineContext coroutineContext;
        Object obj;
        ResponseAdapter responseAdapter;
        HttpStatusCode httpStatusCode = new HttpStatusCode(response.code, response.message);
        HttpProtocolVersion httpProtocolVersionFromOkHttp = OkUtilsKt.fromOkHttp(response.protocol);
        Headers headersFromOkHttp = OkUtilsKt.fromOkHttp(response.headers);
        if ((body instanceof ByteReadChannel) && (responseAdapter = (ResponseAdapter) requestData.getAttributes().getOrNull(HttpRequestKt.getResponseAdapterAttributeKey())) != null) {
            coroutineContext = callContext;
            Object objAdapt = responseAdapter.adapt(requestData, httpStatusCode, headersFromOkHttp, (ByteReadChannel) body, requestData.getBody(), coroutineContext);
            if (objAdapt != null) {
                httpStatusCode = httpStatusCode;
                obj = objAdapt;
            }
            return new HttpResponseData(httpStatusCode, requestTime, headersFromOkHttp, httpProtocolVersionFromOkHttp, obj, coroutineContext);
        }
        coroutineContext = callContext;
        httpStatusCode = httpStatusCode;
        obj = body;
        return new HttpResponseData(httpStatusCode, requestTime, headersFromOkHttp, httpProtocolVersionFromOkHttp, obj, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clientCache$lambda$0(OkHttpClient okHttpClient) {
        okHttpClient.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient createOkHttpClient(HttpTimeoutConfig timeoutExtension) {
        OkHttpClient preconfigured = getConfig().getPreconfigured();
        if (preconfigured == null) {
            preconfigured = Companion.getOkHttpClientPrototype();
        }
        OkHttpClient.Builder builderNewBuilder = preconfigured.newBuilder();
        if (getConfig().getPreconfigured() == null) {
            builderNewBuilder.dispatcher = new Dispatcher((byte) 0);
        }
        getConfig().getConfig().invoke(builderNewBuilder);
        Proxy proxy = getConfig().getProxy();
        if (proxy != null) {
            builderNewBuilder.proxy(proxy);
        }
        Dns dns = getConfig().getDns();
        if (dns != null) {
            if (!dns.equals(builderNewBuilder.dns)) {
                builderNewBuilder.routeDatabase = null;
            }
            builderNewBuilder.dns = dns;
        }
        if (timeoutExtension != null) {
            OkHttpEngineKt.setupTimeoutAttributes(builderNewBuilder, timeoutExtension);
        }
        return new OkHttpClient(builderNewBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object executeHttpRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation continuation) {
        C02311 c02311;
        GMTDate gMTDate;
        if (continuation instanceof C02311) {
            c02311 = (C02311) continuation;
            int i = c02311.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02311.label = i - Integer.MIN_VALUE;
            } else {
                c02311 = new C02311(continuation);
            }
        } else {
            c02311 = new C02311(continuation);
        }
        Object obj = c02311.result;
        int i2 = c02311.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            GMTDate gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            c02311.L$0 = null;
            c02311.L$1 = null;
            c02311.L$2 = coroutineContext;
            c02311.L$3 = httpRequestData;
            c02311.L$4 = gMTDateGMTDate$default;
            c02311.label = 1;
            Object objExecute = OkUtilsKt.execute(okHttpClient, request, httpRequestData, coroutineContext, c02311);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objExecute == coroutineSingletons) {
                return coroutineSingletons;
            }
            gMTDate = gMTDateGMTDate$default;
            obj = objExecute;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            GMTDate gMTDate2 = (GMTDate) c02311.L$4;
            httpRequestData = (HttpRequestData) c02311.L$3;
            coroutineContext = (CoroutineContext) c02311.L$2;
            ResultKt.throwOnFailure(obj);
            gMTDate = gMTDate2;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        HttpRequestData httpRequestData2 = httpRequestData;
        Response response = (Response) obj;
        ResponseBody responseBody = response.body;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(this.requestsJob.plus(getDispatcher()).plus(new CoroutineName("okhttp-response-body-close"))), null, CoroutineStart.ATOMIC, new AnonymousClass2(coroutineContext2, responseBody, null), 1);
        return buildResponseData(response, gMTDate, OkHttpEngineKt.toChannel(responseBody.source(), coroutineContext2, httpRequestData2), coroutineContext2, httpRequestData2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object executeWebSocketRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation continuation) {
        C02321 c02321;
        HttpRequestData httpRequestData2;
        CoroutineContext coroutineContext2;
        GMTDate gMTDate;
        Object obj;
        if (continuation instanceof C02321) {
            c02321 = (C02321) continuation;
            int i = c02321.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02321.label = i - Integer.MIN_VALUE;
            } else {
                c02321 = new C02321(continuation);
            }
        } else {
            c02321 = new C02321(continuation);
        }
        Object obj2 = c02321.result;
        int i2 = c02321.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            GMTDate gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            WebSockets webSockets = (WebSockets) httpRequestData.getAttributes().get(WebSocketsKt.getWEBSOCKETS_KEY());
            WebSocket.Factory webSocketFactory = getConfig().getWebSocketFactory();
            OkHttpWebsocketSession okHttpWebsocketSession = new OkHttpWebsocketSession(okHttpClient, webSocketFactory == null ? okHttpClient : webSocketFactory, request, coroutineContext, webSockets);
            okHttpWebsocketSession.start();
            CompletableDeferred originResponse$ktor_client_okhttp = okHttpWebsocketSession.getOriginResponse();
            c02321.L$0 = null;
            c02321.L$1 = null;
            c02321.L$2 = coroutineContext;
            c02321.L$3 = httpRequestData;
            c02321.L$4 = gMTDateGMTDate$default;
            c02321.L$5 = null;
            c02321.L$6 = okHttpWebsocketSession;
            c02321.label = 1;
            Object objAwaitInternal = ((CompletableDeferredImpl) originResponse$ktor_client_okhttp).awaitInternal(c02321);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitInternal == coroutineSingletons) {
                return coroutineSingletons;
            }
            httpRequestData2 = httpRequestData;
            coroutineContext2 = coroutineContext;
            gMTDate = gMTDateGMTDate$default;
            obj = okHttpWebsocketSession;
            obj2 = objAwaitInternal;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Object obj3 = (OkHttpWebsocketSession) c02321.L$6;
            GMTDate gMTDate2 = (GMTDate) c02321.L$4;
            HttpRequestData httpRequestData3 = (HttpRequestData) c02321.L$3;
            CoroutineContext coroutineContext3 = (CoroutineContext) c02321.L$2;
            ResultKt.throwOnFailure(obj2);
            obj = obj3;
            gMTDate = gMTDate2;
            httpRequestData2 = httpRequestData3;
            coroutineContext2 = coroutineContext3;
        }
        return buildResponseData((Response) obj2, gMTDate, obj, coroutineContext2, httpRequestData2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient okHttpClientPrototype_delegate$lambda$0() {
        return new OkHttpClient(new OkHttpClient.Builder());
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        CoroutineContext.Element element = this.requestsJob.get(Job.Key.$$INSTANCE);
        element.getClass();
        ((JobImpl) ((CompletableJob) element)).complete$1();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Override // io.ktor.client.engine.HttpClientEngine
    public Object execute(HttpRequestData httpRequestData, Continuation continuation) {
        C02301 c02301;
        if (continuation instanceof C02301) {
            c02301 = (C02301) continuation;
            int i = c02301.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02301.label = i - Integer.MIN_VALUE;
            } else {
                c02301 = new C02301(continuation);
            }
        } else {
            c02301 = new C02301(continuation);
        }
        C02301 c02302 = c02301;
        Object objCallContext = c02302.result;
        int i2 = c02302.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCallContext);
            c02302.L$0 = httpRequestData;
            c02302.label = 1;
            objCallContext = UtilsKt.callContext(c02302);
            if (objCallContext != obj) {
            }
            return obj;
        }
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objCallContext);
            return objCallContext;
        }
        httpRequestData = (HttpRequestData) c02302.L$0;
        ResultKt.throwOnFailure(objCallContext);
        HttpRequestData httpRequestData2 = httpRequestData;
        CoroutineContext coroutineContext = (CoroutineContext) objCallContext;
        Request requestConvertToOkHttpRequest = OkHttpEngineKt.convertToOkHttpRequest(httpRequestData2, coroutineContext, getConfig());
        OkHttpClient okHttpClient = this.clientCache.get(httpRequestData2.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE));
        if (okHttpClient == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("OkHttpClient can't be constructed because HttpTimeout plugin is not installed");
            return null;
        }
        if (HttpRequestKt.isUpgradeRequest(httpRequestData2)) {
            c02302.L$0 = null;
            c02302.L$1 = null;
            c02302.L$2 = null;
            c02302.L$3 = null;
            c02302.label = 2;
            Object objExecuteWebSocketRequest = executeWebSocketRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, httpRequestData2, c02302);
            if (objExecuteWebSocketRequest != obj) {
                return objExecuteWebSocketRequest;
            }
        } else {
            c02302.L$0 = null;
            c02302.L$1 = null;
            c02302.L$2 = null;
            c02302.L$3 = null;
            c02302.label = 3;
            Object objExecuteHttpRequest = executeHttpRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, httpRequestData2, c02302);
            if (objExecuteHttpRequest != obj) {
                return objExecuteHttpRequest;
            }
        }
        return obj;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine$Companion;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "okHttpClientPrototype$delegate", "Lkotlin/Lazy;", "getOkHttpClientPrototype", "()Lokhttp3/OkHttpClient;", "okHttpClientPrototype", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OkHttpClient getOkHttpClientPrototype() {
            return (OkHttpClient) OkHttpEngine.okHttpClientPrototype$delegate.getValue();
        }

        private Companion() {
        }
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public OkHttpConfig getConfig() {
        return this.config;
    }
}
