package io.ktor.client.plugins.cookies;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$Companion$install$1", f = "HttpCookies.kt", l = {129}, m = "invokeSuspend", v = 1)
public final class HttpCookies$Companion$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ HttpCookies $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$Companion$install$1(HttpCookies httpCookies, Continuation continuation) {
        super(3, continuation);
        this.$plugin = httpCookies;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
        HttpCookies$Companion$install$1 httpCookies$Companion$install$1 = new HttpCookies$Companion$install$1(this.$plugin, continuation);
        httpCookies$Companion$install$1.L$0 = pipelineContext;
        return httpCookies$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpCookies httpCookies = this.$plugin;
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.getContext();
            this.L$0 = null;
            this.label = 1;
            Object objCaptureHeaderCookies$ktor_client_core = httpCookies.captureHeaderCookies$ktor_client_core(httpRequestBuilder, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCaptureHeaderCookies$ktor_client_core == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
