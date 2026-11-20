package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RepeatableSpec implements FiniteAnimationSpec {
    public final TweenSpec animation;
    public final long initialStartOffset;
    public final int iterations;
    public final RepeatMode repeatMode;

    public RepeatableSpec(int i, TweenSpec tweenSpec, RepeatMode repeatMode, long j) {
        this.iterations = i;
        this.animation = tweenSpec;
        this.repeatMode = repeatMode;
        this.initialStartOffset = j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof RepeatableSpec) {
            RepeatableSpec repeatableSpec = (RepeatableSpec) obj;
            if (repeatableSpec.iterations == this.iterations && repeatableSpec.animation.equals(this.animation) && repeatableSpec.repeatMode == this.repeatMode && repeatableSpec.initialStartOffset == this.initialStartOffset) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.initialStartOffset) + ((this.repeatMode.hashCode() + ((this.animation.hashCode() + (this.iterations * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new VectorizedRepeatableSpec(this.iterations, this.animation.vectorize(twoWayConverterImpl), this.repeatMode, this.initialStartOffset);
    }
}
