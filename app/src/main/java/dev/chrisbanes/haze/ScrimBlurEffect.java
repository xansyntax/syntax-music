package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrimBlurEffect implements BlurEffect {
    public final HazeEffectNode node;

    public ScrimBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) {
        Lazy lazy = HazeEffectNodeKt.renderEffectCache$delegate;
        HazeEffectNode hazeEffectNode = this.node;
        HazeTint hazeTint = hazeEffectNode.fallbackTint;
        HazeTint hazeTint2 = null;
        if (!hazeTint.isSpecified()) {
            hazeTint = null;
        }
        if (hazeTint == null) {
            hazeTint = hazeEffectNode.style.fallbackTint;
            if (!hazeTint.isSpecified()) {
                hazeTint = null;
            }
            if (hazeTint == null) {
                hazeTint = hazeEffectNode.compositionLocalStyle.fallbackTint;
            }
        }
        if (!hazeTint.isSpecified()) {
            hazeTint = null;
        }
        if (hazeTint == null) {
            HazeTint hazeTint3 = (HazeTint) CollectionsKt.firstOrNull(HazeEffectNodeKt.resolveTints(hazeEffectNode));
            if (hazeTint3 != null) {
                float fResolveBlurRadius = HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode);
                if (Float.isNaN(fResolveBlurRadius)) {
                    fResolveBlurRadius = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                Brush brush = hazeTint3.brush;
                if (brush != null) {
                    hazeTint2 = hazeTint3;
                } else {
                    if (Float.isNaN(fResolveBlurRadius)) {
                        fResolveBlurRadius = 20.0f;
                    }
                    long j = hazeTint3.color;
                    float fM481getAlphaimpl = Color.m481getAlphaimpl(j) * ((fResolveBlurRadius / 72.0f) + 1.0f);
                    if (fM481getAlphaimpl > 1.0f) {
                        fM481getAlphaimpl = 1.0f;
                    }
                    hazeTint2 = new HazeTint(ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), fM481getAlphaimpl, Color.m483getColorSpaceimpl(j)), hazeTint3.blendMode, brush);
                }
            }
            if (hazeTint2 == null) {
                return;
            }
        } else {
            hazeTint2 = hazeTint;
        }
        float f = hazeEffectNode.alpha;
        if (f >= 1.0f) {
            CanvasKt.m1540drawScrimDBWKusU(layoutNodeDrawScope, hazeTint2, hazeEffectNode, 0L, layoutNodeDrawScope.mo556getSizeNHjbRc());
            return;
        }
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerCreateGraphicsLayer = graphicsContext.createGraphicsLayer();
        try {
            graphicsLayerCreateGraphicsLayer.getClass();
            graphicsLayerCreateGraphicsLayer.setAlpha(f);
            layoutNodeDrawScope.m651recordJVtK1S4(SizeKt.m875toIntSizeuvyYCjk(layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc()), graphicsLayerCreateGraphicsLayer, new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(hazeTint2, this, (byte) 0));
            LifecyclesKt.drawLayer(layoutNodeDrawScope, graphicsLayerCreateGraphicsLayer);
        } finally {
            graphicsContext.releaseGraphicsLayer(graphicsLayerCreateGraphicsLayer);
        }
    }
}
