package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CardColors {
    public final long containerColor;
    public final long contentColor;
    public final long disabledContainerColor;
    public final long disabledContentColor;

    public CardColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CardColors)) {
            return false;
        }
        CardColors cardColors = (CardColors) obj;
        return ULong.m1869equalsimpl0(this.containerColor, cardColors.containerColor) && ULong.m1869equalsimpl0(this.contentColor, cardColors.contentColor) && ULong.m1869equalsimpl0(this.disabledContainerColor, cardColors.disabledContainerColor) && ULong.m1869equalsimpl0(this.disabledContentColor, cardColors.disabledContentColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledContentColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.containerColor) * 31, 31, this.contentColor), 31, this.disabledContainerColor);
    }
}
