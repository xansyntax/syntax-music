package io.ktor.network.sockets;

import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.network.selector.SelectorManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0015\u0010\u0012J.\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0018J2\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\fH\u0086@¢\u0006\u0004\b\u0015\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/network/sockets/TcpSocketBuilder;", "Lio/ktor/network/sockets/Configurable;", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "Lio/ktor/network/selector/SelectorManager;", "selector", "options", "<init>", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;)V", "", "hostname", "", "port", "Lkotlin/Function1;", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "", "configure", "Lio/ktor/network/sockets/Socket;", "connect", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/ServerSocket;", "bind", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "(Lio/ktor/network/sockets/SocketAddress;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localAddress", "Lio/ktor/network/selector/SelectorManager;", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "getOptions", "()Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "setOptions", "(Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;)V", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TcpSocketBuilder implements Configurable<TcpSocketBuilder, SocketOptions.PeerSocketOptions> {
    private SocketOptions.PeerSocketOptions options;
    private final SelectorManager selector;

    public TcpSocketBuilder(SelectorManager selectorManager, SocketOptions.PeerSocketOptions peerSocketOptions) {
        selectorManager.getClass();
        peerSocketOptions.getClass();
        this.selector = selectorManager;
        this.options = peerSocketOptions;
    }

    public static /* synthetic */ Object bind$default(TcpSocketBuilder tcpSocketBuilder, String str, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "0.0.0.0";
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 15);
        }
        return tcpSocketBuilder.bind(str, i, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$0(SocketOptions.AcceptorOptions acceptorOptions) {
        acceptorOptions.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$1(SocketOptions.AcceptorOptions acceptorOptions) {
        acceptorOptions.getClass();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object connect$default(TcpSocketBuilder tcpSocketBuilder, String str, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 12);
        }
        return tcpSocketBuilder.connect(str, i, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$0(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        tCPClientSocketOptions.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$1(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        tCPClientSocketOptions.getClass();
        return Unit.INSTANCE;
    }

    public final Object bind(SocketAddress socketAddress, Function1 function1, Continuation continuation) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.AcceptorOptions acceptorOptionsTcpAccept$ktor_network = getOptions().tcpAccept$ktor_network();
        function1.invoke(acceptorOptionsTcpAccept$ktor_network);
        return ConnectUtilsJvmKt.tcpBind(selectorManager, socketAddress, acceptorOptionsTcpAccept$ktor_network, continuation);
    }

    @Override // io.ktor.network.sockets.Configurable
    public /* bridge */ TcpSocketBuilder configure(Function1 function1) {
        return (TcpSocketBuilder) super.configure(function1);
    }

    public final Object connect(SocketAddress socketAddress, Function1 function1, Continuation continuation) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.TCPClientSocketOptions tCPClientSocketOptionsTcpConnect$ktor_network = getOptions().tcpConnect$ktor_network();
        function1.invoke(tCPClientSocketOptionsTcpConnect$ktor_network);
        return ConnectUtilsJvmKt.tcpConnect(selectorManager, socketAddress, tCPClientSocketOptionsTcpConnect$ktor_network, continuation);
    }

    @Override // io.ktor.network.sockets.Configurable
    public SocketOptions.PeerSocketOptions getOptions() {
        return this.options;
    }

    @Override // io.ktor.network.sockets.Configurable
    public void setOptions(SocketOptions.PeerSocketOptions peerSocketOptions) {
        peerSocketOptions.getClass();
        this.options = peerSocketOptions;
    }

    public static /* synthetic */ Object connect$default(TcpSocketBuilder tcpSocketBuilder, SocketAddress socketAddress, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 14);
        }
        return tcpSocketBuilder.connect(socketAddress, function1, continuation);
    }

    public final Object bind(String str, int i, Function1 function1, Continuation continuation) {
        return bind(new InetSocketAddress(str, i), function1, continuation);
    }

    public final Object connect(String str, int i, Function1 function1, Continuation continuation) {
        return connect(new InetSocketAddress(str, i), function1, continuation);
    }

    public static /* synthetic */ Object bind$default(TcpSocketBuilder tcpSocketBuilder, SocketAddress socketAddress, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            socketAddress = null;
        }
        if ((i & 2) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 13);
        }
        return tcpSocketBuilder.bind(socketAddress, function1, continuation);
    }
}
