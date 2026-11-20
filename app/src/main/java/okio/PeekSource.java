package okio;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PeekSource implements Source {
    public final Buffer buffer;
    public boolean closed;
    public int expectedPos;
    public Segment expectedSegment;
    public long pos;
    public final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        Buffer buffer = bufferedSource.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r3 == r5.pos) goto L15;
     */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long read(Buffer buffer, long j) {
        Segment segment;
        buffer.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
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
        long jMin = Math.min(j, buffer2.size - this.pos);
        this.buffer.copyTo(buffer, this.pos, jMin);
        this.pos += jMin;
        return jMin;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.upstream.timeout();
    }
}
