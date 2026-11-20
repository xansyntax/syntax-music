package kotlinx.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PeekSource implements RawSource {
    public final Buffer buffer;
    public boolean closed;
    public int expectedPos;
    public Segment expectedSegment;
    public long pos;
    public final Source upstream;

    public PeekSource(Source source) {
        this.upstream = source;
        Buffer buffer = source.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r3 == r5.pos) goto L15;
     */
    @Override // kotlinx.io.RawSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long readAtMostTo(Buffer buffer, long j) {
        Segment segment;
        buffer.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Source is closed.");
            return 0L;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "byteCount (", ") < 0"));
            return 0L;
        }
        Segment segment2 = this.expectedSegment;
        Buffer buffer2 = this.buffer;
        if (segment2 != null) {
            Segment segment3 = buffer2.head;
            if (segment2 == segment3) {
                int i = this.expectedPos;
                segment3.getClass();
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Peek source is invalid because upstream source was used");
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && (segment = buffer2.head) != null) {
            this.expectedSegment = segment;
            this.expectedPos = segment.pos;
        }
        long jMin = Math.min(j, buffer2.sizeMut - this.pos);
        long j2 = this.pos;
        long j3 = j2 + jMin;
        Utf8Kt.checkBounds(buffer2.sizeMut, j2, j3);
        if (j2 != j3) {
            long j4 = j3 - j2;
            buffer.sizeMut += j4;
            Segment segment4 = buffer2.head;
            while (true) {
                segment4.getClass();
                long j5 = segment4.limit - segment4.pos;
                if (j2 < j5) {
                    break;
                }
                j2 -= j5;
                segment4 = segment4.next;
            }
            while (j4 > 0) {
                segment4.getClass();
                Segment segmentSharedCopy$kotlinx_io_core = segment4.sharedCopy$kotlinx_io_core();
                int i2 = segmentSharedCopy$kotlinx_io_core.pos + ((int) j2);
                segmentSharedCopy$kotlinx_io_core.pos = i2;
                segmentSharedCopy$kotlinx_io_core.limit = Math.min(i2 + ((int) j4), segmentSharedCopy$kotlinx_io_core.limit);
                if (buffer.head == null) {
                    buffer.head = segmentSharedCopy$kotlinx_io_core;
                    buffer.tail = segmentSharedCopy$kotlinx_io_core;
                } else {
                    Segment segment5 = buffer.tail;
                    segment5.getClass();
                    segment5.push$kotlinx_io_core(segmentSharedCopy$kotlinx_io_core);
                    buffer.tail = segmentSharedCopy$kotlinx_io_core;
                }
                j4 -= (long) (segmentSharedCopy$kotlinx_io_core.limit - segmentSharedCopy$kotlinx_io_core.pos);
                segment4 = segment4.next;
                j2 = 0;
            }
        }
        this.pos += jMin;
        return jMin;
    }
}
