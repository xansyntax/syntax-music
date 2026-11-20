package com.metrolist.music.ui.screens.equalizer;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BiquadCoeffs {
    public final double a1;
    public final double a2;
    public final double b0;
    public final double b1;
    public final double b2;

    public BiquadCoeffs(double d, double d2, double d3, double d4, double d5) {
        this.b0 = d;
        this.b1 = d2;
        this.b2 = d3;
        this.a1 = d4;
        this.a2 = d5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiquadCoeffs)) {
            return false;
        }
        BiquadCoeffs biquadCoeffs = (BiquadCoeffs) obj;
        return Double.compare(this.b0, biquadCoeffs.b0) == 0 && Double.compare(this.b1, biquadCoeffs.b1) == 0 && Double.compare(this.b2, biquadCoeffs.b2) == 0 && Double.compare(this.a1, biquadCoeffs.a1) == 0 && Double.compare(this.a2, biquadCoeffs.a2) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.a2) + Fragment$5$$ExternalSyntheticOutline0.m(this.a1, Fragment$5$$ExternalSyntheticOutline0.m(this.b2, Fragment$5$$ExternalSyntheticOutline0.m(this.b1, Double.hashCode(this.b0) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "BiquadCoeffs(b0=" + this.b0 + ", b1=" + this.b1 + ", b2=" + this.b2 + ", a1=" + this.a1 + ", a2=" + this.a2 + ")";
    }
}
