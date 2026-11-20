package com.materialkolor.hct;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.materialkolor.utils.MathUtils;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Hct {
    public static final Companion Companion = new Companion();
    public final int argb;
    public final double chroma;
    public final double hue;
    public final double tone;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
    }

    public Hct(int i) {
        this.argb = i;
        Cam16 cam16FromInt = HctSolver.fromInt(i);
        this.hue = cam16FromInt.hue;
        this.chroma = cam16FromInt.chroma;
        this.tone = MathUtils.lstarFromArgb(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Hct) && this.argb == ((Hct) obj).argb;
    }

    public final int hashCode() {
        return this.argb;
    }

    public final boolean isCyan() {
        double d = this.hue;
        return d >= 170.0d && d < 207.0d;
    }

    public final boolean isYellow() {
        double d = this.hue;
        return d >= 105.0d && d < 125.0d;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.argb, "Hct(argb=", ")");
    }
}
