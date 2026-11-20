package com.valentinilk.shimmer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShimmerTheme {
    public final AnimationSpec animationSpec;
    public final int blendMode;
    public final float rotation;
    public final List shaderColorStops;
    public final List shaderColors;
    public final float shimmerWidth;

    public ShimmerTheme(AnimationSpec animationSpec, int i, float f, List list, List list2, float f2) {
        this.animationSpec = animationSpec;
        this.blendMode = i;
        this.rotation = f;
        this.shaderColors = list;
        this.shaderColorStops = list2;
        this.shimmerWidth = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShimmerTheme)) {
            return false;
        }
        ShimmerTheme shimmerTheme = (ShimmerTheme) obj;
        return this.animationSpec.equals(shimmerTheme.animationSpec) && this.blendMode == shimmerTheme.blendMode && Float.compare(this.rotation, shimmerTheme.rotation) == 0 && this.shaderColors.equals(shimmerTheme.shaderColors) && Intrinsics.areEqual(this.shaderColorStops, shimmerTheme.shaderColorStops) && Dp.m796equalsimpl0(this.shimmerWidth, shimmerTheme.shimmerWidth);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.rotation, IntIntPair$$ExternalSyntheticOutline0.m(this.blendMode, this.animationSpec.hashCode() * 31, 31), 31), 31, this.shaderColors);
        List list = this.shaderColorStops;
        return Float.hashCode(this.shimmerWidth) + ((iM + (list == null ? 0 : list.hashCode())) * 31);
    }

    public final String toString() {
        return "ShimmerTheme(animationSpec=" + this.animationSpec + ", blendMode=" + ((Object) ColorKt.m501toStringimpl(this.blendMode)) + ", rotation=" + this.rotation + ", shaderColors=" + this.shaderColors + ", shaderColorStops=" + this.shaderColorStops + ", shimmerWidth=" + ((Object) Dp.m797toStringimpl(this.shimmerWidth)) + ')';
    }
}
