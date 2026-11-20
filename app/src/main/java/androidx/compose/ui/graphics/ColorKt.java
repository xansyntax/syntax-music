package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Illuminant;
import androidx.compose.ui.graphics.colorspace.Oklab;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.unit.IntRect;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorKt {
    public static final RectangleShapeKt$RectangleShape$1 RectangleShape = new RectangleShapeKt$RectangleShape$1();
    public static Method inorderBarrierMethod;
    public static boolean orderMethodsFetched;
    public static Method reorderBarrierMethod;
    public static ReusableGraphicsLayerScope reusableGraphicsLayerScope;

    /* JADX INFO: renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final android.graphics.LinearGradient m487ActualLinearGradientShaderVjE6UOU(long j, long j2, List list, List list2) {
        validateColorStops(list, list2);
        if (Build.VERSION.SDK_INT >= 29) {
            return GradientColorLongVerifier.INSTANCE.m504createLinearGradientColorLongVjE6UOU(j, j2, toPlatformLongArray(list), list2 != null ? CollectionsKt.toFloatArray(list2) : null, 0);
        }
        return new android.graphics.LinearGradient(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), makeTransparentColors(list), makeTransparentStops(list2, list), m497toAndroidTileMode0vamqd0(0));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x014d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0154  */
    /* JADX WARN: Code duplicated, block: B:109:0x0161 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0163  */
    /* JADX WARN: Code duplicated, block: B:112:0x0168  */
    /* JADX WARN: Code duplicated, block: B:114:0x016c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0172 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x0174  */
    /* JADX WARN: Code duplicated, block: B:119:0x017d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0182  */
    /* JADX WARN: Code duplicated, block: B:122:0x0184  */
    /* JADX WARN: Code duplicated, block: B:124:0x018a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0193  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0102  */
    /* JADX WARN: Code duplicated, block: B:81:0x0105  */
    /* JADX WARN: Code duplicated, block: B:83:0x0108  */
    /* JADX WARN: Code duplicated, block: B:85:0x010c  */
    /* JADX WARN: Code duplicated, block: B:86:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0114  */
    /* JADX WARN: Code duplicated, block: B:90:0x011d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0123  */
    /* JADX WARN: Code duplicated, block: B:93:0x0126  */
    /* JADX WARN: Code duplicated, block: B:95:0x012c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0136  */
    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        float minValue;
        float maxValue;
        int iFloatToRawIntBits;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float minValue2;
        float maxValue2;
        int iFloatToRawIntBits2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean zIsSrgb = colorSpace.isSrgb();
        float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (zIsSrgb) {
            float f6 = f4 < CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : f4;
            if (f6 > 1.0f) {
                f6 = 1.0f;
            }
            int i20 = ((int) ((f6 * 255.0f) + 0.5f)) << 24;
            float f7 = f < CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : f;
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            int i21 = i20 | (((int) ((f7 * 255.0f) + 0.5f)) << 16);
            float f8 = f2 < CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : f2;
            if (f8 > 1.0f) {
                f8 = 1.0f;
            }
            int i22 = i21 | (((int) ((f8 * 255.0f) + 0.5f)) << 8);
            if (f3 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                f5 = f3;
            }
            return ((long) (i22 | ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 255.0f) + 0.5f)))) << 32;
        }
        int i23 = colorSpace.id;
        if (i23 == -1) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        int i24 = 0;
        float minValue3 = colorSpace.getMinValue(0);
        float maxValue3 = colorSpace.getMaxValue(0);
        if (f >= minValue3) {
            minValue3 = f;
        }
        if (minValue3 <= maxValue3) {
            maxValue3 = minValue3;
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(maxValue3);
        int i25 = iFloatToRawIntBits3 >>> 31;
        int i26 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i27 = iFloatToRawIntBits3 & 8388607;
        if (i26 == 255) {
            i2 = i27 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i26 - 112;
            if (i >= 31) {
                i2 = 0;
                i = 49;
            } else {
                if (i > 0) {
                    int i28 = i27 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i3 = (((i << 10) | i28) + 1) | (i25 << 15);
                    } else {
                        i2 = i28;
                    }
                    short s = (short) i3;
                    minValue = colorSpace.getMinValue(1);
                    maxValue = colorSpace.getMaxValue(1);
                    if (f2 >= minValue) {
                        minValue = f2;
                    }
                    if (minValue <= maxValue) {
                        maxValue = minValue;
                    }
                    iFloatToRawIntBits = Float.floatToRawIntBits(maxValue);
                    i4 = iFloatToRawIntBits >>> 31;
                    i5 = (iFloatToRawIntBits >>> 23) & 255;
                    i6 = iFloatToRawIntBits & 8388607;
                    if (i5 == 255) {
                        if (i6 != 0) {
                            i9 = 512;
                        } else {
                            i9 = 0;
                        }
                        i7 = 31;
                    } else {
                        i7 = i5 - 112;
                        if (i7 >= 31) {
                            i9 = 0;
                            i7 = 49;
                        } else {
                            if (i7 <= 0) {
                                i8 = i6 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                                } else {
                                    i9 = i8;
                                }
                                short s2 = (short) i10;
                                minValue2 = colorSpace.getMinValue(2);
                                maxValue2 = colorSpace.getMaxValue(2);
                                if (f3 >= minValue2) {
                                    minValue2 = f3;
                                }
                                if (minValue2 <= maxValue2) {
                                    maxValue2 = minValue2;
                                }
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                                i12 = iFloatToRawIntBits2 >>> 31;
                                i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i14 = 8388607 & iFloatToRawIntBits2;
                                if (i13 == 255) {
                                    i17 = i14 != 0 ? 512 : 0;
                                    i24 = 31;
                                } else {
                                    i15 = i13 - 112;
                                    if (i15 >= 31) {
                                        i17 = 0;
                                        i24 = 49;
                                    } else {
                                        if (i15 <= 0) {
                                            i16 = i14 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                            } else {
                                                i17 = i16;
                                                i24 = i15;
                                            }
                                            short s3 = (short) i18;
                                            if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                                f5 = f4;
                                            }
                                            return (((long) i23) & 63) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((65535 & ((long) s3)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                                        }
                                        if (i15 >= -10) {
                                            i19 = (i14 | 8388608) >> (1 - i15);
                                            if ((i19 & 4096) != 0) {
                                                i19 += 8192;
                                            }
                                            i17 = i19 >> 13;
                                        } else {
                                            i17 = 0;
                                        }
                                    }
                                }
                                i18 = i17 | (i12 << 15) | (i24 << 10);
                                short s4 = (short) i18;
                                if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f5 = f4;
                                }
                                return (((long) i23) & 63) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((65535 & ((long) s4)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                            }
                            if (i7 >= -10) {
                                i11 = (i6 | 8388608) >> (1 - i7);
                                if ((i11 & 4096) != 0) {
                                    i11 += 8192;
                                }
                                i9 = i11 >> 13;
                                i7 = 0;
                            } else {
                                i9 = 0;
                                i7 = 0;
                            }
                        }
                    }
                    i10 = i9 | (i4 << 15) | (i7 << 10);
                    short s5 = (short) i10;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                        minValue2 = f3;
                    }
                    if (minValue2 <= maxValue2) {
                        maxValue2 = minValue2;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i17 = i14 != 0 ? 512 : 0;
                        i24 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i17 = 0;
                            i24 = 49;
                        } else {
                            if (i15 <= 0) {
                                i16 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                } else {
                                    i17 = i16;
                                    i24 = i15;
                                }
                                short s6 = (short) i18;
                                if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f5 = f4;
                                }
                                return (((long) i23) & 63) | ((((long) s) & 65535) << 48) | ((((long) s5) & 65535) << 32) | ((65535 & ((long) s6)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                            }
                            if (i15 >= -10) {
                                i19 = (i14 | 8388608) >> (1 - i15);
                                if ((i19 & 4096) != 0) {
                                    i19 += 8192;
                                }
                                i17 = i19 >> 13;
                            } else {
                                i17 = 0;
                            }
                        }
                    }
                    i18 = i17 | (i12 << 15) | (i24 << 10);
                    short s7 = (short) i18;
                    if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        f5 = f4;
                    }
                    return (((long) i23) & 63) | ((((long) s) & 65535) << 48) | ((((long) s5) & 65535) << 32) | ((65535 & ((long) s7)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                }
                if (i >= -10) {
                    int i29 = (i27 | 8388608) >> (1 - i);
                    if ((i29 & 4096) != 0) {
                        i29 += 8192;
                    }
                    i2 = i29 >> 13;
                    i = 0;
                } else {
                    i2 = 0;
                    i = 0;
                }
            }
        }
        i3 = i2 | (i25 << 15) | (i << 10);
        short s8 = (short) i3;
        minValue = colorSpace.getMinValue(1);
        maxValue = colorSpace.getMaxValue(1);
        if (f2 >= minValue) {
            minValue = f2;
        }
        if (minValue <= maxValue) {
            maxValue = minValue;
        }
        iFloatToRawIntBits = Float.floatToRawIntBits(maxValue);
        i4 = iFloatToRawIntBits >>> 31;
        i5 = (iFloatToRawIntBits >>> 23) & 255;
        i6 = iFloatToRawIntBits & 8388607;
        if (i5 == 255) {
            if (i6 != 0) {
                i9 = 512;
            } else {
                i9 = 0;
            }
            i7 = 31;
        } else {
            i7 = i5 - 112;
            if (i7 >= 31) {
                i9 = 0;
                i7 = 49;
            } else {
                if (i7 <= 0) {
                    i8 = i6 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                    } else {
                        i9 = i8;
                    }
                    short s9 = (short) i10;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                        minValue2 = f3;
                    }
                    if (minValue2 <= maxValue2) {
                        maxValue2 = minValue2;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i17 = i14 != 0 ? 512 : 0;
                        i24 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i17 = 0;
                            i24 = 49;
                        } else {
                            if (i15 <= 0) {
                                i16 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                } else {
                                    i17 = i16;
                                    i24 = i15;
                                }
                                short s10 = (short) i18;
                                if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                                    f5 = f4;
                                }
                                return (((long) i23) & 63) | ((((long) s8) & 65535) << 48) | ((((long) s9) & 65535) << 32) | ((65535 & ((long) s10)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                            }
                            if (i15 >= -10) {
                                i19 = (i14 | 8388608) >> (1 - i15);
                                if ((i19 & 4096) != 0) {
                                    i19 += 8192;
                                }
                                i17 = i19 >> 13;
                            } else {
                                i17 = 0;
                            }
                        }
                    }
                    i18 = i17 | (i12 << 15) | (i24 << 10);
                    short s11 = (short) i18;
                    if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        f5 = f4;
                    }
                    return (((long) i23) & 63) | ((((long) s8) & 65535) << 48) | ((((long) s9) & 65535) << 32) | ((65535 & ((long) s11)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                }
                if (i7 >= -10) {
                    i11 = (i6 | 8388608) >> (1 - i7);
                    if ((i11 & 4096) != 0) {
                        i11 += 8192;
                    }
                    i9 = i11 >> 13;
                    i7 = 0;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
            }
        }
        i10 = i9 | (i4 << 15) | (i7 << 10);
        short s12 = (short) i10;
        minValue2 = colorSpace.getMinValue(2);
        maxValue2 = colorSpace.getMaxValue(2);
        if (f3 >= minValue2) {
            minValue2 = f3;
        }
        if (minValue2 <= maxValue2) {
            maxValue2 = minValue2;
        }
        iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
        i12 = iFloatToRawIntBits2 >>> 31;
        i13 = (iFloatToRawIntBits2 >>> 23) & 255;
        i14 = 8388607 & iFloatToRawIntBits2;
        if (i13 == 255) {
            i17 = i14 != 0 ? 512 : 0;
            i24 = 31;
        } else {
            i15 = i13 - 112;
            if (i15 >= 31) {
                i17 = 0;
                i24 = 49;
            } else {
                if (i15 <= 0) {
                    i16 = i14 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                    } else {
                        i17 = i16;
                        i24 = i15;
                    }
                    short s13 = (short) i18;
                    if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        f5 = f4;
                    }
                    return (((long) i23) & 63) | ((((long) s8) & 65535) << 48) | ((((long) s12) & 65535) << 32) | ((65535 & ((long) s13)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
                }
                if (i15 >= -10) {
                    i19 = (i14 | 8388608) >> (1 - i15);
                    if ((i19 & 4096) != 0) {
                        i19 += 8192;
                    }
                    i17 = i19 >> 13;
                } else {
                    i17 = 0;
                }
            }
        }
        i18 = i17 | (i12 << 15) | (i24 << 10);
        short s14 = (short) i18;
        if (f4 >= CropImageView.DEFAULT_ASPECT_RATIO) {
            f5 = f4;
        }
        return (((long) i23) & 63) | ((((long) s8) & 65535) << 48) | ((((long) s12) & 65535) << 32) | ((65535 & ((long) s14)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6);
    }

    public static long Color$default(int i, int i2, int i3) {
        return ((long) (((((i & 255) << 16) | (-16777216)) | ((i2 & 255) << 8)) | (i3 & 255))) << 32;
    }

    /* JADX INFO: renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static AndroidImageBitmap m488ImageBitmapx__hDU$default(int i, int i2, int i3, int i4) {
        android.graphics.ColorSpace rgb;
        byte b;
        android.graphics.ColorSpace.Rgb.TransferParameters transferParameters;
        android.graphics.ColorSpace rgb2;
        android.graphics.ColorSpace colorSpaceObtainAndroidColorSpace;
        int i5 = (i4 & 4) != 0 ? 0 : i3;
        Rgb rgb3 = ColorSpaces.Srgb;
        m499toBitmapConfig1JJdX4A(i5);
        Bitmap.Config configM499toBitmapConfig1JJdX4A = m499toBitmapConfig1JJdX4A(i5);
        if (Intrinsics.areEqual(rgb3, rgb3)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.Aces)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.ACES);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.Acescg)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.ACESCG);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.AdobeRgb)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.ADOBE_RGB);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.Bt2020)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.BT2020);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.Bt709)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.BT709);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.CieLab)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.CIE_LAB);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.CieXyz)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.CIE_XYZ);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.DciP3)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.DCI_P3);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.DisplayP3)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.DISPLAY_P3);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.ExtendedSrgb)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.EXTENDED_SRGB);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.LinearExtendedSrgb)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.LinearSrgb)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.LINEAR_SRGB);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.Ntsc1953)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.NTSC_1953);
        } else if (Intrinsics.areEqual(rgb3, ColorSpaces.ProPhotoRgb)) {
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.PRO_PHOTO_RGB);
        } else {
            if (!Intrinsics.areEqual(rgb3, ColorSpaces.SmpteC)) {
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 34 && (colorSpaceObtainAndroidColorSpace = ColorSpaceVerificationHelperV34.obtainAndroidColorSpace(rgb3)) != null) {
                    rgb2 = colorSpaceObtainAndroidColorSpace;
                } else if (i6 < 36 || (rgb = ColorSpaceVerificationHelperV36.obtainAndroidColorSpace(rgb3)) == null) {
                    if (rgb3 != null) {
                        String str = rgb3.name;
                        float[] xyz$ui_graphics = rgb3.whitePoint.toXyz$ui_graphics();
                        TransferParameters transferParameters2 = rgb3.transferParameters;
                        if (transferParameters2 != null) {
                            b = 0;
                            transferParameters = new android.graphics.ColorSpace.Rgb.TransferParameters(transferParameters2.a, transferParameters2.b, transferParameters2.c, transferParameters2.d, transferParameters2.e, transferParameters2.f, transferParameters2.gamma);
                        } else {
                            b = 0;
                            transferParameters = null;
                        }
                        float[] fArr = rgb3.transform;
                        if (transferParameters != null) {
                            android.graphics.ColorSpace.Rgb rgb4 = new android.graphics.ColorSpace.Rgb(str, rgb3.primaries, xyz$ui_graphics, transferParameters);
                            if (Float.isNaN(fArr[b]) || Arrays.equals(rgb4.getTransform(), fArr)) {
                                rgb2 = rgb4;
                            } else {
                                rgb = new android.graphics.ColorSpace.Rgb(str, fArr, transferParameters);
                            }
                        } else {
                            float[] fArr2 = rgb3.primaries;
                            final Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = rgb3.oetf;
                            final byte b2 = b;
                            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda0
                                @Override // java.util.function.DoubleUnaryOperator
                                public final double applyAsDouble(double d) {
                                    byte b3 = b2;
                                    Function1 function1 = rgb$$ExternalSyntheticLambda0;
                                    switch (b3) {
                                        case 0:
                                            break;
                                    }
                                    return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
                                }
                            };
                            final Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda1 = rgb3.eotf;
                            final byte b3 = 1;
                            rgb2 = new android.graphics.ColorSpace.Rgb(str, fArr2, xyz$ui_graphics, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda0
                                @Override // java.util.function.DoubleUnaryOperator
                                public final double applyAsDouble(double d) {
                                    byte b4 = b3;
                                    Function1 function1 = rgb$$ExternalSyntheticLambda1;
                                    switch (b4) {
                                        case 0:
                                            break;
                                    }
                                    return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
                                }
                            }, rgb3.min, rgb3.max);
                        }
                    } else {
                        rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
                    }
                }
                return new AndroidImageBitmap(Bitmap.createBitmap((DisplayMetrics) null, i, i2, configM499toBitmapConfig1JJdX4A, true, rgb2));
            }
            rgb = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SMPTE_C);
        }
        rgb2 = rgb;
        return new AndroidImageBitmap(Bitmap.createBitmap((DisplayMetrics) null, i, i2, configM499toBitmapConfig1JJdX4A, true, rgb2));
    }

    public static final AndroidPaint Paint() {
        return new AndroidPaint(new Paint(7));
    }

    public static final long TransformOrigin(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0093  */
    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX WARN: Code duplicated, block: B:36:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x009f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:66:0x0100  */
    /* JADX WARN: Code duplicated, block: B:68:0x0106  */
    /* JADX WARN: Code duplicated, block: B:70:0x0110  */
    public static final long UncheckedColor(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        int iFloatToRawIntBits;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iFloatToRawIntBits2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (colorSpace.isSrgb()) {
            return ((long) ((((((int) ((f4 * 255.0f) + 0.5f)) << 24) | (((int) ((f * 255.0f) + 0.5f)) << 16)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f3) + 0.5f)))) << 32;
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(f);
        int i18 = iFloatToRawIntBits3 >>> 31;
        int i19 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i20 = iFloatToRawIntBits3 & 8388607;
        int i21 = 49;
        int i22 = 0;
        if (i19 == 255) {
            i2 = i20 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i19 - 112;
            if (i >= 31) {
                i = 49;
                i2 = 0;
            } else {
                if (i > 0) {
                    int i23 = i20 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i3 = (((i << 10) | i23) + 1) | (i18 << 15);
                    } else {
                        i2 = i23;
                    }
                    short s = (short) i3;
                    iFloatToRawIntBits = Float.floatToRawIntBits(f2);
                    i4 = iFloatToRawIntBits >>> 31;
                    i5 = (iFloatToRawIntBits >>> 23) & 255;
                    i6 = iFloatToRawIntBits & 8388607;
                    if (i5 == 255) {
                        if (i6 != 0) {
                            i9 = 512;
                        } else {
                            i9 = 0;
                        }
                        i7 = 31;
                    } else {
                        i7 = i5 - 112;
                        if (i7 >= 31) {
                            i7 = 49;
                            i9 = 0;
                        } else {
                            if (i7 <= 0) {
                                i8 = i6 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                                } else {
                                    i9 = i8;
                                }
                                short s2 = (short) i10;
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                                i12 = iFloatToRawIntBits2 >>> 31;
                                i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i14 = 8388607 & iFloatToRawIntBits2;
                                if (i13 == 255) {
                                    i15 = i13 - 112;
                                    if (i15 < 31) {
                                        if (i15 <= 0) {
                                            i22 = i14 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i16 = (((i15 << 10) | i22) + 1) | (i12 << 15);
                                            } else {
                                                i21 = i15;
                                            }
                                        } else if (i15 >= -10) {
                                            i17 = (i14 | 8388608) >> (1 - i15);
                                            if ((i17 & 4096) != 0) {
                                                i17 += 8192;
                                            }
                                            i21 = 0;
                                            i22 = i17 >> 13;
                                        } else {
                                            i21 = 0;
                                        }
                                    }
                                    return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
                                }
                                i22 = i14 == 0 ? 0 : 512;
                                i21 = 31;
                                i16 = (i12 << 15) | (i21 << 10) | i22;
                                return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
                            }
                            if (i7 >= -10) {
                                i11 = (i6 | 8388608) >> (1 - i7);
                                if ((i11 & 4096) != 0) {
                                    i11 += 8192;
                                }
                                i9 = i11 >> 13;
                                i7 = 0;
                            } else {
                                i9 = 0;
                                i7 = 0;
                            }
                        }
                    }
                    i10 = i9 | (i4 << 15) | (i7 << 10);
                    short s3 = (short) i10;
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i15 = i13 - 112;
                        if (i15 < 31) {
                            if (i15 <= 0) {
                                i22 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i16 = (((i15 << 10) | i22) + 1) | (i12 << 15);
                                } else {
                                    i21 = i15;
                                }
                            } else if (i15 >= -10) {
                                i17 = (i14 | 8388608) >> (1 - i15);
                                if ((i17 & 4096) != 0) {
                                    i17 += 8192;
                                }
                                i21 = 0;
                                i22 = i17 >> 13;
                            } else {
                                i21 = 0;
                            }
                        }
                        return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s3) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
                    }
                    i22 = i14 == 0 ? 0 : 512;
                    i21 = 31;
                    i16 = (i12 << 15) | (i21 << 10) | i22;
                    return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s3) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
                }
                if (i >= -10) {
                    int i24 = (i20 | 8388608) >> (1 - i);
                    if ((i24 & 4096) != 0) {
                        i24 += 8192;
                    }
                    i2 = i24 >> 13;
                    i = 0;
                } else {
                    i2 = 0;
                    i = 0;
                }
            }
        }
        i3 = i2 | (i18 << 15) | (i << 10);
        short s4 = (short) i3;
        iFloatToRawIntBits = Float.floatToRawIntBits(f2);
        i4 = iFloatToRawIntBits >>> 31;
        i5 = (iFloatToRawIntBits >>> 23) & 255;
        i6 = iFloatToRawIntBits & 8388607;
        if (i5 == 255) {
            if (i6 != 0) {
                i9 = 512;
            } else {
                i9 = 0;
            }
            i7 = 31;
        } else {
            i7 = i5 - 112;
            if (i7 >= 31) {
                i7 = 49;
                i9 = 0;
            } else {
                if (i7 <= 0) {
                    i8 = i6 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                    } else {
                        i9 = i8;
                    }
                    short s5 = (short) i10;
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i15 = i13 - 112;
                        if (i15 < 31) {
                            if (i15 <= 0) {
                                i22 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i16 = (((i15 << 10) | i22) + 1) | (i12 << 15);
                                } else {
                                    i21 = i15;
                                }
                            } else if (i15 >= -10) {
                                i17 = (i14 | 8388608) >> (1 - i15);
                                if ((i17 & 4096) != 0) {
                                    i17 += 8192;
                                }
                                i21 = 0;
                                i22 = i17 >> 13;
                            } else {
                                i21 = 0;
                            }
                        }
                        return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s4) & 65535) << 48) | ((((long) s5) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
                    }
                    i22 = i14 == 0 ? 0 : 512;
                    i21 = 31;
                    i16 = (i12 << 15) | (i21 << 10) | i22;
                    return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s4) & 65535) << 48) | ((((long) s5) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
                }
                if (i7 >= -10) {
                    i11 = (i6 | 8388608) >> (1 - i7);
                    if ((i11 & 4096) != 0) {
                        i11 += 8192;
                    }
                    i9 = i11 >> 13;
                    i7 = 0;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
            }
        }
        i10 = i9 | (i4 << 15) | (i7 << 10);
        short s6 = (short) i10;
        iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
        i12 = iFloatToRawIntBits2 >>> 31;
        i13 = (iFloatToRawIntBits2 >>> 23) & 255;
        i14 = 8388607 & iFloatToRawIntBits2;
        if (i13 == 255) {
            i15 = i13 - 112;
            if (i15 < 31) {
                if (i15 <= 0) {
                    i22 = i14 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i16 = (((i15 << 10) | i22) + 1) | (i12 << 15);
                    } else {
                        i21 = i15;
                    }
                } else if (i15 >= -10) {
                    i17 = (i14 | 8388608) >> (1 - i15);
                    if ((i17 & 4096) != 0) {
                        i17 += 8192;
                    }
                    i21 = 0;
                    i22 = i17 >> 13;
                } else {
                    i21 = 0;
                }
            }
            return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s4) & 65535) << 48) | ((((long) s6) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
        }
        i22 = i14 == 0 ? 0 : 512;
        i21 = 31;
        i16 = (i12 << 15) | (i21 << 10) | i22;
        return ((((long) ((short) i16)) & 65535) << 16) | ((((long) s4) & 65535) << 48) | ((((long) s6) & 65535) << 32) | ((((long) ((int) ((Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.id) & 63);
    }

    public static final void addOutline(AndroidPath androidPath, ColorKt colorKt) {
        if (colorKt instanceof Outline$Rectangle) {
            AndroidPath.addRect$default(androidPath, ((Outline$Rectangle) colorKt).rect);
            return;
        }
        if (colorKt instanceof Outline$Rounded) {
            AndroidPath.addRoundRect$default(androidPath, ((Outline$Rounded) colorKt).roundRect);
        } else if (colorKt instanceof Outline$Generic) {
            AndroidPath.m469addPathUv8p0NA$default(androidPath, ((Outline$Generic) colorKt).path);
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        }
    }

    public static final Bitmap asAndroidBitmap(ImageBitmap imageBitmap) {
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).bitmap;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Bitmap");
        return null;
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m489compositeOverOWjLjI(long j, long j2) {
        float f;
        float f2;
        long jM479convertvNxB06k = Color.m479convertvNxB06k(j, Color.m483getColorSpaceimpl(j2));
        float fM481getAlphaimpl = Color.m481getAlphaimpl(j2);
        float fM481getAlphaimpl2 = Color.m481getAlphaimpl(jM479convertvNxB06k);
        float f3 = 1.0f - fM481getAlphaimpl2;
        float f4 = (fM481getAlphaimpl * f3) + fM481getAlphaimpl2;
        float fM485getRedimpl = Color.m485getRedimpl(jM479convertvNxB06k);
        float fM485getRedimpl2 = Color.m485getRedimpl(j2);
        float f5 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (f4 == CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        } else {
            f = (((fM485getRedimpl2 * fM481getAlphaimpl) * f3) + (fM485getRedimpl * fM481getAlphaimpl2)) / f4;
        }
        float fM484getGreenimpl = Color.m484getGreenimpl(jM479convertvNxB06k);
        float fM484getGreenimpl2 = Color.m484getGreenimpl(j2);
        if (f4 == CropImageView.DEFAULT_ASPECT_RATIO) {
            f2 = 0.0f;
        } else {
            f2 = (((fM484getGreenimpl2 * fM481getAlphaimpl) * f3) + (fM484getGreenimpl * fM481getAlphaimpl2)) / f4;
        }
        float fM482getBlueimpl = Color.m482getBlueimpl(jM479convertvNxB06k);
        float fM482getBlueimpl2 = Color.m482getBlueimpl(j2);
        if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
            f5 = (((fM482getBlueimpl2 * fM481getAlphaimpl) * f3) + (fM482getBlueimpl * fM481getAlphaimpl2)) / f4;
        }
        return UncheckedColor(f, f2, f5, f4, Color.m483getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww$default, reason: not valid java name */
    public static void m490drawOutlinewDX37Ww$default(DrawScope drawScope, ColorKt colorKt, long j) {
        if (colorKt instanceof Outline$Rectangle) {
            Rect rect = ((Outline$Rectangle) colorKt).rect;
            float f = rect.left;
            drawScope.mo539drawRectnJ9OG0(j, (((long) Float.floatToRawIntBits(rect.top)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32), size(rect), 1.0f, 3);
            return;
        }
        boolean z = colorKt instanceof Outline$Rounded;
        Fill fill = Fill.INSTANCE;
        if (!z) {
            if (colorKt instanceof Outline$Generic) {
                drawScope.mo537drawPathLG529CI(((Outline$Generic) colorKt).path, j, 1.0f, fill);
                return;
            } else {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
        }
        Outline$Rounded outline$Rounded = (Outline$Rounded) colorKt;
        AndroidPath androidPath = outline$Rounded.roundRectPath;
        if (androidPath != null) {
            drawScope.mo537drawPathLG529CI(androidPath, j, 1.0f, fill);
            return;
        }
        RoundRect roundRect = outline$Rounded.roundRect;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.bottomLeftCornerRadius >> 32));
        drawScope.mo541drawRoundRectuAw5IA(j, (((long) Float.floatToRawIntBits(roundRect.left)) << 32) | (((long) Float.floatToRawIntBits(roundRect.top)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), fill);
    }

    public static void enableZ(android.graphics.Canvas canvas, boolean z) {
        Method method;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            CanvasZHelper.enableZ(canvas, z);
            return;
        }
        if (!orderMethodsFetched) {
            try {
                if (i == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    reorderBarrierMethod = (Method) declaredMethod.invoke(android.graphics.Canvas.class, "insertReorderBarrier", new Class[0]);
                    inorderBarrierMethod = (Method) declaredMethod.invoke(android.graphics.Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    reorderBarrierMethod = android.graphics.Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    inorderBarrierMethod = android.graphics.Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                Method method2 = reorderBarrierMethod;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = inorderBarrierMethod;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            orderMethodsFetched = true;
        }
        if (z) {
            try {
                Method method4 = reorderBarrierMethod;
                if (method4 != null) {
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z || (method = inorderBarrierMethod) == null) {
            return;
        }
        method.invoke(canvas, null);
    }

    public static final Paint getNativePaint(AndroidPaint androidPaint) {
        if (androidPaint == null) {
            InlineClassHelperKt.throwIllegalArgumentException("Extracting native reference is only supported from androidx.compose.ui.graphics.AndroidPaint instances but received " + Reflection.getOrCreateKotlinClass(androidPaint.getClass()).getQualifiedName());
        }
        return androidPaint.internalPaint;
    }

    public static final Modifier graphicsLayer(Modifier modifier, Function1 function1) {
        return modifier.then(new BlockGraphicsLayerElement(function1));
    }

    /* JADX INFO: renamed from: isIdentity-58bKbWc, reason: not valid java name */
    public static final boolean m492isIdentity58bKbWc(float[] fArr) {
        return fArr.length >= 16 && fArr[0] == 1.0f && fArr[1] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[2] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[3] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[4] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[5] == 1.0f && fArr[6] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[7] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[8] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[9] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[10] == 1.0f && fArr[11] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[12] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[13] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[14] == CropImageView.DEFAULT_ASPECT_RATIO && fArr[15] == 1.0f;
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m493lerpjxsXWHM(long j, long j2, float f) {
        Oklab oklab = ColorSpaces.Oklab;
        long jM479convertvNxB06k = Color.m479convertvNxB06k(j, oklab);
        long jM479convertvNxB06k2 = Color.m479convertvNxB06k(j2, oklab);
        float fM481getAlphaimpl = Color.m481getAlphaimpl(jM479convertvNxB06k);
        float fM485getRedimpl = Color.m485getRedimpl(jM479convertvNxB06k);
        float fM484getGreenimpl = Color.m484getGreenimpl(jM479convertvNxB06k);
        float fM482getBlueimpl = Color.m482getBlueimpl(jM479convertvNxB06k);
        float fM481getAlphaimpl2 = Color.m481getAlphaimpl(jM479convertvNxB06k2);
        float fM485getRedimpl2 = Color.m485getRedimpl(jM479convertvNxB06k2);
        float fM484getGreenimpl2 = Color.m484getGreenimpl(jM479convertvNxB06k2);
        float fM482getBlueimpl2 = Color.m482getBlueimpl(jM479convertvNxB06k2);
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m479convertvNxB06k(UncheckedColor(LifecyclesKt.lerp(fM485getRedimpl, fM485getRedimpl2, f), LifecyclesKt.lerp(fM484getGreenimpl, fM484getGreenimpl2, f), LifecyclesKt.lerp(fM482getBlueimpl, fM482getBlueimpl2, f), LifecyclesKt.lerp(fM481getAlphaimpl, fM481getAlphaimpl2, f), oklab), Color.m483getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m494luminance8_81llA(long j) {
        ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j);
        if (!Illuminant.m527equalsimpl0(colorSpaceM483getColorSpaceimpl.model, 12884901888L)) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is ".concat(Illuminant.m528toStringimpl(colorSpaceM483getColorSpaceimpl.model)));
        }
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = ((Rgb) colorSpaceM483getColorSpaceimpl).eotfFunc;
        double dInvoke = rgb$$ExternalSyntheticLambda1.invoke(Color.m485getRedimpl(j));
        float fInvoke = (float) ((rgb$$ExternalSyntheticLambda1.invoke(Color.m482getBlueimpl(j)) * 0.0722d) + (rgb$$ExternalSyntheticLambda1.invoke(Color.m484getGreenimpl(j)) * 0.7152d) + (dInvoke * 0.2126d));
        if (fInvoke < CropImageView.DEFAULT_ASPECT_RATIO) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    public static final int[] makeTransparentColors(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = m498toArgb8_81llA(((Color) list.get(i)).value);
        }
        return iArr;
    }

    public static final float[] makeTransparentStops(List list, List list2) {
        if (list != null) {
            return CollectionsKt.toFloatArray(list);
        }
        return null;
    }

    /* JADX INFO: renamed from: setFrom-EL8BTi8, reason: not valid java name */
    public static final void m495setFromEL8BTi8(android.graphics.Matrix matrix, float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        float f10 = fArr[12];
        float f11 = fArr[13];
        float f12 = fArr[15];
        fArr[0] = f;
        fArr[1] = f5;
        fArr[2] = f10;
        fArr[3] = f2;
        fArr[4] = f6;
        fArr[5] = f11;
        fArr[6] = f4;
        fArr[7] = f8;
        fArr[8] = f12;
        matrix.setValues(fArr);
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
        fArr[8] = f9;
    }

    /* JADX INFO: renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m496setFromtUYjHk(android.graphics.Matrix matrix, float[] fArr) {
        matrix.getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        fArr[0] = f;
        fArr[1] = f4;
        fArr[2] = 0.0f;
        fArr[3] = f7;
        fArr[4] = f2;
        fArr[5] = f5;
        fArr[6] = 0.0f;
        fArr[7] = f8;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f3;
        fArr[13] = f6;
        fArr[14] = 0.0f;
        fArr[15] = f9;
    }

    public static final long size(Rect rect) {
        float f = rect.right - rect.left;
        return (((long) Float.floatToRawIntBits(rect.bottom - rect.top)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final android.graphics.Rect toAndroidRect(IntRect intRect) {
        return new android.graphics.Rect(intRect.left, intRect.top, intRect.right, intRect.bottom);
    }

    public static final RectF toAndroidRectF(Rect rect) {
        return new RectF(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m497toAndroidTileMode0vamqd0(int i) {
        if (i == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i == 2) {
            return Shader.TileMode.MIRROR;
        }
        if (i == 3) {
            return Build.VERSION.SDK_INT >= 31 ? TileModeVerificationHelper.getFrameworkTileModeDecal() : Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.CLAMP;
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m498toArgb8_81llA(long j) {
        return (int) (Color.m479convertvNxB06k(j, ColorSpaces.Srgb) >>> 32);
    }

    /* JADX INFO: renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m499toBitmapConfig1JJdX4A(int i) {
        if (i == 0) {
            return Bitmap.Config.ARGB_8888;
        }
        if (i == 1) {
            return Bitmap.Config.ALPHA_8;
        }
        if (i == 2) {
            return Bitmap.Config.RGB_565;
        }
        if (i == 3) {
            return Bitmap.Config.RGBA_F16;
        }
        return i == 4 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    /* JADX INFO: renamed from: toColorLong-8_81llA, reason: not valid java name */
    public static final long m500toColorLong8_81llA(long j) {
        long j2 = 63 & j;
        int i = (int) j2;
        if (i <= 15) {
            return j;
        }
        if (i == ColorSpaces.Unspecified.id) {
            return m498toArgb8_81llA(j);
        }
        if ((i == ColorSpaces.Bt2020Hlg.id || i == ColorSpaces.Bt2020Pq.id) && Build.VERSION.SDK_INT < 34) {
            return m498toArgb8_81llA(j);
        }
        return (i != ColorSpaces.Oklab.id || Build.VERSION.SDK_INT >= 36) ? (j & (-64)) | (j2 - 1) : m498toArgb8_81llA(j);
    }

    public static final Rect toComposeRect(RectF rectF) {
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public static final long[] toPlatformLongArray(List list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = m503toSupportedColorLong8_81llA(((Color) list.get(i)).value);
        }
        return jArr;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m501toStringimpl(int i) {
        if (i == 0) {
            return "Clear";
        }
        if (i == 1) {
            return "Src";
        }
        if (i == 2) {
            return "Dst";
        }
        if (i == 3) {
            return "SrcOver";
        }
        if (i == 4) {
            return "DstOver";
        }
        if (i == 5) {
            return "SrcIn";
        }
        if (i == 6) {
            return "DstIn";
        }
        if (i == 7) {
            return "SrcOut";
        }
        if (i == 8) {
            return "DstOut";
        }
        if (i == 9) {
            return "SrcAtop";
        }
        if (i == 10) {
            return "DstAtop";
        }
        if (i == 11) {
            return "Xor";
        }
        if (i == 12) {
            return "Plus";
        }
        if (i == 13) {
            return "Modulate";
        }
        if (i == 14) {
            return "Screen";
        }
        if (i == 15) {
            return "Overlay";
        }
        if (i == 16) {
            return "Darken";
        }
        if (i == 17) {
            return "Lighten";
        }
        if (i == 18) {
            return "ColorDodge";
        }
        if (i == 19) {
            return "ColorBurn";
        }
        if (i == 20) {
            return "HardLight";
        }
        if (i == 21) {
            return "Softlight";
        }
        if (i == 22) {
            return "Difference";
        }
        if (i == 23) {
            return "Exclusion";
        }
        if (i == 24) {
            return "Multiply";
        }
        if (i == 25) {
            return "Hue";
        }
        if (i == 26) {
            return "Saturation";
        }
        if (i == 27) {
            return "Color";
        }
        return i == 28 ? "Luminosity" : "Unknown";
    }

    /* JADX INFO: renamed from: toString-impl$1, reason: not valid java name */
    public static String m502toStringimpl$1(int i) {
        if (i == 0) {
            return "Clamp";
        }
        if (i == 1) {
            return "Repeated";
        }
        if (i == 2) {
            return "Mirror";
        }
        return i == 3 ? "Decal" : "Unknown";
    }

    /* JADX INFO: renamed from: toSupportedColorLong-8_81llA, reason: not valid java name */
    public static final long m503toSupportedColorLong8_81llA(long j) {
        int i = (int) (63 & j);
        return (i == ColorSpaces.Oklab.id || i == ColorSpaces.CieXyz.id || i == ColorSpaces.CieLab.id) ? m500toColorLong8_81llA(Color.m479convertvNxB06k(j, ColorSpaces.Srgb)) : m500toColorLong8_81llA(j);
    }

    public static final void validateColorStops(List list, List list2) {
        if (list2 == null) {
            if (list.size() >= 2) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("colors must have length of at least 2 if colorStops is omitted.");
        } else {
            if (list.size() == list2.size()) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("colors and colorStops arguments must have equal length.");
        }
    }

    public static final int writeValidRootInUnitRange(float f, float[] fArr, int i) {
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO) {
            f2 = f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (Math.abs(f2 - f) > 1.05E-6f) {
            f2 = Float.NaN;
        }
        fArr[i] = f2;
        return !Float.isNaN(f2) ? 1 : 0;
    }

    public abstract Rect getBounds();
}
