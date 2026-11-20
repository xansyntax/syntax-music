package androidx.compose.ui.graphics;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WrapperVerificationHelperMethods {
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    /* JADX INFO: renamed from: getColor-vNxB06k, reason: not valid java name */
    public final long m521getColorvNxB06k(Paint paint) {
        long colorLong = paint.getColorLong();
        long j = 63 & colorLong;
        return j < 16 ? colorLong : (colorLong & (-64)) | (j + 1);
    }

    /* JADX INFO: renamed from: setBlendMode-GB0RdKg, reason: not valid java name */
    public final void m522setBlendModeGB0RdKg(Paint paint, int i) {
        paint.setBlendMode(CanvasZHelper.m476toAndroidBlendModes9anfk8(i));
    }

    /* JADX INFO: renamed from: setColor-4WTKRHQ, reason: not valid java name */
    public final void m523setColor4WTKRHQ(Paint paint, long j) {
        paint.setColor(ColorKt.m503toSupportedColorLong8_81llA(j));
    }
}
