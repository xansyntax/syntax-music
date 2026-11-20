package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.AspectRatioElement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.valentinilk.shimmer.ShimmerModifierKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.uuid.UuidKt;
import okio.Okio__OkioKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(byte b) {
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
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.continue_action, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
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
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.settings, 0, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer2, 440, 0);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.settings, gapComposer2), null, 0L, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer2, 1572864, 0, 131006);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_settings_desc, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 0, 131066);
                    gapComposer2.end(true);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_forward, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer2, 440, 0);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.link, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer4, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 6.0f, gapComposer4, R.string.connect, gapComposer4), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1572864, 0, 262078);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.disconnect, gapComposer5), null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 1572864, 0, 262078);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk("Reconnect", null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 1572870, 0, 262078);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.link, 0, gapComposer7), MathKt.stringResource(R.string.copy_link, gapComposer7), SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer7, 392, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer7, R.string.copy_link, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.content_copy, 0, gapComposer8), MathKt.stringResource(R.string.copy_code, gapComposer8), SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer8, 392, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer8, R.string.copy_code, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.retry, gapComposer9), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    for (int i = 0; i < 8; i++) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer10, 0);
                    }
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                break;
            case 10:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue11 & 6) == 0) {
                    iIntValue11 |= ((GapComposer) composer11).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 19) != 18)) {
                    ShimmerHostKt.ShimmerHost(LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), null, null, false, AlbumScreenKt.f296lambda$1008830117, gapComposer11, 24576, 14);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer12, 384, 3);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    DialogKt.EmptyPlaceholder(R.drawable.search, 0, 4, gapComposer13, null, MathKt.stringResource(R.string.no_results_found, gapComposer13));
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer14, 384, 3);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer15, 0);
                    }
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    for (int i3 = 0; i3 < 3; i3++) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer16, 0);
                    }
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, ArtistItemsScreenKt.f348lambda$868523985, gapComposer17, 24576, 15);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    Okio__OkioKt.GridItemPlaceHolder(null, null, true, gapComposer18, 384, 3);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(Modifier.Companion.$$INSTANCE, null, null, false, ArtistItemsScreenKt.f340lambda$1341727610, gapComposer19, 24582, 14);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    Modifier modifierThen = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2).then(new AspectRatioElement(1.0f));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode3 = Long.hashCode(gapComposer20.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer20.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer20, modifierThen);
                    ComposeUiNode.Companion.getClass();
                    gapComposer20.startReusableNode();
                    if (gapComposer20.inserting) {
                        gapComposer20.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer20.useNode();
                    }
                    Stack.m390setimpl(gapComposer20, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer20, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer20, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer20);
                    Stack.m390setimpl(gapComposer20, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    Modifier modifierShimmer = ShimmerModifierKt.shimmer(SizeKt.FillWholeMaxSize, gapComposer20, 6);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    OffsetKt.Spacer(gapComposer20, ImageKt.m39backgroundbw27NRU(modifierShimmer, ((MaterialTheme$Values) gapComposer20.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)));
                    gapComposer20.end(true);
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer20, 0);
                    int iHashCode4 = Long.hashCode(gapComposer20.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer20.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer20, modifierM135padding3ABfNKs2);
                    gapComposer20.startReusableNode();
                    if (gapComposer20.inserting) {
                        gapComposer20.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer20.useNode();
                    }
                    Stack.m390setimpl(gapComposer20, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer20, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer20, updater$$ExternalSyntheticLambda1, gapComposer20);
                    Stack.m390setimpl(gapComposer20, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    UuidKt.m1896TextPlaceholderuFdPcIQ(OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 0.7f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), 36.0f, null, gapComposer20, 54, 4);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer20, 48);
                    int iHashCode5 = Long.hashCode(gapComposer20.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer20.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer20, modifierFillMaxWidth);
                    gapComposer20.startReusableNode();
                    if (gapComposer20.inserting) {
                        gapComposer20.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer20.useNode();
                    }
                    Stack.m390setimpl(gapComposer20, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer20, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer20, updater$$ExternalSyntheticLambda1, gapComposer20);
                    Stack.m390setimpl(gapComposer20, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    StringsKt__IndentKt.ButtonPlaceholder(SizeKt.m145height3ABfNKs(SizeKt.m155width3ABfNKs(companion, 120.0f), 40.0f), gapComposer20, 6);
                    OffsetKt.Spacer(gapComposer20, new LayoutWeightElement(1.0f, true));
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), vertical, gapComposer20, 54);
                    int iHashCode6 = Long.hashCode(gapComposer20.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer20.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer20, companion);
                    gapComposer20.startReusableNode();
                    if (gapComposer20.inserting) {
                        gapComposer20.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer20.useNode();
                    }
                    Stack.m390setimpl(gapComposer20, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer20, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer20, updater$$ExternalSyntheticLambda1, gapComposer20);
                    Stack.m390setimpl(gapComposer20, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    StringsKt__IndentKt.ButtonPlaceholder(SizeKt.m145height3ABfNKs(SizeKt.m155width3ABfNKs(companion, 100.0f), 40.0f), gapComposer20, 6);
                    Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ShimmerModifierKt.shimmer(SizeKt.m151size3ABfNKs(companion, 48.0f), gapComposer20, 6), ((MaterialTheme$Values) gapComposer20.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(24.0f));
                    int i4 = 0;
                    BoxKt.Box(modifierM39backgroundbw27NRU, gapComposer20, 0);
                    gapComposer20.end(true);
                    gapComposer20.end(true);
                    gapComposer20.end(true);
                    int i5 = 0;
                    while (i5 < 6) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer20, i4);
                        i5++;
                        i4 = 0;
                    }
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    for (int i6 = 0; i6 < 4; i6++) {
                        CollectionsKt__IterablesKt.ListItemPlaceHolder(null, null, gapComposer21, 0);
                    }
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, ArtistItemsScreenKt.f344lambda$2094941704, gapComposer22, 24576, 15);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(Modifier.Companion.$$INSTANCE, null, null, false, ArtistItemsScreenKt.f349lambda$870491277, gapComposer23, 24582, 14);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 17) != 16)) {
                    String strStringResource = MathKt.stringResource(R.string.subscribed, gapComposer24);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer24.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer24.consume(staticProvidableCompositionLocal3)).typography.labelLarge, gapComposer24, 1572864, 0, 131002);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj2;
                int iIntValue25 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.subscribe, gapComposer25), null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer25.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, gapComposer25, 1572864, 0, 131006);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj2;
                int iIntValue26 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 17) != 16)) {
                    Painter painterPainterResource2 = IntMath.painterResource(R.drawable.radio, 0, gapComposer26);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), ((MaterialTheme$Values) gapComposer26.consume(staticProvidableCompositionLocal4)).colorScheme.onSurface, gapComposer26, 440, 0);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer26, R.string.radio, gapComposer26), null, ((MaterialTheme$Values) gapComposer26.consume(staticProvidableCompositionLocal4)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer26.consume(staticProvidableCompositionLocal4)).typography.labelLarge, gapComposer26, 0, 0, 131066);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                break;
            case 26:
                Composer composer27 = (Composer) obj2;
                int iIntValue27 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 17) != 16)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.shuffle, 0, gapComposer27), "Shuffle", SizeKt.m151size3ABfNKs(companion, 20.0f), ((MaterialTheme$Values) gapComposer27.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, gapComposer27, 440, 0);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj2;
                int iIntValue28 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer28), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj2;
                int iIntValue29 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.import_profile, gapComposer29), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                } else {
                    gapComposer29.skipToGroupEnd();
                }
                break;
            default:
                Composer composer30 = (Composer) obj2;
                int iIntValue30 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (gapComposer30.shouldExecute(iIntValue30 & 1, (iIntValue30 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer30), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer30, 0, 0, 262142);
                } else {
                    gapComposer30.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }
}
