package dev.chrisbanes.haze;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderEffectParams {
    public final float blurRadius;
    public final int blurTileMode;
    public final long contentOffset;
    public final long contentSize;
    public final Brush mask;
    public final float noiseFactor;
    public final float scale;
    public final float tintAlphaModulate;
    public final List tints;

    public RenderEffectParams(float f, float f2, float f3, long j, long j2, List list, float f4, Brush brush, int i) {
        this.blurRadius = f;
        this.noiseFactor = f2;
        this.scale = f3;
        this.contentSize = j;
        this.contentOffset = j2;
        this.tints = list;
        this.tintAlphaModulate = f4;
        this.mask = brush;
        this.blurTileMode = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RenderEffectParams)) {
            return false;
        }
        RenderEffectParams renderEffectParams = (RenderEffectParams) obj;
        return Dp.m796equalsimpl0(this.blurRadius, renderEffectParams.blurRadius) && Float.compare(this.noiseFactor, renderEffectParams.noiseFactor) == 0 && Float.compare(this.scale, renderEffectParams.scale) == 0 && Size.m447equalsimpl0(this.contentSize, renderEffectParams.contentSize) && Offset.m434equalsimpl0(this.contentOffset, renderEffectParams.contentOffset) && this.tints.equals(renderEffectParams.tints) && Float.compare(this.tintAlphaModulate, renderEffectParams.tintAlphaModulate) == 0 && Intrinsics.areEqual(this.mask, renderEffectParams.mask) && this.blurTileMode == renderEffectParams.blurTileMode;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.tintAlphaModulate, Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.scale, IntIntPair$$ExternalSyntheticOutline0.m(this.noiseFactor, Float.hashCode(this.blurRadius) * 31, 31), 31), 31, this.contentSize), 31, this.contentOffset), 31, this.tints), 31);
        Brush brush = this.mask;
        return Integer.hashCode(this.blurTileMode) + ((iM + (brush == null ? 0 : brush.hashCode())) * 961);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(this.blurRadius);
        String strM451toStringimpl = Size.m451toStringimpl(this.contentSize);
        String strM441toStringimpl = Offset.m441toStringimpl(this.contentOffset);
        String strM502toStringimpl$1 = ColorKt.m502toStringimpl$1(this.blurTileMode);
        StringBuilder sb = new StringBuilder("RenderEffectParams(blurRadius=");
        sb.append(strM797toStringimpl);
        sb.append(", noiseFactor=");
        sb.append(this.noiseFactor);
        sb.append(", scale=");
        sb.append(this.scale);
        sb.append(", contentSize=");
        sb.append(strM451toStringimpl);
        sb.append(", contentOffset=");
        sb.append(strM441toStringimpl);
        sb.append(", tints=");
        sb.append(this.tints);
        sb.append(", tintAlphaModulate=");
        sb.append(this.tintAlphaModulate);
        sb.append(", mask=");
        sb.append(this.mask);
        sb.append(", progressive=null, blurTileMode=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strM502toStringimpl$1, ")");
    }
}
