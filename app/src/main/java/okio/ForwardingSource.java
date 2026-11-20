package okio;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {
    public final Source delegate;

    public ForwardingSource(Source source) {
        source.getClass();
        this.delegate = source;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        buffer.getClass();
        return this.delegate.read(buffer, j);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.delegate.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
