package androidx.compose.foundation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/CombinedClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/CombinedClickableNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CombinedClickableElement extends ModifierNodeElement {
    public final boolean enabled;
    public final IndicationNodeFactory indicationNodeFactory;
    public final MutableInteractionSourceImpl interactionSource;
    public final Function0 onClick;
    public final Function0 onLongClick;
    public final String onLongClickLabel;
    public final Role role;
    public final boolean useLocalIndication;

    public CombinedClickableElement(IndicationNodeFactory indicationNodeFactory, MutableInteractionSourceImpl mutableInteractionSourceImpl, Role role, String str, Function0 function0, Function0 function1, boolean z, boolean z2) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.indicationNodeFactory = indicationNodeFactory;
        this.useLocalIndication = z;
        this.enabled = z2;
        this.role = role;
        this.onClick = function0;
        this.onLongClickLabel = str;
        this.onLongClick = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        boolean z = this.enabled;
        return new CombinedClickableNode(this.indicationNodeFactory, this.interactionSource, this.role, this.onLongClickLabel, this.onClick, this.onLongClick, this.useLocalIndication, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedClickableElement.class != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return Intrinsics.areEqual(this.interactionSource, combinedClickableElement.interactionSource) && Intrinsics.areEqual(this.indicationNodeFactory, combinedClickableElement.indicationNodeFactory) && this.useLocalIndication == combinedClickableElement.useLocalIndication && this.enabled == combinedClickableElement.enabled && Intrinsics.areEqual(this.role, combinedClickableElement.role) && this.onClick == combinedClickableElement.onClick && Intrinsics.areEqual(this.onLongClickLabel, combinedClickableElement.onLongClickLabel) && this.onLongClick == combinedClickableElement.onLongClick;
    }

    public final int hashCode() {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        int iHashCode = (mutableInteractionSourceImpl != null ? mutableInteractionSourceImpl.hashCode() : 0) * 31;
        IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31, this.useLocalIndication, 31), this.enabled, 961);
        Role role = this.role;
        int iHashCode2 = (this.onClick.hashCode() + ((iM + (role != null ? Integer.hashCode(role.value) : 0)) * 31)) * 31;
        String str = this.onLongClickLabel;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Function0 function0 = this.onLongClick;
        return Boolean.hashCode(true) + ((iHashCode3 + (function0 != null ? function0.hashCode() : 0)) * 961);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        CombinedClickableNode combinedClickableNode = (CombinedClickableNode) node;
        combinedClickableNode.hapticFeedbackEnabled = true;
        String str = combinedClickableNode.onLongClickLabel;
        String str2 = this.onLongClickLabel;
        if (!Intrinsics.areEqual(str, str2)) {
            combinedClickableNode.onLongClickLabel = str2;
            HitTestResultKt.invalidateSemantics(combinedClickableNode);
        }
        boolean z2 = combinedClickableNode.onLongClick == null;
        Function0 function0 = this.onLongClick;
        if (z2 != (function0 == null)) {
            combinedClickableNode.disposeInteractions();
            HitTestResultKt.invalidateSemantics(combinedClickableNode);
            z = true;
        } else {
            z = false;
        }
        combinedClickableNode.onLongClick = function0;
        boolean z3 = combinedClickableNode.enabled;
        boolean z4 = this.enabled;
        boolean z5 = z3 != z4 ? true : z;
        combinedClickableNode.m29updateCommonO2vRcR0(this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, z4, null, this.role, this.onClick);
        if (z5) {
            combinedClickableNode.cancelInput$1(false);
            combinedClickableNode.cancelInput$1(true);
        }
    }
}
