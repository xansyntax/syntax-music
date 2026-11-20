package okio;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal._JavaIoKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InputStreamSource implements Source {
    public final InputStream input;
    public final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        inputStream.getClass();
        this.input = inputStream;
        this.timeout = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.input.close();
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        buffer.getClass();
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
            return 0L;
        }
        try {
            this.timeout.throwIfReached();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int i = this.input.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
            if (i != -1) {
                segmentWritableSegment$okio.limit += i;
                long j2 = i;
                buffer.size += j2;
                return j2;
            }
            if (segmentWritableSegment$okio.pos != segmentWritableSegment$okio.limit) {
                return -1L;
            }
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
            return -1L;
        } catch (AssertionError e) {
            if (_JavaIoKt.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.timeout;
    }

    public final String toString() {
        return "source(" + this.input + ')';
    }
}
