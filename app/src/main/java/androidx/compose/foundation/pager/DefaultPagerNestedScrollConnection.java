package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    public final LayoutDirection layoutDirection;
    public final Orientation orientation;
    public final PagerState state;

    public DefaultPagerNestedScrollConnection(PagerState pagerState, Orientation orientation, LayoutDirection layoutDirection) {
        this.state = pagerState;
        this.orientation = orientation;
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return new Velocity(this.orientation == Orientation.Vertical ? Velocity.m818copyOhffZ5M$default(j2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2) : Velocity.m818copyOhffZ5M$default(j2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        if (i != 2) {
            return 0L;
        }
        if (Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j2 >> 32 : 4294967295L & j2)) == CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0L;
        }
        throw new CancellationException("Scroll cancelled");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final long mo178onPreScrollOzD1aCk(int i, long j) {
        float fIntBitsToFloat;
        PagerState pagerState = this.state;
        DefaultScrollableState defaultScrollableState = pagerState.scrollableState;
        if (i != 1 || Math.abs(pagerState.getCurrentPageOffsetFraction()) <= 1.0E-6d) {
            return 0L;
        }
        Orientation orientation = this.orientation;
        Orientation orientation2 = Orientation.Horizontal;
        if (Math.abs(Float.intBitsToFloat((int) (orientation == orientation2 ? j >> 32 : j & 4294967295L))) <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return 0L;
        }
        PagerMeasureResult layoutInfo = pagerState.getLayoutInfo();
        float currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSize$foundation();
        float f = ((layoutInfo.pageSize + layoutInfo.pageSpacing) * (-Math.signum(pagerState.getCurrentPageOffsetFraction()))) + currentPageOffsetFraction;
        if (pagerState.getCurrentPageOffsetFraction() > CropImageView.DEFAULT_ASPECT_RATIO) {
            currentPageOffsetFraction = f;
            f = currentPageOffsetFraction;
        }
        float fCoerceIn = UuidKt.coerceIn(Float.intBitsToFloat((int) (orientation == orientation2 ? j >> 32 : j & 4294967295L)), currentPageOffsetFraction, f);
        if (orientation != orientation2) {
            fIntBitsToFloat = -defaultScrollableState.dispatchRawDelta(-fCoerceIn);
        } else {
            if (this.layoutDirection == LayoutDirection.Rtl) {
                fIntBitsToFloat = defaultScrollableState.dispatchRawDelta(fCoerceIn);
            } else {
                fIntBitsToFloat = -defaultScrollableState.dispatchRawDelta(-fCoerceIn);
            }
        }
        float fIntBitsToFloat2 = orientation == orientation2 ? fIntBitsToFloat : Float.intBitsToFloat((int) (j >> 32));
        if (orientation != Orientation.Vertical) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L);
    }
}
