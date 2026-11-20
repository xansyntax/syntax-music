package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda37;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SettingsSleepTimerDialogKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ MutableState f$6;

    public /* synthetic */ SettingsSleepTimerDialogKt$$ExternalSyntheticLambda17(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
        this.f$3 = mutableState4;
        this.f$4 = mutableState5;
        this.f$5 = mutableState6;
        this.f$6 = mutableState7;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        MutableState mutableState;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    CardKt.OutlinedCard(OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f), null, null, null, null, Expect_jvmKt.rememberComposableLambda(407976570, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda17(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (byte) 1), gapComposer), gapComposer, 196614, 30);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
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
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    MutableState mutableState2 = this.f$0;
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda29(mutableState2, (byte) 24);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue, 15), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default2);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    String strStringResource = MathKt.stringResource(R.string.sleep_timer_weekdays, gapComposer2);
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    TextKt.m352TextNvy7gAk(strStringResource, new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262140);
                    boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                    Modifier modifierScale = ClipKt.scale();
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        mutableState = mutableState2;
                        objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 13);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        mutableState = mutableState2;
                    }
                    MenuKt.Switch(zBooleanValue, (Function1) objRememberedValue2, modifierScale, Expect_jvmKt.rememberComposableLambda(44007192, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 4), gapComposer2), false, null, gapComposer2, 3504, 112);
                    gapComposer2.end(true);
                    boolean zBooleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
                    EnterTransitionImpl enterTransitionImplPlus = EnterExitTransitionKt.expandVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
                    ExitTransitionImpl exitTransitionImplPlus = EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
                    MutableState mutableState3 = this.f$1;
                    MutableState mutableState4 = this.f$2;
                    MutableState mutableState5 = this.f$3;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(248258120, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(mutableState3, mutableState4, mutableState5, (byte) 4), gapComposer2);
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    CrossfadeKt.AnimatedVisibility(columnScopeInstance, zBooleanValue2, null, enterTransitionImplPlus, exitTransitionImplPlus, null, composableLambdaImplRememberComposableLambda, gapComposer2, 1600518, 18);
                    CardKt.m261HorizontalDivider9IZ8Weo(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer2, 6, 6);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    MutableState mutableState6 = this.f$4;
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda29(mutableState6, (byte) 25);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue3, 15), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default3);
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
                    String strStringResource2 = MathKt.stringResource(R.string.sleep_timer_weekends, gapComposer2);
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    TextKt.m352TextNvy7gAk(strStringResource2, new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262140);
                    boolean zBooleanValue3 = ((Boolean) mutableState6.getValue()).booleanValue();
                    Modifier modifierScale2 = ClipKt.scale();
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState6, (byte) 14);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.Switch(zBooleanValue3, (Function1) objRememberedValue4, modifierScale2, Expect_jvmKt.rememberComposableLambda(-877602545, new SongMenuKt$$ExternalSyntheticLambda37(mutableState6, (byte) 5), gapComposer2), false, null, gapComposer2, 3504, 112);
                    gapComposer2.end(true);
                    CrossfadeKt.AnimatedVisibility(columnScopeInstance, ((Boolean) mutableState6.getValue()).booleanValue(), null, EnterExitTransitionKt.expandVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), null, Expect_jvmKt.rememberComposableLambda(2134010943, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(this.f$5, this.f$6, mutableState5, (byte) 5), gapComposer2), gapComposer2, 1600518, 18);
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }
}
