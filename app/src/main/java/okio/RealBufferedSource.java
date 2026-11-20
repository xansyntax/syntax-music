package okio;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import j$.io.InputStreamRetargetInterface;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Charsets;
import kotlin.text.HexFormatKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        source.getClass();
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    public final boolean exhausted() {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return false;
        }
        Buffer buffer = this.bufferField;
        return buffer.exhausted() && this.source.read(buffer, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    public final Buffer getBuffer() {
        return this.bufferField;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ef A[SYNTHETIC] */
    public final long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7 = 0;
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return 0L;
        }
        if (0 > j2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j2, "fromIndex=0 toIndex="));
            return 0L;
        }
        long jMax = 0;
        while (jMax < j2) {
            Buffer buffer = this.bufferField;
            if (j7 > jMax || jMax > j2) {
                throw new IllegalArgumentException(("size=" + buffer.size + " fromIndex=" + jMax + " toIndex=" + j2).toString());
            }
            long j8 = buffer.size;
            long j9 = j2 > j8 ? j8 : j2;
            if (jMax == j9 || (segment = buffer.head) == null) {
                j3 = j7;
            } else {
                if (j8 - jMax >= jMax) {
                    j3 = j7;
                    j4 = -1;
                    while (true) {
                        long j10 = ((long) (segment.limit - segment.pos)) + j7;
                        if (j10 > jMax) {
                            break;
                        }
                        segment = segment.next;
                        segment.getClass();
                        j7 = j10;
                    }
                    long j11 = jMax;
                    while (true) {
                        if (j7 >= j9) {
                            j5 = j4;
                            break;
                        }
                        byte[] bArr = segment.data;
                        long j12 = j7;
                        int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j9) - j12);
                        for (int i = (int) ((((long) segment.pos) + j11) - j12); i < iMin; i++) {
                            if (bArr[i] == b) {
                                j5 = ((long) (i - segment.pos)) + j12;
                                break;
                            }
                        }
                        j11 = j12 + ((long) (segment.limit - segment.pos));
                        segment = segment.next;
                        segment.getClass();
                        j7 = j11;
                    }
                } else {
                    while (j8 > jMax) {
                        segment = segment.prev;
                        segment.getClass();
                        j8 -= (long) (segment.limit - segment.pos);
                        j7 = j7;
                    }
                    j3 = j7;
                    long j13 = jMax;
                    while (true) {
                        if (j8 < j9) {
                            j4 = -1;
                            byte[] bArr2 = segment.data;
                            long j14 = j13;
                            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j9) - j8);
                            int i2 = (int) ((((long) segment.pos) + j14) - j8);
                            while (true) {
                                if (i2 >= iMin2) {
                                    j13 = ((long) (segment.limit - segment.pos)) + j8;
                                    segment = segment.next;
                                    segment.getClass();
                                    j8 = j13;
                                } else if (bArr2[i2] == b) {
                                    j5 = ((long) (i2 - segment.pos)) + j8;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                }
                if (j5 != j4) {
                    return j5;
                }
                j6 = buffer.size;
                if (j6 >= j2 && this.source.read(buffer, 8192L) != j4) {
                    jMax = Math.max(jMax, j6);
                    j7 = j3;
                }
            }
            j4 = -1;
            j5 = j4;
            if (j5 != j4) {
                return j5;
            }
            j6 = buffer.size;
            return j6 >= j2 ? j4 : j4;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public final InputStream inputStream() {
        return new AnonymousClass1();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) {
        buffer.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return 0L;
        }
        Buffer buffer2 = this.bufferField;
        if (buffer2.size == 0) {
            if (j == 0) {
                return 0L;
            }
            if (this.source.read(buffer2, 8192L) == -1) {
                return -1L;
            }
        }
        return buffer2.read(buffer, Math.min(j, buffer2.size));
    }

    @Override // okio.BufferedSource
    public final long readAll(Sink sink) {
        Buffer buffer;
        long j = 0;
        while (true) {
            Source source = this.source;
            buffer = this.bufferField;
            if (source.read(buffer, 8192L) == -1) {
                break;
            }
            long jCompleteSegmentByteCount = buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(buffer, jCompleteSegmentByteCount);
            }
        }
        long j2 = buffer.size;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        sink.write(buffer, j2);
        return j3;
    }

    public final byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    public final ByteString readByteString(long j) {
        require(j);
        return this.bufferField.readByteString(j);
    }

    public final void readFully(Buffer buffer, long j) throws EOFException {
        Buffer buffer2 = this.bufferField;
        try {
            require(j);
            long j2 = buffer2.size;
            if (j2 >= j) {
                buffer.write(buffer2, j);
            } else {
                buffer.write(buffer2, j2);
                throw new EOFException();
            }
        } catch (EOFException e) {
            buffer.writeAll(buffer2);
            throw e;
        }
    }

    public final int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    public final int readIntLe() throws EOFException {
        require(4L);
        int i = this.bufferField.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public final long readLongLe() throws EOFException {
        require(8L);
        long j = this.bufferField.readLong();
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public final short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    public final short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public final String readString(Charset charset) {
        charset.getClass();
        Source source = this.source;
        Buffer buffer = this.bufferField;
        buffer.writeAll(source);
        return buffer.readString(buffer.size, charset);
    }

    public final String readUtf8(long j) {
        require(j);
        return this.bufferField.readString(j, Charsets.UTF_8);
    }

    public final String readUtf8LineStrict(long j) {
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "limit < 0: "));
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        Buffer buffer = this.bufferField;
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(buffer, jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && buffer.getByte(j2 - 1) == 13 && request(j2 + 1) && buffer.getByte(j2) == 10) {
            return okio.internal.Buffer.readUtf8Line(buffer, j2);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32L, buffer.size));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size, j) + " content=" + buffer2.readByteString(buffer2.size).hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public final boolean request(long j) {
        Buffer buffer;
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
            return false;
        }
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return false;
        }
        do {
            buffer = this.bufferField;
            if (buffer.size >= j) {
                return true;
            }
        } while (this.source.read(buffer, 8192L) != -1);
        return false;
    }

    public final void require(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final int select(Options options) throws EOFException {
        Buffer buffer;
        options.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return 0;
        }
        do {
            buffer = this.bufferField;
            int iSelectPrefix = okio.internal.Buffer.selectPrefix(buffer, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    break;
                }
                buffer.skip(options.byteStrings[iSelectPrefix].getSize$okio());
                return iSelectPrefix;
            }
        } while (this.source.read(buffer, 8192L) != -1);
        return -1;
    }

    public final void skip(long j) throws EOFException {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return;
        }
        while (j > 0) {
            Buffer buffer = this.bufferField;
            if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, buffer.size);
            buffer.skip(jMin);
            j -= jMin;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final String toString() {
        return "buffer(" + this.source + ')';
    }

    /* JADX INFO: renamed from: okio.RealBufferedSource$inputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends InputStream implements InputStreamRetargetInterface {
        public AnonymousClass1() {
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (!realBufferedSource.closed) {
                return (int) Math.min(realBufferedSource.bufferField.size, 2147483647L);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
            return 0;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            RealBufferedSource.this.close();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            bArr.getClass();
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            Buffer buffer = realBufferedSource.bufferField;
            if (realBufferedSource.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
                return 0;
            }
            HexFormatKt.checkOffsetAndCount(bArr.length, i, i2);
            if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                return -1;
            }
            return buffer.read(bArr, i, i2);
        }

        public final String toString() {
            return RealBufferedSource.this + ".inputStream()";
        }

        @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
        public final long transferTo(OutputStream outputStream) throws IOException {
            outputStream.getClass();
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            Buffer buffer = realBufferedSource.bufferField;
            if (realBufferedSource.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
                return 0L;
            }
            long j = 0;
            while (true) {
                if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                    return j;
                }
                long j2 = buffer.size;
                j += j2;
                HexFormatKt.checkOffsetAndCount(j2, 0L, j2);
                Segment segment = buffer.head;
                while (j2 > 0) {
                    segment.getClass();
                    int iMin = (int) Math.min(j2, segment.limit - segment.pos);
                    outputStream.write(segment.data, segment.pos, iMin);
                    int i = segment.pos + iMin;
                    segment.pos = i;
                    long j3 = iMin;
                    buffer.size -= j3;
                    j2 -= j3;
                    if (i == segment.limit) {
                        Segment segmentPop = segment.pop();
                        buffer.head = segmentPop;
                        SegmentPool.recycle(segment);
                        segment = segmentPop;
                    }
                }
            }
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            Buffer buffer = realBufferedSource.bufferField;
            if (realBufferedSource.closed) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
                return 0;
            }
            if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                return -1;
            }
            return buffer.readByte() & 255;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        Buffer buffer = this.bufferField;
        if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
            return -1;
        }
        return buffer.read(byteBuffer);
    }
}
