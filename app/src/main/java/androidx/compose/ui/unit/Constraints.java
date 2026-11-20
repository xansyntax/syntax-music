package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Constraints {
    public final long value;

    /* JADX INFO: renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m776copyZbe2FdA(int i, int i2, int i3, int i4) {
        if (i2 < i || i4 < i3 || i < 0 || i3 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return ConstraintsKt.createConstraints(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m777copyZbe2FdA$default(int i, int i2, int i3, int i4, int i5, long j) {
        if ((i5 & 1) != 0) {
            i = m786getMinWidthimpl(j);
        }
        if ((i5 & 2) != 0) {
            i2 = m784getMaxWidthimpl(j);
        }
        if ((i5 & 4) != 0) {
            i3 = m785getMinHeightimpl(j);
        }
        if ((i5 & 8) != 0) {
            i4 = m783getMaxHeightimpl(j);
        }
        return m776copyZbe2FdA(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m778equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m779getHasBoundedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return (((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) != 0;
    }

    /* JADX INFO: renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m780getHasBoundedWidthimpl(long j) {
        int i = (int) (3 & j);
        return (((int) (j >> 33)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1)) != 0;
    }

    /* JADX INFO: renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m781getHasFixedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i3 = (1 << (18 - i2)) - 1;
        int i4 = ((int) (j >> (i2 + 15))) & i3;
        int i5 = ((int) (j >> (i2 + 46))) & i3;
        return i4 == (i5 == 0 ? Integer.MAX_VALUE : i5 - 1);
    }

    /* JADX INFO: renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m782getHasFixedWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1;
        int i3 = ((int) (j >> 2)) & i2;
        int i4 = ((int) (j >> 33)) & i2;
        return i3 == (i4 == 0 ? Integer.MAX_VALUE : i4 - 1);
    }

    /* JADX INFO: renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m783getMaxHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i3 = ((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1);
        if (i3 == 0) {
            return Integer.MAX_VALUE;
        }
        return i3 - 1;
    }

    /* JADX INFO: renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m784getMaxWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (int) (j >> 33);
        int i3 = i2 & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1);
        if (i3 == 0) {
            return Integer.MAX_VALUE;
        }
        return i3 - 1;
    }

    /* JADX INFO: renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m785getMinHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((int) (j >> (i2 + 15))) & ((1 << (18 - i2)) - 1);
    }

    /* JADX INFO: renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m786getMinWidthimpl(long j) {
        int i = (int) (3 & j);
        return ((int) (j >> 2)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1);
    }

    /* JADX INFO: renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m787isZeroimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((((int) (j >> 33)) & ((1 << (i2 + 13)) - 1)) - 1 == 0) | ((((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) - 1 == 0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m788toStringimpl(long j) {
        int iM784getMaxWidthimpl = m784getMaxWidthimpl(j);
        String strValueOf = iM784getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(iM784getMaxWidthimpl);
        int iM783getMaxHeightimpl = m783getMaxHeightimpl(j);
        String strValueOf2 = iM783getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(iM783getMaxHeightimpl) : "Infinity";
        return "Constraints(minWidth = " + m786getMinWidthimpl(j) + ", maxWidth = " + strValueOf + ", minHeight = " + m785getMinHeightimpl(j) + ", maxHeight = " + strValueOf2 + ")";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Constraints) {
            return this.value == ((Constraints) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return m788toStringimpl(this.value);
    }
}
