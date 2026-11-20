package androidx.media3.datasource.cache;

import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReusableBufferedOutputStream extends BufferedOutputStream {
    public boolean closed;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.closed = true;
        flush();
        th = null;
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        if (th == null) {
            return;
        }
        String str = Util.DEVICE_DEBUG_INFO;
        throw th;
    }

    public final void reset(OutputStream outputStream) {
        UtilsKt.checkState(this.closed);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.closed = false;
    }
}
