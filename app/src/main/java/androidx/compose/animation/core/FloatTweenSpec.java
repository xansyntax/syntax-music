package androidx.compose.animation.core;

import androidx.media3.common.Format;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatTweenSpec implements FloatAnimationSpec {
    public final long delayNanos;
    public final int duration;
    public final long durationNanos;
    public final Object easing;

    public FloatTweenSpec(int i, int i2, Easing easing) {
        this.duration = i;
        this.easing = easing;
        this.durationNanos = ((long) i) * 1000000;
        this.delayNanos = ((long) i2) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float f, float f2, float f3) {
        return this.delayNanos + this.durationNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(float f, float f2, float f3, long j) {
        long j2 = j - this.delayNanos;
        if (j2 < 0) {
            j2 = 0;
        }
        long j3 = this.durationNanos;
        if (j2 > j3) {
            j2 = j3;
        }
        float fTransform = ((Easing) this.easing).transform(this.duration == 0 ? 1.0f : j2 / j3);
        return (f2 * fTransform) + ((1.0f - fTransform) * f);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(float f, float f2, float f3, long j) {
        long j2 = j - this.delayNanos;
        if (j2 < 0) {
            j2 = 0;
        }
        long j3 = this.durationNanos;
        long j4 = j2 > j3 ? j3 : j2;
        if (j4 == 0) {
            return f3;
        }
        return (getValueFromNanos(f, f2, f3, j4) - getValueFromNanos(f, f2, f3, j4 - 1000000)) * 1000.0f;
    }

    public FloatTweenSpec(int i, Format format, long j, long j2) {
        this.duration = i;
        this.easing = format;
        this.durationNanos = j;
        this.delayNanos = j2;
    }
}
