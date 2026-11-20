package androidx.compose.ui.graphics.layer;

import android.view.RenderNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RenderNodeVerificationHelper28 {
    public static int getAmbientShadowColor(RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public static int getSpotShadowColor(RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public static void setAmbientShadowColor(RenderNode renderNode, int i) {
        renderNode.setAmbientShadowColor(i);
    }

    public static void setSpotShadowColor(RenderNode renderNode, int i) {
        renderNode.setSpotShadowColor(i);
    }
}
