package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.InputStream;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/ByteChannelInputStream;", "Ljava/io/InputStream;", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/Job;)V", "", "read", "()I", "", "b", "off", "len", "([BII)I", "", "blockingWait", "()V", "close", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ByteChannelInputStream extends InputStream implements InputStreamRetargetInterface {
    private final ByteReadChannel channel;
    private final CoroutineContext coroutineContext;

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.ByteChannelInputStream$blockingWait$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ByteChannelInputStream$blockingWait$1", f = "Blocking.kt", l = {76}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ByteChannelInputStream.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ByteReadChannel byteReadChannel = ByteChannelInputStream.this.channel;
            this.label = 1;
            Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, this, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objAwaitContent$default == coroutineSingletons ? coroutineSingletons : objAwaitContent$default;
        }
    }

    public ByteChannelInputStream(ByteReadChannel byteReadChannel, Job job) {
        byteReadChannel.getClass();
        this.channel = byteReadChannel;
        this.coroutineContext = job == null ? EmptyCoroutineContext.INSTANCE : job;
    }

    private final void blockingWait() throws Throwable {
        AwaitKt.runBlockingK(this.coroutineContext, new AnonymousClass1(null));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ByteReadChannelKt.cancel(this.channel);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws Throwable {
        b.getClass();
        if (this.channel.isClosedForRead()) {
            return -1;
        }
        if (this.channel.getReadBuffer().exhausted()) {
            blockingWait();
        }
        int atMostTo = this.channel.getReadBuffer().readAtMostTo(b, off, Math.min(ByteReadChannelOperationsKt.getAvailableForRead(this.channel), len) + off);
        if (atMostTo >= 0) {
            return atMostTo;
        }
        return this.channel.isClosedForRead() ? -1 : 0;
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public int read() throws Throwable {
        if (this.channel.isClosedForRead()) {
            return -1;
        }
        if (this.channel.getReadBuffer().exhausted()) {
            blockingWait();
        }
        if (this.channel.isClosedForRead()) {
            return -1;
        }
        return this.channel.getReadBuffer().readByte() & 255;
    }
}
