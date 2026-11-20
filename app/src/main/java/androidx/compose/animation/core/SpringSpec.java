package androidx.compose.animation.core;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.draw.DrawResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpringSpec implements FiniteAnimationSpec {
    public final float dampingRatio;
    public final float stiffness;
    public final Object visibilityThreshold;

    public /* synthetic */ SpringSpec(int i, Object obj) {
        this(1.0f, 1500.0f, (i & 4) != 0 ? null : obj);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SpringSpec) {
            SpringSpec springSpec = (SpringSpec) obj;
            if (springSpec.dampingRatio == this.dampingRatio && springSpec.stiffness == this.stiffness && Intrinsics.areEqual(springSpec.visibilityThreshold, this.visibilityThreshold)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.visibilityThreshold;
        return Float.hashCode(this.stiffness) + IntIntPair$$ExternalSyntheticOutline0.m(this.dampingRatio, (obj != null ? obj.hashCode() : 0) * 31, 31);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        Object obj = this.visibilityThreshold;
        return new DrawResult(this.dampingRatio, this.stiffness, obj == null ? null : (AnimationVector) twoWayConverterImpl.convertToVector.invoke(obj));
    }

    public SpringSpec(float f, float f2, Object obj) {
        this.dampingRatio = f;
        this.stiffness = f2;
        this.visibilityThreshold = obj;
    }
}
