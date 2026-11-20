package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppearanceSettingsKt$$ExternalSyntheticLambda53 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$0;

    public /* synthetic */ AppearanceSettingsKt$$ExternalSyntheticLambda53(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(R.string.lyrics_text_size, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineSmall, gapComposer, 48, 0, 131068);
                    TextKt.m352TextNvy7gAk(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()) + " sp", OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer, 48, 0, 131068);
                    float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                    ClosedFloatRange closedFloatRange = new ClosedFloatRange(12.0f, 48.0f);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 10);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    SliderKt.Slider(floatValue, (Function1) objRememberedValue, modifierFillMaxWidth, false, closedFloatRange, 0, null, null, gapComposer, 432, 488);
                    gapComposer.end(true);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    BiasAlignment.Horizontal horizontal2 = Alignment.Companion.CenterHorizontally;
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion2, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal2, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String strStringResource2 = MathKt.stringResource(R.string.swipe_sensitivity, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource2, OffsetKt.m139paddingqDBjuR0$default(companion2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.headlineSmall, gapComposer2, 48, 0, 131068);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sensitivity_percentage, new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue() * 100.0f))}, gapComposer2), OffsetKt.m139paddingqDBjuR0$default(companion2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodyLarge, gapComposer2, 48, 0, 131068);
                    float floatValue2 = parcelableSnapshotMutableFloatState.getFloatValue();
                    ClosedFloatRange closedFloatRange2 = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion2, 1.0f);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 9);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    SliderKt.Slider(floatValue2, (Function1) objRememberedValue2, modifierFillMaxWidth2, false, closedFloatRange2, 0, null, null, gapComposer2, 432, 488);
                    gapComposer2.end(true);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    BiasAlignment.Horizontal horizontal3 = Alignment.Companion.CenterHorizontally;
                    Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(companion3, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal3, gapComposer3, 48);
                    int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM135padding3ABfNKs3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    String strStringResource3 = MathKt.stringResource(R.string.lyrics_line_spacing, gapComposer3);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource3, OffsetKt.m139paddingqDBjuR0$default(companion3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).typography.headlineSmall, gapComposer3, 48, 0, 131068);
                    TextKt.m352TextNvy7gAk(String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue())}, 1)), OffsetKt.m139paddingqDBjuR0$default(companion3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).typography.bodyLarge, gapComposer3, 48, 0, 131068);
                    float floatValue3 = parcelableSnapshotMutableFloatState.getFloatValue();
                    ClosedFloatRange closedFloatRange3 = new ClosedFloatRange(1.0f, 3.0f);
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion3, 1.0f);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 8);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    SliderKt.Slider(floatValue3, (Function1) objRememberedValue3, modifierFillMaxWidth3, false, closedFloatRange3, 0, null, null, gapComposer3, 432, 488);
                    gapComposer3.end(true);
                }
                break;
            default:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    BiasAlignment.Horizontal horizontal4 = Alignment.Companion.CenterHorizontally;
                    Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM135padding3ABfNKs4 = OffsetKt.m135padding3ABfNKs(companion4, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal4, gapComposer4, 48);
                    int iHashCode4 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    String strStringResource4 = MathKt.stringResource(R.string.scrobble_delay_percent, gapComposer4);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource4, OffsetKt.m139paddingqDBjuR0$default(companion4, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).typography.headlineSmall, gapComposer4, 48, 0, 131068);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sensitivity_percentage, new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue() * 100.0f))}, gapComposer4), OffsetKt.m139paddingqDBjuR0$default(companion4, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).typography.bodyLarge, gapComposer4, 48, 0, 131068);
                    float floatValue4 = parcelableSnapshotMutableFloatState.getFloatValue();
                    ClosedFloatRange closedFloatRange4 = new ClosedFloatRange(0.3f, 0.95f);
                    Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion4, 1.0f);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 12);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    SliderKt.Slider(floatValue4, (Function1) objRememberedValue4, modifierFillMaxWidth4, false, closedFloatRange4, 0, null, null, gapComposer4, 432, 488);
                    gapComposer4.end(true);
                }
                break;
        }
        return unit;
    }
}
