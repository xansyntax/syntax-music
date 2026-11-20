package com.metrolist.music.ui.component;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogKt$$ExternalSyntheticLambda4 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda4(Function0 function0, Function0 function1, Function0 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = function1;
        this.f$2 = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier modifierM1481glassTintedFNF3uiM = Modifier.Companion.$$INSTANCE;
        Function0 function0 = this.f$2;
        Function0 function1 = this.f$1;
        Function0 function2 = this.f$0;
        switch (b) {
            case 0:
                RowScope rowScope = (RowScope) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (function2 != null) {
                        gapComposer.startReplaceGroup(-1964887148);
                        Modifier modifierWeight = rowScope.weight(modifierM1481glassTintedFNF3uiM, 1.0f, true);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
                        int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierWeight);
                        ComposeUiNode.Companion.getClass();
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                        Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                        Stack.m389reconcileimpl(gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                        Modifier modifierPressScale = DialogKt.pressScale(modifierM1481glassTintedFNF3uiM, 0.94f);
                        boolean zChanged = gapComposer.changed(function2);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Handshake$$ExternalSyntheticLambda0(function2, (byte) 8);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        CardKt.TextButton((Function0) objRememberedValue, modifierPressScale, false, null, null, null, DialogKt.lambda$714271667, gapComposer, 805306368, 508);
                        gapComposer.end(true);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1964549837);
                        gapComposer.end(false);
                    }
                    if (function1 != null) {
                        gapComposer.startReplaceGroup(-1964489046);
                        Modifier modifierPressScale2 = DialogKt.pressScale(modifierM1481glassTintedFNF3uiM, 0.94f);
                        boolean zChanged2 = gapComposer.changed(function1);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new Handshake$$ExternalSyntheticLambda0(function1, (byte) 9);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        CardKt.TextButton((Function0) objRememberedValue2, modifierPressScale2, false, null, null, null, DialogKt.lambda$1843256704, gapComposer, 805306368, 508);
                        z = false;
                        gapComposer.end(false);
                    } else {
                        z = false;
                        gapComposer.startReplaceGroup(-1964251245);
                        gapComposer.end(false);
                    }
                    Modifier modifierPressScale3 = DialogKt.pressScale(modifierM1481glassTintedFNF3uiM, 0.94f);
                    if (UiStyleKt.isGlassStyle(gapComposer)) {
                        gapComposer.startReplaceGroup(-1725927449);
                        modifierM1481glassTintedFNF3uiM = GlassComponentsKt.m1481glassTintedFNF3uiM(modifierM1481glassTintedFNF3uiM, RoundedCornerShapeKt.CircleShape, gapComposer);
                    } else {
                        gapComposer.startReplaceGroup(-1725926505);
                    }
                    gapComposer.end(z);
                    Modifier modifierThen = modifierPressScale3.then(modifierM1481glassTintedFNF3uiM);
                    ButtonColors buttonColorsDialogConfirmColors = DialogKt.dialogConfirmColors(gapComposer);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = UiStyleKt.isGlassStyle(gapComposer) ? RoundedCornerShapeKt.CircleShape : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    boolean zChanged3 = gapComposer.changed(function0);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new Handshake$$ExternalSyntheticLambda0(function0, (byte) 10);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.Button((Function0) objRememberedValue3, modifierThen, false, roundedCornerShapeM185RoundedCornerShape0680j_4, buttonColorsDialogConfirmColors, null, null, null, null, DialogKt.f35lambda$967816641, gapComposer, 805306368, 484);
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
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer2, 6);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM1481glassTintedFNF3uiM);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(modifierM1481glassTintedFNF3uiM, 1.0f), false, null, function2, 15);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    SurfaceKt.m337SurfaceT9BRK9s(modifierM46clickableoSLSa3U$default, roundedCornerShapeM185RoundedCornerShape0680j_5, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.errorContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AlbumScreenKt.lambda$1242490498, gapComposer2, 12582912, 120);
                    SurfaceKt.m337SurfaceT9BRK9s(ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(modifierM1481glassTintedFNF3uiM, 1.0f), false, null, function1, 15), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surfaceVariant, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AlbumScreenKt.lambda$1556193849, gapComposer2, 12582912, 120);
                    SurfaceKt.m337SurfaceT9BRK9s(ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(modifierM1481glassTintedFNF3uiM, 1.0f), false, null, function0, 15), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primaryContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, AlbumScreenKt.lambda$1442583354, gapComposer2, 12582912, 120);
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }
}
