package com.metrolist.music.ui.screens.settings;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.theme.UiStyle;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AiSettingsKt$$ExternalSyntheticLambda10 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AiSettingsKt$$ExternalSyntheticLambda10(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x011e  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                String str = (String) obj;
                ((Integer) obj3).intValue();
                str.getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(-174093028);
                gapComposer.end(false);
                return str;
            case 1:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.person, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer2, 440, 8);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m151size3ABfNKs(companion, 8.0f));
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.view_channel, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear_recognition_history_confirm, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer7, 0, 0, 131070);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (gapComposer8.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer8), null, ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262138);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer9), (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer9, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer9, R.string.play_on_app, gapComposer9), null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 1572864, 0, 262078);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (gapComposer10.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.mic, 0, gapComposer10);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, gapComposer10, 440, 0);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer10, R.string.re_listen, gapComposer10), null, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262138);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    Painter painterPainterResource2 = IntMath.painterResource(R.drawable.close, 0, gapComposer11);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, gapComposer11, 440, 0);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer11, R.string.close, gapComposer11), null, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262138);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (gapComposer12.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.refresh, 0, gapComposer12), (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer12, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer12, R.string.try_again, gapComposer12), null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 1572864, 0, 262078);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (gapComposer13.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    DialogKt.EmptyPlaceholder(R.drawable.search, 0, 4, gapComposer13, null, MathKt.stringResource(R.string.no_results_found, gapComposer13));
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (gapComposer14.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, LocalSearchScreenKt.lambda$431133666, gapComposer14, 24576, 15);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (gapComposer15.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    OffsetKt.Spacer(gapComposer15, SizeKt.m145height3ABfNKs(companion, 152.0f));
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer15;
                if (gapComposer16.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    DialogKt.EmptyPlaceholder(R.drawable.search, 0, 4, gapComposer16, null, MathKt.stringResource(R.string.no_results_found, gapComposer16));
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer16;
                if (gapComposer17.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    for (int i9 = 0; i9 < 3; i9++) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer17, 0);
                    }
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer17;
                if (gapComposer18.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, LocalSearchScreenKt.f436lambda$827083889, gapComposer18, 24576, 15);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer18;
                if (gapComposer19.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    DialogKt.EmptyPlaceholder(R.drawable.search, 0, 4, gapComposer19, null, MathKt.stringResource(R.string.no_results_found, gapComposer19));
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer19;
                if (gapComposer20.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    for (int i10 = 0; i10 < 8; i10++) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer20, 0);
                    }
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer20;
                if (gapComposer21.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion2, 1.0f), 20.0f, 8.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer21, 0);
                    int iHashCode = Long.hashCode(gapComposer21.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer21.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer21, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer21.startReusableNode();
                    if (gapComposer21.inserting) {
                        gapComposer21.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer21.useNode();
                    }
                    Stack.m390setimpl(gapComposer21, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer21, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer21, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer21);
                    Stack.m390setimpl(gapComposer21, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.parsed_from_link, gapComposer21), OffsetKt.m139paddingqDBjuR0$default(companion2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 7), ((MaterialTheme$Values) gapComposer21.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer21, 48, 0);
                    gapComposer21.end(true);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer21;
                if (gapComposer22.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    DialogKt.m1467EditorialDivideriJQMabo(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1), 0L, gapComposer22, 6, 2);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer22;
                if (gapComposer23.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    DialogKt.m1467EditorialDivideriJQMabo(null, 0L, gapComposer23, 0, 3);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer23;
                if (gapComposer24.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    OffsetKt.Spacer(gapComposer24, SizeKt.m145height3ABfNKs(companion, 8.0f));
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 24:
                String strM = (String) obj;
                ((Integer) obj3).getClass();
                strM.getClass();
                GapComposer gapComposer25 = (GapComposer) ((Composer) obj2);
                gapComposer25.startReplaceGroup(-1127294661);
                if (!strM.equals("Literal")) {
                    if (strM.equals("Transcribed")) {
                        i = -998405842;
                        i2 = R.string.ai_translation_transcribed;
                    } else {
                        gapComposer25.startReplaceGroup(-998403331);
                        gapComposer25.end(false);
                    }
                    gapComposer25.end(false);
                    return strM;
                }
                i = -998408566;
                i2 = R.string.ai_translation_literal;
                strM = Format$$ExternalSyntheticOutline0.m(gapComposer25, i, i2, gapComposer25, false);
                gapComposer25.end(false);
                return strM;
            case 25:
                String str2 = (String) obj;
                ((Integer) obj3).intValue();
                str2.getClass();
                GapComposer gapComposer26 = (GapComposer) ((Composer) obj2);
                gapComposer26.startReplaceGroup(-2080496294);
                String str3 = (String) PreferenceKeysKt.LanguageCodeToName.get(str2);
                if (str3 != null) {
                    str2 = str3;
                }
                gapComposer26.end(false);
                return str2;
            case 26:
                String strM2 = (String) obj;
                ((Integer) obj3).getClass();
                strM2.getClass();
                GapComposer gapComposer27 = (GapComposer) ((Composer) obj2);
                gapComposer27.startReplaceGroup(-645133897);
                int iHashCode2 = strM2.hashCode();
                if (iHashCode2 != 3318169) {
                    if (iHashCode2 != 3357525) {
                        if (iHashCode2 == 1544803905 && strM2.equals("default")) {
                            i3 = -1498382326;
                            i4 = R.string.ai_deepl_formality_default;
                            strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer27, i3, i4, gapComposer27, false);
                        } else {
                            gapComposer27.startReplaceGroup(-1498374759);
                            gapComposer27.end(false);
                        }
                    } else if (strM2.equals("more")) {
                        i3 = -1498379705;
                        i4 = R.string.ai_deepl_formality_more;
                        strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer27, i3, i4, gapComposer27, false);
                    } else {
                        gapComposer27.startReplaceGroup(-1498374759);
                        gapComposer27.end(false);
                    }
                } else if (strM2.equals("less")) {
                    i3 = -1498377177;
                    i4 = R.string.ai_deepl_formality_less;
                    strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer27, i3, i4, gapComposer27, false);
                } else {
                    gapComposer27.startReplaceGroup(-1498374759);
                    gapComposer27.end(false);
                }
                gapComposer27.end(false);
                return strM2;
            case 27:
                String str4 = (String) obj;
                ((Integer) obj3).intValue();
                str4.getClass();
                GapComposer gapComposer28 = (GapComposer) ((Composer) obj2);
                gapComposer28.startReplaceGroup(1743430133);
                if (str4.equals("custom_input")) {
                    str4 = "Custom";
                }
                gapComposer28.end(false);
                return str4;
            case 28:
                UiStyle uiStyle = (UiStyle) obj;
                ((Integer) obj3).getClass();
                uiStyle.getClass();
                GapComposer gapComposer29 = (GapComposer) ((Composer) obj2);
                gapComposer29.startReplaceGroup(31379938);
                int iOrdinal = uiStyle.ordinal();
                if (iOrdinal == 0) {
                    i5 = 91351661;
                    i6 = R.string.ui_style_editorial;
                } else {
                    if (iOrdinal != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer29, 91350113, false);
                    }
                    i5 = 91354249;
                    i6 = R.string.ui_style_glass;
                }
                String strM3 = Format$$ExternalSyntheticOutline0.m(gapComposer29, i5, i6, gapComposer29, false);
                gapComposer29.end(false);
                return strM3;
            default:
                UiStyle uiStyle2 = (UiStyle) obj;
                ((Integer) obj3).getClass();
                uiStyle2.getClass();
                GapComposer gapComposer30 = (GapComposer) ((Composer) obj2);
                gapComposer30.startReplaceGroup(1081249153);
                int iOrdinal2 = uiStyle2.ordinal();
                if (iOrdinal2 == 0) {
                    i7 = -301647279;
                    i8 = R.string.ui_style_editorial_desc;
                } else {
                    if (iOrdinal2 != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer30, -301648822, false);
                    }
                    i7 = -301644531;
                    i8 = R.string.ui_style_glass_desc;
                }
                String strM4 = Format$$ExternalSyntheticOutline0.m(gapComposer30, i7, i8, gapComposer30, false);
                gapComposer30.end(false);
                return strM4;
        }
    }
}
