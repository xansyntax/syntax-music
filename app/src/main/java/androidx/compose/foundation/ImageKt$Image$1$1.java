package androidx.compose.foundation;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageKt$Image$1$1 implements MeasurePolicy {
    public static final ImageKt$Image$1$1 INSTANCE = new ImageKt$Image$1$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        return measureScope.layout(Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), EmptyMap.INSTANCE, new BorderKt$$ExternalSyntheticLambda1((byte) 14));
    }
}
