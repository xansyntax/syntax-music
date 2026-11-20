package androidx.compose.material3;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ToggleButtonDefaults {
    public static final float size = ToggleButtonSize.Small;

    static {
        if (!((16.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (16.0f >= CropImageView.DEFAULT_ASPECT_RATIO) & (8.0f >= CropImageView.DEFAULT_ASPECT_RATIO)) || !(8.0f >= CropImageView.DEFAULT_ASPECT_RATIO)) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
    }
}
