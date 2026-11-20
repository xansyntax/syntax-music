package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    public PaddingValues paddingValues;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float fMo123calculateLeftPaddingu2uoSUM = this.paddingValues.mo123calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection());
        float fMo125calculateTopPaddingD9Ej5fM = this.paddingValues.mo125calculateTopPaddingD9Ej5fM();
        float fMo124calculateRightPaddingu2uoSUM = this.paddingValues.mo124calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection());
        float fMo122calculateBottomPaddingD9Ej5fM = this.paddingValues.mo122calculateBottomPaddingD9Ej5fM();
        byte b = 0;
        if (!((Dp.m795compareTo0680j_4(fMo123calculateLeftPaddingu2uoSUM, CropImageView.DEFAULT_ASPECT_RATIO) >= 0) & (Dp.m795compareTo0680j_4(fMo125calculateTopPaddingD9Ej5fM, CropImageView.DEFAULT_ASPECT_RATIO) >= 0) & (Dp.m795compareTo0680j_4(fMo124calculateRightPaddingu2uoSUM, CropImageView.DEFAULT_ASPECT_RATIO) >= 0) & (Dp.m795compareTo0680j_4(fMo122calculateBottomPaddingD9Ej5fM, CropImageView.DEFAULT_ASPECT_RATIO) >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(fMo123calculateLeftPaddingu2uoSUM);
        int iMo75roundToPx0680j_5 = measureScope.mo75roundToPx0680j_4(fMo124calculateRightPaddingu2uoSUM) + iMo75roundToPx0680j_4;
        int iMo75roundToPx0680j_6 = measureScope.mo75roundToPx0680j_4(fMo125calculateTopPaddingD9Ej5fM);
        int iMo75roundToPx0680j_7 = measureScope.mo75roundToPx0680j_4(fMo122calculateBottomPaddingD9Ej5fM) + iMo75roundToPx0680j_6;
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(-iMo75roundToPx0680j_5, -iMo75roundToPx0680j_7, j));
        return measureScope.layout(ConstraintsKt.m792constrainWidthK40F9xA(placeableMo598measureBRTryo0.width + iMo75roundToPx0680j_5, j), ConstraintsKt.m791constrainHeightK40F9xA(placeableMo598measureBRTryo0.height + iMo75roundToPx0680j_7, j), EmptyMap.INSTANCE, new PaddingValuesModifier$$ExternalSyntheticLambda0(placeableMo598measureBRTryo0, iMo75roundToPx0680j_4, iMo75roundToPx0680j_6, b));
    }
}
