package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TimeInputColors {
    public final long containerColor;
    public final long periodSelectorBorderColor;
    public final long periodSelectorContainerColor;
    public final long periodSelectorContentColor;
    public final long periodSelectorSelectedContainerColor;
    public final long periodSelectorSelectedContentColor;
    public final TextFieldColors timeTextFieldColors;

    public TimeInputColors(long j, long j2, long j3, long j4, long j5, long j6, TextFieldColors textFieldColors) {
        this.containerColor = j;
        this.periodSelectorBorderColor = j2;
        this.periodSelectorSelectedContainerColor = j3;
        this.periodSelectorContainerColor = j4;
        this.periodSelectorSelectedContentColor = j5;
        this.periodSelectorContentColor = j6;
        this.timeTextFieldColors = textFieldColors;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TimeInputColors)) {
            return false;
        }
        TimeInputColors timeInputColors = (TimeInputColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, timeInputColors.containerColor) && ULong.m1869equalsimpl0(this.periodSelectorBorderColor, timeInputColors.periodSelectorBorderColor) && ULong.m1869equalsimpl0(this.periodSelectorSelectedContainerColor, timeInputColors.periodSelectorSelectedContainerColor) && ULong.m1869equalsimpl0(this.periodSelectorContainerColor, timeInputColors.periodSelectorContainerColor) && ULong.m1869equalsimpl0(this.periodSelectorSelectedContentColor, timeInputColors.periodSelectorSelectedContentColor) && ULong.m1869equalsimpl0(this.periodSelectorContentColor, timeInputColors.periodSelectorContentColor) && this.timeTextFieldColors.equals(timeInputColors.timeTextFieldColors);
    }

    public final int hashCode() {
        return this.timeTextFieldColors.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.periodSelectorBorderColor), 31, this.periodSelectorSelectedContainerColor), 31, this.periodSelectorContainerColor), 31, this.periodSelectorSelectedContentColor), 31, this.periodSelectorContentColor);
    }
}
