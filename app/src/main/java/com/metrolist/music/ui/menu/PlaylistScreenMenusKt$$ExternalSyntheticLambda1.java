package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.parsing.ParserDslKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistScreenMenusKt$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ PlaylistScreenMenusKt$$ExternalSyntheticLambda1(String str, Function1 function1) {
        this.f$1 = str;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Function1 function1 = this.f$0;
        String str = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged = gapComposer.changed(function1);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ParserDslKt$$ExternalSyntheticLambda0(function1, (byte) 9);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue, 15), 8.0f, 8.0f);
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    ScrimKt.RadioButton(Intrinsics.areEqual(str, "csv"), null, null, false, null, gapComposer, 48);
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                    int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.export_as_csv, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    gapComposer.end(true);
                    gapComposer.end(true);
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged2 = gapComposer.changed(function1);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ParserDslKt$$ExternalSyntheticLambda0(function1, (byte) 10);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue2, 15), 8.0f, 8.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
                    int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN5);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                    ScrimKt.RadioButton(Intrinsics.areEqual(str, "m3u"), null, null, false, null, gapComposer, 48);
                    Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(companion, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                    int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default2);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.export_as_m3u, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, true, true, true);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z2 = str == null;
                    boolean zChanged3 = gapComposer2.changed(function1);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ParserDslKt$$ExternalSyntheticLambda0(function1, (byte) 13);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    EqScreenKt.NoEqualizationItem(0, gapComposer2, (Function0) objRememberedValue3, z2);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlaylistScreenMenusKt$$ExternalSyntheticLambda1(Function1 function1, String str) {
        this.f$0 = function1;
        this.f$1 = str;
    }
}
