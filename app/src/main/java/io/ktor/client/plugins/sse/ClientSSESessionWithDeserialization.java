package io.ktor.client.plugins.sse;

import io.ktor.client.call.HttpClientCall;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0097\u0001¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00190\u00188\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/client/plugins/sse/ClientSSESessionWithDeserialization;", "Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;", "Lio/ktor/client/call/HttpClientCall;", "call", "delegate", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;)V", "", "bodyBuffer", "()[B", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/Function2;", "Lio/ktor/util/reflect/TypeInfo;", "", "", "getDeserializer", "()Lkotlin/jvm/functions/Function2;", "deserializer", "Lkotlinx/coroutines/flow/Flow;", "Lio/ktor/sse/TypedServerSentEvent;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ClientSSESessionWithDeserialization implements SSESessionWithDeserialization {
    private final /* synthetic */ SSESessionWithDeserialization $$delegate_0;
    private final HttpClientCall call;

    public ClientSSESessionWithDeserialization(HttpClientCall httpClientCall, SSESessionWithDeserialization sSESessionWithDeserialization) {
        httpClientCall.getClass();
        sSESessionWithDeserialization.getClass();
        this.$$delegate_0 = sSESessionWithDeserialization;
        this.call = httpClientCall;
    }

    @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
    public byte[] bodyBuffer() {
        return this.$$delegate_0.bodyBuffer();
    }

    public final HttpClientCall getCall() {
        return this.call;
    }

    @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
    public Function2 getDeserializer() {
        return this.$$delegate_0.getDeserializer();
    }

    @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
    public Flow getIncoming() {
        return this.$$delegate_0.getIncoming();
    }
}
