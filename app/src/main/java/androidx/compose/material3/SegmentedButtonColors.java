package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SegmentedButtonColors {
    public final long activeBorderColor;
    public final long activeContainerColor;
    public final long activeContentColor;
    public final long disabledActiveBorderColor;
    public final long disabledActiveContainerColor;
    public final long disabledActiveContentColor;
    public final long disabledInactiveBorderColor;
    public final long disabledInactiveContentColor;
    public final long inactiveBorderColor;
    public final long inactiveContentColor;

    public SegmentedButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.activeContainerColor = j;
        this.activeContentColor = j2;
        this.activeBorderColor = j3;
        this.inactiveContentColor = j4;
        this.inactiveBorderColor = j5;
        this.disabledActiveContainerColor = j6;
        this.disabledActiveContentColor = j7;
        this.disabledActiveBorderColor = j8;
        this.disabledInactiveContentColor = j9;
        this.disabledInactiveBorderColor = j10;
    }

    public final boolean equals(Object obj) {
        boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(0L, 0L);
        if (this == obj) {
            return true;
        }
        if (obj == null || SegmentedButtonColors.class != obj.getClass()) {
            return false;
        }
        SegmentedButtonColors segmentedButtonColors = (SegmentedButtonColors) obj;
        return ULong.m1869equalsimpl0(this.activeBorderColor, segmentedButtonColors.activeBorderColor) && ULong.m1869equalsimpl0(this.activeContentColor, segmentedButtonColors.activeContentColor) && ULong.m1869equalsimpl0(this.activeContainerColor, segmentedButtonColors.activeContainerColor) && ULong.m1869equalsimpl0(this.inactiveBorderColor, segmentedButtonColors.inactiveBorderColor) && ULong.m1869equalsimpl0(this.inactiveContentColor, segmentedButtonColors.inactiveContentColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.disabledActiveBorderColor, segmentedButtonColors.disabledActiveBorderColor) && ULong.m1869equalsimpl0(this.disabledActiveContentColor, segmentedButtonColors.disabledActiveContentColor) && ULong.m1869equalsimpl0(this.disabledActiveContainerColor, segmentedButtonColors.disabledActiveContainerColor) && ULong.m1869equalsimpl0(this.disabledInactiveBorderColor, segmentedButtonColors.disabledInactiveBorderColor) && ULong.m1869equalsimpl0(this.disabledInactiveContentColor, segmentedButtonColors.disabledInactiveContentColor) && zM1869equalsimpl0;
    }

    public final int hashCode() {
        return Long.hashCode(0L) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.activeBorderColor) * 31, 31, this.activeContentColor), 31, this.activeContainerColor), 31, this.inactiveBorderColor), 31, this.inactiveContentColor), 31, 0L), 31, this.disabledActiveBorderColor), 31, this.disabledActiveContentColor), 31, this.disabledActiveContainerColor), 31, this.disabledInactiveBorderColor), 31, this.disabledInactiveContentColor);
    }
}
