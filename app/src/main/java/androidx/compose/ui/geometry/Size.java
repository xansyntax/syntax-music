package androidx.compose.ui.geometry;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Size {
    public final long packedValue;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m447equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m448getMinDimensionimpl(long j) {
        return Math.min(Float.intBitsToFloat((int) ((j >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j & 2147483647L)));
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m449isEmptyimpl(long j) {
        return (j == 9205357640488583168L) | (Float.intBitsToFloat((int) (j >> 32)) <= CropImageView.DEFAULT_ASPECT_RATIO) | (Float.intBitsToFloat((int) (j & 4294967295L)) <= CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m450times7Ah8Wj8(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m451toStringimpl(long j) {
        return j != 9205357640488583168L ? Fragment$5$$ExternalSyntheticOutline0.m("Size(", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat((int) (j >> 32))), ", ", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat((int) (j & 4294967295L))), ")") : "Size.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Size) {
            return this.packedValue == ((Size) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m451toStringimpl(this.packedValue);
    }
}
