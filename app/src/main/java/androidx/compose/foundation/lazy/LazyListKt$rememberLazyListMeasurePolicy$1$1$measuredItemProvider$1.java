package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.media3.extractor.flv.TagPayloadReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 extends TagPayloadReader {
    public final /* synthetic */ int $afterContentPadding;
    public final /* synthetic */ int $beforeContentPadding;
    public final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    public final /* synthetic */ boolean $isVertical;
    public final /* synthetic */ int $itemsCount;
    public final /* synthetic */ int $spaceBetweenItems;
    public final /* synthetic */ LazyListState $state;
    public final /* synthetic */ LazyLayoutMeasureScopeImpl $this_LazyLayoutMeasurePolicy;
    public final /* synthetic */ Alignment.Vertical $verticalAlignment;
    public final /* synthetic */ long $visualItemOffset;
    public final long childConstraints;
    public final LazyListItemProviderImpl itemProvider;
    public final LazyLayoutMeasureScopeImpl measureScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(long j, boolean z, LazyListItemProviderImpl lazyListItemProviderImpl, LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, int i, int i2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, int i3, int i4, long j2, LazyListState lazyListState) {
        super((byte) 2);
        this.$isVertical = z;
        this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScopeImpl;
        this.$itemsCount = i;
        this.$spaceBetweenItems = i2;
        this.$horizontalAlignment = horizontal;
        this.$verticalAlignment = vertical;
        this.$beforeContentPadding = i3;
        this.$afterContentPadding = i4;
        this.$visualItemOffset = j2;
        this.$state = lazyListState;
        this.itemProvider = lazyListItemProviderImpl;
        this.measureScope = lazyLayoutMeasureScopeImpl;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m784getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, z ? Integer.MAX_VALUE : Constraints.m783getMaxHeightimpl(j), 5);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc, reason: not valid java name */
    public final LazyLayoutMeasuredItem mo160getAndMeasurehBUhpc(int i, int i2, int i3, long j) {
        return m161getAndMeasure0kLqBqw(i, j);
    }

    /* JADX INFO: renamed from: getAndMeasure-0kLqBqw, reason: not valid java name */
    public final LazyListMeasuredItem m161getAndMeasure0kLqBqw(int i, long j) {
        LazyListItemProviderImpl lazyListItemProviderImpl = this.itemProvider;
        Object key = lazyListItemProviderImpl.getKey(i);
        Object contentType = lazyListItemProviderImpl.intervalContent.getContentType(i);
        return new LazyListMeasuredItem(i, m838getPlaceables3p2s80s(this.measureScope, i, j), this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyLayoutMeasurePolicy.subcomposeMeasureScope.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, i == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.itemAnimator, j);
    }
}
