package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DecayAnimation implements Animation {
    public final VectorizedFloatDecaySpec animationSpec;
    public final long durationNanos;
    public final AnimationVector endVelocity;
    public final Object initialValue;
    public final AnimationVector initialValueVector;
    public final AnimationVector initialVelocityVector;
    public final Object targetValue;
    public final TwoWayConverterImpl typeConverter;

    public DecayAnimation(DecayAnimationSpecImpl decayAnimationSpecImpl, TwoWayConverterImpl twoWayConverterImpl, Object obj, AnimationVector animationVector) {
        VectorizedFloatDecaySpec vectorizedFloatDecaySpec = new VectorizedFloatDecaySpec(decayAnimationSpecImpl.floatDecaySpec);
        this.animationSpec = vectorizedFloatDecaySpec;
        this.typeConverter = twoWayConverterImpl;
        this.initialValue = obj;
        AnimationVector animationVector2 = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj);
        this.initialValueVector = animationVector2;
        this.initialVelocityVector = ArcSplineKt.copy(animationVector);
        Function1 function1 = twoWayConverterImpl.convertFromVector;
        AnimationVector animationVectorNewVector$animation_core = vectorizedFloatDecaySpec.targetVector;
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = animationVector2.newVector$animation_core();
            vectorizedFloatDecaySpec.targetVector = animationVectorNewVector$animation_core;
        }
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        int i = 0;
        while (true) {
            AnimationVector animationVector3 = vectorizedFloatDecaySpec.targetVector;
            FloatDecayAnimationSpec floatDecayAnimationSpec = vectorizedFloatDecaySpec.floatDecaySpec;
            if (i >= size$animation_core) {
                if (animationVector3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                    throw null;
                }
                this.targetValue = function1.invoke(animationVector3);
                AnimationVector animationVectorNewVector$animation_core2 = vectorizedFloatDecaySpec.velocityVector;
                if (animationVectorNewVector$animation_core2 == null) {
                    animationVectorNewVector$animation_core2 = animationVector2.newVector$animation_core();
                    vectorizedFloatDecaySpec.velocityVector = animationVectorNewVector$animation_core2;
                }
                int size$animation_core2 = animationVectorNewVector$animation_core2.getSize$animation_core();
                long jMax = 0;
                for (int i2 = 0; i2 < size$animation_core2; i2++) {
                    animationVector2.getClass();
                    jMax = Math.max(jMax, floatDecayAnimationSpec.getDurationNanos(animationVector.get$animation_core(i2)));
                }
                this.durationNanos = jMax;
                AnimationVector animationVectorCopy = ArcSplineKt.copy(this.animationSpec.getVelocityFromNanos(jMax, this.initialValueVector, animationVector));
                this.endVelocity = animationVectorCopy;
                int size$animation_core3 = animationVectorCopy.getSize$animation_core();
                for (int i3 = 0; i3 < size$animation_core3; i3++) {
                    AnimationVector animationVector4 = this.endVelocity;
                    float f = animationVector4.get$animation_core(i3);
                    float f2 = this.animationSpec.absVelocityThreshold;
                    animationVector4.set$animation_core(i3, UuidKt.coerceIn(f, -f2, f2));
                }
                return;
            }
            if (animationVector3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                throw null;
            }
            animationVector3.set$animation_core(i, floatDecayAnimationSpec.getTargetValue(animationVector2.get$animation_core(i), animationVector.get$animation_core(i)));
            i++;
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public final long getDurationNanos() {
        return this.durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public final Object getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public final TwoWayConverterImpl getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public final Object getValueFromNanos(long j) {
        if (isFinishedFromNanos(j)) {
            return this.targetValue;
        }
        Function1 function1 = this.typeConverter.convertFromVector;
        VectorizedFloatDecaySpec vectorizedFloatDecaySpec = this.animationSpec;
        AnimationVector animationVectorNewVector$animation_core = vectorizedFloatDecaySpec.valueVector;
        AnimationVector animationVector = this.initialValueVector;
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = animationVector.newVector$animation_core();
            vectorizedFloatDecaySpec.valueVector = animationVectorNewVector$animation_core;
        }
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        int i = 0;
        while (true) {
            AnimationVector animationVector2 = vectorizedFloatDecaySpec.valueVector;
            if (i >= size$animation_core) {
                if (animationVector2 != null) {
                    return function1.invoke(animationVector2);
                }
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            if (animationVector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            animationVector2.set$animation_core(i, vectorizedFloatDecaySpec.floatDecaySpec.getValueFromNanos(animationVector.get$animation_core(i), this.initialVelocityVector.get$animation_core(i), j));
            i++;
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public final AnimationVector getVelocityVectorFromNanos(long j) {
        if (isFinishedFromNanos(j)) {
            return this.endVelocity;
        }
        return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.initialVelocityVector);
    }

    @Override // androidx.compose.animation.core.Animation
    public final boolean isInfinite() {
        return false;
    }
}
