package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChipColors {
    public final long containerColor;
    public final long disabledContainerColor;
    public final long disabledLabelColor;
    public final long disabledLeadingIconContentColor;
    public final long disabledTrailingIconContentColor;
    public final long labelColor;
    public final long leadingIconContentColor;
    public final long trailingIconContentColor;

    public ChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.containerColor = j;
        this.labelColor = j2;
        this.leadingIconContentColor = j3;
        this.trailingIconContentColor = j4;
        this.disabledContainerColor = j5;
        this.disabledLabelColor = j6;
        this.disabledLeadingIconContentColor = j7;
        this.disabledTrailingIconContentColor = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipColors)) {
            return false;
        }
        ChipColors chipColors = (ChipColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, chipColors.containerColor) && ULong.m1869equalsimpl0(this.labelColor, chipColors.labelColor) && ULong.m1869equalsimpl0(this.leadingIconContentColor, chipColors.leadingIconContentColor) && ULong.m1869equalsimpl0(this.trailingIconContentColor, chipColors.trailingIconContentColor) && ULong.m1869equalsimpl0(this.disabledContainerColor, chipColors.disabledContainerColor) && ULong.m1869equalsimpl0(this.disabledLabelColor, chipColors.disabledLabelColor) && ULong.m1869equalsimpl0(this.disabledLeadingIconContentColor, chipColors.disabledLeadingIconContentColor) && ULong.m1869equalsimpl0(this.disabledTrailingIconContentColor, chipColors.disabledTrailingIconContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledTrailingIconContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.labelColor), 31, this.leadingIconContentColor), 31, this.trailingIconContentColor), 31, this.disabledContainerColor), 31, this.disabledLabelColor), 31, this.disabledLeadingIconContentColor);
    }
}
