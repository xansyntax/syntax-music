package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ljava/nio/ByteBuffer;", "byteBuffer", "Lkotlinx/io/Source;", "ByteReadPacket", "(Ljava/nio/ByteBuffer;)Lkotlinx/io/Source;", "buffer", "", "readAvailable", "(Lkotlinx/io/Source;Ljava/nio/ByteBuffer;)I", "", "readFully", "(Lkotlinx/io/Source;Ljava/nio/ByteBuffer;)V", "Lkotlin/Function1;", "block", "read", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteReadPacketExtensions_jvmKt {
    public static final Source ByteReadPacket(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        Buffer buffer = new Buffer();
        Utf8Kt.write(buffer, byteBuffer);
        return buffer;
    }

    public static final void read(Source source, Function1 function1) {
        source.getClass();
        function1.getClass();
        Buffer buffer = source.getBuffer();
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

    public static final int readAvailable(Source source, ByteBuffer byteBuffer) {
        source.getClass();
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        Utf8Kt.readAtMostTo(source, byteBuffer);
        return iRemaining - byteBuffer.remaining();
    }

    public static final void readFully(Source source, ByteBuffer byteBuffer) {
        source.getClass();
        byteBuffer.getClass();
        while (!source.exhausted() && byteBuffer.hasRemaining()) {
            Utf8Kt.readAtMostTo(source, byteBuffer);
        }
    }
}
