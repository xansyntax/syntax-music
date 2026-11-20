package androidx.compose.ui.draw;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDrawScope implements Density {
    public BuildDrawCacheParams cacheParams = EmptyBuildDrawCacheParams.INSTANCE;
    public DrawResult drawResult;

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    public final DrawResult onDrawWithContent(Function1 function1) {
        DrawResult drawResult = new DrawResult((byte) 0, false);
        drawResult.block = function1;
        this.drawResult = drawResult;
        return drawResult;
    }
}
