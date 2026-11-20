package androidx.compose.material3;

import androidx.collection.FloatFloatPair;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.graphics.shapes.PointTransformer;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChipArrangement implements Arrangement$Horizontal, PointTransformer {
    public final float leadingSpacing;
    public final float spacing;
    public final float trailingSpacing;

    public ChipArrangement(float f) {
        this.leadingSpacing = f;
        this.trailingSpacing = f;
        this.spacing = (((f + f) + CropImageView.DEFAULT_ASPECT_RATIO) / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
    public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        int i2;
        if (iArr.length == 0) {
            return;
        }
        int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(this.leadingSpacing);
        int iMo75roundToPx0680j_5 = density.mo75roundToPx0680j_4(this.trailingSpacing);
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            if (i4 == 0) {
                i2 = 0;
            } else if (i4 == 1) {
                int i7 = iArr[0];
                i2 = i7 + (i7 > 0 ? iMo75roundToPx0680j_4 : iMo75roundToPx0680j_5);
            } else if (i4 != 2) {
                i2 = 0;
            } else {
                i2 = i - i5;
            }
            if (layoutDirection != LayoutDirection.Ltr) {
                i2 = (i - i2) - i5;
            }
            iArr2[i4] = i2;
            i3++;
            i4 = i6;
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical
    /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
    public float mo112getSpacingD9Ej5fM() {
        return this.spacing;
    }

    @Override // androidx.graphics.shapes.PointTransformer
    /* JADX INFO: renamed from: transform-XgqJiTY, reason: not valid java name */
    public long mo273transformXgqJiTY(float f, float f2) {
        float f3 = f + this.leadingSpacing;
        float f4 = this.trailingSpacing;
        return FloatFloatPair.m0constructorimpl(f3 / f4, (f2 + this.spacing) / f4);
    }

    public ChipArrangement(float f, float f2, float f3) {
        this.leadingSpacing = f;
        this.trailingSpacing = f2;
        this.spacing = f3;
    }
}
