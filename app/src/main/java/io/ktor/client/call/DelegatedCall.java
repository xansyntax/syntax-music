package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/call/DelegatedCall;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "originCall", "Lkotlin/Function1;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/utils/io/ByteReadChannel;", "responseContent", "Lio/ktor/http/Headers;", "responseHeaders", "<init>", "(Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lkotlin/jvm/functions/Function1;Lio/ktor/http/Headers;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DelegatedCall extends HttpClientCall {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegatedCall(HttpClient httpClient, HttpClientCall httpClientCall, Function1 function1, Headers headers) {
        super(httpClient);
        httpClient.getClass();
        httpClientCall.getClass();
        function1.getClass();
        headers.getClass();
        setRequest(new DelegatedRequest(this, httpClientCall.getRequest()));
        setResponse(new DelegatedResponse(this, httpClientCall.getResponse(), function1, headers));
    }

    public /* synthetic */ DelegatedCall(HttpClient httpClient, HttpClientCall httpClientCall, Function1 function1, Headers headers, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClient, httpClientCall, function1, (i & 8) != 0 ? httpClientCall.getResponse().getHeaders() : headers);
    }
}
