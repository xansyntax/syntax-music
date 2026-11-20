package kotlin.io;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FilePathComponents {
    public final File root;
    public final List segments;

    public FilePathComponents(File file, List list) {
        this.root = file;
        this.segments = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) obj;
        return this.root.equals(filePathComponents.root) && this.segments.equals(filePathComponents.segments);
    }

    public final int hashCode() {
        return this.segments.hashCode() + (this.root.hashCode() * 31);
    }

    public final String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
