package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Rgb extends ColorSpace {
    public static final ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 DoubleIdentity = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0((byte) 21);
    public final Rgb$$ExternalSyntheticLambda0 eotf;
    public final Rgb$$ExternalSyntheticLambda1 eotfFunc;
    public final DoubleFunction eotfOrig;
    public final float[] inverseTransform;
    public final boolean isSrgb;
    public final float max;
    public final float min;
    public final Rgb$$ExternalSyntheticLambda0 oetf;
    public final Rgb$$ExternalSyntheticLambda1 oetfFunc;
    public final DoubleFunction oetfOrig;
    public final float[] primaries;
    public final TransferParameters transferParameters;
    public final float[] transform;
    public final WhitePoint whitePoint;

    /* JADX WARN: Code duplicated, block: B:41:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:42:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:45:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:53:0x0214  */
    /* JADX WARN: Code duplicated, block: B:56:0x021d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0231  */
    /* JADX WARN: Code duplicated, block: B:65:0x0249  */
    /* JADX WARN: Code duplicated, block: B:75:0x0214 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x020e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x01e8 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r9v4, types: [androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0] */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f2, TransferParameters transferParameters, int i) {
        int i2;
        float f3;
        float[] fArr3;
        float f4;
        float[] fArr4;
        Rgb rgb;
        double d;
        boolean z;
        int i3;
        super(i, 12884901888L, str);
        this.whitePoint = whitePoint;
        this.min = f;
        this.max = f2;
        this.transferParameters = transferParameters;
        this.oetfOrig = doubleFunction;
        final byte b = 0;
        this.oetf = new Function1(this) { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0
            public final /* synthetic */ Rgb f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                double dCoerceIn;
                byte b2 = b;
                Rgb rgb2 = this.f$0;
                Double d2 = (Double) obj;
                switch (b2) {
                    case 0:
                        dCoerceIn = UuidKt.coerceIn(rgb2.oetfOrig.invoke(d2.doubleValue()), rgb2.min, rgb2.max);
                        break;
                    default:
                        dCoerceIn = rgb2.eotfOrig.invoke(UuidKt.coerceIn(d2.doubleValue(), rgb2.min, rgb2.max));
                        break;
                }
                return Double.valueOf(dCoerceIn);
            }
        };
        this.oetfFunc = new Rgb$$ExternalSyntheticLambda1(this, b);
        this.eotfOrig = doubleFunction2;
        final byte b2 = 1;
        this.eotf = new Function1(this) { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0
            public final /* synthetic */ Rgb f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                double dCoerceIn;
                byte b3 = b2;
                Rgb rgb2 = this.f$0;
                Double d2 = (Double) obj;
                switch (b3) {
                    case 0:
                        dCoerceIn = UuidKt.coerceIn(rgb2.oetfOrig.invoke(d2.doubleValue()), rgb2.min, rgb2.max);
                        break;
                    default:
                        dCoerceIn = rgb2.eotfOrig.invoke(UuidKt.coerceIn(d2.doubleValue(), rgb2.min, rgb2.max));
                        break;
                }
                return Double.valueOf(dCoerceIn);
            }
        };
        this.eotfFunc = new Rgb$$ExternalSyntheticLambda1(this, b2);
        if (fArr.length != 6 && fArr.length != 9) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
            throw null;
        }
        if (f >= f2) {
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
        }
        float[] fArr5 = new float[6];
        if (fArr.length == 9) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = f5 + f6 + fArr[2];
            fArr5[0] = f5 / f7;
            fArr5[1] = f6 / f7;
            float f8 = fArr[3];
            float f9 = fArr[4];
            float f10 = f8 + f9 + fArr[5];
            fArr5[2] = f8 / f10;
            fArr5[3] = f9 / f10;
            float f11 = fArr[6];
            float f12 = fArr[7];
            float f13 = f11 + f12 + fArr[8];
            fArr5[4] = f11 / f13;
            fArr5[5] = f12 / f13;
        } else {
            ArraysKt.copyInto$default(fArr, fArr5, 6);
        }
        this.primaries = fArr5;
        if (fArr2 == null) {
            float f14 = fArr5[0];
            float f15 = fArr5[1];
            float f16 = fArr5[2];
            float f17 = fArr5[3];
            float f18 = fArr5[4];
            float f19 = fArr5[5];
            f3 = 1.0f;
            float f20 = whitePoint.x;
            i2 = 0;
            float f21 = whitePoint.y;
            float f22 = 1.0f - f14;
            float f23 = f22 / f15;
            float f24 = 1.0f - f16;
            float f25 = 1.0f - f18;
            float f26 = (1.0f - f20) / f21;
            float f27 = f14 / f15;
            float f28 = (f16 / f17) - f27;
            float f29 = (f20 / f21) - f27;
            float f30 = (f24 / f17) - f23;
            float f31 = (f18 / f19) - f27;
            float f32 = (((f26 - f23) * f28) - (f29 * f30)) / ((((f25 / f19) - f23) * f28) - (f30 * f31));
            float f33 = (f29 - (f31 * f32)) / f28;
            float f34 = (1.0f - f33) - f32;
            float f35 = f34 / f15;
            float f36 = f33 / f17;
            float f37 = f32 / f19;
            fArr3 = new float[]{f14 * f35, f34, (f22 - f15) * f35, f16 * f36, f33, (f24 - f17) * f36, f18 * f37, f32, (f25 - f19) * f37};
            this.transform = fArr3;
        } else {
            i2 = 0;
            f3 = 1.0f;
            if (fArr2.length != 9) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(fArr2.length, "Transform must have 9 entries! Has "));
                throw null;
            }
            this.transform = fArr2;
            fArr3 = fArr2;
        }
        this.inverseTransform = Illuminant.inverse3x3(fArr3);
        float fArea = Illuminant.area(fArr5);
        float[] fArr6 = ColorSpaces.SrgbPrimaries;
        if (fArea / Illuminant.area(ColorSpaces.Ntsc1953Primaries) > 0.9f) {
            float[] fArr7 = ColorSpaces.SrgbPrimaries;
            float f38 = fArr5[i2];
            float f39 = fArr7[i2];
            float f40 = fArr5[1];
            float f41 = fArr7[1];
            float f42 = fArr5[2];
            float f43 = fArr7[2];
            float f44 = fArr5[3];
            float f45 = fArr7[3];
            float f46 = fArr5[4];
            float f47 = fArr7[4];
            float f48 = fArr5[5];
            float f49 = fArr7[5];
            f4 = CropImageView.DEFAULT_ASPECT_RATIO;
            float[] fArr8 = new float[6];
            fArr8[i2] = f38 - f39;
            fArr8[1] = f40 - f41;
            fArr8[2] = f42 - f43;
            fArr8[3] = f44 - f45;
            fArr8[4] = f46 - f47;
            fArr8[5] = f48 - f49;
            float f50 = fArr8[i2];
            float f51 = fArr8[1];
            if (((f41 - f49) * f50) - ((f39 - f47) * f51) >= CropImageView.DEFAULT_ASPECT_RATIO && ((f39 - f43) * f51) - ((f41 - f45) * f50) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                float f52 = fArr8[2];
                float f53 = fArr8[3];
                if (((f45 - f41) * f52) - ((f43 - f39) * f53) >= CropImageView.DEFAULT_ASPECT_RATIO && ((f43 - f47) * f53) - ((f45 - f49) * f52) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    float f54 = fArr8[4];
                    float f55 = fArr8[5];
                    if (((f49 - f45) * f54) - ((f47 - f43) * f55) < CropImageView.DEFAULT_ASPECT_RATIO || ((f47 - f39) * f55) - ((f49 - f41) * f54) < CropImageView.DEFAULT_ASPECT_RATIO) {
                    }
                }
            }
            if (i != 0) {
                fArr4 = ColorSpaces.SrgbPrimaries;
                if (fArr5 == fArr4) {
                    i3 = i2;
                    while (true) {
                        if (i3 < 6) {
                            if (Float.compare(fArr5[i3], fArr4[i3]) != 0 || Math.abs(fArr5[i3] - fArr4[i3]) <= 0.001f) {
                                i3++;
                            }
                        } else if (Illuminant.compare(whitePoint, Illuminant.D65)) {
                            float[] fArr9 = ColorSpaces.SrgbPrimaries;
                            rgb = ColorSpaces.Srgb;
                            d = 0.0d;
                            while (true) {
                                if (d <= 1.0d) {
                                    z = 1;
                                } else if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) > 0.001d) {
                                }
                                d += 0.00392156862745098d;
                            }
                        }
                    }
                } else if (Illuminant.compare(whitePoint, Illuminant.D65) && f == f4 && f2 == f3) {
                    float[] fArr10 = ColorSpaces.SrgbPrimaries;
                    rgb = ColorSpaces.Srgb;
                    d = 0.0d;
                    while (true) {
                        if (d <= 1.0d) {
                            z = 1;
                        } else if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) > 0.001d && Math.abs(doubleFunction2.invoke(d) - rgb.eotfOrig.invoke(d)) <= 0.001d) {
                            d += 0.00392156862745098d;
                        }
                    }
                }
                z = i2;
            } else {
                z = 1;
            }
            this.isSrgb = z;
        }
        f4 = CropImageView.DEFAULT_ASPECT_RATIO;
        int i4 = (f > f4 ? 1 : (f == f4 ? 0 : -1));
        if (i != 0) {
            fArr4 = ColorSpaces.SrgbPrimaries;
            if (fArr5 == fArr4) {
                i3 = i2;
                while (true) {
                    if (i3 < 6) {
                        if (Float.compare(fArr5[i3], fArr4[i3]) != 0) {
                        }
                        i3++;
                    } else if (Illuminant.compare(whitePoint, Illuminant.D65)) {
                        float[] fArr11 = ColorSpaces.SrgbPrimaries;
                        rgb = ColorSpaces.Srgb;
                        d = 0.0d;
                        while (true) {
                            if (d <= 1.0d) {
                                z = 1;
                            } else if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) > 0.001d) {
                            }
                            d += 0.00392156862745098d;
                        }
                    }
                }
            } else if (Illuminant.compare(whitePoint, Illuminant.D65)) {
                float[] fArr12 = ColorSpaces.SrgbPrimaries;
                rgb = ColorSpaces.Srgb;
                d = 0.0d;
                while (true) {
                    if (d <= 1.0d) {
                        z = 1;
                    } else if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) > 0.001d) {
                    }
                    d += 0.00392156862745098d;
                }
            }
            z = i2;
        } else {
            z = 1;
        }
        this.isSrgb = z;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rgb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = rgb.transferParameters;
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual(transferParameters2, transferParameters);
        }
        if (transferParameters == null) {
            return true;
        }
        if (Intrinsics.areEqual(this.oetfOrig, rgb.oetfOrig)) {
            return Intrinsics.areEqual(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMaxValue(int i) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMinValue(int i) {
        return this.min;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final int hashCode() {
        int iHashCode = (Arrays.hashCode(this.primaries) + ((this.whitePoint.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f = this.min;
        int iFloatToIntBits = (iHashCode + (f == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : Float.floatToIntBits(f))) * 31;
        float f2 = this.max;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : Float.floatToIntBits(f2))) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int iHashCode2 = iFloatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        if (transferParameters != null) {
            return iHashCode2;
        }
        return this.eotfOrig.hashCode() + ((this.oetfOrig.hashCode() + (iHashCode2 * 31)) * 31);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final long toXy$ui_graphics(float f, float f2, float f3) {
        double d = f;
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.eotfFunc;
        float fInvoke = (float) rgb$$ExternalSyntheticLambda1.invoke(d);
        float fInvoke2 = (float) rgb$$ExternalSyntheticLambda1.invoke(f2);
        float fInvoke3 = (float) rgb$$ExternalSyntheticLambda1.invoke(f3);
        float[] fArr = this.transform;
        if (fArr.length < 9) {
            return 0L;
        }
        return (((long) Float.floatToRawIntBits((fArr[6] * fInvoke3) + ((fArr[3] * fInvoke2) + (fArr[0] * fInvoke)))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits((fArr[7] * fInvoke3) + (fArr[4] * fInvoke2) + (fArr[1] * fInvoke))));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float toZ$ui_graphics(float f, float f2, float f3) {
        double d = f;
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.eotfFunc;
        float fInvoke = (float) rgb$$ExternalSyntheticLambda1.invoke(d);
        float fInvoke2 = (float) rgb$$ExternalSyntheticLambda1.invoke(f2);
        float fInvoke3 = (float) rgb$$ExternalSyntheticLambda1.invoke(f3);
        float[] fArr = this.transform;
        return (fArr[8] * fInvoke3) + (fArr[5] * fInvoke2) + (fArr[2] * fInvoke);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics */
    public final long mo524xyzaToColorJlNiLsg$ui_graphics(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float[] fArr = this.inverseTransform;
        float f5 = (fArr[6] * f3) + (fArr[3] * f2) + (fArr[0] * f);
        float f6 = (fArr[7] * f3) + (fArr[4] * f2) + (fArr[1] * f);
        float f7 = (fArr[8] * f3) + (fArr[5] * f2) + (fArr[2] * f);
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.oetfFunc;
        return ColorKt.Color((float) rgb$$ExternalSyntheticLambda1.invoke(f5), (float) rgb$$ExternalSyntheticLambda1.invoke(f6), (float) rgb$$ExternalSyntheticLambda1.invoke(f7), f4, colorSpace);
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final TransferParameters transferParameters, int i) {
        double d;
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2;
        double d2 = transferParameters.gamma;
        final byte b = 0;
        final byte b2 = 1;
        boolean z = d2 == -3.0d;
        double d3 = transferParameters.f;
        double d4 = transferParameters.e;
        if (z) {
            d = -3.0d;
            final byte b3 = 4;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d5) {
                    byte b4 = b3;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (b4) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                        case 2:
                            double d6 = transferParameters2.a;
                            return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                        case 3:
                            double d7 = transferParameters2.a;
                            double d8 = transferParameters2.b;
                            double d9 = transferParameters2.c;
                            return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                        case 6:
                            double d10 = transferParameters2.a;
                            double d11 = transferParameters2.b;
                            double d12 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                        default:
                            double d13 = transferParameters2.a;
                            double d14 = transferParameters2.b;
                            double d15 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                    }
                }
            };
        } else {
            d = -3.0d;
            if (d2 == -2.0d) {
                final byte b4 = 5;
                doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d5) {
                        byte b5 = b4;
                        TransferParameters transferParameters2 = transferParameters;
                        switch (b5) {
                            case 0:
                                float[] fArr2 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                            case 1:
                                float[] fArr3 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                            case 2:
                                double d6 = transferParameters2.a;
                                return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                            case 3:
                                double d7 = transferParameters2.a;
                                double d8 = transferParameters2.b;
                                double d9 = transferParameters2.c;
                                return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                            case 4:
                                float[] fArr4 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                            case 5:
                                float[] fArr5 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                            case 6:
                                double d10 = transferParameters2.a;
                                double d11 = transferParameters2.b;
                                double d12 = transferParameters2.c;
                                return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                            default:
                                double d13 = transferParameters2.a;
                                double d14 = transferParameters2.b;
                                double d15 = transferParameters2.c;
                                return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                        }
                    }
                };
            } else if (d4 == 0.0d && d3 == 0.0d) {
                final byte b5 = 6;
                doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d5) {
                        byte b6 = b5;
                        TransferParameters transferParameters2 = transferParameters;
                        switch (b6) {
                            case 0:
                                float[] fArr2 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                            case 1:
                                float[] fArr3 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                            case 2:
                                double d6 = transferParameters2.a;
                                return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                            case 3:
                                double d7 = transferParameters2.a;
                                double d8 = transferParameters2.b;
                                double d9 = transferParameters2.c;
                                return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                            case 4:
                                float[] fArr4 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                            case 5:
                                float[] fArr5 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                            case 6:
                                double d10 = transferParameters2.a;
                                double d11 = transferParameters2.b;
                                double d12 = transferParameters2.c;
                                return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                            default:
                                double d13 = transferParameters2.a;
                                double d14 = transferParameters2.b;
                                double d15 = transferParameters2.c;
                                return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                        }
                    }
                };
            } else {
                final byte b6 = 7;
                doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d5) {
                        byte b7 = b6;
                        TransferParameters transferParameters2 = transferParameters;
                        switch (b7) {
                            case 0:
                                float[] fArr2 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                            case 1:
                                float[] fArr3 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                            case 2:
                                double d6 = transferParameters2.a;
                                return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                            case 3:
                                double d7 = transferParameters2.a;
                                double d8 = transferParameters2.b;
                                double d9 = transferParameters2.c;
                                return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                            case 4:
                                float[] fArr4 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                            case 5:
                                float[] fArr5 = ColorSpaces.SrgbPrimaries;
                                return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                            case 6:
                                double d10 = transferParameters2.a;
                                double d11 = transferParameters2.b;
                                double d12 = transferParameters2.c;
                                return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                            default:
                                double d13 = transferParameters2.a;
                                double d14 = transferParameters2.b;
                                double d15 = transferParameters2.c;
                                return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                        }
                    }
                };
            }
        }
        if (d2 == d) {
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d5) {
                    byte b7 = b;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (b7) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                        case 2:
                            double d6 = transferParameters2.a;
                            return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                        case 3:
                            double d7 = transferParameters2.a;
                            double d8 = transferParameters2.b;
                            double d9 = transferParameters2.c;
                            return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                        case 6:
                            double d10 = transferParameters2.a;
                            double d11 = transferParameters2.b;
                            double d12 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                        default:
                            double d13 = transferParameters2.a;
                            double d14 = transferParameters2.b;
                            double d15 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                    }
                }
            };
        } else if (d2 == -2.0d) {
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d5) {
                    byte b7 = b2;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (b7) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                        case 2:
                            double d6 = transferParameters2.a;
                            return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                        case 3:
                            double d7 = transferParameters2.a;
                            double d8 = transferParameters2.b;
                            double d9 = transferParameters2.c;
                            return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                        case 6:
                            double d10 = transferParameters2.a;
                            double d11 = transferParameters2.b;
                            double d12 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                        default:
                            double d13 = transferParameters2.a;
                            double d14 = transferParameters2.b;
                            double d15 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                    }
                }
            };
        } else if (d4 == 0.0d && d3 == 0.0d) {
            final byte b7 = 2;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d5) {
                    byte b8 = b7;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (b8) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                        case 2:
                            double d6 = transferParameters2.a;
                            return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                        case 3:
                            double d7 = transferParameters2.a;
                            double d8 = transferParameters2.b;
                            double d9 = transferParameters2.c;
                            return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                        case 6:
                            double d10 = transferParameters2.a;
                            double d11 = transferParameters2.b;
                            double d12 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                        default:
                            double d13 = transferParameters2.a;
                            double d14 = transferParameters2.b;
                            double d15 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                    }
                }
            };
        } else {
            final byte b8 = 3;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d5) {
                    byte b9 = b8;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (b9) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d5);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d5);
                        case 2:
                            double d6 = transferParameters2.a;
                            return d5 >= transferParameters2.d ? Math.pow((d6 * d5) + transferParameters2.b, transferParameters2.gamma) : transferParameters2.c * d5;
                        case 3:
                            double d7 = transferParameters2.a;
                            double d8 = transferParameters2.b;
                            double d9 = transferParameters2.c;
                            return d5 >= transferParameters2.d ? Math.pow((d7 * d5) + d8, transferParameters2.gamma) + transferParameters2.e : (d9 * d5) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d5);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d5);
                        case 6:
                            double d10 = transferParameters2.a;
                            double d11 = transferParameters2.b;
                            double d12 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d12 ? (Math.pow(d5, 1.0d / transferParameters2.gamma) - d11) / d10 : d5 / d12;
                        default:
                            double d13 = transferParameters2.a;
                            double d14 = transferParameters2.b;
                            double d15 = transferParameters2.c;
                            return d5 >= transferParameters2.d * d15 ? (Math.pow(d5 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d14) / d13 : (d5 - transferParameters2.f) / d15;
                    }
                }
            };
        }
        this(str, fArr, whitePoint, null, doubleFunction, doubleFunction2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, transferParameters, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final double d, float f, float f2, int i) {
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2 = DoubleIdentity;
        if (d == 1.0d) {
            doubleFunction = doubleFunction2;
        } else {
            final byte b = 0;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d2) {
                    switch (b) {
                        case 0:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, 1.0d / d);
                        default:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, d);
                    }
                }
            };
        }
        if (d != 1.0d) {
            final byte b2 = 1;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d2) {
                    switch (b2) {
                        case 0:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, 1.0d / d);
                        default:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, d);
                    }
                }
            };
        }
        DoubleFunction doubleFunction3 = doubleFunction2;
        this(str, fArr, whitePoint, null, doubleFunction, doubleFunction3, f, f2, new TransferParameters(d, 1.0d, 0.0d, 0.0d, 0.0d), i);
    }
}
