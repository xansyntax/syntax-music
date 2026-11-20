package coil3.util;

import android.os.SystemClock;
import coil3.size.Dimension;
import coil3.size.Size;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {
    @Override // coil3.util.HardwareBitmapService
    public final boolean allowHardwareMainThread(Size size) {
        Dimension dimension = size.width;
        if ((dimension instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension).px : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        Dimension dimension2 = size.height;
        return (dimension2 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension2).px : Integer.MAX_VALUE) > 100;
    }

    @Override // coil3.util.HardwareBitmapService
    public final boolean allowHardwareWorkerThread() {
        boolean z;
        synchronized (FileDescriptorCounter.INSTANCE) {
            try {
                int i = FileDescriptorCounter.decodesSinceLastFileDescriptorCheck;
                FileDescriptorCounter.decodesSinceLastFileDescriptorCheck = i + 1;
                if (i >= 30 || SystemClock.uptimeMillis() > FileDescriptorCounter.lastFileDescriptorCheckTimestamp + 30000) {
                    FileDescriptorCounter.decodesSinceLastFileDescriptorCheck = 0;
                    FileDescriptorCounter.lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
                    String[] list = FileDescriptorCounter.fileDescriptorList.list();
                    if (list == null) {
                        list = new String[0];
                    }
                    FileDescriptorCounter.hasAvailableFileDescriptors = list.length < 800;
                }
                z = FileDescriptorCounter.hasAvailableFileDescriptors;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
