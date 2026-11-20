package io.ktor.utils.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\u0005\u001a2\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\tH\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a/\u0010\r\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/nio/ByteBuffer;", "value", "", "writeByteBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "", "min", "Lkotlin/Function1;", "block", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeAvailable", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function1;)I", "buffer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteWriteChannelOperations_jvmKt {
    public static final Object write(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation) {
        Buffer buffer = byteWriteChannel.getWriteBuffer().getBuffer();
        Segment segmentWritableSegment = buffer.writableSegment(i);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i2, bArr.length - i2);
        byteBufferWrap.getClass();
        function1.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - i2;
        if (iPosition == i) {
            segmentWritableSegment.limit += iPosition;
            buffer.sizeMut += (long) iPosition;
        } else {
            if (iPosition < 0 || iPosition > segmentWritableSegment.getRemainingCapacity()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iPosition, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
                return null;
            }
            if (iPosition != 0) {
                segmentWritableSegment.limit += iPosition;
                buffer.sizeMut += (long) iPosition;
            } else if (Utf8Kt.isEmpty(segmentWritableSegment)) {
                buffer.recycleTail();
            }
        }
        Object objFlush = byteWriteChannel.flush(continuation);
        return objFlush == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlush : Unit.INSTANCE;
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return write(byteWriteChannel, i, function1, continuation);
    }

    public static final int writeAvailable(ByteWriteChannel byteWriteChannel, int i, Function1 function1) {
        byteWriteChannel.getClass();
        function1.getClass();
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("min should be positive");
            return 0;
        }
        if (i > 1048576) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Min(", ") shouldn't be greater than 1048576"));
            return 0;
        }
        if (byteWriteChannel.isClosedForWrite()) {
            return -1;
        }
        Buffer buffer = byteWriteChannel.getWriteBuffer().getBuffer();
        Segment segmentWritableSegment = buffer.writableSegment(i);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i2, bArr.length - i2);
        byteBufferWrap.getClass();
        function1.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - i2;
        int iPosition2 = byteBufferWrap.position() - i2;
        if (iPosition2 == i) {
            segmentWritableSegment.limit += iPosition2;
            buffer.sizeMut += (long) iPosition2;
            return iPosition;
        }
        if (iPosition2 < 0 || iPosition2 > segmentWritableSegment.getRemainingCapacity()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iPosition2, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
            return 0;
        }
        if (iPosition2 != 0) {
            segmentWritableSegment.limit += iPosition2;
            buffer.sizeMut += (long) iPosition2;
            return iPosition;
        }
        if (Utf8Kt.isEmpty(segmentWritableSegment)) {
            buffer.recycleTail();
        }
        return iPosition;
    }

    public static /* synthetic */ int writeAvailable$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return writeAvailable(byteWriteChannel, i, function1);
    }

    public static final Object writeByteBuffer(ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer, Continuation continuation) {
        OutputArraysJVMKt.writeByteBuffer(byteWriteChannel.getWriteBuffer(), byteBuffer);
        Object objFlush = byteWriteChannel.flush(continuation);
        return objFlush == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlush : Unit.INSTANCE;
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer, Continuation continuation) {
        OutputArraysJVMKt.writeByteBuffer(byteWriteChannel.getWriteBuffer(), byteBuffer);
        Object objFlush = byteWriteChannel.flush(continuation);
        return objFlush == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlush : Unit.INSTANCE;
    }

    public static final void writeAvailable(ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer) {
        byteWriteChannel.getClass();
        byteBuffer.getClass();
        Utf8Kt.write(byteWriteChannel.getWriteBuffer(), byteBuffer);
    }
}
