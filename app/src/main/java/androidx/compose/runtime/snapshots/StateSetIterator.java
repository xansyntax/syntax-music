package androidx.compose.runtime.snapshots;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StateSetIterator implements Iterator, KMappedMarker {
    public Object current;
    public final Iterator iterator;
    public int modification;
    public Object next;
    public final SnapshotStateSet set;

    public StateSetIterator(SnapshotStateSet snapshotStateSet, Iterator it) {
        this.set = snapshotStateSet;
        this.iterator = it;
        this.modification = ((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord, snapshotStateSet)).modification;
        this.current = this.next;
        this.next = it.hasNext() ? it.next() : null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        SnapshotStateSet snapshotStateSet = this.set;
        if (((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord, snapshotStateSet)).modification != this.modification) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return null;
        }
        this.current = this.next;
        Iterator it = this.iterator;
        this.next = it.hasNext() ? it.next() : null;
        Object obj = this.current;
        if (obj != null) {
            return obj;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        SnapshotStateSet snapshotStateSet = this.set;
        if (((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord, snapshotStateSet)).modification != this.modification) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return;
        }
        Object obj = this.current;
        if (obj == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return;
        }
        snapshotStateSet.remove(obj);
        this.current = null;
        this.modification = ((StateSetStateRecord) SnapshotKt.current(snapshotStateSet.firstStateRecord, snapshotStateSet)).modification;
    }
}
