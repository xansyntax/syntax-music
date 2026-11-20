package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.logging.LoggerJvmKt;
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
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$1", f = "WebSockets.kt", l = {218}, m = "invokeSuspend", v = 1)
public final class WebSockets$Plugin$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$1(boolean z, WebSockets webSockets, Continuation continuation) {
        super(3, continuation);
        this.$extensionsSupported = z;
        this.$plugin = webSockets;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
        WebSockets$Plugin$install$1 webSockets$Plugin$install$1 = new WebSockets$Plugin$install$1(this.$extensionsSupported, this.$plugin, continuation);
        webSockets$Plugin$install$1.L$0 = pipelineContext;
        return webSockets$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        int i = this.label;
        Unit unit = Unit.INSTANCE;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!URLProtocolKt.isWebsocket(((HttpRequestBuilder) pipelineContext.getContext()).getUrl().getProtocol())) {
                Logger logger = WebSocketsKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    logger.trace("Skipping WebSocket plugin for non-websocket request: " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
                }
                return unit;
            }
            Logger logger2 = WebSocketsKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("Sending WebSocket request " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
            }
            ((HttpRequestBuilder) pipelineContext.getContext()).setCapability(WebSocketCapability.INSTANCE, unit);
            if (this.$extensionsSupported) {
                this.$plugin.installExtensions((HttpRequestBuilder) pipelineContext.getContext());
            }
            ((HttpRequestBuilder) pipelineContext.getContext()).getAttributes().set(WebSocketsKt.getWEBSOCKETS_KEY(), this.$plugin);
            WebSocketContent webSocketContent = new WebSocketContent();
            this.L$0 = null;
            this.label = 1;
            Object objProceedWith = pipelineContext.proceedWith(webSocketContent, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objProceedWith == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return unit;
    }
}
