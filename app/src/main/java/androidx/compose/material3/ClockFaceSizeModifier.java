package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.InlineClassHelperKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClockFaceSizeModifier implements LayoutModifier {
    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo195measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f;
        float fMo78toDpu2uoSUM = measureScope.mo78toDpu2uoSUM(Constraints.m783getMaxHeightimpl(j));
        MutableIntList mutableIntList = TimePickerKt.Minutes;
        if (Dp.m795compareTo0680j_4(fMo78toDpu2uoSUM, 384.0f) >= 0) {
            f = 256.0f;
        } else {
            f = Dp.m795compareTo0680j_4(fMo78toDpu2uoSUM, 330.0f) >= 0 ? 238.0f : 200.0f;
        }
        int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(f);
        if (!((iMo75roundToPx0680j_4 >= 0) & (iMo75roundToPx0680j_4 >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.createConstraints(iMo75roundToPx0680j_4, iMo75roundToPx0680j_4, iMo75roundToPx0680j_4, iMo75roundToPx0680j_4));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 16));
    }
}
