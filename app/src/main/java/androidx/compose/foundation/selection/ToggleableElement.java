package androidx.compose.foundation.selection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/selection/ToggleableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/ToggleableNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ToggleableElement extends ModifierNodeElement {
    public final boolean enabled;
    public final IndicationNodeFactory indicationNodeFactory;
    public final MutableInteractionSourceImpl interactionSource;
    public final Function1 onValueChange;
    public final Role role;
    public final boolean value;

    public ToggleableElement(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function1 function1) {
        this.value = z;
        this.interactionSource = mutableInteractionSourceImpl;
        this.indicationNodeFactory = indicationNodeFactory;
        this.enabled = z2;
        this.role = role;
        this.onValueChange = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new ToggleableNode(this.value, this.interactionSource, this.indicationNodeFactory, this.enabled, this.role, this.onValueChange);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ToggleableElement.class != obj.getClass()) {
            return false;
        }
        ToggleableElement toggleableElement = (ToggleableElement) obj;
        return this.value == toggleableElement.value && Intrinsics.areEqual(this.interactionSource, toggleableElement.interactionSource) && Intrinsics.areEqual(this.indicationNodeFactory, toggleableElement.indicationNodeFactory) && this.enabled == toggleableElement.enabled && Intrinsics.areEqual(this.role, toggleableElement.role) && this.onValueChange == toggleableElement.onValueChange;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.value) * 31;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        int iHashCode2 = (iHashCode + (mutableInteractionSourceImpl != null ? mutableInteractionSourceImpl.hashCode() : 0)) * 31;
        IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31, false, 31), this.enabled, 31);
        Role role = this.role;
        return this.onValueChange.hashCode() + ((iM + (role != null ? Integer.hashCode(role.value) : 0)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ToggleableNode toggleableNode = (ToggleableNode) node;
        boolean z = toggleableNode.value;
        boolean z2 = this.value;
        if (z != z2) {
            toggleableNode.value = z2;
            HitTestResultKt.invalidateSemantics(toggleableNode);
        }
        toggleableNode.onValueChange = this.onValueChange;
        toggleableNode.m29updateCommonO2vRcR0(this.interactionSource, this.indicationNodeFactory, false, this.enabled, null, this.role, toggleableNode._onClick);
    }
}
