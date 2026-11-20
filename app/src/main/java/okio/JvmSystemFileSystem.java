package okio;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class JvmSystemFileSystem extends FileSystem {
    @Override // okio.FileSystem
    public final void createDirectory(Path path) throws IOException {
        path.getClass();
        if (path.toFile().mkdir()) {
            return;
        }
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull == null || !fileMetadataMetadataOrNull.isDirectory) {
            Path$$ExternalSyntheticBUOutline0.m(path, "failed to create directory: ");
        }
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
