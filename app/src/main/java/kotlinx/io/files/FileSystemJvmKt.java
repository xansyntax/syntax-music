package kotlinx.io.files;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FileSystemJvmKt {
    public static final okio.Path.Companion SystemFileSystem = new okio.Path.Companion(13);

    static {
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        new File(property);
    }
}
