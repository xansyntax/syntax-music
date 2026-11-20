package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.ColorKt;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSpace {
    public final int id;
    public final long model;
    public final String name;

    public ColorSpace(int i, long j, String str) {
        this.name = str;
        this.model = j;
        this.id = i;
        if (str.length() == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The name of a color space cannot be null and must contain at least 1 character");
            throw null;
        }
        if (i < -1 || i > 63) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The id must be between -1 and 63");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.id == colorSpace.id && this.name.equals(colorSpace.name)) {
            return Illuminant.m527equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    public float getMaxValue(int i) {
        return i == 0 ? 1.0f : 0.5f;
    }

    public float getMinValue(int i) {
        if (i == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return -0.5f;
    }

    public int hashCode() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.model) + this.id;
    }

    public boolean isSrgb() {
        return false;
    }

    public final String toString() {
        return this.name + " (id=" + this.id + ", model=" + Illuminant.m528toStringimpl(this.model) + ")";
    }

    public long toXy$ui_graphics(float f, float f2, float f3) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < -0.5f) {
            f2 = -0.5f;
        }
        if (f2 > 0.5f) {
            f2 = 0.5f;
        }
        if (f3 < -0.5f) {
            f3 = -0.5f;
        }
        float f4 = f3 <= 0.5f ? f3 : 0.5f;
        float[] fArr = Oklab.InverseM2;
        float f5 = (fArr[6] * f4) + (fArr[3] * f2) + (fArr[0] * f);
        float f6 = (fArr[7] * f4) + (fArr[4] * f2) + (fArr[1] * f);
        float f7 = (fArr[8] * f4) + (fArr[5] * f2) + (fArr[2] * f);
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float[] fArr2 = Oklab.InverseM1;
        return (((long) Float.floatToRawIntBits((fArr2[6] * f10) + ((fArr2[3] * f9) + (fArr2[0] * f8)))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits((fArr2[7] * f10) + (fArr2[4] * f9) + (fArr2[1] * f8))));
    }

    public float toZ$ui_graphics(float f, float f2, float f3) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < -0.5f) {
            f2 = -0.5f;
        }
        if (f2 > 0.5f) {
            f2 = 0.5f;
        }
        if (f3 < -0.5f) {
            f3 = -0.5f;
        }
        float f4 = f3 <= 0.5f ? f3 : 0.5f;
        float[] fArr = Oklab.InverseM2;
        float f5 = (fArr[6] * f4) + (fArr[3] * f2) + (fArr[0] * f);
        float f6 = (fArr[7] * f4) + (fArr[4] * f2) + (fArr[1] * f);
        float f7 = (fArr[8] * f4) + (fArr[5] * f2) + (fArr[2] * f);
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float[] fArr2 = Oklab.InverseM1;
        return (fArr2[8] * f10) + (fArr2[5] * f9) + (fArr2[2] * f8);
    }

    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics, reason: not valid java name */
    public long mo524xyzaToColorJlNiLsg$ui_graphics(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float[] fArr = Oklab.M1;
        float f5 = (fArr[6] * f3) + (fArr[3] * f2) + (fArr[0] * f);
        float f6 = (fArr[7] * f3) + (fArr[4] * f2) + (fArr[1] * f);
        float f7 = (fArr[8] * f3) + (fArr[5] * f2) + (fArr[2] * f);
        float fFastCbrt = LifecyclesKt.fastCbrt(f5);
        float fFastCbrt2 = LifecyclesKt.fastCbrt(f6);
        float fFastCbrt3 = LifecyclesKt.fastCbrt(f7);
        float[] fArr2 = Oklab.M2;
        return ColorKt.Color((fArr2[6] * fFastCbrt3) + (fArr2[3] * fFastCbrt2) + (fArr2[0] * fFastCbrt), (fArr2[7] * fFastCbrt3) + (fArr2[4] * fFastCbrt2) + (fArr2[1] * fFastCbrt), (fArr2[8] * fFastCbrt3) + (fArr2[5] * fFastCbrt2) + (fArr2[2] * fFastCbrt), f4, colorSpace);
    }
}
