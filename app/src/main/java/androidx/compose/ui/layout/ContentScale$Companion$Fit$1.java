package androidx.compose.ui.layout;

import androidx.collection.Values;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentScale$Companion$Fit$1 implements SubcomposeSlotReusePolicy, ContentScale {
    public static final ContentScale$Companion$Fit$1 INSTANCE = new ContentScale$Companion$Fit$1(1);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ContentScale$Companion$Fit$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(Object obj, Object obj2) {
        return false;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
    public long mo597computeScaleFactorH7hwNQA(long j, long j2) {
        long jFloatToRawIntBits;
        long jFloatToRawIntBits2;
        long jFloatToRawIntBits3;
        int iFloatToRawIntBits;
        switch (this.$r8$classId) {
            case 0:
                float fM623computeFillMinDimensioniLBOSCw = RulerKt.m623computeFillMinDimensioniLBOSCw(j, j2);
                long jFloatToRawIntBits4 = Float.floatToRawIntBits(fM623computeFillMinDimensioniLBOSCw);
                long jFloatToRawIntBits5 = Float.floatToRawIntBits(fM623computeFillMinDimensioniLBOSCw);
                jFloatToRawIntBits = jFloatToRawIntBits4 << 32;
                jFloatToRawIntBits2 = jFloatToRawIntBits5 & 4294967295L;
                break;
            case 1:
            default:
                if (Float.intBitsToFloat((int) (j >> 32)) > Float.intBitsToFloat((int) (j2 >> 32)) || Float.intBitsToFloat((int) (j & 4294967295L)) > Float.intBitsToFloat((int) (j2 & 4294967295L))) {
                    float fM623computeFillMinDimensioniLBOSCw2 = RulerKt.m623computeFillMinDimensioniLBOSCw(j, j2);
                    jFloatToRawIntBits3 = Float.floatToRawIntBits(fM623computeFillMinDimensioniLBOSCw2);
                    iFloatToRawIntBits = Float.floatToRawIntBits(fM623computeFillMinDimensioniLBOSCw2);
                } else {
                    jFloatToRawIntBits3 = Float.floatToRawIntBits(1.0f);
                    iFloatToRawIntBits = Float.floatToRawIntBits(1.0f);
                }
                return (jFloatToRawIntBits3 << 32) | (((long) iFloatToRawIntBits) & 4294967295L);
            case 2:
                float fMax = Math.max(Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L)));
                jFloatToRawIntBits = ((long) Float.floatToRawIntBits(fMax)) << 32;
                jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(fMax)) & 4294967295L;
                break;
        }
        return jFloatToRawIntBits | jFloatToRawIntBits2;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(Values values) {
        values.clear();
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 4:
                return "ReusedSlotId";
            default:
                return super.toString();
        }
    }
}
