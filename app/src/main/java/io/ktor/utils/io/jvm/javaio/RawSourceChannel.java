package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.CloseToken;
import io.ktor.utils.io.CloseTokenKt;
import io.ktor.utils.io.ClosedByteChannelException;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00060\u0012j\u0002`\u0013*\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00102\u001a\u00020-8VX\u0097\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/RawSourceChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/io/RawSource;", "source", "Lkotlin/coroutines/CoroutineContext;", "parent", "<init>", "(Lkotlinx/io/RawSource;Lkotlin/coroutines/CoroutineContext;)V", "", "min", "", "awaitContent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "closeSource", "(Ljava/util/concurrent/CancellationException;)V", "asCancellationException", "(Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/io/RawSource;", "Lio/ktor/utils/io/CloseToken;", "closedToken", "Lio/ktor/utils/io/CloseToken;", "Lkotlinx/io/Buffer;", "buffer", "Lkotlinx/io/Buffer;", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/io/Source;", "getReadBuffer", "()Lkotlinx/io/Source;", "getReadBuffer$annotations", "()V", "readBuffer", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RawSourceChannel implements ByteReadChannel {
    private final Buffer buffer;
    private CloseToken closedToken;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private final RawSource source;

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.RawSourceChannel$awaitContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.RawSourceChannel", f = "Reading.kt", l = {80}, m = "awaitContent", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawSourceChannel.this.awaitContent(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.RawSourceChannel$awaitContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.RawSourceChannel$awaitContent$2", f = "Reading.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $min;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, Continuation continuation) {
            super(2, continuation);
            this.$min = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RawSourceChannel.this.new AnonymousClass2(this.$min, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            if (this.label != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            long atMostTo = 0;
            while (ByteReadPacketKt.getRemaining(RawSourceChannel.this.buffer) < this.$min && atMostTo >= 0) {
                try {
                    atMostTo = RawSourceChannel.this.source.readAtMostTo(RawSourceChannel.this.buffer, Long.MAX_VALUE);
                } catch (EOFException unused) {
                    atMostTo = -1;
                } catch (IOException e) {
                    ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(RawSourceChannel.this);
                    throw e;
                }
            }
            if (atMostTo == -1) {
                RawSourceChannel.this.source.close();
                ((JobImpl) RawSourceChannel.this.getJob()).complete$1();
                ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(RawSourceChannel.this);
                RawSourceChannel.this.closedToken = CloseTokenKt.getCLOSED();
            }
            return Unit.INSTANCE;
        }
    }

    public RawSourceChannel(RawSource rawSource, CoroutineContext coroutineContext) {
        rawSource.getClass();
        coroutineContext.getClass();
        this.source = rawSource;
        this.buffer = new Buffer();
        JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.job = jobImpl;
        this.coroutineContext = coroutineContext.plus(jobImpl).plus(new CoroutineName("RawSourceChannel"));
        jobImpl.invokeOnCompletion(true, true, new PingPongKt$$ExternalSyntheticLambda0((byte) 3, (Object) this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(RawSourceChannel rawSourceChannel, Throwable th) throws Exception {
        if (th != null) {
            rawSourceChannel.closeSource(rawSourceChannel.asCancellationException(th));
        }
        return Unit.INSTANCE;
    }

    private final CancellationException asCancellationException(Throwable th) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "Channel was cancelled";
        }
        return AwaitKt.CancellationException(message, th);
    }

    private final void closeSource(CancellationException cause) throws Exception {
        if (this.closedToken != null) {
            return;
        }
        this.closedToken = new CloseToken(cause);
        this.source.close();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(int i, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
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
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.closedToken != null) {
                ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(this);
                return Boolean.valueOf(ByteReadPacketKt.getRemaining(this.buffer) >= ((long) i));
            }
            CoroutineContext coroutineContext = this.coroutineContext;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(i, null);
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            Object objWithContext = AwaitKt.withContext(coroutineContext, anonymousClass2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boolean.valueOf(ByteReadPacketKt.getRemaining(this.buffer) >= ((long) i));
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) throws Exception {
        if (this.closedToken != null) {
            return;
        }
        CancellationException cancellationExceptionAsCancellationException = cause != null ? asCancellationException(cause) : null;
        ((JobSupport) this.job).cancel(cancellationExceptionAsCancellationException);
        closeSource(cancellationExceptionAsCancellationException);
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        Throwable th;
        CloseToken closeToken = this.closedToken;
        if (closeToken == null || (th = closeToken.origin) == null) {
            return null;
        }
        if (th instanceof CopyableThrowable) {
            return ((CopyableThrowable) closeToken.origin).createCopy();
        }
        return th instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken.origin).getMessage(), closeToken.origin) : new ClosedByteChannelException(closeToken.origin);
    }

    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final CompletableJob getJob() {
        return this.job;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Source getReadBuffer() {
        return this.buffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return this.closedToken != null && this.buffer.exhausted();
    }

    public static /* synthetic */ void getReadBuffer$annotations() {
    }
}
