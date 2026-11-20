package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Connector {
    public final ColorSpace destination;
    public final float[] transform;
    public final ColorSpace transformDestination;
    public final ColorSpace transformSource;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RgbConnector extends Connector {
        public final Rgb mDestination;
        public final Rgb mSource;
        public final float[] mTransform;

        public RgbConnector(Rgb rgb, Rgb rgb2) {
            float[] fArrMul3x3;
            super(rgb2, rgb, rgb2, null);
            this.mSource = rgb;
            this.mDestination = rgb2;
            float[] fArr = Adaptation$Companion$Bradford$1.Bradford.transform;
            WhitePoint whitePoint = rgb.whitePoint;
            float[] fArr2 = rgb.transform;
            WhitePoint whitePoint2 = rgb2.whitePoint;
            float[] fArr3 = rgb2.inverseTransform;
            if (Illuminant.compare(whitePoint, whitePoint2)) {
                fArrMul3x3 = Illuminant.mul3x3(fArr3, fArr2);
            } else {
                float[] xyz$ui_graphics = whitePoint.toXyz$ui_graphics();
                float[] xyz$ui_graphics2 = whitePoint2.toXyz$ui_graphics();
                WhitePoint whitePoint3 = Illuminant.D50;
                fArrMul3x3 = Illuminant.mul3x3(Illuminant.compare(whitePoint2, whitePoint3) ? fArr3 : Illuminant.inverse3x3(Illuminant.mul3x3(Illuminant.chromaticAdaptation(fArr, xyz$ui_graphics2, new float[]{0.964212f, 1.0f, 0.825188f}), rgb2.transform)), Illuminant.compare(whitePoint, whitePoint3) ? fArr2 : Illuminant.mul3x3(Illuminant.chromaticAdaptation(fArr, xyz$ui_graphics, new float[]{0.964212f, 1.0f, 0.825188f}), fArr2));
            }
            this.mTransform = fArrMul3x3;
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* JADX INFO: renamed from: transformToColor-l2rxGTc$ui_graphics */
        public final long mo525transformToColorl2rxGTc$ui_graphics(long j) {
            float fM485getRedimpl = Color.m485getRedimpl(j);
            float fM484getGreenimpl = Color.m484getGreenimpl(j);
            float fM482getBlueimpl = Color.m482getBlueimpl(j);
            float fM481getAlphaimpl = Color.m481getAlphaimpl(j);
            Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.mSource.eotfFunc;
            float fInvoke = (float) rgb$$ExternalSyntheticLambda1.invoke(fM485getRedimpl);
            float fInvoke2 = (float) rgb$$ExternalSyntheticLambda1.invoke(fM484getGreenimpl);
            float fInvoke3 = (float) rgb$$ExternalSyntheticLambda1.invoke(fM482getBlueimpl);
            float[] fArr = this.mTransform;
            float f = (fArr[6] * fInvoke3) + (fArr[3] * fInvoke2) + (fArr[0] * fInvoke);
            float f2 = (fArr[7] * fInvoke3) + (fArr[4] * fInvoke2) + (fArr[1] * fInvoke);
            float f3 = (fArr[8] * fInvoke3) + (fArr[5] * fInvoke2) + (fArr[2] * fInvoke);
            Rgb rgb = this.mDestination;
            Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda2 = rgb.oetfFunc;
            return ColorKt.Color((float) rgb$$ExternalSyntheticLambda2.invoke(f), (float) rgb$$ExternalSyntheticLambda2.invoke(f2), (float) rgb$$ExternalSyntheticLambda2.invoke(f3), fM481getAlphaimpl, rgb);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        ColorSpace colorSpaceAdapt$default = Illuminant.m527equalsimpl0(colorSpace.model, 12884901888L) ? Illuminant.adapt$default(colorSpace) : colorSpace;
        ColorSpace colorSpaceAdapt$default2 = Illuminant.m527equalsimpl0(colorSpace2.model, 12884901888L) ? Illuminant.adapt$default(colorSpace2) : colorSpace2;
        float[] fArr = null;
        if (i == 3) {
            boolean zM527equalsimpl0 = Illuminant.m527equalsimpl0(colorSpace.model, 12884901888L);
            boolean zM527equalsimpl1 = Illuminant.m527equalsimpl0(colorSpace2.model, 12884901888L);
            if ((!zM527equalsimpl0 || !zM527equalsimpl1) && (zM527equalsimpl0 || zM527equalsimpl1)) {
                WhitePoint whitePoint = ((Rgb) (zM527equalsimpl0 ? colorSpace : colorSpace2)).whitePoint;
                float[] xyz$ui_graphics = Illuminant.D50Xyz;
                float[] xyz$ui_graphics2 = zM527equalsimpl0 ? whitePoint.toXyz$ui_graphics() : xyz$ui_graphics;
                xyz$ui_graphics = zM527equalsimpl1 ? whitePoint.toXyz$ui_graphics() : xyz$ui_graphics;
                fArr = new float[]{xyz$ui_graphics2[0] / xyz$ui_graphics[0], xyz$ui_graphics2[1] / xyz$ui_graphics[1], xyz$ui_graphics2[2] / xyz$ui_graphics[2]};
            }
        }
        this(colorSpace2, colorSpaceAdapt$default, colorSpaceAdapt$default2, fArr);
    }

    /* JADX INFO: renamed from: transformToColor-l2rxGTc$ui_graphics, reason: not valid java name */
    public long mo525transformToColorl2rxGTc$ui_graphics(long j) {
        float fM485getRedimpl = Color.m485getRedimpl(j);
        float fM484getGreenimpl = Color.m484getGreenimpl(j);
        float fM482getBlueimpl = Color.m482getBlueimpl(j);
        float fM481getAlphaimpl = Color.m481getAlphaimpl(j);
        ColorSpace colorSpace = this.transformSource;
        long xy$ui_graphics = colorSpace.toXy$ui_graphics(fM485getRedimpl, fM484getGreenimpl, fM482getBlueimpl);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics & 4294967295L));
        float z$ui_graphics = colorSpace.toZ$ui_graphics(fM485getRedimpl, fM484getGreenimpl, fM482getBlueimpl);
        float[] fArr = this.transform;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            z$ui_graphics *= fArr[2];
        }
        float f = fIntBitsToFloat;
        float f2 = fIntBitsToFloat2;
        return this.transformDestination.mo524xyzaToColorJlNiLsg$ui_graphics(f, f2, z$ui_graphics, fM481getAlphaimpl, this.destination);
    }

    public Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, float[] fArr) {
        this.destination = colorSpace;
        this.transformSource = colorSpace2;
        this.transformDestination = colorSpace3;
        this.transform = fArr;
    }
}
