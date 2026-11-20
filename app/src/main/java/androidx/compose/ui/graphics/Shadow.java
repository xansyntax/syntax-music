package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Shadow {
    public static final Shadow None = new Shadow(-72057594037927936L, 0, CropImageView.DEFAULT_ASPECT_RATIO);
    public final float blurRadius;
    public final long color;
    public final long offset;

    public Shadow(long j, long j2, float f) {
        this.color = j;
        this.offset = j2;
        this.blurRadius = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return ULong.m1869equalsimpl0(this.color, shadow.color) && Offset.m434equalsimpl0(this.offset, shadow.offset) && this.blurRadius == shadow.blurRadius;
    }

    public final int hashCode() {
        return Float.hashCode(this.blurRadius) + IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.color) * 31, 31, this.offset);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Shadow(color=", Color.m486toStringimpl(this.color), ", offset=", Offset.m441toStringimpl(this.offset), ", blurRadius=");
        sbM.append(this.blurRadius);
        sbM.append(")");
        return sbM.toString();
    }
}
