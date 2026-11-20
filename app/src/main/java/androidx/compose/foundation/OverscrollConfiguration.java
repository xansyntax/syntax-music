package androidx.compose.foundation;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.ui.graphics.Color;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OverscrollConfiguration {
    public final PaddingValuesImpl drawPadding = OffsetKt.m127PaddingValuesYgX7TsA$default(3, CropImageView.DEFAULT_ASPECT_RATIO);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!OverscrollConfiguration.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        return ULong.m1869equalsimpl0(-43234558140743680L, -43234558140743680L) && this.drawPadding.equals(((OverscrollConfiguration) obj).drawPadding);
    }

    public final int hashCode() {
        return this.drawPadding.hashCode() + (Long.hashCode(-43234558140743680L) * 31);
    }

    public final String toString() {
        return "OverscrollConfiguration(glowColor=" + Color.m486toStringimpl(-43234558140743680L) + ", drawPadding=" + this.drawPadding + ")";
    }
}
