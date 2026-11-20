package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.content.NullBody;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u000028\u00124\u00122\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJO\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b26\u0010\r\u001a2\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/TransformResponseBodyHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/util/reflect/TypeInfo;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function5;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TransformResponseBodyHook implements ClientHook<Function5> {
    public static final TransformResponseBodyHook INSTANCE = new TransformResponseBodyHook();

    /* JADX INFO: renamed from: io.ktor.client.plugins.api.TransformResponseBodyHook$install$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.api.TransformResponseBodyHook$install$1", f = "KtorCallContexts.kt", l = {113, 120}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ Function5 $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function5 function5, Continuation continuation) {
            super(3, continuation);
            this.$handler = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, continuation);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnonymousClass1 anonymousClass1;
            TypeInfo typeInfo;
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i != 0) {
                if (i == 1) {
                    typeInfo = (TypeInfo) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                } else {
                    if (i != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            ResultKt.throwOnFailure(obj);
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) pipelineContext.getSubject();
            TypeInfo expectedType = httpResponseContainer.getExpectedType();
            Object response = httpResponseContainer.getResponse();
            if (!(response instanceof ByteReadChannel)) {
                return unit;
            }
            Function5 function5 = this.$handler;
            TransformResponseBodyContext transformResponseBodyContext = new TransformResponseBodyContext();
            HttpResponse response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
            this.L$0 = pipelineContext;
            this.L$1 = expectedType;
            this.L$2 = null;
            this.label = 1;
            anonymousClass1 = this;
            obj = function5.invoke(transformResponseBodyContext, response2, response, expectedType, anonymousClass1);
            if (obj != coroutineSingletons) {
                typeInfo = expectedType;
            }
            if (obj == null) {
                return unit;
            }
            if (!(obj instanceof NullBody) && !typeInfo.getType().isInstance(obj)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("transformResponseBody returned ", obj, " but expected value of type ", typeInfo);
                return null;
            }
            HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, obj);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = null;
            anonymousClass1.label = 2;
            return pipelineContext.proceedWith(httpResponseContainer2, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    private TransformResponseBodyHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function5 handler) {
        client.getClass();
        handler.getClass();
        client.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new AnonymousClass1(handler, null));
    }
}
