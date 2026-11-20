package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyItemScopeImpl {
    public ParcelableSnapshotMutableIntState maxHeightState;
    public ParcelableSnapshotMutableIntState maxWidthState;

    public static Modifier animateItem$default(LazyItemScopeImpl lazyItemScopeImpl, Modifier modifier) {
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        SpringSpec springSpecSpring$default2 = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntOffset(4294967297L), 1);
        SpringSpec springSpecSpring$default3 = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
        lazyItemScopeImpl.getClass();
        return modifier.then(new LazyLayoutAnimateItemElement(springSpecSpring$default, springSpecSpring$default2, springSpecSpring$default3));
    }

    public static Modifier fillParentMaxSize$default(LazyItemScopeImpl lazyItemScopeImpl) {
        return new ParentSizeElement(lazyItemScopeImpl.maxWidthState, lazyItemScopeImpl.maxHeightState);
    }

    public static Modifier fillParentMaxWidth$default(LazyItemScopeImpl lazyItemScopeImpl) {
        return new ParentSizeElement(lazyItemScopeImpl.maxWidthState, null);
    }
}
