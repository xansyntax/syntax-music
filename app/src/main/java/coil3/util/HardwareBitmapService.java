package coil3.util;

import coil3.size.Size;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface HardwareBitmapService {
    boolean allowHardwareMainThread(Size size);

    boolean allowHardwareWorkerThread();
}
