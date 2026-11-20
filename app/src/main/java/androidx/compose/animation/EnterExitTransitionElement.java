package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.modifier.SingleLocalMap;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/EnterExitTransitionModifierNode;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EnterExitTransitionElement extends ModifierNodeElement {
    public final EnterTransitionImpl enter;
    public final ExitTransitionImpl exit;
    public final EnterExitTransitionKt$$ExternalSyntheticLambda7 graphicsLayerBlock;
    public final Function0 isEnabled;
    public final SharedMutableTransformState mutableTransformState;
    public final Transition.DeferredAnimation offsetAnimation;
    public final Transition.DeferredAnimation sizeAnimation;
    public final Transition.DeferredAnimation slideAnimation;
    public final TransitionInstance transition;

    public EnterExitTransitionElement(TransitionInstance transitionInstance, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, SharedMutableTransformState sharedMutableTransformState, Function0 function0, EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda7) {
        this.transition = transitionInstance;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransitionImpl;
        this.exit = exitTransitionImpl;
        this.mutableTransformState = sharedMutableTransformState;
        this.isEnabled = function0;
        this.graphicsLayerBlock = enterExitTransitionKt$$ExternalSyntheticLambda7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new EnterExitTransitionModifierNode(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.mutableTransformState, this.isEnabled, this.graphicsLayerBlock);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) obj;
        return enterExitTransitionElement.transition == this.transition && Intrinsics.areEqual(enterExitTransitionElement.sizeAnimation, this.sizeAnimation) && Intrinsics.areEqual(enterExitTransitionElement.offsetAnimation, this.offsetAnimation) && Intrinsics.areEqual(enterExitTransitionElement.slideAnimation, this.slideAnimation) && enterExitTransitionElement.enter.equals(this.enter) && Intrinsics.areEqual(enterExitTransitionElement.exit, this.exit) && enterExitTransitionElement.mutableTransformState == this.mutableTransformState && enterExitTransitionElement.isEnabled == this.isEnabled && Intrinsics.areEqual(enterExitTransitionElement.graphicsLayerBlock, this.graphicsLayerBlock);
    }

    public final int hashCode() {
        int iHashCode = this.transition.hashCode() * 31;
        Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
        int iHashCode2 = (iHashCode + (deferredAnimation != null ? deferredAnimation.hashCode() : 0)) * 31;
        Transition.DeferredAnimation deferredAnimation2 = this.offsetAnimation;
        int iHashCode3 = (iHashCode2 + (deferredAnimation2 != null ? deferredAnimation2.hashCode() : 0)) * 31;
        Transition.DeferredAnimation deferredAnimation3 = this.slideAnimation;
        return this.mutableTransformState.hashCode() + (this.graphicsLayerBlock.hashCode() * 31) + ((this.isEnabled.hashCode() + ((this.exit.config.hashCode() + ((this.enter.config.hashCode() + ((iHashCode3 + (deferredAnimation3 != null ? deferredAnimation3.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        EnterExitTransitionModifierNode enterExitTransitionModifierNode = (EnterExitTransitionModifierNode) node;
        enterExitTransitionModifierNode.transition = this.transition;
        SingleLocalMap singleLocalMap = enterExitTransitionModifierNode.providedValues;
        enterExitTransitionModifierNode.sizeAnimation = this.sizeAnimation;
        enterExitTransitionModifierNode.offsetAnimation = this.offsetAnimation;
        enterExitTransitionModifierNode.slideAnimation = this.slideAnimation;
        enterExitTransitionModifierNode.enter = this.enter;
        enterExitTransitionModifierNode.exit = this.exit;
        SharedMutableTransformState sharedMutableTransformState = enterExitTransitionModifierNode.mutableTransformState;
        SharedMutableTransformState sharedMutableTransformState2 = this.mutableTransformState;
        if (sharedMutableTransformState != sharedMutableTransformState2) {
            enterExitTransitionModifierNode.mutableTransformState = sharedMutableTransformState2;
            if (singleLocalMap == EmptyMap.INSTANCE) {
                InlineClassHelperKt.throwIllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap");
            }
            ProvidableModifierLocal providableModifierLocal = CrossfadeKt.ModifierLocalSharedMutableTransformState;
            if (!singleLocalMap.contains$ui(providableModifierLocal)) {
                InlineClassHelperKt.throwIllegalArgumentException("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + providableModifierLocal + " was not found.");
            }
            singleLocalMap.value$delegate.setValue(sharedMutableTransformState2);
        }
        enterExitTransitionModifierNode.isEnabled = this.isEnabled;
        enterExitTransitionModifierNode.graphicsLayerBlock = this.graphicsLayerBlock;
    }
}
