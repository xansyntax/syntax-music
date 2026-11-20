package androidx.compose.foundation.layout;

import androidx.compose.runtime.DerivedSnapshotState$$ExternalSyntheticLambda0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil3.util.FileSystemsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RowMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    public final Arrangement$Horizontal horizontalArrangement;
    public final Alignment.Vertical verticalAlignment;

    public RowMeasurePolicy(Arrangement$Horizontal arrangement$Horizontal, Alignment.Vertical vertical) {
        this.horizontalArrangement = arrangement$Horizontal;
        this.verticalAlignment = vertical;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    public final long mo119createConstraintsxF2OJ5Q(int i, int i2, int i3, boolean z) {
        return !z ? ConstraintsKt.Constraints(i, i2, 0, i3) : FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(i, i2, 0, i3);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final int crossAxisSize(Placeable placeable) {
        return placeable.height;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowMeasurePolicy)) {
            return false;
        }
        RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) obj;
        return Intrinsics.areEqual(this.horizontalArrangement, rowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalAlignment, rowMeasurePolicy.verticalAlignment);
    }

    public final int hashCode() {
        return this.verticalAlignment.hashCode() + (this.horizontalArrangement.hashCode() * 31);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final int mainAxisSize(Placeable placeable) {
        return placeable.width;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.horizontalArrangement.mo112getSpacingD9Ej5fM());
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * iMo75roundToPx0680j_4, i);
        int size = list.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = (Measurable) list.get(i2);
            float weight = OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable));
            if (weight == CropImageView.DEFAULT_ASPECT_RATIO) {
                int iMin2 = Math.min(measurable.maxIntrinsicWidth(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, measurable.maxIntrinsicHeight(iMin2));
            } else if (weight > CropImageView.DEFAULT_ASPECT_RATIO) {
                f += weight;
            }
        }
        int iRound = f == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Measurable measurable2 = (Measurable) list.get(i3);
            float weight2 = OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable2));
            if (weight2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                iMax = Math.max(iMax, measurable2.maxIntrinsicHeight(iRound != Integer.MAX_VALUE ? Math.round(iRound * weight2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.horizontalArrangement.mo112getSpacingD9Ej5fM());
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i2 = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            Measurable measurable = (Measurable) list.get(i3);
            float weight = OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable));
            int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(i);
            if (weight == CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += iMaxIntrinsicWidth;
            } else if (weight > CropImageView.DEFAULT_ASPECT_RATIO) {
                f += weight;
                iMax = Math.max(iMax, Math.round(iMaxIntrinsicWidth / weight));
            }
        }
        return ((list.size() - 1) * iMo75roundToPx0680j_4) + Math.round(iMax * f) + i2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        return OffsetKt.measure(this, Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), measureScope.mo75roundToPx0680j_4(this.horizontalArrangement.mo112getSpacingD9Ej5fM()), measureScope, list, new Placeable[list.size()], 0, list.size(), null, 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.horizontalArrangement.mo112getSpacingD9Ej5fM());
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * iMo75roundToPx0680j_4, i);
        int size = list.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = (Measurable) list.get(i2);
            float weight = OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable));
            if (weight == CropImageView.DEFAULT_ASPECT_RATIO) {
                int iMin2 = Math.min(measurable.maxIntrinsicWidth(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, measurable.minIntrinsicHeight(iMin2));
            } else if (weight > CropImageView.DEFAULT_ASPECT_RATIO) {
                f += weight;
            }
        }
        int iRound = f == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i - iMin, 0) / f);
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Measurable measurable2 = (Measurable) list.get(i3);
            float weight2 = OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable2));
            if (weight2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                iMax = Math.max(iMax, measurable2.minIntrinsicHeight(iRound != Integer.MAX_VALUE ? Math.round(iRound * weight2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.horizontalArrangement.mo112getSpacingD9Ej5fM());
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i2 = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            Measurable measurable = (Measurable) list.get(i3);
            float weight = OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable));
            int iMinIntrinsicWidth = measurable.minIntrinsicWidth(i);
            if (weight == CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += iMinIntrinsicWidth;
            } else if (weight > CropImageView.DEFAULT_ASPECT_RATIO) {
                f += weight;
                iMax = Math.max(iMax, Math.round(iMinIntrinsicWidth / weight));
            }
        }
        return ((list.size() - 1) * iMo75roundToPx0680j_4) + Math.round(iMax * f) + i2;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final MeasureResult placeHelper(Placeable[] placeableArr, MeasureScope measureScope, int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5) {
        return measureScope.layout(i, i2, EmptyMap.INSTANCE, new DerivedSnapshotState$$ExternalSyntheticLambda0(placeableArr, this, i2, iArr));
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final void populateMainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.horizontalArrangement.arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
    }

    public final String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.horizontalArrangement + ", verticalAlignment=" + this.verticalAlignment + ")";
    }
}
