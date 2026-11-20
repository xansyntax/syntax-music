package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HazeEffectNode$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LayoutNodeDrawScope f$0;

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda2(LayoutNodeDrawScope layoutNodeDrawScope, GraphicsLayer graphicsLayer) {
        this.$r8$classId = (byte) 2;
        this.f$0 = layoutNodeDrawScope;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LayoutNodeDrawScope layoutNodeDrawScope = this.f$0;
        DrawScope drawScope = (DrawScope) obj;
        switch (b) {
            case 0:
                drawScope.getClass();
                CanvasKt.drawContentSafely(layoutNodeDrawScope);
                break;
            case 1:
                layoutNodeDrawScope.drawContent();
                break;
            default:
                drawScope.getClass();
                CanvasKt.drawContentSafely(layoutNodeDrawScope);
                break;
        }
        return unit;
    }

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda2(LayoutNodeDrawScope layoutNodeDrawScope, byte b) {
        this.$r8$classId = b;
        this.f$0 = layoutNodeDrawScope;
    }
}
