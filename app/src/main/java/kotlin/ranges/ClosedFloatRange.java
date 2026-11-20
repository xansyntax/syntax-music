package kotlin.ranges;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ClosedFloatRange {
    public final float _endInclusive;
    public final float _start;

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    public static boolean lessThanOrEquals(Float f, Float f2) {
        return f.floatValue() <= f2.floatValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ClosedFloatRange)) {
            return false;
        }
        float f = this._start;
        float f2 = this._endInclusive;
        if (f > f2) {
            ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
            if (closedFloatRange._start > closedFloatRange._endInclusive) {
                return true;
            }
        }
        ClosedFloatRange closedFloatRange2 = (ClosedFloatRange) obj;
        return f == closedFloatRange2._start && f2 == closedFloatRange2._endInclusive;
    }

    public final int hashCode() {
        float f = this._start;
        float f2 = this._endInclusive;
        if (f > f2) {
            return -1;
        }
        return Float.hashCode(f2) + (Float.hashCode(f) * 31);
    }

    public final String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
