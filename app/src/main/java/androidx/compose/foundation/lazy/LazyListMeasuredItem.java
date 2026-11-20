package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyLayoutMeasuredItem {
    public final int afterContentPadding;
    public final LazyLayoutItemAnimator animator;
    public final int beforeContentPadding;
    public final long constraints;
    public final Object contentType;
    public final int crossAxisSize;
    public final Alignment.Horizontal horizontalAlignment;
    public final int horizontalAxisSize;
    public final int horizontalAxisSpacing;
    public final int index;
    public final boolean isVertical;
    public final Object key;
    public final LayoutDirection layoutDirection;
    public int mainAxisLayoutSize = Integer.MIN_VALUE;
    public int maxMainAxisOffset;
    public int minMainAxisOffset;
    public boolean nonScrollableItem;
    public int offset;
    public final int[] placeableOffsets;
    public final List placeables;
    public final int size;
    public final int spacing;
    public final Alignment.Vertical verticalAlignment;
    public final int verticalAxisSize;
    public final int verticalAxisSpacing;
    public final long visualOffset;

    public LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        int size = list.size();
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            boolean z2 = this.isVertical;
            i5 += z2 ? placeable.height : placeable.width;
            iMax = Math.max(iMax, !z2 ? placeable.height : placeable.width);
        }
        this.size = i5;
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        if (this.isVertical) {
            this.verticalAxisSpacing = this.spacing;
            this.verticalAxisSize = i5;
            this.horizontalAxisSize = iMax;
            this.horizontalAxisSpacing = 0;
            return;
        }
        this.verticalAxisSpacing = 0;
        this.verticalAxisSize = iMax;
        this.horizontalAxisSize = i5;
        this.horizontalAxisSpacing = this.spacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
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
        return 0;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    public final int m164getMainAxisgyyYBs(long j) {
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
        int i3 = i + i2;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long mo165getOffsetBjo55l4(int i) {
        if (i == 0 && this.placeables.size() == 0) {
            int i2 = this.offset;
            return this.isVertical ? ((long) i2) & 4294967295L : ((long) i2) << 32;
        }
        int i3 = i * 2;
        int[] iArr = this.placeableOffsets;
        return (((long) iArr[i3 + 1]) & 4294967295L) | (((long) iArr[i3]) << 32);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final List getPlaceables() {
        return this.placeables;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final int getSpan() {
        return 1;
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
            long jMo165getOffsetBjo55l4 = mo165getOffsetBjo55l4(i);
            LazyLayoutItemAnimation animation = this.animator.getAnimation(i, this.key);
            GraphicsLayer graphicsLayer = null;
            Object[] objArr = 0;
            if (animation != null) {
                if (z) {
                    animation.lookaheadOffset = jMo165getOffsetBjo55l4;
                } else {
                    if (!IntOffset.m804equalsimpl0(animation.lookaheadOffset, 9223372034707292159L)) {
                        jMo165getOffsetBjo55l4 = animation.lookaheadOffset;
                    }
                    long jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(jMo165getOffsetBjo55l4, ((IntOffset) animation.placementDelta$delegate.getValue()).packedValue);
                    if (((m164getMainAxisgyyYBs(jMo165getOffsetBjo55l4) <= i3 && m164getMainAxisgyyYBs(jM806plusqkQi6aY) <= i3) || (m164getMainAxisgyyYBs(jMo165getOffsetBjo55l4) >= i4 && m164getMainAxisgyyYBs(jM806plusqkQi6aY) >= i4)) && ((Boolean) animation.isPlacementAnimationInProgress$delegate.getValue()).booleanValue()) {
                        AwaitKt.launch$default(animation.coroutineScope, null, null, new LazyLayoutItemAnimation.AnonymousClass1(animation, objArr == true ? 1 : 0, (byte) 2), 3);
                    }
                    jMo165getOffsetBjo55l4 = jM806plusqkQi6aY;
                }
                graphicsLayer = animation.layer;
            } else {
                list = list;
                size = size;
            }
            long jM806plusqkQi6aY2 = IntOffset.m806plusqkQi6aY(jMo165getOffsetBjo55l4, this.visualOffset);
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

    public final void position(int i, int i2, int i3) {
        int i4;
        this.offset = i;
        boolean z = this.isVertical;
        this.mainAxisLayoutSize = z ? i3 : i2;
        List list = this.placeables;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            int i6 = i5 * 2;
            int[] iArr = this.placeableOffsets;
            if (z) {
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw Fragment$5$$ExternalSyntheticOutline0.m("null horizontalAlignment when isVertical == true");
                }
                iArr[i6] = horizontal.align(placeable.width, i2, this.layoutDirection);
                iArr[i6 + 1] = i;
                i4 = placeable.height;
            } else {
                iArr[i6] = i;
                int i7 = i6 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw Fragment$5$$ExternalSyntheticOutline0.m("null verticalAlignment when isVertical == false");
                }
                iArr[i7] = vertical.align(placeable.height, i3);
                i4 = placeable.width;
            }
            i += i4;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public final void position(int i, int i2, int i3, int i4) {
        position(i, i3, i4);
    }
}
