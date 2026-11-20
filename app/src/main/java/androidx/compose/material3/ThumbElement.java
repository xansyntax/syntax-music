package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/ThumbElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ThumbNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class ThumbElement extends ModifierNodeElement {
    public final FiniteAnimationSpec animationSpec;
    public final boolean checked;
    public final InteractionSource interactionSource;

    public ThumbElement(MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, FiniteAnimationSpec finiteAnimationSpec) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.checked = z;
        this.animationSpec = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ThumbNode thumbNode = new ThumbNode();
        thumbNode.interactionSource = this.interactionSource;
        thumbNode.checked = this.checked;
        thumbNode.animationSpec = this.animationSpec;
        thumbNode.initialOffset = Float.NaN;
        thumbNode.initialSize = Float.NaN;
        return thumbNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) obj;
        return Intrinsics.areEqual(this.interactionSource, thumbElement.interactionSource) && this.checked == thumbElement.checked && Intrinsics.areEqual(this.animationSpec, thumbElement.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.interactionSource.hashCode() * 31, this.checked, 31);
    }

    public final String toString() {
        return "ThumbElement(interactionSource=" + this.interactionSource + ", checked=" + this.checked + ", animationSpec=" + this.animationSpec + ")";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ThumbNode thumbNode = (ThumbNode) node;
        thumbNode.interactionSource = this.interactionSource;
        boolean z = thumbNode.checked;
        boolean z2 = this.checked;
        if (z != z2) {
            HitTestResultKt.invalidateMeasurement(thumbNode);
        }
        thumbNode.checked = z2;
        thumbNode.animationSpec = this.animationSpec;
        if (thumbNode.sizeAnim == null && !Float.isNaN(thumbNode.initialSize)) {
            thumbNode.sizeAnim = ArcSplineKt.Animatable$default(thumbNode.initialSize);
        }
        if (thumbNode.offsetAnim != null || Float.isNaN(thumbNode.initialOffset)) {
            return;
        }
        thumbNode.offsetAnim = ArcSplineKt.Animatable$default(thumbNode.initialOffset);
    }
}
