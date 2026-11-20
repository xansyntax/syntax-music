package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractIterator implements Iterator, KMappedMarker {
    public Object nextValue;
    public byte state;

    public abstract void computeNext();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        byte b = this.state;
        if (b == 0) {
            this.state = (byte) 3;
            computeNext();
            return this.state == 1;
        }
        if (b == 1) {
            return true;
        }
        if (b == 2) {
            return false;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("hasNext called when the iterator is in the FAILED state.");
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        byte b = this.state;
        if (b == 1) {
            this.state = (byte) 0;
            return this.nextValue;
        }
        if (b != 2) {
            this.state = (byte) 3;
            computeNext();
            if (this.state == 1) {
                this.state = (byte) 0;
                return this.nextValue;
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
