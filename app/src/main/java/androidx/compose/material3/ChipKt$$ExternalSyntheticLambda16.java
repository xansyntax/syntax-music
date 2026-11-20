package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda16 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$1;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda16(long j, byte b) {
        this.$r8$classId = b;
        this.f$1 = j;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                ((Integer) obj3).getClass();
                ComposableLambdaImpl composableLambdaImplM279trailingContentRPmYEkk = ChipKt.m279trailingContentRPmYEkk(null, this.f$1, composer);
                GapComposer gapComposer = (GapComposer) composer;
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = Stack.mutableStateOf$default(composableLambdaImplM279trailingContentRPmYEkk);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState = (MutableState) objRememberedValue;
                if (composableLambdaImplM279trailingContentRPmYEkk != null) {
                    mutableState.setValue(composableLambdaImplM279trailingContentRPmYEkk);
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
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
                Function2 function2 = (Function2) mutableState.getValue();
                if (function2 == null) {
                    gapComposer.startReplaceGroup(-657207800);
                } else {
                    gapComposer.startReplaceGroup(671536409);
                    function2.invoke(gapComposer, 0);
                }
                gapComposer.end(false);
                gapComposer.end(true);
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.error_playing, gapComposer2), null, this.f$1, IntMath.getSp(10), null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer2, 24576, 24960, 241642);
                }
                break;
        }
        return unit;
    }
}
