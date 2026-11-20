package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.yalantis.ucrop.R;
import java.io.IOException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda49 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda49(Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
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
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.group, 0, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 48.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer, 440, 0);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 16.0f, gapComposer, R.string.listen_together, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineSmall, gapComposer, 1572864, 0, 131002);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 8.0f, gapComposer, R.string.listen_together_not_configured, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 0, 130042);
                    OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 24.0f));
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    CardKt.Button(this.f$0, null, false, null, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, 0L, gapComposer, 14), null, null, null, null, AlbumMenuKt.lambda$122311348, gapComposer, 805306368, 494);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                MeasureScope measureScope = (MeasureScope) obj;
                Measurable measurable = (Measurable) obj2;
                Constraints constraints = (Constraints) obj3;
                float f = ((Dp) this.f$0.invoke()).value;
                Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, ConstraintsKt.m791constrainHeightK40F9xA(Dp.m796equalsimpl0(f, Float.NaN) ? 0 : measureScope.mo75roundToPx0680j_4(f), constraints.value), 0, 11, constraints.value));
                return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 19));
            case 2:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    CardKt.FilledTonalButton(this.f$0, null, false, null, null, null, null, DialogKt.lambda$1106178229, gapComposer2, 805306368, 510);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    CardKt.IconButton(this.f$0, null, false, null, null, AlbumScreenKt.lambda$531862457, gapComposer3, 1572864, 62);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    CardKt.TextButton(this.f$0, null, false, null, null, null, AlbumScreenKt.lambda$64519786, gapComposer4, 805306368, 510);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer5, 48);
                    int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, companion);
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer5, updater$$ExternalSyntheticLambda1, gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource2 = IntMath.painterResource(R.drawable.equalizer, 0, gapComposer5);
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 48.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, modifierM151size3ABfNKs, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, gapComposer5, 440, 0);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 16.0f, gapComposer5, R.string.no_profiles, gapComposer5), null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.titleMedium, gapComposer5, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    CardKt.Button(this.f$0, null, false, null, null, null, null, null, null, EqScreenKt.f360lambda$783560626, gapComposer5, 805306368, 510);
                    gapComposer5.end(true);
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    CardKt.IconButton(this.f$0, null, false, null, null, LocalSearchScreenKt.lambda$525872218, gapComposer6, 1572864, 62);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    CardKt.Button(this.f$0, null, false, null, null, null, null, null, null, LastFMSettingsKt.lambda$1968213365, gapComposer7, 805306368, 510);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    CardKt.TextButton(this.f$0, null, false, null, null, null, LastFMSettingsKt.lambda$1223272314, gapComposer8, 805306368, 510);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
        }
    }
}
