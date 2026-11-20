package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedCorner {
    public long center;
    public final float cornerRadius;
    public final long d1;
    public final long d2;
    public final float expectedRoundCut;
    public final long p0;
    public final long p1;
    public final long p2;
    public final float smoothing;

    public RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding) {
        this.p0 = j;
        this.p1 = j2;
        this.p2 = j3;
        long jM1065minusybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(j, j2);
        long jM1065minusybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(j3, j2);
        float fM1062getDistanceDnnuFBc = DatabaseDao_Impl.AnonymousClass17.m1062getDistanceDnnuFBc(jM1065minusybeJwSQ);
        float fM1062getDistanceDnnuFBc2 = DatabaseDao_Impl.AnonymousClass17.m1062getDistanceDnnuFBc(jM1065minusybeJwSQ2);
        if (fM1062getDistanceDnnuFBc <= CropImageView.DEFAULT_ASPECT_RATIO || fM1062getDistanceDnnuFBc2 <= CropImageView.DEFAULT_ASPECT_RATIO) {
            this.d1 = FloatFloatPair.m0constructorimpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            this.d2 = FloatFloatPair.m0constructorimpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            this.cornerRadius = CropImageView.DEFAULT_ASPECT_RATIO;
            this.smoothing = CropImageView.DEFAULT_ASPECT_RATIO;
            this.expectedRoundCut = CropImageView.DEFAULT_ASPECT_RATIO;
        } else {
            long jM1059divso9K2fw = DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(jM1065minusybeJwSQ, fM1062getDistanceDnnuFBc);
            this.d1 = jM1059divso9K2fw;
            long jM1059divso9K2fw2 = DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(jM1065minusybeJwSQ2, fM1062getDistanceDnnuFBc2);
            this.d2 = jM1059divso9K2fw2;
            float f = cornerRounding.radius;
            this.cornerRadius = f;
            this.smoothing = CropImageView.DEFAULT_ASPECT_RATIO;
            float fM1060dotProductybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1060dotProductybeJwSQ(jM1059divso9K2fw, jM1059divso9K2fw2);
            float f2 = Utils.FloatPi;
            float fSqrt = (float) Math.sqrt(1.0f - (fM1060dotProductybeJwSQ * fM1060dotProductybeJwSQ));
            this.expectedRoundCut = ((double) fSqrt) > 0.001d ? ((fM1060dotProductybeJwSQ + 1.0f) * f) / fSqrt : 0.0f;
        }
        this.center = FloatFloatPair.m0constructorimpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    public static Cubic m834computeFlankingCurveoAJzIJU(float f, float f2, long j, long j2, long j3, long j4, long j5, float f3) {
        long jM1065minusybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(j2, j);
        float fM1062getDistanceDnnuFBc = DatabaseDao_Impl.AnonymousClass17.m1062getDistanceDnnuFBc(jM1065minusybeJwSQ);
        FloatFloatPair floatFloatPair = null;
        if (fM1062getDistanceDnnuFBc <= CropImageView.DEFAULT_ASPECT_RATIO) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Can't get the direction of a 0-length vector");
            return null;
        }
        long jM1059divso9K2fw = DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(jM1065minusybeJwSQ, fM1062getDistanceDnnuFBc);
        long jM1066plusybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(jM1059divso9K2fw, f), 1.0f + f2));
        long jM1059divso9K2fw2 = DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j3, j4), 2.0f);
        long jM0constructorimpl = FloatFloatPair.m0constructorimpl(Utils.interpolate(DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j3), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1059divso9K2fw2), f2), Utils.interpolate(DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j3), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1059divso9K2fw2), f2));
        long jM1066plusybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j5, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(Utils.directionVector(DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl) - DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j5), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl) - DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j5)), f3));
        long jM1065minusybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(jM1066plusybeJwSQ2, j5);
        long jM0constructorimpl2 = FloatFloatPair.m0constructorimpl(-DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1065minusybeJwSQ2), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1065minusybeJwSQ2));
        long jM0constructorimpl3 = FloatFloatPair.m0constructorimpl(-DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl2), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl2));
        float fM1060dotProductybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1060dotProductybeJwSQ(jM1059divso9K2fw, jM0constructorimpl3);
        if (Math.abs(fM1060dotProductybeJwSQ) >= 1.0E-4f) {
            float fM1060dotProductybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1060dotProductybeJwSQ(DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(jM1066plusybeJwSQ2, j2), jM0constructorimpl3);
            if (Math.abs(fM1060dotProductybeJwSQ) >= Math.abs(fM1060dotProductybeJwSQ2) * 1.0E-4f) {
                floatFloatPair = new FloatFloatPair(DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j2, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(jM1059divso9K2fw, fM1060dotProductybeJwSQ2 / fM1060dotProductybeJwSQ)));
            }
        }
        long j6 = floatFloatPair != null ? floatFloatPair.packedValue : j3;
        long jM1059divso9K2fw3 = DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(jM1066plusybeJwSQ, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(j6, 2.0f)), 3.0f);
        return new Cubic(new float[]{DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1066plusybeJwSQ), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1066plusybeJwSQ), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1059divso9K2fw3), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1059divso9K2fw3), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j6), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j6), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1066plusybeJwSQ2), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1066plusybeJwSQ2)});
    }

    public final float calculateActualSmoothingValue(float f) {
        float expectedCut = getExpectedCut();
        float f2 = this.smoothing;
        if (f > expectedCut) {
            return f2;
        }
        float f3 = this.expectedRoundCut;
        return f > f3 ? ((f - f3) * f2) / (getExpectedCut() - f3) : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public final float getExpectedCut() {
        return (1.0f + this.smoothing) * this.expectedRoundCut;
    }
}
