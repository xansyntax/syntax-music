package io.ktor.client;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.BodyProgressKt;
import io.ktor.client.plugins.DefaultResponseValidationKt;
import io.ktor.client.plugins.DefaultTransformKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpPlainTextKt;
import io.ktor.client.plugins.HttpRedirectKt;
import io.ktor.client.plugins.HttpRequestLifecycleKt;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.client.utils.HttpResponseReceiveFail;
import io.ktor.events.Events;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nB)\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001b\u001a\u00020\u00002\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\u00020*8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00100\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00105\u001a\u0002048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010?\u001a\u00020>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010D\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010H\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010M\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lio/ktor/client/HttpClient;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/engine/HttpClientEngine;", "engine", "Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "userConfig", "<init>", "(Lio/ktor/client/engine/HttpClientEngine;Lio/ktor/client/HttpClientConfig;)V", "", "manageEngine", "(Lio/ktor/client/engine/HttpClientEngine;Lio/ktor/client/HttpClientConfig;Z)V", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/call/HttpClientCall;", "execute$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lio/ktor/client/engine/HttpClientEngineCapability;", "capability", "isSupported", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Z", "Lkotlin/Function1;", "", "block", "config", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "close", "()V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/engine/HttpClientEngine;", "getEngine", "()Lio/ktor/client/engine/HttpClientEngine;", "Lio/ktor/client/HttpClientConfig;", "Z", "Lkotlinx/coroutines/CompletableJob;", "clientJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/client/request/HttpRequestPipeline;", "requestPipeline", "Lio/ktor/client/request/HttpRequestPipeline;", "getRequestPipeline", "()Lio/ktor/client/request/HttpRequestPipeline;", "Lio/ktor/client/statement/HttpResponsePipeline;", "responsePipeline", "Lio/ktor/client/statement/HttpResponsePipeline;", "getResponsePipeline", "()Lio/ktor/client/statement/HttpResponsePipeline;", "Lio/ktor/client/request/HttpSendPipeline;", "sendPipeline", "Lio/ktor/client/request/HttpSendPipeline;", "getSendPipeline", "()Lio/ktor/client/request/HttpSendPipeline;", "Lio/ktor/client/statement/HttpReceivePipeline;", "receivePipeline", "Lio/ktor/client/statement/HttpReceivePipeline;", "getReceivePipeline", "()Lio/ktor/client/statement/HttpReceivePipeline;", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "engineConfig", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getEngineConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "Lio/ktor/events/Events;", "monitor", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "getConfig$ktor_client_core", "()Lio/ktor/client/HttpClientConfig;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpClient implements CoroutineScope, Closeable {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");
    private final Attributes attributes;
    private final CompletableJob clientJob;
    private volatile /* synthetic */ int closed;
    private final HttpClientConfig<HttpClientEngineConfig> config;
    private final CoroutineContext coroutineContext;
    private final HttpClientEngine engine;
    private final HttpClientEngineConfig engineConfig;
    private boolean manageEngine;
    private final Events monitor;
    private final HttpReceivePipeline receivePipeline;
    private final HttpRequestPipeline requestPipeline;
    private final HttpResponsePipeline responsePipeline;
    private final HttpSendPipeline sendPipeline;
    private final HttpClientConfig<? extends HttpClientEngineConfig> userConfig;

    /* JADX INFO: renamed from: io.ktor.client.HttpClient$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "call"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", l = {1372, 1374}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = HttpClient.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = obj;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (obj2 instanceof HttpClientCall) {
                    HttpReceivePipeline receivePipeline = HttpClient.this.getReceivePipeline();
                    HttpResponse response = ((HttpClientCall) obj2).getResponse();
                    this.L$0 = pipelineContext;
                    this.L$1 = obj2;
                    this.label = 1;
                    obj = receivePipeline.execute(unit, response, this);
                    if (obj != coroutineSingletons) {
                    }
                }
                StringBuilder sb = new StringBuilder("Error: HttpClientCall expected, but found ");
                sb.append(obj2);
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(obj2.getClass());
                sb.append('(');
                sb.append(orCreateKotlinClass);
                sb.append(").");
                throw new IllegalStateException(sb.toString().toString());
            }
            if (i != 1) {
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            ResultKt.throwOnFailure(obj);
            ((HttpClientCall) obj2).setResponse$ktor_client_core((HttpResponse) obj);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            return pipelineContext.proceedWith(obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.HttpClient$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", l = {1406}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass4 extends SuspendLambda implements Function3 {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = HttpClient.this.new AnonymousClass4(continuation);
            anonymousClass4.L$0 = pipelineContext;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = pipelineContext;
                    this.label = 1;
                    obj = pipelineContext.proceed(this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                HttpClient.this.getMonitor().raise(ClientEventsKt.getHttpResponseReceiveFailed(), new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.getContext()).getResponse(), th));
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpClient(HttpClientEngine httpClientEngine, HttpClientConfig<? extends HttpClientEngineConfig> httpClientConfig) {
        httpClientEngine.getClass();
        httpClientConfig.getClass();
        this.engine = httpClientEngine;
        this.userConfig = httpClientConfig;
        Object[] objArr = 0;
        this.closed = 0;
        JobImpl jobImpl = new JobImpl((Job) httpClientEngine.getCoroutineContext().get(Job.Key.$$INSTANCE));
        this.clientJob = jobImpl;
        this.coroutineContext = httpClientEngine.getCoroutineContext().plus(jobImpl);
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.requestPipeline = new HttpRequestPipeline(false, i, defaultConstructorMarker);
        HttpResponsePipeline httpResponsePipeline = new HttpResponsePipeline(0 == true ? 1 : 0, i, defaultConstructorMarker);
        this.responsePipeline = httpResponsePipeline;
        HttpSendPipeline httpSendPipeline = new HttpSendPipeline(0 == true ? 1 : 0, i, defaultConstructorMarker);
        this.sendPipeline = httpSendPipeline;
        this.receivePipeline = new HttpReceivePipeline(0 == true ? 1 : 0, i, defaultConstructorMarker);
        this.attributes = AttributesJvmKt.Attributes(true);
        this.engineConfig = httpClientEngine.getConfig();
        this.monitor = new Events();
        HttpClientConfig<HttpClientEngineConfig> httpClientConfig2 = new HttpClientConfig<>();
        this.config = httpClientConfig2;
        httpClientEngine.install(this);
        httpSendPipeline.intercept(HttpSendPipeline.INSTANCE.getReceive(), new AnonymousClass2(null));
        HttpClientConfig.install$default(httpClientConfig2, HttpRequestLifecycleKt.getHttpRequestLifecycle(), null, 2, null);
        HttpClientConfig.install$default(httpClientConfig2, BodyProgressKt.getBodyProgress(), null, 2, null);
        HttpClientConfig.install$default(httpClientConfig2, DoubleReceivePluginKt.getSaveBody(), null, 2, null);
        if (httpClientConfig.getUseDefaultTransformers()) {
            httpClientConfig2.install("DefaultTransformers", new HttpClient$$ExternalSyntheticLambda1(objArr == true ? 1 : 0));
        }
        HttpClientConfig.install$default(httpClientConfig2, HttpSend.INSTANCE, null, 2, null);
        HttpClientConfig.install$default(httpClientConfig2, HttpCallValidatorKt.getHttpCallValidator(), null, 2, null);
        if (httpClientConfig.getFollowRedirects()) {
            HttpClientConfig.install$default(httpClientConfig2, HttpRedirectKt.getHttpRedirect(), null, 2, null);
        }
        httpClientConfig2.plusAssign(httpClientConfig);
        if (httpClientConfig.getUseDefaultTransformers()) {
            HttpClientConfig.install$default(httpClientConfig2, HttpPlainTextKt.getHttpPlainText(), null, 2, null);
        }
        DefaultResponseValidationKt.addDefaultResponseValidation(httpClientConfig2);
        httpClientConfig2.install(this);
        httpResponsePipeline.intercept(HttpResponsePipeline.INSTANCE.getReceive(), new AnonymousClass4(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    /* JADX WARN: Code duplicated, block: B:6:0x000f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    public static final Unit _init_$lambda$0(HttpClientEngine httpClientEngine, Throwable th) throws IOException {
        CancellationException CancellationException;
        if (httpClientEngine instanceof HttpClientEngineBase) {
            if (HttpClientEngineBase.clientRefCount$FU$internal.decrementAndGet((HttpClientEngineBase) httpClientEngine) <= 0) {
                if (th == null) {
                    httpClientEngine.close();
                } else {
                    if (th instanceof CancellationException) {
                        CancellationException = (CancellationException) th;
                    } else {
                        CancellationException = null;
                    }
                    if (CancellationException == null) {
                        CancellationException = AwaitKt.CancellationException("Client scope is canceled", th);
                    }
                    AwaitKt.cancel(httpClientEngine, CancellationException);
                }
            }
        } else if (th == null) {
            httpClientEngine.close();
        } else {
            if (th instanceof CancellationException) {
                CancellationException = (CancellationException) th;
            } else {
                CancellationException = null;
            }
            if (CancellationException == null) {
                CancellationException = AwaitKt.CancellationException("Client scope is canceled", th);
            }
            AwaitKt.cancel(httpClientEngine, CancellationException);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda$1$0(HttpClient httpClient) {
        httpClient.getClass();
        DefaultTransformKt.defaultTransformers(httpClient);
        return Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        boolean zIsTerminated;
        if (closed$FU.compareAndSet(this, 0, 1)) {
            Attributes attributes = (Attributes) this.attributes.get(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST());
            Iterator<T> it = attributes.getAllKeys().iterator();
            while (it.hasNext()) {
                AttributeKey attributeKey = (AttributeKey) it.next();
                attributeKey.getClass();
                Object obj = attributes.get(attributeKey);
                if (obj instanceof AutoCloseable) {
                    AutoCloseable autoCloseable = (AutoCloseable) obj;
                    if (autoCloseable instanceof AutoCloseable) {
                        autoCloseable.close();
                    } else if (autoCloseable instanceof ExecutorService) {
                        ExecutorService executorService = (ExecutorService) autoCloseable;
                        if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                            executorService.shutdown();
                            boolean z = false;
                            while (!zIsTerminated) {
                                try {
                                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                                } catch (InterruptedException unused) {
                                    if (!z) {
                                        executorService.shutdownNow();
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    } else if (autoCloseable instanceof TypedArray) {
                        ((TypedArray) autoCloseable).recycle();
                    } else if (autoCloseable instanceof MediaMetadataRetriever) {
                        ((MediaMetadataRetriever) autoCloseable).release();
                    } else {
                        if (!(autoCloseable instanceof MediaDrm)) {
                            Path$$ExternalSyntheticBUOutline0.m();
                            return;
                        }
                        ((MediaDrm) autoCloseable).release();
                    }
                }
            }
            ((JobImpl) this.clientJob).complete$1();
        }
    }

    public final HttpClient config(Function1 block) {
        block.getClass();
        HttpClientEngine httpClientEngine = this.engine;
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.plusAssign(this.userConfig);
        block.invoke(httpClientConfig);
        return new HttpClient(httpClientEngine, httpClientConfig, this.manageEngine);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object execute$ktor_client_core(HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        HttpClient$execute$1 httpClient$execute$1;
        if (continuation instanceof HttpClient$execute$1) {
            httpClient$execute$1 = (HttpClient$execute$1) continuation;
            int i = httpClient$execute$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                httpClient$execute$1.label = i - Integer.MIN_VALUE;
            } else {
                httpClient$execute$1 = new HttpClient$execute$1(this, continuation);
            }
        } else {
            httpClient$execute$1 = new HttpClient$execute$1(this, continuation);
        }
        Object objExecute = httpClient$execute$1.result;
        int i2 = httpClient$execute$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            this.monitor.raise(ClientEventsKt.getHttpRequestCreated(), httpRequestBuilder);
            HttpRequestPipeline httpRequestPipeline = this.requestPipeline;
            Object body = httpRequestBuilder.getBody();
            httpClient$execute$1.L$0 = null;
            httpClient$execute$1.label = 1;
            objExecute = httpRequestPipeline.execute(httpRequestBuilder, body, httpClient$execute$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objExecute == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
        }
        objExecute.getClass();
        return (HttpClientCall) objExecute;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final HttpClientConfig<HttpClientEngineConfig> getConfig$ktor_client_core() {
        return this.config;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final HttpClientEngine getEngine() {
        return this.engine;
    }

    public final HttpClientEngineConfig getEngineConfig() {
        return this.engineConfig;
    }

    public final Events getMonitor() {
        return this.monitor;
    }

    public final HttpReceivePipeline getReceivePipeline() {
        return this.receivePipeline;
    }

    public final HttpRequestPipeline getRequestPipeline() {
        return this.requestPipeline;
    }

    public final HttpResponsePipeline getResponsePipeline() {
        return this.responsePipeline;
    }

    public final HttpSendPipeline getSendPipeline() {
        return this.sendPipeline;
    }

    public final boolean isSupported(HttpClientEngineCapability<?> capability) {
        capability.getClass();
        return this.engine.getSupportedCapabilities().contains(capability);
    }

    public String toString() {
        return "HttpClient[" + this.engine + ']';
    }

    public /* synthetic */ HttpClient(HttpClientEngine httpClientEngine, HttpClientConfig httpClientConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClientEngine, (i & 2) != 0 ? new HttpClientConfig() : httpClientConfig);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClient(HttpClientEngine httpClientEngine, HttpClientConfig<? extends HttpClientEngineConfig> httpClientConfig, boolean z) {
        this(httpClientEngine, httpClientConfig);
        httpClientEngine.getClass();
        httpClientConfig.getClass();
        this.manageEngine = z;
        if (z) {
            if (httpClientEngine instanceof HttpClientEngineBase) {
                HttpClientEngineBase.clientRefCount$FU$internal.incrementAndGet((HttpClientEngineBase) httpClientEngine);
            }
            CoroutineContext.Element element = getCoroutineContext().get(Job.Key.$$INSTANCE);
            element.getClass();
            ((Job) element).invokeOnCompletion(new MimesKt$$ExternalSyntheticLambda0((byte) 22, httpClientEngine));
        }
    }
}
