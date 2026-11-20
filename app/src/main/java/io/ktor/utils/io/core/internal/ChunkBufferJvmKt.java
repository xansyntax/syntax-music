package io.ktor.utils.io.core.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/io/Buffer;", "", "min", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "block", "writeDirect", "(Lkotlinx/io/Buffer;ILkotlin/jvm/functions/Function1;)V", "readDirect", "(Lkotlinx/io/Buffer;Lkotlin/jvm/functions/Function1;)V", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChunkBufferJvmKt {
    public static final void readDirect(Buffer buffer, Function1 function1) {
        buffer.getClass();
        function1.getClass();
        if (buffer.exhausted()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
            return;
        }
        Segment segment = buffer.head;
        segment.getClass();
        byte[] bArr = segment.data;
        int i = segment.pos;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, segment.limit - i);
        byteBufferWrap.getClass();
        function1.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - i;
        if (iPosition != 0) {
            if (iPosition < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
            } else if (iPosition <= segment.getSize()) {
                buffer.skip(iPosition);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
            }
        }
    }

    public static final void writeDirect(Buffer buffer, int i, Function1 function1) {
        buffer.getClass();
        function1.getClass();
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
            return;
        }
        if (iPosition < 0 || iPosition > segmentWritableSegment.getRemainingCapacity()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iPosition, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
            return;
        }
        if (iPosition != 0) {
            segmentWritableSegment.limit += iPosition;
            buffer.sizeMut += (long) iPosition;
        } else if (Utf8Kt.isEmpty(segmentWritableSegment)) {
            buffer.recycleTail();
        }
    }
}
