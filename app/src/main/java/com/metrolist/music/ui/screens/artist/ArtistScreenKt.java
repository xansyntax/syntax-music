package com.metrolist.music.ui.screens.artist;

import android.content.Context;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
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
import androidx.compose.ui.unit.Density;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.utils.AppBarKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArtistScreenKt {
    /* JADX WARN: Code duplicated, block: B:114:0x041a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0421  */
    /* JADX WARN: Code duplicated, block: B:119:0x0439  */
    /* JADX WARN: Code duplicated, block: B:122:0x043e  */
    /* JADX WARN: Code duplicated, block: B:126:0x045e  */
    /* JADX WARN: Code duplicated, block: B:128:0x046a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0476  */
    /* JADX WARN: Code duplicated, block: B:132:0x0482 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x048e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0498  */
    /* JADX WARN: Code duplicated, block: B:141:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:142:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:144:0x04af  */
    /* JADX WARN: Code duplicated, block: B:145:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:149:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:152:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:155:0x0503  */
    /* JADX WARN: Code duplicated, block: B:156:0x0506  */
    /* JADX WARN: Code duplicated, block: B:158:0x0543 A[LOOP:0: B:137:0x0492->B:158:0x0543, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:159:0x054c  */
    /* JADX WARN: Code duplicated, block: B:162:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:163:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:172:0x04b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x054c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v42, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r36v0 */
    /* JADX WARN: Type inference failed for: r6v15, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r6v20, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.runtime.Composer] */
    public static final void ArtistScreen(NavHostController navHostController, ArtistViewModel artistViewModel, Composer composer, final int i) {
        final ArtistViewModel artistViewModel2;
        ?? r6;
        final ArtistViewModel artistViewModel3;
        String str;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2;
        boolean z;
        final MutableState mutableState;
        SongItem songItem;
        ArtistPage artistPage;
        MutableState mutableState2;
        String str2;
        boolean z2;
        PlayerConnection playerConnection;
        MutableState mutableState3;
        GapComposer gapComposer;
        ArtistViewModel artistViewModel4;
        boolean z3;
        boolean z4;
        ?? r11;
        int i2;
        boolean zChanged;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        BoxScopeInstance boxScopeInstance;
        NeverEqualPolicy neverEqualPolicy2;
        boolean z5;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        boolean z6;
        State state;
        TopAppBarColors defaultTopAppBarColors$material3;
        ?? r7;
        List list;
        Iterator it;
        Object objFirstOrNull;
        SongItem songItem2;
        Object obj;
        Album album;
        Object objRememberedValue2;
        Object obj2;
        Object objRememberedValue3;
        Object obj3;
        float f;
        boolean z7;
        final NavHostController navHostController2 = navHostController;
        navHostController2.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1240809037);
        int i3 = (gapComposer2.changedInstance(navHostController2) ? 4 : 2) | i | 16;
        final byte b = 0;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                artistViewModel3 = (ArtistViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(ArtistViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
            } else {
                gapComposer2.skipToGroupEnd();
                artistViewModel3 = artistViewModel;
            }
            gapComposer2.endDefaults();
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer2.consume(CompositionLocalsKt.LocalHapticFeedback);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
            if (objRememberedValue4 == neverEqualPolicy3) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            final PlayerConnection playerConnection2 = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController2, artistViewModel3, i, b) { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ ArtistViewModel f$1;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            ArtistViewModel artistViewModel5 = this.f$1;
                            NavHostController navHostController3 = this.f$0;
                            Composer composer2 = (Composer) obj4;
                            ((Integer) obj5).getClass();
                            switch (b2) {
                                case 0:
                                    ArtistScreenKt.ArtistScreen(navHostController3, artistViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    ArtistScreenKt.ArtistScreen(navHostController3, artistViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
            boolean z8 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
            final MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer2);
            final ArtistPage artistPage2 = (ArtistPage) artistViewModel3.artistPage$delegate.getValue();
            final MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(artistViewModel3.libraryArtist, gapComposer2);
            Map map = (Map) gapComposer2.consume(MainActivityKt.LocalArtistNameAliases);
            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
            String str3 = artistViewModel3.artistId;
            if (artistPage2 == null || (str = artistPage2.artist.title) == null) {
                Artist artist = (Artist) mutableStateCollectAsStateWithLifecycle3.getValue();
                str = artist != null ? artist.artist.name : null;
                if (str == null) {
                    str = "";
                }
            }
            String strResolve = ArtistNameAliases.resolve(str3, str, map);
            if (strResolve.length() == 0) {
                strResolve = null;
            }
            final MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(artistViewModel3.librarySongs, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(artistViewModel3.libraryAlbums, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(artistViewModel3.isChannelSubscribed, gapComposer2);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.HideExplicitKey, Boolean.FALSE, gapComposer2, 48);
            Preferences$Key preferences$Key = PreferenceKeysKt.ShowArtistDescriptionKey;
            Boolean bool = Boolean.TRUE;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key, bool, gapComposer2, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference3 = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowArtistSubscriberCountKey, bool, gapComposer2, 48);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference4 = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowMonthlyListenersKey, bool, gapComposer2, 48);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy3) {
                objRememberedValue5 = new SnackbarHostState();
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue5;
            Object[] objArr = new Object[0];
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy3) {
                objRememberedValue6 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 17);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue6, gapComposer2, 48);
            Density density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            float fMo125calculateTopPaddingD9Ej5fM = OffsetKt.asPaddingValues(OffsetKt.current(gapComposer2).systemBars, gapComposer2).mo125calculateTopPaddingD9Ej5fM();
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            density.mo75roundToPx0680j_4(fMo125calculateTopPaddingD9Ej5fM + 64.0f + CropImageView.DEFAULT_ASPECT_RATIO);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy3) {
                objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new LazyListKt$$ExternalSyntheticLambda0(lazyListStateRememberLazyListState, (byte) 5));
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            State state2 = (State) objRememberedValue7;
            boolean zChanged2 = gapComposer2.changed(artistPage2 != null ? artistPage2.sections : null);
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue8 == neverEqualPolicy3) {
                if (artistPage2 != null) {
                    List list2 = artistPage2.sections;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        List list3 = ((ArtistSection) it2.next()).items;
                        Iterator it3 = it2;
                        HashSet hashSet = new HashSet();
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj4 : list3) {
                            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$3 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$4 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                            if (hashSet.add(((YTItem) obj4).getId())) {
                                arrayList2.add(obj4);
                            }
                            dataStoreKt$rememberPreference$1$1RememberPreference4 = dataStoreKt$rememberPreference$1$3;
                            dataStoreKt$rememberPreference$1$1RememberPreference3 = dataStoreKt$rememberPreference$1$4;
                        }
                        arrayList.add(arrayList2);
                        it2 = it3;
                    }
                    dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                    dataStoreKt$rememberPreference$1$2 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                    objRememberedValue8 = arrayList;
                } else {
                    dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                    dataStoreKt$rememberPreference$1$2 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                    objRememberedValue8 = EmptyList.INSTANCE;
                }
                gapComposer2.updateRememberedValue(objRememberedValue8);
            } else {
                dataStoreKt$rememberPreference$1$1 = dataStoreKt$rememberPreference$1$1RememberPreference4;
                dataStoreKt$rememberPreference$1$2 = dataStoreKt$rememberPreference$1$1RememberPreference3;
                state2 = state2;
            }
            final List list4 = (List) objRememberedValue8;
            Artist artist2 = (Artist) mutableStateCollectAsStateWithLifecycle3.getValue();
            boolean zChanged3 = gapComposer2.changed(mutableState4) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3);
            Object objRememberedValue9 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue9 == neverEqualPolicy3) {
                z = false;
                objRememberedValue9 = new ArtistScreenKt$ArtistScreen$1$1(mutableStateCollectAsStateWithLifecycle3, mutableState4, null, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue9);
            } else {
                z = false;
            }
            Stack.LaunchedEffect(gapComposer2, artist2, (Function2) objRememberedValue9);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, z);
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
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$5 = dataStoreKt$rememberPreference$1$2;
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$6 = dataStoreKt$rememberPreference$1$1;
            final String str4 = strResolve;
            boolean zChangedInstance = gapComposer2.changedInstance(artistPage2) | gapComposer2.changed(mutableState4) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer2.changed(strResolve) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle6) | gapComposer2.changedInstance(artistViewModel3) | gapComposer2.changed(z8) | gapComposer2.changedInstance(playerConnection2) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference2) | gapComposer2.changed(dataStoreKt$rememberPreference$1$5) | gapComposer2.changed(dataStoreKt$rememberPreference$1$6) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(list4);
            Object objRememberedValue10 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue10 == neverEqualPolicy3) {
                final ArtistViewModel artistViewModel5 = artistViewModel3;
                mutableState = mutableState4;
                navHostController2 = navHostController;
                final boolean z9 = z8;
                songItem = null;
                objRememberedValue10 = new Function1() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda5
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r14v7, types: [java.util.List] */
                    /* JADX WARN: Type inference failed for: r4v17, types: [java.util.List] */
                    /* JADX WARN: Type inference failed for: r4v18, types: [java.util.List] */
                    /* JADX WARN: Type inference failed for: r4v20, types: [java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r6v1 */
                    /* JADX WARN: Type inference failed for: r6v3, types: [boolean, byte] */
                    /* JADX WARN: Type inference failed for: r6v6 */
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        boolean z10;
                        MenuState menuState2;
                        State state3;
                        State state4;
                        ?? arrayList3;
                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj5;
                        lazyListIntervalContent.getClass();
                        ArtistPage artistPage3 = artistPage2;
                        MutableState mutableState5 = mutableState;
                        if (artistPage3 != null || ArtistScreenKt.ArtistScreen$lambda$14(mutableState5)) {
                            MutableState mutableState6 = mutableStateCollectAsStateWithLifecycle3;
                            String str5 = str4;
                            final ArtistViewModel artistViewModel6 = artistViewModel5;
                            boolean z11 = z9;
                            State state5 = mutableStateCollectAsStateWithLifecycle6;
                            PlayerConnection playerConnection3 = playerConnection2;
                            TimePickerKt$$ExternalSyntheticLambda8 timePickerKt$$ExternalSyntheticLambda8 = new TimePickerKt$$ExternalSyntheticLambda8(artistPage3, mutableState6, str5, artistViewModel6, z11, state5, mutableState5, playerConnection3);
                            final boolean z12 = z11;
                            final PlayerConnection playerConnection4 = playerConnection3;
                            final ?? r8 = 1;
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "header", null, new ComposableLambdaImpl(true, -895456940, timePickerKt$$ExternalSyntheticLambda8), 2);
                            if (!ArtistScreenKt.ArtistScreen$lambda$14(mutableState5)) {
                                MutableState mutableState7 = dataStoreKt$rememberPreference$1$1RememberPreference2;
                                boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
                                MutableState mutableState8 = dataStoreKt$rememberPreference$1$5;
                                MutableState mutableState9 = dataStoreKt$rememberPreference$1$6;
                                if (zBooleanValue || ((Boolean) mutableState8.getValue()).booleanValue() || ((Boolean) mutableState9.getValue()).booleanValue()) {
                                    String str6 = artistPage3 != null ? artistPage3.description : null;
                                    List list5 = artistPage3 != null ? artistPage3.descriptionRuns : null;
                                    String str7 = artistPage3 != null ? artistPage3.subscriberCountText : null;
                                    String str8 = artistPage3 != null ? artistPage3.monthlyListenerCount : null;
                                    if ((((Boolean) mutableState7.getValue()).booleanValue() && str6 != null && str6.length() != 0) || ((((Boolean) mutableState8.getValue()).booleanValue() && str7 != null && str7.length() != 0) || (((Boolean) mutableState9.getValue()).booleanValue() && str8 != null && str8.length() != 0))) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "about_artist", null, new ComposableLambdaImpl(true, -601534306, new SongMenuKt$$ExternalSyntheticLambda8(str6, list5, str7, str8, mutableState7, mutableState8, mutableState9)), 2);
                                    }
                                }
                            }
                            if (artistPage3 == null && !((Boolean) mutableState5.getValue()).booleanValue()) {
                                LazyListIntervalContent.item$default(lazyListIntervalContent, "section_shimmer", null, ArtistItemsScreenKt.f342lambda$198786494, 2);
                            }
                            boolean zBooleanValue2 = ((Boolean) mutableState5.getValue()).booleanValue();
                            final byte b2 = 0;
                            final NavHostController navHostController3 = navHostController2;
                            final HapticFeedback hapticFeedback2 = hapticFeedback;
                            MenuState menuState3 = menuState;
                            State state6 = mutableStateCollectAsStateWithLifecycle2;
                            State state7 = mutableStateCollectAsStateWithLifecycle;
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            if (zBooleanValue2) {
                                State state8 = mutableStateCollectAsStateWithLifecycle4;
                                boolean zIsEmpty = ((List) state8.getValue()).isEmpty();
                                MutableState mutableState10 = dataStoreKt$rememberPreference$1$1RememberPreference;
                                if (zIsEmpty) {
                                    menuState2 = menuState3;
                                    state3 = state6;
                                    state4 = state7;
                                } else {
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "local_songs_title", null, new ComposableLambdaImpl(true, 2143797222, new Function3() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda16
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj6, Object obj7, Object obj8) {
                                            byte b3 = b2;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                            final NavHostController navHostController4 = navHostController3;
                                            final ArtistViewModel artistViewModel7 = artistViewModel6;
                                            final byte b4 = 1;
                                            Object[] objArr2 = 0;
                                            switch (b3) {
                                                case 0:
                                                    Composer composer2 = (Composer) obj7;
                                                    int iIntValue = ((Integer) obj8).intValue();
                                                    ((LazyItemScopeImpl) obj6).getClass();
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        String strStringResource = MathKt.stringResource(R.string.songs, gapComposer3);
                                                        boolean zChangedInstance2 = gapComposer3.changedInstance(navHostController4) | gapComposer3.changedInstance(artistViewModel7);
                                                        Object objRememberedValue11 = gapComposer3.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue11 == neverEqualPolicy4) {
                                                            final Object[] objArr3 = objArr2 == true ? 1 : 0;
                                                            objRememberedValue11 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda24
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    byte b5 = objArr3;
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    ArtistViewModel artistViewModel8 = artistViewModel7;
                                                                    NavHostController navHostController5 = navHostController4;
                                                                    switch (b5) {
                                                                        case 0:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/songs");
                                                                            break;
                                                                        default:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/albums");
                                                                            break;
                                                                    }
                                                                    return unit2;
                                                                }
                                                            };
                                                            gapComposer3.updateRememberedValue(objRememberedValue11);
                                                        }
                                                        MenuKt.NavigationTitle(strStringResource, Modifier.Companion.$$INSTANCE, null, null, (Function0) objRememberedValue11, null, gapComposer3, 48, 44);
                                                    }
                                                    break;
                                                default:
                                                    Composer composer3 = (Composer) obj7;
                                                    int iIntValue2 = ((Integer) obj8).intValue();
                                                    ((LazyItemScopeImpl) obj6).getClass();
                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                    if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                        gapComposer4.skipToGroupEnd();
                                                    } else {
                                                        String strStringResource2 = MathKt.stringResource(R.string.albums, gapComposer4);
                                                        boolean zChangedInstance3 = gapComposer4.changedInstance(navHostController4) | gapComposer4.changedInstance(artistViewModel7);
                                                        Object objRememberedValue12 = gapComposer4.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue12 == neverEqualPolicy4) {
                                                            objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda24
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    byte b5 = b4;
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    ArtistViewModel artistViewModel8 = artistViewModel7;
                                                                    NavHostController navHostController5 = navHostController4;
                                                                    switch (b5) {
                                                                        case 0:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/songs");
                                                                            break;
                                                                        default:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/albums");
                                                                            break;
                                                                    }
                                                                    return unit2;
                                                                }
                                                            };
                                                            gapComposer4.updateRememberedValue(objRememberedValue12);
                                                        }
                                                        MenuKt.NavigationTitle(strStringResource2, Modifier.Companion.$$INSTANCE, null, null, (Function0) objRememberedValue12, null, gapComposer4, 48, 44);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                    if (((Boolean) mutableState10.getValue()).booleanValue()) {
                                        List list6 = (List) state8.getValue();
                                        arrayList3 = new ArrayList();
                                        for (Object obj6 : list6) {
                                            if (!((Song) obj6).song.explicit) {
                                                arrayList3.add(obj6);
                                            }
                                        }
                                    } else {
                                        arrayList3 = (List) state8.getValue();
                                    }
                                    HomeScreenKt$$ExternalSyntheticLambda97 homeScreenKt$$ExternalSyntheticLambda97 = new HomeScreenKt$$ExternalSyntheticLambda97((byte) 18);
                                    int size = arrayList3.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(homeScreenKt$$ExternalSyntheticLambda97, arrayList3, (byte) 2);
                                    SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(arrayList3, (byte) 27);
                                    menuState2 = menuState3;
                                    state3 = state6;
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3 artistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3((List) arrayList3, hapticFeedback2, menuState2, z12, state3, playerConnection4, str5, state8, state7);
                                    state4 = state7;
                                    r8 = 1;
                                    lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3, new ComposableLambdaImpl(true, 2039820996, artistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3));
                                }
                                State state9 = mutableStateCollectAsStateWithLifecycle5;
                                if (!((List) state9.getValue()).isEmpty()) {
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "local_albums_title", null, new ComposableLambdaImpl(r8, 2099312271, new Function3() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda16
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj7, Object obj8, Object obj9) {
                                            byte b3 = r8;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                            final NavHostController navHostController4 = navHostController3;
                                            final ArtistViewModel artistViewModel7 = artistViewModel6;
                                            final byte b4 = 1;
                                            Object[] objArr2 = 0;
                                            switch (b3) {
                                                case 0:
                                                    Composer composer2 = (Composer) obj8;
                                                    int iIntValue = ((Integer) obj9).intValue();
                                                    ((LazyItemScopeImpl) obj7).getClass();
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        String strStringResource = MathKt.stringResource(R.string.songs, gapComposer3);
                                                        boolean zChangedInstance2 = gapComposer3.changedInstance(navHostController4) | gapComposer3.changedInstance(artistViewModel7);
                                                        Object objRememberedValue11 = gapComposer3.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue11 == neverEqualPolicy4) {
                                                            final byte objArr3 = objArr2 == true ? 1 : 0;
                                                            objRememberedValue11 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda24
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    byte b5 = objArr3;
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    ArtistViewModel artistViewModel8 = artistViewModel7;
                                                                    NavHostController navHostController5 = navHostController4;
                                                                    switch (b5) {
                                                                        case 0:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/songs");
                                                                            break;
                                                                        default:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/albums");
                                                                            break;
                                                                    }
                                                                    return unit2;
                                                                }
                                                            };
                                                            gapComposer3.updateRememberedValue(objRememberedValue11);
                                                        }
                                                        MenuKt.NavigationTitle(strStringResource, Modifier.Companion.$$INSTANCE, null, null, (Function0) objRememberedValue11, null, gapComposer3, 48, 44);
                                                    }
                                                    break;
                                                default:
                                                    Composer composer3 = (Composer) obj8;
                                                    int iIntValue2 = ((Integer) obj9).intValue();
                                                    ((LazyItemScopeImpl) obj7).getClass();
                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                    if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                        gapComposer4.skipToGroupEnd();
                                                    } else {
                                                        String strStringResource2 = MathKt.stringResource(R.string.albums, gapComposer4);
                                                        boolean zChangedInstance3 = gapComposer4.changedInstance(navHostController4) | gapComposer4.changedInstance(artistViewModel7);
                                                        Object objRememberedValue12 = gapComposer4.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue12 == neverEqualPolicy4) {
                                                            objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda24
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    byte b5 = b4;
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    ArtistViewModel artistViewModel8 = artistViewModel7;
                                                                    NavHostController navHostController5 = navHostController4;
                                                                    switch (b5) {
                                                                        case 0:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/songs");
                                                                            break;
                                                                        default:
                                                                            NavHostController.navigate$default(navHostController5, "artist/" + artistViewModel8.artistId + "/albums");
                                                                            break;
                                                                    }
                                                                    return unit2;
                                                                }
                                                            };
                                                            gapComposer4.updateRememberedValue(objRememberedValue12);
                                                        }
                                                        MenuKt.NavigationTitle(strStringResource2, Modifier.Companion.$$INSTANCE, null, null, (Function0) objRememberedValue12, null, gapComposer4, 48, 44);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "local_albums_list", null, new ComposableLambdaImpl(r8, 1723651320, new AlbumMenuKt$$ExternalSyntheticLambda20(state3, state4, hapticFeedback2, menuState2, navHostController3, coroutineScope2, mutableState10, state9)), 2);
                                }
                            } else {
                                final MenuState menuState4 = menuState3;
                                final State state10 = state6;
                                final State state11 = state7;
                                if (artistPage3 != null) {
                                    final int i4 = 0;
                                    for (Object obj7 : artistPage3.sections) {
                                        int i5 = i4 + 1;
                                        if (i4 < 0) {
                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                            throw null;
                                        }
                                        final ArtistSection artistSection = (ArtistSection) obj7;
                                        List list7 = artistSection.items;
                                        String str9 = artistSection.title;
                                        if (!list7.isEmpty()) {
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, Fragment$5$$ExternalSyntheticOutline0.m("section_", str9), null, new ComposableLambdaImpl(true, 765625739, new PlayerKt$$ExternalSyntheticLambda82(artistSection, artistViewModel6, navHostController3, (byte) 13)), 2);
                                        }
                                        Object objFirstOrNull2 = CollectionsKt.firstOrNull(list7);
                                        SongItem songItem3 = objFirstOrNull2 instanceof SongItem ? (SongItem) objFirstOrNull2 : null;
                                        Album album2 = songItem3 != null ? songItem3.album : null;
                                        final List list8 = list4;
                                        if (album2 != null) {
                                            List list9 = (List) CollectionsKt.getOrNull(i4, list8);
                                            final List list10 = list9 == null ? list7 : list9;
                                            z10 = false;
                                            lazyListIntervalContent.items(list10.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 9), list10, (byte) 0), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 10), list10, (byte) 4), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$3
                                                @Override // kotlin.jvm.functions.Function4
                                                public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) {
                                                    int i6;
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj8;
                                                    int iIntValue = ((Number) obj9).intValue();
                                                    Composer composer2 = (Composer) obj10;
                                                    int iIntValue2 = ((Number) obj11).intValue();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        i6 = (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                                                    } else {
                                                        i6 = iIntValue2;
                                                    }
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i6 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (gapComposer3.shouldExecute(i6 & 1, (i6 & 147) != 146)) {
                                                        final YTItem yTItem = (YTItem) list10.get(iIntValue);
                                                        gapComposer3.startReplaceGroup(-1454481977);
                                                        yTItem.getClass();
                                                        SongItem songItem4 = (SongItem) yTItem;
                                                        final State state12 = state10;
                                                        MediaMetadata mediaMetadata = (MediaMetadata) state12.getValue();
                                                        boolean zAreEqual = Intrinsics.areEqual(mediaMetadata != null ? mediaMetadata.id : null, songItem4.id);
                                                        boolean zBooleanValue3 = ((Boolean) state11.getValue()).booleanValue();
                                                        HapticFeedback hapticFeedback3 = hapticFeedback2;
                                                        boolean zChangedInstance2 = gapComposer3.changedInstance(hapticFeedback3);
                                                        MenuState menuState5 = menuState4;
                                                        boolean zChanged4 = zChangedInstance2 | gapComposer3.changed(menuState5) | gapComposer3.changedInstance(yTItem);
                                                        Object objRememberedValue11 = gapComposer3.rememberedValue();
                                                        NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                                        if (zChanged4 || objRememberedValue11 == neverEqualPolicy4) {
                                                            objRememberedValue11 = new AccountScreenKt$AccountScreen$1$1$11$1$1(hapticFeedback3, menuState5, yTItem, (byte) 1);
                                                            gapComposer3.updateRememberedValue(objRememberedValue11);
                                                        }
                                                        Function0 function0 = (Function0) objRememberedValue11;
                                                        final boolean z13 = z12;
                                                        boolean zChanged5 = gapComposer3.changed(z13) | gapComposer3.changedInstance(yTItem) | gapComposer3.changed(state12);
                                                        final PlayerConnection playerConnection5 = playerConnection4;
                                                        boolean zChangedInstance3 = zChanged5 | gapComposer3.changedInstance(playerConnection5);
                                                        Object objRememberedValue12 = gapComposer3.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue12 == neverEqualPolicy4) {
                                                            objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$2$1$1$9$4$2$1
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    if (!z13) {
                                                                        SongItem songItem5 = (SongItem) yTItem;
                                                                        String str10 = songItem5.id;
                                                                        MediaMetadata mediaMetadata2 = (MediaMetadata) state12.getValue();
                                                                        boolean zAreEqual2 = Intrinsics.areEqual(str10, mediaMetadata2 != null ? mediaMetadata2.id : null);
                                                                        PlayerConnection playerConnection6 = playerConnection5;
                                                                        if (zAreEqual2) {
                                                                            playerConnection6.togglePlayPause();
                                                                        } else {
                                                                            playerConnection6.playQueue(new YouTubeQueue(new WatchEndpoint(62, str10, null, null), HexFormatKt.toMediaMetadata(songItem5)));
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            gapComposer3.updateRememberedValue(objRememberedValue12);
                                                        }
                                                        MenuKt.YouTubeListItem(songItem4, ImageKt.m48combinedClickablehoGz1lA$default(Modifier.Companion.$$INSTANCE, false, function0, (Function0) objRememberedValue12, 239), false, zAreEqual, zBooleanValue3, false, null, Expect_jvmKt.rememberComposableLambda(-1006906039, new ArtistScreenKt$ArtistScreen$2$1$1$9$4$3(menuState5, yTItem), gapComposer3), null, gapComposer3, 100663296, 716);
                                                        gapComposer3.end(false);
                                                    } else {
                                                        gapComposer3.skipToGroupEnd();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }));
                                        } else {
                                            z10 = false;
                                            String strM = Fragment$5$$ExternalSyntheticOutline0.m("section_list_", str9);
                                            final MenuState menuState5 = menuState4;
                                            final boolean z13 = z12;
                                            final State state12 = state11;
                                            final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                            final State state13 = state10;
                                            final PlayerConnection playerConnection5 = playerConnection4;
                                            Function3 function3 = new Function3() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda23
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Object invoke(Object obj8, Object obj9, Object obj10) {
                                                    Composer composer2 = (Composer) obj9;
                                                    int iIntValue = ((Integer) obj10).intValue();
                                                    ((LazyItemScopeImpl) obj8).getClass();
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                        WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                                                        InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer3).systemBars, 15), gapComposer3);
                                                        final List list11 = list8;
                                                        boolean zChangedInstance2 = gapComposer3.changedInstance(list11);
                                                        final int i6 = i4;
                                                        boolean zChanged4 = zChangedInstance2 | gapComposer3.changed(i6);
                                                        final ArtistSection artistSection2 = artistSection;
                                                        boolean zChangedInstance3 = zChanged4 | gapComposer3.changedInstance(artistSection2);
                                                        final State state14 = state13;
                                                        boolean zChanged5 = zChangedInstance3 | gapComposer3.changed(state14);
                                                        final State state15 = state12;
                                                        boolean zChanged6 = zChanged5 | gapComposer3.changed(state15);
                                                        final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                                        boolean zChangedInstance4 = zChanged6 | gapComposer3.changedInstance(hapticFeedback4);
                                                        final MenuState menuState6 = menuState5;
                                                        boolean zChanged7 = zChangedInstance4 | gapComposer3.changed(menuState6);
                                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                                        boolean zChangedInstance5 = zChanged7 | gapComposer3.changedInstance(coroutineScope3);
                                                        final boolean z14 = z13;
                                                        boolean zChanged8 = zChangedInstance5 | gapComposer3.changed(z14);
                                                        final PlayerConnection playerConnection6 = playerConnection5;
                                                        boolean zChangedInstance6 = zChanged8 | gapComposer3.changedInstance(playerConnection6);
                                                        final NavHostController navHostController4 = navHostController3;
                                                        boolean zChangedInstance7 = zChangedInstance6 | gapComposer3.changedInstance(navHostController4);
                                                        Object objRememberedValue11 = gapComposer3.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue11 == Composer.Companion.Empty) {
                                                            Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda29
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj11) {
                                                                    LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj11;
                                                                    lazyListIntervalContent2.getClass();
                                                                    List list12 = (List) CollectionsKt.getOrNull(i6, list11);
                                                                    if (list12 == null) {
                                                                        list12 = artistSection2.items;
                                                                    }
                                                                    List list13 = list12;
                                                                    lazyListIntervalContent2.items(list13.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 11), list13, (byte) 5), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 12), list13, (byte) 6), new ComposableLambdaImpl(true, 802480018, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$$inlined$itemsIndexed$3(list13, hapticFeedback4, menuState6, coroutineScope3, z14, playerConnection6, navHostController4, state14, state15)));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            gapComposer3.updateRememberedValue(function1);
                                                            objRememberedValue11 = function1;
                                                        }
                                                        IntMath.LazyRow(null, null, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, (Function1) objRememberedValue11, gapComposer3, 0, 507);
                                                    } else {
                                                        gapComposer3.skipToGroupEnd();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            playerConnection4 = playerConnection5;
                                            state10 = state13;
                                            state11 = state12;
                                            hapticFeedback2 = hapticFeedback3;
                                            menuState4 = menuState5;
                                            z12 = z13;
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, strM, null, new ComposableLambdaImpl(true, -2129573621, function3), 2);
                                        }
                                        i4 = i5;
                                    }
                                }
                            }
                        } else {
                            LazyListIntervalContent.item$default(lazyListIntervalContent, "shimmer", null, ArtistItemsScreenKt.f338lambda$1187489731, 2);
                        }
                        return Unit.INSTANCE;
                    }
                };
                artistPage = artistPage2;
                mutableState2 = mutableStateCollectAsStateWithLifecycle3;
                str2 = str4;
                z2 = z9;
                playerConnection = playerConnection2;
                mutableState3 = mutableStateCollectAsStateWithLifecycle4;
                gapComposer = gapComposer2;
                artistViewModel4 = artistViewModel5;
                gapComposer.updateRememberedValue(objRememberedValue10);
            } else {
                navHostController2 = navHostController;
                gapComposer = gapComposer2;
                artistViewModel4 = artistViewModel3;
                mutableState = mutableState4;
                z2 = z8;
                mutableState3 = mutableStateCollectAsStateWithLifecycle4;
                str2 = str4;
                songItem = null;
                mutableState2 = mutableStateCollectAsStateWithLifecycle3;
                artistPage = artistPage2;
                playerConnection = playerConnection2;
            }
            GapComposer gapComposer3 = gapComposer;
            MutableState mutableState5 = mutableState;
            IntMath.LazyColumn(null, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue10, gapComposer3, 0, 505);
            ?? r8 = gapComposer3;
            boolean zIsScrollingUp = AppBarKt.isScrollingUp(lazyListStateRememberLazyListState, r8, 0);
            if (((List) mutableState3.getValue()).isEmpty()) {
                z3 = true;
            } else {
                Artist artist3 = (Artist) mutableState2.getValue();
                if (artist3 != null) {
                    z7 = true;
                    z3 = true;
                    if (artist3.artist.isLocal) {
                    }
                    if (ArtistScreen$lambda$14(mutableState5)) {
                        i2 = R.drawable.language;
                    } else {
                        i2 = R.drawable.library_music;
                    }
                    int i4 = i2;
                    zChanged = r8.changed(mutableState5) | r8.changedInstance(artistPage) | r8.changedInstance(artistViewModel4);
                    objRememberedValue = r8.rememberedValue();
                    if (zChanged) {
                        neverEqualPolicy = neverEqualPolicy3;
                    } else {
                        neverEqualPolicy = neverEqualPolicy3;
                        if (objRememberedValue == neverEqualPolicy) {
                        }
                        obj = objRememberedValue;
                        boxScopeInstance = BoxScopeInstance.INSTANCE;
                        neverEqualPolicy2 = neverEqualPolicy;
                        z5 = z4;
                        MenuKt.HideOnScrollFAB(boxScopeInstance, z5, lazyListStateRememberLazyListState, i4, (Function0) obj, null, r8, 6, 16);
                        companion = Modifier.Companion.$$INSTANCE;
                        if (z2) {
                            companion2 = companion;
                            z6 = false;
                            r8.startReplaceGroup(607774165);
                            r8.end(false);
                        } else {
                            if (((Boolean) mutableState5.getValue()).booleanValue() || ((List) mutableState3.getValue()).isEmpty()) {
                                if (!((Boolean) mutableState5.getValue()).booleanValue() && artistPage != null) {
                                    list = artistPage.sections;
                                    if (!list.isEmpty()) {
                                        it = list.iterator();
                                        z5 = z5;
                                        while (true) {
                                            if (it.hasNext()) {
                                                objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                                if (objFirstOrNull instanceof SongItem) {
                                                    songItem2 = (SongItem) objFirstOrNull;
                                                } else {
                                                    songItem2 = songItem;
                                                }
                                                if (songItem2 != null) {
                                                    album = songItem2.album;
                                                } else {
                                                    obj = songItem;
                                                }
                                                if (obj != null) {
                                                    obj = album;
                                                } else {
                                                    obj = album;
                                                    artistPage = artistPage;
                                                    z5 = z5 ? 1 : 0 ? 1 : 0;
                                                }
                                            }
                                        }
                                    }
                                }
                                companion2 = companion;
                                z6 = false;
                                r8.startReplaceGroup(607774165);
                                r8.end(false);
                            }
                            r8.startReplaceGroup(601540809);
                            objRememberedValue2 = r8.rememberedValue();
                            obj2 = objRememberedValue2;
                            if (objRememberedValue2 == neverEqualPolicy2) {
                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda9);
                                obj2 = statsScreenKt$$ExternalSyntheticLambda9;
                            }
                            EnterTransitionImpl enterTransitionImplSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                            objRememberedValue3 = r8.rememberedValue();
                            obj3 = objRememberedValue3;
                            if (objRememberedValue3 == neverEqualPolicy2) {
                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda10 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda10);
                                obj3 = statsScreenKt$$ExternalSyntheticLambda10;
                            }
                            ExitTransitionImpl exitTransitionImplSlideOutVertically$default = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                            Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                            if (z5) {
                                f = 64.0f;
                            } else {
                                f = 0.0f;
                            }
                            companion2 = companion;
                            CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default, exitTransitionImplSlideOutVertically$default, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                            z6 = false;
                            r8.end(false);
                        }
                        ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion2, (WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), Alignment.Companion.BottomCenter), null, r8, 6, 4);
                        r8.end(r11);
                        state = state2;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1671792759, new MainActivity$$ExternalSyntheticLambda1((Object) str2, (Object) state, (byte) 25), r8);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1126920185, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 11), r8);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(2100024674, new AlbumMenuKt$$ExternalSyntheticLambda11(artistViewModel4, context, (byte) 22), r8);
                        if (((Boolean) state.getValue()).booleanValue()) {
                            r8.startReplaceGroup(1890324778);
                            defaultTopAppBarColors$material3 = TopAppBarDefaults.m363topAppBarColors5tl4gsc(0L, 0L, 0L, 0L, 0L, r8, 62);
                            ?? r9 = r8;
                            r9.end(z6);
                            r7 = r9;
                        } else {
                            r8.startReplaceGroup(1890429868);
                            PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                            defaultTopAppBarColors$material3 = TopAppBarDefaults.getDefaultTopAppBarColors$material3(((MaterialTheme$Values) r8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                            r8.end(z6);
                            r7 = r8;
                        }
                        ?? r10 = r7;
                        MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, composableLambdaImplRememberComposableLambda3, CropImageView.DEFAULT_ASPECT_RATIO, null, defaultTopAppBarColors$material3, null, r10, 3462, 178);
                        r6 = r10;
                        artistViewModel2 = artistViewModel4;
                    }
                    obj = objRememberedValue;
                    QueueKt$$ExternalSyntheticLambda24 queueKt$$ExternalSyntheticLambda24 = new QueueKt$$ExternalSyntheticLambda24((Object) artistPage, (Object) artistViewModel4, (Object) mutableState5, (byte) 5);
                    r8.updateRememberedValue(queueKt$$ExternalSyntheticLambda24);
                    Object obj5 = queueKt$$ExternalSyntheticLambda24;
                    obj5 = objRememberedValue;
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    neverEqualPolicy2 = neverEqualPolicy;
                    z5 = z4;
                    MenuKt.HideOnScrollFAB(boxScopeInstance, z5, lazyListStateRememberLazyListState, i4, (Function0) obj5, null, r8, 6, 16);
                    companion = Modifier.Companion.$$INSTANCE;
                    if (z2) {
                        companion2 = companion;
                        z6 = false;
                        r8.startReplaceGroup(607774165);
                        r8.end(false);
                    } else if (((Boolean) mutableState5.getValue()).booleanValue()) {
                        if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                            list = artistPage.sections;
                            if (!list.isEmpty()) {
                                it = list.iterator();
                                z5 = z5;
                                while (true) {
                                    if (it.hasNext()) {
                                        objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                        if (objFirstOrNull instanceof SongItem) {
                                            songItem2 = (SongItem) objFirstOrNull;
                                        } else {
                                            songItem2 = songItem;
                                        }
                                        if (songItem2 != null) {
                                            album = songItem2.album;
                                        } else {
                                            obj = songItem;
                                        }
                                        if (obj != null) {
                                            obj = album;
                                            r8.startReplaceGroup(601540809);
                                            objRememberedValue2 = r8.rememberedValue();
                                            obj2 = objRememberedValue2;
                                            if (objRememberedValue2 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda11 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda11);
                                                obj2 = statsScreenKt$$ExternalSyntheticLambda11;
                                            }
                                            EnterTransitionImpl enterTransitionImplSlideInVertically$default2 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                            objRememberedValue3 = r8.rememberedValue();
                                            obj3 = objRememberedValue3;
                                            if (objRememberedValue3 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda12 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda12);
                                                obj3 = statsScreenKt$$ExternalSyntheticLambda12;
                                            }
                                            ExitTransitionImpl exitTransitionImplSlideOutVertically$default2 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                            Modifier modifierWindowInsetsPadding2 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                            if (z5) {
                                                f = 64.0f;
                                            } else {
                                                f = 0.0f;
                                            }
                                            companion2 = companion;
                                            CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default2, exitTransitionImplSlideOutVertically$default2, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                            z6 = false;
                                            r8.end(false);
                                        } else {
                                            obj = album;
                                            artistPage = artistPage;
                                            z5 = z5 ? 1 : 0 ? 1 : 0;
                                        }
                                    }
                                }
                            }
                        }
                        companion2 = companion;
                        z6 = false;
                        r8.startReplaceGroup(607774165);
                        r8.end(false);
                    } else {
                        if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                            list = artistPage.sections;
                            if (!list.isEmpty()) {
                                it = list.iterator();
                                z5 = z5;
                                while (true) {
                                    if (it.hasNext()) {
                                        objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                        if (objFirstOrNull instanceof SongItem) {
                                            songItem2 = (SongItem) objFirstOrNull;
                                        } else {
                                            songItem2 = songItem;
                                        }
                                        if (songItem2 != null) {
                                            album = songItem2.album;
                                        } else {
                                            obj = songItem;
                                        }
                                        if (obj != null) {
                                            obj = album;
                                            r8.startReplaceGroup(601540809);
                                            objRememberedValue2 = r8.rememberedValue();
                                            obj2 = objRememberedValue2;
                                            if (objRememberedValue2 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda13 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda13);
                                                obj2 = statsScreenKt$$ExternalSyntheticLambda13;
                                            }
                                            EnterTransitionImpl enterTransitionImplSlideInVertically$default3 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                            objRememberedValue3 = r8.rememberedValue();
                                            obj3 = objRememberedValue3;
                                            if (objRememberedValue3 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda14 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda14);
                                                obj3 = statsScreenKt$$ExternalSyntheticLambda14;
                                            }
                                            ExitTransitionImpl exitTransitionImplSlideOutVertically$default3 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                            Modifier modifierWindowInsetsPadding3 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                            if (z5) {
                                                f = 64.0f;
                                            } else {
                                                f = 0.0f;
                                            }
                                            companion2 = companion;
                                            CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default3, exitTransitionImplSlideOutVertically$default3, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                            z6 = false;
                                            r8.end(false);
                                        } else {
                                            obj = album;
                                            artistPage = artistPage;
                                            z5 = z5 ? 1 : 0 ? 1 : 0;
                                        }
                                    }
                                }
                            }
                        }
                        companion2 = companion;
                        z6 = false;
                        r8.startReplaceGroup(607774165);
                        r8.end(false);
                    }
                    ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion2, (WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), Alignment.Companion.BottomCenter), null, r8, 6, 4);
                    r8.end(r11);
                    state = state2;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(1671792759, new MainActivity$$ExternalSyntheticLambda1((Object) str2, (Object) state, (byte) 25), r8);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(1126920185, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 11), r8);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(2100024674, new AlbumMenuKt$$ExternalSyntheticLambda11(artistViewModel4, context, (byte) 22), r8);
                    if (((Boolean) state.getValue()).booleanValue()) {
                        r8.startReplaceGroup(1890324778);
                        defaultTopAppBarColors$material3 = TopAppBarDefaults.m363topAppBarColors5tl4gsc(0L, 0L, 0L, 0L, 0L, r8, 62);
                        ?? r12 = r8;
                        r12.end(z6);
                        r7 = r12;
                    } else {
                        r8.startReplaceGroup(1890429868);
                        PaddingValuesImpl paddingValuesImpl2 = TopAppBarDefaults.ContentPadding;
                        defaultTopAppBarColors$material3 = TopAppBarDefaults.getDefaultTopAppBarColors$material3(((MaterialTheme$Values) r8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                        r8.end(z6);
                        r7 = r8;
                    }
                    ?? r13 = r7;
                    MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda4, null, composableLambdaImplRememberComposableLambda5, composableLambdaImplRememberComposableLambda6, CropImageView.DEFAULT_ASPECT_RATIO, null, defaultTopAppBarColors$material3, null, r13, 3462, 178);
                    r6 = r13;
                    artistViewModel2 = artistViewModel4;
                } else {
                    z7 = true;
                }
                z4 = z7;
                r11 = z7;
                if (ArtistScreen$lambda$14(mutableState5)) {
                    i2 = R.drawable.language;
                } else {
                    i2 = R.drawable.library_music;
                }
                int i5 = i2;
                zChanged = r8.changed(mutableState5) | r8.changedInstance(artistPage) | r8.changedInstance(artistViewModel4);
                objRememberedValue = r8.rememberedValue();
                if (zChanged) {
                    neverEqualPolicy = neverEqualPolicy3;
                    if (objRememberedValue == neverEqualPolicy) {
                    }
                    obj5 = objRememberedValue;
                    boxScopeInstance = BoxScopeInstance.INSTANCE;
                    neverEqualPolicy2 = neverEqualPolicy;
                    z5 = z4;
                    MenuKt.HideOnScrollFAB(boxScopeInstance, z5, lazyListStateRememberLazyListState, i5, (Function0) obj5, null, r8, 6, 16);
                    companion = Modifier.Companion.$$INSTANCE;
                    if (z2) {
                        companion2 = companion;
                        z6 = false;
                        r8.startReplaceGroup(607774165);
                        r8.end(false);
                    } else if (((Boolean) mutableState5.getValue()).booleanValue()) {
                        if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                            list = artistPage.sections;
                            if (!list.isEmpty()) {
                                it = list.iterator();
                                z5 = z5;
                                while (true) {
                                    if (it.hasNext()) {
                                        objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                        if (objFirstOrNull instanceof SongItem) {
                                            songItem2 = (SongItem) objFirstOrNull;
                                        } else {
                                            songItem2 = songItem;
                                        }
                                        if (songItem2 != null) {
                                            album = songItem2.album;
                                        } else {
                                            obj = songItem;
                                        }
                                        if (obj != null) {
                                            obj = album;
                                            r8.startReplaceGroup(601540809);
                                            objRememberedValue2 = r8.rememberedValue();
                                            obj2 = objRememberedValue2;
                                            if (objRememberedValue2 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda15 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda15);
                                                obj2 = statsScreenKt$$ExternalSyntheticLambda15;
                                            }
                                            EnterTransitionImpl enterTransitionImplSlideInVertically$default4 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                            objRememberedValue3 = r8.rememberedValue();
                                            obj3 = objRememberedValue3;
                                            if (objRememberedValue3 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda16 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda16);
                                                obj3 = statsScreenKt$$ExternalSyntheticLambda16;
                                            }
                                            ExitTransitionImpl exitTransitionImplSlideOutVertically$default4 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                            Modifier modifierWindowInsetsPadding4 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                            if (z5) {
                                                f = 64.0f;
                                            } else {
                                                f = 0.0f;
                                            }
                                            companion2 = companion;
                                            CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding4, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default4, exitTransitionImplSlideOutVertically$default4, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                            z6 = false;
                                            r8.end(false);
                                        } else {
                                            obj = album;
                                            artistPage = artistPage;
                                            z5 = z5 ? 1 : 0 ? 1 : 0;
                                        }
                                    }
                                }
                            }
                        }
                        companion2 = companion;
                        z6 = false;
                        r8.startReplaceGroup(607774165);
                        r8.end(false);
                    } else {
                        if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                            list = artistPage.sections;
                            if (!list.isEmpty()) {
                                it = list.iterator();
                                z5 = z5;
                                while (true) {
                                    if (it.hasNext()) {
                                        objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                        if (objFirstOrNull instanceof SongItem) {
                                            songItem2 = (SongItem) objFirstOrNull;
                                        } else {
                                            songItem2 = songItem;
                                        }
                                        if (songItem2 != null) {
                                            album = songItem2.album;
                                        } else {
                                            obj = songItem;
                                        }
                                        if (obj != null) {
                                            obj = album;
                                            r8.startReplaceGroup(601540809);
                                            objRememberedValue2 = r8.rememberedValue();
                                            obj2 = objRememberedValue2;
                                            if (objRememberedValue2 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda17 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda17);
                                                obj2 = statsScreenKt$$ExternalSyntheticLambda17;
                                            }
                                            EnterTransitionImpl enterTransitionImplSlideInVertically$default5 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                            objRememberedValue3 = r8.rememberedValue();
                                            obj3 = objRememberedValue3;
                                            if (objRememberedValue3 == neverEqualPolicy2) {
                                                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda18 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                                r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda18);
                                                obj3 = statsScreenKt$$ExternalSyntheticLambda18;
                                            }
                                            ExitTransitionImpl exitTransitionImplSlideOutVertically$default5 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                            Modifier modifierWindowInsetsPadding5 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                            if (z5) {
                                                f = 64.0f;
                                            } else {
                                                f = 0.0f;
                                            }
                                            companion2 = companion;
                                            CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding5, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default5, exitTransitionImplSlideOutVertically$default5, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                            z6 = false;
                                            r8.end(false);
                                        } else {
                                            obj = album;
                                            artistPage = artistPage;
                                            z5 = z5 ? 1 : 0 ? 1 : 0;
                                        }
                                    }
                                }
                            }
                        }
                        companion2 = companion;
                        z6 = false;
                        r8.startReplaceGroup(607774165);
                        r8.end(false);
                    }
                    ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion2, (WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), Alignment.Companion.BottomCenter), null, r8, 6, 4);
                    r8.end(r11);
                    state = state2;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda7 = Expect_jvmKt.rememberComposableLambda(1671792759, new MainActivity$$ExternalSyntheticLambda1((Object) str2, (Object) state, (byte) 25), r8);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda8 = Expect_jvmKt.rememberComposableLambda(1126920185, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 11), r8);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda9 = Expect_jvmKt.rememberComposableLambda(2100024674, new AlbumMenuKt$$ExternalSyntheticLambda11(artistViewModel4, context, (byte) 22), r8);
                    if (((Boolean) state.getValue()).booleanValue()) {
                        r8.startReplaceGroup(1890324778);
                        defaultTopAppBarColors$material3 = TopAppBarDefaults.m363topAppBarColors5tl4gsc(0L, 0L, 0L, 0L, 0L, r8, 62);
                        ?? r14 = r8;
                        r14.end(z6);
                        r7 = r14;
                    } else {
                        r8.startReplaceGroup(1890429868);
                        PaddingValuesImpl paddingValuesImpl3 = TopAppBarDefaults.ContentPadding;
                        defaultTopAppBarColors$material3 = TopAppBarDefaults.getDefaultTopAppBarColors$material3(((MaterialTheme$Values) r8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                        r8.end(z6);
                        r7 = r8;
                    }
                    ?? r15 = r7;
                    MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda7, null, composableLambdaImplRememberComposableLambda8, composableLambdaImplRememberComposableLambda9, CropImageView.DEFAULT_ASPECT_RATIO, null, defaultTopAppBarColors$material3, null, r15, 3462, 178);
                    r6 = r15;
                    artistViewModel2 = artistViewModel4;
                } else {
                    neverEqualPolicy = neverEqualPolicy3;
                }
                obj5 = objRememberedValue;
                QueueKt$$ExternalSyntheticLambda24 queueKt$$ExternalSyntheticLambda25 = new QueueKt$$ExternalSyntheticLambda24((Object) artistPage, (Object) artistViewModel4, (Object) mutableState5, (byte) 5);
                r8.updateRememberedValue(queueKt$$ExternalSyntheticLambda25);
                Object obj6 = queueKt$$ExternalSyntheticLambda25;
                obj6 = objRememberedValue;
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                neverEqualPolicy2 = neverEqualPolicy;
                z5 = z4;
                MenuKt.HideOnScrollFAB(boxScopeInstance, z5, lazyListStateRememberLazyListState, i5, (Function0) obj6, null, r8, 6, 16);
                companion = Modifier.Companion.$$INSTANCE;
                if (z2) {
                    companion2 = companion;
                    z6 = false;
                    r8.startReplaceGroup(607774165);
                    r8.end(false);
                } else if (((Boolean) mutableState5.getValue()).booleanValue()) {
                    if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                        list = artistPage.sections;
                        if (!list.isEmpty()) {
                            it = list.iterator();
                            z5 = z5;
                            while (true) {
                                if (it.hasNext()) {
                                    objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                    if (objFirstOrNull instanceof SongItem) {
                                        songItem2 = (SongItem) objFirstOrNull;
                                    } else {
                                        songItem2 = songItem;
                                    }
                                    if (songItem2 != null) {
                                        album = songItem2.album;
                                    } else {
                                        obj = songItem;
                                    }
                                    if (obj != null) {
                                        obj = album;
                                        r8.startReplaceGroup(601540809);
                                        objRememberedValue2 = r8.rememberedValue();
                                        obj2 = objRememberedValue2;
                                        if (objRememberedValue2 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda19 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda19);
                                            obj2 = statsScreenKt$$ExternalSyntheticLambda19;
                                        }
                                        EnterTransitionImpl enterTransitionImplSlideInVertically$default6 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                        objRememberedValue3 = r8.rememberedValue();
                                        obj3 = objRememberedValue3;
                                        if (objRememberedValue3 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda110 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda110);
                                            obj3 = statsScreenKt$$ExternalSyntheticLambda110;
                                        }
                                        ExitTransitionImpl exitTransitionImplSlideOutVertically$default6 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                        Modifier modifierWindowInsetsPadding6 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                        if (z5) {
                                            f = 64.0f;
                                        } else {
                                            f = 0.0f;
                                        }
                                        companion2 = companion;
                                        CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding6, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default6, exitTransitionImplSlideOutVertically$default6, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                        z6 = false;
                                        r8.end(false);
                                    } else {
                                        obj = album;
                                        artistPage = artistPage;
                                        z5 = z5 ? 1 : 0 ? 1 : 0;
                                    }
                                }
                            }
                        }
                    }
                    companion2 = companion;
                    z6 = false;
                    r8.startReplaceGroup(607774165);
                    r8.end(false);
                } else {
                    if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                        list = artistPage.sections;
                        if (!list.isEmpty()) {
                            it = list.iterator();
                            z5 = z5;
                            while (true) {
                                if (it.hasNext()) {
                                    objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                    if (objFirstOrNull instanceof SongItem) {
                                        songItem2 = (SongItem) objFirstOrNull;
                                    } else {
                                        songItem2 = songItem;
                                    }
                                    if (songItem2 != null) {
                                        album = songItem2.album;
                                    } else {
                                        obj = songItem;
                                    }
                                    if (obj != null) {
                                        obj = album;
                                        r8.startReplaceGroup(601540809);
                                        objRememberedValue2 = r8.rememberedValue();
                                        obj2 = objRememberedValue2;
                                        if (objRememberedValue2 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda111 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda111);
                                            obj2 = statsScreenKt$$ExternalSyntheticLambda111;
                                        }
                                        EnterTransitionImpl enterTransitionImplSlideInVertically$default7 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                        objRememberedValue3 = r8.rememberedValue();
                                        obj3 = objRememberedValue3;
                                        if (objRememberedValue3 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda112 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda112);
                                            obj3 = statsScreenKt$$ExternalSyntheticLambda112;
                                        }
                                        ExitTransitionImpl exitTransitionImplSlideOutVertically$default7 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                        Modifier modifierWindowInsetsPadding7 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                        if (z5) {
                                            f = 64.0f;
                                        } else {
                                            f = 0.0f;
                                        }
                                        companion2 = companion;
                                        CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding7, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default7, exitTransitionImplSlideOutVertically$default7, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                        z6 = false;
                                        r8.end(false);
                                    } else {
                                        obj = album;
                                        artistPage = artistPage;
                                        z5 = z5 ? 1 : 0 ? 1 : 0;
                                    }
                                }
                            }
                        }
                    }
                    companion2 = companion;
                    z6 = false;
                    r8.startReplaceGroup(607774165);
                    r8.end(false);
                }
                ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion2, (WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), Alignment.Companion.BottomCenter), null, r8, 6, 4);
                r8.end(r11);
                state = state2;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda10 = Expect_jvmKt.rememberComposableLambda(1671792759, new MainActivity$$ExternalSyntheticLambda1((Object) str2, (Object) state, (byte) 25), r8);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda11 = Expect_jvmKt.rememberComposableLambda(1126920185, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 11), r8);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda12 = Expect_jvmKt.rememberComposableLambda(2100024674, new AlbumMenuKt$$ExternalSyntheticLambda11(artistViewModel4, context, (byte) 22), r8);
                if (((Boolean) state.getValue()).booleanValue()) {
                    r8.startReplaceGroup(1890324778);
                    defaultTopAppBarColors$material3 = TopAppBarDefaults.m363topAppBarColors5tl4gsc(0L, 0L, 0L, 0L, 0L, r8, 62);
                    ?? r16 = r8;
                    r16.end(z6);
                    r7 = r16;
                } else {
                    r8.startReplaceGroup(1890429868);
                    PaddingValuesImpl paddingValuesImpl4 = TopAppBarDefaults.ContentPadding;
                    defaultTopAppBarColors$material3 = TopAppBarDefaults.getDefaultTopAppBarColors$material3(((MaterialTheme$Values) r8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                    r8.end(z6);
                    r7 = r8;
                }
                ?? r17 = r7;
                MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda10, null, composableLambdaImplRememberComposableLambda11, composableLambdaImplRememberComposableLambda12, CropImageView.DEFAULT_ASPECT_RATIO, null, defaultTopAppBarColors$material3, null, r17, 3462, 178);
                r6 = r17;
                artistViewModel2 = artistViewModel4;
            }
            z4 = false;
            r11 = z3;
            if (ArtistScreen$lambda$14(mutableState5)) {
                i2 = R.drawable.language;
            } else {
                i2 = R.drawable.library_music;
            }
            int i6 = i2;
            zChanged = r8.changed(mutableState5) | r8.changedInstance(artistPage) | r8.changedInstance(artistViewModel4);
            objRememberedValue = r8.rememberedValue();
            if (zChanged) {
                neverEqualPolicy = neverEqualPolicy3;
                if (objRememberedValue == neverEqualPolicy) {
                }
                obj6 = objRememberedValue;
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                neverEqualPolicy2 = neverEqualPolicy;
                z5 = z4;
                MenuKt.HideOnScrollFAB(boxScopeInstance, z5, lazyListStateRememberLazyListState, i6, (Function0) obj6, null, r8, 6, 16);
                companion = Modifier.Companion.$$INSTANCE;
                if (z2) {
                    companion2 = companion;
                    z6 = false;
                    r8.startReplaceGroup(607774165);
                    r8.end(false);
                } else if (((Boolean) mutableState5.getValue()).booleanValue()) {
                    if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                        list = artistPage.sections;
                        if (!list.isEmpty()) {
                            it = list.iterator();
                            z5 = z5;
                            while (true) {
                                if (it.hasNext()) {
                                    objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                    if (objFirstOrNull instanceof SongItem) {
                                        songItem2 = (SongItem) objFirstOrNull;
                                    } else {
                                        songItem2 = songItem;
                                    }
                                    if (songItem2 != null) {
                                        album = songItem2.album;
                                    } else {
                                        obj = songItem;
                                    }
                                    if (obj != null) {
                                        obj = album;
                                        r8.startReplaceGroup(601540809);
                                        objRememberedValue2 = r8.rememberedValue();
                                        obj2 = objRememberedValue2;
                                        if (objRememberedValue2 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda113 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda113);
                                            obj2 = statsScreenKt$$ExternalSyntheticLambda113;
                                        }
                                        EnterTransitionImpl enterTransitionImplSlideInVertically$default8 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                        objRememberedValue3 = r8.rememberedValue();
                                        obj3 = objRememberedValue3;
                                        if (objRememberedValue3 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda114 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda114);
                                            obj3 = statsScreenKt$$ExternalSyntheticLambda114;
                                        }
                                        ExitTransitionImpl exitTransitionImplSlideOutVertically$default8 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                        Modifier modifierWindowInsetsPadding8 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                        if (z5) {
                                            f = 64.0f;
                                        } else {
                                            f = 0.0f;
                                        }
                                        companion2 = companion;
                                        CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding8, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default8, exitTransitionImplSlideOutVertically$default8, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                        z6 = false;
                                        r8.end(false);
                                    } else {
                                        obj = album;
                                        artistPage = artistPage;
                                        z5 = z5 ? 1 : 0 ? 1 : 0;
                                    }
                                }
                            }
                        }
                    }
                    companion2 = companion;
                    z6 = false;
                    r8.startReplaceGroup(607774165);
                    r8.end(false);
                } else {
                    if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                        list = artistPage.sections;
                        if (!list.isEmpty()) {
                            it = list.iterator();
                            z5 = z5;
                            while (true) {
                                if (it.hasNext()) {
                                    objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                    if (objFirstOrNull instanceof SongItem) {
                                        songItem2 = (SongItem) objFirstOrNull;
                                    } else {
                                        songItem2 = songItem;
                                    }
                                    if (songItem2 != null) {
                                        album = songItem2.album;
                                    } else {
                                        obj = songItem;
                                    }
                                    if (obj != null) {
                                        obj = album;
                                        r8.startReplaceGroup(601540809);
                                        objRememberedValue2 = r8.rememberedValue();
                                        obj2 = objRememberedValue2;
                                        if (objRememberedValue2 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda115 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda115);
                                            obj2 = statsScreenKt$$ExternalSyntheticLambda115;
                                        }
                                        EnterTransitionImpl enterTransitionImplSlideInVertically$default9 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                        objRememberedValue3 = r8.rememberedValue();
                                        obj3 = objRememberedValue3;
                                        if (objRememberedValue3 == neverEqualPolicy2) {
                                            StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda116 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                            r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda116);
                                            obj3 = statsScreenKt$$ExternalSyntheticLambda116;
                                        }
                                        ExitTransitionImpl exitTransitionImplSlideOutVertically$default9 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                        Modifier modifierWindowInsetsPadding9 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                        if (z5) {
                                            f = 64.0f;
                                        } else {
                                            f = 0.0f;
                                        }
                                        companion2 = companion;
                                        CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding9, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default9, exitTransitionImplSlideOutVertically$default9, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                        z6 = false;
                                        r8.end(false);
                                    } else {
                                        obj = album;
                                        artistPage = artistPage;
                                        z5 = z5 ? 1 : 0 ? 1 : 0;
                                    }
                                }
                            }
                        }
                    }
                    companion2 = companion;
                    z6 = false;
                    r8.startReplaceGroup(607774165);
                    r8.end(false);
                }
                ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion2, (WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), Alignment.Companion.BottomCenter), null, r8, 6, 4);
                r8.end(r11);
                state = state2;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda13 = Expect_jvmKt.rememberComposableLambda(1671792759, new MainActivity$$ExternalSyntheticLambda1((Object) str2, (Object) state, (byte) 25), r8);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda14 = Expect_jvmKt.rememberComposableLambda(1126920185, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 11), r8);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda15 = Expect_jvmKt.rememberComposableLambda(2100024674, new AlbumMenuKt$$ExternalSyntheticLambda11(artistViewModel4, context, (byte) 22), r8);
                if (((Boolean) state.getValue()).booleanValue()) {
                    r8.startReplaceGroup(1890324778);
                    defaultTopAppBarColors$material3 = TopAppBarDefaults.m363topAppBarColors5tl4gsc(0L, 0L, 0L, 0L, 0L, r8, 62);
                    ?? r18 = r8;
                    r18.end(z6);
                    r7 = r18;
                } else {
                    r8.startReplaceGroup(1890429868);
                    PaddingValuesImpl paddingValuesImpl5 = TopAppBarDefaults.ContentPadding;
                    defaultTopAppBarColors$material3 = TopAppBarDefaults.getDefaultTopAppBarColors$material3(((MaterialTheme$Values) r8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                    r8.end(z6);
                    r7 = r8;
                }
                ?? r19 = r7;
                MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda13, null, composableLambdaImplRememberComposableLambda14, composableLambdaImplRememberComposableLambda15, CropImageView.DEFAULT_ASPECT_RATIO, null, defaultTopAppBarColors$material3, null, r19, 3462, 178);
                r6 = r19;
                artistViewModel2 = artistViewModel4;
            } else {
                neverEqualPolicy = neverEqualPolicy3;
            }
            obj6 = objRememberedValue;
            QueueKt$$ExternalSyntheticLambda24 queueKt$$ExternalSyntheticLambda26 = new QueueKt$$ExternalSyntheticLambda24((Object) artistPage, (Object) artistViewModel4, (Object) mutableState5, (byte) 5);
            r8.updateRememberedValue(queueKt$$ExternalSyntheticLambda26);
            Object obj7 = queueKt$$ExternalSyntheticLambda26;
            obj7 = objRememberedValue;
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            neverEqualPolicy2 = neverEqualPolicy;
            z5 = z4;
            MenuKt.HideOnScrollFAB(boxScopeInstance, z5, lazyListStateRememberLazyListState, i6, (Function0) obj7, null, r8, 6, 16);
            companion = Modifier.Companion.$$INSTANCE;
            if (z2) {
                companion2 = companion;
                z6 = false;
                r8.startReplaceGroup(607774165);
                r8.end(false);
            } else if (((Boolean) mutableState5.getValue()).booleanValue()) {
                if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                    list = artistPage.sections;
                    if (!list.isEmpty()) {
                        it = list.iterator();
                        z5 = z5;
                        while (true) {
                            if (it.hasNext()) {
                                objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                if (objFirstOrNull instanceof SongItem) {
                                    songItem2 = (SongItem) objFirstOrNull;
                                } else {
                                    songItem2 = songItem;
                                }
                                if (songItem2 != null) {
                                    album = songItem2.album;
                                } else {
                                    obj = songItem;
                                }
                                if (obj != null) {
                                    obj = album;
                                    r8.startReplaceGroup(601540809);
                                    objRememberedValue2 = r8.rememberedValue();
                                    obj2 = objRememberedValue2;
                                    if (objRememberedValue2 == neverEqualPolicy2) {
                                        StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda117 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                        r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda117);
                                        obj2 = statsScreenKt$$ExternalSyntheticLambda117;
                                    }
                                    EnterTransitionImpl enterTransitionImplSlideInVertically$default10 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                    objRememberedValue3 = r8.rememberedValue();
                                    obj3 = objRememberedValue3;
                                    if (objRememberedValue3 == neverEqualPolicy2) {
                                        StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda118 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                        r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda118);
                                        obj3 = statsScreenKt$$ExternalSyntheticLambda118;
                                    }
                                    ExitTransitionImpl exitTransitionImplSlideOutVertically$default10 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                    Modifier modifierWindowInsetsPadding10 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                    if (z5) {
                                        f = 64.0f;
                                    } else {
                                        f = 0.0f;
                                    }
                                    companion2 = companion;
                                    CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding10, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default10, exitTransitionImplSlideOutVertically$default10, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                    z6 = false;
                                    r8.end(false);
                                } else {
                                    obj = album;
                                    artistPage = artistPage;
                                    z5 = z5 ? 1 : 0 ? 1 : 0;
                                }
                            }
                        }
                    }
                }
                companion2 = companion;
                z6 = false;
                r8.startReplaceGroup(607774165);
                r8.end(false);
            } else {
                if (!((Boolean) mutableState5.getValue()).booleanValue()) {
                    list = artistPage.sections;
                    if (!list.isEmpty()) {
                        it = list.iterator();
                        z5 = z5;
                        while (true) {
                            if (it.hasNext()) {
                                objFirstOrNull = CollectionsKt.firstOrNull(((ArtistSection) it.next()).items);
                                if (objFirstOrNull instanceof SongItem) {
                                    songItem2 = (SongItem) objFirstOrNull;
                                } else {
                                    songItem2 = songItem;
                                }
                                if (songItem2 != null) {
                                    album = songItem2.album;
                                } else {
                                    obj = songItem;
                                }
                                if (obj != null) {
                                    obj = album;
                                    r8.startReplaceGroup(601540809);
                                    objRememberedValue2 = r8.rememberedValue();
                                    obj2 = objRememberedValue2;
                                    if (objRememberedValue2 == neverEqualPolicy2) {
                                        StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda119 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 14);
                                        r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda119);
                                        obj2 = statsScreenKt$$ExternalSyntheticLambda119;
                                    }
                                    EnterTransitionImpl enterTransitionImplSlideInVertically$default11 = EnterExitTransitionKt.slideInVertically$default(r11, (Function1) obj2);
                                    objRememberedValue3 = r8.rememberedValue();
                                    obj3 = objRememberedValue3;
                                    if (objRememberedValue3 == neverEqualPolicy2) {
                                        StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda1110 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 15);
                                        r8.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda1110);
                                        obj3 = statsScreenKt$$ExternalSyntheticLambda1110;
                                    }
                                    ExitTransitionImpl exitTransitionImplSlideOutVertically$default11 = EnterExitTransitionKt.slideOutVertically$default(r11, (Function1) obj3);
                                    Modifier modifierWindowInsetsPadding11 = OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47));
                                    if (z5) {
                                        f = 64.0f;
                                    } else {
                                        f = 0.0f;
                                    }
                                    companion2 = companion;
                                    CrossfadeKt.AnimatedVisibility(zIsScrollingUp, OffsetKt.m139paddingqDBjuR0$default(modifierWindowInsetsPadding11, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, 7), enterTransitionImplSlideInVertically$default11, exitTransitionImplSlideOutVertically$default11, null, Expect_jvmKt.rememberComposableLambda(-628893094, new TextFieldKt$$ExternalSyntheticLambda2(z2, mutableState5, mutableState3, playerConnection, str2, artistPage, coroutineScope, z5), r8), r8, 200064, 16);
                                    z6 = false;
                                    r8.end(false);
                                } else {
                                    obj = album;
                                    artistPage = artistPage;
                                    z5 = z5 ? 1 : 0 ? 1 : 0;
                                }
                            }
                        }
                    }
                }
                companion2 = companion;
                z6 = false;
                r8.startReplaceGroup(607774165);
                r8.end(false);
            }
            ScrimKt.SnackbarHost(snackbarHostState, boxScopeInstance.align(OffsetKt.windowInsetsPadding(companion2, (WindowInsets) r8.consume(MainActivityKt.LocalPlayerAwareWindowInsets)), Alignment.Companion.BottomCenter), null, r8, 6, 4);
            r8.end(r11);
            state = state2;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda16 = Expect_jvmKt.rememberComposableLambda(1671792759, new MainActivity$$ExternalSyntheticLambda1((Object) str2, (Object) state, (byte) 25), r8);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda17 = Expect_jvmKt.rememberComposableLambda(1126920185, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 11), r8);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda18 = Expect_jvmKt.rememberComposableLambda(2100024674, new AlbumMenuKt$$ExternalSyntheticLambda11(artistViewModel4, context, (byte) 22), r8);
            if (((Boolean) state.getValue()).booleanValue()) {
                r8.startReplaceGroup(1890324778);
                defaultTopAppBarColors$material3 = TopAppBarDefaults.m363topAppBarColors5tl4gsc(0L, 0L, 0L, 0L, 0L, r8, 62);
                ?? r110 = r8;
                r110.end(z6);
                r7 = r110;
            } else {
                r8.startReplaceGroup(1890429868);
                PaddingValuesImpl paddingValuesImpl6 = TopAppBarDefaults.ContentPadding;
                defaultTopAppBarColors$material3 = TopAppBarDefaults.getDefaultTopAppBarColors$material3(((MaterialTheme$Values) r8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
                r8.end(z6);
                r7 = r8;
            }
            ?? r111 = r7;
            MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda16, null, composableLambdaImplRememberComposableLambda17, composableLambdaImplRememberComposableLambda18, CropImageView.DEFAULT_ASPECT_RATIO, null, defaultTopAppBarColors$material3, null, r111, 3462, 178);
            r6 = r111;
            artistViewModel2 = artistViewModel4;
        } else {
            GapComposer gapComposer4 = gapComposer2;
            gapComposer4.skipToGroupEnd();
            artistViewModel2 = artistViewModel;
            r6 = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = r6.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController2, artistViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ ArtistViewModel f$1;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj8, Object obj9) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    ArtistViewModel artistViewModel6 = this.f$1;
                    NavHostController navHostController3 = this.f$0;
                    Composer composer2 = (Composer) obj8;
                    ((Integer) obj9).getClass();
                    switch (b3) {
                        case 0:
                            ArtistScreenKt.ArtistScreen(navHostController3, artistViewModel6, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            ArtistScreenKt.ArtistScreen(navHostController3, artistViewModel6, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final boolean ArtistScreen$lambda$14(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }
}
