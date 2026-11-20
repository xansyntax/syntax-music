package androidx.compose.foundation.layout;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConsumedInsetsModifierNode extends InsetsConsumingModifierNode {
    public Function1 block;

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public final WindowInsets calculateInsets(WindowInsets windowInsets) {
        this.block.invoke(windowInsets);
        return windowInsets;
    }
}
