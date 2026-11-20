package androidx.compose.ui.unit;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DpSize {
    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m801getHeightD9Ej5fM(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L)) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m802getWidthD9Ej5fM(long j) {
        return Float.intBitsToFloat((int) (j >> 32)) + CropImageView.DEFAULT_ASPECT_RATIO;
    }
}
