package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;
import okio.FileSystem;
import okio.JvmFileHandle;
import okio.JvmSystemFileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ResourceFileSystem extends FileSystem {
    public static final Path ROOT;
    public final ClassLoader classLoader;
    public final SynchronizedLazyImpl roots$delegate;
    public final FileSystem systemFileSystem;

    static {
        String str = Path.DIRECTORY_SEPARATOR;
        ROOT = Path.Companion.get("/");
    }

    public ResourceFileSystem(ClassLoader classLoader) {
        JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
        jvmSystemFileSystem.getClass();
        this.classLoader = classLoader;
        this.systemFileSystem = jvmSystemFileSystem;
        this.roots$delegate = new SynchronizedLazyImpl(new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 0, this));
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void createDirectory(Path path) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final void delete(Path path) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final List list(Path path) throws FileNotFoundException {
        Path path2 = ROOT;
        path2.getClass();
        String strUtf8 = Path.commonResolve(path2, path, true).relativeTo(path2).bytes.utf8();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair pair : (List) this.roots$delegate.getValue()) {
            FileSystem fileSystem = (FileSystem) pair.first;
            Path path3 = (Path) pair.second;
            try {
                List list = fileSystem.list(path3.resolve(strUtf8));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (_ZlibJvmKt.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    Path path4 = (Path) obj2;
                    path4.getClass();
                    String strReplace = StringsKt.removePrefix(path4.bytes.utf8(), path3.bytes.utf8()).replace('\\', '/');
                    strReplace.getClass();
                    arrayList2.add(path2.resolve(strReplace));
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, linkedHashSet);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.toList(linkedHashSet);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "file not found: ");
        return null;
    }

    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) {
        path.getClass();
        if (!_ZlibJvmKt.keepPath(path)) {
            return null;
        }
        Path path2 = ROOT;
        path2.getClass();
        String strUtf8 = Path.commonResolve(path2, path, true).relativeTo(path2).bytes.utf8();
        for (Pair pair : (List) this.roots$delegate.getValue()) {
            FileMetadata fileMetadataMetadataOrNull = ((FileSystem) pair.first).metadataOrNull(((Path) pair.second).resolve(strUtf8));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) throws FileNotFoundException {
        if (!_ZlibJvmKt.keepPath(path)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "file not found: ");
            return null;
        }
        Path path2 = ROOT;
        path2.getClass();
        String strUtf8 = Path.commonResolve(path2, path, true).relativeTo(path2).bytes.utf8();
        Iterator it = ((List) this.roots$delegate.getValue()).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            try {
                return ((FileSystem) pair.first).openReadOnly(((Path) pair.second).resolve(strUtf8));
            } catch (FileNotFoundException unused) {
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "file not found: ");
        return null;
    }

    @Override // okio.FileSystem
    public final Sink sink(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public final Source source(Path path) throws IOException {
        path.getClass();
        if (!_ZlibJvmKt.keepPath(path)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "file not found: ");
            return null;
        }
        Path path2 = ROOT;
        path2.getClass();
        URL resource = this.classLoader.getResource(Path.commonResolve(path2, path, false).relativeTo(path2).bytes.utf8());
        if (resource == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "file not found: ");
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        inputStream.getClass();
        return StringsKt__IndentKt.source(inputStream);
    }
}
