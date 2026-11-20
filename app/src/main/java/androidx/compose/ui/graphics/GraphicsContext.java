package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.layer.GraphicsLayer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface GraphicsContext {
    GraphicsLayer createGraphicsLayer();

    void releaseGraphicsLayer(GraphicsLayer graphicsLayer);
}
