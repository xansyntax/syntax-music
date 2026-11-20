package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListItemElevation {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof ListItemElevation) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(8.0f, 8.0f);
    }

    public final int hashCode() {
        return Float.hashCode(8.0f) + (Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) * 31);
    }
}
