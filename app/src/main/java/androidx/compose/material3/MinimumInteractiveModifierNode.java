package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesModifier$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public LinkedHashMap alignmentLinesCache;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f = ((Dp) HitTestResultKt.currentValueOf(this, InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize)).value;
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        boolean z = this.isAttached && !Float.isNaN(f) && Dp.m795compareTo0680j_4(f, CropImageView.DEFAULT_ASPECT_RATIO) > 0;
        int iMo75roundToPx0680j_4 = !Float.isNaN(f) ? measureScope.mo75roundToPx0680j_4(f) : 0;
        int iMax = placeableMo598measureBRTryo0.width;
        if (z) {
            iMax = Math.max(iMax, iMo75roundToPx0680j_4);
        }
        int iMax2 = placeableMo598measureBRTryo0.height;
        if (z) {
            iMax2 = Math.max(iMax2, iMo75roundToPx0680j_4);
        }
        if (z) {
            LinkedHashMap linkedHashMap = this.alignmentLinesCache;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap(2);
                this.alignmentLinesCache = linkedHashMap;
            }
            VerticalAlignmentLine verticalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveLeftAlignmentLine;
            int iRound = Math.round((iMo75roundToPx0680j_4 - placeableMo598measureBRTryo0.width) / 2.0f);
            if (iRound < 0) {
                iRound = 0;
            }
            linkedHashMap.put(verticalAlignmentLine, Integer.valueOf(iRound));
            HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
            int iRound2 = Math.round((iMo75roundToPx0680j_4 - placeableMo598measureBRTryo0.height) / 2.0f);
            linkedHashMap.put(horizontalAlignmentLine, Integer.valueOf(iRound2 >= 0 ? iRound2 : 0));
        }
        Map map = this.alignmentLinesCache;
        if (map == null) {
            map = EmptyMap.INSTANCE;
        }
        return measureScope.layout(iMax, iMax2, map, new PaddingValuesModifier$$ExternalSyntheticLambda0(iMax, placeableMo598measureBRTryo0, iMax2));
    }
}
