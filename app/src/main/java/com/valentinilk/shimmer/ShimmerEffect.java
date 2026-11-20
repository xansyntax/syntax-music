package com.valentinilk.shimmer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShimmerEffect {
    public final AnimationSpec animationSpec;
    public final int blendMode;
    public final BrushKt$ShaderBrush$1 brush;
    public final AndroidPaint emptyPaint;
    public final float rotation;
    public final List shaderColorStops;
    public final List shaderColors;
    public final float shimmerWidth;
    public final Animatable animatedState = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
    public final float[] transformationMatrix = Matrix.m507constructorimpl$default();

    public ShimmerEffect(AnimationSpec animationSpec, int i, float f, List list, List list2, float f2) {
        this.animationSpec = animationSpec;
        this.blendMode = i;
        this.rotation = f;
        this.shaderColors = list;
        this.shaderColorStops = list2;
        this.shimmerWidth = f2;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((-f2) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L);
        this.brush = new BrushKt$ShaderBrush$1(ColorKt.m487ActualLinearGradientShaderVjE6UOU(jFloatToRawIntBits, jFloatToRawIntBits ^ (-9223372034707292160L), list, list2));
        this.emptyPaint = ColorKt.Paint();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ShimmerEffect.class != obj.getClass()) {
            return false;
        }
        ShimmerEffect shimmerEffect = (ShimmerEffect) obj;
        return this.animationSpec.equals(shimmerEffect.animationSpec) && this.blendMode == shimmerEffect.blendMode && this.rotation == shimmerEffect.rotation && this.shaderColors.equals(shimmerEffect.shaderColors) && Intrinsics.areEqual(this.shaderColorStops, shimmerEffect.shaderColorStops) && this.shimmerWidth == shimmerEffect.shimmerWidth;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.rotation, IntIntPair$$ExternalSyntheticOutline0.m(this.blendMode, this.animationSpec.hashCode() * 31, 31), 31), 31, this.shaderColors);
        List list = this.shaderColorStops;
        return Float.hashCode(this.shimmerWidth) + ((iM + (list != null ? list.hashCode() : 0)) * 31);
    }
}
