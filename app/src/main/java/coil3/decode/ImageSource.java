package coil3.decode;

import com.google.common.math.IntMath;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ImageSource extends AutoCloseable {
    Path fileOrNull();

    FileSystem getFileSystem();

    IntMath getMetadata();

    BufferedSource source();
}
