package io.ktor.network.sockets;

import io.ktor.network.selector.SelectableBase;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelUtilsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ChannelJob;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.WriterJob;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0013J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0016H ¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ%\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\b0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R#\u0010/\u001a\u00020,*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R%\u00102\u001a\u0004\u0018\u00010\u0016*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lio/ktor/network/sockets/SocketBase;", "Lio/ktor/network/sockets/ReadWriteSocket;", "Lio/ktor/network/selector/SelectableBase;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "parent", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "", "dispose", "()V", "close", "Lio/ktor/utils/io/ByteChannel;", "channel", "Lio/ktor/utils/io/WriterJob;", "attachForReading", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ReaderJob;", "attachForWriting", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/ReaderJob;", "attachForReadingImpl", "attachForWritingImpl", "", "actualClose$ktor_network", "()Ljava/lang/Throwable;", "actualClose", "checkChannels", "e1", "e2", "combine", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "channelCompletionHandler", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CompletableJob;", "socketContext", "Lkotlinx/coroutines/CompletableJob;", "getSocketContext", "()Lkotlinx/coroutines/CompletableJob;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/atomicfu/AtomicRef;", "Lio/ktor/utils/io/ChannelJob;", "", "getCompletedOrNotStarted", "(Lkotlinx/atomicfu/AtomicRef;)Z", "completedOrNotStarted", "getException", "(Lkotlinx/atomicfu/AtomicRef;)Ljava/lang/Throwable;", "exception", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SocketBase extends SelectableBase implements ReadWriteSocket, CoroutineScope {
    private volatile /* synthetic */ int actualCloseFlag;
    private final Function1 channelCompletionHandler;
    private volatile /* synthetic */ int closeFlag;
    volatile /* synthetic */ Object readerJob;
    private final CompletableJob socketContext;
    volatile /* synthetic */ Object writerJob;
    private static final /* synthetic */ AtomicIntegerFieldUpdater closeFlag$FU = AtomicIntegerFieldUpdater.newUpdater(SocketBase.class, "closeFlag");
    private static final /* synthetic */ AtomicIntegerFieldUpdater actualCloseFlag$FU = AtomicIntegerFieldUpdater.newUpdater(SocketBase.class, "actualCloseFlag");
    static final /* synthetic */ AtomicReferenceFieldUpdater readerJob$FU = AtomicReferenceFieldUpdater.newUpdater(SocketBase.class, Object.class, "readerJob");
    static final /* synthetic */ AtomicReferenceFieldUpdater writerJob$FU = AtomicReferenceFieldUpdater.newUpdater(SocketBase.class, Object.class, "writerJob");

    /* JADX INFO: renamed from: io.ktor.network.sockets.SocketBase$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.SocketBase$close$1", f = "SocketBase.kt", l = {42}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SocketBase.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReaderJob readerJob = (ReaderJob) SocketBase.this.readerJob;
                if (readerJob != null) {
                    this.label = 1;
                    if (readerJob.flushAndClose(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            WriterJob writerJob = (WriterJob) SocketBase.this.writerJob;
            if (writerJob != null) {
                ByteWriteChannelOperationsKt.cancel(writerJob);
            }
            SocketBase.this.checkChannels();
            return Unit.INSTANCE;
        }
    }

    public SocketBase(CoroutineContext coroutineContext) {
        coroutineContext.getClass();
        this.closeFlag = 0;
        this.actualCloseFlag = 0;
        this.readerJob = null;
        this.writerJob = null;
        this.channelCompletionHandler = new PingPongKt$$ExternalSyntheticLambda0((byte) 1, (Object) this);
        this.socketContext = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit channelCompletionHandler$lambda$0(SocketBase socketBase, Throwable th) {
        socketBase.checkChannels();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    public final void checkChannels() {
        Throwable cause;
        CancellationException cancellationException;
        CancellationException cancellationException2;
        if (this.closeFlag != 0) {
            ChannelJob channelJob = (ChannelJob) this.readerJob;
            if (channelJob == null || ByteWriteChannelOperationsKt.isCompleted(channelJob)) {
                ChannelJob channelJob2 = (ChannelJob) this.writerJob;
                if ((channelJob2 == null || ByteWriteChannelOperationsKt.isCompleted(channelJob2)) && actualCloseFlag$FU.compareAndSet(this, 0, 1)) {
                    ChannelJob channelJob3 = (ChannelJob) this.readerJob;
                    Throwable cause2 = null;
                    if (channelJob3 == null) {
                        cause = null;
                    } else {
                        if (!ByteWriteChannelOperationsKt.isCancelled(channelJob3)) {
                            channelJob3 = null;
                        }
                        if (channelJob3 == null || (cancellationException2 = ByteWriteChannelOperationsKt.getCancellationException(channelJob3)) == null) {
                            cause = null;
                        } else {
                            cause = cancellationException2.getCause();
                        }
                    }
                    ChannelJob channelJob4 = (ChannelJob) this.writerJob;
                    if (channelJob4 != null) {
                        if (!ByteWriteChannelOperationsKt.isCancelled(channelJob4)) {
                            channelJob4 = null;
                        }
                        if (channelJob4 != null && (cancellationException = ByteWriteChannelOperationsKt.getCancellationException(channelJob4)) != null) {
                            cause2 = cancellationException.getCause();
                        }
                    }
                    Throwable thCombine = combine(combine(cause, cause2), actualClose$ktor_network());
                    JobImpl jobImpl = (JobImpl) getSocketContext();
                    if (thCombine == null) {
                        jobImpl.complete$1();
                    } else {
                        jobImpl.completeExceptionally(thCombine);
                    }
                }
            }
        }
    }

    private final Throwable combine(Throwable e1, Throwable e2) {
        if (e1 == null) {
            return e2;
        }
        if (e2 == null || e1 == e2) {
            return e1;
        }
        ResultKt.addSuppressed(e1, e2);
        return e1;
    }

    public abstract Throwable actualClose$ktor_network();

    @Override // io.ktor.network.sockets.AReadable
    public final WriterJob attachForReading(ByteChannel channel) throws Throwable {
        channel.getClass();
        if (this.closeFlag != 0) {
            IOException iOException = new IOException("Socket closed");
            ByteWriteChannelOperationsKt.close(channel, iOException);
            throw iOException;
        }
        WriterJob writerJobAttachForReadingImpl = attachForReadingImpl(channel);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = writerJob$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, writerJobAttachForReadingImpl)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                IllegalStateException illegalStateException = new IllegalStateException("reading channel has already been set");
                ByteWriteChannelOperationsKt.cancel(writerJobAttachForReadingImpl);
                throw illegalStateException;
            }
        }
        if (this.closeFlag == 0) {
            ByteChannelUtilsKt.attachJob(channel, writerJobAttachForReadingImpl);
            ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobAttachForReadingImpl, this.channelCompletionHandler);
            return writerJobAttachForReadingImpl;
        }
        IOException iOException2 = new IOException("Socket closed");
        ByteWriteChannelOperationsKt.cancel(writerJobAttachForReadingImpl);
        ByteWriteChannelOperationsKt.close(channel, iOException2);
        throw iOException2;
    }

    public abstract WriterJob attachForReadingImpl(ByteChannel channel);

    @Override // io.ktor.network.sockets.AWritable
    public final ReaderJob attachForWriting(ByteChannel channel) throws Throwable {
        channel.getClass();
        if (this.closeFlag != 0) {
            IOException iOException = new IOException("Socket closed");
            ByteWriteChannelOperationsKt.close(channel, iOException);
            throw iOException;
        }
        ReaderJob readerJobAttachForWritingImpl = attachForWritingImpl(channel);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = readerJob$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, readerJobAttachForWritingImpl)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                IllegalStateException illegalStateException = new IllegalStateException("writing channel has already been set");
                ByteWriteChannelOperationsKt.cancel(readerJobAttachForWritingImpl);
                throw illegalStateException;
            }
        }
        if (this.closeFlag == 0) {
            ByteChannelUtilsKt.attachJob(channel, readerJobAttachForWritingImpl);
            ByteWriteChannelOperationsKt.invokeOnCompletion(readerJobAttachForWritingImpl, this.channelCompletionHandler);
            return readerJobAttachForWritingImpl;
        }
        IOException iOException2 = new IOException("Socket closed");
        ByteWriteChannelOperationsKt.cancel(readerJobAttachForWritingImpl);
        ByteWriteChannelOperationsKt.close(channel, iOException2);
        throw iOException2;
    }

    public abstract ReaderJob attachForWritingImpl(ByteChannel channel);

    @Override // io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (closeFlag$FU.compareAndSet(this, 0, 1)) {
            AwaitKt.launch$default(this, new CoroutineName("socket-close"), null, new AnonymousClass1(null), 2);
        }
    }

    @Override // io.ktor.network.selector.SelectableBase, io.ktor.network.selector.Selectable, kotlinx.coroutines.DisposableHandle
    public void dispose() {
        close();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return getSocketContext();
    }

    @Override // io.ktor.network.sockets.ASocket
    public CompletableJob getSocketContext() {
        return this.socketContext;
    }
}
