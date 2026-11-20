package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        sink.getClass();
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Sink sink = this.sink;
        if (this.closed) {
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j > 0) {
            sink.write(buffer, j);
        }
        th = null;
        try {
            sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final BufferedSink emitCompleteSegments() {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return null;
        }
        Buffer buffer = this.bufferField;
        long jCompleteSegmentByteCount = buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(buffer, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        Sink sink = this.sink;
        if (j > 0) {
            sink.write(buffer, j);
        }
        sink.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    public final OutputStream outputStream() {
        return new Buffer.C03821(this, (byte) 2);
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return 0;
        }
        int iWrite = this.bufferField.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    public final long writeAll(Source source) {
        source.getClass();
        long j = 0;
        while (true) {
            long j2 = source.read(this.bufferField, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int i) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return null;
        }
        this.bufferField.m1913writeByte(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeDecimalLong(long j) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return null;
        }
        this.bufferField.m1914writeDecimalLong(j);
        emitCompleteSegments();
        return this;
    }

    public final BufferedSink writeInt(int i) {
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return null;
        }
        this.bufferField.writeInt(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String str) {
        str.getClass();
        if (this.closed) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
            return null;
        }
        this.bufferField.m1915writeUtf8(str);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) {
        buffer.getClass();
        if (!this.closed) {
            this.bufferField.write(buffer, j);
            emitCompleteSegments();
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
        }
    }

    public final BufferedSink write(ByteString byteString) {
        byteString.getClass();
        if (!this.closed) {
            this.bufferField.write(byteString);
            emitCompleteSegments();
            return this;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
        return null;
    }
}
