package com.metrolist.music.eq.audio;

import com.metrolist.music.eq.data.FilterType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BiquadFilter {
    public double a1;
    public double a2;
    public double b0;
    public double b1;
    public double b2;
    public final double frequency;
    public final double gain;
    public final double q;
    public final int sampleRate;
    public double x1L;
    public double x1R;
    public double x2L;
    public double x2R;
    public double y1L;
    public double y1R;
    public double y2L;
    public double y2R;

    public BiquadFilter(int i, double d, double d2, double d3, FilterType filterType) {
        filterType.getClass();
        this.sampleRate = i;
        this.frequency = d;
        this.gain = d2;
        this.q = d3;
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            calculatePeakingCoefficients();
            return;
        }
        if (iOrdinal == 1) {
            double dSqrt = Math.sqrt(Math.pow(10.0d, d2 / 20.0d));
            double d4 = (d * 6.283185307179586d) / ((double) i);
            double dSin = Math.sin(d4);
            double dCos = Math.cos(d4);
            double d5 = dSqrt + 1.0d;
            double d6 = dSqrt - 1.0d;
            double dSqrt2 = Math.sqrt(dSqrt) * 2.0d * Math.sqrt((((1.0d / dSqrt) + dSqrt) * 0.0d) + 2.0d) * (dSin / 2.0d);
            double d7 = d6 * dCos;
            double d8 = d5 - d7;
            double d9 = dCos * d5;
            double d10 = d6 - d9;
            double d11 = d5 + d7;
            double d12 = d11 + dSqrt2;
            this.b0 = ((d8 + dSqrt2) * dSqrt) / d12;
            this.b1 = (d10 * (2.0d * dSqrt)) / d12;
            this.b2 = ((d8 - dSqrt2) * dSqrt) / d12;
            this.a1 = ((d6 + d9) * (-2.0d)) / d12;
            this.a2 = (d11 - dSqrt2) / d12;
            return;
        }
        if (iOrdinal != 2) {
            calculatePeakingCoefficients();
            return;
        }
        double dSqrt3 = Math.sqrt(Math.pow(10.0d, d2 / 20.0d));
        double d13 = (d * 6.283185307179586d) / ((double) i);
        double dSin2 = Math.sin(d13);
        double dCos2 = Math.cos(d13);
        double d14 = dSqrt3 + 1.0d;
        double d15 = dSqrt3 - 1.0d;
        double dSqrt4 = Math.sqrt(dSqrt3) * 2.0d * Math.sqrt((((1.0d / dSqrt3) + dSqrt3) * 0.0d) + 2.0d) * (dSin2 / 2.0d);
        double d16 = d15 * dCos2;
        double d17 = d14 + d16;
        double d18 = dCos2 * d14;
        double d19 = d15 + d18;
        double d20 = d14 - d16;
        double d21 = d20 + dSqrt4;
        this.b0 = ((d17 + dSqrt4) * dSqrt3) / d21;
        this.b1 = (d19 * (dSqrt3 * (-2.0d))) / d21;
        this.b2 = ((d17 - dSqrt4) * dSqrt3) / d21;
        this.a1 = ((d15 - d18) * 2.0d) / d21;
        this.a2 = (d20 - dSqrt4) / d21;
    }

    public final void calculatePeakingCoefficients() {
        double dPow = Math.pow(10.0d, this.gain / 40.0d);
        double d = (this.frequency * 6.283185307179586d) / ((double) this.sampleRate);
        double dSin = Math.sin(d);
        double dCos = Math.cos(d);
        double d2 = dSin / (this.q * 2.0d);
        double d3 = d2 * dPow;
        double d4 = d2 / dPow;
        double d5 = d4 + 1.0d;
        this.b0 = (d3 + 1.0d) / d5;
        double d6 = (dCos * (-2.0d)) / d5;
        this.b1 = d6;
        this.b2 = (1.0d - d3) / d5;
        this.a1 = d6;
        this.a2 = (1.0d - d4) / d5;
    }

    public final void reset() {
        this.x1L = 0.0d;
        this.x2L = 0.0d;
        this.y1L = 0.0d;
        this.y2L = 0.0d;
        this.x1R = 0.0d;
        this.x2R = 0.0d;
        this.y1R = 0.0d;
        this.y2R = 0.0d;
    }
}
