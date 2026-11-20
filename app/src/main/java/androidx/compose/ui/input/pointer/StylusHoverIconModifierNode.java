package androidx.compose.ui.input.pointer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StylusHoverIconModifierNode extends HoverIconModifierNode {
    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return "androidx.compose.ui.input.pointer.StylusHoverIcon";
    }

    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    /* JADX INFO: renamed from: isRelevantPointerType-uerMTgs */
    public final boolean mo585isRelevantPointerTypeuerMTgs(int i) {
        return i == 3 || i == 4;
    }
}
