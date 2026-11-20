package kotlin.ranges;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class IntRange extends IntProgression {
    public static final IntRange EMPTY = new IntRange(1, 0, 1);

    public final boolean contains(int i) {
        return this.first <= i && i <= this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean equals(Object obj) {
        if (!(obj instanceof IntRange)) {
            return false;
        }
        if (isEmpty() && ((IntRange) obj).isEmpty()) {
            return true;
        }
        IntRange intRange = (IntRange) obj;
        return this.first == intRange.first && this.last == intRange.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean isEmpty() {
        return this.first > this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final String toString() {
        return this.first + ".." + this.last;
    }
}
