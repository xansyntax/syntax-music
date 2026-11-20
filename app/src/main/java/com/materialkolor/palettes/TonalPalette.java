package com.materialkolor.palettes;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.utils.MathUtils;
import java.util.HashMap;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TonalPalette {
    public static final Companion Companion = new Companion();
    public final HashMap cache = new HashMap();
    public final double chroma;
    public final double hue;
    public final Hct keyColor;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static TonalPalette fromHueAndChroma(double d, double d2) {
            Hct hct;
            KeyColor keyColor = new KeyColor(d, d2);
            int i = 100;
            int i2 = 0;
            while (i2 < i) {
                int i3 = (i2 + i) / 2;
                int i4 = i3 + 1;
                boolean z = keyColor.maxChroma(i3) < keyColor.maxChroma(i4);
                if (keyColor.maxChroma(i3) >= keyColor.requestedChroma - 0.01d) {
                    if (Math.abs(i2 - 50) < Math.abs(i - 50)) {
                        i = i3;
                    } else {
                        if (i2 == i3) {
                            hct = new Hct(HctSolver.solveToInt(keyColor.hue, keyColor.requestedChroma, i2));
                            return new TonalPalette(d, d2, hct);
                        }
                        i2 = i3;
                    }
                } else if (z) {
                    i2 = i4;
                } else {
                    i = i3;
                }
            }
            hct = new Hct(HctSolver.solveToInt(keyColor.hue, keyColor.requestedChroma, i2));
            return new TonalPalette(d, d2, hct);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeyColor {
        public final HashMap chromaCache = new HashMap();
        public final double hue;
        public final double requestedChroma;

        public KeyColor(double d, double d2) {
            this.hue = d;
            this.requestedChroma = d2;
        }

        public final double maxChroma(int i) {
            Integer numValueOf = Integer.valueOf(i);
            HashMap map = this.chromaCache;
            Object objValueOf = map.get(numValueOf);
            if (objValueOf == null) {
                int iSolveToInt = HctSolver.solveToInt(this.hue, 200.0d, i);
                double d = HctSolver.fromInt(iSolveToInt).chroma;
                MathUtils.lstarFromArgb(iSolveToInt);
                objValueOf = Double.valueOf(d);
                map.put(numValueOf, objValueOf);
            }
            return ((Number) objValueOf).doubleValue();
        }
    }

    public TonalPalette(double d, double d2, Hct hct) {
        this.hue = d;
        this.chroma = d2;
        this.keyColor = hct;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TonalPalette)) {
            return false;
        }
        TonalPalette tonalPalette = (TonalPalette) obj;
        return Double.compare(this.hue, tonalPalette.hue) == 0 && Double.compare(this.chroma, tonalPalette.chroma) == 0 && this.keyColor.equals(tonalPalette.keyColor);
    }

    public final Hct getHct(double d) {
        if (d == 99.0d) {
            double d2 = this.hue;
            if (d2 >= 105.0d && d2 < 125.0d) {
                return new Hct(tone(99));
            }
        }
        return new Hct(HctSolver.solveToInt(this.hue, this.chroma, d));
    }

    public final int hashCode() {
        return Fragment$5$$ExternalSyntheticOutline0.m(this.chroma, Double.hashCode(this.hue) * 31, 31) + this.keyColor.argb;
    }

    public final String toString() {
        return "TonalPalette(hue=" + this.hue + ", chroma=" + this.chroma + ", keyColor=" + this.keyColor + ")";
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0076  */
    public final int tone(int i) {
        Integer numValueOf;
        Integer numValueOf2 = Integer.valueOf(i);
        HashMap map = this.cache;
        Integer num = (Integer) map.get(numValueOf2);
        if (num != null) {
            return num.intValue();
        }
        if (i == 99) {
            double d = this.hue;
            if (d < 105.0d || d >= 125.0d) {
                int iSolveToInt = HctSolver.solveToInt(this.hue, this.chroma, i);
                HctSolver.fromInt(iSolveToInt);
                MathUtils.lstarFromArgb(iSolveToInt);
                numValueOf = Integer.valueOf(iSolveToInt);
            } else {
                int neVar = tone(98);
                int neVar2 = tone(100);
                numValueOf = Integer.valueOf((MathKt.roundToInt(((neVar & 255) + (neVar2 & 255)) / 2.0f) & 255) | ((MathKt.roundToInt((((neVar >>> 16) & 255) + ((neVar2 >>> 16) & 255)) / 2.0f) & 255) << 16) | (-16777216) | ((MathKt.roundToInt((((neVar >>> 8) & 255) + ((neVar2 >>> 8) & 255)) / 2.0f) & 255) << 8));
            }
        } else {
            int iSolveToInt2 = HctSolver.solveToInt(this.hue, this.chroma, i);
            HctSolver.fromInt(iSolveToInt2);
            MathUtils.lstarFromArgb(iSolveToInt2);
            numValueOf = Integer.valueOf(iSolveToInt2);
        }
        map.put(Integer.valueOf(i), numValueOf);
        return numValueOf.intValue();
    }
}
