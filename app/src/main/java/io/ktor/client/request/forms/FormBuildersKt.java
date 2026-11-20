package io.ktor.client.request.forms;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.content.PartData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\n\u0010\u000b\u001aF\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\n\u0010\u000e\u001a8\u0010\u0012\u001a\u00020\t*\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0012\u0010\u0013\u001a@\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0012\u0010\u0014\u001a>\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0016\u0010\u000b\u001aF\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\u0016\u0010\u000e\u001a8\u0010\u0017\u001a\u00020\u0015*\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0006\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0017\u0010\u0013\u001a@\u0010\u0017\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0006\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Parameters;", "formParameters", "", "encodeInQuery", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "block", "Lio/ktor/client/statement/HttpResponse;", "submitForm", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "url", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/http/content/PartData;", "formData", "submitFormWithBinaryData", "(Lio/ktor/client/HttpClient;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareForm", "prepareFormWithBinaryData", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FormBuildersKt {
    public static final Object prepareForm(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareForm.2
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
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareForm$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, String str, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareFormWithBinaryData.5
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
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitForm(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static Object submitForm$default(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitForm.2
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
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit submitForm$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static Object submitFormWithBinaryData$default(HttpClient httpClient, String str, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitFormWithBinaryData.5
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
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareFormWithBinaryData.2
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
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static Object submitFormWithBinaryData$default(HttpClient httpClient, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitFormWithBinaryData.2
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
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static final Object prepareForm(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitForm(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return Cookie$$ExternalSyntheticOutline0.m(httpClient, httpRequestBuilder, continuation);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 20);
        }
        return prepareForm(httpClient, str, parameters2, z2, function1, continuation);
    }

    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 21);
        }
        return submitForm(httpClient, str, parameters2, z2, function1, continuation);
    }
}
