package androidx.compose.animation.core;

import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface FloatAnimationSpec extends AnimationSpec {
    long getDurationNanos(float f, float f2, float f3);

    default float getEndVelocity(float f, float f2, float f3) {
        return getVelocityFromNanos(f, f2, f3, getDurationNanos(f, f2, f3));
    }

    float getValueFromNanos(float f, float f2, float f3, long j);

    float getVelocityFromNanos(float f, float f2, float f3, long j);

    @Override // androidx.compose.animation.core.AnimationSpec
    default VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new Dispatcher(this);
    }
}
