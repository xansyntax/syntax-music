package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "close", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "Lio/ktor/utils/io/ByteChannel;", "cancel", "(Lio/ktor/utils/io/ByteChannel;)V", "flushIfNeeded", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteWriteChannelKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelKt$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        public AnonymousClass1(Object obj) {
            super(1, obj, ByteWriteChannel.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((ByteWriteChannel) this.receiver).flushAndClose(continuation);
        }
    }

    public static final void cancel(ByteChannel byteChannel) {
        byteChannel.getClass();
        byteChannel.cancel(new IOException("Channel was cancelled"));
    }

    @Deprecated
    public static final void close(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        ByteWriteChannelOperationsKt.fireAndForget(new AnonymousClass1(byteWriteChannel));
    }

    public static final Object flushIfNeeded(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object objFlush;
        ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(byteWriteChannel);
        boolean autoFlush = byteWriteChannel.getAutoFlush();
        Unit unit = Unit.INSTANCE;
        return ((autoFlush || BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer()) >= 1048576) && (objFlush = byteWriteChannel.flush(continuation)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objFlush : unit;
    }

    @Deprecated
    public static final void cancel(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        byteWriteChannel.cancel(new IOException("Channel was cancelled"));
    }
}
