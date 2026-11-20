package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleConfiguration {
    public final long color = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RippleConfiguration) {
            return ULong.m1869equalsimpl0(this.color, ((RippleConfiguration) obj).color);
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.color) * 961;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("RippleConfiguration(color=", Color.m486toStringimpl(this.color), ", focus=null, rippleAlpha=null)");
    }
}
