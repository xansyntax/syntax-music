package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TimePickerColors {
    public final long clockDialColor;
    public final long clockDialContentColor;
    public final long clockDialSelectedContentColor;
    public final long containerColor;
    public final long periodSelectorBorderColor;
    public final long periodSelectorContainerColor;
    public final long periodSelectorContentColor;
    public final long periodSelectorSelectedContainerColor;
    public final long periodSelectorSelectedContentColor;
    public final long selectorColor;
    public final long timeSelectorContainerColor;
    public final long timeSelectorContentColor;
    public final long timeSelectorSelectedContainerColor;
    public final long timeSelectorSelectedContentColor;

    public TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.clockDialColor = j;
        this.selectorColor = j2;
        this.containerColor = j3;
        this.periodSelectorBorderColor = j4;
        this.clockDialSelectedContentColor = j5;
        this.clockDialContentColor = j6;
        this.periodSelectorSelectedContainerColor = j7;
        this.periodSelectorContainerColor = j8;
        this.periodSelectorSelectedContentColor = j9;
        this.periodSelectorContentColor = j10;
        this.timeSelectorSelectedContainerColor = j11;
        this.timeSelectorContainerColor = j12;
        this.timeSelectorSelectedContentColor = j13;
        this.timeSelectorContentColor = j14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TimePickerColors.class != obj.getClass()) {
            return false;
        }
        TimePickerColors timePickerColors = (TimePickerColors) obj;
        return ULong.m1869equalsimpl0(this.clockDialColor, timePickerColors.clockDialColor) && ULong.m1869equalsimpl0(this.selectorColor, timePickerColors.selectorColor) && ULong.m1869equalsimpl0(this.containerColor, timePickerColors.containerColor) && ULong.m1869equalsimpl0(this.periodSelectorBorderColor, timePickerColors.periodSelectorBorderColor) && ULong.m1869equalsimpl0(this.periodSelectorSelectedContainerColor, timePickerColors.periodSelectorSelectedContainerColor) && ULong.m1869equalsimpl0(this.periodSelectorContainerColor, timePickerColors.periodSelectorContainerColor) && ULong.m1869equalsimpl0(this.periodSelectorSelectedContentColor, timePickerColors.periodSelectorSelectedContentColor) && ULong.m1869equalsimpl0(this.periodSelectorContentColor, timePickerColors.periodSelectorContentColor) && ULong.m1869equalsimpl0(this.timeSelectorSelectedContainerColor, timePickerColors.timeSelectorSelectedContainerColor) && ULong.m1869equalsimpl0(this.timeSelectorContainerColor, timePickerColors.timeSelectorContainerColor) && ULong.m1869equalsimpl0(this.timeSelectorSelectedContentColor, timePickerColors.timeSelectorSelectedContentColor) && ULong.m1869equalsimpl0(this.timeSelectorContentColor, timePickerColors.timeSelectorContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.timeSelectorContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.clockDialColor) * 31, 31, this.selectorColor), 31, this.containerColor), 31, this.periodSelectorBorderColor), 31, this.periodSelectorSelectedContainerColor), 31, this.periodSelectorContainerColor), 31, this.periodSelectorSelectedContentColor), 31, this.periodSelectorContentColor), 31, this.timeSelectorSelectedContainerColor), 31, this.timeSelectorContainerColor), 31, this.timeSelectorSelectedContentColor);
    }
}
