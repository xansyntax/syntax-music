package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawWithContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/DrawWithContentModifier;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DrawWithContentElement extends ModifierNodeElement {
    public final Function1 onDraw;

    public DrawWithContentElement(Function1 function1) {
        this.onDraw = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DrawWithContentModifier drawWithContentModifier = new DrawWithContentModifier();
        drawWithContentModifier.onDraw = this.onDraw;
        return drawWithContentModifier;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawWithContentElement) {
            return this.onDraw == ((DrawWithContentElement) obj).onDraw;
        }
        return false;
    }

    public final int hashCode() {
        return this.onDraw.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((DrawWithContentModifier) node).onDraw = this.onDraw;
    }
}
