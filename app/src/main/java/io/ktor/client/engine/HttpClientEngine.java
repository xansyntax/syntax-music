package io.ktor.client.engine;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#À\u0006\u0003"}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "client", "", "install", "(Lio/ktor/client/HttpClient;)V", "requestData", "executeWithinCallContext", "checkExtensions", "(Lio/ktor/client/request/HttpRequestData;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "config", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "supportedCapabilities", "", "getClosed", "()Z", "closed", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HttpClientEngine extends CoroutineScope, Closeable {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            return HttpClientEngine.super.getSupportedCapabilities();
        }

        @Deprecated
        public static void install(HttpClientEngine httpClientEngine, HttpClient httpClient) {
            httpClient.getClass();
            HttpClientEngine.super.install(httpClient);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine", f = "HttpClientEngine.kt", l = {172, 181}, m = "executeWithinCallContext", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientEngine.this.executeWithinCallContext(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/request/HttpResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", l = {180}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ HttpRequestData $requestData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequestData httpRequestData, Continuation continuation) {
            super(2, continuation);
            this.$requestData = httpRequestData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HttpClientEngine.this.new AnonymousClass2(this.$requestData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            if (HttpClientEngine.this.getClosed()) {
                throw new ClientEngineClosedException(null, 1, null);
            }
            HttpClientEngine httpClientEngine = HttpClientEngine.this;
            HttpRequestData httpRequestData = this.$requestData;
            this.label = 1;
            Object objExecute = httpClientEngine.execute(httpRequestData, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.HttpClientEngine$install$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", l = {151, 163}, m = "invokeSuspend", v = 1)
    public static final class C02291 extends SuspendLambda implements Function3 {
        final /* synthetic */ HttpClient $client;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ HttpClientEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02291(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation continuation) {
            super(3, continuation);
            this.$client = httpClient;
            this.this$0 = httpClientEngine;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(HttpClient httpClient, HttpResponse httpResponse, Throwable th) {
            if (th != null) {
                httpClient.getMonitor().raise(ClientEventsKt.getHttpResponseCancelled(), httpResponse);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
            C02291 c02291 = new C02291(this.$client, this.this$0, continuation);
            c02291.L$0 = pipelineContext;
            c02291.L$1 = obj;
            return c02291.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0100, code lost:
        
            if (r0.proceedWith(r2, r9) == r6) goto L30;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TypeReference typeReferenceTypeOf;
            HttpRequestData httpRequestDataBuild;
            TypeReference typeReferenceTypeOf2;
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            int i = this.label;
            byte b = 1;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i != 0) {
                if (i == 1) {
                    httpRequestDataBuild = (HttpRequestData) this.L$3;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.takeFromWithExecutionContext((HttpRequestBuilder) pipelineContext.getContext());
            if (obj2 == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    typeReferenceTypeOf2 = Reflection.typeOf(Object.class);
                } catch (Throwable unused) {
                    typeReferenceTypeOf2 = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf2, httpRequestBuilder);
            } else if (obj2 instanceof OutgoingContent) {
                httpRequestBuilder.setBody(obj2);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(obj2);
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(Object.class);
                } catch (Throwable unused2) {
                    typeReferenceTypeOf = null;
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass2, false, typeReferenceTypeOf, httpRequestBuilder);
            }
            this.$client.getMonitor().raise(ClientEventsKt.getHttpRequestIsReadyForSending(), httpRequestBuilder);
            httpRequestDataBuild = httpRequestBuilder.build();
            httpRequestDataBuild.getAttributes().put(HttpClientEngineKt.getCLIENT_CONFIG(), this.$client.getConfig$ktor_client_core());
            HttpClientEngineKt.validateHeaders(httpRequestDataBuild);
            this.this$0.checkExtensions(httpRequestDataBuild);
            HttpClientEngine httpClientEngine = this.this$0;
            this.L$0 = pipelineContext;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = httpRequestDataBuild;
            this.label = 1;
            obj = httpClientEngine.executeWithinCallContext(httpRequestDataBuild, this);
            if (obj != coroutineSingletons) {
            }
            return coroutineSingletons;
            HttpClientCall httpClientCall = new HttpClientCall(this.$client, httpRequestDataBuild, (HttpResponseData) obj);
            HttpResponse response = httpClientCall.getResponse();
            this.$client.getMonitor().raise(ClientEventsKt.getHttpResponseReceived(), response);
            AwaitKt.getJob(response.getCoroutineContext()).invokeOnCompletion(new UtilsKt$$ExternalSyntheticLambda0(this.$client, response, b));
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    default void checkExtensions(HttpRequestData requestData) {
        for (HttpClientEngineCapability<?> httpClientEngineCapability : requestData.getRequiredCapabilities$ktor_client_core()) {
            if (!getSupportedCapabilities().contains(httpClientEngineCapability)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$4(httpClientEngineCapability, "Engine doesn't support ");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    default Object executeWithinCallContext(HttpRequestData httpRequestData, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCreateCallContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCreateCallContext);
            Job executionContext = httpRequestData.getExecutionContext();
            anonymousClass1.L$0 = httpRequestData;
            anonymousClass1.label = 1;
            objCreateCallContext = HttpClientEngineKt.createCallContext(this, executionContext, anonymousClass1);
            if (objCreateCallContext != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objCreateCallContext);
            return objCreateCallContext;
        }
        httpRequestData = (HttpRequestData) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objCreateCallContext);
        CoroutineContext coroutineContext = (CoroutineContext) objCreateCallContext;
        DeferredCoroutine deferredCoroutineAsync$default = AwaitKt.async$default(this, coroutineContext.plus(new KtorCallContextElement(coroutineContext)), new AnonymousClass2(httpRequestData, null), 2);
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        Object objAwaitInternal = deferredCoroutineAsync$default.awaitInternal(anonymousClass1);
        return objAwaitInternal == coroutineSingletons ? coroutineSingletons : objAwaitInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    default boolean getClosed() {
        Job job = (Job) getCoroutineContext().get(Job.Key.$$INSTANCE);
        return !(job != null ? job.isActive() : false);
    }

    Object execute(HttpRequestData httpRequestData, Continuation continuation);

    HttpClientEngineConfig getConfig();

    @Override // kotlinx.coroutines.CoroutineScope
    /* synthetic */ CoroutineContext getCoroutineContext();

    CoroutineDispatcher getDispatcher();

    default Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return EmptySet.INSTANCE;
    }

    default void install(HttpClient client) {
        client.getClass();
        client.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getEngine(), new C02291(client, this, null));
    }
}
