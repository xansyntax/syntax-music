package com.metrolist.music.ui.component;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda9 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ComposableLambdaImpl f$0;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda9(ComposableLambdaImpl composableLambdaImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        ComposableLambdaImpl composableLambdaImpl = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
                }
                break;
            case 1:
                ((Integer) obj3).getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new ChipKt$$ExternalSyntheticLambda3((byte) 22);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer2, 0);
                int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierClearAndSetSemantics);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                Stack.m389reconcileimpl(gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
                composableLambdaImpl.invoke((Object) gapComposer2, (Object) 0);
                gapComposer2.end(true);
                break;
            case 2:
                ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                columnScopeInstance.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(columnScopeInstance) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke(columnScopeInstance, gapComposer3, Integer.valueOf(iIntValue2 & 14));
                }
                break;
            case 3:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (!gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer4, (Object) 6);
                }
                break;
            case 4:
                BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl.getClass();
                if ((iIntValue4 & 6) == 0) {
                    iIntValue4 |= ((GapComposer) composer4).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (!gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke(boxWithConstraintsScopeImpl, gapComposer5, Integer.valueOf(iIntValue4 & 14));
                }
                break;
            case 5:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (!gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(companion, 16.0f, 8.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer6, 54);
                    int iHashCode2 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    composableLambdaImpl.invoke((Object) RowScopeInstance.INSTANCE, (Object) gapComposer6, (Object) 6);
                    gapComposer6.end(true);
                }
                break;
            case 6:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (!gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer7, (Object) 6);
                }
                break;
            case 7:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (!gapComposer8.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer8, (Object) 6);
                }
                break;
            case 8:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (!gapComposer9.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer9, (Object) 6);
                }
                break;
            case 9:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (!gapComposer10.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer10, (Object) 6);
                }
                break;
            case 10:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (!gapComposer11.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer11, (Object) 6);
                }
                break;
            case 11:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (!gapComposer12.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer12, (Object) 6);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (!gapComposer13.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer13, (Object) 6);
                }
                break;
            case 13:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (!gapComposer14.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer14, (Object) 6);
                }
                break;
            case 14:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (!gapComposer15.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer15, (Object) 0);
                }
                break;
            case 15:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer15;
                if (!gapComposer16.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer16, (Object) 6);
                }
                break;
            case 16:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer16;
                if (!gapComposer17.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer17, (Object) 0);
                }
                break;
            case 17:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer17;
                if (!gapComposer18.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer18, (Object) 6);
                }
                break;
            case 18:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer18;
                if (!gapComposer19.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer19, (Object) 6);
                }
                break;
            case 19:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer19;
                if (!gapComposer20.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer20, (Object) 0);
                }
                break;
            case 20:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer20;
                if (!gapComposer21.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer21, (Object) 6);
                }
                break;
            case 21:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer21;
                if (!gapComposer22.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer22, (Object) 0);
                }
                break;
            case 22:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer22;
                if (!gapComposer23.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer23, (Object) 6);
                }
                break;
            case 23:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer23;
                if (!gapComposer24.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer24, (Object) 6);
                }
                break;
            default:
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer24;
                if (!gapComposer25.shouldExecute(iIntValue24 & 1, (iIntValue24 & 17) != 16)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke((Object) gapComposer25, (Object) 6);
                }
                break;
        }
        return unit;
    }
}
