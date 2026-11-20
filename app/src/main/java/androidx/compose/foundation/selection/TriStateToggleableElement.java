package androidx.compose.foundation.selection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/selection/TriStateToggleableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/TriStateToggleableNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TriStateToggleableElement extends ModifierNodeElement {
    public final boolean enabled;
    public final IndicationNodeFactory indicationNodeFactory;
    public final MutableInteractionSourceImpl interactionSource;
    public final Function0 onClick;
    public final Role role;
    public final ToggleableState state;

    public TriStateToggleableElement(ToggleableState toggleableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z, Role role, Function0 function0) {
        this.state = toggleableState;
        this.interactionSource = mutableInteractionSourceImpl;
        this.indicationNodeFactory = indicationNodeFactory;
        this.enabled = z;
        this.role = role;
        this.onClick = function0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        TriStateToggleableNode triStateToggleableNode = new TriStateToggleableNode(this.interactionSource, this.indicationNodeFactory, false, this.enabled, null, this.role, this.onClick);
        triStateToggleableNode.state = this.state;
        return triStateToggleableNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TriStateToggleableElement.class != obj.getClass()) {
            return false;
        }
        TriStateToggleableElement triStateToggleableElement = (TriStateToggleableElement) obj;
        return this.state == triStateToggleableElement.state && Intrinsics.areEqual(this.interactionSource, triStateToggleableElement.interactionSource) && Intrinsics.areEqual(this.indicationNodeFactory, triStateToggleableElement.indicationNodeFactory) && this.enabled == triStateToggleableElement.enabled && this.role.equals(triStateToggleableElement.role) && this.onClick == triStateToggleableElement.onClick;
    }

    public final int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        int iHashCode2 = (iHashCode + (mutableInteractionSourceImpl != null ? mutableInteractionSourceImpl.hashCode() : 0)) * 31;
        IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        return this.onClick.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((int) this.role.value, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31, false, 31), this.enabled, 31), 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        TriStateToggleableNode triStateToggleableNode = (TriStateToggleableNode) node;
        ToggleableState toggleableState = triStateToggleableNode.state;
        ToggleableState toggleableState2 = this.state;
        if (toggleableState != toggleableState2) {
            triStateToggleableNode.state = toggleableState2;
            HitTestResultKt.invalidateSemantics(triStateToggleableNode);
        }
        triStateToggleableNode.m29updateCommonO2vRcR0(this.interactionSource, this.indicationNodeFactory, false, this.enabled, null, this.role, this.onClick);
    }
}
