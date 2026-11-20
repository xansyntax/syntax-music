package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyAdaptingPlatformTextInputModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode {
    public final ParcelableSnapshotMutableState layoutCoordinates$delegate = Stack.mutableStateOf$default(null);
    public LegacyTextFieldState legacyTextFieldState;
    public AndroidLegacyPlatformTextInputServiceAdapter serviceAdapter;
    public TextFieldSelectionManager textFieldSelectionManager;

    public LegacyAdaptingPlatformTextInputModifierNode(AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        this.serviceAdapter = androidLegacyPlatformTextInputServiceAdapter;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = this.serviceAdapter;
        if (androidLegacyPlatformTextInputServiceAdapter.textInputModifierNode != null) {
            InlineClassHelperKt.throwIllegalStateException("Expected textInputModifierNode to be null");
        }
        androidLegacyPlatformTextInputServiceAdapter.textInputModifierNode = this;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.serviceAdapter.unregisterModifier(this);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.layoutCoordinates$delegate.setValue(nodeCoordinator);
    }
}
