package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListItemColors {
    public final long containerColor;
    public final long contentColor;
    public final long disabledContainerColor;
    public final long disabledContentColor;
    public final long disabledLeadingContentColor;
    public final long disabledOverlineContentColor;
    public final long disabledSupportingContentColor;
    public final long disabledTrailingContentColor;
    public final long draggedContainerColor;
    public final long draggedContentColor;
    public final long draggedLeadingContentColor;
    public final long draggedOverlineContentColor;
    public final long draggedSupportingContentColor;
    public final long draggedTrailingContentColor;
    public final long leadingContentColor;
    public final long overlineContentColor;
    public final long selectedContainerColor;
    public final long selectedContentColor;
    public final long selectedLeadingContentColor;
    public final long selectedOverlineContentColor;
    public final long selectedSupportingContentColor;
    public final long selectedTrailingContentColor;
    public final long supportingContentColor;
    public final long trailingContentColor;

    public ListItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24) {
        this.containerColor = j;
        this.contentColor = j2;
        this.leadingContentColor = j3;
        this.trailingContentColor = j4;
        this.overlineContentColor = j5;
        this.supportingContentColor = j6;
        this.disabledContainerColor = j7;
        this.disabledContentColor = j8;
        this.disabledLeadingContentColor = j9;
        this.disabledTrailingContentColor = j10;
        this.disabledOverlineContentColor = j11;
        this.disabledSupportingContentColor = j12;
        this.selectedContainerColor = j13;
        this.selectedContentColor = j14;
        this.selectedLeadingContentColor = j15;
        this.selectedTrailingContentColor = j16;
        this.selectedOverlineContentColor = j17;
        this.selectedSupportingContentColor = j18;
        this.draggedContainerColor = j19;
        this.draggedContentColor = j20;
        this.draggedLeadingContentColor = j21;
        this.draggedTrailingContentColor = j22;
        this.draggedOverlineContentColor = j23;
        this.draggedSupportingContentColor = j24;
    }

    /* JADX INFO: renamed from: containerColor-XeAY9LY, reason: not valid java name */
    public final long m293containerColorXeAY9LY(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.draggedContainerColor : this.containerColor;
        }
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: contentColor-XeAY9LY, reason: not valid java name */
    public final long m294contentColorXeAY9LY(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.draggedContentColor : this.contentColor;
        }
        return this.disabledContentColor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListItemColors)) {
            return false;
        }
        ListItemColors listItemColors = (ListItemColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, listItemColors.containerColor) && ULong.m1869equalsimpl0(this.contentColor, listItemColors.contentColor) && ULong.m1869equalsimpl0(this.leadingContentColor, listItemColors.leadingContentColor) && ULong.m1869equalsimpl0(this.trailingContentColor, listItemColors.trailingContentColor) && ULong.m1869equalsimpl0(this.overlineContentColor, listItemColors.overlineContentColor) && ULong.m1869equalsimpl0(this.supportingContentColor, listItemColors.supportingContentColor) && ULong.m1869equalsimpl0(this.disabledContainerColor, listItemColors.disabledContainerColor) && ULong.m1869equalsimpl0(this.disabledContentColor, listItemColors.disabledContentColor) && ULong.m1869equalsimpl0(this.disabledLeadingContentColor, listItemColors.disabledLeadingContentColor) && ULong.m1869equalsimpl0(this.disabledTrailingContentColor, listItemColors.disabledTrailingContentColor) && ULong.m1869equalsimpl0(this.disabledOverlineContentColor, listItemColors.disabledOverlineContentColor) && ULong.m1869equalsimpl0(this.disabledSupportingContentColor, listItemColors.disabledSupportingContentColor) && ULong.m1869equalsimpl0(this.selectedContainerColor, listItemColors.selectedContainerColor) && ULong.m1869equalsimpl0(this.selectedContentColor, listItemColors.selectedContentColor) && ULong.m1869equalsimpl0(this.selectedLeadingContentColor, listItemColors.selectedLeadingContentColor) && ULong.m1869equalsimpl0(this.selectedTrailingContentColor, listItemColors.selectedTrailingContentColor) && ULong.m1869equalsimpl0(this.selectedOverlineContentColor, listItemColors.selectedOverlineContentColor) && ULong.m1869equalsimpl0(this.selectedSupportingContentColor, listItemColors.selectedSupportingContentColor) && ULong.m1869equalsimpl0(this.draggedContainerColor, listItemColors.draggedContainerColor) && ULong.m1869equalsimpl0(this.draggedContentColor, listItemColors.draggedContentColor) && ULong.m1869equalsimpl0(this.draggedLeadingContentColor, listItemColors.draggedLeadingContentColor) && ULong.m1869equalsimpl0(this.draggedTrailingContentColor, listItemColors.draggedTrailingContentColor) && ULong.m1869equalsimpl0(this.draggedOverlineContentColor, listItemColors.draggedOverlineContentColor) && ULong.m1869equalsimpl0(this.draggedSupportingContentColor, listItemColors.draggedSupportingContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.draggedSupportingContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.contentColor), 31, this.leadingContentColor), 31, this.trailingContentColor), 31, this.overlineContentColor), 31, this.supportingContentColor), 31, this.disabledContainerColor), 31, this.disabledContentColor), 31, this.disabledLeadingContentColor), 31, this.disabledTrailingContentColor), 31, this.disabledOverlineContentColor), 31, this.disabledSupportingContentColor), 31, this.selectedContainerColor), 31, this.selectedContentColor), 31, this.selectedLeadingContentColor), 31, this.selectedTrailingContentColor), 31, this.selectedOverlineContentColor), 31, this.selectedSupportingContentColor), 31, this.draggedContainerColor), 31, this.draggedContentColor), 31, this.draggedLeadingContentColor), 31, this.draggedTrailingContentColor), 31, this.draggedOverlineContentColor);
    }

    /* JADX INFO: renamed from: leadingContentColor-XeAY9LY, reason: not valid java name */
    public final long m295leadingContentColorXeAY9LY(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.draggedLeadingContentColor : this.leadingContentColor;
        }
        return this.disabledLeadingContentColor;
    }

    /* JADX INFO: renamed from: overlineContentColor-XeAY9LY, reason: not valid java name */
    public final long m296overlineContentColorXeAY9LY(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.draggedOverlineContentColor : this.overlineContentColor;
        }
        return this.disabledOverlineContentColor;
    }

    /* JADX INFO: renamed from: supportingContentColor-XeAY9LY, reason: not valid java name */
    public final long m297supportingContentColorXeAY9LY(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.draggedSupportingContentColor : this.supportingContentColor;
        }
        return this.disabledSupportingContentColor;
    }

    /* JADX INFO: renamed from: trailingContentColor-XeAY9LY, reason: not valid java name */
    public final long m298trailingContentColorXeAY9LY(boolean z, boolean z2) {
        if (z) {
            return z2 ? this.draggedTrailingContentColor : this.trailingContentColor;
        }
        return this.disabledTrailingContentColor;
    }
}
