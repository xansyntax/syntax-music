package io.ktor.client.request;

import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.client.plugins.sse.SSEKt;
import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethodKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.content.OutgoingContentKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.AttributesKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\t*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\f*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0012\u001a\u00020\u0003*\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u000f\u001a\u00020\f*\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0014\u001a(\u0010\u0016\u001a\u00020\f*\u00020\u00152\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\bH\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001aW\u0010\u0012\u001a\u00020\u0003*\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u0012\u0010\u001d\u001aZ\u0010\u0016\u001a\u00020\f*\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\bH\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u001e\u001a\u0019\u0010\u0012\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010 \u001a\u0013\u0010\"\u001a\u00020!*\u00020\u0000H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010$\u001a\u00020!*\u00020\u0000H\u0007¢\u0006\u0004\b$\u0010#\u001a\u0013\u0010%\u001a\u00020!*\u00020\u0000H\u0007¢\u0006\u0004\b%\u0010#\"&\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "Lkotlin/Function2;", "", "", "block", "forEachHeader", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/http/HttpMessageBuilder;", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "headers", "(Lio/ktor/http/HttpMessageBuilder;Lkotlin/jvm/functions/Function1;)Lio/ktor/http/HeadersBuilder;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequest;", "request", "takeFrom", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/request/HttpRequest;)Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/URLBuilder;", "url", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequestBuilder$Companion;", "invoke", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "scheme", "host", "", "port", "path", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "urlString", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "", "isUpgradeRequest", "(Lio/ktor/client/request/HttpRequestData;)Z", "isSseRequest", "isSseReconnectionRequest", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/request/ResponseAdapter;", "ResponseAdapterAttributeKey", "Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey", "()Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpRequestKt {
    private static final AttributeKey<ResponseAdapter> ResponseAdapterAttributeKey;

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ResponseAdapter.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(ResponseAdapter.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        ResponseAdapterAttributeKey = new AttributeKey<>("ResponseAdapterAttributeKey", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    public static final void forEachHeader(HttpRequestData httpRequestData, final Function2 function2) {
        httpRequestData.getClass();
        function2.getClass();
        final boolean z = !HttpMethodKt.getSupportsRequestBody(httpRequestData.getMethod()) && OutgoingContentKt.isEmpty(httpRequestData.getBody());
        io.ktor.client.engine.UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new Function2() { // from class: io.ktor.client.request.HttpRequestKt.forEachHeader.1
            public final void invoke(String str, String str2) {
                str.getClass();
                str2.getClass();
                if (z && str.equals(HttpHeaders.ContentLength)) {
                    return;
                }
                function2.invoke(str, str2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }
        });
    }

    public static final AttributeKey<ResponseAdapter> getResponseAdapterAttributeKey() {
        return ResponseAdapterAttributeKey;
    }

    public static final HeadersBuilder headers(HttpMessageBuilder httpMessageBuilder, Function1 function1) {
        httpMessageBuilder.getClass();
        function1.getClass();
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        function1.invoke(headers);
        return headers;
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, Function1 function1) {
        companion.getClass();
        function1.getClass();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, function1);
        return httpRequestBuilder;
    }

    public static /* synthetic */ HttpRequestBuilder invoke$default(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 18);
        }
        return invoke(companion, str, str2, num, str3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final boolean isSseReconnectionRequest(HttpRequestData httpRequestData) {
        httpRequestData.getClass();
        return Intrinsics.areEqual(httpRequestData.getAttributes().getOrNull(SSEKt.getSSEReconnectionRequestAttr()), Boolean.TRUE);
    }

    public static final boolean isSseRequest(HttpRequestData httpRequestData) {
        httpRequestData.getClass();
        return httpRequestData.getBody() instanceof SSEClientContent;
    }

    public static final boolean isUpgradeRequest(HttpRequestData httpRequestData) {
        httpRequestData.getClass();
        return httpRequestData.getBody() instanceof ClientUpgradeContent;
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder, HttpRequest httpRequest) {
        httpRequestBuilder.getClass();
        httpRequest.getClass();
        httpRequestBuilder.setMethod(httpRequest.getMethod());
        httpRequestBuilder.setBody(httpRequest.getContent());
        httpRequestBuilder.setBodyType((TypeInfo) httpRequestBuilder.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), httpRequest.getUrl());
        httpRequestBuilder.getHeaders().appendAll(httpRequest.getHeaders());
        AttributesKt.putAll(httpRequestBuilder.getAttributes(), httpRequest.getAttributes());
        return httpRequestBuilder;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Function1 function1) {
        httpRequestBuilder.getClass();
        function1.getClass();
        function1.invoke(httpRequestBuilder.getUrl());
    }

    public static /* synthetic */ void url$default(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 19);
        }
        url(httpRequestBuilder, str, str2, num, str3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit url$lambda$0(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1) {
        httpRequestBuilder.getClass();
        function1.getClass();
        URLBuilderKt.set(httpRequestBuilder.getUrl(), str, str2, num, str3, function1);
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, Function1 function1) {
        companion.getClass();
        function1.getClass();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, str, str2, num, str3, function1);
        return httpRequestBuilder;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String str) {
        httpRequestBuilder.getClass();
        str.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
    }

    public static /* synthetic */ void getResponseAdapterAttributeKey$annotations() {
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder, HttpRequestData httpRequestData) {
        httpRequestBuilder.getClass();
        httpRequestData.getClass();
        httpRequestBuilder.setMethod(httpRequestData.getMethod());
        httpRequestBuilder.setBody(httpRequestData.getBody());
        httpRequestBuilder.setBodyType((TypeInfo) httpRequestBuilder.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), httpRequestData.getUrl());
        httpRequestBuilder.getHeaders().appendAll(httpRequestData.getHeaders());
        AttributesKt.putAll(httpRequestBuilder.getAttributes(), httpRequestData.getAttributes());
        return httpRequestBuilder;
    }
}
