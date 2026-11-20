package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda11 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Function f$5;
    public final /* synthetic */ Function f$7;
    public final /* synthetic */ long f$8;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda11(PaddingValues paddingValues, Arrangement$Horizontal arrangement$Horizontal, Function2 function2, long j, ComposableLambdaImpl composableLambdaImpl, long j2) {
        this.f$1 = paddingValues;
        this.f$2 = arrangement$Horizontal;
        this.f$5 = function2;
        this.f$7 = composableLambdaImpl;
        this.f$8 = j2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        boolean z2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function function = this.f$7;
        Function function2 = this.f$5;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                PaddingValues paddingValues = (PaddingValues) obj4;
                Arrangement$Horizontal arrangement$Horizontal = (Arrangement$Horizontal) obj3;
                Function2 function3 = (Function2) function2;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) function;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                BiasAlignment biasAlignment = Alignment.Companion.Center;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IntrinsicSize intrinsicSize = IntrinsicSize.Max;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierPadding = OffsetKt.padding(SizeKt.m144defaultMinSizeVpY3zN4$default(OffsetKt.width(companion, intrinsicSize), CropImageView.DEFAULT_ASPECT_RATIO, 32.0f, 1), paddingValues);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$Horizontal, vertical, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPadding);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z3 = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z3) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    gapComposer.startReplaceGroup(1940381975);
                    OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, CropImageView.DEFAULT_ASPECT_RATIO));
                    gapComposer.end(false);
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 54);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    composableLambdaImpl.invoke((Object) gapComposer, (Object) 0);
                    gapComposer.end(true);
                    if (function3 != null) {
                        gapComposer.startReplaceGroup(1940776698);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                        ComposableLambdaImpl composableLambdaImplM279trailingContentRPmYEkk = ChipKt.m279trailingContentRPmYEkk(function3, this.f$8, gapComposer);
                        if (composableLambdaImplM279trailingContentRPmYEkk != null) {
                            gapComposer.startReplaceGroup(-1684490611);
                            composableLambdaImplM279trailingContentRPmYEkk.invoke((Object) gapComposer, (Object) 0);
                            z2 = false;
                            gapComposer.end(false);
                        } else {
                            z2 = false;
                            gapComposer.startReplaceGroup(-1684412770);
                            gapComposer.end(false);
                        }
                        z = true;
                        gapComposer.end(true);
                        gapComposer.end(z2);
                    } else {
                        z = true;
                        gapComposer.startReplaceGroup(1941196407);
                        OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, CropImageView.DEFAULT_ASPECT_RATIO));
                        gapComposer.end(false);
                    }
                    gapComposer.end(z);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ScrimKt.m319ScrimyrwZFoE((String) obj4, (Modifier) obj3, (Function0) function2, (Function0) function, this.f$8, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda11(String str, Modifier modifier, Function0 function0, Function0 function1, long j, int i) {
        this.f$1 = str;
        this.f$2 = modifier;
        this.f$5 = function0;
        this.f$7 = function1;
        this.f$8 = j;
    }
}
