package androidx.compose.ui.graphics.colorspace;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Oklab extends ColorSpace {
    public static final float[] InverseM1;
    public static final float[] InverseM2;
    public static final float[] M1;
    public static final float[] M2;

    static {
        float[] fArrMul3x3 = Illuminant.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, Illuminant.chromaticAdaptation(Adaptation$Companion$Bradford$1.Bradford.transform, new float[]{0.964212f, 1.0f, 0.8251883f}, new float[]{0.95042855f, 1.0f, 1.0889004f}));
        M1 = fArrMul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = fArr;
        InverseM1 = Illuminant.inverse3x3(fArrMul3x3);
        InverseM2 = Illuminant.inverse3x3(fArr);
    }
}
