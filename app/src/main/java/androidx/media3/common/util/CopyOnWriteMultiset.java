package androidx.media3.common.util;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CopyOnWriteMultiset implements Iterable {
    public final Object lock = new Object();
    public final HashMap elementCounts = new HashMap();
    public Set elementSet = Collections.EMPTY_SET;
    public List elements = Collections.EMPTY_LIST;

    public final int count(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        int iIntValue;
        synchronized (this.lock) {
            try {
                iIntValue = this.elementCounts.containsKey(eventDispatcher) ? ((Integer) this.elementCounts.get(eventDispatcher)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator it;
        synchronized (this.lock) {
            it = this.elements.iterator();
        }
        return it;
    }
}
