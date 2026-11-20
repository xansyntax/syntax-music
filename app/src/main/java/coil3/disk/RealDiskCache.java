package coil3.disk;

import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealDiskCache {
    public final DiskLruCache cache;
    public final Path directory;
    public final FileSystem fileSystem;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RealSnapshot implements AutoCloseable {
        public final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // java.lang.AutoCloseable
        public final void close() {
            this.snapshot.close();
        }
    }

    public RealDiskCache(long j, FileSystem fileSystem, Path path) {
        this.directory = path;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(j, fileSystem, path);
    }

    public final void clear() {
        DiskLruCache diskLruCache = this.cache;
        synchronized (diskLruCache.lock) {
            try {
                diskLruCache.initialize();
                for (DiskLruCache.Entry entry : (DiskLruCache.Entry[]) diskLruCache.lruEntries.values().toArray(new DiskLruCache.Entry[0])) {
                    diskLruCache.removeEntry(entry);
                }
                diskLruCache.mostRecentTrimFailed = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
