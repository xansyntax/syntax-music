package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.core.provider.CallbackWrapper;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.yalantis.ucrop.R;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SheetDefaultsKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        ArcSplineKt.tween$default(300, 0, EasingKt.FastOutSlowInEasing, 2);
    }

    public static final void DragHandleWithTooltip(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        Modifier modifier2;
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1361920385);
        byte b = 2;
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16);
        byte b2 = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(R.string.m3c_bottom_sheet_drag_handle_description, gapComposer);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
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
            modifier2 = modifier;
            composableLambdaImpl2 = composableLambdaImpl;
            TooltipKt.TooltipBox(TooltipDefaults.m360rememberTooltipPositionProviderHu5FAss(gapComposer), Expect_jvmKt.rememberComposableLambda(1497042086, new MainActivity$$ExternalSyntheticLambda7(strM373getString2EP1pXo, b2), gapComposer), TooltipKt.rememberTooltipState(gapComposer), modifier2, false, composableLambdaImpl2, gapComposer, ((i2 << 9) & 7168) | 48 | ((i2 << 21) & 234881024), 240);
            gapComposer.end(true);
        } else {
            modifier2 = modifier;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(modifier2, composableLambdaImpl2, i, b);
        }
    }

    public static final SheetState rememberBottomSheetState(Composer composer) {
        SheetValue sheetValue = SheetValue.PartiallyExpanded;
        SheetValue sheetValue2 = SheetValue.Expanded;
        SheetValue sheetValue3 = SheetValue.Hidden;
        Set set = ArraysKt.toSet(new SheetValue[]{sheetValue3, sheetValue, sheetValue2});
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 4);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        GapComposer gapComposer2 = (GapComposer) composer;
        Density density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
        boolean zChanged = gapComposer2.changed(density) | gapComposer2.changed(56.0f);
        Object objRememberedValue2 = gapComposer2.rememberedValue();
        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new SheetDefaultsKt$$ExternalSyntheticLambda0(density, (byte) 0);
            gapComposer2.updateRememberedValue(objRememberedValue2);
        }
        Function0 function0 = (Function0) objRememberedValue2;
        boolean zChanged2 = gapComposer2.changed(density) | gapComposer2.changed(125.0f);
        Object objRememberedValue3 = gapComposer2.rememberedValue();
        if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new SheetDefaultsKt$$ExternalSyntheticLambda0(density, (byte) 3);
            gapComposer2.updateRememberedValue(objRememberedValue3);
        }
        Function0 function2 = (Function0) objRememberedValue3;
        Object[] objArr = {set, function1, Boolean.TRUE};
        CallbackWrapper callbackWrapper = new CallbackWrapper(new ScrollState$$ExternalSyntheticLambda3((byte) 17), new MainActivity$$ExternalSyntheticLambda59((Object) set, (Object) function0, (Object) function2, (Object) function1, (byte) 7), (byte) 7);
        boolean zChangedInstance = gapComposer2.changedInstance(set) | gapComposer2.changed(function0) | gapComposer2.changed(function2) | gapComposer2.changed(function1) | gapComposer2.changed(true);
        Object objRememberedValue4 = gapComposer2.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
            SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) set, function0, (Object) function2, (Object) sheetValue3, (Object) function1, (byte) 1);
            gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
            objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda40;
        }
        return (SheetState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue4, (Composer) gapComposer2, 0);
    }
}
