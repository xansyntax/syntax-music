package androidx.compose.ui.window;

import android.view.View;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda37;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidDialog_androidKt {
    public static final ComposableLambdaImpl lambda$210148896 = new ComposableLambdaImpl(false, 210148896, new SaversKt$$ExternalSyntheticLambda5(20));

    /* JADX INFO: renamed from: lambda$-1131826196, reason: not valid java name */
    public static final ComposableLambdaImpl f7lambda$1131826196 = new ComposableLambdaImpl(false, -1131826196, new SaversKt$$ExternalSyntheticLambda5(21));

    public static final void Dialog(Function0 function0, DialogProperties dialogProperties, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        Object obj;
        byte b;
        Object obj2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(826668973);
        byte b2 = 2;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(dialogProperties) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        int i3 = i2;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
            Object[] objArr = new Object[0];
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                obj = objRememberedValue;
                UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((byte) 5);
                gapComposer.updateRememberedValue(utilsKt$$ExternalSyntheticLambda0);
                obj = utilsKt$$ExternalSyntheticLambda0;
            }
            obj = objRememberedValue;
            UUID uuid = (UUID) SaverKt.rememberSaveable(objArr, (Function0) obj, gapComposer, 48);
            boolean zChanged = gapComposer.changed((int) dialogProperties.windowType) | gapComposer.changed(view) | gapComposer.changed(density) | gapComposer.changed((Object) null);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                DialogWrapper dialogWrapper = new DialogWrapper(function0, dialogProperties, view, layoutDirection, density, uuid);
                ComposableLambdaImpl composableLambdaImpl2 = new ComposableLambdaImpl(true, -1338939603, new SongMenuKt$$ExternalSyntheticLambda37(mutableStateRememberUpdatedState, b2));
                DialogLayout dialogLayout = dialogWrapper.dialogLayout;
                dialogLayout.setParentCompositionContext(compositionContextImplRememberCompositionContext);
                dialogLayout.content$delegate.setValue(composableLambdaImpl2);
                dialogLayout.shouldCreateCompositionOnAttachedToWindow = true;
                dialogLayout.createComposition();
                gapComposer.updateRememberedValue(dialogWrapper);
                objRememberedValue2 = dialogWrapper;
            }
            DialogWrapper dialogWrapper2 = (DialogWrapper) objRememberedValue2;
            boolean zChangedInstance = gapComposer.changedInstance(dialogWrapper2);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                b = 1;
                DialogWrapper$$ExternalSyntheticLambda0 dialogWrapper$$ExternalSyntheticLambda0 = new DialogWrapper$$ExternalSyntheticLambda0(dialogWrapper2, b);
                gapComposer.updateRememberedValue(dialogWrapper$$ExternalSyntheticLambda0);
                obj2 = dialogWrapper$$ExternalSyntheticLambda0;
            } else {
                b = 1;
                obj2 = objRememberedValue3;
            }
            Stack.DisposableEffect(dialogWrapper2, (Function1) obj2, gapComposer);
            boolean z = (((((gapComposer.changedInstance(dialogWrapper2) ? 1 : 0) | ((i3 & 14) == 4 ? b : (byte) 0)) | ((i3 & 112) == 32 ? b : (byte) 0)) | (gapComposer.changed(layoutDirection.ordinal()) ? 1 : 0)) == true ? 1 : 0) | (gapComposer.changed(density) ? 1 : 0);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (z != 0 || objRememberedValue4 == neverEqualPolicy) {
                SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) dialogWrapper2, function0, (Object) dialogProperties, (Object) layoutDirection, (Object) density, (byte) 2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda40;
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 13, i, (Object) function0, (Object) dialogProperties, (Object) composableLambdaImpl);
        }
    }

    public static final void DialogLayout(Modifier modifier, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1090521195);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i | (gapComposer.changedInstance(function2) ? 32 : 16);
        byte b = 3;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE$1;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            int i3 = (((((i2 << 3) & 112) | (((i2 >> 3) & 14) | 384)) << 6) & 896) | 6;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            function2.invoke(gapComposer, Integer.valueOf((i3 >> 6) & 14));
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(modifier, function2, i, b);
        }
    }
}
