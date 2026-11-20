package io.ktor.client.call;

import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/Headers;", "headers", "Lkotlin/Function1;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "replaceResponse", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/http/Headers;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DelegatedCallKt {
    public static final HttpClientCall replaceResponse(HttpClientCall httpClientCall, Headers headers, Function1 function1) {
        httpClientCall.getClass();
        headers.getClass();
        function1.getClass();
        return new DelegatedCall(httpClientCall.getClient(), httpClientCall, function1, headers);
    }

    public static /* synthetic */ HttpClientCall replaceResponse$default(HttpClientCall httpClientCall, Headers headers, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            headers = httpClientCall.getResponse().getHeaders();
        }
        return replaceResponse(httpClientCall, headers, function1);
    }
}
