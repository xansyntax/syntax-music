package io.ktor.client.request;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpStatement;
import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsJvmKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\n\u0010\t\u001a2\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000b\u0010\t\u001a2\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\f\u0010\t\u001a2\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\r\u0010\t\u001a2\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000e\u0010\t\u001a2\u0010\u000f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000f\u0010\t\u001a2\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0010\u0010\t\u001a2\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0012\u0010\t\u001a2\u0010\u0013\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0013\u0010\t\u001a2\u0010\u0014\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0014\u0010\t\u001a2\u0010\u0015\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0015\u0010\t\u001a2\u0010\u0016\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0016\u0010\t\u001a2\u0010\u0017\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0017\u0010\t\u001a2\u0010\u0018\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0018\u0010\t\u001a2\u0010\u0019\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lio/ktor/client/HttpClient;", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "block", "Lio/ktor/client/statement/HttpResponse;", "request", "(Lio/ktor/client/HttpClient;Ljava/net/URL;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "post", "put", "patch", "options", "head", "delete", "Lio/ktor/client/statement/HttpStatement;", "prepareRequest", "prepareGet", "preparePost", "preparePut", "preparePatch", "prepareOptions", "prepareHead", "prepareDelete", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersJvmKt {
    public static final Object delete(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 4);
        }
        return delete(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object get(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 2);
        }
        return get(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit get$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object head(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 14);
        }
        return head(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit head$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object options(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 12);
        }
        return options(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit options$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object patch(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 13);
        }
        return patch(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit patch$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object post(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 16);
        }
        return post(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit post$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object prepareDelete(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 7);
        }
        return prepareDelete(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareDelete$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object prepareGet(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 9);
        }
        return prepareGet(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareGet$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object prepareHead(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 17);
        }
        return prepareHead(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareHead$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object prepareOptions(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 3);
        }
        return prepareOptions(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareOptions$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object preparePatch(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 10);
        }
        return preparePatch(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preparePatch$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object preparePost(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 5);
        }
        return preparePost(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preparePost$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object preparePut(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 6);
        }
        return preparePut(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preparePut$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object prepareRequest(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 15);
        }
        return prepareRequest(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareRequest$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object put(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 8);
        }
        return put(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit put$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object request(HttpClient httpClient, URL url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 11);
        }
        return request(httpClient, url, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit request$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }
}
