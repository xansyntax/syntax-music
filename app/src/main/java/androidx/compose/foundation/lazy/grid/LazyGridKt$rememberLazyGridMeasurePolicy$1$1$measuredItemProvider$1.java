package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.flv.TagPayloadReader;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 extends TagPayloadReader {
    public final /* synthetic */ int $afterContentPadding;
    public final /* synthetic */ int $beforeContentPadding;
    public final /* synthetic */ boolean $isVertical;
    public final /* synthetic */ LazyGridState $state;
    public final /* synthetic */ LazyLayoutMeasureScopeImpl $this_LazyLayoutMeasurePolicy;
    public final /* synthetic */ long $visualItemOffset;
    public final int defaultMainAxisSpacing;
    public final LazyGridItemProviderImpl itemProvider;
    public final LazyLayoutMeasureScopeImpl measureScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyGridItemProviderImpl lazyGridItemProviderImpl, LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, int i, LazyGridState lazyGridState, boolean z, int i2, int i3, long j) {
        super((byte) 2);
        this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScopeImpl;
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$beforeContentPadding = i2;
        this.$afterContentPadding = i3;
        this.$visualItemOffset = j;
        this.itemProvider = lazyGridItemProviderImpl;
        this.measureScope = lazyLayoutMeasureScopeImpl;
        this.defaultMainAxisSpacing = i;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public final LazyLayoutMeasuredItem mo160getAndMeasurehBUhpc(int i, int i2, int i3, long j) {
        return m166getAndMeasurem8Kt_7k(i, j, i2, i3, this.defaultMainAxisSpacing);
    }

    /* JADX INFO: renamed from: getAndMeasure-m8Kt_7k, reason: not valid java name */
    public final LazyGridMeasuredItem m166getAndMeasurem8Kt_7k(int i, long j, int i2, int i3, int i4) {
        int iM785getMinHeightimpl;
        LazyGridItemProviderImpl lazyGridItemProviderImpl = this.itemProvider;
        Object key = lazyGridItemProviderImpl.getKey(i);
        Object contentType = lazyGridItemProviderImpl.intervalContent.getContentType(i);
        List listM838getPlaceables3p2s80s = m838getPlaceables3p2s80s(this.measureScope, i, j);
        if (Constraints.m782getHasFixedWidthimpl(j)) {
            iM785getMinHeightimpl = Constraints.m786getMinWidthimpl(j);
        } else {
            if (!Constraints.m781getHasFixedHeightimpl(j)) {
                InlineClassHelperKt.throwIllegalArgumentException("does not have fixed height");
            }
            iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        }
        int i5 = iM785getMinHeightimpl;
        LayoutDirection layoutDirection = this.$this_LazyLayoutMeasurePolicy.subcomposeMeasureScope.getLayoutDirection();
        LazyLayoutItemAnimator lazyLayoutItemAnimator = this.$state.itemAnimator;
        return new LazyGridMeasuredItem(i, key, this.$isVertical, i5, i4, layoutDirection, this.$beforeContentPadding, this.$afterContentPadding, listM838getPlaceables3p2s80s, this.$visualItemOffset, contentType, lazyLayoutItemAnimator, j, i2, i3);
    }
}
