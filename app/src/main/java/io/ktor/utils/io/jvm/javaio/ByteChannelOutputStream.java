package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ClosedWriteChannelException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.io.Sink;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u0012¨\u0006\u001e"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/ByteChannelOutputStream;", "Ljava/io/OutputStream;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/coroutines/Job;)V", "", "b", "", "write", "(I)V", "", "off", "len", "([BII)V", "flushIfNeeded", "()V", "flush", "throwIfClosed", "close", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/io/Sink;", "channelWriteBuffer", "Lkotlinx/io/Sink;", "getChannelWriteBuffer$annotations", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ByteChannelOutputStream extends OutputStream {
    private final ByteWriteChannel channel;
    private final Sink channelWriteBuffer;
    private final CoroutineContext coroutineContext;

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.ByteChannelOutputStream$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ByteChannelOutputStream$close$1", f = "Blocking.kt", l = {155}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ByteChannelOutputStream.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteWriteChannel byteWriteChannel = ByteChannelOutputStream.this.channel;
                this.label = 1;
                Object objFlushAndClose = byteWriteChannel.flushAndClose(this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFlushAndClose == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.ByteChannelOutputStream$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ByteChannelOutputStream$flush$1", f = "Blocking.kt", l = {144}, m = "invokeSuspend", v = 1)
    public static final class C03671 extends SuspendLambda implements Function2 {
        int label;

        public C03671(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ByteChannelOutputStream.this.new C03671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteWriteChannel byteWriteChannel = ByteChannelOutputStream.this.channel;
                this.label = 1;
                Object objFlush = byteWriteChannel.flush(this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFlush == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public ByteChannelOutputStream(ByteWriteChannel byteWriteChannel, Job job) {
        byteWriteChannel.getClass();
        this.channel = byteWriteChannel;
        this.coroutineContext = job == null ? EmptyCoroutineContext.INSTANCE : job;
        this.channelWriteBuffer = byteWriteChannel.getWriteBuffer();
    }

    private final void flushIfNeeded() throws Throwable {
        if (this.channel.getAutoFlush() || this.channelWriteBuffer.getBuffer().sizeMut >= 1048576) {
            flush();
        }
    }

    private final void throwIfClosed() throws Throwable {
        if (this.channel.isClosedForWrite()) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            throw new ClosedWriteChannelException(null, 1, null);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            AwaitKt.runBlockingK(this.coroutineContext, new AnonymousClass1(null));
        } catch (Throwable th) {
            this.channel.cancel(th);
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws Throwable {
        throwIfClosed();
        AwaitKt.runBlockingK(this.coroutineContext, new C03671(null));
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws Throwable {
        b.getClass();
        throwIfClosed();
        this.channelWriteBuffer.write(b, off, len + off);
        flushIfNeeded();
    }

    @Override // java.io.OutputStream
    public void write(int b) throws Throwable {
        throwIfClosed();
        this.channelWriteBuffer.writeByte((byte) b);
        flushIfNeeded();
    }

    public /* synthetic */ ByteChannelOutputStream(ByteWriteChannel byteWriteChannel, Job job, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteWriteChannel, (i & 2) != 0 ? null : job);
    }

    private static /* synthetic */ void getChannelWriteBuffer$annotations() {
    }
}
