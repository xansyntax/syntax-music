package kotlinx.io.files;

import java.io.File;
import java.io.IOException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface FileSystem {
    static void delete$default(FileSystem fileSystem, Path path) throws IOException {
        ((okio.Path.Companion) fileSystem).getClass();
        path.getClass();
        File file = path.file;
        if (!file.exists()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$6(file, "File does not exist: ");
        } else {
            if (file.delete()) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Deletion failed");
        }
    }
}
