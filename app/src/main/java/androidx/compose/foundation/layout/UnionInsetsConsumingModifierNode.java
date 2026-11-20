package androidx.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnionInsetsConsumingModifierNode extends InsetsConsumingModifierNode {
    public WindowInsets insets;

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public final WindowInsets calculateInsets(WindowInsets windowInsets) {
        return new UnionInsets(windowInsets, this.insets);
    }
}
