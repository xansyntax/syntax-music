package com.metrolist.music.ui.component;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
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
import androidx.compose.ui.unit.Constraints;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExperimentalLyricsKt$$ExternalSyntheticLambda25 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ExperimentalLyricsKt$$ExternalSyntheticLambda25(byte b) {
        this.$r8$classId = b;
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
                MeasureScope measureScope = (MeasureScope) obj;
                Measurable measurable = (Measurable) obj2;
                measureScope.getClass();
                measurable.getClass();
                Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, Integer.MAX_VALUE, 7, ((Constraints) obj3).value));
                return measureScope.layout(placeableMo598measureBRTryo0.width, 0, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 25));
            case 1:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 16.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 24, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onPrimaryContainer, 0L, gapComposer3, modifierM151size3ABfNKs);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ai_translating_lyrics, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.labelMedium, gapComposer3, 0, 0, 131070);
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
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.check, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer4, 440, 8);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ai_lyrics_translated, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer4, 0, 0, 131070);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer5), MathKt.stringResource(R.string.auto_scroll, gapComposer5), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer5, 392, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer5, R.string.auto_scroll, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
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
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer6), MathKt.stringResource(R.string.cancel, gapComposer6), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer6, 392, 8);
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
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer7), MathKt.stringResource(R.string.share_selected, gapComposer7), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer7, 392, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer7, R.string.share, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.share, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.play_all, gapComposer9), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer9.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer9, 0, 0, 131070);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(companion, 16.0f, 8.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer10, 54);
                    int iHashCode = Long.hashCode(gapComposer10.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer10.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer10, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer10.startReusableNode();
                    if (gapComposer10.inserting) {
                        gapComposer10.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer10.useNode();
                    }
                    Stack.m390setimpl(gapComposer10, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer10, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer10, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer10);
                    Stack.m390setimpl(gapComposer10, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion, 16.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 24, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimaryContainer, 0L, gapComposer10, modifierM151size3ABfNKs2);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ai_translating_lyrics, gapComposer10), null, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimaryContainer, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).typography.labelMedium, gapComposer10, 0, 0, 131066);
                    gapComposer10.end(true);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(companion, 16.0f, 8.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer11, 54);
                    int iHashCode2 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierM136paddingVpY3zN5);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.check, 0, gapComposer11);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.onTertiaryContainer, gapComposer11, 440, 0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ai_lyrics_translated, gapComposer11), null, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.onTertiaryContainer, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).typography.labelMedium, gapComposer11, 0, 0, 131066);
                    gapComposer11.end(true);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer12), MathKt.stringResource(R.string.auto_scroll, gapComposer12), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer12, 392, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer12, R.string.auto_scroll, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer13), MathKt.stringResource(R.string.cancel, gapComposer13), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer13, 392, 8);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer14), MathKt.stringResource(R.string.share_selected, gapComposer14), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer14, 392, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer14, R.string.share, gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode3 = Long.hashCode(gapComposer15.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer15.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer15, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer15.startReusableNode();
                    if (gapComposer15.inserting) {
                        gapComposer15.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer15.useNode();
                    }
                    Stack.m390setimpl(gapComposer15, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer15, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer15, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer15);
                    Stack.m390setimpl(gapComposer15, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(Fragment$5$$ExternalSyntheticOutline0.m(MathKt.stringResource(R.string.generating_image, gapComposer15), "\n", MathKt.stringResource(R.string.please_wait, gapComposer15)), null, ((MaterialTheme$Values) gapComposer15.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262138);
                    gapComposer15.end(true);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.share, gapComposer16), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sleep_timer, gapComposer17), OffsetKt.m136paddingVpY3zN4(companion, 16.0f, 12.0f), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer17.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, gapComposer17, 48, 0, 131068);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer18), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer21), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.time_transfer_convert, gapComposer23), null, ((MaterialTheme$Values) gapComposer23.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onPrimary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262138);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.add, 0, gapComposer24), (String) null, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 20.0f), 0L, gapComposer24, 440, 8);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.create_playlist, gapComposer24), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer24.consume(MaterialThemeKt._localMaterialTheme)).typography.titleSmall, gapComposer24, 1572864, 0, 131006);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer25 = (Composer) obj2;
                int iIntValue25 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.skip_duplicates, gapComposer25), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer25, 0, 0, 262142);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer26 = (Composer) obj2;
                int iIntValue26 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.add_anyway, gapComposer26), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer27 = (Composer) obj2;
                int iIntValue27 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer28 = (Composer) obj2;
                int iIntValue28 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.add, 0, gapComposer28), (String) null, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 20.0f), 0L, gapComposer28, 440, 8);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.create_playlist, gapComposer28), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer28.consume(MaterialThemeKt._localMaterialTheme)).typography.titleSmall, gapComposer28, 1572864, 0, 131006);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer29 = (Composer) obj2;
                int iIntValue29 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.playlist_add_local_to_synced_note, gapComposer29), OffsetKt.m137paddingVpY3zN4$default(companion, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, IntMath.pack(4294967296L, 12.0f), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 48, 0, 262124);
                } else {
                    gapComposer29.skipToGroupEnd();
                }
                return unit;
        }
    }
}
