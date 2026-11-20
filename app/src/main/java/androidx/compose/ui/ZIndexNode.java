package androidx.compose.ui;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ZIndexNode extends Modifier.Node implements LayoutModifierNode {
    public float zIndex;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new ZIndexNode$$ExternalSyntheticLambda0((Object) placeableMo598measureBRTryo0, (Object) this, (byte) 0));
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("ZIndexModifier(zIndex=", this.zIndex, ")");
    }
}
