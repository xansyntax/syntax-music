package kotlinx.io;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class OutputStreamSink implements RawSink {
    public final OutputStream out;

    public OutputStreamSink(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // kotlinx.io.RawSink, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.out.close();
    }

    @Override // kotlinx.io.RawSink, java.io.Flushable
    public final void flush() throws IOException {
        this.out.flush();
    }

    public final String toString() {
        return "RawSink(" + this.out + ')';
    }

    @Override // kotlinx.io.RawSink
    public final void write(Buffer buffer, long j) throws IOException {
        Utf8Kt.checkOffsetAndCount(buffer.sizeMut, 0L, j);
        while (j > 0) {
            if (buffer.exhausted()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
                return;
            }
            Segment segment = buffer.head;
            segment.getClass();
            byte[] bArr = segment.data;
            int i = segment.pos;
            int iMin = (int) Math.min(j, segment.limit - i);
            this.out.write(bArr, i, iMin);
            if (iMin != 0) {
                if (iMin < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                    return;
                } else {
                    if (iMin > segment.getSize()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                        return;
                    }
                    buffer.skip(iMin);
                }
            }
            j -= (long) iMin;
        }
    }
}
