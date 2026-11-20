package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.WeakCache;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TextContextMenuToolbarHandlerElement extends ModifierNodeElement {
    public final CoreTextFieldKt$$ExternalSyntheticLambda7 computeContentBounds;
    public final TextFieldSelectionManager$contextMenuAreaModifier$3 onHide;
    public final SyncUtils$executeSyncPlaylist$2.AnonymousClass1 onShow;
    public final WeakCache requester;

    public TextContextMenuToolbarHandlerElement(WeakCache weakCache, SyncUtils$executeSyncPlaylist$2.AnonymousClass1 anonymousClass1, TextFieldSelectionManager$contextMenuAreaModifier$3 textFieldSelectionManager$contextMenuAreaModifier$3, CoreTextFieldKt$$ExternalSyntheticLambda7 coreTextFieldKt$$ExternalSyntheticLambda7) {
        this.requester = weakCache;
        this.onShow = anonymousClass1;
        this.onHide = textFieldSelectionManager$contextMenuAreaModifier$3;
        this.computeContentBounds = coreTextFieldKt$$ExternalSyntheticLambda7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new TextContextMenuToolbarHandlerNode(this.requester, this.onShow, this.onHide, this.computeContentBounds);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextContextMenuToolbarHandlerElement)) {
            return false;
        }
        TextContextMenuToolbarHandlerElement textContextMenuToolbarHandlerElement = (TextContextMenuToolbarHandlerElement) obj;
        return this.requester == textContextMenuToolbarHandlerElement.requester && this.onShow == textContextMenuToolbarHandlerElement.onShow && this.onHide == textContextMenuToolbarHandlerElement.onHide && this.computeContentBounds == textContextMenuToolbarHandlerElement.computeContentBounds;
    }

    public final int hashCode() {
        return this.computeContentBounds.hashCode() + ((this.onHide.hashCode() + ((this.onShow.hashCode() + (this.requester.hashCode() * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) node;
        textContextMenuToolbarHandlerNode.requester.values = null;
        WeakCache weakCache = this.requester;
        textContextMenuToolbarHandlerNode.requester = weakCache;
        weakCache.values = textContextMenuToolbarHandlerNode;
        weakCache.referenceQueue = textContextMenuToolbarHandlerNode.isAttached ? ToolbarHandlerState.Attached : ToolbarHandlerState.Detached;
        textContextMenuToolbarHandlerNode.onShow = this.onShow;
        textContextMenuToolbarHandlerNode.onHide = this.onHide;
        textContextMenuToolbarHandlerNode.computeContentBounds = this.computeContentBounds;
    }
}
