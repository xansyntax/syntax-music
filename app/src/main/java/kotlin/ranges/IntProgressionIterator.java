package kotlin.ranges;

import kotlin.collections.IntIterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class IntProgressionIterator extends IntIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntProgressionIterator(int i, int i2, int i3) {
        super((byte) 0);
        boolean z = false;
        this.step = i3;
        this.finalElement = i2;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.hasNext = z;
        this.next = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = this.step + i;
            return i;
        }
        if (this.hasNext) {
            this.hasNext = false;
            return i;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
        return 0;
    }
}
