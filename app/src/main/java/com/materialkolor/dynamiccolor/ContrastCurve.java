package com.materialkolor.dynamiccolor;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContrastCurve {
    public final double high;
    public final double low;
    public final double medium;
    public final double normal;

    public ContrastCurve(double d, double d2, double d3, double d4) {
        this.low = d;
        this.normal = d2;
        this.medium = d3;
        this.high = d4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContrastCurve)) {
            return false;
        }
        ContrastCurve contrastCurve = (ContrastCurve) obj;
        return Double.compare(this.low, contrastCurve.low) == 0 && Double.compare(this.normal, contrastCurve.normal) == 0 && Double.compare(this.medium, contrastCurve.medium) == 0 && Double.compare(this.high, contrastCurve.high) == 0;
    }

    public final double get(double d) {
        double d2;
        double d3;
        double d4 = this.low;
        if (d <= -1.0d) {
            return d4;
        }
        double d5 = this.normal;
        if (d < 0.0d) {
            double d6 = (d - (-1.0d)) / 1.0d;
            d2 = (1.0d - d6) * d4;
            d3 = d6 * d5;
        } else {
            double d7 = this.medium;
            if (d < 0.5d) {
                double d8 = (d - 0.0d) / 0.5d;
                d2 = (1.0d - d8) * d5;
                d3 = d8 * d7;
            } else {
                double d9 = this.high;
                if (d >= 1.0d) {
                    return d9;
                }
                double d10 = (d - 0.5d) / 0.5d;
                d2 = (1.0d - d10) * d7;
                d3 = d10 * d9;
            }
        }
        return d3 + d2;
    }

    public final int hashCode() {
        return Double.hashCode(this.high) + Fragment$5$$ExternalSyntheticOutline0.m(this.medium, Fragment$5$$ExternalSyntheticOutline0.m(this.normal, Double.hashCode(this.low) * 31, 31), 31);
    }

    public final String toString() {
        return "ContrastCurve(low=" + this.low + ", normal=" + this.normal + ", medium=" + this.medium + ", high=" + this.high + ")";
    }
}
