package com.metrolist.music.ui.screens.artist;

import android.content.Context;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells$Adaptive;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.models.ItemsPage;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda35;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.screens.ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.NewReleaseScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.equalizer.ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.ArtistAlbumsViewModel;
import com.metrolist.music.viewmodels.ArtistItemsViewModel;
import com.metrolist.music.viewmodels.ArtistSongsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArtistItemsScreenKt {

    /* JADX INFO: renamed from: lambda$-263324921, reason: not valid java name */
    public static final ComposableLambdaImpl f345lambda$263324921 = new ComposableLambdaImpl(false, -263324921, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 20));

    /* JADX INFO: renamed from: lambda$-1087693688, reason: not valid java name */
    public static final ComposableLambdaImpl f337lambda$1087693688 = new ComposableLambdaImpl(false, -1087693688, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(14));
    public static final ComposableLambdaImpl lambda$1099964723 = new ComposableLambdaImpl(false, 1099964723, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 21));

    /* JADX INFO: renamed from: lambda$-868523985, reason: not valid java name */
    public static final ComposableLambdaImpl f348lambda$868523985 = new ComposableLambdaImpl(false, -868523985, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(15));

    /* JADX INFO: renamed from: lambda$-1544137819, reason: not valid java name */
    public static final ComposableLambdaImpl f341lambda$1544137819 = new ComposableLambdaImpl(false, -1544137819, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(16));

    /* JADX INFO: renamed from: lambda$-1341727610, reason: not valid java name */
    public static final ComposableLambdaImpl f340lambda$1341727610 = new ComposableLambdaImpl(false, -1341727610, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(17));
    public static final ComposableLambdaImpl lambda$969371088 = new ComposableLambdaImpl(false, 969371088, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(18));
    public static final ComposableLambdaImpl lambda$1994861503 = new ComposableLambdaImpl(false, 1994861503, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 22));

    /* JADX INFO: renamed from: lambda$-870491277, reason: not valid java name */
    public static final ComposableLambdaImpl f349lambda$870491277 = new ComposableLambdaImpl(false, -870491277, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(19));

    /* JADX INFO: renamed from: lambda$-1187489731, reason: not valid java name */
    public static final ComposableLambdaImpl f338lambda$1187489731 = new ComposableLambdaImpl(false, -1187489731, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(22));
    public static final ComposableLambdaImpl lambda$185065037 = new ComposableLambdaImpl(false, 185065037, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(23));
    public static final ComposableLambdaImpl lambda$327652006 = new ComposableLambdaImpl(false, 327652006, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(24));
    public static final ComposableLambdaImpl lambda$1391529335 = new ComposableLambdaImpl(false, 1391529335, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(25));
    public static final ComposableLambdaImpl lambda$1998895264 = new ComposableLambdaImpl(false, 1998895264, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(26));

    /* JADX INFO: renamed from: lambda$-2094941704, reason: not valid java name */
    public static final ComposableLambdaImpl f344lambda$2094941704 = new ComposableLambdaImpl(false, -2094941704, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(20));

    /* JADX INFO: renamed from: lambda$-198786494, reason: not valid java name */
    public static final ComposableLambdaImpl f342lambda$198786494 = new ComposableLambdaImpl(false, -198786494, new ComposableSingletons$LoginScreenKt$$ExternalSyntheticLambda1(21));

    /* JADX INFO: renamed from: lambda$-742881513, reason: not valid java name */
    public static final ComposableLambdaImpl f346lambda$742881513 = new ComposableLambdaImpl(false, -742881513, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 23));

    /* JADX INFO: renamed from: lambda$-778940053, reason: not valid java name */
    public static final ComposableLambdaImpl f347lambda$778940053 = new ComposableLambdaImpl(false, -778940053, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 24));

    /* JADX INFO: renamed from: lambda$-948408580, reason: not valid java name */
    public static final ComposableLambdaImpl f351lambda$948408580 = new ComposableLambdaImpl(false, -948408580, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 25));
    public static final ComposableLambdaImpl lambda$796694260 = new ComposableLambdaImpl(false, 796694260, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 26));
    public static final ComposableLambdaImpl lambda$27455767 = new ComposableLambdaImpl(false, 27455767, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 27));

    /* JADX INFO: renamed from: lambda$-1221544444, reason: not valid java name */
    public static final ComposableLambdaImpl f339lambda$1221544444 = new ComposableLambdaImpl(false, -1221544444, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 28));

    /* JADX INFO: renamed from: lambda$-913587669, reason: not valid java name */
    public static final ComposableLambdaImpl f350lambda$913587669 = new ComposableLambdaImpl(false, -913587669, new HomeScreenKt$$ExternalSyntheticLambda97((byte) 29));

    /* JADX INFO: renamed from: lambda$-2002008381, reason: not valid java name */
    public static final ComposableLambdaImpl f343lambda$2002008381 = new ComposableLambdaImpl(false, -2002008381, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(1));

    public static final void ArtistAlbumsScreen(final NavHostController navHostController, final NavDeepLinkRequest navDeepLinkRequest, ArtistAlbumsViewModel artistAlbumsViewModel, Composer composer, final int i) {
        NavHostController navHostController2;
        final ArtistAlbumsViewModel artistAlbumsViewModel2;
        final ArtistAlbumsViewModel artistAlbumsViewModel3;
        int i2;
        navHostController.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1087474281);
        int i3 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | (gapComposer.changed(navDeepLinkRequest) ? 32 : 16) | 128;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    artistAlbumsViewModel3 = (ArtistAlbumsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(ArtistAlbumsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
                    i2 = i3 & (-897);
                }
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-897);
                artistAlbumsViewModel3 = artistAlbumsViewModel;
            }
            int i4 = i2;
            gapComposer.endDefaults();
            MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, navDeepLinkRequest, artistAlbumsViewModel3, i, b) { // from class: com.metrolist.music.ui.screens.artist.ArtistAlbumsScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ NavDeepLinkRequest f$1;
                        public final /* synthetic */ ArtistAlbumsViewModel f$2;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            ArtistAlbumsViewModel artistAlbumsViewModel4 = this.f$2;
                            NavDeepLinkRequest navDeepLinkRequest2 = this.f$1;
                            NavHostController navHostController3 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b2) {
                                case 0:
                                    ArtistItemsScreenKt.ArtistAlbumsScreen(navHostController3, navDeepLinkRequest2, artistAlbumsViewModel4, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    ArtistItemsScreenKt.ArtistAlbumsScreen(navHostController3, navDeepLinkRequest2, artistAlbumsViewModel4, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            ArtistAlbumsViewModel artistAlbumsViewModel4 = artistAlbumsViewModel3;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(artistAlbumsViewModel4.artist, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(artistAlbumsViewModel4.albums, gapComposer);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
            Preferences$Key preferences$Key = PreferenceKeysKt.GridItemsSizeKey;
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 26));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, gridItemSize, gapComposer, 48);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle5, coroutineScope2, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2 artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2 = (ArtistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2) objRememberedValue4;
            Object[] objArr = new Object[0];
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 15);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue5, gapComposer, 48);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new HomeScreenKt$$ExternalSyntheticLambda97((byte) 17);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Function2 function2 = (Function2) objRememberedValue6;
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            CallbackWrapper callbackWrapperListSaver = SaverKt.listSaver(function2, (Function1) objRememberedValue7);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 16);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            List list = (List) SaverKt.m393rememberSaveable(objArr2, (Saver) callbackWrapperListSaver, (Function0) objRememberedValue8, (Composer) gapComposer, 384);
            boolean zChanged = gapComposer.changed(mutableState) | gapComposer.changedInstance(list);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new QueueKt$$ExternalSyntheticLambda6(list, mutableState, (byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            Function0 function0 = (Function0) objRememberedValue9;
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(9206528);
                UtilsKt.BackHandler(false, function0, gapComposer, 0, 1);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(9261305);
                gapComposer.end(false);
            }
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new SnackbarHostState();
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue10;
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            GridCells$Adaptive gridCells$Adaptive = new GridCells$Adaptive(128.0f + (((GridItemSize) artistAlbumsScreenKt$ArtistAlbumsScreen$$inlined$rememberEnumPreference$2.getValue()) == gridItemSize ? 24.0f : -24.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MainActivityKt.LocalPlayerAwareWindowInsets;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal), gapComposer);
            boolean zChanged2 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = new AlbumMenuKt$$ExternalSyntheticLambda40((Object) mutableStateCollectAsStateWithLifecycle4, (Object) menuState, (Object) coroutineScope, (Object) mutableStateCollectAsStateWithLifecycle2, (Object) mutableStateCollectAsStateWithLifecycle, (byte) 14);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            navHostController2 = navHostController;
            LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive, null, lazyGridStateRememberLazyGridState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, null, (Function1) objRememberedValue11, gapComposer, 0, 2034);
            MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(-731024793, new PlayerKt$$ExternalSyntheticLambda35(mutableStateCollectAsStateWithLifecycle3, (byte) 2), gapComposer), null, Expect_jvmKt.rememberComposableLambda(1705534441, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 9), gapComposer), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, navDeepLinkRequest, gapComposer, ((i4 << 18) & 29360128) | 390, 122);
            ScrimKt.SnackbarHost(snackbarHostState, BoxScopeInstance.INSTANCE.align(OffsetKt.windowInsetsPadding(Modifier.Companion.$$INSTANCE, (WindowInsets) gapComposer.consume(staticProvidableCompositionLocal)), Alignment.Companion.BottomCenter), null, gapComposer, 6, 4);
            gapComposer.end(true);
            artistAlbumsViewModel2 = artistAlbumsViewModel4;
        } else {
            navHostController2 = navHostController;
            gapComposer.skipToGroupEnd();
            artistAlbumsViewModel2 = artistAlbumsViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            final NavHostController navHostController3 = navHostController2;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController3, navDeepLinkRequest, artistAlbumsViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.artist.ArtistAlbumsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ NavDeepLinkRequest f$1;
                public final /* synthetic */ ArtistAlbumsViewModel f$2;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    ArtistAlbumsViewModel artistAlbumsViewModel5 = this.f$2;
                    NavDeepLinkRequest navDeepLinkRequest2 = this.f$1;
                    NavHostController navHostController4 = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b3) {
                        case 0:
                            ArtistItemsScreenKt.ArtistAlbumsScreen(navHostController4, navDeepLinkRequest2, artistAlbumsViewModel5, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            ArtistItemsScreenKt.ArtistAlbumsScreen(navHostController4, navDeepLinkRequest2, artistAlbumsViewModel5, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void ArtistItemsScreen(NavHostController navHostController, ArtistItemsViewModel artistItemsViewModel, Composer composer, final int i) {
        final byte b;
        final ArtistItemsViewModel artistItemsViewModel2;
        final ArtistItemsViewModel artistItemsViewModel3;
        LazyGridState lazyGridState;
        NeverEqualPolicy neverEqualPolicy;
        boolean z;
        MutableState mutableState;
        byte b2;
        GapComposer gapComposer;
        final NavHostController navHostController2 = navHostController;
        navHostController2.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-2134339677);
        int i2 = (gapComposer2.changedInstance(navHostController2) ? 4 : 2) | i | 16;
        final byte b3 = 0;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                artistItemsViewModel3 = (ArtistItemsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(ArtistItemsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
            } else {
                gapComposer2.skipToGroupEnd();
                artistItemsViewModel3 = artistItemsViewModel;
            }
            gapComposer2.endDefaults();
            MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer2.consume(CompositionLocalsKt.LocalHapticFeedback);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController2, artistItemsViewModel3, i, b3) { // from class: com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ ArtistItemsViewModel f$1;

                        {
                            this.$r8$classId = b3;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b4 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            ArtistItemsViewModel artistItemsViewModel4 = this.f$1;
                            NavHostController navHostController3 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b4) {
                                case 0:
                                    ArtistItemsScreenKt.ArtistItemsScreen(navHostController3, artistItemsViewModel4, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    ArtistItemsScreenKt.ArtistItemsScreen(navHostController3, artistItemsViewModel4, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer2);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy2) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Preferences$Key preferences$Key = PreferenceKeysKt.GridItemsSizeKey;
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy2) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy2) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 27));
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, gridItemSize, gapComposer2, 48);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy2) {
                objRememberedValue4 = new ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle3, coroutineScope2, context, preferences$Key);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2 artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2 = (ArtistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2) objRememberedValue4;
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(artistItemsViewModel3.title, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(artistItemsViewModel3.itemsPage, gapComposer2);
            boolean zChanged = gapComposer2.changed(lazyListStateRememberLazyListState) | gapComposer2.changedInstance(artistItemsViewModel3);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            Continuation continuation = null;
            if (zChanged || objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = new DataStoreKt$get$1((Object) lazyListStateRememberLazyListState, (Object) artistItemsViewModel3, continuation, (byte) 7);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            Stack.LaunchedEffect(gapComposer2, lazyListStateRememberLazyListState, (Function2) objRememberedValue5);
            boolean zChanged2 = gapComposer2.changed(lazyGridStateRememberLazyGridState) | gapComposer2.changedInstance(artistItemsViewModel3);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue6 == neverEqualPolicy2) {
                objRememberedValue6 = new DataStoreKt$get$1((Object) lazyGridStateRememberLazyGridState, (Object) artistItemsViewModel3, continuation, (byte) 8);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            Stack.LaunchedEffect(gapComposer2, lazyGridStateRememberLazyGridState, (Function2) objRememberedValue6);
            if (((ItemsPage) mutableStateCollectAsStateWithLifecycle5.getValue()) == null) {
                gapComposer2.startReplaceGroup(-1416078938);
                lazyGridState = lazyGridStateRememberLazyGridState;
                neverEqualPolicy = neverEqualPolicy2;
                ShimmerHostKt.ShimmerHost(OffsetKt.windowInsetsPadding(Modifier.Companion.$$INSTANCE, (WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), null, null, false, f337lambda$1087693688, gapComposer2, 24576, 14);
                z = false;
                gapComposer2.end(false);
            } else {
                lazyGridState = lazyGridStateRememberLazyGridState;
                neverEqualPolicy = neverEqualPolicy2;
                z = false;
                gapComposer2.startReplaceGroup(-1415870401);
                gapComposer2.end(false);
            }
            ItemsPage itemsPage = (ItemsPage) mutableStateCollectAsStateWithLifecycle5.getValue();
            if ((itemsPage != null ? (YTItem) CollectionsKt.firstOrNull(itemsPage.items) : null) instanceof SongItem) {
                gapComposer2.startReplaceGroup(-1415616666);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer2);
                boolean zChanged3 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changedInstance(navHostController2) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(r27);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                    NavHostKt$$ExternalSyntheticLambda12 navHostKt$$ExternalSyntheticLambda12 = new NavHostKt$$ExternalSyntheticLambda12(mutableStateCollectAsStateWithLifecycle5, mutableStateCollectAsStateWithLifecycle2, playerConnection, navHostController2, mutableStateCollectAsStateWithLifecycle, menuState, coroutineScope);
                    gapComposer2.updateRememberedValue(navHostKt$$ExternalSyntheticLambda12);
                    objRememberedValue7 = navHostKt$$ExternalSyntheticLambda12;
                }
                IntMath.LazyColumn(null, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue7, gapComposer2, 0, 505);
                gapComposer = gapComposer2;
                gapComposer.end(z);
                mutableState = mutableStateCollectAsStateWithLifecycle4;
                b = 1;
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle4;
                artistItemsViewModel3 = artistItemsViewModel3;
                boolean z2 = z;
                gapComposer2.startReplaceGroup(-1409234510);
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                GridCells$Adaptive gridCells$Adaptive = new GridCells$Adaptive(128.0f + (((GridItemSize) artistItemsScreenKt$ArtistItemsScreen$$inlined$rememberEnumPreference$2.getValue()) == gridItemSize ? 24.0f : -24.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer2);
                boolean zChanged4 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(r27) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changedInstance(navHostController2);
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                if (zChanged4 || objRememberedValue8 == neverEqualPolicy) {
                    b2 = 1;
                    NewReleaseScreenKt$$ExternalSyntheticLambda1 newReleaseScreenKt$$ExternalSyntheticLambda1 = new NewReleaseScreenKt$$ExternalSyntheticLambda1(mutableStateCollectAsStateWithLifecycle5, hapticFeedback, menuState, (CoroutineScope) r27, playerConnection, navHostController2, mutableStateCollectAsStateWithLifecycle2, mutableStateCollectAsStateWithLifecycle);
                    navHostController2 = navHostController2;
                    gapComposer2.updateRememberedValue(newReleaseScreenKt$$ExternalSyntheticLambda1);
                    objRememberedValue8 = newReleaseScreenKt$$ExternalSyntheticLambda1;
                } else {
                    b2 = 1;
                }
                b = b2;
                LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive, null, lazyGridState, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, null, (Function1) objRememberedValue8, gapComposer2, 0, 2034);
                gapComposer = gapComposer2;
                gapComposer.end(z2);
            }
            GapComposer gapComposer3 = gapComposer;
            MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(825682015, new PlayerKt$$ExternalSyntheticLambda35(mutableState, (byte) 3), gapComposer), null, Expect_jvmKt.rememberComposableLambda(-497496931, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 10), gapComposer), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer3, 390, 250);
            gapComposer2 = gapComposer3;
            artistItemsViewModel2 = artistItemsViewModel3;
        } else {
            b = 1;
            gapComposer2.skipToGroupEnd();
            artistItemsViewModel2 = artistItemsViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController2, artistItemsViewModel2, i, b) { // from class: com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ ArtistItemsViewModel f$1;

                {
                    this.$r8$classId = b;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b4 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    ArtistItemsViewModel artistItemsViewModel4 = this.f$1;
                    NavHostController navHostController3 = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b4) {
                        case 0:
                            ArtistItemsScreenKt.ArtistItemsScreen(navHostController3, artistItemsViewModel4, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            ArtistItemsScreenKt.ArtistItemsScreen(navHostController3, artistItemsViewModel4, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void ArtistSongsScreen(final NavHostController navHostController, ArtistSongsViewModel artistSongsViewModel, Composer composer, final int i) {
        final NavHostController navHostController2;
        GapComposer gapComposer;
        final byte b;
        final ArtistSongsViewModel artistSongsViewModel2;
        MutableState mutableState;
        PlayerConnection playerConnection;
        navHostController.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(826506401);
        int i2 = (gapComposer2.changedInstance(navHostController) ? 4 : 2) | i | 16;
        final byte b2 = 0;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                artistSongsViewModel2 = (ArtistSongsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(ArtistSongsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
            } else {
                gapComposer2.skipToGroupEnd();
                artistSongsViewModel2 = artistSongsViewModel;
            }
            gapComposer2.endDefaults();
            MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
            String strStringResource = MathKt.stringResource(R.string.queue_all_songs, gapComposer2);
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer2.consume(CompositionLocalsKt.LocalHapticFeedback);
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, artistSongsViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ ArtistSongsViewModel f$1;

                        {
                            this.$r8$classId = b2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            ArtistSongsViewModel artistSongsViewModel3 = this.f$1;
                            NavHostController navHostController3 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b3) {
                                case 0:
                                    ArtistItemsScreenKt.ArtistSongsScreen(navHostController3, artistSongsViewModel3, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    ArtistItemsScreenKt.ArtistSongsScreen(navHostController3, artistSongsViewModel3, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer2);
            Preferences$Key preferences$Key = PreferenceKeysKt.ArtistSongSortTypeKey;
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 28));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, ArtistSongSortType.CREATE_DATE, gapComposer2, 48);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle3, coroutineScope, context, preferences$Key);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2 artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2 = (ArtistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2) objRememberedValue3;
            ArtistSongSortType artistSongSortType = (ArtistSongSortType) artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(artistSongsScreenKt$ArtistSongsScreen$$inlined$rememberEnumPreference$2, (byte) 7);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ArtistSongSortDescendingKey, Boolean.TRUE, gapComposer2, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.HideExplicitKey, Boolean.FALSE, gapComposer2, 48);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(artistSongsViewModel2.artist, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(artistSongsViewModel2.songs, gapComposer2);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            artistSongsViewModel = artistSongsViewModel2;
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer2);
            boolean zChanged = gapComposer2.changed(artistSongSortType.ordinal()) | gapComposer2.changed(zBooleanValue) | gapComposer2.changed(anonymousClass2) | gapComposer2.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(playerConnection2) | gapComposer2.changed(strStringResource);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                mutableState = mutableStateCollectAsStateWithLifecycle5;
                objRememberedValue4 = new ArtistSongsScreenKt$$ExternalSyntheticLambda1(artistSongSortType, zBooleanValue, anonymousClass2, mimesKt$$ExternalSyntheticLambda0, mutableState, hapticFeedback, menuState, mutableStateCollectAsStateWithLifecycle2, playerConnection2, strStringResource, mutableStateCollectAsStateWithLifecycle);
                playerConnection = playerConnection2;
                gapComposer2.updateRememberedValue(objRememberedValue4);
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle5;
                playerConnection = playerConnection2;
            }
            MutableState mutableState2 = mutableState;
            IntMath.LazyColumn(null, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer2, 0, 505);
            navHostController2 = navHostController;
            MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(-1322620061, new PlayerKt$$ExternalSyntheticLambda35(mutableStateCollectAsStateWithLifecycle4, (byte) 4), gapComposer2), null, Expect_jvmKt.rememberComposableLambda(-835546335, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 12), gapComposer2), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer2, 390, 250);
            gapComposer = gapComposer2;
            boolean zChangedInstance = gapComposer.changedInstance(playerConnection) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer.changed(mutableState2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new QueueKt$$ExternalSyntheticLambda24(playerConnection, (Object) mutableStateCollectAsStateWithLifecycle4, (Object) mutableState2, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            MenuKt.HideOnScrollFAB(BoxScopeInstance.INSTANCE, false, lazyListStateRememberLazyListState, R.drawable.shuffle, (Function0) objRememberedValue5, null, gapComposer, 6, 17);
            b = 1;
            gapComposer.end(true);
        } else {
            navHostController2 = navHostController;
            gapComposer = gapComposer2;
            b = 1;
            gapComposer.skipToGroupEnd();
        }
        final ArtistSongsViewModel artistSongsViewModel3 = artistSongsViewModel;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController2, artistSongsViewModel3, i, b) { // from class: com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ ArtistSongsViewModel f$1;

                {
                    this.$r8$classId = b;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    ArtistSongsViewModel artistSongsViewModel4 = this.f$1;
                    NavHostController navHostController3 = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b3) {
                        case 0:
                            ArtistItemsScreenKt.ArtistSongsScreen(navHostController3, artistSongsViewModel4, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            ArtistItemsScreenKt.ArtistSongsScreen(navHostController3, artistSongsViewModel4, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }
}
