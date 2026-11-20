package com.metrolist.music;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.DialogKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda44 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda44(AvailableUpdate availableUpdate) {
        this.$r8$classId = (byte) 0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        final byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                int i = MainActivity.$r8$clinit;
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.update_action, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(contextMenuColors) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, ContextMenuSpec.DividerVerticalPadding, 1), 1.0f), ContextMenuSpec.DividerHeight), contextMenuColors.iconColor, ColorKt.RectangleShape), gapComposer2, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Placeable placeableMo598measureBRTryo0 = ((Measurable) obj2).mo598measureBRTryo0(((Constraints) obj3).value);
                return ((MeasureScope) obj).layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new ChipKt$$ExternalSyntheticLambda3((byte) 18), new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 0));
            case 3:
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(snackbarDataImpl) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    ScrimKt.m322SnackbarsDKtq54(snackbarDataImpl, null, null, 0L, 0L, 0L, 0L, 0L, gapComposer3, iIntValue3 & 14);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                ((Integer) obj3).getClass();
                CardKt.lambda$1863131183.invoke(obj2, (Object) 0);
                return unit;
            case 5:
                MeasureScope measureScope = (MeasureScope) obj;
                final int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(10.0f);
                int i2 = iMo75roundToPx0680j_4 * 2;
                final Placeable placeableMo598measureBRTryo1 = ((Measurable) obj2).mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(i2, 0, ((Constraints) obj3).value));
                int i3 = placeableMo598measureBRTryo1.height;
                int i4 = placeableMo598measureBRTryo1.width - i2;
                final byte b3 = false ? (byte) 1 : (byte) 0;
                return measureScope.layout(i4, i3, emptyMap, new Function1() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        byte b4 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        int i5 = iMo75roundToPx0680j_4;
                        Placeable placeable = placeableMo598measureBRTryo1;
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj4;
                        switch (b4) {
                            case 0:
                                placementScope.place(placeable, -i5, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                            default:
                                placementScope.place(placeable, 0, -i5, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                        }
                        return unit2;
                    }
                });
            case 6:
                MeasureScope measureScope2 = (MeasureScope) obj;
                final int iMo75roundToPx0680j_5 = measureScope2.mo75roundToPx0680j_4(10.0f);
                int i5 = iMo75roundToPx0680j_5 * 2;
                final Placeable placeableMo598measureBRTryo2 = ((Measurable) obj2).mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(0, i5, ((Constraints) obj3).value));
                return measureScope2.layout(placeableMo598measureBRTryo2.width, placeableMo598measureBRTryo2.height - i5, emptyMap, new Function1() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        byte b4 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        int i6 = iMo75roundToPx0680j_5;
                        Placeable placeable = placeableMo598measureBRTryo2;
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj4;
                        switch (b4) {
                            case 0:
                                placementScope.place(placeable, -i6, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                            default:
                                placementScope.place(placeable, 0, -i6, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                        }
                        return unit2;
                    }
                });
            case 7:
                ((Integer) obj3).intValue();
                ((Transition.Segment) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) ((Composer) obj2);
                gapComposer4.startReplaceGroup(-1885765762);
                SpringSpec defaultColorSpring = com.materialkolor.ktx.ColorKt.getDefaultColorSpring();
                gapComposer4.end(false);
                return defaultColorSpring;
            case 8:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.settings, 0, gapComposer5), MathKt.stringResource(R.string.settings, gapComposer5), SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer5, 392, 8);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.kmp_upgrade_later, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (!gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (!gapComposer8.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (!gapComposer9.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (gapComposer10.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(DialogKt.dialogLabel(MathKt.stringResource(R.string.reset, gapComposer10), gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(DialogKt.dialogLabel(MathKt.stringResource(android.R.string.cancel, gapComposer11), gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (gapComposer12.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(DialogKt.dialogLabel(MathKt.stringResource(android.R.string.ok, gapComposer12), gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (gapComposer13.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(DialogKt.dialogLabel(MathKt.stringResource(android.R.string.cancel, gapComposer13), gapComposer13), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer13, 0, 0, 262142);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (gapComposer14.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(DialogKt.dialogLabel(MathKt.stringResource(android.R.string.ok, gapComposer14), gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (gapComposer15.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer15.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer15.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer15, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer15.startReusableNode();
                    if (gapComposer15.inserting) {
                        gapComposer15.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer15.useNode();
                    }
                    Stack.m390setimpl(gapComposer15, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer15, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer15, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer15);
                    Stack.m390setimpl(gapComposer15, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    TextKt.m352TextNvy7gAk(Fragment$5$$ExternalSyntheticOutline0.m(MathKt.stringResource(R.string.generating_image, gapComposer15), "\n", MathKt.stringResource(R.string.please_wait, gapComposer15)), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                    gapComposer15.end(true);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer15;
                if (!gapComposer16.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer16;
                if (!gapComposer17.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer17;
                if (!gapComposer18.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer18;
                if (!gapComposer19.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer19;
                if (!gapComposer20.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer20;
                if (!gapComposer21.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer21;
                if (!gapComposer22.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer22;
                if (!gapComposer23.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer23;
                if (!gapComposer24.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer24;
                if (!gapComposer25.shouldExecute(iIntValue24 & 1, (iIntValue24 & 17) != 16)) {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer25 = (Composer) obj2;
                int iIntValue25 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer25;
                if (!gapComposer26.shouldExecute(iIntValue25 & 1, (iIntValue25 & 17) != 16)) {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda44(byte b) {
        this.$r8$classId = b;
    }
}
