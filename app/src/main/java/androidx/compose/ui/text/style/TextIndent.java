package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextIndent {
    public static final TextIndent None = new TextIndent(IntMath.getSp(0), IntMath.getSp(0));
    public final long firstLine;
    public final long restLine;

    public TextIndent(long j, long j2) {
        this.firstLine = j;
        this.restLine = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.m812equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m812equalsimpl0(this.restLine, textIndent.restLine);
    }

    public final int hashCode() {
        return Long.hashCode(this.restLine) + (Long.hashCode(this.firstLine) * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("TextIndent(firstLine=", TextUnit.m815toStringimpl(this.firstLine), ", restLine=", TextUnit.m815toStringimpl(this.restLine), ")");
    }
}
