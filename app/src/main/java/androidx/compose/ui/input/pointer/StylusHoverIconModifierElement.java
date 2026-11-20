package androidx.compose.ui.input.pointer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class StylusHoverIconModifierElement extends ModifierNodeElement {
    public final DpTouchBoundsExpansion touchBoundsExpansion;

    public StylusHoverIconModifierElement(DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.touchBoundsExpansion = dpTouchBoundsExpansion;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new StylusHoverIconModifierNode(BasicTextKt.handwritingPointerIcon, this.touchBoundsExpansion);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylusHoverIconModifierElement)) {
            return false;
        }
        StylusHoverIconModifierElement stylusHoverIconModifierElement = (StylusHoverIconModifierElement) obj;
        AndroidPointerIconType androidPointerIconType = BasicTextKt.handwritingPointerIcon;
        return androidPointerIconType.equals(androidPointerIconType) && Intrinsics.areEqual(this.touchBoundsExpansion, stylusHoverIconModifierElement.touchBoundsExpansion);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(1022 * 31, false, 31);
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.touchBoundsExpansion;
        return iM + (dpTouchBoundsExpansion != null ? dpTouchBoundsExpansion.hashCode() : 0);
    }

    public final String toString() {
        return "StylusHoverIconModifierElement(icon=" + BasicTextKt.handwritingPointerIcon + ", overrideDescendants=false, touchBoundsExpansion=" + this.touchBoundsExpansion + ")";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        StylusHoverIconModifierNode stylusHoverIconModifierNode = (StylusHoverIconModifierNode) node;
        AndroidPointerIconType androidPointerIconType = BasicTextKt.handwritingPointerIcon;
        if (!Intrinsics.areEqual(stylusHoverIconModifierNode.icon, androidPointerIconType)) {
            stylusHoverIconModifierNode.icon = androidPointerIconType;
            if (stylusHoverIconModifierNode.cursorInBoundsOfNode) {
                stylusHoverIconModifierNode.displayIconIfDescendantsDoNotHavePriority();
            }
        }
        stylusHoverIconModifierNode.dpTouchBoundsExpansion = this.touchBoundsExpansion;
    }
}
