package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "", "count", "Ljava/nio/ByteBuffer;", "request", "(I)Ljava/nio/ByteBuffer;", "", "tryAwait", "(I)V", "rc", "written", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "getChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "kotlin.jvm.PlatformType", "byteBuffer", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WriteSuspendSession {
    private final ByteBuffer byteBuffer;
    private final ByteWriteChannel channel;

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSession$written$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSession", f = "WriteSuspendSession.kt", l = {30, 32}, m = "written", v = 1)
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
            return WriteSuspendSession.this.written(0, this);
        }
    }

    public WriteSuspendSession(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        this.channel = byteWriteChannel;
        this.byteBuffer = ByteBuffer.allocate(8192);
    }

    public final ByteWriteChannel getChannel() {
        return this.channel;
    }

    public final ByteBuffer request(int count) {
        return this.byteBuffer;
    }

    public final void tryAwait(int count) {
        Sink writeBuffer = this.channel.getWriteBuffer();
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.getClass();
        OutputArraysJVMKt.writeByteBuffer(writeBuffer, byteBuffer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (r5.flush(r0) == r4) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object written(int i, Continuation continuation) {
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
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 != 0) {
            if (i3 == 1) {
                i = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.byteBuffer.flip();
        ByteWriteChannel byteWriteChannel = this.channel;
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.getClass();
        anonymousClass1.I$0 = i;
        anonymousClass1.label = 1;
        if (ByteWriteChannelOperations_jvmKt.writeFully(byteWriteChannel, byteBuffer, anonymousClass1) != coroutineSingletons) {
        }
        return coroutineSingletons;
        this.byteBuffer.clear();
        ByteWriteChannel byteWriteChannel2 = this.channel;
        anonymousClass1.I$0 = i;
        anonymousClass1.label = 2;
    }
}
