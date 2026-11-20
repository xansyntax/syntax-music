package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda18;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccountScreenKt$$ExternalSyntheticLambda5 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AccountScreenKt$$ExternalSyntheticLambda5(byte b) {
        this.$r8$classId = b;
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
        byte b2 = 1;
        switch (b) {
            case 0:
                ((Integer) obj2).intValue();
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                ((PodcastEntity) obj3).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 1:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.FillWholeMaxSize, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), ColorKt.RectangleShape), gapComposer, 6);
                } else {
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
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.similar_content, gapComposer3), LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 20.0f, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 4)), ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer3, 0, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.Top, gapComposer5, 6);
                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierFillMaxWidth);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sleep_timer, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, gapComposer5, 0, 24960, 110590);
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.set_as_default, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.set_as_default, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.end_of_song, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                ((Integer) obj2).intValue();
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                ((ArtistItem) obj3).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 10:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer9, 384, 3);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer10, 0);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer11, 384, 3);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer12, 384, 3);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.filter_podcasts, gapComposer13), OffsetKt.m138paddingqDBjuR0(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f, 16.0f, 20.0f, 8.0f), ((MaterialTheme$Values) gapComposer13.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer13, 0, 0);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.filter_channels, gapComposer14), OffsetKt.m138paddingqDBjuR0(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f, 16.0f, 20.0f, 8.0f), ((MaterialTheme$Values) gapComposer14.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer14, 0, 0);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 16:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                lazyItemScopeImpl2.getClass();
                if ((iIntValue15 & 6) == 0) {
                    iIntValue15 |= ((GapComposer) composer15).changed(lazyItemScopeImpl2) ? 4 : 2;
                }
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 19) != 18)) {
                    MenuKt.NavigationTitle(MathKt.stringResource(R.string.other_versions, gapComposer15), LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion), null, null, null, null, gapComposer15, 0, 60);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode2 = Long.hashCode(gapComposer16.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer16.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer16, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer16.startReusableNode();
                    if (gapComposer16.inserting) {
                        gapComposer16.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer16.useNode();
                    }
                    Stack.m390setimpl(gapComposer16, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer16, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer16, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer16);
                    Stack.m390setimpl(gapComposer16, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    DialogKt.m1465ContainedLoadingIndicatoreopBjH0(null, 0L, 0L, null, gapComposer16, 0);
                    gapComposer16.end(true);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer17, 384, 3);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 19:
                BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl.getClass();
                if ((iIntValue18 & 6) == 0) {
                    iIntValue18 |= ((GapComposer) composer18).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 19) != 18)) {
                    float fM118getMaxWidthD9Ej5fM = (boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM() * (Dp.m795compareTo0680j_4((boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM() * 0.475f) + CropImageView.DEFAULT_ASPECT_RATIO, 320.0f) < 0 ? 0.9f : 0.475f)) + CropImageView.DEFAULT_ASPECT_RATIO;
                    GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(4);
                    PaddingValuesImpl paddingValuesImplM128PaddingValuesa9UjIt4$default = OffsetKt.m128PaddingValuesa9UjIt4$default(4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth2, 256.0f);
                    boolean zChanged = gapComposer18.changed(fM118getMaxWidthD9Ej5fM);
                    Object objRememberedValue = gapComposer18.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new BottomSheetKt$$ExternalSyntheticLambda18(fM118getMaxWidthD9Ej5fM, b2);
                        gapComposer18.updateRememberedValue(objRememberedValue);
                    }
                    LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM145height3ABfNKs, null, paddingValuesImplM128PaddingValuesa9UjIt4$default, null, null, null, false, null, null, (Function1) objRememberedValue, gapComposer18, 3072, 2036);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer19, 0);
                    int iHashCode3 = Long.hashCode(gapComposer19.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer19.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer19, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer19.startReusableNode();
                    if (gapComposer19.inserting) {
                        gapComposer19.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer19.useNode();
                    }
                    Stack.m390setimpl(gapComposer19, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer19, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer19, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer19);
                    Stack.m390setimpl(gapComposer19, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    UuidKt.m1896TextPlaceholderuFdPcIQ(SizeKt.fillMaxWidth(OffsetKt.m135padding3ABfNKs(companion, 12.0f), 0.5f), 36.0f, null, gapComposer19, 54, 4);
                    OffsetKt.BoxWithConstraints(SizeKt.fillMaxWidth(companion, 1.0f), null, AlbumScreenKt.lambda$676841006, gapComposer19, 3078, 6);
                    UuidKt.m1896TextPlaceholderuFdPcIQ(SizeKt.m155width3ABfNKs(OffsetKt.m136paddingVpY3zN4(companion, 12.0f, 12.0f), 250.0f), 36.0f, null, gapComposer19, 48, 4);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer19, 0);
                    int iHashCode4 = Long.hashCode(gapComposer19.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer19.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer19, companion);
                    gapComposer19.startReusableNode();
                    if (gapComposer19.inserting) {
                        gapComposer19.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer19.useNode();
                    }
                    Stack.m390setimpl(gapComposer19, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer19, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer19, updater$$ExternalSyntheticLambda1, gapComposer19);
                    Stack.m390setimpl(gapComposer19, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    gapComposer19.startReplaceGroup(2144927579);
                    for (int i = 0; i < 2; i++) {
                        Okio__OkioKt.GridItemPlaceHolder(null, null, false, gapComposer19, 0, 7);
                    }
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer19, false, true, true);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 21:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                lazyItemScopeImpl3.getClass();
                if ((iIntValue20 & 6) == 0) {
                    iIntValue20 |= ((GapComposer) composer20).changed(lazyItemScopeImpl3) ? 4 : 2;
                }
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 19) != 18)) {
                    MenuKt.NavigationTitle(MathKt.stringResource(R.string.top_music_videos, gapComposer20), LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, companion), null, null, null, null, gapComposer20, 0, 60);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    MenuKt.NavigationTitle(MathKt.stringResource(R.string.podcast_channels, gapComposer21), DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer21, 6), null, null, null, null, gapComposer21, 0, 60);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    MenuKt.NavigationTitle(MathKt.stringResource(R.string.speed_dial, gapComposer22), DialogKt.m1473hairlineBottomiJQMabo(DialogKt.m1476riseInwH6b6FI$default(companion, 40), gapComposer22, 0), null, null, null, null, gapComposer22, 0, 60);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    MenuKt.NavigationTitle(MathKt.stringResource(R.string.from_the_community, gapComposer23), DialogKt.m1473hairlineBottomiJQMabo(DialogKt.m1476riseInwH6b6FI$default(companion, 40), gapComposer23, 0), null, null, null, null, gapComposer23, 0, 60);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 17) != 16)) {
                    MenuKt.NavigationTitle(MathKt.stringResource(R.string.keep_listening, gapComposer24), DialogKt.m1473hairlineBottomiJQMabo(DialogKt.m1476riseInwH6b6FI$default(companion, 40), gapComposer24, 0), null, null, null, null, gapComposer24, 0, 60);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer25 = (Composer) obj2;
                int iIntValue25 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 17) != 16)) {
                    String strStringResource = MathKt.stringResource(R.string.listen_together_background_disconnect_note, gapComposer25);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, SizeKt.fillMaxWidth(companion, 1.0f), ((MaterialTheme$Values) gapComposer25.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer25.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer25, 48, 0, 130040);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer26 = (Composer) obj2;
                int iIntValue26 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.logout, 0, gapComposer26), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer26, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer26, R.string.leave_room, gapComposer26), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 1572864, 0, 262078);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer27 = (Composer) obj2;
                int iIntValue27 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.add, 0, gapComposer27), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer27, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer27, R.string.create_room, gapComposer27), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 1572864, 0, 262078);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer28 = (Composer) obj2;
                int iIntValue28 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.login, 0, gapComposer28), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer28, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer28, R.string.join_room, gapComposer28), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 1572864, 0, 262078);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                return unit;
        }
    }
}
