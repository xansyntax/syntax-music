package coil3.memory;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RealWeakMemoryCache$InternalValue {
    public final Map extras;
    public final WeakReference image;
    public final long size;

    public RealWeakMemoryCache$InternalValue(WeakReference weakReference, Map map, long j) {
        this.image = weakReference;
        this.extras = map;
        this.size = j;
    }
}
