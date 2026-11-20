package io.ktor.websocket;

import dagger.hilt.EntryPoints;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/channels/Channel$Factory;", "Lio/ktor/websocket/ChannelConfig;", "config", "Lkotlinx/coroutines/channels/Channel;", "from", "(Lkotlinx/coroutines/channels/Channel$Factory;Lio/ktor/websocket/ChannelConfig;)Lkotlinx/coroutines/channels/Channel;", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WebSocketChannelsConfigKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Channel from(Channel.Factory factory, ChannelConfig channelConfig) {
        factory.getClass();
        channelConfig.getClass();
        Channel channel = null;
        Object[] objArr = 0;
        if (channelConfig.getCapacity() == Integer.MAX_VALUE) {
            return EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
        }
        if (channelConfig.getOnOverflow() == ChannelOverflow.SUSPEND) {
            return EntryPoints.Channel$default(channelConfig.getCapacity(), 4, BufferOverflow.SUSPEND);
        }
        if (channelConfig.getOnOverflow() == ChannelOverflow.CLOSE) {
            return new BoundedChannel(channelConfig.getCapacity(), channel, 2, objArr == true ? 1 : 0);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unsupported channel config.");
        return null;
    }
}
