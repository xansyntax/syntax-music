package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import com.google.common.math.IntMath;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuGestureNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode {
    public final ParcelableSnapshotMutableState localCoordinates$delegate = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
    public TextFieldSelectionManager$paste$1 onPreShowContextMenu;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClickTextContextMenuDataProvider implements TextContextMenuDataProvider {
        public final long localClickOffset;

        public ClickTextContextMenuDataProvider(long j) {
            this.localClickOffset = j;
        }

        @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
        public final Rect contentBounds(LayoutCoordinates layoutCoordinates) {
            return IntMath.m896Recttz77jQw(mo211positiontuRUvjQ(layoutCoordinates), 0L);
        }

        @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
        public final TextContextMenuData data() {
            return TextContextMenuModifierKt.collectTextContextMenuData(TextContextMenuGestureNode.this);
        }

        @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
        /* JADX INFO: renamed from: position-tuRUvjQ, reason: not valid java name */
        public final long mo211positiontuRUvjQ(LayoutCoordinates layoutCoordinates) {
            LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) TextContextMenuGestureNode.this.localCoordinates$delegate.getValue();
            if (layoutCoordinates2 != null) {
                if (layoutCoordinates2.isAttached$1()) {
                    return layoutCoordinates.mo609screenToLocalMKHz9U(layoutCoordinates2.mo607localToScreenMKHz9U(this.localClickOffset));
                }
                return 0L;
            }
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Tried to open context menu before the anchor was placed.");
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return 0L;
        }
    }

    public TextContextMenuGestureNode(TextFieldSelectionManager$paste$1 textFieldSelectionManager$paste$1) {
        this.onPreShowContextMenu = textFieldSelectionManager$paste$1;
        delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ScrimKt$Scrim$dismissModifier$1$1((byte) 4, this)));
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.localCoordinates$delegate.setValue(nodeCoordinator);
    }
}
