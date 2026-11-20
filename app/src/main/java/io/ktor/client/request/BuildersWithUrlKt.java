package io.ktor.client.request;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u000b\u0010\t\u001a2\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\f\u0010\t\u001a2\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\r\u0010\t\u001a2\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u000e\u0010\t\u001a2\u0010\u000f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u000f\u0010\t\u001a2\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0010\u0010\t\u001a2\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0011\u0010\t\u001a2\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0012\u0010\t\u001a2\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0013\u0010\t\u001a2\u0010\u0014\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0014\u0010\t\u001a2\u0010\u0015\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0015\u0010\t\u001a2\u0010\u0016\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0016\u0010\t\u001a2\u0010\u0017\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0017\u0010\t\u001a\u0019\u0010\u0002\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Url;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "block", "Lio/ktor/client/statement/HttpResponse;", "get", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareGet", "post", "preparePost", "put", "preparePut", "patch", "preparePatch", "options", "prepareOptions", "head", "prepareHead", "delete", "prepareDelete", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/Url;)V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersWithUrlKt {
    public static final Object delete(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Delete;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static Object delete$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.delete.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object get(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static Object get$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.get.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object head(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Head;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static Object head$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.head.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object options(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Options;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static Object options$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.options.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object patch(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Patch;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static Object patch$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.patch.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object post(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static Object post$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.post.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static final Object prepareDelete(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareDelete.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareGet(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareGet.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Head);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareHead.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Options);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareOptions.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Patch);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePatch.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePost.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Put);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePut.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, Url url, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Put;
        httpRequestBuilder.setMethod(httpMethod);
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static Object put$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.BuildersWithUrlKt.put.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, httpMethod, httpRequestBuilder, httpClient, continuation);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Url url) {
        httpRequestBuilder.getClass();
        url.getClass();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
    }
}
