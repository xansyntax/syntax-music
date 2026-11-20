package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChipKt {
    public static final ChipArrangement DefaultHorizontalArrangement;

    static {
        PaddingValuesImpl paddingValuesImpl = SuggestionChipDefaults.ContentPadding;
        DefaultHorizontalArrangement = new ChipArrangement(SuggestionChipDefaults.HorizontalSpacing);
    }

    /* JADX INFO: renamed from: AnimatingChipContent-lRyMtFw, reason: not valid java name */
    public static final void m274AnimatingChipContentlRyMtFw(final ComposableLambdaImpl composableLambdaImpl, final TextStyle textStyle, final long j, final Function2 function2, final long j2, final long j3, final Arrangement$Horizontal arrangement$Horizontal, final PaddingValues paddingValues, final FiniteAnimationSpec finiteAnimationSpec, final FiniteAnimationSpec finiteAnimationSpec2, final FiniteAnimationSpec finiteAnimationSpec3, final FiniteAnimationSpec finiteAnimationSpec4, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1255048750);
        int i2 = i | (gapComposer.changedInstance(composableLambdaImpl) ? 4 : 2) | (gapComposer.changed(textStyle) ? 32 : 16) | (gapComposer.changed(j) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | (gapComposer.changedInstance(null) ? 16384 : 8192) | (gapComposer.changedInstance(null) ? 131072 : 65536) | (gapComposer.changed(j2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(j3) ? 8388608 : 4194304) | (gapComposer.changed(32.0f) ? 67108864 : 33554432) | (gapComposer.changed(arrangement$Horizontal) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i2 & 1, ((i2 & 306783379) == 306783378 && ((((((gapComposer.changed(paddingValues) ? (char) 4 : (char) 2) | (gapComposer.changedInstance(finiteAnimationSpec) ? ' ' : (char) 16)) | (gapComposer.changedInstance(finiteAnimationSpec2) ? 256 : 128)) | (gapComposer.changedInstance(finiteAnimationSpec3) ? 2048 : 1024)) | (gapComposer.changedInstance(finiteAnimationSpec4) ? (char) 16384 : (char) 8192)) & 9363) == 9362) ? false : true)) {
            Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(j, ContentColorKt.LocalContentColor), TextKt.LocalTextStyle.defaultProvidedValue$runtime(textStyle)}, Expect_jvmKt.rememberComposableLambda(-881676654, new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierPadding = OffsetKt.padding(SizeKt.m144defaultMinSizeVpY3zN4$default(SizeKt.m157widthInVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 1000.0f, 1), CropImageView.DEFAULT_ASPECT_RATIO, 32.0f, 1), paddingValues);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$Horizontal, vertical, gapComposer2, 48);
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
                        Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                        Integer numValueOf = Integer.valueOf(iHashCode);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer2);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
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
                        Function2 function3 = function2;
                        boolean z2 = function3 != null;
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                        FiniteAnimationSpec finiteAnimationSpec5 = finiteAnimationSpec3;
                        EnterTransitionImpl enterTransitionImplExpandHorizontally$default = EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpec5, horizontal, 12);
                        FiniteAnimationSpec finiteAnimationSpec6 = finiteAnimationSpec;
                        boolean z3 = z2;
                        EnterTransitionImpl enterTransitionImplPlus = enterTransitionImplExpandHorizontally$default.plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec6, CropImageView.DEFAULT_ASPECT_RATIO, 2));
                        FiniteAnimationSpec finiteAnimationSpec7 = finiteAnimationSpec4;
                        ExitTransitionImpl exitTransitionImplShrinkHorizontally$default = EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpec7, horizontal, 12);
                        FiniteAnimationSpec finiteAnimationSpec8 = finiteAnimationSpec2;
                        CrossfadeKt.AnimatedVisibility(z3, null, enterTransitionImplPlus, exitTransitionImplShrinkHorizontally$default.plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec8, CropImageView.DEFAULT_ASPECT_RATIO, 2)), null, Expect_jvmKt.rememberComposableLambda(-181659180, new ChipKt$$ExternalSyntheticLambda15(j2, function3), gapComposer2), gapComposer2, 1572870);
                        if (function3 == null) {
                            gapComposer2.startReplaceGroup(-37113233);
                            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, CropImageView.DEFAULT_ASPECT_RATIO));
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-37029626);
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(true);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, false);
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 54);
                        int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                        Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl, gapComposer2, true);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                        BiasAlignment.Horizontal horizontal2 = Alignment.Companion.End;
                        CrossfadeKt.AnimatedVisibility(false, null, EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpec5, horizontal2, 12).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec6, CropImageView.DEFAULT_ASPECT_RATIO, 2)), EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpec7, horizontal2, 12).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec8, CropImageView.DEFAULT_ASPECT_RATIO, 2)), null, Expect_jvmKt.rememberComposableLambda(-1090690805, new ChipKt$$ExternalSyntheticLambda16(j3, (byte) 0), gapComposer2), gapComposer2, 1572870);
                        gapComposer2.startReplaceGroup(-1514776840);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, CropImageView.DEFAULT_ASPECT_RATIO));
                        Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, true, true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(textStyle, j, function2, j2, j3, arrangement$Horizontal, paddingValues, finiteAnimationSpec, finiteAnimationSpec2, finiteAnimationSpec3, finiteAnimationSpec4, i) { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda10
                public final /* synthetic */ TextStyle f$1;
                public final /* synthetic */ PaddingValues f$10;
                public final /* synthetic */ FiniteAnimationSpec f$11;
                public final /* synthetic */ FiniteAnimationSpec f$12;
                public final /* synthetic */ FiniteAnimationSpec f$13;
                public final /* synthetic */ FiniteAnimationSpec f$14;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ Function2 f$3;
                public final /* synthetic */ long f$6;
                public final /* synthetic */ long f$7;
                public final /* synthetic */ Arrangement$Horizontal f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ChipKt.m274AnimatingChipContentlRyMtFw(this.f$0, this.f$1, this.f$2, this.f$3, this.f$6, this.f$7, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void AssistChip(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, boolean z, Function2 function2, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, Arrangement$Horizontal arrangement$Horizontal, PaddingValues paddingValues, Composer composer, int i) {
        Modifier modifier2;
        boolean z2;
        ChipElevation chipElevation2;
        Arrangement$Horizontal arrangement$Horizontal2;
        PaddingValues paddingValues2;
        int i2;
        Modifier modifier3;
        ChipElevation chipElevation3;
        PaddingValues paddingValues3;
        boolean z3;
        Arrangement$Horizontal arrangement$Horizontal3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-696418916);
        int i3 = i | 28032 | (gapComposer.changed(shape) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(chipColors) ? 8388608 : 4194304) | 33554432 | (gapComposer.changed(borderStroke) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i3 & 1, (306783379 & i3) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                PaddingValuesImpl paddingValuesImpl = AssistChipDefaults.ContentPadding;
                ChipElevation chipElevation4 = new ChipElevation();
                i2 = i3 & (-234881025);
                PaddingValuesImpl paddingValuesImpl2 = AssistChipDefaults.ContentPadding;
                modifier3 = Modifier.Companion.$$INSTANCE;
                chipElevation3 = chipElevation4;
                paddingValues3 = paddingValuesImpl2;
                z3 = true;
                arrangement$Horizontal3 = DefaultHorizontalArrangement;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-234881025);
                modifier3 = modifier;
                z3 = z;
                chipElevation3 = chipElevation;
                arrangement$Horizontal3 = arrangement$Horizontal;
                paddingValues3 = paddingValues;
            }
            gapComposer.endDefaults();
            TextStyle value = CardKt.getValue(9, gapComposer);
            int i4 = i2;
            long j = z3 ? chipColors.labelColor : chipColors.disabledLabelColor;
            PaddingValuesImpl paddingValuesImpl3 = AssistChipDefaults.ContentPadding;
            int i5 = i4 << 6;
            long j2 = j;
            Modifier modifier4 = modifier3;
            m275ChipEosBjUw(modifier4, function0, z3, composableLambdaImpl, value, j2, function2, shape, chipColors, chipElevation3, borderStroke, arrangement$Horizontal3, paddingValues3, gapComposer, (234881024 & i5) | 14159286 | (i5 & 1879048192), ((i4 >> 24) & 112) | 221568);
            modifier2 = modifier4;
            z2 = z3;
            chipElevation2 = chipElevation3;
            arrangement$Horizontal2 = arrangement$Horizontal3;
            paddingValues2 = paddingValues3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z2 = z;
            chipElevation2 = chipElevation;
            arrangement$Horizontal2 = arrangement$Horizontal;
            paddingValues2 = paddingValues;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda0(function0, composableLambdaImpl, modifier2, z2, function2, shape, chipColors, chipElevation2, borderStroke, arrangement$Horizontal2, paddingValues2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:195:0x02b2  */
    /* JADX INFO: renamed from: Chip-EosBjUw, reason: not valid java name */
    public static final void m275ChipEosBjUw(final Modifier modifier, final Function0 function0, final boolean z, final ComposableLambdaImpl composableLambdaImpl, final TextStyle textStyle, final long j, final Function2 function2, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final Arrangement$Horizontal arrangement$Horizontal, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        float f;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean z4;
        AnimationState animationState;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1954811544);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(textStyle) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer.changed(j) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changedInstance(null) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(chipColors) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(chipElevation) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(borderStroke) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer.changed(32.0f) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer.changed(arrangement$Horizontal) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer.changed((Object) null) ? 131072 : 65536;
        }
        boolean z5 = true;
        if (gapComposer.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (i4 & 74899) == 74898) ? false : true)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(329822563);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue2;
            gapComposer.end(false);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                z2 = false;
                objRememberedValue3 = new ChipKt$$ExternalSyntheticLambda3((byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                z2 = false;
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, z2, (Function1) objRememberedValue3);
            long j2 = z ? chipColors.containerColor : chipColors.disabledContainerColor;
            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
            if (chipElevation == null) {
                gapComposer.startReplaceGroup(330097470);
                gapComposer.end(false);
                mutableInteractionSourceImpl = mutableInteractionSourceImpl;
                animationState = null;
                i3 = i3;
            } else {
                gapComposer.startReplaceGroup(1673216291);
                int i5 = ((i3 >> 6) & 14) | ((i4 << 6) & 896);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
                }
                SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue4;
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                MutableState mutableState = (MutableState) objRememberedValue5;
                boolean zChanged = gapComposer.changed(mutableInteractionSourceImpl);
                Object objRememberedValue6 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new CardElevation$animateElevation$1$1(mutableInteractionSourceImpl, snapshotStateList, null, (byte) 2);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue6);
                Interaction interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                float f3 = (!z || (interaction instanceof PressInteraction.Press) || (interaction instanceof HoverInteraction$Enter) || (interaction instanceof FocusInteraction.Focus) || !(interaction instanceof DragInteraction$Start)) ? 0.0f : 8.0f;
                Object objRememberedValue7 = gapComposer.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new Animatable(new Dp(f3), ArcSplineKt.DpToVector, (Object) null, 12);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                Animatable animatable = (Animatable) objRememberedValue7;
                Dp dp = new Dp(f3);
                boolean zChangedInstance2 = gapComposer.changedInstance(animatable) | gapComposer.changed(f3);
                if (((i5 & 14) ^ 6) > 4) {
                    z3 = z;
                    if (gapComposer.changed(z3)) {
                        f = f3;
                    }
                    zChangedInstance = zChangedInstance2 | z5 | gapComposer.changedInstance(interaction);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        z4 = false;
                        ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$1 = new ChipElevation$animateElevation$2$1(animatable, f, z3, interaction, mutableState, null, (byte) 0);
                        gapComposer.updateRememberedValue(chipElevation$animateElevation$2$1);
                        objRememberedValue = chipElevation$animateElevation$2$1;
                    } else {
                        z4 = false;
                    }
                    Stack.LaunchedEffect(gapComposer, dp, (Function2) objRememberedValue);
                    animationState = animatable.internalState;
                    gapComposer.end(z4);
                } else {
                    z3 = z;
                }
                f = f3;
                if ((i5 & 6) != 4) {
                    z5 = false;
                }
                zChangedInstance = zChangedInstance2 | z5 | gapComposer.changedInstance(interaction);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    z4 = false;
                    ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$2 = new ChipElevation$animateElevation$2$1(animatable, f, z3, interaction, mutableState, null, (byte) 0);
                    gapComposer.updateRememberedValue(chipElevation$animateElevation$2$2);
                    objRememberedValue = chipElevation$animateElevation$2$2;
                } else {
                    z4 = false;
                    ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$3 = new ChipElevation$animateElevation$2$1(animatable, f, z3, interaction, mutableState, null, (byte) 0);
                    gapComposer.updateRememberedValue(chipElevation$animateElevation$2$3);
                    objRememberedValue = chipElevation$animateElevation$2$3;
                }
                Stack.LaunchedEffect(gapComposer, dp, (Function2) objRememberedValue);
                animationState = animatable.internalState;
                gapComposer.end(z4);
            }
            if (animationState != null) {
                f2 = ((Dp) animationState.value$delegate.getValue()).value;
            }
            SurfaceKt.m339Surfaceo_FOJdg(function0, modifierSemantics, z, shape, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, f2, borderStroke, mutableInteractionSourceImpl, Expect_jvmKt.rememberComposableLambda(1333593699, new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        ChipColors chipColors2 = chipColors;
                        boolean z6 = z;
                        ChipKt.m276ChipContentCmOm80E(composableLambdaImpl, textStyle, j, function2, z6 ? chipColors2.leadingIconContentColor : chipColors2.disabledLeadingIconContentColor, z6 ? chipColors2.trailingIconContentColor : chipColors2.disabledTrailingIconContentColor, arrangement$Horizontal, paddingValues, gapComposer2, 24576);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, ((i3 >> 15) & 7168) | ((i3 >> 3) & 14) | (i3 & 896) | ((i4 << 21) & 234881024), 96);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    ChipKt.m275ChipEosBjUw(modifier, function0, z, composableLambdaImpl, textStyle, j, function2, shape, chipColors, chipElevation, borderStroke, arrangement$Horizontal, paddingValues, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ChipContent-CmOm80E, reason: not valid java name */
    public static final void m276ChipContentCmOm80E(final ComposableLambdaImpl composableLambdaImpl, final TextStyle textStyle, final long j, final Function2 function2, final long j2, final long j3, final Arrangement$Horizontal arrangement$Horizontal, final PaddingValues paddingValues, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(897958272);
        int i2 = i | (gapComposer.changedInstance(composableLambdaImpl) ? 4 : 2) | (gapComposer.changed(textStyle) ? 32 : 16) | (gapComposer.changed(j) ? 256 : 128) | (gapComposer.changedInstance(null) ? 2048 : 1024) | (gapComposer.changedInstance(function2) ? 131072 : 65536) | (gapComposer.changed(j2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changed(j3) ? 8388608 : 4194304) | (gapComposer.changed(32.0f) ? 67108864 : 33554432) | (gapComposer.changed(arrangement$Horizontal) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer.shouldExecute(i2 & 1, ((306783379 & i2) == 306783378 && ((gapComposer.changed(paddingValues) ? (char) 4 : (char) 2) & 3) == 2) ? false : true)) {
            Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(j, ContentColorKt.LocalContentColor), TextKt.LocalTextStyle.defaultProvidedValue$runtime(textStyle)}, Expect_jvmKt.rememberComposableLambda(100316352, new ChipKt$$ExternalSyntheticLambda11(paddingValues, arrangement$Horizontal, function2, j2, composableLambdaImpl, j3), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(textStyle, j, function2, j2, j3, arrangement$Horizontal, paddingValues, i) { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda12
                public final /* synthetic */ TextStyle f$1;
                public final /* synthetic */ PaddingValues f$10;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ Function2 f$5;
                public final /* synthetic */ long f$6;
                public final /* synthetic */ long f$7;
                public final /* synthetic */ Arrangement$Horizontal f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(24577);
                    ChipKt.m276ChipContentCmOm80E(this.f$0, this.f$1, this.f$2, this.f$5, this.f$6, this.f$7, this.f$9, this.f$10, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0153 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0155  */
    /* JADX WARN: Code duplicated, block: B:112:0x0158  */
    /* JADX WARN: Code duplicated, block: B:114:0x015b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0160  */
    /* JADX WARN: Code duplicated, block: B:118:0x0169  */
    /* JADX WARN: Code duplicated, block: B:121:0x016e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0181  */
    /* JADX WARN: Code duplicated, block: B:125:0x018f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0198  */
    /* JADX WARN: Code duplicated, block: B:129:0x0206  */
    /* JADX WARN: Code duplicated, block: B:132:0x021c  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x010d  */
    /* JADX WARN: Code duplicated, block: B:96:0x011f  */
    public static final void FilterChip(final boolean z, final Function0 function0, final ComposableLambdaImpl composableLambdaImpl, Modifier modifier, boolean z2, Function2 function2, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, Arrangement$Horizontal arrangement$Horizontal, PaddingValues paddingValues, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        Function2 function3;
        int i7;
        int i8;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        BorderStroke borderStrokeM287filterChipBorder_7El2pE;
        int i9;
        int i10;
        boolean z3;
        final boolean z4;
        final Arrangement$Horizontal arrangement$Horizontal2;
        final PaddingValues paddingValues2;
        final Function2 function4;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final Shape shape3;
        final SelectableChipColors selectableChipColors3;
        final SelectableChipElevation selectableChipElevation2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        Shape value;
        SelectableChipColors defaultFilterChipColors$material3;
        int i11;
        int i12;
        int i13;
        boolean z5;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1511159815);
        int i14 = 4;
        if ((i & 6) == 0) {
            i4 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        int i15 = i3 & 8;
        if (i15 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= gapComposer.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i4 | 24576;
            i6 = i3 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function2;
                    if (gapComposer.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i5 |= i7;
                }
                i8 = i5 | 1572864;
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        int i16 = gapComposer.changed(shape2) ? 8388608 : 4194304;
                        i8 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    i8 |= i16;
                } else {
                    shape2 = shape;
                }
                if ((100663296 & i) == 0) {
                    if ((i3 & 256) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        int i17 = gapComposer.changed(selectableChipColors2) ? 67108864 : 33554432;
                        i8 |= i17;
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i8 |= i17;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    i8 |= WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                        if (!gapComposer.changed(borderStrokeM287filterChipBorder_7El2pE)) {
                        }
                        i9 = i2 | i14;
                    } else {
                        borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                    }
                    i14 = 2;
                    i9 = i2 | i14;
                } else {
                    borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                    i9 = i2;
                }
                i10 = i9 | 3472;
                if ((i8 & 306783379) == 306783378 || (i10 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i8 & 1, z3)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        }
                        if ((i3 & 128) != 0) {
                            PaddingValuesImpl paddingValuesImpl = FilterChipDefaults.ContentPadding;
                            value = ShapesKt.getValue(14, gapComposer);
                            i8 &= -29360129;
                        } else {
                            value = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            PaddingValuesImpl paddingValuesImpl2 = FilterChipDefaults.ContentPadding;
                            defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                            i8 &= -234881025;
                        } else {
                            defaultFilterChipColors$material3 = selectableChipColors2;
                        }
                        PaddingValuesImpl paddingValuesImpl3 = FilterChipDefaults.ContentPadding;
                        SelectableChipElevation selectableChipElevation3 = new SelectableChipElevation();
                        int i18 = i8 & (-1879048193);
                        if ((i3 & 1024) != 0) {
                            borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                            i11 = 3472;
                        } else {
                            i11 = i10;
                        }
                        i12 = i11 & (-113);
                        borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                        i13 = i18;
                        paddingValues2 = FilterChipDefaults.ContentPadding;
                        function4 = function3;
                        shape3 = value;
                        selectableChipColors3 = defaultFilterChipColors$material3;
                        selectableChipElevation2 = selectableChipElevation3;
                        arrangement$Horizontal2 = DefaultHorizontalArrangement;
                        z5 = true;
                    } else {
                        gapComposer.skipToGroupEnd();
                        if ((i3 & 128) != 0) {
                            i8 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i8 &= -234881025;
                        }
                        int i19 = i8 & (-1879048193);
                        i12 = ((i3 & 1024) != 0 ? 3472 : i10) & (-113);
                        arrangement$Horizontal2 = arrangement$Horizontal;
                        function4 = function3;
                        borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                        shape3 = shape2;
                        selectableChipColors3 = selectableChipColors2;
                        z5 = z2;
                        i13 = i19;
                        modifier4 = modifier2;
                        selectableChipElevation2 = selectableChipElevation;
                        paddingValues2 = paddingValues;
                    }
                    gapComposer.endDefaults();
                    TextStyle value2 = CardKt.getValue(9, gapComposer);
                    PaddingValuesImpl paddingValuesImpl4 = FilterChipDefaults.ContentPadding;
                    int i20 = i13 << 3;
                    int i21 = i13 << 6;
                    m277SelectableChip9rhh44(z, modifier4, function0, z5, composableLambdaImpl, value2, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, gapComposer, (i21 & 1879048192) | (i13 & 14) | 12582912 | ((i13 >> 6) & 112) | (i20 & 896) | ((i13 >> 3) & 7168) | (i21 & 57344) | (i20 & 3670016) | (i21 & 234881024), ((i13 >> 24) & 14) | 3072 | ((i12 << 6) & 896) | 1769472);
                    modifier3 = modifier4;
                    z4 = z5;
                } else {
                    gapComposer.skipToGroupEnd();
                    z4 = z2;
                    arrangement$Horizontal2 = arrangement$Horizontal;
                    paddingValues2 = paddingValues;
                    function4 = function3;
                    borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    selectableChipColors3 = selectableChipColors2;
                    selectableChipElevation2 = selectableChipElevation;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            ChipKt.FilterChip(z, function0, composableLambdaImpl, modifier3, z4, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i5 = 221184 | i4;
            function3 = function2;
            i8 = i5 | 1572864;
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (gapComposer.changed(shape2)) {
                    }
                    i8 |= i16;
                } else {
                    shape2 = shape;
                }
                i8 |= i16;
            } else {
                shape2 = shape;
            }
            if ((100663296 & i) == 0) {
                if ((i3 & 256) == 0) {
                    selectableChipColors2 = selectableChipColors;
                    if (gapComposer.changed(selectableChipColors2)) {
                    }
                    i8 |= i17;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                i8 |= i17;
            } else {
                selectableChipColors2 = selectableChipColors;
            }
            if ((i & 805306368) == 0) {
                i8 |= WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                    if (!gapComposer.changed(borderStrokeM287filterChipBorder_7El2pE)) {
                    }
                    i9 = i2 | i14;
                } else {
                    borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                }
                i14 = 2;
                i9 = i2 | i14;
            } else {
                borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                i9 = i2;
            }
            i10 = i9 | 3472;
            if ((i8 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i8 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if ((i3 & 128) != 0) {
                        PaddingValuesImpl paddingValuesImpl5 = FilterChipDefaults.ContentPadding;
                        value = ShapesKt.getValue(14, gapComposer);
                        i8 &= -29360129;
                    } else {
                        value = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        PaddingValuesImpl paddingValuesImpl6 = FilterChipDefaults.ContentPadding;
                        defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                        i8 &= -234881025;
                    } else {
                        defaultFilterChipColors$material3 = selectableChipColors2;
                    }
                    PaddingValuesImpl paddingValuesImpl7 = FilterChipDefaults.ContentPadding;
                    SelectableChipElevation selectableChipElevation4 = new SelectableChipElevation();
                    int i110 = i8 & (-1879048193);
                    if ((i3 & 1024) != 0) {
                        borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                        i11 = 3472;
                    } else {
                        i11 = i10;
                    }
                    i12 = i11 & (-113);
                    borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                    i13 = i110;
                    paddingValues2 = FilterChipDefaults.ContentPadding;
                    function4 = function3;
                    shape3 = value;
                    selectableChipColors3 = defaultFilterChipColors$material3;
                    selectableChipElevation2 = selectableChipElevation4;
                    arrangement$Horizontal2 = DefaultHorizontalArrangement;
                    z5 = true;
                } else {
                    if (i15 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if ((i3 & 128) != 0) {
                        PaddingValuesImpl paddingValuesImpl8 = FilterChipDefaults.ContentPadding;
                        value = ShapesKt.getValue(14, gapComposer);
                        i8 &= -29360129;
                    } else {
                        value = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        PaddingValuesImpl paddingValuesImpl9 = FilterChipDefaults.ContentPadding;
                        defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                        i8 &= -234881025;
                    } else {
                        defaultFilterChipColors$material3 = selectableChipColors2;
                    }
                    PaddingValuesImpl paddingValuesImpl10 = FilterChipDefaults.ContentPadding;
                    SelectableChipElevation selectableChipElevation5 = new SelectableChipElevation();
                    int i111 = i8 & (-1879048193);
                    if ((i3 & 1024) != 0) {
                        borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                        i11 = 3472;
                    } else {
                        i11 = i10;
                    }
                    i12 = i11 & (-113);
                    borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                    i13 = i111;
                    paddingValues2 = FilterChipDefaults.ContentPadding;
                    function4 = function3;
                    shape3 = value;
                    selectableChipColors3 = defaultFilterChipColors$material3;
                    selectableChipElevation2 = selectableChipElevation5;
                    arrangement$Horizontal2 = DefaultHorizontalArrangement;
                    z5 = true;
                }
                gapComposer.endDefaults();
                TextStyle value3 = CardKt.getValue(9, gapComposer);
                PaddingValuesImpl paddingValuesImpl11 = FilterChipDefaults.ContentPadding;
                int i22 = i13 << 3;
                int i23 = i13 << 6;
                m277SelectableChip9rhh44(z, modifier4, function0, z5, composableLambdaImpl, value3, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, gapComposer, (i23 & 1879048192) | (i13 & 14) | 12582912 | ((i13 >> 6) & 112) | (i22 & 896) | ((i13 >> 3) & 7168) | (i23 & 57344) | (i22 & 3670016) | (i23 & 234881024), ((i13 >> 24) & 14) | 3072 | ((i12 << 6) & 896) | 1769472);
                modifier3 = modifier4;
                z4 = z5;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z2;
                arrangement$Horizontal2 = arrangement$Horizontal;
                paddingValues2 = paddingValues;
                function4 = function3;
                borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                modifier3 = modifier2;
                shape3 = shape2;
                selectableChipColors3 = selectableChipColors2;
                selectableChipElevation2 = selectableChipElevation;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        ChipKt.FilterChip(z, function0, composableLambdaImpl, modifier3, z4, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 3072;
        modifier2 = modifier;
        i5 = i4 | 24576;
        i6 = i3 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function3 = function2;
                if (gapComposer.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i5 |= i7;
            }
            i8 = i5 | 1572864;
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (gapComposer.changed(shape2)) {
                    }
                    i8 |= i16;
                } else {
                    shape2 = shape;
                }
                i8 |= i16;
            } else {
                shape2 = shape;
            }
            if ((100663296 & i) == 0) {
                if ((i3 & 256) == 0) {
                    selectableChipColors2 = selectableChipColors;
                    if (gapComposer.changed(selectableChipColors2)) {
                    }
                    i8 |= i17;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                i8 |= i17;
            } else {
                selectableChipColors2 = selectableChipColors;
            }
            if ((i & 805306368) == 0) {
                i8 |= WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                    if (!gapComposer.changed(borderStrokeM287filterChipBorder_7El2pE)) {
                    }
                    i9 = i2 | i14;
                } else {
                    borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                }
                i14 = 2;
                i9 = i2 | i14;
            } else {
                borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                i9 = i2;
            }
            i10 = i9 | 3472;
            if ((i8 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i8 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if ((i3 & 128) != 0) {
                        PaddingValuesImpl paddingValuesImpl12 = FilterChipDefaults.ContentPadding;
                        value = ShapesKt.getValue(14, gapComposer);
                        i8 &= -29360129;
                    } else {
                        value = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        PaddingValuesImpl paddingValuesImpl13 = FilterChipDefaults.ContentPadding;
                        defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                        i8 &= -234881025;
                    } else {
                        defaultFilterChipColors$material3 = selectableChipColors2;
                    }
                    PaddingValuesImpl paddingValuesImpl14 = FilterChipDefaults.ContentPadding;
                    SelectableChipElevation selectableChipElevation6 = new SelectableChipElevation();
                    int i112 = i8 & (-1879048193);
                    if ((i3 & 1024) != 0) {
                        borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                        i11 = 3472;
                    } else {
                        i11 = i10;
                    }
                    i12 = i11 & (-113);
                    borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                    i13 = i112;
                    paddingValues2 = FilterChipDefaults.ContentPadding;
                    function4 = function3;
                    shape3 = value;
                    selectableChipColors3 = defaultFilterChipColors$material3;
                    selectableChipElevation2 = selectableChipElevation6;
                    arrangement$Horizontal2 = DefaultHorizontalArrangement;
                    z5 = true;
                } else {
                    if (i15 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    }
                    if ((i3 & 128) != 0) {
                        PaddingValuesImpl paddingValuesImpl15 = FilterChipDefaults.ContentPadding;
                        value = ShapesKt.getValue(14, gapComposer);
                        i8 &= -29360129;
                    } else {
                        value = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        PaddingValuesImpl paddingValuesImpl16 = FilterChipDefaults.ContentPadding;
                        defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                        i8 &= -234881025;
                    } else {
                        defaultFilterChipColors$material3 = selectableChipColors2;
                    }
                    PaddingValuesImpl paddingValuesImpl17 = FilterChipDefaults.ContentPadding;
                    SelectableChipElevation selectableChipElevation7 = new SelectableChipElevation();
                    int i113 = i8 & (-1879048193);
                    if ((i3 & 1024) != 0) {
                        borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                        i11 = 3472;
                    } else {
                        i11 = i10;
                    }
                    i12 = i11 & (-113);
                    borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                    i13 = i113;
                    paddingValues2 = FilterChipDefaults.ContentPadding;
                    function4 = function3;
                    shape3 = value;
                    selectableChipColors3 = defaultFilterChipColors$material3;
                    selectableChipElevation2 = selectableChipElevation7;
                    arrangement$Horizontal2 = DefaultHorizontalArrangement;
                    z5 = true;
                }
                gapComposer.endDefaults();
                TextStyle value4 = CardKt.getValue(9, gapComposer);
                PaddingValuesImpl paddingValuesImpl18 = FilterChipDefaults.ContentPadding;
                int i24 = i13 << 3;
                int i25 = i13 << 6;
                m277SelectableChip9rhh44(z, modifier4, function0, z5, composableLambdaImpl, value4, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, gapComposer, (i25 & 1879048192) | (i13 & 14) | 12582912 | ((i13 >> 6) & 112) | (i24 & 896) | ((i13 >> 3) & 7168) | (i25 & 57344) | (i24 & 3670016) | (i25 & 234881024), ((i13 >> 24) & 14) | 3072 | ((i12 << 6) & 896) | 1769472);
                modifier3 = modifier4;
                z4 = z5;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z2;
                arrangement$Horizontal2 = arrangement$Horizontal;
                paddingValues2 = paddingValues;
                function4 = function3;
                borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                modifier3 = modifier2;
                shape3 = shape2;
                selectableChipColors3 = selectableChipColors2;
                selectableChipElevation2 = selectableChipElevation;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        ChipKt.FilterChip(z, function0, composableLambdaImpl, modifier3, z4, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i5 = 221184 | i4;
        function3 = function2;
        i8 = i5 | 1572864;
        if ((i & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                shape2 = shape;
                if (gapComposer.changed(shape2)) {
                }
                i8 |= i16;
            } else {
                shape2 = shape;
            }
            i8 |= i16;
        } else {
            shape2 = shape;
        }
        if ((100663296 & i) == 0) {
            if ((i3 & 256) == 0) {
                selectableChipColors2 = selectableChipColors;
                if (gapComposer.changed(selectableChipColors2)) {
                }
                i8 |= i17;
            } else {
                selectableChipColors2 = selectableChipColors;
            }
            i8 |= i17;
        } else {
            selectableChipColors2 = selectableChipColors;
        }
        if ((i & 805306368) == 0) {
            i8 |= WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            if ((i3 & 1024) == 0) {
                borderStrokeM287filterChipBorder_7El2pE = borderStroke;
                if (!gapComposer.changed(borderStrokeM287filterChipBorder_7El2pE)) {
                }
                i9 = i2 | i14;
            } else {
                borderStrokeM287filterChipBorder_7El2pE = borderStroke;
            }
            i14 = 2;
            i9 = i2 | i14;
        } else {
            borderStrokeM287filterChipBorder_7El2pE = borderStroke;
            i9 = i2;
        }
        i10 = i9 | 3472;
        if ((i8 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer.shouldExecute(i8 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    function3 = null;
                }
                if ((i3 & 128) != 0) {
                    PaddingValuesImpl paddingValuesImpl19 = FilterChipDefaults.ContentPadding;
                    value = ShapesKt.getValue(14, gapComposer);
                    i8 &= -29360129;
                } else {
                    value = shape2;
                }
                if ((i3 & 256) != 0) {
                    PaddingValuesImpl paddingValuesImpl110 = FilterChipDefaults.ContentPadding;
                    defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                    i8 &= -234881025;
                } else {
                    defaultFilterChipColors$material3 = selectableChipColors2;
                }
                PaddingValuesImpl paddingValuesImpl111 = FilterChipDefaults.ContentPadding;
                SelectableChipElevation selectableChipElevation8 = new SelectableChipElevation();
                int i114 = i8 & (-1879048193);
                if ((i3 & 1024) != 0) {
                    borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                    i11 = 3472;
                } else {
                    i11 = i10;
                }
                i12 = i11 & (-113);
                borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                i13 = i114;
                paddingValues2 = FilterChipDefaults.ContentPadding;
                function4 = function3;
                shape3 = value;
                selectableChipColors3 = defaultFilterChipColors$material3;
                selectableChipElevation2 = selectableChipElevation8;
                arrangement$Horizontal2 = DefaultHorizontalArrangement;
                z5 = true;
            } else {
                if (i15 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    function3 = null;
                }
                if ((i3 & 128) != 0) {
                    PaddingValuesImpl paddingValuesImpl112 = FilterChipDefaults.ContentPadding;
                    value = ShapesKt.getValue(14, gapComposer);
                    i8 &= -29360129;
                } else {
                    value = shape2;
                }
                if ((i3 & 256) != 0) {
                    PaddingValuesImpl paddingValuesImpl113 = FilterChipDefaults.ContentPadding;
                    defaultFilterChipColors$material3 = FilterChipDefaults.getDefaultFilterChipColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                    i8 &= -234881025;
                } else {
                    defaultFilterChipColors$material3 = selectableChipColors2;
                }
                PaddingValuesImpl paddingValuesImpl114 = FilterChipDefaults.ContentPadding;
                SelectableChipElevation selectableChipElevation9 = new SelectableChipElevation();
                int i115 = i8 & (-1879048193);
                if ((i3 & 1024) != 0) {
                    borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z, gapComposer, 252);
                    i11 = 3472;
                } else {
                    i11 = i10;
                }
                i12 = i11 & (-113);
                borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
                i13 = i115;
                paddingValues2 = FilterChipDefaults.ContentPadding;
                function4 = function3;
                shape3 = value;
                selectableChipColors3 = defaultFilterChipColors$material3;
                selectableChipElevation2 = selectableChipElevation9;
                arrangement$Horizontal2 = DefaultHorizontalArrangement;
                z5 = true;
            }
            gapComposer.endDefaults();
            TextStyle value5 = CardKt.getValue(9, gapComposer);
            PaddingValuesImpl paddingValuesImpl115 = FilterChipDefaults.ContentPadding;
            int i26 = i13 << 3;
            int i27 = i13 << 6;
            m277SelectableChip9rhh44(z, modifier4, function0, z5, composableLambdaImpl, value5, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, gapComposer, (i27 & 1879048192) | (i13 & 14) | 12582912 | ((i13 >> 6) & 112) | (i26 & 896) | ((i13 >> 3) & 7168) | (i27 & 57344) | (i26 & 3670016) | (i27 & 234881024), ((i13 >> 24) & 14) | 3072 | ((i12 << 6) & 896) | 1769472);
            modifier3 = modifier4;
            z4 = z5;
        } else {
            gapComposer.skipToGroupEnd();
            z4 = z2;
            arrangement$Horizontal2 = arrangement$Horizontal;
            paddingValues2 = paddingValues;
            function4 = function3;
            borderStroke2 = borderStrokeM287filterChipBorder_7El2pE;
            modifier3 = modifier2;
            shape3 = shape2;
            selectableChipColors3 = selectableChipColors2;
            selectableChipElevation2 = selectableChipElevation;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    ChipKt.FilterChip(z, function0, composableLambdaImpl, modifier3, z4, function4, shape3, selectableChipColors3, selectableChipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:168:0x024c  */
    /* JADX INFO: renamed from: SelectableChip-9rhh4-4, reason: not valid java name */
    public static final void m277SelectableChip9rhh44(final boolean z, final Modifier modifier, final Function0 function0, final boolean z2, final ComposableLambdaImpl composableLambdaImpl, final TextStyle textStyle, final Function2 function2, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final Arrangement$Horizontal arrangement$Horizontal, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        GapComposer gapComposer;
        long j;
        float f;
        float f2;
        boolean z3;
        AnimationState animationState;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(400616238);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changedInstance(composableLambdaImpl) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer2.changed(textStyle) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer2.changedInstance(null) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer2.changedInstance(null) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer2.changed(shape) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer2.changed(selectableChipColors) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer2.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer2.changed(borderStroke) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer2.changed(32.0f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer2.changed(arrangement$Horizontal) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer2.changed(paddingValues) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer2.changed((Object) null) ? 1048576 : 524288;
        }
        boolean z4 = true;
        if (gapComposer2.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (i4 & 599187) == 599186) ? false : true)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0 && !gapComposer2.getDefaultsInvalid()) {
                gapComposer2.skipToGroupEnd();
            }
            gapComposer2.endDefaults();
            gapComposer2.startReplaceGroup(-955061811);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer2.end(false);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ChipKt$$ExternalSyntheticLambda3((byte) 21);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue2);
            if (z2) {
                j = !z ? selectableChipColors.containerColor : selectableChipColors.selectedContainerColor;
            } else {
                j = z ? selectableChipColors.disabledSelectedContainerColor : selectableChipColors.disabledContainerColor;
            }
            long j2 = j;
            float f3 = CropImageView.DEFAULT_ASPECT_RATIO;
            if (selectableChipElevation == null) {
                gapComposer2.startReplaceGroup(-954746232);
                gapComposer2.end(false);
                mutableInteractionSourceImpl = mutableInteractionSourceImpl;
                animationState = null;
            } else {
                gapComposer2.startReplaceGroup(-1554818919);
                int i5 = ((i3 >> 9) & 14) | ((i4 << 3) & 896);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue3;
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(null);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState = (MutableState) objRememberedValue4;
                boolean zChanged = gapComposer2.changed(mutableInteractionSourceImpl);
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new CardElevation$animateElevation$1$1(mutableInteractionSourceImpl, snapshotStateList, null, (byte) 3);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                Stack.LaunchedEffect(gapComposer2, mutableInteractionSourceImpl, (Function2) objRememberedValue5);
                Interaction interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                if (z2 && !(interaction instanceof PressInteraction.Press)) {
                    if (interaction instanceof HoverInteraction$Enter) {
                        f = 1.0f;
                    } else if (!(interaction instanceof FocusInteraction.Focus) && (interaction instanceof DragInteraction$Start)) {
                        f = 8.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    f2 = f;
                } else {
                    f2 = 0.0f;
                }
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new Animatable(new Dp(f2), ArcSplineKt.DpToVector, (Object) null, 12);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                Animatable animatable = (Animatable) objRememberedValue6;
                Dp dp = new Dp(f2);
                boolean zChangedInstance = gapComposer2.changedInstance(animatable) | gapComposer2.changed(f2);
                if ((((i5 & 14) ^ 6) <= 4 || !gapComposer2.changed(z2)) && (i5 & 6) != 4) {
                    z4 = false;
                }
                boolean zChangedInstance2 = zChangedInstance | z4 | gapComposer2.changedInstance(interaction);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy) {
                    z3 = false;
                    ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$1 = new ChipElevation$animateElevation$2$1(animatable, f2, z2, interaction, mutableState, null, (byte) 1);
                    gapComposer2.updateRememberedValue(chipElevation$animateElevation$2$1);
                    objRememberedValue7 = chipElevation$animateElevation$2$1;
                } else {
                    z3 = false;
                }
                Stack.LaunchedEffect(gapComposer2, dp, (Function2) objRememberedValue7);
                animationState = animatable.internalState;
                gapComposer2.end(z3);
            }
            if (animationState != null) {
                f3 = ((Dp) animationState.value$delegate.getValue()).value;
            }
            gapComposer = gapComposer2;
            SurfaceKt.m338Surfaced85dljk(z, function0, modifierSemantics, z2, shape, j2, 0L, f3, borderStroke, mutableInteractionSourceImpl, Expect_jvmKt.rememberComposableLambda(-1320468520, new ChipKt$$ExternalSyntheticLambda7(selectableChipColors, z2, z, composableLambdaImpl, textStyle, function2, arrangement$Horizontal, paddingValues), gapComposer2), gapComposer, (i3 & 14) | ((i3 >> 3) & 112) | (i3 & 7168) | ((i3 >> 15) & 57344) | (1879048192 & (i4 << 21)), 192);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    ChipKt.m277SelectableChip9rhh44(z, modifier, function0, z2, composableLambdaImpl, textStyle, function2, shape, selectableChipColors, selectableChipElevation, borderStroke, arrangement$Horizontal, paddingValues, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SuggestionChip(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, boolean z, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, Arrangement$Horizontal arrangement$Horizontal, PaddingValues paddingValues, Composer composer, int i) {
        Modifier modifier2;
        boolean z2;
        Shape shape2;
        ChipColors chipColors2;
        ChipElevation chipElevation2;
        BorderStroke borderStroke2;
        Arrangement$Horizontal arrangement$Horizontal2;
        PaddingValues paddingValues2;
        PaddingValues paddingValues3;
        ChipElevation chipElevation3;
        BorderStroke borderStroke3;
        Arrangement$Horizontal arrangement$Horizontal3;
        int i2;
        ChipColors chipColors3;
        Modifier modifier3;
        Shape shape3;
        boolean z3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1651051734);
        int i3 = i | (gapComposer.changedInstance(function0) ? 4 : 2) | 306802048;
        if (gapComposer.shouldExecute(i3 & 1, (306783379 & i3) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                PaddingValuesImpl paddingValuesImpl = SuggestionChipDefaults.ContentPadding;
                Shape value = ShapesKt.getValue(14, gapComposer);
                ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                ChipColors chipColors4 = colorScheme.defaultSuggestionChipColorsCached;
                if (chipColors4 == null) {
                    long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
                    long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
                    Rgb rgb = ColorSpaces.Unspecified;
                    long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                    long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    long jColor2 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
                    long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                    ChipColors chipColors5 = new ChipColors(0L, jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor, 0L, jColor2, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4)), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb));
                    colorScheme.defaultSuggestionChipColorsCached = chipColors5;
                    chipColors4 = chipColors5;
                }
                ChipElevation chipElevation4 = new ChipElevation();
                long value2 = ColorSchemeKt.getValue(24, gapComposer);
                long value3 = ColorSchemeKt.getValue(17, gapComposer);
                ColorKt.Color(Color.m485getRedimpl(value3), Color.m484getGreenimpl(value3), Color.m482getBlueimpl(value3), 0.12f, Color.m483getColorSpaceimpl(value3));
                BorderStroke borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(value2, 1.0f);
                PaddingValuesImpl paddingValuesImpl2 = SuggestionChipDefaults.ContentPadding;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                paddingValues3 = paddingValuesImpl2;
                chipElevation3 = chipElevation4;
                borderStroke3 = borderStrokeM38BorderStrokecXLIe8U;
                arrangement$Horizontal3 = DefaultHorizontalArrangement;
                i2 = i3 & (-2147418113);
                chipColors3 = chipColors4;
                modifier3 = companion;
                shape3 = value;
                z3 = true;
            } else {
                gapComposer.skipToGroupEnd();
                z3 = z;
                shape3 = shape;
                chipColors3 = chipColors;
                chipElevation3 = chipElevation;
                borderStroke3 = borderStroke;
                arrangement$Horizontal3 = arrangement$Horizontal;
                paddingValues3 = paddingValues;
                i2 = i3 & (-2147418113);
                modifier3 = modifier;
            }
            gapComposer.endDefaults();
            TextStyle value4 = CardKt.getValue(9, gapComposer);
            long j = z3 ? chipColors3.labelColor : chipColors3.disabledLabelColor;
            PaddingValuesImpl paddingValuesImpl3 = SuggestionChipDefaults.ContentPadding;
            m275ChipEosBjUw(modifier3, function0, z3, composableLambdaImpl, value4, j, null, shape3, chipColors3, chipElevation3, borderStroke3, arrangement$Horizontal3, paddingValues3, gapComposer, ((i2 << 3) & 112) | 14159238, 221568);
            modifier2 = modifier3;
            z2 = z3;
            shape2 = shape3;
            chipColors2 = chipColors3;
            chipElevation2 = chipElevation3;
            borderStroke2 = borderStroke3;
            arrangement$Horizontal2 = arrangement$Horizontal3;
            paddingValues2 = paddingValues3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z2 = z;
            shape2 = shape;
            chipColors2 = chipColors;
            chipElevation2 = chipElevation;
            borderStroke2 = borderStroke;
            arrangement$Horizontal2 = arrangement$Horizontal;
            paddingValues2 = paddingValues;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda1(function0, composableLambdaImpl, modifier2, z2, shape2, chipColors2, chipElevation2, borderStroke2, arrangement$Horizontal2, paddingValues2, i);
        }
    }

    /* JADX INFO: renamed from: leadingContent-XO-JAsU, reason: not valid java name */
    public static final Function2 m278leadingContentXOJAsU(Function2 function2, long j, Composer composer) {
        if (function2 == null) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startReplaceGroup(1575598419);
            gapComposer.end(false);
            return null;
        }
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startReplaceGroup(1575370973);
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-237350650, new ChipKt$$ExternalSyntheticLambda13(j, function2, (byte) 1), gapComposer2);
        gapComposer2.end(false);
        return composableLambdaImplRememberComposableLambda;
    }

    /* JADX INFO: renamed from: trailingContent-RPmYEkk, reason: not valid java name */
    public static final ComposableLambdaImpl m279trailingContentRPmYEkk(Function2 function2, long j, Composer composer) {
        if (function2 == null) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startReplaceGroup(-1218883371);
            gapComposer.end(false);
            return null;
        }
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startReplaceGroup(-1219075416);
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-566924201, new ChipKt$$ExternalSyntheticLambda13(j, function2, (byte) 0), gapComposer2);
        gapComposer2.end(false);
        return composableLambdaImplRememberComposableLambda;
    }
}
