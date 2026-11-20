package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewNode extends Modifier.Node {
    public AndroidViewHolder$$ExternalSyntheticLambda4 onRequesterReady;
    public final DiskLruCache$$ExternalSyntheticLambda0 requester = new DiskLruCache$$ExternalSyntheticLambda0((byte) 10, this);

    public BringIntoViewNode(AndroidViewHolder$$ExternalSyntheticLambda4 androidViewHolder$$ExternalSyntheticLambda4) {
        this.onRequesterReady = androidViewHolder$$ExternalSyntheticLambda4;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.onRequesterReady.invoke(this.requester);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.onRequesterReady.invoke(null);
    }
}
