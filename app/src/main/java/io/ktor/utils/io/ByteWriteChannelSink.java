package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.Buffer;
import kotlinx.io.RawSink;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannelSink;", "Lkotlinx/io/RawSink;", "Lio/ktor/utils/io/ByteWriteChannel;", "origin", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "Lkotlinx/io/Buffer;", "source", "", "byteCount", "", "write", "(Lkotlinx/io/Buffer;J)V", "flush", "()V", "close", "Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ByteWriteChannelSink implements RawSink {
    private final ByteWriteChannel origin;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelSink$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelSink$close$1", f = "ByteWriteChannelSink.kt", l = {47}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ByteWriteChannelSink.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(ByteWriteChannelSink.this.origin);
                ByteWriteChannel byteWriteChannel = ByteWriteChannelSink.this.origin;
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

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelSink$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelSink$flush$1", f = "ByteWriteChannelSink.kt", l = {40}, m = "invokeSuspend", v = 1)
    public static final class C03651 extends SuspendLambda implements Function2 {
        int label;

        public C03651(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ByteWriteChannelSink.this.new C03651(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(ByteWriteChannelSink.this.origin);
                ByteWriteChannel byteWriteChannel = ByteWriteChannelSink.this.origin;
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

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelSink$write$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelSink$write$1", f = "ByteWriteChannelSink.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class C03661 extends SuspendLambda implements Function2 {
        int label;

        public C03661(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ByteWriteChannelSink.this.new C03661(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            if (this.label != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ByteWriteChannelSink.this.flush();
            return Unit.INSTANCE;
        }
    }

    public ByteWriteChannelSink(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        this.origin = byteWriteChannel;
    }

    @Override // kotlinx.io.RawSink, java.lang.AutoCloseable
    public void close() throws Throwable {
        AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new AnonymousClass1(null));
    }

    @Override // kotlinx.io.RawSink, java.io.Flushable
    public void flush() throws Throwable {
        AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new C03651(null));
    }

    @Override // kotlinx.io.RawSink
    public void write(Buffer source, long byteCount) throws Throwable {
        source.getClass();
        ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(this.origin);
        this.origin.getWriteBuffer().write(source, byteCount);
        ByteWriteChannel byteWriteChannel = this.origin;
        ByteChannel byteChannel = byteWriteChannel instanceof ByteChannel ? (ByteChannel) byteWriteChannel : null;
        if ((byteChannel == null || !byteChannel.getAutoFlush()) && BytePacketBuilderKt.getSize(this.origin.getWriteBuffer()) < 1048576) {
            return;
        }
        AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new C03661(null));
    }
}
