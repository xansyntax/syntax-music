package io.ktor.client.plugins.sse;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.sse.ServerSentEvent;
import io.ktor.sse.TypedServerSentEvent;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt$SSE$2$2", f = "SSE.kt", l = {127, 130, 155}, m = "invokeSuspend", v = 1)
public final class SSEKt$SSE$2$2 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    public SSEKt$SSE$2$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation continuation) {
        SSEKt$SSE$2$2 sSEKt$SSE$2$2 = new SSEKt$SSE$2$2(continuation);
        sSEKt$SSE$2$2.L$0 = pipelineContext;
        sSEKt$SSE$2$2.L$1 = httpResponseContainer;
        return sSEKt$SSE$2$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Object response;
        HttpResponse response2;
        TypeInfo typeInfo;
        Object obj2;
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
        int i = this.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TypeInfo expectedType = httpResponseContainer.getExpectedType();
            response = httpResponseContainer.getResponse();
            response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
            if (Intrinsics.areEqual(HttpResponseKt.getRequest(response2).getAttributes().getOrNull(BuildersKt.getSseRequestAttr()), Boolean.TRUE)) {
                this.L$0 = pipelineContext;
                this.L$1 = null;
                this.L$2 = expectedType;
                this.L$3 = response;
                this.L$4 = response2;
                this.L$5 = null;
                this.label = 1;
                if (SSEKt.checkResponse(response2, this) != coroutineSingletons) {
                    typeInfo = expectedType;
                }
                return coroutineSingletons;
            }
            Logger logger = SSEKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Skipping non SSE response from " + HttpResponseKt.getRequest(response2).getUrl());
                return unit;
            }
            return unit;
        }
        if (i == 1) {
            HttpResponse httpResponse = (HttpResponse) this.L$4;
            Object obj3 = this.L$3;
            typeInfo = (TypeInfo) this.L$2;
            ResultKt.throwOnFailure(obj);
            response2 = httpResponse;
            response = obj3;
        } else {
            if (i != 2) {
                if (i != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            obj2 = this.L$3;
            ResultKt.throwOnFailure(obj);
        }
        throw new SSEClientException((HttpResponse) obj, null, "Expected " + Reflection.getOrCreateKotlinClass(SSESession.class).getSimpleName() + " content but was " + obj2, 2, null);
        if (response instanceof SSESession) {
            Logger logger2 = SSEKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("Receive SSE session from " + HttpResponseKt.getRequest(response2).getUrl() + ": " + response);
            }
            final Function2 function2 = (Function2) HttpResponseKt.getRequest(response2).getAttributes().getOrNull(BuildersKt.getDeserializerAttr());
            HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, function2 != null ? new ClientSSESessionWithDeserialization((HttpClientCall) pipelineContext.getContext(), new SSESessionWithDeserialization(response, function2) { // from class: io.ktor.client.plugins.sse.SSEKt$SSE$2$2$clientSSESession$1$1
                final /* synthetic */ Object $session;
                private final CoroutineContext coroutineContext;
                private final Function2 deserializer;
                private final Flow incoming;

                {
                    this.$session = response;
                    SSESession sSESession = (SSESession) response;
                    final Flow flow = sSESession.get_incoming();
                    this.incoming = new Flow() { // from class: io.ktor.client.plugins.sse.SSEKt$SSE$2$2$clientSSESession$1$1$special$$inlined$map$1

                        /* JADX INFO: renamed from: io.ktor.client.plugins.sse.SSEKt$SSE$2$2$clientSSESession$1$1$special$$inlined$map$1$2, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: io.ktor.client.plugins.sse.SSEKt$SSE$2$2$clientSSESession$1$1$special$$inlined$map$1$2$1, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                            @DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt$SSE$2$2$clientSSESession$1$1$special$$inlined$map$1$2", f = "SSE.kt", l = {217}, m = "emit", v = 1)
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int I$0;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1;
                                if (continuation instanceof AnonymousClass1) {
                                    anonymousClass1 = (AnonymousClass1) continuation;
                                    int i = anonymousClass1.label;
                                    if ((i & Integer.MIN_VALUE) != 0) {
                                        anonymousClass1.label = i - Integer.MIN_VALUE;
                                    } else {
                                        anonymousClass1 = new AnonymousClass1(continuation);
                                    }
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                                Object obj2 = anonymousClass1.result;
                                int i2 = anonymousClass1.label;
                                if (i2 == 0) {
                                    ResultKt.throwOnFailure(obj2);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    ServerSentEvent serverSentEvent = (ServerSentEvent) obj;
                                    TypedServerSentEvent typedServerSentEvent = new TypedServerSentEvent(serverSentEvent.getData(), serverSentEvent.getEvent(), serverSentEvent.getId(), serverSentEvent.getRetry(), serverSentEvent.getComments());
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    Object objEmit = flowCollector.emit(typedServerSentEvent, anonymousClass1);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objEmit == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else {
                                    if (i2 != 1) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector flowCollector, Continuation continuation) {
                            Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                            return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
                        }
                    };
                    this.deserializer = function2;
                    this.coroutineContext = sSESession.getCoroutineContext();
                }

                @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
                public byte[] bodyBuffer() {
                    return ((SSESession) this.$session).bodyBuffer();
                }

                @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization, kotlinx.coroutines.CoroutineScope
                public CoroutineContext getCoroutineContext() {
                    return this.coroutineContext;
                }

                @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
                public Function2 getDeserializer() {
                    return this.deserializer;
                }

                @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
                public Flow getIncoming() {
                    return this.incoming;
                }
            }) : new ClientSSESession((HttpClientCall) pipelineContext.getContext(), (SSESession) response));
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.L$7 = null;
            this.label = 3;
            if (pipelineContext.proceedWith(httpResponseContainer2, this) != coroutineSingletons) {
                return unit;
            }
        } else {
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = response;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 2;
            obj = SSEKt.saved(response2, this);
            if (obj != coroutineSingletons) {
                obj2 = response;
                throw new SSEClientException((HttpResponse) obj, null, "Expected " + Reflection.getOrCreateKotlinClass(SSESession.class).getSimpleName() + " content but was " + obj2, 2, null);
            }
        }
        return coroutineSingletons;
    }
}
