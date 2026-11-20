package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface VectorizedDurationBasedAnimationSpec extends VectorizedFiniteAnimationSpec {
    int getDelayMillis();

    int getDurationMillis();

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    default long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((long) (getDurationMillis() + getDelayMillis())) * 1000000;
    }
}
