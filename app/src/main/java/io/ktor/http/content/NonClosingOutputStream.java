package io.ktor.http.content;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/NonClosingOutputStream;", "Ljava/io/OutputStream;", "delegate", "<init>", "(Ljava/io/OutputStream;)V", "", "b", "", "write", "(I)V", "", "([B)V", "off", "len", "([BII)V", "flush", "()V", "close", "Ljava/io/OutputStream;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class NonClosingOutputStream extends OutputStream {
    private final OutputStream delegate;

    public NonClosingOutputStream(OutputStream outputStream) {
        outputStream.getClass();
        this.delegate = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        b.getClass();
        this.delegate.write(b);
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.delegate.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        b.getClass();
        this.delegate.write(b, off, len);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
