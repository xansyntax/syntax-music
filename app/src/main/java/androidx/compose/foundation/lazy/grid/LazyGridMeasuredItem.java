package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasuredItem implements LazyLayoutMeasuredItem {
    public final int afterContentPadding;
    public final LazyLayoutItemAnimator animator;
    public final int beforeContentPadding;
    public int column;
    public final long constraints;
    public final Object contentType;
    public final int crossAxisSize;
    public final int horizontalAxisSize;
    public final int horizontalAxisSpacing;
    public final int index;
    public final boolean isVertical;
    public final Object key;
    public final int lane;
    public final LayoutDirection layoutDirection;
    public int mainAxisLayoutSize = Integer.MIN_VALUE;
    public final int mainAxisSize;
    public int maxMainAxisOffset;
    public int minMainAxisOffset;
    public boolean nonScrollableItem;
    public long offset;
    public final List placeables;
    public int row;
    public final long size;
    public final int span;
    public final int verticalAxisSize;
    public final int verticalAxisSpacing;
    public final long visualOffset;

    public LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, LayoutDirection layoutDirection, int i4, int i5, List list, long j, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, int i6, int i7) {
        int i8;
        long j3;
        long j4;
        this.index = i;
        this.key = obj;
        this.isVertical = z;
        this.crossAxisSize = i2;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.placeables = list;
        this.visualOffset = j;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.lane = i6;
        this.span = i7;
        int size = list.size();
        int iMax = 0;
        for (int i9 = 0; i9 < size; i9++) {
            Placeable placeable = (Placeable) list.get(i9);
            iMax = Math.max(iMax, this.isVertical ? placeable.height : placeable.width);
        }
        this.mainAxisSize = iMax;
        boolean z2 = this.isVertical;
        if (z2) {
            this.verticalAxisSpacing = i3;
            this.verticalAxisSize = iMax;
            i8 = this.crossAxisSize;
            this.horizontalAxisSize = i8;
            this.horizontalAxisSpacing = 0;
        } else {
            this.verticalAxisSpacing = 0;
            i8 = this.crossAxisSize;
            this.verticalAxisSize = i8;
            this.horizontalAxisSize = iMax;
            this.horizontalAxisSpacing = i3;
        }
        if (z2) {
            j3 = ((long) i8) << 32;
            j4 = iMax;
        } else {
            j3 = ((long) iMax) << 32;
            j4 = i8;
        }
        this.size = j3 | (j4 & 4294967295L);
        this.offset = 0L;
        this.row = -1;
        this.column = -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public final long mo163getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getHorizontalAxisSize() {
        return this.horizontalAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getHorizontalAxisSpacing() {
        return this.horizontalAxisSpacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getLane() {
        return this.lane;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs$1, reason: not valid java name */
    public final int m169getMainAxisgyyYBs$1(long j) {
        return (int) (this.isVertical ? j & 4294967295L : j >> 32);
    }

    public final int getMainAxisSizeWithSpacings() {
        int i;
        int i2;
        if (this.isVertical) {
            i = this.verticalAxisSize;
            i2 = this.verticalAxisSpacing;
        } else {
            i = this.horizontalAxisSize;
            i2 = this.horizontalAxisSpacing;
        }
        return i + i2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public final long mo165getOffsetBjo55l4(int i) {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final List getPlaceables() {
        return this.placeables;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getVerticalAxisSize() {
        return this.verticalAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getVerticalAxisSpacing() {
        return this.verticalAxisSpacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final void makeNonScrollable() {
        this.nonScrollableItem = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void place(Placeable.PlacementScope placementScope, boolean z) {
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }
        List list = this.placeables;
        int size = list.size();
        int i = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            int i2 = this.minMainAxisOffset;
            boolean z2 = this.isVertical;
            int i3 = i2 - (z2 ? placeable.height : placeable.width);
            int i4 = this.maxMainAxisOffset;
            long j = this.offset;
            LazyLayoutItemAnimation animation = this.animator.getAnimation(i, this.key);
            GraphicsLayer graphicsLayer = null;
            Object[] objArr = 0;
            if (animation != null) {
                if (z) {
                    animation.lookaheadOffset = j;
                } else {
                    long jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(!IntOffset.m804equalsimpl0(animation.lookaheadOffset, 9223372034707292159L) ? animation.lookaheadOffset : j, ((IntOffset) animation.placementDelta$delegate.getValue()).packedValue);
                    if (((m169getMainAxisgyyYBs$1(j) <= i3 && m169getMainAxisgyyYBs$1(jM806plusqkQi6aY) <= i3) || (m169getMainAxisgyyYBs$1(j) >= i4 && m169getMainAxisgyyYBs$1(jM806plusqkQi6aY) >= i4)) && ((Boolean) animation.isPlacementAnimationInProgress$delegate.getValue()).booleanValue()) {
                        AwaitKt.launch$default(animation.coroutineScope, null, null, new LazyLayoutItemAnimation.AnonymousClass1(animation, objArr == true ? 1 : 0, (byte) 2), 3);
                    }
                    j = jM806plusqkQi6aY;
                }
                graphicsLayer = animation.layer;
            } else {
                list = list;
                size = size;
            }
            long jM806plusqkQi6aY2 = IntOffset.m806plusqkQi6aY(j, this.visualOffset);
            if (!z && animation != null) {
                animation.placementOffset = jM806plusqkQi6aY2;
            }
            if (z2) {
                if (graphicsLayer != null) {
                    placementScope.handleMotionFrameOfReferencePlacement(placeable);
                    placeable.mo616placeAtf8xVGno(IntOffset.m806plusqkQi6aY(jM806plusqkQi6aY2, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, graphicsLayer);
                } else {
                    Placeable.PlacementScope.m622placeWithLayeraW9wM$default(placementScope, placeable, jM806plusqkQi6aY2);
                }
            } else if (graphicsLayer != null) {
                Placeable.PlacementScope.m621placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM806plusqkQi6aY2, graphicsLayer);
            } else {
                Placeable.PlacementScope.m620placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM806plusqkQi6aY2);
            }
            i++;
            list = list;
            size = size;
        }
    }

    public final void position(int i, int i2, int i3, int i4, int i5, int i6) {
        long j;
        long j2;
        boolean z = this.isVertical;
        int i7 = z ? i4 : i3;
        this.mainAxisLayoutSize = i7;
        if (!z) {
            i3 = i4;
        }
        if (z && this.layoutDirection == LayoutDirection.Rtl) {
            i2 = (i3 - i2) - this.crossAxisSize;
        }
        if (z) {
            j = ((long) i2) << 32;
            j2 = i;
        } else {
            j = ((long) i) << 32;
            j2 = i2;
        }
        this.offset = (j2 & 4294967295L) | j;
        this.row = i5;
        this.column = i6;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = i7 + this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final void position(int i, int i2, int i3, int i4) {
        position(i, i2, i3, i4, -1, -1);
    }
}
