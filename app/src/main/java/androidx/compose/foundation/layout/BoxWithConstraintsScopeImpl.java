package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BoxWithConstraintsScopeImpl implements BoxScope {
    public final long constraints;
    public final Density density;

    public BoxWithConstraintsScopeImpl(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        this.density = subcomposeMeasureScope;
        this.constraints = j;
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public final Modifier align(Modifier modifier, Alignment alignment) {
        return modifier.then(new BoxChildDataElement(alignment, false));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        return Intrinsics.areEqual(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m778equalsimpl0(this.constraints, boxWithConstraintsScopeImpl.constraints);
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m117getMaxHeightD9Ej5fM() {
        long j = this.constraints;
        if (!Constraints.m779getHasBoundedHeightimpl(j)) {
            return Float.POSITIVE_INFINITY;
        }
        return this.density.mo78toDpu2uoSUM(Constraints.m783getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m118getMaxWidthD9Ej5fM() {
        long j = this.constraints;
        if (!Constraints.m780getHasBoundedWidthimpl(j)) {
            return Float.POSITIVE_INFINITY;
        }
        return this.density.mo78toDpu2uoSUM(Constraints.m784getMaxWidthimpl(j));
    }

    public final int hashCode() {
        return Long.hashCode(this.constraints) + (this.density.hashCode() * 31);
    }

    public final String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + Constraints.m788toStringimpl(this.constraints) + ")";
    }
}
