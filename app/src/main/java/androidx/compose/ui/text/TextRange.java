package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextRange {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Zero = TextRangeKt.TextRange(0, 0);
    public final long packedValue;

    public /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m739equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).packedValue;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m740equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m741getCollapsedimpl(long j) {
        return ((int) (j >> 32)) == ((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m742getLengthimpl(long j) {
        return m743getMaximpl(j) - m744getMinimpl(j);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m743getMaximpl(long j) {
        return Math.max((int) (j >> 32), (int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m744getMinimpl(long j) {
        return Math.min((int) (j >> 32), (int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m745getReversedimpl(long j) {
        return ((int) (j >> 32)) > ((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m746toStringimpl(long j) {
        return IntIntPair$$ExternalSyntheticOutline0.m((int) (j >> 32), "TextRange(", ", ", (int) (j & 4294967295L), ")");
    }

    public final boolean equals(Object obj) {
        return m739equalsimpl(this.packedValue, obj);
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m746toStringimpl(this.packedValue);
    }
}
