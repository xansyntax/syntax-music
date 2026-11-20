package okio;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class BlackholeSink implements Sink {
    @Override // okio.Sink
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws EOFException {
        buffer.getClass();
        buffer.skip(j);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
    }
}
