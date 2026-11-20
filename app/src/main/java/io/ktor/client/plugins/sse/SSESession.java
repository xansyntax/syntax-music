package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/sse/SSESession;", "Lkotlinx/coroutines/CoroutineScope;", "", "bodyBuffer", "()[B", "Lkotlinx/coroutines/flow/Flow;", "Lio/ktor/sse/ServerSentEvent;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SSESession extends CoroutineScope {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static byte[] bodyBuffer(SSESession sSESession) {
            return SSESession.super.bodyBuffer();
        }
    }

    default byte[] bodyBuffer() {
        return SSEBufferPolicyKt.getEMPTY();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    /* synthetic */ CoroutineContext getCoroutineContext();

    Flow getIncoming();
}
