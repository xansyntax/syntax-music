package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/IndicationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/IndicationModifierNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class IndicationModifierElement extends ModifierNodeElement {
    public final IndicationNodeFactory indication;
    public final InteractionSource interactionSource;

    public IndicationModifierElement(InteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory) {
        this.interactionSource = interactionSource;
        this.indication = indicationNodeFactory;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DelegatableNode delegatableNodeCreate = this.indication.create(this.interactionSource);
        IndicationModifierNode indicationModifierNode = new IndicationModifierNode();
        indicationModifierNode.indicationNode = delegatableNodeCreate;
        indicationModifierNode.delegate(delegatableNodeCreate);
        return indicationModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicationModifierElement)) {
            return false;
        }
        IndicationModifierElement indicationModifierElement = (IndicationModifierElement) obj;
        return Intrinsics.areEqual(this.interactionSource, indicationModifierElement.interactionSource) && Intrinsics.areEqual(this.indication, indicationModifierElement.indication);
    }

    public final int hashCode() {
        return this.indication.hashCode() + (this.interactionSource.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        IndicationModifierNode indicationModifierNode = (IndicationModifierNode) node;
        DelegatableNode delegatableNodeCreate = this.indication.create(this.interactionSource);
        indicationModifierNode.undelegate(indicationModifierNode.indicationNode);
        indicationModifierNode.indicationNode = delegatableNodeCreate;
        indicationModifierNode.delegate(delegatableNodeCreate);
    }
}
