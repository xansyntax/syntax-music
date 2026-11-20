package okio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.text.Charsets;
import kotlin.text.HexFormatKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    public long size;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        public Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.buffer == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("not attached to a buffer");
                return;
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final void resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("not attached to a buffer");
                return;
            }
            if (!this.readWrite) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("resizeBuffer() only permitted for read/write buffers");
                return;
            }
            long j2 = buffer.size;
            if (j <= j2) {
                if (j < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "newSize < 0: "));
                    return;
                }
                long j3 = j2 - j;
                while (j3 > 0) {
                    Segment segment = buffer.head;
                    segment.getClass();
                    Segment segment2 = segment.prev;
                    segment2.getClass();
                    int i = segment2.limit;
                    long j4 = i - segment2.pos;
                    if (j4 > j3) {
                        segment2.limit = i - ((int) j3);
                        break;
                    } else {
                        buffer.head = segment2.pop();
                        SegmentPool.recycle(segment2);
                        j3 -= j4;
                    }
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                int i2 = 1;
                boolean z = true;
                for (long j6 = 0; j5 > j6; j6 = 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i2);
                    int iMin = (int) Math.min(j5, 8192 - segmentWritableSegment$okio.limit);
                    int i3 = segmentWritableSegment$okio.limit + iMin;
                    segmentWritableSegment$okio.limit = i3;
                    j5 -= (long) iMin;
                    if (z) {
                        this.segment = segmentWritableSegment$okio;
                        this.offset = j2;
                        this.data = segmentWritableSegment$okio.data;
                        this.start = i3 - iMin;
                        this.end = i3;
                        z = false;
                    }
                    i2 = 1;
                }
            }
            buffer.size = j;
        }

        public final int seek(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("not attached to a buffer");
                return 0;
            }
            if (j >= -1) {
                long j2 = buffer.size;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment = buffer.head;
                    Segment segment2 = this.segment;
                    long j3 = 0;
                    if (segment2 != null) {
                        long j4 = this.offset - ((long) (this.start - segment2.pos));
                        if (j4 > j) {
                            segment2 = segment;
                            segment = segment2;
                            j2 = j4;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            segment2.getClass();
                            long j5 = ((long) (segment2.limit - segment2.pos)) + j3;
                            if (j < j5) {
                                break;
                            }
                            segment2 = segment2.next;
                            j3 = j5;
                        }
                    } else {
                        while (j2 > j) {
                            segment.getClass();
                            segment = segment.prev;
                            segment.getClass();
                            j2 -= (long) (segment.limit - segment.pos);
                        }
                        segment2 = segment;
                        j3 = j2;
                    }
                    if (this.readWrite) {
                        segment2.getClass();
                        if (segment2.shared) {
                            byte[] bArr = segment2.data;
                            Segment segment3 = new Segment(Arrays.copyOf(bArr, bArr.length), segment2.pos, segment2.limit, false, true);
                            if (buffer.head == segment2) {
                                buffer.head = segment3;
                            }
                            segment2.push(segment3);
                            Segment segment4 = segment3.prev;
                            segment4.getClass();
                            segment4.pop();
                            segment2 = segment3;
                        }
                    }
                    this.segment = segment2;
                    this.offset = j;
                    segment2.getClass();
                    this.data = segment2.data;
                    int i = segment2.pos + ((int) (j - j3));
                    this.start = i;
                    int i2 = segment2.limit;
                    this.end = i2;
                    return i2 - i;
                }
            }
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "offset=", " > size=");
            sbM.append(buffer.size);
            throw new ArrayIndexOutOfBoundsException(sbM.toString());
        }
    }

    public final void clear() throws EOFException {
        skip(this.size);
    }

    public final Object clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segment = this.head;
        segment.getClass();
        Segment segmentSharedCopy = segment.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = segmentSharedCopy.prev;
            segment3.getClass();
            segment2.getClass();
            segment3.push(segment2.sharedCopy());
        }
        buffer.size = this.size;
        return buffer;
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head;
        segment.getClass();
        Segment segment2 = segment.prev;
        segment2.getClass();
        int i = segment2.limit;
        return (i >= 8192 || !segment2.owner) ? j : j - ((long) (i - segment2.pos));
    }

    public final void copyTo(Buffer buffer, long j, long j2) {
        buffer.getClass();
        long j3 = j;
        HexFormatKt.checkOffsetAndCount(this.size, j3, j2);
        if (j2 == 0) {
            return;
        }
        buffer.size += j2;
        Segment segment = this.head;
        while (true) {
            segment.getClass();
            long j4 = segment.limit - segment.pos;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            segment = segment.next;
        }
        long j5 = j2;
        while (j5 > 0) {
            segment.getClass();
            Segment segmentSharedCopy = segment.sharedCopy();
            int i = segmentSharedCopy.pos + ((int) j3);
            segmentSharedCopy.pos = i;
            segmentSharedCopy.limit = Math.min(i + ((int) j5), segmentSharedCopy.limit);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer.head = segmentSharedCopy;
            } else {
                Segment segment3 = segment2.prev;
                segment3.getClass();
                segment3.push(segmentSharedCopy);
            }
            j5 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
            segment = segment.next;
            j3 = 0;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        long j = this.size;
        Buffer buffer = (Buffer) obj;
        if (j != buffer.size) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        Segment segment = this.head;
        segment.getClass();
        Segment segment2 = buffer.head;
        segment2.getClass();
        int i = segment.pos;
        int i2 = segment2.pos;
        long j2 = 0;
        while (j2 < this.size) {
            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                segment.getClass();
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                segment2.getClass();
                i2 = segment2.pos;
            }
            j2 += jMin;
        }
        return true;
    }

    public final boolean exhausted() {
        return this.size == 0;
    }

    public final byte getByte(long j) {
        HexFormatKt.checkOffsetAndCount(this.size, j, 1L);
        Segment segment = this.head;
        segment.getClass();
        long j2 = this.size;
        if (j2 - j < j) {
            while (j2 > j) {
                segment = segment.prev;
                segment.getClass();
                j2 -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return segment.data[(int) ((((long) i2) + j) - j3)];
            }
            segment = segment.next;
            segment.getClass();
            j3 = j4;
        }
    }

    public final int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            segment.getClass();
        } while (segment != this.head);
        return i;
    }

    public final long indexOfElement(ByteString byteString) {
        int i;
        int i2;
        byteString.getClass();
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j = this.size;
        long j2 = 0;
        if (j < 0) {
            while (j > 0) {
                segment = segment.prev;
                segment.getClass();
                j -= (long) (segment.limit - segment.pos);
            }
            if (byteString.getSize$okio() == 2) {
                byte bInternalGet$okio = byteString.internalGet$okio(0);
                byte bInternalGet$okio2 = byteString.internalGet$okio(1);
                while (j < this.size) {
                    byte[] bArr = segment.data;
                    i = (int) ((((long) segment.pos) + j2) - j);
                    int i3 = segment.limit;
                    while (true) {
                        if (i >= i3) {
                            j2 = ((long) (segment.limit - segment.pos)) + j;
                            segment = segment.next;
                            segment.getClass();
                            j = j2;
                        } else {
                            byte b = bArr[i];
                            if (b == bInternalGet$okio || b == bInternalGet$okio2) {
                                i2 = segment.pos;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            while (j < this.size) {
                byte[] bArr2 = segment.data;
                i = (int) ((((long) segment.pos) + j2) - j);
                int i4 = segment.limit;
                while (true) {
                    if (i < i4) {
                        byte b2 = bArr2[i];
                        int length = bArrInternalArray$okio.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                i++;
                            } else if (b2 == bArrInternalArray$okio[i5]) {
                                i2 = segment.pos;
                            } else {
                                i5++;
                            }
                        }
                    } else {
                        j2 = ((long) (segment.limit - segment.pos)) + j;
                        segment = segment.next;
                        segment.getClass();
                        j = j2;
                    }
                }
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j;
            if (j3 > 0) {
                break;
            }
            segment = segment.next;
            segment.getClass();
            j = j3;
        }
        if (byteString.getSize$okio() == 2) {
            byte bInternalGet$okio3 = byteString.internalGet$okio(0);
            byte bInternalGet$okio4 = byteString.internalGet$okio(1);
            while (j < this.size) {
                byte[] bArr3 = segment.data;
                i = (int) ((((long) segment.pos) + j2) - j);
                int i6 = segment.limit;
                while (true) {
                    if (i >= i6) {
                        j2 = ((long) (segment.limit - segment.pos)) + j;
                        segment = segment.next;
                        segment.getClass();
                        j = j2;
                    } else {
                        byte b3 = bArr3[i];
                        if (b3 == bInternalGet$okio3 || b3 == bInternalGet$okio4) {
                            i2 = segment.pos;
                        } else {
                            i++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
        while (j < this.size) {
            byte[] bArr4 = segment.data;
            i = (int) ((((long) segment.pos) + j2) - j);
            int i7 = segment.limit;
            while (true) {
                if (i < i7) {
                    byte b4 = bArr4[i];
                    int length2 = bArrInternalArray$okio2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            i++;
                        } else if (b4 == bArrInternalArray$okio2[i8]) {
                            i2 = segment.pos;
                        } else {
                            i8++;
                        }
                    }
                } else {
                    j2 = ((long) (segment.limit - segment.pos)) + j;
                    segment = segment.next;
                    segment.getClass();
                    j = j2;
                }
            }
        }
        return -1L;
        return ((long) (i - i2)) + j;
    }

    @Override // okio.BufferedSource
    public final InputStream inputStream() {
        return new AnonymousClass1();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // okio.BufferedSink
    public final OutputStream outputStream() {
        return new C03821(this, (byte) 0);
    }

    public final boolean rangeEquals(long j, ByteString byteString) {
        Segment segment;
        long j2;
        long j3;
        long j4 = j;
        byteString.getClass();
        int size$okio = byteString.getSize$okio();
        if (size$okio >= 0 && j4 >= 0) {
            long j5 = size$okio;
            if (j4 + j5 <= this.size && size$okio <= byteString.getSize$okio()) {
                if (size$okio == 0) {
                    return true;
                }
                byte[] bArr = okio.internal.Buffer.HEX_DIGIT_BYTES;
                long j6 = j4 + 1;
                HexFormatKt.checkOffsetAndCount(byteString.getSize$okio(), 0L, j5);
                if (size$okio <= 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("byteCount == 0");
                    return false;
                }
                if (j4 < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j4, "fromIndex < 0: "));
                    return false;
                }
                if (j4 > j6) {
                    StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j4, "fromIndex > toIndex: ", " > ");
                    sbM.append(j6);
                    throw new IllegalArgumentException(sbM.toString().toString());
                }
                long j7 = this.size;
                if (j6 > j7) {
                    j6 = j7;
                }
                if (j4 == j6 || (segment = this.head) == null) {
                    j3 = -1;
                    j2 = -1;
                } else if (j7 - j4 >= j4) {
                    j2 = -1;
                    long j8 = 0;
                    while (true) {
                        long j9 = j8 + ((long) (segment.limit - segment.pos));
                        if (j9 > j4) {
                            break;
                        }
                        segment = segment.next;
                        segment.getClass();
                        j8 = j9;
                    }
                    byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                    byte b = bArrInternalArray$okio[0];
                    long jMin = Math.min(j6, (this.size - j5) + 1);
                    loop4: while (true) {
                        if (j8 >= jMin) {
                            j3 = j2;
                            break;
                        }
                        byte[] bArr2 = segment.data;
                        int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + jMin) - j8);
                        for (int i = (int) ((((long) segment.pos) + j4) - j8); i < iMin; i++) {
                            if (bArr2[i] == b && okio.internal.Buffer.rangeEquals(segment, i + 1, bArrInternalArray$okio, 1, size$okio)) {
                                j3 = ((long) (i - segment.pos)) + j8;
                                break loop4;
                            }
                        }
                        j8 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        segment.getClass();
                        j4 = j8;
                    }
                } else {
                    while (j7 > j4) {
                        segment = segment.prev;
                        segment.getClass();
                        j7 -= (long) (segment.limit - segment.pos);
                    }
                    j2 = -1;
                    byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                    byte b2 = bArrInternalArray$okio2[0];
                    long jMin2 = Math.min(j6, (this.size - j5) + 1);
                    loop1: while (true) {
                        if (j7 >= jMin2) {
                            j3 = j2;
                            break;
                        }
                        byte[] bArr3 = segment.data;
                        int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + jMin2) - j7);
                        for (int i2 = (int) ((((long) segment.pos) + j4) - j7); i2 < iMin2; i2++) {
                            if (bArr3[i2] == b2 && okio.internal.Buffer.rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size$okio)) {
                                j3 = ((long) (i2 - segment.pos)) + j7;
                                break loop1;
                            }
                        }
                        j7 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        segment.getClass();
                        j4 = j7;
                    }
                }
                return j3 != j2;
            }
        }
        return false;
    }

    public final int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        HexFormatKt.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        ArraysKt.copyInto(i, i3, i3 + iMin, bArr2, bArr);
        int i4 = segment.pos + iMin;
        segment.pos = i4;
        this.size -= (long) iMin;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public final long readAll(Sink sink) {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final void readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        unsafeCursor.getClass();
        byte[] bArr = okio.internal.Buffer.HEX_DIGIT_BYTES;
        if (unsafeCursor.buffer != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("already attached to a buffer");
        } else {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
        }
    }

    public final byte readByte() throws EOFException {
        if (this.size == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        segment.getClass();
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size--;
        if (i3 != i2) {
            segment.pos = i3;
            return b;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return b;
    }

    public final byte[] readByteArray(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return null;
        }
        if (this.size < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final ByteString readByteString(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return null;
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(readByteArray(j));
        }
        ByteString byteStringSnapshot = snapshot((int) j);
        skip(j);
        return byteStringSnapshot;
    }

    public final long readDecimalLong() throws EOFException {
        long j;
        byte b;
        long j2 = 0;
        if (this.size == 0) {
            throw new EOFException();
        }
        int i = 0;
        boolean z = false;
        long j3 = 0;
        long j4 = -7;
        boolean z2 = false;
        loop0: while (true) {
            Segment segment = this.head;
            segment.getClass();
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            while (true) {
                if (i2 >= i3) {
                    j = j2;
                    break;
                }
                b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j3 < -922337203685477580L) {
                        break loop0;
                    }
                    j = j2;
                    if (j3 == -922337203685477580L && i4 < j4) {
                        break loop0;
                    }
                    j3 = (j3 * 10) + ((long) i4);
                } else {
                    j = j2;
                    if (b != 45 || i != 0) {
                        z2 = true;
                        break;
                    }
                    j4--;
                    z = true;
                }
                i2++;
                i++;
                j2 = j;
            }
            if (i2 == i3) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i2;
            }
            if (z2 || this.head == null) {
                long j5 = this.size - ((long) i);
                this.size = j5;
                if (i >= (z ? 2 : 1)) {
                    return z ? j3 : -j3;
                }
                if (j5 == j) {
                    throw new EOFException();
                }
                throw new NumberFormatException((z ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + HexFormatKt.toHexString(getByte(j)));
            }
            j2 = j;
        }
        Buffer buffer = new Buffer();
        buffer.m1914writeDecimalLong(j3);
        buffer.m1913writeByte((int) b);
        if (!z) {
            buffer.readByte();
        }
        throw new NumberFormatException("Number too large: ".concat(buffer.readUtf8()));
    }

    public final void readFully(byte[] bArr) throws EOFException {
        bArr.getClass();
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    public final long readHexadecimalUnsignedLong() throws EOFException {
        int i;
        if (this.size == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            Segment segment = this.head;
            segment.getClass();
            byte[] bArr = segment.data;
            int i3 = segment.pos;
            int i4 = segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        if (i2 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(HexFormatKt.toHexString(b)));
                        }
                        z = true;
                        break;
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    Buffer buffer = new Buffer();
                    buffer.writeHexadecimalUnsignedLong(j);
                    buffer.m1913writeByte((int) b);
                    throw new NumberFormatException("Number too large: ".concat(buffer.readUtf8()));
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            if (z) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i2;
        return j;
    }

    public final int readInt() throws EOFException {
        if (this.size < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        segment.getClass();
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.size -= 4;
        if (i5 != i2) {
            segment.pos = i5;
            return i6;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return i6;
    }

    public final long readLong() throws EOFException {
        if (this.size < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        segment.getClass();
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i3 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (((long) bArr[i3]) & 255);
        this.size -= 8;
        if (i4 != i2) {
            segment.pos = i4;
            return j2;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return j2;
    }

    public final short readShort() throws EOFException {
        if (this.size < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        segment.getClass();
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.size -= 2;
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    public final short readShortLe() throws EOFException {
        short s = readShort();
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public final String readString(long j, Charset charset) throws EOFException {
        charset.getClass();
        if (j < 0 || j > 2147483647L) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return null;
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        segment.getClass();
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment.data, i, i2, charset);
        int i3 = segment.pos + i2;
        segment.pos = i3;
        this.size -= j;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    public final String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public final boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public final int select(Options options) throws EOFException {
        options.getClass();
        int iSelectPrefix = okio.internal.Buffer.selectPrefix(this, options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        skip(options.byteStrings[iSelectPrefix].getSize$okio());
        return iSelectPrefix;
    }

    public final void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        HexFormatKt.checkOffsetAndCount(this.size, 0L, i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            segment.getClass();
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            segment2.getClass();
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final String toString() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.size).toString());
    }

    public final Segment writableSegment$okio(int i) {
        if (i < 1 || i > 8192) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("unexpected capacity");
            return null;
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        Segment segment2 = segment.prev;
        segment2.getClass();
        if (segment2.limit + i <= 8192 && segment2.owner) {
            return segment2;
        }
        Segment segmentTake2 = SegmentPool.take();
        segment2.push(segmentTake2);
        return segmentTake2;
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) {
        Segment segmentTake;
        buffer.getClass();
        if (buffer == this) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("source == this");
            return;
        }
        HexFormatKt.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            Segment segment = buffer.head;
            segment.getClass();
            int i = segment.limit;
            Segment segment2 = buffer.head;
            segment2.getClass();
            long j2 = i - segment2.pos;
            int i2 = 0;
            if (j < j2) {
                Segment segment3 = this.head;
                Segment segment4 = segment3 != null ? segment3.prev : null;
                if (segment4 != null && segment4.owner) {
                    if ((((long) segment4.limit) + j) - ((long) (segment4.shared ? 0 : segment4.pos)) <= 8192) {
                        Segment segment5 = buffer.head;
                        segment5.getClass();
                        segment5.writeTo(segment4, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                Segment segment6 = buffer.head;
                segment6.getClass();
                int i3 = (int) j;
                if (i3 <= 0 || i3 > segment6.limit - segment6.pos) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("byteCount out of range");
                    return;
                }
                if (i3 >= 1024) {
                    segmentTake = segment6.sharedCopy();
                } else {
                    segmentTake = SegmentPool.take();
                    byte[] bArr = segment6.data;
                    byte[] bArr2 = segmentTake.data;
                    int i4 = segment6.pos;
                    ArraysKt.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2);
                }
                segmentTake.limit = segmentTake.pos + i3;
                segment6.pos += i3;
                Segment segment7 = segment6.prev;
                segment7.getClass();
                segment7.push(segmentTake);
                buffer.head = segmentTake;
            }
            Segment segment8 = buffer.head;
            segment8.getClass();
            long j3 = segment8.limit - segment8.pos;
            buffer.head = segment8.pop();
            Segment segment9 = this.head;
            if (segment9 == null) {
                this.head = segment8;
                segment8.prev = segment8;
                segment8.next = segment8;
            } else {
                Segment segment10 = segment9.prev;
                segment10.getClass();
                segment10.push(segment8);
                Segment segment11 = segment8.prev;
                if (segment11 == segment8) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("cannot compact");
                    return;
                }
                segment11.getClass();
                if (segment11.owner) {
                    int i5 = segment8.limit - segment8.pos;
                    Segment segment12 = segment8.prev;
                    segment12.getClass();
                    int i6 = 8192 - segment12.limit;
                    Segment segment13 = segment8.prev;
                    segment13.getClass();
                    if (!segment13.shared) {
                        Segment segment14 = segment8.prev;
                        segment14.getClass();
                        i2 = segment14.pos;
                    }
                    if (i5 <= i6 + i2) {
                        Segment segment15 = segment8.prev;
                        segment15.getClass();
                        segment8.writeTo(segment15, i5);
                        segment8.pop();
                        SegmentPool.recycle(segment8);
                    }
                }
            }
            buffer.size -= j3;
            this.size += j3;
            j -= j3;
        }
    }

    public final long writeAll(Source source) {
        source.getClass();
        long j = 0;
        while (true) {
            long j2 = source.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    /* JADX INFO: renamed from: writeByte, reason: collision with other method in class */
    public final void m1913writeByte(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
    }

    /* JADX INFO: renamed from: writeDecimalLong, reason: collision with other method in class */
    public final void m1914writeDecimalLong(long j) {
        boolean z;
        if (j == 0) {
            m1913writeByte(48);
            return;
        }
        if (j < 0) {
            j = -j;
            if (j < 0) {
                m1915writeUtf8("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        byte[] bArr = okio.internal.Buffer.HEX_DIGIT_BYTES;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        int i = iNumberOfLeadingZeros + (j > okio.internal.Buffer.DigitCountToLargestValue[iNumberOfLeadingZeros] ? 1 : 0);
        if (z) {
            i++;
        }
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr2 = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit + i;
        while (j != 0) {
            i2--;
            bArr2[i2] = okio.internal.Buffer.HEX_DIGIT_BYTES[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr2[i2 - 1] = 45;
        }
        segmentWritableSegment$okio.limit += i;
        this.size += (long) i;
    }

    public final void writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            m1913writeByte(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = okio.internal.Buffer.HEX_DIGIT_BYTES[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        this.size += (long) i;
    }

    public final void writeInt(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 4;
        this.size += 4;
    }

    public final void writeShort(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 2;
        this.size += 2;
    }

    public final void writeUtf8(int i, int i2, String str) {
        char cCharAt;
        str.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "beginIndex < 0: "));
            return;
        }
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i2, i, "endIndex < beginIndex: ", " < "));
            return;
        }
        if (i2 > str.length()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m2m(i2, "endIndex > string.length: ", " > "), str.length());
            return;
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                Segment segmentWritableSegment$okio = writableSegment$okio(1);
                byte[] bArr = segmentWritableSegment$okio.data;
                int i3 = segmentWritableSegment$okio.limit - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = segmentWritableSegment$okio.limit;
                int i6 = (i3 + i) - i5;
                segmentWritableSegment$okio.limit = i5 + i6;
                this.size += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i7 = segmentWritableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment$okio2.limit = i7 + 2;
                    this.size += 2;
                } else if (55296 <= cCharAt2 && cCharAt2 < 56320) {
                    int i8 = i + 1;
                    char cCharAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (56320 > cCharAt3 || cCharAt3 >= 57344) {
                        m1913writeByte(63);
                        i = i8;
                    } else {
                        int i9 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                        byte[] bArr3 = segmentWritableSegment$okio3.data;
                        int i10 = segmentWritableSegment$okio3.limit;
                        bArr3[i10] = (byte) ((i9 >> 18) | 240);
                        bArr3[i10 + 1] = (byte) (((i9 >> 12) & 63) | 128);
                        bArr3[i10 + 2] = (byte) (((i9 >> 6) & 63) | 128);
                        bArr3[i10 + 3] = (byte) ((i9 & 63) | 128);
                        segmentWritableSegment$okio3.limit = i10 + 4;
                        this.size += 4;
                        i += 2;
                    }
                } else if (56320 > cCharAt2 || cCharAt2 >= 57344) {
                    Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                    byte[] bArr4 = segmentWritableSegment$okio4.data;
                    int i11 = segmentWritableSegment$okio4.limit;
                    bArr4[i11] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr4[i11 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr4[i11 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segmentWritableSegment$okio4.limit = i11 + 3;
                    this.size += 3;
                } else {
                    m1913writeByte(63);
                }
                i++;
            }
        }
    }

    public final void writeUtf8CodePoint(int i) {
        if (i < 128) {
            m1913writeByte(i);
            return;
        }
        if (i < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            this.size += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            m1913writeByte(63);
            return;
        }
        if (i < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            this.size += 3;
            return;
        }
        if (i > 1114111) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unexpected code point: 0x".concat(HexFormatKt.toHexString(i)));
            return;
        }
        Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
        byte[] bArr3 = segmentWritableSegment$okio3.data;
        int i4 = segmentWritableSegment$okio3.limit;
        bArr3[i4] = (byte) ((i >> 18) | 240);
        bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i4 + 3] = (byte) ((i & 63) | 128);
        segmentWritableSegment$okio3.limit = i4 + 4;
        this.size += 4;
    }

    /* JADX INFO: renamed from: okio.Buffer$outputStream$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C03821 extends OutputStream {
        public final /* synthetic */ byte $r8$classId;
        public final Object this$0;

        public C03821(FileOutputStream fileOutputStream) {
            this.$r8$classId = (byte) 1;
            this.this$0 = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            switch (this.$r8$classId) {
                case 0:
                case 1:
                    break;
                default:
                    ((RealBufferedSink) this.this$0).close();
                    break;
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() throws IOException {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    break;
                case 1:
                    ((FileOutputStream) obj).flush();
                    break;
                default:
                    RealBufferedSink realBufferedSink = (RealBufferedSink) obj;
                    if (!realBufferedSink.closed) {
                        realBufferedSink.flush();
                    }
                    break;
            }
        }

        public String toString() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    return ((Buffer) obj) + ".outputStream()";
                case 1:
                default:
                    return super.toString();
                case 2:
                    return ((RealBufferedSink) obj) + ".outputStream()";
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            bArr.getClass();
            switch (b) {
                case 0:
                    ((Buffer) obj).write(bArr, i, i2);
                    break;
                case 1:
                    ((FileOutputStream) obj).write(bArr, i, i2);
                    break;
                default:
                    RealBufferedSink realBufferedSink = (RealBufferedSink) obj;
                    if (!realBufferedSink.closed) {
                        realBufferedSink.bufferField.write(bArr, i, i2);
                        realBufferedSink.emitCompleteSegments();
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
                    }
                    break;
            }
        }

        public /* synthetic */ C03821(BufferedSink bufferedSink, byte b) {
            this.$r8$classId = b;
            this.this$0 = bufferedSink;
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    ((Buffer) obj).m1913writeByte(i);
                    break;
                case 1:
                    ((FileOutputStream) obj).write(i);
                    break;
                default:
                    RealBufferedSink realBufferedSink = (RealBufferedSink) obj;
                    if (!realBufferedSink.closed) {
                        realBufferedSink.bufferField.m1913writeByte((int) ((byte) i));
                        realBufferedSink.emitCompleteSegments();
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("closed");
                    }
                    break;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            switch (this.$r8$classId) {
                case 1:
                    bArr.getClass();
                    ((FileOutputStream) this.this$0).write(bArr);
                    break;
                default:
                    super.write(bArr);
                    break;
            }
        }

        private final void close$androidx$datastore$core$UncloseableOutputStream() {
        }

        private final void close$okio$Buffer$outputStream$1() {
        }

        private final void flush$okio$Buffer$outputStream$1() {
        }
    }

    /* JADX INFO: renamed from: okio.Buffer$inputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends InputStream implements InputStreamRetargetInterface {
        public AnonymousClass1() {
        }

        @Override // java.io.InputStream
        public final int available() {
            return (int) Math.min(Buffer.this.size, 2147483647L);
        }

        @Override // java.io.InputStream
        public final int read() {
            Buffer buffer = Buffer.this;
            if (buffer.size > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public final String toString() {
            return Buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
        public /* synthetic */ long transferTo(OutputStream outputStream) {
            return DesugarInputStream.transferTo(this, outputStream);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            return Buffer.this.read(bArr, i, i2);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        m1913writeByte(i);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i = segment.pos + iMin;
        segment.pos = i;
        this.size -= (long) iMin;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) {
        buffer.getClass();
        if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // okio.BufferedSource
    public final Buffer getBuffer() {
        return this;
    }

    @Override // okio.BufferedSource
    public final String readString(Charset charset) {
        charset.getClass();
        return readString(this.size, charset);
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long j) {
        m1914writeDecimalLong(j);
        return this;
    }

    public final void write(ByteString byteString) {
        byteString.getClass();
        byteString.write$okio(this, byteString.getSize$okio());
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i, 8192 - segmentWritableSegment$okio.limit);
            byteBuffer.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    public final void write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        long j = i2;
        HexFormatKt.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i3 - i, 8192 - segmentWritableSegment$okio.limit);
            int i4 = i + iMin;
            ArraysKt.copyInto(segmentWritableSegment$okio.limit, i, i4, bArr, segmentWritableSegment$okio.data);
            segmentWritableSegment$okio.limit += iMin;
            i = i4;
        }
        this.size += j;
    }

    /* JADX INFO: renamed from: writeUtf8, reason: collision with other method in class */
    public final void m1915writeUtf8(String str) {
        str.getClass();
        writeUtf8(0, str.length(), str);
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeUtf8(String str) {
        m1915writeUtf8(str);
        return this;
    }
}
