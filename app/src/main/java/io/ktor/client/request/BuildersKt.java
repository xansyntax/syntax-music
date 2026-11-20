package io.ktor.client.request;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0007\u0010\u0005\u001a(\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0004\u0010\u000b\u001a(\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0007\u0010\u000b\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0004\u0010\u000e\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0007\u0010\u000e\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0004\u0010\u0011\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0007\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0012\u0010\u0005\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0013\u0010\u0005\u001a\u001c\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0014\u0010\u0005\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0017\u0010\u0005\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0018\u0010\u0005\u001a\u001c\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u001c\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001a\u0010\u0005\u001a\u001c\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001b\u0010\u0005\u001a\u001c\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001c\u0010\u0005\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001d\u0010\u0005\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001f\u0010\u0005\u001a\u001c\u0010 \u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b \u0010\u0005\u001a\u001c\u0010!\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b!\u0010\u0005\u001a(\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0012\u0010\u000b\u001a(\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u000b\u001a(\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0014\u0010\u000b\u001a(\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0015\u0010\u000b\u001a(\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0016\u0010\u000b\u001a(\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0017\u0010\u000b\u001a(\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u000b\u001a(\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0019\u0010\u000b\u001a(\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001a\u0010\u000b\u001a(\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001b\u0010\u000b\u001a(\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001c\u0010\u000b\u001a(\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001d\u0010\u000b\u001a(\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001e\u0010\u000b\u001a(\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001f\u0010\u000b\u001a(\u0010 \u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b \u0010\u000b\u001a(\u0010!\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b!\u0010\u000b\u001a!\u0010\u0004\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0004\u0010\"\u001a2\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0012\u0010\u000e\u001a2\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u000e\u001a2\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0014\u0010\u000e\u001a2\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0015\u0010\u000e\u001a2\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0016\u0010\u000e\u001a2\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0017\u0010\u000e\u001a2\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u000e\u001a2\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0019\u0010\u000e\u001a2\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001a\u0010\u000e\u001a2\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001b\u0010\u000e\u001a2\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001c\u0010\u000e\u001a2\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001d\u0010\u000e\u001a2\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001e\u0010\u000e\u001a2\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001f\u0010\u000e\u001a2\u0010 \u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b \u0010\u000e\u001a2\u0010!\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b!\u0010\u000e¨\u0006#"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/statement/HttpResponse;", "request", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareRequest", "Lkotlin/Function1;", "", "block", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "url", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "post", "put", "delete", "options", "patch", "head", "query", "prepareGet", "preparePost", "preparePut", "prepareDelete", "prepareOptions", "preparePatch", "prepareHead", "prepareQuery", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt {
    public static final Object delete(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object delete$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.delete.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object get(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static Object get$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.get.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object head(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object head$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.head.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object options(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object options$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.options.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object patch(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object patch$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.patch.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object post(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object post$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.post.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object prepareDelete(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareDelete.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareGet(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareGet.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareHead.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareOptions.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.preparePatch.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.preparePost.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.preparePut.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareQuery(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Query);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareQuery$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Query);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareQuery$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareQuery.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Query);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareRequest(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareRequest.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object put$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.put.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object query(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Query;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object query$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Query;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object query$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.query.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Query;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object request(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, String str, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object request$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.request.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object request(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object prepareRequest(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object get(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object prepareGet(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static final HttpRequestBuilder request(Function1 function1) {
        function1.getClass();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return httpRequestBuilder;
    }

    public static final Object prepareRequest(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object prepareRequest(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object get(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object prepareGet(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareQuery(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Query);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareQuery$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Query);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static Object request$default(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = new HttpRequestBuilder();
        }
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = new HttpRequestBuilder();
        }
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object delete(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object head(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object options(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object patch(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object post(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object put(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object query(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Query;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object query$$forInline(HttpClient httpClient, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Query;
        httpRequestBuilder.setMethod(httpMethod);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(httpMethod);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static Object request$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.request.7
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersKt.prepareRequest.7
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((HttpRequestBuilder) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Delete, httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Head, httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Options, httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Patch, httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Put, httpRequestBuilder, httpClient);
    }

    public static final Object prepareQuery(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Query, httpRequestBuilder, httpClient);
    }

    public static final Object delete(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Delete, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object head(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Head, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object options(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Options, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object patch(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Patch, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object post(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object put(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Put, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object query(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Query, httpRequestBuilder, httpClient, continuation);
    }
}
