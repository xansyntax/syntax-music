package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.FractionLazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLazyGridCacheWindow implements LazyLayoutCacheWindow {
    public static final DefaultLazyGridCacheWindow INSTANCE = new DefaultLazyGridCacheWindow();
    public final /* synthetic */ FractionLazyLayoutCacheWindow $$delegate_0 = new FractionLazyLayoutCacheWindow();

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public final int calculateAheadWindow(Density density, int i) {
        return this.$$delegate_0.calculateAheadWindow(density, i);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public final int calculateBehindWindow(Density density, int i) {
        return this.$$delegate_0.calculateBehindWindow(density, i);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public final boolean isNonScrollCachingEnabled() {
        return false;
    }
}
