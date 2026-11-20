package androidx.compose.ui.input.pointer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerId {
    public final long value;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m590equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m591toStringimpl(long j) {
        return IntIntPair$$ExternalSyntheticOutline0.m(j, "PointerId(value=", ")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PointerId) {
            return this.value == ((PointerId) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return m591toStringimpl(this.value);
    }
}
