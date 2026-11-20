package io.ktor.util;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0002\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/file/Path;", "relativePath", "combineSafe", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Ljava/nio/file/Path;", "normalizeAndRelativize", "(Ljava/nio/file/Path;)Ljava/nio/file/Path;", "dropLeadingTopDirs", "Ljava/io/File;", "(Ljava/io/File;Ljava/nio/file/Path;)Ljava/io/File;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class NioPathKt {
    public static final Path combineSafe(Path path, Path path2) {
        path.getClass();
        path2.getClass();
        Path pathNormalizeAndRelativize = normalizeAndRelativize(path2);
        if (pathNormalizeAndRelativize.startsWith("..")) {
            throw new InvalidPathException(path2.toString(), "Relative path " + path2 + " beginning with .. is invalid");
        }
        if (pathNormalizeAndRelativize.isAbsolute()) {
            PathKt$$ExternalSyntheticBUOutline0.m$2(path2, "Bad relative path ");
            return null;
        }
        if (path.getNameCount() == 0) {
            return pathNormalizeAndRelativize;
        }
        Path pathResolve = path.resolve(pathNormalizeAndRelativize);
        pathResolve.getClass();
        return pathResolve;
    }

    private static final Path dropLeadingTopDirs(Path path) {
        Iterator it = path.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Object next = it.next();
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            if (!Intrinsics.areEqual(((Path) next).toString(), "..")) {
                break;
            }
            i++;
        }
        if (i <= 0) {
            return path;
        }
        Path pathSubpath = path.subpath(i, path.getNameCount());
        pathSubpath.getClass();
        return pathSubpath;
    }

    public static final Path normalizeAndRelativize(Path path) {
        Path pathRelativize;
        Path pathNormalize;
        Path pathDropLeadingTopDirs;
        path.getClass();
        Path root = path.getRoot();
        if (root != null && (pathRelativize = root.relativize(path)) != null && (pathNormalize = pathRelativize.normalize()) != null && (pathDropLeadingTopDirs = dropLeadingTopDirs(pathNormalize)) != null) {
            return pathDropLeadingTopDirs;
        }
        Path pathNormalize2 = path.normalize();
        pathNormalize2.getClass();
        return dropLeadingTopDirs(pathNormalize2);
    }

    public static final File combineSafe(File file, Path path) {
        file.getClass();
        path.getClass();
        Path pathNormalizeAndRelativize = normalizeAndRelativize(path);
        if (!pathNormalizeAndRelativize.startsWith("..")) {
            if (!pathNormalizeAndRelativize.isAbsolute()) {
                return new File(file, pathNormalizeAndRelativize.toString());
            }
            PathKt$$ExternalSyntheticBUOutline0.m$2(path, "Bad relative path ");
            return null;
        }
        throw new InvalidPathException(path.toString(), "Relative path " + path + " beginning with .. is invalid");
    }
}
