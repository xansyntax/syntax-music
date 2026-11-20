package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.pager.DefaultPagerState;
import androidx.compose.foundation.pager.PagerScopeImpl;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
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
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.sqlite.SQLite;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ExplorePage;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.models.SimilarRecommendation;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda25;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.player.ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda6 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LazyGridState f$0;
    public final /* synthetic */ LazyGridState f$1;
    public final /* synthetic */ State f$10;
    public final /* synthetic */ List f$11;
    public final /* synthetic */ List f$12;
    public final /* synthetic */ MutableState f$13;
    public final /* synthetic */ State f$14;
    public final /* synthetic */ boolean f$15;
    public final /* synthetic */ CoroutineScope f$16;
    public final /* synthetic */ PlayerConnection f$17;
    public final /* synthetic */ MutableState f$18;
    public final /* synthetic */ MusicDatabase f$19;
    public final /* synthetic */ LazyListState f$2;
    public final /* synthetic */ State f$20;
    public final /* synthetic */ State f$21;
    public final /* synthetic */ HapticFeedback f$22;
    public final /* synthetic */ MenuState f$23;
    public final /* synthetic */ State f$24;
    public final /* synthetic */ MutableState f$25;
    public final /* synthetic */ InsetsPaddingValues f$26;
    public final /* synthetic */ MutableState f$27;
    public final /* synthetic */ MutableState f$28;
    public final /* synthetic */ MutableState f$29;
    public final /* synthetic */ HomeViewModel f$3;
    public final /* synthetic */ float f$30;
    public final /* synthetic */ MutableState f$31;
    public final /* synthetic */ State f$32;
    public final /* synthetic */ String f$33;
    public final /* synthetic */ MutableState f$34;
    public final /* synthetic */ MutableState f$35;
    public final /* synthetic */ MutableState f$36;
    public final /* synthetic */ State f$37;
    public final /* synthetic */ State f$38;
    public final /* synthetic */ ComposableLambdaImpl f$39;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ MutableState f$40;
    public final /* synthetic */ ComposableLambdaImpl f$41;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ MutableState f$6;
    public final /* synthetic */ PaddingValuesImpl f$7;
    public final /* synthetic */ State f$8;
    public final /* synthetic */ NavHostController f$9;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda6(LazyGridState lazyGridState, LazyGridState lazyGridState2, LazyListState lazyListState, HomeViewModel homeViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, PaddingValuesImpl paddingValuesImpl, State state, NavHostController navHostController, State state2, List list, List list2, MutableState mutableState4, State state3, boolean z, CoroutineScope coroutineScope, PlayerConnection playerConnection, MutableState mutableState5, MusicDatabase musicDatabase, State state4, State state5, HapticFeedback hapticFeedback, MenuState menuState, State state6, MutableState mutableState6, InsetsPaddingValues insetsPaddingValues, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, float f, MutableState mutableState10, State state7, String str, MutableState mutableState11, MutableState mutableState12, MutableState mutableState13, State state8, State state9, ComposableLambdaImpl composableLambdaImpl, MutableState mutableState14, ComposableLambdaImpl composableLambdaImpl2, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyGridState;
        this.f$1 = lazyGridState2;
        this.f$2 = lazyListState;
        this.f$3 = homeViewModel;
        this.f$4 = mutableState;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
        this.f$7 = paddingValuesImpl;
        this.f$8 = state;
        this.f$9 = navHostController;
        this.f$10 = state2;
        this.f$11 = list;
        this.f$12 = list2;
        this.f$13 = mutableState4;
        this.f$14 = state3;
        this.f$15 = z;
        this.f$16 = coroutineScope;
        this.f$17 = playerConnection;
        this.f$18 = mutableState5;
        this.f$19 = musicDatabase;
        this.f$20 = state4;
        this.f$21 = state5;
        this.f$22 = hapticFeedback;
        this.f$23 = menuState;
        this.f$24 = state6;
        this.f$25 = mutableState6;
        this.f$26 = insetsPaddingValues;
        this.f$27 = mutableState7;
        this.f$28 = mutableState8;
        this.f$29 = mutableState9;
        this.f$30 = f;
        this.f$31 = mutableState10;
        this.f$32 = state7;
        this.f$33 = str;
        this.f$34 = mutableState11;
        this.f$35 = mutableState12;
        this.f$36 = mutableState13;
        this.f$37 = state8;
        this.f$38 = state9;
        this.f$39 = composableLambdaImpl;
        this.f$40 = mutableState14;
        this.f$41 = composableLambdaImpl2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4;
        NeverEqualPolicy neverEqualPolicy;
        NavHostController navHostController;
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl;
        MusicDatabase musicDatabase;
        boolean z;
        CoroutineScope coroutineScope;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    OffsetKt.BoxWithConstraints(SizeKt.FillWholeMaxSize, Alignment.Companion.TopStart, Expect_jvmKt.rememberComposableLambda(1666475045, new HomeScreenKt$$ExternalSyntheticLambda6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, this.f$18, this.f$19, this.f$20, this.f$21, this.f$22, this.f$23, this.f$24, this.f$25, this.f$26, this.f$27, this.f$28, this.f$29, this.f$30, this.f$31, this.f$32, this.f$33, this.f$34, this.f$35, this.f$36, this.f$37, this.f$38, this.f$39, this.f$40, this.f$41, (byte) 1), gapComposer), gapComposer, 3126, 4);
                }
                break;
            default:
                final BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl2 = (BoxWithConstraintsScopeImpl) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl2.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(boxWithConstraintsScopeImpl2) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    float f = Dp.m795compareTo0680j_4((boxWithConstraintsScopeImpl2.m118getMaxWidthD9Ej5fM() * 0.475f) + CropImageView.DEFAULT_ASPECT_RATIO, 320.0f) < 0 ? 0.9f : 0.475f;
                    final float fM118getMaxWidthD9Ej5fM = (boxWithConstraintsScopeImpl2.m118getMaxWidthD9Ej5fM() * f) + CropImageView.DEFAULT_ASPECT_RATIO;
                    final LazyGridState lazyGridState = this.f$0;
                    boolean zChanged = gapComposer2.changed(lazyGridState);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    if (zChanged || objRememberedValue == neverEqualPolicy2) {
                        HomeScreenKt$$ExternalSyntheticLambda21 homeScreenKt$$ExternalSyntheticLambda21 = new HomeScreenKt$$ExternalSyntheticLambda21(f, (byte) 0);
                        lazyGridState.getClass();
                        objRememberedValue = new ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(lazyGridState, homeScreenKt$$ExternalSyntheticLambda21, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    final SnapLayoutInfoProvider snapLayoutInfoProvider = (SnapLayoutInfoProvider) objRememberedValue;
                    final LazyGridState lazyGridState2 = this.f$1;
                    boolean zChanged2 = gapComposer2.changed(lazyGridState2);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy2) {
                        HomeScreenKt$$ExternalSyntheticLambda21 homeScreenKt$$ExternalSyntheticLambda22 = new HomeScreenKt$$ExternalSyntheticLambda21(f, (byte) 2);
                        lazyGridState2.getClass();
                        ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 = new ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(lazyGridState2, homeScreenKt$$ExternalSyntheticLambda22, (byte) 1);
                        gapComposer2.updateRememberedValue(thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2);
                        objRememberedValue2 = thumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2;
                    }
                    final SnapLayoutInfoProvider snapLayoutInfoProvider2 = (SnapLayoutInfoProvider) objRememberedValue2;
                    InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer2);
                    final MutableState mutableState = this.f$4;
                    boolean zChanged3 = gapComposer2.changed(mutableState);
                    final MutableState mutableState2 = this.f$5;
                    boolean zChanged4 = zChanged3 | gapComposer2.changed(mutableState2);
                    final HomeViewModel homeViewModel = this.f$3;
                    boolean zChangedInstance = zChanged4 | gapComposer2.changedInstance(homeViewModel);
                    final MutableState mutableState3 = this.f$6;
                    boolean zChanged5 = zChangedInstance | gapComposer2.changed(mutableState3);
                    final PaddingValuesImpl paddingValuesImpl = this.f$7;
                    boolean zChanged6 = zChanged5 | gapComposer2.changed(paddingValuesImpl);
                    final State state = this.f$8;
                    boolean zChanged7 = zChanged6 | gapComposer2.changed(state);
                    final NavHostController navHostController2 = this.f$9;
                    boolean zChangedInstance2 = zChanged7 | gapComposer2.changedInstance(navHostController2);
                    final State state2 = this.f$10;
                    boolean zChanged8 = zChangedInstance2 | gapComposer2.changed(state2);
                    int i = iIntValue2;
                    final List list = this.f$11;
                    boolean zChangedInstance3 = zChanged8 | gapComposer2.changedInstance(list);
                    final List list2 = this.f$12;
                    boolean zChangedInstance4 = zChangedInstance3 | gapComposer2.changedInstance(list2);
                    final MutableState mutableState4 = this.f$13;
                    boolean zChanged9 = zChangedInstance4 | gapComposer2.changed(mutableState4);
                    int i2 = i & 14;
                    boolean z2 = (i2 == 4) | zChanged9;
                    final State state3 = this.f$14;
                    boolean zChanged10 = z2 | gapComposer2.changed(state3);
                    final boolean z3 = this.f$15;
                    boolean zChanged11 = zChanged10 | gapComposer2.changed(z3);
                    final CoroutineScope coroutineScope2 = this.f$16;
                    boolean zChangedInstance5 = zChanged11 | gapComposer2.changedInstance(coroutineScope2);
                    final PlayerConnection playerConnection = this.f$17;
                    boolean zChangedInstance6 = zChangedInstance5 | gapComposer2.changedInstance(playerConnection);
                    final MutableState mutableState5 = this.f$18;
                    boolean zChanged12 = zChangedInstance6 | gapComposer2.changed(mutableState5);
                    final MusicDatabase musicDatabase2 = this.f$19;
                    boolean zChangedInstance7 = zChanged12 | gapComposer2.changedInstance(musicDatabase2);
                    final State state4 = this.f$20;
                    boolean zChanged13 = zChangedInstance7 | gapComposer2.changed(state4);
                    final State state5 = this.f$21;
                    boolean zChanged14 = zChanged13 | gapComposer2.changed(state5);
                    final HapticFeedback hapticFeedback = this.f$22;
                    boolean zChangedInstance8 = zChanged14 | gapComposer2.changedInstance(hapticFeedback);
                    final MenuState menuState = this.f$23;
                    boolean zChanged15 = zChangedInstance8 | gapComposer2.changed(menuState);
                    final State state6 = this.f$24;
                    boolean zChanged16 = zChanged15 | gapComposer2.changed(state6);
                    final MutableState mutableState6 = this.f$25;
                    boolean zChanged17 = zChanged16 | gapComposer2.changed(mutableState6) | gapComposer2.changedInstance(snapLayoutInfoProvider) | gapComposer2.changed(lazyGridState);
                    final InsetsPaddingValues insetsPaddingValues = this.f$26;
                    boolean zChanged18 = zChanged17 | gapComposer2.changed(insetsPaddingValues) | gapComposer2.changed(fM118getMaxWidthD9Ej5fM);
                    final MutableState mutableState7 = this.f$27;
                    boolean zChanged19 = zChanged18 | gapComposer2.changed(mutableState7);
                    final MutableState mutableState8 = this.f$28;
                    boolean zChanged20 = zChanged19 | gapComposer2.changed(mutableState8);
                    final MutableState mutableState9 = this.f$29;
                    boolean zChanged21 = zChanged20 | gapComposer2.changed(mutableState9);
                    final float f2 = this.f$30;
                    boolean zChanged22 = zChanged21 | gapComposer2.changed(f2);
                    final MutableState mutableState10 = this.f$31;
                    boolean zChanged23 = zChanged22 | gapComposer2.changed(mutableState10);
                    final State state7 = this.f$32;
                    boolean zChanged24 = zChanged23 | gapComposer2.changed(state7);
                    final String str = this.f$33;
                    boolean zChanged25 = zChanged24 | gapComposer2.changed(str);
                    final MutableState mutableState11 = this.f$34;
                    boolean zChanged26 = zChanged25 | gapComposer2.changed(mutableState11) | gapComposer2.changedInstance(snapLayoutInfoProvider2) | gapComposer2.changed(lazyGridState2);
                    final MutableState mutableState12 = this.f$35;
                    boolean zChanged27 = zChanged26 | gapComposer2.changed(mutableState12);
                    final MutableState mutableState13 = this.f$36;
                    boolean zChanged28 = zChanged27 | gapComposer2.changed(mutableState13);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged28 || objRememberedValue3 == neverEqualPolicy2) {
                        final ComposableLambdaImpl composableLambdaImpl = this.f$39;
                        final MutableState mutableState14 = this.f$40;
                        final ComposableLambdaImpl composableLambdaImpl2 = this.f$41;
                        neverEqualPolicy = neverEqualPolicy2;
                        obj4 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda23
                            /* JADX WARN: Code duplicated, block: B:117:0x03dd  */
                            /* JADX WARN: Code duplicated, block: B:129:0x0432  */
                            /* JADX WARN: Code duplicated, block: B:53:0x019c  */
                            /* JADX WARN: Code duplicated, block: B:54:0x01a0  */
                            /* JADX WARN: Code duplicated, block: B:56:0x01a3  */
                            /* JADX WARN: Code duplicated, block: B:84:0x0309  */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                MutableState mutableState15;
                                MutableState mutableState16;
                                byte b2;
                                final byte b3;
                                final byte b4;
                                String str2;
                                ComposableLambdaImpl composableLambdaImpl3;
                                ExplorePage explorePage;
                                String str3;
                                boolean z4;
                                String str4;
                                final ComposableLambdaImpl composableLambdaImpl4;
                                PaddingValuesImpl paddingValuesImpl2;
                                ComposableLambdaImpl composableLambdaImpl5;
                                final List list3;
                                String str5;
                                byte b5;
                                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj5;
                                lazyListIntervalContent.getClass();
                                final HomeViewModel homeViewModel2 = homeViewModel;
                                MutableState mutableState17 = mutableState;
                                MutableState mutableState18 = mutableState2;
                                byte b6 = 1;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 258200880, new PlayerKt$$ExternalSyntheticLambda82(homeViewModel2, mutableState17, mutableState18, (byte) 9)), 3);
                                MutableState mutableState19 = mutableState3;
                                boolean zBooleanValue = ((Boolean) mutableState19.getValue()).booleanValue();
                                final PaddingValuesImpl paddingValuesImpl3 = paddingValuesImpl;
                                if (zBooleanValue) {
                                    HomePage homePage = (HomePage) mutableState17.getValue();
                                    List list4 = homePage != null ? homePage.chips : null;
                                    if (list4 == null || list4.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "chips_shimmer", null, new ComposableLambdaImpl(true, 369607925, new HomeScreenKt$$ExternalSyntheticLambda37(paddingValuesImpl3, (byte) 0)), 2);
                                    }
                                }
                                HomePage.Chip chip = (HomePage.Chip) mutableState18.getValue();
                                List list5 = list2;
                                final NavHostController navHostController3 = navHostController2;
                                final ComposableLambdaImpl composableLambdaImpl6 = composableLambdaImpl;
                                String str6 = "Podcast";
                                if (chip == null || (str5 = chip.title) == null || !StringsKt.contains(str5, "Podcast", true)) {
                                    mutableState19 = mutableState19;
                                    mutableState15 = mutableState17;
                                    mutableState16 = mutableState18;
                                    b2 = 1;
                                } else {
                                    final State state8 = state;
                                    if (((List) state8.getValue()).isEmpty()) {
                                        b5 = 2;
                                    } else {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "00_your_shows_title", null, new ComposableLambdaImpl(true, 1332502627, new HomeScreenKt$$ExternalSyntheticLambda43(navHostController3, b6)), 2);
                                        final byte b7 = 0;
                                        b5 = 2;
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "00_your_shows_list", null, new ComposableLambdaImpl(true, 321274892, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda47
                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj6, Object obj7, Object obj8) {
                                                byte b8 = b7;
                                                Unit unit2 = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                final ComposableLambdaImpl composableLambdaImpl7 = composableLambdaImpl6;
                                                final State state9 = state8;
                                                Object[] objArr = 0;
                                                final byte b9 = 1;
                                                switch (b8) {
                                                    case 0:
                                                        Composer composer3 = (Composer) obj7;
                                                        int iIntValue3 = ((Integer) obj8).intValue();
                                                        ((LazyItemScopeImpl) obj6).getClass();
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            boolean zChanged29 = gapComposer3.changed(state9);
                                                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                            if (zChanged29 || objRememberedValue4 == neverEqualPolicy3) {
                                                                objRememberedValue4 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda68
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj9) {
                                                                        byte b10 = b9;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        ComposableLambdaImpl composableLambdaImpl8 = composableLambdaImpl7;
                                                                        State state10 = state9;
                                                                        LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj9;
                                                                        switch (b10) {
                                                                            case 0:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list6 = (List) state10.getValue();
                                                                                HashSet hashSet = new HashSet();
                                                                                ArrayList arrayList = new ArrayList();
                                                                                for (Object obj10 : list6) {
                                                                                    if (hashSet.add(((SongItem) obj10).id)) {
                                                                                        arrayList.add(obj10);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 27), arrayList, (byte) 5), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 12), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList, composableLambdaImpl8, (byte) 1)));
                                                                                break;
                                                                            default:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list7 = (List) state10.getValue();
                                                                                HashSet hashSet2 = new HashSet();
                                                                                ArrayList arrayList2 = new ArrayList();
                                                                                for (Object obj11 : list7) {
                                                                                    if (hashSet2.add(((PodcastItem) obj11).id)) {
                                                                                        arrayList2.add(obj11);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 19), arrayList2, (byte) 4), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList2, (byte) 11), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList2, composableLambdaImpl8, (byte) 0)));
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer3.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            IntMath.LazyRow(null, null, paddingValuesImpl3, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer3, 0, 507);
                                                        }
                                                        break;
                                                    default:
                                                        Composer composer4 = (Composer) obj7;
                                                        int iIntValue4 = ((Integer) obj8).intValue();
                                                        ((LazyItemScopeImpl) obj6).getClass();
                                                        GapComposer gapComposer4 = (GapComposer) composer4;
                                                        if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                            gapComposer4.skipToGroupEnd();
                                                        } else {
                                                            boolean zChanged30 = gapComposer4.changed(state9);
                                                            Object objRememberedValue5 = gapComposer4.rememberedValue();
                                                            if (zChanged30 || objRememberedValue5 == neverEqualPolicy3) {
                                                                final Object[] objArr2 = objArr == true ? 1 : 0;
                                                                objRememberedValue5 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda68
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj9) {
                                                                        byte b10 = objArr2;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        ComposableLambdaImpl composableLambdaImpl8 = composableLambdaImpl7;
                                                                        State state10 = state9;
                                                                        LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj9;
                                                                        switch (b10) {
                                                                            case 0:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list6 = (List) state10.getValue();
                                                                                HashSet hashSet = new HashSet();
                                                                                ArrayList arrayList = new ArrayList();
                                                                                for (Object obj10 : list6) {
                                                                                    if (hashSet.add(((SongItem) obj10).id)) {
                                                                                        arrayList.add(obj10);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 27), arrayList, (byte) 5), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 12), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList, composableLambdaImpl8, (byte) 1)));
                                                                                break;
                                                                            default:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list7 = (List) state10.getValue();
                                                                                HashSet hashSet2 = new HashSet();
                                                                                ArrayList arrayList2 = new ArrayList();
                                                                                for (Object obj11 : list7) {
                                                                                    if (hashSet2.add(((PodcastItem) obj11).id)) {
                                                                                        arrayList2.add(obj11);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 19), arrayList2, (byte) 4), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList2, (byte) 11), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList2, composableLambdaImpl8, (byte) 0)));
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer4.updateRememberedValue(objRememberedValue5);
                                                            }
                                                            IntMath.LazyRow(null, null, paddingValuesImpl3, null, null, null, false, null, (Function1) objRememberedValue5, gapComposer4, 0, 507);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }), 2);
                                    }
                                    final State state9 = state2;
                                    if (!((List) state9.getValue()).isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "00_episodes_for_later_title", null, new ComposableLambdaImpl(true, -2057628148, new HomeScreenKt$$ExternalSyntheticLambda43(navHostController3, b5)), 2);
                                        final byte b8 = 1;
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "00_episodes_for_later_list", null, new ComposableLambdaImpl(true, 1110094709, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda47
                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj6, Object obj7, Object obj8) {
                                                byte b9 = b8;
                                                Unit unit2 = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                final ComposableLambdaImpl composableLambdaImpl7 = composableLambdaImpl6;
                                                final State state10 = state9;
                                                Object[] objArr = 0;
                                                final byte b10 = 1;
                                                switch (b9) {
                                                    case 0:
                                                        Composer composer3 = (Composer) obj7;
                                                        int iIntValue3 = ((Integer) obj8).intValue();
                                                        ((LazyItemScopeImpl) obj6).getClass();
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            boolean zChanged29 = gapComposer3.changed(state10);
                                                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                            if (zChanged29 || objRememberedValue4 == neverEqualPolicy3) {
                                                                objRememberedValue4 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda68
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj9) {
                                                                        byte b11 = b10;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        ComposableLambdaImpl composableLambdaImpl8 = composableLambdaImpl7;
                                                                        State state11 = state10;
                                                                        LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj9;
                                                                        switch (b11) {
                                                                            case 0:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list6 = (List) state11.getValue();
                                                                                HashSet hashSet = new HashSet();
                                                                                ArrayList arrayList = new ArrayList();
                                                                                for (Object obj10 : list6) {
                                                                                    if (hashSet.add(((SongItem) obj10).id)) {
                                                                                        arrayList.add(obj10);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 27), arrayList, (byte) 5), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 12), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList, composableLambdaImpl8, (byte) 1)));
                                                                                break;
                                                                            default:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list7 = (List) state11.getValue();
                                                                                HashSet hashSet2 = new HashSet();
                                                                                ArrayList arrayList2 = new ArrayList();
                                                                                for (Object obj11 : list7) {
                                                                                    if (hashSet2.add(((PodcastItem) obj11).id)) {
                                                                                        arrayList2.add(obj11);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 19), arrayList2, (byte) 4), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList2, (byte) 11), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList2, composableLambdaImpl8, (byte) 0)));
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer3.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            IntMath.LazyRow(null, null, paddingValuesImpl3, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer3, 0, 507);
                                                        }
                                                        break;
                                                    default:
                                                        Composer composer4 = (Composer) obj7;
                                                        int iIntValue4 = ((Integer) obj8).intValue();
                                                        ((LazyItemScopeImpl) obj6).getClass();
                                                        GapComposer gapComposer4 = (GapComposer) composer4;
                                                        if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                            gapComposer4.skipToGroupEnd();
                                                        } else {
                                                            boolean zChanged30 = gapComposer4.changed(state10);
                                                            Object objRememberedValue5 = gapComposer4.rememberedValue();
                                                            if (zChanged30 || objRememberedValue5 == neverEqualPolicy3) {
                                                                final byte objArr2 = objArr == true ? 1 : 0;
                                                                objRememberedValue5 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda68
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj9) {
                                                                        byte b11 = objArr2;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        ComposableLambdaImpl composableLambdaImpl8 = composableLambdaImpl7;
                                                                        State state11 = state10;
                                                                        LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj9;
                                                                        switch (b11) {
                                                                            case 0:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list6 = (List) state11.getValue();
                                                                                HashSet hashSet = new HashSet();
                                                                                ArrayList arrayList = new ArrayList();
                                                                                for (Object obj10 : list6) {
                                                                                    if (hashSet.add(((SongItem) obj10).id)) {
                                                                                        arrayList.add(obj10);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 27), arrayList, (byte) 5), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 12), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList, composableLambdaImpl8, (byte) 1)));
                                                                                break;
                                                                            default:
                                                                                lazyListIntervalContent2.getClass();
                                                                                List list7 = (List) state11.getValue();
                                                                                HashSet hashSet2 = new HashSet();
                                                                                ArrayList arrayList2 = new ArrayList();
                                                                                for (Object obj11 : list7) {
                                                                                    if (hashSet2.add(((PodcastItem) obj11).id)) {
                                                                                        arrayList2.add(obj11);
                                                                                    }
                                                                                }
                                                                                lazyListIntervalContent2.items(arrayList2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 19), arrayList2, (byte) 4), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList2, (byte) 11), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList2, composableLambdaImpl8, (byte) 0)));
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer4.updateRememberedValue(objRememberedValue5);
                                                            }
                                                            IntMath.LazyRow(null, null, paddingValuesImpl3, null, null, null, false, null, (Function1) objRememberedValue5, gapComposer4, 0, 507);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }), 2);
                                    }
                                    final List list6 = list;
                                    if (!list6.isEmpty() && ((List) state8.getValue()).isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "0_podcast_channels_title", null, AlbumScreenKt.f309lambda$1644721941, 2);
                                        final byte b9 = 1;
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "0_podcast_channels_list", null, new ComposableLambdaImpl(true, 1523000916, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda34
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj6, Object obj7, Object obj8) {
                                                byte b10 = b9;
                                                Unit unit2 = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                ComposableLambdaImpl composableLambdaImpl7 = composableLambdaImpl6;
                                                List list7 = list6;
                                                switch (b10) {
                                                    case 0:
                                                        Composer composer3 = (Composer) obj7;
                                                        int iIntValue3 = ((Integer) obj8).intValue();
                                                        ((LazyItemScopeImpl) obj6).getClass();
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            boolean zChangedInstance9 = gapComposer3.changedInstance(list7);
                                                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue4 == neverEqualPolicy3) {
                                                                objRememberedValue4 = new HomeScreenKt$$ExternalSyntheticLambda60(list7, composableLambdaImpl7, (byte) 2);
                                                                gapComposer3.updateRememberedValue(objRememberedValue4);
                                                            }
                                                            IntMath.LazyRow(null, null, paddingValuesImpl3, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer3, 0, 507);
                                                        }
                                                        break;
                                                    default:
                                                        Composer composer4 = (Composer) obj7;
                                                        int iIntValue4 = ((Integer) obj8).intValue();
                                                        ((LazyItemScopeImpl) obj6).getClass();
                                                        GapComposer gapComposer4 = (GapComposer) composer4;
                                                        if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                            gapComposer4.skipToGroupEnd();
                                                        } else {
                                                            boolean zChangedInstance10 = gapComposer4.changedInstance(list7);
                                                            Object objRememberedValue5 = gapComposer4.rememberedValue();
                                                            if (zChangedInstance10 || objRememberedValue5 == neverEqualPolicy3) {
                                                                objRememberedValue5 = new HomeScreenKt$$ExternalSyntheticLambda60(list7, composableLambdaImpl7, (byte) 1);
                                                                gapComposer4.updateRememberedValue(objRememberedValue5);
                                                            }
                                                            IntMath.LazyRow(null, null, paddingValuesImpl3, null, null, null, false, null, (Function1) objRememberedValue5, gapComposer4, 0, 507);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }), 2);
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    for (Object obj6 : list5) {
                                        if (obj6 instanceof HomeSection.HomePageSection) {
                                            arrayList.add(obj6);
                                        }
                                    }
                                    int size = arrayList.size();
                                    int i3 = 0;
                                    while (i3 < size) {
                                        Object obj7 = arrayList.get(i3);
                                        i3++;
                                        HomeSection.HomePageSection homePageSection = (HomeSection.HomePageSection) obj7;
                                        HomePage homePage2 = (HomePage) mutableState17.getValue();
                                        HomePage.Section section = homePage2 != null ? (HomePage.Section) CollectionsKt.getOrNull(homePageSection.index, homePage2.sections) : null;
                                        ArrayList arrayList2 = arrayList;
                                        int i4 = size;
                                        MutableState mutableState20 = mutableState17;
                                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"your shows", "episodes for later", "podcast channels", "new episodes"});
                                        if (section != null) {
                                            String lowerCase = section.title.toLowerCase(Locale.ROOT);
                                            lowerCase.getClass();
                                            if (!listListOf.isEmpty()) {
                                                Iterator it = listListOf.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        if (StringsKt.contains(lowerCase, (String) it.next(), false)) {
                                                        }
                                                    } else if (section != null) {
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(homePageSection.index, "1_chip_section_title_"), null, new ComposableLambdaImpl(true, 1048143614, new AlbumMenuKt$$ExternalSyntheticLambda11(section, navHostController3, (byte) 20)), 2);
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(homePageSection.index, "1_chip_section_list_"), null, new ComposableLambdaImpl(true, -568679897, new PlayerKt$$ExternalSyntheticLambda82(paddingValuesImpl3, section, composableLambdaImpl6, (byte) 12)), 2);
                                                    }
                                                }
                                            } else if (section != null) {
                                                LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(homePageSection.index, "1_chip_section_title_"), null, new ComposableLambdaImpl(true, 1048143614, new AlbumMenuKt$$ExternalSyntheticLambda11(section, navHostController3, (byte) 20)), 2);
                                                LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(homePageSection.index, "1_chip_section_list_"), null, new ComposableLambdaImpl(true, -568679897, new PlayerKt$$ExternalSyntheticLambda82(paddingValuesImpl3, section, composableLambdaImpl6, (byte) 12)), 2);
                                            }
                                        } else if (section != null) {
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(homePageSection.index, "1_chip_section_title_"), null, new ComposableLambdaImpl(true, 1048143614, new AlbumMenuKt$$ExternalSyntheticLambda11(section, navHostController3, (byte) 20)), 2);
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(homePageSection.index, "1_chip_section_list_"), null, new ComposableLambdaImpl(true, -568679897, new PlayerKt$$ExternalSyntheticLambda82(paddingValuesImpl3, section, composableLambdaImpl6, (byte) 12)), 2);
                                        }
                                        arrayList = arrayList2;
                                        size = i4;
                                        mutableState17 = mutableState20;
                                        mutableState18 = mutableState18;
                                    }
                                    mutableState15 = mutableState17;
                                    mutableState16 = mutableState18;
                                    b2 = 1;
                                }
                                Iterator it2 = list5.iterator();
                                while (it2.hasNext()) {
                                    HomeSection homeSection = (HomeSection) it2.next();
                                    boolean zAreEqual = Intrinsics.areEqual(homeSection, HomeSection.SpeedDial.INSTANCE);
                                    final MusicDatabase musicDatabase3 = musicDatabase2;
                                    final PaddingValuesImpl paddingValuesImpl4 = paddingValuesImpl3;
                                    final boolean z5 = z3;
                                    final PlayerConnection playerConnection2 = playerConnection;
                                    ComposableLambdaImpl composableLambdaImpl7 = composableLambdaImpl6;
                                    final MutableState mutableState21 = mutableState5;
                                    final HapticFeedback hapticFeedback2 = hapticFeedback;
                                    final MenuState menuState2 = menuState;
                                    Iterator it3 = it2;
                                    final State state10 = state4;
                                    final State state11 = state5;
                                    if (zAreEqual) {
                                        List list7 = (List) mutableState4.getValue();
                                        if (list7.isEmpty()) {
                                            composableLambdaImpl5 = composableLambdaImpl7;
                                            list3 = null;
                                        } else {
                                            list3 = list7;
                                            composableLambdaImpl5 = composableLambdaImpl7;
                                        }
                                        if (list3 != null) {
                                            ComposableLambdaImpl composableLambdaImpl8 = composableLambdaImpl5;
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "speed_dial_title", null, AlbumScreenKt.lambda$2027674076, 2);
                                            final BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl3 = boxWithConstraintsScopeImpl2;
                                            final State state12 = state3;
                                            final CoroutineScope coroutineScope3 = coroutineScope2;
                                            String str7 = str6;
                                            final MutableState mutableState22 = mutableState14;
                                            final State state13 = state6;
                                            b3 = 1;
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "speed_dial_list", null, new ComposableLambdaImpl(true, 2003495635, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda53
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                    long j;
                                                    Composer composer3 = (Composer) obj9;
                                                    int iIntValue3 = ((Integer) obj10).intValue();
                                                    ((LazyItemScopeImpl) obj8).getClass();
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                        float fM118getMaxWidthD9Ej5fM2 = (boxWithConstraintsScopeImpl3.m118getMaxWidthD9Ej5fM() - 40.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
                                                        int i5 = (int) (fM118getMaxWidthD9Ej5fM2 / 160.0f);
                                                        final int i6 = i5 < 3 ? 3 : i5;
                                                        final int i7 = i6 >= 6 ? 1 : i6 >= 4 ? 2 : 3;
                                                        final int i8 = i6 * i7;
                                                        final float f3 = (fM118getMaxWidthD9Ej5fM2 / i6) + CropImageView.DEFAULT_ASPECT_RATIO;
                                                        final List list8 = list3;
                                                        boolean zChangedInstance9 = gapComposer3.changedInstance(list8) | gapComposer3.changed(i8);
                                                        Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                        if (zChangedInstance9 || objRememberedValue4 == neverEqualPolicy3) {
                                                            objRememberedValue4 = new HomeScreenKt$$ExternalSyntheticLambda57(list8, i8, (byte) 0);
                                                            gapComposer3.updateRememberedValue(objRememberedValue4);
                                                        }
                                                        Function0 function0 = (Function0) objRememberedValue4;
                                                        PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$1 = PagerStateKt.UnitDensity;
                                                        Object[] objArr = new Object[0];
                                                        CallbackWrapper callbackWrapper = DefaultPagerState.Saver;
                                                        boolean zChanged29 = gapComposer3.changed(0) | gapComposer3.changed(CropImageView.DEFAULT_ASPECT_RATIO) | gapComposer3.changed(function0);
                                                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                                                        if (zChanged29 || objRememberedValue5 == neverEqualPolicy3) {
                                                            objRememberedValue5 = new Handshake$$ExternalSyntheticLambda0(function0, (byte) 1);
                                                            gapComposer3.updateRememberedValue(objRememberedValue5);
                                                        }
                                                        DefaultPagerState defaultPagerState = (DefaultPagerState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue5, (Composer) gapComposer3, 0);
                                                        defaultPagerState.pageCountState.setValue(function0);
                                                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                                                        int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
                                                        ComposeUiNode.Companion.getClass();
                                                        gapComposer3.startReusableNode();
                                                        boolean z6 = gapComposer3.inserting;
                                                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                                                        if (z6) {
                                                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                                        } else {
                                                            gapComposer3.useNode();
                                                        }
                                                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                                                        Integer numValueOf = Integer.valueOf(iHashCode);
                                                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                        Stack.m390setimpl(gapComposer3, numValueOf, updater$$ExternalSyntheticLambda2);
                                                        Stack.m389reconcileimpl(gapComposer3);
                                                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                                                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                                                        PaddingValuesImpl paddingValuesImplM127PaddingValuesYgX7TsA$default = OffsetKt.m127PaddingValuesYgX7TsA$default(2, 20.0f);
                                                        Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), (i7 * f3) + CropImageView.DEFAULT_ASPECT_RATIO);
                                                        final MusicDatabase musicDatabase4 = musicDatabase3;
                                                        final HomeViewModel homeViewModel3 = homeViewModel2;
                                                        final State state14 = state12;
                                                        final boolean z7 = z5;
                                                        final CoroutineScope coroutineScope4 = coroutineScope3;
                                                        final PlayerConnection playerConnection3 = playerConnection2;
                                                        final MutableState mutableState23 = mutableState21;
                                                        final NavHostController navHostController4 = navHostController3;
                                                        final MutableState mutableState24 = mutableState22;
                                                        final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                                        final MenuState menuState3 = menuState2;
                                                        final State state15 = state13;
                                                        final State state16 = state10;
                                                        final State state17 = state11;
                                                        MathKt.m1872HorizontalPagerIOMxRjY(defaultPagerState, modifierM145height3ABfNKs, paddingValuesImplM127PaddingValuesYgX7TsA$default, null, 0, 20.0f, null, null, false, null, null, null, null, Expect_jvmKt.rememberComposableLambda(370278697, new Function4() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda58
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            @Override // kotlin.jvm.functions.Function4
                                                            public final Object invoke(Object obj11, Object obj12, Object obj13, Object obj14) {
                                                                Modifier.Companion companion2;
                                                                MediaMetadata.Album album;
                                                                HomeScreenKt$$ExternalSyntheticLambda58 homeScreenKt$$ExternalSyntheticLambda58 = this;
                                                                int iIntValue4 = ((Integer) obj12).intValue();
                                                                Composer composer4 = (Composer) obj13;
                                                                int iIntValue5 = ((Integer) obj14).intValue();
                                                                BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                                                                ((PagerScopeImpl) obj11).getClass();
                                                                if ((iIntValue5 & 48) == 0) {
                                                                    iIntValue5 |= ((GapComposer) composer4).changed(iIntValue4) ? 32 : 16;
                                                                }
                                                                int i9 = 0;
                                                                boolean z8 = true;
                                                                GapComposer gapComposer4 = (GapComposer) composer4;
                                                                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 145) != 144)) {
                                                                    int i10 = i8;
                                                                    List listTake = CollectionsKt.take(CollectionsKt.drop(list8, iIntValue4 * i10), i10);
                                                                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                                                                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                                                                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                                                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, fillElement);
                                                                    ComposeUiNode.Companion.getClass();
                                                                    gapComposer4.startReusableNode();
                                                                    boolean z9 = gapComposer4.inserting;
                                                                    Function0 function1 = LayoutNode.Constructor;
                                                                    if (z9) {
                                                                        gapComposer4.createNode(function1);
                                                                    } else {
                                                                        gapComposer4.useNode();
                                                                    }
                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
                                                                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy2, updater$$ExternalSyntheticLambda4);
                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda5);
                                                                    Integer numValueOf2 = Integer.valueOf(iHashCode2);
                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                                                    Stack.m390setimpl(gapComposer4, numValueOf2, updater$$ExternalSyntheticLambda6);
                                                                    Stack.m389reconcileimpl(gapComposer4);
                                                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetModifier;
                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda7);
                                                                    gapComposer4.startReplaceGroup(135034595);
                                                                    int i11 = 0;
                                                                    while (i11 < i7) {
                                                                        Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion3, 1.0f);
                                                                        boolean z10 = z8;
                                                                        int i12 = i10;
                                                                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer4, i9);
                                                                        int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                                                                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierFillMaxWidth2);
                                                                        ComposeUiNode.Companion.getClass();
                                                                        gapComposer4.startReusableNode();
                                                                        int i13 = iIntValue4;
                                                                        if (gapComposer4.inserting) {
                                                                            gapComposer4.createNode(function1);
                                                                        } else {
                                                                            gapComposer4.useNode();
                                                                        }
                                                                        Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda4);
                                                                        Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda5);
                                                                        Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda6);
                                                                        Stack.m389reconcileimpl(gapComposer4);
                                                                        Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda7);
                                                                        gapComposer4.startReplaceGroup(-1911557745);
                                                                        int i14 = 0;
                                                                        while (true) {
                                                                            int i15 = i6;
                                                                            if (i14 < i15) {
                                                                                int i16 = (i15 * i11) + i14;
                                                                                float f4 = f3;
                                                                                final boolean z11 = z7;
                                                                                final CoroutineScope coroutineScope5 = coroutineScope4;
                                                                                int i17 = i14;
                                                                                final PlayerConnection playerConnection4 = playerConnection3;
                                                                                int i18 = i11;
                                                                                final MutableState mutableState25 = mutableState23;
                                                                                List list9 = listTake;
                                                                                final NavHostController navHostController5 = navHostController4;
                                                                                Object obj15 = Composer.Companion.Empty;
                                                                                if (i13 == 0 && i16 == i12 - 1) {
                                                                                    gapComposer4.startReplaceGroup(871091533);
                                                                                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.m145height3ABfNKs(SizeKt.m155width3ABfNKs(companion3, f4), f4), 4.0f);
                                                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                                                                    int iHashCode4 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs);
                                                                                    ComposeUiNode.Companion.getClass();
                                                                                    gapComposer4.startReusableNode();
                                                                                    if (gapComposer4.inserting) {
                                                                                        gapComposer4.createNode(function1);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda4);
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda5);
                                                                                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda6);
                                                                                    Stack.m389reconcileimpl(gapComposer4);
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda7);
                                                                                    final State state18 = state14;
                                                                                    boolean zBooleanValue2 = ((Boolean) state18.getValue()).booleanValue();
                                                                                    boolean zChanged30 = gapComposer4.changed(state18) | gapComposer4.changed(z11) | gapComposer4.changedInstance(coroutineScope5);
                                                                                    final HomeViewModel homeViewModel4 = homeViewModel3;
                                                                                    boolean zChangedInstance10 = zChanged30 | gapComposer4.changedInstance(homeViewModel4) | gapComposer4.changedInstance(playerConnection4) | gapComposer4.changed(mutableState25) | gapComposer4.changedInstance(navHostController5);
                                                                                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                                                                                    if (zChangedInstance10 || objRememberedValue6 == obj15) {
                                                                                        final MutableState mutableState26 = mutableState24;
                                                                                        objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda99
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                boolean zBooleanValue3 = ((Boolean) state18.getValue()).booleanValue();
                                                                                                MutableState mutableState27 = mutableState26;
                                                                                                if (zBooleanValue3) {
                                                                                                    Job job = (Job) mutableState27.getValue();
                                                                                                    if (job != null) {
                                                                                                        job.cancel(null);
                                                                                                    }
                                                                                                } else if (!z11) {
                                                                                                    mutableState27.setValue(AwaitKt.launch$default(coroutineScope5, null, null, new HomeScreenKt$HomeScreen$10$1$1$1$9$2$1$1$1$1$1$1$1$1$1(homeViewModel4, playerConnection4, navHostController5, mutableState25, null), 3));
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue6);
                                                                                    }
                                                                                    MenuKt.RandomizeGridItem(0, gapComposer4, null, (Function0) objRememberedValue6, zBooleanValue2);
                                                                                    gapComposer4.end(z10);
                                                                                    gapComposer4.end(false);
                                                                                    companion2 = companion3;
                                                                                } else if (i16 < list9.size()) {
                                                                                    gapComposer4.startReplaceGroup(879677510);
                                                                                    YTItem yTItem = (YTItem) list9.get(i16);
                                                                                    MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase4.delegate.getSpeedDialDao().isPinned(yTItem.getId()), Boolean.FALSE, gapComposer4, 48);
                                                                                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(SizeKt.m145height3ABfNKs(SizeKt.m155width3ABfNKs(companion3, f4), f4), 4.0f);
                                                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                                                                    int iHashCode5 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                                                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer4.currentCompositionLocalScope();
                                                                                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs2);
                                                                                    ComposeUiNode.Companion.getClass();
                                                                                    gapComposer4.startReusableNode();
                                                                                    if (gapComposer4.inserting) {
                                                                                        gapComposer4.createNode(function1);
                                                                                    } else {
                                                                                        gapComposer4.useNode();
                                                                                    }
                                                                                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda4);
                                                                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda5);
                                                                                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda6);
                                                                                    Stack.m389reconcileimpl(gapComposer4);
                                                                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda7);
                                                                                    boolean zBooleanValue3 = ((Boolean) mutableStateCollectAsStateWithLifecycle.getValue()).booleanValue();
                                                                                    State state19 = state16;
                                                                                    MediaMetadata mediaMetadata = (MediaMetadata) state19.getValue();
                                                                                    String str8 = (mediaMetadata == null || (album = mediaMetadata.album) == null) ? null : album.id;
                                                                                    MediaMetadata mediaMetadata2 = (MediaMetadata) state19.getValue();
                                                                                    boolean zContains = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{str8, mediaMetadata2 != null ? mediaMetadata2.id : null}).contains(yTItem.getId());
                                                                                    boolean zBooleanValue4 = ((Boolean) state17.getValue()).booleanValue();
                                                                                    FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                                                                                    HapticFeedback hapticFeedback4 = hapticFeedback3;
                                                                                    boolean zChangedInstance11 = gapComposer4.changedInstance(hapticFeedback4);
                                                                                    MenuState menuState4 = menuState3;
                                                                                    boolean zChanged31 = zChangedInstance11 | gapComposer4.changed(menuState4) | gapComposer4.changedInstance(yTItem) | gapComposer4.changedInstance(coroutineScope5);
                                                                                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                                                                                    if (zChanged31 || objRememberedValue7 == obj15) {
                                                                                        objRememberedValue7 = new HomeScreenKt$$ExternalSyntheticLambda9(hapticFeedback4, menuState4, yTItem, coroutineScope5, (byte) 1);
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue7);
                                                                                    }
                                                                                    Function0 function2 = (Function0) objRememberedValue7;
                                                                                    boolean zChangedInstance12 = gapComposer4.changedInstance(r20);
                                                                                    YTItem yTItem2 = yTItem;
                                                                                    boolean zChanged32 = zChangedInstance12 | gapComposer4.changed(z11) | gapComposer4.changedInstance(playerConnection4) | gapComposer4.changed(mutableState25) | gapComposer4.changedInstance(navHostController5);
                                                                                    State state20 = state15;
                                                                                    boolean zChanged33 = zChanged32 | gapComposer4.changed(state20);
                                                                                    Object objRememberedValue8 = gapComposer4.rememberedValue();
                                                                                    if (zChanged33 || objRememberedValue8 == obj15) {
                                                                                        objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda25(yTItem2, z11, playerConnection4, navHostController5, mutableState25, state20);
                                                                                        yTItem2 = yTItem2;
                                                                                        gapComposer4.updateRememberedValue(objRememberedValue8);
                                                                                    }
                                                                                    Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(fillElement2, false, function2, (Function0) objRememberedValue8, 239);
                                                                                    companion2 = companion3;
                                                                                    MenuKt.SpeedDialGridItem(yTItem2, zBooleanValue3, modifierM48combinedClickablehoGz1lA$default, zContains, zBooleanValue4, gapComposer4, 0);
                                                                                    gapComposer4.end(true);
                                                                                    gapComposer4.end(false);
                                                                                } else {
                                                                                    companion2 = companion3;
                                                                                    gapComposer4.startReplaceGroup(894441105);
                                                                                    OffsetKt.Spacer(gapComposer4, SizeKt.m155width3ABfNKs(companion2, f4));
                                                                                    gapComposer4.end(false);
                                                                                }
                                                                                updater$$ExternalSyntheticLambda7 = updater$$ExternalSyntheticLambda7;
                                                                                companion3 = companion2;
                                                                                updater$$ExternalSyntheticLambda6 = updater$$ExternalSyntheticLambda6;
                                                                                updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda4;
                                                                                function1 = function1;
                                                                                i14 = i17 + 1;
                                                                                biasAlignment = biasAlignment;
                                                                                i11 = i18;
                                                                                listTake = list9;
                                                                                z10 = true;
                                                                                homeScreenKt$$ExternalSyntheticLambda58 = this;
                                                                            }
                                                                        }
                                                                        gapComposer4.end(false);
                                                                        gapComposer4.end(true);
                                                                        i11++;
                                                                        biasAlignment = biasAlignment;
                                                                        iIntValue4 = i13;
                                                                        homeScreenKt$$ExternalSyntheticLambda58 = this;
                                                                        z8 = true;
                                                                        i9 = 0;
                                                                        listTake = listTake;
                                                                        i10 = i12;
                                                                    }
                                                                    gapComposer4.end(i9);
                                                                    gapComposer4.end(z8);
                                                                } else {
                                                                    gapComposer4.skipToGroupEnd();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, gapComposer3), gapComposer3, 196992, 32728);
                                                        boolean z8 = true;
                                                        if (defaultPagerState.getPageCount() > 1) {
                                                            gapComposer3.startReplaceGroup(746395354);
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(SizeKt.m145height3ABfNKs(companion, 24.0f), 1.0f);
                                                            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer3, 54);
                                                            int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                                                            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth2);
                                                            gapComposer3.startReusableNode();
                                                            if (gapComposer3.inserting) {
                                                                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                                            } else {
                                                                gapComposer3.useNode();
                                                            }
                                                            Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                                                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                                                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                                                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                                                            gapComposer3.startReplaceGroup(-1122813451);
                                                            int pageCount = defaultPagerState.getPageCount();
                                                            for (int i9 = 0; i9 < pageCount; i9++) {
                                                                if (defaultPagerState.getCurrentPage() == i9) {
                                                                    gapComposer3.startReplaceGroup(-1080065263);
                                                                    j = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                                                                    gapComposer3.end(false);
                                                                } else {
                                                                    gapComposer3.startReplaceGroup(-1079907318);
                                                                    j = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                                                                    gapComposer3.end(false);
                                                                }
                                                                float f4 = 8.0f;
                                                                Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(OffsetKt.m136paddingVpY3zN4(companion, 3.0f, 8.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(2.0f)), j, ColorKt.RectangleShape);
                                                                if (defaultPagerState.getCurrentPage() == i9) {
                                                                    f4 = 16.0f;
                                                                }
                                                                BoxKt.Box(SizeKt.m152sizeVpY3zN4(modifierM39backgroundbw27NRU, f4, 3.0f), gapComposer3, 0);
                                                            }
                                                            z8 = true;
                                                            Fragment$5$$ExternalSyntheticOutline0.m(gapComposer3, false, true, false);
                                                        } else {
                                                            gapComposer3.startReplaceGroup(748301017);
                                                            gapComposer3.end(false);
                                                        }
                                                        gapComposer3.end(z8);
                                                    } else {
                                                        gapComposer3.skipToGroupEnd();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), 2);
                                            navHostController3 = navHostController3;
                                            paddingValuesImpl4 = paddingValuesImpl4;
                                            composableLambdaImpl3 = composableLambdaImpl8;
                                            str2 = str7;
                                        } else {
                                            b3 = 1;
                                            navHostController3 = navHostController3;
                                            str2 = str6;
                                            composableLambdaImpl3 = composableLambdaImpl5;
                                        }
                                    } else {
                                        String str8 = str6;
                                        b3 = 1;
                                        boolean zAreEqual2 = Intrinsics.areEqual(homeSection, HomeSection.QuickPicks.INSTANCE);
                                        final InsetsPaddingValues insetsPaddingValues2 = insetsPaddingValues;
                                        final float f3 = fM118getMaxWidthD9Ej5fM;
                                        if (zAreEqual2) {
                                            final List list8 = (List) mutableState6.getValue();
                                            if (list8 == null) {
                                                b4 = 0;
                                            } else {
                                                if (list8.isEmpty()) {
                                                    list8 = null;
                                                }
                                                if (list8 != null) {
                                                    b4 = 0;
                                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "quick_picks_title", null, new ComposableLambdaImpl(true, 551421075, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda27
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                            byte b10 = b4;
                                                            Unit unit2 = Unit.INSTANCE;
                                                            Function0 function0 = null;
                                                            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                            List list9 = list8;
                                                            PlayerConnection playerConnection3 = playerConnection2;
                                                            boolean z6 = z5;
                                                            switch (b10) {
                                                                case 0:
                                                                    Composer composer3 = (Composer) obj9;
                                                                    int iIntValue3 = ((Integer) obj10).intValue();
                                                                    ((LazyItemScopeImpl) obj8).getClass();
                                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                                    if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                        gapComposer3.skipToGroupEnd();
                                                                    } else {
                                                                        String strStringResource = MathKt.stringResource(R.string.quick_picks, gapComposer3);
                                                                        Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(DialogKt.m1476riseInwH6b6FI$default(companion, 40), gapComposer3, 0);
                                                                        if (z6) {
                                                                            gapComposer3.startReplaceGroup(-863610229);
                                                                            gapComposer3.end(false);
                                                                        } else {
                                                                            gapComposer3.startReplaceGroup(-864213179);
                                                                            boolean zChangedInstance9 = gapComposer3.changedInstance(playerConnection3) | gapComposer3.changed(strStringResource) | gapComposer3.changedInstance(list9);
                                                                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                                            if (zChangedInstance9 || objRememberedValue4 == neverEqualPolicy3) {
                                                                                objRememberedValue4 = new HomeScreenKt$$ExternalSyntheticLambda72(playerConnection3, strStringResource, list9, (byte) 2);
                                                                                gapComposer3.updateRememberedValue(objRememberedValue4);
                                                                            }
                                                                            function0 = (Function0) objRememberedValue4;
                                                                            gapComposer3.end(false);
                                                                        }
                                                                        MenuKt.NavigationTitle(strStringResource, modifierM1473hairlineBottomiJQMabo, null, null, null, function0, gapComposer3, 0, 28);
                                                                    }
                                                                    break;
                                                                default:
                                                                    Composer composer4 = (Composer) obj9;
                                                                    int iIntValue4 = ((Integer) obj10).intValue();
                                                                    ((LazyItemScopeImpl) obj8).getClass();
                                                                    GapComposer gapComposer4 = (GapComposer) composer4;
                                                                    if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                                        gapComposer4.skipToGroupEnd();
                                                                    } else {
                                                                        String strStringResource2 = MathKt.stringResource(R.string.forgotten_favorites, gapComposer4);
                                                                        Modifier modifierM1473hairlineBottomiJQMabo2 = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer4, 6);
                                                                        if (z6) {
                                                                            gapComposer4.startReplaceGroup(-590690490);
                                                                            gapComposer4.end(false);
                                                                        } else {
                                                                            gapComposer4.startReplaceGroup(-591308816);
                                                                            boolean zChangedInstance10 = gapComposer4.changedInstance(playerConnection3) | gapComposer4.changed(strStringResource2) | gapComposer4.changedInstance(list9);
                                                                            Object objRememberedValue5 = gapComposer4.rememberedValue();
                                                                            if (zChangedInstance10 || objRememberedValue5 == neverEqualPolicy3) {
                                                                                objRememberedValue5 = new HomeScreenKt$$ExternalSyntheticLambda72(playerConnection3, strStringResource2, list9, (byte) 1);
                                                                                gapComposer4.updateRememberedValue(objRememberedValue5);
                                                                            }
                                                                            function0 = (Function0) objRememberedValue5;
                                                                            gapComposer4.end(false);
                                                                        }
                                                                        MenuKt.NavigationTitle(strStringResource2, modifierM1473hairlineBottomiJQMabo2, null, null, null, function0, gapComposer4, 0, 28);
                                                                    }
                                                                    break;
                                                            }
                                                            return unit2;
                                                        }
                                                    }), 2);
                                                    final byte b10 = 0;
                                                    final SnapLayoutInfoProvider snapLayoutInfoProvider3 = snapLayoutInfoProvider;
                                                    final LazyGridState lazyGridState3 = lazyGridState;
                                                    final List list9 = list8;
                                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "quick_picks_list", null, new ComposableLambdaImpl(true, -1209224246, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda28
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                            Object obj11;
                                                            Modifier modifierFillMaxWidth;
                                                            byte b11 = b10;
                                                            Unit unit2 = Unit.INSTANCE;
                                                            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                            SnapLayoutInfoProvider snapLayoutInfoProvider4 = snapLayoutInfoProvider3;
                                                            switch (b11) {
                                                                case 0:
                                                                    Composer composer3 = (Composer) obj9;
                                                                    int iIntValue3 = ((Integer) obj10).intValue();
                                                                    ((LazyItemScopeImpl) obj8).getClass();
                                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                        List list10 = list9;
                                                                        boolean zChanged29 = gapComposer3.changed(list10);
                                                                        Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                                        if (zChanged29 || objRememberedValue4 == neverEqualPolicy3) {
                                                                            obj11 = objRememberedValue4;
                                                                            HashSet hashSet = new HashSet();
                                                                            ArrayList arrayList3 = new ArrayList();
                                                                            for (Object obj12 : list10) {
                                                                                if (hashSet.add(((Song) obj12).song.id)) {
                                                                                    arrayList3.add(obj12);
                                                                                }
                                                                            }
                                                                            gapComposer3.updateRememberedValue(arrayList3);
                                                                            obj11 = arrayList3;
                                                                        }
                                                                        List list11 = (List) obj11;
                                                                        GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(4);
                                                                        SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior = SQLite.rememberSnapFlingBehavior(snapLayoutInfoProvider4, gapComposer3);
                                                                        Modifier modifierM1476riseInwH6b6FI$default = DialogKt.m1476riseInwH6b6FI$default(companion, 100);
                                                                        if (UiStyleKt.isGlassStyle(gapComposer3)) {
                                                                            gapComposer3.startReplaceGroup(-2108018096);
                                                                            modifierFillMaxWidth = GlassComponentsKt.glassCard(SizeKt.fillMaxWidth(OffsetKt.m137paddingVpY3zN4$default(companion, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(26.0f), gapComposer3);
                                                                            gapComposer3.end(false);
                                                                        } else {
                                                                            gapComposer3.startReplaceGroup(-2107815759);
                                                                            gapComposer3.end(false);
                                                                            modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                                        }
                                                                        Modifier modifierThen = modifierM1476riseInwH6b6FI$default.then(modifierFillMaxWidth);
                                                                        SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                                                        Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierThen, 256.0f);
                                                                        boolean zChangedInstance9 = gapComposer3.changedInstance(list11);
                                                                        MusicDatabase musicDatabase4 = musicDatabase3;
                                                                        boolean zChangedInstance10 = zChangedInstance9 | gapComposer3.changedInstance(musicDatabase4);
                                                                        State state14 = state10;
                                                                        boolean zChanged30 = zChangedInstance10 | gapComposer3.changed(state14);
                                                                        State state15 = state11;
                                                                        boolean zChanged31 = zChanged30 | gapComposer3.changed(state15);
                                                                        float f4 = f3;
                                                                        boolean zChanged32 = zChanged31 | gapComposer3.changed(f4);
                                                                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                                                                        boolean zChangedInstance11 = zChanged32 | gapComposer3.changedInstance(hapticFeedback3);
                                                                        MenuState menuState3 = menuState2;
                                                                        boolean zChanged33 = zChangedInstance11 | gapComposer3.changed(menuState3);
                                                                        boolean z6 = z5;
                                                                        boolean zChanged34 = zChanged33 | gapComposer3.changed(z6);
                                                                        PlayerConnection playerConnection3 = playerConnection2;
                                                                        boolean zChangedInstance12 = zChanged34 | gapComposer3.changedInstance(playerConnection3);
                                                                        MutableState mutableState23 = mutableState21;
                                                                        boolean zChanged35 = zChangedInstance12 | gapComposer3.changed(mutableState23);
                                                                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                                                                        if (zChanged35 || objRememberedValue5 == neverEqualPolicy3) {
                                                                            HomeScreenKt$$ExternalSyntheticLambda59 homeScreenKt$$ExternalSyntheticLambda59 = new HomeScreenKt$$ExternalSyntheticLambda59(list11, musicDatabase4, f4, hapticFeedback3, menuState3, z6, state14, playerConnection3, mutableState23, state15, (byte) 1);
                                                                            gapComposer3.updateRememberedValue(homeScreenKt$$ExternalSyntheticLambda59);
                                                                            objRememberedValue5 = homeScreenKt$$ExternalSyntheticLambda59;
                                                                        }
                                                                        LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM145height3ABfNKs, lazyGridState3, insetsPaddingValues2, null, null, snapFlingBehaviorRememberSnapFlingBehavior, false, null, null, (Function1) objRememberedValue5, gapComposer3, 0, 1904);
                                                                    } else {
                                                                        gapComposer3.skipToGroupEnd();
                                                                    }
                                                                    break;
                                                                default:
                                                                    Composer composer4 = (Composer) obj9;
                                                                    int iIntValue4 = ((Integer) obj10).intValue();
                                                                    ((LazyItemScopeImpl) obj8).getClass();
                                                                    GapComposer gapComposer4 = (GapComposer) composer4;
                                                                    if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                                        List list12 = list9;
                                                                        int iMin = Math.min(4, list12.size());
                                                                        GridCells$Fixed gridCells$Fixed2 = new GridCells$Fixed(iMin);
                                                                        SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior2 = SQLite.rememberSnapFlingBehavior(snapLayoutInfoProvider4, gapComposer4);
                                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                                        SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                                                                        Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(modifierFillMaxWidth2, (64.0f * iMin) + CropImageView.DEFAULT_ASPECT_RATIO);
                                                                        boolean zChangedInstance13 = gapComposer4.changedInstance(list12);
                                                                        MusicDatabase musicDatabase5 = musicDatabase3;
                                                                        boolean zChangedInstance14 = zChangedInstance13 | gapComposer4.changedInstance(musicDatabase5);
                                                                        State state16 = state10;
                                                                        boolean zChanged36 = zChangedInstance14 | gapComposer4.changed(state16);
                                                                        State state17 = state11;
                                                                        boolean zChanged37 = zChanged36 | gapComposer4.changed(state17);
                                                                        float f5 = f3;
                                                                        boolean zChanged38 = zChanged37 | gapComposer4.changed(f5);
                                                                        HapticFeedback hapticFeedback4 = hapticFeedback2;
                                                                        boolean zChangedInstance15 = zChanged38 | gapComposer4.changedInstance(hapticFeedback4);
                                                                        MenuState menuState4 = menuState2;
                                                                        boolean zChanged39 = zChangedInstance15 | gapComposer4.changed(menuState4);
                                                                        boolean z7 = z5;
                                                                        boolean zChanged40 = zChanged39 | gapComposer4.changed(z7);
                                                                        PlayerConnection playerConnection4 = playerConnection2;
                                                                        boolean zChangedInstance16 = zChanged40 | gapComposer4.changedInstance(playerConnection4);
                                                                        MutableState mutableState24 = mutableState21;
                                                                        boolean zChanged41 = zChangedInstance16 | gapComposer4.changed(mutableState24);
                                                                        Object objRememberedValue6 = gapComposer4.rememberedValue();
                                                                        if (zChanged41 || objRememberedValue6 == neverEqualPolicy3) {
                                                                            HomeScreenKt$$ExternalSyntheticLambda59 homeScreenKt$$ExternalSyntheticLambda510 = new HomeScreenKt$$ExternalSyntheticLambda59(list12, musicDatabase5, f5, hapticFeedback4, menuState4, z7, state16, playerConnection4, mutableState24, state17, (byte) 0);
                                                                            gapComposer4.updateRememberedValue(homeScreenKt$$ExternalSyntheticLambda510);
                                                                            objRememberedValue6 = homeScreenKt$$ExternalSyntheticLambda510;
                                                                        }
                                                                        LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed2, modifierM145height3ABfNKs2, lazyGridState3, insetsPaddingValues2, null, null, snapFlingBehaviorRememberSnapFlingBehavior2, false, null, null, (Function1) objRememberedValue6, gapComposer4, 0, 1904);
                                                                    } else {
                                                                        gapComposer4.skipToGroupEnd();
                                                                    }
                                                                    break;
                                                            }
                                                            return unit2;
                                                        }
                                                    }), 2);
                                                } else {
                                                    b4 = 0;
                                                }
                                            }
                                        } else {
                                            b4 = 0;
                                            if (Intrinsics.areEqual(homeSection, HomeSection.FromTheCommunity.INSTANCE)) {
                                                List list10 = (List) mutableState7.getValue();
                                                if (list10 != null) {
                                                    NavHostController navHostController4 = navHostController3;
                                                    List list11 = !list10.isEmpty() ? list10 : null;
                                                    if (list11 != null) {
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "community_playlists_title", null, AlbumScreenKt.lambda$569847828, 2);
                                                        HomeScreenKt$$ExternalSyntheticLambda29 homeScreenKt$$ExternalSyntheticLambda29 = new HomeScreenKt$$ExternalSyntheticLambda29(list11, (Object) navHostController4, z5, (Object) playerConnection2, (byte) 0);
                                                        navHostController3 = navHostController4;
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "community_playlists_content", null, new ComposableLambdaImpl(true, -1190797493, homeScreenKt$$ExternalSyntheticLambda29), 2);
                                                    } else {
                                                        navHostController3 = navHostController4;
                                                    }
                                                }
                                            } else if (Intrinsics.areEqual(homeSection, HomeSection.DailyDiscover.INSTANCE)) {
                                                List list12 = (List) mutableState8.getValue();
                                                if (list12 != null) {
                                                    if (list12.isEmpty()) {
                                                        list12 = null;
                                                    }
                                                    if (list12 != null) {
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "daily_discover_title", null, new ComposableLambdaImpl(true, 588274581, new AlbumMenuKt$$ExternalSyntheticLambda11(list12, playerConnection2, (byte) 18)), 2);
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "daily_discover_content", null, new ComposableLambdaImpl(true, -1172370740, new HomeScreenKt$$ExternalSyntheticLambda29(list12, z5, playerConnection2, mutableState21)), 2);
                                                    }
                                                }
                                            } else if (Intrinsics.areEqual(homeSection, HomeSection.KeepListening.INSTANCE)) {
                                                List list13 = (List) mutableState9.getValue();
                                                if (list13 == null) {
                                                    paddingValuesImpl2 = paddingValuesImpl4;
                                                } else {
                                                    if (list13.isEmpty()) {
                                                        list13 = null;
                                                    }
                                                    if (list13 != null) {
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "keep_listening_title", null, AlbumScreenKt.lambda$606701334, 2);
                                                        paddingValuesImpl2 = paddingValuesImpl4;
                                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "keep_listening_list", null, new ComposableLambdaImpl(true, -1153943987, new HomeScreenKt$$ExternalSyntheticLambda32(list13, f2, paddingValuesImpl2, composableLambdaImpl2)), 2);
                                                    } else {
                                                        paddingValuesImpl2 = paddingValuesImpl4;
                                                    }
                                                }
                                                navHostController3 = navHostController3;
                                                paddingValuesImpl4 = paddingValuesImpl2;
                                                composableLambdaImpl3 = composableLambdaImpl7;
                                                str2 = str8;
                                            } else {
                                                paddingValuesImpl4 = paddingValuesImpl4;
                                                if (Intrinsics.areEqual(homeSection, HomeSection.AccountPlaylists.INSTANCE)) {
                                                    final List list14 = (List) mutableState10.getValue();
                                                    if (list14 == null) {
                                                        composableLambdaImpl4 = composableLambdaImpl7;
                                                    } else {
                                                        if (list14.isEmpty()) {
                                                            list14 = null;
                                                        }
                                                        if (list14 != null) {
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "account_playlists_title", null, new ComposableLambdaImpl(true, 625128087, new PlayerKt$$ExternalSyntheticLambda82(navHostController3, state7, str, (byte) 10)), 2);
                                                            composableLambdaImpl4 = composableLambdaImpl7;
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "account_playlists_list", null, new ComposableLambdaImpl(true, -1135517234, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda34
                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                                    byte b11 = b4;
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                                    ComposableLambdaImpl composableLambdaImpl9 = composableLambdaImpl4;
                                                                    List list15 = list14;
                                                                    switch (b11) {
                                                                        case 0:
                                                                            Composer composer3 = (Composer) obj9;
                                                                            int iIntValue3 = ((Integer) obj10).intValue();
                                                                            ((LazyItemScopeImpl) obj8).getClass();
                                                                            GapComposer gapComposer3 = (GapComposer) composer3;
                                                                            if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                                gapComposer3.skipToGroupEnd();
                                                                            } else {
                                                                                boolean zChangedInstance9 = gapComposer3.changedInstance(list15);
                                                                                Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                                                if (zChangedInstance9 || objRememberedValue4 == neverEqualPolicy3) {
                                                                                    objRememberedValue4 = new HomeScreenKt$$ExternalSyntheticLambda60(list15, composableLambdaImpl9, (byte) 2);
                                                                                    gapComposer3.updateRememberedValue(objRememberedValue4);
                                                                                }
                                                                                IntMath.LazyRow(null, null, paddingValuesImpl4, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer3, 0, 507);
                                                                            }
                                                                            break;
                                                                        default:
                                                                            Composer composer4 = (Composer) obj9;
                                                                            int iIntValue4 = ((Integer) obj10).intValue();
                                                                            ((LazyItemScopeImpl) obj8).getClass();
                                                                            GapComposer gapComposer4 = (GapComposer) composer4;
                                                                            if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                                                gapComposer4.skipToGroupEnd();
                                                                            } else {
                                                                                boolean zChangedInstance10 = gapComposer4.changedInstance(list15);
                                                                                Object objRememberedValue5 = gapComposer4.rememberedValue();
                                                                                if (zChangedInstance10 || objRememberedValue5 == neverEqualPolicy3) {
                                                                                    objRememberedValue5 = new HomeScreenKt$$ExternalSyntheticLambda60(list15, composableLambdaImpl9, (byte) 1);
                                                                                    gapComposer4.updateRememberedValue(objRememberedValue5);
                                                                                }
                                                                                IntMath.LazyRow(null, null, paddingValuesImpl4, null, null, null, false, null, (Function1) objRememberedValue5, gapComposer4, 0, 507);
                                                                            }
                                                                            break;
                                                                    }
                                                                    return unit2;
                                                                }
                                                            }), 2);
                                                        } else {
                                                            composableLambdaImpl4 = composableLambdaImpl7;
                                                        }
                                                    }
                                                    navHostController3 = navHostController3;
                                                    str2 = str8;
                                                    composableLambdaImpl3 = composableLambdaImpl4;
                                                    paddingValuesImpl4 = paddingValuesImpl4;
                                                } else {
                                                    if (Intrinsics.areEqual(homeSection, HomeSection.ForgottenFavorites.INSTANCE)) {
                                                        final List list15 = (List) mutableState11.getValue();
                                                        if (list15 != null) {
                                                            if (list15.isEmpty()) {
                                                                list15 = null;
                                                            }
                                                            if (list15 != null) {
                                                                LazyListIntervalContent.item$default(lazyListIntervalContent, "forgotten_favorites_title", null, new ComposableLambdaImpl(true, 643554840, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda27
                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                                        byte b11 = b3;
                                                                        Unit unit2 = Unit.INSTANCE;
                                                                        Function0 function0 = null;
                                                                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                                        List list16 = list15;
                                                                        PlayerConnection playerConnection3 = playerConnection2;
                                                                        boolean z6 = z5;
                                                                        switch (b11) {
                                                                            case 0:
                                                                                Composer composer3 = (Composer) obj9;
                                                                                int iIntValue3 = ((Integer) obj10).intValue();
                                                                                ((LazyItemScopeImpl) obj8).getClass();
                                                                                GapComposer gapComposer3 = (GapComposer) composer3;
                                                                                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                                    gapComposer3.skipToGroupEnd();
                                                                                } else {
                                                                                    String strStringResource = MathKt.stringResource(R.string.quick_picks, gapComposer3);
                                                                                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(DialogKt.m1476riseInwH6b6FI$default(companion, 40), gapComposer3, 0);
                                                                                    if (z6) {
                                                                                        gapComposer3.startReplaceGroup(-863610229);
                                                                                        gapComposer3.end(false);
                                                                                    } else {
                                                                                        gapComposer3.startReplaceGroup(-864213179);
                                                                                        boolean zChangedInstance9 = gapComposer3.changedInstance(playerConnection3) | gapComposer3.changed(strStringResource) | gapComposer3.changedInstance(list16);
                                                                                        Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                                                        if (zChangedInstance9 || objRememberedValue4 == neverEqualPolicy3) {
                                                                                            objRememberedValue4 = new HomeScreenKt$$ExternalSyntheticLambda72(playerConnection3, strStringResource, list16, (byte) 2);
                                                                                            gapComposer3.updateRememberedValue(objRememberedValue4);
                                                                                        }
                                                                                        function0 = (Function0) objRememberedValue4;
                                                                                        gapComposer3.end(false);
                                                                                    }
                                                                                    MenuKt.NavigationTitle(strStringResource, modifierM1473hairlineBottomiJQMabo, null, null, null, function0, gapComposer3, 0, 28);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                Composer composer4 = (Composer) obj9;
                                                                                int iIntValue4 = ((Integer) obj10).intValue();
                                                                                ((LazyItemScopeImpl) obj8).getClass();
                                                                                GapComposer gapComposer4 = (GapComposer) composer4;
                                                                                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                                                    gapComposer4.skipToGroupEnd();
                                                                                } else {
                                                                                    String strStringResource2 = MathKt.stringResource(R.string.forgotten_favorites, gapComposer4);
                                                                                    Modifier modifierM1473hairlineBottomiJQMabo2 = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer4, 6);
                                                                                    if (z6) {
                                                                                        gapComposer4.startReplaceGroup(-590690490);
                                                                                        gapComposer4.end(false);
                                                                                    } else {
                                                                                        gapComposer4.startReplaceGroup(-591308816);
                                                                                        boolean zChangedInstance10 = gapComposer4.changedInstance(playerConnection3) | gapComposer4.changed(strStringResource2) | gapComposer4.changedInstance(list16);
                                                                                        Object objRememberedValue5 = gapComposer4.rememberedValue();
                                                                                        if (zChangedInstance10 || objRememberedValue5 == neverEqualPolicy3) {
                                                                                            objRememberedValue5 = new HomeScreenKt$$ExternalSyntheticLambda72(playerConnection3, strStringResource2, list16, (byte) 1);
                                                                                            gapComposer4.updateRememberedValue(objRememberedValue5);
                                                                                        }
                                                                                        function0 = (Function0) objRememberedValue5;
                                                                                        gapComposer4.end(false);
                                                                                    }
                                                                                    MenuKt.NavigationTitle(strStringResource2, modifierM1473hairlineBottomiJQMabo2, null, null, null, function0, gapComposer4, 0, 28);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit2;
                                                                    }
                                                                }), 2);
                                                                final byte b11 = 1;
                                                                final SnapLayoutInfoProvider snapLayoutInfoProvider4 = snapLayoutInfoProvider2;
                                                                final LazyGridState lazyGridState4 = lazyGridState2;
                                                                final List list16 = list15;
                                                                LazyListIntervalContent.item$default(lazyListIntervalContent, "forgotten_favorites_list", null, new ComposableLambdaImpl(true, -1117090481, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda28
                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                                        Object obj11;
                                                                        Modifier modifierFillMaxWidth;
                                                                        byte b12 = b11;
                                                                        Unit unit2 = Unit.INSTANCE;
                                                                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                                        SnapLayoutInfoProvider snapLayoutInfoProvider5 = snapLayoutInfoProvider4;
                                                                        switch (b12) {
                                                                            case 0:
                                                                                Composer composer3 = (Composer) obj9;
                                                                                int iIntValue3 = ((Integer) obj10).intValue();
                                                                                ((LazyItemScopeImpl) obj8).getClass();
                                                                                GapComposer gapComposer3 = (GapComposer) composer3;
                                                                                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                                    List list17 = list16;
                                                                                    boolean zChanged29 = gapComposer3.changed(list17);
                                                                                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                                                    if (zChanged29 || objRememberedValue4 == neverEqualPolicy3) {
                                                                                        obj11 = objRememberedValue4;
                                                                                        HashSet hashSet = new HashSet();
                                                                                        ArrayList arrayList3 = new ArrayList();
                                                                                        for (Object obj12 : list17) {
                                                                                            if (hashSet.add(((Song) obj12).song.id)) {
                                                                                                arrayList3.add(obj12);
                                                                                            }
                                                                                        }
                                                                                        gapComposer3.updateRememberedValue(arrayList3);
                                                                                        obj11 = arrayList3;
                                                                                    }
                                                                                    List list18 = (List) obj11;
                                                                                    GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(4);
                                                                                    SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior = SQLite.rememberSnapFlingBehavior(snapLayoutInfoProvider5, gapComposer3);
                                                                                    Modifier modifierM1476riseInwH6b6FI$default = DialogKt.m1476riseInwH6b6FI$default(companion, 100);
                                                                                    if (UiStyleKt.isGlassStyle(gapComposer3)) {
                                                                                        gapComposer3.startReplaceGroup(-2108018096);
                                                                                        modifierFillMaxWidth = GlassComponentsKt.glassCard(SizeKt.fillMaxWidth(OffsetKt.m137paddingVpY3zN4$default(companion, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(26.0f), gapComposer3);
                                                                                        gapComposer3.end(false);
                                                                                    } else {
                                                                                        gapComposer3.startReplaceGroup(-2107815759);
                                                                                        gapComposer3.end(false);
                                                                                        modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                                                    }
                                                                                    Modifier modifierThen = modifierM1476riseInwH6b6FI$default.then(modifierFillMaxWidth);
                                                                                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                                                                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierThen, 256.0f);
                                                                                    boolean zChangedInstance9 = gapComposer3.changedInstance(list18);
                                                                                    MusicDatabase musicDatabase4 = musicDatabase3;
                                                                                    boolean zChangedInstance10 = zChangedInstance9 | gapComposer3.changedInstance(musicDatabase4);
                                                                                    State state14 = state10;
                                                                                    boolean zChanged30 = zChangedInstance10 | gapComposer3.changed(state14);
                                                                                    State state15 = state11;
                                                                                    boolean zChanged31 = zChanged30 | gapComposer3.changed(state15);
                                                                                    float f4 = f3;
                                                                                    boolean zChanged32 = zChanged31 | gapComposer3.changed(f4);
                                                                                    HapticFeedback hapticFeedback3 = hapticFeedback2;
                                                                                    boolean zChangedInstance11 = zChanged32 | gapComposer3.changedInstance(hapticFeedback3);
                                                                                    MenuState menuState3 = menuState2;
                                                                                    boolean zChanged33 = zChangedInstance11 | gapComposer3.changed(menuState3);
                                                                                    boolean z6 = z5;
                                                                                    boolean zChanged34 = zChanged33 | gapComposer3.changed(z6);
                                                                                    PlayerConnection playerConnection3 = playerConnection2;
                                                                                    boolean zChangedInstance12 = zChanged34 | gapComposer3.changedInstance(playerConnection3);
                                                                                    MutableState mutableState23 = mutableState21;
                                                                                    boolean zChanged35 = zChangedInstance12 | gapComposer3.changed(mutableState23);
                                                                                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                                                                                    if (zChanged35 || objRememberedValue5 == neverEqualPolicy3) {
                                                                                        HomeScreenKt$$ExternalSyntheticLambda59 homeScreenKt$$ExternalSyntheticLambda59 = new HomeScreenKt$$ExternalSyntheticLambda59(list18, musicDatabase4, f4, hapticFeedback3, menuState3, z6, state14, playerConnection3, mutableState23, state15, (byte) 1);
                                                                                        gapComposer3.updateRememberedValue(homeScreenKt$$ExternalSyntheticLambda59);
                                                                                        objRememberedValue5 = homeScreenKt$$ExternalSyntheticLambda59;
                                                                                    }
                                                                                    LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM145height3ABfNKs, lazyGridState4, insetsPaddingValues2, null, null, snapFlingBehaviorRememberSnapFlingBehavior, false, null, null, (Function1) objRememberedValue5, gapComposer3, 0, 1904);
                                                                                } else {
                                                                                    gapComposer3.skipToGroupEnd();
                                                                                }
                                                                                break;
                                                                            default:
                                                                                Composer composer4 = (Composer) obj9;
                                                                                int iIntValue4 = ((Integer) obj10).intValue();
                                                                                ((LazyItemScopeImpl) obj8).getClass();
                                                                                GapComposer gapComposer4 = (GapComposer) composer4;
                                                                                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                                                                    List list19 = list16;
                                                                                    int iMin = Math.min(4, list19.size());
                                                                                    GridCells$Fixed gridCells$Fixed2 = new GridCells$Fixed(iMin);
                                                                                    SnapFlingBehavior snapFlingBehaviorRememberSnapFlingBehavior2 = SQLite.rememberSnapFlingBehavior(snapLayoutInfoProvider5, gapComposer4);
                                                                                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                                                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                                                                                    Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(modifierFillMaxWidth2, (64.0f * iMin) + CropImageView.DEFAULT_ASPECT_RATIO);
                                                                                    boolean zChangedInstance13 = gapComposer4.changedInstance(list19);
                                                                                    MusicDatabase musicDatabase5 = musicDatabase3;
                                                                                    boolean zChangedInstance14 = zChangedInstance13 | gapComposer4.changedInstance(musicDatabase5);
                                                                                    State state16 = state10;
                                                                                    boolean zChanged36 = zChangedInstance14 | gapComposer4.changed(state16);
                                                                                    State state17 = state11;
                                                                                    boolean zChanged37 = zChanged36 | gapComposer4.changed(state17);
                                                                                    float f5 = f3;
                                                                                    boolean zChanged38 = zChanged37 | gapComposer4.changed(f5);
                                                                                    HapticFeedback hapticFeedback4 = hapticFeedback2;
                                                                                    boolean zChangedInstance15 = zChanged38 | gapComposer4.changedInstance(hapticFeedback4);
                                                                                    MenuState menuState4 = menuState2;
                                                                                    boolean zChanged39 = zChangedInstance15 | gapComposer4.changed(menuState4);
                                                                                    boolean z7 = z5;
                                                                                    boolean zChanged40 = zChanged39 | gapComposer4.changed(z7);
                                                                                    PlayerConnection playerConnection4 = playerConnection2;
                                                                                    boolean zChangedInstance16 = zChanged40 | gapComposer4.changedInstance(playerConnection4);
                                                                                    MutableState mutableState24 = mutableState21;
                                                                                    boolean zChanged41 = zChangedInstance16 | gapComposer4.changed(mutableState24);
                                                                                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                                                                                    if (zChanged41 || objRememberedValue6 == neverEqualPolicy3) {
                                                                                        HomeScreenKt$$ExternalSyntheticLambda59 homeScreenKt$$ExternalSyntheticLambda510 = new HomeScreenKt$$ExternalSyntheticLambda59(list19, musicDatabase5, f5, hapticFeedback4, menuState4, z7, state16, playerConnection4, mutableState24, state17, (byte) 0);
                                                                                        gapComposer4.updateRememberedValue(homeScreenKt$$ExternalSyntheticLambda510);
                                                                                        objRememberedValue6 = homeScreenKt$$ExternalSyntheticLambda510;
                                                                                    }
                                                                                    LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed2, modifierM145height3ABfNKs2, lazyGridState4, insetsPaddingValues2, null, null, snapFlingBehaviorRememberSnapFlingBehavior2, false, null, null, (Function1) objRememberedValue6, gapComposer4, 0, 1904);
                                                                                } else {
                                                                                    gapComposer4.skipToGroupEnd();
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit2;
                                                                    }
                                                                }), 2);
                                                            }
                                                        }
                                                    } else if (homeSection instanceof HomeSection.SimilarRecommendation) {
                                                        List list17 = (List) mutableState12.getValue();
                                                        SimilarRecommendation similarRecommendation = list17 != null ? (SimilarRecommendation) CollectionsKt.getOrNull(((HomeSection.SimilarRecommendation) homeSection).index, list17) : null;
                                                        if (similarRecommendation != null) {
                                                            int i5 = ((HomeSection.SimilarRecommendation) homeSection).index;
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(i5, "similar_to_title_"), null, new ComposableLambdaImpl(true, 1503444903, new AlbumMenuKt$$ExternalSyntheticLambda11(similarRecommendation, navHostController3, (byte) 19)), 2);
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(i5, "similar_to_list_"), null, new ComposableLambdaImpl(true, -180779696, new PlayerKt$$ExternalSyntheticLambda82(paddingValuesImpl4, similarRecommendation, composableLambdaImpl7, (byte) 11)), 2);
                                                        }
                                                    } else if (homeSection instanceof HomeSection.HomePageSection) {
                                                        HomePage.Chip chip2 = (HomePage.Chip) mutableState16.getValue();
                                                        if (chip2 == null || (str4 = chip2.title) == null) {
                                                            str2 = str8;
                                                        } else {
                                                            str2 = str8;
                                                            if (!StringsKt.contains(str4, str2, true)) {
                                                            }
                                                            composableLambdaImpl3 = composableLambdaImpl7;
                                                        }
                                                        HomePage homePage3 = (HomePage) mutableState15.getValue();
                                                        HomePage.Section section2 = homePage3 != null ? (HomePage.Section) CollectionsKt.getOrNull(((HomeSection.HomePageSection) homeSection).index, homePage3.sections) : null;
                                                        if (section2 != null) {
                                                            List list18 = section2.items;
                                                            final ArrayList arrayList3 = new ArrayList();
                                                            for (Object obj8 : list18) {
                                                                if (obj8 instanceof SongItem) {
                                                                    arrayList3.add(obj8);
                                                                }
                                                            }
                                                            boolean z6 = !arrayList3.isEmpty();
                                                            if (list18.isEmpty()) {
                                                                z4 = false;
                                                            } else {
                                                                if (!list18.isEmpty()) {
                                                                    Iterator it4 = list18.iterator();
                                                                    while (true) {
                                                                        if (it4.hasNext()) {
                                                                            if (!(((YTItem) it4.next()) instanceof SongItem)) {
                                                                                z4 = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                z4 = true;
                                                            }
                                                            final HomeSection.HomePageSection homePageSection2 = (HomeSection.HomePageSection) homeSection;
                                                            int i6 = homePageSection2.index;
                                                            NavHostController navHostController5 = navHostController3;
                                                            HomePage.Section section3 = section2;
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(i6, "home_section_title_"), null, new ComposableLambdaImpl(true, 2062089639, new HomeScreenKt$$ExternalSyntheticLambda40(section3, z6, z5, playerConnection2, arrayList3, navHostController5)), 2);
                                                            if (z4) {
                                                                LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(i6, "home_section_list_"), null, new ComposableLambdaImpl(true, -1823067540, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda41
                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Object invoke(Object obj9, Object obj10, Object obj11) {
                                                                        Composer composer3 = (Composer) obj10;
                                                                        int iIntValue3 = ((Integer) obj11).intValue();
                                                                        ((LazyItemScopeImpl) obj9).getClass();
                                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                            HomeSection.HomePageSection homePageSection3 = homePageSection2;
                                                                            boolean zChanged29 = gapComposer3.changed("section_" + homePageSection3.index + "_grid");
                                                                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                                                                            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                                                            if (zChanged29 || objRememberedValue4 == neverEqualPolicy3) {
                                                                                objRememberedValue4 = new LazyGridState(0, 0);
                                                                                gapComposer3.updateRememberedValue(objRememberedValue4);
                                                                            }
                                                                            LazyGridState lazyGridState5 = (LazyGridState) objRememberedValue4;
                                                                            GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(4);
                                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                                                                            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                                                            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth, 256.0f);
                                                                            ArrayList arrayList4 = arrayList3;
                                                                            boolean zChangedInstance9 = gapComposer3.changedInstance(arrayList4) | gapComposer3.changedInstance(homePageSection3);
                                                                            State state14 = state10;
                                                                            boolean zChanged30 = zChangedInstance9 | gapComposer3.changed(state14);
                                                                            State state15 = state11;
                                                                            boolean zChanged31 = zChanged30 | gapComposer3.changed(state15);
                                                                            float f4 = f3;
                                                                            boolean zChanged32 = zChanged31 | gapComposer3.changed(f4);
                                                                            HapticFeedback hapticFeedback3 = hapticFeedback2;
                                                                            boolean zChangedInstance10 = zChanged32 | gapComposer3.changedInstance(hapticFeedback3);
                                                                            MenuState menuState3 = menuState2;
                                                                            boolean zChanged33 = zChangedInstance10 | gapComposer3.changed(menuState3);
                                                                            boolean z7 = z5;
                                                                            boolean zChanged34 = zChanged33 | gapComposer3.changed(z7);
                                                                            PlayerConnection playerConnection3 = playerConnection2;
                                                                            boolean zChangedInstance11 = zChanged34 | gapComposer3.changedInstance(playerConnection3);
                                                                            MutableState mutableState23 = mutableState21;
                                                                            boolean zChanged35 = zChangedInstance11 | gapComposer3.changed(mutableState23);
                                                                            Object objRememberedValue5 = gapComposer3.rememberedValue();
                                                                            if (zChanged35 || objRememberedValue5 == neverEqualPolicy3) {
                                                                                HomeScreenKt$$ExternalSyntheticLambda59 homeScreenKt$$ExternalSyntheticLambda59 = new HomeScreenKt$$ExternalSyntheticLambda59(arrayList4, homePageSection3, f4, hapticFeedback3, menuState3, z7, playerConnection3, mutableState23, state14, state15);
                                                                                gapComposer3.updateRememberedValue(homeScreenKt$$ExternalSyntheticLambda59);
                                                                                objRememberedValue5 = homeScreenKt$$ExternalSyntheticLambda59;
                                                                            }
                                                                            LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM145height3ABfNKs, lazyGridState5, insetsPaddingValues2, null, null, null, false, null, null, (Function1) objRememberedValue5, gapComposer3, 0, 2032);
                                                                        } else {
                                                                            gapComposer3.skipToGroupEnd();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), 2);
                                                                composableLambdaImpl3 = composableLambdaImpl7;
                                                                navHostController3 = navHostController5;
                                                                paddingValuesImpl4 = paddingValuesImpl4;
                                                            } else {
                                                                String strM = IntIntPair$$ExternalSyntheticOutline0.m(i6, "home_section_list_");
                                                                navHostController3 = navHostController5;
                                                                paddingValuesImpl4 = paddingValuesImpl4;
                                                                composableLambdaImpl3 = composableLambdaImpl7;
                                                                LazyListIntervalContent.item$default(lazyListIntervalContent, strM, null, new ComposableLambdaImpl(true, 1076794499, new SongMenuKt$$ExternalSyntheticLambda34(paddingValuesImpl4, section3, homePageSection2, composableLambdaImpl3, (byte) 12)), 2);
                                                            }
                                                        } else {
                                                            composableLambdaImpl3 = composableLambdaImpl7;
                                                        }
                                                    } else {
                                                        navHostController3 = navHostController3;
                                                        paddingValuesImpl4 = paddingValuesImpl4;
                                                        str2 = str8;
                                                        composableLambdaImpl3 = composableLambdaImpl7;
                                                        byte b12 = 0;
                                                        if (!Intrinsics.areEqual(homeSection, HomeSection.MoodAndGenres.INSTANCE)) {
                                                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                            return null;
                                                        }
                                                        HomePage.Chip chip3 = (HomePage.Chip) mutableState16.getValue();
                                                        if ((chip3 == null || (str3 = chip3.title) == null || !StringsKt.contains(str3, str2, true)) && (explorePage = (ExplorePage) mutableState13.getValue()) != null) {
                                                            List list19 = explorePage.moodAndGenres;
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "mood_and_genres_title", null, new ComposableLambdaImpl(true, 698835099, new HomeScreenKt$$ExternalSyntheticLambda43(navHostController3, b12)), 2);
                                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "mood_and_genres_list", null, new ComposableLambdaImpl(true, -1061810222, new HomeScreenKt$$ExternalSyntheticLambda44(list19, navHostController3, (byte) 0)), 2);
                                                        }
                                                    }
                                                    str2 = str8;
                                                    composableLambdaImpl3 = composableLambdaImpl7;
                                                }
                                            }
                                        }
                                        navHostController3 = navHostController3;
                                        paddingValuesImpl4 = paddingValuesImpl4;
                                        composableLambdaImpl3 = composableLambdaImpl7;
                                        str2 = str8;
                                    }
                                    b2 = b3;
                                    str6 = str2;
                                    paddingValuesImpl3 = paddingValuesImpl4;
                                    composableLambdaImpl6 = composableLambdaImpl3;
                                    it2 = it3;
                                    navHostController3 = navHostController3;
                                }
                                boolean z7 = b2;
                                PaddingValuesImpl paddingValuesImpl5 = paddingValuesImpl3;
                                if (((Boolean) mutableState19.getValue()).booleanValue()) {
                                    HomePage homePage4 = (HomePage) mutableState15.getValue();
                                    List list20 = homePage4 != null ? homePage4.sections : null;
                                    if (list20 == null || list20.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "loading_shimmer", null, new ComposableLambdaImpl(z7, 1910864253, new HomeScreenKt$$ExternalSyntheticLambda37(paddingValuesImpl5, z7 ? (byte) 1 : (byte) 0)), 2);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        navHostController = navHostController2;
                        boxWithConstraintsScopeImpl = boxWithConstraintsScopeImpl2;
                        musicDatabase = musicDatabase2;
                        z = z3;
                        coroutineScope = coroutineScope2;
                        gapComposer2.updateRememberedValue(obj4);
                    } else {
                        boxWithConstraintsScopeImpl = boxWithConstraintsScopeImpl2;
                        navHostController = navHostController2;
                        z = z3;
                        coroutineScope = coroutineScope2;
                        musicDatabase = musicDatabase2;
                        obj4 = objRememberedValue3;
                        neverEqualPolicy = neverEqualPolicy2;
                    }
                    LazyListState lazyListState = this.f$2;
                    IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) obj4, gapComposer2, 0, 505);
                    State state8 = this.f$37;
                    boolean zIsEmpty = ((List) state8.getValue()).isEmpty();
                    State state9 = this.f$38;
                    boolean z4 = (zIsEmpty && ((List) state9.getValue()).isEmpty()) ? false : true;
                    boolean zChanged29 = gapComposer2.changed(z) | gapComposer2.changed(state8) | gapComposer2.changed(state9) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(r23) | gapComposer2.changedInstance(musicDatabase);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged29 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda25(z, coroutineScope, state8, state9, playerConnection, musicDatabase);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function0 = (Function0) objRememberedValue4;
                    boolean zChangedInstance9 = gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChangedInstance9 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 15);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    MenuKt.HideOnScrollFAB(boxWithConstraintsScopeImpl, z4, lazyListState, R.drawable.shuffle, function0, (Function0) objRememberedValue5, gapComposer2, i2, 0);
                }
                break;
        }
        return unit;
    }
}
