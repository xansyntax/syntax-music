package com.metrolist.music.ui.screens.search;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.YouTubeBrowseScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda10;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import com.yalantis.ucrop.R;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalSearchScreenKt {

    /* JADX INFO: renamed from: lambda$-578453558, reason: not valid java name */
    public static final ComposableLambdaImpl f432lambda$578453558 = new ComposableLambdaImpl(false, -578453558, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 27));
    public static final ComposableLambdaImpl lambda$1086635420 = new ComposableLambdaImpl(false, 1086635420, new AiSettingsKt$$ExternalSyntheticLambda10(12));
    public static final ComposableLambdaImpl lambda$525872218 = new ComposableLambdaImpl(false, 525872218, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 28));

    /* JADX INFO: renamed from: lambda$-678945234, reason: not valid java name */
    public static final ComposableLambdaImpl f434lambda$678945234 = new ComposableLambdaImpl(false, -678945234, new TopPlaylistScreenKt$$ExternalSyntheticLambda8((byte) 29));
    public static final ComposableLambdaImpl lambda$1822886447 = new ComposableLambdaImpl(false, 1822886447, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(1));
    public static final ComposableLambdaImpl lambda$2128929299 = new ComposableLambdaImpl(false, 2128929299, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(2));
    public static final ComposableLambdaImpl lambda$1091391228 = new ComposableLambdaImpl(false, 1091391228, new AiSettingsKt$$ExternalSyntheticLambda10(15));

    /* JADX INFO: renamed from: lambda$-827083889, reason: not valid java name */
    public static final ComposableLambdaImpl f436lambda$827083889 = new ComposableLambdaImpl(false, -827083889, new AiSettingsKt$$ExternalSyntheticLambda10(16));

    /* JADX INFO: renamed from: lambda$-1398411515, reason: not valid java name */
    public static final ComposableLambdaImpl f428lambda$1398411515 = new ComposableLambdaImpl(false, -1398411515, new AiSettingsKt$$ExternalSyntheticLambda10(17));
    public static final ComposableLambdaImpl lambda$65700988 = new ComposableLambdaImpl(false, 65700988, new AiSettingsKt$$ExternalSyntheticLambda10(18));
    public static final ComposableLambdaImpl lambda$431133666 = new ComposableLambdaImpl(false, 431133666, new AiSettingsKt$$ExternalSyntheticLambda10(19));

    /* JADX INFO: renamed from: lambda$-84140072, reason: not valid java name */
    public static final ComposableLambdaImpl f437lambda$84140072 = new ComposableLambdaImpl(false, -84140072, new AiSettingsKt$$ExternalSyntheticLambda10(13));

    /* JADX INFO: renamed from: lambda$-1590738426, reason: not valid java name */
    public static final ComposableLambdaImpl f429lambda$1590738426 = new ComposableLambdaImpl(false, -1590738426, new AiSettingsKt$$ExternalSyntheticLambda10(14));

    /* JADX INFO: renamed from: lambda$-2067521948, reason: not valid java name */
    public static final ComposableLambdaImpl f431lambda$2067521948 = new ComposableLambdaImpl(false, -2067521948, new AiSettingsKt$$ExternalSyntheticLambda10(20));

    /* JADX INFO: renamed from: lambda$-651962542, reason: not valid java name */
    public static final ComposableLambdaImpl f433lambda$651962542 = new ComposableLambdaImpl(false, -651962542, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(3));

    /* JADX INFO: renamed from: lambda$-2042283108, reason: not valid java name */
    public static final ComposableLambdaImpl f430lambda$2042283108 = new ComposableLambdaImpl(false, -2042283108, new AiSettingsKt$$ExternalSyntheticLambda10(21));
    public static final ComposableLambdaImpl lambda$1939284955 = new ComposableLambdaImpl(false, 1939284955, new AiSettingsKt$$ExternalSyntheticLambda10(22));
    public static final ComposableLambdaImpl lambda$1425062290 = new ComposableLambdaImpl(false, 1425062290, new AiSettingsKt$$ExternalSyntheticLambda10(23));
    public static final ComposableLambdaImpl lambda$315531498 = new ComposableLambdaImpl(false, 315531498, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(4));
    public static final ComposableLambdaImpl lambda$1622225079 = new ComposableLambdaImpl(false, 1622225079, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(5));

    /* JADX INFO: renamed from: lambda$-797866126, reason: not valid java name */
    public static final ComposableLambdaImpl f435lambda$797866126 = new ComposableLambdaImpl(false, -797866126, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(6));
    public static final ComposableLambdaImpl lambda$454144867 = new ComposableLambdaImpl(false, 454144867, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(0));
    public static final ComposableLambdaImpl lambda$1397505380 = new ComposableLambdaImpl(false, 1397505380, new ComposableSingletons$SearchScreenKt$$ExternalSyntheticLambda0(7));

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean, int] */
    public static final void LocalSearchScreen(final String str, final Function0 function0, final boolean z, LocalSearchViewModel localSearchViewModel, Composer composer, final int i) {
        final LocalSearchViewModel localSearchViewModel2;
        GapComposer gapComposer;
        final LocalSearchViewModel localSearchViewModel3;
        int i2;
        long j;
        ?? r12;
        str.getClass();
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(343652354);
        int i3 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16) | 384 | (gapComposer2.changed(z) ? 2048 : 1024) | 8192;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer2.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    localSearchViewModel3 = (LocalSearchViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LocalSearchViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer2), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer2);
                    i2 = i3 & (-57345);
                }
            } else {
                gapComposer2.skipToGroupEnd();
                i2 = i3 & (-57345);
                localSearchViewModel3 = localSearchViewModel;
            }
            int i4 = i2;
            gapComposer2.endDefaults();
            NavHostController navHostController = (NavHostController) gapComposer2.consume(MainActivityKt.LocalNavController);
            String strStringResource = MathKt.stringResource(R.string.queue_searched_songs, gapComposer2);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer2.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            MenuState menuState = (MenuState) gapComposer2.consume(BottomSheetMenuKt.LocalMenuState);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(str, function0, z, localSearchViewModel3, i, b) { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ Function0 f$1;
                        public final /* synthetic */ boolean f$3;
                        public final /* synthetic */ LocalSearchViewModel f$4;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            switch (b2) {
                                case 0:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                                    LocalSearchScreenKt.LocalSearchScreen(this.f$0, this.f$1, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags);
                                    break;
                                default:
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                                    LocalSearchScreenKt.LocalSearchScreen(this.f$0, this.f$1, this.f$3, this.f$4, (Composer) obj, iUpdateChangedFlags2);
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            LocalSearchViewModel localSearchViewModel4 = localSearchViewModel3;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(localSearchViewModel4.filter, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(localSearchViewModel4.result, gapComposer2);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            boolean zChanged = gapComposer2.changed(lazyListStateRememberLazyListState) | gapComposer2.changed(softwareKeyboardController);
            Object objRememberedValue = gapComposer2.rememberedValue();
            Object obj = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == obj) {
                objRememberedValue = new LocalSearchScreenKt$LocalSearchScreen$1$1(lazyListStateRememberLazyListState, softwareKeyboardController, null, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue);
            boolean zChangedInstance = gapComposer2.changedInstance(localSearchViewModel4) | ((i4 & 14) == 4);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == obj) {
                objRememberedValue2 = new InterruptibleKt$runInterruptible$2(localSearchViewModel4, str, null, (byte) 7);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer2, str, (Function2) objRememberedValue2);
            LazyWindowInfo lazyWindowInfo = (LazyWindowInfo) ((WindowInfo) gapComposer2.consume(CompositionLocalsKt.LocalWindowInfo));
            boolean z2 = ((int) (lazyWindowInfo.m715getContainerSizeYbymL2g() >> 32)) > ((int) (lazyWindowInfo.m715getContainerSizeYbymL2g() & 4294967295L));
            gapComposer2.startReplaceGroup(-462522148);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            if (z) {
                gapComposer2.startReplaceGroup(-462524569);
                gapComposer2.end(false);
                j = -72057594037927936L;
            } else {
                gapComposer2.startReplaceGroup(-462523380);
                j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                gapComposer2.end(false);
            }
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, j, ColorKt.RectangleShape);
            if (z2) {
                gapComposer2.startReplaceGroup(-2115142919);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                modifierM39backgroundbw27NRU = OffsetKt.windowInsetsPadding(modifierM39backgroundbw27NRU, new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 15));
                r12 = 0;
                gapComposer2.end(false);
            } else {
                r12 = 0;
                gapComposer2.startReplaceGroup(-2114955648);
                gapComposer2.end(false);
            }
            gapComposer2.end(r12);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, r12);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM39backgroundbw27NRU);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(LocalFilter.ALL, MathKt.stringResource(R.string.filter_all, gapComposer2)), new Pair(LocalFilter.SONG, MathKt.stringResource(R.string.filter_songs, gapComposer2)), new Pair(LocalFilter.ALBUM, MathKt.stringResource(R.string.filter_albums, gapComposer2)), new Pair(LocalFilter.ARTIST, MathKt.stringResource(R.string.filter_artists, gapComposer2)), new Pair(LocalFilter.PLAYLIST, MathKt.stringResource(R.string.filter_playlists, gapComposer2))});
            LocalFilter localFilter = (LocalFilter) mutableStateCollectAsStateWithLifecycle3.getValue();
            boolean zChangedInstance2 = gapComposer2.changedInstance(localSearchViewModel4);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == obj) {
                objRememberedValue3 = new MimesKt$$ExternalSyntheticLambda0((byte) 15, localSearchViewModel4);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            LocalSearchViewModel localSearchViewModel5 = localSearchViewModel4;
            DialogKt.m1461ChipsRowyrwZFoE(listListOf, localFilter, (Function1) objRememberedValue3, null, 0L, gapComposer2, 0, 24);
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer2).systemBars, 32), gapComposer2);
            boolean zChanged2 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer2.changedInstance(localSearchViewModel5) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changed(menuState) | ((i4 & 112) == 32) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(strStringResource) | gapComposer2.changedInstance(navHostController);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue4 == obj) {
                YouTubeBrowseScreenKt$$ExternalSyntheticLambda1 youTubeBrowseScreenKt$$ExternalSyntheticLambda1 = new YouTubeBrowseScreenKt$$ExternalSyntheticLambda1(mutableStateCollectAsStateWithLifecycle4, localSearchViewModel5, menuState, function0, mutableStateCollectAsStateWithLifecycle2, playerConnection, strStringResource, navHostController, mutableStateCollectAsStateWithLifecycle);
                localSearchViewModel5 = localSearchViewModel5;
                gapComposer2.updateRememberedValue(youTubeBrowseScreenKt$$ExternalSyntheticLambda1);
                objRememberedValue4 = youTubeBrowseScreenKt$$ExternalSyntheticLambda1;
            }
            IntMath.LazyColumn(layoutWeightElement, lazyListStateRememberLazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue4, gapComposer2, 0, 504);
            GapComposer gapComposer3 = gapComposer2;
            gapComposer3.end(true);
            localSearchViewModel2 = localSearchViewModel5;
            gapComposer = gapComposer3;
        } else {
            gapComposer2.skipToGroupEnd();
            localSearchViewModel2 = localSearchViewModel;
            gapComposer = gapComposer2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(str, function0, z, localSearchViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ String f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ LocalSearchViewModel f$4;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    switch (b3) {
                        case 0:
                            ((Integer) obj3).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                            LocalSearchScreenKt.LocalSearchScreen(this.f$0, this.f$1, this.f$3, this.f$4, (Composer) obj2, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj3).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                            LocalSearchScreenKt.LocalSearchScreen(this.f$0, this.f$1, this.f$3, this.f$4, (Composer) obj2, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
        }
    }
}
