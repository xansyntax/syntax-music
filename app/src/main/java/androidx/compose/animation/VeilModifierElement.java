package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/VeilModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/VeilModifierNode;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class VeilModifierElement extends ModifierNodeElement {
    public final EnterTransitionImpl enter;
    public final ExitTransitionImpl exit;
    public final SharedMutableTransformState mutableTransformState;
    public final TransitionInstance transition;
    public final Transition.DeferredAnimation veilAnimation;

    public VeilModifierElement(TransitionInstance transitionInstance, Transition.DeferredAnimation deferredAnimation, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, SharedMutableTransformState sharedMutableTransformState) {
        this.transition = transitionInstance;
        this.veilAnimation = deferredAnimation;
        this.enter = enterTransitionImpl;
        this.exit = exitTransitionImpl;
        this.mutableTransformState = sharedMutableTransformState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        VeilModifierNode veilModifierNode = new VeilModifierNode();
        veilModifierNode.veilAnimation = this.veilAnimation;
        veilModifierNode.enter = this.enter;
        veilModifierNode.exit = this.exit;
        veilModifierNode.mutableTransformState = this.mutableTransformState;
        return veilModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VeilModifierElement) {
            VeilModifierElement veilModifierElement = (VeilModifierElement) obj;
            return this.transition == veilModifierElement.transition && Intrinsics.areEqual(this.veilAnimation, veilModifierElement.veilAnimation) && this.enter.equals(veilModifierElement.enter) && Intrinsics.areEqual(this.exit, veilModifierElement.exit) && this.mutableTransformState == veilModifierElement.mutableTransformState;
        }
        return false;
    }

    public final int hashCode() {
        return this.mutableTransformState.hashCode() + ((this.exit.config.hashCode() + ((this.enter.config.hashCode() + ((this.veilAnimation.hashCode() + (this.transition.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "VeilModifierElement(transition=" + this.transition + ", veilAnimation=" + this.veilAnimation + ", enter=" + this.enter + ", exit=" + this.exit + ", mutableTransformState=" + this.mutableTransformState + ")";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        VeilModifierNode veilModifierNode = (VeilModifierNode) node;
        veilModifierNode.getClass();
        veilModifierNode.veilAnimation = this.veilAnimation;
        veilModifierNode.enter = this.enter;
        veilModifierNode.exit = this.exit;
        veilModifierNode.mutableTransformState = this.mutableTransformState;
    }
}
