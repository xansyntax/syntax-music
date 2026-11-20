package androidx.compose.ui.geometry;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Offset {
    public final long packedValue;

    /* JADX INFO: renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static long m433copydBAh8RU$default(long j, float f, int i) {
        float fIntBitsToFloat = (i & 1) != 0 ? Float.intBitsToFloat((int) (j >> 32)) : CropImageView.DEFAULT_ASPECT_RATIO;
        if ((i & 2) != 0) {
            f = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m434equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m435getDistanceimpl(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat2 * fIntBitsToFloat2) + (fIntBitsToFloat * fIntBitsToFloat));
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m436getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m437getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m438minusMKHz9U(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    /* JADX INFO: renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m439plusMKHz9U(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat((int) (j >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    /* JADX INFO: renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m440timestuRUvjQ(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m441toStringimpl(long j) {
        return (9223372034707292159L & j) != 9205357640488583168L ? Fragment$5$$ExternalSyntheticOutline0.m("Offset(", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat((int) (j >> 32))), ", ", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat((int) (j & 4294967295L))), ")") : "Offset.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Offset) {
            return this.packedValue == ((Offset) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m441toStringimpl(this.packedValue);
    }
}
