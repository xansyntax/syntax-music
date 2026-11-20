package io.ktor.network.sockets;

import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.network.selector.SelectorManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u0014J:\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\"\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/network/sockets/UDPSocketBuilder;", "Lio/ktor/network/sockets/Configurable;", "Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "Lio/ktor/network/selector/SelectorManager;", "selector", "options", "<init>", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;)V", "Lio/ktor/network/sockets/SocketAddress;", "localAddress", "Lkotlin/Function1;", "", "configure", "Lio/ktor/network/sockets/BoundDatagramSocket;", "bind", "(Lio/ktor/network/sockets/SocketAddress;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "hostname", "", "port", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteAddress", "Lio/ktor/network/sockets/ConnectedDatagramSocket;", "connect", "(Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketAddress;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/network/selector/SelectorManager;", "Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "getOptions", "()Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "setOptions", "(Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;)V", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UDPSocketBuilder implements Configurable<UDPSocketBuilder, SocketOptions.UDPSocketOptions> {
    private SocketOptions.UDPSocketOptions options;
    private final SelectorManager selector;

    public UDPSocketBuilder(SelectorManager selectorManager, SocketOptions.UDPSocketOptions uDPSocketOptions) {
        selectorManager.getClass();
        uDPSocketOptions.getClass();
        this.selector = selectorManager;
        this.options = uDPSocketOptions;
    }

    public static /* synthetic */ Object bind$default(UDPSocketBuilder uDPSocketBuilder, String str, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "0.0.0.0";
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 16);
        }
        return uDPSocketBuilder.bind(str, i, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$0(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        uDPSocketOptions.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$1(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        uDPSocketOptions.getClass();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object connect$default(UDPSocketBuilder uDPSocketBuilder, SocketAddress socketAddress, SocketAddress socketAddress2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            socketAddress2 = null;
        }
        if ((i & 4) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 18);
        }
        return uDPSocketBuilder.connect(socketAddress, socketAddress2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$0(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        uDPSocketOptions.getClass();
        return Unit.INSTANCE;
    }

    public final Object bind(SocketAddress socketAddress, Function1 function1, Continuation continuation) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.UDPSocketOptions uDPSocketOptionsUdp$ktor_network = getOptions().udp$ktor_network();
        function1.invoke(uDPSocketOptionsUdp$ktor_network);
        return UDPSocketBuilderJvmKt.udpBind(selectorManager, socketAddress, uDPSocketOptionsUdp$ktor_network, continuation);
    }

    @Override // io.ktor.network.sockets.Configurable
    public /* bridge */ UDPSocketBuilder configure(Function1 function1) {
        return (UDPSocketBuilder) super.configure(function1);
    }

    public final Object connect(SocketAddress socketAddress, SocketAddress socketAddress2, Function1 function1, Continuation continuation) {
        SelectorManager selectorManager = this.selector;
        SocketOptions.UDPSocketOptions uDPSocketOptionsUdp$ktor_network = getOptions().udp$ktor_network();
        function1.invoke(uDPSocketOptionsUdp$ktor_network);
        return UDPSocketBuilderJvmKt.udpConnect(selectorManager, socketAddress, socketAddress2, uDPSocketOptionsUdp$ktor_network, continuation);
    }

    @Override // io.ktor.network.sockets.Configurable
    public SocketOptions.UDPSocketOptions getOptions() {
        return this.options;
    }

    @Override // io.ktor.network.sockets.Configurable
    public void setOptions(SocketOptions.UDPSocketOptions uDPSocketOptions) {
        uDPSocketOptions.getClass();
        this.options = uDPSocketOptions;
    }

    public final Object bind(String str, int i, Function1 function1, Continuation continuation) {
        return bind(new InetSocketAddress(str, i), function1, continuation);
    }

    public static /* synthetic */ Object bind$default(UDPSocketBuilder uDPSocketBuilder, SocketAddress socketAddress, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            socketAddress = null;
        }
        if ((i & 2) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 17);
        }
        return uDPSocketBuilder.bind(socketAddress, function1, continuation);
    }
}
