package androidx.compose.foundation.selection;

import android.view.autofill.AutofillValue;
import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleableNode extends ClickableNode {
    public final SliderState$$ExternalSyntheticLambda0 _onClick;
    public Function1 onValueChange;
    public boolean value;

    public ToggleableNode(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function1 function1) {
        super(mutableInteractionSourceImpl, indicationNodeFactory, false, z2, null, role, new CheckboxKt$$ExternalSyntheticLambda2((byte) 1, function1, z));
        this.value = z;
        this.onValueChange = function1;
        this._onClick = new SliderState$$ExternalSyntheticLambda0((byte) 11, this);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setToggleableState(semanticsPropertyReceiver, this.value ? ToggleableState.On : ToggleableState.Off);
        SemanticsPropertiesKt.setContentDataType(semanticsPropertyReceiver, ContentDataType$Companion.Toggle);
        SemanticsPropertiesKt.setFillableData(semanticsPropertyReceiver, new AndroidFillableData(AutofillValue.forToggle(this.value)));
        semanticsPropertyReceiver.set(SemanticsActions.OnFillData, new AccessibilityAction(null, new ToggleableNode$$ExternalSyntheticLambda0(semanticsPropertyReceiver, (byte) 0)));
    }
}
