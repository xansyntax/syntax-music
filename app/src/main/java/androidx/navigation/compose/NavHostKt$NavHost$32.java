package androidx.navigation.compose;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import com.metrolist.music.ui.component.DraggableLyricsProviderListKt$DraggableLyricsProviderList$2$1$2$1$1$1$1$1;
import com.metrolist.music.ui.component.LibraryKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$12$1$3$1$1;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$7$1$1$1;
import com.metrolist.music.ui.screens.AccountScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1;
import com.metrolist.music.ui.screens.BrowseScreenKt$BrowseScreen$1$1$1$4$1$1;
import com.metrolist.music.ui.screens.settings.AndroidAutoSection;
import com.metrolist.music.ui.screens.settings.AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http2.Http2Connection;
import sh.calvin.reorderable.DragGestureDetector$Press;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl$draggableHandle$1;
import sh.calvin.reorderable.ReorderableLazyCollectionState$findTargetItem$1;
import sh.calvin.reorderable.ReorderableLazyListState;
import sh.calvin.reorderable.Scroller$ScrollInfo$Companion$Null$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$32 implements Function4 {
    public final /* synthetic */ Object $backStackEntry;
    public final /* synthetic */ Object $inPredictiveBack$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $saveableStateHolder;
    public final /* synthetic */ Object $transitionState;
    public final /* synthetic */ Object $visibleEntries$delegate;

    public /* synthetic */ NavHostKt$NavHost$32(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.$transitionState = obj;
        this.$backStackEntry = obj2;
        this.$saveableStateHolder = obj3;
        this.$inPredictiveBack$delegate = obj4;
        this.$visibleEntries$delegate = obj5;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean z;
        GapComposer gapComposer;
        Object obj5;
        Object obj6;
        MediaMetadata.Album album;
        MediaMetadata.Album album2;
        int i;
        int i2;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Long lValueOf = null;
        str = null;
        String str = null;
        str = null;
        String str2 = null;
        Unit unit = Unit.INSTANCE;
        Object obj7 = this.$visibleEntries$delegate;
        Object obj8 = this.$inPredictiveBack$delegate;
        Object obj9 = this.$transitionState;
        Object obj10 = this.$backStackEntry;
        Object obj11 = this.$saveableStateHolder;
        switch (b) {
            case 0:
                AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj2;
                Composer composer = (Composer) obj3;
                ((Number) obj4).intValue();
                boolean zAreEqual = Intrinsics.areEqual(((SeekableTransitionState) obj9).currentState$delegate.getValue(), (NavBackStackEntry) obj10);
                if (!((Boolean) ((MutableState) obj8).getValue()).booleanValue() && !zAreEqual) {
                    List list = (List) ((State) obj7).getValue();
                    ListIterator listIterator = list.listIterator(list.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            Object objPrevious = listIterator.previous();
                            if (Intrinsics.areEqual(navBackStackEntry, (NavBackStackEntry) objPrevious)) {
                                obj5 = objPrevious;
                            }
                        } else {
                            obj5 = null;
                        }
                    }
                    navBackStackEntry = (NavBackStackEntry) obj5;
                }
                if (navBackStackEntry == null) {
                    gapComposer = (GapComposer) composer;
                    gapComposer.startReplaceGroup(105930796);
                    z = false;
                } else {
                    z = false;
                    gapComposer = (GapComposer) composer;
                    gapComposer.startReplaceGroup(-1520603531);
                    DatabaseDao_Impl.AnonymousClass17.LocalOwnersProvider(navBackStackEntry, (SaveableStateHolder) obj11, Expect_jvmKt.rememberComposableLambda(-1263531443, new AnonymousClass1(navBackStackEntry, animatedContentScopeImpl, false ? 1 : 0), gapComposer), gapComposer, 384);
                }
                gapComposer.end(z);
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                Function0 function0 = (Function0) obj11;
                MutableState mutableState = (MutableState) obj8;
                NavHostController navHostController = (NavHostController) obj10;
                int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ArtistEntity artistEntity = (ArtistEntity) ((ArrayList) obj9).get(iIntValue);
                    gapComposer2.startReplaceGroup(1171346523);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, 64.0f);
                    boolean zChangedInstance = gapComposer2.changedInstance(navHostController) | gapComposer2.changed(artistEntity) | gapComposer2.changed(mutableState) | gapComposer2.changed(function0);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SongMenuKt$SongMenu$12$1$3$1$1(navHostController, artistEntity, function0, mutableState, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs, false, null, (Function0) objRememberedValue, 15), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    boolean z2 = gapComposer2.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z2) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer2);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    BiasAlignment biasAlignment = Alignment.Companion.CenterStart;
                    Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(LazyItemScopeImpl.fillParentMaxWidth$default(lazyItemScopeImpl), 64.0f);
                    boolean zChanged = gapComposer2.changed(mutableState) | gapComposer2.changed(function0) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(artistEntity);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    Object obj12 = objRememberedValue2;
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        SongMenuKt$SongMenu$12$1$3$1$1 songMenuKt$SongMenu$12$1$3$1$1 = new SongMenuKt$SongMenu$12$1$3$1$1(function0, navHostController, artistEntity, mutableState);
                        gapComposer2.updateRememberedValue(songMenuKt$SongMenu$12$1$3$1$1);
                        obj12 = songMenuKt$SongMenu$12$1$3$1$1;
                    }
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs2, false, null, (Function0) obj12, 15), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default2);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                    TextKt.m352TextNvy7gAk(ArtistNameAliases.resolve(artistEntity.id, artistEntity.name, (Map) obj7), null, 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer2, 1597440, 24960, 241582);
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, true, true, false);
                }
                break;
            case 2:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                NavHostController navHostController2 = (NavHostController) obj7;
                CoroutineScope coroutineScope = (CoroutineScope) obj8;
                MenuState menuState = (MenuState) obj11;
                HapticFeedback hapticFeedback = (HapticFeedback) obj10;
                int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    PlaylistItem playlistItem = (PlaylistItem) ((ArrayList) obj9).get(iIntValue3);
                    gapComposer3.startReplaceGroup(441556412);
                    boolean zChangedInstance2 = gapComposer3.changedInstance(hapticFeedback) | gapComposer3.changed(menuState) | gapComposer3.changedInstance(playlistItem) | gapComposer3.changedInstance(coroutineScope);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new QueueKt$Queue$5$4$1$1$7$1$1$1(hapticFeedback, menuState, (Object) playlistItem, (Object) coroutineScope, (byte) 2);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1 = (Function0) objRememberedValue3;
                    boolean zChangedInstance3 = gapComposer3.changedInstance(navHostController2) | gapComposer3.changedInstance(playlistItem);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    Object obj13 = objRememberedValue4;
                    if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                        Http2Connection.ReaderRunnable readerRunnable = new Http2Connection.ReaderRunnable(navHostController2, playlistItem, (byte) 4);
                        gapComposer3.updateRememberedValue(readerRunnable);
                        obj13 = readerRunnable;
                    }
                    MenuKt.YouTubeGridItem(playlistItem, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function1, (Function0) obj13, 239), null, null, CropImageView.DEFAULT_ASPECT_RATIO, false, false, true, gapComposer3, 12582912, 124);
                    gapComposer3.end(false);
                }
                break;
            case 3:
                LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                NavHostController navHostController3 = (NavHostController) obj8;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj11;
                MenuState menuState2 = (MenuState) obj10;
                int i5 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer4).changed(lazyGridItemScopeImpl2) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i5 |= ((GapComposer) composer4).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    YTItem yTItem = (YTItem) ((ArrayList) obj9).get(iIntValue5);
                    gapComposer4.startReplaceGroup(607521852);
                    boolean zBooleanValue = ((Boolean) ((State) obj7).getValue()).booleanValue();
                    boolean zChanged2 = gapComposer4.changed(menuState2) | gapComposer4.changedInstance(yTItem) | gapComposer4.changedInstance(coroutineScope2);
                    Object objRememberedValue5 = gapComposer4.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        obj6 = objRememberedValue5;
                        BrowseScreenKt$BrowseScreen$1$1$1$4$1$1 browseScreenKt$BrowseScreen$1$1$1$4$1$1 = new BrowseScreenKt$BrowseScreen$1$1$1$4$1$1((byte) 0, yTItem, menuState2, coroutineScope2);
                        gapComposer4.updateRememberedValue(browseScreenKt$BrowseScreen$1$1$1$4$1$1);
                        obj6 = browseScreenKt$BrowseScreen$1$1$1$4$1$1;
                    }
                    Function0 function2 = (Function0) obj6;
                    boolean zChangedInstance4 = gapComposer4.changedInstance(yTItem) | gapComposer4.changedInstance(navHostController3);
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    Object obj14 = objRememberedValue6;
                    if (zChangedInstance4 || objRememberedValue6 == neverEqualPolicy) {
                        Http2Connection.ReaderRunnable readerRunnable2 = new Http2Connection.ReaderRunnable(yTItem, navHostController3, (byte) 5);
                        gapComposer4.updateRememberedValue(readerRunnable2);
                        obj14 = readerRunnable2;
                    }
                    MenuKt.YouTubeGridItem(yTItem, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function2, (Function0) obj14, 239), (CoroutineScope) obj11, null, CropImageView.DEFAULT_ASPECT_RATIO, false, zBooleanValue, true, gapComposer4, 12582912, 56);
                    gapComposer4.end(false);
                }
                break;
            case 4:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer5 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                NavHostController navHostController4 = (NavHostController) obj7;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj8;
                MenuState menuState3 = (MenuState) obj11;
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj10;
                int i6 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer5).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i6 |= ((GapComposer) composer5).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(i6 & 1, (i6 & 147) != 146)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    Artist artist = (Artist) ((List) obj9).get(iIntValue7);
                    gapComposer5.startReplaceGroup(-1780749825);
                    String str3 = (iIntValue7 + 1) + ". " + artist.artist.name;
                    int i7 = artist.songCount;
                    String strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_time, i7, new Object[]{Integer.valueOf(i7)}, gapComposer5);
                    Integer num = artist.timeListened;
                    if (num != null) {
                        lValueOf = Long.valueOf(num.intValue());
                    }
                    String strJoinByBullet = UtilsKt.joinByBullet(strPluralStringResource, UtilsKt.makeTimeString(lValueOf));
                    String str4 = artist.artist.thumbnailUrl;
                    boolean zChangedInstance5 = gapComposer5.changedInstance(hapticFeedback2) | gapComposer5.changed(menuState3) | gapComposer5.changed(artist) | gapComposer5.changedInstance(coroutineScope3);
                    Object objRememberedValue7 = gapComposer5.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new QueueKt$Queue$5$4$1$1$7$1$1$1(hapticFeedback2, menuState3, (Object) artist, (Object) coroutineScope3, (byte) 4);
                        gapComposer5.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function3 = (Function0) objRememberedValue7;
                    boolean zChangedInstance6 = gapComposer5.changedInstance(navHostController4) | gapComposer5.changed(artist);
                    Object objRememberedValue8 = gapComposer5.rememberedValue();
                    Object obj15 = objRememberedValue8;
                    if (zChangedInstance6 || objRememberedValue8 == neverEqualPolicy) {
                        Http2Connection.ReaderRunnable readerRunnable3 = new Http2Connection.ReaderRunnable(navHostController4, artist, (byte) 12);
                        gapComposer5.updateRememberedValue(readerRunnable3);
                        obj15 = readerRunnable3;
                    }
                    MenuKt.LocalArtistsGrid(str3, strJoinByBullet, null, str4, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function3, (Function0) obj15, 239), gapComposer5, 0);
                    gapComposer5.end(false);
                }
                break;
            case 5:
                LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj;
                int iIntValue9 = ((Number) obj2).intValue();
                Composer composer6 = (Composer) obj3;
                int iIntValue10 = ((Number) obj4).intValue();
                int i8 = (iIntValue10 & 6) == 0 ? iIntValue10 | (((GapComposer) composer6).changed(lazyGridItemScopeImpl3) ? 4 : 2) : iIntValue10;
                if ((iIntValue10 & 48) == 0) {
                    i8 |= ((GapComposer) composer6).changed(iIntValue9) ? 32 : 16;
                }
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(i8 & 1, (i8 & 147) != 146)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    Album album3 = (Album) ((ArrayList) obj9).get(iIntValue9);
                    gapComposer6.startReplaceGroup(-2113344317);
                    String str5 = album3.album.id;
                    MediaMetadata mediaMetadata = (MediaMetadata) ((State) obj7).getValue();
                    if (mediaMetadata != null && (album = mediaMetadata.album) != null) {
                        str2 = album.id;
                    }
                    LibraryKt.LibraryAlbumGridItem(Modifier.Companion.$$INSTANCE, (MenuState) obj10, (CoroutineScope) obj11, album3, Intrinsics.areEqual(str5, str2), ((Boolean) ((State) obj8).getValue()).booleanValue(), gapComposer6, 6);
                    gapComposer6.end(false);
                }
                break;
            case 6:
                LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj;
                int iIntValue11 = ((Number) obj2).intValue();
                Composer composer7 = (Composer) obj3;
                int iIntValue12 = ((Number) obj4).intValue();
                int i9 = (iIntValue12 & 6) == 0 ? iIntValue12 | (((GapComposer) composer7).changed(lazyGridItemScopeImpl4) ? 4 : 2) : iIntValue12;
                if ((iIntValue12 & 48) == 0) {
                    i9 |= ((GapComposer) composer7).changed(iIntValue11) ? 32 : 16;
                }
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(1 & i9, (i9 & 147) != 146)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    Album album4 = (Album) ((List) obj9).get(iIntValue11);
                    gapComposer7.startReplaceGroup(1303392941);
                    String str6 = album4.album.id;
                    MediaMetadata mediaMetadata2 = (MediaMetadata) ((State) obj7).getValue();
                    if (mediaMetadata2 != null && (album2 = mediaMetadata2.album) != null) {
                        str = album2.id;
                    }
                    LibraryKt.LibraryAlbumGridItem(LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, companion), (MenuState) obj10, (CoroutineScope) obj11, album4, Intrinsics.areEqual(str6, str), ((Boolean) ((State) obj8).getValue()).booleanValue(), gapComposer7, 0);
                    gapComposer7.end(false);
                }
                break;
            case 7:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue13 = ((Number) obj2).intValue();
                Composer composer8 = (Composer) obj3;
                int iIntValue14 = ((Number) obj4).intValue();
                int i10 = (iIntValue14 & 6) == 0 ? iIntValue14 | (((GapComposer) composer8).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue14;
                if ((iIntValue14 & 48) == 0) {
                    i10 |= ((GapComposer) composer8).changed(iIntValue13) ? 32 : 16;
                }
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(i10 & 1, (i10 & 147) != 146)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    Pair pair = (Pair) ((List) obj9).get(iIntValue13);
                    gapComposer8.startReplaceGroup(1090566616);
                    AndroidAutoSection androidAutoSection = (AndroidAutoSection) pair.first;
                    CharsKt.ReorderableItem(lazyItemScopeImpl3, (ReorderableLazyListState) obj10, androidAutoSection.id, null, false, null, Expect_jvmKt.rememberComposableLambda(581166065, new AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1(androidAutoSection, (MutableState) obj8, (MimesKt$$ExternalSyntheticLambda0) obj11, (HapticFeedback) obj7, ((Boolean) pair.second).booleanValue(), (byte) 0), gapComposer8), gapComposer8, (i10 & 14) | 1572864);
                    gapComposer8.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                int iIntValue15 = ((Number) obj2).intValue();
                Composer composer9 = (Composer) obj3;
                int iIntValue16 = ((Number) obj4).intValue();
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj10;
                if ((iIntValue16 & 6) == 0) {
                    i = 48;
                    i2 = iIntValue16 | (((GapComposer) composer9).changed(lazyItemScopeImpl4) ? 4 : 2);
                } else {
                    i = 48;
                    i2 = iIntValue16;
                }
                if ((iIntValue16 & 48) == 0) {
                    i2 |= ((GapComposer) composer9).changed(iIntValue15) ? 32 : 16;
                }
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    String str7 = (String) ((ArrayList) obj9).get(iIntValue15);
                    gapComposer9.startReplaceGroup(1830903485);
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion2, 1.0f);
                    boolean zChanged3 = gapComposer9.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer9.changed(str7);
                    Object objRememberedValue9 = gapComposer9.rememberedValue();
                    if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new AccountScreenKt$AccountScreen$1$1$11$1$1((Object) mimesKt$$ExternalSyntheticLambda0, (Object) str7, obj8, (byte) 10);
                        gapComposer9.updateRememberedValue(objRememberedValue9);
                    }
                    Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue9, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, gapComposer9, i);
                    int iHashCode3 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierM137paddingVpY3zN4$default3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer9, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                    ScrimKt.RadioButton(Intrinsics.areEqual(str7, (String) obj11), null, null, false, null, gapComposer9, 48);
                    TextKt.m352TextNvy7gAk((String) ((QueueKt$$ExternalSyntheticLambda21) obj7).invoke(str7, gapComposer9, 0), OffsetKt.m139paddingqDBjuR0$default(companion2, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer9.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer9, 48, 0, 131068);
                    gapComposer9.end(true);
                    gapComposer9.end(false);
                }
                break;
        }
        return unit;
    }

    /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$32$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ Object $currentEntry;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object $this_AnimatedContent;

        public AnonymousClass1(DialogNavigator.Destination destination, NavBackStackEntry navBackStackEntry) {
            this.$r8$classId = (byte) 1;
            this.$this_AnimatedContent = destination;
            this.$currentEntry = navBackStackEntry;
        }

        /* JADX WARN: Code duplicated, block: B:41:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:49:0x01f6  */
        /* JADX WARN: Code duplicated, block: B:57:0x0224  */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            Unit unit = Unit.INSTANCE;
            Object obj3 = this.$this_AnimatedContent;
            Object obj4 = this.$currentEntry;
            switch (b) {
                case 0:
                    Composer composer = (Composer) obj;
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj4;
                    if ((((Number) obj2).intValue() & 3) == 2) {
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.getSkipping()) {
                            gapComposer.skipToGroupEnd();
                        } else {
                            NavDestination navDestination = navBackStackEntry.destination;
                            navDestination.getClass();
                            ((ComposeNavigator.Destination) navDestination).content.invoke(obj3, (Object) navBackStackEntry, (Object) composer, (Object) 0);
                        }
                    } else {
                        NavDestination navDestination2 = navBackStackEntry.destination;
                        navDestination2.getClass();
                        ((ComposeNavigator.Destination) navDestination2).content.invoke(obj3, (Object) navBackStackEntry, (Object) composer, (Object) 0);
                    }
                    return unit;
                case 1:
                    Composer composer2 = (Composer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2) {
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.getSkipping()) {
                            gapComposer2.skipToGroupEnd();
                        } else {
                            ((DialogNavigator.Destination) obj3).content.invoke(obj4, (Object) composer2, (Object) 0);
                        }
                    } else {
                        ((DialogNavigator.Destination) obj3).content.invoke(obj4, (Object) composer2, (Object) 0);
                    }
                    return unit;
                case 2:
                    Composer composer3 = (Composer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2) {
                        GapComposer gapComposer3 = (GapComposer) composer3;
                        if (gapComposer3.getSkipping()) {
                            gapComposer3.skipToGroupEnd();
                        } else {
                            DatabaseDao_Impl.AnonymousClass17.SaveableStateProvider((SaveableStateHolder) obj4, (ComposableLambdaImpl) obj3, composer3, 0);
                        }
                    } else {
                        DatabaseDao_Impl.AnonymousClass17.SaveableStateProvider((SaveableStateHolder) obj4, (ComposableLambdaImpl) obj3, composer3, 0);
                    }
                    return unit;
                case 3:
                    Composer composer4 = (Composer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    GapComposer gapComposer4 = (GapComposer) composer4;
                    if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 12.0f);
                        ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj4;
                        DraggableLyricsProviderItem draggableLyricsProviderItem = (DraggableLyricsProviderItem) obj3;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer4, 54);
                        int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs);
                        ComposeUiNode.Companion.getClass();
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(LayoutNode.Constructor);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m390setimpl(gapComposer4, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m389reconcileimpl(gapComposer4);
                        Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        Object objRememberedValue = gapComposer4.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = DraggableLyricsProviderListKt$DraggableLyricsProviderList$2$1$2$1$1$1$1$1.INSTANCE;
                            gapComposer4.updateRememberedValue(objRememberedValue);
                        }
                        CardKt.IconButton((Function0) objRememberedValue, Modifier.Companion.$$INSTANCE.then(new ComposedModifier(new ReorderableCollectionItemScopeImpl$draggableHandle$1(reorderableCollectionItemScopeImpl, DragGestureDetector$Press.INSTANCE, ReorderableLazyCollectionState$findTargetItem$1.INSTANCE$1, Scroller$ScrollInfo$Companion$Null$1.INSTANCE$1))), false, null, null, DialogKt.f30lambda$394851107, gapComposer4, 1572870, 60);
                        TextKt.m352TextNvy7gAk(draggableLyricsProviderItem.name, new LayoutWeightElement(1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer4, 0, 384, 126972);
                        gapComposer4.end(true);
                    } else {
                        gapComposer4.skipToGroupEnd();
                    }
                    return unit;
                case 4:
                    Composer composer5 = (Composer) obj;
                    int iIntValue2 = ((Number) obj2).intValue();
                    Map map = (Map) obj3;
                    MediaMetadata mediaMetadata = (MediaMetadata) obj4;
                    GapComposer gapComposer5 = (GapComposer) composer5;
                    if (gapComposer5.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                        List list = mediaMetadata.artists;
                        boolean zChangedInstance = gapComposer5.changedInstance(map);
                        Object objRememberedValue2 = gapComposer5.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new CallsKt$await$2$1((byte) 24, map);
                            gapComposer5.updateRememberedValue(objRememberedValue2);
                        }
                        TextKt.m352TextNvy7gAk(UtilsKt.joinByBullet(CollectionsKt.joinToString$default(list, null, null, null, (Function1) objRememberedValue2, 31), UtilsKt.makeTimeString(Long.valueOf(((long) mediaMetadata.duration) * 1000))), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                    } else {
                        gapComposer5.skipToGroupEnd();
                    }
                    return unit;
                case 5:
                    int iIntValue3 = ((Number) obj2).intValue();
                    return (GridItemSpan) ((AccountScreenKt$$ExternalSyntheticLambda5) obj4).invoke((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj, Integer.valueOf(iIntValue3), ((List) obj3).get(iIntValue3));
                default:
                    int iIntValue4 = ((Number) obj2).intValue();
                    return (GridItemSpan) ((AccountScreenKt$$ExternalSyntheticLambda5) obj4).invoke((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj, Integer.valueOf(iIntValue4), ((List) obj3).get(iIntValue4));
            }
        }

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, byte b) {
            this.$r8$classId = b;
            this.$currentEntry = obj;
            this.$this_AnimatedContent = obj2;
        }
    }

    public /* synthetic */ NavHostKt$NavHost$32(List list, MenuState menuState, CoroutineScope coroutineScope, State state, State state2, byte b) {
        this.$r8$classId = b;
        this.$transitionState = list;
        this.$backStackEntry = menuState;
        this.$saveableStateHolder = coroutineScope;
        this.$visibleEntries$delegate = state;
        this.$inPredictiveBack$delegate = state2;
    }

    public /* synthetic */ NavHostKt$NavHost$32(List list, Object obj, MutableState mutableState, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$transitionState = list;
        this.$backStackEntry = obj;
        this.$inPredictiveBack$delegate = mutableState;
        this.$saveableStateHolder = obj2;
        this.$visibleEntries$delegate = obj3;
    }
}
