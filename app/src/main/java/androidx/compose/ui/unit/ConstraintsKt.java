package androidx.compose.ui.unit;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintsKt {
    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!((i3 >= 0) & (i2 >= i) & (i4 >= i3) & (i >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final int bitsNeedForSizeUnchecked(int i) {
        if (i < 8191) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < 262143 ? 18 : 255;
    }

    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m789constrain4WqzIAM(long j, long j2) {
        int i = (int) (j2 >> 32);
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        if (i < iM786getMinWidthimpl) {
            i = iM786getMinWidthimpl;
        }
        if (i <= iM784getMaxWidthimpl) {
            iM784getMaxWidthimpl = i;
        }
        int i2 = (int) (j2 & 4294967295L);
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        if (i2 < iM785getMinHeightimpl) {
            i2 = iM785getMinHeightimpl;
        }
        if (i2 <= iM783getMaxHeightimpl) {
            iM783getMaxHeightimpl = i2;
        }
        return (((long) iM784getMaxWidthimpl) << 32) | (((long) iM783getMaxHeightimpl) & 4294967295L);
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m790constrainN9IONVI(long j, long j2) {
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        int iM786getMinWidthimpl2 = Constraints.m786getMinWidthimpl(j2);
        if (iM786getMinWidthimpl2 < iM786getMinWidthimpl) {
            iM786getMinWidthimpl2 = iM786getMinWidthimpl;
        }
        if (iM786getMinWidthimpl2 > iM784getMaxWidthimpl) {
            iM786getMinWidthimpl2 = iM784getMaxWidthimpl;
        }
        int iM784getMaxWidthimpl2 = Constraints.m784getMaxWidthimpl(j2);
        if (iM784getMaxWidthimpl2 >= iM786getMinWidthimpl) {
            iM786getMinWidthimpl = iM784getMaxWidthimpl2;
        }
        if (iM786getMinWidthimpl <= iM784getMaxWidthimpl) {
            iM784getMaxWidthimpl = iM786getMinWidthimpl;
        }
        int iM785getMinHeightimpl2 = Constraints.m785getMinHeightimpl(j2);
        if (iM785getMinHeightimpl2 < iM785getMinHeightimpl) {
            iM785getMinHeightimpl2 = iM785getMinHeightimpl;
        }
        if (iM785getMinHeightimpl2 > iM783getMaxHeightimpl) {
            iM785getMinHeightimpl2 = iM783getMaxHeightimpl;
        }
        int iM783getMaxHeightimpl2 = Constraints.m783getMaxHeightimpl(j2);
        if (iM783getMaxHeightimpl2 >= iM785getMinHeightimpl) {
            iM785getMinHeightimpl = iM783getMaxHeightimpl2;
        }
        if (iM785getMinHeightimpl <= iM783getMaxHeightimpl) {
            iM783getMaxHeightimpl = iM785getMinHeightimpl;
        }
        return Constraints(iM786getMinWidthimpl2, iM784getMaxWidthimpl, iM785getMinHeightimpl2, iM783getMaxHeightimpl);
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m791constrainHeightK40F9xA(int i, long j) {
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        if (i < iM785getMinHeightimpl) {
            i = iM785getMinHeightimpl;
        }
        return i > iM783getMaxHeightimpl ? iM783getMaxHeightimpl : i;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m792constrainWidthK40F9xA(int i, long j) {
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        if (i < iM786getMinWidthimpl) {
            i = iM786getMinWidthimpl;
        }
        return i > iM784getMaxWidthimpl ? iM784getMaxWidthimpl : i;
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            throwInvalidConstraintException(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i4 + 1;
        int i9 = iBitsNeedForSizeUnchecked2 - 13;
        return (((long) (i7 & (~(i7 >> 31)))) << 33) | ((long) ((i9 >> 1) + (i9 & 1))) | (((long) i) << 2) | (((long) i3) << (iBitsNeedForSizeUnchecked2 + 2)) | (((long) (i8 & (~(i8 >> 31)))) << (iBitsNeedForSizeUnchecked2 + 33));
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m793offsetNN6EwU(int i, int i2, long j) {
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j) + i;
        if (iM786getMinWidthimpl < 0) {
            iM786getMinWidthimpl = 0;
        }
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        if (iM784getMaxWidthimpl != Integer.MAX_VALUE && (iM784getMaxWidthimpl = iM784getMaxWidthimpl + i) < 0) {
            iM784getMaxWidthimpl = 0;
        }
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j) + i2;
        if (iM785getMinHeightimpl < 0) {
            iM785getMinHeightimpl = 0;
        }
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        return Constraints(iM786getMinWidthimpl, iM784getMaxWidthimpl, iM785getMinHeightimpl, (iM783getMaxHeightimpl == Integer.MAX_VALUE || (iM783getMaxHeightimpl = iM783getMaxHeightimpl + i2) >= 0) ? iM783getMaxHeightimpl : 0);
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m794offsetNN6EwU$default(int i, int i2, int i3, long j) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m793offsetNN6EwU(i, i2, j);
    }

    public static final void throwInvalidConstraintException(int i, int i2) {
        throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Can't represent a width of ", " and height of ", i2, " in Constraints"));
    }

    public static final Void throwInvalidConstraintsSizeException(int i) {
        throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Can't represent a size of ", " in Constraints"));
    }
}
