package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJA\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2(\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/sse/AfterRender;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/content/OutgoingContent;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class AfterRender implements ClientHook<Function3> {
    public static final AfterRender INSTANCE = new AfterRender();

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.AfterRender$install$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.AfterRender$install$1", f = "SSE.kt", l = {183, 183}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ Function3 $handler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function3 function3, Continuation continuation) {
            super(3, continuation);
            this.$handler = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i != 0) {
                if (i == 1) {
                    pipelineContext = (PipelineContext) this.L$2;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            ResultKt.throwOnFailure(obj);
            if (!(obj2 instanceof OutgoingContent)) {
                return unit;
            }
            Function3 function3 = this.$handler;
            Object context = pipelineContext.getContext();
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = pipelineContext;
            this.label = 1;
            obj = function3.invoke(context, obj2, this);
            if (obj != coroutineSingletons) {
            }
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            return pipelineContext.proceedWith(obj, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    private AfterRender() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3 handler) {
        client.getClass();
        handler.getClass();
        PipelinePhase pipelinePhase = new PipelinePhase("AfterRender");
        client.getRequestPipeline().insertPhaseAfter(HttpRequestPipeline.INSTANCE.getRender(), pipelinePhase);
        client.getRequestPipeline().intercept(pipelinePhase, new AnonymousClass1(handler, null));
    }
}
