package androidx.media3.container;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReorderingBufferQueue$BuffersWithTimestamp implements Comparable {
    public long presentationTimeUs = -9223372036854775807L;
    public final ArrayList nalBuffers = new ArrayList();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.presentationTimeUs, ((ReorderingBufferQueue$BuffersWithTimestamp) obj).presentationTimeUs);
    }
}
