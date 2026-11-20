package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SizeAnimationModifierNode;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SizeAnimationModifierElement extends ModifierNodeElement {
    public final FiniteAnimationSpec animationSpec;

    public SizeAnimationModifierElement(FiniteAnimationSpec finiteAnimationSpec) {
        this.animationSpec = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new SizeAnimationModifierNode(this.animationSpec);
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
        if (!(obj instanceof SizeAnimationModifierElement) || !Intrinsics.areEqual(((SizeAnimationModifierElement) obj).animationSpec, this.animationSpec)) {
            return false;
        }
        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
        return biasAlignment.equals(biasAlignment);
    }

    public final int hashCode() {
        return (Float.hashCode(-1.0f) + (Float.hashCode(-1.0f) * 31) + (this.animationSpec.hashCode() * 31)) * 31;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((SizeAnimationModifierNode) node).animationSpec = this.animationSpec;
    }
}
