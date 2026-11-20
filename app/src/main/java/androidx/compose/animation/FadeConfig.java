package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FadeConfig {
    public final float alpha;
    public final FiniteAnimationSpec animationSpec;

    public FadeConfig(float f, FiniteAnimationSpec finiteAnimationSpec) {
        this.alpha = f;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FadeConfig)) {
            return false;
        }
        FadeConfig fadeConfig = (FadeConfig) obj;
        return this.alpha == fadeConfig.alpha && Intrinsics.areEqual(this.animationSpec, fadeConfig.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + (Float.hashCode(this.alpha) * 31);
    }

    public final String toString() {
        return "FadeConfig(alpha=" + this.alpha + ", animationSpec=" + this.animationSpec + ")";
    }
}
