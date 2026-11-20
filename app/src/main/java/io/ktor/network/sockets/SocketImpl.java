package io.ktor.network.sockets;

import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectorManager;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.SocketChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B#\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0080@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Lio/ktor/network/sockets/SocketImpl;", "Ljava/nio/channels/SocketChannel;", "S", "Lio/ktor/network/sockets/NIOSocketImpl;", "Lio/ktor/network/sockets/Socket;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "<init>", "(Ljava/nio/channels/SocketChannel;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)V", "Ljava/net/SocketAddress;", "target", "connect$ktor_network", "(Ljava/net/SocketAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect", "", "state", "", "wantConnect", "(Z)V", "inetSelfConnect", "()Z", "Ljava/nio/channels/SocketChannel;", "getChannel", "()Ljava/nio/channels/SocketChannel;", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "getRemoteAddress", "remoteAddress", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SocketImpl<S extends SocketChannel> extends NIOSocketImpl<S> implements Socket {
    private final S channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketImpl(S s, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        super(s, selectorManager, null, tCPClientSocketOptions);
        s.getClass();
        selectorManager.getClass();
        this.channel = s;
        if (getChannel().isBlocking()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Channel need to be configured as non-blocking.");
            throw null;
        }
    }

    private final boolean inetSelfConnect() {
        String hostAddress;
        InetAddress address;
        InetAddress address2;
        String hostAddress2;
        InetAddress address3;
        java.net.SocketAddress localAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getLocalAddress() : getChannel().socket().getLocalSocketAddress();
        java.net.SocketAddress remoteAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getRemoteAddress() : getChannel().socket().getRemoteSocketAddress();
        if (localAddress == null || remoteAddress == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("localAddress and remoteAddress should not be null.");
            return false;
        }
        java.net.InetSocketAddress inetSocketAddress = localAddress instanceof java.net.InetSocketAddress ? (java.net.InetSocketAddress) localAddress : null;
        java.net.InetSocketAddress inetSocketAddress2 = remoteAddress instanceof java.net.InetSocketAddress ? (java.net.InetSocketAddress) remoteAddress : null;
        if (inetSocketAddress == null && inetSocketAddress2 == null) {
            return false;
        }
        String str = "";
        if (inetSocketAddress == null || (address3 = inetSocketAddress.getAddress()) == null || (hostAddress = address3.getHostAddress()) == null) {
            hostAddress = "";
        }
        if (inetSocketAddress2 != null && (address2 = inetSocketAddress2.getAddress()) != null && (hostAddress2 = address2.getHostAddress()) != null) {
            str = hostAddress2;
        }
        return Intrinsics.areEqual(inetSocketAddress != null ? Integer.valueOf(inetSocketAddress.getPort()) : null, inetSocketAddress2 != null ? Integer.valueOf(inetSocketAddress2.getPort()) : null) && (((inetSocketAddress2 == null || (address = inetSocketAddress2.getAddress()) == null) ? false : address.isAnyLocalAddress()) || hostAddress.equals(str));
    }

    private final void wantConnect(boolean state) {
        interestOp(SelectInterest.CONNECT, state);
    }

    public static /* synthetic */ void wantConnect$default(SocketImpl socketImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        socketImpl.wantConnect(z);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object connect$ktor_network(java.net.SocketAddress socketAddress, Continuation continuation) throws IOException {
        SocketImpl$connect$1 socketImpl$connect$1;
        if (continuation instanceof SocketImpl$connect$1) {
            socketImpl$connect$1 = (SocketImpl$connect$1) continuation;
            int i = socketImpl$connect$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                socketImpl$connect$1.label = i - Integer.MIN_VALUE;
            } else {
                socketImpl$connect$1 = new SocketImpl$connect$1(this, continuation);
            }
        } else {
            socketImpl$connect$1 = new SocketImpl$connect$1(this, continuation);
        }
        Object obj = socketImpl$connect$1.result;
        int i2 = socketImpl$connect$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (getChannel().connect(socketAddress)) {
                return this;
            }
            wantConnect(true);
            SelectorManager selector = getSelector();
            SelectInterest selectInterest = SelectInterest.CONNECT;
            socketImpl$connect$1.L$0 = null;
            socketImpl$connect$1.label = 1;
            if (selector.select(this, selectInterest, socketImpl$connect$1) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1 && i2 != 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        while (true) {
            if (!getChannel().finishConnect()) {
                wantConnect(true);
                SelectorManager selector2 = getSelector();
                SelectInterest selectInterest2 = SelectInterest.CONNECT;
                socketImpl$connect$1.L$0 = null;
                socketImpl$connect$1.label = 2;
                if (selector2.select(this, selectInterest2, socketImpl$connect$1) == coroutineSingletons) {
                    break;
                }
            } else {
                if (!inetSelfConnect()) {
                    wantConnect(false);
                    return this;
                }
                if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                    getChannel().close();
                } else {
                    getChannel().socket().close();
                }
            }
        }
        return coroutineSingletons;
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() {
        SocketAddress socketAddress;
        java.net.SocketAddress localAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getLocalAddress() : getChannel().socket().getLocalSocketAddress();
        if (localAddress != null && (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(localAddress)) != null) {
            return socketAddress;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Channel is not yet bound");
        return null;
    }

    @Override // io.ktor.network.sockets.AConnectedSocket
    public SocketAddress getRemoteAddress() {
        SocketAddress socketAddress;
        java.net.SocketAddress remoteAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getRemoteAddress() : getChannel().socket().getRemoteSocketAddress();
        if (remoteAddress != null && (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(remoteAddress)) != null) {
            return socketAddress;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Channel is not yet connected");
        return null;
    }

    @Override // io.ktor.network.sockets.NIOSocketImpl, io.ktor.network.selector.Selectable
    public S getChannel() {
        return this.channel;
    }

    public /* synthetic */ SocketImpl(SocketChannel socketChannel, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(socketChannel, selectorManager, (i & 4) != 0 ? null : tCPClientSocketOptions);
    }
}
