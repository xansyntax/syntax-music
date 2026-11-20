package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import androidx.sqlite.SQLite;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.UrlEndpoint;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.AppNavigationKt;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.component.ItemsKt$ListItem$2$1;
import com.metrolist.music.ui.component.LinkSegment;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.NewAction;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.PlaylistType;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.metrolist.shazamkit.models.RecognitionStatus;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Handshake$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.DraggableKt$draggable$3$2$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda8 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(LazyItemScopeImpl lazyItemScopeImpl, ChartsPage.ChartSection chartSection, State state, State state2, HapticFeedback hapticFeedback, MenuState menuState, PlayerConnection playerConnection) {
        this.$r8$classId = (byte) 9;
        this.f$0 = lazyItemScopeImpl;
        this.f$6 = chartSection;
        this.f$1 = state;
        this.f$2 = state2;
        this.f$3 = hapticFeedback;
        this.f$4 = menuState;
        this.f$5 = playerConnection;
    }

    private final Object invoke$com$metrolist$music$ui$screens$AlbumScreenKt$$ExternalSyntheticLambda17(Object obj, Object obj2, Object obj3) {
        State state = (State) this.f$0;
        State state2 = (State) this.f$6;
        State state3 = (State) this.f$1;
        HapticFeedback hapticFeedback = (HapticFeedback) this.f$2;
        MenuState menuState = (MenuState) this.f$4;
        NavHostController navHostController = (NavHostController) this.f$5;
        CoroutineScope coroutineScope = (CoroutineScope) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15), gapComposer);
            boolean zChanged = gapComposer.changed(state) | gapComposer.changed(state2) | gapComposer.changed(state3) | gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | gapComposer.changedInstance(navHostController) | gapComposer.changedInstance(coroutineScope);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new NavHostKt$$ExternalSyntheticLambda12(state, (Object) hapticFeedback, (Object) menuState, (Object) navHostController, (Object) coroutineScope, (Object) state2, (Object) state3, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            IntMath.LazyRow(null, null, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue, gapComposer, 0, 507);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$ChartsScreenKt$$ExternalSyntheticLambda11(Object obj, Object obj2, Object obj3) {
        ChartsPage.ChartSection chartSection = (ChartsPage.ChartSection) this.f$0;
        State state = (State) this.f$6;
        State state2 = (State) this.f$1;
        HapticFeedback hapticFeedback = (HapticFeedback) this.f$2;
        MenuState menuState = (MenuState) this.f$4;
        PlayerConnection playerConnection = (PlayerConnection) this.f$5;
        CoroutineScope coroutineScope = (CoroutineScope) this.f$3;
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lazyItemScopeImpl.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15), gapComposer);
            Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, Modifier.Companion.$$INSTANCE);
            boolean zChangedInstance = gapComposer.changedInstance(chartSection) | gapComposer.changed(state) | gapComposer.changed(state2) | gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | gapComposer.changedInstance(playerConnection) | gapComposer.changedInstance(coroutineScope);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new NavHostKt$$ExternalSyntheticLambda12(chartSection, hapticFeedback, menuState, state, playerConnection, coroutineScope, state2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            IntMath.LazyRow(modifierAnimateItem$default, null, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue, gapComposer, 0, 506);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$ChartsScreenKt$$ExternalSyntheticLambda13(Object obj, Object obj2, Object obj3) {
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) this.f$0;
        ChartsPage.ChartSection chartSection = (ChartsPage.ChartSection) this.f$6;
        State state = (State) this.f$1;
        State state2 = (State) this.f$2;
        HapticFeedback hapticFeedback = (HapticFeedback) this.f$3;
        MenuState menuState = (MenuState) this.f$4;
        PlayerConnection playerConnection = (PlayerConnection) this.f$5;
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        boxWithConstraintsScopeImpl.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
        }
        byte b = 1;
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            float f = Dp.m795compareTo0680j_4((boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM() * 0.475f) + CropImageView.DEFAULT_ASPECT_RATIO, 320.0f) < 0 ? 0.9f : 0.475f;
            float fM118getMaxWidthD9Ej5fM = (boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM() * f) + CropImageView.DEFAULT_ASPECT_RATIO;
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
            boolean zChanged = gapComposer.changed(lazyGridStateRememberLazyGridState);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                HomeScreenKt$$ExternalSyntheticLambda21 homeScreenKt$$ExternalSyntheticLambda21 = new HomeScreenKt$$ExternalSyntheticLambda21(f, b);
                lazyGridStateRememberLazyGridState.getClass();
                objRememberedValue = new ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(lazyGridStateRememberLazyGridState, homeScreenKt$$ExternalSyntheticLambda21, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(4);
            SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior = SQLite.rememberSnapFlingBehavior((SnapLayoutInfoProvider) objRememberedValue, gapComposer);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15), gapComposer);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, SizeKt.m145height3ABfNKs(modifierFillMaxWidth, 256.0f));
            boolean zChangedInstance = gapComposer.changedInstance(chartSection) | gapComposer.changed(state) | gapComposer.changed(state2) | gapComposer.changed(fM118getMaxWidthD9Ej5fM) | gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | gapComposer.changedInstance(playerConnection);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                CheckboxKt$$ExternalSyntheticLambda4 checkboxKt$$ExternalSyntheticLambda4 = new CheckboxKt$$ExternalSyntheticLambda4(chartSection, fM118getMaxWidthD9Ej5fM, hapticFeedback, menuState, state, playerConnection, state2);
                gapComposer.updateRememberedValue(checkboxKt$$ExternalSyntheticLambda4);
                objRememberedValue2 = checkboxKt$$ExternalSyntheticLambda4;
            }
            LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierAnimateItem$default, lazyGridStateRememberLazyGridState, insetsPaddingValuesAsPaddingValues, null, null, snapFlingBehaviorRememberSnapFlingBehavior, false, null, null, (Function1) objRememberedValue2, gapComposer, 0, 1904);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$artist$ArtistScreenKt$$ExternalSyntheticLambda15(Object obj, Object obj2, Object obj3) {
        Modifier.Companion companion;
        boolean z;
        float f;
        ArrayList arrayList;
        UrlEndpoint urlEndpoint;
        String str = (String) this.f$1;
        List<Run> list = (List) this.f$2;
        String str2 = (String) this.f$3;
        String str3 = (String) this.f$4;
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$6;
        MutableState mutableState3 = (MutableState) this.f$5;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((LazyItemScopeImpl) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion2, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (!((Boolean) mutableState.getValue()).booleanValue() || ((str == null || str.length() == 0) && (list == null || list.isEmpty()))) {
                companion = companion2;
                gapComposer.startReplaceGroup(1850559898);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1850171561);
                companion = companion2;
                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.about_artist, gapComposer), OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 7), 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 1572912, 0, 131004);
                gapComposer.end(false);
            }
            if (!((Boolean) mutableState2.getValue()).booleanValue() || str2 == null || str2.length() == 0) {
                z = false;
                f = 0.0f;
                gapComposer.startReplaceGroup(1851096570);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1850709194);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                z = false;
                f = 0.0f;
                TextKt.m352TextNvy7gAk(str2, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 7), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 48, 0, 131064);
                gapComposer = gapComposer;
                gapComposer.end(false);
            }
            if (!((Boolean) mutableState3.getValue()).booleanValue() || str3 == null || str3.length() == 0) {
                gapComposer.startReplaceGroup(1852218522);
                gapComposer.end(z);
            } else {
                gapComposer.startReplaceGroup(1851260312);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                GapComposer gapComposer2 = gapComposer;
                TextKt.m352TextNvy7gAk(str3, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (!((Boolean) mutableState.getValue()).booleanValue() || str == null || str.length() == 0) ? f : 8.0f, 7), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer2, 0, 0, 131064);
                gapComposer = gapComposer2;
                gapComposer.end(z);
            }
            if (!((Boolean) mutableState.getValue()).booleanValue() || ((str == null || str.length() == 0) && (list == null || list.isEmpty()))) {
                gapComposer.startReplaceGroup(1853039898);
                gapComposer.end(z);
            } else {
                gapComposer.startReplaceGroup(1852370081);
                if (str == null) {
                    str = "";
                }
                String str4 = str;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (Run run : list) {
                        String str5 = run.text;
                        NavigationEndpoint navigationEndpoint = run.navigationEndpoint;
                        arrayList2.add(new LinkSegment(str5, (navigationEndpoint == null || (urlEndpoint = navigationEndpoint.urlEndpoint) == null) ? null : urlEndpoint.url));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                DialogKt.ExpandableText(str4, arrayList, null, gapComposer, 3072, 4);
                gapComposer.end(z);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$AutoPlaylistScreenKt$$ExternalSyntheticLambda11(Object obj, Object obj2, Object obj3) {
        List list = (List) this.f$1;
        List list2 = (List) this.f$2;
        MenuState menuState = (MenuState) this.f$3;
        Function0 function0 = (Function0) this.f$5;
        PlaylistType playlistType = (PlaylistType) this.f$4;
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$6;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zAutoPlaylistScreen$lambda$16 = TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState);
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zAutoPlaylistScreen$lambda$16) {
                gapComposer.startReplaceGroup(1649248559);
                boolean z = list.size() == list2.size() && !list.isEmpty();
                boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changedInstance(list2);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new AlbumScreenKt$$ExternalSyntheticLambda13(list, list2, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                CardKt.Checkbox(z, (Function1) objRememberedValue, null, false, null, gapComposer, 0);
                boolean z2 = !list.isEmpty();
                boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(list2) | gapComposer.changedInstance(list) | gapComposer.changed(function0) | gapComposer.changed(playlistType.ordinal());
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                    SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(menuState, list2, function0, playlistType, list);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                    objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda40;
                }
                CardKt.IconButton((Function0) objRememberedValue2, null, z2, null, null, TopPlaylistScreenKt.lambda$1954312766, gapComposer, 1572864, 58);
                gapComposer.end(false);
            } else if (((Boolean) mutableState2.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(1650989643);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1650662903);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState2, (byte) 4);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, TopPlaylistScreenKt.f402lambda$801695243, gapComposer, 1572870, 62);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$CachePlaylistScreenKt$$ExternalSyntheticLambda2(Object obj, Object obj2, Object obj3) {
        List list = (List) this.f$1;
        List list2 = (List) this.f$2;
        CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) this.f$3;
        MenuState menuState = (MenuState) this.f$4;
        Function0 function0 = (Function0) this.f$5;
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$6;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zCachePlaylistScreen$lambda$7 = TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState);
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zCachePlaylistScreen$lambda$7) {
                gapComposer.startReplaceGroup(-2142611514);
                boolean z = list.size() == list2.size() && !list.isEmpty();
                boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changedInstance(list2);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new AlbumScreenKt$$ExternalSyntheticLambda13(list, list2, (byte) 4);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                CardKt.Checkbox(z, (Function1) objRememberedValue, null, false, null, gapComposer, 0);
                boolean z2 = !list.isEmpty();
                boolean zChangedInstance2 = gapComposer.changedInstance(list2) | gapComposer.changedInstance(list) | gapComposer.changed(menuState) | gapComposer.changed(function0) | gapComposer.changedInstance(cachePlaylistViewModel);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                    SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) list2, (Object) menuState, (Object) list, (Object) function0, (Object) cachePlaylistViewModel, (byte) 20);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                    objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda40;
                }
                CardKt.IconButton((Function0) objRememberedValue2, null, z2, null, null, TopPlaylistScreenKt.lambda$1072759353, gapComposer, 1572864, 58);
                gapComposer.end(false);
            } else if (((Boolean) mutableState2.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-2140764286);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-2141044898);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState2, (byte) 6);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, TopPlaylistScreenKt.f401lambda$567006430, gapComposer, 1572870, 62);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:175:0x09d9  */
    /* JADX WARN: Code duplicated, block: B:176:0x09dd  */
    /* JADX WARN: Code duplicated, block: B:180:0x0a64  */
    /* JADX WARN: Code duplicated, block: B:183:0x0a9b  */
    /* JADX WARN: Code duplicated, block: B:184:0x0a9f  */
    /* JADX WARN: Code duplicated, block: B:187:0x0b44  */
    /* JADX WARN: Code duplicated, block: B:188:0x0b48  */
    /* JADX WARN: Code duplicated, block: B:192:0x0b7e  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z;
        MutableInteractionSourceImpl mutableInteractionSourceImpl;
        HapticFeedback hapticFeedback;
        MutableState mutableState;
        NeverEqualPolicy neverEqualPolicy;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean z2;
        Modifier modifierDrawBehind;
        boolean z3;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$0;
        Object obj5 = this.f$4;
        Object obj6 = this.f$5;
        Object obj7 = this.f$1;
        Object obj8 = this.f$2;
        Object obj9 = this.f$3;
        Object obj10 = this.f$6;
        switch (b) {
            case 0:
                MutableState mutableState2 = (MutableState) obj4;
                Song song = (Song) obj7;
                Context context = (Context) obj8;
                CoroutineScope coroutineScope = (CoroutineScope) obj9;
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                Function0 function0 = (Function0) obj6;
                MutableState mutableState3 = (MutableState) obj10;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    boolean zChanged3 = gapComposer.changed(mutableState2);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy2) {
                        objRememberedValue3 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 2);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, !((Boolean) mutableState3.getValue()).booleanValue(), null, null, null, AlbumMenuKt.lambda$975137589, gapComposer, 805306368, 506);
                    boolean zChanged4 = gapComposer.changed(song) | gapComposer.changedInstance(context) | gapComposer.changed(mutableState2) | gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(musicDatabase) | gapComposer.changed(function0);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy2) {
                        SongMenuKt$$ExternalSyntheticLambda29 songMenuKt$$ExternalSyntheticLambda29 = new SongMenuKt$$ExternalSyntheticLambda29(context, mutableState2, mutableState3, musicDatabase, song, function0, coroutineScope);
                        gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda29);
                        objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda29;
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, !((Boolean) mutableState3.getValue()).booleanValue(), null, null, null, Expect_jvmKt.rememberComposableLambda(1910660716, new QueueKt$$ExternalSyntheticLambda21(mutableState3, (byte) 13), gapComposer), gapComposer, 805306368, 506);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                List list = (List) obj4;
                String str = (String) obj10;
                Function0 function1 = (Function0) obj6;
                Function0 function2 = (Function0) obj7;
                ViewConfiguration viewConfiguration = (ViewConfiguration) obj8;
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj9;
                final Function2 function3 = (Function2) obj5;
                ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                columnScopeInstance.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(columnScopeInstance) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    OffsetKt.Spacer(gapComposer2, columnScopeInstance.weight(companion, 1.0f, true));
                    gapComposer2.startReplaceGroup(725669105);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        final Screens screens = (Screens) it.next();
                        boolean zChanged5 = gapComposer2.changed(screens.route) | gapComposer2.changed(str);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged5 || objRememberedValue5 == neverEqualPolicy2) {
                            objRememberedValue5 = Boolean.valueOf(AppNavigationKt.isRouteSelected(str, screens.route, list));
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        Boolean bool = (Boolean) objRememberedValue5;
                        boolean zBooleanValue = bool.booleanValue();
                        MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(bool, gapComposer2);
                        boolean zChanged6 = gapComposer2.changed(zBooleanValue) | gapComposer2.changed(screens);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChanged6 || objRememberedValue6 == neverEqualPolicy2) {
                            objRememberedValue6 = Integer.valueOf(zBooleanValue ? screens.iconIdActive : screens.iconIdInactive);
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        int iIntValue3 = ((Number) objRememberedValue6).intValue();
                        String str2 = str;
                        boolean z4 = screens.equals(Screens.Search.INSTANCE) && function1 != null;
                        Iterator it2 = it;
                        boolean z5 = screens.equals(Screens.Home.INSTANCE) && function2 != null;
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                        }
                        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue7;
                        if (z4 || z5) {
                            gapComposer2.startReplaceGroup(-424096650);
                            boolean zChanged7 = gapComposer2.changed(z5) | gapComposer2.changedInstance(viewConfiguration) | gapComposer2.changedInstance(hapticFeedback2) | gapComposer2.changed(function2) | gapComposer2.changed(function1) | gapComposer2.changed(function3) | gapComposer2.changed(screens) | gapComposer2.changed(mutableStateRememberUpdatedState);
                            z = z5;
                            Object objRememberedValue8 = gapComposer2.rememberedValue();
                            if (zChanged7 || objRememberedValue8 == neverEqualPolicy2) {
                                HapticFeedback hapticFeedback3 = hapticFeedback2;
                                objRememberedValue8 = new DraggableKt$draggable$3$2$1(mutableInteractionSourceImpl2, z, viewConfiguration, hapticFeedback3, function2, function1, function3, screens, mutableStateRememberUpdatedState, null, (byte) 1);
                                mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
                                hapticFeedback = hapticFeedback3;
                                mutableState = mutableStateRememberUpdatedState;
                                gapComposer2.updateRememberedValue(objRememberedValue8);
                            } else {
                                hapticFeedback = hapticFeedback2;
                                mutableState = mutableStateRememberUpdatedState;
                                mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
                            }
                            Stack.LaunchedEffect(gapComposer2, mutableInteractionSourceImpl, (Function2) objRememberedValue8);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-422939606);
                            gapComposer2.end(false);
                            hapticFeedback = hapticFeedback2;
                            mutableState = mutableStateRememberUpdatedState;
                            mutableInteractionSourceImpl = mutableInteractionSourceImpl2;
                            z = z5;
                        }
                        boolean zChanged8 = gapComposer2.changed(z4) | gapComposer2.changed(z) | gapComposer2.changed(function3) | gapComposer2.changed(screens) | gapComposer2.changed(mutableState);
                        final boolean z6 = z4;
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChanged8 || objRememberedValue9 == neverEqualPolicy2) {
                            final MutableState mutableState4 = mutableState;
                            final boolean z7 = z;
                            objRememberedValue9 = new Function0() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    if (!z6 && !z7) {
                                        Boolean bool2 = (Boolean) mutableState4.getValue();
                                        bool2.booleanValue();
                                        function3.invoke(screens, bool2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        CardKt.NavigationRailItem(zBooleanValue, (Function0) objRememberedValue9, Expect_jvmKt.rememberComposableLambda(-1252476976, new ItemsKt$$ExternalSyntheticLambda34(iIntValue3, (Object) screens, (byte) 4), gapComposer2), null, false, false, null, mutableInteractionSourceImpl, gapComposer2, 100663680);
                        it = it2;
                        hapticFeedback2 = hapticFeedback;
                        str = str2;
                    }
                    gapComposer2.end(false);
                    OffsetKt.Spacer(gapComposer2, columnScopeInstance.weight(companion, 1.0f, true));
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                String str3 = (String) obj4;
                String str4 = (String) obj10;
                String str5 = (String) obj7;
                String str6 = (String) obj9;
                Context context2 = (Context) obj8;
                Function0 function4 = (Function0) obj6;
                Function0 function5 = (Function0) obj5;
                Composer composer3 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 20.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(R.string.share_lyrics, gapComposer3);
                    FontWeight fontWeight = FontWeight.Normal;
                    long sp = IntMath.getSp(20);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, sp, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 1597440, 0, 262058);
                    OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged9 = gapComposer3.changed(str3) | gapComposer3.changed(str4) | gapComposer3.changed(str5) | gapComposer3.changed(str6) | gapComposer3.changedInstance(context2) | gapComposer3.changed(function4);
                    Object objRememberedValue10 = gapComposer3.rememberedValue();
                    if (zChanged9) {
                        neverEqualPolicy = neverEqualPolicy2;
                    } else {
                        if (objRememberedValue10 == neverEqualPolicy) {
                        }
                        neverEqualPolicy = neverEqualPolicy2;
                        Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue10, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer3, 48);
                        int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer3), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer3, 56, 4);
                        TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 12.0f, gapComposer3, R.string.share_as_text, gapComposer3), null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(16), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 24576, 0, 262122);
                        gapComposer3.end(true);
                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                        zChanged = gapComposer3.changed(function5);
                        objRememberedValue = gapComposer3.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Handshake$$ExternalSyntheticLambda0(function5, (byte) 11);
                            gapComposer3.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer3, 48);
                        int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default2);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer3), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer3, 56, 4);
                        TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 12.0f, gapComposer3, R.string.share_as_image, gapComposer3), null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(16), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 24576, 0, 262122);
                        gapComposer3.end(true);
                        Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 5);
                        RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.End, Alignment.Companion.Top, gapComposer3, 6);
                        int iHashCode4 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM139paddingqDBjuR0$default);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                        String strStringResource2 = MathKt.stringResource(R.string.cancel, gapComposer3);
                        long sp2 = IntMath.getSp(16);
                        long j = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.error;
                        FontWeight fontWeight2 = FontWeight.Medium;
                        zChanged2 = gapComposer3.changed(function4);
                        objRememberedValue2 = gapComposer3.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new Handshake$$ExternalSyntheticLambda0(function4, (byte) 12);
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        TextKt.m352TextNvy7gAk(strStringResource2, OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue2, 15), 12.0f, 8.0f), j, sp2, null, fontWeight2, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 1597440, 0, 262056);
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                    }
                    neverEqualPolicy = neverEqualPolicy2;
                    objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda73((Object) context2, (Object) function4, str3, (Object) str4, (Object) str5, (Object) str6, (byte) 5);
                    gapComposer3.updateRememberedValue(objRememberedValue10);
                    neverEqualPolicy = neverEqualPolicy2;
                    Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue10, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    Arrangement$End$1 arrangement$End$2 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement$End$2, vertical2, gapComposer3, 48);
                    int iHashCode5 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default3);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer3), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer3, 56, 4);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 12.0f, gapComposer3, R.string.share_as_text, gapComposer3), null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(16), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 24576, 0, 262122);
                    gapComposer3.end(true);
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                    zChanged = gapComposer3.changed(function5);
                    objRememberedValue = gapComposer3.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new Handshake$$ExternalSyntheticLambda0(function5, (byte) 11);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Handshake$$ExternalSyntheticLambda0(function5, (byte) 11);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM137paddingVpY3zN4$default4 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                    RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement$End$2, vertical2, gapComposer3, 48);
                    int iHashCode6 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default4);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer3), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer3, 56, 4);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 12.0f, gapComposer3, R.string.share_as_image, gapComposer3), null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(16), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 24576, 0, 262122);
                    gapComposer3.end(true);
                    Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 5);
                    RowMeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(OffsetKt.End, Alignment.Companion.Top, gapComposer3, 6);
                    int iHashCode7 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM139paddingqDBjuR0$default2);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy6, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda0);
                    String strStringResource3 = MathKt.stringResource(R.string.cancel, gapComposer3);
                    long sp3 = IntMath.getSp(16);
                    long j2 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.error;
                    FontWeight fontWeight3 = FontWeight.Medium;
                    zChanged2 = gapComposer3.changed(function4);
                    objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new Handshake$$ExternalSyntheticLambda0(function4, (byte) 12);
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Handshake$$ExternalSyntheticLambda0(function4, (byte) 12);
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource3, OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue2, 15), 12.0f, 8.0f), j2, sp3, null, fontWeight3, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 1597440, 0, 262056);
                    gapComposer3.end(true);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                Function1 function6 = (Function1) obj4;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj9;
                Function0 function7 = (Function0) obj6;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj10;
                Function1 function8 = (Function1) obj7;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj5;
                Function1 function9 = (Function1) obj8;
                Composer composer4 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    boolean zChangedInstance = gapComposer4.changedInstance(coroutineScope2) | gapComposer4.changed(function7) | gapComposer4.changed(snapshotStateList) | gapComposer4.changed(function8) | gapComposer4.changedInstance(musicDatabase2) | gapComposer4.changed(function6) | gapComposer4.changed(function9);
                    Object objRememberedValue11 = gapComposer4.rememberedValue();
                    if (zChangedInstance || objRememberedValue11 == neverEqualPolicy2) {
                        objRememberedValue11 = new SongMenuKt$$ExternalSyntheticLambda29(snapshotStateList, musicDatabase2, function7, function8, function6, function9, coroutineScope2);
                        gapComposer4.updateRememberedValue(objRememberedValue11);
                    }
                    Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue11, 15);
                    String strStringResource4 = MathKt.stringResource(R.string.liked_songs, gapComposer4);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    long j3 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal2)).colorScheme.outlineVariant;
                    long jColor = ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), 0.35f, Color.m483getColorSpaceimpl(j3));
                    BiasAlignment.Vertical vertical3 = Alignment.Companion.CenterVertically;
                    gapComposer4.startReplaceGroup(980878578);
                    gapComposer4.startReplaceGroup(342807021);
                    gapComposer4.end(false);
                    gapComposer4.startReplaceGroup(343091420);
                    Modifier modifierPressScale = DialogKt.pressScale(modifierM46clickableoSLSa3U$default, 0.985f);
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(SizeKt.m145height3ABfNKs(modifierPressScale, 64.0f), gapComposer4, 0);
                    if (UiStyleKt.isGlassStyle(gapComposer4)) {
                        gapComposer4.startReplaceGroup(343275033);
                        boolean zChanged10 = gapComposer4.changed(jColor);
                        Object objRememberedValue12 = gapComposer4.rememberedValue();
                        if (zChanged10 || objRememberedValue12 == neverEqualPolicy2) {
                            objRememberedValue12 = new ItemsKt$ListItem$2$1(jColor);
                            gapComposer4.updateRememberedValue(objRememberedValue12);
                        }
                        modifierDrawBehind = ClipKt.drawBehind(companion, (Function1) objRememberedValue12);
                        z2 = false;
                        gapComposer4.end(false);
                    } else {
                        z2 = false;
                        gapComposer4.startReplaceGroup(343633486);
                        gapComposer4.end(false);
                        modifierDrawBehind = companion;
                    }
                    Modifier modifierThen = modifierM1473hairlineBottomiJQMabo.then(modifierDrawBehind);
                    gapComposer4.end(z2);
                    gapComposer4.end(z2);
                    Modifier modifierM137paddingVpY3zN4$default5 = OffsetKt.m137paddingVpY3zN4$default(modifierThen, 14.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy7 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical3, gapComposer4, 48);
                    int iHashCode8 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM137paddingVpY3zN4$default5);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy7, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode8), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion, 6.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode9 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs2);
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode9, gapComposer4, updater$$ExternalSyntheticLambda1, gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier9, updater$$ExternalSyntheticLambda0);
                    ImageKt.Image(IntMath.painterResource(R.drawable.favorite, 0, gapComposer4), null, SizeKt.m151size3ABfNKs(companion, 40.0f), null, null, CropImageView.DEFAULT_ASPECT_RATIO, new BlendModeColorFilter(((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal2)).colorScheme.onBackground, 5), gapComposer4, 440, 56);
                    gapComposer4.startReplaceGroup(813683088);
                    gapComposer4.end(false);
                    gapComposer4.end(true);
                    Modifier modifierM137paddingVpY3zN4$default6 = OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                    int iHashCode10 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM137paddingVpY3zN4$default6);
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode10, gapComposer4, updater$$ExternalSyntheticLambda1, gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier10, updater$$ExternalSyntheticLambda0);
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal2)).typography.titleMedium;
                    gapComposer4.startReplaceGroup(-1898635093);
                    long j4 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface;
                    gapComposer4.end(false);
                    TextKt.m352TextNvy7gAk(strStringResource4, null, ((Color) SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j4, ArcSplineKt.tween$default(200, 0, null, 6), "listItemTitleColor", gapComposer4, 432, 8).getValue()).value, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer4, 0, 24960, 110586);
                    gapComposer4.startReplaceGroup(1272246816);
                    gapComposer4.end(false);
                    gapComposer4.end(true);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                MutableState mutableState5 = (MutableState) obj4;
                Function0 function10 = (Function0) obj6;
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj7;
                Function0 function11 = (Function0) obj9;
                Function0 function12 = (Function0) obj5;
                MutableState mutableState6 = (MutableState) obj10;
                Context context3 = (Context) obj8;
                Composer composer5 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    MenuKt.NewActionGrid(CollectionsKt__IterablesKt.listOf((Object[]) new NewAction[]{new NewAction(AlbumMenuKt.lambda$951325879, MathKt.stringResource(R.string.edit, gapComposer5), Expect_jvmKt.rememberComposableLambda(-1285035147, new SongMenuKt$$ExternalSyntheticLambda37(mutableState5, (byte) 6), gapComposer5)), new NewAction(AlbumMenuKt.f270lambda$860241322, MathKt.stringResource(R.string.refetch, gapComposer5), Expect_jvmKt.rememberComposableLambda(1198364948, new CrossfadeKt$$ExternalSyntheticLambda3(function10, lyricsMenuViewModel, function11, function12, (byte) 6), gapComposer5)), new NewAction(AlbumMenuKt.lambda$1623158773, MathKt.stringResource(R.string.search, gapComposer5), Expect_jvmKt.rememberComposableLambda(-613202253, new SongMenuKt$$ExternalSyntheticLambda37(mutableState6, (byte) 7), gapComposer5)), new NewAction(AlbumMenuKt.f149lambda$188408428, MathKt.stringResource(R.string.copy, gapComposer5), Expect_jvmKt.rememberComposableLambda(1870197842, new MainActivity$$ExternalSyntheticLambda1((Object) function12, (Object) context3, (byte) 16), gapComposer5))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), 4, gapComposer5, 432, 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                SongItem songItem = (SongItem) obj10;
                List list2 = (List) obj7;
                NavHostController navHostController = (NavHostController) obj8;
                Function0 function13 = (Function0) obj6;
                MutableState mutableState7 = (MutableState) obj4;
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) obj9;
                Map map = (Map) obj5;
                Composer composer6 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    Album album = songItem.album;
                    boolean z8 = album != null ? !StringsKt__StringsJVMKt.startsWith(album.id, "MPREb_", false) : false;
                    gapComposer6.startReplaceGroup(-739860228);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (list2.isEmpty() || z8) {
                        z3 = false;
                        gapComposer6.startReplaceGroup(-954385701);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(-955714764);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f117lambda$1628904144;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1842252337;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1018441522, new YouTubeSongMenuKt$$ExternalSyntheticLambda12(songItem, map, (byte) 1), gapComposer6);
                        boolean zChangedInstance2 = gapComposer6.changedInstance(list2) | gapComposer6.changedInstance(navHostController) | gapComposer6.changed(function13) | gapComposer6.changed(mutableState7);
                        Object objRememberedValue13 = gapComposer6.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue13 == neverEqualPolicy2) {
                            objRememberedValue13 = new YouTubeSongMenuKt$$ExternalSyntheticLambda28(list2, navHostController, function13, mutableState7, (byte) 0);
                            gapComposer6.updateRememberedValue(objRememberedValue13);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImplRememberComposableLambda, (Function0) objRememberedValue13, null, null, 48));
                        z3 = false;
                        gapComposer6.end(false);
                    }
                    Album album2 = songItem.album;
                    if (album2 == null) {
                        gapComposer6.startReplaceGroup(-954316851);
                        gapComposer6.end(z3);
                    } else {
                        gapComposer6.startReplaceGroup(-954316850);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1916149107, new SongMenuKt$$ExternalSyntheticLambda26((byte) 15, z8), gapComposer6);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-617601518, new SongMenuKt$$ExternalSyntheticLambda26((byte) 16, z8), gapComposer6);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(1143615153, new MainActivity$$ExternalSyntheticLambda0((byte) 11, album2), gapComposer6);
                        boolean zChanged11 = gapComposer6.changed(z8) | gapComposer6.changedInstance(navHostController) | gapComposer6.changedInstance(album2) | gapComposer6.changed(function13);
                        Object objRememberedValue14 = gapComposer6.rememberedValue();
                        if (zChanged11 || objRememberedValue14 == neverEqualPolicy2) {
                            objRememberedValue14 = new SongMenuKt$$ExternalSyntheticLambda69(z8, navHostController, album2, function13);
                            gapComposer6.updateRememberedValue(objRememberedValue14);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda2, composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, (Function0) objRememberedValue14, null, null, 48));
                        gapComposer6.end(false);
                    }
                    ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f106lambda$1539638101;
                    ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f256lambda$753287444;
                    ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$33063213;
                    boolean zChanged12 = gapComposer6.changed(function13) | gapComposer6.changed(bottomSheetPageState) | gapComposer6.changedInstance(songItem);
                    Object objRememberedValue15 = gapComposer6.rememberedValue();
                    if (zChanged12 || objRememberedValue15 == neverEqualPolicy2) {
                        objRememberedValue15 = new GapComposer$$ExternalSyntheticLambda0(function13, bottomSheetPageState, songItem, (byte) 29);
                        gapComposer6.updateRememberedValue(objRememberedValue15);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, composableLambdaImpl5, (Function0) objRememberedValue15, null, null, 48));
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer6.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer6, 0);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj10;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj9;
                Context context4 = (Context) obj8;
                String str7 = (String) obj7;
                PlayerConnection playerConnection = (PlayerConnection) obj5;
                State state = (State) obj6;
                MutableState mutableState8 = (MutableState) obj4;
                Composer composer7 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer7, 48);
                    int iHashCode11 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope11 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier11 = ZIndexModifierKt.materializeModifier(gapComposer7, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope11, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode11), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier11, updater$$ExternalSyntheticLambda0);
                    String strPluralStringResource = MathKt.pluralStringResource(R.plurals.minute, MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()), new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()))}, gapComposer7);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strPluralStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal3)).typography.bodyLarge, gapComposer7, 0, 0, 131070);
                    GapComposer gapComposer8 = gapComposer7;
                    OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                    ClosedFloatRange closedFloatRange = new ClosedFloatRange(5.0f, 120.0f);
                    Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                    Object objRememberedValue16 = gapComposer8.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 5);
                        gapComposer8.updateRememberedValue(objRememberedValue16);
                    }
                    SliderKt.Slider(floatValue, (Function1) objRememberedValue16, modifierFillMaxWidth4, false, closedFloatRange, 22, null, null, gapComposer8, 197040, 456);
                    OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer8, 54);
                    int iHashCode12 = Long.hashCode(gapComposer8.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope12 = gapComposer8.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier12 = ZIndexModifierKt.materializeModifier(gapComposer8, companion);
                    gapComposer8.startReusableNode();
                    if (gapComposer8.inserting) {
                        gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer8.useNode();
                    }
                    Stack.m390setimpl(gapComposer8, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope12, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode12, gapComposer8, updater$$ExternalSyntheticLambda1, gapComposer8);
                    Stack.m390setimpl(gapComposer8, modifierMaterializeModifier12, updater$$ExternalSyntheticLambda0);
                    if (((Boolean) state.getValue()).booleanValue()) {
                        gapComposer8.startReplaceGroup(495514606);
                        boolean zChangedInstance3 = gapComposer8.changedInstance(coroutineScope3) | gapComposer8.changedInstance(context4) | gapComposer8.changed(str7);
                        Object objRememberedValue17 = gapComposer8.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue17 == neverEqualPolicy2) {
                            objRememberedValue17 = new PlayerKt$$ExternalSyntheticLambda2(coroutineScope3, context4, str7, parcelableSnapshotMutableFloatState, (byte) 2);
                            gapComposer8.updateRememberedValue(objRememberedValue17);
                        }
                        PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                        gapComposer8 = gapComposer8;
                        CardKt.Button((Function0) objRememberedValue17, null, false, null, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).colorScheme.primary, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).colorScheme.onPrimary, 0L, gapComposer8, 12), null, null, null, null, QueueKt.f294lambda$56133041, gapComposer8, 805306368, 494);
                        gapComposer8.end(false);
                    } else {
                        gapComposer8.startReplaceGroup(496891130);
                        boolean zChangedInstance4 = gapComposer8.changedInstance(coroutineScope3) | gapComposer8.changedInstance(context4) | gapComposer8.changed(str7);
                        Object objRememberedValue18 = gapComposer8.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue18 == neverEqualPolicy2) {
                            objRememberedValue18 = new PlayerKt$$ExternalSyntheticLambda2(coroutineScope3, context4, str7, parcelableSnapshotMutableFloatState, (byte) 3);
                            gapComposer8.updateRememberedValue(objRememberedValue18);
                        }
                        CardKt.OutlinedButton((Function0) objRememberedValue18, null, false, null, null, null, null, QueueKt.f290lambda$1741163686, gapComposer8, 805306368, 510);
                        gapComposer8.end(false);
                    }
                    boolean zChangedInstance5 = gapComposer8.changedInstance(playerConnection);
                    Object objRememberedValue19 = gapComposer8.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue19 == neverEqualPolicy2) {
                        objRememberedValue19 = new PlayerKt$$ExternalSyntheticLambda4(playerConnection, mutableState8, (byte) 1);
                        gapComposer8.updateRememberedValue(objRememberedValue19);
                    }
                    CardKt.OutlinedButton((Function0) objRememberedValue19, null, false, null, null, null, null, QueueKt.f289lambda$1566138954, gapComposer8, 805306368, 510);
                    gapComposer8.end(true);
                    gapComposer8.end(true);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                return invoke$com$metrolist$music$ui$screens$AlbumScreenKt$$ExternalSyntheticLambda17(obj, obj2, obj3);
            case 8:
                return invoke$com$metrolist$music$ui$screens$ChartsScreenKt$$ExternalSyntheticLambda11(obj, obj2, obj3);
            case 9:
                return invoke$com$metrolist$music$ui$screens$ChartsScreenKt$$ExternalSyntheticLambda13(obj, obj2, obj3);
            case 10:
                return invoke$com$metrolist$music$ui$screens$artist$ArtistScreenKt$$ExternalSyntheticLambda15(obj, obj2, obj3);
            case 11:
                return invoke$com$metrolist$music$ui$screens$playlist$AutoPlaylistScreenKt$$ExternalSyntheticLambda11(obj, obj2, obj3);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$ui$screens$playlist$CachePlaylistScreenKt$$ExternalSyntheticLambda2(obj, obj2, obj3);
            default:
                State state2 = (State) obj10;
                CoroutineScope coroutineScope4 = (CoroutineScope) obj9;
                Context context5 = (Context) obj8;
                ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj7;
                NavHostController navHostController2 = (NavHostController) obj6;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj5;
                MutableState mutableState9 = (MutableState) obj4;
                PaddingValues paddingValues = (PaddingValues) obj;
                Composer composer8 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                paddingValues.getClass();
                if ((iIntValue9 & 6) == 0) {
                    iIntValue9 |= ((GapComposer) composer8).changed(paddingValues) ? 4 : 2;
                }
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 19) != 18)) {
                    Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues), 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterHorizontally, gapComposer9, 54);
                    int iHashCode13 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope13 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier13 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierM135padding3ABfNKs3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, columnMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope13, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer9, Integer.valueOf(iHashCode13), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier13, updater$$ExternalSyntheticLambda0);
                    RecognitionStatus recognitionStatus = (RecognitionStatus) state2.getValue();
                    Object objRememberedValue20 = gapComposer9.rememberedValue();
                    if (objRememberedValue20 == neverEqualPolicy2) {
                        objRememberedValue20 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 23);
                        gapComposer9.updateRememberedValue(objRememberedValue20);
                    }
                    CrossfadeKt.AnimatedContent(recognitionStatus, null, (Function1) objRememberedValue20, null, "recognition_content", null, Expect_jvmKt.rememberComposableLambda(1032657113, new RecognitionScreenKt$$ExternalSyntheticLambda6(coroutineScope4, context5, managedActivityResultLauncher, navHostController2, musicDatabase3, mutableState9, (byte) 0), gapComposer9), gapComposer9, RecognitionStatus.$stable | 1597824, 42);
                    gapComposer9.end(true);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(Context context, MutableState mutableState, MutableState mutableState2, MusicDatabase musicDatabase, Song song, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 0;
        this.f$0 = mutableState;
        this.f$1 = song;
        this.f$2 = context;
        this.f$3 = coroutineScope;
        this.f$4 = musicDatabase;
        this.f$5 = function0;
        this.f$6 = mutableState2;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(MutableState mutableState, Function0 function0, LyricsMenuViewModel lyricsMenuViewModel, Function0 function1, Function0 function2, MutableState mutableState2, Context context) {
        this.$r8$classId = (byte) 4;
        this.f$0 = mutableState;
        this.f$5 = function0;
        this.f$1 = lyricsMenuViewModel;
        this.f$3 = function1;
        this.f$4 = function2;
        this.f$6 = mutableState2;
        this.f$2 = context;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(MutableState mutableState, CoroutineScope coroutineScope, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, MusicDatabase musicDatabase, MutableState mutableState2) {
        this.$r8$classId = (byte) 13;
        this.f$6 = mutableState;
        this.f$3 = coroutineScope;
        this.f$2 = context;
        this.f$1 = managedActivityResultLauncher;
        this.f$5 = navHostController;
        this.f$4 = musicDatabase;
        this.f$0 = mutableState2;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, CoroutineScope coroutineScope, Context context, String str, PlayerConnection playerConnection, State state, MutableState mutableState) {
        this.$r8$classId = (byte) 6;
        this.f$6 = parcelableSnapshotMutableFloatState;
        this.f$3 = coroutineScope;
        this.f$2 = context;
        this.f$1 = str;
        this.f$4 = playerConnection;
        this.f$5 = state;
        this.f$0 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(SnapshotStateList snapshotStateList, MusicDatabase musicDatabase, Function0 function0, Function1 function1, Function1 function2, Function1 function3, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 3;
        this.f$0 = function1;
        this.f$3 = coroutineScope;
        this.f$5 = function0;
        this.f$6 = snapshotStateList;
        this.f$1 = function2;
        this.f$4 = musicDatabase;
        this.f$2 = function3;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(SongItem songItem, List list, NavHostController navHostController, Function0 function0, MutableState mutableState, BottomSheetPageState bottomSheetPageState, Map map) {
        this.$r8$classId = (byte) 5;
        this.f$6 = songItem;
        this.f$1 = list;
        this.f$2 = navHostController;
        this.f$5 = function0;
        this.f$0 = mutableState;
        this.f$3 = bottomSheetPageState;
        this.f$4 = map;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(Object obj, State state, State state2, HapticFeedback hapticFeedback, MenuState menuState, Object obj2, CoroutineScope coroutineScope, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$6 = state;
        this.f$1 = state2;
        this.f$2 = hapticFeedback;
        this.f$4 = menuState;
        this.f$5 = obj2;
        this.f$3 = coroutineScope;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(String str, String str2, String str3, String str4, Context context, Function0 function0, Function0 function1) {
        this.$r8$classId = (byte) 2;
        this.f$0 = str;
        this.f$6 = str2;
        this.f$1 = str3;
        this.f$3 = str4;
        this.f$2 = context;
        this.f$5 = function0;
        this.f$4 = function1;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(String str, List list, String str2, String str3, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 10;
        this.f$1 = str;
        this.f$2 = list;
        this.f$3 = str2;
        this.f$4 = str3;
        this.f$0 = mutableState;
        this.f$6 = mutableState2;
        this.f$5 = mutableState3;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(List list, String str, Function0 function0, Function0 function1, ViewConfiguration viewConfiguration, HapticFeedback hapticFeedback, Function2 function2) {
        this.$r8$classId = (byte) 1;
        this.f$0 = list;
        this.f$6 = str;
        this.f$5 = function0;
        this.f$1 = function1;
        this.f$2 = viewConfiguration;
        this.f$3 = hapticFeedback;
        this.f$4 = function2;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(List list, List list2, MenuState menuState, Function0 function0, PlaylistType playlistType, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = (byte) 11;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$3 = menuState;
        this.f$5 = function0;
        this.f$4 = playlistType;
        this.f$0 = mutableState;
        this.f$6 = mutableState2;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda8(List list, List list2, CachePlaylistViewModel cachePlaylistViewModel, MenuState menuState, Function0 function0, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = (byte) 12;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$3 = cachePlaylistViewModel;
        this.f$4 = menuState;
        this.f$5 = function0;
        this.f$0 = mutableState;
        this.f$6 = mutableState2;
    }
}
