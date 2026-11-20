package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlingCalculator implements FloatDecayAnimationSpec {
    public final float friction;
    public final float magicPhysicalCoefficient;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FlingInfo {
        public final float distance;
        public final long duration;
        public final float initialVelocity;

        public FlingInfo(float f, float f2, long j) {
            this.initialVelocity = f;
            this.distance = f2;
            this.duration = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) obj;
            return Float.compare(this.initialVelocity, flingInfo.initialVelocity) == 0 && Float.compare(this.distance, flingInfo.distance) == 0 && this.duration == flingInfo.duration;
        }

        public final int hashCode() {
            return Long.hashCode(this.duration) + IntIntPair$$ExternalSyntheticOutline0.m(this.distance, Float.hashCode(this.initialVelocity) * 31, 31);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("FlingInfo(initialVelocity=", this.initialVelocity, ", distance=", this.distance, ", duration="), this.duration, ")");
        }
    }

    public FlingCalculator(float f) {
        this.friction = Math.max(1.0E-7f, Math.abs(0.1f));
        this.magicPhysicalCoefficient = Math.max(1.0E-4f, f) * (-4.2f);
    }

    public FlingInfo flingInfo(float f) {
        double splineDeceleration = getSplineDeceleration(f);
        double d = FlingCalculatorKt.DecelerationRate;
        double d2 = d - 1.0d;
        return new FlingInfo(f, (float) (Math.exp((d / d2) * splineDeceleration) * ((double) (this.friction * this.magicPhysicalCoefficient))), (long) (Math.exp(splineDeceleration / d2) * 1000.0d));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.friction;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f) {
        return ((long) ((((float) Math.log(this.friction / Math.abs(f))) * 1000.0f) / this.magicPhysicalCoefficient)) * 1000000;
    }

    public double getSplineDeceleration(float f) {
        float[] fArr = AndroidFlingSpline.SplinePositions;
        return Math.log(((double) (Math.abs(f) * 0.35f)) / ((double) (this.friction * this.magicPhysicalCoefficient)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f, float f2) {
        float fAbs = Math.abs(f2);
        float f3 = this.friction;
        if (fAbs <= f3) {
            return f;
        }
        double dLog = Math.log(Math.abs(f3 / f2));
        float f4 = this.magicPhysicalCoefficient;
        return ((f2 / f4) * ((float) Math.exp((((double) f4) * ((dLog / ((double) f4)) * 1000.0d)) / 1000.0d))) + (f - (f2 / f4));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(float f, float f2, long j) {
        float f3 = this.magicPhysicalCoefficient;
        return ((f2 / f3) * ((float) Math.exp((f3 * (j / 1000000)) / 1000.0f))) + (f - (f2 / f3));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long j, float f) {
        return f * ((float) Math.exp(((j / 1000000) / 1000.0f) * this.magicPhysicalCoefficient));
    }

    public FlingCalculator(float f, Density density) {
        this.friction = f;
        float density2 = density.getDensity();
        float f2 = FlingCalculatorKt.DecelerationRate;
        this.magicPhysicalCoefficient = density2 * 386.0878f * 160.0f * 0.84f;
    }

    public FlingCalculator(float f, float f2, float f3, float f4) {
        this.friction = f3;
        this.magicPhysicalCoefficient = f4;
    }
}
