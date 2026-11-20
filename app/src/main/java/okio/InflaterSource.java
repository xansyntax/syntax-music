package okio;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final RealBufferedSource source;

    public InflaterSource(RealBufferedSource realBufferedSource, Inflater inflater) {
        this.source = realBufferedSource;
        this.inflater = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        buffer.getClass();
        do {
            long orInflate = readOrInflate(buffer, j);
            if (orInflate > 0) {
                return orInflate;
            }
            Inflater inflater = this.inflater;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(Buffer buffer, long j) throws IOException {
        Inflater inflater = this.inflater;
        buffer.getClass();
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return 0L;
        }
        if (j != 0) {
            try {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                int iMin = (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit);
                boolean zNeedsInput = inflater.needsInput();
                RealBufferedSource realBufferedSource = this.source;
                if (zNeedsInput && !realBufferedSource.exhausted()) {
                    Segment segment = realBufferedSource.bufferField.head;
                    segment.getClass();
                    int i = segment.limit;
                    int i2 = segment.pos;
                    int i3 = i - i2;
                    this.bufferBytesHeldByInflater = i3;
                    inflater.setInput(segment.data, i2, i3);
                }
                int iInflate = inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
                int i4 = this.bufferBytesHeldByInflater;
                if (i4 != 0) {
                    int remaining = i4 - inflater.getRemaining();
                    this.bufferBytesHeldByInflater -= remaining;
                    realBufferedSource.skip(remaining);
                }
                if (iInflate > 0) {
                    segmentWritableSegment$okio.limit += iInflate;
                    long j2 = iInflate;
                    buffer.size += j2;
                    return j2;
                }
                if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                    buffer.head = segmentWritableSegment$okio.pop();
                    SegmentPool.recycle(segmentWritableSegment$okio);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }
}
