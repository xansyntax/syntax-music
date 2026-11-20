package io.ktor.client.call;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/client/call/ReceivePipelineException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "Lio/ktor/client/call/HttpClientCall;", "request", "Lio/ktor/util/reflect/TypeInfo;", "info", "", "cause", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Throwable;)V", "Lio/ktor/client/call/HttpClientCall;", "getRequest", "()Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/util/reflect/TypeInfo;", "getInfo", "()Lio/ktor/util/reflect/TypeInfo;", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReceivePipelineException extends IllegalStateException {
    private final Throwable cause;
    private final TypeInfo info;
    private final HttpClientCall request;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceivePipelineException(HttpClientCall httpClientCall, TypeInfo typeInfo, Throwable th) {
        super("Fail to run receive pipeline: " + th);
        httpClientCall.getClass();
        typeInfo.getClass();
        th.getClass();
        this.request = httpClientCall;
        this.info = typeInfo;
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public final TypeInfo getInfo() {
        return this.info;
    }

    public final HttpClientCall getRequest() {
        return this.request;
    }
}
