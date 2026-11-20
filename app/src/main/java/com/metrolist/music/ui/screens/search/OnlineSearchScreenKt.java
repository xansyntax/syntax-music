package com.metrolist.music.ui.screens.search;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.LyricsMenuKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$Queue_TBEEUPw$lambda$45$13$0$0$$inlined$itemsIndexed$6;
import com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$lambda$22$0$$inlined$itemsIndexed$3;
import com.metrolist.music.ui.screens.settings.AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel;
import com.metrolist.music.viewmodels.SearchSuggestionViewState;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import io.ktor.utils.io.ByteChannelKt;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OnlineSearchScreenKt {
    public static final void OnlineSearchScreen(final String str, final Function1 function1, final Function1 function2, final Function0 function0, final boolean z, OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel, Composer composer, final int i) {
        int i2;
        final Function1 function3;
        Function0 function4;
        GapComposer gapComposer;
        final OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel2;
        OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel3;
        int i3;
        boolean z2;
        boolean z3;
        long j;
        str.getClass();
        function1.getClass();
        function2.getClass();
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-876753612);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function3 = function2;
            i2 |= gapComposer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function2;
        }
        if ((i & 3072) == 0) {
            function4 = function0;
            i2 |= gapComposer2.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function0;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= 65536;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    onlineSearchSuggestionViewModel3 = (OnlineSearchSuggestionViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(OnlineSearchSuggestionViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
                    i3 = i2 & (-458753);
                }
            } else {
                gapComposer2.skipToGroupEnd();
                i3 = i2 & (-458753);
                onlineSearchSuggestionViewModel3 = onlineSearchSuggestionViewModel;
            }
            gapComposer2.endDefaults();
            final NavHostController navHostController = (NavHostController) gapComposer2.consume(MainActivityKt.LocalNavController);
            final MusicDatabase musicDatabase = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer2.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            final MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
            final PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    final Function0 function5 = function4;
                    final OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel4 = onlineSearchSuggestionViewModel3;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = b;
                            Unit unit = Unit.INSTANCE;
                            int i4 = i;
                            switch (b2) {
                                case 0:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                    OnlineSearchScreenKt.OnlineSearchScreen(str, function1, function3, function5, z, onlineSearchSuggestionViewModel4, (Composer) obj, iUpdateChangedFlags);
                                    break;
                                default:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4 | 1);
                                    OnlineSearchScreenKt.OnlineSearchScreen(str, function1, function3, function5, z, onlineSearchSuggestionViewModel4, (Composer) obj, iUpdateChangedFlags2);
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel5 = onlineSearchSuggestionViewModel3;
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer2.consume(CompositionLocalsKt.LocalHapticFeedback);
            final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(onlineSearchSuggestionViewModel5.viewState, gapComposer2);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.AutoRadioQueueKey, Boolean.TRUE, gapComposer2, 48);
            boolean zChanged = gapComposer2.changed(lazyListStateRememberLazyListState) | gapComposer2.changed(softwareKeyboardController);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                z2 = true;
                objRememberedValue2 = new LocalSearchScreenKt$LocalSearchScreen$1$1(lazyListStateRememberLazyListState, softwareKeyboardController, null, (byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                z2 = true;
            }
            Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue2);
            boolean zChangedInstance = ((i3 & 14) == 4 ? z2 : false) | gapComposer2.changedInstance(onlineSearchSuggestionViewModel5);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new DataStoreKt$get$1(str, onlineSearchSuggestionViewModel5, (Continuation) null, (byte) 16);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            Stack.LaunchedEffect(gapComposer2, str, (Function2) objRememberedValue3);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 32), gapComposer2);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            if (z) {
                gapComposer2.startReplaceGroup(-746579719);
                z3 = false;
                gapComposer2.end(false);
                j = -72057594037927936L;
            } else {
                z3 = false;
                gapComposer2.startReplaceGroup(-746578530);
                j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                gapComposer2.end(false);
            }
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, j, ColorKt.RectangleShape);
            boolean zChanged2 = ((i3 & 57344) == 16384) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | ((i3 & 7168) == 2048 ? true : z3) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changedInstance(navHostController) | ((i3 & 896) == 256) | gapComposer2.changedInstance(musicDatabase) | ((i3 & 112) == 32);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                Function1 function6 = new Function1() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda1
                    /* JADX WARN: Code duplicated, block: B:13:0x012d  */
                    /* JADX WARN: Type inference failed for: r14v1 */
                    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, byte] */
                    /* JADX WARN: Type inference failed for: r14v3 */
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ?? r14;
                        byte b2;
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                        lazyListIntervalContent.getClass();
                        State state = mutableStateCollectAsStateWithLifecycle3;
                        boolean z4 = ((SearchSuggestionViewState) state.getValue()).isUrlQuery;
                        HapticFeedback hapticFeedback2 = hapticFeedback;
                        MenuState menuState2 = menuState;
                        Function0 function7 = function0;
                        CoroutineScope coroutineScope2 = coroutineScope;
                        State state2 = mutableStateCollectAsStateWithLifecycle2;
                        PlayerConnection playerConnection2 = playerConnection;
                        MutableState mutableState = dataStoreKt$rememberPreference$1$1RememberPreference;
                        NavHostController navHostController2 = navHostController;
                        boolean z5 = z;
                        State state3 = mutableStateCollectAsStateWithLifecycle;
                        if (!z4 || ((SearchSuggestionViewState) state.getValue()).parsedUrlItem == null) {
                            r14 = 1;
                        } else {
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "parsed_url_header", null, LocalSearchScreenKt.f431lambda$2067521948, 2);
                            r14 = 1;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "parsed_url_item", null, new ComposableLambdaImpl(true, -1205488165, new LyricsMenuKt$$ExternalSyntheticLambda21(hapticFeedback2, menuState2, function7, coroutineScope2, state2, playerConnection2, mutableState, navHostController2, z5, state, state3)), 2);
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "parsed_url_divider", null, LocalSearchScreenKt.f430lambda$2042283108, 2);
                        }
                        List list = ((SearchSuggestionViewState) state.getValue()).history;
                        LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 27);
                        LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda6 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 28);
                        int size = list.size();
                        ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 14);
                        ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 scrimBlurEffect$drawEffect$$inlined$withAlpha$1$2 = new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(localSearchScreenKt$$ExternalSyntheticLambda6, list, (byte) 15);
                        Function1 function8 = function2;
                        MusicDatabase musicDatabase2 = musicDatabase;
                        Function1 function9 = function1;
                        lazyListIntervalContent.items(size, scrimBlurEffect$drawEffect$$inlined$withAlpha$1$1, scrimBlurEffect$drawEffect$$inlined$withAlpha$1$2, new ComposableLambdaImpl(r14, 802480018, new QueueKt$Queue_TBEEUPw$lambda$45$13$0$0$$inlined$itemsIndexed$6(list, function8, function7, musicDatabase2, function9, z5)));
                        List list2 = ((SearchSuggestionViewState) state.getValue()).suggestions;
                        lazyListIntervalContent.items(list2.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 29), list2, (byte) 16), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new InnerTubeXPlayer$$ExternalSyntheticLambda3(r14), list2, (byte) 17), new ComposableLambdaImpl(r14, 802480018, new AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1(list2, function8, function7, function9, z5, (byte) 1)));
                        if (((SearchSuggestionViewState) state.getValue()).items.isEmpty()) {
                            b2 = 2;
                        } else {
                            if (((SearchSuggestionViewState) state.getValue()).suggestions.size() + ((SearchSuggestionViewState) state.getValue()).history.size() > 0) {
                                b2 = 2;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "search_divider", null, LocalSearchScreenKt.lambda$1939284955, 2);
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "search_divider_spacer", null, LocalSearchScreenKt.lambda$1425062290, 2);
                            } else {
                                b2 = 2;
                            }
                        }
                        List list3 = ((SearchSuggestionViewState) state.getValue()).items;
                        lazyListIntervalContent.items(list3.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new InnerTubeXPlayer$$ExternalSyntheticLambda3(b2), list3, (byte) 18), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 3), list3, (byte) 19), new ComposableLambdaImpl(r14, 802480018, new AlbumScreenKt$AlbumScreen$lambda$22$0$$inlined$itemsIndexed$3(list3, hapticFeedback2, menuState2, function7, coroutineScope2, state2, playerConnection2, mutableState, navHostController2, z5, state3)));
                        return Unit.INSTANCE;
                    }
                };
                gapComposer2.updateRememberedValue(function6);
                objRememberedValue4 = function6;
            }
            gapComposer = gapComposer2;
            IntMath.LazyColumn(modifierM39backgroundbw27NRU, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer, 0, 504);
            onlineSearchSuggestionViewModel2 = onlineSearchSuggestionViewModel5;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            onlineSearchSuggestionViewModel2 = onlineSearchSuggestionViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = b2;
                    Unit unit = Unit.INSTANCE;
                    int i4 = i;
                    switch (b3) {
                        case 0:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            OnlineSearchScreenKt.OnlineSearchScreen(str, function1, function2, function0, z, onlineSearchSuggestionViewModel2, (Composer) obj, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i4 | 1);
                            OnlineSearchScreenKt.OnlineSearchScreen(str, function1, function2, function0, z, onlineSearchSuggestionViewModel2, (Composer) obj, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void SuggestionItem(Modifier modifier, final String str, final boolean z, final Function0 function0, Function0 function1, final Function0 function2, final boolean z2, Composer composer, final int i, final int i2) {
        Function0 function3;
        int i3;
        final Modifier modifier2;
        final Function0 function4;
        Function0 function5;
        long j;
        str.getClass();
        function0.getClass();
        function2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(667102004);
        int i4 = i | 6 | (gapComposer.changed(str) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 2048 : 1024);
        int i5 = i2 & 16;
        if (i5 != 0) {
            i3 = i4 | 24576;
            function3 = function1;
        } else {
            function3 = function1;
            i3 = i4 | (gapComposer.changedInstance(function3) ? 16384 : 8192);
        }
        int i6 = i3 | (gapComposer.changedInstance(function2) ? 131072 : 65536) | (gapComposer.changed(z2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer.shouldExecute(i6 & 1, (599187 & i6) != 599186)) {
            if (i5 != 0) {
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 23);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                function5 = (Function0) objRememberedValue;
            } else {
                function5 = function3;
            }
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(DialogKt.pressScale(companion, 0.985f), 1.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth, 56.0f);
            if (z2) {
                gapComposer.startReplaceGroup(1134914105);
                gapComposer.end(false);
                j = -72057594037927936L;
            } else {
                gapComposer.startReplaceGroup(1134915294);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                gapComposer.end(false);
            }
            Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(ImageKt.m39backgroundbw27NRU(modifierM145height3ABfNKs, j, ColorKt.RectangleShape), false, null, function0, 15);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(OffsetKt.windowInsetsPadding(modifierM46clickableoSLSa3U$default, new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15)), gapComposer, 0);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM1473hairlineBottomiJQMabo);
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
            Painter painterPainterResource = IntMath.painterResource(z ? R.drawable.search : R.drawable.history, 0, gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10), 20.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, gapComposer, 440, 0);
            TextKt.m352TextNvy7gAk(str, new LayoutWeightElement(1.0f, true), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer, (i6 >> 3) & 14, 24960, 110584);
            gapComposer = gapComposer;
            if (z) {
                gapComposer.startReplaceGroup(1942023442);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1941690936);
                CardKt.IconButton(function5, null, false, null, null, LocalSearchScreenKt.lambda$1622225079, gapComposer, ((i6 >> 12) & 14) | 1572864, 62);
                gapComposer.end(false);
            }
            CardKt.IconButton(function2, null, false, null, null, LocalSearchScreenKt.f435lambda$797866126, gapComposer, ((i6 >> 15) & 14) | 1572864, 62);
            gapComposer.end(true);
            function4 = function5;
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            function4 = function3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(str, z, function0, function4, function2, z2, i, i2) { // from class: com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda14
                public final /* synthetic */ String f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ Function0 f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Function0 f$5;
                public final /* synthetic */ boolean f$6;
                public final /* synthetic */ byte f$8;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f$8 = i2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(385);
                    OnlineSearchScreenKt.SuggestionItem(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags, this.f$8);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
