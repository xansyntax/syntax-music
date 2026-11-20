package com.valentinilk.shimmer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.core.provider.CallbackWrapper;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShimmerNode extends Modifier.Node implements DrawModifierNode, GlobalPositionAwareModifierNode {
    public ShimmerArea area;
    public ShimmerEffect effect;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        ShimmerEffect shimmerEffect = this.effect;
        ShimmerArea shimmerArea = this.area;
        BrushKt$ShaderBrush$1 brushKt$ShaderBrush$1 = shimmerEffect.brush;
        float[] fArr = shimmerEffect.transformationMatrix;
        shimmerArea.getClass();
        if (shimmerArea.shimmerBounds.isEmpty() || shimmerArea.viewBounds.isEmpty()) {
            return;
        }
        float fFloatValue = ((Number) shimmerEffect.animatedState.getValue()).floatValue();
        float f = shimmerArea.translationDistance;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (shimmerArea.pivotPoint >> 32)) + (f * fFloatValue) + ((-f) / 2.0f);
        Matrix.m510resetimpl(fArr);
        Matrix.m514translateimpl(fArr, Float.intBitsToFloat((int) (shimmerArea.pivotPoint >> 32)), Float.intBitsToFloat((int) (shimmerArea.pivotPoint & 4294967295L)));
        Matrix.m511rotateZimpl(fArr, shimmerEffect.rotation);
        Matrix.m514translateimpl(fArr, -Float.intBitsToFloat((int) (shimmerArea.pivotPoint >> 32)), -Float.intBitsToFloat((int) (shimmerArea.pivotPoint & 4294967295L)));
        Matrix.m514translateimpl(fArr, fIntBitsToFloat, CropImageView.DEFAULT_ASPECT_RATIO);
        brushKt$ShaderBrush$1.transform = fArr;
        CallbackWrapper callbackWrapper = brushKt$ShaderBrush$1.internalTransformShader;
        if (callbackWrapper != null) {
            callbackWrapper.m829transformQ8lPUPs(fArr);
        }
        Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(0L, canvasDrawScope.mo556getSizeNHjbRc());
        Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        try {
            canvas.saveLayer(rectM896Recttz77jQw, shimmerEffect.emptyPaint);
            layoutNodeDrawScope.drawContent();
            DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, brushKt$ShaderBrush$1, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, shimmerEffect.blendMode, 62);
        } finally {
            canvas.restore();
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        Rect rect;
        try {
            long jMo608localToWindowMKHz9U = nodeCoordinator.mo608localToWindowMKHz9U(0L);
            int i = (int) (jMo608localToWindowMKHz9U >> 32);
            int i2 = (int) (jMo608localToWindowMKHz9U & 4294967295L);
            rect = new Rect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat(i) + ((int) (nodeCoordinator.measuredSize >> 32)), Float.intBitsToFloat(i2) + ((int) (4294967295L & nodeCoordinator.measuredSize)));
        } catch (IllegalStateException unused) {
            rect = Rect.Zero;
        }
        ShimmerArea shimmerArea = this.area;
        shimmerArea.getClass();
        if (rect.equals(shimmerArea.viewBounds)) {
            return;
        }
        shimmerArea.viewBounds = rect;
        shimmerArea.computeShimmerBounds();
    }
}
