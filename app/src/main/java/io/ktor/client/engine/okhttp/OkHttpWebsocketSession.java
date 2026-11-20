package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.websocket.WebSocketException;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketChannelsConfig;
import io.ktor.websocket.WebSocketChannelsConfigKt;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Charsets;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u001d\u0010!J'\u0010%\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b'\u0010&J)\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010)\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b,\u0010-J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010.J\u000f\u0010/\u001a\u00020\u0012H\u0017¢\u0006\u0004\b/\u0010.R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00101R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u00102\u001a\u0004\b3\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0000058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00020\u0017058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u00107\u001a\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R*\u0010@\u001a\u00020>2\u0006\u0010?\u001a\u00020>8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010H\u001a\u00020>2\u0006\u0010?\u001a\u00020>8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER$\u0010N\u001a\u00020I2\u0006\u0010?\u001a\u00020I8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010Q\u001a\u00020>2\u0006\u0010?\u001a\u00020>8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bO\u0010C\"\u0004\bP\u0010ER\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020S0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010UR\u001c\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u00107R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020S0Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020S0]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u001c\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W0a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010j\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpWebsocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lokhttp3/WebSocketListener;", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/WebSocket$Factory;", "webSocketFactory", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/client/plugins/websocket/WebSockets;", "wsConfig", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/WebSocket$Factory;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/plugins/websocket/WebSockets;)V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "", "start", "(Ljava/util/List;)V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "Lokio/ByteString;", "bytes", "onMessage", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", ContentType.Text.TYPE, "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "", "code", "reason", "onClosed", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosing", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()V", "terminate", "Lokhttp3/OkHttpClient;", "Lokhttp3/WebSocket$Factory;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CompletableDeferred;", "self", "Lkotlinx/coroutines/CompletableDeferred;", "originResponse", "getOriginResponse$ktor_client_okhttp", "()Lkotlinx/coroutines/CompletableDeferred;", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "Lio/ktor/websocket/WebSocketChannelsConfig;", "", "_", "pingIntervalMillis", "J", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "setMaxFrameSize", "maxFrameSize", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "_outgoing", "Lio/ktor/websocket/CloseReason;", "_closeReason", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Job;", "writeJob", "Lkotlinx/coroutines/Job;", "getExtensions", "()Ljava/util/List;", "extensions", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpWebsocketSession extends WebSocketListener implements DefaultWebSocketSession {
    private final CompletableDeferred _closeReason;
    private final Channel _incoming;
    private final Channel _outgoing;
    private final WebSocketChannelsConfig channelsConfig;
    private final CoroutineContext coroutineContext;
    private final OkHttpClient engine;
    private final CompletableDeferred originResponse;
    private long pingIntervalMillis;
    private final CompletableDeferred self;
    private final WebSocket.Factory webSocketFactory;
    private final Job writeJob;

    public OkHttpWebsocketSession(OkHttpClient okHttpClient, WebSocket.Factory factory, Request request, CoroutineContext coroutineContext, WebSockets webSockets) {
        okHttpClient.getClass();
        factory.getClass();
        request.getClass();
        coroutineContext.getClass();
        webSockets.getClass();
        this.engine = okHttpClient;
        this.webSocketFactory = factory;
        this.coroutineContext = coroutineContext;
        this.self = AwaitKt.CompletableDeferred$default();
        this.originResponse = AwaitKt.CompletableDeferred$default();
        WebSocketChannelsConfig channelsConfig = webSockets.getChannelsConfig();
        this.channelsConfig = channelsConfig;
        long j = okHttpClient.pingIntervalMillis;
        Long lValueOf = j == 0 ? null : Long.valueOf(j);
        this.pingIntervalMillis = lValueOf != null ? lValueOf.longValue() : webSockets.getPingIntervalMillis();
        if (channelsConfig.getIncoming().getCanSuspend()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("OkHttp does not support SUSPEND overflow strategy for incoming channel");
            throw null;
        }
        Channel.Factory factory2 = Channel.Factory;
        this._incoming = WebSocketChannelsConfigKt.from(factory2, channelsConfig.getIncoming());
        this._outgoing = WebSocketChannelsConfigKt.from(factory2, channelsConfig.getOutgoing());
        this._closeReason = AwaitKt.CompletableDeferred$default();
        this.writeJob = AwaitKt.launch$default(this, null, null, new OkHttpWebsocketSession$writeJob$1(this, request, null), 3);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation continuation) {
        return Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred getCloseReason() {
        return this._closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession, io.ktor.websocket.WebSocketSession, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return EmptyList.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return true;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: getOriginResponse$ktor_client_okhttp, reason: from getter */
    public final CompletableDeferred getOriginResponse() {
        return this.originResponse;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.engine.readTimeoutMillis;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int code, String reason) {
        Object objValueOf;
        webSocket.getClass();
        reason.getClass();
        short s = (short) code;
        ((CompletableDeferredImpl) this._closeReason).makeCompleting$kotlinx_coroutines_core(new CloseReason(s, reason));
        this._incoming.close(null);
        StringBuilder sb = new StringBuilder("WebSocket session closed with code ");
        CloseReason.Codes codesByCode = CloseReason.Codes.INSTANCE.byCode(s);
        if (codesByCode == null || (objValueOf = codesByCode.toString()) == null) {
            objValueOf = Integer.valueOf(code);
        }
        sb.append(objValueOf);
        sb.append('.');
        CancellationException cancellationException = new CancellationException(sb.toString());
        getOutgoing().close(cancellationException);
        this.writeJob.cancel(cancellationException);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.getClass();
        reason.getClass();
        short s = (short) code;
        ((CompletableDeferredImpl) this._closeReason).makeCompleting$kotlinx_coroutines_core(new CloseReason(s, reason));
        getOutgoing().mo1712trySendJP2dKIU(new Frame.Close(new CloseReason(s, reason)));
        this._incoming.close(null);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        webSocket.getClass();
        t.getClass();
        Integer numValueOf = response != null ? Integer.valueOf(response.code) : null;
        int value = HttpStatusCode.INSTANCE.getUnauthorized().getValue();
        if (numValueOf != null && numValueOf.intValue() == value) {
            ((CompletableDeferredImpl) this.originResponse).makeCompleting$kotlinx_coroutines_core(response);
            this._incoming.close(null);
            getOutgoing().close(null);
        } else {
            ((CompletableDeferredImpl) this.originResponse).completeExceptionally(t);
            ((CompletableDeferredImpl) this._closeReason).completeExceptionally(t);
            this._incoming.close(t);
            getOutgoing().close(t);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String text) {
        webSocket.getClass();
        text.getClass();
        Channel channel = this._incoming;
        byte[] bytes = text.getBytes(Charsets.UTF_8);
        bytes.getClass();
        channel.mo1712trySendJP2dKIU(new Frame.Text(true, bytes));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.getClass();
        response.getClass();
        ((CompletableDeferredImpl) this.originResponse).makeCompleting$kotlinx_coroutines_core(response);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public /* bridge */ Object send(Frame frame, Continuation continuation) {
        return super.send(frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        throw new WebSocketException("Masking switch is not supported in OkHttp engine.");
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        throw new WebSocketException("Max frame size switch is not supported in OkHttp engine.");
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j) {
        throw new WebSocketException("OkHttp doesn't support dynamic ping interval. You could switch it in the engine configuration.");
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j) {
        throw new WebSocketException("Websocket timeout should be configured in OkHttp engine.");
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        negotiatedExtensions.getClass();
        if (negotiatedExtensions.isEmpty()) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Extensions are not supported.");
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated
    public void terminate() {
        AwaitKt.cancel(getCoroutineContext(), (CancellationException) null);
    }

    public final void start() {
        ((CompletableDeferredImpl) this.self).makeCompleting$kotlinx_coroutines_core(this);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        webSocket.getClass();
        bytes.getClass();
        this._incoming.mo1712trySendJP2dKIU(new Frame.Binary(true, bytes.toByteArray()));
    }

    public /* synthetic */ OkHttpWebsocketSession(OkHttpClient okHttpClient, WebSocket.Factory factory, Request request, CoroutineContext coroutineContext, WebSockets webSockets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpClient, factory, request, coroutineContext, (i & 16) != 0 ? new WebSockets() : webSockets);
    }
}
