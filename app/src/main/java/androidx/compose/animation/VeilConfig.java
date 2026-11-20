package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VeilConfig {
    public final FiniteAnimationSpec animationSpec;
    public final long initialColor;
    public final boolean matchParentSize;
    public final long targetColor;

    public VeilConfig(long j, long j2, FiniteAnimationSpec finiteAnimationSpec, boolean z) {
        this.initialColor = j;
        this.targetColor = j2;
        this.animationSpec = finiteAnimationSpec;
        this.matchParentSize = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VeilConfig)) {
            return false;
        }
        VeilConfig veilConfig = (VeilConfig) obj;
        return ULong.m1869equalsimpl0(this.initialColor, veilConfig.initialColor) && ULong.m1869equalsimpl0(this.targetColor, veilConfig.targetColor) && Intrinsics.areEqual(this.animationSpec, veilConfig.animationSpec) && this.matchParentSize == veilConfig.matchParentSize;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.matchParentSize) + ((this.animationSpec.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.initialColor) * 31, 31, this.targetColor)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("VeilConfig(initialColor=", Color.m486toStringimpl(this.initialColor), ", targetColor=", Color.m486toStringimpl(this.targetColor), ", animationSpec=");
        sbM.append(this.animationSpec);
        sbM.append(", matchParentSize=");
        sbM.append(this.matchParentSize);
        sbM.append(")");
        return sbM.toString();
    }
}
