package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketSession;", "RawWebSocket", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;Lio/ktor/websocket/WebSocketChannelsConfig;)Lio/ktor/websocket/WebSocketSession;", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RawWebSocketJvmKt {
    public static final WebSocketSession RawWebSocket(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig) {
        byteReadChannel.getClass();
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        webSocketChannelsConfig.getClass();
        return new RawWebSocketJvm(byteReadChannel, byteWriteChannel, j, z, coroutineContext, webSocketChannelsConfig, null, 64, null);
    }

    public static /* synthetic */ WebSocketSession RawWebSocket$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 2147483647L;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            webSocketChannelsConfig = WebSocketChannelsConfig.INSTANCE.getUNLIMITED();
        }
        return RawWebSocket(byteReadChannel, byteWriteChannel, j2, z2, coroutineContext, webSocketChannelsConfig);
    }

    @Deprecated
    public static final /* synthetic */ WebSocketSession RawWebSocket(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext) {
        byteReadChannel.getClass();
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        return RawWebSocket(byteReadChannel, byteWriteChannel, j, z, coroutineContext, WebSocketChannelsConfig.INSTANCE.getUNLIMITED());
    }

    public static /* synthetic */ WebSocketSession RawWebSocket$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 2147483647L;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        return RawWebSocket(byteReadChannel, byteWriteChannel, j2, z, coroutineContext);
    }
}
