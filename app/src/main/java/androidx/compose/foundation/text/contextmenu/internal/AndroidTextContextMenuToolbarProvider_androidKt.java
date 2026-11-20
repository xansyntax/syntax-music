package androidx.compose.foundation.text.contextmenu.internal;

import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.contextmenu.ProcessTextApi23Impl$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidTextContextMenuToolbarProvider_androidKt {
    public static final ComposableLambdaImpl lambda$636288403 = new ComposableLambdaImpl(false, 636288403, new ProcessTextApi23Impl$$ExternalSyntheticLambda1((byte) 1));

    /* JADX INFO: renamed from: lambda$-1357803046, reason: not valid java name */
    public static final ComposableLambdaImpl f2lambda$1357803046 = new ComposableLambdaImpl(false, -1357803046, new ProcessTextApi23Impl$$ExternalSyntheticLambda1((byte) 2));

    public static final void ProvideBothDefaultProviders(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(790527681);
        byte b = 4;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
                gapComposer.updateRememberedValue(parcelableSnapshotMutableState);
                objRememberedValue = parcelableSnapshotMutableState;
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 7);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            PopupProperties popupProperties = DefaultTextContextMenuDropdownProvider_androidKt.DefaultPopupProperties;
            BasicTextContextMenuProvider basicTextContextMenuProvider = DatabaseDao_Impl.AnonymousClass17.basicTextContextMenuProvider(f2lambda$1357803046, gapComposer, 6);
            modifier2 = modifier;
            composableLambdaImpl2 = composableLambdaImpl;
            Stack.CompositionLocalProvider(new ProvidedValue[]{TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider.defaultProvidedValue$runtime(platformTextContextMenuToolbarProvider(function0, gapComposer, 2)), TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider.defaultProvidedValue$runtime(basicTextContextMenuProvider)}, Expect_jvmKt.rememberComposableLambda(1070596993, new PlayerKt$$ExternalSyntheticLambda92((Object) modifier2, (State) mutableState, (Object) composableLambdaImpl2, (Object) basicTextContextMenuProvider, (Object) function0, (byte) 1), gapComposer), gapComposer, 56);
        } else {
            modifier2 = modifier;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier2, composableLambdaImpl2, i, b);
        }
    }

    public static final void ProvideDefaultPlatformTextContextMenuProviders(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(155925518);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        byte b = 3;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            boolean z = gapComposer.consume(TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider) != null;
            boolean z2 = gapComposer.consume(TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider) != null;
            if (z && z2) {
                gapComposer.startReplaceGroup(-1977187922);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
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
                composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i2 >> 3) & 14));
                gapComposer.end(true);
                gapComposer.end(false);
            } else if (z) {
                gapComposer.startReplaceGroup(-1976997706);
                ProvidePlatformTextContextMenuToolbar(modifier, composableLambdaImpl, gapComposer, i2 & 126);
                gapComposer.end(false);
            } else if (z2) {
                gapComposer.startReplaceGroup(-1976846922);
                DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(modifier, composableLambdaImpl, gapComposer, i2 & 126);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1976716505);
                ProvideBothDefaultProviders(modifier, composableLambdaImpl, gapComposer, i2 & 126);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, b);
        }
    }

    public static final void ProvidePlatformTextContextMenuToolbar(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2064964257);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            ProvidePlatformTextContextMenuToolbar$1(modifier, composableLambdaImpl, gapComposer, ((i2 << 3) & 896) | (i2 & 14) | 48);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, b);
        }
    }

    public static final void ProvidePlatformTextContextMenuToolbar$1(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(771959668);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
                gapComposer.updateRememberedValue(parcelableSnapshotMutableState);
                objRememberedValue = parcelableSnapshotMutableState;
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.CompositionLocalProvider(TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider.defaultProvidedValue$runtime(platformTextContextMenuToolbarProvider((Function0) objRememberedValue2, gapComposer, 0)), Expect_jvmKt.rememberComposableLambda(-291176396, new MainActivity$$ExternalSyntheticLambda9(modifier, mutableState, composableLambdaImpl), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, b);
        }
    }

    public static final AndroidTextContextMenuToolbarProvider platformTextContextMenuToolbarProvider(Function0 function0, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
        boolean zChanged = gapComposer.changed(view);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new AndroidTextContextMenuToolbarProvider(view, null, function0);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) objRememberedValue;
        boolean zChangedInstance = gapComposer.changedInstance(androidTextContextMenuToolbarProvider);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(androidTextContextMenuToolbarProvider, (byte) 3);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(androidTextContextMenuToolbarProvider, (Function1) objRememberedValue2, gapComposer);
        return androidTextContextMenuToolbarProvider;
    }
}
