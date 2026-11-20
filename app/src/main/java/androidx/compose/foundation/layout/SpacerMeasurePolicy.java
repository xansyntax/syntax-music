package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpacerMeasurePolicy implements MeasurePolicy {
    public final /* synthetic */ byte $r8$classId;
    public static final SpacerMeasurePolicy INSTANCE$1 = new SpacerMeasurePolicy(1);
    public static final SpacerMeasurePolicy INSTANCE = new SpacerMeasurePolicy(0);

    public /* synthetic */ SpacerMeasurePolicy(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        switch (b) {
            case 0:
                return measureScope.layout(Constraints.m782getHasFixedWidthimpl(j) ? Constraints.m784getMaxWidthimpl(j) : 0, Constraints.m781getHasFixedHeightimpl(j) ? Constraints.m783getMaxHeightimpl(j) : 0, emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 10));
            default:
                return measureScope.layout(Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 2));
        }
    }
}
