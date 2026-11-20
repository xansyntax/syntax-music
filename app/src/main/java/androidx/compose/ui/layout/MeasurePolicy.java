package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MeasurePolicy {
    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height, (byte) 0));
        }
        return mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width, (byte) 0));
        }
        return mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j);

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height, (byte) 0));
        }
        return mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width, (byte) 0));
        }
        return mo13measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }
}
