package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VectorizedFloatDecaySpec {
    public final float absVelocityThreshold;
    public final FloatDecayAnimationSpec floatDecaySpec;
    public AnimationVector targetVector;
    public AnimationVector valueVector;
    public AnimationVector velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    public final AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2) {
        AnimationVector animationVectorNewVector$animation_core = this.velocityVector;
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = animationVector.newVector$animation_core();
            this.velocityVector = animationVectorNewVector$animation_core;
        }
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        int i = 0;
        while (true) {
            AnimationVector animationVector3 = this.velocityVector;
            if (i >= size$animation_core) {
                if (animationVector3 != null) {
                    return animationVector3;
                }
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            if (animationVector3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            animationVector.getClass();
            animationVector3.set$animation_core(i, this.floatDecaySpec.getVelocityFromNanos(j, animationVector2.get$animation_core(i)));
            i++;
        }
    }
}
