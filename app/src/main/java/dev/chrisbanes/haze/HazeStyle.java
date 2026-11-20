package dev.chrisbanes.haze;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HazeStyle {
    public static final HazeStyle Unspecified = new HazeStyle(ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), EmptyList.INSTANCE, Float.NaN, -1.0f, HazeTint.Unspecified);
    public final long backgroundColor;
    public final float blurRadius;
    public final HazeTint fallbackTint;
    public final float noiseFactor;
    public final List tints;

    public HazeStyle(long j, List list, float f, float f2, HazeTint hazeTint) {
        list.getClass();
        hazeTint.getClass();
        this.backgroundColor = j;
        this.tints = list;
        this.blurRadius = f;
        this.noiseFactor = f2;
        this.fallbackTint = hazeTint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HazeStyle)) {
            return false;
        }
        HazeStyle hazeStyle = (HazeStyle) obj;
        return ULong.m1869equalsimpl0(this.backgroundColor, hazeStyle.backgroundColor) && Intrinsics.areEqual(this.tints, hazeStyle.tints) && Dp.m796equalsimpl0(this.blurRadius, hazeStyle.blurRadius) && Float.compare(this.noiseFactor, hazeStyle.noiseFactor) == 0 && Intrinsics.areEqual(this.fallbackTint, hazeStyle.fallbackTint);
    }

    public final int hashCode() {
        return this.fallbackTint.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.noiseFactor, IntIntPair$$ExternalSyntheticOutline0.m(this.blurRadius, Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(this.backgroundColor) * 31, 31, this.tints), 31), 31);
    }

    public final String toString() {
        return "HazeStyle(backgroundColor=" + Color.m486toStringimpl(this.backgroundColor) + ", tints=" + this.tints + ", blurRadius=" + Dp.m797toStringimpl(this.blurRadius) + ", noiseFactor=" + this.noiseFactor + ", fallbackTint=" + this.fallbackTint + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HazeStyle(long j, HazeTint hazeTint, float f, float f2) {
        HazeTint hazeTint2 = HazeTint.Unspecified;
        hazeTint2.getClass();
        this(j, CollectionsKt__IterablesKt.listOfNotNull(hazeTint), f, f2, hazeTint2);
    }
}
