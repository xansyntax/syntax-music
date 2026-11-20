package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.RealBufferedSink;
import okio.Segment;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocketWriter implements Closeable {
    public MessageDeflater messageDeflater;
    public final short minimumDeflateSize;
    public final boolean noContextTakeover;
    public final boolean perMessageDeflate;
    public final Random random;
    public final RealBufferedSink sink;
    public final Buffer sinkBuffer;
    public boolean writerClosed;
    public final Buffer messageBuffer = new Buffer();
    public final byte[] maskKey = new byte[4];
    public final Buffer.UnsafeCursor maskCursor = new Buffer.UnsafeCursor();

    /* JADX WARN: Type inference failed for: r2v1, types: [int, short] */
    public WebSocketWriter(RealBufferedSink realBufferedSink, Random random, boolean z, boolean z2, long j) {
        this.sink = realBufferedSink;
        this.random = random;
        this.perMessageDeflate = z;
        this.noContextTakeover = z2;
        this.minimumDeflateSize = (int) j;
        this.sinkBuffer = realBufferedSink.bufferField;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            _UtilCommonKt.closeQuietly(messageDeflater);
        }
        _UtilCommonKt.closeQuietly(this.sink);
    }

    public final void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
            return;
        }
        int size$okio = byteString.getSize$okio();
        if (size$okio > 125) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Payload size must be less than or equal to 125");
            return;
        }
        Buffer buffer = this.sinkBuffer;
        buffer.m1913writeByte(i | 128);
        buffer.m1913writeByte(size$okio | 128);
        byte[] bArr = this.maskKey;
        bArr.getClass();
        this.random.nextBytes(bArr);
        buffer.write(bArr, 0, bArr.length);
        if (size$okio > 0) {
            long j = buffer.size;
            buffer.write(byteString);
            Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
            unsafeCursor.getClass();
            buffer.readAndWriteUnsafe(unsafeCursor);
            unsafeCursor.seek(j);
            CharsKt.toggleMask(unsafeCursor, bArr);
            unsafeCursor.close();
        }
        this.sink.flush();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0139  */
    public final void writeMessageFrame(int i, ByteString byteString) throws IOException {
        byte[] bArr;
        if (this.writerClosed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
            return;
        }
        Buffer buffer = this.messageBuffer;
        buffer.write(byteString);
        int i2 = i | 128;
        if (this.perMessageDeflate && byteString.data.length >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater((byte) 0, this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            DeflaterSink deflaterSink = (DeflaterSink) messageDeflater.deflaterSink;
            Buffer buffer2 = messageDeflater.deflatedBytes;
            if (buffer2.size != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                return;
            }
            if (messageDeflater.noContextTakeover) {
                ((Deflater) messageDeflater.deflater).reset();
            }
            deflaterSink.write(buffer, buffer.size);
            deflaterSink.flush();
            ByteString byteString2 = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
            if (buffer2.rangeEquals(buffer2.size - ((long) byteString2.data.length), byteString2)) {
                long j = buffer2.size - 4;
                Buffer.UnsafeCursor unsafeCursor = new Buffer.UnsafeCursor();
                buffer2.readAndWriteUnsafe(unsafeCursor);
                try {
                    unsafeCursor.resizeBuffer(j);
                    unsafeCursor.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(unsafeCursor, th);
                        throw th2;
                    }
                }
            } else {
                buffer2.m1913writeByte(0);
            }
            buffer.write(buffer2, buffer2.size);
            i2 = i | 192;
        }
        long j2 = buffer.size;
        Buffer buffer3 = this.sinkBuffer;
        buffer3.m1913writeByte(i2);
        if (j2 > 125) {
            if (j2 <= 65535) {
                buffer3.m1913writeByte(254);
                buffer3.writeShort((int) j2);
            } else {
                buffer3.m1913writeByte(255);
                Segment segmentWritableSegment$okio = buffer3.writableSegment$okio(8);
                byte[] bArr2 = segmentWritableSegment$okio.data;
                int i3 = segmentWritableSegment$okio.limit;
                bArr2[i3] = (byte) ((j2 >>> 56) & 255);
                bArr2[i3 + 1] = (byte) ((j2 >>> 48) & 255);
                bArr2[i3 + 2] = (byte) ((j2 >>> 40) & 255);
                bArr2[i3 + 3] = (byte) ((j2 >>> 32) & 255);
                bArr2[i3 + 4] = (byte) ((j2 >>> 24) & 255);
                bArr2[i3 + 5] = (byte) ((j2 >>> 16) & 255);
                bArr2[i3 + 6] = (byte) ((j2 >>> 8) & 255);
                bArr2[i3 + 7] = (byte) (j2 & 255);
                segmentWritableSegment$okio.limit = i3 + 8;
                buffer3.size += 8;
            }
            bArr = this.maskKey;
            bArr.getClass();
            this.random.nextBytes(bArr);
            buffer3.write(bArr, 0, bArr.length);
            if (j2 > r7) {
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                unsafeCursor2.getClass();
                buffer.readAndWriteUnsafe(unsafeCursor2);
                unsafeCursor2.seek(0L);
                CharsKt.toggleMask(unsafeCursor2, bArr);
                unsafeCursor2.close();
            }
            buffer3.write(buffer, j2);
            this.sink.flush();
        }
        buffer3.m1913writeByte(((int) j2) | 128);
        bArr = this.maskKey;
        bArr.getClass();
        this.random.nextBytes(bArr);
        buffer3.write(bArr, 0, bArr.length);
        if (j2 > r7) {
            Buffer.UnsafeCursor unsafeCursor3 = this.maskCursor;
            unsafeCursor3.getClass();
            buffer.readAndWriteUnsafe(unsafeCursor3);
            unsafeCursor3.seek(0L);
            CharsKt.toggleMask(unsafeCursor3, bArr);
            unsafeCursor3.close();
        }
        buffer3.write(buffer, j2);
        this.sink.flush();
    }
}
