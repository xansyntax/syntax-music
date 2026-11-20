package io.ktor.network.sockets;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\t*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0018\u001a\u00020\u0015*\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/ktor/network/sockets/ASocket;", "", "awaitClosed", "(Lio/ktor/network/sockets/ASocket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/network/sockets/AReadable;", "Lio/ktor/utils/io/ByteReadChannel;", "openReadChannel", "(Lio/ktor/network/sockets/AReadable;)Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/network/sockets/AWritable;", "", "autoFlush", "Lio/ktor/utils/io/ByteWriteChannel;", "openWriteChannel", "(Lio/ktor/network/sockets/AWritable;Z)Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/network/sockets/Socket;", "Lio/ktor/network/sockets/Connection;", "connection", "(Lio/ktor/network/sockets/Socket;)Lio/ktor/network/sockets/Connection;", "isClosed", "(Lio/ktor/network/sockets/ASocket;)Z", "Lio/ktor/network/sockets/ServerSocket;", "", "getPort", "(Lio/ktor/network/sockets/ServerSocket;)I", "port", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SocketsKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.SocketsKt$awaitClosed$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.SocketsKt", f = "Sockets.kt", l = {49}, m = "awaitClosed", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SocketsKt.awaitClosed(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitClosed(ASocket aSocket, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
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
            Job socketContext = aSocket.getSocketContext();
            anonymousClass1.L$0 = aSocket;
            anonymousClass1.label = 1;
            Object objJoin = socketContext.join(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objJoin == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            aSocket = (ASocket) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (aSocket.getSocketContext().isCancelled()) {
            throw aSocket.getSocketContext().getCancellationException();
        }
        return Unit.INSTANCE;
    }

    public static final Connection connection(Socket socket) {
        socket.getClass();
        return new Connection(socket, openReadChannel(socket), openWriteChannel$default(socket, false, 1, null));
    }

    public static final int getPort(ServerSocket serverSocket) {
        serverSocket.getClass();
        return SocketAddressKt.port(serverSocket.getLocalAddress());
    }

    public static final boolean isClosed(ASocket aSocket) {
        aSocket.getClass();
        return aSocket.getSocketContext().isCompleted();
    }

    public static final ByteReadChannel openReadChannel(AReadable aReadable) {
        aReadable.getClass();
        ByteChannel byteChannel = new ByteChannel(false);
        aReadable.attachForReading(byteChannel);
        return byteChannel;
    }

    public static final ByteWriteChannel openWriteChannel(AWritable aWritable, boolean z) {
        aWritable.getClass();
        ByteChannel byteChannel = new ByteChannel(z);
        aWritable.attachForWriting(byteChannel);
        return byteChannel;
    }

    public static /* synthetic */ ByteWriteChannel openWriteChannel$default(AWritable aWritable, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return openWriteChannel(aWritable, z);
    }
}
