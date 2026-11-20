package com.github.ajalt.colormath.model;

import com.github.ajalt.colormath.Illuminant;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class XYZColorSpaces {
    public static final XYZColorSpaceImpl XYZ65 = new XYZColorSpaceImpl(Illuminant.D65);
    public static final XYZColorSpaceImpl XYZ50 = new XYZColorSpaceImpl(Illuminant.D50);
}
