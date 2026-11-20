package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import coil3.util.LifecyclesKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
    public LazyLayoutItemAnimator animator;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        ArrayList arrayList = this.animator.disappearingItems;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) arrayList.get(i);
            GraphicsLayer graphicsLayer = lazyLayoutItemAnimation.layer;
            if (graphicsLayer != null) {
                long j = lazyLayoutItemAnimation.placementOffset;
                long j2 = graphicsLayer.topLeft;
                float f = ((int) (j >> 32)) - ((int) (j2 >> 32));
                float f2 = ((int) (j & 4294967295L)) - ((int) (4294967295L & j2));
                ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(f, f2);
                try {
                    LifecyclesKt.drawLayer(layoutNodeDrawScope, graphicsLayer);
                    ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f, -f2);
                } catch (Throwable th) {
                    ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).translate(-f, -f2);
                    throw th;
                }
            }
        }
        layoutNodeDrawScope.drawContent();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) obj).animator);
    }

    public final int hashCode() {
        return this.animator.hashCode();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.animator.displayingNode = this;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        LazyLayoutItemAnimator lazyLayoutItemAnimator = this.animator;
        lazyLayoutItemAnimator.releaseAnimations();
        lazyLayoutItemAnimator.keyIndexMap = null;
        lazyLayoutItemAnimator.firstVisibleIndex = -1;
    }

    public final String toString() {
        return "DisplayingDisappearingItemsNode(animator=" + this.animator + ")";
    }
}
