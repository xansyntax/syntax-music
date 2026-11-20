package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableChipColors {
    public final long containerColor;
    public final long disabledContainerColor;
    public final long disabledLabelColor;
    public final long disabledLeadingIconColor;
    public final long disabledSelectedContainerColor;
    public final long disabledTrailingIconColor;
    public final long labelColor;
    public final long leadingIconColor;
    public final long selectedContainerColor;
    public final long selectedLabelColor;
    public final long selectedLeadingIconColor;
    public final long selectedTrailingIconColor;
    public final long trailingIconColor;

    public SelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        this.containerColor = j;
        this.labelColor = j2;
        this.leadingIconColor = j3;
        this.trailingIconColor = j4;
        this.disabledContainerColor = j5;
        this.disabledLabelColor = j6;
        this.disabledLeadingIconColor = j7;
        this.disabledTrailingIconColor = j8;
        this.selectedContainerColor = j9;
        this.disabledSelectedContainerColor = j10;
        this.selectedLabelColor = j11;
        this.selectedLeadingIconColor = j12;
        this.selectedTrailingIconColor = j13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectableChipColors)) {
            return false;
        }
        SelectableChipColors selectableChipColors = (SelectableChipColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, selectableChipColors.containerColor) && ULong.m1869equalsimpl0(this.labelColor, selectableChipColors.labelColor) && ULong.m1869equalsimpl0(this.leadingIconColor, selectableChipColors.leadingIconColor) && ULong.m1869equalsimpl0(this.trailingIconColor, selectableChipColors.trailingIconColor) && ULong.m1869equalsimpl0(this.disabledContainerColor, selectableChipColors.disabledContainerColor) && ULong.m1869equalsimpl0(this.disabledLabelColor, selectableChipColors.disabledLabelColor) && ULong.m1869equalsimpl0(this.disabledLeadingIconColor, selectableChipColors.disabledLeadingIconColor) && ULong.m1869equalsimpl0(this.disabledTrailingIconColor, selectableChipColors.disabledTrailingIconColor) && ULong.m1869equalsimpl0(this.selectedContainerColor, selectableChipColors.selectedContainerColor) && ULong.m1869equalsimpl0(this.disabledSelectedContainerColor, selectableChipColors.disabledSelectedContainerColor) && ULong.m1869equalsimpl0(this.selectedLabelColor, selectableChipColors.selectedLabelColor) && ULong.m1869equalsimpl0(this.selectedLeadingIconColor, selectableChipColors.selectedLeadingIconColor) && ULong.m1869equalsimpl0(this.selectedTrailingIconColor, selectableChipColors.selectedTrailingIconColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.selectedTrailingIconColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.labelColor), 31, this.leadingIconColor), 31, this.trailingIconColor), 31, this.disabledContainerColor), 31, this.disabledLabelColor), 31, this.disabledLeadingIconColor), 31, this.disabledTrailingIconColor), 31, this.selectedContainerColor), 31, this.disabledSelectedContainerColor), 31, this.selectedLabelColor), 31, this.selectedLeadingIconColor);
    }
}
