package androidx.compose.animation.core;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationVector1D extends AnimationVector {
    public float value;

    public AnimationVector1D(float f) {
        this.value = f;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AnimationVector1D) && ((AnimationVector1D) obj).value == this.value;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core(int i) {
        return i == 0 ? this.value : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public final int hashCode() {
        return Float.hashCode(this.value);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core() {
        this.value = CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core(int i, float f) {
        if (i == 0) {
            this.value = f;
        }
    }

    public final String toString() {
        return "AnimationVector1D: value = " + this.value;
    }
}
