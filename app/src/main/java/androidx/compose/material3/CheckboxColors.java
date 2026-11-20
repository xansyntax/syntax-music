package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CheckboxColors {
    public final long checkedBorderColor;
    public final long checkedBoxColor;
    public final long checkedCheckmarkColor;
    public final long disabledBorderColor;
    public final long disabledCheckedBoxColor;
    public final long disabledCheckmarkColor;
    public final long disabledIndeterminateBorderColor;
    public final long disabledIndeterminateBoxColor;
    public final long disabledUncheckedBorderColor;
    public final long uncheckedBorderColor;

    public CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.checkedCheckmarkColor = j;
        this.checkedBoxColor = j2;
        this.disabledCheckedBoxColor = j3;
        this.disabledIndeterminateBoxColor = j4;
        this.checkedBorderColor = j5;
        this.uncheckedBorderColor = j6;
        this.disabledBorderColor = j7;
        this.disabledUncheckedBorderColor = j8;
        this.disabledIndeterminateBorderColor = j9;
        this.disabledCheckmarkColor = j10;
    }

    public final boolean equals(Object obj) {
        boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(0L, 0L);
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        return ULong.m1869equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.disabledCheckmarkColor, checkboxColors.disabledCheckmarkColor) && ULong.m1869equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && ULong.m1869equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && ULong.m1869equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && ULong.m1869equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && ULong.m1869equalsimpl0(this.disabledUncheckedBorderColor, checkboxColors.disabledUncheckedBorderColor) && ULong.m1869equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledIndeterminateBorderColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.checkedCheckmarkColor) * 31, 31, 0L), 31, this.disabledCheckmarkColor), 31, this.checkedBoxColor), 31, 0L), 31, this.disabledCheckedBoxColor), 31, 0L), 31, this.disabledIndeterminateBoxColor), 31, this.checkedBorderColor), 31, this.uncheckedBorderColor), 31, this.disabledBorderColor), 31, this.disabledUncheckedBorderColor);
    }
}
