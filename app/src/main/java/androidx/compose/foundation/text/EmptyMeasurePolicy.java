package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyMeasurePolicy implements MeasurePolicy {
    public final /* synthetic */ byte $r8$classId;
    public static final EmptyMeasurePolicy INSTANCE$1 = new EmptyMeasurePolicy(1);
    public static final EmptyMeasurePolicy INSTANCE = new EmptyMeasurePolicy(0);
    public static final OffsetKt$$ExternalSyntheticLambda0 placementBlock = new OffsetKt$$ExternalSyntheticLambda0((byte) 27);

    public /* synthetic */ EmptyMeasurePolicy(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        switch (b) {
            case 0:
                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), emptyMap, placementBlock);
            default:
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(((Measurable) list.get(i)).mo598measureBRTryo0(j));
                }
                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), emptyMap, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 3));
        }
    }
}
