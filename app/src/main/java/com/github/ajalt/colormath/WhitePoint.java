package com.github.ajalt.colormath;

import com.github.ajalt.colormath.model.xyY;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WhitePoint {
    public final xyY chromaticity;
    public final String name;

    public WhitePoint(String str, xyY xyy) {
        this.name = str;
        this.chromaticity = xyy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) obj;
        return this.name.equals(whitePoint.name) && this.chromaticity.equals(whitePoint.chromaticity);
    }

    public final int hashCode() {
        return this.chromaticity.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return this.name;
    }
}
