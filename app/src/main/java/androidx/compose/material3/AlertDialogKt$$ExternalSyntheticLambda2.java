package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda2(Modifier modifier, ComposableLambdaImpl composableLambdaImpl) {
        this.$r8$classId = (byte) 0;
        this.f$0 = modifier;
        this.f$1 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ComposableLambdaImpl composableLambdaImpl = this.f$1;
        Modifier modifier = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                byte b2 = 2;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(R.string.m3c_dialog, gapComposer);
                    Modifier modifierM154sizeInqDBjuR0$default = SizeKt.m154sizeInqDBjuR0$default(modifier, 280.0f, CropImageView.DEFAULT_ASPECT_RATIO, 560.0f, 10);
                    boolean zChanged = gapComposer.changed(strM373getString2EP1pXo);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new IconKt$$ExternalSyntheticLambda1(strM373getString2EP1pXo, b2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierThen = modifierM154sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics(Modifier.Companion.$$INSTANCE, false, (Function1) objRememberedValue));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl, gapComposer, true);
                }
                break;
            case 1:
                num.getClass();
                IntMath.SimpleLayout(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(49));
                break;
            default:
                num.getClass();
                SheetDefaultsKt.DragHandleWithTooltip(modifier, composableLambdaImpl, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda2(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
        this.f$1 = composableLambdaImpl;
    }
}
