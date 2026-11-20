package com.materialkolor.ktx;

import android.graphics.Bitmap;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.palette.graphics.ColorCutQuantizer;
import com.materialkolor.quantize.QuantizerCelebi;
import com.materialkolor.quantize.QuantizerWsmeans$Distance;
import com.materialkolor.quantize.QuantizerWu;
import com.materialkolor.utils.MathUtils;
import dagger.hilt.EntryPoints;
import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.XorWowRandom;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u001a-\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001aA\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\r*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0013\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0014\u001a\u0004\u0018\u00010\b*\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aE\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a5\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c²\u0006\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0013\u001a\u00020\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/materialkolor/quantize/QuantizerCelebi;", "Landroidx/compose/ui/graphics/ImageBitmap;", ContentType.Image.TYPE, "", "maxColors", "", "quantize", "(Lcom/materialkolor/quantize/QuantizerCelebi;Landroidx/compose/ui/graphics/ImageBitmap;I)Ljava/util/Map;", "Landroidx/compose/ui/graphics/Color;", "fallback", "", "filter", "desired", "", "themeColors-XO-JAsU", "(Landroidx/compose/ui/graphics/ImageBitmap;IJZI)Ljava/util/List;", "themeColors", "themeColor-RPmYEkk", "(Landroidx/compose/ui/graphics/ImageBitmap;JZI)J", "themeColor", "themeColorOrNull", "(Landroidx/compose/ui/graphics/ImageBitmap;ZI)Landroidx/compose/ui/graphics/Color;", "rememberThemeColors-8V94_ZQ", "(Landroidx/compose/ui/graphics/ImageBitmap;JIZILandroidx/compose/runtime/Composer;II)Ljava/util/List;", "rememberThemeColors", "rememberThemeColor-sW7UJKQ", "(Landroidx/compose/ui/graphics/ImageBitmap;JZILandroidx/compose/runtime/Composer;II)J", "rememberThemeColor", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ImageBitmapKt {
    /* JADX WARN: Code duplicated, block: B:158:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:161:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:163:0x03f8 A[LOOP:7: B:159:0x03ee->B:163:0x03f8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:165:0x0401  */
    /* JADX WARN: Code duplicated, block: B:169:0x040c A[LOOP:6: B:101:0x028b->B:169:0x040c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:353:0x0407 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x03fb A[EDGE_INSN: B:360:0x03fb->B:164:0x03fb BREAK  A[LOOP:7: B:159:0x03ee->B:163:0x03f8], SYNTHETIC] */
    public static final Map<Integer, Integer> quantize(QuantizerCelebi quantizerCelebi, ImageBitmap imageBitmap, int i) {
        Bitmap bitmapCopy;
        boolean z;
        String str;
        int[] iArr;
        String str2;
        int i2;
        Integer numValueOf;
        QuantizerWsmeans$Distance[][] quantizerWsmeans$DistanceArr;
        int[] iArr2;
        int i3;
        int i4;
        double dVariance;
        double dVariance2;
        int i5;
        double d;
        double d2;
        int i6;
        int i7;
        double d3;
        quantizerCelebi.getClass();
        imageBitmap.getClass();
        AndroidImageBitmap androidImageBitmap = (AndroidImageBitmap) imageBitmap;
        Bitmap bitmap = androidImageBitmap.bitmap;
        int height = bitmap.getHeight() * bitmap.getWidth();
        int[] iArr3 = new int[height];
        int width = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap bitmapAsAndroidBitmap = androidx.compose.ui.graphics.ColorKt.asAndroidBitmap(androidImageBitmap);
        int i8 = 1;
        int i9 = 0;
        if (bitmapAsAndroidBitmap.getConfig() != Bitmap.Config.HARDWARE) {
            bitmapCopy = bitmapAsAndroidBitmap;
            z = false;
        } else {
            bitmapCopy = bitmapAsAndroidBitmap.copy(Bitmap.Config.ARGB_8888, false);
            z = true;
        }
        bitmapCopy.getPixels(iArr3, 0, width, 0, 0, width, height2);
        if (z) {
            bitmapCopy.recycle();
        }
        QuantizerWu quantizerWu = new QuantizerWu();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 = 0; i10 < height; i10++) {
            int i11 = iArr3[i10];
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i11));
            linkedHashMap.put(Integer.valueOf(i11), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
        }
        quantizerWu.weights = new int[35937];
        quantizerWu.momentsR = new int[35937];
        quantizerWu.momentsG = new int[35937];
        quantizerWu.momentsB = new int[35937];
        quantizerWu.moments = new double[35937];
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            String str3 = "weights";
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                int iIntValue = ((Number) entry.getKey()).intValue();
                int iIntValue2 = ((Number) entry.getValue()).intValue();
                int i12 = (iIntValue >> 16) & 255;
                int i13 = (iIntValue >> 8) & 255;
                int i14 = iIntValue & 255;
                int i15 = i9;
                int i16 = i8;
                Iterator it2 = it;
                int index = CollectionsKt__IterablesKt.getIndex((i12 >> 3) + 1, (i13 >> 3) + 1, (i14 >> 3) + 1);
                int[] iArr4 = (int[]) quantizerWu.weights;
                if (iArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("weights");
                    throw null;
                }
                iArr4[index] = iArr4[index] + iIntValue2;
                int[] iArr5 = (int[]) quantizerWu.momentsR;
                if (iArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("momentsR");
                    throw null;
                }
                iArr5[index] = (i12 * iIntValue2) + iArr5[index];
                int[] iArr6 = (int[]) quantizerWu.momentsG;
                if (iArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("momentsG");
                    throw null;
                }
                iArr6[index] = (i13 * iIntValue2) + iArr6[index];
                int[] iArr7 = (int[]) quantizerWu.momentsB;
                if (iArr7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("momentsB");
                    throw null;
                }
                iArr7[index] = (i14 * iIntValue2) + iArr7[index];
                double[] dArr = (double[]) quantizerWu.moments;
                if (dArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moments");
                    throw null;
                }
                dArr[index] = dArr[index] + ((double) (((i14 * i14) + (i13 * i13) + (i12 * i12)) * iIntValue2));
                i9 = i15;
                it = it2;
                i8 = i16;
            } else {
                int i17 = i8;
                int i18 = i9;
                int i19 = i17;
                while (true) {
                    int i20 = 33;
                    if (i19 < 33) {
                        int[] iArr8 = new int[33];
                        int[] iArr9 = new int[33];
                        int[] iArr10 = new int[33];
                        int[] iArr11 = new int[33];
                        double[] dArr2 = new double[33];
                        int i21 = i17;
                        while (i21 < i20) {
                            int i22 = i18;
                            int i23 = i22;
                            int i24 = i23;
                            int i25 = i24;
                            double[] dArr3 = dArr2;
                            int i26 = i17;
                            double d4 = 0.0d;
                            while (i26 < i20) {
                                int index2 = CollectionsKt__IterablesKt.getIndex(i19, i21, i26);
                                int[] iArr12 = (int[]) quantizerWu.weights;
                                if (iArr12 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("weights");
                                    throw null;
                                }
                                i22 += iArr12[index2];
                                int[] iArr13 = (int[]) quantizerWu.momentsR;
                                if (iArr13 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("momentsR");
                                    throw null;
                                }
                                i23 += iArr13[index2];
                                int[] iArr14 = (int[]) quantizerWu.momentsG;
                                if (iArr14 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("momentsG");
                                    throw null;
                                }
                                i24 += iArr14[index2];
                                int[] iArr15 = (int[]) quantizerWu.momentsB;
                                if (iArr15 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("momentsB");
                                    throw null;
                                }
                                i25 += iArr15[index2];
                                double[] dArr4 = (double[]) quantizerWu.moments;
                                if (dArr4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("moments");
                                    throw null;
                                }
                                d4 += dArr4[index2];
                                iArr8[i26] = iArr8[i26] + i22;
                                iArr9[i26] = iArr9[i26] + i23;
                                iArr10[i26] = iArr10[i26] + i24;
                                iArr11[i26] = iArr11[i26] + i25;
                                dArr3[i26] = dArr3[i26] + d4;
                                int index3 = CollectionsKt__IterablesKt.getIndex(i19 - 1, i21, i26);
                                int i27 = i19;
                                int[] iArr16 = (int[]) quantizerWu.weights;
                                if (iArr16 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("weights");
                                    throw null;
                                }
                                iArr16[index2] = iArr16[index3] + iArr8[i26];
                                int[] iArr17 = (int[]) quantizerWu.momentsR;
                                if (iArr17 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("momentsR");
                                    throw null;
                                }
                                iArr17[index2] = iArr17[index3] + iArr9[i26];
                                int[] iArr18 = (int[]) quantizerWu.momentsG;
                                if (iArr18 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("momentsG");
                                    throw null;
                                }
                                iArr18[index2] = iArr18[index3] + iArr10[i26];
                                int[] iArr19 = (int[]) quantizerWu.momentsB;
                                if (iArr19 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("momentsB");
                                    throw null;
                                }
                                iArr19[index2] = iArr19[index3] + iArr11[i26];
                                double[] dArr5 = (double[]) quantizerWu.moments;
                                if (dArr5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("moments");
                                    throw null;
                                }
                                dArr5[index2] = dArr5[index3] + dArr3[i26];
                                i26++;
                                i19 = i27;
                                i20 = 33;
                            }
                            i21++;
                            dArr2 = dArr3;
                            i20 = 33;
                        }
                        i19++;
                    } else {
                        quantizerWu.cubes = new QuantizerWu.Box[i];
                        int i28 = i18;
                        while (true) {
                            String str4 = "cubes";
                            if (i28 >= i) {
                                double[] dArr6 = new double[i];
                                QuantizerWu.Box[] boxArr = (QuantizerWu.Box[]) quantizerWu.cubes;
                                if (boxArr == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("cubes");
                                    throw null;
                                }
                                QuantizerWu.Box box = boxArr[i18];
                                box.getClass();
                                box.r1 = 32;
                                box.g1 = 32;
                                box.b1 = 32;
                                int i29 = i18;
                                int i30 = i17;
                                while (true) {
                                    if (i30 >= i) {
                                        str = str4;
                                        iArr = iArr3;
                                        str2 = str3;
                                        i2 = i;
                                        break;
                                    }
                                    QuantizerWu.Box[] boxArr2 = (QuantizerWu.Box[]) quantizerWu.cubes;
                                    if (boxArr2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str4);
                                        throw null;
                                    }
                                    QuantizerWu.Box box2 = boxArr2[i29];
                                    QuantizerWu.Box box3 = boxArr2[i30];
                                    int[] iArr20 = (int[]) quantizerWu.momentsR;
                                    if (iArr20 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("momentsR");
                                        throw null;
                                    }
                                    int iVolume = CollectionsKt__IterablesKt.volume(box2, iArr20);
                                    int[] iArr21 = (int[]) quantizerWu.momentsG;
                                    if (iArr21 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("momentsG");
                                        throw null;
                                    }
                                    int iVolume2 = CollectionsKt__IterablesKt.volume(box2, iArr21);
                                    int[] iArr22 = (int[]) quantizerWu.momentsB;
                                    if (iArr22 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("momentsB");
                                        throw null;
                                    }
                                    int iVolume3 = CollectionsKt__IterablesKt.volume(box2, iArr22);
                                    int[] iArr23 = (int[]) quantizerWu.weights;
                                    if (iArr23 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str3);
                                        throw null;
                                    }
                                    int iVolume4 = CollectionsKt__IterablesKt.volume(box2, iArr23);
                                    int i31 = box2.r0 + 1;
                                    int i32 = box2.r1;
                                    QuantizerWu.Direction direction = QuantizerWu.Direction.RED;
                                    QuantizerWu.MaximizeResult maximizeResultMaximize = quantizerWu.maximize(box2, direction, i31, i32, iVolume, iVolume2, iVolume3, iVolume4);
                                    double[] dArr7 = dArr6;
                                    int i33 = maximizeResultMaximize.cutLocation;
                                    str = str4;
                                    int i34 = box2.g0 + 1;
                                    int i35 = box2.g1;
                                    QuantizerWu.Direction direction2 = QuantizerWu.Direction.GREEN;
                                    QuantizerWu.MaximizeResult maximizeResultMaximize2 = quantizerWu.maximize(box2, direction2, i34, i35, iVolume, iVolume2, iVolume3, iVolume4);
                                    int i36 = i29;
                                    int i37 = i30;
                                    int i38 = box2.b0 + 1;
                                    int i39 = box2.b1;
                                    QuantizerWu.Direction direction3 = QuantizerWu.Direction.BLUE;
                                    QuantizerWu.MaximizeResult maximizeResultMaximize3 = quantizerWu.maximize(box2, direction3, i38, i39, iVolume, iVolume2, iVolume3, iVolume4);
                                    str2 = str3;
                                    iArr = iArr3;
                                    double d5 = maximizeResultMaximize.maximum;
                                    double d6 = maximizeResultMaximize2.maximum;
                                    double d7 = maximizeResultMaximize3.maximum;
                                    if (d5 >= d6 && d5 >= d7) {
                                        if (i33 < 0) {
                                            dArr7[i36] = 0.0d;
                                            i5 = i37 - 1;
                                        } else {
                                            direction3 = direction;
                                        }
                                        d = dArr7[i18];
                                        if (1 <= i5) {
                                            d2 = d;
                                            i6 = 1;
                                            i7 = i18;
                                            while (true) {
                                                d3 = dArr7[i6];
                                                if (d3 > d2) {
                                                    i7 = i6;
                                                    d2 = d3;
                                                }
                                                if (i6 != i5) {
                                                    break;
                                                }
                                                i6++;
                                            }
                                            i29 = i7;
                                            d = d2;
                                        } else {
                                            i29 = i18;
                                        }
                                        if (d <= 0.0d) {
                                            i2 = i5 + 1;
                                            break;
                                        }
                                        i30 = i5 + 1;
                                        iArr3 = iArr;
                                        str3 = str2;
                                        dArr6 = dArr7;
                                        str4 = str;
                                        i17 = 1;
                                    } else if (d6 >= d5 && d6 >= d7) {
                                        direction3 = direction2;
                                    }
                                    box3.getClass();
                                    box3.r1 = box2.r1;
                                    box3.g1 = box2.g1;
                                    box3.b1 = box2.b1;
                                    int iOrdinal = direction3.ordinal();
                                    if (iOrdinal == 0) {
                                        box2.r1 = i33;
                                        box3.r0 = i33;
                                        i3 = box2.g0;
                                        box3.g0 = i3;
                                        i4 = box2.b0;
                                        box3.b0 = i4;
                                    } else if (iOrdinal == i17) {
                                        i3 = maximizeResultMaximize2.cutLocation;
                                        box2.g1 = i3;
                                        i33 = box2.r0;
                                        box3.r0 = i33;
                                        box3.g0 = i3;
                                        i4 = box2.b0;
                                        box3.b0 = i4;
                                    } else {
                                        if (iOrdinal != 2) {
                                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                                            return null;
                                        }
                                        int i40 = maximizeResultMaximize3.cutLocation;
                                        box2.b1 = i40;
                                        int i41 = box2.r0;
                                        box3.r0 = i41;
                                        i3 = box2.g0;
                                        box3.g0 = i3;
                                        box3.b0 = i40;
                                        i4 = i40;
                                        i33 = i41;
                                    }
                                    box2.vol = (box2.b1 - box2.b0) * (box2.g1 - box2.g0) * (box2.r1 - box2.r0);
                                    box3.vol = (box3.b1 - i4) * (box3.g1 - i3) * (box3.r1 - i33);
                                    QuantizerWu.Box[] boxArr3 = (QuantizerWu.Box[]) quantizerWu.cubes;
                                    if (boxArr3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str);
                                        throw null;
                                    }
                                    QuantizerWu.Box box4 = boxArr3[i36];
                                    box4.getClass();
                                    if (box4.vol > 1) {
                                        QuantizerWu.Box[] boxArr4 = (QuantizerWu.Box[]) quantizerWu.cubes;
                                        if (boxArr4 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(str);
                                            throw null;
                                        }
                                        dVariance = quantizerWu.variance(boxArr4[i36]);
                                    } else {
                                        dVariance = 0.0d;
                                    }
                                    dArr7[i36] = dVariance;
                                    QuantizerWu.Box[] boxArr5 = (QuantizerWu.Box[]) quantizerWu.cubes;
                                    if (boxArr5 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str);
                                        throw null;
                                    }
                                    QuantizerWu.Box box5 = boxArr5[i37];
                                    box5.getClass();
                                    if (box5.vol > 1) {
                                        QuantizerWu.Box[] boxArr6 = (QuantizerWu.Box[]) quantizerWu.cubes;
                                        if (boxArr6 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(str);
                                            throw null;
                                        }
                                        dVariance2 = quantizerWu.variance(boxArr6[i37]);
                                    } else {
                                        dVariance2 = 0.0d;
                                    }
                                    dArr7[i37] = dVariance2;
                                    i5 = i37;
                                    d = dArr7[i18];
                                    if (1 <= i5) {
                                        d2 = d;
                                        i6 = 1;
                                        i7 = i18;
                                        while (true) {
                                            d3 = dArr7[i6];
                                            if (d3 > d2) {
                                                i7 = i6;
                                                d2 = d3;
                                            }
                                            if (i6 != i5) {
                                                break;
                                                break;
                                            }
                                            i6++;
                                        }
                                        i29 = i7;
                                        d = d2;
                                    } else {
                                        i29 = i18;
                                    }
                                    if (d <= 0.0d) {
                                        i2 = i5 + 1;
                                        break;
                                    }
                                    i30 = i5 + 1;
                                    iArr3 = iArr;
                                    str3 = str2;
                                    dArr6 = dArr7;
                                    str4 = str;
                                    i17 = 1;
                                }
                                ArrayList arrayList = new ArrayList();
                                for (int i42 = i18; i42 < i2; i42++) {
                                    QuantizerWu.Box[] boxArr7 = (QuantizerWu.Box[]) quantizerWu.cubes;
                                    if (boxArr7 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str);
                                        throw null;
                                    }
                                    QuantizerWu.Box box6 = boxArr7[i42];
                                    int[] iArr24 = (int[]) quantizerWu.weights;
                                    if (iArr24 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str2);
                                        throw null;
                                    }
                                    int iVolume5 = CollectionsKt__IterablesKt.volume(box6, iArr24);
                                    if (iVolume5 > 0) {
                                        int[] iArr25 = (int[]) quantizerWu.momentsR;
                                        if (iArr25 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("momentsR");
                                            throw null;
                                        }
                                        int iVolume6 = CollectionsKt__IterablesKt.volume(box6, iArr25) / iVolume5;
                                        int[] iArr26 = (int[]) quantizerWu.momentsG;
                                        if (iArr26 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("momentsG");
                                            throw null;
                                        }
                                        int iVolume7 = CollectionsKt__IterablesKt.volume(box6, iArr26) / iVolume5;
                                        int[] iArr27 = (int[]) quantizerWu.momentsB;
                                        if (iArr27 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("momentsB");
                                            throw null;
                                        }
                                        arrayList.add(Integer.valueOf(((CollectionsKt__IterablesKt.volume(box6, iArr27) / iVolume5) & 255) | ((iVolume6 & 255) << 16) | (-16777216) | ((iVolume7 & 255) << 8)));
                                    }
                                }
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                int size = arrayList.size();
                                int i43 = i18;
                                while (i43 < size) {
                                    Object obj = arrayList.get(i43);
                                    i43++;
                                    linkedHashMap2.put(Integer.valueOf(((Number) obj).intValue()), Integer.valueOf(i18));
                                }
                                Set setKeySet = linkedHashMap2.keySet();
                                int size2 = setKeySet.size();
                                int[] iArr28 = new int[size2];
                                Iterator it3 = setKeySet.iterator();
                                int i44 = i18;
                                while (it3.hasNext()) {
                                    iArr28[i44] = ((Number) it3.next()).intValue();
                                    i44++;
                                }
                                XorWowRandom xorWowRandom = new XorWowRandom(272008, i18);
                                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                                double[][] dArr8 = new double[height][];
                                int[] iArr29 = new int[height];
                                int i45 = 0;
                                for (int i46 = 0; i46 < height; i46++) {
                                    int i47 = iArr[i46];
                                    Integer num2 = (Integer) linkedHashMap3.get(Integer.valueOf(i47));
                                    if (num2 == null) {
                                        double[] dArrLabFromArgb = MathUtils.labFromArgb(i47);
                                        dArr8[i45] = new double[]{dArrLabFromArgb[0], dArrLabFromArgb[1], dArrLabFromArgb[2]};
                                        iArr29[i45] = i47;
                                        i45++;
                                        linkedHashMap3.put(Integer.valueOf(i47), 1);
                                    } else {
                                        linkedHashMap3.put(Integer.valueOf(i47), Integer.valueOf(num2.intValue() + 1));
                                    }
                                }
                                int[] iArr30 = new int[i45];
                                for (int i48 = 0; i48 < i45; i48++) {
                                    Object obj2 = linkedHashMap3.get(Integer.valueOf(iArr29[i48]));
                                    obj2.getClass();
                                    iArr30[i48] = ((Number) obj2).intValue();
                                }
                                int iMin = Math.min(i, i45);
                                if (size2 != 0) {
                                    iMin = Math.min(iMin, size2);
                                }
                                double[][] dArr9 = new double[iMin][];
                                for (int i49 = 0; i49 < size2; i49++) {
                                    double[] dArrLabFromArgb2 = MathUtils.labFromArgb(iArr28[i49]);
                                    dArr9[i49] = new double[]{dArrLabFromArgb2[0], dArrLabFromArgb2[1], dArrLabFromArgb2[2]};
                                }
                                int i50 = 0;
                                int[] iArr31 = new int[i45];
                                int i51 = 0;
                                while (i51 < i45) {
                                    iArr31[i51] = xorWowRandom.nextInt(i50, iMin);
                                    i51++;
                                    i50 = 0;
                                }
                                int[][] iArr32 = new int[iMin][];
                                for (int i52 = 0; i52 < iMin; i52++) {
                                    iArr32[i52] = new int[iMin];
                                }
                                QuantizerWsmeans$Distance[][] quantizerWsmeans$DistanceArr2 = new QuantizerWsmeans$Distance[iMin][];
                                for (int i53 = 0; i53 < iMin; i53++) {
                                    QuantizerWsmeans$Distance[] quantizerWsmeans$DistanceArr3 = new QuantizerWsmeans$Distance[iMin];
                                    for (int i54 = 0; i54 < iMin; i54++) {
                                        quantizerWsmeans$DistanceArr3[i54] = new QuantizerWsmeans$Distance();
                                    }
                                    quantizerWsmeans$DistanceArr2[i53] = quantizerWsmeans$DistanceArr3;
                                }
                                for (int i55 = 0; i55 < iMin; i55++) {
                                    quantizerWsmeans$DistanceArr2[i55] = new QuantizerWsmeans$Distance[iMin];
                                    for (int i56 = 0; i56 < iMin; i56++) {
                                        quantizerWsmeans$DistanceArr2[i55][i56] = new QuantizerWsmeans$Distance();
                                    }
                                }
                                int[] iArr33 = new int[iMin];
                                int i57 = 0;
                                while (i57 < 10) {
                                    int i58 = 0;
                                    while (i58 < iMin) {
                                        int i59 = i58 + 1;
                                        for (int i60 = i59; i60 < iMin; i60++) {
                                            double[] dArr10 = dArr9[i58];
                                            dArr10.getClass();
                                            double[] dArr11 = dArr9[i60];
                                            dArr11.getClass();
                                            double dDistance = Okio__OkioKt.distance(dArr10, dArr11);
                                            QuantizerWsmeans$Distance quantizerWsmeans$Distance = quantizerWsmeans$DistanceArr2[i60][i58];
                                            quantizerWsmeans$Distance.getClass();
                                            quantizerWsmeans$Distance.distance = dDistance;
                                            QuantizerWsmeans$Distance quantizerWsmeans$Distance2 = quantizerWsmeans$DistanceArr2[i60][i58];
                                            quantizerWsmeans$Distance2.getClass();
                                            quantizerWsmeans$Distance2.index = i58;
                                            QuantizerWsmeans$Distance quantizerWsmeans$Distance3 = quantizerWsmeans$DistanceArr2[i58][i60];
                                            quantizerWsmeans$Distance3.getClass();
                                            quantizerWsmeans$Distance3.distance = dDistance;
                                            QuantizerWsmeans$Distance quantizerWsmeans$Distance4 = quantizerWsmeans$DistanceArr2[i58][i60];
                                            quantizerWsmeans$Distance4.getClass();
                                            quantizerWsmeans$Distance4.index = i60;
                                        }
                                        QuantizerWsmeans$Distance[] quantizerWsmeans$DistanceArr4 = quantizerWsmeans$DistanceArr2[i58];
                                        if (quantizerWsmeans$DistanceArr4.length > 1) {
                                            ColorCutQuantizer.AnonymousClass1 anonymousClass1 = new ColorCutQuantizer.AnonymousClass1((byte) 5);
                                            if (quantizerWsmeans$DistanceArr4.length > 1) {
                                                Arrays.sort(quantizerWsmeans$DistanceArr4, anonymousClass1);
                                            }
                                        }
                                        for (int i61 = 0; i61 < iMin; i61++) {
                                            int[] iArr34 = iArr32[i58];
                                            iArr34.getClass();
                                            QuantizerWsmeans$Distance quantizerWsmeans$Distance5 = quantizerWsmeans$DistanceArr2[i58][i61];
                                            quantizerWsmeans$Distance5.getClass();
                                            iArr34[i61] = quantizerWsmeans$Distance5.index;
                                        }
                                        i58 = i59;
                                    }
                                    int i62 = 0;
                                    int i63 = 0;
                                    while (i62 < i45) {
                                        double[] dArr12 = dArr8[i62];
                                        dArr12.getClass();
                                        int i64 = iArr31[i62];
                                        double[] dArr13 = dArr9[i64];
                                        dArr13.getClass();
                                        double dDistance2 = Okio__OkioKt.distance(dArr12, dArr13);
                                        int[][] iArr35 = iArr32;
                                        int[] iArr36 = iArr31;
                                        double d8 = dDistance2;
                                        int i65 = 0;
                                        int i66 = -1;
                                        while (i65 < iMin) {
                                            int i67 = i65;
                                            QuantizerWsmeans$Distance quantizerWsmeans$Distance6 = quantizerWsmeans$DistanceArr2[i64][i67];
                                            if (quantizerWsmeans$Distance6 == null) {
                                                quantizerWsmeans$DistanceArr = quantizerWsmeans$DistanceArr2;
                                                iArr2 = iArr30;
                                            } else {
                                                quantizerWsmeans$DistanceArr = quantizerWsmeans$DistanceArr2;
                                                iArr2 = iArr30;
                                                if (quantizerWsmeans$Distance6.distance < 4.0d * dDistance2) {
                                                    double[] dArr14 = dArr9[i67];
                                                    dArr14.getClass();
                                                    double dDistance3 = Okio__OkioKt.distance(dArr12, dArr14);
                                                    if (dDistance3 < d8) {
                                                        d8 = dDistance3;
                                                        i66 = i67;
                                                    }
                                                }
                                            }
                                            i65 = i67 + 1;
                                            iArr30 = iArr2;
                                            quantizerWsmeans$DistanceArr2 = quantizerWsmeans$DistanceArr;
                                        }
                                        QuantizerWsmeans$Distance[][] quantizerWsmeans$DistanceArr5 = quantizerWsmeans$DistanceArr2;
                                        int[] iArr37 = iArr30;
                                        if (i66 != -1 && Math.abs(Math.sqrt(d8) - Math.sqrt(dDistance2)) > 3.0d) {
                                            i63++;
                                            iArr36[i62] = i66;
                                        }
                                        i62++;
                                        iArr32 = iArr35;
                                        iArr31 = iArr36;
                                        iArr30 = iArr37;
                                        quantizerWsmeans$DistanceArr2 = quantizerWsmeans$DistanceArr5;
                                    }
                                    int[][] iArr38 = iArr32;
                                    int[] iArr39 = iArr31;
                                    QuantizerWsmeans$Distance[][] quantizerWsmeans$DistanceArr6 = quantizerWsmeans$DistanceArr2;
                                    int[] iArr40 = iArr30;
                                    if (i63 == 0 && i57 != 0) {
                                        break;
                                    }
                                    double[] dArr15 = new double[iMin];
                                    double[] dArr16 = new double[iMin];
                                    double[] dArr17 = new double[iMin];
                                    char c = 0;
                                    Arrays.fill(iArr33, 0, iMin, 0);
                                    int i68 = 0;
                                    while (i68 < i45) {
                                        int i69 = iArr39[i68];
                                        double[] dArr18 = dArr8[i68];
                                        int i70 = iArr40[i68];
                                        iArr33[i69] = iArr33[i69] + i70;
                                        double d9 = dArr15[i69];
                                        dArr18.getClass();
                                        double d10 = i70;
                                        dArr15[i69] = (dArr18[c] * d10) + d9;
                                        dArr16[i69] = (dArr18[1] * d10) + dArr16[i69];
                                        dArr17[i69] = (dArr18[2] * d10) + dArr17[i69];
                                        i68++;
                                        c = 0;
                                    }
                                    for (int i71 = 0; i71 < iMin; i71++) {
                                        int i72 = iArr33[i71];
                                        if (i72 == 0) {
                                            dArr9[i71] = new double[]{0.0d, 0.0d, 0.0d};
                                        } else {
                                            double d11 = i72;
                                            double d12 = dArr15[i71] / d11;
                                            double d13 = dArr16[i71] / d11;
                                            double d14 = dArr17[i71] / d11;
                                            double[] dArr19 = dArr9[i71];
                                            dArr19.getClass();
                                            dArr19[0] = d12;
                                            double[] dArr20 = dArr9[i71];
                                            dArr20.getClass();
                                            dArr20[1] = d13;
                                            double[] dArr21 = dArr9[i71];
                                            dArr21.getClass();
                                            dArr21[2] = d14;
                                        }
                                    }
                                    i57++;
                                    iArr32 = iArr38;
                                    iArr31 = iArr39;
                                    iArr30 = iArr40;
                                    quantizerWsmeans$DistanceArr2 = quantizerWsmeans$DistanceArr6;
                                }
                                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                                for (int i73 = 0; i73 < iMin; i73++) {
                                    int i74 = iArr33[i73];
                                    if (i74 != 0) {
                                        double[] dArr22 = dArr9[i73];
                                        if (dArr22 != null) {
                                            double d15 = dArr22[0];
                                            double d16 = dArr22[1];
                                            double d17 = (d15 + 16.0d) / 116.0d;
                                            double d18 = d17 - (dArr22[2] / 200.0d);
                                            double dLabInvf = MathUtils.labInvf((d16 / 500.0d) + d17);
                                            double dLabInvf2 = MathUtils.labInvf(d17);
                                            double dLabInvf3 = MathUtils.labInvf(d18);
                                            double[] dArr23 = MathUtils.WHITE_POINT_D65;
                                            numValueOf = Integer.valueOf(MathUtils.argbFromXyz(dLabInvf * dArr23[0], dLabInvf2 * dArr23[1], dLabInvf3 * dArr23[2]));
                                        } else {
                                            numValueOf = null;
                                        }
                                        if (numValueOf != null && !linkedHashMap4.containsKey(numValueOf)) {
                                            linkedHashMap4.put(numValueOf, Integer.valueOf(i74));
                                        }
                                    }
                                }
                                return linkedHashMap4;
                            }
                            QuantizerWu.Box[] boxArr8 = (QuantizerWu.Box[]) quantizerWu.cubes;
                            if (boxArr8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cubes");
                                throw null;
                            }
                            boxArr8[i28] = new QuantizerWu.Box();
                            i28++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: rememberThemeColor-sW7UJKQ, reason: not valid java name */
    public static final long m974rememberThemeColorsW7UJKQ(ImageBitmap imageBitmap, long j, boolean z, int i, Composer composer, int i2, int i3) {
        imageBitmap.getClass();
        if ((i3 & 2) != 0) {
            j = ((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
        }
        long j2 = j;
        boolean z2 = true;
        boolean z3 = (i3 & 4) != 0 ? true : z;
        if ((i3 & 8) != 0) {
            i = 128;
        }
        int i4 = i;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.mutableStateOf$default(new Color(j2));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        Object[] objArr = {imageBitmap, new Color(j2), Boolean.valueOf(z3), Integer.valueOf(i4)};
        boolean z4 = ((((i2 & 14) ^ 6) > 4 && gapComposer.changedInstance(imageBitmap)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && gapComposer.changed(j2)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && gapComposer.changed(z3)) || (i2 & 384) == 256);
        if ((((i2 & 7168) ^ 3072) <= 2048 || !gapComposer.changed(i4)) && (i2 & 3072) != 2048) {
            z2 = false;
        }
        boolean z5 = z2 | z4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z5 || objRememberedValue2 == neverEqualPolicy) {
            ImageBitmapKt$rememberThemeColor$1$1 imageBitmapKt$rememberThemeColor$1$1 = new ImageBitmapKt$rememberThemeColor$1$1(imageBitmap, j2, z3, i4, mutableState, null);
            gapComposer.updateRememberedValue(imageBitmapKt$rememberThemeColor$1$1);
            objRememberedValue2 = imageBitmapKt$rememberThemeColor$1$1;
        }
        Stack.LaunchedEffect(objArr, (Function2) objRememberedValue2, gapComposer);
        return ((Color) mutableState.getValue()).value;
    }

    /* JADX INFO: renamed from: rememberThemeColors-8V94_ZQ, reason: not valid java name */
    public static final List<Color> m975rememberThemeColors8V94_ZQ(ImageBitmap imageBitmap, long j, int i, boolean z, int i2, Composer composer, int i3, int i4) {
        long j2;
        MutableState mutableState;
        imageBitmap.getClass();
        if ((i4 & 2) != 0) {
            j2 = ((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
        } else {
            j2 = j;
        }
        int i5 = (i4 & 4) != 0 ? 128 : i;
        boolean z2 = true;
        boolean z3 = (i4 & 8) != 0 ? true : z;
        int i6 = (i4 & 16) != 0 ? 4 : i2;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.mutableStateOf$default(CollectionsKt__IterablesKt.listOf(new Color(j2)));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState2 = (MutableState) objRememberedValue;
        Object[] objArr = {imageBitmap, new Color(j2), Boolean.valueOf(z3), Integer.valueOf(i5)};
        boolean z4 = ((((i3 & 14) ^ 6) > 4 && gapComposer.changedInstance(imageBitmap)) || (i3 & 6) == 4) | ((((i3 & 896) ^ 384) > 256 && gapComposer.changed(i5)) || (i3 & 384) == 256) | ((((i3 & 112) ^ 48) > 32 && gapComposer.changed(j2)) || (i3 & 48) == 32) | ((((i3 & 7168) ^ 3072) > 2048 && gapComposer.changed(z3)) || (i3 & 3072) == 2048);
        if ((((57344 & i3) ^ 24576) <= 16384 || !gapComposer.changed(i6)) && (i3 & 24576) != 16384) {
            z2 = false;
        }
        boolean z5 = z4 | z2;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z5 || objRememberedValue2 == neverEqualPolicy) {
            int i7 = i6;
            mutableState = mutableState2;
            ImageBitmapKt$rememberThemeColors$1$1 imageBitmapKt$rememberThemeColors$1$1 = new ImageBitmapKt$rememberThemeColors$1$1(imageBitmap, i5, j2, z3, i7, mutableState, null);
            gapComposer.updateRememberedValue(imageBitmapKt$rememberThemeColors$1$1);
            objRememberedValue2 = imageBitmapKt$rememberThemeColors$1$1;
        } else {
            mutableState = mutableState2;
        }
        Stack.LaunchedEffect(objArr, (Function2) objRememberedValue2, gapComposer);
        return (List) mutableState.getValue();
    }

    /* JADX INFO: renamed from: themeColor-RPmYEkk, reason: not valid java name */
    public static final long m976themeColorRPmYEkk(ImageBitmap imageBitmap, long j, boolean z, int i) {
        imageBitmap.getClass();
        return ((Color) CollectionsKt.first(m979themeColorsXOJAsU$default(imageBitmap, i, j, z, 0, 8, null))).value;
    }

    /* JADX INFO: renamed from: themeColor-RPmYEkk$default, reason: not valid java name */
    public static /* synthetic */ long m977themeColorRPmYEkk$default(ImageBitmap imageBitmap, long j, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = 128;
        }
        return m976themeColorRPmYEkk(imageBitmap, j, z, i);
    }

    public static final Color themeColorOrNull(ImageBitmap imageBitmap, boolean z, int i) {
        imageBitmap.getClass();
        Integer num = (Integer) CollectionsKt.firstOrNull((List) EntryPoints.score(quantize(QuantizerCelebi.INSTANCE, imageBitmap, i), 1, null, z));
        if (num != null) {
            return new Color(((long) num.intValue()) << 32);
        }
        return null;
    }

    public static /* synthetic */ Color themeColorOrNull$default(ImageBitmap imageBitmap, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 128;
        }
        return themeColorOrNull(imageBitmap, z, i);
    }

    /* JADX INFO: renamed from: themeColors-XO-JAsU, reason: not valid java name */
    public static final List<Color> m978themeColorsXOJAsU(ImageBitmap imageBitmap, int i, long j, boolean z, int i2) {
        imageBitmap.getClass();
        ArrayList arrayListScore = EntryPoints.score(quantize(QuantizerCelebi.INSTANCE, imageBitmap, i), i2, Integer.valueOf(androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j)), z);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListScore, 10));
        int size = arrayListScore.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListScore.get(i3);
            i3++;
            arrayList.add(new Color(((long) ((Number) obj).intValue()) << 32));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: themeColors-XO-JAsU$default, reason: not valid java name */
    public static List m979themeColorsXOJAsU$default(ImageBitmap imageBitmap, int i, long j, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 128;
        }
        if ((i3 & 2) != 0) {
            j = -53332962556510208L;
        }
        if ((i3 & 4) != 0) {
            z = true;
        }
        if ((i3 & 8) != 0) {
            i2 = 4;
        }
        return m978themeColorsXOJAsU(imageBitmap, i, j, z, i2);
    }
}
