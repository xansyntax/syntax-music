package androidx.compose.material3;

import androidx.compose.ui.graphics.Matrix;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MaterialShapes {
    public static RoundedPolygon _cookie12Sided;
    public static RoundedPolygon _cookie4Sided;
    public static RoundedPolygon _cookie9Sided;
    public static final CornerRounding cornerRound50 = new CornerRounding(2, 0.5f);
    public static final float[] rotateNeg90;

    static {
        Matrix.m511rotateZimpl(Matrix.m507constructorimpl$default(), -45.0f);
        float[] fArrM507constructorimpl$default = Matrix.m507constructorimpl$default();
        Matrix.m511rotateZimpl(fArrM507constructorimpl$default, -90.0f);
        rotateNeg90 = fArrM507constructorimpl$default;
        Matrix.m511rotateZimpl(Matrix.m507constructorimpl$default(), -135.0f);
    }
}
