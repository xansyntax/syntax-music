package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderColors {
    public final long activeTickColor;
    public final long activeTrackColor;
    public final long disabledActiveTickColor;
    public final long disabledActiveTrackColor;
    public final long disabledInactiveTickColor;
    public final long disabledInactiveTrackColor;
    public final long disabledThumbColor;
    public final long inactiveTickColor;
    public final long inactiveTrackColor;
    public final long thumbColor;

    public SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.thumbColor = j;
        this.activeTrackColor = j2;
        this.activeTickColor = j3;
        this.inactiveTrackColor = j4;
        this.inactiveTickColor = j5;
        this.disabledThumbColor = j6;
        this.disabledActiveTrackColor = j7;
        this.disabledActiveTickColor = j8;
        this.disabledInactiveTrackColor = j9;
        this.disabledInactiveTickColor = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SliderColors)) {
            return false;
        }
        SliderColors sliderColors = (SliderColors) obj;
        return ULong.m1869equalsimpl0(this.thumbColor, sliderColors.thumbColor) && ULong.m1869equalsimpl0(this.activeTrackColor, sliderColors.activeTrackColor) && ULong.m1869equalsimpl0(this.activeTickColor, sliderColors.activeTickColor) && ULong.m1869equalsimpl0(this.inactiveTrackColor, sliderColors.inactiveTrackColor) && ULong.m1869equalsimpl0(this.inactiveTickColor, sliderColors.inactiveTickColor) && ULong.m1869equalsimpl0(this.disabledThumbColor, sliderColors.disabledThumbColor) && ULong.m1869equalsimpl0(this.disabledActiveTrackColor, sliderColors.disabledActiveTrackColor) && ULong.m1869equalsimpl0(this.disabledActiveTickColor, sliderColors.disabledActiveTickColor) && ULong.m1869equalsimpl0(this.disabledInactiveTrackColor, sliderColors.disabledInactiveTrackColor) && ULong.m1869equalsimpl0(this.disabledInactiveTickColor, sliderColors.disabledInactiveTickColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledInactiveTickColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.thumbColor) * 31, 31, this.activeTrackColor), 31, this.activeTickColor), 31, this.inactiveTrackColor), 31, this.inactiveTickColor), 31, this.disabledThumbColor), 31, this.disabledActiveTrackColor), 31, this.disabledActiveTickColor), 31, this.disabledInactiveTrackColor);
    }

    /* JADX INFO: renamed from: trackColor-WaAFU9c$material3, reason: not valid java name */
    public final long m327trackColorWaAFU9c$material3(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.activeTrackColor : this.inactiveTrackColor;
        }
        return z2 ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
    }
}
