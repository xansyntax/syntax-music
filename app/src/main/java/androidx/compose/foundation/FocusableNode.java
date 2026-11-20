package androidx.compose.foundation;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.room.RoomDatabase$closeBarrier$1;
import androidx.room.RoomDatabase$createConnectionManager$2;
import coil3.RealImageLoader;
import coil3.network.NetworkFetcher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusableNode extends DelegatingNode implements SemanticsModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public final FocusTargetNode focusTargetNode;
    public FocusInteraction.Focus focusedInteraction;
    public MutableInteractionSourceImpl interactionSource;
    public final Function1 onFocusChange;
    public LazyLayoutPinnableItem pinnedHandle;

    public FocusableNode(MutableInteractionSourceImpl mutableInteractionSourceImpl, int i, NetworkFetcher.AnonymousClass2 anonymousClass2) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.onFocusChange = anonymousClass2;
        FocusTargetNode focusTargetNode = new FocusTargetNode(i, new RoomDatabase$createConnectionManager$2(2, this, FocusableNode.class, "onFocusStateChange", "onFocusStateChange(Landroidx/compose/ui/focus/FocusState;Landroidx/compose/ui/focus/FocusState;)V", 0, (byte) 1), 10);
        delegate(focusTargetNode);
        this.focusTargetNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        boolean zIsFocused = this.focusTargetNode.getFocusState$1().isFocused();
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.Focused;
        KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[5];
        Boolean boolValueOf = Boolean.valueOf(zIsFocused);
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, boolValueOf);
        semanticsPropertyReceiver.set(SemanticsActions.RequestFocus, new AccessibilityAction(null, new RoomDatabase$closeBarrier$1(0, this, FocusableNode.class, "requestFocus", "requestFocus()Z", 0, (byte) 1)));
    }

    public final void emitWithFallback(MutableInteractionSourceImpl mutableInteractionSourceImpl, FocusInteraction focusInteraction) {
        if (!this.isAttached) {
            mutableInteractionSourceImpl.tryEmit(focusInteraction);
            return;
        }
        Job job = (Job) ((ContextScope) getCoroutineScope()).coroutineContext.get(Job.Key.$$INSTANCE);
        AwaitKt.launch$default(getCoroutineScope(), null, null, new RealImageLoader.AnonymousClass2(mutableInteractionSourceImpl, focusInteraction, job != null ? job.invokeOnCompletion(new BackHandlerKt$$ExternalSyntheticLambda2(mutableInteractionSourceImpl, focusInteraction, (byte) 13)) : null, null, (byte) 5, false), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6((Object) ref$ObjectRef, (Object) this, (byte) 4));
        LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) ref$ObjectRef.element;
        if (this.focusTargetNode.getFocusState$1().isFocused()) {
            LazyLayoutPinnableItem lazyLayoutPinnableItem2 = this.pinnedHandle;
            if (lazyLayoutPinnableItem2 != null) {
                lazyLayoutPinnableItem2.release();
            }
            if (lazyLayoutPinnableItem != null) {
                lazyLayoutPinnableItem.pin();
            } else {
                lazyLayoutPinnableItem = null;
            }
            this.pinnedHandle = lazyLayoutPinnableItem;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        LazyLayoutPinnableItem lazyLayoutPinnableItem = this.pinnedHandle;
        if (lazyLayoutPinnableItem != null) {
            lazyLayoutPinnableItem.release();
        }
        this.pinnedHandle = null;
    }

    public final void update(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        FocusInteraction.Focus focus;
        if (Intrinsics.areEqual(this.interactionSource, mutableInteractionSourceImpl)) {
            return;
        }
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.interactionSource;
        if (mutableInteractionSourceImpl2 != null && (focus = this.focusedInteraction) != null) {
            mutableInteractionSourceImpl2.tryEmit(new FocusInteraction.Unfocus(focus));
        }
        this.focusedInteraction = null;
        this.interactionSource = mutableInteractionSourceImpl;
    }
}
