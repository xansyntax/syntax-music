package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$writeJob$1", f = "OkHttpWebsocketSession.kt", l = {76, 80}, m = "invokeSuspend", v = 1)
public final class OkHttpWebsocketSession$writeJob$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Request $engineRequest;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OkHttpWebsocketSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpWebsocketSession$writeJob$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = okHttpWebsocketSession;
        this.$engineRequest = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OkHttpWebsocketSession$writeJob$1(this.this$0, this.$engineRequest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OkHttpWebsocketSession$writeJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
    
        if (r15 == r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        if (r15 == r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        return r3;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0123: INVOKE (r15 I:short) = (r4 I:io.ktor.websocket.CloseReason) VIRTUAL call: io.ktor.websocket.CloseReason.getCode():short A[Catch: all -> 0x0132, MD:():short (m), TRY_ENTER] (LINE:292), block:B:48:0x0123 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x012b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:300), block:B:48:0x0123 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0134: CHECK_CAST (r5 I:okhttp3.internal.ws.RealWebSocket) = (okhttp3.internal.ws.RealWebSocket) (r5 I:??[OBJECT, ARRAY]), block:B:51:0x0133 */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.websocket.CloseReason] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0078 -> B:22:0x007b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RealWebSocket realWebSocketCancel;
        ?? code;
        RealWebSocket realWebSocket;
        WebSocket.Factory factory;
        Request request;
        WebSocket webSocketNewWebSocket;
        CloseReason closeReason;
        Object it;
        ChannelIterator channelIterator;
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i != 0) {
                if (i == 1) {
                    request = (Request) this.L$1;
                    factory = (WebSocket.Factory) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ChannelIterator channelIterator2 = (ChannelIterator) this.L$2;
                    closeReason = (CloseReason) this.L$1;
                    webSocketNewWebSocket = (WebSocket) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    channelIterator = channelIterator2;
                }
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Unit unit = Unit.INSTANCE;
                if (!zBooleanValue) {
                    try {
                        ((RealWebSocket) webSocketNewWebSocket).close(closeReason.getCode(), closeReason.getMessage());
                        return unit;
                    } catch (Throwable th) {
                        ((RealWebSocket) webSocketNewWebSocket).cancel();
                        throw th;
                    }
                }
                BufferedChannel.BufferedChannelIterator bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                Frame frame = (Frame) bufferedChannelIterator.next();
                if (frame instanceof Frame.Binary) {
                    ByteString byteString = ByteString.EMPTY;
                    byte[] data = frame.getData();
                    int length = frame.getData().length;
                    data.getClass();
                    HexFormatKt.checkOffsetAndCount(data.length, 0L, length);
                    ByteString byteString2 = new ByteString(ArraysKt.copyOfRange(data, 0, length));
                    RealWebSocket realWebSocket2 = (RealWebSocket) webSocketNewWebSocket;
                    realWebSocket2.getClass();
                    realWebSocket2.send(2, byteString2);
                    it = bufferedChannelIterator;
                } else {
                    if (!(frame instanceof Frame.Text)) {
                        if (!(frame instanceof Frame.Close)) {
                            throw new UnsupportedFrameTypeException(frame);
                        }
                        CloseReason reason = FrameCommonKt.readReason((Frame.Close) frame);
                        reason.getClass();
                        if (!OkHttpWebsocketSessionKt.isReserved(reason)) {
                            closeReason = reason;
                        }
                        try {
                            ((RealWebSocket) webSocketNewWebSocket).close(closeReason.getCode(), closeReason.getMessage());
                            return unit;
                        } catch (Throwable th2) {
                            ((RealWebSocket) webSocketNewWebSocket).cancel();
                            throw th2;
                        }
                    }
                    String str = new String(frame.getData(), Charsets.UTF_8);
                    RealWebSocket realWebSocket3 = (RealWebSocket) webSocketNewWebSocket;
                    realWebSocket3.getClass();
                    ByteString byteString3 = ByteString.EMPTY;
                    realWebSocket3.send(1, Path.Companion.encodeUtf8(str));
                    it = bufferedChannelIterator;
                }
                this.L$0 = webSocketNewWebSocket;
                this.L$1 = closeReason;
                this.L$2 = it;
                this.label = 2;
                BufferedChannel.BufferedChannelIterator bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) it;
                obj = bufferedChannelIterator2.hasNext(this);
                channelIterator = bufferedChannelIterator2;
            } else {
                ResultKt.throwOnFailure(obj);
                factory = this.this$0.webSocketFactory;
                request = this.$engineRequest;
                CompletableDeferred completableDeferred = this.this$0.self;
                this.L$0 = factory;
                this.L$1 = request;
                this.label = 1;
                obj = ((CompletableDeferredImpl) completableDeferred).awaitInternal(this);
            }
            webSocketNewWebSocket = ((OkHttpClient) factory).newWebSocket(request, (WebSocketListener) obj);
            closeReason = OkHttpWebsocketSessionKt.DEFAULT_CLOSE_REASON_ERROR;
            it = this.this$0._outgoing.iterator();
            this.L$0 = webSocketNewWebSocket;
            this.L$1 = closeReason;
            this.L$2 = it;
            this.label = 2;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator3 = (BufferedChannel.BufferedChannelIterator) it;
            obj = bufferedChannelIterator3.hasNext(this);
            channelIterator = bufferedChannelIterator3;
        } catch (Throwable th3) {
            try {
                realWebSocket.close(code.getCode(), code.getMessage());
                throw th3;
            } catch (Throwable th4) {
                realWebSocketCancel.cancel();
                throw th4;
            }
        }
    }
}
