package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FractionLazyLayoutCacheWindow implements LazyLayoutCacheWindow {
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public final int calculateAheadWindow(Density density, int i) {
        return MathKt.roundToInt(i * 0.5f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public final int calculateBehindWindow(Density density, int i) {
        return MathKt.roundToInt(i * CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final boolean equals(Object obj) {
        return obj instanceof FractionLazyLayoutCacheWindow;
    }

    public final int hashCode() {
        return Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) + (Float.hashCode(0.5f) * 31);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public final boolean isNonScrollCachingEnabled() {
        return false;
    }
}
