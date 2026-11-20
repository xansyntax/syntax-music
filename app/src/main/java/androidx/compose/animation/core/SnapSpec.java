package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapSpec implements DurationBasedAnimationSpec {
    public final byte delay;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapSpec(int i) {
        this.delay = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof SnapSpec) && ((SnapSpec) obj).delay == this.delay;
    }

    public final int hashCode() {
        return this.delay;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new VectorizedSnapSpec(this.delay);
    }
}
