package androidx.compose.foundation.shape;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedCornerShape implements Shape {
    public final CornerSize bottomEnd;
    public final CornerSize bottomStart;
    public final CornerSize topEnd;
    public final CornerSize topStart;

    public RoundedCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public static RoundedCornerShape copy$default(RoundedCornerShape roundedCornerShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i) {
        if ((i & 1) != 0) {
            cornerSize = roundedCornerShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = roundedCornerShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = roundedCornerShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = roundedCornerShape.bottomStart;
        }
        roundedCornerShape.getClass();
        return new RoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        float fMo184toPxTmRCtEA = this.topStart.mo184toPxTmRCtEA(j, density);
        float fMo184toPxTmRCtEA2 = this.topEnd.mo184toPxTmRCtEA(j, density);
        float fMo184toPxTmRCtEA3 = this.bottomEnd.mo184toPxTmRCtEA(j, density);
        float fMo184toPxTmRCtEA4 = this.bottomStart.mo184toPxTmRCtEA(j, density);
        float fM448getMinDimensionimpl = Size.m448getMinDimensionimpl(j);
        float f = fMo184toPxTmRCtEA + fMo184toPxTmRCtEA4;
        if (f > fM448getMinDimensionimpl) {
            float f2 = fM448getMinDimensionimpl / f;
            fMo184toPxTmRCtEA *= f2;
            fMo184toPxTmRCtEA4 *= f2;
        }
        float f3 = fMo184toPxTmRCtEA2 + fMo184toPxTmRCtEA3;
        if (f3 > fM448getMinDimensionimpl) {
            float f4 = fM448getMinDimensionimpl / f3;
            fMo184toPxTmRCtEA2 *= f4;
            fMo184toPxTmRCtEA3 *= f4;
        }
        if (fMo184toPxTmRCtEA < CropImageView.DEFAULT_ASPECT_RATIO || fMo184toPxTmRCtEA2 < CropImageView.DEFAULT_ASPECT_RATIO || fMo184toPxTmRCtEA3 < CropImageView.DEFAULT_ASPECT_RATIO || fMo184toPxTmRCtEA4 < CropImageView.DEFAULT_ASPECT_RATIO) {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Corner size in Px can't be negative(topStart = ", fMo184toPxTmRCtEA, ", topEnd = ", fMo184toPxTmRCtEA2, ", bottomEnd = ");
            sbM.append(fMo184toPxTmRCtEA3);
            sbM.append(", bottomStart = ");
            sbM.append(fMo184toPxTmRCtEA4);
            sbM.append(")!");
            InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
        }
        if (fMo184toPxTmRCtEA + fMo184toPxTmRCtEA2 + fMo184toPxTmRCtEA3 + fMo184toPxTmRCtEA4 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return new Outline$Rectangle(IntMath.m896Recttz77jQw(0L, j));
        }
        Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(0L, j);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        float f5 = layoutDirection == layoutDirection2 ? fMo184toPxTmRCtEA : fMo184toPxTmRCtEA2;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L);
        if (layoutDirection == layoutDirection2) {
            fMo184toPxTmRCtEA = fMo184toPxTmRCtEA2;
        }
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fMo184toPxTmRCtEA)) << 32) | (((long) Float.floatToRawIntBits(fMo184toPxTmRCtEA)) & 4294967295L);
        float f6 = layoutDirection == layoutDirection2 ? fMo184toPxTmRCtEA3 : fMo184toPxTmRCtEA4;
        long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L);
        if (layoutDirection != layoutDirection2) {
            fMo184toPxTmRCtEA4 = fMo184toPxTmRCtEA3;
        }
        return new Outline$Rounded(new RoundRect(rectM896Recttz77jQw.left, rectM896Recttz77jQw.top, rectM896Recttz77jQw.right, rectM896Recttz77jQw.bottom, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits3, (((long) Float.floatToRawIntBits(fMo184toPxTmRCtEA4)) << 32) | (((long) Float.floatToRawIntBits(fMo184toPxTmRCtEA4)) & 4294967295L)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        return Intrinsics.areEqual(this.topStart, roundedCornerShape.topStart) && Intrinsics.areEqual(this.topEnd, roundedCornerShape.topEnd) && Intrinsics.areEqual(this.bottomEnd, roundedCornerShape.bottomEnd) && Intrinsics.areEqual(this.bottomStart, roundedCornerShape.bottomStart);
    }

    public final int hashCode() {
        return this.bottomStart.hashCode() + ((this.bottomEnd.hashCode() + ((this.topEnd.hashCode() + (this.topStart.hashCode() * 31)) * 31)) * 31);
    }

    public final Object lerp(final float f, Object obj) {
        if (Intrinsics.areEqual(obj, ColorKt.RectangleShape) || obj == null) {
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            PxCornerSize pxCornerSize = new PxCornerSize(CropImageView.DEFAULT_ASPECT_RATIO);
            obj = new RoundedCornerShape(pxCornerSize, pxCornerSize, pxCornerSize, pxCornerSize);
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return null;
        }
        RoundedCornerShape roundedCornerShape2 = (RoundedCornerShape) obj;
        RoundedCornerShape roundedCornerShape3 = RoundedCornerShapeKt.CircleShape;
        final CornerSize cornerSize = roundedCornerShape2.topStart;
        final CornerSize cornerSize2 = this.topStart;
        CornerSize cornerSize3 = new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo184toPxTmRCtEA(long j, Density density) {
                return LifecyclesKt.lerp(cornerSize2.mo184toPxTmRCtEA(j, density), cornerSize.mo184toPxTmRCtEA(j, density), f);
            }
        };
        final CornerSize cornerSize4 = roundedCornerShape2.topEnd;
        final CornerSize cornerSize5 = this.topEnd;
        CornerSize cornerSize6 = new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo184toPxTmRCtEA(long j, Density density) {
                return LifecyclesKt.lerp(cornerSize5.mo184toPxTmRCtEA(j, density), cornerSize4.mo184toPxTmRCtEA(j, density), f);
            }
        };
        final CornerSize cornerSize7 = roundedCornerShape2.bottomEnd;
        final CornerSize cornerSize8 = this.bottomEnd;
        CornerSize cornerSize9 = new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo184toPxTmRCtEA(long j, Density density) {
                return LifecyclesKt.lerp(cornerSize8.mo184toPxTmRCtEA(j, density), cornerSize7.mo184toPxTmRCtEA(j, density), f);
            }
        };
        final CornerSize cornerSize10 = roundedCornerShape2.bottomStart;
        final CornerSize cornerSize11 = this.bottomStart;
        return new RoundedCornerShape(cornerSize3, cornerSize6, cornerSize9, new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo184toPxTmRCtEA(long j, Density density) {
                return LifecyclesKt.lerp(cornerSize11.mo184toPxTmRCtEA(j, density), cornerSize10.mo184toPxTmRCtEA(j, density), f);
            }
        });
    }

    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.topStart + ", topEnd = " + this.topEnd + ", bottomEnd = " + this.bottomEnd + ", bottomStart = " + this.bottomStart + ")";
    }
}
