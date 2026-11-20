package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleButtonColors {
    public final long checkedContainerColor;
    public final long checkedContentColor;
    public final long containerColor;
    public final long contentColor;
    public final long disabledContainerColor;
    public final long disabledContentColor;

    public ToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
        this.checkedContainerColor = j5;
        this.checkedContentColor = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ToggleButtonColors)) {
            return false;
        }
        ToggleButtonColors toggleButtonColors = (ToggleButtonColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, toggleButtonColors.containerColor) && ULong.m1869equalsimpl0(this.contentColor, toggleButtonColors.contentColor) && ULong.m1869equalsimpl0(this.disabledContainerColor, toggleButtonColors.disabledContainerColor) && ULong.m1869equalsimpl0(this.disabledContentColor, toggleButtonColors.disabledContentColor) && ULong.m1869equalsimpl0(this.checkedContainerColor, toggleButtonColors.checkedContainerColor) && ULong.m1869equalsimpl0(this.checkedContentColor, toggleButtonColors.checkedContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.checkedContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.contentColor), 31, this.disabledContainerColor), 31, this.disabledContentColor), 31, this.checkedContainerColor);
    }
}
