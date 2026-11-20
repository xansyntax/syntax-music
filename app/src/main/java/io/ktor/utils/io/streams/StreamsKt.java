package io.ktor.utils.io.streams;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.SinkByteWriteChannelKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.InputStreamSource;
import kotlinx.io.JvmCoreKt;
import kotlinx.io.OutputStreamSink;
import kotlinx.io.RealSource;
import kotlinx.io.Segment;
import kotlinx.io.Source;
import kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0;
import kotlinx.io.SourcesJvmKt$asInputStream$1;
import kotlinx.io.SourcesJvmKt$asInputStream$isClosed$1;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\n\u001a\u00020\t*\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\n\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0015\u001a\u00020\u0014*\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ljava/io/InputStream;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "asInput", "(Ljava/io/InputStream;)Lkotlinx/io/Source;", "inputStream", "(Lkotlinx/io/Source;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "packet", "", "writePacket", "(Ljava/io/OutputStream;Lkotlinx/io/Source;)V", "Lkotlin/Function1;", "Lkotlinx/io/Sink;", "block", "(Ljava/io/OutputStream;Lkotlin/jvm/functions/Function1;)V", "", "min", "readPacketAtLeast", "(Ljava/io/InputStream;I)Lkotlinx/io/Source;", "Lio/ktor/utils/io/ByteWriteChannel;", "asByteWriteChannel", "(Ljava/io/OutputStream;)Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StreamsKt {
    public static final ByteWriteChannel asByteWriteChannel(OutputStream outputStream) {
        outputStream.getClass();
        int i = JvmCoreKt.$r8$clinit;
        return SinkByteWriteChannelKt.asByteWriteChannel(new OutputStreamSink(outputStream));
    }

    public static final Source asInput(InputStream inputStream) {
        inputStream.getClass();
        int i = JvmCoreKt.$r8$clinit;
        return new RealSource(new InputStreamSource(inputStream));
    }

    public static final InputStream inputStream(Source source) {
        Source source2;
        Function0 sourcesJvmKt$$ExternalSyntheticLambda0;
        source.getClass();
        if (source instanceof RealSource) {
            source2 = source;
            sourcesJvmKt$$ExternalSyntheticLambda0 = new SourcesJvmKt$asInputStream$isClosed$1(source2, RealSource.class, "closed", "getClosed()Z", 0, (byte) 0);
        } else {
            source2 = source;
            if (!(source2 instanceof Buffer)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            sourcesJvmKt$$ExternalSyntheticLambda0 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 0);
        }
        return new SourcesJvmKt$asInputStream$1(sourcesJvmKt$$ExternalSyntheticLambda0, source2);
    }

    public static final Source readPacketAtLeast(InputStream inputStream, int i) throws IOException {
        inputStream.getClass();
        Buffer buffer = new Buffer();
        Segment segmentWritableSegment = buffer.writableSegment(i);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        int i3 = inputStream.read(bArr, i2, bArr.length - i2);
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 == i) {
            segmentWritableSegment.limit += i3;
            buffer.sizeMut += (long) i3;
            return buffer;
        }
        if (i3 < 0 || i3 > segmentWritableSegment.getRemainingCapacity()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i3, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
            return null;
        }
        if (i3 != 0) {
            segmentWritableSegment.limit += i3;
            buffer.sizeMut += (long) i3;
            return buffer;
        }
        if (Utf8Kt.isEmpty(segmentWritableSegment)) {
            buffer.recycleTail();
        }
        return buffer;
    }

    public static /* synthetic */ Source readPacketAtLeast$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return readPacketAtLeast(inputStream, i);
    }

    public static final void writePacket(OutputStream outputStream, Function1 function1) {
        outputStream.getClass();
        function1.getClass();
        Buffer buffer = new Buffer();
        function1.invoke(buffer);
        writePacket(outputStream, buffer);
    }

    public static final void writePacket(OutputStream outputStream, Source source) {
        outputStream.getClass();
        source.getClass();
        int i = JvmCoreKt.$r8$clinit;
        source.transferTo(new OutputStreamSink(outputStream));
    }
}
