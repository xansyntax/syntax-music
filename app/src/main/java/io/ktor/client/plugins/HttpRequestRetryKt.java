package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\f\u001a\u00020\b*\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\" \u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"2\u0010(\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0%0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\"\"2\u0010)\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0%0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\"\",\u0010,\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030*0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\"\",\u0010/\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020.0*0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\"¨\u00060"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "block", "retry", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "", "", "isTimeoutException", "(Ljava/lang/Throwable;)Z", "Lio/ktor/client/statement/HttpResponse;", "throwOnInvalidResponseBody", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/HttpRetryEventData;", "HttpRequestRetryEvent", "Lio/ktor/events/EventDefinition;", "getHttpRequestRetryEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestRetry", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry$annotations", "()V", "Lio/ktor/util/AttributeKey;", "", "MaxRetriesPerRequestAttributeKey", "Lio/ktor/util/AttributeKey;", "getMaxRetriesPerRequestAttributeKey", "()Lio/ktor/util/AttributeKey;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "ShouldRetryPerRequestAttributeKey", "ShouldRetryOnExceptionPerRequestAttributeKey", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "ModifyRequestPerRequestAttributeKey", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "", "RetryDelayPerRequestAttributeKey", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpRequestRetryKt {
    private static final ClientPlugin<HttpRequestRetryConfig> HttpRequestRetry;
    private static final EventDefinition<HttpRetryEventData> HttpRequestRetryEvent;
    private static final Logger LOGGER;
    private static final AttributeKey<Integer> MaxRetriesPerRequestAttributeKey;
    private static final AttributeKey<Function2> ModifyRequestPerRequestAttributeKey;
    private static final AttributeKey<Function2> RetryDelayPerRequestAttributeKey;
    private static final AttributeKey<Function3> ShouldRetryOnExceptionPerRequestAttributeKey;
    private static final AttributeKey<Function3> ShouldRetryPerRequestAttributeKey;

    /* JADX INFO: renamed from: io.ktor.client.plugins.HttpRequestRetryKt$throwOnInvalidResponseBody$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryKt", f = "HttpRequestRetry.kt", l = {489}, m = "throwOnInvalidResponseBody", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpRequestRetryKt.throwOnInvalidResponseBody(null, this);
        }
    }

    static {
        TypeReference typeReferenceTypeOf;
        TypeReference typeReferenceTypeOf2;
        TypeReference typeReferenceTypeOf3;
        TypeReference typeReferenceTypeOf4;
        Class cls = Boolean.TYPE;
        Class cls2 = Integer.TYPE;
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestRetry");
        HttpRequestRetryEvent = new EventDefinition<>();
        HttpRequestRetry = CreatePluginUtilsKt.createClientPlugin("RetryFeature", HttpRequestRetryKt$HttpRequestRetry$1.INSTANCE, new UserAgentKt$$ExternalSyntheticLambda0((byte) 10));
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
        TypeReference typeReferenceTypeOf5 = null;
        try {
            typeReferenceTypeOf = Reflection.typeOf(cls2);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        MaxRetriesPerRequestAttributeKey = new AttributeKey<>("MaxRetriesPerRequestAttributeKey", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Function3.class);
        boolean zIsFunctionOfArity = TypeIntrinsics.isFunctionOfArity(3, null);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            typeReferenceTypeOf2 = Reflection.typeOf(Function3.class, companion.invariant(Reflection.typeOf(HttpRetryShouldRetryContext.class)), companion.invariant(Reflection.typeOf(HttpRequest.class)), companion.invariant(Reflection.typeOf(HttpResponse.class)), companion.invariant(Reflection.typeOf(cls)));
        } catch (Throwable unused2) {
            typeReferenceTypeOf2 = null;
        }
        ShouldRetryPerRequestAttributeKey = new AttributeKey<>("ShouldRetryPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass2, zIsFunctionOfArity, typeReferenceTypeOf2));
        ClassReference orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Function3.class);
        boolean zIsFunctionOfArity2 = TypeIntrinsics.isFunctionOfArity(3, null);
        try {
            KTypeProjection.Companion companion2 = KTypeProjection.INSTANCE;
            typeReferenceTypeOf3 = Reflection.typeOf(Function3.class, companion2.invariant(Reflection.typeOf(HttpRetryShouldRetryContext.class)), companion2.invariant(Reflection.typeOf(HttpRequestBuilder.class)), companion2.invariant(Reflection.typeOf(Throwable.class)), companion2.invariant(Reflection.typeOf(cls)));
        } catch (Throwable unused3) {
            typeReferenceTypeOf3 = null;
        }
        ShouldRetryOnExceptionPerRequestAttributeKey = new AttributeKey<>("ShouldRetryOnExceptionPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass3, zIsFunctionOfArity2, typeReferenceTypeOf3));
        ClassReference orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Function2.class);
        boolean zIsFunctionOfArity3 = TypeIntrinsics.isFunctionOfArity(2, null);
        try {
            KTypeProjection.Companion companion3 = KTypeProjection.INSTANCE;
            typeReferenceTypeOf4 = Reflection.typeOf(Function2.class, companion3.invariant(Reflection.typeOf(HttpRetryModifyRequestContext.class)), companion3.invariant(Reflection.typeOf(HttpRequestBuilder.class)), companion3.invariant(Reflection.typeOf(Unit.class)));
        } catch (Throwable unused4) {
            typeReferenceTypeOf4 = null;
        }
        ModifyRequestPerRequestAttributeKey = new AttributeKey<>("ModifyRequestPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass4, zIsFunctionOfArity3, typeReferenceTypeOf4));
        ClassReference orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Function2.class);
        boolean zIsFunctionOfArity4 = TypeIntrinsics.isFunctionOfArity(2, null);
        try {
            KTypeProjection.Companion companion4 = KTypeProjection.INSTANCE;
            typeReferenceTypeOf5 = Reflection.typeOf(Function2.class, companion4.invariant(Reflection.typeOf(HttpRetryDelayContext.class)), companion4.invariant(Reflection.typeOf(cls2)), companion4.invariant(Reflection.typeOf(Long.TYPE)));
        } catch (Throwable unused5) {
        }
        RetryDelayPerRequestAttributeKey = new AttributeKey<>("RetryDelayPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass5, zIsFunctionOfArity4, typeReferenceTypeOf5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestRetry$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        Function3 shouldRetry$ktor_client_core = ((HttpRequestRetryConfig) clientPluginBuilder.getPluginConfig()).getShouldRetry$ktor_client_core();
        Function3 shouldRetryOnException$ktor_client_core = ((HttpRequestRetryConfig) clientPluginBuilder.getPluginConfig()).getShouldRetryOnException$ktor_client_core();
        Function2 delayMillis$ktor_client_core = ((HttpRequestRetryConfig) clientPluginBuilder.getPluginConfig()).getDelayMillis$ktor_client_core();
        Function2 delay$ktor_client_core = ((HttpRequestRetryConfig) clientPluginBuilder.getPluginConfig()).getDelay();
        int maxRetries = ((HttpRequestRetryConfig) clientPluginBuilder.getPluginConfig()).getMaxRetries();
        Function2 modifyRequest = ((HttpRequestRetryConfig) clientPluginBuilder.getPluginConfig()).getModifyRequest();
        clientPluginBuilder.onRequest(new HttpRequestRetryKt$HttpRequestRetry$2$1(maxRetries, null));
        clientPluginBuilder.on(Send.INSTANCE, new HttpRequestRetryKt$HttpRequestRetry$2$2(shouldRetry$ktor_client_core, shouldRetryOnException$ktor_client_core, maxRetries, delayMillis$ktor_client_core, modifyRequest, clientPluginBuilder, delay$ktor_client_core, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpRequestBuilder HttpRequestRetry$lambda$0$prepareRequest(HttpRequestBuilder httpRequestBuilder) {
        HttpRequestBuilder httpRequestBuilderTakeFrom = new HttpRequestBuilder().takeFrom(httpRequestBuilder);
        httpRequestBuilder.getExecutionContext().invokeOnCompletion(new HttpTimeoutKt$$ExternalSyntheticLambda1((byte) 6, httpRequestBuilderTakeFrom));
        return httpRequestBuilderTakeFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestRetry$lambda$0$prepareRequest$0(HttpRequestBuilder httpRequestBuilder, Throwable th) {
        Job executionContext = httpRequestBuilder.getExecutionContext();
        executionContext.getClass();
        CompletableJob completableJob = (CompletableJob) executionContext;
        if (th == null) {
            ((JobImpl) completableJob).complete$1();
        } else {
            ((JobImpl) completableJob).completeExceptionally(th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$0$shouldRetry(int i, int i2, Function3 function3, HttpClientCall httpClientCall) {
        return i < i2 && ((Boolean) function3.invoke(new HttpRetryShouldRetryContext(i + 1), httpClientCall.getRequest(), httpClientCall.getResponse())).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$0$shouldRetryOnException(int i, int i2, Function3 function3, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        return i < i2 && ((Boolean) function3.invoke(new HttpRetryShouldRetryContext(i + 1), httpRequestBuilder, th)).booleanValue();
    }

    public static final ClientPlugin<HttpRequestRetryConfig> getHttpRequestRetry() {
        return HttpRequestRetry;
    }

    public static final EventDefinition<HttpRetryEventData> getHttpRequestRetryEvent() {
        return HttpRequestRetryEvent;
    }

    public static final AttributeKey<Integer> getMaxRetriesPerRequestAttributeKey() {
        return MaxRetriesPerRequestAttributeKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTimeoutException(Throwable th) {
        Throwable thUnwrapCancellationException = ExceptionUtilsJvmKt.unwrapCancellationException(th);
        return (thUnwrapCancellationException instanceof HttpRequestTimeoutException) || (thUnwrapCancellationException instanceof ConnectTimeoutException) || (thUnwrapCancellationException instanceof SocketTimeoutException);
    }

    public static final void retry(HttpRequestBuilder httpRequestBuilder, Function1 function1) {
        httpRequestBuilder.getClass();
        function1.getClass();
        HttpRequestRetryConfig httpRequestRetryConfig = new HttpRequestRetryConfig();
        function1.invoke(httpRequestRetryConfig);
        httpRequestBuilder.getAttributes().put(ShouldRetryPerRequestAttributeKey, httpRequestRetryConfig.getShouldRetry$ktor_client_core());
        httpRequestBuilder.getAttributes().put(ShouldRetryOnExceptionPerRequestAttributeKey, httpRequestRetryConfig.getShouldRetryOnException$ktor_client_core());
        httpRequestBuilder.getAttributes().put(RetryDelayPerRequestAttributeKey, httpRequestRetryConfig.getDelayMillis$ktor_client_core());
        httpRequestBuilder.getAttributes().put(MaxRetriesPerRequestAttributeKey, Integer.valueOf(httpRequestRetryConfig.getMaxRetries()));
        httpRequestBuilder.getAttributes().put(ModifyRequestPerRequestAttributeKey, httpRequestRetryConfig.getModifyRequest());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.ktor.utils.io.ByteReadChannel] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v6, types: [io.ktor.utils.io.ByteReadChannel] */
    public static final Object throwOnInvalidResponseBody(HttpResponse httpResponse, Continuation continuation) {
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
        Object objAwaitContent$default = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Object failure = Unit.INSTANCE;
        boolean z = false;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objAwaitContent$default);
                    if (DoubleReceivePluginKt.isSaved(httpResponse)) {
                        ByteReadChannel rawContent = httpResponse.getRawContent();
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = rawContent;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        objAwaitContent$default = ByteReadChannel.awaitContent$default(rawContent, 0, anonymousClass1, 1, null);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        httpResponse = rawContent;
                        if (objAwaitContent$default == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Boolean.valueOf(z);
                }
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ByteReadChannel byteReadChannel = (ByteReadChannel) anonymousClass1.L$1;
                ResultKt.throwOnFailure(objAwaitContent$default);
                httpResponse = byteReadChannel;
                ByteReadChannelKt.cancel(httpResponse);
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            boolean zBooleanValue = ((Boolean) objAwaitContent$default).booleanValue();
            Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
            if (thM1866exceptionOrNullimpl != null) {
                LOGGER.debug("Failed to close response body channel", thM1866exceptionOrNullimpl);
            }
            if (zBooleanValue) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th2) {
            try {
                ByteReadChannelKt.cancel(httpResponse);
            } catch (Throwable th3) {
                failure = new Result.Failure(th3);
            }
            Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(failure);
            if (thM1866exceptionOrNullimpl2 == null) {
                throw th2;
            }
            LOGGER.debug("Failed to close response body channel", thM1866exceptionOrNullimpl2);
            throw th2;
        }
    }

    public static /* synthetic */ void getHttpRequestRetry$annotations() {
    }
}
