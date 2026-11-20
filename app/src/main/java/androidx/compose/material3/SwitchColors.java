package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SwitchColors {
    public final long checkedIconColor;
    public final long checkedThumbColor;
    public final long checkedTrackColor;
    public final long disabledCheckedIconColor;
    public final long disabledCheckedThumbColor;
    public final long disabledCheckedTrackColor;
    public final long disabledUncheckedBorderColor;
    public final long disabledUncheckedIconColor;
    public final long disabledUncheckedThumbColor;
    public final long disabledUncheckedTrackColor;
    public final long uncheckedBorderColor;
    public final long uncheckedIconColor;
    public final long uncheckedThumbColor;
    public final long uncheckedTrackColor;

    public SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.checkedIconColor = j3;
        this.uncheckedThumbColor = j4;
        this.uncheckedTrackColor = j5;
        this.uncheckedBorderColor = j6;
        this.uncheckedIconColor = j7;
        this.disabledCheckedThumbColor = j8;
        this.disabledCheckedTrackColor = j9;
        this.disabledCheckedIconColor = j10;
        this.disabledUncheckedThumbColor = j11;
        this.disabledUncheckedTrackColor = j12;
        this.disabledUncheckedBorderColor = j13;
        this.disabledUncheckedIconColor = j14;
    }

    public final boolean equals(Object obj) {
        boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(0L, 0L);
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return ULong.m1869equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && ULong.m1869equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && ULong.m1869equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && ULong.m1869equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && ULong.m1869equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && ULong.m1869equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && ULong.m1869equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && ULong.m1869equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && ULong.m1869equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && ULong.m1869equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && ULong.m1869equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && ULong.m1869equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledUncheckedIconColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.checkedThumbColor) * 31, 31, this.checkedTrackColor), 31, 0L), 31, this.checkedIconColor), 31, this.uncheckedThumbColor), 31, this.uncheckedTrackColor), 31, this.uncheckedBorderColor), 31, this.uncheckedIconColor), 31, this.disabledCheckedThumbColor), 31, this.disabledCheckedTrackColor), 31, 0L), 31, this.disabledCheckedIconColor), 31, this.disabledUncheckedThumbColor), 31, this.disabledUncheckedTrackColor), 31, this.disabledUncheckedBorderColor);
    }
}
