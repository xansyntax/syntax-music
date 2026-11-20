package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2", f = "WebSockets.kt", l = {269}, m = "invokeSuspend", v = 1)
public final class WebSockets$Plugin$install$2 extends SuspendLambda implements Function3 {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$2(WebSockets webSockets, boolean z, Continuation continuation) {
        super(3, continuation);
        this.$plugin = webSockets;
        this.$extensionsSupported = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation continuation) {
        WebSockets$Plugin$install$2 webSockets$Plugin$install$2 = new WebSockets$Plugin$install$2(this.$plugin, this.$extensionsSupported, continuation);
        webSockets$Plugin$install$2.L$0 = pipelineContext;
        webSockets$Plugin$install$2.L$1 = httpResponseContainer;
        return webSockets$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object delegatingClientWebSocketSession;
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
        int i = this.label;
        Unit unit = Unit.INSTANCE;
        if (i != 0) {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return unit;
        }
        ResultKt.throwOnFailure(obj);
        TypeInfo expectedType = httpResponseContainer.getExpectedType();
        Object response = httpResponseContainer.getResponse();
        HttpResponse response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
        HttpStatusCode status = response2.getStatus();
        OutgoingContent content = HttpResponseKt.getRequest(response2).getContent();
        if (content instanceof WebSocketContent) {
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (!Intrinsics.areEqual(status, companion.getSwitchingProtocols())) {
                throw new WebSocketException("Handshake exception, expected status code " + companion.getSwitchingProtocols().getValue() + " but was " + status.getValue());
            }
            if (!(response instanceof WebSocketSession)) {
                throw new WebSocketException("Handshake exception, expected `WebSocketSession` content but was " + Reflection.getOrCreateKotlinClass(response.getClass()));
            }
            Logger logger = WebSocketsKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Receive websocket session from " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + ": " + response);
            }
            if (this.$plugin.getMaxFrameSize() != 2147483647L) {
                ((WebSocketSession) response).setMaxFrameSize(this.$plugin.getMaxFrameSize());
            }
            if (Intrinsics.areEqual(expectedType.getType(), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class))) {
                DefaultClientWebSocketSession defaultClientWebSocketSession = new DefaultClientWebSocketSession((HttpClientCall) pipelineContext.getContext(), this.$plugin.convertSessionToDefault$ktor_client_core((WebSocketSession) response));
                defaultClientWebSocketSession.start(this.$extensionsSupported ? this.$plugin.completeNegotiation((HttpClientCall) pipelineContext.getContext()) : EmptyList.INSTANCE);
                delegatingClientWebSocketSession = defaultClientWebSocketSession;
            } else {
                delegatingClientWebSocketSession = new DelegatingClientWebSocketSession((HttpClientCall) pipelineContext.getContext(), (WebSocketSession) response);
            }
            HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(expectedType, delegatingClientWebSocketSession);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.L$7 = null;
            this.label = 1;
            Object objProceedWith = pipelineContext.proceedWith(httpResponseContainer2, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objProceedWith == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            Logger logger2 = WebSocketsKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("Skipping non-websocket response from " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + ": " + content);
                return unit;
            }
        }
        return unit;
    }
}
