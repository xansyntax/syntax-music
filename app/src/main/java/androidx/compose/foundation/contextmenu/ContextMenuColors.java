package androidx.compose.foundation.contextmenu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextMenuColors {
    public final long backgroundColor;
    public final long disabledIconColor;
    public final long disabledTextColor;
    public final long iconColor;
    public final long textColor;

    public ContextMenuColors(long j, long j2, long j3, long j4, long j5) {
        this.backgroundColor = j;
        this.textColor = j2;
        this.iconColor = j3;
        this.disabledTextColor = j4;
        this.disabledIconColor = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextMenuColors)) {
            return false;
        }
        ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
        return ULong.m1869equalsimpl0(this.backgroundColor, contextMenuColors.backgroundColor) && ULong.m1869equalsimpl0(this.textColor, contextMenuColors.textColor) && ULong.m1869equalsimpl0(this.iconColor, contextMenuColors.iconColor) && ULong.m1869equalsimpl0(this.disabledTextColor, contextMenuColors.disabledTextColor) && ULong.m1869equalsimpl0(this.disabledIconColor, contextMenuColors.disabledIconColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.disabledIconColor) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.backgroundColor) * 31, 31, this.textColor), 31, this.iconColor), 31, this.disabledTextColor);
    }

    public final String toString() {
        String strM486toStringimpl = Color.m486toStringimpl(this.backgroundColor);
        String strM486toStringimpl2 = Color.m486toStringimpl(this.textColor);
        String strM486toStringimpl3 = Color.m486toStringimpl(this.iconColor);
        String strM486toStringimpl4 = Color.m486toStringimpl(this.disabledTextColor);
        String strM486toStringimpl5 = Color.m486toStringimpl(this.disabledIconColor);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ContextMenuColors(backgroundColor=", strM486toStringimpl, ", textColor=", strM486toStringimpl2, ", iconColor=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, strM486toStringimpl3, ", disabledTextColor=", strM486toStringimpl4, ", disabledIconColor=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, strM486toStringimpl5, ")");
    }
}
