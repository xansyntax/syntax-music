package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002:\u00126\u00124\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJQ\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b28\u0010\r\u001a4\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/TransformRequestBodyHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lio/ktor/util/reflect/TypeInfo;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function5;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TransformRequestBodyHook implements ClientHook<Function5> {
    public static final TransformRequestBodyHook INSTANCE = new TransformRequestBodyHook();

    /* JADX INFO: renamed from: io.ktor.client.plugins.api.TransformRequestBodyHook$install$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.api.TransformRequestBodyHook$install$1", f = "KtorCallContexts.kt", l = {87, 88}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ Function5 $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function5 function5, Continuation continuation) {
            super(3, continuation);
            this.$handler = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, continuation);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        
            if (r0.proceedWith(r13, r11) == r5) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AnonymousClass1 anonymousClass1;
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            int i = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                } else {
                    if (i != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Function5 function5 = this.$handler;
            TransformRequestBodyContext transformRequestBodyContext = new TransformRequestBodyContext();
            Object context = pipelineContext.getContext();
            Object subject = pipelineContext.getSubject();
            TypeInfo bodyType = ((HttpRequestBuilder) pipelineContext.getContext()).getBodyType();
            this.L$0 = pipelineContext;
            this.label = 1;
            anonymousClass1 = this;
            obj = function5.invoke(transformRequestBodyContext, context, subject, bodyType, anonymousClass1);
            if (obj != coroutineSingletons) {
            }
            return coroutineSingletons;
            OutgoingContent outgoingContent = (OutgoingContent) obj;
            if (outgoingContent != null) {
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    private TransformRequestBodyHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function5 handler) {
        client.getClass();
        handler.getClass();
        client.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getTransform(), new AnonymousClass1(handler, null));
    }
}
