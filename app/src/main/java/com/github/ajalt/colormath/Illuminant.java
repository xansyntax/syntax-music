package com.github.ajalt.colormath;

import com.github.ajalt.colormath.model.xyY;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Illuminant {
    public static final WhitePoint D50;
    public static final WhitePoint D65;

    static {
        Double dValueOf = Double.valueOf(0.3333333333333333d);
        Double dValueOf2 = Double.valueOf(1.0d);
        Double dValueOf3 = Double.valueOf(0.44758d);
        Double dValueOf4 = Double.valueOf(0.40745d);
        dValueOf3.floatValue();
        dValueOf4.floatValue();
        dValueOf2.floatValue();
        Double dValueOf5 = Double.valueOf(0.34842d);
        Double dValueOf6 = Double.valueOf(0.35161d);
        dValueOf5.floatValue();
        dValueOf6.floatValue();
        dValueOf2.floatValue();
        Double dValueOf7 = Double.valueOf(0.31006d);
        Double dValueOf8 = Double.valueOf(0.31616d);
        dValueOf7.floatValue();
        dValueOf8.floatValue();
        dValueOf2.floatValue();
        D50 = new WhitePoint("D50", new xyY(Double.valueOf(0.3457d), Double.valueOf(0.3585d)));
        Double dValueOf9 = Double.valueOf(0.33243d);
        Double dValueOf10 = Double.valueOf(0.34744d);
        dValueOf9.floatValue();
        dValueOf10.floatValue();
        dValueOf2.floatValue();
        D65 = new WhitePoint("D65", new xyY(Double.valueOf(0.3127d), Double.valueOf(0.329d)));
        Double dValueOf11 = Double.valueOf(0.29903d);
        Double dValueOf12 = Double.valueOf(0.31488d);
        dValueOf11.floatValue();
        dValueOf12.floatValue();
        dValueOf2.floatValue();
        dValueOf.floatValue();
        dValueOf.floatValue();
        dValueOf2.floatValue();
    }
}
