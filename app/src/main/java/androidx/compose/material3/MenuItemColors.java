package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuItemColors {
    public final long disabledLeadingIconColor;
    public final long disabledTextColor;
    public final long disabledTrailingIconColor;
    public final long leadingIconColor;
    public final long textColor;
    public final long trailingIconColor;

    public MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.textColor = j;
        this.leadingIconColor = j2;
        this.trailingIconColor = j3;
        this.disabledTextColor = j4;
        this.disabledLeadingIconColor = j5;
        this.disabledTrailingIconColor = j6;
    }

    public final boolean equals(Object obj) {
        boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(0L, 0L);
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MenuItemColors)) {
            return false;
        }
        MenuItemColors menuItemColors = (MenuItemColors) obj;
        return ULong.m1869equalsimpl0(this.textColor, menuItemColors.textColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.leadingIconColor, menuItemColors.leadingIconColor) && ULong.m1869equalsimpl0(this.trailingIconColor, menuItemColors.trailingIconColor) && ULong.m1869equalsimpl0(this.disabledTextColor, menuItemColors.disabledTextColor) && ULong.m1869equalsimpl0(this.disabledLeadingIconColor, menuItemColors.disabledLeadingIconColor) && ULong.m1869equalsimpl0(this.disabledTrailingIconColor, menuItemColors.disabledTrailingIconColor) && zM1869equalsimpl0;
    }

    public final int hashCode() {
        return Long.hashCode(0L) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.textColor) * 31, 31, 0L), 31, this.leadingIconColor), 31, this.trailingIconColor), 31, this.disabledTextColor), 31, this.disabledLeadingIconColor), 31, this.disabledTrailingIconColor);
    }
}
