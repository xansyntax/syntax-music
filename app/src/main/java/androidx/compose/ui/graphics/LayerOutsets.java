package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayerOutsets {
    public static final LayerOutsets Zero;

    static {
        LayerOutsets layerOutsets = new LayerOutsets();
        if (Dp.m795compareTo0680j_4(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) < 0 || Dp.m795compareTo0680j_4(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) < 0 || Dp.m795compareTo0680j_4(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) < 0 || Dp.m795compareTo0680j_4(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Layer outsets must be non-negative");
        }
        Zero = layerOutsets;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayerOutsets) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final int hashCode() {
        return Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) + IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) * 31, 31), 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(CropImageView.DEFAULT_ASPECT_RATIO);
        String strM797toStringimpl2 = Dp.m797toStringimpl(CropImageView.DEFAULT_ASPECT_RATIO);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("LayerOutsets(left=", strM797toStringimpl, ", top=", strM797toStringimpl2, ", right="), Dp.m797toStringimpl(CropImageView.DEFAULT_ASPECT_RATIO), ", bottom=", Dp.m797toStringimpl(CropImageView.DEFAULT_ASPECT_RATIO), ")");
    }
}
