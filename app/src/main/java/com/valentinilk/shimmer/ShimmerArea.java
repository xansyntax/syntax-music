package com.valentinilk.shimmer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShimmerArea {
    public long pivotPoint;
    public final float reducedRotation;
    public Rect requestedShimmerBounds;
    public Rect shimmerBounds;
    public long shimmerSize;
    public float translationDistance;
    public Rect viewBounds;
    public final float widthOfShimmer;

    public ShimmerArea(float f, float f2) {
        this.widthOfShimmer = f;
        if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The shimmer's rotation must be a positive number");
            throw null;
        }
        this.reducedRotation = (((-Math.abs((f2 % 180.0f) - 90.0f)) + 90.0f) / 180.0f) * 3.1415927f;
        this.shimmerSize = 0L;
        this.pivotPoint = 9205357640488583168L;
        Rect rect = Rect.Zero;
        this.shimmerBounds = rect;
        this.viewBounds = rect;
    }

    public final void computeShimmerBounds() {
        if (this.viewBounds.isEmpty()) {
            return;
        }
        Rect rect = this.requestedShimmerBounds;
        if (rect == null) {
            rect = this.viewBounds;
        }
        this.shimmerBounds = rect;
        this.pivotPoint = Offset.m439plusMKHz9U(this.viewBounds.m445getTopLeftF1C5BW0() ^ (-9223372034707292160L), this.shimmerBounds.m443getCenterF1C5BW0());
        long jM444getSizeNHjbRc = this.shimmerBounds.m444getSizeNHjbRc();
        if (Size.m447equalsimpl0(this.shimmerSize, jM444getSizeNHjbRc)) {
            return;
        }
        this.shimmerSize = jM444getSizeNHjbRc;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc >> 32)) / 2.0f;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(fIntBitsToFloat, 2.0d)) + ((float) Math.pow(Float.intBitsToFloat((int) (this.shimmerSize & 4294967295L)) / 2.0f, 2.0d)));
        this.translationDistance = (((float) Math.cos(((float) Math.acos(fIntBitsToFloat / fSqrt)) - this.reducedRotation)) * fSqrt * 2.0f) + this.widthOfShimmer;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ShimmerArea.class == obj.getClass()) {
            ShimmerArea shimmerArea = (ShimmerArea) obj;
            if (this.widthOfShimmer == shimmerArea.widthOfShimmer && this.reducedRotation == shimmerArea.reducedRotation) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.reducedRotation) + (Float.hashCode(this.widthOfShimmer) * 31);
    }
}
