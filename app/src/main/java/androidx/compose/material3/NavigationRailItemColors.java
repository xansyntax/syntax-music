package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationRailItemColors {
    public final long disabledIconColor;
    public final long disabledTextColor;
    public final long selectedIconColor;
    public final long selectedIndicatorColor;
    public final long selectedTextColor;
    public final long unselectedIconColor;
    public final long unselectedTextColor;

    public NavigationRailItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j4;
        this.unselectedTextColor = j5;
        this.disabledIconColor = j6;
        this.disabledTextColor = j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationRailItemColors)) {
            return false;
        }
        NavigationRailItemColors navigationRailItemColors = (NavigationRailItemColors) obj;
        return ULong.m1869equalsimpl0(this.selectedIconColor, navigationRailItemColors.selectedIconColor) && ULong.m1869equalsimpl0(this.unselectedIconColor, navigationRailItemColors.unselectedIconColor) && ULong.m1869equalsimpl0(this.selectedTextColor, navigationRailItemColors.selectedTextColor) && ULong.m1869equalsimpl0(this.unselectedTextColor, navigationRailItemColors.unselectedTextColor) && ULong.m1869equalsimpl0(this.selectedIndicatorColor, navigationRailItemColors.selectedIndicatorColor) && ULong.m1869equalsimpl0(this.disabledIconColor, navigationRailItemColors.disabledIconColor) && ULong.m1869equalsimpl0(this.disabledTextColor, navigationRailItemColors.disabledTextColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledTextColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.selectedIconColor) * 31, 31, this.unselectedIconColor), 31, this.selectedTextColor), 31, this.unselectedTextColor), 31, this.selectedIndicatorColor), 31, this.disabledIconColor);
    }
}
