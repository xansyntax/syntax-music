package coil3.decode;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.RealBufferedSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileImageSource implements ImageSource {
    public final AutoCloseable closeable;
    public final String diskCacheKey;
    public final Path file;
    public final FileSystem fileSystem;
    public boolean isClosed;
    public final Object lock = new Object();
    public RealBufferedSource source;

    public FileImageSource(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable) {
        this.file = path;
        this.fileSystem = fileSystem;
        this.diskCacheKey = str;
        this.closeable = autoCloseable;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0014 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.AutoCloseable
    public final void close() {
        AutoCloseable autoCloseable;
        synchronized (this.lock) {
            this.isClosed = true;
            RealBufferedSource realBufferedSource = this.source;
            if (realBufferedSource != null) {
                try {
                    realBufferedSource.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
                autoCloseable = this.closeable;
                if (autoCloseable != null) {
                    try {
                        Format$$ExternalSyntheticOutline0.m(autoCloseable);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
            } else {
                autoCloseable = this.closeable;
                if (autoCloseable != null) {
                    Format$$ExternalSyntheticOutline0.m(autoCloseable);
                }
            }
            throw th;
        }
    }

    @Override // coil3.decode.ImageSource
    public final Path fileOrNull() {
        Path path;
        synchronized (this.lock) {
            if (this.isClosed) {
                throw new IllegalStateException("closed");
            }
            path = this.file;
        }
        return path;
    }

    @Override // coil3.decode.ImageSource
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.decode.ImageSource
    public final IntMath getMetadata() {
        return null;
    }

    @Override // coil3.decode.ImageSource
    public final BufferedSource source() {
        synchronized (this.lock) {
            if (this.isClosed) {
                throw new IllegalStateException("closed");
            }
            RealBufferedSource realBufferedSource = this.source;
            if (realBufferedSource != null) {
                return realBufferedSource;
            }
            Source source = this.fileSystem.source(this.file);
            source.getClass();
            RealBufferedSource realBufferedSource2 = new RealBufferedSource(source);
            this.source = realBufferedSource2;
            return realBufferedSource2;
        }
    }
}
