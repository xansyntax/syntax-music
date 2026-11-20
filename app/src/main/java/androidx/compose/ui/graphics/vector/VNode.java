package androidx.compose.ui.graphics.vector;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VNode {
    public TextKt$$ExternalSyntheticLambda2 invalidateListener;

    public abstract void draw(DrawScope drawScope);

    public Function1 getInvalidateListener$ui() {
        return this.invalidateListener;
    }

    public final void invalidate() {
        Function1 invalidateListener$ui = getInvalidateListener$ui();
        if (invalidateListener$ui != null) {
            invalidateListener$ui.invoke(this);
        }
    }

    public void setInvalidateListener$ui(TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) {
        this.invalidateListener = textKt$$ExternalSyntheticLambda2;
    }
}
