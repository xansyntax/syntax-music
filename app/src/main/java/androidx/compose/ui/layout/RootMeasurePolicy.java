package androidx.compose.ui.layout;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy("Undefined intrinsics block and it is required");

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        int size = list.size();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (size == 0) {
            return measureScope.layout(Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), emptyMap, new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 9));
        }
        if (size == 1) {
            Placeable placeableMo598measureBRTryo0 = ((Measurable) list.get(0)).mo598measureBRTryo0(j);
            return measureScope.layout(ConstraintsKt.m792constrainWidthK40F9xA(placeableMo598measureBRTryo0.width, j), ConstraintsKt.m791constrainHeightK40F9xA(placeableMo598measureBRTryo0.height, j), emptyMap, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 21));
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            Placeable placeableMo598measureBRTryo1 = ((Measurable) list.get(i)).mo598measureBRTryo0(j);
            iMax = Math.max(placeableMo598measureBRTryo1.width, iMax);
            iMax2 = Math.max(placeableMo598measureBRTryo1.height, iMax2);
            arrayList.add(placeableMo598measureBRTryo1);
        }
        return measureScope.layout(ConstraintsKt.m792constrainWidthK40F9xA(iMax, j), ConstraintsKt.m791constrainHeightK40F9xA(iMax2, j), emptyMap, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 5));
    }
}
