package com.github.ajalt.colormath.model;

import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import com.github.ajalt.colormath.WhitePoint;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RGBColorSpacesKt {
    public static final xyY SRGB_R = new xyY(Double.valueOf(0.64d), Double.valueOf(0.33d));
    public static final xyY SRGB_G = new xyY(Double.valueOf(0.3d), Double.valueOf(0.6d));
    public static final xyY SRGB_B = new xyY(Double.valueOf(0.15d), Double.valueOf(0.06d));
    public static final WhitePoint ACES_WHITE_POINT = new WhitePoint("ACES", new xyY(Double.valueOf(0.32168d), Double.valueOf(0.33767d)));
    public static final xyY ACES_AP0_R = new xyY(Double.valueOf(0.7347d), Double.valueOf(0.2653d));
    public static final xyY ACES_AP0_G = new xyY(Double.valueOf(0.0d), Double.valueOf(1.0d));
    public static final xyY ACES_AP0_B = new xyY(Double.valueOf(1.0E-4d), Double.valueOf(-0.077d));
    public static final xyY ACES_AP1_R = new xyY(Double.valueOf(0.713d), Double.valueOf(0.293d));
    public static final xyY ACES_AP1_G = new xyY(Double.valueOf(0.165d), Double.valueOf(0.83d));
    public static final xyY ACES_AP1_B = new xyY(Double.valueOf(0.128d), Double.valueOf(0.044d));

    public static final RGBColorSpaceImpl RGBColorSpace(String str, WhitePoint whitePoint, RGBColorSpace.TransferFunctions transferFunctions, xyY xyy, xyY xyy2, xyY xyy3) {
        whitePoint.getClass();
        xyy.getClass();
        xyy2.getClass();
        xyy3.getClass();
        return new RGBColorSpaceImpl(str, whitePoint, transferFunctions, xyy, xyy2, xyy3, new SaversKt$$ExternalSyntheticLambda5((byte) 26));
    }
}
