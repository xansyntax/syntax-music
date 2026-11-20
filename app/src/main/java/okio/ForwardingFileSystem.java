package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingFileSystem extends FileSystem {
    public final FileSystem delegate;

    public ForwardingFileSystem(FileSystem fileSystem) {
        fileSystem.getClass();
        this.delegate = fileSystem;
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) {
        path.getClass();
        return this.delegate.appendingSink(path);
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        this.delegate.atomicMove(path, path2);
    }

    @Override // okio.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path path) throws IOException {
        path.getClass();
        this.delegate.createDirectory(path);
    }

    @Override // okio.FileSystem
    public final void delete(Path path) {
        path.getClass();
        this.delegate.delete(path);
    }

    @Override // okio.FileSystem
    public final List list(Path path) throws IOException {
        List<Path> list = this.delegate.list(path);
        ArrayList arrayList = new ArrayList();
        for (Path path2 : list) {
            path2.getClass();
            arrayList.add(path2);
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) {
        path.getClass();
        FileMetadata fileMetadataMetadataOrNull = this.delegate.metadataOrNull(path);
        if (fileMetadataMetadataOrNull == null) {
            return null;
        }
        Path path2 = (Path) fileMetadataMetadataOrNull.symlinkTarget;
        if (path2 == null) {
            return fileMetadataMetadataOrNull;
        }
        boolean z = fileMetadataMetadataOrNull.isRegularFile;
        boolean z2 = fileMetadataMetadataOrNull.isDirectory;
        Long l = (Long) fileMetadataMetadataOrNull.size;
        Long l2 = (Long) fileMetadataMetadataOrNull.createdAtMillis;
        Long l3 = (Long) fileMetadataMetadataOrNull.lastModifiedAtMillis;
        Long l4 = (Long) fileMetadataMetadataOrNull.lastAccessedAtMillis;
        Map map = (Map) fileMetadataMetadataOrNull.extras;
        map.getClass();
        return new FileMetadata(z, z2, path2, l, l2, l3, l4, map);
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) {
        return this.delegate.openReadOnly(path);
    }

    @Override // okio.FileSystem
    public final Source source(Path path) {
        path.getClass();
        return this.delegate.source(path);
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
