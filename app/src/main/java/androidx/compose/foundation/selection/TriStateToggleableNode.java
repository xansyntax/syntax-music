package androidx.compose.foundation.selection;

import android.view.autofill.AutofillValue;
import androidx.compose.foundation.ClickableNode;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TriStateToggleableNode extends ClickableNode {
    public ToggleableState state;

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setToggleableState(semanticsPropertyReceiver, this.state);
        SemanticsPropertiesKt.setContentDataType(semanticsPropertyReceiver, ContentDataType$Companion.Toggle);
        SemanticsPropertiesKt.setFillableData(semanticsPropertyReceiver, new AndroidFillableData(AutofillValue.forToggle(this.state != ToggleableState.Indeterminate)));
        semanticsPropertyReceiver.set(SemanticsActions.OnFillData, new AccessibilityAction(null, new ToggleableNode$$ExternalSyntheticLambda0(semanticsPropertyReceiver, (byte) 1)));
    }
}
