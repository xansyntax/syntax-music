package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Arrangement$Vertical {
    void arrange(Density density, int i, int[] iArr, int[] iArr2);

    /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
    default float mo112getSpacingD9Ej5fM() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }
}
