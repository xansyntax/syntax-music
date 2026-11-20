package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawWithContentModifier extends Modifier.Node implements DrawModifierNode {
    public Function1 onDraw;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        this.onDraw.invoke(layoutNodeDrawScope);
    }
}
