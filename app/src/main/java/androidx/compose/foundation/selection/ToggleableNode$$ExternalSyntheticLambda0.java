package androidx.compose.foundation.selection;

import android.view.autofill.AutofillValue;
import androidx.compose.material3.internal.ParentSemanticsNode;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ToggleableNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SemanticsPropertyReceiver f$0;

    public /* synthetic */ ToggleableNode$$ExternalSyntheticLambda0(SemanticsPropertyReceiver semanticsPropertyReceiver, byte b) {
        this.$r8$classId = b;
        this.f$0 = semanticsPropertyReceiver;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        Boolean boolValueOf;
        byte b = this.$r8$classId;
        boolean z = false;
        ToggleableState toggleableState = ToggleableState.Off;
        ToggleableState toggleableState2 = ToggleableState.On;
        SemanticsPropertyReceiver semanticsPropertyReceiver = this.f$0;
        switch (b) {
            case 0:
                AutofillValue autofillValue = ((AndroidFillableData) obj).autofillValue;
                boolValueOf = autofillValue.isToggle() ? Boolean.valueOf(autofillValue.getToggleValue()) : null;
                if (boolValueOf != null) {
                    if (boolValueOf.booleanValue()) {
                        toggleableState = toggleableState2;
                    }
                    SemanticsPropertiesKt.setToggleableState(semanticsPropertyReceiver, toggleableState);
                    z = true;
                }
                return Boolean.valueOf(z);
            case 1:
                AutofillValue autofillValue2 = ((AndroidFillableData) obj).autofillValue;
                boolValueOf = autofillValue2.isToggle() ? Boolean.valueOf(autofillValue2.getToggleValue()) : null;
                if (boolValueOf != null) {
                    if (boolValueOf.booleanValue()) {
                        toggleableState = toggleableState2;
                    }
                    SemanticsPropertiesKt.setToggleableState(semanticsPropertyReceiver, toggleableState);
                    z = true;
                }
                return Boolean.valueOf(z);
            default:
                TraversableNode traversableNode = (TraversableNode) obj;
                traversableNode.getClass();
                ParentSemanticsNode parentSemanticsNode = (ParentSemanticsNode) traversableNode;
                parentSemanticsNode.semanticsConsumed = true;
                parentSemanticsNode.properties.invoke(semanticsPropertyReceiver);
                HitTestResultKt.invalidateSemantics(parentSemanticsNode);
                return Boolean.FALSE;
        }
    }
}
