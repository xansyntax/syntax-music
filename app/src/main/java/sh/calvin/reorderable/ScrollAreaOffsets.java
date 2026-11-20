package sh.calvin.reorderable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ScrollAreaOffsets {
    public final float end;
    public final float start;

    public ScrollAreaOffsets(float f, float f2) {
        this.start = f;
        this.end = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollAreaOffsets)) {
            return false;
        }
        ScrollAreaOffsets scrollAreaOffsets = (ScrollAreaOffsets) obj;
        return Float.compare(this.start, scrollAreaOffsets.start) == 0 && Float.compare(this.end, scrollAreaOffsets.end) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.end) + (Float.hashCode(this.start) * 31);
    }

    public final String toString() {
        return "ScrollAreaOffsets(start=" + this.start + ", end=" + this.end + ')';
    }
}
