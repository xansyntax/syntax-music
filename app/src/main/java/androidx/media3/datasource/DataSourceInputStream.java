package androidx.media3.datasource;

import coil3.util.UtilsKt;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataSourceInputStream extends InputStream implements InputStreamRetargetInterface {
    public final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    public boolean opened = false;
    public boolean closed = false;
    public final byte[] singleByteArray = new byte[1];

    public DataSourceInputStream(StatsDataSource statsDataSource, DataSpec dataSpec) {
        this.dataSource = statsDataSource;
        this.dataSpec = dataSpec;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        this.dataSource.close();
        this.closed = true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        UtilsKt.checkState(!this.closed);
        boolean z = this.opened;
        StatsDataSource statsDataSource = this.dataSource;
        if (!z) {
            statsDataSource.open(this.dataSpec);
            this.opened = true;
        }
        int i3 = statsDataSource.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        return i3;
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.singleByteArray;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
