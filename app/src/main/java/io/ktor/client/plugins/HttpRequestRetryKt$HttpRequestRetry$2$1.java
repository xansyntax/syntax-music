package io.ktor.client.plugins;

import io.ktor.client.plugins.api.OnRequestContext;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/OnRequestContext;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "<unused var>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryKt$HttpRequestRetry$2$1", f = "HttpRequestRetry.kt", l = {}, m = "invokeSuspend", v = 1)
public final class HttpRequestRetryKt$HttpRequestRetry$2$1 extends SuspendLambda implements Function4 {
    final /* synthetic */ int $maxRetries;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestRetryKt$HttpRequestRetry$2$1(int i, Continuation continuation) {
        super(4, continuation);
        this.$maxRetries = i;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(OnRequestContext onRequestContext, HttpRequestBuilder httpRequestBuilder, Object obj, Continuation continuation) {
        HttpRequestRetryKt$HttpRequestRetry$2$1 httpRequestRetryKt$HttpRequestRetry$2$1 = new HttpRequestRetryKt$HttpRequestRetry$2$1(this.$maxRetries, continuation);
        httpRequestRetryKt$HttpRequestRetry$2$1.L$0 = httpRequestBuilder;
        return httpRequestRetryKt$HttpRequestRetry$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        Integer num = (Integer) httpRequestBuilder.getAttributes().getOrNull(HttpRequestRetryKt.getMaxRetriesPerRequestAttributeKey());
        httpRequestBuilder.getAttributes().put(HttpRequestRetryKt.getMaxRetriesPerRequestAttributeKey(), new Integer(num != null ? num.intValue() : this.$maxRetries));
        return Unit.INSTANCE;
    }
}
