package io.ktor.network.sockets;

import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.io.Buffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082P¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010!\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010\fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lio/ktor/network/sockets/DatagramSocketImpl;", "Lio/ktor/network/sockets/BoundDatagramSocket;", "Lio/ktor/network/sockets/ConnectedDatagramSocket;", "Lio/ktor/network/sockets/NIOSocketImpl;", "Ljava/nio/channels/DatagramChannel;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "<init>", "(Ljava/nio/channels/DatagramChannel;Lio/ktor/network/selector/SelectorManager;)V", "", "close", "()V", "Lio/ktor/network/sockets/Datagram;", "receiveImpl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "buffer", "receiveSuspend", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/DatagramChannel;", "getChannel", "()Ljava/nio/channels/DatagramChannel;", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "getRemoteAddress", "remoteAddress", "Lkotlinx/coroutines/channels/SendChannel;", "sender", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "receiver", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getReceiver$annotations", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatagramSocketImpl extends NIOSocketImpl<DatagramChannel> implements BoundDatagramSocket, ConnectedDatagramSocket {
    private final DatagramChannel channel;
    private final ReceiveChannel receiver;
    private final SendChannel sender;

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSocketImpl", f = "DatagramSocketImpl.kt", l = {90}, m = "receiveSuspend", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatagramSocketImpl.this.receiveSuspend(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSocketImpl(DatagramChannel datagramChannel, SelectorManager selectorManager) {
        super(datagramChannel, selectorManager, PoolsKt.getDefaultDatagramByteBufferPool(), null, 8, null);
        datagramChannel.getClass();
        selectorManager.getClass();
        this.channel = datagramChannel;
        this.sender = new DatagramSendChannel(getChannel(), this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.receiver = HexFormatKt.produce$default(this, DefaultIoScheduler.INSTANCE, new DatagramSocketImpl$receiver$1(this, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveImpl(Continuation continuation) {
        ByteBuffer byteBufferBorrow = PoolsKt.getDefaultDatagramByteBufferPool().borrow();
        try {
            java.net.SocketAddress socketAddressReceive = getChannel().receive(byteBufferBorrow);
            if (socketAddressReceive == null) {
                return receiveSuspend(byteBufferBorrow, continuation);
            }
            interestOp(SelectInterest.READ, false);
            byteBufferBorrow.flip();
            Buffer buffer = new Buffer();
            BytePacketBuilderExtensions_jvmKt.writeFully(buffer, byteBufferBorrow);
            Datagram datagram = new Datagram(buffer, JavaSocketAddressUtilsKt.toSocketAddress(socketAddressReceive));
            PoolsKt.getDefaultDatagramByteBufferPool().recycle(byteBufferBorrow);
            return datagram;
        } catch (Throwable th) {
            PoolsKt.getDefaultDatagramByteBufferPool().recycle(byteBufferBorrow);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x004e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004c -> B:26:0x004f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object receiveSuspend(java.nio.ByteBuffer r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.network.sockets.DatagramSocketImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1 r0 = (io.ktor.network.sockets.DatagramSocketImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1 r0 = new io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            java.lang.Object r4 = r0.L$1
            io.ktor.network.sockets.DatagramSocketImpl r4 = (io.ktor.network.sockets.DatagramSocketImpl) r4
            java.lang.Object r5 = r0.L$0
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L2d:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r4)
            r4 = 0
            return r4
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
        L37:
            io.ktor.network.selector.SelectInterest r6 = io.ktor.network.selector.SelectInterest.READ
            r4.interestOp(r6, r2)
            io.ktor.network.selector.SelectorManager r1 = r4.getSelector()
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r2
            java.lang.Object r6 = r1.select(r4, r6, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r6 != r1) goto L4f
            return r1
        L4f:
            java.nio.channels.DatagramChannel r6 = r4.getChannel()     // Catch: java.lang.Throwable -> L7c
            java.net.SocketAddress r6 = r6.receive(r5)     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L5a
            goto L37
        L5a:
            io.ktor.network.selector.SelectInterest r0 = io.ktor.network.selector.SelectInterest.READ
            r1 = 0
            r4.interestOp(r0, r1)
            r5.flip()
            kotlinx.io.Buffer r4 = new kotlinx.io.Buffer
            r4.<init>()
            io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt.writeFully(r4, r5)
            io.ktor.network.sockets.SocketAddress r6 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toSocketAddress(r6)
            io.ktor.network.sockets.Datagram r0 = new io.ktor.network.sockets.Datagram
            r0.<init>(r4, r6)
            io.ktor.utils.io.pool.ObjectPool r4 = io.ktor.network.util.PoolsKt.getDefaultDatagramByteBufferPool()
            r4.recycle(r5)
            return r0
        L7c:
            r4 = move-exception
            io.ktor.utils.io.pool.ObjectPool r6 = io.ktor.network.util.PoolsKt.getDefaultDatagramByteBufferPool()
            r6.recycle(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl.receiveSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.network.sockets.SocketBase, io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.receiver.cancel((CancellationException) null);
        super.close();
        this.sender.close(null);
    }

    @Override // io.ktor.network.sockets.DatagramReadChannel
    /* JADX INFO: renamed from: getIncoming, reason: from getter */
    public ReceiveChannel getReceiver() {
        return this.receiver;
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

    @Override // io.ktor.network.sockets.DatagramWriteChannel
    /* JADX INFO: renamed from: getOutgoing, reason: from getter */
    public SendChannel getSender() {
        return this.sender;
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

    @Override // io.ktor.network.sockets.DatagramReadChannel
    public /* bridge */ Object receive(Continuation continuation) {
        return super.receive(continuation);
    }

    @Override // io.ktor.network.sockets.DatagramWriteChannel
    public /* bridge */ Object send(Datagram datagram, Continuation continuation) {
        return super.send(datagram, continuation);
    }

    @Override // io.ktor.network.sockets.NIOSocketImpl, io.ktor.network.selector.Selectable
    public DatagramChannel getChannel() {
        return this.channel;
    }

    private static /* synthetic */ void getReceiver$annotations() {
    }
}
