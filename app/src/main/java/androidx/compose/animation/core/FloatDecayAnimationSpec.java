package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface FloatDecayAnimationSpec {
    float getAbsVelocityThreshold();

    long getDurationNanos(float f);

    float getTargetValue(float f, float f2);

    float getValueFromNanos(float f, float f2, long j);

    float getVelocityFromNanos(long j, float f);
}
