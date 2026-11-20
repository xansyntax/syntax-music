package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.WeakCache;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuToolbarHandlerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, TextContextMenuDataProvider {
    public CoreTextFieldKt$$ExternalSyntheticLambda7 computeContentBounds;
    public TextFieldSelectionManager$contextMenuAreaModifier$3 onHide;
    public SyncUtils$executeSyncPlaylist$2.AnonymousClass1 onShow;
    public WeakCache requester;
    public StandaloneCoroutine textToolbarJob;
    public final DerivedSnapshotState derivedData$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new SliderState$$ExternalSyntheticLambda0(20, this));
    public Rect previousContentBounds = Rect.Zero;

    public TextContextMenuToolbarHandlerNode(WeakCache weakCache, SyncUtils$executeSyncPlaylist$2.AnonymousClass1 anonymousClass1, TextFieldSelectionManager$contextMenuAreaModifier$3 textFieldSelectionManager$contextMenuAreaModifier$3, CoreTextFieldKt$$ExternalSyntheticLambda7 coreTextFieldKt$$ExternalSyntheticLambda7) {
        this.requester = weakCache;
        this.onShow = anonymousClass1;
        this.onHide = textFieldSelectionManager$contextMenuAreaModifier$3;
        this.computeContentBounds = coreTextFieldKt$$ExternalSyntheticLambda7;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public final Rect contentBounds(LayoutCoordinates layoutCoordinates) {
        if (!this.isAttached) {
            return this.previousContentBounds;
        }
        Rect rect = (Rect) this.computeContentBounds.invoke(layoutCoordinates);
        if (rect == null) {
            return this.previousContentBounds;
        }
        this.previousContentBounds = rect;
        return rect;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public final TextContextMenuData data() {
        return (TextContextMenuData) this.derivedData$delegate.getValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        WeakCache weakCache = this.requester;
        weakCache.referenceQueue = ToolbarHandlerState.Attached;
        weakCache.values = this;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        WeakCache weakCache = this.requester;
        weakCache.referenceQueue = ToolbarHandlerState.Detached;
        weakCache.values = null;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    /* JADX INFO: renamed from: position-tuRUvjQ */
    public final long mo211positiontuRUvjQ(LayoutCoordinates layoutCoordinates) {
        return contentBounds(layoutCoordinates).m445getTopLeftF1C5BW0();
    }
}
