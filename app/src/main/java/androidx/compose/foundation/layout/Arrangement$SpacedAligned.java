package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Arrangement$SpacedAligned implements Arrangement$Horizontal, Arrangement$Vertical {
    public final Arrangement$SpacingAlignmentCalculator alignment;
    public final boolean rtlMirror;
    public final float space;
    public final float spacing;

    public Arrangement$SpacedAligned(float f, boolean z, Arrangement$SpacingAlignmentCalculator arrangement$SpacingAlignmentCalculator) {
        this.space = f;
        this.rtlMirror = z;
        this.alignment = arrangement$SpacingAlignmentCalculator;
        this.spacing = f;
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
    public final void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        int i2;
        if (iArr.length == 0) {
            return;
        }
        int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(this.space);
        boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
        if (z) {
            int length = iArr.length;
            int i3 = 0;
            int iMin = 0;
            int i4 = 0;
            while (i3 < length) {
                int iMax = Math.max(0, i - iArr[i3]);
                iArr2[i4] = iMax;
                iMin = Math.min(iMo75roundToPx0680j_4, iMax);
                i = iArr2[i4] - iMin;
                i3++;
                i4++;
            }
            i2 = i + iMin;
        } else {
            int length2 = iArr.length;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i5 < length2) {
                int i9 = iArr[i5];
                int iMin2 = Math.min(i6, i - i9);
                iArr2[i8] = iMin2;
                int iMin3 = Math.min(iMo75roundToPx0680j_4, (i - iMin2) - i9);
                int i10 = iArr2[i8] + i9 + iMin3;
                i5++;
                i7 = iMin3;
                i6 = i10;
                i8++;
            }
            i2 = i - (i6 - i7);
        }
        Arrangement$SpacingAlignmentCalculator arrangement$SpacingAlignmentCalculator = this.alignment;
        if (arrangement$SpacingAlignmentCalculator == null || i2 <= 0) {
            return;
        }
        int iAlign = arrangement$SpacingAlignmentCalculator.align(i2, layoutDirection);
        if (z) {
            iAlign -= i2;
        }
        if (iAlign != 0) {
            int length3 = iArr2.length;
            for (int i11 = 0; i11 < length3; i11++) {
                iArr2[i11] = iArr2[i11] + iAlign;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Arrangement$SpacedAligned)) {
            return false;
        }
        Arrangement$SpacedAligned arrangement$SpacedAligned = (Arrangement$SpacedAligned) obj;
        return Dp.m796equalsimpl0(this.space, arrangement$SpacedAligned.space) && this.rtlMirror == arrangement$SpacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, arrangement$SpacedAligned.alignment);
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical
    /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
    public final float mo112getSpacingD9Ej5fM() {
        return this.spacing;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(Float.hashCode(this.space) * 31, this.rtlMirror, 31);
        Arrangement$SpacingAlignmentCalculator arrangement$SpacingAlignmentCalculator = this.alignment;
        return iM + (arrangement$SpacingAlignmentCalculator == null ? 0 : arrangement$SpacingAlignmentCalculator.hashCode());
    }

    public final String toString() {
        return (this.rtlMirror ? "" : "Absolute") + "Arrangement#spacedAligned(" + Dp.m797toStringimpl(this.space) + ", " + this.alignment + ")";
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Vertical
    public final void arrange(Density density, int i, int[] iArr, int[] iArr2) {
        arrange(density, i, iArr, LayoutDirection.Ltr, iArr2);
    }
}
