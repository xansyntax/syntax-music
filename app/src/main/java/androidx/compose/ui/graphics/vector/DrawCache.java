package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawCache {
    public AndroidCanvas cachedCanvas;
    public AndroidImageBitmap mCachedImage;
    public long size = 0;
    public int config = 0;
    public final CanvasDrawScope cacheScope = new CanvasDrawScope();
}
