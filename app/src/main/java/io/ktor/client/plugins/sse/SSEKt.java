package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0080@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\bH\u0080@¢\u0006\u0004\b\r\u0010\f\"\u001e\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\" \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \" \u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 ¨\u0006$"}, d2 = {"", "T", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/util/AttributeKey;", "attributeKey", "getAttributeValue", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "checkResponse", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saved", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/sse/SSEConfig;", "SSE", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE$annotations", "()V", "Lio/ktor/client/HttpClient;", "SSEClientForReconnectionAttr", "Lio/ktor/util/AttributeKey;", "getSSEClientForReconnectionAttr", "()Lio/ktor/util/AttributeKey;", "", "SSEReconnectionRequestAttr", "getSSEReconnectionRequestAttr", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SSEKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.sse.SSE");
    private static final ClientPlugin<SSEConfig> SSE = CreatePluginUtilsKt.createClientPlugin("SSE", SSEKt$SSE$1.INSTANCE, new SSEKt$$ExternalSyntheticLambda0(0));
    private static final AttributeKey<HttpClient> SSEClientForReconnectionAttr;
    private static final AttributeKey<Boolean> SSEReconnectionRequestAttr;

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.SSEKt$checkResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt", f = "SSE.kt", l = {202, 208}, m = "checkResponse", v = 1)
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
            return SSEKt.checkResponse(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.SSEKt$saved$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt", f = "SSE.kt", l = {215}, m = "saved", v = 1)
    public static final class C02571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02571(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSEKt.saved(null, this);
        }
    }

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpClient.class);
        TypeReference typeReferenceTypeOf2 = null;
        try {
            typeReferenceTypeOf = Reflection.typeOf(HttpClient.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        SSEClientForReconnectionAttr = new AttributeKey<>("SSEClientForReconnection", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            typeReferenceTypeOf2 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused2) {
        }
        SSEReconnectionRequestAttr = new AttributeKey<>("SSEReconnectionRequestAttr", new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SSE$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.on(AfterRender.INSTANCE, new SSEKt$SSE$2$1(clientPluginBuilder, ((SSEConfig) clientPluginBuilder.getPluginConfig()).getReconnectionTime(), ((SSEConfig) clientPluginBuilder.getPluginConfig()).getShowCommentEvents(), ((SSEConfig) clientPluginBuilder.getPluginConfig()).getShowRetryEvents(), ((SSEConfig) clientPluginBuilder.getPluginConfig()).getMaxReconnectionAttempts(), ((SSEConfig) clientPluginBuilder.getPluginConfig()).getBufferPolicy(), null));
        clientPluginBuilder.getClient().getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new SSEKt$SSE$2$2(null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object checkResponse(HttpResponse httpResponse, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        ContentType contentType;
        HttpStatusCode httpStatusCode;
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
        Object objSaved = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                httpStatusCode = (HttpStatusCode) anonymousClass1.L$1;
                ResultKt.throwOnFailure(objSaved);
                throw new SSEClientException((HttpResponse) objSaved, null, "Expected status code " + HttpStatusCode.INSTANCE.getOK().getValue() + " but was " + httpStatusCode.getValue(), 2, null);
            }
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            contentType = (ContentType) anonymousClass1.L$2;
            ResultKt.throwOnFailure(objSaved);
            throw new SSEClientException((HttpResponse) objSaved, null, "Expected Content-Type " + ContentType.Text.INSTANCE.getEventStream() + " but was " + contentType, 2, null);
        }
        ResultKt.throwOnFailure(objSaved);
        HttpStatusCode status = httpResponse.getStatus();
        ContentType contentType2 = HttpMessagePropertiesKt.contentType(httpResponse);
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        boolean zAreEqual = Intrinsics.areEqual(status, companion.getNoContent());
        Unit unit = Unit.INSTANCE;
        if (zAreEqual) {
            Logger logger = LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Receive status code NoContent for SSE request to " + HttpResponseKt.getRequest(httpResponse).getUrl());
            }
            return unit;
        }
        boolean zAreEqual2 = Intrinsics.areEqual(status, companion.getOK());
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (!zAreEqual2) {
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = status;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 1;
            Object objSaved2 = saved(httpResponse, anonymousClass1);
            if (objSaved2 != coroutineSingletons) {
                objSaved = objSaved2;
                httpStatusCode = status;
                throw new SSEClientException((HttpResponse) objSaved, null, "Expected status code " + HttpStatusCode.INSTANCE.getOK().getValue() + " but was " + httpStatusCode.getValue(), 2, null);
            }
        } else {
            if (contentType2 == null || Intrinsics.areEqual(contentType2.withoutParameters(), ContentType.Text.INSTANCE.getEventStream())) {
                return unit;
            }
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = contentType2;
            anonymousClass1.label = 2;
            objSaved = saved(httpResponse, anonymousClass1);
            if (objSaved != coroutineSingletons) {
                contentType = contentType2;
                throw new SSEClientException((HttpResponse) objSaved, null, "Expected Content-Type " + ContentType.Text.INSTANCE.getEventStream() + " but was " + contentType, 2, null);
            }
        }
        return coroutineSingletons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T getAttributeValue(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey) {
        return (T) httpRequestBuilder.getAttributes().getOrNull(attributeKey);
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final ClientPlugin<SSEConfig> getSSE() {
        return SSE;
    }

    public static final AttributeKey<HttpClient> getSSEClientForReconnectionAttr() {
        return SSEClientForReconnectionAttr;
    }

    public static final AttributeKey<Boolean> getSSEReconnectionRequestAttr() {
        return SSEReconnectionRequestAttr;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object saved(HttpResponse httpResponse, Continuation continuation) {
        C02571 c02571;
        if (continuation instanceof C02571) {
            c02571 = (C02571) continuation;
            int i = c02571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02571.label = i - Integer.MIN_VALUE;
            } else {
                c02571 = new C02571(continuation);
            }
        } else {
            c02571 = new C02571(continuation);
        }
        Object objSave = c02571.result;
        int i2 = c02571.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSave);
            HttpClientCall call = httpResponse.getCall();
            c02571.L$0 = null;
            c02571.label = 1;
            objSave = SavedCallKt.save(call, c02571);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objSave == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objSave);
        }
        HttpClientCall httpClientCall = (HttpClientCall) objSave;
        httpClientCall.getRequest().getAttributes().remove(BuildersKt.getSseRequestAttr());
        return httpClientCall.getResponse();
    }

    public static /* synthetic */ void getSSE$annotations() {
    }
}
