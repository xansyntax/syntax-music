package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "Context", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AfterReceiveHook implements ClientHook<Function3> {
    public static final AfterReceiveHook INSTANCE = new AfterReceiveHook();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "", "context", "<init>", "(Lio/ktor/util/pipeline/PipelineContext;)V", "response", "proceedWith", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/pipeline/PipelineContext;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Context {
        private final PipelineContext<HttpResponse, Unit> context;

        public Context(PipelineContext<HttpResponse, Unit> pipelineContext) {
            pipelineContext.getClass();
            this.context = pipelineContext;
        }

        public final Object proceedWith(HttpResponse httpResponse, Continuation continuation) {
            return this.context.proceedWith(httpResponse, continuation);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.observer.AfterReceiveHook$install$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.AfterReceiveHook$install$1", f = "ResponseObserver.kt", l = {99}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ Function3 $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function3 function3, Continuation continuation) {
            super(3, continuation);
            this.$handler = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, continuation);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3 function3 = this.$handler;
                Context context = new Context(pipelineContext);
                Object subject = pipelineContext.getSubject();
                this.L$0 = null;
                this.label = 1;
                Object objInvoke = function3.invoke(context, subject, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == coroutineSingletons) {
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

    private AfterReceiveHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3 handler) {
        client.getClass();
        handler.getClass();
        client.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getAfter(), new AnonymousClass1(handler, null));
    }
}
