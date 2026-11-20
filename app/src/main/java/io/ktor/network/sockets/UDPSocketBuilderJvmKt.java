package io.ktor.network.sockets;

import io.ktor.network.selector.SelectorManager;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "localAddress", "Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "options", "Lio/ktor/network/sockets/ConnectedDatagramSocket;", "udpConnect", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/network/sockets/BoundDatagramSocket;", "udpBind", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UDPSocketBuilderJvmKt {
    public static final Object udpBind(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.UDPSocketOptions uDPSocketOptions, Continuation continuation) throws IOException {
        DatagramChannel datagramChannelOpenDatagramChannel = selectorManager.getProvider().openDatagramChannel();
        try {
            datagramChannelOpenDatagramChannel.getClass();
            JavaSocketOptionsKt.assignOptions(datagramChannelOpenDatagramChannel, uDPSocketOptions);
            JavaSocketOptionsKt.nonBlocking(datagramChannelOpenDatagramChannel);
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                datagramChannelOpenDatagramChannel.bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null);
            } else {
                datagramChannelOpenDatagramChannel.socket().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null);
            }
            return new DatagramSocketImpl(datagramChannelOpenDatagramChannel, selectorManager);
        } catch (Throwable th) {
            datagramChannelOpenDatagramChannel.close();
            throw th;
        }
    }

    public static final Object udpConnect(SelectorManager selectorManager, SocketAddress socketAddress, SocketAddress socketAddress2, SocketOptions.UDPSocketOptions uDPSocketOptions, Continuation continuation) throws IOException {
        DatagramChannel datagramChannelOpenDatagramChannel = selectorManager.getProvider().openDatagramChannel();
        try {
            datagramChannelOpenDatagramChannel.getClass();
            JavaSocketOptionsKt.assignOptions(datagramChannelOpenDatagramChannel, uDPSocketOptions);
            JavaSocketOptionsKt.nonBlocking(datagramChannelOpenDatagramChannel);
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                datagramChannelOpenDatagramChannel.bind(socketAddress2 != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress2) : null);
            } else {
                datagramChannelOpenDatagramChannel.socket().bind(socketAddress2 != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress2) : null);
            }
            datagramChannelOpenDatagramChannel.connect(JavaSocketAddressUtilsKt.toJavaAddress(socketAddress));
            return new DatagramSocketImpl(datagramChannelOpenDatagramChannel, selectorManager);
        } catch (Throwable th) {
            datagramChannelOpenDatagramChannel.close();
            throw th;
        }
    }
}
