package androidx.compose.ui.graphics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidRenderEffect extends RenderEffect {
    public final android.graphics.RenderEffect androidRenderEffect;

    public AndroidRenderEffect(android.graphics.RenderEffect renderEffect) {
        this.androidRenderEffect = renderEffect;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public final android.graphics.RenderEffect createRenderEffect() {
        return this.androidRenderEffect;
    }
}
