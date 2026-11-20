package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.plugins.api.SetupRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\n\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\" \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"(\u0010 \u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f*B\u0010%\"\u001e\b\u0001\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0!2\u001e\b\u0001\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0!*B\u0010'\"\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0!2\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0!*N\u0010)\"$\b\u0001\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0(2$\b\u0001\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#\u0012\u0006\u0012\u0004\u0018\u00010$0(¨\u0006*"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/request/HttpRequest;", "HttpRequest", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "block", "HttpResponseValidator", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpCallValidator", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpCallValidator", "()Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/util/AttributeKey;", "", "ExpectSuccessAttributeKey", "Lio/ktor/util/AttributeKey;", "getExpectSuccessAttributeKey", "()Lio/ktor/util/AttributeKey;", "value", "getExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;)Z", "setExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;Z)V", "expectSuccess", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "ResponseValidator", "", "CallExceptionHandler", "Lkotlin/Function3;", "CallRequestExceptionHandler", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCallValidatorKt {
    private static final AttributeKey<Boolean> ExpectSuccessAttributeKey;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCallValidator");
    private static final ClientPlugin<HttpCallValidatorConfig> HttpCallValidator = CreatePluginUtilsKt.createClientPlugin("HttpResponseValidator", HttpCallValidatorKt$HttpCallValidator$1.INSTANCE, new UserAgentKt$$ExternalSyntheticLambda0(5));

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        ExpectSuccessAttributeKey = new AttributeKey<>("ExpectSuccessAttributeKey", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpCallValidator$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        List listReversed = CollectionsKt.reversed(((HttpCallValidatorConfig) clientPluginBuilder.getPluginConfig()).getResponseValidators$ktor_client_core());
        List listReversed2 = CollectionsKt.reversed(((HttpCallValidatorConfig) clientPluginBuilder.getPluginConfig()).getResponseExceptionHandlers$ktor_client_core());
        clientPluginBuilder.on(SetupRequest.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$1(((HttpCallValidatorConfig) clientPluginBuilder.getPluginConfig()).getExpectSuccess(), null));
        clientPluginBuilder.on(Send.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$2(listReversed, null));
        clientPluginBuilder.on(RequestError.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$3(listReversed2, null));
        clientPluginBuilder.on(ReceiveError.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$4(listReversed2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x008a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0096  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object HttpCallValidator$lambda$0$processException(java.util.List<? extends io.ktor.client.plugins.HandlerWrapper> r8, java.lang.Throwable r9, io.ktor.client.request.HttpRequest r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidatorKt.HttpCallValidator$lambda$0$processException(java.util.List, java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object HttpCallValidator$lambda$0$validateResponse(List<? extends Function2> list, HttpResponse httpResponse, Continuation continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1 httpCallValidatorKt$HttpCallValidator$2$validateResponse$1;
        HttpResponse httpResponse2;
        Iterator it;
        int i;
        if (continuation instanceof HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1) {
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1 = (HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1) continuation;
            int i2 = httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label = i2 - Integer.MIN_VALUE;
            } else {
                httpCallValidatorKt$HttpCallValidator$2$validateResponse$1 = new HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1(continuation);
            }
        } else {
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1 = new HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1(continuation);
        }
        Object obj = httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.result;
        int i3 = httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Logger logger = LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Validating response for request " + httpResponse.getCall().getRequest().getUrl());
            }
            httpResponse2 = httpResponse;
            it = list.iterator();
            i = 0;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.I$0;
            it = (Iterator) httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$3;
            HttpResponse httpResponse3 = (HttpResponse) httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$1;
            ResultKt.throwOnFailure(obj);
            httpResponse2 = httpResponse3;
        }
        while (it.hasNext()) {
            Function2 function2 = (Function2) it.next();
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$0 = null;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$1 = httpResponse2;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$2 = null;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$3 = it;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$4 = null;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$5 = null;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.I$0 = i;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.I$1 = 0;
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label = 1;
            Object objInvoke = function2.invoke(httpResponse2, httpCallValidatorKt$HttpCallValidator$2$validateResponse$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpRequest HttpRequest(HttpRequestBuilder httpRequestBuilder) {
        return new HttpRequest() { // from class: io.ktor.client.plugins.HttpCallValidatorKt.HttpRequest.1
            private final Attributes attributes;
            private final Headers headers;
            private final HttpMethod method;
            private final Url url;

            {
                this.method = this.$builder.getMethod();
                this.url = this.$builder.getUrl().build();
                this.attributes = this.$builder.getAttributes();
                this.headers = this.$builder.getHeaders().build();
            }

            @Override // io.ktor.client.request.HttpRequest
            public Attributes getAttributes() {
                return this.attributes;
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpClientCall getCall() {
                throw new IllegalStateException("Call is not initialized");
            }

            @Override // io.ktor.client.request.HttpRequest
            public OutgoingContent getContent() {
                Object body = this.$builder.getBody();
                OutgoingContent outgoingContent = body instanceof OutgoingContent ? (OutgoingContent) body : null;
                if (outgoingContent != null) {
                    return outgoingContent;
                }
                PathKt$$ExternalSyntheticBUOutline0.m(this.$builder.getBody(), "Content was not transformed to OutgoingContent yet. Current body is ");
                return null;
            }

            @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
            public /* bridge */ CoroutineContext getCoroutineContext() {
                return super.getCoroutineContext();
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpMethod getMethod() {
                return this.method;
            }

            @Override // io.ktor.client.request.HttpRequest
            public Url getUrl() {
                return this.url;
            }
        };
    }

    public static final void HttpResponseValidator(HttpClientConfig<?> httpClientConfig, Function1 function1) {
        httpClientConfig.getClass();
        function1.getClass();
        httpClientConfig.install(HttpCallValidator, function1);
    }

    public static final boolean getExpectSuccess(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        Boolean bool = (Boolean) httpRequestBuilder.getAttributes().getOrNull(ExpectSuccessAttributeKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final AttributeKey<Boolean> getExpectSuccessAttributeKey() {
        return ExpectSuccessAttributeKey;
    }

    public static final ClientPlugin<HttpCallValidatorConfig> getHttpCallValidator() {
        return HttpCallValidator;
    }

    public static final void setExpectSuccess(HttpRequestBuilder httpRequestBuilder, boolean z) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getAttributes().put(ExpectSuccessAttributeKey, Boolean.valueOf(z));
    }
}
