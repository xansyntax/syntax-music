package com.github.ajalt.colormath.model;

import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import com.github.ajalt.colormath.Illuminant;
import com.github.ajalt.colormath.WhitePoint;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RGBColorSpaces {
    public static final RGBColorSpaceImpl ACES;
    public static final RGBColorSpaceImpl ACEScg;
    public static final RGBColorSpaceImpl AdobeRGB;
    public static final RGBColorSpaceImpl BT2020;
    public static final RGBColorSpaceImpl BT709;
    public static final RGBColorSpaceImpl DCI_P3;
    public static final RGBColorSpaceImpl DisplayP3;
    public static final RGBColorSpaceImpl LinearSRGB;
    public static final RGBColorSpaceImpl ROMM_RGB;
    public static final RGBColorSpaceImpl SRGB;

    static {
        WhitePoint whitePoint = Illuminant.D65;
        HSL.Companion companion = HSL.Companion.INSTANCE$2;
        xyY xyy = RGBColorSpacesKt.SRGB_R;
        xyY xyy2 = RGBColorSpacesKt.SRGB_G;
        xyY xyy3 = RGBColorSpacesKt.SRGB_B;
        SRGB = new RGBColorSpaceImpl("sRGB", whitePoint, companion, xyy, xyy2, xyy3, new SaversKt$$ExternalSyntheticLambda5((byte) 24));
        HSL.Companion companion2 = HSL.Companion.INSTANCE;
        LinearSRGB = RGBColorSpacesKt.RGBColorSpace("Linear sRGB", whitePoint, companion2, xyy, xyy2, xyy3);
        WhitePoint whitePoint2 = RGBColorSpacesKt.ACES_WHITE_POINT;
        ACES = RGBColorSpacesKt.RGBColorSpace("ACES2065-1", whitePoint2, companion2, RGBColorSpacesKt.ACES_AP0_R, RGBColorSpacesKt.ACES_AP0_G, RGBColorSpacesKt.ACES_AP0_B);
        ACESccTransferFunctions aCESccTransferFunctions = ACESccTransferFunctions.INSTANCE;
        xyY xyy4 = RGBColorSpacesKt.ACES_AP1_R;
        xyY xyy5 = RGBColorSpacesKt.ACES_AP1_G;
        xyY xyy6 = RGBColorSpacesKt.ACES_AP1_B;
        RGBColorSpacesKt.RGBColorSpace("ACEScc", whitePoint2, aCESccTransferFunctions, xyy4, xyy5, xyy6);
        RGBColorSpacesKt.RGBColorSpace("ACEScct", whitePoint2, ACEScctTransferFunctions.INSTANCE, xyy4, xyy5, xyy6);
        ACEScg = RGBColorSpacesKt.RGBColorSpace("ACEScg", whitePoint2, companion2, xyy4, xyy5, xyy6);
        RGBColorSpace.GammaTransferFunctions gammaTransferFunctions = new RGBColorSpace.GammaTransferFunctions(2.19921875d);
        Double dValueOf = Double.valueOf(0.64d);
        Double dValueOf2 = Double.valueOf(0.33d);
        xyY xyy7 = new xyY(dValueOf, dValueOf2);
        xyY xyy8 = new xyY(Double.valueOf(0.21d), Double.valueOf(0.71d));
        Double dValueOf3 = Double.valueOf(0.15d);
        Double dValueOf4 = Double.valueOf(0.06d);
        AdobeRGB = RGBColorSpacesKt.RGBColorSpace("Adobe RGB", whitePoint, gammaTransferFunctions, xyy7, xyy8, new xyY(dValueOf3, dValueOf4));
        BT2020 = new RGBColorSpaceImpl("BT.2020", whitePoint, BT2020TransferFunctions.INSTANCE, new xyY(Double.valueOf(0.708d), Double.valueOf(0.292d)), new xyY(Double.valueOf(0.17d), Double.valueOf(0.797d)), new xyY(Double.valueOf(0.131d), Double.valueOf(0.046d)), new SaversKt$$ExternalSyntheticLambda5((byte) 25));
        BT709 = RGBColorSpacesKt.RGBColorSpace("BT.709", whitePoint, BT709TransferFunctions.INSTANCE, new xyY(dValueOf, dValueOf2), new xyY(Double.valueOf(0.3d), Double.valueOf(0.6d)), new xyY(dValueOf3, dValueOf4));
        WhitePoint whitePoint3 = new WhitePoint("DCI P3", new xyY(Double.valueOf(0.314d), Double.valueOf(0.351d)));
        RGBColorSpace.GammaTransferFunctions gammaTransferFunctions2 = new RGBColorSpace.GammaTransferFunctions(2.6d);
        Double dValueOf5 = Double.valueOf(0.68d);
        Double dValueOf6 = Double.valueOf(0.32d);
        xyY xyy9 = new xyY(dValueOf5, dValueOf6);
        Double dValueOf7 = Double.valueOf(0.265d);
        Double dValueOf8 = Double.valueOf(0.69d);
        DCI_P3 = RGBColorSpacesKt.RGBColorSpace("DCI P3", whitePoint3, gammaTransferFunctions2, xyy9, new xyY(dValueOf7, dValueOf8), new xyY(dValueOf3, dValueOf4));
        DisplayP3 = RGBColorSpacesKt.RGBColorSpace("Display P3", whitePoint, companion, new xyY(dValueOf5, dValueOf6), new xyY(dValueOf7, dValueOf8), new xyY(dValueOf3, dValueOf4));
        ROMM_RGB = RGBColorSpacesKt.RGBColorSpace("ROMM RGB", Illuminant.D50, HSL.Companion.INSTANCE$1, new xyY(Double.valueOf(0.7347d), Double.valueOf(0.2653d)), new xyY(Double.valueOf(0.1596d), Double.valueOf(0.8404d)), new xyY(Double.valueOf(0.0366d), Double.valueOf(1.0E-4d)));
    }
}
