package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScaleConfig {
    public final FiniteAnimationSpec animationSpec;
    public final float scale;
    public final long transformOrigin;

    public ScaleConfig(float f, long j, FiniteAnimationSpec finiteAnimationSpec) {
        this.scale = f;
        this.transformOrigin = j;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaleConfig)) {
            return false;
        }
        ScaleConfig scaleConfig = (ScaleConfig) obj;
        return this.scale == scaleConfig.scale && TransformOrigin.m519equalsimpl0(this.transformOrigin, scaleConfig.transformOrigin) && Intrinsics.areEqual(this.animationSpec, scaleConfig.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Float.hashCode(this.scale) * 31, 31, this.transformOrigin);
    }

    public final String toString() {
        return "ScaleConfig(scale=" + this.scale + ", transformOrigin=" + TransformOrigin.m520toStringimpl(this.transformOrigin) + ", animationSpec=" + this.animationSpec + ")";
    }
}
