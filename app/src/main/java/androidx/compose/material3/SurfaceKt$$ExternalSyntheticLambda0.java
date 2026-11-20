package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.ChildSemanticsNodeElement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ MutableInteractionSourceImpl f$1;
    public final /* synthetic */ ComposableLambdaImpl f$10;
    public final /* synthetic */ Shape f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ float f$4;
    public final /* synthetic */ BorderStroke f$5;
    public final /* synthetic */ boolean f$6;
    public final /* synthetic */ boolean f$7;
    public final /* synthetic */ Function f$8;
    public final /* synthetic */ float f$9;

    public /* synthetic */ SurfaceKt$$ExternalSyntheticLambda0(Modifier modifier, MutableInteractionSourceImpl mutableInteractionSourceImpl, Shape shape, long j, float f, BorderStroke borderStroke, boolean z, boolean z2, Function function, float f2, ComposableLambdaImpl composableLambdaImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
        this.f$1 = mutableInteractionSourceImpl;
        this.f$2 = shape;
        this.f$3 = j;
        this.f$4 = f;
        this.f$5 = borderStroke;
        this.f$6 = z;
        this.f$7 = z2;
        this.f$8 = function;
        this.f$9 = f2;
        this.f$10 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MinimumInteractiveModifier minimumInteractiveModifier = MinimumInteractiveModifier.INSTANCE;
        ComposableLambdaImpl composableLambdaImpl = this.f$10;
        float f = this.f$9;
        Function function = this.f$8;
        float f2 = this.f$4;
        long j = this.f$3;
        Modifier modifier = this.f$0;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) function;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                    Modifier modifierThen = modifier.then(minimumInteractiveModifier);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = RippleKt.LocalRippleThemeConfiguration;
                    ((RippleThemeConfiguration) gapComposer.consume(staticProvidableCompositionLocal)).getClass();
                    Modifier modifierThen2 = modifierThen.then(companion);
                    long jM341surfaceColorAtElevationCLU3JFs = SurfaceKt.m341surfaceColorAtElevationCLU3JFs(j, f2, gapComposer);
                    float fMo81toPx0680j_4 = ((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f);
                    Shape shape = this.f$2;
                    Modifier modifierM340surfaceXOJAsU = SurfaceKt.m340surfaceXOJAsU(modifierThen2, shape, jM341surfaceColorAtElevationCLU3JFs, this.f$5, fMo81toPx0680j_4);
                    ((RippleThemeConfiguration) gapComposer.consume(staticProvidableCompositionLocal)).getClass();
                    Modifier modifierThen3 = SelectableKt.m181selectableO2vRcR0(modifierM340surfaceXOJAsU, this.f$6, this.f$1, RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, shape, 215), this.f$7, null, function0).then(new ChildSemanticsNodeElement(new TextKt$$ExternalSyntheticLambda0((byte) 21)));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl, gapComposer, true);
                }
                break;
            default:
                Function1 function1 = (Function1) function;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                boolean z = (iIntValue2 & 3) != 2;
                int i = iIntValue2 & 1;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i, z)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    HorizontalAlignmentLine horizontalAlignmentLine2 = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                    Modifier modifierThen4 = modifier.then(minimumInteractiveModifier);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = RippleKt.LocalRippleThemeConfiguration;
                    ((RippleThemeConfiguration) gapComposer2.consume(staticProvidableCompositionLocal2)).getClass();
                    Modifier modifierThen5 = modifierThen4.then(companion);
                    long jM341surfaceColorAtElevationCLU3JFs2 = SurfaceKt.m341surfaceColorAtElevationCLU3JFs(j, f2, gapComposer2);
                    float fMo81toPx0680j_5 = ((Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f);
                    Shape shape2 = this.f$2;
                    Modifier modifierM340surfaceXOJAsU2 = SurfaceKt.m340surfaceXOJAsU(modifierThen5, shape2, jM341surfaceColorAtElevationCLU3JFs2, this.f$5, fMo81toPx0680j_5);
                    ((RippleThemeConfiguration) gapComposer2.consume(staticProvidableCompositionLocal2)).getClass();
                    Modifier modifierThen6 = SelectableKt.m182toggleableO2vRcR0(modifierM340surfaceXOJAsU2, this.f$6, this.f$1, RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, shape2, 215), this.f$7, null, function1).then(new ChildSemanticsNodeElement(new TextKt$$ExternalSyntheticLambda0((byte) 21)));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen6);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl, gapComposer2, true);
                }
                break;
        }
        return unit;
    }
}
