package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class OutputStreamSink implements Sink {
    public final OutputStream out;
    public final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout) {
        this.out = outputStream;
        this.timeout = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        this.out.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.timeout;
    }

    public final String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        buffer.getClass();
        HexFormatKt.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            segment.getClass();
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, iMin);
            int i = segment.pos + iMin;
            segment.pos = i;
            long j2 = iMin;
            j -= j2;
            buffer.size -= j2;
            if (i == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
