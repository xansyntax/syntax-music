package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavHostController;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.lyrics.LyricsResult;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1;
import com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$2$4$3;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$6$1$1$2$1$1;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$6$1$1$2$2$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3 implements Function4 {
    public final /* synthetic */ Object $database$inlined;
    public final /* synthetic */ State $expandedItemIndex$delegate$inlined;
    public final /* synthetic */ List $items;
    public final /* synthetic */ Object $onDismiss$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $searchMediaMetadata$inlined;
    public final /* synthetic */ Object $viewModel$inlined;

    public /* synthetic */ LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3(List list, Object obj, Object obj2, Object obj3, Object obj4, State state, byte b) {
        this.$r8$classId = b;
        this.$items = list;
        this.$viewModel$inlined = obj;
        this.$onDismiss$inlined = obj2;
        this.$database$inlined = obj3;
        this.$searchMediaMetadata$inlined = obj4;
        this.$expandedItemIndex$delegate$inlined = state;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        MediaMetadata.Album album;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        State state = this.$expandedItemIndex$delegate$inlined;
        List list = this.$items;
        Object obj5 = this.$viewModel$inlined;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj6 = this.$searchMediaMetadata$inlined;
        Object obj7 = this.$onDismiss$inlined;
        Object obj8 = this.$database$inlined;
        byte b2 = 0;
        switch (b) {
            case 0:
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj5;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                final int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) state;
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    LyricsResult lyricsResult = (LyricsResult) list.get(iIntValue);
                    gapComposer.startReplaceGroup(182046908);
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion2, 1.0f);
                    boolean zChanged = gapComposer.changed((Function0) obj7) | gapComposer.changedInstance(lyricsMenuViewModel) | gapComposer.changedInstance((MusicDatabase) obj8) | gapComposer.changed((MediaMetadata) obj6) | gapComposer.changedInstance(lyricsResult);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LyricsMenuKt$LyricsMenu$11$1$1$1$1((Function0) obj7, lyricsMenuViewModel, (MusicDatabase) obj8, (MediaMetadata) obj6, lyricsResult, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierAnimateContentSize$default = CrossfadeKt.animateContentSize$default(OffsetKt.m135padding3ABfNKs(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue, 15), 12.0f), null, 3);
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, Alignment.Companion.Top, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierAnimateContentSize$default);
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
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    int i2 = i;
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    String str = lyricsResult.lyrics;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str, OffsetKt.m139paddingqDBjuR0$default(companion2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 2, false, iIntValue == parcelableSnapshotMutableIntState.getIntValue() ? Integer.MAX_VALUE : 2, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 48, 384, 110588);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, Alignment.Companion.CenterVertically, gapComposer, 48);
                    int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, companion2);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(lyricsResult.providerName, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.secondary, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium, gapComposer, 0, 24576, 114682);
                    if (StringsKt__StringsJVMKt.startsWith(lyricsResult.lyrics, "[", false)) {
                        gapComposer.startReplaceGroup(878403224);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion2, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), 18.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.secondary, gapComposer, 440, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(878885615);
                        gapComposer.end(false);
                    }
                    gapComposer.end(true);
                    gapComposer.end(true);
                    boolean zChanged2 = gapComposer.changed(parcelableSnapshotMutableIntState) | ((((i2 & 112) ^ 48) > 32 && gapComposer.changed(iIntValue)) || (i2 & 48) == 32);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$11$1$1$2$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState;
                                int intValue = parcelableSnapshotMutableIntState2.getIntValue();
                                int i3 = iIntValue;
                                if (intValue == i3) {
                                    i3 = -1;
                                }
                                parcelableSnapshotMutableIntState2.setIntValue(i3);
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.IconButton((Function0) objRememberedValue2, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-1316769329, new Function2() { // from class: com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$11$1$1$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj9, Object obj10) {
                            Composer composer2 = (Composer) obj9;
                            int iIntValue3 = ((Number) obj10).intValue();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                IconKt.m290Iconww6aTOc(IntMath.painterResource(iIntValue == parcelableSnapshotMutableIntState.getIntValue() ? R.drawable.expand_less : R.drawable.expand_more, 0, gapComposer2), (String) null, (Modifier) null, 0L, gapComposer2, 56, 12);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 1572864, 62);
                    gapComposer.end(true);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                final PlayerConnection playerConnection = (PlayerConnection) obj6;
                MenuState menuState = (MenuState) obj7;
                HistoryViewModel historyViewModel = (HistoryViewModel) obj5;
                final State state2 = (State) obj8;
                int i3 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i3 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    final SongItem songItem = (SongItem) list.get(iIntValue3);
                    gapComposer2.startReplaceGroup(-1752125649);
                    String str2 = songItem.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                    boolean zAreEqual = Intrinsics.areEqual(str2, mediaMetadata != null ? mediaMetadata.id : null);
                    boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged3 = gapComposer2.changed(menuState) | gapComposer2.changedInstance(songItem) | gapComposer2.changedInstance(historyViewModel);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new HistoryScreenKt$HistoryScreen$4$1$1$2$4$1$1((byte) 0, songItem, menuState, historyViewModel);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function0 = (Function0) objRememberedValue3;
                    boolean zChangedInstance = gapComposer2.changedInstance(songItem) | gapComposer2.changed(state2) | gapComposer2.changedInstance(playerConnection);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$4$1$1$2$4$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                SongItem songItem2 = songItem;
                                String str3 = songItem2.id;
                                MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                                boolean zAreEqual2 = Intrinsics.areEqual(str3, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                PlayerConnection playerConnection2 = playerConnection;
                                if (zAreEqual2) {
                                    playerConnection2.togglePlayPause();
                                } else {
                                    playerConnection2.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(songItem2)));
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.YouTubeListItem(songItem, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, function0, (Function0) objRememberedValue4, 239)), false, zAreEqual, zBooleanValue, false, null, Expect_jvmKt.rememberComposableLambda(-973045641, new HistoryScreenKt$HistoryScreen$4$1$1$2$4$3(historyViewModel, menuState, songItem), gapComposer2), null, gapComposer2, 100663296, 716);
                    gapComposer2.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                NavHostController navHostController = (NavHostController) obj8;
                MenuState menuState2 = (MenuState) obj7;
                HapticFeedback hapticFeedback = (HapticFeedback) obj5;
                int i4 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i4 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Album album2 = (Album) list.get(iIntValue5);
                    gapComposer3.startReplaceGroup(-382210614);
                    AlbumEntity albumEntity = album2.album;
                    Integer num = album2.songCountListened;
                    String str3 = (iIntValue5 + 1) + ". " + albumEntity.title;
                    String strJoinByBullet = UtilsKt.joinByBullet(MathKt.pluralStringResource(R.plurals.n_time, num != null ? num.intValue() : 0, new Object[]{Integer.valueOf(num != null ? num.intValue() : 0)}, gapComposer3), UtilsKt.makeTimeString(album2.timeListened));
                    AlbumEntity albumEntity2 = album2.album;
                    String str4 = albumEntity2.thumbnailUrl;
                    String str5 = albumEntity2.id;
                    MediaMetadata mediaMetadata2 = (MediaMetadata) ((State) obj6).getValue();
                    boolean zAreEqual2 = Intrinsics.areEqual(str5, (mediaMetadata2 == null || (album = mediaMetadata2.album) == null) ? null : album.id);
                    boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChangedInstance2 = gapComposer3.changedInstance(hapticFeedback) | gapComposer3.changed(menuState2) | gapComposer3.changed(album2);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new StatsScreenKt$StatsScreen$6$1$1$6$1$1$2$1$1(hapticFeedback, menuState2, album2, b2);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function1 = (Function0) objRememberedValue5;
                    boolean zChangedInstance3 = gapComposer3.changedInstance(navHostController) | gapComposer3.changed(album2);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new StatsScreenKt$StatsScreen$6$1$1$6$1$1$2$2$1(navHostController, album2, (byte) 0);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    MenuKt.LocalAlbumsGrid(str3, strJoinByBullet, null, str4, zAreEqual2, zBooleanValue2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth3, false, function1, (Function0) objRememberedValue6, 239), gapComposer3, 0);
                    gapComposer3.end(false);
                }
                break;
        }
        return unit;
    }
}
