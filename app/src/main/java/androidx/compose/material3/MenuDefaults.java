package androidx.compose.material3;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.ui.window.PopupProperties;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuDefaults {
    public static final PaddingValuesImpl DropdownMenuItemContentPadding;
    public static final PopupProperties DefaultMenuProperties = new PopupProperties(true, 30);
    public static final float ShadowElevation = 3.0f;

    static {
        OffsetKt.m128PaddingValuesa9UjIt4$default(12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
        int i = MenuKt.$r8$clinit;
        DropdownMenuItemContentPadding = new PaddingValuesImpl(12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO);
    }
}
