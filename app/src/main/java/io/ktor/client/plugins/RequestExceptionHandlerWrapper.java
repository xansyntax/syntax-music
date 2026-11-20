package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B5\u0012,\u0010\t\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bR=\u0010\t\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002j\u0002`\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/RequestExceptionHandlerWrapper;", "Lio/ktor/client/plugins/HandlerWrapper;", "Lkotlin/Function3;", "", "Lio/ktor/client/request/HttpRequest;", "Lkotlin/coroutines/Continuation;", "", "", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "getHandler", "()Lkotlin/jvm/functions/Function3;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RequestExceptionHandlerWrapper implements HandlerWrapper {
    private final Function3 handler;

    public RequestExceptionHandlerWrapper(Function3 function3) {
        function3.getClass();
        this.handler = function3;
    }

    public final Function3 getHandler() {
        return this.handler;
    }
}
