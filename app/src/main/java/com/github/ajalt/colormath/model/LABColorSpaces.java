package com.github.ajalt.colormath.model;

import com.github.ajalt.colormath.Illuminant;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LABColorSpaces {
    public static final LABColorSpaceImpl LAB50;

    static {
        new LABColorSpaceImpl(Illuminant.D65);
        LAB50 = new LABColorSpaceImpl(Illuminant.D50);
    }
}
