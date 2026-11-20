package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.foundation.CanvasKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import io.ktor.websocket.ControlFramesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidView_androidKt {
    public static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = new AndroidViewHolder_androidKt$NoOpScrollConnection$1();
    public static final SaversKt$$ExternalSyntheticLambda6 NoOpUpdate = new SaversKt$$ExternalSyntheticLambda6((byte) 23);

    public static final void AndroidView(int i, Composer composer, Modifier modifier, final Function1 function1) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-180024211);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        int i3 = i2 | 384;
        int i4 = i & 3072;
        SaversKt$$ExternalSyntheticLambda6 saversKt$$ExternalSyntheticLambda6 = NoOpUpdate;
        if (i4 == 0) {
            i3 |= gapComposer.changedInstance(saversKt$$ExternalSyntheticLambda6) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(saversKt$$ExternalSyntheticLambda6) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier.then(FocusGroupPropertiesElement.INSTANCE).then(FocusTargetNode.FocusTargetElement.INSTANCE).then(FocusTargetPropertiesElement.INSTANCE).then(FocusTargetInteropElement.INSTANCE));
            Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            LifecycleOwner lifecycleOwner = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) gapComposer.consume(LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner);
            gapComposer.startReplaceGroup(1314774735);
            int i5 = i3 & 14;
            final int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            final Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
            final View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            boolean zChangedInstance = gapComposer.changedInstance(context) | ((((i5 & 14) ^ 6) > 4 && gapComposer.changed(function1)) || (i5 & 6) == 4) | gapComposer.changedInstance(compositionContextImplRememberCompositionContext) | gapComposer.changedInstance(saveableStateRegistry) | gapComposer.changed(iHashCode2) | gapComposer.changedInstance(view);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                Function0 function0 = new Function0() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        KeyEvent.Callback callback = view;
                        callback.getClass();
                        return new ViewFactoryHolder(context, function1, compositionContextImplRememberCompositionContext, saveableStateRegistry, iHashCode2, (Owner) callback).getLayoutNode();
                    }
                };
                gapComposer.updateRememberedValue(function0);
                objRememberedValue = function0;
            }
            Function0 function2 = (Function0) objRememberedValue;
            gapComposer.m384startAzEfcrM(ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, 1, null, null);
            gapComposer.nodeExpected = true;
            if (gapComposer.inserting) {
                gapComposer.createNode(function2);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode.Companion.getClass();
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, new SaversKt$$ExternalSyntheticLambda5((byte) 16));
            Stack.m390setimpl(gapComposer, density, new SaversKt$$ExternalSyntheticLambda5((byte) 17));
            Stack.m390setimpl(gapComposer, lifecycleOwner, new SaversKt$$ExternalSyntheticLambda5((byte) 18));
            Stack.m390setimpl(gapComposer, savedStateRegistryOwner, new SaversKt$$ExternalSyntheticLambda5((byte) 19));
            Stack.m390setimpl(gapComposer, layoutDirection, new SaversKt$$ExternalSyntheticLambda5((byte) 13));
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m390setimpl(gapComposer, saversKt$$ExternalSyntheticLambda6, new SaversKt$$ExternalSyntheticLambda5((byte) 14));
            Stack.m390setimpl(gapComposer, saversKt$$ExternalSyntheticLambda6, new SaversKt$$ExternalSyntheticLambda5((byte) 15));
            gapComposer.end(true);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CanvasKt$$ExternalSyntheticLambda0(function1, modifier, i);
        }
    }

    public static final View getEmbeddedView(Modifier.Node node) {
        ViewFactoryHolder viewFactoryHolder = HitTestResultKt.requireLayoutNode(node.node).interopViewFactoryHolder;
        View interopView = viewFactoryHolder != null ? viewFactoryHolder.getInteropView() : null;
        if (interopView != null) {
            return interopView;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Could not fetch interop view");
        return null;
    }

    public static final void layoutAccordingTo(ViewFactoryHolder viewFactoryHolder, LayoutNode layoutNode) {
        long jMo606localToRootMKHz9U = ((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).mo606localToRootMKHz9U(0L);
        int iRound = Math.round(Float.intBitsToFloat((int) (jMo606localToRootMKHz9U >> 32)));
        int iRound2 = Math.round(Float.intBitsToFloat((int) (jMo606localToRootMKHz9U & 4294967295L)));
        viewFactoryHolder.layout(iRound, iRound2, viewFactoryHolder.getMeasuredWidth() + iRound, viewFactoryHolder.getMeasuredHeight() + iRound2);
    }

    public static final ViewFactoryHolder requireViewFactoryHolder(LayoutNode layoutNode) {
        ViewFactoryHolder viewFactoryHolder = layoutNode.interopViewFactoryHolder;
        if (viewFactoryHolder != null) {
            return viewFactoryHolder;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$2("Required value was null.");
    }

    public static final void AndroidView(Function1 function1, Modifier modifier, Function1 function2, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1783766393);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        int i3 = i2 | 384;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            AndroidView((i3 & 14) | 3072 | (i3 & 112) | ((i3 << 6) & 57344), gapComposer, modifier, function1);
            function2 = NoOpUpdate;
        } else {
            gapComposer.skipToGroupEnd();
        }
        Function1 function3 = function2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 12, i, (Object) function1, (Object) modifier, (Object) function3);
        }
    }
}
