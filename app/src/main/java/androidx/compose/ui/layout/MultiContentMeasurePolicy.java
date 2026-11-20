package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MultiContentMeasurePolicy {
    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = (ArrayList) list;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list2 = (List) arrayList.get(i2);
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(new DefaultIntrinsicMeasurable((Measurable) list2.get(i3), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height, (byte) 0));
            }
            arrayList2.add(arrayList3);
        }
        return mo121measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList2, ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = (ArrayList) list;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list2 = (List) arrayList.get(i2);
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(new DefaultIntrinsicMeasurable((Measurable) list2.get(i3), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width, (byte) 0));
            }
            arrayList2.add(arrayList3);
        }
        return mo121measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList2, ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo121measure3p2s80s(MeasureScope measureScope, List list, long j);

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = (ArrayList) list;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list2 = (List) arrayList.get(i2);
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(new DefaultIntrinsicMeasurable((Measurable) list2.get(i3), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height, (byte) 0));
            }
            arrayList2.add(arrayList3);
        }
        return mo121measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList2, ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList arrayList = (ArrayList) list;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list2 = (List) arrayList.get(i2);
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(new DefaultIntrinsicMeasurable((Measurable) list2.get(i3), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width, (byte) 0));
            }
            arrayList2.add(arrayList3);
        }
        return mo121measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList2, ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }
}
