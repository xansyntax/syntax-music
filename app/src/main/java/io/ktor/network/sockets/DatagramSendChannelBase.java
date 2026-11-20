package io.ktor.network.sockets;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\n2\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0002H$¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H¤@¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010\u001f\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00020\n2\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n0\u000fH\u0007¢\u0006\u0004\b!\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u00148VX\u0097\u0004¢\u0006\f\u0012\u0004\b+\u0010\u000e\u001a\u0004\b)\u0010*R&\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lio/ktor/network/sockets/DatagramSendChannelBase;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/network/sockets/Datagram;", "Lio/ktor/network/sockets/ASocket;", "socket", "Lio/ktor/network/sockets/SocketAddress;", "remote", "<init>", "(Lio/ktor/network/sockets/ASocket;Lio/ktor/network/sockets/SocketAddress;)V", "element", "", "checkRemoteAddress", "(Lio/ktor/network/sockets/Datagram;)V", "closeAndCheckHandler", "()V", "Lkotlin/Function1;", "", "handler", "failInvokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "", "trySendImpl", "(Lio/ktor/network/sockets/Datagram;)Z", "sendImpl", "(Lio/ktor/network/sockets/Datagram;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Lio/ktor/network/sockets/Datagram;)Ljava/lang/Object;", "trySend", "send", "cause", "close", "(Ljava/lang/Throwable;)Z", "invokeOnClose", "Lio/ktor/network/sockets/ASocket;", "Lio/ktor/network/sockets/SocketAddress;", "getRemote", "()Lio/ktor/network/sockets/SocketAddress;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "isClosedForSend", "()Z", "isClosedForSend$annotations", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DatagramSendChannelBase implements SendChannel {
    private volatile /* synthetic */ int closed;
    private volatile /* synthetic */ Object closedCause;
    private final Mutex lock;
    private volatile /* synthetic */ Object onCloseHandler;
    private final SocketAddress remote;
    private final ASocket socket;
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(DatagramSendChannelBase.class, Object.class, "onCloseHandler");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DatagramSendChannelBase.class, "closed");

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSendChannelBase$send$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSendChannelBase", f = "DatagramSendChannelBase.kt", l = {130, 57}, m = "send", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return DatagramSendChannelBase.this.send((Datagram) null, (Continuation) this);
        }
    }

    public DatagramSendChannelBase(ASocket aSocket, SocketAddress socketAddress) {
        aSocket.getClass();
        this.socket = aSocket;
        this.remote = socketAddress;
        this.lock = new MutexImpl();
        this.onCloseHandler = null;
        this.closed = 0;
        this.closedCause = null;
    }

    private final void checkRemoteAddress(Datagram element) {
        SocketAddress socketAddress = this.remote;
        if (socketAddress == null || Intrinsics.areEqual(element.getAddress(), socketAddress)) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("Datagram address ", element.getAddress(), " doesn't match the connected address ", socketAddress);
    }

    private final void closeAndCheckHandler() {
        while (true) {
            Function1 function1 = (Function1) this.onCloseHandler;
            if (function1 != DatagramSendChannelBaseKt.CLOSED_INVOKED) {
                if (function1 == null) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
                    Function1 function2 = DatagramSendChannelBaseKt.CLOSED;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, null, function2)) {
                        if (atomicReferenceFieldUpdater.get(this) != null) {
                        }
                    }
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = onCloseHandler$FU;
                Function1 function3 = DatagramSendChannelBaseKt.CLOSED_INVOKED;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, function1, function3)) {
                    if (atomicReferenceFieldUpdater2.get(this) != function1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                        return;
                    }
                }
                function1.invoke(this.closedCause);
                return;
            }
            return;
        }
    }

    private final void failInvokeOnClose(Function1 handler) {
        String str;
        if (handler == DatagramSendChannelBaseKt.CLOSED_INVOKED) {
            str = "Another handler was already registered and successfully invoked";
        } else {
            str = "Another handler was already registered: " + handler;
        }
        throw new IllegalStateException(str);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable cause) throws IOException {
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return false;
        }
        this.closedCause = cause;
        if (!SocketsKt.isClosed(this.socket)) {
            this.socket.close();
        }
        closeAndCheckHandler();
        return true;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 getOnSend() {
        throw new NotImplementedError("An operation is not implemented: [DatagramSendChannel] doesn't support [onSend] select clause");
    }

    public final SocketAddress getRemote() {
        return this.remote;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 handler) {
        handler.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, handler)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                if (this.onCloseHandler != DatagramSendChannelBaseKt.CLOSED) {
                    failInvokeOnClose((Function1) this.onCloseHandler);
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = onCloseHandler$FU;
                Function1 function1 = DatagramSendChannelBaseKt.CLOSED;
                Function1 function2 = DatagramSendChannelBaseKt.CLOSED_INVOKED;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, function1, function2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != function1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                        return;
                    }
                }
                handler.invoke(this.closedCause);
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.closed;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(Datagram datagram, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        int i;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.closed != 0) {
                    Throwable th = (Throwable) this.closedCause;
                    if (th == null) {
                        throw new ClosedSendChannelException("Channel was closed for send");
                    }
                    throw th;
                }
                checkRemoteAddress(datagram);
                mutex = this.lock;
                anonymousClass1.L$0 = datagram;
                anonymousClass1.L$1 = mutex;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                if (mutex.lock(anonymousClass1) != obj2) {
                    i = 0;
                }
                return obj2;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = (Mutex) anonymousClass1.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i4 = anonymousClass1.I$0;
            Mutex mutex3 = (Mutex) anonymousClass1.L$1;
            Datagram datagram2 = (Datagram) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            i = i4;
            datagram = datagram2;
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = mutex;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            if (sendImpl(datagram, anonymousClass1) != obj2) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return obj2;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    public abstract Object sendImpl(Datagram datagram, Continuation continuation);

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Object mo1712trySendJP2dKIU(Datagram element) {
        ChannelResult.Failed failed = ChannelResult.failed;
        element.getClass();
        if (this.closed != 0) {
            return new ChannelResult.Closed((Throwable) this.closedCause);
        }
        checkRemoteAddress(element);
        if (this.lock.tryLock()) {
            try {
                boolean zTrySendImpl = trySendImpl(element);
                this.lock.unlock(null);
                if (zTrySendImpl) {
                    return Unit.INSTANCE;
                }
                if (zTrySendImpl) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
            } catch (Throwable th) {
                this.lock.unlock(null);
                throw th;
            }
        }
        return failed;
    }

    public abstract boolean trySendImpl(Datagram element);

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated
    public /* bridge */ boolean offer(Datagram datagram) {
        return super.offer((Object) datagram);
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }
}
