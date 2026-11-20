package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderEffectBlurEffect implements BlurEffect {
    public final HazeEffectNode node;
    public RenderEffect renderEffect;

    public RenderEffectBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) {
        URLParserKt$$ExternalSyntheticLambda0 uRLParserKt$$ExternalSyntheticLambda0 = new URLParserKt$$ExternalSyntheticLambda0((byte) 8, this);
        HazeEffectNode hazeEffectNode = this.node;
        float fM1544calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m1544calculateInputScaleFactor3ABfNKs$default(hazeEffectNode);
        boolean z = hazeEffectNode.blurredEdgeTreatment != null;
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerM1538createScaledContentLayerwZMzALA = CanvasKt.m1538createScaledContentLayerwZMzALA(layoutNodeDrawScope, hazeEffectNode, fM1544calculateInputScaleFactor3ABfNKs$default, hazeEffectNode.layerSize, hazeEffectNode.layerOffset);
        if (graphicsLayerM1538createScaledContentLayerwZMzALA != null) {
            graphicsLayerM1538createScaledContentLayerwZMzALA.setClip(z);
            CanvasKt.m1539drawScaledContentLF441nw(layoutNodeDrawScope, hazeEffectNode.layerOffset ^ (-9223372034707292160L), Size.m450times7Ah8Wj8(layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc(), fM1544calculateInputScaleFactor3ABfNKs$default), z, new FileChannelsKt$$ExternalSyntheticLambda1(uRLParserKt$$ExternalSyntheticLambda0, graphicsLayerM1538createScaledContentLayerwZMzALA, (byte) 3));
            graphicsContext.releaseGraphicsLayer(graphicsLayerM1538createScaledContentLayerwZMzALA);
        }
    }
}
