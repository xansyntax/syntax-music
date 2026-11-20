package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidPopup_androidKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PopupLayout f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ AndroidPopup_androidKt$$ExternalSyntheticLambda1(PopupLayout popupLayout, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = popupLayout;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        PopupLayout popupLayout = this.f$0;
        byte b2 = 1;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Stack.CompositionLocalProvider(AndroidPopup_androidKt.LocalIsInPopupLayout.defaultProvidedValue$runtime(Boolean.TRUE), Expect_jvmKt.rememberComposableLambda(1022273628, new AndroidPopup_androidKt$$ExternalSyntheticLambda1(popupLayout, mutableState, b2), gapComposer), gapComposer, 56);
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SaversKt$$ExternalSyntheticLambda6((byte) 25);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(Modifier.Companion.$$INSTANCE, false, (Function1) objRememberedValue);
                    boolean zChangedInstance = gapComposer2.changedInstance(popupLayout);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new PopupLayout$$ExternalSyntheticLambda3(popupLayout, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierAlpha = ClipKt.alpha(RulerKt.onSizeChanged(modifierSemantics, (Function1) objRememberedValue2), popupLayout.getCanCalculatePosition() ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO);
                    Function2 function2 = (Function2) mutableState.getValue();
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierAlpha);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    function2.invoke(gapComposer2, 0);
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }
}
