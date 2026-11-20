package androidx.compose.ui.window;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.foundation.text.TextMeasurePolicy;
import androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.metrolist.music.App;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda73;
import java.util.UUID;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPopup_androidKt {
    public static final StaticProvidableCompositionLocal LocalPopupTestTag = new StaticProvidableCompositionLocal(new UtilsKt$$ExternalSyntheticLambda0(7), (byte) 1);
    public static final StaticProvidableCompositionLocal LocalIsInPopupLayout = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 4), (byte) 1);

    /* JADX WARN: Code duplicated, block: B:101:0x0238  */
    /* JADX WARN: Code duplicated, block: B:102:0x023e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0263  */
    /* JADX WARN: Code duplicated, block: B:107:0x026d  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0054  */
    /* JADX WARN: Code duplicated, block: B:33:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:51:0x0104  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115  */
    /* JADX WARN: Code duplicated, block: B:55:0x0117  */
    /* JADX WARN: Code duplicated, block: B:58:0x011f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0121  */
    /* JADX WARN: Code duplicated, block: B:63:0x013e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0160  */
    /* JADX WARN: Code duplicated, block: B:69:0x0162  */
    /* JADX WARN: Code duplicated, block: B:72:0x0168  */
    /* JADX WARN: Code duplicated, block: B:73:0x016a  */
    /* JADX WARN: Code duplicated, block: B:79:0x018b  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:98:0x0213  */
    public static final void Popup(PopupPositionProvider popupPositionProvider, Function0 function0, PopupProperties popupProperties, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        Function0 function1;
        PopupProperties popupProperties2;
        int i4;
        boolean z;
        Function0 function2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function0 function3;
        View view;
        Density density;
        String str;
        LayoutDirection layoutDirection;
        GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext;
        MutableState mutableStateRememberUpdatedState;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        Object obj;
        UUID uuid;
        boolean zBooleanValue;
        Object objRememberedValue2;
        byte b;
        String str2;
        Density density2;
        PopupLayout popupLayout;
        int i5;
        byte b2;
        int i6;
        byte b3;
        boolean z2;
        Object objRememberedValue3;
        byte b4;
        byte b5;
        boolean z3;
        Object objRememberedValue4;
        byte b6;
        int i7;
        Object obj2;
        boolean zChangedInstance;
        Object obj3;
        boolean zChangedInstance2;
        Object obj4;
        boolean zChangedInstance3;
        Object obj5;
        int i8;
        int i9;
        PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1772091631);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                function1 = function0;
                i3 |= gapComposer.changedInstance(function1) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                popupProperties2 = popupProperties;
                if (gapComposer.changed(popupProperties2)) {
                    i9 = 256;
                } else {
                    i9 = 128;
                }
                i3 |= i9;
            } else {
                popupProperties2 = popupProperties;
            }
            if ((i & 3072) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i3 |= i8;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z)) {
                if (i10 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
                density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                str = (String) gapComposer.consume(LocalPopupTestTag);
                layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
                Object[] objArr = new Object[0];
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                obj = objRememberedValue;
                if (objRememberedValue == neverEqualPolicy) {
                    UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((byte) 6);
                    gapComposer.updateRememberedValue(utilsKt$$ExternalSyntheticLambda0);
                    obj = utilsKt$$ExternalSyntheticLambda0;
                }
                uuid = (UUID) SaverKt.rememberSaveable(objArr, (Function0) obj, gapComposer, 48);
                zBooleanValue = ((Boolean) gapComposer.consume(LocalIsInPopupLayout)).booleanValue();
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    b = 0;
                    str2 = str;
                    density2 = density;
                    PopupLayout popupLayout2 = new PopupLayout(function3, popupProperties2, str2, view, density2, popupPositionProvider2, uuid, zBooleanValue);
                    popupPositionProvider2 = popupPositionProvider2;
                    popupLayout2.setContent(compositionContextImplRememberCompositionContext, new ComposableLambdaImpl(true, -297523940, new AndroidPopup_androidKt$$ExternalSyntheticLambda1(popupLayout2, mutableStateRememberUpdatedState, b)));
                    gapComposer.updateRememberedValue(popupLayout2);
                    objRememberedValue2 = popupLayout2;
                } else {
                    b = 0;
                    str2 = str;
                    density2 = density;
                }
                popupLayout = (PopupLayout) objRememberedValue2;
                boolean zChangedInstance4 = gapComposer.changedInstance(popupLayout);
                i5 = i4 & 112;
                if (i5 == 32) {
                    b2 = 1;
                } else {
                    b2 = b;
                }
                int i11 = (zChangedInstance4 ? 1 : 0) | b2;
                i6 = i4 & 896;
                if (i6 == 256) {
                    b3 = 1;
                } else {
                    b3 = b;
                }
                z2 = (((i11 | b3) | (gapComposer.changed(str2) ? 1 : 0)) == true ? 1 : 0) | (gapComposer.changed(layoutDirection.ordinal()) ? 1 : 0) | (gapComposer.changed(density2) ? 1 : 0);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (z2 || objRememberedValue3 == neverEqualPolicy) {
                    SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda20 = new SongMenuKt$$ExternalSyntheticLambda20(popupLayout, function3, popupProperties, str2, layoutDirection, density2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda20);
                    objRememberedValue3 = songMenuKt$$ExternalSyntheticLambda20;
                }
                Stack.DisposableEffect(popupLayout, (Function1) objRememberedValue3, gapComposer);
                boolean zChangedInstance5 = gapComposer.changedInstance(popupLayout);
                if (i5 == 32) {
                    b4 = 1;
                } else {
                    b4 = b;
                }
                int i12 = b4 | (zChangedInstance5 ? 1 : 0);
                if (i6 == 256) {
                    b5 = 1;
                } else {
                    b5 = b;
                }
                z3 = ((((i12 == true ? 1 : 0) | b5) | (gapComposer.changed(str2) ? 1 : 0)) == true ? 1 : 0) | (gapComposer.changed(layoutDirection.ordinal()) ? 1 : 0) | (gapComposer.changed(density2) ? 1 : 0);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (z3 || objRememberedValue4 == neverEqualPolicy) {
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73((Object) popupLayout, (Object) function3, (Object) popupProperties, str2, (Object) layoutDirection, (Object) density2, (byte) 3);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                    objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda73;
                }
                Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
                boolean zChangedInstance6 = gapComposer.changedInstance(popupLayout);
                b6 = 4;
                if ((i4 & 14) == 4) {
                    b = 1;
                }
                i7 = (zChangedInstance6 ? 1 : 0) | b;
                Object objRememberedValue5 = gapComposer.rememberedValue();
                obj2 = objRememberedValue5;
                if (i7 == 0 || objRememberedValue5 == neverEqualPolicy) {
                    QuickJs$$ExternalSyntheticLambda1 quickJs$$ExternalSyntheticLambda1 = new QuickJs$$ExternalSyntheticLambda1(popupLayout, popupPositionProvider2, b6);
                    gapComposer.updateRememberedValue(quickJs$$ExternalSyntheticLambda1);
                    obj2 = quickJs$$ExternalSyntheticLambda1;
                }
                Stack.DisposableEffect(popupPositionProvider2, (Function1) obj2, gapComposer);
                zChangedInstance = gapComposer.changedInstance(popupLayout);
                Object objRememberedValue6 = gapComposer.rememberedValue();
                obj3 = objRememberedValue6;
                if (zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                    App.C01391 c01391 = new App.C01391((Object) popupLayout, (Continuation) null, (byte) 1);
                    gapComposer.updateRememberedValue(c01391);
                    obj3 = c01391;
                }
                Stack.LaunchedEffect(gapComposer, popupLayout, (Function2) obj3);
                zChangedInstance2 = gapComposer.changedInstance(popupLayout);
                Object objRememberedValue7 = gapComposer.rememberedValue();
                obj4 = objRememberedValue7;
                if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy) {
                    PopupLayout$$ExternalSyntheticLambda3 popupLayout$$ExternalSyntheticLambda3 = new PopupLayout$$ExternalSyntheticLambda3(popupLayout, (byte) 1);
                    gapComposer.updateRememberedValue(popupLayout$$ExternalSyntheticLambda3);
                    obj4 = popupLayout$$ExternalSyntheticLambda3;
                }
                Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(Modifier.Companion.$$INSTANCE, (Function1) obj4);
                zChangedInstance3 = gapComposer.changedInstance(popupLayout) | gapComposer.changed(layoutDirection.ordinal());
                Object objRememberedValue8 = gapComposer.rememberedValue();
                obj5 = objRememberedValue8;
                if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                    TextMeasurePolicy textMeasurePolicy = new TextMeasurePolicy(popupLayout, layoutDirection, (byte) 1);
                    gapComposer.updateRememberedValue(textMeasurePolicy);
                    obj5 = textMeasurePolicy;
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) obj5;
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierOnGloballyPositioned);
                ComposeUiNode.Companion.getClass();
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
                gapComposer.end(true);
                function2 = function3;
            } else {
                gapComposer.skipToGroupEnd();
                function2 = function1;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda3(popupPositionProvider2, function2, popupProperties, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 48;
        function1 = function0;
        if ((i & 384) == 0) {
            popupProperties2 = popupProperties;
            if (gapComposer.changed(popupProperties2)) {
                i9 = 256;
            } else {
                i9 = 128;
            }
            i3 |= i9;
        } else {
            popupProperties2 = popupProperties;
        }
        if ((i & 3072) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i3 |= i8;
        }
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z)) {
            if (i10 != 0) {
                function3 = null;
            } else {
                function3 = function1;
            }
            view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            str = (String) gapComposer.consume(LocalPopupTestTag);
            layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
            Object[] objArr2 = new Object[0];
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer.Companion.Empty;
            obj = objRememberedValue;
            if (objRememberedValue == neverEqualPolicy) {
                UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda1 = new UtilsKt$$ExternalSyntheticLambda0((byte) 6);
                gapComposer.updateRememberedValue(utilsKt$$ExternalSyntheticLambda1);
                obj = utilsKt$$ExternalSyntheticLambda1;
            }
            uuid = (UUID) SaverKt.rememberSaveable(objArr2, (Function0) obj, gapComposer, 48);
            zBooleanValue = ((Boolean) gapComposer.consume(LocalIsInPopupLayout)).booleanValue();
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                b = 0;
                str2 = str;
                density2 = density;
                PopupLayout popupLayout3 = new PopupLayout(function3, popupProperties2, str2, view, density2, popupPositionProvider2, uuid, zBooleanValue);
                popupPositionProvider2 = popupPositionProvider2;
                popupLayout3.setContent(compositionContextImplRememberCompositionContext, new ComposableLambdaImpl(true, -297523940, new AndroidPopup_androidKt$$ExternalSyntheticLambda1(popupLayout3, mutableStateRememberUpdatedState, b)));
                gapComposer.updateRememberedValue(popupLayout3);
                objRememberedValue2 = popupLayout3;
            } else {
                b = 0;
                str2 = str;
                density2 = density;
            }
            popupLayout = (PopupLayout) objRememberedValue2;
            boolean zChangedInstance7 = gapComposer.changedInstance(popupLayout);
            i5 = i4 & 112;
            if (i5 == 32) {
                b2 = 1;
            } else {
                b2 = b;
            }
            int i13 = (zChangedInstance7 ? 1 : 0) | b2;
            i6 = i4 & 896;
            if (i6 == 256) {
                b3 = 1;
            } else {
                b3 = b;
            }
            z2 = (((i13 | b3) | (gapComposer.changed(str2) ? 1 : 0)) == true ? 1 : 0) | (gapComposer.changed(layoutDirection.ordinal()) ? 1 : 0) | (gapComposer.changed(density2) ? 1 : 0);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (z2) {
                SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda21 = new SongMenuKt$$ExternalSyntheticLambda20(popupLayout, function3, popupProperties, str2, layoutDirection, density2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda21);
                objRememberedValue3 = songMenuKt$$ExternalSyntheticLambda21;
            } else {
                SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda22 = new SongMenuKt$$ExternalSyntheticLambda20(popupLayout, function3, popupProperties, str2, layoutDirection, density2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda22);
                objRememberedValue3 = songMenuKt$$ExternalSyntheticLambda22;
            }
            Stack.DisposableEffect(popupLayout, (Function1) objRememberedValue3, gapComposer);
            boolean zChangedInstance8 = gapComposer.changedInstance(popupLayout);
            if (i5 == 32) {
                b4 = 1;
            } else {
                b4 = b;
            }
            int i14 = b4 | (zChangedInstance8 ? 1 : 0);
            if (i6 == 256) {
                b5 = 1;
            } else {
                b5 = b;
            }
            z3 = ((((i14 == true ? 1 : 0) | b5) | (gapComposer.changed(str2) ? 1 : 0)) == true ? 1 : 0) | (gapComposer.changed(layoutDirection.ordinal()) ? 1 : 0) | (gapComposer.changed(density2) ? 1 : 0);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (z3) {
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda74 = new SongMenuKt$$ExternalSyntheticLambda73((Object) popupLayout, (Object) function3, (Object) popupProperties, str2, (Object) layoutDirection, (Object) density2, (byte) 3);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda74);
                objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda74;
            } else {
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda75 = new SongMenuKt$$ExternalSyntheticLambda73((Object) popupLayout, (Object) function3, (Object) popupProperties, str2, (Object) layoutDirection, (Object) density2, (byte) 3);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda75);
                objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda75;
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
            boolean zChangedInstance9 = gapComposer.changedInstance(popupLayout);
            b6 = 4;
            if ((i4 & 14) == 4) {
                b = 1;
            }
            i7 = (zChangedInstance9 ? 1 : 0) | b;
            Object objRememberedValue9 = gapComposer.rememberedValue();
            obj2 = objRememberedValue9;
            if (i7 == 0) {
                QuickJs$$ExternalSyntheticLambda1 quickJs$$ExternalSyntheticLambda2 = new QuickJs$$ExternalSyntheticLambda1(popupLayout, popupPositionProvider2, b6);
                gapComposer.updateRememberedValue(quickJs$$ExternalSyntheticLambda2);
                obj2 = quickJs$$ExternalSyntheticLambda2;
            } else {
                QuickJs$$ExternalSyntheticLambda1 quickJs$$ExternalSyntheticLambda3 = new QuickJs$$ExternalSyntheticLambda1(popupLayout, popupPositionProvider2, b6);
                gapComposer.updateRememberedValue(quickJs$$ExternalSyntheticLambda3);
                obj2 = quickJs$$ExternalSyntheticLambda3;
            }
            Stack.DisposableEffect(popupPositionProvider2, (Function1) obj2, gapComposer);
            zChangedInstance = gapComposer.changedInstance(popupLayout);
            Object objRememberedValue10 = gapComposer.rememberedValue();
            obj3 = objRememberedValue10;
            if (zChangedInstance) {
                App.C01391 c01392 = new App.C01391((Object) popupLayout, (Continuation) null, (byte) 1);
                gapComposer.updateRememberedValue(c01392);
                obj3 = c01392;
            } else {
                App.C01391 c01393 = new App.C01391((Object) popupLayout, (Continuation) null, (byte) 1);
                gapComposer.updateRememberedValue(c01393);
                obj3 = c01393;
            }
            Stack.LaunchedEffect(gapComposer, popupLayout, (Function2) obj3);
            zChangedInstance2 = gapComposer.changedInstance(popupLayout);
            Object objRememberedValue11 = gapComposer.rememberedValue();
            obj4 = objRememberedValue11;
            if (zChangedInstance2) {
                PopupLayout$$ExternalSyntheticLambda3 popupLayout$$ExternalSyntheticLambda4 = new PopupLayout$$ExternalSyntheticLambda3(popupLayout, (byte) 1);
                gapComposer.updateRememberedValue(popupLayout$$ExternalSyntheticLambda4);
                obj4 = popupLayout$$ExternalSyntheticLambda4;
            } else {
                PopupLayout$$ExternalSyntheticLambda3 popupLayout$$ExternalSyntheticLambda5 = new PopupLayout$$ExternalSyntheticLambda3(popupLayout, (byte) 1);
                gapComposer.updateRememberedValue(popupLayout$$ExternalSyntheticLambda5);
                obj4 = popupLayout$$ExternalSyntheticLambda5;
            }
            Modifier modifierOnGloballyPositioned2 = RulerKt.onGloballyPositioned(Modifier.Companion.$$INSTANCE, (Function1) obj4);
            zChangedInstance3 = gapComposer.changedInstance(popupLayout) | gapComposer.changed(layoutDirection.ordinal());
            Object objRememberedValue12 = gapComposer.rememberedValue();
            obj5 = objRememberedValue12;
            if (zChangedInstance3) {
                TextMeasurePolicy textMeasurePolicy2 = new TextMeasurePolicy(popupLayout, layoutDirection, (byte) 1);
                gapComposer.updateRememberedValue(textMeasurePolicy2);
                obj5 = textMeasurePolicy2;
            } else {
                TextMeasurePolicy textMeasurePolicy3 = new TextMeasurePolicy(popupLayout, layoutDirection, (byte) 1);
                gapComposer.updateRememberedValue(textMeasurePolicy3);
                obj5 = textMeasurePolicy3;
            }
            MeasurePolicy measurePolicy2 = (MeasurePolicy) obj5;
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierOnGloballyPositioned2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            gapComposer.end(true);
            function2 = function3;
        } else {
            gapComposer.skipToGroupEnd();
            function2 = function1;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda3(popupPositionProvider2, function2, popupProperties, composableLambdaImpl, i, i2);
        }
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }
}
