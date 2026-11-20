package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RadioButtonColors {
    public final long disabledSelectedColor;
    public final long disabledUnselectedColor;
    public final long selectedColor;
    public final long unselectedColor;

    public RadioButtonColors(long j, long j2, long j3, long j4) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.disabledSelectedColor = j3;
        this.disabledUnselectedColor = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) obj;
        return ULong.m1869equalsimpl0(this.selectedColor, radioButtonColors.selectedColor) && ULong.m1869equalsimpl0(this.unselectedColor, radioButtonColors.unselectedColor) && ULong.m1869equalsimpl0(this.disabledSelectedColor, radioButtonColors.disabledSelectedColor) && ULong.m1869equalsimpl0(this.disabledUnselectedColor, radioButtonColors.disabledUnselectedColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledUnselectedColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.selectedColor) * 31, 31, this.unselectedColor), 31, this.disabledSelectedColor);
    }
}
