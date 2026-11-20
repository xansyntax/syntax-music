package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavHostController;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.equalizer.wizard.EQProfileVariant;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3 implements Function4 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $sArtists$inlined;
    public final /* synthetic */ Object $toggleArtistSelection$inlined;

    public /* synthetic */ StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3(List list, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$sArtists$inlined = obj;
        this.$toggleArtistSelection$inlined = obj2;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        StateListIterator stateListIterator;
        long jColor;
        long jColor2;
        byte b = this.$r8$classId;
        byte b2 = 8;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.$toggleArtistSelection$inlined;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        List list = this.$items;
        Object obj6 = this.$sArtists$inlined;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj6;
                Function1 function1 = (Function1) obj5;
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Artist artist = (Artist) ((ArrayList) list).get(iIntValue);
                    gapComposer.startReplaceGroup(2138381912);
                    ArtistEntity artistEntity = artist.artist;
                    com.metrolist.innertube.models.Artist artist2 = new com.metrolist.innertube.models.Artist(artistEntity.name, artistEntity.id);
                    if (snapshotStateList == null || !snapshotStateList.isEmpty()) {
                        ListIterator listIterator = snapshotStateList.listIterator();
                        do {
                            stateListIterator = (StateListIterator) listIterator;
                            if (stateListIterator.hasNext()) {
                            }
                        } while (!Intrinsics.areEqual(((com.metrolist.innertube.models.Artist) stateListIterator.next()).id, artist2.id));
                    }
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged = gapComposer.changed(function1) | gapComposer.changedInstance(artist2);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(function1, artist2, (byte) 10);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue, 15), 8.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    MenuKt.ArtistListItem(artist, new LayoutWeightElement(1.0f, true), null, null, gapComposer, 0, 12);
                    ArtistEntity artistEntity2 = artist.artist;
                    boolean zContains = snapshotStateList.contains(new com.metrolist.innertube.models.Artist(artistEntity2.name, artistEntity2.id));
                    boolean zChanged2 = gapComposer.changed(function1) | gapComposer.changedInstance(artist2);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(function1, artist2, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.Checkbox(zContains, (Function1) objRememberedValue2, null, false, null, gapComposer, 0);
                    gapComposer.end(true);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                Function1 function2 = (Function1) obj5;
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    EQProfileVariant eQProfileVariant = (EQProfileVariant) list.get(iIntValue3);
                    gapComposer2.startReplaceGroup(1226855034);
                    boolean zContains2 = ((Set) obj6).contains(eQProfileVariant.id);
                    boolean zChanged3 = gapComposer2.changed(function2) | gapComposer2.changedInstance(eQProfileVariant);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new Http2Connection.ReaderRunnable(function2, eQProfileVariant, (byte) 15);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    WizardScreenKt.VariantItem(eQProfileVariant, zContains2, (Function0) objRememberedValue3, gapComposer2, 0);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                NavHostController navHostController = (NavHostController) obj6;
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    RecognitionHistory recognitionHistory = (RecognitionHistory) list.get(iIntValue5);
                    gapComposer3.startReplaceGroup(704436023);
                    boolean zChangedInstance = gapComposer3.changedInstance(recognitionHistory) | gapComposer3.changedInstance(navHostController);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Http2Connection.ReaderRunnable(recognitionHistory, navHostController, (byte) 17);
                        gapComposer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function0 = (Function0) objRememberedValue4;
                    boolean zChangedInstance2 = gapComposer3.changedInstance(recognitionHistory);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new Http2Connection.ReaderRunnable(recognitionHistory, (MutableState) obj5, (byte) 18);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    RecognitionHistoryScreenKt.RecognitionHistoryItem(recognitionHistory, function0, (Function0) objRememberedValue5, gapComposer3, 8);
                    gapComposer3.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                MutableState mutableState = (MutableState) obj6;
                int i4 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl4) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    final Playlist playlist = (Playlist) list.get(iIntValue7);
                    gapComposer4.startReplaceGroup(-27842623);
                    final boolean zAreEqual = Intrinsics.areEqual(playlist.playlist.id, (String) mutableState.getValue());
                    if (UiStyleKt.isGlassStyle(gapComposer4)) {
                        gapComposer4.startReplaceGroup(-832178080);
                        gapComposer4.end(false);
                        jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
                    } else {
                        gapComposer4.startReplaceGroup(-832175589);
                        jColor = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                        gapComposer4.end(false);
                    }
                    BorderStroke borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f);
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1);
                    if (zAreEqual) {
                        gapComposer4.startReplaceGroup(-27155261);
                        jColor2 = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primaryContainer;
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-27035663);
                        long j = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant;
                        jColor2 = ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.35f, Color.m483getColorSpaceimpl(j));
                        gapComposer4.end(false);
                    }
                    CardColors cardColorsM267cardColorsro_MJ88 = CardKt.m267cardColorsro_MJ88(jColor2, 0L, gapComposer4, 14);
                    boolean zChanged4 = gapComposer4.changed(playlist);
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AccountScreenKt$AccountScreen$1$1$11$1$1(playlist, mutableState, (MutableState) obj5, b2);
                        gapComposer4.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.Card((Function0) objRememberedValue6, modifierM137paddingVpY3zN4$default, false, null, cardColorsM267cardColorsro_MJ88, null, borderStrokeM38BorderStrokecXLIe8U, Expect_jvmKt.rememberComposableLambda(1977916024, new Function3() { // from class: com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$5$1$1$2$2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj7, Object obj8, Object obj9) {
                            Composer composer5 = (Composer) obj8;
                            int iIntValue9 = ((Number) obj9).intValue();
                            ((ColumnScopeInstance) obj7).getClass();
                            GapComposer gapComposer5 = (GapComposer) composer5;
                            if (gapComposer5.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion2, 1.0f), 14.0f, 12.0f);
                                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer5, 48);
                                int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM136paddingVpY3zN4);
                                ComposeUiNode.Companion.getClass();
                                gapComposer5.startReusableNode();
                                boolean z = gapComposer5.inserting;
                                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                                if (z) {
                                    gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer5.useNode();
                                }
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                Stack.m390setimpl(gapComposer5, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                Integer numValueOf = Integer.valueOf(iHashCode2);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                Stack.m390setimpl(gapComposer5, numValueOf, updater$$ExternalSyntheticLambda2);
                                Stack.m389reconcileimpl(gapComposer5);
                                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer5, 0);
                                int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, layoutWeightElement);
                                gapComposer5.startReusableNode();
                                if (gapComposer5.inserting) {
                                    gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer5.useNode();
                                }
                                Stack.m390setimpl(gapComposer5, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer5, updater$$ExternalSyntheticLambda2, gapComposer5);
                                Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                                Playlist playlist2 = playlist;
                                String str = playlist2.playlist.name;
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer5, 0, 0, 131070);
                                int i5 = playlist2.songCount;
                                TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.alarm_playlist_song_count, i5, new Object[]{Integer.valueOf(i5)}, gapComposer5), null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer5, 0, 0, 131066);
                                gapComposer5.end(true);
                                if (zAreEqual) {
                                    gapComposer5.startReplaceGroup(-1341661544);
                                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.check, 0, gapComposer5), MathKt.stringResource(R.string.alarm_selected, gapComposer5), SizeKt.m151size3ABfNKs(companion2, 18.0f), 0L, gapComposer5, 392, 8);
                                    gapComposer5.end(false);
                                } else {
                                    gapComposer5.startReplaceGroup(-1341302130);
                                    gapComposer5.end(false);
                                }
                                gapComposer5.end(true);
                            } else {
                                gapComposer5.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer4), gapComposer4, 100663344);
                    gapComposer4.end(false);
                }
                break;
        }
        return unit;
    }
}
