package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a#\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "wrapWithContent", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/client/call/HttpClientCall;", "Lkotlin/Function0;", "block", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/jvm/functions/Function0;)Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/Headers;", "headers", "wrap", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/Headers;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DelegatedCallKt {
    @Deprecated
    public static final HttpClientCall wrap(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel, Headers headers) {
        httpClientCall.getClass();
        byteReadChannel.getClass();
        headers.getClass();
        return io.ktor.client.call.DelegatedCallKt.replaceResponse(httpClientCall, headers, new DelegatedCallKt$$ExternalSyntheticLambda1(byteReadChannel, (byte) 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel wrap$lambda$0(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        httpResponse.getClass();
        return byteReadChannel;
    }

    @Deprecated
    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel) {
        httpClientCall.getClass();
        byteReadChannel.getClass();
        return io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpClientCall, null, new DelegatedCallKt$$ExternalSyntheticLambda1(byteReadChannel, (byte) 0), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel wrapWithContent$lambda$0(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        httpResponse.getClass();
        return byteReadChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel wrapWithContent$lambda$1(Function0 function0, HttpResponse httpResponse) {
        httpResponse.getClass();
        return (ByteReadChannel) function0.invoke();
    }

    @Deprecated
    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, Function0 function0) {
        httpClientCall.getClass();
        function0.getClass();
        return io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpClientCall, null, new DelegatedCallKt$$ExternalSyntheticLambda0(function0, (byte) 0), 1, null);
    }
}
