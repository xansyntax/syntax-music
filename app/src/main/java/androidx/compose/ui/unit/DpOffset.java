package androidx.compose.ui.unit;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DpOffset {
    public final long packedValue;

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m798getXD9Ej5fM(long j) {
        return Float.intBitsToFloat((int) (j >> 32)) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m799getYD9Ej5fM(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L)) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m800toStringimpl(long j) {
        return j != 9205357640488583168L ? Fragment$5$$ExternalSyntheticOutline0.m("(", Dp.m797toStringimpl(m798getXD9Ej5fM(j)), ", ", Dp.m797toStringimpl(m799getYD9Ej5fM(j)), ")") : "DpOffset.Unspecified";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DpOffset) {
            return this.packedValue == ((DpOffset) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m800toStringimpl(this.packedValue);
    }
}
