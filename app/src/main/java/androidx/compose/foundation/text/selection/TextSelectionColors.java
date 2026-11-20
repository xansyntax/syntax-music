package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextSelectionColors {
    public final long backgroundColor;
    public final long handleColor;

    public TextSelectionColors(long j, long j2) {
        this.handleColor = j;
        this.backgroundColor = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        return ULong.m1869equalsimpl0(this.handleColor, textSelectionColors.handleColor) && ULong.m1869equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.backgroundColor) + (Long.hashCode(this.handleColor) * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("SelectionColors(selectionHandleColor=", Color.m486toStringimpl(this.handleColor), ", selectionBackgroundColor=", Color.m486toStringimpl(this.backgroundColor), ")");
    }
}
