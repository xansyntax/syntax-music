package com.materialkolor.hct;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Cam16 {
    public final double astar;
    public final double bstar;
    public final double chroma;
    public final double hue;
    public final double jstar;
    public static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    public static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    public Cam16(double d, double d2, double d3, double d4, double d5, double d6) {
        this.hue = d;
        this.chroma = d2;
        this.jstar = d4;
        this.astar = d5;
        this.bstar = d6;
    }
}
