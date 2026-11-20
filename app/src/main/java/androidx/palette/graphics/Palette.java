package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Palette {
    public static final AnonymousClass1 DEFAULT_FILTER = new AnonymousClass1();
    public final Swatch mDominantSwatch;
    public final List mSwatches;
    public final SparseBooleanArray mUsedColors = new SparseBooleanArray();
    public final ArrayMap mSelectedSwatches = new ArrayMap(0);

    /* JADX INFO: renamed from: androidx.palette.graphics.Palette$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public final Bitmap mBitmap;
        public final ArrayList mFilters;
        public byte mMaxColors;
        public final ArrayList mTargets;

        public Builder(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.mTargets = arrayList;
            this.mMaxColors = (byte) 16;
            ArrayList arrayList2 = new ArrayList();
            this.mFilters = arrayList2;
            if (bitmap.isRecycled()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Bitmap is not valid");
                throw null;
            }
            arrayList2.add(Palette.DEFAULT_FILTER);
            this.mBitmap = bitmap;
            arrayList.add(Target.LIGHT_VIBRANT);
            arrayList.add(Target.VIBRANT);
            arrayList.add(Target.DARK_VIBRANT);
            arrayList.add(Target.LIGHT_MUTED);
            arrayList.add(Target.MUTED);
            arrayList.add(Target.DARK_MUTED);
        }

        /* JADX WARN: Code duplicated, block: B:70:0x015f  */
        public final Palette generate() {
            ArrayList arrayList;
            float f;
            Bitmap bitmap = this.mBitmap;
            int height = bitmap.getHeight() * bitmap.getWidth();
            double dSqrt = height > 12544 ? Math.sqrt(12544.0d / ((double) height)) : -1.0d;
            int i = 0;
            Bitmap bitmapCreateScaledBitmap = dSqrt <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dSqrt), (int) Math.ceil(((double) bitmap.getHeight()) * dSqrt), false);
            int width = bitmapCreateScaledBitmap.getWidth();
            int height2 = bitmapCreateScaledBitmap.getHeight();
            int[] iArr = new int[width * height2];
            bitmapCreateScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height2);
            byte b = this.mMaxColors;
            ArrayList arrayList2 = this.mFilters;
            ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(iArr, b, arrayList2.isEmpty() ? null : (AnonymousClass1[]) arrayList2.toArray(new AnonymousClass1[arrayList2.size()]));
            if (bitmapCreateScaledBitmap != bitmap) {
                bitmapCreateScaledBitmap.recycle();
            }
            ArrayList arrayList3 = colorCutQuantizer.mQuantizedColors;
            ArrayList arrayList4 = this.mTargets;
            Palette palette = new Palette(arrayList3, arrayList4);
            int size = arrayList4.size();
            int i2 = 0;
            while (true) {
                SparseBooleanArray sparseBooleanArray = palette.mUsedColors;
                if (i2 >= size) {
                    sparseBooleanArray.clear();
                    return palette;
                }
                Target target = (Target) arrayList4.get(i2);
                float[] fArr = target.mWeights;
                float[] fArr2 = target.mSaturationTargets;
                int length = fArr.length;
                float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                float f3 = 0.0f;
                for (int i3 = i; i3 < length; i3++) {
                    float f4 = fArr[i3];
                    if (f4 > CropImageView.DEFAULT_ASPECT_RATIO) {
                        f3 += f4;
                    }
                }
                if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                    int length2 = fArr.length;
                    for (int i4 = i; i4 < length2; i4++) {
                        float f5 = fArr[i4];
                        if (f5 > CropImageView.DEFAULT_ASPECT_RATIO) {
                            fArr[i4] = f5 / f3;
                        }
                    }
                }
                List list = palette.mSwatches;
                int size2 = list.size();
                int i5 = i;
                float f6 = 0.0f;
                Swatch swatch = null;
                while (i5 < size2) {
                    int i6 = i;
                    Swatch swatch2 = (Swatch) list.get(i5);
                    float[] hsl = swatch2.getHsl();
                    float f7 = hsl[1];
                    float[] fArr3 = target.mLightnessTargets;
                    if (f7 < fArr2[i6] || f7 > fArr2[2]) {
                        arrayList = arrayList4;
                        f = f2;
                    } else {
                        float f8 = hsl[2];
                        if (f8 < fArr3[i6] || f8 > fArr3[2]) {
                            arrayList = arrayList4;
                            f = f2;
                        } else {
                            f = f2;
                            if (sparseBooleanArray.get(swatch2.mRgb)) {
                                arrayList = arrayList4;
                            } else {
                                float[] hsl2 = swatch2.getHsl();
                                Swatch swatch3 = palette.mDominantSwatch;
                                int i7 = swatch3 != null ? swatch3.mPopulation : 1;
                                arrayList = arrayList4;
                                float[] fArr4 = target.mWeights;
                                float f9 = fArr4[i6];
                                float fAbs = f9 > f ? (1.0f - Math.abs(hsl2[1] - fArr2[1])) * f9 : f;
                                float f10 = fArr4[1];
                                float fAbs2 = f10 > f ? (1.0f - Math.abs(hsl2[2] - fArr3[1])) * f10 : f;
                                float f11 = fArr4[2];
                                float f12 = fAbs + fAbs2 + (f11 > f ? (swatch2.mPopulation / i7) * f11 : f);
                                if (swatch == null || f12 > f6) {
                                    swatch = swatch2;
                                    f6 = f12;
                                }
                            }
                        }
                    }
                    i5++;
                    f2 = f;
                    i = i6;
                    arrayList4 = arrayList;
                }
                ArrayList arrayList5 = arrayList4;
                int i8 = i;
                if (swatch != null) {
                    sparseBooleanArray.append(swatch.mRgb, true);
                }
                palette.mSelectedSwatches.put(target, swatch);
                i2++;
                i = i8;
                arrayList4 = arrayList5;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Swatch {
        public final int mBlue;
        public int mBodyTextColor;
        public boolean mGeneratedTextColors;
        public final int mGreen;
        public float[] mHsl;
        public final int mPopulation;
        public final int mRed;
        public final int mRgb;
        public int mTitleTextColor;

        public Swatch(int i, int i2) {
            this.mRed = Color.red(i);
            this.mGreen = Color.green(i);
            this.mBlue = Color.blue(i);
            this.mRgb = i;
            this.mPopulation = i2;
        }

        public final void ensureTextColorsGenerated() {
            if (this.mGeneratedTextColors) {
                return;
            }
            int i = this.mRgb;
            int iCalculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(4.5f, -1, i);
            int iCalculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(3.0f, -1, i);
            if (iCalculateMinimumAlpha != -1 && iCalculateMinimumAlpha2 != -1) {
                this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, iCalculateMinimumAlpha);
                this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, iCalculateMinimumAlpha2);
                this.mGeneratedTextColors = true;
                return;
            }
            int iCalculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(4.5f, -16777216, i);
            int iCalculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(3.0f, -16777216, i);
            if (iCalculateMinimumAlpha3 == -1 || iCalculateMinimumAlpha4 == -1) {
                this.mBodyTextColor = iCalculateMinimumAlpha != -1 ? ColorUtils.setAlphaComponent(-1, iCalculateMinimumAlpha) : ColorUtils.setAlphaComponent(-16777216, iCalculateMinimumAlpha3);
                this.mTitleTextColor = iCalculateMinimumAlpha2 != -1 ? ColorUtils.setAlphaComponent(-1, iCalculateMinimumAlpha2) : ColorUtils.setAlphaComponent(-16777216, iCalculateMinimumAlpha4);
                this.mGeneratedTextColors = true;
            } else {
                this.mBodyTextColor = ColorUtils.setAlphaComponent(-16777216, iCalculateMinimumAlpha3);
                this.mTitleTextColor = ColorUtils.setAlphaComponent(-16777216, iCalculateMinimumAlpha4);
                this.mGeneratedTextColors = true;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Swatch.class == obj.getClass()) {
                Swatch swatch = (Swatch) obj;
                if (this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb) {
                    return true;
                }
            }
            return false;
        }

        public final float[] getHsl() {
            float[] fArr = this.mHsl;
            if (fArr == null) {
                fArr = new float[3];
                this.mHsl = fArr;
            }
            ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, fArr);
            return this.mHsl;
        }

        public final int hashCode() {
            return (this.mRgb * 31) + this.mPopulation;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(Swatch.class.getSimpleName());
            sb.append(" [RGB: #");
            sb.append(Integer.toHexString(this.mRgb));
            sb.append("] [HSL: ");
            sb.append(Arrays.toString(getHsl()));
            sb.append("] [Population: ");
            sb.append(this.mPopulation);
            sb.append("] [Title Text: #");
            ensureTextColorsGenerated();
            sb.append(Integer.toHexString(this.mTitleTextColor));
            sb.append("] [Body Text: #");
            ensureTextColorsGenerated();
            sb.append(Integer.toHexString(this.mBodyTextColor));
            sb.append(']');
            return sb.toString();
        }
    }

    public Palette(List list, ArrayList arrayList) {
        this.mSwatches = list;
        int size = list.size();
        int i = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = (Swatch) list.get(i2);
            int i3 = swatch2.mPopulation;
            if (i3 > i) {
                swatch = swatch2;
                i = i3;
            }
        }
        this.mDominantSwatch = swatch;
    }

    public final int getColorForTarget(Target target, int i) {
        Swatch swatch = (Swatch) this.mSelectedSwatches.get(target);
        return swatch != null ? swatch.mRgb : i;
    }
}
