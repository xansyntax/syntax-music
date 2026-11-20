package androidx.compose.animation.core;

import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VectorizedRepeatableSpec implements VectorizedFiniteAnimationSpec {
    public final VectorizedDurationBasedAnimationSpec animation;
    public final long durationNanos;
    public final long initialOffsetNanos;
    public final int iterations;
    public final RepeatMode repeatMode;

    public VectorizedRepeatableSpec(int i, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        this.iterations = i;
        this.animation = vectorizedDurationBasedAnimationSpec;
        this.repeatMode = repeatMode;
        if (i < 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Iterations count can't be less than 1");
            throw null;
        }
        this.durationNanos = ((long) (vectorizedDurationBasedAnimationSpec.getDurationMillis() + vectorizedDurationBasedAnimationSpec.getDelayMillis())) * 1000000;
        this.initialOffsetNanos = j * 1000000;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return (((long) this.iterations) * this.durationNanos) - this.initialOffsetNanos;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(j), animationVector, animationVector2, repetitionStartVelocity(j, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(j), animationVector, animationVector2, repetitionStartVelocity(j, animationVector, animationVector3, animationVector2));
    }

    public final long repetitionPlayTimeNanos(long j) {
        long j2 = this.initialOffsetNanos;
        if (j + j2 <= 0) {
            return 0L;
        }
        long j3 = j + j2;
        long j4 = this.durationNanos;
        long jMin = Math.min(j3 / j4, ((long) this.iterations) - 1);
        return (this.repeatMode == RepeatMode.Restart || jMin % 2 == 0) ? j3 - (jMin * j4) : ((jMin + 1) * j4) - j3;
    }

    public final AnimationVector repetitionStartVelocity(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j2 = this.initialOffsetNanos;
        long j3 = j + j2;
        long j4 = this.durationNanos;
        return j3 > j4 ? getVelocityFromNanos(j4 - j2, animationVector, animationVector2, animationVector3) : animationVector2;
    }
}
