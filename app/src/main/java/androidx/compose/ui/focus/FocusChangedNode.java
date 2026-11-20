package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusChangedNode extends Modifier.Node implements FocusEventModifierNode {
    public FocusStateImpl focusState;
    public Function1 onFocusChanged;

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusStateImpl) {
        if (Intrinsics.areEqual(this.focusState, focusStateImpl)) {
            return;
        }
        this.focusState = focusStateImpl;
        this.onFocusChanged.invoke(focusStateImpl);
    }
}
