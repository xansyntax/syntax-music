package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusTargetPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        View embeddedView = AndroidView_androidKt.getEmbeddedView(this);
        focusProperties.setCanFocus(this.node.isAttached && AndroidView_androidKt.getEmbeddedView(this).hasFocusable());
        View viewFindFocus = embeddedView.findFocus();
        if (viewFindFocus != null) {
            focusProperties.setFocusRect(FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(viewFindFocus, embeddedView));
        }
    }
}
