package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResultProxy {
    public LayoutCoordinates decorationBoxCoordinates;
    public LayoutCoordinates innerTextFieldCoordinates = null;
    public final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates) {
        this.value = textLayoutResult;
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    public final long m203coercedInVisibleBoundsOfInputTextMKHz9U(long j) {
        Rect rectLocalBoundingBoxOf;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        Rect rect = Rect.Zero;
        if (layoutCoordinates != null) {
            if (layoutCoordinates.isAttached$1()) {
                LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
                rectLocalBoundingBoxOf = layoutCoordinates2 != null ? layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, true) : null;
            } else {
                rectLocalBoundingBoxOf = rect;
            }
            if (rectLocalBoundingBoxOf != null) {
                rect = rectLocalBoundingBoxOf;
            }
        }
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        float fIntBitsToFloat2 = rect.left;
        if (fIntBitsToFloat >= fIntBitsToFloat2) {
            float fIntBitsToFloat3 = Float.intBitsToFloat(i);
            fIntBitsToFloat2 = rect.right;
            if (fIntBitsToFloat3 <= fIntBitsToFloat2) {
                fIntBitsToFloat2 = Float.intBitsToFloat(i);
            }
        }
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat4 = Float.intBitsToFloat(i2);
        float fIntBitsToFloat5 = rect.top;
        if (fIntBitsToFloat4 >= fIntBitsToFloat5) {
            float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
            fIntBitsToFloat5 = rect.bottom;
            if (fIntBitsToFloat6 <= fIntBitsToFloat5) {
                fIntBitsToFloat5 = Float.intBitsToFloat(i2);
            }
        }
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat5)) & 4294967295L);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m204getOffsetForPosition3MmeM6k(long j, boolean z) {
        if (z) {
            j = m203coercedInVisibleBoundsOfInputTextMKHz9U(j);
        }
        return this.value.multiParagraph.m729getOffsetForPositionk4lQ0M(m206translateDecorationToInnerCoordinatesMKHz9U$foundation(j));
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m205isPositionOnTextk4lQ0M(long j) {
        long jM206translateDecorationToInnerCoordinatesMKHz9U$foundation = m206translateDecorationToInnerCoordinatesMKHz9U$foundation(m203coercedInVisibleBoundsOfInputTextMKHz9U(j));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (4294967295L & jM206translateDecorationToInnerCoordinatesMKHz9U$foundation));
        TextLayoutResult textLayoutResult = this.value;
        int lineForVerticalPosition = textLayoutResult.multiParagraph.getLineForVerticalPosition(fIntBitsToFloat);
        int i = (int) (jM206translateDecorationToInnerCoordinatesMKHz9U$foundation >> 32);
        return Float.intBitsToFloat(i) >= textLayoutResult.getLineLeft(lineForVerticalPosition) && Float.intBitsToFloat(i) <= textLayoutResult.getLineRight(lineForVerticalPosition);
    }

    /* JADX INFO: renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation, reason: not valid java name */
    public final long m206translateDecorationToInnerCoordinatesMKHz9U$foundation(long j) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached$1()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.decorationBoxCoordinates) != null) {
                LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached$1() ? layoutCoordinates : null;
                if (layoutCoordinates3 != null) {
                    return layoutCoordinates2.mo604localPositionOfR5De75A(layoutCoordinates3, j);
                }
            }
        }
        return j;
    }

    /* JADX INFO: renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation, reason: not valid java name */
    public final long m207translateInnerToDecorationCoordinatesMKHz9U$foundation(long j) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached$1()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.decorationBoxCoordinates) != null) {
                LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached$1() ? layoutCoordinates : null;
                if (layoutCoordinates3 != null) {
                    return layoutCoordinates3.mo604localPositionOfR5De75A(layoutCoordinates2, j);
                }
            }
        }
        return j;
    }
}
