package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AlertDialogKt {
    public static final PaddingValuesImpl IconPadding = OffsetKt.m128PaddingValuesa9UjIt4$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7);
    public static final PaddingValuesImpl TitlePadding = OffsetKt.m128PaddingValuesa9UjIt4$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7);

    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m237AlertDialogContent4hvqGtA(final ComposableLambdaImpl composableLambdaImpl, Modifier modifier, final Function2 function2, final Function2 function3, final Function2 function4, final Shape shape, final long j, final long j2, final long j3, final long j4, final long j5, Composer composer, final int i) {
        final Modifier modifier2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1378716401);
        int i2 = i | 48 | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | (gapComposer.changed(shape) ? 131072 : 65536) | (gapComposer.changed(j) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(CropImageView.DEFAULT_ASPECT_RATIO) ? 8388608 : 4194304) | (gapComposer.changed(j2) ? 67108864 : 33554432) | (gapComposer.changed(j3) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i2 & 1, ((306783379 & i2) == 306783378 && (((gapComposer.changed(j4) ? (char) 4 : (char) 2) | (gapComposer.changed(j5) ? ' ' : (char) 16)) & 19) == 18) ? false : true)) {
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-652798794, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    TextStyle value;
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    byte b = 1;
                    byte b2 = 0;
                    byte b3 = 2;
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
                        float f = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 20.0f : 24.0f;
                        Modifier modifierPadding = OffsetKt.padding(Modifier.Companion.$$INSTANCE, new PaddingValuesImpl(f, f, f, f));
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                        int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierPadding);
                        ComposeUiNode.Companion.getClass();
                        gapComposer2.startReusableNode();
                        boolean z = gapComposer2.inserting;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (z) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                        Integer numValueOf = Integer.valueOf(iHashCode);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer2);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                        Function2 function5 = function2;
                        if (function5 == null) {
                            gapComposer2.startReplaceGroup(346092326);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(346092327);
                            Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(j3, ContentColorKt.LocalContentColor), Expect_jvmKt.rememberComposableLambda(-1128150638, new StringValuesKt$$ExternalSyntheticLambda0(function5, b3), gapComposer2), gapComposer2, 56);
                            gapComposer2.end(false);
                        }
                        Function2 function6 = function3;
                        if (function6 == null) {
                            gapComposer2.startReplaceGroup(346408309);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(346408310);
                            if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                                gapComposer2.startReplaceGroup(1812109189);
                                value = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, 0L, IntMath.getSp(20), null, null, null, null, 0L, IntMath.getSp(26), null, null, 16646141);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(1812321322);
                                value = CardKt.getValue(8, gapComposer2);
                                gapComposer2.end(false);
                            }
                            Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j4, value, Expect_jvmKt.rememberComposableLambda(71284337, new AlertDialogKt$$ExternalSyntheticLambda9(function5, function6, b2), gapComposer2), gapComposer2, 384);
                            gapComposer2.end(false);
                        }
                        Function2 function7 = function4;
                        if (function7 == null) {
                            gapComposer2.startReplaceGroup(347551589);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(347551590);
                            Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j5, CardKt.getValue(1, gapComposer2), Expect_jvmKt.rememberComposableLambda(705583346, new StringValuesKt$$ExternalSyntheticLambda0(function7, b), gapComposer2), gapComposer2, 384);
                            gapComposer2.end(false);
                        }
                        HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement(Alignment.Companion.End);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, horizontalAlignElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j2, CardKt.getValue(9, gapComposer2), composableLambdaImpl, gapComposer2, 0);
                        gapComposer2.end(true);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer);
            int i3 = i2 >> 12;
            int i4 = (i3 & 896) | (i3 & 112) | 12582918 | ((i2 >> 9) & 57344);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            SurfaceKt.m337SurfaceT9BRK9s(companion, shape, j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, composableLambdaImplRememberComposableLambda, gapComposer, i4, 104);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier2, function2, function3, function4, shape, j, j2, j3, j4, j5, i) { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda5
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ long f$10;
                public final /* synthetic */ long f$11;
                public final /* synthetic */ Function2 f$2;
                public final /* synthetic */ Function2 f$3;
                public final /* synthetic */ Function2 f$4;
                public final /* synthetic */ Shape f$5;
                public final /* synthetic */ long f$6;
                public final /* synthetic */ long f$8;
                public final /* synthetic */ long f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                    AlertDialogKt.m237AlertDialogContent4hvqGtA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$8, this.f$9, this.f$10, this.f$11, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m238AlertDialogFlowRowixp7dh8(float f, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        LayoutDirection layoutDirection;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-917637668);
        int i2 = (gapComposer.changed(8.0f) ? 4 : 2) | i | (gapComposer.changed(f) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalLayoutDirection;
            LayoutDirection layoutDirection2 = (LayoutDirection) gapComposer.consume(staticProvidableCompositionLocal);
            int iOrdinal = layoutDirection2.ordinal();
            if (iOrdinal == 0) {
                layoutDirection = LayoutDirection.Rtl;
            } else {
                if (iOrdinal != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                layoutDirection = LayoutDirection.Ltr;
            }
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(layoutDirection), Expect_jvmKt.rememberComposableLambda(-1986402020, new AlertDialogKt$$ExternalSyntheticLambda11(f, layoutDirection2, composableLambdaImpl), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda12(f, composableLambdaImpl, i);
        }
    }

    /* JADX INFO: renamed from: AlertDialogImpl-wrnwzgE, reason: not valid java name */
    public static final void m239AlertDialogImplwrnwzgE(final Function0 function0, final ComposableLambdaImpl composableLambdaImpl, final Modifier modifier, final Function2 function2, final Function2 function3, final Function2 function4, final Function2 function5, final Shape shape, final long j, final long j2, final long j3, final long j4, final DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        ComposableLambdaImpl composableLambdaImpl2;
        Function2 function6;
        int i4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-867616355);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i3 |= gapComposer.changedInstance(composableLambdaImpl2) ? 32 : 16;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function6 = function2;
            i3 |= gapComposer.changedInstance(function6) ? 2048 : 1024;
        } else {
            function6 = function2;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changedInstance(function5) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(j2) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(j3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(j4) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer.changed(CropImageView.DEFAULT_ASPECT_RATIO) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer.changed(dialogProperties) ? 2048 : 1024;
        }
        int i5 = i4;
        if (gapComposer.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (i5 & 1171) == 1170) ? false : true)) {
            final ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
            final Function2 function7 = function6;
            BasicAlertDialog(function0, modifier, dialogProperties, Expect_jvmKt.rememberComposableLambda(527420759, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    byte b = 0;
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        AlertDialogKt.m237AlertDialogContent4hvqGtA(Expect_jvmKt.rememberComposableLambda(1367541877, new AlertDialogKt$$ExternalSyntheticLambda1(composableLambdaImpl3, function7, b), gapComposer2), null, function3, function4, function5, shape, j, ColorSchemeKt.getValue(25, gapComposer2), j2, j3, j4, gapComposer2, 6);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i3 & 14) | 3072 | ((i3 >> 3) & 112) | ((i5 >> 3) & 896), 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    AlertDialogKt.m239AlertDialogImplwrnwzgE(function0, composableLambdaImpl, modifier, function2, function3, function4, function5, shape, j, j2, j3, j4, dialogProperties, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void BasicAlertDialog(Function0 function0, Modifier modifier, DialogProperties dialogProperties, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(24925658);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= gapComposer.changed(dialogProperties) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            if (i4 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            if (i5 != 0) {
                dialogProperties = new DialogProperties();
            }
            AndroidDialog_androidKt.Dialog(function0, dialogProperties, Expect_jvmKt.rememberComposableLambda(784693091, new AlertDialogKt$$ExternalSyntheticLambda2(modifier, composableLambdaImpl), gapComposer), gapComposer, ((i3 >> 3) & 112) | (i3 & 14) | 384);
        } else {
            gapComposer.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        DialogProperties dialogProperties2 = dialogProperties;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda3(function0, modifier2, dialogProperties2, composableLambdaImpl, i, i2, (byte) 0);
        }
    }
}
