package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntSize {
    public final long packedValue;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m810equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m811toStringimpl(long j) {
        return ((int) (j >> 32)) + " x " + ((int) (j & 4294967295L));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof IntSize) {
            return this.packedValue == ((IntSize) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m811toStringimpl(this.packedValue);
    }
}
