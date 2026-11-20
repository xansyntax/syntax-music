package io.ktor.network.sockets;

import io.ktor.network.selector.SelectInterest;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0094@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\r*\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/network/sockets/DatagramSendChannel;", "Lio/ktor/network/sockets/DatagramSendChannelBase;", "Ljava/nio/channels/DatagramChannel;", "channel", "Lio/ktor/network/sockets/DatagramSocketImpl;", "socket", "<init>", "(Ljava/nio/channels/DatagramChannel;Lio/ktor/network/sockets/DatagramSocketImpl;)V", "Lio/ktor/network/sockets/Datagram;", "element", "", "trySendImpl", "(Lio/ktor/network/sockets/Datagram;)Z", "", "sendImpl", "(Lio/ktor/network/sockets/Datagram;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "buffer", "Lio/ktor/network/sockets/SocketAddress;", "address", "sendSuspend", "(Ljava/nio/ByteBuffer;Lio/ktor/network/sockets/SocketAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "writeMessageTo", "(Lkotlinx/io/Source;Ljava/nio/ByteBuffer;)V", "Ljava/nio/channels/DatagramChannel;", "Lio/ktor/network/sockets/DatagramSocketImpl;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatagramSendChannel extends DatagramSendChannelBase {
    private final DatagramChannel channel;
    private final DatagramSocketImpl socket;

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSendChannel$sendImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSendChannel$sendImpl$2", f = "DatagramSendChannel.kt", l = {73, 86}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Datagram $element;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        final /* synthetic */ DatagramSendChannel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Datagram datagram, DatagramSendChannel datagramSendChannel, Continuation continuation) {
            super(2, continuation);
            this.$element = datagram;
            this.this$0 = datagramSendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$element, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0113 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:31:0x0115  */
        /* JADX WARN: Code duplicated, block: B:33:0x011b  */
        /* JADX WARN: Code duplicated, block: B:34:0x0120  */
        /* JADX WARN: Code duplicated, block: B:36:0x0128  */
        /* JADX WARN: Code duplicated, block: B:40:0x0134  */
        /* JADX WARN: Code duplicated, block: B:43:0x015c A[Catch: all -> 0x0166, TryCatch #1 {all -> 0x0166, blocks: (B:41:0x0140, B:43:0x015c, B:46:0x0169), top: B:60:0x0140 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x0169 A[Catch: all -> 0x0166, TRY_LEAVE, TryCatch #1 {all -> 0x0166, blocks: (B:41:0x0140, B:43:0x015c, B:46:0x0169), top: B:60:0x0140 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0192  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            long remaining;
            Ref$BooleanRef ref$BooleanRef;
            Buffer buffer;
            Segment segment;
            ByteBuffer byteBufferAsReadOnlyBuffer;
            CoroutineSingletons coroutineSingletons;
            ByteBuffer byteBuffer;
            Segment segment2;
            int iPosition;
            ObjectPool defaultDatagramByteBufferPool;
            DatagramSendChannel datagramSendChannel;
            Datagram datagram;
            Object objBorrow;
            Object obj2;
            ByteBuffer byteBuffer2;
            int iSend;
            SocketAddress address;
            int i = this.label;
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                remaining = ByteReadPacketKt.getRemaining(this.$element.getPacket());
                ref$BooleanRef = new Ref$BooleanRef();
                buffer = this.$element.getPacket().getBuffer();
                DatagramSendChannel datagramSendChannel2 = this.this$0;
                Datagram datagram2 = this.$element;
                if (buffer.exhausted()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
                    return null;
                }
                segment = buffer.head;
                segment.getClass();
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                int i3 = segment.limit;
                byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(bArr, i2, i3 - i2).slice().asReadOnlyBuffer();
                byteBufferAsReadOnlyBuffer.getClass();
                int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
                if (iRemaining >= remaining) {
                    int iSend2 = datagramSendChannel2.channel.send(byteBufferAsReadOnlyBuffer, JavaSocketAddressUtilsKt.toJavaAddress(datagram2.getAddress()));
                    if (iSend2 != 0) {
                        datagramSendChannel2.socket.interestOp(SelectInterest.WRITE, false);
                        byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.limit());
                    } else {
                        SocketAddress address2 = datagram2.getAddress();
                        this.L$0 = ref$BooleanRef;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = buffer;
                        this.L$5 = segment;
                        this.L$6 = null;
                        this.L$7 = byteBufferAsReadOnlyBuffer;
                        this.L$8 = byteBufferAsReadOnlyBuffer;
                        this.J$0 = remaining;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = i3;
                        this.I$3 = i2;
                        this.I$4 = 0;
                        this.I$5 = 0;
                        this.I$6 = iRemaining;
                        this.I$7 = iSend2;
                        this.label = 1;
                        coroutineSingletons = coroutineSingletons2;
                        if (datagramSendChannel2.sendSuspend(byteBufferAsReadOnlyBuffer, address2, this) != coroutineSingletons) {
                            byteBuffer = byteBufferAsReadOnlyBuffer;
                            segment2 = segment;
                        }
                    }
                    return coroutineSingletons;
                }
                ref$BooleanRef.element = true;
                coroutineSingletons = coroutineSingletons2;
                iPosition = byteBufferAsReadOnlyBuffer.position();
                if (iPosition != 0) {
                    if (iPosition >= 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                        return null;
                    }
                    if (iPosition <= segment.getSize()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                        return null;
                    }
                    buffer.skip(iPosition);
                }
                if (ref$BooleanRef.element) {
                    defaultDatagramByteBufferPool = PoolsKt.getDefaultDatagramByteBufferPool();
                    datagramSendChannel = this.this$0;
                    datagram = this.$element;
                    objBorrow = defaultDatagramByteBufferPool.borrow();
                    try {
                        byteBuffer2 = (ByteBuffer) objBorrow;
                        datagramSendChannel.writeMessageTo(datagram.getPacket(), byteBuffer2);
                        iSend = datagramSendChannel.channel.send(byteBuffer2, JavaSocketAddressUtilsKt.toJavaAddress(datagram.getAddress()));
                        if (iSend != 0) {
                            address = datagram.getAddress();
                            this.L$0 = null;
                            this.L$1 = defaultDatagramByteBufferPool;
                            this.L$2 = objBorrow;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.J$0 = remaining;
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.I$2 = iSend;
                            this.label = 2;
                            if (datagramSendChannel.sendSuspend(byteBuffer2, address, this) != coroutineSingletons) {
                                obj2 = objBorrow;
                                objBorrow = obj2;
                            }
                            return coroutineSingletons;
                        }
                        datagramSendChannel.socket.interestOp(SelectInterest.WRITE, false);
                        defaultDatagramByteBufferPool.recycle(objBorrow);
                    } catch (Throwable th) {
                        th = th;
                        obj2 = objBorrow;
                        defaultDatagramByteBufferPool.recycle(obj2);
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj2 = this.L$2;
                defaultDatagramByteBufferPool = (ObjectPool) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    objBorrow = obj2;
                    defaultDatagramByteBufferPool.recycle(objBorrow);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    defaultDatagramByteBufferPool.recycle(obj2);
                    throw th;
                }
            }
            remaining = this.J$0;
            byteBuffer = (ByteBuffer) this.L$8;
            ByteBuffer byteBuffer3 = (ByteBuffer) this.L$7;
            segment2 = (Segment) this.L$5;
            buffer = (Buffer) this.L$4;
            ref$BooleanRef = (Ref$BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            byteBufferAsReadOnlyBuffer = byteBuffer3;
            coroutineSingletons = coroutineSingletons2;
            byteBuffer.position(byteBuffer.limit());
            segment = segment2;
            iPosition = byteBufferAsReadOnlyBuffer.position();
            if (iPosition != 0) {
                if (iPosition >= 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                    return null;
                }
                if (iPosition <= segment.getSize()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                    return null;
                }
                buffer.skip(iPosition);
            }
            if (ref$BooleanRef.element) {
                defaultDatagramByteBufferPool = PoolsKt.getDefaultDatagramByteBufferPool();
                datagramSendChannel = this.this$0;
                datagram = this.$element;
                objBorrow = defaultDatagramByteBufferPool.borrow();
                byteBuffer2 = (ByteBuffer) objBorrow;
                datagramSendChannel.writeMessageTo(datagram.getPacket(), byteBuffer2);
                iSend = datagramSendChannel.channel.send(byteBuffer2, JavaSocketAddressUtilsKt.toJavaAddress(datagram.getAddress()));
                if (iSend != 0) {
                    address = datagram.getAddress();
                    this.L$0 = null;
                    this.L$1 = defaultDatagramByteBufferPool;
                    this.L$2 = objBorrow;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.L$7 = null;
                    this.L$8 = null;
                    this.J$0 = remaining;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.I$2 = iSend;
                    this.label = 2;
                    if (datagramSendChannel.sendSuspend(byteBuffer2, address, this) != coroutineSingletons) {
                        obj2 = objBorrow;
                        objBorrow = obj2;
                    }
                    return coroutineSingletons;
                }
                datagramSendChannel.socket.interestOp(SelectInterest.WRITE, false);
                defaultDatagramByteBufferPool.recycle(objBorrow);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", l = {95}, m = "sendSuspend", v = 1)
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
            return DatagramSendChannel.this.sendSuspend(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSendChannel(DatagramChannel datagramChannel, DatagramSocketImpl datagramSocketImpl) {
        super(datagramSocketImpl, null);
        datagramChannel.getClass();
        datagramSocketImpl.getClass();
        this.channel = datagramChannel;
        this.socket = datagramSocketImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0057 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0064  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:18:0x0058). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendSuspend(java.nio.ByteBuffer r6, io.ktor.network.sockets.SocketAddress r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.network.sockets.DatagramSendChannel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1 r0 = (io.ktor.network.sockets.DatagramSendChannel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1 r0 = new io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L30
            java.lang.Object r6 = r0.L$1
            io.ktor.network.sockets.SocketAddress r6 = (io.ktor.network.sockets.SocketAddress) r6
            java.lang.Object r7 = r0.L$0
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r7
            r7 = r6
            r6 = r4
            goto L58
        L30:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r5)
            r5 = 0
            return r5
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
        L3a:
            io.ktor.network.sockets.DatagramSocketImpl r8 = r5.socket
            io.ktor.network.selector.SelectInterest r1 = io.ktor.network.selector.SelectInterest.WRITE
            r8.interestOp(r1, r2)
            io.ktor.network.sockets.DatagramSocketImpl r8 = r5.socket
            io.ktor.network.selector.SelectorManager r8 = r8.getSelector()
            io.ktor.network.sockets.DatagramSocketImpl r3 = r5.socket
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r2
            java.lang.Object r8 = r8.select(r3, r1, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r1) goto L58
            return r1
        L58:
            java.nio.channels.DatagramChannel r8 = r5.channel
            java.net.SocketAddress r1 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toJavaAddress(r7)
            int r8 = r8.send(r6, r1)
            if (r8 == 0) goto L3a
            io.ktor.network.sockets.DatagramSocketImpl r5 = r5.socket
            io.ktor.network.selector.SelectInterest r6 = io.ktor.network.selector.SelectInterest.WRITE
            r7 = 0
            r5.interestOp(r6, r7)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSendChannel.sendSuspend(java.nio.ByteBuffer, io.ktor.network.sockets.SocketAddress, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeMessageTo(Source source, ByteBuffer byteBuffer) {
        ByteReadPacketExtensions_jvmKt.readFully(source, byteBuffer);
        byteBuffer.flip();
    }

    @Override // io.ktor.network.sockets.DatagramSendChannelBase
    public Object sendImpl(Datagram datagram, Continuation continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new AnonymousClass2(datagram, this, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.ktor.network.sockets.DatagramSendChannelBase
    public boolean trySendImpl(Datagram element) {
        boolean z;
        element.getClass();
        long remaining = ByteReadPacketKt.getRemaining(element.getPacket());
        Buffer buffer = element.getPacket().getBuffer();
        if (buffer.exhausted()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
            return false;
        }
        Segment segment = buffer.head;
        segment.getClass();
        byte[] bArr = segment.data;
        int i = segment.pos;
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(bArr, i, segment.limit - i).slice().asReadOnlyBuffer();
        byteBufferAsReadOnlyBuffer.getClass();
        if (byteBufferAsReadOnlyBuffer.remaining() < remaining) {
            z = true;
        } else {
            if (this.channel.send(byteBufferAsReadOnlyBuffer, JavaSocketAddressUtilsKt.toJavaAddress(element.getAddress())) == 0) {
                byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.limit());
            } else {
                byteBufferAsReadOnlyBuffer.position(0);
            }
            z = false;
        }
        int iPosition = byteBufferAsReadOnlyBuffer.position();
        if (iPosition != 0) {
            if (iPosition < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                return false;
            }
            if (iPosition > segment.getSize()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                return false;
            }
            buffer.skip(iPosition);
        }
        if (!z) {
            return true;
        }
        ObjectPool<ByteBuffer> defaultDatagramByteBufferPool = PoolsKt.getDefaultDatagramByteBufferPool();
        ByteBuffer byteBufferBorrow = defaultDatagramByteBufferPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            writeMessageTo(element.getPacket().peek(), byteBuffer);
            if (this.channel.send(byteBuffer, JavaSocketAddressUtilsKt.toJavaAddress(element.getAddress())) == 0) {
                ByteReadPacketKt.discard$default(element.getPacket(), 0L, 1, null);
            }
            return true;
        } finally {
            defaultDatagramByteBufferPool.recycle(byteBufferBorrow);
        }
    }
}
