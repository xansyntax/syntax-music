package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SlideConfig {
    public final FiniteAnimationSpec animationSpec;
    public final Function1 slideOffset;

    public SlideConfig(Function1 function1, FiniteAnimationSpec finiteAnimationSpec) {
        this.slideOffset = function1;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlideConfig)) {
            return false;
        }
        SlideConfig slideConfig = (SlideConfig) obj;
        return this.slideOffset == slideConfig.slideOffset && Intrinsics.areEqual(this.animationSpec, slideConfig.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + (this.slideOffset.hashCode() * 31);
    }

    public final String toString() {
        return "SlideConfig(slideOffset=" + this.slideOffset + ", animationSpec=" + this.animationSpec + ")";
    }
}
