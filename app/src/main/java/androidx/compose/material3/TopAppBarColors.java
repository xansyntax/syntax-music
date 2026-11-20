package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarColors {
    public final long actionIconContentColor;
    public final long containerColor;
    public final long navigationIconContentColor;
    public final long scrolledContainerColor;
    public final long subtitleContentColor;
    public final long titleContentColor;

    public TopAppBarColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j4;
        this.actionIconContentColor = j5;
        this.subtitleContentColor = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, topAppBarColors.containerColor) && ULong.m1869equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && ULong.m1869equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && ULong.m1869equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && ULong.m1869equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor) && ULong.m1869equalsimpl0(this.subtitleContentColor, topAppBarColors.subtitleContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.subtitleContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.scrolledContainerColor), 31, this.navigationIconContentColor), 31, this.titleContentColor), 31, this.actionIconContentColor);
    }
}
