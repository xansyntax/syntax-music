package okio;

import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.text.HexFormatKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.internal._ZlibJvmKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DeflaterSink implements Sink {
    public final /* synthetic */ byte $r8$classId = 2;
    public boolean closed;
    public final Object deflater;
    public final Object sink;

    public DeflaterSink(Http1ExchangeCodec http1ExchangeCodec) {
        this.deflater = http1ExchangeCodec;
        this.sink = new ForwardingTimeout(((RealBufferedSink) http1ExchangeCodec.socket.mimeType).sink.timeout());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        byte b = this.$r8$classId;
        Object obj = this.sink;
        Object obj2 = this.deflater;
        switch (b) {
            case 0:
                Deflater deflater = (Deflater) obj2;
                if (this.closed) {
                    return;
                }
                deflater.finish();
                deflate(false);
                th = null;
                try {
                    deflater.end();
                    break;
                } catch (Throwable th) {
                    if (th == null) {
                        th = th;
                    }
                }
                try {
                    ((RealBufferedSink) obj).close();
                    break;
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
                this.closed = true;
                if (th != null) {
                    throw th;
                }
                return;
            case 1:
                try {
                    ((Sink) obj).close();
                    return;
                } catch (IOException e) {
                    this.closed = true;
                    ((DiskLruCache$$ExternalSyntheticLambda0) obj2).invoke(e);
                    return;
                }
            default:
                Http1ExchangeCodec http1ExchangeCodec = (Http1ExchangeCodec) obj2;
                if (this.closed) {
                    return;
                }
                this.closed = true;
                ((RealBufferedSink) http1ExchangeCodec.socket.mimeType).flush();
                ForwardingTimeout forwardingTimeout = (ForwardingTimeout) obj;
                Timeout timeout = forwardingTimeout.delegate;
                forwardingTimeout.delegate = Timeout.NONE;
                timeout.clearDeadline();
                timeout.clearTimeout();
                http1ExchangeCodec.state = (byte) 3;
                return;
        }
    }

    public void deflate(boolean z) throws IOException {
        Segment segmentWritableSegment$okio;
        int iDeflate;
        Deflater deflater = (Deflater) this.deflater;
        RealBufferedSink realBufferedSink = (RealBufferedSink) this.sink;
        Buffer buffer = realBufferedSink.bufferField;
        while (true) {
            segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i = segmentWritableSegment$okio.limit;
            if (z) {
                try {
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (IllegalStateException e) {
                    throw new IOException("Deflater already closed", e);
                } catch (NullPointerException e2) {
                    throw new IOException("Deflater already closed", e2);
                }
            } else {
                iDeflate = deflater.deflate(bArr, i, 8192 - i);
            }
            if (iDeflate > 0) {
                segmentWritableSegment$okio.limit += iDeflate;
                buffer.size += (long) iDeflate;
                realBufferedSink.emitCompleteSegments();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        byte b = this.$r8$classId;
        Object obj = this.sink;
        Object obj2 = this.deflater;
        switch (b) {
            case 0:
                deflate(true);
                ((RealBufferedSink) obj).flush();
                break;
            case 1:
                try {
                    ((Sink) obj).flush();
                } catch (IOException e) {
                    this.closed = true;
                    ((DiskLruCache$$ExternalSyntheticLambda0) obj2).invoke(e);
                    return;
                }
                break;
            default:
                if (!this.closed) {
                    ((RealBufferedSink) ((Http1ExchangeCodec) obj2).socket.mimeType).flush();
                    break;
                }
                break;
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        byte b = this.$r8$classId;
        Object obj = this.sink;
        switch (b) {
            case 0:
                return ((RealBufferedSink) obj).sink.timeout();
            case 1:
                return ((Sink) obj).timeout();
            default:
                return (ForwardingTimeout) obj;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "DeflaterSink(" + ((RealBufferedSink) this.sink) + ')';
            default:
                return super.toString();
        }
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        byte b = this.$r8$classId;
        Object obj = this.deflater;
        switch (b) {
            case 0:
                Deflater deflater = (Deflater) obj;
                buffer.getClass();
                HexFormatKt.checkOffsetAndCount(buffer.size, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    Segment segment = buffer.head;
                    segment.getClass();
                    int iMin = (int) Math.min(j2, segment.limit - segment.pos);
                    deflater.setInput(segment.data, segment.pos, iMin);
                    deflate(false);
                    long j3 = iMin;
                    buffer.size -= j3;
                    int i = segment.pos + iMin;
                    segment.pos = i;
                    if (i == segment.limit) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                    j2 -= j3;
                }
                deflater.setInput(_ZlibJvmKt.EMPTY_BYTE_ARRAY, 0, 0);
                break;
            case 1:
                if (this.closed) {
                    buffer.skip(j);
                } else {
                    try {
                        ((Sink) this.sink).write(buffer, j);
                    } catch (IOException e) {
                        this.closed = true;
                        ((DiskLruCache$$ExternalSyntheticLambda0) obj).invoke(e);
                        return;
                    }
                }
                break;
            default:
                buffer.getClass();
                if (!this.closed) {
                    _UtilCommonKt.checkOffsetAndCount(buffer.size, 0L, j);
                    ((RealBufferedSink) ((Http1ExchangeCodec) obj).socket.mimeType).write(buffer, j);
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                }
                break;
        }
    }

    public DeflaterSink(Buffer buffer, Deflater deflater) {
        this.sink = new RealBufferedSink(buffer);
        this.deflater = deflater;
    }

    public DeflaterSink(Sink sink, DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0) {
        this.sink = sink;
        this.deflater = diskLruCache$$ExternalSyntheticLambda0;
    }
}
