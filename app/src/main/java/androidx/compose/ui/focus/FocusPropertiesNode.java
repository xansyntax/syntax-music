package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    public FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 focusPropertiesScope;

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        this.focusPropertiesScope.function.invoke(focusProperties);
    }
}
