package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IconToggleButtonColors {
    public final long checkedContentColor;
    public final long contentColor;
    public final long disabledContentColor;

    public IconToggleButtonColors(long j, long j2, long j3) {
        this.contentColor = j;
        this.disabledContentColor = j2;
        this.checkedContentColor = j3;
    }

    public final boolean equals(Object obj) {
        boolean zM1869equalsimpl0 = ULong.m1869equalsimpl0(0L, 0L);
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IconToggleButtonColors)) {
            return false;
        }
        IconToggleButtonColors iconToggleButtonColors = (IconToggleButtonColors) obj;
        return zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.contentColor, iconToggleButtonColors.contentColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.disabledContentColor, iconToggleButtonColors.disabledContentColor) && zM1869equalsimpl0 && ULong.m1869equalsimpl0(this.checkedContentColor, iconToggleButtonColors.checkedContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.checkedContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(0L) * 31, 31, this.contentColor), 31, 0L), 31, this.disabledContentColor), 31, 0L);
    }
}
