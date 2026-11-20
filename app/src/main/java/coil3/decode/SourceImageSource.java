package coil3.decode;

import com.google.common.math.IntMath;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SourceImageSource implements ImageSource {
    public final FileSystem fileSystem;
    public boolean isClosed;
    public final Object lock = new Object();
    public final IntMath metadata;
    public final BufferedSource source;

    public SourceImageSource(BufferedSource bufferedSource, FileSystem fileSystem, IntMath intMath) {
        this.fileSystem = fileSystem;
        this.metadata = intMath;
        this.source = bufferedSource;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.lock) {
            this.isClosed = true;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                try {
                    bufferedSource.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // coil3.decode.ImageSource
    public final Path fileOrNull() {
        synchronized (this.lock) {
            if (this.isClosed) {
                throw new IllegalStateException("closed");
            }
        }
        return null;
    }

    @Override // coil3.decode.ImageSource
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.decode.ImageSource
    public final IntMath getMetadata() {
        return this.metadata;
    }

    @Override // coil3.decode.ImageSource
    public final BufferedSource source() {
        BufferedSource bufferedSource;
        synchronized (this.lock) {
            try {
                if (this.isClosed) {
                    throw new IllegalStateException("closed");
                }
                bufferedSource = this.source;
                if (bufferedSource == null) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bufferedSource;
    }
}
