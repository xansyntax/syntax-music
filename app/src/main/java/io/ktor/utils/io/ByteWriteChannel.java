package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.io.Sink;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "", "getAutoFlush", "()Z", "autoFlush", "isClosedForWrite", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "()V", "writeBuffer", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ByteWriteChannel {
    void cancel(Throwable cause);

    Object flush(Continuation continuation);

    Object flushAndClose(Continuation continuation);

    default boolean getAutoFlush() {
        return false;
    }

    Throwable getClosedCause();

    Sink getWriteBuffer();

    boolean isClosedForWrite();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getAutoFlush(ByteWriteChannel byteWriteChannel) {
            return ByteWriteChannel.super.getAutoFlush();
        }

        public static /* synthetic */ void getWriteBuffer$annotations() {
        }
    }
}
