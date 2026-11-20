package androidx.compose.animation.core;

import coil3.memory.RealStrongMemoryCache$cache$1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InfiniteRepeatableSpec implements AnimationSpec {
    public final DurationBasedAnimationSpec animation;
    public final long initialStartOffset;
    public final RepeatMode repeatMode;

    public InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        this.animation = durationBasedAnimationSpec;
        this.repeatMode = repeatMode;
        this.initialStartOffset = j;
        if (durationBasedAnimationSpec instanceof TweenSpec) {
            TweenSpec tweenSpec = (TweenSpec) durationBasedAnimationSpec;
            if (tweenSpec.durationMillis != 0 || tweenSpec.delay != 0) {
                return;
            }
        } else if (durationBasedAnimationSpec instanceof SnapSpec) {
            if (((SnapSpec) durationBasedAnimationSpec).delay != 0) {
                return;
            }
        } else if (!(durationBasedAnimationSpec instanceof KeyframesSpec) || ((KeyframesSpec) durationBasedAnimationSpec).config.durationMillis != 0) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Animation to be infinitely repeated cannot have a 0-duration");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof InfiniteRepeatableSpec) {
            InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
            if (infiniteRepeatableSpec.animation.equals(this.animation) && infiniteRepeatableSpec.repeatMode == this.repeatMode && infiniteRepeatableSpec.initialStartOffset == this.initialStartOffset) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.initialStartOffset) + ((this.repeatMode.hashCode() + (this.animation.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpecVectorize = this.animation.vectorize(twoWayConverterImpl);
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = new RealStrongMemoryCache$cache$1();
        realStrongMemoryCache$cache$1.map = vectorizedDurationBasedAnimationSpecVectorize;
        realStrongMemoryCache$cache$1.this$0 = this.repeatMode;
        realStrongMemoryCache$cache$1.maxSize = ((long) (vectorizedDurationBasedAnimationSpecVectorize.getDurationMillis() + vectorizedDurationBasedAnimationSpecVectorize.getDelayMillis())) * 1000000;
        realStrongMemoryCache$cache$1.size = this.initialStartOffset * 1000000;
        return realStrongMemoryCache$cache$1;
    }
}
