package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChangeSizeConfig {
    public final Alignment alignment;
    public final FiniteAnimationSpec animationSpec;
    public final boolean clip;
    public final Function1 size;

    public ChangeSizeConfig(Alignment alignment, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, boolean z) {
        this.alignment = alignment;
        this.size = function1;
        this.animationSpec = finiteAnimationSpec;
        this.clip = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSizeConfig)) {
            return false;
        }
        ChangeSizeConfig changeSizeConfig = (ChangeSizeConfig) obj;
        return Intrinsics.areEqual(this.alignment, changeSizeConfig.alignment) && this.size == changeSizeConfig.size && Intrinsics.areEqual(this.animationSpec, changeSizeConfig.animationSpec) && this.clip == changeSizeConfig.clip;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.clip) + ((this.animationSpec.hashCode() + ((this.size.hashCode() + (this.alignment.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ChangeSizeConfig(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=" + this.clip + ")";
    }
}
