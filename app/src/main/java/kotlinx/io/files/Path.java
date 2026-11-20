package kotlinx.io.files;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Path {
    public final File file;

    public Path(File file) {
        this.file = file;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Path) {
            return toString().equals(((Path) obj).toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String string = this.file.toString();
        string.getClass();
        return string;
    }
}
