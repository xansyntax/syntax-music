package androidx.compose.animation.core;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnimationVector {
    public abstract float get$animation_core(int i);

    public int getSize$animation_core() {
        return 1;
    }

    public AnimationVector newVector$animation_core() {
        return new AnimationVector1D(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public abstract void reset$animation_core();

    public abstract void set$animation_core(int i, float f);
}
