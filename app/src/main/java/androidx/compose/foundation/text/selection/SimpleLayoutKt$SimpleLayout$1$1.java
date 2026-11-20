package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleLayoutKt$SimpleLayout$1$1 implements MeasurePolicy {
    public static final SimpleLayoutKt$SimpleLayout$1$1 INSTANCE = new SimpleLayoutKt$SimpleLayout$1$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size; i++) {
            Placeable placeableMo598measureBRTryo0 = ((Measurable) list.get(i)).mo598measureBRTryo0(j);
            iMax = Math.max(iMax, placeableMo598measureBRTryo0.width);
            iMax2 = Math.max(iMax2, placeableMo598measureBRTryo0.height);
            arrayList.add(placeableMo598measureBRTryo0);
        }
        return measureScope.layout(iMax, iMax2, EmptyMap.INSTANCE, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 4));
    }
}
