package androidx.compose.ui.viewinterop;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.room.RoomDatabase$createConnectionManager$2;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusTargetInteropNode extends DelegatingNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode {
    public final FocusTargetNode focusTargetNode;
    public LazyLayoutPinnableItem pinnedHandle;

    public FocusTargetInteropNode() {
        FocusTargetNode focusTargetNode = new FocusTargetNode(0, new RoomDatabase$createConnectionManager$2(2, this, FocusTargetInteropNode.class, "onFocusStateChange", "onFocusStateChange(Landroidx/compose/ui/focus/FocusState;Landroidx/compose/ui/focus/FocusState;)V", 0, (byte) 2), 9);
        delegate(focusTargetNode);
        this.focusTargetNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.observeReads(this, new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) ref$ObjectRef, (Object) this, (byte) 3));
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
}
