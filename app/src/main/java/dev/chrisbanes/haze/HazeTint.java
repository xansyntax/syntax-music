package dev.chrisbanes.haze;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HazeTint {
    public final int blendMode;
    public final Brush brush;
    public final long color;
    public static final HazeTint Unspecified = new HazeTint(ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 3, null);
    public static final byte DefaultBlendMode = 3;

    public HazeTint(long j, int i, Brush brush) {
        this.color = j;
        this.blendMode = i;
        this.brush = brush;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HazeTint)) {
            return false;
        }
        HazeTint hazeTint = (HazeTint) obj;
        return ULong.m1869equalsimpl0(this.color, hazeTint.color) && this.blendMode == hazeTint.blendMode && Intrinsics.areEqual(this.brush, hazeTint.brush);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.blendMode, Long.hashCode(this.color) * 31, 31);
        Brush brush = this.brush;
        return iM + (brush == null ? 0 : brush.hashCode());
    }

    public final boolean isSpecified() {
        return (this.color == 16 && this.brush == null) ? false : true;
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("HazeTint(color=", Color.m486toStringimpl(this.color), ", blendMode=", ColorKt.m501toStringimpl(this.blendMode), ", brush=");
        sbM.append(this.brush);
        sbM.append(")");
        return sbM.toString();
    }

    public HazeTint(long j) {
        this(j, DefaultBlendMode, null);
    }
}
