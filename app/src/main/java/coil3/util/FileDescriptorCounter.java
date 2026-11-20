package coil3.util;

import android.os.SystemClock;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileDescriptorCounter {
    public static final FileDescriptorCounter INSTANCE = new FileDescriptorCounter();
    public static final File fileDescriptorList = new File("/proc/self/fd");
    public static int decodesSinceLastFileDescriptorCheck = 30;
    public static long lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
    public static boolean hasAvailableFileDescriptors = true;
}
