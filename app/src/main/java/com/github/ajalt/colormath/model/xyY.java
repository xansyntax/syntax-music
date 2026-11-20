package com.github.ajalt.colormath.model;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class xyY {
    public final float Y;
    public final float x;
    public final float y;

    public xyY(Double d, Double d2) {
        Double dValueOf = Double.valueOf(1.0d);
        float fFloatValue = d.floatValue();
        float fFloatValue2 = d2.floatValue();
        float fFloatValue3 = dValueOf.floatValue();
        this.x = fFloatValue;
        this.y = fFloatValue2;
        this.Y = fFloatValue3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xyY)) {
            return false;
        }
        xyY xyy = (xyY) obj;
        return Float.compare(this.x, xyy.x) == 0 && Float.compare(this.y, xyy.y) == 0 && Float.compare(this.Y, xyy.Y) == 0;
    }

    public final float getAbsoluteZ() {
        float f = 1.0f - this.x;
        float f2 = this.y;
        return ((f - f2) * this.Y) / f2;
    }

    public final int hashCode() {
        return Float.hashCode(this.Y) + IntIntPair$$ExternalSyntheticOutline0.m(this.y, Float.hashCode(this.x) * 31, 31);
    }

    public final String toString() {
        return "xyY(x=" + this.x + ", y=" + this.y + ", Y=" + this.Y + ')';
    }
}
