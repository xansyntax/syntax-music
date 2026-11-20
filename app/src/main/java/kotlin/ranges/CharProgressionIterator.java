package kotlin.ranges;

import kotlin.collections.IntIterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CharProgressionIterator extends IntIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;

    public CharProgressionIterator(char c, char c2) {
        super((byte) 1);
        this.finalElement = c2;
        boolean z = c <= c2;
        this.hasNext = z;
        this.next = z ? c : c2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.IntIterator
    public final char nextChar() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = i + 1;
        } else {
            if (!this.hasNext) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return (char) 0;
            }
            this.hasNext = false;
        }
        return (char) i;
    }
}
