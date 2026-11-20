package com.github.ajalt.colormath.model;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.extractor.text.CueDecoder;
import com.github.ajalt.colormath.Color;
import com.github.ajalt.colormath.ColorSpace;
import com.github.ajalt.colormath.internal.ColorSpaceUtilsKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HSL implements Color {
    public static final Companion Companion = new Companion(0 == true ? 1 : 0);
    public final float alpha;
    public final float h;
    public final float l;
    public final float s;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements RGBColorSpace.TransferFunctions, ColorSpace {
        public static final Companion INSTANCE = new Companion(1);
        public static final Companion INSTANCE$1 = new Companion(2);
        public static final Companion INSTANCE$2 = new Companion(3);
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ Companion(byte b) {
            this.$r8$classId = b;
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
        public float eotf(float f) {
            switch (this.$r8$classId) {
                case 1:
                    return f;
                case 2:
                    double d = f;
                    return (float) (d < 0.031248d ? d / 16.0d : IntMath.spow(d, 1.8d));
                default:
                    double d2 = f;
                    return (float) (d2 <= 0.04045d ? d2 / 12.92d : IntMath.spow((d2 + 0.055d) / 1.055d, 2.4d));
            }
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
        public float oetf(float f) {
            switch (this.$r8$classId) {
                case 1:
                    return f;
                case 2:
                    double d = f;
                    return (float) (d < 0.001953d ? d * 16.0d : IntMath.spow(d, 0.5555555555555556d));
                default:
                    double d2 = f;
                    return (float) (d2 <= 0.0031308d ? d2 * 12.92d : (IntMath.spow(d2, 0.4166666666666667d) * 1.055d) - 0.055d);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        CueDecoder cueDecoder = ColorSpaceUtilsKt.alphaInfo;
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        for (int i = 0; i < 3; i++) {
            char cCharAt = "HSL".charAt(i);
            listBuilderCreateListBuilder.add(new CueDecoder(String.valueOf(cCharAt), CropImageView.DEFAULT_ASPECT_RATIO, cCharAt == 'H' ? 360.0f : 1.0f));
        }
        listBuilderCreateListBuilder.add(ColorSpaceUtilsKt.alphaInfo);
        CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
    }

    public HSL(float f, float f2, float f3, float f4) {
        this.h = f;
        this.s = f2;
        this.l = f3;
        this.alpha = f4;
    }

    public static final float toSRGB$f(double d, double d2, double d3, int i) {
        double d4 = (((double) i) + d) % 12.0d;
        double dMin = Math.min(d3, 1.0d - d3) * d2;
        double dMin2 = Math.min(d4 - 3.0d, Math.min(9.0d - d4, 1.0d));
        if (dMin2 < -1.0d) {
            dMin2 = -1.0d;
        }
        return (float) (d3 - (dMin * dMin2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HSL)) {
            return false;
        }
        HSL hsl = (HSL) obj;
        return Float.compare(this.h, hsl.h) == 0 && Float.compare(this.s, hsl.s) == 0 && Float.compare(this.l, hsl.l) == 0 && Float.compare(this.alpha, hsl.alpha) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.alpha) + IntIntPair$$ExternalSyntheticOutline0.m(this.l, IntIntPair$$ExternalSyntheticOutline0.m(this.s, Float.hashCode(this.h) * 31, 31), 31);
    }

    @Override // com.github.ajalt.colormath.Color
    public final RGB toSRGB() {
        double d = this.s;
        float f = this.alpha;
        float f2 = this.l;
        if (d < 1.0E-7d) {
            return RGB.Companion.invoke(f2, f2, f2, f);
        }
        Integer num = 0;
        float fFloatValue = this.h;
        if (Float.isNaN(fFloatValue)) {
            fFloatValue = num.floatValue();
        }
        double d2 = ((double) (((fFloatValue % 360.0f) + 360.0f) % 360.0f)) / 30.0d;
        double d3 = f2;
        return SRGB.INSTANCE.invoke(toSRGB$f(d2, d, d3, 0), toSRGB$f(d2, d, d3, 8), toSRGB$f(d2, d, d3, 4), f);
    }

    public final String toString() {
        return "HSL(h=" + this.h + ", s=" + this.s + ", l=" + this.l + ", alpha=" + this.alpha + ')';
    }

    @Override // com.github.ajalt.colormath.Color
    public final XYZ toXYZ() {
        return toSRGB().toXYZ();
    }

    @Override // com.github.ajalt.colormath.Color
    public final HSL toHSL() {
        return this;
    }
}
