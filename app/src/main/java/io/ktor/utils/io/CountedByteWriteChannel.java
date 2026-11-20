package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.io.Sink;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188F¢\u0006\f\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010 \u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0012\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lio/ktor/utils/io/CountedByteWriteChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "delegate", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "", "initial", "I", "getInitial$annotations", "()V", "flushedCount", "", "getAutoFlush", "()Z", "autoFlush", "", "getTotalBytesWritten", "()J", "getTotalBytesWritten$annotations", "totalBytesWritten", "isClosedForWrite", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "writeBuffer", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CountedByteWriteChannel implements ByteWriteChannel {
    private final ByteWriteChannel delegate;
    private int flushedCount;
    private int initial;

    /* JADX INFO: renamed from: io.ktor.utils.io.CountedByteWriteChannel$flush$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.CountedByteWriteChannel", f = "CountedByteWriteChannel.kt", l = {35}, m = "flush", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CountedByteWriteChannel.this.flush(this);
        }
    }

    public CountedByteWriteChannel(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        this.delegate = byteWriteChannel;
        this.initial = BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        this.delegate.cancel(cause);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object flush(Continuation continuation) {
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
            this.flushedCount = BytePacketBuilderKt.getSize(getWriteBuffer()) + this.flushedCount;
            ByteWriteChannel byteWriteChannel = this.delegate;
            anonymousClass1.label = 1;
            Object objFlush = byteWriteChannel.flush(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFlush == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.initial = BytePacketBuilderKt.getSize(getWriteBuffer());
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object flushAndClose(Continuation continuation) {
        Object objFlushAndClose = this.delegate.flushAndClose(continuation);
        return objFlushAndClose == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushAndClose : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.delegate.getAutoFlush();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        return this.delegate.getClosedCause();
    }

    public final long getTotalBytesWritten() {
        return (BytePacketBuilderKt.getSize(getWriteBuffer()) + this.flushedCount) - this.initial;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Sink getWriteBuffer() {
        return this.delegate.getWriteBuffer();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this.delegate.isClosedForWrite();
    }

    private static /* synthetic */ void getInitial$annotations() {
    }

    public static /* synthetic */ void getTotalBytesWritten$annotations() {
    }

    public static /* synthetic */ void getWriteBuffer$annotations() {
    }
}
