package kotlinx.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import kotlin.collections.ArraysKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Buffer implements Source, Sink {
    public Segment head;
    public long sizeMut;
    public Segment tail;

    public final long completeSegmentByteCount$kotlinx_io_core() {
        long j = this.sizeMut;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.tail;
        segment.getClass();
        int i = segment.limit;
        return (i >= 8192 || !segment.owner) ? j : j - ((long) (i - segment.pos));
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (this.sizeMut == 0) {
            return buffer;
        }
        Segment segment = this.head;
        segment.getClass();
        Segment segmentSharedCopy$kotlinx_io_core = segment.sharedCopy$kotlinx_io_core();
        buffer.head = segmentSharedCopy$kotlinx_io_core;
        buffer.tail = segmentSharedCopy$kotlinx_io_core;
        for (Segment segment2 = segment.next; segment2 != null; segment2 = segment2.next) {
            Segment segment3 = buffer.tail;
            segment3.getClass();
            Segment segmentSharedCopy$kotlinx_io_core2 = segment2.sharedCopy$kotlinx_io_core();
            segment3.push$kotlinx_io_core(segmentSharedCopy$kotlinx_io_core2);
            buffer.tail = segmentSharedCopy$kotlinx_io_core2;
        }
        buffer.sizeMut = this.sizeMut;
        return buffer;
    }

    @Override // kotlinx.io.Source
    public final boolean exhausted() {
        return this.sizeMut == 0;
    }

    public final byte get(long j) {
        long j2 = 0;
        if (j < 0 || j >= this.sizeMut) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(j, "position (", ") is not within the range [0..size("), this.sizeMut, "))"));
            return (byte) 0;
        }
        Segment segment = this.head;
        if (j == 0) {
            segment.getClass();
            return segment.getUnchecked$kotlinx_io_core(0);
        }
        segment.getClass();
        long j3 = this.sizeMut;
        if (j3 - j < j) {
            Segment segment2 = this.tail;
            while (segment2 != null && j3 > j) {
                j3 -= (long) (segment2.limit - segment2.pos);
                if (j3 <= j) {
                    break;
                }
                segment2 = segment2.prev;
            }
            segment2.getClass();
            return segment2.getUnchecked$kotlinx_io_core((int) (j - j3));
        }
        Segment segment3 = this.head;
        while (segment3 != null) {
            long j4 = ((long) (segment3.limit - segment3.pos)) + j2;
            if (j4 > j) {
                break;
            }
            segment3 = segment3.next;
            j2 = j4;
        }
        segment3.getClass();
        return segment3.getUnchecked$kotlinx_io_core((int) (j - j2));
    }

    @Override // kotlinx.io.Source
    public final RealSource peek() {
        return new RealSource(new PeekSource(this));
    }

    @Override // kotlinx.io.Source
    public final int readAtMostTo(byte[] bArr, int i, int i2) {
        bArr.getClass();
        Utf8Kt.checkBounds(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2 - i, segment.getSize());
        int i3 = (i + iMin) - i;
        byte[] bArr2 = segment.data;
        int i4 = segment.pos;
        ArraysKt.copyInto(i, i4, i4 + i3, bArr2, bArr);
        segment.pos += i3;
        this.sizeMut -= (long) iMin;
        if (Utf8Kt.isEmpty(segment)) {
            recycleHead$kotlinx_io_core();
        }
        return iMin;
    }

    @Override // kotlinx.io.Source
    public final byte readByte() throws EOFException {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(1L);
            throw null;
        }
        int size = segment.getSize();
        if (size == 0) {
            recycleHead$kotlinx_io_core();
            return readByte();
        }
        byte[] bArr = segment.data;
        int i = segment.pos;
        segment.pos = i + 1;
        byte b = bArr[i];
        this.sizeMut--;
        if (size == 1) {
            recycleHead$kotlinx_io_core();
        }
        return b;
    }

    @Override // kotlinx.io.Source
    public final int readInt() throws EOFException {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(4L);
            throw null;
        }
        int size = segment.getSize();
        if (size < 4) {
            require(4L);
            if (size == 0) {
                recycleHead$kotlinx_io_core();
                return readInt();
            }
            return (readShort() & 65535) | (readShort() << 16);
        }
        byte[] bArr = segment.data;
        int i = segment.pos;
        int i2 = (bArr[i + 3] & 255) | ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        segment.pos = i + 4;
        this.sizeMut -= 4;
        if (size == 4) {
            recycleHead$kotlinx_io_core();
        }
        return i2;
    }

    @Override // kotlinx.io.Source
    public final long readLong() throws EOFException {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(8L);
            throw null;
        }
        int size = segment.getSize();
        if (size < 8) {
            require(8L);
            if (size != 0) {
                return (((long) readInt()) << 32) | (((long) readInt()) & 4294967295L);
            }
            recycleHead$kotlinx_io_core();
            return readLong();
        }
        byte[] bArr = segment.data;
        int i = segment.pos;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8) | (((long) bArr[i + 7]) & 255);
        segment.pos = i + 8;
        this.sizeMut -= 8;
        if (size == 8) {
            recycleHead$kotlinx_io_core();
        }
        return j;
    }

    @Override // kotlinx.io.Source
    public final short readShort() throws EOFException {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(2L);
            throw null;
        }
        int size = segment.getSize();
        if (size < 2) {
            require(2L);
            if (size == 0) {
                recycleHead$kotlinx_io_core();
                return readShort();
            }
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i = segment.pos;
        short s = (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
        segment.pos = i + 2;
        this.sizeMut -= 2;
        if (size == 2) {
            recycleHead$kotlinx_io_core();
        }
        return s;
    }

    @Override // kotlinx.io.Source
    public final void readTo(RawSink rawSink, long j) throws EOFException {
        rawSink.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
            return;
        }
        long j2 = this.sizeMut;
        if (j2 >= j) {
            rawSink.write(this, j);
        } else {
            rawSink.write(this, j2);
            throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(j, "Buffer exhausted before writing ", " bytes. Only "), this.sizeMut, " bytes were written."));
        }
    }

    public final void recycleHead$kotlinx_io_core() {
        Segment segment = this.head;
        segment.getClass();
        Segment segment2 = segment.next;
        this.head = segment2;
        if (segment2 == null) {
            this.tail = null;
        } else {
            segment2.prev = null;
        }
        segment.next = null;
        SegmentPool.recycle(segment);
    }

    public final /* synthetic */ void recycleTail() {
        Segment segment = this.tail;
        segment.getClass();
        Segment segment2 = segment.prev;
        this.tail = segment2;
        if (segment2 == null) {
            this.head = null;
        } else {
            segment2.next = null;
        }
        segment.prev = null;
        SegmentPool.recycle(segment);
    }

    @Override // kotlinx.io.Source
    public final boolean request(long j) {
        if (j >= 0) {
            return this.sizeMut >= j;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount: ", " < 0"));
        return false;
    }

    @Override // kotlinx.io.Source
    public final void require(long j) {
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount: "));
            return;
        }
        if (this.sizeMut >= j) {
            return;
        }
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + this.sizeMut + ", required: " + j + ')');
    }

    @Override // kotlinx.io.Source
    public final void skip(long j) {
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
            return;
        }
        long j2 = j;
        while (j2 > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(j, "Buffer exhausted before skipping ", " bytes."));
            }
            int iMin = (int) Math.min(j2, segment.limit - segment.pos);
            long j3 = iMin;
            this.sizeMut -= j3;
            j2 -= j3;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                recycleHead$kotlinx_io_core();
            }
        }
    }

    public final void throwEof(long j) throws EOFException {
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + this.sizeMut + ", required: " + j + ')');
    }

    public final String toString() {
        long j = this.sizeMut;
        if (j == 0) {
            return "Buffer(size=0)";
        }
        int iMin = (int) Math.min(64L, j);
        StringBuilder sb = new StringBuilder((iMin * 2) + (this.sizeMut > 64 ? 1 : 0));
        int i = 0;
        for (Segment segment = this.head; segment != null; segment = segment.next) {
            int i2 = 0;
            while (i < iMin && i2 < segment.getSize()) {
                int i3 = i2 + 1;
                byte unchecked$kotlinx_io_core = segment.getUnchecked$kotlinx_io_core(i2);
                i++;
                char[] cArr = Utf8Kt.HEX_DIGIT_CHARS;
                sb.append(cArr[(unchecked$kotlinx_io_core >> 4) & 15]);
                sb.append(cArr[unchecked$kotlinx_io_core & 15]);
                i2 = i3;
            }
        }
        if (this.sizeMut > 64) {
            sb.append((char) 8230);
        }
        return "Buffer(size=" + this.sizeMut + " hex=" + ((Object) sb) + ')';
    }

    @Override // kotlinx.io.Sink
    public final long transferFrom(RawSource rawSource) {
        rawSource.getClass();
        long j = 0;
        while (true) {
            long atMostTo = rawSource.readAtMostTo(this, 8192L);
            if (atMostTo == -1) {
                return j;
            }
            j += atMostTo;
        }
    }

    @Override // kotlinx.io.Source
    public final long transferTo(RawSink rawSink) {
        rawSink.getClass();
        long j = this.sizeMut;
        if (j > 0) {
            rawSink.write(this, j);
        }
        return j;
    }

    public final /* synthetic */ Segment writableSegment(int i) {
        if (i < 1 || i > 8192) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "unexpected capacity (", "), should be in range [1, 8192]"));
            return null;
        }
        Segment segment = this.tail;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            this.tail = segmentTake;
            return segmentTake;
        }
        if (segment.limit + i <= 8192 && segment.owner) {
            return segment;
        }
        Segment segmentTake2 = SegmentPool.take();
        segment.push$kotlinx_io_core(segmentTake2);
        this.tail = segmentTake2;
        return segmentTake2;
    }

    @Override // kotlinx.io.RawSink
    public final void write(Buffer buffer, long j) {
        Segment segmentTake;
        buffer.getClass();
        if (buffer == this) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("source == this");
            return;
        }
        Utf8Kt.checkOffsetAndCount(buffer.sizeMut, 0L, j);
        while (j > 0) {
            Segment segment = buffer.head;
            segment.getClass();
            int i = 0;
            if (j < segment.getSize()) {
                Segment segment2 = this.tail;
                if (segment2 != null && segment2.owner) {
                    long j2 = ((long) segment2.limit) + j;
                    RefCountingCopyTracker refCountingCopyTracker = segment2.copyTracker;
                    if (j2 - ((long) ((refCountingCopyTracker == null || refCountingCopyTracker.copyCount <= 0) ? segment2.pos : 0)) <= 8192) {
                        Segment segment3 = buffer.head;
                        segment3.getClass();
                        segment3.writeTo$kotlinx_io_core(segment2, (int) j);
                        buffer.sizeMut -= j;
                        this.sizeMut += j;
                        return;
                    }
                }
                Segment segment4 = buffer.head;
                segment4.getClass();
                int i2 = (int) j;
                if (i2 <= 0 || i2 > segment4.limit - segment4.pos) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("byteCount out of range");
                    return;
                }
                if (i2 >= 1024) {
                    segmentTake = segment4.sharedCopy$kotlinx_io_core();
                } else {
                    segmentTake = SegmentPool.take();
                    byte[] bArr = segment4.data;
                    byte[] bArr2 = segmentTake.data;
                    int i3 = segment4.pos;
                    ArraysKt.copyInto$default(bArr, bArr2, 0, i3, i3 + i2, 2);
                }
                segmentTake.limit = segmentTake.pos + i2;
                segment4.pos += i2;
                Segment segment5 = segment4.prev;
                if (segment5 != null) {
                    segment5.push$kotlinx_io_core(segmentTake);
                } else {
                    segmentTake.next = segment4;
                    segment4.prev = segmentTake;
                }
                buffer.head = segmentTake;
            }
            Segment segment6 = buffer.head;
            segment6.getClass();
            long size = segment6.getSize();
            Segment segmentPop$kotlinx_io_core = segment6.pop$kotlinx_io_core();
            buffer.head = segmentPop$kotlinx_io_core;
            if (segmentPop$kotlinx_io_core == null) {
                buffer.tail = null;
            }
            if (this.head == null) {
                this.head = segment6;
                this.tail = segment6;
            } else {
                Segment segment7 = this.tail;
                segment7.getClass();
                segment7.push$kotlinx_io_core(segment6);
                Segment segment8 = segment6.prev;
                if (segment8 == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("cannot compact");
                    return;
                }
                if (segment8.owner) {
                    int i4 = segment6.limit - segment6.pos;
                    int i5 = 8192 - segment8.limit;
                    segment8.getClass();
                    RefCountingCopyTracker refCountingCopyTracker2 = segment8.copyTracker;
                    if (refCountingCopyTracker2 == null || refCountingCopyTracker2.copyCount <= 0) {
                        Segment segment9 = segment6.prev;
                        segment9.getClass();
                        i = segment9.pos;
                    }
                    if (i4 <= i5 + i) {
                        Segment segment10 = segment6.prev;
                        segment10.getClass();
                        segment6.writeTo$kotlinx_io_core(segment10, i4);
                        if (segment6.pop$kotlinx_io_core() != null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                            return;
                        } else {
                            SegmentPool.recycle(segment6);
                            segment6 = segment10;
                        }
                    }
                }
                this.tail = segment6;
                if (segment6.prev == null) {
                    this.head = segment6;
                }
            }
            buffer.sizeMut -= size;
            this.sizeMut += size;
            j -= size;
        }
    }

    @Override // kotlinx.io.Sink
    public final void writeByte(byte b) {
        Segment segmentWritableSegment = writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i = segmentWritableSegment.limit;
        segmentWritableSegment.limit = i + 1;
        bArr[i] = b;
        this.sizeMut++;
    }

    @Override // kotlinx.io.Sink
    public final void writeInt(int i) {
        Segment segmentWritableSegment = writableSegment(4);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        segmentWritableSegment.limit = i2 + 4;
        this.sizeMut += 4;
    }

    @Override // kotlinx.io.Sink
    public final void writeLong(long j) {
        Segment segmentWritableSegment = writableSegment(8);
        byte[] bArr = segmentWritableSegment.data;
        int i = segmentWritableSegment.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        segmentWritableSegment.limit = i + 8;
        this.sizeMut += 8;
    }

    @Override // kotlinx.io.Sink
    public final void writeShort(short s) {
        Segment segmentWritableSegment = writableSegment(2);
        byte[] bArr = segmentWritableSegment.data;
        int i = segmentWritableSegment.limit;
        bArr[i] = (byte) ((s >>> 8) & 255);
        bArr[i + 1] = (byte) (s & 255);
        segmentWritableSegment.limit = i + 2;
        this.sizeMut += 2;
    }

    @Override // kotlinx.io.RawSource
    public final long readAtMostTo(Buffer buffer, long j) {
        buffer.getClass();
        if (j >= 0) {
            long j2 = this.sizeMut;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
        return 0L;
    }

    @Override // java.lang.AutoCloseable, kotlinx.io.RawSink
    public final void close() {
    }

    @Override // kotlinx.io.RawSink, java.io.Flushable
    public final void flush() {
    }

    @Override // kotlinx.io.Source, kotlinx.io.Sink
    public final Buffer getBuffer() {
        return this;
    }

    @Override // kotlinx.io.Sink
    public final void hintEmit() {
    }

    @Override // kotlinx.io.Sink
    public final void write(RawSource rawSource, long j) throws EOFException {
        rawSource.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
            return;
        }
        long j2 = j;
        while (j2 > 0) {
            long atMostTo = rawSource.readAtMostTo(this, j2);
            if (atMostTo == -1) {
                throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(j, "Source exhausted before reading ", " bytes. Only "), j - j2, " were read."));
            }
            j2 -= atMostTo;
        }
    }

    @Override // kotlinx.io.Sink
    public final void write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        Utf8Kt.checkBounds(bArr.length, i, i2);
        int i3 = i;
        while (i3 < i2) {
            Segment segmentWritableSegment = writableSegment(1);
            int iMin = Math.min(i2 - i3, segmentWritableSegment.getRemainingCapacity()) + i3;
            ArraysKt.copyInto(segmentWritableSegment.limit, i3, iMin, bArr, segmentWritableSegment.data);
            segmentWritableSegment.limit = (iMin - i3) + segmentWritableSegment.limit;
            i3 = iMin;
        }
        this.sizeMut += (long) (i2 - i);
    }
}
