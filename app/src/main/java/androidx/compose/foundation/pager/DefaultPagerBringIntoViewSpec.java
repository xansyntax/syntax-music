package androidx.compose.foundation.pager;

import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultPagerBringIntoViewSpec implements BringIntoViewSpec {
    public final BringIntoViewSpec defaultBringIntoViewSpec;
    public final LayoutDirection layoutDirection;
    public final PagerState pagerState;

    public DefaultPagerBringIntoViewSpec(PagerState pagerState, BringIntoViewSpec bringIntoViewSpec, LayoutDirection layoutDirection) {
        this.pagerState = pagerState;
        this.defaultBringIntoViewSpec = bringIntoViewSpec;
        this.layoutDirection = layoutDirection;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0016  */
    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final float calculateScrollDistance(float f, float f2, float f3) {
        int pageSizeWithSpacing$foundation;
        int pageSizeWithSpacing$foundation2;
        int pageSizeWithSpacing$foundation3;
        PagerState pagerState = this.pagerState;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = pagerState.isLastScrollForwardState;
        float fCalculateScrollDistance = this.defaultBringIntoViewSpec.calculateScrollDistance(f, f2, f3);
        boolean z = false;
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            float f4 = f + f2;
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            if (f4 <= 1.0f) {
                z = true;
            }
        } else if (f + f2 > f3) {
            z = true;
        }
        float fAbs = Math.abs(fCalculateScrollDistance);
        LayoutDirection layoutDirection = LayoutDirection.Rtl;
        Orientation orientation = Orientation.Horizontal;
        LayoutDirection layoutDirection2 = this.layoutDirection;
        if (fAbs != CropImageView.DEFAULT_ASPECT_RATIO && z) {
            if (layoutDirection2 == layoutDirection && pagerState.getLayoutInfo().orientation == orientation) {
                pageSizeWithSpacing$foundation3 = pagerState.getPageSizeWithSpacing$foundation() + (-pagerState.firstVisiblePageOffset);
            } else {
                pageSizeWithSpacing$foundation3 = pagerState.firstVisiblePageOffset;
            }
            float pageSizeWithSpacing$foundation4 = pageSizeWithSpacing$foundation3 * (-1.0f);
            while (fCalculateScrollDistance > CropImageView.DEFAULT_ASPECT_RATIO && pageSizeWithSpacing$foundation4 < fCalculateScrollDistance) {
                pageSizeWithSpacing$foundation4 += pagerState.getPageSizeWithSpacing$foundation();
            }
            while (fCalculateScrollDistance < CropImageView.DEFAULT_ASPECT_RATIO && pageSizeWithSpacing$foundation4 > fCalculateScrollDistance) {
                pageSizeWithSpacing$foundation4 -= pagerState.getPageSizeWithSpacing$foundation();
            }
            return pageSizeWithSpacing$foundation4;
        }
        if (Math.abs(pagerState.firstVisiblePageOffset) < 1.0E-6d) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (layoutDirection2 == layoutDirection && pagerState.getLayoutInfo().orientation == orientation) {
            pageSizeWithSpacing$foundation = pagerState.getPageSizeWithSpacing$foundation() + (-pagerState.firstVisiblePageOffset);
        } else {
            pageSizeWithSpacing$foundation = pagerState.firstVisiblePageOffset;
        }
        float f5 = pageSizeWithSpacing$foundation * (-1.0f);
        if (layoutDirection2 == layoutDirection && pagerState.getLayoutInfo().orientation == orientation) {
            if (!((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                pageSizeWithSpacing$foundation2 = pagerState.getPageSizeWithSpacing$foundation();
                f5 += pageSizeWithSpacing$foundation2;
            }
        } else if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            pageSizeWithSpacing$foundation2 = pagerState.getPageSizeWithSpacing$foundation();
            f5 += pageSizeWithSpacing$foundation2;
        }
        return UuidKt.coerceIn(f5, -f3, f3);
    }
}
