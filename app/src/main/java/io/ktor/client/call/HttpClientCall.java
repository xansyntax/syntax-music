package io.ktor.client.call;

import com.yalantis.ucrop.UCrop;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.content.NullBody;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0094@¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0013\u0010\u0012J\u0011\u0010\u0015\u001a\u00020\u0014H\u0096\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010,\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R*\u0010\u001e\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8\u0006@DX\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u00100\"\u0004\b!\u0010 R*\u0010\u0018\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00178\u0006@DX\u0086.¢\u0006\u0012\n\u0004\b\u0018\u00101\u001a\u0004\b2\u00103\"\u0004\b\u001c\u0010\u001bR\u001a\u00105\u001a\u0002048\u0014X\u0094D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/HttpClient;)V", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/client/request/HttpResponseData;", "responseData", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestData;Lio/ktor/client/request/HttpResponseData;)V", "Lio/ktor/utils/io/ByteReadChannel;", "getResponseContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "info", "", "bodyNullable", "(Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "body", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "setResponse$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;)V", "setResponse", "Lio/ktor/client/request/HttpRequest;", "request", "setRequest$ktor_client_core", "(Lio/ktor/client/request/HttpRequest;)V", "setRequest", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "attributes", "value", "Lio/ktor/client/request/HttpRequest;", "getRequest", "()Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "", "allowDoubleReceive", "Z", "getAllowDoubleReceive", "()Z", "Companion", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class HttpClientCall implements CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<Object> CustomResponse;
    private static final /* synthetic */ AtomicIntegerFieldUpdater received$FU;
    private final boolean allowDoubleReceive;
    private final HttpClient client;
    private volatile /* synthetic */ int received;
    protected HttpRequest request;
    protected HttpResponse response;

    /* JADX INFO: renamed from: io.ktor.client.call.HttpClientCall$body$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {124}, m = "body", v = 1)
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
            return HttpClientCall.this.body(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.call.HttpClientCall$bodyNullable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {UCrop.RESULT_ERROR, 99}, m = "bodyNullable", v = 1)
    public static final class C02281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02281(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCall.this.bodyNullable(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TypeReference typeReferenceTypeOf = null;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(Object.class);
        } catch (Throwable unused) {
        }
        CustomResponse = new AttributeKey<>("CustomResponse", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
        received$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClientCall(HttpClient httpClient, HttpRequestData httpRequestData, HttpResponseData httpResponseData) {
        this(httpClient);
        httpClient.getClass();
        httpRequestData.getClass();
        httpResponseData.getClass();
        setRequest(new DefaultHttpRequest(this, httpRequestData));
        setResponse(new DefaultHttpResponse(this, httpResponseData));
        Attributes attributes = getAttributes();
        AttributeKey<Object> attributeKey = CustomResponse;
        attributes.remove(attributeKey);
        if (httpResponseData.getBody() instanceof ByteReadChannel) {
            return;
        }
        getAttributes().put(attributeKey, httpResponseData.getBody());
    }

    public static /* synthetic */ Object getResponseContent$suspendImpl(HttpClientCall httpClientCall, Continuation continuation) {
        return httpClientCall.getResponse().getRawContent();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object body(TypeInfo typeInfo, Continuation continuation) {
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
        Object objBodyNullable = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBodyNullable);
            anonymousClass1.L$0 = null;
            anonymousClass1.label = 1;
            objBodyNullable = bodyNullable(typeInfo, anonymousClass1);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objBodyNullable == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objBodyNullable);
        }
        objBodyNullable.getClass();
        return objBodyNullable;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a9, code lost:
    
        if (r8 == r5) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bodyNullable(TypeInfo typeInfo, Continuation continuation) {
        C02281 c02281;
        if (continuation instanceof C02281) {
            c02281 = (C02281) continuation;
            int i = c02281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02281.label = i - Integer.MIN_VALUE;
            } else {
                c02281 = new C02281(continuation);
            }
        } else {
            c02281 = new C02281(continuation);
        }
        Object orNull = c02281.result;
        int i2 = c02281.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(orNull);
                if (TypeInfoJvmKt.instanceOf(getResponse(), typeInfo.getType())) {
                    return getResponse();
                }
                if (!getAllowDoubleReceive() && !DoubleReceivePluginKt.isSaved(getResponse()) && !received$FU.compareAndSet(this, 0, 1)) {
                    throw new DoubleReceiveException(this);
                }
                orNull = getAttributes().getOrNull(CustomResponse);
                if (orNull == null) {
                    c02281.L$0 = typeInfo;
                    c02281.label = 1;
                    orNull = getResponseContent(c02281);
                    if (orNull == obj) {
                    }
                }
                return obj;
            }
            if (i2 == 1) {
                typeInfo = (TypeInfo) c02281.L$0;
                ResultKt.throwOnFailure(orNull);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                typeInfo = (TypeInfo) c02281.L$0;
                ResultKt.throwOnFailure(orNull);
            }
            Object response = ((HttpResponseContainer) orNull).getResponse();
            Object obj2 = Intrinsics.areEqual(response, NullBody.INSTANCE) ? null : response;
            if (obj2 != null && !TypeInfoJvmKt.instanceOf(obj2, typeInfo.getType())) {
                throw new NoTransformationFoundException(getResponse(), Reflection.getOrCreateKotlinClass(obj2.getClass()), typeInfo.getType());
            }
            return obj2;
            HttpResponseContainer httpResponseContainer = new HttpResponseContainer(typeInfo, orNull);
            HttpResponsePipeline responsePipeline = this.client.getResponsePipeline();
            c02281.L$0 = typeInfo;
            c02281.L$1 = null;
            c02281.L$2 = null;
            c02281.label = 2;
            orNull = responsePipeline.execute(this, httpResponseContainer, c02281);
        } catch (Throwable th) {
            AwaitKt.cancel(getResponse(), AwaitKt.CancellationException("Receive failed", th));
            throw th;
        }
    }

    public boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }

    public final Attributes getAttributes() {
        return getRequest().getAttributes();
    }

    public final HttpClient getClient() {
        return this.client;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return getResponse().getCoroutineContext();
    }

    public final HttpRequest getRequest() {
        HttpRequest httpRequest = this.request;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.throwUninitializedPropertyAccessException("request");
        throw null;
    }

    public final HttpResponse getResponse() {
        HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        throw null;
    }

    public Object getResponseContent(Continuation continuation) {
        return getResponseContent$suspendImpl(this, continuation);
    }

    public final void setRequest(HttpRequest httpRequest) {
        httpRequest.getClass();
        this.request = httpRequest;
    }

    public final void setRequest$ktor_client_core(HttpRequest request) {
        request.getClass();
        setRequest(request);
    }

    public final void setResponse(HttpResponse httpResponse) {
        httpResponse.getClass();
        this.response = httpResponse;
    }

    public final void setResponse$ktor_client_core(HttpResponse response) {
        response.getClass();
        setResponse(response);
    }

    public String toString() {
        return "HttpClientCall[" + getRequest().getUrl() + ", " + getResponse().getStatus() + ']';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/call/HttpClientCall$Companion;", "", "<init>", "()V", "Lio/ktor/util/AttributeKey;", "CustomResponse", "Lio/ktor/util/AttributeKey;", "getCustomResponse$ktor_client_core", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AttributeKey<Object> getCustomResponse$ktor_client_core() {
            return HttpClientCall.CustomResponse;
        }

        private Companion() {
        }
    }

    public HttpClientCall(HttpClient httpClient) {
        httpClient.getClass();
        this.client = httpClient;
        this.received = 0;
    }
}
