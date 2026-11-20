package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Rect;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphInfo {
    public final float bottom;
    public final int endIndex;
    public final int endLineIndex;
    public final AndroidParagraph paragraph;
    public final int startIndex;
    public final int startLineIndex;
    public final float top;

    public ParagraphInfo(AndroidParagraph androidParagraph, int i, int i2, int i3, int i4, float f, float f2) {
        this.paragraph = androidParagraph;
        this.startIndex = i;
        this.endIndex = i2;
        this.startLineIndex = i3;
        this.endLineIndex = i4;
        this.top = f;
        this.bottom = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParagraphInfo) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
            if (this.paragraph == paragraphInfo.paragraph && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Float.compare(this.top, paragraphInfo.top) == 0 && Float.compare(this.bottom, paragraphInfo.bottom) == 0) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + IntIntPair$$ExternalSyntheticOutline0.m(this.top, IntIntPair$$ExternalSyntheticOutline0.m(this.endLineIndex, IntIntPair$$ExternalSyntheticOutline0.m(this.startLineIndex, IntIntPair$$ExternalSyntheticOutline0.m(this.endIndex, IntIntPair$$ExternalSyntheticOutline0.m(this.startIndex, this.paragraph.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final Rect toGlobal(Rect rect) {
        return rect.m446translatek4lQ0M((((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(this.top)) & 4294967295L));
    }

    /* JADX INFO: renamed from: toGlobal-xdX6-G0, reason: not valid java name */
    public final long m732toGlobalxdX6G0(long j, boolean z) {
        if (z) {
            long j2 = TextRange.Zero;
            if (TextRange.m740equalsimpl0(j, j2)) {
                return j2;
            }
        }
        int i = TextRange.$r8$clinit;
        int i2 = this.startIndex;
        return TextRangeKt.TextRange(((int) (j >> 32)) + i2, ((int) (j & 4294967295L)) + i2);
    }

    public final Rect toLocal(Rect rect) {
        float f = -this.top;
        return rect.m446translatek4lQ0M((((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    public final int toLocalIndex(int i) {
        int i2 = this.endIndex;
        int i3 = this.startIndex;
        return UuidKt.coerceIn(i, i3, i2) - i3;
    }

    public final String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ")";
    }
}
