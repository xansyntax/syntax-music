package coil3.decode;

import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExifInterfaceInputStream extends InputStream implements InputStreamRetargetInterface {
    public int availableBytes = 1073741824;
    public final InputStream delegate;

    public ExifInterfaceInputStream(InputStream inputStream) {
        this.delegate = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.availableBytes;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.delegate.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i = this.delegate.read();
        if (i == -1) {
            this.availableBytes = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.delegate.skip(j);
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.delegate.read(bArr);
        if (i == -1) {
            this.availableBytes = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.delegate.read(bArr, i, i2);
        if (i3 == -1) {
            this.availableBytes = 0;
        }
        return i3;
    }
}
