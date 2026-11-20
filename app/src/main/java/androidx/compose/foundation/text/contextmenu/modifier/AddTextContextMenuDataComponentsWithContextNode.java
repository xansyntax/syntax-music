package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddTextContextMenuDataComponentsWithContextNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public ButtonKt$$ExternalSyntheticLambda1 builder;
    public final ParcelableSnapshotMutableState configuration$delegate = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState context$delegate = Stack.mutableStateOf$default(null);

    public AddTextContextMenuDataComponentsWithContextNode(ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1) {
        this.builder = buttonKt$$ExternalSyntheticLambda1;
        ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0 = new ScrollState$$ExternalSyntheticLambda0((byte) 24, this);
        AddTextContextMenuDataComponentsNode addTextContextMenuDataComponentsNode = new AddTextContextMenuDataComponentsNode();
        addTextContextMenuDataComponentsNode.builder = scrollState$$ExternalSyntheticLambda0;
        delegate(addTextContextMenuDataComponentsNode);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        HitTestResultKt.observeReads(this, new SliderState$$ExternalSyntheticLambda0((byte) 19, this));
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new SliderState$$ExternalSyntheticLambda0((byte) 19, this));
    }
}
