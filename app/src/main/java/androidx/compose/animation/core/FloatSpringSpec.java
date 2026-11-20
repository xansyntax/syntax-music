package androidx.compose.animation.core;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatSpringSpec implements FloatAnimationSpec {
    public final SpringSimulation spring;
    public final float visibilityThreshold;

    public FloatSpringSpec(float f, float f2, float f3) {
        this.visibilityThreshold = f3;
        SpringSimulation springSimulation = new SpringSimulation();
        springSimulation.finalPosition = 1.0f;
        springSimulation.naturalFreq = Math.sqrt(50.0d);
        springSimulation.dampingRatio = 1.0f;
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
        }
        springSimulation.dampingRatio = f;
        double d = springSimulation.naturalFreq;
        if (((float) (d * d)) <= CropImageView.DEFAULT_ASPECT_RATIO) {
            PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
        }
        springSimulation.naturalFreq = Math.sqrt(f2);
        this.spring = springSimulation;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final long getDurationNanos(float f, float f2, float f3) {
        double d;
        double dLog;
        long j;
        double d2;
        SpringSimulation springSimulation = this.spring;
        double d3 = springSimulation.naturalFreq;
        float f4 = (float) (d3 * d3);
        float f5 = springSimulation.dampingRatio;
        float f6 = this.visibilityThreshold;
        float f7 = (f - f2) / f6;
        float f8 = f3 / f6;
        if (f5 == CropImageView.DEFAULT_ASPECT_RATIO) {
            j = 9223372036854L;
        } else {
            double d4 = f4;
            double d5 = f5;
            double d6 = f8;
            double d7 = f7;
            double dSqrt = Math.sqrt(d4) * d5 * 2.0d;
            double d8 = (dSqrt * dSqrt) - (d4 * 4.0d);
            double dSqrt2 = d8 < 0.0d ? 0.0d : Math.sqrt(d8);
            double d9 = -dSqrt;
            double d10 = (d9 + dSqrt2) * 0.5d;
            double dSqrt3 = (d8 < 0.0d ? Math.sqrt(Math.abs(d8)) : 0.0d) * 0.5d;
            double d11 = (d9 - dSqrt2) * 0.5d;
            if (d7 == 0.0d && d6 == 0.0d) {
                j = 0;
            } else {
                if (d7 < 0.0d) {
                    d6 = -d6;
                }
                double d12 = d6;
                double dAbs = Math.abs(d7);
                double dAbs2 = Double.MAX_VALUE;
                if (d5 > 1.0d) {
                    double d13 = d10 - d11;
                    double d14 = ((d10 * dAbs) - d12) / d13;
                    double d15 = dAbs - d14;
                    dLog = Math.log(Math.abs(1.0d / d15)) / d10;
                    double dLog2 = Math.log(Math.abs(1.0d / d14)) / d11;
                    if ((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) >= 9218868437227405312L) {
                        dLog = dLog2;
                    } else if ((Double.doubleToRawLongBits(dLog2) & Long.MAX_VALUE) < 9218868437227405312L) {
                        dLog = Math.max(dLog, dLog2);
                    }
                    double d16 = d15 * d10;
                    double dLog3 = Math.log(d16 / ((-d14) * d11)) / (d11 - d10);
                    if (Double.isNaN(dLog3) || dLog3 <= 0.0d) {
                        d2 = -1.0d;
                    } else {
                        if (dLog3 > 0.0d) {
                            if ((-((Math.exp(dLog3 * d11) * d14) + (Math.exp(d10 * dLog3) * d15))) < 1.0d) {
                                if (d14 > 0.0d && d15 < 0.0d) {
                                    dLog = 0.0d;
                                }
                                d2 = -1.0d;
                            }
                        }
                        dLog = Math.log((-((d14 * d11) * d11)) / (d16 * d10)) / d13;
                        d2 = 1.0d;
                    }
                    double d17 = d14 * d11;
                    if (Math.abs((Math.exp(d11 * dLog) * d17) + (Math.exp(d10 * dLog) * d16)) >= 1.0E-4d) {
                        int i = 0;
                        while (dAbs2 > 0.001d && i < 100) {
                            i++;
                            double d18 = d10 * dLog;
                            double d19 = d11 * dLog;
                            double dExp = dLog - ((((Math.exp(d19) * d14) + (Math.exp(d18) * d15)) + d2) / ((Math.exp(d19) * d17) + (Math.exp(d18) * d16)));
                            dAbs2 = Math.abs(dLog - dExp);
                            dLog = dExp;
                        }
                    }
                } else if (d5 < 1.0d) {
                    double dM = IntIntPair$$ExternalSyntheticOutline0.m(d10, dAbs, d12, dSqrt3);
                    dLog = Math.log(1.0d / Math.sqrt((dM * dM) + (dAbs * dAbs))) / d10;
                } else {
                    double d20 = d10 * dAbs;
                    double d21 = d12 - d20;
                    double dLog4 = Math.log(Math.abs(1.0d / dAbs)) / d10;
                    double dLog5 = Math.log(Math.abs(1.0d / d21));
                    double dLog6 = dLog5;
                    for (int i2 = 0; i2 < 6; i2++) {
                        dLog6 = dLog5 - Math.log(Math.abs(dLog6 / d10));
                    }
                    double d22 = dLog6 / d10;
                    if ((Double.doubleToRawLongBits(dLog4) & Long.MAX_VALUE) >= 9218868437227405312L) {
                        dLog4 = d22;
                    } else if ((Double.doubleToRawLongBits(d22) & Long.MAX_VALUE) < 9218868437227405312L) {
                        dLog4 = Math.max(dLog4, d22);
                    }
                    double d23 = (-(d20 + d21)) / (d10 * d21);
                    double d24 = d10 * d23;
                    double dExp2 = (Math.exp(d24) * d21 * d23) + (Math.exp(d24) * dAbs);
                    if (Double.isNaN(d23) || d23 <= 0.0d) {
                        d = -1.0d;
                    } else if (d23 <= 0.0d || (-dExp2) >= 1.0d) {
                        dLog4 = (-(2.0d / d10)) - (dAbs / d21);
                        d = 1.0d;
                    } else {
                        dLog4 = (d21 >= 0.0d || dAbs <= 0.0d) ? dLog4 : 0.0d;
                        d = -1.0d;
                    }
                    dLog = dLog4;
                    int i3 = 0;
                    while (dAbs2 > 0.001d && i3 < 100) {
                        i3++;
                        double d25 = d10 * dLog;
                        double dExp3 = dLog - (((Math.exp(d25) * ((d21 * dLog) + dAbs)) + d) / (Math.exp(d25) * (((d25 + 1.0d) * d21) + d20)));
                        dAbs2 = Math.abs(dLog - dExp3);
                        dLog = dExp3;
                    }
                }
                j = (long) (dLog * 1000.0d);
            }
        }
        return j * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getEndVelocity(float f, float f2, float f3) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getValueFromNanos(float f, float f2, float f3, long j) {
        SpringSimulation springSimulation = this.spring;
        springSimulation.finalPosition = f2;
        return Float.intBitsToFloat((int) (springSimulation.m20updateValuesIJZedt4$animation_core(f, f3, j / 1000000) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getVelocityFromNanos(float f, float f2, float f3, long j) {
        SpringSimulation springSimulation = this.spring;
        springSimulation.finalPosition = f2;
        return Float.intBitsToFloat((int) (springSimulation.m20updateValuesIJZedt4$animation_core(f, f3, j / 1000000) & 4294967295L));
    }

    public /* synthetic */ FloatSpringSpec(float f, float f2) {
        this(f, f2, 0.01f);
    }
}
