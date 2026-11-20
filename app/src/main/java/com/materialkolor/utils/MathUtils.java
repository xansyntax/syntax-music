package com.materialkolor.utils;

import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MathUtils {
    public static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    public static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
    public static final double[] WHITE_POINT_D65 = {95.047d, 100.0d, 108.883d};

    public static int argbFromRgb(int i, int i2, int i3) {
        return ((i & 255) << 16) | (-16777216) | ((i2 & 255) << 8) | (i3 & 255);
    }

    public static int argbFromXyz(double d, double d2, double d3) {
        double[][] dArr = XYZ_TO_SRGB;
        double[] dArr2 = dArr[0];
        double d4 = (dArr2[2] * d3) + (dArr2[1] * d2) + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d5 = (dArr3[2] * d3) + (dArr3[1] * d2) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        return argbFromRgb(delinearized(d4), delinearized(d5), delinearized((dArr4[2] * d3) + (dArr4[1] * d2) + (dArr4[0] * d)));
    }

    public static int delinearized(double d) {
        double d2 = d / 100.0d;
        return (int) UuidKt.coerceIn(Math.rint((d2 <= 0.0031308d ? d2 * 12.92d : (Math.pow(d2, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0.0d, 255.0d);
    }

    public static double labF(double d) {
        return d > 0.008856451679035631d ? Math.pow(d, 0.3333333333333333d) : ((d * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] labFromArgb(int i) {
        double dLinearized = linearized((i >> 16) & 255);
        double dLinearized2 = linearized((i >> 8) & 255);
        double dLinearized3 = linearized(i & 255);
        double[][] dArr = SRGB_TO_XYZ;
        double[] dArr2 = dArr[0];
        double d = (dArr2[2] * dLinearized3) + (dArr2[1] * dLinearized2) + (dArr2[0] * dLinearized);
        double[] dArr3 = dArr[1];
        double d2 = (dArr3[2] * dLinearized3) + (dArr3[1] * dLinearized2) + (dArr3[0] * dLinearized);
        double[] dArr4 = dArr[2];
        double d3 = (dArr4[2] * dLinearized3) + (dArr4[1] * dLinearized2) + (dArr4[0] * dLinearized);
        double[] dArr5 = WHITE_POINT_D65;
        double d4 = d / dArr5[0];
        double d5 = d2 / dArr5[1];
        double d6 = d3 / dArr5[2];
        double dLabF = labF(d4);
        double dLabF2 = labF(d5);
        return new double[]{(116.0d * dLabF2) - 16.0d, (dLabF - dLabF2) * 500.0d, (dLabF2 - labF(d6)) * 200.0d};
    }

    public static double labInvf(double d) {
        double d2 = d * d * d;
        return d2 > 0.008856451679035631d ? d2 : ((116.0d * d) - 16.0d) / 903.2962962962963d;
    }

    public static double linearized(int i) {
        double d = ((double) i) / 255.0d;
        return (d <= 0.040449936d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d)) * 100.0d;
    }

    public static double lstarFromArgb(int i) {
        return (labF(xyzFromArgb(i)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        dArr.getClass();
        double d = dArr[0];
        double[] dArr3 = dArr2[0];
        double d2 = dArr3[0] * d;
        double d3 = dArr[1];
        double d4 = (dArr3[1] * d3) + d2;
        double d5 = dArr[2];
        double d6 = (dArr3[2] * d5) + d4;
        double[] dArr4 = dArr2[1];
        double d7 = (dArr4[2] * d5) + (dArr4[1] * d3) + (dArr4[0] * d);
        double[] dArr5 = dArr2[2];
        return new double[]{d6, d7, (d5 * dArr5[2]) + (d3 * dArr5[1]) + (d * dArr5[0])};
    }

    public static double[] xyzFromArgb(int i) {
        return matrixMultiply(new double[]{linearized((i >> 16) & 255), linearized((i >> 8) & 255), linearized(i & 255)}, SRGB_TO_XYZ);
    }

    public static double yFromLstar(double d) {
        return labInvf((d + 16.0d) / 116.0d) * 100.0d;
    }
}
