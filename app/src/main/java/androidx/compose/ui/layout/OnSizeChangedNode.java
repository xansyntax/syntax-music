package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.MeasuredSizeAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnSizeChangedNode extends Modifier.Node implements MeasuredSizeAwareModifierNode {
    public Function1 onSizeChanged;
    public long previousSize;

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return true;
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo61onRemeasuredozmzZPI(long j) {
        if (IntSize.m810equalsimpl0(this.previousSize, j)) {
            return;
        }
        this.onSizeChanged.invoke(new IntSize(j));
        this.previousSize = j;
    }
}
