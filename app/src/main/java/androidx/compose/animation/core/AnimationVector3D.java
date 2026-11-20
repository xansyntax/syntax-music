package androidx.compose.animation.core;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationVector3D extends AnimationVector {
    public float v1;
    public float v2;
    public float v3;

    public AnimationVector3D(float f, float f2, float f3) {
        this.v1 = f;
        this.v2 = f2;
        this.v3 = f3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AnimationVector3D)) {
            return false;
        }
        AnimationVector3D animationVector3D = (AnimationVector3D) obj;
        return animationVector3D.v1 == this.v1 && animationVector3D.v2 == this.v2 && animationVector3D.v3 == this.v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core(int i) {
        if (i == 0) {
            return this.v1;
        }
        if (i != 1) {
            return i != 2 ? CropImageView.DEFAULT_ASPECT_RATIO : this.v3;
        }
        return this.v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final int getSize$animation_core() {
        return 3;
    }

    public final int hashCode() {
        return Float.hashCode(this.v3) + IntIntPair$$ExternalSyntheticOutline0.m(this.v2, Float.hashCode(this.v1) * 31, 31);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final AnimationVector newVector$animation_core() {
        return new AnimationVector3D(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core() {
        this.v1 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.v2 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.v3 = CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core(int i, float f) {
        if (i == 0) {
            this.v1 = f;
        } else if (i == 1) {
            this.v2 = f;
        } else {
            if (i != 2) {
                return;
            }
            this.v3 = f;
        }
    }

    public final String toString() {
        float f = this.v1;
        float f2 = this.v2;
        float f3 = this.v3;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AnimationVector3D: v1 = ", f, ", v2 = ", f2, ", v3 = ");
        sbM.append(f3);
        return sbM.toString();
    }
}
