package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.IntRect;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        OffsetKt.m127PaddingValuesYgX7TsA$default(2, 4.0f);
        ((Boolean) PrecisionPointer.shouldUsePrecisionPointerComponentSizing.getValue()).getClass();
    }

    /* JADX INFO: renamed from: DropdownMenuContent-Qj0Zi0g, reason: not valid java name */
    public static final void m305DropdownMenuContentQj0Zi0g(Modifier modifier, MutableTransitionState mutableTransitionState, Function0 function0, ScrollState scrollState, Shape shape, long j, float f, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        boolean z;
        Object objM;
        boolean z2;
        Object objM2;
        Object menuKt$$ExternalSyntheticLambda2;
        BorderStroke borderStroke;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1278879194);
        int i2 = i | (gapComposer.changed(modifier) ? 4 : 2) | (gapComposer.changed(mutableTransitionState) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128) | (gapComposer.changed(scrollState) ? 2048 : 1024) | (gapComposer.changed(shape) ? 16384 : 8192) | (gapComposer.changed(j) ? 131072 : 65536) | (gapComposer.changed(CropImageView.DEFAULT_ASPECT_RATIO) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(f) ? 8388608 : 4194304) | (gapComposer.changed((Object) null) ? 67108864 : 33554432) | (gapComposer.changedInstance(composableLambdaImpl) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 306783379) != 306783378)) {
            Transition transitionRememberTransition = ArcSplineKt.rememberTransition(mutableTransitionState, "DropDownMenu", gapComposer, (((i2 >> 3) & 14) | 48) & 126);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(1, gapComposer);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(4, gapComposer);
            TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
            boolean zIsSeeking = transitionRememberTransition.isSeeking();
            TagPayloadReader tagPayloadReader = transitionRememberTransition.transitionState;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zIsSeeking) {
                z = false;
                objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                boolean zChanged = gapComposer.changed(transitionRememberTransition);
                objM = gapComposer.rememberedValue();
                if (zChanged || objM == neverEqualPolicy) {
                    Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                    Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        Object currentState = tagPayloadReader.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        gapComposer.updateRememberedValue(currentState);
                        objM = currentState;
                    } catch (Throwable th) {
                        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
                z = false;
                gapComposer.end(false);
            }
            boolean zBooleanValue = ((Boolean) objM).booleanValue();
            gapComposer.startReplaceGroup(-904349302);
            float f2 = zBooleanValue ? 1.0f : 0.8f;
            gapComposer.end(z);
            Float fValueOf = Float.valueOf(f2);
            boolean zChanged2 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 1));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            boolean zBooleanValue2 = ((Boolean) ((State) objRememberedValue).getValue()).booleanValue();
            gapComposer.startReplaceGroup(-904349302);
            float f3 = zBooleanValue2 ? 1.0f : 0.8f;
            gapComposer.end(false);
            Float fValueOf2 = Float.valueOf(f3);
            boolean zChanged3 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 2));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.startReplaceGroup(-257488561);
            gapComposer.end(false);
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf, fValueOf2, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl, gapComposer, 0);
            if (transitionRememberTransition.isSeeking()) {
                z2 = false;
                objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
            } else {
                gapComposer.startReplaceGroup(1666573488);
                boolean zChanged4 = gapComposer.changed(transitionRememberTransition);
                objM2 = gapComposer.rememberedValue();
                if (zChanged4 || objM2 == neverEqualPolicy) {
                    Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object currentState2 = tagPayloadReader.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        gapComposer.updateRememberedValue(currentState2);
                        objM2 = currentState2;
                    } catch (Throwable th2) {
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th2;
                    }
                }
                z2 = false;
                gapComposer.end(false);
            }
            boolean zBooleanValue3 = ((Boolean) objM2).booleanValue();
            gapComposer.startReplaceGroup(2062693622);
            float f4 = zBooleanValue3 ? 1.0f : 0.0f;
            gapComposer.end(z2);
            Float fValueOf3 = Float.valueOf(f4);
            boolean zChanged5 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 3));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            boolean zBooleanValue4 = ((Boolean) ((State) objRememberedValue3).getValue()).booleanValue();
            gapComposer.startReplaceGroup(2062693622);
            float f5 = zBooleanValue4 ? 1.0f : 0.0f;
            gapComposer.end(false);
            Float fValueOf4 = Float.valueOf(f5);
            boolean zChanged6 = gapComposer.changed(transitionRememberTransition);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 4));
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            gapComposer.startReplaceGroup(-1585412933);
            gapComposer.end(false);
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf3, fValueOf4, finiteAnimationSpecM272valueyDoVZcs2, twoWayConverterImpl, gapComposer, 0);
            boolean zBooleanValue5 = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
            boolean zChanged7 = gapComposer.changed(zBooleanValue5) | gapComposer.changed(transitionAnimationStateCreateTransitionAnimation) | ((i2 & 112) == 32) | gapComposer.changed(transitionAnimationStateCreateTransitionAnimation2) | ((i2 & 896) == 256);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged7 || objRememberedValue5 == neverEqualPolicy) {
                borderStroke = null;
                menuKt$$ExternalSyntheticLambda2 = new MenuKt$$ExternalSyntheticLambda2(zBooleanValue5, mutableTransitionState, function0, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2);
                gapComposer.updateRememberedValue(menuKt$$ExternalSyntheticLambda2);
            } else {
                menuKt$$ExternalSyntheticLambda2 = objRememberedValue5;
                borderStroke = null;
            }
            int i3 = i2 >> 9;
            int i4 = i2 >> 6;
            SurfaceKt.m337SurfaceT9BRK9s(ColorKt.graphicsLayer(Modifier.Companion.$$INSTANCE, (Function1) menuKt$$ExternalSyntheticLambda2), shape, j, 0L, CropImageView.DEFAULT_ASPECT_RATIO, f, borderStroke, Expect_jvmKt.rememberComposableLambda(-816027071, new MainActivity$$ExternalSyntheticLambda9((Object) modifier, (Object) scrollState, (Object) composableLambdaImpl, (byte) 5), gapComposer), gapComposer, (i3 & 896) | (i3 & 112) | 12582912 | (57344 & i4) | (458752 & i4) | (i4 & 3670016), 8);
            gapComposer = gapComposer;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda4(modifier, mutableTransitionState, function0, scrollState, shape, j, f, composableLambdaImpl, i);
        }
    }

    public static final void DropdownMenuItemContent(ComposableLambdaImpl composableLambdaImpl, Function0 function0, Modifier modifier, Function2 function2, Function2 function3, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1325192924);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(composableLambdaImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed(menuItemColors) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changed(paddingValues) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 67108864 : 33554432;
        }
        if (gapComposer.shouldExecute(i2 & 1, (38347923 & i2) != 38347922)) {
            Modifier modifierPadding = OffsetKt.padding(SizeKt.m154sizeInqDBjuR0$default(SizeKt.fillMaxWidth(ImageKt.m45clickableO2vRcR0$default(modifier, null, RippleKt.m313rippleOu1YvPQ$default(true, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254), z, null, function0, 24), 1.0f), 112.0f, 48.0f, 280.0f, 8), paddingValues);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
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
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.ProvideTextStyle(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, Expect_jvmKt.rememberComposableLambda(865999929, new MenuKt$$ExternalSyntheticLambda0(function2, menuItemColors, z, function3, composableLambdaImpl), gapComposer), gapComposer, 48);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(composableLambdaImpl, function0, modifier, function2, function3, z, menuItemColors, paddingValues, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0039  */
    /* JADX WARN: Code duplicated, block: B:4:0x0015  */
    public static final long calculateTransformOrigin(IntRect intRect, IntRect intRect2) {
        float fMin;
        int i = intRect2.left;
        int i2 = intRect2.bottom;
        int i3 = intRect2.right;
        int i4 = intRect2.top;
        int i5 = intRect.right;
        int i6 = intRect.top;
        int i7 = intRect.bottom;
        int i8 = intRect.left;
        float fMin2 = 1.0f;
        if (i >= i5) {
            fMin = 0.0f;
        } else if (i3 <= i8) {
            fMin = 1.0f;
        } else if (intRect2.getWidth() == 0) {
            fMin = 0.0f;
        } else {
            fMin = (((Math.min(intRect.right, i3) + Math.max(i8, i)) / 2) - i) / intRect2.getWidth();
        }
        if (i4 >= i7) {
            fMin2 = 0.0f;
        } else if (i2 > i6) {
            if (intRect2.getHeight() == 0) {
                fMin2 = 0.0f;
            } else {
                fMin2 = (((Math.min(i7, i2) + Math.max(i6, i4)) / 2) - i4) / intRect2.getHeight();
            }
        }
        return ColorKt.TransformOrigin(fMin, fMin2);
    }
}
