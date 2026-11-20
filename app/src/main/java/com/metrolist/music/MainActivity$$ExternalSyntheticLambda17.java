package com.metrolist.music;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.AddedInsets;
import androidx.compose.foundation.layout.AndroidWindowInsets;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.dokar.quickjs.QuickJs;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.ui.component.AppNavigationKt;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.BottomSheetPageKt;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.ChangelogScreenKt;
import com.metrolist.music.ui.screens.settings.NavigationTab;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.utils.AppBarKt;
import com.metrolist.music.ui.utils.AppBarScrollBehavior$nestedScrollConnection$1;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.valentinilk.shimmer.ShimmerThemeKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ String f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ boolean f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda17(PlayerConnection playerConnection, MainActivity mainActivity, MusicDatabase musicDatabase, boolean z, DownloadUtil downloadUtil, SyncUtils syncUtils, MutableState mutableState, HazeState hazeState, boolean z2, MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, String str, MutableState mutableState2) {
        this.f$0 = playerConnection;
        this.f$1 = mainActivity;
        this.f$2 = musicDatabase;
        this.f$3 = z;
        this.f$4 = downloadUtil;
        this.f$5 = syncUtils;
        this.f$6 = mutableState;
        this.f$7 = hazeState;
        this.f$8 = z2;
        this.f$9 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
        this.f$10 = str;
        this.f$11 = mutableState2;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x040b  */
    /* JADX WARN: Code duplicated, block: B:156:0x0527  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Unit unit;
        Boolean bool;
        Object obj4;
        Object obj5;
        boolean z;
        NavigationTab navigationTabValueOf;
        byte b;
        boolean z2;
        final float f;
        float f2;
        MutableState mutableStateCollectAsStateWithLifecycle;
        MutableState mutableState;
        NavDeepLinkRequest navDeepLinkRequest;
        List list;
        BottomSheetState bottomSheetState;
        MutableState mutableState2;
        MutableState mutableState3;
        boolean z3;
        Continuation continuation;
        Object objValueOf;
        NavDestination navDestination;
        long j;
        long jM282contentColorForek8zF_U;
        byte b2 = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit2 = Unit.INSTANCE;
        Object obj6 = this.f$9;
        Object obj7 = this.f$11;
        Object obj8 = this.f$7;
        Object obj9 = this.f$5;
        Object obj10 = this.f$6;
        Object obj11 = this.f$4;
        Object obj12 = this.f$2;
        Object obj13 = this.f$1;
        Object obj14 = this.f$0;
        final byte b3 = 1;
        switch (b2) {
            case 0:
                final PlayerConnection playerConnection = (PlayerConnection) obj14;
                final MainActivity mainActivity = (MainActivity) obj13;
                MusicDatabase musicDatabase = (MusicDatabase) obj12;
                DownloadUtil downloadUtil = (DownloadUtil) obj11;
                SyncUtils syncUtils = (SyncUtils) obj9;
                final MutableState mutableState4 = (MutableState) obj10;
                final HazeState hazeState = (HazeState) obj8;
                final MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) obj6;
                final MutableState mutableState5 = (MutableState) obj7;
                final BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                int i = MainActivity.$r8$clinit;
                boxWithConstraintsScopeImpl.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                    return unit2;
                }
                Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                WindowInfo windowInfo = (WindowInfo) gapComposer.consume(CompositionLocalsKt.LocalWindowInfo);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                final AndroidWindowInsets androidWindowInsets = OffsetKt.current(gapComposer).displayCutout;
                AndroidWindowInsets androidWindowInsets2 = OffsetKt.current(gapComposer).systemBars;
                final float fMo78toDpu2uoSUM = density.mo78toDpu2uoSUM(androidWindowInsets2.getInsets$foundation_layout().bottom);
                final float fMo122calculateBottomPaddingD9Ej5fM = OffsetKt.asPaddingValues(OffsetKt.current(gapComposer).systemBars, gapComposer).mo122calculateBottomPaddingD9Ej5fM();
                Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                Object[] objArrCopyOf = Arrays.copyOf(new Navigator[0], 0);
                CallbackWrapper callbackWrapper = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5((byte) 23), new DiskLruCache$$ExternalSyntheticLambda0((byte) 13, context), (byte) 7);
                boolean zChangedInstance = gapComposer.changedInstance(context);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new App$$ExternalSyntheticLambda0(context, (byte) 2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                final NavHostController navHostController = (NavHostController) SaverKt.rememberSaveable(objArrCopyOf, callbackWrapper, (Function0) objRememberedValue, gapComposer, 0, 4);
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return null;
                }
                Continuation continuation2 = null;
                FileSystemsKt.collectAsStateWithLifecycle(((HomeViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(HomeViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer)).accountImageUrl, gapComposer);
                MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
                Object[] objArr = new Object[0];
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new LastFM$$ExternalSyntheticLambda1((byte) 17);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                MutableState mutableState6 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue2, gapComposer, 48);
                String str = (String) mutableState6.component1();
                Function1 function1Component2 = mutableState6.component2();
                Boolean bool2 = (Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ListenTogetherInTopBarKey, Boolean.TRUE, gapComposer, 48).$state.getValue();
                boolean zBooleanValue = bool2.booleanValue();
                boolean zChanged = gapComposer.changed(zBooleanValue);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    if (zBooleanValue) {
                        List list2 = Screens.MainScreens;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj15 : list2) {
                            Unit unit3 = unit2;
                            Boolean bool3 = bool2;
                            if (!Intrinsics.areEqual((Screens) obj15, Screens.ListenTogether.INSTANCE)) {
                                arrayList.add(obj15);
                            }
                            bool2 = bool3;
                            unit2 = unit3;
                        }
                        unit = unit2;
                        bool = bool2;
                        obj4 = arrayList;
                    } else {
                        unit = unit2;
                        bool = bool2;
                        obj4 = Screens.MainScreens;
                    }
                    gapComposer.updateRememberedValue(obj4);
                    obj5 = obj4;
                } else {
                    unit = unit2;
                    bool = bool2;
                    obj5 = objRememberedValue3;
                }
                List list3 = (List) obj5;
                boolean zChanged2 = gapComposer.changed(list3);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                    Iterator it = list3.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        arrayList2.add(new Pair(((Screens) next).route, Integer.valueOf(i2)));
                        it = it;
                        i2 = i3;
                        zBooleanValue = zBooleanValue;
                    }
                    z = zBooleanValue;
                    objRememberedValue4 = MapsKt__MapsKt.toMap(arrayList2);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    z = zBooleanValue;
                }
                Preferences$Key preferences$Key = PreferenceKeysKt.ForceBottomNavBarKey;
                Boolean bool4 = Boolean.FALSE;
                boolean zBooleanValue2 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key, bool4, gapComposer, 48).$state.getValue()).booleanValue();
                final boolean zBooleanValue3 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.SlimNavBarKey, bool4, gapComposer, 48).$state.getValue()).booleanValue();
                final boolean zBooleanValue4 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.UseNewMiniPlayerDesignKey, Boolean.TRUE, gapComposer, 48).$state.getValue()).booleanValue();
                String str2 = (String) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.DefaultOpenTabKey, "HOME", gapComposer, 0).$state.getValue();
                boolean zChanged3 = gapComposer.changed(str2);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                    try {
                        navigationTabValueOf = NavigationTab.valueOf(str2);
                    } catch (IllegalArgumentException unused) {
                        navigationTabValueOf = NavigationTab.HOME;
                    }
                    objRememberedValue5 = navigationTabValueOf;
                    gapComposer.updateRememberedValue(objRememberedValue5);
                    break;
                }
                final NavigationTab navigationTab = (NavigationTab) objRememberedValue5;
                Object objRememberedValue6 = gapComposer.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy) {
                    Intent intent = mainActivity.getIntent();
                    String action = intent != null ? intent.getAction() : null;
                    if (action == null) {
                        objRememberedValue6 = null;
                    } else {
                        int iHashCode = action.hashCode();
                        if (iHashCode != -354067920) {
                            if (iHashCode == 1986374003 && action.equals("com.metrolist.music.action.SEARCH")) {
                                objRememberedValue6 = NavigationTab.SEARCH;
                            } else {
                                objRememberedValue6 = null;
                            }
                        } else if (action.equals("com.metrolist.music.action.LIBRARY")) {
                            objRememberedValue6 = NavigationTab.LIBRARY;
                        } else {
                            objRememberedValue6 = null;
                        }
                    }
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                final NavigationTab navigationTab2 = (NavigationTab) objRememberedValue6;
                Object objRememberedValue7 = gapComposer.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    Screens.Home home = Screens.Home.INSTANCE;
                    Screens.Library library = Screens.Library.INSTANCE;
                    Screens.ListenTogether listenTogether = Screens.ListenTogether.INSTANCE;
                    objRememberedValue7 = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"home", "library", "listen_together", "settings"});
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                List list4 = (List) objRememberedValue7;
                Object[] objArr2 = new Object[0];
                Object objRememberedValue8 = gapComposer.rememberedValue();
                if (objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = new LastFM$$ExternalSyntheticLambda1((byte) 18);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) TextFieldValue.Saver, (Function0) objRememberedValue8, (Composer) gapComposer, 384);
                Function1 function1Component3 = mutableStateRememberSaveable.component2();
                Object objRememberedValue9 = gapComposer.rememberedValue();
                if (objRememberedValue9 == neverEqualPolicy) {
                    b = 0;
                    objRememberedValue9 = new MainActivity$$ExternalSyntheticLambda21(navHostController, mainActivity, musicDatabase, b);
                    gapComposer.updateRememberedValue(objRememberedValue9);
                } else {
                    b = 0;
                }
                Object objRememberedValue10 = gapComposer.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new MainActivity$$ExternalSyntheticLambda22(mutableStateCurrentBackStackEntryAsState, b));
                    gapComposer.updateRememberedValue(objRememberedValue10);
                }
                final State state = (State) objRememberedValue10;
                Object objRememberedValue11 = gapComposer.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new MainActivity$$ExternalSyntheticLambda22(state, (byte) 12));
                    gapComposer.updateRememberedValue(objRememberedValue11);
                }
                final State state2 = (State) objRememberedValue11;
                boolean zChanged4 = gapComposer.changed(list3);
                Object objRememberedValue12 = gapComposer.rememberedValue();
                if (zChanged4 || objRememberedValue12 == neverEqualPolicy) {
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                    Iterator it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((Screens) it2.next()).route);
                    }
                    objRememberedValue12 = CollectionsKt.toSet(arrayList3);
                    gapComposer.updateRememberedValue(objRememberedValue12);
                }
                Set set = (Set) objRememberedValue12;
                boolean zChanged5 = gapComposer.changed((String) state.getValue()) | gapComposer.changed(set);
                Object objRememberedValue13 = gapComposer.rememberedValue();
                if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
                    if (((String) state.getValue()) == null || CollectionsKt.contains(set, (String) state.getValue())) {
                        z2 = true;
                    } else {
                        String str3 = (String) state.getValue();
                        str3.getClass();
                        if (StringsKt__StringsJVMKt.startsWith(str3, "search/", false)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    objRememberedValue13 = Boolean.valueOf(z2);
                    gapComposer.updateRememberedValue(objRememberedValue13);
                }
                final boolean zBooleanValue5 = ((Boolean) objRememberedValue13).booleanValue();
                LazyWindowInfo lazyWindowInfo = (LazyWindowInfo) windowInfo;
                boolean z4 = !zBooleanValue2 && ((Dp.m795compareTo0680j_4(DpSize.m802getWidthD9Ej5fM(lazyWindowInfo.m714getContainerDpSizeMYxV2XQ()), DpSize.m801getHeightD9Ej5fM(lazyWindowInfo.m714getContainerDpSizeMYxV2XQ())) > 0) || (Dp.m795compareTo0680j_4(DpSize.m802getWidthD9Ej5fM(lazyWindowInfo.m714getContainerDpSizeMYxV2XQ()), 600.0f) >= 0)) && !((Boolean) state2.getValue()).booleanValue();
                if (!zBooleanValue5 || z4) {
                    f = 0.0f;
                } else if (zBooleanValue3) {
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    f = 64.0f;
                } else {
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    f = 80.0f;
                }
                if (!zBooleanValue5 || z4) {
                    f2 = 0.0f;
                } else {
                    SpringSpec springSpec3 = DimensionsKt.NavigationBarAnimationSpec;
                    f2 = 80.0f;
                }
                final AnimateAsState animateAsStateM18animateDpAsStateAjpBEmI = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f2, DimensionsKt.NavigationBarAnimationSpec, "navBarHeight", gapComposer, 384, 8);
                final BottomSheetState bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ = DialogKt.m1475rememberBottomSheetStatejTDHpeQ(CropImageView.DEFAULT_ASPECT_RATIO, boxWithConstraintsScopeImpl.m117getMaxHeightD9Ej5fM(), fMo78toDpu2uoSUM + ((z4 || !zBooleanValue5) ? 0.0f : f) + CropImageView.DEFAULT_ASPECT_RATIO + (zBooleanValue4 ? 8.0f : 0.0f) + CropImageView.DEFAULT_ASPECT_RATIO + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO, gapComposer, 6, 8);
                ReadonlyStateFlow readonlyStateFlow = playerConnection != null ? playerConnection.service.isPlayerReady : null;
                if (readonlyStateFlow == null) {
                    gapComposer.startReplaceGroup(-625023665);
                    gapComposer.end(false);
                    mutableStateCollectAsStateWithLifecycle = null;
                } else {
                    gapComposer.startReplaceGroup(-297256718);
                    mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(readonlyStateFlow, gapComposer);
                    gapComposer.end(false);
                }
                if (mutableStateCollectAsStateWithLifecycle == null) {
                    gapComposer.startReplaceGroup(-624966965);
                    Object objRememberedValue14 = gapComposer.rememberedValue();
                    if (objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    }
                    mutableState = (MutableState) objRememberedValue14;
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-297257958);
                    gapComposer.end(false);
                    mutableState = mutableStateCollectAsStateWithLifecycle;
                }
                PlayerConnection playerConnection2 = ((Boolean) mutableState.getValue()).booleanValue() ? playerConnection : null;
                boolean zChanged6 = gapComposer.changed(fMo78toDpu2uoSUM) | gapComposer.changed(zBooleanValue5) | gapComposer.changed(bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ.isDismissed()) | gapComposer.changed(z4);
                Object objRememberedValue15 = gapComposer.rememberedValue();
                if (zChanged6 || objRememberedValue15 == neverEqualPolicy) {
                    float f3 = (!zBooleanValue5 || z4) ? fMo78toDpu2uoSUM : fMo78toDpu2uoSUM + 80.0f + CropImageView.DEFAULT_ASPECT_RATIO;
                    if (!bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ.isDismissed()) {
                        f3 = f3 + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                    objRememberedValue15 = new AddedInsets(new LimitInsets(androidWindowInsets2, 31), OffsetKt.m129WindowInsetsa9UjIt4$default(64.0f, f3, 5));
                    gapComposer.updateRememberedValue(objRememberedValue15);
                }
                WindowInsets windowInsets = (WindowInsets) objRememberedValue15;
                boolean zChanged7 = gapComposer.changed(bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ);
                Object objRememberedValue16 = gapComposer.rememberedValue();
                if (zChanged7 || objRememberedValue16 == neverEqualPolicy) {
                    final byte b4 = 0;
                    objRememberedValue16 = new Function0() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b5 = b4;
                            boolean z5 = false;
                            State state3 = state2;
                            BottomSheetState bottomSheetState2 = bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ;
                            switch (b5) {
                                case 0:
                                    int i4 = MainActivity.$r8$clinit;
                                    if (!((Boolean) state3.getValue()).booleanValue() && (bottomSheetState2.isCollapsed() || bottomSheetState2.isDismissed())) {
                                        z5 = true;
                                    }
                                    return Boolean.valueOf(z5);
                                default:
                                    int i5 = MainActivity.$r8$clinit;
                                    if (!((Boolean) state3.getValue()).booleanValue() && (bottomSheetState2.isCollapsed() || bottomSheetState2.isDismissed())) {
                                        z5 = true;
                                    }
                                    return Boolean.valueOf(z5);
                            }
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue16);
                }
                AppBarKt.appBarScrollBehavior((Function0) objRememberedValue16, gapComposer);
                boolean zChanged8 = gapComposer.changed(bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ);
                Object objRememberedValue17 = gapComposer.rememberedValue();
                if (zChanged8 || objRememberedValue17 == neverEqualPolicy) {
                    objRememberedValue17 = new Function0() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b5 = b3;
                            boolean z5 = false;
                            State state3 = state2;
                            BottomSheetState bottomSheetState2 = bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ;
                            switch (b5) {
                                case 0:
                                    int i4 = MainActivity.$r8$clinit;
                                    if (!((Boolean) state3.getValue()).booleanValue() && (bottomSheetState2.isCollapsed() || bottomSheetState2.isDismissed())) {
                                        z5 = true;
                                    }
                                    return Boolean.valueOf(z5);
                                default:
                                    int i5 = MainActivity.$r8$clinit;
                                    if (!((Boolean) state3.getValue()).booleanValue() && (bottomSheetState2.isCollapsed() || bottomSheetState2.isDismissed())) {
                                        z5 = true;
                                    }
                                    return Boolean.valueOf(z5);
                            }
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue17);
                }
                NavDeepLinkRequest navDeepLinkRequestAppBarScrollBehavior = AppBarKt.appBarScrollBehavior((Function0) objRememberedValue17, gapComposer);
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
                boolean zChanged9 = gapComposer.changed(mutableStateCurrentBackStackEntryAsState) | gapComposer.changed(function1Component3) | gapComposer.changedInstance(list3) | gapComposer.changed(str) | gapComposer.changed(navDeepLinkRequestAppBarScrollBehavior) | gapComposer.changed(bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ) | gapComposer.changedInstance(navHostController) | gapComposer.changed(function1Component2);
                Object objRememberedValue18 = gapComposer.rememberedValue();
                if (zChanged9 || objRememberedValue18 == neverEqualPolicy) {
                    navDeepLinkRequest = navDeepLinkRequestAppBarScrollBehavior;
                    list = list3;
                    objRememberedValue18 = new QuickJs.AnonymousClass3(function1Component3, list, navDeepLinkRequest, bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ, navHostController, state2, mutableStateCurrentBackStackEntryAsState, str, function1Component2, null);
                    bottomSheetState = bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ;
                    mutableState2 = mutableStateCurrentBackStackEntryAsState;
                    gapComposer.updateRememberedValue(objRememberedValue18);
                } else {
                    mutableState2 = mutableStateCurrentBackStackEntryAsState;
                    navDeepLinkRequest = navDeepLinkRequestAppBarScrollBehavior;
                    list = list3;
                    bottomSheetState = bottomSheetStateM1475rememberBottomSheetStatejTDHpeQ;
                }
                Stack.LaunchedEffect(gapComposer, navBackStackEntry, (Function2) objRememberedValue18);
                boolean zChangedInstance2 = gapComposer.changedInstance(playerConnection2) | gapComposer.changed(bottomSheetState);
                Object objRememberedValue19 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                    objRememberedValue19 = new SyncUtils$createPlaylist$1.AnonymousClass1(bottomSheetState, playerConnection2, continuation2, (byte) 4);
                    gapComposer.updateRememberedValue(objRememberedValue19);
                }
                Stack.LaunchedEffect(gapComposer, playerConnection2, (Function2) objRememberedValue19);
                boolean zChangedInstance3 = gapComposer.changedInstance(playerConnection2) | gapComposer.changed(bottomSheetState);
                Object objRememberedValue20 = gapComposer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                    objRememberedValue20 = new QuickJs$$ExternalSyntheticLambda1(playerConnection2, bottomSheetState, (byte) 9);
                    gapComposer.updateRememberedValue(objRememberedValue20);
                }
                Stack.DisposableEffect(playerConnection2, bottomSheetState, (Function1) objRememberedValue20, gapComposer);
                Object[] objArr3 = new Object[0];
                Object objRememberedValue21 = gapComposer.rememberedValue();
                if (objRememberedValue21 == neverEqualPolicy) {
                    objRememberedValue21 = new LastFM$$ExternalSyntheticLambda1((byte) 19);
                    gapComposer.updateRememberedValue(objRememberedValue21);
                }
                MutableState mutableState7 = (MutableState) SaverKt.rememberSaveable(objArr3, (Function0) objRememberedValue21, gapComposer, 48);
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) mutableState2.getValue();
                boolean z5 = z;
                boolean zChanged10 = gapComposer.changed(mutableState2) | gapComposer.changed(mutableState7) | gapComposer.changedInstance(list4) | gapComposer.changed(z5);
                Object objRememberedValue22 = gapComposer.rememberedValue();
                if (zChanged10 || objRememberedValue22 == neverEqualPolicy) {
                    mutableState3 = mutableState7;
                    z3 = z5;
                    objRememberedValue22 = new DataStoreKt$get$2(list4, z3, mutableState2, mutableState3, null, (byte) 2);
                    gapComposer.updateRememberedValue(objRememberedValue22);
                } else {
                    mutableState3 = mutableState7;
                    z3 = z5;
                }
                Stack.LaunchedEffect(navBackStackEntry2, bool, (Function2) objRememberedValue22, gapComposer);
                Object objRememberedValue23 = gapComposer.rememberedValue();
                if (objRememberedValue23 == neverEqualPolicy) {
                    objRememberedValue23 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue23);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue23;
                Object objRememberedValue24 = gapComposer.rememberedValue();
                if (objRememberedValue24 == neverEqualPolicy) {
                    objRememberedValue24 = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue24);
                }
                final MutableState mutableState8 = (MutableState) objRememberedValue24;
                Object objRememberedValue25 = gapComposer.rememberedValue();
                if (objRememberedValue25 == neverEqualPolicy) {
                    objRememberedValue25 = new SnackbarHostState();
                    gapComposer.updateRememberedValue(objRememberedValue25);
                }
                final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue25;
                boolean zChangedInstance4 = gapComposer.changedInstance(mainActivity) | gapComposer.changedInstance(navHostController);
                Object objRememberedValue26 = gapComposer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue26 == neverEqualPolicy) {
                    continuation = null;
                    objRememberedValue26 = new DownloadUtil.AnonymousClass2(mainActivity, navHostController, continuation, (byte) 8);
                    gapComposer.updateRememberedValue(objRememberedValue26);
                } else {
                    continuation = null;
                }
                Unit unit4 = unit;
                Stack.LaunchedEffect(gapComposer, unit4, (Function2) objRememberedValue26);
                boolean zChangedInstance5 = gapComposer.changedInstance(mainActivity) | gapComposer.changedInstance(navHostController);
                Object objRememberedValue27 = gapComposer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue27 == neverEqualPolicy) {
                    objRememberedValue27 = new QuickJs$$ExternalSyntheticLambda1(mainActivity, navHostController, (byte) 10);
                    gapComposer.updateRememberedValue(objRememberedValue27);
                }
                Stack.DisposableEffect(unit4, (Function1) objRememberedValue27, gapComposer);
                boolean zChanged11 = gapComposer.changed((NavBackStackEntry) mutableState2.getValue());
                Object objRememberedValue28 = gapComposer.rememberedValue();
                if (zChanged11 || objRememberedValue28 == neverEqualPolicy) {
                    NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) mutableState2.getValue();
                    Object obj16 = (navBackStackEntry3 == null || (navDestination = navBackStackEntry3.destination) == null) ? continuation : (String) navDestination.impl.layoutNodes;
                    Screens.Home home2 = Screens.Home.INSTANCE;
                    if (Intrinsics.areEqual(obj16, "home")) {
                        objValueOf = Integer.valueOf(R.string.home);
                    } else {
                        Screens.Search search = Screens.Search.INSTANCE;
                        if (Intrinsics.areEqual(obj16, "search_input")) {
                            objValueOf = Integer.valueOf(R.string.search);
                        } else {
                            Screens.Library library2 = Screens.Library.INSTANCE;
                            if (Intrinsics.areEqual(obj16, "library")) {
                                objValueOf = Integer.valueOf(R.string.filter_library);
                            } else {
                                Screens.ListenTogether listenTogether2 = Screens.ListenTogether.INSTANCE;
                                objValueOf = Intrinsics.areEqual(obj16, "listen_together") ? Integer.valueOf(R.string.together) : continuation;
                            }
                        }
                    }
                    gapComposer.updateRememberedValue(objValueOf);
                    objRememberedValue28 = objValueOf;
                }
                final Integer num = (Integer) objRememberedValue28;
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.PauseListenHistoryKey, Boolean.FALSE, gapComposer, 48);
                MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.$$delegate_0.eventCount(), 0, gapComposer, 48);
                boolean zChanged12 = gapComposer.changed(((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue()) | gapComposer.changed(((Number) mutableStateCollectAsStateWithLifecycle2.getValue()).intValue());
                Object objRememberedValue29 = gapComposer.rememberedValue();
                if (zChanged12 || objRememberedValue29 == neverEqualPolicy) {
                    objRememberedValue29 = Boolean.valueOf((((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue() && ((Number) mutableStateCollectAsStateWithLifecycle2.getValue()).intValue() == 0) ? false : true);
                    gapComposer.updateRememberedValue(objRememberedValue29);
                }
                final boolean zBooleanValue6 = ((Boolean) objRememberedValue29).booleanValue();
                final boolean z6 = this.f$3;
                if (z6) {
                    gapComposer.startReplaceGroup(-296994118);
                    gapComposer.end(false);
                    j = -72057594037927936L;
                } else {
                    gapComposer.startReplaceGroup(-296992923);
                    j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                    gapComposer.end(false);
                }
                final long j2 = j;
                MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(ArtistNameAliases.aliases, gapComposer);
                ProvidedValue providedValueDefaultProvidedValue$runtime = MainActivityKt.LocalDatabase.defaultProvidedValue$runtime(musicDatabase);
                ProvidedValue providedValueDefaultProvidedValue$runtime2 = MainActivityKt.LocalNavController.defaultProvidedValue$runtime(navHostController);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ContentColorKt.LocalContentColor;
                if (z6) {
                    gapComposer.startReplaceGroup(-296982022);
                    gapComposer.end(false);
                    jM282contentColorForek8zF_U = -4294967296L;
                } else {
                    gapComposer.startReplaceGroup(-296981625);
                    jM282contentColorForek8zF_U = ColorSchemeKt.m282contentColorForek8zF_U(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface, gapComposer);
                    gapComposer.end(false);
                }
                ProvidedValue[] providedValueArr = {providedValueDefaultProvidedValue$runtime, providedValueDefaultProvidedValue$runtime2, Fragment$5$$ExternalSyntheticOutline0.m(jM282contentColorForek8zF_U, staticProvidableCompositionLocal), MainActivityKt.LocalPlayerConnection.defaultProvidedValue$runtime(playerConnection), MainActivityKt.LocalPlayerAwareWindowInsets.defaultProvidedValue$runtime(windowInsets), MainActivityKt.LocalDownloadUtil.defaultProvidedValue$runtime(downloadUtil), ShimmerThemeKt.LocalShimmerTheme.defaultProvidedValue$runtime(ShimmerHostKt.ShimmerTheme), MainActivityKt.LocalSyncUtils.defaultProvidedValue$runtime(syncUtils), MainActivityKt.LocalListenTogetherManager.defaultProvidedValue$runtime(mainActivity.getListenTogetherManager()), MainActivityKt.LocalChangelogState.defaultProvidedValue$runtime(mutableState4), GlassComponentsKt.LocalHazeState.defaultProvidedValue$runtime(((UiStyle) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4.getValue()) == UiStyle.GLASS ? hazeState : continuation), GlassComponentsKt.LocalGlassBlurEnabled.defaultProvidedValue$runtime(Boolean.valueOf(this.f$8)), MainActivityKt.LocalArtistNameAliases.defaultProvidedValue$runtime((Map) mutableStateCollectAsStateWithLifecycle3.getValue())};
                final String str4 = this.f$10;
                final BottomSheetState bottomSheetState2 = bottomSheetState;
                final boolean z7 = z4;
                final PlayerConnection playerConnection3 = playerConnection2;
                final boolean z8 = z3;
                final MutableState mutableState9 = mutableState3;
                final List list5 = list;
                final NavDeepLinkRequest navDeepLinkRequest2 = navDeepLinkRequest;
                Stack.CompositionLocalProvider(providedValueArr, Expect_jvmKt.rememberComposableLambda(825351733, new Function2() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj17, Object obj18) {
                        boolean z9;
                        Composer composer2 = (Composer) obj17;
                        int iIntValue2 = ((Integer) obj18).intValue();
                        int i4 = MainActivity.$r8$clinit;
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                            MutableState mutableState10 = mutableState4;
                            boolean zBooleanValue7 = ((Boolean) mutableState10.getValue()).booleanValue();
                            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                            if (zBooleanValue7) {
                                gapComposer2.startReplaceGroup(-634241823);
                                boolean zChanged13 = gapComposer2.changed(mutableState10);
                                Object objRememberedValue30 = gapComposer2.rememberedValue();
                                if (zChanged13 || objRememberedValue30 == neverEqualPolicy2) {
                                    objRememberedValue30 = new MainActivity$$ExternalSyntheticLambda29(mutableState10, (byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue30);
                                }
                                ChangelogScreenKt.ChangelogScreen((Function0) objRememberedValue30, gapComposer2, 0);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-634138035);
                                gapComposer2.end(false);
                            }
                            FillElement fillElement = SizeKt.FillWholeMaxSize;
                            final NavDeepLinkRequest navDeepLinkRequest3 = navDeepLinkRequest2;
                            Modifier modifierNestedScroll = NestedScrollModifierKt.nestedScroll(fillElement, (AppBarScrollBehavior$nestedScrollConnection$1) navDeepLinkRequest3.mimeType, null);
                            MutableState mutableState11 = mutableState9;
                            final boolean z10 = z6;
                            final boolean z11 = z7;
                            WindowInsets windowInsets2 = androidWindowInsets;
                            MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$5 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
                            Integer num2 = num;
                            boolean z12 = zBooleanValue6;
                            final NavHostController navHostController2 = navHostController;
                            boolean z13 = z8;
                            String str5 = str4;
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-713152783, new MainActivity$$ExternalSyntheticLambda31(mutableState11, z10, z11, windowInsets2, navDeepLinkRequest3, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$5, num2, z12, navHostController2, z13, str5), gapComposer2);
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            final BottomSheetState bottomSheetState3 = bottomSheetState2;
                            final float f4 = fMo78toDpu2uoSUM;
                            final PlayerConnection playerConnection4 = playerConnection3;
                            final BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl2 = boxWithConstraintsScopeImpl;
                            final float f5 = fMo122calculateBottomPaddingD9Ej5fM;
                            final boolean z14 = zBooleanValue4;
                            final boolean z15 = zBooleanValue5;
                            final long j3 = j2;
                            final float f6 = f;
                            final State state3 = animateAsStateM18animateDpAsStateAjpBEmI;
                            final List list6 = list5;
                            final boolean z16 = zBooleanValue3;
                            final State state4 = state;
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-2003804592, new Function2() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda32
                                /* JADX WARN: Multi-variable type inference failed */
                                /* JADX WARN: Type inference failed for: r14v10, types: [boolean, int] */
                                /* JADX WARN: Type inference failed for: r14v11 */
                                /* JADX WARN: Type inference failed for: r14v9 */
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj19, Object obj20) {
                                    long j4;
                                    boolean z17;
                                    long j5;
                                    Modifier.Companion companion;
                                    boolean z18;
                                    BottomSheetState bottomSheetState4;
                                    ?? r14;
                                    Composer composer3 = (Composer) obj19;
                                    int iIntValue3 = ((Integer) obj20).intValue();
                                    int i5 = MainActivity.$r8$clinit;
                                    BiasAlignment biasAlignment = Alignment.Companion.BottomCenter;
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                        NavHostController navHostController3 = navHostController2;
                                        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = navHostController3.impl.getCurrentBackStackEntry$navigation_runtime_release();
                                        boolean zChanged14 = gapComposer3.changed(navHostController3);
                                        CoroutineScope coroutineScope3 = coroutineScope2;
                                        boolean zChanged15 = zChanged14 | gapComposer3.changed(coroutineScope3);
                                        NavDeepLinkRequest navDeepLinkRequest4 = navDeepLinkRequest3;
                                        boolean zChanged16 = zChanged15 | gapComposer3.changed(navDeepLinkRequest4);
                                        BottomSheetState bottomSheetState5 = bottomSheetState3;
                                        boolean zChanged17 = gapComposer3.changed(currentBackStackEntry$navigation_runtime_release) | zChanged16 | gapComposer3.changed(bottomSheetState5);
                                        Object objRememberedValue31 = gapComposer3.rememberedValue();
                                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                                        if (zChanged17 || objRememberedValue31 == neverEqualPolicy3) {
                                            MainActivity$$ExternalSyntheticLambda46 mainActivity$$ExternalSyntheticLambda46 = new MainActivity$$ExternalSyntheticLambda46(bottomSheetState5, navHostController3, coroutineScope3, navDeepLinkRequest4, (byte) 0);
                                            gapComposer3.updateRememberedValue(mainActivity$$ExternalSyntheticLambda46);
                                            objRememberedValue31 = mainActivity$$ExternalSyntheticLambda46;
                                        }
                                        Function2 function2 = (Function2) objRememberedValue31;
                                        boolean zChanged18 = gapComposer3.changed(navHostController3);
                                        Object objRememberedValue32 = gapComposer3.rememberedValue();
                                        if (zChanged18 || objRememberedValue32 == neverEqualPolicy3) {
                                            objRememberedValue32 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 3);
                                            gapComposer3.updateRememberedValue(objRememberedValue32);
                                        }
                                        Function0 function0 = (Function0) objRememberedValue32;
                                        SpringSpec springSpec4 = DimensionsKt.NavigationBarAnimationSpec;
                                        float f7 = f4;
                                        float f8 = 80.0f + f7 + CropImageView.DEFAULT_ASPECT_RATIO;
                                        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
                                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                        boolean z19 = z11;
                                        PlayerConnection playerConnection5 = playerConnection4;
                                        boolean z20 = z10;
                                        float f9 = f5;
                                        boolean z21 = z14;
                                        boolean z22 = z15;
                                        long j6 = j3;
                                        if (z19) {
                                            gapComposer3.startReplaceGroup(416112550);
                                            gapComposer3.startReplaceGroup(416126624);
                                            if (playerConnection5 != null) {
                                                gapComposer3.startReplaceGroup(416196684);
                                                j4 = j6;
                                                QueueKt.BottomSheetPlayer(bottomSheetState5, navHostController3, null, z20, gapComposer3, 0);
                                                z17 = false;
                                                gapComposer3.end(false);
                                            } else {
                                                j4 = j6;
                                                z17 = false;
                                                gapComposer3.startReplaceGroup(416540722);
                                                gapComposer3.end(false);
                                            }
                                            gapComposer3.end(z17);
                                            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(boxWithConstraintsScopeImpl2.align(SizeKt.fillMaxWidth(companion2, 1.0f), biasAlignment), f9);
                                            boolean zChanged19 = gapComposer3.changed(bottomSheetState5) | gapComposer3.changed(z21) | gapComposer3.changed(z22);
                                            Object objRememberedValue33 = gapComposer3.rememberedValue();
                                            if (zChanged19 || objRememberedValue33 == neverEqualPolicy3) {
                                                objRememberedValue33 = new MainActivity$$ExternalSyntheticLambda50(bottomSheetState5, z21, z22, (byte) 1);
                                                gapComposer3.updateRememberedValue(objRememberedValue33);
                                            }
                                            BoxKt.Box(ImageKt.m39backgroundbw27NRU(ColorKt.graphicsLayer(modifierM145height3ABfNKs, (Function1) objRememberedValue33), j4, rectangleShapeKt$RectangleShape$1), gapComposer3, 0);
                                            gapComposer3.end(false);
                                        } else {
                                            gapComposer3.startReplaceGroup(412031183);
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                            int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, companion2);
                                            ComposeUiNode.Companion.getClass();
                                            gapComposer3.startReusableNode();
                                            if (gapComposer3.inserting) {
                                                gapComposer3.createNode(LayoutNode.Constructor);
                                            } else {
                                                gapComposer3.useNode();
                                            }
                                            Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                            Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                                            Stack.m389reconcileimpl(gapComposer3);
                                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                            if (playerConnection5 != null) {
                                                gapComposer3.startReplaceGroup(-164056531);
                                                j5 = j6;
                                                z18 = z20;
                                                bottomSheetState4 = bottomSheetState5;
                                                companion = companion2;
                                                QueueKt.BottomSheetPlayer(bottomSheetState4, navHostController3, null, z18, gapComposer3, 0);
                                                gapComposer3.end(false);
                                            } else {
                                                j5 = j6;
                                                companion = companion2;
                                                z18 = z20;
                                                bottomSheetState4 = bottomSheetState5;
                                                gapComposer3.startReplaceGroup(-163712493);
                                                gapComposer3.end(false);
                                            }
                                            String str6 = (String) state4.getValue();
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            boolean z23 = z18;
                                            Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(boxScopeInstance.align(companion, biasAlignment), f7 + f6 + CropImageView.DEFAULT_ASPECT_RATIO);
                                            State state5 = state3;
                                            boolean zChanged20 = gapComposer3.changed(state5) | gapComposer3.changed(f8) | gapComposer3.changed(bottomSheetState4);
                                            Object objRememberedValue34 = gapComposer3.rememberedValue();
                                            if (zChanged20 || objRememberedValue34 == neverEqualPolicy3) {
                                                objRememberedValue34 = new MainActivity$$ExternalSyntheticLambda48(f8, bottomSheetState4, state5, (byte) 0);
                                                gapComposer3.updateRememberedValue(objRememberedValue34);
                                            }
                                            Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifierM145height3ABfNKs2, (Function1) objRememberedValue34);
                                            boolean zChangedInstance6 = gapComposer3.changedInstance(navHostController3);
                                            Object objRememberedValue35 = gapComposer3.rememberedValue();
                                            if (zChangedInstance6 || objRememberedValue35 == r17) {
                                                objRememberedValue35 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 4);
                                                gapComposer3.updateRememberedValue(objRememberedValue35);
                                            }
                                            BottomSheetState bottomSheetState6 = bottomSheetState4;
                                            AppNavigationKt.AppNavigationBar(list6, str6, function2, modifierGraphicsLayer, z23, z16, function0, (Function0) objRememberedValue35, gapComposer3, 0);
                                            Modifier modifierM145height3ABfNKs3 = SizeKt.m145height3ABfNKs(boxScopeInstance.align(SizeKt.fillMaxWidth(companion, 1.0f), biasAlignment), f9);
                                            boolean zChanged21 = gapComposer3.changed(bottomSheetState6) | gapComposer3.changed((boolean) r19) | gapComposer3.changed((boolean) r21);
                                            Object objRememberedValue36 = gapComposer3.rememberedValue();
                                            if (zChanged21 || objRememberedValue36 == r17) {
                                                r14 = 0;
                                                objRememberedValue36 = new MainActivity$$ExternalSyntheticLambda50(bottomSheetState6, z21, z22, (byte) 0);
                                                gapComposer3.updateRememberedValue(objRememberedValue36);
                                            } else {
                                                r14 = 0;
                                            }
                                            BoxKt.Box(ImageKt.m39backgroundbw27NRU(ColorKt.graphicsLayer(modifierM145height3ABfNKs3, (Function1) objRememberedValue36), j5, rectangleShapeKt$RectangleShape$1), gapComposer3, r14);
                                            gapComposer3.end(true);
                                            gapComposer3.end(r14);
                                        }
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2);
                            SnackbarHostState snackbarHostState2 = snackbarHostState;
                            ScrimKt.m317ScaffoldTvnljyQ(modifierNestedScroll, composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, Expect_jvmKt.rememberComposableLambda(1000510895, new MainActivity$$ExternalSyntheticLambda0((byte) 3, snackbarHostState2), gapComposer2), null, 0, 0L, 0L, null, Expect_jvmKt.rememberComposableLambda(927337286, new MainActivity$$ExternalSyntheticLambda34(navHostController2, coroutineScope2, navDeepLinkRequest3, bottomSheetState3, z11, list6, z10, hazeState, state4, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$5, navigationTab2, navigationTab, str5, mainActivity, snackbarHostState2), gapComposer2), gapComposer2, 806882736, 432);
                            MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
                            BiasAlignment biasAlignment = Alignment.Companion.BottomCenter;
                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                            BottomSheetMenuKt.m1454BottomSheetMenuFNF3uiM(boxWithConstraintsScopeImpl2.align(companion, biasAlignment), menuState, 0L, gapComposer2, 0);
                            BottomSheetPageKt.m1455BottomSheetPageFNF3uiM(boxWithConstraintsScopeImpl2.align(companion, biasAlignment), (BottomSheetPageState) gapComposer2.consume(BottomSheetPageKt.LocalBottomSheetPageState), 0L, gapComposer2, 0);
                            MutableState mutableState12 = mutableState8;
                            SongItem songItem = (SongItem) mutableState12.getValue();
                            if (songItem == null) {
                                gapComposer2.startReplaceGroup(-613869461);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-613869460);
                                if (playerConnection == null) {
                                    gapComposer2.startReplaceGroup(-2060422862);
                                    gapComposer2.end(false);
                                    z9 = false;
                                } else {
                                    gapComposer2.startReplaceGroup(-2060422861);
                                    Object objRememberedValue31 = gapComposer2.rememberedValue();
                                    if (objRememberedValue31 == neverEqualPolicy2) {
                                        objRememberedValue31 = new MainActivity$$ExternalSyntheticLambda29(mutableState12, (byte) 12);
                                        gapComposer2.updateRememberedValue(objRememberedValue31);
                                    }
                                    z9 = false;
                                    AndroidDialog_androidKt.Dialog((Function0) objRememberedValue31, new DialogProperties(3), Expect_jvmKt.rememberComposableLambda(-1834202059, new MainActivity$$ExternalSyntheticLambda36(songItem, mutableState12, (byte) 0), gapComposer2), gapComposer2, 438);
                                    gapComposer2.end(false);
                                }
                                gapComposer2.end(z9);
                            }
                            if (((Boolean) mutableState10.getValue()).booleanValue()) {
                                gapComposer2.startReplaceGroup(-608320243);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-1405229660);
                                gapComposer2.startReplaceGroup(-612446499);
                                gapComposer2.end(false);
                                gapComposer2.end(false);
                            }
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 48);
                return unit4;
            case 1:
                VisualTransformation visualTransformation = (VisualTransformation) obj14;
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj13;
                Function2 function2 = (Function2) obj12;
                Function2 function3 = (Function2) obj11;
                Function2 function4 = (Function2) obj9;
                Function2 function5 = (Function2) obj10;
                Function2 function6 = (Function2) obj7;
                TextFieldColors textFieldColors = (TextFieldColors) obj8;
                Shape shape = (Shape) obj6;
                Function2 function7 = (Function2) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changedInstance(function7) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE$3;
                    boolean z9 = this.f$3;
                    textFieldDefaults.DecorationBox(this.f$10, function7, z9, this.f$8, visualTransformation, mutableInteractionSourceImpl, function2, function3, function4, function5, function6, textFieldColors, null, Expect_jvmKt.rememberComposableLambda(-656940872, new OutlinedTextFieldKt$$ExternalSyntheticLambda6(z9, mutableInteractionSourceImpl, textFieldColors, shape, (byte) 1), gapComposer2), gapComposer2, (iIntValue2 << 3) & 112);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit2;
            default:
                Function0 function0 = (Function0) obj14;
                final Context context2 = (Context) obj13;
                final Function1 function1 = (Function1) obj12;
                final MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj11;
                final MutableState mutableState10 = (MutableState) obj10;
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj9;
                final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj8;
                final MutableState mutableState11 = (MutableState) obj7;
                final MutableState mutableState12 = (MutableState) obj6;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    CardKt.TextButton(function0, null, false, null, null, null, AiSettingsKt.lambda$1839025979, gapComposer3, 805306368, 510);
                    final boolean z10 = this.f$3;
                    final boolean z11 = this.f$8;
                    boolean z12 = !z10 && z11;
                    boolean zChanged13 = gapComposer3.changed(z10) | gapComposer3.changed(z11) | gapComposer3.changedInstance(context2);
                    final String str5 = this.f$10;
                    boolean zChanged14 = zChanged13 | gapComposer3.changed(str5) | gapComposer3.changed(function1) | gapComposer3.changedInstance(musicAlarmEntry);
                    Object objRememberedValue30 = gapComposer3.rememberedValue();
                    if (zChanged14 || objRememberedValue30 == neverEqualPolicy) {
                        objRememberedValue30 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda37
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                MusicAlarmEntry musicAlarmEntry2;
                                boolean z13 = z10;
                                Unit unit5 = Unit.INSTANCE;
                                if (z13) {
                                    return unit5;
                                }
                                if (!z11) {
                                    Toast.makeText(context2, str5, 0).show();
                                    return unit5;
                                }
                                MusicAlarmEntry musicAlarmEntry3 = musicAlarmEntry;
                                if (musicAlarmEntry3 == null) {
                                    String string = UUID.randomUUID().toString();
                                    string.getClass();
                                    musicAlarmEntry2 = new MusicAlarmEntry(string, true, 7, 0, "", false, -1L);
                                } else {
                                    musicAlarmEntry2 = musicAlarmEntry3;
                                }
                                function1.invoke(MusicAlarmEntry.copy$default(musicAlarmEntry2, ((Boolean) mutableState10.getValue()).booleanValue(), parcelableSnapshotMutableIntState.getIntValue(), parcelableSnapshotMutableIntState2.getIntValue(), (String) mutableState11.getValue(), ((Boolean) mutableState12.getValue()).booleanValue(), 0L, 65));
                                return unit5;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue30);
                    }
                    CardKt.TextButton((Function0) objRememberedValue30, null, z12, null, null, null, AiSettingsKt.lambda$1874789284, gapComposer3, 805306368, 506);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit2;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda17(String str, boolean z, boolean z2, VisualTransformation visualTransformation, MutableInteractionSourceImpl mutableInteractionSourceImpl, Function2 function2, Function2 function3, Function2 function4, Function2 function5, Function2 function6, TextFieldColors textFieldColors, Shape shape) {
        this.f$10 = str;
        this.f$3 = z;
        this.f$8 = z2;
        this.f$0 = visualTransformation;
        this.f$1 = mutableInteractionSourceImpl;
        this.f$2 = function2;
        this.f$4 = function3;
        this.f$5 = function4;
        this.f$6 = function5;
        this.f$11 = function6;
        this.f$7 = textFieldColors;
        this.f$9 = shape;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda17(Function0 function0, boolean z, boolean z2, Context context, String str, Function1 function1, MusicAlarmEntry musicAlarmEntry, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, MutableState mutableState2, MutableState mutableState3) {
        this.f$0 = function0;
        this.f$3 = z;
        this.f$8 = z2;
        this.f$1 = context;
        this.f$10 = str;
        this.f$2 = function1;
        this.f$4 = musicAlarmEntry;
        this.f$6 = mutableState;
        this.f$5 = parcelableSnapshotMutableIntState;
        this.f$7 = parcelableSnapshotMutableIntState2;
        this.f$11 = mutableState2;
        this.f$9 = mutableState3;
    }
}
