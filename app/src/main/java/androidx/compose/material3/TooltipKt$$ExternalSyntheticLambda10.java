package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda10 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ Function2 f$2;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda10(float f, long j, ComposableLambdaImpl composableLambdaImpl) {
        this.$r8$classId = (byte) 0;
        this.f$0 = f;
        this.f$1 = j;
        this.f$2 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$2;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifierPadding = OffsetKt.padding(SizeKt.m154sizeInqDBjuR0$default(Modifier.Companion.$$INSTANCE, 40.0f, 24.0f, this.f$0, 8), TooltipKt.PlainTooltipContentPadding);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPadding);
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
                    Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(this.f$1, ContentColorKt.LocalContentColor), TextKt.LocalTextStyle.defaultProvidedValue$runtime(CardKt.getValue(2, gapComposer))}, composableLambdaImpl, gapComposer, 8);
                    gapComposer.end(true);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                ListItemKt.m304TrailingDecoratorYv3_QuU(this.f$0, this.f$1, this.f$2, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                ListItemKt.m301LeadingDecoratorYv3_QuU(this.f$0, this.f$1, this.f$2, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda10(float f, long j, Function2 function2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = f;
        this.f$1 = j;
        this.f$2 = function2;
    }
}
