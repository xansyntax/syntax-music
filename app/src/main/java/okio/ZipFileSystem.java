package okio;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.ZipEntry;
import okio.internal._ZlibJvmKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ZipFileSystem extends FileSystem {
    public static final Path ROOT;
    public final LinkedHashMap entries;
    public final FileSystem fileSystem;
    public final Path zipPath;

    static {
        String str = Path.DIRECTORY_SEPARATOR;
        ROOT = Path.Companion.get("/");
    }

    public ZipFileSystem(Path path, FileSystem fileSystem, LinkedHashMap linkedHashMap) {
        fileSystem.getClass();
        this.zipPath = path;
        this.fileSystem = fileSystem;
        this.entries = linkedHashMap;
    }

    @Override // okio.FileSystem
    public final Sink appendingSink(Path path) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final void delete(Path path) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final List list(Path path) throws IOException {
        Path path2 = ROOT;
        path2.getClass();
        ZipEntry zipEntry = (ZipEntry) this.entries.get(okio.internal.Path.commonResolve(path2, path, true));
        if (zipEntry != null) {
            return CollectionsKt.toList(zipEntry.children);
        }
        Path$$ExternalSyntheticBUOutline0.m(path, "not a directory: ");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00cf  */
    @Override // okio.FileSystem
    public final FileMetadata metadataOrNull(Path path) throws Throwable {
        Long lValueOf;
        Long lValueOf2;
        Long l;
        Long lValueOf3;
        Throwable th;
        Throwable th2;
        path.getClass();
        Path path2 = ROOT;
        path2.getClass();
        ZipEntry orSkipLocalHeader = (ZipEntry) this.entries.get(okio.internal.Path.commonResolve(path2, path, true));
        if (orSkipLocalHeader == null) {
            return null;
        }
        long j = orSkipLocalHeader.offset;
        if (j != -1) {
            JvmFileHandle jvmFileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            try {
                RealBufferedSource realBufferedSource = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(j));
                try {
                    orSkipLocalHeader = _ZlibJvmKt.readOrSkipLocalHeader(realBufferedSource, orSkipLocalHeader);
                    orSkipLocalHeader.getClass();
                    try {
                        realBufferedSource.close();
                        th2 = null;
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                } catch (Throwable th4) {
                    try {
                        realBufferedSource.close();
                    } catch (Throwable th5) {
                        ResultKt.addSuppressed(th4, th5);
                    }
                    th2 = th4;
                    orSkipLocalHeader = null;
                }
                if (th2 != null) {
                    throw th2;
                }
                try {
                    jvmFileHandleOpenReadOnly.close();
                    th = null;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                if (jvmFileHandleOpenReadOnly != null) {
                    try {
                        jvmFileHandleOpenReadOnly.close();
                    } catch (Throwable th8) {
                        ResultKt.addSuppressed(th7, th8);
                    }
                }
                th = th7;
                orSkipLocalHeader = null;
            }
            if (th != null) {
                throw th;
            }
        }
        boolean z = orSkipLocalHeader.isDirectory;
        boolean z2 = !z;
        Long lValueOf4 = z ? null : Long.valueOf(orSkipLocalHeader.size);
        Long l2 = orSkipLocalHeader.ntfsCreatedAtFiletime;
        if (l2 != null) {
            lValueOf = Long.valueOf((l2.longValue() / 10000) - 11644473600000L);
        } else {
            Integer num = orSkipLocalHeader.extendedCreatedAtSeconds;
            lValueOf = num != null ? Long.valueOf(((long) num.intValue()) * 1000) : null;
        }
        Long l3 = orSkipLocalHeader.ntfsLastModifiedAtFiletime;
        if (l3 != null) {
            lValueOf2 = Long.valueOf((l3.longValue() / 10000) - 11644473600000L);
        } else {
            Integer num2 = orSkipLocalHeader.extendedLastModifiedAtSeconds;
            if (num2 != null) {
                lValueOf2 = Long.valueOf(((long) num2.intValue()) * 1000);
            } else {
                int i = orSkipLocalHeader.dosLastModifiedAtTime;
                if (i != -1) {
                    int i2 = orSkipLocalHeader.dosLastModifiedAtDate;
                    if (i == -1) {
                        lValueOf2 = null;
                    } else {
                        int i3 = (i >> 11) & 31;
                        int i4 = (i >> 5) & 63;
                        int i5 = (i & 31) << 1;
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.set(14, 0);
                        gregorianCalendar.set(((i2 >> 9) & 127) + 1980, ((i2 >> 5) & 15) - 1, i2 & 31, i3, i4, i5);
                        lValueOf2 = Long.valueOf(gregorianCalendar.getTime().getTime());
                    }
                } else {
                    lValueOf2 = null;
                }
            }
        }
        Long l4 = orSkipLocalHeader.ntfsLastAccessedAtFiletime;
        if (l4 == null) {
            Integer num3 = orSkipLocalHeader.extendedLastAccessedAtSeconds;
            if (num3 != null) {
                lValueOf3 = Long.valueOf(((long) num3.intValue()) * 1000);
            } else {
                l = null;
            }
            return new FileMetadata(z2, z, null, lValueOf4, lValueOf, lValueOf2, l);
        }
        lValueOf3 = Long.valueOf((l4.longValue() / 10000) - 11644473600000L);
        l = lValueOf3;
        return new FileMetadata(z2, z, null, lValueOf4, lValueOf, lValueOf2, l);
    }

    @Override // okio.FileSystem
    public final JvmFileHandle openReadOnly(Path path) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public final Sink sink(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public final Source source(Path path) throws Throwable {
        Throwable th;
        RealBufferedSource realBufferedSource;
        path.getClass();
        Path path2 = ROOT;
        path2.getClass();
        ZipEntry zipEntry = (ZipEntry) this.entries.get(okio.internal.Path.commonResolve(path2, path, true));
        if (zipEntry == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$6(path, "no such file: ");
            return null;
        }
        long j = zipEntry.size;
        JvmFileHandle jvmFileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            realBufferedSource = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(zipEntry.offset));
            try {
                jvmFileHandleOpenReadOnly.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (jvmFileHandleOpenReadOnly != null) {
                try {
                    jvmFileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    ResultKt.addSuppressed(th3, th4);
                }
            }
            th = th3;
            realBufferedSource = null;
        }
        if (th != null) {
            throw th;
        }
        realBufferedSource.getClass();
        _ZlibJvmKt.readOrSkipLocalHeader(realBufferedSource, null);
        if (zipEntry.compressionMethod == 0) {
            return new LimitSource(realBufferedSource, j, false);
        }
        return new LimitSource(new InflaterSource(new RealBufferedSource(new LimitSource(realBufferedSource, zipEntry.compressedSize, false)), new Inflater(true)), j, true);
    }
}
