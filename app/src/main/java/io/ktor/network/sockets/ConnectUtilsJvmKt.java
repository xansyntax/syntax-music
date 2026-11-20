package io.ktor.network.sockets;

import io.ktor.network.selector.SelectorManager;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0080@¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00140\u0014*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/network/sockets/Socket;", "tcpConnect", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localAddress", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/ServerSocket;", "tcpBind", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/spi/SelectorProvider;", "address", "Ljava/nio/channels/SocketChannel;", "kotlin.jvm.PlatformType", "openSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/SocketChannel;", "Ljava/nio/channels/ServerSocketChannel;", "openServerSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/ServerSocketChannel;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConnectUtilsJvmKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.ConnectUtilsJvmKt", f = "ConnectUtilsJvm.kt", l = {21}, m = "tcpConnect", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectUtilsJvmKt.tcpConnect(null, null, null, this);
        }
    }

    public static final ServerSocketChannel openServerSocketChannelFor(SelectorProvider selectorProvider, SocketAddress socketAddress) throws IllegalAccessException, InvocationTargetException {
        selectorProvider.getClass();
        if (socketAddress == null) {
            return selectorProvider.openServerSocketChannel();
        }
        if (socketAddress instanceof InetSocketAddress) {
            return selectorProvider.openServerSocketChannel();
        }
        if (!(socketAddress instanceof UnixSocketAddress)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        Object objInvoke = SelectorProvider.class.getMethod("openServerSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        objInvoke.getClass();
        return (ServerSocketChannel) objInvoke;
    }

    public static final SocketChannel openSocketChannelFor(SelectorProvider selectorProvider, SocketAddress socketAddress) throws IllegalAccessException, InvocationTargetException {
        selectorProvider.getClass();
        socketAddress.getClass();
        if (socketAddress instanceof InetSocketAddress) {
            return selectorProvider.openSocketChannel();
        }
        if (!(socketAddress instanceof UnixSocketAddress)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        Object objInvoke = SelectorProvider.class.getMethod("openSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        objInvoke.getClass();
        return (SocketChannel) objInvoke;
    }

    public static final Object tcpBind(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.AcceptorOptions acceptorOptions, Continuation continuation) throws IllegalAccessException, IOException, InvocationTargetException {
        ServerSocketChannel serverSocketChannelOpenServerSocketChannelFor = openServerSocketChannelFor(selectorManager.getProvider(), socketAddress);
        try {
            if (socketAddress instanceof InetSocketAddress) {
                serverSocketChannelOpenServerSocketChannelFor.getClass();
                JavaSocketOptionsKt.assignOptions(serverSocketChannelOpenServerSocketChannelFor, acceptorOptions);
            }
            serverSocketChannelOpenServerSocketChannelFor.getClass();
            JavaSocketOptionsKt.nonBlocking(serverSocketChannelOpenServerSocketChannelFor);
            ServerSocketImpl serverSocketImpl = new ServerSocketImpl(serverSocketChannelOpenServerSocketChannelFor, selectorManager);
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                serverSocketImpl.getChannel().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
                return serverSocketImpl;
            }
            serverSocketImpl.getChannel().socket().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
            return serverSocketImpl;
        } catch (Throwable th) {
            serverSocketChannelOpenServerSocketChannelFor.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object tcpConnect(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Closeable closeable;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SocketChannel socketChannelOpenSocketChannelFor = openSocketChannelFor(selectorManager.getProvider(), socketAddress);
            try {
                if (socketAddress instanceof InetSocketAddress) {
                    socketChannelOpenSocketChannelFor.getClass();
                    JavaSocketOptionsKt.assignOptions(socketChannelOpenSocketChannelFor, tCPClientSocketOptions);
                }
                socketChannelOpenSocketChannelFor.getClass();
                JavaSocketOptionsKt.nonBlocking(socketChannelOpenSocketChannelFor);
                SocketImpl socketImpl = new SocketImpl(socketChannelOpenSocketChannelFor, selectorManager, tCPClientSocketOptions);
                java.net.SocketAddress javaAddress = JavaSocketAddressUtilsKt.toJavaAddress(socketAddress);
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = socketChannelOpenSocketChannelFor;
                anonymousClass1.L$6 = socketImpl;
                anonymousClass1.L$7 = null;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 1;
                Object objConnect$ktor_network = socketImpl.connect$ktor_network(javaAddress, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objConnect$ktor_network == coroutineSingletons ? coroutineSingletons : socketImpl;
            } catch (Throwable th) {
                th = th;
                closeable = socketChannelOpenSocketChannelFor;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            SocketImpl socketImpl2 = (SocketImpl) anonymousClass1.L$6;
            closeable = (Closeable) anonymousClass1.L$5;
            try {
                ResultKt.throwOnFailure(obj);
                return socketImpl2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        closeable.close();
        throw th;
    }
}
