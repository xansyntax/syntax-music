package io.ktor.client.plugins;

import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@KtorDsl
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00072&\u0010\t\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\b¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\n\u001a\u00020\u00072,\u0010\t\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\u0002`\u000eH\u0007¢\u0006\u0004\b\n\u0010\u000fJ;\u0010\u0010\u001a\u00020\u00072,\u0010\t\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u000fJ5\u0010\u0013\u001a\u00020\u00072&\u0010\t\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u0012¢\u0006\u0004\b\u0013\u0010\u000bR@\u0010\u0015\u001a(\u0012$\u0012\"\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u00120\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\"\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "<init>", "()V", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/client/plugins/CallExceptionHandler;", "block", "handleResponseException", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "(Lkotlin/jvm/functions/Function3;)V", "handleResponseExceptionWithRequest", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/ResponseValidator;", "validateResponse", "", "responseValidators", "Ljava/util/List;", "getResponseValidators$ktor_client_core", "()Ljava/util/List;", "Lio/ktor/client/plugins/HandlerWrapper;", "responseExceptionHandlers", "getResponseExceptionHandlers$ktor_client_core", "", "expectSuccess", "Z", "getExpectSuccess$ktor_client_core", "()Z", "setExpectSuccess$ktor_client_core", "(Z)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpCallValidatorConfig {
    private final List<Function2> responseValidators = new ArrayList();
    private final List<HandlerWrapper> responseExceptionHandlers = new ArrayList();
    private boolean expectSuccess = true;

    /* JADX INFO: renamed from: getExpectSuccess$ktor_client_core, reason: from getter */
    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final List<HandlerWrapper> getResponseExceptionHandlers$ktor_client_core() {
        return this.responseExceptionHandlers;
    }

    public final List<Function2> getResponseValidators$ktor_client_core() {
        return this.responseValidators;
    }

    public final void handleResponseException(Function2 block) {
        block.getClass();
        this.responseExceptionHandlers.add(new ExceptionHandlerWrapper(block));
    }

    public final void handleResponseExceptionWithRequest(Function3 block) {
        block.getClass();
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
    }

    public final void setExpectSuccess$ktor_client_core(boolean z) {
        this.expectSuccess = z;
    }

    public final void validateResponse(Function2 block) {
        block.getClass();
        this.responseValidators.add(block);
    }

    @Deprecated
    public final void handleResponseException(Function3 block) {
        block.getClass();
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
    }
}
