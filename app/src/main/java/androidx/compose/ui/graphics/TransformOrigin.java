package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TransformOrigin {
    public final long packedValue;

    public /* synthetic */ TransformOrigin(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m519equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m520toStringimpl(long j) {
        return IntIntPair$$ExternalSyntheticOutline0.m(j, "TransformOrigin(packedValue=", ")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TransformOrigin) {
            return this.packedValue == ((TransformOrigin) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m520toStringimpl(this.packedValue);
    }
}
