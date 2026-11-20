package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RowColumnParentData {
    public float weight = CropImageView.DEFAULT_ASPECT_RATIO;
    public boolean fill = true;
    public CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return Float.compare(this.weight, rowColumnParentData.weight) == 0 && this.fill == rowColumnParentData.fill && Intrinsics.areEqual(this.crossAxisAlignment, rowColumnParentData.crossAxisAlignment);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(Float.hashCode(this.weight) * 31, this.fill, 31);
        CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment = this.crossAxisAlignment;
        return (iM + (crossAxisAlignment$HorizontalCrossAxisAlignment == null ? 0 : crossAxisAlignment$HorizontalCrossAxisAlignment.horizontal.hashCode())) * 31;
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ", flowLayoutData=null)";
    }
}
