package androidx.compose.animation.core;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationVector4D extends AnimationVector {
    public float v1;
    public float v2;
    public float v3;
    public float v4;

    public AnimationVector4D(float f, float f2, float f3, float f4) {
        this.v1 = f;
        this.v2 = f2;
        this.v3 = f3;
        this.v4 = f4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AnimationVector4D)) {
            return false;
        }
        AnimationVector4D animationVector4D = (AnimationVector4D) obj;
        return animationVector4D.v1 == this.v1 && animationVector4D.v2 == this.v2 && animationVector4D.v3 == this.v3 && animationVector4D.v4 == this.v4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core(int i) {
        if (i == 0) {
            return this.v1;
        }
        if (i == 1) {
            return this.v2;
        }
        if (i != 2) {
            return i != 3 ? CropImageView.DEFAULT_ASPECT_RATIO : this.v4;
        }
        return this.v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final int getSize$animation_core() {
        return 4;
    }

    public final int hashCode() {
        return Float.hashCode(this.v4) + IntIntPair$$ExternalSyntheticOutline0.m(this.v3, IntIntPair$$ExternalSyntheticOutline0.m(this.v2, Float.hashCode(this.v1) * 31, 31), 31);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final AnimationVector newVector$animation_core() {
        return new AnimationVector4D(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core() {
        this.v1 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.v2 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.v3 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.v4 = CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core(int i, float f) {
        if (i == 0) {
            this.v1 = f;
            return;
        }
        if (i == 1) {
            this.v2 = f;
        } else if (i == 2) {
            this.v3 = f;
        } else {
            if (i != 3) {
                return;
            }
            this.v4 = f;
        }
    }

    public final String toString() {
        float f = this.v1;
        float f2 = this.v2;
        float f3 = this.v3;
        float f4 = this.v4;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AnimationVector4D: v1 = ", f, ", v2 = ", f2, ", v3 = ");
        sbM.append(f3);
        sbM.append(", v4 = ");
        sbM.append(f4);
        return sbM.toString();
    }
}
