package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.ResourceFileSystem;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FileSystem implements Closeable {
    public static final JvmSystemFileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    static {
        JvmSystemFileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        String str = Path.DIRECTORY_SEPARATOR;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get(property);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        classLoader.getClass();
        new ResourceFileSystem(classLoader);
    }

    public Sink appendingSink(Path path) {
        path.getClass();
        return new OutputStreamSink(new FileOutputStream(path.toFile(), true), new Timeout());
    }

    public void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        if (path.toFile().renameTo(path2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + path + " to " + path2);
    }

    public final void createDirectories(Path path) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque();
        while (path != null && !exists(path)) {
            arrayDeque.addFirst(path);
            path = path.parent();
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            createDirectory((Path) it.next());
        }
    }

    public void createDirectory(Path path) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    public void delete(Path path) {
        path.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        Path$$ExternalSyntheticBUOutline0.m(path, "failed to delete ");
    }

    public final void delete$1(Path path) {
        path.getClass();
        delete(path);
    }

    public final boolean exists(Path path) {
        path.getClass();
        return metadataOrNull(path) != null;
    }

    public List list(Path path) throws IOException {
        File file = path.toFile();
        String[] list = file.list();
        if (list == null) {
            if (file.exists()) {
                Path$$ExternalSyntheticBUOutline0.m(path, "failed to list ");
                return null;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "no such file: ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.getClass();
            arrayList.add(path.resolve(str));
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        return arrayList;
    }

    public final FileMetadata metadata(Path path) throws FileNotFoundException {
        path.getClass();
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "no such file: ");
        return null;
    }

    public FileMetadata metadataOrNull(Path path) {
        path.getClass();
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
    }

    public JvmFileHandle openReadOnly(Path path) {
        return new JvmFileHandle(new RandomAccessFile(path.toFile(), "r"));
    }

    public Sink sink(Path path, boolean z) throws IOException {
        path.getClass();
        if (!z || !exists(path)) {
            return new OutputStreamSink(new FileOutputStream(path.toFile(), false), new Timeout());
        }
        throw new IOException(path + " already exists.");
    }

    public Source source(Path path) {
        path.getClass();
        return new InputStreamSource(new FileInputStream(path.toFile()), Timeout.NONE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
