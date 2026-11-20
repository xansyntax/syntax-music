package com.metrolist.music.ui.screens.search;

import android.os.Bundle;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
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
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda2;
import coil3.RealImageLoader$execute$result$1;
import coil3.size.ViewSizeResolver$size$3$1;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.SearchSummaryPage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda49;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OnlineSearchResultKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v79 */
    public static final void OnlineSearchResult(OnlineSearchViewModel onlineSearchViewModel, final SavedStateHandle savedStateHandle, Composer composer, final int i) {
        final byte b;
        final OnlineSearchViewModel onlineSearchViewModel2;
        final OnlineSearchViewModel onlineSearchViewModel3;
        MutableState mutableStateCollectAsStateWithLifecycle;
        int i2;
        String string;
        FocusOwner focusOwner;
        final CoroutineScope coroutineScope;
        MutableState mutableState;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        boolean z;
        boolean z2;
        Bundle arguments$navigation_common_release;
        final byte b2 = 0;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1818542017);
        int i3 = i | 50 | (gapComposer.changedInstance(savedStateHandle) ? 256 : 128);
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                onlineSearchViewModel3 = (OnlineSearchViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(OnlineSearchViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
            } else {
                gapComposer.skipToGroupEnd();
                onlineSearchViewModel3 = onlineSearchViewModel;
            }
            gapComposer.endDefaults();
            final NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            final MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            final PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(onlineSearchViewModel3, savedStateHandle, i, b2) { // from class: com.metrolist.music.ui.screens.search.OnlineSearchResultKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ OnlineSearchViewModel f$0;
                        public final /* synthetic */ SavedStateHandle f$2;

                        {
                            this.$r8$classId = b2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            SavedStateHandle savedStateHandle2 = this.f$2;
                            OnlineSearchViewModel onlineSearchViewModel4 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b3) {
                                case 0:
                                    OnlineSearchResultKt.OnlineSearchResult(onlineSearchViewModel4, savedStateHandle2, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    OnlineSearchResultKt.OnlineSearchResult(onlineSearchViewModel4, savedStateHandle2, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer);
            final MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            final FocusOwner focusOwner2 = (FocusOwner) gapComposer.consume(CompositionLocalsKt.LocalFocusManager);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FocusRequester();
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
            ReadonlyStateFlow stateFlow = savedStateHandle != null ? savedStateHandle.getStateFlow(0, "scrollToTopCount") : null;
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(533126581);
                gapComposer.end(false);
                i2 = 0;
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(432839628);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, 0, gapComposer, 48);
                i2 = 0;
                gapComposer.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle == null) {
                gapComposer.startReplaceGroup(533174818);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Fragment$5$$ExternalSyntheticOutline0.m(i2, gapComposer);
                }
                mutableStateCollectAsStateWithLifecycle = (ParcelableSnapshotMutableIntState) objRememberedValue3;
            } else {
                gapComposer.startReplaceGroup(432837402);
            }
            gapComposer.end(i2);
            Object[] objArr = new Object[i2];
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 22);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue4, gapComposer, 48);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue5;
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            Integer numValueOf = Integer.valueOf(((Number) mutableStateCollectAsStateWithLifecycle.getValue()).intValue());
            boolean zChanged = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(softwareKeyboardController);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new RealImageLoader$execute$result$1((Object) focusRequester, (Object) softwareKeyboardController, (Object) mutableStateCollectAsStateWithLifecycle, (Object) parcelableSnapshotMutableIntState, (Object) mutableState2, (Continuation) null, (byte) 15);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Stack.LaunchedEffect(gapComposer, numValueOf, (Function2) objRememberedValue6);
            Preferences$Key preferences$Key = PreferenceKeysKt.PauseSearchHistoryKey;
            Boolean bool = Boolean.FALSE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key, bool, gapComposer, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.HideVideoSongsKey, bool, gapComposer, 48);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.AutoRadioQueueKey, Boolean.TRUE, gapComposer, 48);
            boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
            boolean zChangedInstance = gapComposer.changedInstance(focusOwner2);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == neverEqualPolicy) {
                final byte b3 = 1;
                objRememberedValue7 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchResultKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        MutableState mutableState3 = mutableState2;
                        FocusOwner focusOwner3 = focusOwner2;
                        switch (b4) {
                            case 0:
                                mutableState3.setValue(Boolean.FALSE);
                                ((FocusOwnerImpl) focusOwner3).m409clearFocusI7lrPNg(8, false, true);
                                break;
                            default:
                                mutableState3.setValue(Boolean.FALSE);
                                ((FocusOwnerImpl) focusOwner3).m409clearFocusI7lrPNg(8, false, true);
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            UtilsKt.BackHandler(zBooleanValue, (Function0) objRememberedValue7, gapComposer, 0, 0);
            NavBackStackEntry currentBackStackEntry$navigation_runtime_release = navHostController.impl.getCurrentBackStackEntry$navigation_runtime_release();
            if (currentBackStackEntry$navigation_runtime_release == null || (arguments$navigation_common_release = currentBackStackEntry$navigation_runtime_release.impl.getArguments$navigation_common_release()) == null || (string = arguments$navigation_common_release.getString("query")) == null) {
                string = "";
            }
            boolean zChanged2 = gapComposer.changed(string);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = StringsKt.removePrefix(string, "__metrolist_search_query__");
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            String str = (String) objRememberedValue8;
            Object[] objArr2 = new Object[0];
            boolean zChanged3 = gapComposer.changed(str);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new NavDestinationImpl$$ExternalSyntheticLambda2(str, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) TextFieldValue.Saver, (Function0) objRememberedValue9, (Composer) gapComposer, 0);
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                focusOwner = focusOwner2;
                SongMenuKt$$ExternalSyntheticLambda20 songMenuKt$$ExternalSyntheticLambda20 = new SongMenuKt$$ExternalSyntheticLambda20(focusOwner, navHostController, mutableState2, coroutineScope2, dataStoreKt$rememberPreference$1$1RememberPreference, musicDatabase);
                coroutineScope = coroutineScope2;
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda20);
                objRememberedValue10 = songMenuKt$$ExternalSyntheticLambda20;
            } else {
                focusOwner = focusOwner2;
                coroutineScope = coroutineScope2;
            }
            Function1 function1 = (Function1) objRememberedValue10;
            boolean zChanged4 = gapComposer.changed(mutableStateRememberSaveable) | gapComposer.changed(str);
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = new InterruptibleKt$runInterruptible$2(str, mutableStateRememberSaveable, null, (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            Stack.LaunchedEffect(gapComposer, str, (Function2) objRememberedValue11);
            Boolean bool2 = (Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue();
            bool2.getClass();
            boolean zChanged5 = gapComposer.changed(dataStoreKt$rememberPreference$1$1RememberPreference2) | gapComposer.changedInstance(onlineSearchViewModel3);
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = new InterruptibleKt$runInterruptible$2(onlineSearchViewModel3, dataStoreKt$rememberPreference$1$1RememberPreference2, null, (byte) 9);
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            Stack.LaunchedEffect(gapComposer, bool2, (Function2) objRememberedValue12);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(onlineSearchViewModel3.filter, gapComposer);
            SearchSummaryPage searchSummaryPage = (SearchSummaryPage) onlineSearchViewModel3.summaryPage$delegate.getValue();
            String strOnlineSearchResult$lambda$24 = OnlineSearchResult$lambda$24(mutableStateCollectAsStateWithLifecycle4);
            boolean zChanged6 = gapComposer.changed(strOnlineSearchResult$lambda$24 != null ? new YouTube.SearchFilter(strOnlineSearchResult$lambda$24) : null);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new QueueKt$$ExternalSyntheticLambda16(mutableStateCollectAsStateWithLifecycle4, onlineSearchViewModel3, (byte) 21));
                gapComposer.updateRememberedValue(objRememberedValue13);
            }
            State state = (State) objRememberedValue13;
            boolean zChanged7 = gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changedInstance(onlineSearchViewModel3);
            Object objRememberedValue14 = gapComposer.rememberedValue();
            byte b4 = 15;
            if (zChanged7 || objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = new DataStoreKt$get$1(lazyListStateRememberLazyListState, onlineSearchViewModel3, (Continuation) null, b4);
                gapComposer.updateRememberedValue(objRememberedValue14);
            }
            Stack.LaunchedEffect(gapComposer, lazyListStateRememberLazyListState, (Function2) objRememberedValue14);
            final FocusOwner focusOwner3 = focusOwner;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-969094557, new Function4() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchResultKt$$ExternalSyntheticLambda13
                /* JADX WARN: Code duplicated, block: B:33:0x00d5  */
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    YTItem yTItem;
                    Object homeScreenKt$$ExternalSyntheticLambda9;
                    boolean z3;
                    boolean zAreEqual;
                    MediaMetadata.Album album;
                    PlayerConnection playerConnection2;
                    MutableState mutableState3;
                    NavHostController navHostController2;
                    boolean zChangedInstance2;
                    Object objRememberedValue15;
                    YTItem yTItem2 = (YTItem) obj2;
                    int iIntValue = ((Integer) obj4).intValue();
                    ((LazyItemScopeImpl) obj).getClass();
                    yTItem2.getClass();
                    GapComposer gapComposer2 = (GapComposer) ((Composer) obj3);
                    HapticFeedback hapticFeedback2 = hapticFeedback;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(hapticFeedback2);
                    MenuState menuState2 = menuState;
                    boolean zChanged8 = zChangedInstance3 | gapComposer2.changed(menuState2) | gapComposer2.changedInstance(yTItem2);
                    CoroutineScope coroutineScope3 = coroutineScope;
                    boolean zChangedInstance4 = zChanged8 | gapComposer2.changedInstance(coroutineScope3);
                    Object objRememberedValue16 = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                    if (zChangedInstance4 || objRememberedValue16 == neverEqualPolicy2) {
                        yTItem = yTItem2;
                        homeScreenKt$$ExternalSyntheticLambda9 = new HomeScreenKt$$ExternalSyntheticLambda9(hapticFeedback2, menuState2, yTItem, coroutineScope3, (byte) 2);
                        gapComposer2.updateRememberedValue(homeScreenKt$$ExternalSyntheticLambda9);
                    } else {
                        yTItem = yTItem2;
                        homeScreenKt$$ExternalSyntheticLambda9 = objRememberedValue16;
                    }
                    Function0 function0 = (Function0) homeScreenKt$$ExternalSyntheticLambda9;
                    boolean z4 = yTItem instanceof SongItem;
                    State state2 = mutableStateCollectAsStateWithLifecycle3;
                    String str2 = null;
                    if (z4) {
                        MediaMetadata mediaMetadata = (MediaMetadata) state2.getValue();
                        zAreEqual = Intrinsics.areEqual(mediaMetadata != null ? mediaMetadata.id : null, ((SongItem) yTItem).id);
                    } else {
                        if (!(yTItem instanceof AlbumItem)) {
                            if (yTItem instanceof EpisodeItem) {
                                MediaMetadata mediaMetadata2 = (MediaMetadata) state2.getValue();
                                zAreEqual = Intrinsics.areEqual(mediaMetadata2 != null ? mediaMetadata2.id : null, ((EpisodeItem) yTItem).id);
                            } else {
                                z3 = false;
                            }
                            boolean zBooleanValue2 = ((Boolean) mutableStateCollectAsStateWithLifecycle2.getValue()).booleanValue();
                            boolean zChangedInstance5 = gapComposer2.changedInstance(yTItem) | gapComposer2.changed(state2);
                            playerConnection2 = playerConnection;
                            boolean zChangedInstance6 = zChangedInstance5 | gapComposer2.changedInstance(playerConnection2);
                            mutableState3 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                            boolean zChanged9 = zChangedInstance6 | gapComposer2.changed(mutableState3);
                            navHostController2 = navHostController;
                            zChangedInstance2 = zChanged9 | gapComposer2.changedInstance(navHostController2);
                            objRememberedValue15 = gapComposer2.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue15 == neverEqualPolicy2) {
                                YTItem yTItem3 = yTItem;
                                SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(yTItem3, playerConnection2, navHostController2, state2, mutableState3, (byte) 26);
                                yTItem = yTItem3;
                                gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                                objRememberedValue15 = songMenuKt$$ExternalSyntheticLambda40;
                            }
                            MenuKt.YouTubeListItem(yTItem, ImageKt.m48combinedClickablehoGz1lA$default(Modifier.Companion.$$INSTANCE, false, function0, (Function0) objRememberedValue15, 239), false, z3, zBooleanValue2, false, null, Expect_jvmKt.rememberComposableLambda(-656895684, new PlayerMenuKt$$ExternalSyntheticLambda49(function0, (byte) 6), gapComposer2), null, gapComposer2, ((iIntValue >> 3) & 14) | 100663296, 716);
                            return Unit.INSTANCE;
                        }
                        MediaMetadata mediaMetadata3 = (MediaMetadata) state2.getValue();
                        if (mediaMetadata3 != null && (album = mediaMetadata3.album) != null) {
                            str2 = album.id;
                        }
                        zAreEqual = Intrinsics.areEqual(str2, ((AlbumItem) yTItem).id);
                    }
                    z3 = zAreEqual;
                    boolean zBooleanValue3 = ((Boolean) mutableStateCollectAsStateWithLifecycle2.getValue()).booleanValue();
                    boolean zChangedInstance7 = gapComposer2.changedInstance(yTItem) | gapComposer2.changed(state2);
                    playerConnection2 = playerConnection;
                    boolean zChangedInstance8 = zChangedInstance7 | gapComposer2.changedInstance(playerConnection2);
                    mutableState3 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                    boolean zChanged10 = zChangedInstance8 | gapComposer2.changed(mutableState3);
                    navHostController2 = navHostController;
                    zChangedInstance2 = zChanged10 | gapComposer2.changedInstance(navHostController2);
                    objRememberedValue15 = gapComposer2.rememberedValue();
                    if (zChangedInstance2) {
                        YTItem yTItem4 = yTItem;
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda41 = new SongMenuKt$$ExternalSyntheticLambda40(yTItem4, playerConnection2, navHostController2, state2, mutableState3, (byte) 26);
                        yTItem = yTItem4;
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda41);
                        objRememberedValue15 = songMenuKt$$ExternalSyntheticLambda41;
                    } else {
                        YTItem yTItem5 = yTItem;
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda42 = new SongMenuKt$$ExternalSyntheticLambda40(yTItem5, playerConnection2, navHostController2, state2, mutableState3, (byte) 26);
                        yTItem = yTItem5;
                        gapComposer2.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda42);
                        objRememberedValue15 = songMenuKt$$ExternalSyntheticLambda42;
                    }
                    MenuKt.YouTubeListItem(yTItem, ImageKt.m48combinedClickablehoGz1lA$default(Modifier.Companion.$$INSTANCE, false, function0, (Function0) objRememberedValue15, 239), false, z3, zBooleanValue3, false, null, Expect_jvmKt.rememberComposableLambda(-656895684, new PlayerMenuKt$$ExternalSyntheticLambda49(function0, (byte) 6), gapComposer2), null, gapComposer2, ((iIntValue >> 3) & 14) | 100663296, 716);
                    return Unit.INSTANCE;
                }
            }, gapComposer);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            gapComposer.startReplaceGroup(433124521);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.background;
            gapComposer.end(false);
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, j, ColorKt.RectangleShape);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(modifierM39backgroundbw27NRU, new LimitInsets(OffsetKt.current(gapComposer).systemBars, 16));
            Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
            BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
            OnlineSearchViewModel onlineSearchViewModel4 = onlineSearchViewModel3;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
            CoroutineScope coroutineScope3 = coroutineScope;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierWindowInsetsPadding);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z3 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
            if (z3) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf2 = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf2, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            TextFieldValue textFieldValue = (TextFieldValue) mutableStateRememberSaveable.getValue();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
            boolean zChanged8 = gapComposer.changed(mutableStateRememberSaveable);
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (zChanged8 || objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = new ClickableTextKt$$ExternalSyntheticLambda1(function1, mutableStateRememberSaveable, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            KeyboardActions keyboardActions = new KeyboardActions(null, (Function1) objRememberedValue15, 47);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer));
            TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, null, 0L, 0L, null, null, 16777214);
            gapComposer.startReplaceGroup(1086844805);
            long j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(1086848709);
            long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer;
            gapComposer.end(false);
            TextFieldColors textFieldColorsM347colors0hiis_0 = TextFieldDefaults.m347colors0hiis_0(0L, 0L, 0L, 0L, j2, j3, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, gapComposer, 3072, 2147477199, 4095);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f, 8.0f), focusRequester);
            Object objRememberedValue16 = gapComposer.rememberedValue();
            if (objRememberedValue16 == neverEqualPolicy) {
                mutableState = mutableState2;
                objRememberedValue16 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 14);
                gapComposer.updateRememberedValue(objRememberedValue16);
            } else {
                mutableState = mutableState2;
            }
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierFocusRequester, (Function1) objRememberedValue16);
            boolean zChanged9 = gapComposer.changed(mutableStateRememberSaveable);
            Object objRememberedValue17 = gapComposer.rememberedValue();
            if (zChanged9 || objRememberedValue17 == neverEqualPolicy) {
                objRememberedValue17 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableStateRememberSaveable, (byte) 15);
                gapComposer.updateRememberedValue(objRememberedValue17);
            }
            final MutableState mutableState3 = mutableState;
            ScrimKt.OutlinedTextField(textFieldValue, (Function1) objRememberedValue17, modifierOnFocusChanged, false, textStyleM750copyp1EtxEg$default, null, LocalSearchScreenKt.f434lambda$678945234, Expect_jvmKt.rememberComposableLambda(-1566982771, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController, (byte) 17), gapComposer), Expect_jvmKt.rememberComposableLambda(1839946988, new QueueKt$$ExternalSyntheticLambda39(mutableStateRememberSaveable, (byte) 16), gapComposer), null, keyboardOptions, keyboardActions, true, 0, 0, roundedCornerShapeM185RoundedCornerShape0680j_4, textFieldColorsM347colors0hiis_0, gapComposer, 918552576, 12779520, 1866840);
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            gapComposer.startReplaceGroup(1533802570);
            Collection collectionListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(null, MathKt.stringResource(R.string.filter_all, gapComposer)), new Pair(new YouTube.SearchFilter("EgWKAQIIAWoKEAkQBRAKEAMQBA%3D%3D"), MathKt.stringResource(R.string.filter_songs, gapComposer))});
            if (((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).booleanValue()) {
                z = false;
                gapComposer.startReplaceGroup(1438409299);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1438282168);
                collectionListOf = CollectionsKt.plus(new Pair(new YouTube.SearchFilter("EgWKAQIQAWoKEAkQChAFEAMQBA%3D%3D"), MathKt.stringResource(R.string.filter_videos, gapComposer)), collectionListOf);
                z = false;
                gapComposer.end(false);
            }
            gapComposer.end(z);
            ArrayList arrayListPlus = CollectionsKt.plus((Iterable) CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(new YouTube.SearchFilter("EgWKAQIYAWoKEAkQChAFEAMQBA%3D%3D"), MathKt.stringResource(R.string.filter_albums, gapComposer)), new Pair(new YouTube.SearchFilter("EgWKAQIgAWoKEAkQChAFEAMQBA%3D%3D"), MathKt.stringResource(R.string.filter_artists, gapComposer)), new Pair(new YouTube.SearchFilter("EgeKAQQoAEABagoQAxAEEAoQCRAF"), MathKt.stringResource(R.string.filter_community_playlists, gapComposer)), new Pair(new YouTube.SearchFilter("EgeKAQQoADgBagwQDhAKEAMQBRAJEAQ%3D"), MathKt.stringResource(R.string.filter_featured_playlists, gapComposer)), new Pair(new YouTube.SearchFilter("EgWKAQJQAWoKEAkQChAFEAMQBA%3D%3D"), MathKt.stringResource(R.string.filter_podcasts, gapComposer)), new Pair(new YouTube.SearchFilter("EgWKAQJYAWoKEAkQChAFEAMQBA%3D%3D"), MathKt.stringResource(R.string.filter_episodes, gapComposer)), new Pair(new YouTube.SearchFilter("EgWKAQJYAWoSEAUQCRADEAQQEBAVEAoQDhAR"), MathKt.stringResource(R.string.filter_profiles, gapComposer))}), collectionListOf);
            String strOnlineSearchResult$lambda$25 = OnlineSearchResult$lambda$24(mutableStateCollectAsStateWithLifecycle4);
            YouTube.SearchFilter searchFilter = strOnlineSearchResult$lambda$25 != null ? new YouTube.SearchFilter(strOnlineSearchResult$lambda$25) : null;
            onlineSearchViewModel2 = onlineSearchViewModel4;
            boolean zChangedInstance2 = gapComposer.changedInstance(onlineSearchViewModel2) | gapComposer.changedInstance(coroutineScope3) | gapComposer.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue18 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue18 == neverEqualPolicy) {
                objRememberedValue18 = new ViewSizeResolver$size$3$1(onlineSearchViewModel2, coroutineScope3, lazyListStateRememberLazyListState, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue18);
            }
            DialogKt.m1461ChipsRowyrwZFoE(arrayListPlus, searchFilter, (Function1) objRememberedValue18, SizeKt.fillMaxWidth(companion, 1.0f), 0L, gapComposer, 3072, 16);
            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
            boolean zChanged10 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer.changedInstance(searchSummaryPage) | gapComposer.changed(state);
            Object objRememberedValue19 = gapComposer.rememberedValue();
            if (zChanged10 || objRememberedValue19 == neverEqualPolicy) {
                objRememberedValue19 = new MainActivity$$ExternalSyntheticLambda59((Object) searchSummaryPage, (Object) composableLambdaImplRememberComposableLambda, (Object) mutableStateCollectAsStateWithLifecycle4, (Object) state, (byte) 21);
                gapComposer.updateRememberedValue(objRememberedValue19);
            }
            b = 1;
            IntMath.LazyColumn(modifierFillMaxWidth2, lazyListStateRememberLazyListState, null, null, null, null, false, null, (Function1) objRememberedValue19, gapComposer, 6, 508);
            gapComposer = gapComposer;
            gapComposer.end(true);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-750982569);
                String str2 = ((TextFieldValue) mutableStateRememberSaveable.getValue()).annotatedString.text;
                boolean zChanged11 = gapComposer.changed(mutableStateRememberSaveable);
                Object objRememberedValue20 = gapComposer.rememberedValue();
                if (zChanged11 || objRememberedValue20 == neverEqualPolicy) {
                    objRememberedValue20 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableStateRememberSaveable, (byte) 16);
                    gapComposer.updateRememberedValue(objRememberedValue20);
                }
                Function1 function2 = (Function1) objRememberedValue20;
                boolean zChangedInstance3 = gapComposer.changedInstance(focusOwner3);
                Object objRememberedValue21 = gapComposer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue21 == neverEqualPolicy) {
                    z2 = false;
                    final Object[] objArr3 = null == true ? 1 : 0;
                    objRememberedValue21 = new Function0() { // from class: com.metrolist.music.ui.screens.search.OnlineSearchResultKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b5 = objArr3;
                            Unit unit = Unit.INSTANCE;
                            MutableState mutableState4 = mutableState3;
                            FocusOwner focusOwner4 = focusOwner3;
                            switch (b5) {
                                case 0:
                                    mutableState4.setValue(Boolean.FALSE);
                                    ((FocusOwnerImpl) focusOwner4).m409clearFocusI7lrPNg(8, false, true);
                                    break;
                                default:
                                    mutableState4.setValue(Boolean.FALSE);
                                    ((FocusOwnerImpl) focusOwner4).m409clearFocusI7lrPNg(8, false, true);
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue21);
                } else {
                    z2 = false;
                }
                OnlineSearchScreenKt.OnlineSearchScreen(str2, function2, function1, (Function0) objRememberedValue21, false, null, gapComposer, 24960);
                gapComposer.end(z2);
            } else {
                gapComposer.startReplaceGroup(-750598169);
                gapComposer.end(false);
            }
            boolean zChangedInstance4 = gapComposer.changedInstance(navHostController);
            Object objRememberedValue22 = gapComposer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue22 == neverEqualPolicy) {
                objRememberedValue22 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 10);
                gapComposer.updateRememberedValue(objRememberedValue22);
            }
            MenuKt.HideOnScrollFAB(BoxScopeInstance.INSTANCE, false, lazyListStateRememberLazyListState, R.drawable.mic, (Function0) objRememberedValue22, null, gapComposer, 6, 17);
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            b = 1;
            gapComposer.skipToGroupEnd();
            onlineSearchViewModel2 = onlineSearchViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(onlineSearchViewModel2, savedStateHandle, i, b) { // from class: com.metrolist.music.ui.screens.search.OnlineSearchResultKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ OnlineSearchViewModel f$0;
                public final /* synthetic */ SavedStateHandle f$2;

                {
                    this.$r8$classId = b;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b5 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    SavedStateHandle savedStateHandle2 = this.f$2;
                    OnlineSearchViewModel onlineSearchViewModel5 = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b5) {
                        case 0:
                            OnlineSearchResultKt.OnlineSearchResult(onlineSearchViewModel5, savedStateHandle2, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            OnlineSearchResultKt.OnlineSearchResult(onlineSearchViewModel5, savedStateHandle2, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final String OnlineSearchResult$lambda$24(MutableState mutableState) {
        YouTube.SearchFilter searchFilter = (YouTube.SearchFilter) mutableState.getValue();
        if (searchFilter != null) {
            return searchFilter.value;
        }
        return null;
    }
}
