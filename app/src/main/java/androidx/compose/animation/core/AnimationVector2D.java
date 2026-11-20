package androidx.compose.animation.core;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationVector2D extends AnimationVector {
    public float v1;
    public float v2;

    public AnimationVector2D(float f, float f2) {
        this.v1 = f;
        this.v2 = f2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AnimationVector2D)) {
            return false;
        }
        AnimationVector2D animationVector2D = (AnimationVector2D) obj;
        return animationVector2D.v1 == this.v1 && animationVector2D.v2 == this.v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core(int i) {
        if (i != 0) {
            return i != 1 ? CropImageView.DEFAULT_ASPECT_RATIO : this.v2;
        }
        return this.v1;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final int getSize$animation_core() {
        return 2;
    }

    public final int hashCode() {
        return Float.hashCode(this.v2) + (Float.hashCode(this.v1) * 31);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final AnimationVector newVector$animation_core() {
        return new AnimationVector2D(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core() {
        this.v1 = CropImageView.DEFAULT_ASPECT_RATIO;
        this.v2 = CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core(int i, float f) {
        if (i == 0) {
            this.v1 = f;
        } else {
            if (i != 1) {
                return;
            }
            this.v2 = f;
        }
    }

    public final String toString() {
        return "AnimationVector2D: v1 = " + this.v1 + ", v2 = " + this.v2;
    }
}
