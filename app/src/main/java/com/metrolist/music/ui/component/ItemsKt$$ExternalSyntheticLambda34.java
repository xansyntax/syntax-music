package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListInterval;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.grid.LazyGridInterval;
import androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.pager.PagerIntervalContent;
import androidx.compose.foundation.pager.PagerLazyLayoutItemProvider;
import androidx.compose.foundation.pager.PagerScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.WavyProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.style.TextAlign;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.menu.LoadingScreenKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.viewmodels.ConvertedSongLog;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda34 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda34(Material3SettingsItem material3SettingsItem, int i, int i2) {
        this.$r8$classId = (byte) 5;
        this.f$0 = material3SettingsItem;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        boolean z;
        String strM;
        byte b = this.$r8$classId;
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$0;
        int i = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                MenuKt.OverlayPlayButton((BoxWithConstraintsScopeImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    IntervalList$Interval intervalList$Interval = lazyListItemProviderImpl.intervalContent.intervals.get(i);
                    ((LazyListInterval) intervalList$Interval.value).item.invoke((Object) lazyListItemProviderImpl.itemScope, (Object) Integer.valueOf(i - intervalList$Interval.startIndex), (Object) gapComposer, (Object) 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 2:
                LazyGridItemProviderImpl lazyGridItemProviderImpl = (LazyGridItemProviderImpl) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    IntervalList$Interval intervalList$Interval2 = lazyGridItemProviderImpl.intervalContent.intervals.get(i);
                    ((LazyGridInterval) intervalList$Interval2.value).item.invoke((Object) LazyGridItemScopeImpl.INSTANCE, (Object) Integer.valueOf(i - intervalList$Interval2.startIndex), (Object) gapComposer2, (Object) 6);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 3:
                PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider = (PagerLazyLayoutItemProvider) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    IntervalList$Interval intervalList$Interval3 = pagerLazyLayoutItemProvider.intervalContent.getIntervals().get(i);
                    ((PagerIntervalContent) intervalList$Interval3.value).item.invoke(PagerScopeImpl.INSTANCE, Integer.valueOf(i - intervalList$Interval3.startIndex), gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 4:
                Screens screens = (Screens) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer4), MathKt.stringResource(screens.titleId, gapComposer4), (Modifier) null, 0L, gapComposer4, 8, 12);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 5:
                ((Integer) obj2).getClass();
                MenuKt.Material3SettingsItemRow((Material3SettingsItem) obj3, i, (Composer) obj, Stack.updateChangedFlags(9));
                break;
            case 6:
                List<ConvertedSongLog> list = (List) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 0.85f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f)), CardKt.getColorScheme(gapComposer5).surface, rectangleShapeKt$RectangleShape$1), 24.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer5, 6);
                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer5, updater$$ExternalSyntheticLambda1, gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.importing_csv, gapComposer5), null, CardKt.getColorScheme(gapComposer5).onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer5).headlineSmall, gapComposer5, 0, 0, 131066);
                    boolean zChanged = gapComposer5.changed(i);
                    Object objRememberedValue = gapComposer5.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LoadingScreenKt$$ExternalSyntheticLambda4((byte) 2, i);
                        gapComposer5.updateRememberedValue(objRememberedValue);
                    }
                    ProgressIndicatorKt.m309LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue, ClipKt.clip(SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 8.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(4.0f)), 0L, 0L, 0, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer5, 0, 124);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.percentage_format, new Object[]{Integer.valueOf(i)}, gapComposer5), null, CardKt.getColorScheme(gapComposer5).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer5).bodySmall, gapComposer5, 0, 0, 131066);
                    if (list.isEmpty()) {
                        z = true;
                        gapComposer5.startReplaceGroup(-799285444);
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(-801259338);
                        Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), CardKt.getColorScheme(gapComposer5).surfaceVariant, rectangleShapeKt$RectangleShape$1), 12.0f);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer5, 6);
                        int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs2);
                        gapComposer5.startReusableNode();
                        if (gapComposer5.inserting) {
                            gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer5.useNode();
                        }
                        Stack.m390setimpl(gapComposer5, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer5, updater$$ExternalSyntheticLambda1, gapComposer5);
                        Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.recently_converted, gapComposer5), null, CardKt.getColorScheme(gapComposer5).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer5).labelMedium, gapComposer5, 0, 0, 131066);
                        gapComposer5.startReplaceGroup(-53676590);
                        for (ConvertedSongLog convertedSongLog : list) {
                            Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(4.0f));
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                            Modifier.Companion companion2 = companion;
                            Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(modifierClip, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.background, rectangleShapeKt$RectangleShape$1), 8.0f);
                            ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer5, 6);
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda0;
                            int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM135padding3ABfNKs3);
                            ComposeUiNode.Companion.getClass();
                            gapComposer5.startReusableNode();
                            if (gapComposer5.inserting) {
                                gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer5.useNode();
                            }
                            Stack.m390setimpl(gapComposer5, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer5, updater$$ExternalSyntheticLambda1, gapComposer5);
                            Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
                            TextKt.m352TextNvy7gAk(convertedSongLog.title, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer5, 0, 24960, 110586);
                            TextKt.m352TextNvy7gAk(convertedSongLog.artists, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer5, 0, 24960, 110586);
                            gapComposer5.end(true);
                            updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda4;
                            companion = companion2;
                        }
                        z = true;
                        Fragment$5$$ExternalSyntheticOutline0.m(gapComposer5, false, true, false);
                    }
                    gapComposer5.end(z);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            case 7:
                String str = (String) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    Modifier modifierM135padding3ABfNKs4 = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 0.9f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f)), CardKt.getColorScheme(gapComposer6).surfaceContainer, rectangleShapeKt$RectangleShape$1), 24.0f);
                    ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer6, 54);
                    int iHashCode4 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.playlist_add, 0, gapComposer6), (String) null, SizeKt.m151size3ABfNKs(companion, 32.0f), CardKt.getColorScheme(gapComposer6).secondary, gapComposer6, 440, 0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.importing_playlist, gapComposer6), null, CardKt.getColorScheme(gapComposer6).onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer6).headlineSmall, gapComposer6, 0, 0, 131066);
                    if (str == null || StringsKt.isBlank(str)) {
                        gapComposer6.startReplaceGroup(1614248062);
                        OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion, 24.0f));
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(1613911712);
                        TextKt.m352TextNvy7gAk(str, null, CardKt.getColorScheme(gapComposer6).onSurface, 0L, null, null, null, 0L, new TextAlign(3), 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer6).bodyLarge, gapComposer6, 0, 24960, 109562);
                        gapComposer6.end(false);
                    }
                    OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    boolean zChanged2 = gapComposer6.changed(i);
                    Object objRememberedValue2 = gapComposer6.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new LoadingScreenKt$$ExternalSyntheticLambda4((byte) 0, i);
                        gapComposer6.updateRememberedValue(objRememberedValue2);
                    }
                    WavyProgressIndicatorKt.m364LinearWavyProgressIndicator1YwxWKA((Function0) objRememberedValue2, SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 8.0f), 0L, 0L, null, null, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer6, 48, 2044);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.progress_percent, new Object[]{String.valueOf(i)}, gapComposer6), null, CardKt.getColorScheme(gapComposer6).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer6).labelLarge, gapComposer6, 0, 0, 131066);
                    gapComposer6.startReplaceGroup(1615152487);
                    gapComposer6.end(false);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
            default:
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj3;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    Object objRememberedValue3 = gapComposer7.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{10, 25, 50, 75, 100, 150, 200, -1});
                        gapComposer7.updateRememberedValue(objRememberedValue3);
                    }
                    List list2 = (List) objRememberedValue3;
                    ColumnMeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer7, 0);
                    int iHashCode5 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer7, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, columnMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.android_auto_search_local_songs_limit_desc, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                    OffsetKt.Spacer(gapComposer7, SizeKt.m145height3ABfNKs(companion, 4.0f));
                    if (i == -1) {
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer7, -1642505851, R.string.unlimited, gapComposer7, false);
                    } else {
                        gapComposer7.startReplaceGroup(-1642503165);
                        strM = i + ServerSentEventKt.SPACE + MathKt.stringResource(R.string.songs, gapComposer7);
                        gapComposer7.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strM, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                    float fIndexOf = list2.indexOf(Integer.valueOf(i));
                    int size = list2.size() - 2;
                    ClosedFloatRange closedFloatRange = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, list2.size() - 1);
                    boolean zChangedInstance = gapComposer7.changedInstance(list2) | gapComposer7.changed(mimesKt$$ExternalSyntheticLambda0);
                    Object objRememberedValue4 = gapComposer7.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda4((Object) list2, (Object) mimesKt$$ExternalSyntheticLambda0, (byte) 24);
                        gapComposer7.updateRememberedValue(objRememberedValue4);
                    }
                    SliderKt.Slider(fIndexOf, (Function1) objRememberedValue4, null, true, closedFloatRange, size, null, null, gapComposer7, 3072, 452);
                    gapComposer7.end(true);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda34(int i, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$2 = i;
        this.f$0 = obj;
    }

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda34(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = i;
    }
}
