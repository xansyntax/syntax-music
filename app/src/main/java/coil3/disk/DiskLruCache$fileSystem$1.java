package coil3.disk;

import java.io.IOException;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache$fileSystem$1 extends ForwardingFileSystem {
    @Override // okio.FileSystem
    public final Sink sink(Path path, boolean z) throws IOException {
        Path pathParent = path.parent();
        if (pathParent != null) {
            createDirectories(pathParent);
        }
        return this.delegate.sink(path, z);
    }
}
