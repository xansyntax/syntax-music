package com.metrolist.music.ui.screens.library;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells$Adaptive;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshElement;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import coil3.compose.AsyncImageKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.AlbumFilter;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistFilter;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.MixSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.PodcastFilter;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.DatabaseDao$songs$lambda$0$$inlined$compareBy$1;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.extensions.StringExtKt;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.component.LibraryKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.LyricsMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda65;
import com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda42;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda35;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda74;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.AccountScreenKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$3$1;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.NewReleaseScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda37;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$4$2$1;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1;
import com.metrolist.music.ui.screens.artist.ArtistSongsScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.equalizer.ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.equalizer.ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt$$ExternalSyntheticLambda35;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.Updater$checkForUpdate$2;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.text.Collator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LibraryScreenKt {

    /* JADX INFO: renamed from: lambda$-1550870679, reason: not valid java name */
    public static final ComposableLambdaImpl f371lambda$1550870679 = new ComposableLambdaImpl(false, -1550870679, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(16));
    public static final ComposableLambdaImpl lambda$768255174 = new ComposableLambdaImpl(false, 768255174, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(17));
    public static final ComposableLambdaImpl lambda$306992480 = new ComposableLambdaImpl(false, 306992480, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(18));
    public static final ComposableLambdaImpl lambda$1780954809 = new ComposableLambdaImpl(false, 1780954809, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(19));
    public static final ComposableLambdaImpl lambda$2015318076 = new ComposableLambdaImpl(false, 2015318076, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(20));
    public static final ComposableLambdaImpl lambda$138781026 = new ComposableLambdaImpl(false, 138781026, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(21));
    public static final ComposableLambdaImpl lambda$1841139844 = new ComposableLambdaImpl(false, 1841139844, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(22));

    /* JADX INFO: renamed from: lambda$-653225796, reason: not valid java name */
    public static final ComposableLambdaImpl f378lambda$653225796 = new ComposableLambdaImpl(false, -653225796, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(23));

    /* JADX INFO: renamed from: lambda$-1098905367, reason: not valid java name */
    public static final ComposableLambdaImpl f367lambda$1098905367 = new ComposableLambdaImpl(false, -1098905367, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(24));

    /* JADX INFO: renamed from: lambda$-273147912, reason: not valid java name */
    public static final ComposableLambdaImpl f375lambda$273147912 = new ComposableLambdaImpl(false, -273147912, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(25));
    public static final ComposableLambdaImpl lambda$1372482218 = new ComposableLambdaImpl(false, 1372482218, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(26));
    public static final ComposableLambdaImpl lambda$796068548 = new ComposableLambdaImpl(false, 796068548, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(3));
    public static final ComposableLambdaImpl lambda$1853827769 = new ComposableLambdaImpl(false, 1853827769, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(4));
    public static final ComposableLambdaImpl lambda$119083619 = new ComposableLambdaImpl(false, 119083619, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(27));

    /* JADX INFO: renamed from: lambda$-1801157478, reason: not valid java name */
    public static final ComposableLambdaImpl f373lambda$1801157478 = new ComposableLambdaImpl(false, -1801157478, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(28));
    public static final ComposableLambdaImpl lambda$321452699 = new ComposableLambdaImpl(false, 321452699, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda1(29));
    public static final ComposableLambdaImpl lambda$1605724367 = new ComposableLambdaImpl(false, 1605724367, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 1));

    /* JADX INFO: renamed from: lambda$-549649172, reason: not valid java name */
    public static final ComposableLambdaImpl f376lambda$549649172 = new ComposableLambdaImpl(false, -549649172, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 2));
    public static final ComposableLambdaImpl lambda$1407590897 = new ComposableLambdaImpl(false, 1407590897, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(5));
    public static final ComposableLambdaImpl lambda$623940510 = new ComposableLambdaImpl(false, 623940510, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 3));
    public static final ComposableLambdaImpl lambda$839618674 = new ComposableLambdaImpl(false, 839618674, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(6));

    /* JADX INFO: renamed from: lambda$-1107604815, reason: not valid java name */
    public static final ComposableLambdaImpl f368lambda$1107604815 = new ComposableLambdaImpl(false, -1107604815, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 4));
    public static final ComposableLambdaImpl lambda$2075926179 = new ComposableLambdaImpl(false, 2075926179, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 5));

    /* JADX INFO: renamed from: lambda$-952970332, reason: not valid java name */
    public static final ComposableLambdaImpl f381lambda$952970332 = new ComposableLambdaImpl(false, -952970332, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 6));

    /* JADX INFO: renamed from: lambda$-709019292, reason: not valid java name */
    public static final ComposableLambdaImpl f380lambda$709019292 = new ComposableLambdaImpl(false, -709019292, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 7));
    public static final ComposableLambdaImpl lambda$557051493 = new ComposableLambdaImpl(false, 557051493, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 8));

    /* JADX INFO: renamed from: lambda$-1246923554, reason: not valid java name */
    public static final ComposableLambdaImpl f370lambda$1246923554 = new ComposableLambdaImpl(false, -1246923554, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 9));

    /* JADX INFO: renamed from: lambda$-1662250371, reason: not valid java name */
    public static final ComposableLambdaImpl f372lambda$1662250371 = new ComposableLambdaImpl(false, -1662250371, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 10));

    /* JADX INFO: renamed from: lambda$-1928926927, reason: not valid java name */
    public static final ComposableLambdaImpl f374lambda$1928926927 = new ComposableLambdaImpl(false, -1928926927, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(7));

    /* JADX INFO: renamed from: lambda$-1061755591, reason: not valid java name */
    public static final ComposableLambdaImpl f366lambda$1061755591 = new ComposableLambdaImpl(false, -1061755591, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 11));

    /* JADX INFO: renamed from: lambda$-609666692, reason: not valid java name */
    public static final ComposableLambdaImpl f377lambda$609666692 = new ComposableLambdaImpl(false, -609666692, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 12));

    /* JADX INFO: renamed from: lambda$-1218611378, reason: not valid java name */
    public static final ComposableLambdaImpl f369lambda$1218611378 = new ComposableLambdaImpl(false, -1218611378, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 13));
    public static final ComposableLambdaImpl lambda$2135480189 = new ComposableLambdaImpl(false, 2135480189, new ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(8));

    /* JADX INFO: renamed from: lambda$-68880943, reason: not valid java name */
    public static final ComposableLambdaImpl f379lambda$68880943 = new ComposableLambdaImpl(false, -68880943, new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 14));

    public static final void AutoPlaylistCard(String str, String str2, String str3, Function0 function0, Modifier modifier, Composer composer, int i) {
        String str4;
        Modifier modifier2;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1;
        int i2;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2;
        Modifier.Companion companion;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-426513110);
        int i3 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(str2) ? 32 : 16) | (gapComposer.changed(str3) ? 256 : 128) | (gapComposer.changedInstance(function0) ? 2048 : 1024) | 24576;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion2, 1.0f), false, null, function0, 15), 20.0f, 10.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda4);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda5);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda6);
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 56.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierM = Format$$ExternalSyntheticOutline0.m(18.0f, 10.0f, gapComposer, modifierM151size3ABfNKs);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifierM, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda4);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda5, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda6);
            if (str2 != null) {
                gapComposer.startReplaceGroup(1873085657);
                staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda4;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda6;
                AsyncImageKt.m849AsyncImage10Xjiaw(YouTubeUtilsKt.resize(str2, 168, 168), Format$$ExternalSyntheticOutline0.m(18.0f, 10.0f, gapComposer, SizeKt.m151size3ABfNKs(companion2, 56.0f)), ContentScale.Companion.Crop, gapComposer, 1572912, 1976);
                gapComposer = gapComposer;
                i2 = 0;
                gapComposer.end(false);
                companion = companion2;
                updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda3;
            } else {
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda4;
                staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda6;
                i2 = 0;
                gapComposer.startReplaceGroup(1873509241);
                updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda3;
                companion = companion2;
                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.queue_music, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion2, 28.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, gapComposer, 440, 0);
                gapComposer.end(false);
            }
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 12.0f));
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, i2);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda2);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda0);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda5, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda1);
            GapComposer gapComposer2 = gapComposer;
            TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer2, i3 & 14, 24960, 110590);
            StringBuilder sb = new StringBuilder();
            sb.append(MathKt.stringResource(R.string.auto_playlist, gapComposer2));
            if (str3 == null || StringsKt.isBlank(str3)) {
                str4 = str3;
            } else {
                sb.append(" • ");
                str4 = str3;
                sb.append(str4);
            }
            TextKt.m352TextNvy7gAk(sb.toString(), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer2, 0, 24960, 110586);
            gapComposer = gapComposer2;
            gapComposer.end(true);
            gapComposer.end(true);
            modifier2 = companion;
        } else {
            str4 = str3;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AccountScreenKt$$ExternalSyntheticLambda20(str, str2, str4, function0, modifier2, i, (byte) 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.util.ArrayList] */
    public static final void LibraryAlbumsScreen(final NavHostController navHostController, final Function0 function0, LibraryAlbumsViewModel libraryAlbumsViewModel, Composer composer, final int i) {
        final LibraryAlbumsViewModel libraryAlbumsViewModel2;
        GapComposer gapComposer;
        LibraryAlbumsViewModel libraryAlbumsViewModel3;
        ?? arrayList;
        ComposableLambdaImpl composableLambdaImpl;
        LibraryAlbumsViewModel libraryAlbumsViewModel4;
        MutableState mutableState;
        MutableState mutableState2;
        Object obj;
        MutableState mutableStateCollectAsStateWithLifecycle;
        LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2;
        LazyListState lazyListState;
        GapComposer gapComposer2;
        SavedStateHandle savedStateHandle;
        navHostController.getClass();
        function0.getClass();
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(1009854441);
        int i2 = i | (gapComposer3.changedInstance(navHostController) ? 4 : 2) | (gapComposer3.changedInstance(function0) ? 32 : 16) | 128;
        if (gapComposer3.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer3.startDefaults();
            if ((i & 1) == 0 || gapComposer3.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer3.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                libraryAlbumsViewModel3 = (LibraryAlbumsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LibraryAlbumsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer3), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer3);
            } else {
                gapComposer3.skipToGroupEnd();
                libraryAlbumsViewModel3 = libraryAlbumsViewModel;
            }
            gapComposer3.endDefaults();
            MenuState menuState = (MenuState) gapComposer3.consume(BottomSheetMenuKt.LocalMenuState);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer3.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            PlayerConnection playerConnection = (PlayerConnection) gapComposer3.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    final LibraryAlbumsViewModel libraryAlbumsViewModel5 = libraryAlbumsViewModel3;
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, function0, libraryAlbumsViewModel5, i, b) { // from class: com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ Function0 f$1;
                        public final /* synthetic */ LibraryAlbumsViewModel f$2;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            LibraryAlbumsViewModel libraryAlbumsViewModel6 = this.f$2;
                            Function0 function1 = this.f$1;
                            NavHostController navHostController2 = this.f$0;
                            Composer composer2 = (Composer) obj2;
                            ((Integer) obj3).getClass();
                            switch (b2) {
                                case 0:
                                    LibraryScreenKt.LibraryAlbumsScreen(navHostController2, function1, libraryAlbumsViewModel6, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    LibraryScreenKt.LibraryAlbumsScreen(navHostController2, function1, libraryAlbumsViewModel6, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            LibraryAlbumsViewModel libraryAlbumsViewModel6 = libraryAlbumsViewModel3;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer3);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer3);
            Preferences$Key preferences$Key = PreferenceKeysKt.AlbumViewTypeKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer3.consume(staticProvidableCompositionLocal);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 29));
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, LibraryViewType.GRID, gapComposer3, 48);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle4, coroutineScope2, context, preferences$Key);
                gapComposer3.updateRememberedValue(objRememberedValue4);
            }
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2) objRememberedValue4;
            Preferences$Key preferences$Key2 = PreferenceKeysKt.AlbumFilterKey;
            Context context2 = (Context) gapComposer3.consume(staticProvidableCompositionLocal);
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue5;
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key2, (byte) 1));
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue6, AlbumFilter.LIKED, gapComposer3, 48);
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle5, coroutineScope3, context2, preferences$Key2);
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4) objRememberedValue7;
            Preferences$Key preferences$Key3 = PreferenceKeysKt.AlbumSortTypeKey;
            Context context3 = (Context) gapComposer3.consume(staticProvidableCompositionLocal);
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            CoroutineScope coroutineScope4 = (CoroutineScope) objRememberedValue8;
            Object objRememberedValue9 = gapComposer3.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context3).getData(), preferences$Key3, (byte) 2));
                gapComposer3.updateRememberedValue(objRememberedValue9);
            }
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue9, AlbumSortType.CREATE_DATE, gapComposer3, 48);
            Object objRememberedValue10 = gapComposer3.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6(mutableStateCollectAsStateWithLifecycle6, coroutineScope4, context3, preferences$Key3);
                gapComposer3.updateRememberedValue(objRememberedValue10);
            }
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6) objRememberedValue10;
            AlbumSortType albumSortType = (AlbumSortType) libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$6, (byte) 10);
            Preferences$Key preferences$Key4 = PreferenceKeysKt.AlbumSortDescendingKey;
            Boolean bool = Boolean.TRUE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key4, bool, gapComposer3, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            Preferences$Key preferences$Key5 = PreferenceKeysKt.GridItemsSizeKey;
            Context context4 = (Context) gapComposer3.consume(staticProvidableCompositionLocal);
            Object objRememberedValue11 = gapComposer3.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue11);
            }
            CoroutineScope coroutineScope5 = (CoroutineScope) objRememberedValue11;
            Object objRememberedValue12 = gapComposer3.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context4).getData(), preferences$Key5, (byte) 3));
                gapComposer3.updateRememberedValue(objRememberedValue12);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue12, gridItemSize, gapComposer3, 48);
            Object objRememberedValue13 = gapComposer3.rememberedValue();
            if (objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8(mutableStateCollectAsStateWithLifecycle7, coroutineScope5, context4, preferences$Key5);
                gapComposer3.updateRememberedValue(objRememberedValue13);
            }
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8 = (LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8) objRememberedValue13;
            boolean zBooleanValue2 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.YtmSyncKey, bool, gapComposer3, 48).$state.getValue()).booleanValue();
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.HideExplicitKey, Boolean.FALSE, gapComposer3, 48);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(624547424, new EqScreenKt$$ExternalSyntheticLambda35(function0, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$4, (byte) 1), gapComposer3);
            boolean zChanged = gapComposer3.changed(zBooleanValue2) | gapComposer3.changedInstance(libraryAlbumsViewModel6);
            Object objRememberedValue14 = gapComposer3.rememberedValue();
            Continuation continuation = null;
            if (zChanged || objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = new Updater$checkForUpdate$2(zBooleanValue2, (Object) libraryAlbumsViewModel6, continuation, (byte) 5);
                gapComposer3.updateRememberedValue(objRememberedValue14);
            }
            Stack.LaunchedEffect(gapComposer3, Unit.INSTANCE, (Function2) objRememberedValue14);
            MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(libraryAlbumsViewModel6.allAlbums, gapComposer3);
            Object[] objArr = new Object[0];
            Object objRememberedValue15 = gapComposer3.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 18);
                gapComposer3.updateRememberedValue(objRememberedValue15);
            }
            MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue15, gapComposer3, 48);
            MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(libraryAlbumsViewModel6.searchQuery, gapComposer3);
            boolean zChanged2 = gapComposer3.changed((String) mutableStateCollectAsStateWithLifecycle9.getValue());
            Object objRememberedValue16 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = StringExtKt.normalizeForSearch((String) mutableStateCollectAsStateWithLifecycle9.getValue());
                gapComposer3.updateRememberedValue(objRememberedValue16);
            }
            String str = (String) objRememberedValue16;
            boolean zChanged3 = gapComposer3.changed(((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).booleanValue()) | gapComposer3.changed((List) mutableStateCollectAsStateWithLifecycle8.getValue()) | gapComposer3.changed(str);
            Object objRememberedValue17 = gapComposer3.rememberedValue();
            if (zChanged3 || objRememberedValue17 == neverEqualPolicy) {
                if (((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).booleanValue()) {
                    List list = (List) mutableStateCollectAsStateWithLifecycle8.getValue();
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Iterator it2 = it;
                        if (!((Album) next).album.explicit) {
                            arrayList.add(next);
                        }
                        it = it2;
                    }
                } else {
                    arrayList = (List) mutableStateCollectAsStateWithLifecycle8.getValue();
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Object next2 = it3.next();
                    ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda;
                    Album album = (Album) next2;
                    LibraryAlbumsViewModel libraryAlbumsViewModel7 = libraryAlbumsViewModel6;
                    List list2 = album.artists;
                    Iterator it4 = it3;
                    MutableState mutableState4 = mutableState3;
                    MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle9;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        arrayList3.add(((ArtistEntity) it5.next()).name);
                    }
                    String[] strArr = (String[]) arrayList3.toArray(new String[0]);
                    Headers.Builder builder = new Headers.Builder(2);
                    builder.add(album.album.title);
                    builder.addSpread(strArr);
                    ArrayList arrayList4 = builder.namesAndValues;
                    if (StringExtKt.matchesNormalizedQuery(str, (String[]) arrayList4.toArray(new String[arrayList4.size()]))) {
                        arrayList2.add(next2);
                    }
                    composableLambdaImplRememberComposableLambda = composableLambdaImpl2;
                    mutableStateCollectAsStateWithLifecycle9 = mutableState5;
                    it3 = it4;
                    libraryAlbumsViewModel6 = libraryAlbumsViewModel7;
                    mutableState3 = mutableState4;
                }
                composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                libraryAlbumsViewModel4 = libraryAlbumsViewModel6;
                mutableState = mutableState3;
                mutableState2 = mutableStateCollectAsStateWithLifecycle9;
                HashSet hashSet = new HashSet();
                ArrayList arrayList5 = new ArrayList();
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    if (hashSet.add(((Album) obj2).album.id)) {
                        arrayList5.add(obj2);
                    }
                }
                gapComposer3.updateRememberedValue(arrayList5);
                obj = arrayList5;
            } else {
                composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                libraryAlbumsViewModel4 = libraryAlbumsViewModel6;
                mutableState = mutableState3;
                mutableState2 = mutableStateCollectAsStateWithLifecycle9;
                obj = objRememberedValue17;
            }
            List list3 = (List) obj;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer3);
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer3);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer3);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop");
            if (stateFlow == null) {
                gapComposer3.startReplaceGroup(-1668249061);
                gapComposer3.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer3.startReplaceGroup(-192361818);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer3);
                gapComposer3.end(false);
            }
            Boolean bool2 = mutableStateCollectAsStateWithLifecycle != null ? (Boolean) mutableStateCollectAsStateWithLifecycle.getValue() : null;
            boolean zChanged4 = gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer3.changed(libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3) | gapComposer3.changed(lazyListStateRememberLazyListState) | gapComposer3.changed(lazyGridStateRememberLazyGridState) | gapComposer3.changed(mutableStateCurrentBackStackEntryAsState);
            Object objRememberedValue18 = gapComposer3.rememberedValue();
            if (zChanged4 || objRememberedValue18 == neverEqualPolicy) {
                libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3;
                objRememberedValue18 = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(mutableStateCollectAsStateWithLifecycle, lazyListStateRememberLazyListState, lazyGridStateRememberLazyGridState, libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2, mutableStateCurrentBackStackEntryAsState, null, (byte) 0);
                lazyListState = lazyListStateRememberLazyListState;
                gapComposer3.updateRememberedValue(objRememberedValue18);
            } else {
                lazyListState = lazyListStateRememberLazyListState;
                libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$3;
            }
            Stack.LaunchedEffect(gapComposer3, bool2, (Function2) objRememberedValue18);
            MutableState mutableState6 = mutableState2;
            LibraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2 libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5 = libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$2;
            LibraryAlbumsViewModel libraryAlbumsViewModel8 = libraryAlbumsViewModel4;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1376468277, new ChipKt$$ExternalSyntheticLambda1((ViewModel) libraryAlbumsViewModel8, mutableState, softwareKeyboardController, mutableState6, (Enum) albumSortType, zBooleanValue, (Function1) anonymousClass2, (Function1) mimesKt$$ExternalSyntheticLambda0, (Object) list3, (Object) libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5, (byte) 2), gapComposer3);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, fillElement);
            ComposeUiNode.Companion.getClass();
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(LayoutNode.Constructor);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            int iOrdinal = ((LibraryViewType) libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$5.getValue()).ordinal();
            if (iOrdinal == 0) {
                ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl;
                gapComposer3.startReplaceGroup(735322259);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer3.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer3);
                boolean zChangedInstance = gapComposer3.changedInstance(list3) | gapComposer3.changed(mutableState6) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer3.changed(menuState);
                Object objRememberedValue19 = gapComposer3.rememberedValue();
                if (zChangedInstance || objRememberedValue19 == neverEqualPolicy) {
                    objRememberedValue19 = new NavHostKt$$ExternalSyntheticLambda12(list3, composableLambdaImpl3, composableLambdaImplRememberComposableLambda2, mutableState6, menuState, mutableStateCollectAsStateWithLifecycle3, mutableStateCollectAsStateWithLifecycle2);
                    gapComposer3.updateRememberedValue(objRememberedValue19);
                }
                IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue19, gapComposer3, 0, 505);
                GapComposer gapComposer4 = gapComposer3;
                gapComposer4.end(false);
                gapComposer2 = gapComposer4;
            } else {
                if (iOrdinal != 1) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer3, -1915941621, false);
                }
                gapComposer3.startReplaceGroup(737528777);
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                GridCells$Adaptive gridCells$Adaptive = new GridCells$Adaptive(128.0f + (((GridItemSize) libraryAlbumsScreenKt$LibraryAlbumsScreen$$inlined$rememberEnumPreference$8.getValue()) == gridItemSize ? 24.0f : -24.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues((WindowInsets) gapComposer3.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer3);
                boolean zChangedInstance2 = gapComposer3.changedInstance(list3) | gapComposer3.changed(mutableState6) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer3.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer3.changed(menuState) | gapComposer3.changedInstance(coroutineScope);
                Object objRememberedValue20 = gapComposer3.rememberedValue();
                if (zChangedInstance2 || objRememberedValue20 == neverEqualPolicy) {
                    objRememberedValue20 = new NewReleaseScreenKt$$ExternalSyntheticLambda1(list3, composableLambdaImpl, composableLambdaImplRememberComposableLambda2, mutableState6, menuState, coroutineScope, mutableStateCollectAsStateWithLifecycle3, mutableStateCollectAsStateWithLifecycle2);
                    gapComposer3.updateRememberedValue(objRememberedValue20);
                }
                LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive, null, lazyGridStateRememberLazyGridState, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, null, (Function1) objRememberedValue20, gapComposer3, 0, 2034);
                gapComposer3.end(false);
                gapComposer2 = gapComposer3;
            }
            gapComposer2.end(true);
            libraryAlbumsViewModel2 = libraryAlbumsViewModel8;
            gapComposer = gapComposer2;
        } else {
            gapComposer3.skipToGroupEnd();
            libraryAlbumsViewModel2 = libraryAlbumsViewModel;
            gapComposer = gapComposer3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController, function0, libraryAlbumsViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.library.LibraryAlbumsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ LibraryAlbumsViewModel f$2;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    LibraryAlbumsViewModel libraryAlbumsViewModel9 = this.f$2;
                    Function0 function1 = this.f$1;
                    NavHostController navHostController2 = this.f$0;
                    Composer composer2 = (Composer) obj3;
                    ((Integer) obj4).getClass();
                    switch (b3) {
                        case 0:
                            LibraryScreenKt.LibraryAlbumsScreen(navHostController2, function1, libraryAlbumsViewModel9, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            LibraryScreenKt.LibraryAlbumsScreen(navHostController2, function1, libraryAlbumsViewModel9, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0396  */
    /* JADX WARN: Code duplicated, block: B:102:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:103:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:107:0x03de  */
    /* JADX WARN: Code duplicated, block: B:109:0x040f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0418  */
    /* JADX WARN: Code duplicated, block: B:114:0x044b  */
    /* JADX WARN: Code duplicated, block: B:81:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:82:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:84:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:85:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:91:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:94:0x0363  */
    /* JADX WARN: Code duplicated, block: B:95:0x0369  */
    /* JADX WARN: Code duplicated, block: B:98:0x0393  */
    public static final void LibraryArtistsScreen(NavHostController navHostController, Function0 function0, LibraryArtistsViewModel libraryArtistsViewModel, Composer composer, int i) {
        LibraryArtistsViewModel libraryArtistsViewModel2;
        LibraryArtistsViewModel libraryArtistsViewModel3;
        MutableState mutableState;
        ReadonlyStateFlow stateFlow;
        MutableState mutableStateCollectAsStateWithLifecycle;
        Boolean bool;
        boolean zChanged;
        MutableState mutableState2;
        Object objRememberedValue;
        LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2;
        LazyListState lazyListState;
        LazyGridState lazyGridState;
        final MutableState mutableState3;
        final ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        int iOrdinal;
        boolean z;
        boolean zChanged2;
        Object objRememberedValue2;
        float f;
        boolean zChanged3;
        Object objRememberedValue3;
        navHostController.getClass();
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1133893177);
        int i2 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | 128;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                libraryArtistsViewModel3 = (LibraryArtistsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LibraryArtistsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
            } else {
                gapComposer.skipToGroupEnd();
                libraryArtistsViewModel3 = libraryArtistsViewModel;
            }
            gapComposer.endDefaults();
            final MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            Preferences$Key preferences$Key = PreferenceKeysKt.ArtistViewTypeKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue5;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 4));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue6, LibraryViewType.GRID, gapComposer, 48);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle2, coroutineScope2, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2) objRememberedValue7;
            Preferences$Key preferences$Key2 = PreferenceKeysKt.ArtistFilterKey;
            Context context2 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue8;
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key2, (byte) 5));
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue9, ArtistFilter.LIKED, gapComposer, 48);
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle3, coroutineScope3, context2, preferences$Key2);
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4) objRememberedValue10;
            Preferences$Key preferences$Key3 = PreferenceKeysKt.ArtistSortTypeKey;
            Context context3 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            CoroutineScope coroutineScope4 = (CoroutineScope) objRememberedValue11;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context3).getData(), preferences$Key3, (byte) 6));
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue12, ArtistSortType.CREATE_DATE, gapComposer, 48);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6(mutableStateCollectAsStateWithLifecycle4, coroutineScope4, context3, preferences$Key3);
                gapComposer.updateRememberedValue(objRememberedValue13);
            }
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6) objRememberedValue13;
            ArtistSortType artistSortType = (ArtistSortType) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$6, (byte) 14);
            Preferences$Key preferences$Key4 = PreferenceKeysKt.ArtistSortDescendingKey;
            Boolean bool2 = Boolean.TRUE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key4, bool2, gapComposer, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            Preferences$Key preferences$Key5 = PreferenceKeysKt.GridItemsSizeKey;
            Context context4 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue14 = gapComposer.rememberedValue();
            if (objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue14);
            }
            CoroutineScope coroutineScope5 = (CoroutineScope) objRememberedValue14;
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context4).getData(), preferences$Key5, (byte) 7));
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue15, gridItemSize, gapComposer, 48);
            Object objRememberedValue16 = gapComposer.rememberedValue();
            if (objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = new LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8(mutableStateCollectAsStateWithLifecycle5, coroutineScope5, context4, preferences$Key5);
                gapComposer.updateRememberedValue(objRememberedValue16);
            }
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8 = (LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8) objRememberedValue16;
            boolean zBooleanValue2 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.YtmSyncKey, bool2, gapComposer, 48).$state.getValue()).booleanValue();
            final ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1394835358, new EqScreenKt$$ExternalSyntheticLambda35(function0, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$4, (byte) 2), gapComposer);
            boolean zChanged4 = gapComposer.changed(zBooleanValue2) | gapComposer.changedInstance(libraryArtistsViewModel3);
            Object objRememberedValue17 = gapComposer.rememberedValue();
            Continuation continuation = null;
            if (zChanged4 || objRememberedValue17 == neverEqualPolicy) {
                objRememberedValue17 = new Updater$checkForUpdate$2(zBooleanValue2, (Object) libraryArtistsViewModel3, continuation, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue17);
            }
            Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue17);
            Object[] objArr = new Object[0];
            Object objRememberedValue18 = gapComposer.rememberedValue();
            if (objRememberedValue18 == neverEqualPolicy) {
                objRememberedValue18 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 19);
                gapComposer.updateRememberedValue(objRememberedValue18);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue18, gapComposer, 48);
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(libraryArtistsViewModel3.searchQuery, gapComposer);
            final MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(libraryArtistsViewModel3.filteredArtists, gapComposer);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            LibraryArtistsViewModel libraryArtistsViewModel4 = libraryArtistsViewModel3;
            if (navBackStackEntry != null) {
                SavedStateHandle savedStateHandle = navBackStackEntry.getSavedStateHandle();
                mutableState = mutableStateCollectAsStateWithLifecycle6;
                stateFlow = savedStateHandle != null ? savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop") : null;
                if (stateFlow == null) {
                    gapComposer.startReplaceGroup(-103058037);
                    gapComposer.end(false);
                    mutableStateCollectAsStateWithLifecycle = null;
                } else {
                    gapComposer.startReplaceGroup(-1250250442);
                    mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                    gapComposer.end(false);
                }
                if (mutableStateCollectAsStateWithLifecycle != null) {
                    bool = (Boolean) mutableStateCollectAsStateWithLifecycle.getValue();
                } else {
                    bool = null;
                }
                zChanged = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(lazyGridStateRememberLazyGridState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
                mutableState2 = mutableStateCollectAsStateWithLifecycle;
                objRememberedValue = gapComposer.rememberedValue();
                if (!zChanged || objRememberedValue == neverEqualPolicy) {
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3;
                    objRememberedValue = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(mutableState2, lazyListStateRememberLazyListState, lazyGridStateRememberLazyGridState, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2, mutableStateCurrentBackStackEntryAsState, null, (byte) 1);
                    lazyListState = lazyListStateRememberLazyListState;
                    lazyGridState = lazyGridStateRememberLazyGridState;
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    lazyListState = lazyListStateRememberLazyListState;
                    lazyGridState = lazyGridStateRememberLazyGridState;
                    libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3;
                }
                Stack.LaunchedEffect(gapComposer, bool, (Function2) objRememberedValue);
                mutableState3 = mutableState;
                LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2;
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(824847725, new ChipKt$$ExternalSyntheticLambda1((ViewModel) libraryArtistsViewModel4, mutableState4, softwareKeyboardController, mutableState3, (Enum) artistSortType, zBooleanValue, (Function1) anonymousClass2, (Function1) mimesKt$$ExternalSyntheticLambda0, (Object) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5, (Object) mutableStateCollectAsStateWithLifecycle7, (byte) 3), gapComposer);
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
                iOrdinal = ((LibraryViewType) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$5.getValue()).ordinal();
                if (iOrdinal != 0) {
                    z = true;
                    gapComposer.startReplaceGroup(1615336762);
                    InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer);
                    zChanged2 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer.changed(mutableState3) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        final byte b = 0;
                        Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                byte b2 = b;
                                Unit unit = Unit.INSTANCE;
                                final CoroutineScope coroutineScope6 = coroutineScope;
                                final MenuState menuState2 = menuState;
                                State state = mutableState3;
                                State state2 = mutableStateCollectAsStateWithLifecycle7;
                                ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                                ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda2;
                                byte b3 = 2;
                                final byte b4 = 1;
                                switch (b2) {
                                    case 0:
                                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                        lazyListIntervalContent.getClass();
                                        lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1041303220, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 12)));
                                        lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 305093571, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 13)));
                                        final List list = (List) state2.getValue();
                                        if (list.isEmpty()) {
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -1122646467, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 3)), 2);
                                        }
                                        LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 2);
                                        StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 25);
                                        int size = list.size();
                                        ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 12);
                                        ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, list, (byte) 13);
                                        final byte b5 = 0;
                                        lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                            @Override // kotlin.jvm.functions.Function4
                                            public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                                byte b6 = b5;
                                                Unit unit2 = Unit.INSTANCE;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                List list2 = list;
                                                switch (b6) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                        int iIntValue = ((Number) obj3).intValue();
                                                        Composer composer2 = (Composer) obj4;
                                                        int iIntValue2 = ((Number) obj5).intValue();
                                                        int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                        if ((iIntValue2 & 48) == 0) {
                                                            i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer2 = (GapComposer) composer2;
                                                        if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                            gapComposer2.skipToGroupEnd();
                                                        } else {
                                                            Artist artist = (Artist) list2.get(iIntValue);
                                                            gapComposer2.startReplaceGroup(-1607709659);
                                                            LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                        int iIntValue3 = ((Number) obj3).intValue();
                                                        Composer composer3 = (Composer) obj4;
                                                        int iIntValue4 = ((Number) obj5).intValue();
                                                        int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                        if ((iIntValue4 & 48) == 0) {
                                                            i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            Artist artist2 = (Artist) list2.get(iIntValue3);
                                                            gapComposer3.startReplaceGroup(-244469462);
                                                            LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }));
                                        break;
                                    default:
                                        LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                                        lazyGridIntervalContent.getClass();
                                        lazyGridIntervalContent.item("filter", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 26), 0, new ComposableLambdaImpl(true, 2001537965, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 10)));
                                        lazyGridIntervalContent.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 27), 0, new ComposableLambdaImpl(true, 1576382934, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 11)));
                                        final List list2 = (List) state2.getValue();
                                        if (list2.isEmpty()) {
                                            LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new StatsScreenKt$$ExternalSyntheticLambda9((byte) 28), null, new ComposableLambdaImpl(true, -1886922062, new PlayerKt$$ExternalSyntheticLambda74(state, b3)), 5);
                                        }
                                        lazyGridIntervalContent.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 29), list2, (byte) 14), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 1), list2, (byte) 15), new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                            @Override // kotlin.jvm.functions.Function4
                                            public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                                byte b6 = b4;
                                                Unit unit2 = Unit.INSTANCE;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                List list3 = list2;
                                                switch (b6) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                        int iIntValue = ((Number) obj3).intValue();
                                                        Composer composer2 = (Composer) obj4;
                                                        int iIntValue2 = ((Number) obj5).intValue();
                                                        int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                        if ((iIntValue2 & 48) == 0) {
                                                            i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer2 = (GapComposer) composer2;
                                                        if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                            gapComposer2.skipToGroupEnd();
                                                        } else {
                                                            Artist artist = (Artist) list3.get(iIntValue);
                                                            gapComposer2.startReplaceGroup(-1607709659);
                                                            LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                        int iIntValue3 = ((Number) obj3).intValue();
                                                        Composer composer3 = (Composer) obj4;
                                                        int iIntValue4 = ((Number) obj5).intValue();
                                                        int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                        if ((iIntValue4 & 48) == 0) {
                                                            i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            Artist artist2 = (Artist) list3.get(iIntValue3);
                                                            gapComposer3.startReplaceGroup(-244469462);
                                                            LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(function1);
                        objRememberedValue2 = function1;
                    }
                    IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue2, gapComposer, 0, 505);
                    gapComposer.end(false);
                } else {
                    if (iOrdinal == 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer, 1615337240, false);
                    }
                    gapComposer.startReplaceGroup(-1461886421);
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    if (((GridItemSize) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8.getValue()) == gridItemSize) {
                        f = 24.0f;
                    } else {
                        f = -24.0f;
                    }
                    GridCells$Adaptive gridCells$Adaptive = new GridCells$Adaptive(128.0f + f + CropImageView.DEFAULT_ASPECT_RATIO);
                    InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer);
                    zChanged3 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer.changed(mutableState3) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        final byte b2 = 1;
                        Function1 function2 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                byte b3 = b2;
                                Unit unit = Unit.INSTANCE;
                                final CoroutineScope coroutineScope6 = coroutineScope;
                                final MenuState menuState2 = menuState;
                                State state = mutableState3;
                                State state2 = mutableStateCollectAsStateWithLifecycle7;
                                ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                                ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda2;
                                byte b4 = 2;
                                final byte b5 = 1;
                                switch (b3) {
                                    case 0:
                                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                        lazyListIntervalContent.getClass();
                                        lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1041303220, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 12)));
                                        lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 305093571, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 13)));
                                        final List list = (List) state2.getValue();
                                        if (list.isEmpty()) {
                                            LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -1122646467, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 3)), 2);
                                        }
                                        LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 2);
                                        StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 25);
                                        int size = list.size();
                                        ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 12);
                                        ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, list, (byte) 13);
                                        final byte b6 = 0;
                                        lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                            @Override // kotlin.jvm.functions.Function4
                                            public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                                byte b7 = b6;
                                                Unit unit2 = Unit.INSTANCE;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                List list3 = list;
                                                switch (b7) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                        int iIntValue = ((Number) obj3).intValue();
                                                        Composer composer2 = (Composer) obj4;
                                                        int iIntValue2 = ((Number) obj5).intValue();
                                                        int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                        if ((iIntValue2 & 48) == 0) {
                                                            i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer2 = (GapComposer) composer2;
                                                        if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                            gapComposer2.skipToGroupEnd();
                                                        } else {
                                                            Artist artist = (Artist) list3.get(iIntValue);
                                                            gapComposer2.startReplaceGroup(-1607709659);
                                                            LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                        int iIntValue3 = ((Number) obj3).intValue();
                                                        Composer composer3 = (Composer) obj4;
                                                        int iIntValue4 = ((Number) obj5).intValue();
                                                        int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                        if ((iIntValue4 & 48) == 0) {
                                                            i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            Artist artist2 = (Artist) list3.get(iIntValue3);
                                                            gapComposer3.startReplaceGroup(-244469462);
                                                            LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }));
                                        break;
                                    default:
                                        LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                                        lazyGridIntervalContent.getClass();
                                        lazyGridIntervalContent.item("filter", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 26), 0, new ComposableLambdaImpl(true, 2001537965, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 10)));
                                        lazyGridIntervalContent.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 27), 0, new ComposableLambdaImpl(true, 1576382934, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 11)));
                                        final List list2 = (List) state2.getValue();
                                        if (list2.isEmpty()) {
                                            LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new StatsScreenKt$$ExternalSyntheticLambda9((byte) 28), null, new ComposableLambdaImpl(true, -1886922062, new PlayerKt$$ExternalSyntheticLambda74(state, b4)), 5);
                                        }
                                        lazyGridIntervalContent.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 29), list2, (byte) 14), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 1), list2, (byte) 15), new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                            @Override // kotlin.jvm.functions.Function4
                                            public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                                byte b7 = b5;
                                                Unit unit2 = Unit.INSTANCE;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                List list3 = list2;
                                                switch (b7) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                        int iIntValue = ((Number) obj3).intValue();
                                                        Composer composer2 = (Composer) obj4;
                                                        int iIntValue2 = ((Number) obj5).intValue();
                                                        int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                        if ((iIntValue2 & 48) == 0) {
                                                            i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer2 = (GapComposer) composer2;
                                                        if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                            gapComposer2.skipToGroupEnd();
                                                        } else {
                                                            Artist artist = (Artist) list3.get(iIntValue);
                                                            gapComposer2.startReplaceGroup(-1607709659);
                                                            LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                        int iIntValue3 = ((Number) obj3).intValue();
                                                        Composer composer3 = (Composer) obj4;
                                                        int iIntValue4 = ((Number) obj5).intValue();
                                                        int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                        if ((iIntValue4 & 48) == 0) {
                                                            i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                        }
                                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                                        if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                            gapComposer3.skipToGroupEnd();
                                                        } else {
                                                            Artist artist2 = (Artist) list3.get(iIntValue3);
                                                            gapComposer3.startReplaceGroup(-244469462);
                                                            LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        }));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(function2);
                        objRememberedValue3 = function2;
                    }
                    z = true;
                    LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive, null, lazyGridState, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, null, (Function1) objRememberedValue3, gapComposer, 0, 2034);
                    gapComposer = gapComposer;
                    gapComposer.end(false);
                }
                gapComposer.end(z);
                libraryArtistsViewModel2 = libraryArtistsViewModel4;
            } else {
                mutableState = mutableStateCollectAsStateWithLifecycle6;
            }
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(-103058037);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(-1250250442);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                gapComposer.end(false);
            }
            if (mutableStateCollectAsStateWithLifecycle != null) {
                bool = (Boolean) mutableStateCollectAsStateWithLifecycle.getValue();
            } else {
                bool = null;
            }
            zChanged = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(lazyGridStateRememberLazyGridState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
            mutableState2 = mutableStateCollectAsStateWithLifecycle;
            objRememberedValue = gapComposer.rememberedValue();
            if (zChanged) {
                libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3;
                objRememberedValue = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(mutableState2, lazyListStateRememberLazyListState, lazyGridStateRememberLazyGridState, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2, mutableStateCurrentBackStackEntryAsState, null, (byte) 1);
                lazyListState = lazyListStateRememberLazyListState;
                lazyGridState = lazyGridStateRememberLazyGridState;
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$3;
                objRememberedValue = new LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(mutableState2, lazyListStateRememberLazyListState, lazyGridStateRememberLazyGridState, libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2, mutableStateCurrentBackStackEntryAsState, null, (byte) 1);
                lazyListState = lazyListStateRememberLazyListState;
                lazyGridState = lazyGridStateRememberLazyGridState;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer, bool, (Function2) objRememberedValue);
            mutableState3 = mutableState;
            LibraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2 libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7 = libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$2;
            composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(824847725, new ChipKt$$ExternalSyntheticLambda1((ViewModel) libraryArtistsViewModel4, mutableState4, softwareKeyboardController, mutableState3, (Enum) artistSortType, zBooleanValue, (Function1) anonymousClass2, (Function1) mimesKt$$ExternalSyntheticLambda0, (Object) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7, (Object) mutableStateCollectAsStateWithLifecycle7, (byte) 3), gapComposer);
            FillElement fillElement2 = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, fillElement2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            iOrdinal = ((LibraryViewType) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$7.getValue()).ordinal();
            if (iOrdinal != 0) {
                z = true;
                gapComposer.startReplaceGroup(1615336762);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues3 = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer);
                zChanged2 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer.changed(mutableState3) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    final byte b3 = 0;
                    Function1 function3 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            byte b4 = b3;
                            Unit unit = Unit.INSTANCE;
                            final CoroutineScope coroutineScope6 = coroutineScope;
                            final MenuState menuState2 = menuState;
                            State state = mutableState3;
                            State state2 = mutableStateCollectAsStateWithLifecycle7;
                            ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda2;
                            byte b5 = 2;
                            final byte b6 = 1;
                            switch (b4) {
                                case 0:
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                    lazyListIntervalContent.getClass();
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1041303220, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 12)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 305093571, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 13)));
                                    final List list = (List) state2.getValue();
                                    if (list.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -1122646467, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 3)), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 2);
                                    StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 25);
                                    int size = list.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 12);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, list, (byte) 13);
                                    final byte b7 = 0;
                                    lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b8 = b7;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list;
                                            switch (b8) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                                default:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 26), 0, new ComposableLambdaImpl(true, 2001537965, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 10)));
                                    lazyGridIntervalContent.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 27), 0, new ComposableLambdaImpl(true, 1576382934, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 11)));
                                    final List list2 = (List) state2.getValue();
                                    if (list2.isEmpty()) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new StatsScreenKt$$ExternalSyntheticLambda9((byte) 28), null, new ComposableLambdaImpl(true, -1886922062, new PlayerKt$$ExternalSyntheticLambda74(state, b5)), 5);
                                    }
                                    lazyGridIntervalContent.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 29), list2, (byte) 14), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 1), list2, (byte) 15), new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b8 = b6;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list2;
                                            switch (b8) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function3);
                    objRememberedValue2 = function3;
                } else {
                    final byte b4 = 0;
                    Function1 function4 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            byte b5 = b4;
                            Unit unit = Unit.INSTANCE;
                            final CoroutineScope coroutineScope6 = coroutineScope;
                            final MenuState menuState2 = menuState;
                            State state = mutableState3;
                            State state2 = mutableStateCollectAsStateWithLifecycle7;
                            ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda2;
                            byte b6 = 2;
                            final byte b7 = 1;
                            switch (b5) {
                                case 0:
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                    lazyListIntervalContent.getClass();
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1041303220, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 12)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 305093571, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 13)));
                                    final List list = (List) state2.getValue();
                                    if (list.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -1122646467, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 3)), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 2);
                                    StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 25);
                                    int size = list.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 12);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, list, (byte) 13);
                                    final byte b8 = 0;
                                    lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b9 = b8;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list;
                                            switch (b9) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                                default:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 26), 0, new ComposableLambdaImpl(true, 2001537965, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 10)));
                                    lazyGridIntervalContent.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 27), 0, new ComposableLambdaImpl(true, 1576382934, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 11)));
                                    final List list2 = (List) state2.getValue();
                                    if (list2.isEmpty()) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new StatsScreenKt$$ExternalSyntheticLambda9((byte) 28), null, new ComposableLambdaImpl(true, -1886922062, new PlayerKt$$ExternalSyntheticLambda74(state, b6)), 5);
                                    }
                                    lazyGridIntervalContent.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 29), list2, (byte) 14), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 1), list2, (byte) 15), new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b9 = b7;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list2;
                                            switch (b9) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function4);
                    objRememberedValue2 = function4;
                }
                IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues3, null, null, null, false, null, (Function1) objRememberedValue2, gapComposer, 0, 505);
                gapComposer.end(false);
            } else {
                if (iOrdinal == 1) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, 1615337240, false);
                }
                gapComposer.startReplaceGroup(-1461886421);
                SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                if (((GridItemSize) libraryArtistsScreenKt$LibraryArtistsScreen$$inlined$rememberEnumPreference$8.getValue()) == gridItemSize) {
                    f = 24.0f;
                } else {
                    f = -24.0f;
                }
                GridCells$Adaptive gridCells$Adaptive2 = new GridCells$Adaptive(128.0f + f + CropImageView.DEFAULT_ASPECT_RATIO);
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues4 = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer);
                zChanged3 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer.changed(mutableState3) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged3) {
                    final byte b5 = 1;
                    Function1 function5 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            byte b6 = b5;
                            Unit unit = Unit.INSTANCE;
                            final CoroutineScope coroutineScope6 = coroutineScope;
                            final MenuState menuState2 = menuState;
                            State state = mutableState3;
                            State state2 = mutableStateCollectAsStateWithLifecycle7;
                            ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda2;
                            byte b7 = 2;
                            final byte b8 = 1;
                            switch (b6) {
                                case 0:
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                    lazyListIntervalContent.getClass();
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1041303220, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 12)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 305093571, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 13)));
                                    final List list = (List) state2.getValue();
                                    if (list.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -1122646467, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 3)), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 2);
                                    StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 25);
                                    int size = list.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 12);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, list, (byte) 13);
                                    final byte b9 = 0;
                                    lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b10 = b9;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list;
                                            switch (b10) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                                default:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 26), 0, new ComposableLambdaImpl(true, 2001537965, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 10)));
                                    lazyGridIntervalContent.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 27), 0, new ComposableLambdaImpl(true, 1576382934, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 11)));
                                    final List list2 = (List) state2.getValue();
                                    if (list2.isEmpty()) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new StatsScreenKt$$ExternalSyntheticLambda9((byte) 28), null, new ComposableLambdaImpl(true, -1886922062, new PlayerKt$$ExternalSyntheticLambda74(state, b7)), 5);
                                    }
                                    lazyGridIntervalContent.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 29), list2, (byte) 14), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 1), list2, (byte) 15), new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b10 = b8;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list2;
                                            switch (b10) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function5);
                    objRememberedValue3 = function5;
                } else {
                    final byte b6 = 1;
                    Function1 function6 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            byte b7 = b6;
                            Unit unit = Unit.INSTANCE;
                            final CoroutineScope coroutineScope6 = coroutineScope;
                            final MenuState menuState2 = menuState;
                            State state = mutableState3;
                            State state2 = mutableStateCollectAsStateWithLifecycle7;
                            ComposableLambdaImpl composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda2;
                            byte b8 = 2;
                            final byte b9 = 1;
                            switch (b7) {
                                case 0:
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                    lazyListIntervalContent.getClass();
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1041303220, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 12)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 305093571, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 13)));
                                    final List list = (List) state2.getValue();
                                    if (list.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -1122646467, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 3)), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 2);
                                    StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 25);
                                    int size = list.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list, (byte) 12);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, list, (byte) 13);
                                    final byte b10 = 0;
                                    lazyListIntervalContent.items(size, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b11 = b10;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list;
                                            switch (b11) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                                default:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 26), 0, new ComposableLambdaImpl(true, 2001537965, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 10)));
                                    lazyGridIntervalContent.item("header", new StatsScreenKt$$ExternalSyntheticLambda9((byte) 27), 0, new ComposableLambdaImpl(true, 1576382934, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 11)));
                                    final List list2 = (List) state2.getValue();
                                    if (list2.isEmpty()) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new StatsScreenKt$$ExternalSyntheticLambda9((byte) 28), null, new ComposableLambdaImpl(true, -1886922062, new PlayerKt$$ExternalSyntheticLambda74(state, b8)), 5);
                                    }
                                    lazyGridIntervalContent.items(list2.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 29), list2, (byte) 14), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 1), list2, (byte) 15), new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryArtistsScreenKt$LibraryArtistsScreen$lambda$15$0$0$2$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                            byte b11 = b9;
                                            Unit unit2 = Unit.INSTANCE;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            List list3 = list2;
                                            switch (b11) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                                    int iIntValue = ((Number) obj3).intValue();
                                                    Composer composer2 = (Composer) obj4;
                                                    int iIntValue2 = ((Number) obj5).intValue();
                                                    int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i3 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                                    if (!gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                                        gapComposer2.skipToGroupEnd();
                                                    } else {
                                                        Artist artist = (Artist) list3.get(iIntValue);
                                                        gapComposer2.startReplaceGroup(-1607709659);
                                                        LibraryKt.LibraryArtistListItem(menuState2, coroutineScope6, artist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer2, 0);
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj2;
                                                    int iIntValue3 = ((Number) obj3).intValue();
                                                    Composer composer3 = (Composer) obj4;
                                                    int iIntValue4 = ((Number) obj5).intValue();
                                                    int i4 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i4 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                                    if (!gapComposer3.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        Artist artist2 = (Artist) list3.get(iIntValue3);
                                                        gapComposer3.startReplaceGroup(-244469462);
                                                        LibraryKt.LibraryArtistGridItem(menuState2, coroutineScope6, artist2, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer3, 0);
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function6);
                    objRememberedValue3 = function6;
                }
                z = true;
                LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive2, null, lazyGridState, insetsPaddingValuesAsPaddingValues4, null, null, null, false, null, null, (Function1) objRememberedValue3, gapComposer, 0, 2034);
                gapComposer = gapComposer;
                gapComposer.end(false);
            }
            gapComposer.end(z);
            libraryArtistsViewModel2 = libraryArtistsViewModel4;
        } else {
            gapComposer.skipToGroupEnd();
            libraryArtistsViewModel2 = libraryArtistsViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 7, i, navHostController, function0, libraryArtistsViewModel2);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void LibraryMixScreen(final NavHostController navHostController, final ComposableLambdaImpl composableLambdaImpl, final LibraryViewType libraryViewType, final Function1 function1, LibraryMixViewModel libraryMixViewModel, Composer composer, final int i) {
        final LibraryMixViewModel libraryMixViewModel2;
        GapComposer gapComposer;
        int i2;
        LibraryMixViewModel libraryMixViewModel3;
        PlayerConnection playerConnection;
        MutableState mutableState;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0;
        Object obj;
        boolean z;
        GapComposer gapComposer2;
        Object obj2;
        boolean z2;
        List listSortedWith;
        Playlist playlist;
        boolean z3;
        boolean z4;
        byte b;
        boolean zMatchesNormalizedQuery;
        MutableState mutableStateCollectAsStateWithLifecycle;
        LazyListState lazyListState;
        LazyGridState lazyGridState;
        Object artistScreenKt$ArtistScreen$4$2$1;
        boolean z5;
        FillElement fillElement;
        LibraryMixViewModel libraryMixViewModel4;
        Object obj3;
        Object obj4;
        GapComposer gapComposer3;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        GapComposer gapComposer4;
        GapComposer gapComposer5;
        SavedStateHandle savedStateHandle;
        boolean z6;
        navHostController.getClass();
        libraryViewType.getClass();
        function1.getClass();
        GapComposer gapComposer6 = (GapComposer) composer;
        gapComposer6.startRestartGroup(-1925025701);
        int i3 = i | (gapComposer6.changedInstance(navHostController) ? 4 : 2) | (gapComposer6.changed(libraryViewType.ordinal()) ? 256 : 128) | (gapComposer6.changedInstance(function1) ? 2048 : 1024) | 8192;
        if (gapComposer6.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            gapComposer6.startDefaults();
            if ((i & 1) == 0 || gapComposer6.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer6.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    i2 = i3 & (-57345);
                    libraryMixViewModel3 = (LibraryMixViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LibraryMixViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer6), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer6);
                }
            } else {
                gapComposer6.skipToGroupEnd();
                i2 = i3 & (-57345);
                libraryMixViewModel3 = libraryMixViewModel;
            }
            int i4 = i2;
            gapComposer6.endDefaults();
            final MenuState menuState = (MenuState) gapComposer6.consume(BottomSheetMenuKt.LocalMenuState);
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer6.consume(CompositionLocalsKt.LocalHapticFeedback);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer6.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            final String strStringResource = MathKt.stringResource(R.string.queue_searched_songs, gapComposer6);
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer6.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer6.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b2 = 0;
                    final LibraryMixViewModel libraryMixViewModel5 = libraryMixViewModel3;
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, composableLambdaImpl, libraryViewType, function1, libraryMixViewModel5, i, b2) { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ ComposableLambdaImpl f$1;
                        public final /* synthetic */ LibraryViewType f$2;
                        public final /* synthetic */ Function1 f$3;
                        public final /* synthetic */ LibraryMixViewModel f$4;

                        {
                            this.$r8$classId = b2;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj5, Object obj6) {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            switch (b3) {
                                case 0:
                                    ((Integer) obj6).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(49);
                                    LibraryScreenKt.LibraryMixScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj5, iUpdateChangedFlags);
                                    break;
                                default:
                                    ((Integer) obj6).getClass();
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(49);
                                    LibraryScreenKt.LibraryMixScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj5, iUpdateChangedFlags2);
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer6);
            final MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer6);
            Preferences$Key preferences$Key = PreferenceKeysKt.MixSortTypeKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer6.consume(staticProvidableCompositionLocal2);
            Object objRememberedValue = gapComposer6.rememberedValue();
            Object obj5 = Composer.Companion.Empty;
            if (objRememberedValue == obj5) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer6);
                gapComposer6.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer6.rememberedValue();
            if (objRememberedValue2 == obj5) {
                objRememberedValue2 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 8));
                gapComposer6.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, MixSortType.CREATE_DATE, gapComposer6, 48);
            Object objRememberedValue3 = gapComposer6.rememberedValue();
            if (objRememberedValue3 == obj5) {
                objRememberedValue3 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle4, coroutineScope, context, preferences$Key);
                gapComposer6.updateRememberedValue(objRememberedValue3);
            }
            LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2) objRememberedValue3;
            MixSortType mixSortType = (MixSortType) libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$2, (byte) 16);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.MixSortDescendingKey;
            Boolean bool = Boolean.TRUE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer6, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            Preferences$Key preferences$Key3 = PreferenceKeysKt.GridItemsSizeKey;
            Context context2 = (Context) gapComposer6.consume(staticProvidableCompositionLocal2);
            Object objRememberedValue4 = gapComposer6.rememberedValue();
            if (objRememberedValue4 == obj5) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer6);
                gapComposer6.updateRememberedValue(objRememberedValue4);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue4;
            Object objRememberedValue5 = gapComposer6.rememberedValue();
            if (objRememberedValue5 == obj5) {
                objRememberedValue5 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key3, (byte) 9));
                gapComposer6.updateRememberedValue(objRememberedValue5);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue5, gridItemSize, gapComposer6, 48);
            Object objRememberedValue6 = gapComposer6.rememberedValue();
            if (objRememberedValue6 == obj5) {
                objRememberedValue6 = new LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle5, coroutineScope2, context2, preferences$Key3);
                gapComposer6.updateRememberedValue(objRememberedValue6);
            }
            LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4 libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4 = (LibraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4) objRememberedValue6;
            boolean zBooleanValue2 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.YtmSyncKey, bool, gapComposer6, 48).$state.getValue()).booleanValue();
            Object[] objArr = new Object[0];
            Object objRememberedValue7 = gapComposer6.rememberedValue();
            if (objRememberedValue7 == obj5) {
                objRememberedValue7 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 1);
                gapComposer6.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue7, gapComposer6, 48);
            final MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.searchQuery, gapComposer6);
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.debouncedSearchQuery, gapComposer6);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue8 = gapComposer6.rememberedValue();
            if (objRememberedValue8 == obj5) {
                objRememberedValue8 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 2);
                gapComposer6.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue8, gapComposer6, 48);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                gapComposer6.startReplaceGroup(-2035868986);
                boolean zChanged = gapComposer6.changed(mutableState3);
                Object objRememberedValue9 = gapComposer6.rememberedValue();
                if (zChanged || objRememberedValue9 == obj5) {
                    objRememberedValue9 = new PlayerKt$$ExternalSyntheticLambda7(mutableState3, (byte) 27);
                    gapComposer6.updateRememberedValue(objRememberedValue9);
                }
                Function0 function0 = (Function0) objRememberedValue9;
                boolean zChanged2 = gapComposer6.changed(mutableState3) | gapComposer6.changedInstance(navHostController);
                Object objRememberedValue10 = gapComposer6.rememberedValue();
                if (zChanged2 || objRememberedValue10 == obj5) {
                    z6 = false;
                    objRememberedValue10 = new LibraryMixScreenKt$$ExternalSyntheticLambda7(navHostController, mutableState3, (byte) 0);
                    gapComposer6.updateRememberedValue(objRememberedValue10);
                } else {
                    z6 = false;
                }
                playerConnection = playerConnection2;
                mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda1;
                mutableState = mutableState3;
                obj = obj5;
                z = zBooleanValue;
                DialogKt.CreatePlaylistDialog(function0, null, false, (Function1) objRememberedValue10, gapComposer6, 0, 6);
                GapComposer gapComposer7 = gapComposer6;
                gapComposer7.end(z6);
                gapComposer2 = gapComposer7;
            } else {
                playerConnection = playerConnection2;
                mutableState = mutableState3;
                GapComposer gapComposer8 = gapComposer6;
                mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda1;
                obj = obj5;
                z = zBooleanValue;
                gapComposer8.startReplaceGroup(-2035591257);
                gapComposer8.end(false);
                gapComposer2 = gapComposer8;
            }
            boolean zChanged3 = gapComposer2.changed(((Boolean) mutableState2.getValue()).booleanValue()) | gapComposer2.changed((String) mutableStateCollectAsStateWithLifecycle6.getValue()) | gapComposer2.changed((String) mutableStateCollectAsStateWithLifecycle7.getValue());
            Object objRememberedValue11 = gapComposer2.rememberedValue();
            if (zChanged3 || objRememberedValue11 == obj) {
                objRememberedValue11 = ((Boolean) mutableState2.getValue()).booleanValue() ? StringExtKt.normalizeForSearch((String) mutableStateCollectAsStateWithLifecycle6.getValue()) : StringExtKt.normalizeForSearch((String) mutableStateCollectAsStateWithLifecycle7.getValue());
                gapComposer2.updateRememberedValue(objRememberedValue11);
            }
            String str = (String) objRememberedValue11;
            final MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.topValue, 50, gapComposer2, 48);
            String string = UUID.randomUUID().toString();
            string.getClass();
            String strStringResource2 = MathKt.stringResource(R.string.liked, gapComposer2);
            PlaylistEntity playlistEntity = new PlaylistEntity(string, strStringResource2, null, null, false, null, null, null, null, null, null, 16380);
            EmptyList emptyList = EmptyList.INSTANCE;
            Playlist playlist2 = new Playlist(playlistEntity, 0, emptyList);
            String string2 = UUID.randomUUID().toString();
            string2.getClass();
            String strStringResource3 = MathKt.stringResource(R.string.offline, gapComposer2);
            final Playlist playlist3 = new Playlist(new PlaylistEntity(string2, strStringResource3, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            String string3 = UUID.randomUUID().toString();
            string3.getClass();
            String str2 = MathKt.stringResource(R.string.my_top, gapComposer2) + ServerSentEventKt.SPACE + mutableStateCollectAsStateWithLifecycle8.getValue();
            final Playlist playlist4 = new Playlist(new PlaylistEntity(string3, str2, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            String string4 = UUID.randomUUID().toString();
            string4.getClass();
            String strStringResource4 = MathKt.stringResource(R.string.cached_playlist, gapComposer2);
            final Playlist playlist5 = new Playlist(new PlaylistEntity(string4, strStringResource4, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            String string5 = UUID.randomUUID().toString();
            string5.getClass();
            String strStringResource5 = MathKt.stringResource(R.string.uploaded_playlist, gapComposer2);
            final Playlist playlist6 = new Playlist(new PlaylistEntity(string5, strStringResource5, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            boolean zBooleanValue3 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowLikedPlaylistKey, bool, gapComposer2, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue4 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowDownloadedPlaylistKey, bool, gapComposer2, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue5 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowTopPlaylistKey, bool, gapComposer2, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue6 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowCachedPlaylistKey, bool, gapComposer2, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue7 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowUploadedPlaylistKey, bool, gapComposer2, 48).$state.getValue()).booleanValue();
            boolean z7 = zBooleanValue3 && StringExtKt.matchesNormalizedQuery(str, strStringResource2);
            boolean z8 = zBooleanValue4 && StringExtKt.matchesNormalizedQuery(str, strStringResource3);
            boolean z9 = zBooleanValue5 && StringExtKt.matchesNormalizedQuery(str, str2);
            boolean z10 = zBooleanValue7 && StringExtKt.matchesNormalizedQuery(str, strStringResource5);
            boolean z11 = zBooleanValue6 && StringExtKt.matchesNormalizedQuery(str, strStringResource4);
            final boolean z12 = z10;
            MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.albums, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle10 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.artists, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle11 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.songs, gapComposer2);
            final boolean z13 = z9;
            ArrayList arrayListPlus = CollectionsKt.plus((Iterable) FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.playlists, gapComposer2).getValue(), (Collection) CollectionsKt.plus((Iterable) mutableStateCollectAsStateWithLifecycle10.getValue(), (Collection) mutableStateCollectAsStateWithLifecycle9.getValue()));
            Locale locale = ((androidx.compose.ui.text.intl.Locale) gapComposer2.consume(CompositionLocalsKt.LocalLocale)).platformLocale;
            boolean zChanged4 = gapComposer2.changed(locale);
            Object objRememberedValue12 = gapComposer2.rememberedValue();
            if (zChanged4 || objRememberedValue12 == obj) {
                Collator collator = Collator.getInstance(locale);
                collator.setStrength(0);
                gapComposer2.updateRememberedValue(collator);
                obj2 = collator;
            } else {
                obj2 = objRememberedValue12;
            }
            Collator collator2 = (Collator) obj2;
            int iOrdinal = mixSortType.ordinal();
            if (iOrdinal != 0) {
                z2 = z11;
                if (iOrdinal == 1) {
                    collator2.getClass();
                    listSortedWith = CollectionsKt.sortedWith(arrayListPlus, new DatabaseDao$songs$lambda$0$$inlined$compareBy$1(collator2, (byte) 20));
                } else if (iOrdinal != 2) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                } else {
                    final byte b3 = 1;
                    listSortedWith = CollectionsKt.sortedWith(arrayListPlus, new Comparator() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$sortedBy$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj6, Object obj7) {
                            LocalDateTime localDateTimeNow;
                            LocalDateTime localDateTimeNow2;
                            LocalDateTime localDateTimeNow3;
                            LocalDateTime localDateTimeNow4;
                            switch (b3) {
                                case 0:
                                    LocalItem localItem = (LocalItem) obj6;
                                    if (localItem != null) {
                                        if (localItem instanceof Album) {
                                            localDateTimeNow = ((Album) localItem).album.bookmarkedAt;
                                        } else if (localItem instanceof Artist) {
                                            localDateTimeNow = ((Artist) localItem).artist.bookmarkedAt;
                                        } else if (localItem instanceof Playlist) {
                                            localDateTimeNow = ((Playlist) localItem).playlist.createdAt;
                                        } else if (localItem instanceof Song) {
                                            localDateTimeNow = LocalDateTime.now();
                                        }
                                        LocalItem localItem2 = (LocalItem) obj7;
                                        if (localItem2 != null) {
                                            if (localItem2 instanceof Album) {
                                                localDateTimeNow2 = ((Album) localItem2).album.bookmarkedAt;
                                            } else if (localItem2 instanceof Artist) {
                                                localDateTimeNow2 = ((Artist) localItem2).artist.bookmarkedAt;
                                            } else if (localItem2 instanceof Playlist) {
                                                localDateTimeNow2 = ((Playlist) localItem2).playlist.createdAt;
                                            } else if (localItem2 instanceof Song) {
                                                localDateTimeNow2 = LocalDateTime.now();
                                            }
                                            return RegexKt.compareValues(localDateTimeNow, localDateTimeNow2);
                                        }
                                    }
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return 0;
                                default:
                                    LocalItem localItem3 = (LocalItem) obj6;
                                    if (localItem3 != null) {
                                        if (localItem3 instanceof Album) {
                                            localDateTimeNow3 = ((Album) localItem3).album.lastUpdateTime;
                                        } else if (localItem3 instanceof Artist) {
                                            localDateTimeNow3 = ((Artist) localItem3).artist.lastUpdateTime;
                                        } else if (localItem3 instanceof Playlist) {
                                            localDateTimeNow3 = ((Playlist) localItem3).playlist.lastUpdateTime;
                                        } else if (localItem3 instanceof Song) {
                                            localDateTimeNow3 = LocalDateTime.now();
                                        }
                                        LocalItem localItem4 = (LocalItem) obj7;
                                        if (localItem4 != null) {
                                            if (localItem4 instanceof Album) {
                                                localDateTimeNow4 = ((Album) localItem4).album.lastUpdateTime;
                                            } else if (localItem4 instanceof Artist) {
                                                localDateTimeNow4 = ((Artist) localItem4).artist.lastUpdateTime;
                                            } else if (localItem4 instanceof Playlist) {
                                                localDateTimeNow4 = ((Playlist) localItem4).playlist.lastUpdateTime;
                                            } else if (localItem4 instanceof Song) {
                                                localDateTimeNow4 = LocalDateTime.now();
                                            }
                                            return RegexKt.compareValues(localDateTimeNow3, localDateTimeNow4);
                                        }
                                    }
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return 0;
                            }
                        }
                    });
                }
            } else {
                z2 = z11;
                final byte b4 = 0;
                listSortedWith = CollectionsKt.sortedWith(arrayListPlus, new Comparator() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj6, Object obj7) {
                        LocalDateTime localDateTimeNow;
                        LocalDateTime localDateTimeNow2;
                        LocalDateTime localDateTimeNow3;
                        LocalDateTime localDateTimeNow4;
                        switch (b4) {
                            case 0:
                                LocalItem localItem = (LocalItem) obj6;
                                if (localItem != null) {
                                    if (localItem instanceof Album) {
                                        localDateTimeNow = ((Album) localItem).album.bookmarkedAt;
                                    } else if (localItem instanceof Artist) {
                                        localDateTimeNow = ((Artist) localItem).artist.bookmarkedAt;
                                    } else if (localItem instanceof Playlist) {
                                        localDateTimeNow = ((Playlist) localItem).playlist.createdAt;
                                    } else if (localItem instanceof Song) {
                                        localDateTimeNow = LocalDateTime.now();
                                    }
                                    LocalItem localItem2 = (LocalItem) obj7;
                                    if (localItem2 != null) {
                                        if (localItem2 instanceof Album) {
                                            localDateTimeNow2 = ((Album) localItem2).album.bookmarkedAt;
                                        } else if (localItem2 instanceof Artist) {
                                            localDateTimeNow2 = ((Artist) localItem2).artist.bookmarkedAt;
                                        } else if (localItem2 instanceof Playlist) {
                                            localDateTimeNow2 = ((Playlist) localItem2).playlist.createdAt;
                                        } else if (localItem2 instanceof Song) {
                                            localDateTimeNow2 = LocalDateTime.now();
                                        }
                                        return RegexKt.compareValues(localDateTimeNow, localDateTimeNow2);
                                    }
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return 0;
                            default:
                                LocalItem localItem3 = (LocalItem) obj6;
                                if (localItem3 != null) {
                                    if (localItem3 instanceof Album) {
                                        localDateTimeNow3 = ((Album) localItem3).album.lastUpdateTime;
                                    } else if (localItem3 instanceof Artist) {
                                        localDateTimeNow3 = ((Artist) localItem3).artist.lastUpdateTime;
                                    } else if (localItem3 instanceof Playlist) {
                                        localDateTimeNow3 = ((Playlist) localItem3).playlist.lastUpdateTime;
                                    } else if (localItem3 instanceof Song) {
                                        localDateTimeNow3 = LocalDateTime.now();
                                    }
                                    LocalItem localItem4 = (LocalItem) obj7;
                                    if (localItem4 != null) {
                                        if (localItem4 instanceof Album) {
                                            localDateTimeNow4 = ((Album) localItem4).album.lastUpdateTime;
                                        } else if (localItem4 instanceof Artist) {
                                            localDateTimeNow4 = ((Artist) localItem4).artist.lastUpdateTime;
                                        } else if (localItem4 instanceof Playlist) {
                                            localDateTimeNow4 = ((Playlist) localItem4).playlist.lastUpdateTime;
                                        } else if (localItem4 instanceof Song) {
                                            localDateTimeNow4 = LocalDateTime.now();
                                        }
                                        return RegexKt.compareValues(localDateTimeNow3, localDateTimeNow4);
                                    }
                                }
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return 0;
                        }
                    }
                });
            }
            Collection collectionReversed = CollectionsKt__IterablesKt.reversed(listSortedWith, z);
            if (!StringsKt.isBlank(str)) {
                collectionReversed = CollectionsKt.plus((Iterable) mutableStateCollectAsStateWithLifecycle11.getValue(), collectionReversed);
            }
            boolean zChanged5 = gapComposer2.changed(collectionReversed) | gapComposer2.changed(str) | gapComposer2.changed(collator2);
            Object objRememberedValue13 = gapComposer2.rememberedValue();
            if (zChanged5 || objRememberedValue13 == obj) {
                ArrayList arrayList = new ArrayList();
                Iterator it = collectionReversed.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Iterator it2 = it;
                    LocalItem localItem = (LocalItem) next;
                    boolean z14 = z;
                    if (localItem == null) {
                        b = -1;
                    } else if (localItem instanceof Song) {
                        b = 0;
                    } else if (localItem instanceof Album) {
                        b = 1;
                    } else if (localItem instanceof Artist) {
                        b = 2;
                    } else {
                        b = localItem instanceof Playlist ? (byte) 3 : (byte) -2;
                    }
                    if (b == 0) {
                        Song song = (Song) localItem;
                        List orderedArtists = song.getOrderedArtists();
                        SongEntity songEntity = song.song;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(orderedArtists, 10));
                        Iterator it3 = orderedArtists.iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(((ArtistEntity) it3.next()).name);
                        }
                        String[] strArr = (String[]) arrayList2.toArray(new String[0]);
                        Headers.Builder builder = new Headers.Builder(3);
                        builder.add(songEntity.title);
                        builder.add(songEntity.albumName);
                        builder.addSpread(strArr);
                        ArrayList arrayList3 = builder.namesAndValues;
                        zMatchesNormalizedQuery = StringExtKt.matchesNormalizedQuery(str, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
                    } else if (b == 1) {
                        Album album = (Album) localItem;
                        List list = album.artists;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        Iterator it4 = list.iterator();
                        while (it4.hasNext()) {
                            arrayList4.add(((ArtistEntity) it4.next()).name);
                        }
                        String[] strArr2 = (String[]) arrayList4.toArray(new String[0]);
                        Headers.Builder builder2 = new Headers.Builder(2);
                        builder2.add(album.album.title);
                        builder2.addSpread(strArr2);
                        ArrayList arrayList5 = builder2.namesAndValues;
                        zMatchesNormalizedQuery = StringExtKt.matchesNormalizedQuery(str, (String[]) arrayList5.toArray(new String[arrayList5.size()]));
                    } else if (b == 2) {
                        zMatchesNormalizedQuery = StringExtKt.matchesNormalizedQuery(str, ((Artist) localItem).artist.name);
                    } else {
                        if (b != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                        zMatchesNormalizedQuery = StringExtKt.matchesNormalizedQuery(str, ((Playlist) localItem).playlist.name);
                    }
                    if (zMatchesNormalizedQuery) {
                        arrayList.add(next);
                    }
                    it = it2;
                    z = z14;
                    z8 = z8;
                    playlist2 = playlist2;
                }
                playlist = playlist2;
                z3 = z8;
                z4 = z;
                if (StringsKt.isBlank(str)) {
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList6 = new ArrayList();
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj6 = arrayList.get(i5);
                        i5++;
                        if (hashSet.add(((LocalItem) obj6).getId())) {
                            arrayList6.add(obj6);
                        }
                    }
                    objRememberedValue13 = arrayList6;
                } else {
                    List listSortedWith2 = CollectionsKt.sortedWith(arrayList, new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0((byte) 2, new MainActivity$$ExternalSyntheticLambda0((byte) 16, collator2)));
                    HashSet hashSet2 = new HashSet();
                    ArrayList arrayList7 = new ArrayList();
                    for (Object obj7 : listSortedWith2) {
                        if (hashSet2.add(((LocalItem) obj7).getId())) {
                            arrayList7.add(obj7);
                        }
                    }
                    objRememberedValue13 = arrayList7;
                }
                gapComposer2.updateRememberedValue(objRememberedValue13);
            } else {
                playlist = playlist2;
                z3 = z8;
                z4 = z;
            }
            final List list2 = (List) objRememberedValue13;
            Object objRememberedValue14 = gapComposer2.rememberedValue();
            if (objRememberedValue14 == obj) {
                objRememberedValue14 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue14);
            }
            final CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue14;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer2);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer2);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop");
            if (stateFlow == null) {
                gapComposer2.startReplaceGroup(-2027778359);
                gapComposer2.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer2.startReplaceGroup(1181513784);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer2);
                gapComposer2.end(false);
            }
            Boolean bool2 = mutableStateCollectAsStateWithLifecycle != null ? (Boolean) mutableStateCollectAsStateWithLifecycle.getValue() : null;
            boolean zChanged6 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | ((i4 & 896) == 256) | gapComposer2.changed(lazyListStateRememberLazyListState) | gapComposer2.changed(lazyGridStateRememberLazyGridState) | gapComposer2.changed(mutableStateCurrentBackStackEntryAsState);
            Object objRememberedValue15 = gapComposer2.rememberedValue();
            if (zChanged6 || objRememberedValue15 == obj) {
                lazyListState = lazyListStateRememberLazyListState;
                lazyGridState = lazyGridStateRememberLazyGridState;
                objRememberedValue15 = new LibraryMixScreenKt$LibraryMixScreen$6$1(mutableStateCollectAsStateWithLifecycle, libraryViewType, lazyListState, lazyGridState, mutableStateCurrentBackStackEntryAsState, null, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue15);
            } else {
                lazyListState = lazyListStateRememberLazyListState;
                lazyGridState = lazyGridStateRememberLazyGridState;
            }
            Stack.LaunchedEffect(gapComposer2, bool2, (Function2) objRememberedValue15);
            boolean zChanged7 = gapComposer2.changed(zBooleanValue2) | gapComposer2.changedInstance(libraryMixViewModel3);
            Object objRememberedValue16 = gapComposer2.rememberedValue();
            if (zChanged7 || objRememberedValue16 == obj) {
                objRememberedValue16 = new Updater$checkForUpdate$2(zBooleanValue2, (Object) libraryMixViewModel3, (Continuation) null, (byte) 7);
                gapComposer2.updateRememberedValue(objRememberedValue16);
            }
            Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue16);
            final ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1121020815, new ChipKt$$ExternalSyntheticLambda1((ViewModel) libraryMixViewModel3, mutableState2, softwareKeyboardController, mutableStateCollectAsStateWithLifecycle6, (Enum) mixSortType, z4, (Function1) anonymousClass2, (Function1) mimesKt$$ExternalSyntheticLambda0, (Object) function1, (Object) libraryViewType, (byte) 4), gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle12 = FileSystemsKt.collectAsStateWithLifecycle(libraryMixViewModel3.isRefreshing, gapComposer2);
            PullToRefreshStateImpl pullToRefreshStateImplRememberPullToRefreshState = coil3.size.SizeKt.rememberPullToRefreshState(gapComposer2);
            FillElement fillElement2 = SizeKt.FillWholeMaxSize;
            boolean zBooleanValue8 = ((Boolean) mutableStateCollectAsStateWithLifecycle12.getValue()).booleanValue();
            boolean zChangedInstance = gapComposer2.changedInstance(libraryMixViewModel3);
            Object objRememberedValue17 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue17 == obj) {
                LibraryMixViewModel libraryMixViewModel6 = libraryMixViewModel3;
                z5 = zBooleanValue8;
                fillElement = fillElement2;
                artistScreenKt$ArtistScreen$4$2$1 = new ArtistScreenKt$ArtistScreen$4$2$1(0, libraryMixViewModel6, LibraryMixViewModel.class, "refresh", "refresh()V", 0, (byte) 23);
                libraryMixViewModel4 = libraryMixViewModel6;
                gapComposer2.updateRememberedValue(artistScreenKt$ArtistScreen$4$2$1);
            } else {
                libraryMixViewModel4 = libraryMixViewModel3;
                z5 = zBooleanValue8;
                artistScreenKt$ArtistScreen$4$2$1 = objRememberedValue17;
                fillElement = fillElement2;
            }
            Modifier modifierThen = fillElement.then(new PullToRefreshElement(z5, (Function0) ((KFunction) artistScreenKt$ArtistScreen$4$2$1), true, pullToRefreshStateImplRememberPullToRefreshState, PullToRefreshDefaults.PositionalThreshold));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
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
            int iOrdinal2 = libraryViewType.ordinal();
            if (iOrdinal2 == 0) {
                final boolean z15 = z7;
                Object obj8 = obj;
                pullToRefreshStateImplRememberPullToRefreshState = pullToRefreshStateImplRememberPullToRefreshState;
                final PlayerConnection playerConnection3 = playerConnection;
                final boolean z16 = z2;
                final boolean z17 = z3;
                final Playlist playlist7 = playlist;
                gapComposer2.startReplaceGroup(-1563856221);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(staticProvidableCompositionLocal3), gapComposer2);
                boolean zChanged8 = gapComposer2.changed(z15) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(playlist7) | gapComposer2.changed(z17) | gapComposer2.changed(playlist3) | gapComposer2.changed(z16) | gapComposer2.changed(playlist5) | gapComposer2.changed(z13) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle8) | gapComposer2.changed(playlist4) | gapComposer2.changed(z12) | gapComposer2.changed(playlist6) | gapComposer2.changedInstance(list2) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(coroutineScope3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changedInstance(playerConnection3) | gapComposer2.changed(strStringResource) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle6);
                GapComposer gapComposer9 = gapComposer2;
                Object objRememberedValue18 = gapComposer9.rememberedValue();
                if (zChanged8) {
                    obj3 = obj8;
                } else {
                    obj3 = obj8;
                    if (objRememberedValue18 != obj3) {
                        obj4 = obj3;
                        gapComposer3 = gapComposer9;
                    }
                    IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue18, gapComposer3, 0, 505);
                    gapComposer3.end(false);
                    staticProvidableCompositionLocal = staticProvidableCompositionLocal3;
                    gapComposer4 = gapComposer3;
                }
                final byte b5 = 1;
                obj4 = obj3;
                objRememberedValue18 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj9) {
                        byte b6 = b5;
                        MutableState mutableState4 = mutableStateCollectAsStateWithLifecycle6;
                        final Playlist playlist8 = playlist6;
                        final Playlist playlist9 = playlist4;
                        final MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle8;
                        final Playlist playlist10 = playlist5;
                        final Playlist playlist11 = playlist3;
                        final Playlist playlist12 = playlist7;
                        ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda;
                        ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl;
                        boolean z18 = z12;
                        boolean z19 = z13;
                        boolean z20 = z16;
                        boolean z21 = z17;
                        boolean z22 = z15;
                        switch (b6) {
                            case 0:
                                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj9;
                                lazyGridIntervalContent.getClass();
                                lazyGridIntervalContent.item("filter", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 5), 0, new ComposableLambdaImpl(true, -1311929905, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 16)));
                                lazyGridIntervalContent.item("header", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 9), 0, new ComposableLambdaImpl(true, -1642035976, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 17)));
                                final NavHostController navHostController2 = navHostController;
                                if (z22) {
                                    final byte b7 = 5;
                                    LazyGridIntervalContent.item$default(lazyGridIntervalContent, "likedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 27), new ComposableLambdaImpl(true, 1969182548, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b8 = b7;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController3 = navHostController2;
                                            switch (b8) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController3);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController3, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController3);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController3);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController3);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController3);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController3);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController3);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController3);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                }
                                if (z21) {
                                    final byte b8 = 6;
                                    LazyGridIntervalContent.item$default(lazyGridIntervalContent, "downloadedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 28), new ComposableLambdaImpl(true, -998963907, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b9 = b8;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController3 = navHostController2;
                                            switch (b9) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController3);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController3, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController3);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController3);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController3);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController3);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController3);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController3);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController3);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                }
                                if (z20) {
                                    final byte b9 = 7;
                                    LazyGridIntervalContent.item$default(lazyGridIntervalContent, "cachedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 29), new ComposableLambdaImpl(true, -285765988, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b10 = b9;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController3 = navHostController2;
                                            switch (b10) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController3);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController3, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController3);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController3);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController3);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController3);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController3);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController3);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController3);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                }
                                if (z19) {
                                    final byte b10 = 1;
                                    LazyGridIntervalContent.item$default(lazyGridIntervalContent, "TopPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 25), new ComposableLambdaImpl(true, 427431931, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda25
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b11 = b10;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            MutableState mutableState6 = mutableState5;
                                            NavHostController navHostController3 = navHostController2;
                                            switch (b11) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(1 & iIntValue, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController3) | gapComposer10.changed(mutableState6);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController3, mutableState6, (byte) 4);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController3) | gapComposer11.changed(mutableState6);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController3, mutableState6, (byte) 3);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer11, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                }
                                if (z18) {
                                    final byte b11 = 4;
                                    LazyGridIntervalContent.item$default(lazyGridIntervalContent, "uploadedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 26), new ComposableLambdaImpl(true, 1140629850, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b12 = b11;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController3 = navHostController2;
                                            switch (b12) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController3);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController3, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController3);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController3);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController3);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController3);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController3);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController3);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController3);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }), 2);
                                }
                                LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 6);
                                LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda6 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 7);
                                List list3 = list2;
                                lazyGridIntervalContent.items(list3.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list3, (byte) 18), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda6, list3, (byte) 19), new ComposableLambdaImpl(true, -1117249557, new HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(list3, hapticFeedback, menuState, coroutineScope3, navHostController2, mutableStateCollectAsStateWithLifecycle3, playerConnection3, list3, strStringResource, mutableStateCollectAsStateWithLifecycle2, (byte) 2)));
                                if (list3.isEmpty() && !z22 && !z21 && !z20 && !z19 && !z18 && !StringsKt.isBlank((String) mutableState4.getValue())) {
                                    LazyGridIntervalContent.item$default(lazyGridIntervalContent, "empty_search_result", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 8), null, LibraryScreenKt.lambda$1853827769, 4);
                                }
                                break;
                            default:
                                final byte b12 = 0;
                                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj9;
                                lazyListIntervalContent.getClass();
                                final byte b13 = 1;
                                lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, 985156206, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 14)));
                                lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, -1159301147, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 15)));
                                final NavHostController navHostController3 = navHostController;
                                if (z22) {
                                    lazyListIntervalContent.item("likedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 21), new ComposableLambdaImpl(true, 1298372873, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b14 = b13;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController4 = navHostController3;
                                            switch (b14) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController4);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController4);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController4);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController4);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController4);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController4);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController4);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController4);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }));
                                }
                                final byte b14 = 2;
                                if (z21) {
                                    lazyListIntervalContent.item("downloadedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 22), new ComposableLambdaImpl(true, -805794880, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b15 = b14;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController4 = navHostController3;
                                            switch (b15) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController4);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController4);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController4);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController4);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController4);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController4);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController4);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController4);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }));
                                }
                                final byte b15 = 3;
                                if (z20) {
                                    lazyListIntervalContent.item("cachedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 23), new ComposableLambdaImpl(true, 1742154625, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b16 = b15;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController4 = navHostController3;
                                            switch (b16) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController4);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController4);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController4);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController4);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController4);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController4);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController4);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController4);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }));
                                }
                                if (z19) {
                                    lazyListIntervalContent.item("TopPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 24), new ComposableLambdaImpl(true, -4863166, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda25
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b16 = b12;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            MutableState mutableState6 = mutableState5;
                                            NavHostController navHostController4 = navHostController3;
                                            switch (b16) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(1 & iIntValue, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController4) | gapComposer10.changed(mutableState6);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController4, mutableState6, (byte) 4);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController4) | gapComposer11.changed(mutableState6);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController4, mutableState6, (byte) 3);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer11, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }));
                                }
                                if (z18) {
                                    final byte b16 = 0;
                                    lazyListIntervalContent.item("uploadedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 20), new ComposableLambdaImpl(true, -1751880957, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                            byte b17 = b16;
                                            Unit unit = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            NavHostController navHostController4 = navHostController3;
                                            switch (b17) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                    Composer composer2 = (Composer) obj11;
                                                    int iIntValue = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl.getClass();
                                                    if ((iIntValue & 6) == 0) {
                                                        iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer10 = (GapComposer) composer2;
                                                    if (!gapComposer10.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                        gapComposer10.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance2 = gapComposer10.changedInstance(navHostController4);
                                                        Object objRememberedValue19 = gapComposer10.rememberedValue();
                                                        if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy) {
                                                            objRememberedValue19 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                            gapComposer10.updateRememberedValue(objRememberedValue19);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer10, 384, 24);
                                                    }
                                                    break;
                                                case 1:
                                                    LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                    Composer composer3 = (Composer) obj11;
                                                    int iIntValue2 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl2.getClass();
                                                    if ((iIntValue2 & 6) == 0) {
                                                        iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer11 = (GapComposer) composer3;
                                                    if (!gapComposer11.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                        gapComposer11.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance3 = gapComposer11.changedInstance(navHostController4);
                                                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                                                        if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                            objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                            gapComposer11.updateRememberedValue(objRememberedValue20);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer11, 384, 24);
                                                    }
                                                    break;
                                                case 2:
                                                    LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                    Composer composer4 = (Composer) obj11;
                                                    int iIntValue3 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl3.getClass();
                                                    if ((iIntValue3 & 6) == 0) {
                                                        iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer12 = (GapComposer) composer4;
                                                    if (!gapComposer12.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                        gapComposer12.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance4 = gapComposer12.changedInstance(navHostController4);
                                                        Object objRememberedValue21 = gapComposer12.rememberedValue();
                                                        if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                            objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                            gapComposer12.updateRememberedValue(objRememberedValue21);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer12, 384, 24);
                                                    }
                                                    break;
                                                case 3:
                                                    LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                    Composer composer5 = (Composer) obj11;
                                                    int iIntValue4 = ((Integer) obj12).intValue();
                                                    lazyItemScopeImpl4.getClass();
                                                    if ((iIntValue4 & 6) == 0) {
                                                        iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer13 = (GapComposer) composer5;
                                                    if (!gapComposer13.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                        gapComposer13.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance5 = gapComposer13.changedInstance(navHostController4);
                                                        Object objRememberedValue22 = gapComposer13.rememberedValue();
                                                        if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                            objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                            gapComposer13.updateRememberedValue(objRememberedValue22);
                                                        }
                                                        MenuKt.PlaylistListItem(playlist8, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer13, 384, 24);
                                                    }
                                                    break;
                                                case 4:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer6 = (Composer) obj11;
                                                    int iIntValue5 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl.getClass();
                                                    if ((iIntValue5 & 6) == 0) {
                                                        iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer14 = (GapComposer) composer6;
                                                    if (!gapComposer14.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                        gapComposer14.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance6 = gapComposer14.changedInstance(navHostController4);
                                                        Object objRememberedValue23 = gapComposer14.rememberedValue();
                                                        if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                            objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                            gapComposer14.updateRememberedValue(objRememberedValue23);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer14, 24960, 8);
                                                    }
                                                    break;
                                                case 5:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer7 = (Composer) obj11;
                                                    int iIntValue6 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl2.getClass();
                                                    if ((iIntValue6 & 6) == 0) {
                                                        iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer15 = (GapComposer) composer7;
                                                    if (!gapComposer15.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                        gapComposer15.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance7 = gapComposer15.changedInstance(navHostController4);
                                                        Object objRememberedValue24 = gapComposer15.rememberedValue();
                                                        if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                            objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                            gapComposer15.updateRememberedValue(objRememberedValue24);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer15, 24960, 8);
                                                    }
                                                    break;
                                                case 6:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer8 = (Composer) obj11;
                                                    int iIntValue7 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl3.getClass();
                                                    if ((iIntValue7 & 6) == 0) {
                                                        iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer16 = (GapComposer) composer8;
                                                    if (!gapComposer16.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                        gapComposer16.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance8 = gapComposer16.changedInstance(navHostController4);
                                                        Object objRememberedValue25 = gapComposer16.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                            objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                            gapComposer16.updateRememberedValue(objRememberedValue25);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer16, 24960, 8);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                    Composer composer9 = (Composer) obj11;
                                                    int iIntValue8 = ((Integer) obj12).intValue();
                                                    lazyGridItemScopeImpl4.getClass();
                                                    if ((iIntValue8 & 6) == 0) {
                                                        iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                    }
                                                    GapComposer gapComposer17 = (GapComposer) composer9;
                                                    if (!gapComposer17.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                        gapComposer17.skipToGroupEnd();
                                                    } else {
                                                        Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                        boolean zChangedInstance9 = gapComposer17.changedInstance(navHostController4);
                                                        Object objRememberedValue26 = gapComposer17.rememberedValue();
                                                        if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                            objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                            gapComposer17.updateRememberedValue(objRememberedValue26);
                                                        }
                                                        MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer17, 24960, 8);
                                                    }
                                                    break;
                                            }
                                            return unit;
                                        }
                                    }));
                                }
                                LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda7 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 3);
                                LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda8 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 4);
                                List list4 = list2;
                                lazyListIntervalContent.items(list4.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda7, list4, (byte) 16), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda8, list4, (byte) 17), new ComposableLambdaImpl(true, 802480018, new HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(list4, hapticFeedback, menuState, coroutineScope3, navHostController3, mutableStateCollectAsStateWithLifecycle3, playerConnection3, list4, strStringResource, mutableStateCollectAsStateWithLifecycle2, (byte) 1)));
                                if (list4.isEmpty() && !z22 && !z21 && !z20 && !z19 && !z18 && !StringsKt.isBlank((String) mutableState4.getValue())) {
                                    LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_search_result", null, LibraryScreenKt.lambda$796068548, 2);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
                GapComposer gapComposer10 = gapComposer9;
                gapComposer10.updateRememberedValue(objRememberedValue18);
                gapComposer3 = gapComposer10;
                IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue18, gapComposer3, 0, 505);
                gapComposer3.end(false);
                staticProvidableCompositionLocal = staticProvidableCompositionLocal3;
                gapComposer4 = gapComposer3;
            } else {
                if (iOrdinal2 != 1) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 2027775860, false);
                }
                gapComposer2.startReplaceGroup(-1546840910);
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                GridCells$Adaptive gridCells$Adaptive = new GridCells$Adaptive(128.0f + (((GridItemSize) ((Enum) libraryMixScreenKt$LibraryMixScreen$$inlined$rememberEnumPreference$4.$state.getValue())) == gridItemSize ? 24.0f : -24.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues((WindowInsets) gapComposer2.consume(staticProvidableCompositionLocal4), gapComposer2);
                final Playlist playlist8 = playlist;
                final boolean z18 = z3;
                boolean zChanged9 = gapComposer2.changed(z7) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(playlist8) | gapComposer2.changed(z18) | gapComposer2.changed(playlist3) | gapComposer2.changed(z2) | gapComposer2.changed(playlist5) | gapComposer2.changed(z13) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle8) | gapComposer2.changed(playlist4) | gapComposer2.changed(z12) | gapComposer2.changed(playlist6) | gapComposer2.changedInstance(list2) | gapComposer2.changedInstance(hapticFeedback) | gapComposer2.changed(menuState) | gapComposer2.changedInstance(coroutineScope3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changed(strStringResource) | gapComposer2.changed(mutableStateCollectAsStateWithLifecycle6);
                GapComposer gapComposer11 = gapComposer2;
                Object objRememberedValue19 = gapComposer11.rememberedValue();
                if (zChanged9 || objRememberedValue19 == obj) {
                    final byte b6 = 0;
                    final boolean z19 = z7;
                    final PlayerConnection playerConnection4 = playerConnection;
                    final boolean z20 = z2;
                    objRememberedValue19 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj9) {
                            byte b7 = b6;
                            MutableState mutableState4 = mutableStateCollectAsStateWithLifecycle6;
                            final Playlist playlist9 = playlist6;
                            final Playlist playlist10 = playlist4;
                            final MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle8;
                            final Playlist playlist11 = playlist5;
                            final Playlist playlist12 = playlist3;
                            final Playlist playlist13 = playlist8;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl;
                            boolean z110 = z12;
                            boolean z111 = z13;
                            boolean z21 = z20;
                            boolean z22 = z18;
                            boolean z23 = z19;
                            switch (b7) {
                                case 0:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj9;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 5), 0, new ComposableLambdaImpl(true, -1311929905, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 16)));
                                    lazyGridIntervalContent.item("header", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 9), 0, new ComposableLambdaImpl(true, -1642035976, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 17)));
                                    final NavHostController navHostController2 = navHostController;
                                    if (z23) {
                                        final byte b8 = 5;
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, "likedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 27), new ComposableLambdaImpl(true, 1969182548, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b8;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController2;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }), 2);
                                    }
                                    if (z22) {
                                        final byte b9 = 6;
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, "downloadedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 28), new ComposableLambdaImpl(true, -998963907, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b9;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController2;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }), 2);
                                    }
                                    if (z21) {
                                        final byte b10 = 7;
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, "cachedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 29), new ComposableLambdaImpl(true, -285765988, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b10;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController2;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }), 2);
                                    }
                                    if (z111) {
                                        final byte b11 = 1;
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, "TopPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 25), new ComposableLambdaImpl(true, 427431931, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda25
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b16 = b11;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                MutableState mutableState6 = mutableState5;
                                                NavHostController navHostController4 = navHostController2;
                                                switch (b16) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(1 & iIntValue, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4) | gapComposer12.changed(mutableState6);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController4, mutableState6, (byte) 4);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4) | gapComposer13.changed(mutableState6);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController4, mutableState6, (byte) 3);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer13, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }), 2);
                                    }
                                    if (z110) {
                                        final byte b12 = 4;
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, "uploadedPlaylist", null, new LoginScreenKt$$ExternalSyntheticLambda4((byte) 26), new ComposableLambdaImpl(true, 1140629850, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b12;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController2;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 6);
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda6 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 7);
                                    List list3 = list2;
                                    lazyGridIntervalContent.items(list3.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list3, (byte) 18), null, new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda6, list3, (byte) 19), new ComposableLambdaImpl(true, -1117249557, new HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(list3, hapticFeedback, menuState, coroutineScope3, navHostController2, mutableStateCollectAsStateWithLifecycle3, playerConnection4, list3, strStringResource, mutableStateCollectAsStateWithLifecycle2, (byte) 2)));
                                    if (list3.isEmpty() && !z23 && !z22 && !z21 && !z111 && !z110 && !StringsKt.isBlank((String) mutableState4.getValue())) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, "empty_search_result", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 8), null, LibraryScreenKt.lambda$1853827769, 4);
                                    }
                                    break;
                                default:
                                    final byte b13 = 0;
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj9;
                                    lazyListIntervalContent.getClass();
                                    final byte b14 = 1;
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, 985156206, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 14)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, -1159301147, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 15)));
                                    final NavHostController navHostController3 = navHostController;
                                    if (z23) {
                                        lazyListIntervalContent.item("likedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 21), new ComposableLambdaImpl(true, 1298372873, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b14;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController3;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist13, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist13, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }));
                                    }
                                    final byte b15 = 2;
                                    if (z22) {
                                        lazyListIntervalContent.item("downloadedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 22), new ComposableLambdaImpl(true, -805794880, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b15;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController3;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist12, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist12, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }));
                                    }
                                    final byte b16 = 3;
                                    if (z21) {
                                        lazyListIntervalContent.item("cachedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 23), new ComposableLambdaImpl(true, 1742154625, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b16;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController3;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist11, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist11, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }));
                                    }
                                    if (z111) {
                                        lazyListIntervalContent.item("TopPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 24), new ComposableLambdaImpl(true, -4863166, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda25
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b17 = b13;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                MutableState mutableState6 = mutableState5;
                                                NavHostController navHostController4 = navHostController3;
                                                switch (b17) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(1 & iIntValue, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4) | gapComposer12.changed(mutableState6);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController4, mutableState6, (byte) 4);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist10, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4) | gapComposer13.changed(mutableState6);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController4, mutableState6, (byte) 3);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist10, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer13, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }));
                                    }
                                    if (z110) {
                                        final byte b17 = 0;
                                        lazyListIntervalContent.item("uploadedPlaylist", new LoginScreenKt$$ExternalSyntheticLambda4((byte) 20), new ComposableLambdaImpl(true, -1751880957, new Function3() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj10, Object obj11, Object obj12) {
                                                byte b18 = b17;
                                                Unit unit = Unit.INSTANCE;
                                                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                                NavHostController navHostController4 = navHostController3;
                                                switch (b18) {
                                                    case 0:
                                                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj10;
                                                        Composer composer2 = (Composer) obj11;
                                                        int iIntValue = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl.getClass();
                                                        if ((iIntValue & 6) == 0) {
                                                            iIntValue |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer12 = (GapComposer) composer2;
                                                        if (!gapComposer12.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                                                            gapComposer12.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance2 = gapComposer12.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer12.rememberedValue();
                                                            if (zChangedInstance2 || objRememberedValue110 == neverEqualPolicy) {
                                                                objRememberedValue110 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController4, (byte) 1);
                                                                gapComposer12.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer12, 384, 24);
                                                        }
                                                        break;
                                                    case 1:
                                                        LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj10;
                                                        Composer composer3 = (Composer) obj11;
                                                        int iIntValue2 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl2.getClass();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= ((GapComposer) composer3).changed(lazyItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer13 = (GapComposer) composer3;
                                                        if (!gapComposer13.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            gapComposer13.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance3 = gapComposer13.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer13.rememberedValue();
                                                            if (zChangedInstance3 || objRememberedValue20 == neverEqualPolicy) {
                                                                objRememberedValue20 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 23);
                                                                gapComposer13.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 15)), true, null, null, gapComposer13, 384, 24);
                                                        }
                                                        break;
                                                    case 2:
                                                        LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj10;
                                                        Composer composer4 = (Composer) obj11;
                                                        int iIntValue3 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl3.getClass();
                                                        if ((iIntValue3 & 6) == 0) {
                                                            iIntValue3 |= ((GapComposer) composer4).changed(lazyItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer14 = (GapComposer) composer4;
                                                        if (!gapComposer14.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                                                            gapComposer14.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance4 = gapComposer14.changedInstance(navHostController4);
                                                            Object objRememberedValue21 = gapComposer14.rememberedValue();
                                                            if (zChangedInstance4 || objRememberedValue21 == neverEqualPolicy) {
                                                                objRememberedValue21 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 25);
                                                                gapComposer14.updateRememberedValue(objRememberedValue21);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth3, false, null, (Function0) objRememberedValue21, 15)), true, null, null, gapComposer14, 384, 24);
                                                        }
                                                        break;
                                                    case 3:
                                                        LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj10;
                                                        Composer composer5 = (Composer) obj11;
                                                        int iIntValue4 = ((Integer) obj12).intValue();
                                                        lazyItemScopeImpl4.getClass();
                                                        if ((iIntValue4 & 6) == 0) {
                                                            iIntValue4 |= ((GapComposer) composer5).changed(lazyItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer15 = (GapComposer) composer5;
                                                        if (!gapComposer15.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                                                            gapComposer15.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance5 = gapComposer15.changedInstance(navHostController4);
                                                            Object objRememberedValue22 = gapComposer15.rememberedValue();
                                                            if (zChangedInstance5 || objRememberedValue22 == neverEqualPolicy) {
                                                                objRememberedValue22 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 28);
                                                                gapComposer15.updateRememberedValue(objRememberedValue22);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl4, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth4, false, null, (Function0) objRememberedValue22, 15)), true, null, null, gapComposer15, 384, 24);
                                                        }
                                                        break;
                                                    case 4:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer6 = (Composer) obj11;
                                                        int iIntValue5 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl.getClass();
                                                        if ((iIntValue5 & 6) == 0) {
                                                            iIntValue5 |= ((GapComposer) composer6).changed(lazyGridItemScopeImpl) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer16 = (GapComposer) composer6;
                                                        if (!gapComposer16.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                                                            gapComposer16.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth5 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance6 = gapComposer16.changedInstance(navHostController4);
                                                            Object objRememberedValue23 = gapComposer16.rememberedValue();
                                                            if (zChangedInstance6 || objRememberedValue23 == neverEqualPolicy) {
                                                                objRememberedValue23 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 24);
                                                                gapComposer16.updateRememberedValue(objRememberedValue23);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth5, false, null, (Function0) objRememberedValue23, 15)), true, null, true, gapComposer16, 24960, 8);
                                                        }
                                                        break;
                                                    case 5:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl2 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer7 = (Composer) obj11;
                                                        int iIntValue6 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl2.getClass();
                                                        if ((iIntValue6 & 6) == 0) {
                                                            iIntValue6 |= ((GapComposer) composer7).changed(lazyGridItemScopeImpl2) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer17 = (GapComposer) composer7;
                                                        if (!gapComposer17.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                                                            gapComposer17.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth6 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance7 = gapComposer17.changedInstance(navHostController4);
                                                            Object objRememberedValue24 = gapComposer17.rememberedValue();
                                                            if (zChangedInstance7 || objRememberedValue24 == neverEqualPolicy) {
                                                                objRememberedValue24 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 26);
                                                                gapComposer17.updateRememberedValue(objRememberedValue24);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl2, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth6, false, null, (Function0) objRememberedValue24, 255)), true, null, true, gapComposer17, 24960, 8);
                                                        }
                                                        break;
                                                    case 6:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl3 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer8 = (Composer) obj11;
                                                        int iIntValue7 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl3.getClass();
                                                        if ((iIntValue7 & 6) == 0) {
                                                            iIntValue7 |= ((GapComposer) composer8).changed(lazyGridItemScopeImpl3) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer18 = (GapComposer) composer8;
                                                        if (!gapComposer18.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                                                            gapComposer18.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth7 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance8 = gapComposer18.changedInstance(navHostController4);
                                                            Object objRememberedValue25 = gapComposer18.rememberedValue();
                                                            if (zChangedInstance8 || objRememberedValue25 == neverEqualPolicy) {
                                                                objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 29);
                                                                gapComposer18.updateRememberedValue(objRememberedValue25);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth7, false, null, (Function0) objRememberedValue25, 255)), true, null, true, gapComposer18, 24960, 8);
                                                        }
                                                        break;
                                                    default:
                                                        LazyGridItemScopeImpl lazyGridItemScopeImpl4 = (LazyGridItemScopeImpl) obj10;
                                                        Composer composer9 = (Composer) obj11;
                                                        int iIntValue8 = ((Integer) obj12).intValue();
                                                        lazyGridItemScopeImpl4.getClass();
                                                        if ((iIntValue8 & 6) == 0) {
                                                            iIntValue8 |= ((GapComposer) composer9).changed(lazyGridItemScopeImpl4) ? 4 : 2;
                                                        }
                                                        GapComposer gapComposer19 = (GapComposer) composer9;
                                                        if (!gapComposer19.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                                                            gapComposer19.skipToGroupEnd();
                                                        } else {
                                                            Modifier modifierFillMaxWidth8 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChangedInstance9 = gapComposer19.changedInstance(navHostController4);
                                                            Object objRememberedValue26 = gapComposer19.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue26 == neverEqualPolicy) {
                                                                objRememberedValue26 = new MainActivity$$ExternalSyntheticLambda2(navHostController4, (byte) 27);
                                                                gapComposer19.updateRememberedValue(objRememberedValue26);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist9, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl4, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth8, false, null, (Function0) objRememberedValue26, 255)), true, null, true, gapComposer19, 24960, 8);
                                                        }
                                                        break;
                                                }
                                                return unit;
                                            }
                                        }));
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda7 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 3);
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda8 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 4);
                                    List list4 = list2;
                                    lazyListIntervalContent.items(list4.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda7, list4, (byte) 16), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda8, list4, (byte) 17), new ComposableLambdaImpl(true, 802480018, new HistoryScreenKt$HistoryScreen$lambda$28$0$0$2$$inlined$itemsIndexed$3(list4, hapticFeedback, menuState, coroutineScope3, navHostController3, mutableStateCollectAsStateWithLifecycle3, playerConnection4, list4, strStringResource, mutableStateCollectAsStateWithLifecycle2, (byte) 1)));
                                    if (list4.isEmpty() && !z23 && !z22 && !z21 && !z111 && !z110 && !StringsKt.isBlank((String) mutableState4.getValue())) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_search_result", null, LibraryScreenKt.lambda$796068548, 2);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    GapComposer gapComposer12 = gapComposer11;
                    gapComposer12.updateRememberedValue(objRememberedValue19);
                    gapComposer5 = gapComposer12;
                } else {
                    gapComposer5 = gapComposer11;
                }
                GapComposer gapComposer13 = gapComposer5;
                LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive, null, lazyGridState, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, null, (Function1) objRememberedValue19, gapComposer13, 0, 2034);
                gapComposer13.end(false);
                gapComposer4 = gapComposer13;
                staticProvidableCompositionLocal = staticProvidableCompositionLocal4;
                obj4 = obj;
            }
            MutableState mutableState4 = mutableState;
            boolean zChanged10 = gapComposer4.changed(mutableState4);
            Object objRememberedValue20 = gapComposer4.rememberedValue();
            if (zChanged10 || objRememberedValue20 == obj4) {
                objRememberedValue20 = new PlayerKt$$ExternalSyntheticLambda7(mutableState4, (byte) 25);
                gapComposer4.updateRememberedValue(objRememberedValue20);
            }
            Function0 function2 = (Function0) objRememberedValue20;
            BiasAlignment biasAlignment = Alignment.Companion.BottomEnd;
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            CardKt.m259FloatingActionButtonXz6DiA(function2, OffsetKt.m135padding3ABfNKs(OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, biasAlignment), new LimitInsets((WindowInsets) gapComposer4.consume(staticProvidableCompositionLocal), 47)), 16.0f), null, 0L, 0L, null, lambda$119083619, gapComposer4, 12582912, 124);
            PullToRefreshDefaults.INSTANCE.m378Indicator2poqoh4(pullToRefreshStateImplRememberPullToRefreshState, ((Boolean) mutableStateCollectAsStateWithLifecycle12.getValue()).booleanValue(), OffsetKt.padding(boxScopeInstance.align(companion, Alignment.Companion.TopCenter), OffsetKt.asPaddingValues((WindowInsets) gapComposer4.consume(staticProvidableCompositionLocal), gapComposer4)), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer4, 1572864);
            gapComposer4.end(true);
            libraryMixViewModel2 = libraryMixViewModel4;
            gapComposer = gapComposer4;
        } else {
            GapComposer gapComposer14 = gapComposer6;
            gapComposer14.skipToGroupEnd();
            libraryMixViewModel2 = libraryMixViewModel;
            gapComposer = gapComposer14;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b7 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController, composableLambdaImpl, libraryViewType, function1, libraryMixViewModel2, i, b7) { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ ComposableLambdaImpl f$1;
                public final /* synthetic */ LibraryViewType f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ LibraryMixViewModel f$4;

                {
                    this.$r8$classId = b7;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj9, Object obj10) {
                    byte b8 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    switch (b8) {
                        case 0:
                            ((Integer) obj10).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(49);
                            LibraryScreenKt.LibraryMixScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj9, iUpdateChangedFlags);
                            break;
                        default:
                            ((Integer) obj10).getClass();
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(49);
                            LibraryScreenKt.LibraryMixScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Composer) obj9, iUpdateChangedFlags2);
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void LibraryPlaylistsScreen(final NavHostController navHostController, final ComposableLambdaImpl composableLambdaImpl, LibraryViewType libraryViewType, Function1 function1, LibraryPlaylistsViewModel libraryPlaylistsViewModel, boolean z, Composer composer, int i) {
        boolean z2;
        LibraryPlaylistsViewModel libraryPlaylistsViewModel2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        MutableState mutableStateCollectAsStateWithLifecycle;
        Boolean bool;
        LazyListState lazyListState;
        LazyGridState lazyGridState;
        NeverEqualPolicy neverEqualPolicy;
        int i3;
        boolean z6;
        MutableState mutableState;
        NeverEqualPolicy neverEqualPolicy2;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        boolean z7;
        Object obj;
        MutableState mutableState2;
        SavedStateHandle savedStateHandle;
        navHostController.getClass();
        libraryViewType.getClass();
        function1.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1998928803);
        int i4 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | (gapComposer.changed(libraryViewType.ordinal()) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | 1777664;
        if (gapComposer.shouldExecute(i4 & 1, (599187 & i4) != 599186)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    libraryPlaylistsViewModel2 = (LibraryPlaylistsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LibraryPlaylistsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
                    i2 = i4 & (-57345);
                    z3 = true;
                }
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i4 & (-57345);
                libraryPlaylistsViewModel2 = libraryPlaylistsViewModel;
                z3 = z;
            }
            gapComposer.endDefaults();
            final MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy3) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Preferences$Key preferences$Key = PreferenceKeysKt.PlaylistSortTypeKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer.consume(staticProvidableCompositionLocal2);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy3) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy3) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 10));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, PlaylistSortType.CREATE_DATE, gapComposer, 48);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy3) {
                objRememberedValue4 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle2, coroutineScope2, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2) objRememberedValue4;
            PlaylistSortType playlistSortType = (PlaylistSortType) libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$2, (byte) 18);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.PlaylistSortDescendingKey, Boolean.TRUE, gapComposer, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.GridItemsSizeKey;
            Context context2 = (Context) gapComposer.consume(staticProvidableCompositionLocal2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy3) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue5;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy3) {
                objRememberedValue6 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key2, (byte) 11));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue6, gridItemSize, gapComposer, 48);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy3) {
                objRememberedValue7 = new LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle3, coroutineScope3, context2, preferences$Key2);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4 libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4 = (LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4) objRememberedValue7;
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(libraryPlaylistsViewModel2.allPlaylists, gapComposer);
            Object[] objArr = new Object[0];
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy3) {
                objRememberedValue8 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue8, gapComposer, 48);
            final MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(libraryPlaylistsViewModel2.searchQuery, gapComposer);
            boolean zChanged = gapComposer.changed((String) mutableStateCollectAsStateWithLifecycle5.getValue());
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue9 == neverEqualPolicy3) {
                objRememberedValue9 = StringExtKt.normalizeForSearch((String) mutableStateCollectAsStateWithLifecycle5.getValue());
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            String str = (String) objRememberedValue9;
            boolean zChanged2 = gapComposer.changed((List) mutableStateCollectAsStateWithLifecycle4.getValue()) | gapComposer.changed(str);
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue10 == neverEqualPolicy3) {
                if (StringsKt.isBlank(str)) {
                    objRememberedValue10 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                } else {
                    List list = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Iterator it2 = it;
                        if (StringExtKt.matchesNormalizedQuery(str, ((Playlist) next).playlist.name)) {
                            arrayList.add(next);
                        }
                        it = it2;
                    }
                    objRememberedValue10 = arrayList;
                }
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            List list2 = (List) objRememberedValue10;
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(libraryPlaylistsViewModel2.topValue, 50, gapComposer, 48);
            String string = UUID.randomUUID().toString();
            string.getClass();
            String strStringResource = MathKt.stringResource(R.string.liked, gapComposer);
            PlaylistEntity playlistEntity = new PlaylistEntity(string, strStringResource, null, null, false, null, null, null, null, null, null, 16380);
            EmptyList emptyList = EmptyList.INSTANCE;
            boolean z8 = z3;
            Playlist playlist = new Playlist(playlistEntity, 0, emptyList);
            String string2 = UUID.randomUUID().toString();
            string2.getClass();
            String strStringResource2 = MathKt.stringResource(R.string.offline, gapComposer);
            Playlist playlist2 = new Playlist(new PlaylistEntity(string2, strStringResource2, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            String string3 = UUID.randomUUID().toString();
            string3.getClass();
            String str2 = MathKt.stringResource(R.string.my_top, gapComposer) + ServerSentEventKt.SPACE + mutableStateCollectAsStateWithLifecycle6.getValue();
            Playlist playlist3 = new Playlist(new PlaylistEntity(string3, str2, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            String string4 = UUID.randomUUID().toString();
            string4.getClass();
            String strStringResource3 = MathKt.stringResource(R.string.uploaded_playlist, gapComposer);
            Playlist playlist4 = new Playlist(new PlaylistEntity(string4, strStringResource3, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            String string5 = UUID.randomUUID().toString();
            string5.getClass();
            String strStringResource4 = MathKt.stringResource(R.string.cached_playlist, gapComposer);
            Playlist playlist5 = new Playlist(new PlaylistEntity(string5, strStringResource4, null, null, false, null, null, null, null, null, null, 16380), 0, emptyList);
            Preferences$Key preferences$Key3 = PreferenceKeysKt.ShowLikedPlaylistKey;
            Boolean bool2 = Boolean.TRUE;
            boolean zBooleanValue2 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key3, bool2, gapComposer, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue3 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowDownloadedPlaylistKey, bool2, gapComposer, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue4 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowTopPlaylistKey, bool2, gapComposer, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue5 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowUploadedPlaylistKey, bool2, gapComposer, 48).$state.getValue()).booleanValue();
            boolean zBooleanValue6 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.ShowCachedPlaylistKey, bool2, gapComposer, 48).$state.getValue()).booleanValue();
            boolean z9 = zBooleanValue2 && StringExtKt.matchesNormalizedQuery(str, strStringResource);
            boolean z10 = zBooleanValue3 && StringExtKt.matchesNormalizedQuery(str, strStringResource2);
            boolean z11 = zBooleanValue6 && StringExtKt.matchesNormalizedQuery(str, strStringResource4);
            boolean z12 = zBooleanValue4 && StringExtKt.matchesNormalizedQuery(str, str2);
            int i5 = i2;
            boolean z13 = zBooleanValue5 && StringExtKt.matchesNormalizedQuery(str, strStringResource3);
            boolean zChanged3 = gapComposer.changed(list2) | gapComposer.changed(z9) | gapComposer.changed(z10) | gapComposer.changed(z11) | gapComposer.changed(z12) | gapComposer.changed(z13) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle6.getValue());
            boolean z14 = z13;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            boolean z15 = z11;
            if (zChanged3 || objRememberedValue11 == neverEqualPolicy3) {
                ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                if (z9) {
                    z4 = true;
                    listBuilderCreateListBuilder.add(new VisiblePlaylistItem("likedPlaylist", playlist, true, "auto_playlist/liked"));
                } else {
                    z4 = true;
                }
                if (z10) {
                    listBuilderCreateListBuilder.add(new VisiblePlaylistItem("downloadedPlaylist", playlist2, z4, "auto_playlist/downloaded"));
                }
                if (z15) {
                    listBuilderCreateListBuilder.add(new VisiblePlaylistItem("cachedPlaylist", playlist5, z4, "cache_playlist/cached"));
                }
                if (z12) {
                    z5 = true;
                    listBuilderCreateListBuilder.add(new VisiblePlaylistItem("TopPlaylist", playlist3, true, "top_playlist/" + mutableStateCollectAsStateWithLifecycle6.getValue()));
                } else {
                    z5 = true;
                }
                if (z14) {
                    listBuilderCreateListBuilder.add(new VisiblePlaylistItem("uploadedPlaylist", playlist4, z5, "auto_playlist/uploaded"));
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    if (hashSet.add(((Playlist) obj2).playlist.id)) {
                        arrayList2.add(obj2);
                    }
                }
                int size = arrayList2.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj3 = arrayList2.get(i6);
                    i6++;
                    Playlist playlist6 = (Playlist) obj3;
                    listBuilderCreateListBuilder.add(new VisiblePlaylistItem(playlist6.playlist.id, playlist6, false, null));
                }
                objRememberedValue11 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            final List list3 = (List) objRememberedValue11;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop");
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(373043553);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(1120412320);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                gapComposer.end(false);
            }
            String str3 = (String) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer, 48).$state.getValue();
            boolean zChanged4 = gapComposer.changed(str3);
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue12 == neverEqualPolicy3) {
                objRememberedValue12 = Boolean.valueOf(StringsKt__IndentKt.parseCookieString(str3).containsKey("SAPISID"));
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            ((Boolean) objRememberedValue12).getClass();
            boolean zBooleanValue7 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.YtmSyncKey, Boolean.TRUE, gapComposer, 48).$state.getValue()).booleanValue();
            boolean zChanged5 = gapComposer.changed(zBooleanValue7) | gapComposer.changedInstance(libraryPlaylistsViewModel2);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue13 == neverEqualPolicy3) {
                bool = null;
                objRememberedValue13 = new Updater$checkForUpdate$2(zBooleanValue7, (Object) libraryPlaylistsViewModel2, (Continuation) (null == true ? 1 : 0), (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue13);
            } else {
                bool = null;
            }
            Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue13);
            if (mutableStateCollectAsStateWithLifecycle != null) {
                bool = (Boolean) mutableStateCollectAsStateWithLifecycle.getValue();
            }
            boolean zChanged6 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | ((i5 & 896) == 256) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(lazyGridStateRememberLazyGridState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
            Object objRememberedValue14 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue14 == neverEqualPolicy3) {
                lazyListState = lazyListStateRememberLazyListState;
                lazyGridState = lazyGridStateRememberLazyGridState;
                objRememberedValue14 = new LibraryMixScreenKt$LibraryMixScreen$6$1(mutableStateCollectAsStateWithLifecycle, libraryViewType, lazyListState, lazyGridState, mutableStateCurrentBackStackEntryAsState, null, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue14);
            } else {
                lazyListState = lazyListStateRememberLazyListState;
                lazyGridState = lazyGridStateRememberLazyGridState;
            }
            Stack.LaunchedEffect(gapComposer, bool, (Function2) objRememberedValue14);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy3) {
                objRememberedValue15 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            MutableState mutableState4 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue15, gapComposer, 48);
            if (((Boolean) mutableState4.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(373959418);
                boolean zChanged7 = gapComposer.changed(mutableState4);
                Object objRememberedValue16 = gapComposer.rememberedValue();
                if (zChanged7 || objRememberedValue16 == neverEqualPolicy3) {
                    objRememberedValue16 = new PlayerKt$$ExternalSyntheticLambda7(mutableState4, (byte) 29);
                    gapComposer.updateRememberedValue(objRememberedValue16);
                }
                Function0 function0 = (Function0) objRememberedValue16;
                boolean zChanged8 = gapComposer.changed(mutableState4) | gapComposer.changedInstance(navHostController);
                Object objRememberedValue17 = gapComposer.rememberedValue();
                if (zChanged8 || objRememberedValue17 == neverEqualPolicy3) {
                    i3 = 1;
                    objRememberedValue17 = new LibraryMixScreenKt$$ExternalSyntheticLambda7(navHostController, mutableState4, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue17);
                } else {
                    i3 = 1;
                }
                neverEqualPolicy = neverEqualPolicy3;
                DialogKt.CreatePlaylistDialog(function0, null, z8, (Function1) objRememberedValue17, gapComposer, 432, 0);
                gapComposer = gapComposer;
                z6 = false;
                gapComposer.end(false);
            } else {
                neverEqualPolicy = neverEqualPolicy3;
                i3 = 1;
                z6 = false;
                gapComposer.startReplaceGroup(374333247);
                gapComposer.end(false);
            }
            LibraryPlaylistsViewModel libraryPlaylistsViewModel3 = libraryPlaylistsViewModel2;
            int i7 = i3;
            NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy;
            ChipKt$$ExternalSyntheticLambda0 chipKt$$ExternalSyntheticLambda0 = new ChipKt$$ExternalSyntheticLambda0(libraryPlaylistsViewModel3, mutableState3, softwareKeyboardController, mutableStateCollectAsStateWithLifecycle5, playlistSortType, zBooleanValue, anonymousClass2, mimesKt$$ExternalSyntheticLambda0, list3, function1, libraryViewType);
            libraryPlaylistsViewModel = libraryPlaylistsViewModel3;
            final ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1156221201, chipKt$$ExternalSyntheticLambda0, gapComposer);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, z6);
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
            int iOrdinal = libraryViewType.ordinal();
            if (iOrdinal == 0) {
                mutableState = mutableState4;
                neverEqualPolicy2 = neverEqualPolicy4;
                gapComposer.startReplaceGroup(-1149652379);
                staticProvidableCompositionLocal = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal), gapComposer);
                boolean zChangedInstance = gapComposer.changedInstance(list3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer.changedInstance(navHostController) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
                Object objRememberedValue18 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue18 == neverEqualPolicy2) {
                    final byte b = 0;
                    Function1 function2 = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            byte b2 = b;
                            Unit unit = Unit.INSTANCE;
                            MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle5;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl;
                            switch (b2) {
                                case 0:
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                                    lazyListIntervalContent.getClass();
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1565642768, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 21)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 1602080089, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 18)));
                                    final List list4 = list3;
                                    if (list4.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -2124390219, new QueueKt$$ExternalSyntheticLambda21(mutableState5, (byte) 20)), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 10);
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda6 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 11);
                                    int size2 = list4.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list4, (byte) 20);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda6, list4, (byte) 21);
                                    final byte b3 = 0;
                                    final NavHostController navHostController2 = navHostController;
                                    final MenuState menuState2 = menuState;
                                    final CoroutineScope coroutineScope4 = coroutineScope;
                                    lazyListIntervalContent.items(size2, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$lambda$20$0$0$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                            GapComposer gapComposer2;
                                            byte b4 = b3;
                                            Unit unit2 = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                            List list5 = list4;
                                            final NavHostController navHostController3 = navHostController2;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            final byte b5 = 0;
                                            final byte b6 = 1;
                                            switch (b4) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                                    int iIntValue = ((Number) obj6).intValue();
                                                    Composer composer2 = (Composer) obj7;
                                                    int iIntValue2 = ((Number) obj8).intValue();
                                                    int i8 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (!gapComposer3.shouldExecute(i8 & 1, (i8 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem = (VisiblePlaylistItem) list5.get(iIntValue);
                                                        gapComposer3.startReplaceGroup(-470926478);
                                                        if (visiblePlaylistItem.autoPlaylist) {
                                                            gapComposer3.startReplaceGroup(-470887543);
                                                            Playlist playlist7 = visiblePlaylistItem.playlist;
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged9 = gapComposer3.changed(visiblePlaylistItem) | gapComposer3.changedInstance(navHostController3);
                                                            Object objRememberedValue19 = gapComposer3.rememberedValue();
                                                            if (zChanged9 || objRememberedValue19 == neverEqualPolicy5) {
                                                                objRememberedValue19 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b7 = b5;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController4 = navHostController3;
                                                                        VisiblePlaylistItem visiblePlaylistItem2 = visiblePlaylistItem;
                                                                        switch (b7) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem2.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController4, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem2.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController4, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer3.updateRememberedValue(objRememberedValue19);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist7, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer3, 384, 24);
                                                            gapComposer3.end(false);
                                                        } else {
                                                            gapComposer3.startReplaceGroup(-470327776);
                                                            LibraryKt.LibraryPlaylistListItem(menuState2, coroutineScope4, visiblePlaylistItem.playlist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj5;
                                                    int iIntValue3 = ((Number) obj6).intValue();
                                                    Composer composer3 = (Composer) obj7;
                                                    int iIntValue4 = ((Number) obj8).intValue();
                                                    int i9 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i9 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                    if (!gapComposer4.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                                        gapComposer4.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem2 = (VisiblePlaylistItem) list5.get(iIntValue3);
                                                        gapComposer4.startReplaceGroup(2041268716);
                                                        if (visiblePlaylistItem2.autoPlaylist) {
                                                            gapComposer4.startReplaceGroup(2041307651);
                                                            Playlist playlist8 = visiblePlaylistItem2.playlist;
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged10 = gapComposer4.changed(visiblePlaylistItem2) | gapComposer4.changedInstance(navHostController3);
                                                            Object objRememberedValue20 = gapComposer4.rememberedValue();
                                                            if (zChanged10 || objRememberedValue20 == neverEqualPolicy5) {
                                                                objRememberedValue20 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b7 = b6;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController4 = navHostController3;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem2;
                                                                        switch (b7) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController4, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController4, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer4.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer4, 24960, 8);
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.end(false);
                                                        } else {
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.startReplaceGroup(2042027905);
                                                            LibraryKt.LibraryPlaylistGridItem(menuState2, coroutineScope4, visiblePlaylistItem2.playlist, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                                default:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj4;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 12), 0, new ComposableLambdaImpl(true, 478552239, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 19)));
                                    lazyGridIntervalContent.item("header", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 13), 0, new ComposableLambdaImpl(true, 1909780134, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 20)));
                                    final List list5 = list3;
                                    if (list5.isEmpty()) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 14), null, new ComposableLambdaImpl(true, 10672074, new QueueKt$$ExternalSyntheticLambda21(mutableState5, (byte) 21)), 5);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda7 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 15);
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda8 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 16);
                                    int size3 = list5.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$3 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda7, list5, (byte) 22);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$4 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda8, list5, (byte) 23);
                                    final byte b4 = 1;
                                    final NavHostController navHostController3 = navHostController;
                                    final MenuState menuState3 = menuState;
                                    final CoroutineScope coroutineScope5 = coroutineScope;
                                    lazyGridIntervalContent.items(size3, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$3, null, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$4, new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$lambda$20$0$0$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                            GapComposer gapComposer2;
                                            byte b5 = b4;
                                            Unit unit2 = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                            List list6 = list5;
                                            final NavHostController navHostController4 = navHostController3;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            final byte b6 = 0;
                                            final byte b7 = 1;
                                            switch (b5) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                                    int iIntValue = ((Number) obj6).intValue();
                                                    Composer composer2 = (Composer) obj7;
                                                    int iIntValue2 = ((Number) obj8).intValue();
                                                    int i8 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (!gapComposer3.shouldExecute(i8 & 1, (i8 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem = (VisiblePlaylistItem) list6.get(iIntValue);
                                                        gapComposer3.startReplaceGroup(-470926478);
                                                        if (visiblePlaylistItem.autoPlaylist) {
                                                            gapComposer3.startReplaceGroup(-470887543);
                                                            Playlist playlist7 = visiblePlaylistItem.playlist;
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged9 = gapComposer3.changed(visiblePlaylistItem) | gapComposer3.changedInstance(navHostController4);
                                                            Object objRememberedValue19 = gapComposer3.rememberedValue();
                                                            if (zChanged9 || objRememberedValue19 == neverEqualPolicy5) {
                                                                objRememberedValue19 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b8 = b6;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController5 = navHostController4;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem;
                                                                        switch (b8) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer3.updateRememberedValue(objRememberedValue19);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist7, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue19, 15)), true, null, null, gapComposer3, 384, 24);
                                                            gapComposer3.end(false);
                                                        } else {
                                                            gapComposer3.startReplaceGroup(-470327776);
                                                            LibraryKt.LibraryPlaylistListItem(menuState3, coroutineScope5, visiblePlaylistItem.playlist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj5;
                                                    int iIntValue3 = ((Number) obj6).intValue();
                                                    Composer composer3 = (Composer) obj7;
                                                    int iIntValue4 = ((Number) obj8).intValue();
                                                    int i9 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i9 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                    if (!gapComposer4.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                                        gapComposer4.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem2 = (VisiblePlaylistItem) list6.get(iIntValue3);
                                                        gapComposer4.startReplaceGroup(2041268716);
                                                        if (visiblePlaylistItem2.autoPlaylist) {
                                                            gapComposer4.startReplaceGroup(2041307651);
                                                            Playlist playlist8 = visiblePlaylistItem2.playlist;
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged10 = gapComposer4.changed(visiblePlaylistItem2) | gapComposer4.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer4.rememberedValue();
                                                            if (zChanged10 || objRememberedValue20 == neverEqualPolicy5) {
                                                                objRememberedValue20 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b8 = b7;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController5 = navHostController4;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem2;
                                                                        switch (b8) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer4.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer4, 24960, 8);
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.end(false);
                                                        } else {
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.startReplaceGroup(2042027905);
                                                            LibraryKt.LibraryPlaylistGridItem(menuState3, coroutineScope5, visiblePlaylistItem2.playlist, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(function2);
                    objRememberedValue18 = function2;
                }
                IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue18, gapComposer, 0, 505);
                gapComposer.end(false);
            } else {
                if (iOrdinal != i7) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, 1764031239, false);
                }
                gapComposer.startReplaceGroup(-1147010559);
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                GridCells$Adaptive gridCells$Adaptive = new GridCells$Adaptive(128.0f + (((GridItemSize) ((Enum) libraryPlaylistsScreenKt$LibraryPlaylistsScreen$$inlined$rememberEnumPreference$4.$state.getValue())) == gridItemSize ? 24.0f : -24.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal3), gapComposer);
                boolean zChangedInstance2 = gapComposer.changedInstance(list3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle5) | gapComposer.changedInstance(navHostController) | gapComposer.changed(menuState) | gapComposer.changedInstance(coroutineScope);
                Object objRememberedValue19 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue19 == neverEqualPolicy4) {
                    final byte b2 = 1;
                    mutableState2 = mutableState4;
                    obj = new Function1() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            byte b3 = b2;
                            Unit unit = Unit.INSTANCE;
                            MutableState mutableState5 = mutableStateCollectAsStateWithLifecycle5;
                            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda;
                            ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl;
                            switch (b3) {
                                case 0:
                                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                                    lazyListIntervalContent.getClass();
                                    lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -1565642768, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 21)));
                                    lazyListIntervalContent.item("header", 0, new ComposableLambdaImpl(true, 1602080089, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 18)));
                                    final List list4 = list3;
                                    if (list4.isEmpty()) {
                                        LazyListIntervalContent.item$default(lazyListIntervalContent, "empty_placeholder", null, new ComposableLambdaImpl(true, -2124390219, new QueueKt$$ExternalSyntheticLambda21(mutableState5, (byte) 20)), 2);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda5 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 10);
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda6 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 11);
                                    int size2 = list4.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda5, list4, (byte) 20);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda6, list4, (byte) 21);
                                    final byte b4 = 0;
                                    final NavHostController navHostController2 = navHostController;
                                    final MenuState menuState2 = menuState;
                                    final CoroutineScope coroutineScope4 = coroutineScope;
                                    lazyListIntervalContent.items(size2, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$2, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$lambda$20$0$0$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                            GapComposer gapComposer2;
                                            byte b5 = b4;
                                            Unit unit2 = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                            List list6 = list4;
                                            final NavHostController navHostController4 = navHostController2;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            final byte b6 = 0;
                                            final byte b7 = 1;
                                            switch (b5) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                                    int iIntValue = ((Number) obj6).intValue();
                                                    Composer composer2 = (Composer) obj7;
                                                    int iIntValue2 = ((Number) obj8).intValue();
                                                    int i8 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (!gapComposer3.shouldExecute(i8 & 1, (i8 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem = (VisiblePlaylistItem) list6.get(iIntValue);
                                                        gapComposer3.startReplaceGroup(-470926478);
                                                        if (visiblePlaylistItem.autoPlaylist) {
                                                            gapComposer3.startReplaceGroup(-470887543);
                                                            Playlist playlist7 = visiblePlaylistItem.playlist;
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged9 = gapComposer3.changed(visiblePlaylistItem) | gapComposer3.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer3.rememberedValue();
                                                            if (zChanged9 || objRememberedValue110 == neverEqualPolicy5) {
                                                                objRememberedValue110 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b8 = b6;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController5 = navHostController4;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem;
                                                                        switch (b8) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer3.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist7, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer3, 384, 24);
                                                            gapComposer3.end(false);
                                                        } else {
                                                            gapComposer3.startReplaceGroup(-470327776);
                                                            LibraryKt.LibraryPlaylistListItem(menuState2, coroutineScope4, visiblePlaylistItem.playlist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj5;
                                                    int iIntValue3 = ((Number) obj6).intValue();
                                                    Composer composer3 = (Composer) obj7;
                                                    int iIntValue4 = ((Number) obj8).intValue();
                                                    int i9 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i9 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                    if (!gapComposer4.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                                        gapComposer4.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem2 = (VisiblePlaylistItem) list6.get(iIntValue3);
                                                        gapComposer4.startReplaceGroup(2041268716);
                                                        if (visiblePlaylistItem2.autoPlaylist) {
                                                            gapComposer4.startReplaceGroup(2041307651);
                                                            Playlist playlist8 = visiblePlaylistItem2.playlist;
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged10 = gapComposer4.changed(visiblePlaylistItem2) | gapComposer4.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer4.rememberedValue();
                                                            if (zChanged10 || objRememberedValue20 == neverEqualPolicy5) {
                                                                objRememberedValue20 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b8 = b7;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController5 = navHostController4;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem2;
                                                                        switch (b8) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer4.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer4, 24960, 8);
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.end(false);
                                                        } else {
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.startReplaceGroup(2042027905);
                                                            LibraryKt.LibraryPlaylistGridItem(menuState2, coroutineScope4, visiblePlaylistItem2.playlist, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                                default:
                                    LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj4;
                                    lazyGridIntervalContent.getClass();
                                    lazyGridIntervalContent.item("filter", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 12), 0, new ComposableLambdaImpl(true, 478552239, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl3, (byte) 19)));
                                    lazyGridIntervalContent.item("header", new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 13), 0, new ComposableLambdaImpl(true, 1909780134, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 20)));
                                    final List list5 = list3;
                                    if (list5.isEmpty()) {
                                        LazyGridIntervalContent.item$default(lazyGridIntervalContent, null, new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 14), null, new ComposableLambdaImpl(true, 10672074, new QueueKt$$ExternalSyntheticLambda21(mutableState5, (byte) 21)), 5);
                                    }
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda7 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 15);
                                    LocalSearchScreenKt$$ExternalSyntheticLambda5 localSearchScreenKt$$ExternalSyntheticLambda8 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 16);
                                    int size3 = list5.size();
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$3 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda7, list5, (byte) 22);
                                    ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$4 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(localSearchScreenKt$$ExternalSyntheticLambda8, list5, (byte) 23);
                                    final byte b5 = 1;
                                    final NavHostController navHostController3 = navHostController;
                                    final MenuState menuState3 = menuState;
                                    final CoroutineScope coroutineScope5 = coroutineScope;
                                    lazyGridIntervalContent.items(size3, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$3, null, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$4, new ComposableLambdaImpl(true, -1117249557, new Function4() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$lambda$20$0$0$$inlined$items$3
                                        @Override // kotlin.jvm.functions.Function4
                                        public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                                            GapComposer gapComposer2;
                                            byte b6 = b5;
                                            Unit unit2 = Unit.INSTANCE;
                                            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
                                            List list6 = list5;
                                            final NavHostController navHostController4 = navHostController3;
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            final byte b7 = 0;
                                            final byte b8 = 1;
                                            switch (b6) {
                                                case 0:
                                                    LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj5;
                                                    int iIntValue = ((Number) obj6).intValue();
                                                    Composer composer2 = (Composer) obj7;
                                                    int iIntValue2 = ((Number) obj8).intValue();
                                                    int i8 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                                                    if ((iIntValue2 & 48) == 0) {
                                                        i8 |= ((GapComposer) composer2).changed(iIntValue) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer3 = (GapComposer) composer2;
                                                    if (!gapComposer3.shouldExecute(i8 & 1, (i8 & 147) != 146)) {
                                                        gapComposer3.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem = (VisiblePlaylistItem) list6.get(iIntValue);
                                                        gapComposer3.startReplaceGroup(-470926478);
                                                        if (visiblePlaylistItem.autoPlaylist) {
                                                            gapComposer3.startReplaceGroup(-470887543);
                                                            Playlist playlist7 = visiblePlaylistItem.playlist;
                                                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged9 = gapComposer3.changed(visiblePlaylistItem) | gapComposer3.changedInstance(navHostController4);
                                                            Object objRememberedValue110 = gapComposer3.rememberedValue();
                                                            if (zChanged9 || objRememberedValue110 == neverEqualPolicy5) {
                                                                objRememberedValue110 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b9 = b7;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController5 = navHostController4;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem;
                                                                        switch (b9) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer3.updateRememberedValue(objRememberedValue110);
                                                            }
                                                            MenuKt.PlaylistListItem(playlist7, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue110, 15)), true, null, null, gapComposer3, 384, 24);
                                                            gapComposer3.end(false);
                                                        } else {
                                                            gapComposer3.startReplaceGroup(-470327776);
                                                            LibraryKt.LibraryPlaylistListItem(menuState3, coroutineScope5, visiblePlaylistItem.playlist, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), gapComposer3, 0);
                                                            gapComposer3.end(false);
                                                        }
                                                        gapComposer3.end(false);
                                                    }
                                                    break;
                                                default:
                                                    LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj5;
                                                    int iIntValue3 = ((Number) obj6).intValue();
                                                    Composer composer3 = (Composer) obj7;
                                                    int iIntValue4 = ((Number) obj8).intValue();
                                                    int i9 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue4;
                                                    if ((iIntValue4 & 48) == 0) {
                                                        i9 |= ((GapComposer) composer3).changed(iIntValue3) ? 32 : 16;
                                                    }
                                                    GapComposer gapComposer4 = (GapComposer) composer3;
                                                    if (!gapComposer4.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                                                        gapComposer4.skipToGroupEnd();
                                                    } else {
                                                        final VisiblePlaylistItem visiblePlaylistItem2 = (VisiblePlaylistItem) list6.get(iIntValue3);
                                                        gapComposer4.startReplaceGroup(2041268716);
                                                        if (visiblePlaylistItem2.autoPlaylist) {
                                                            gapComposer4.startReplaceGroup(2041307651);
                                                            Playlist playlist8 = visiblePlaylistItem2.playlist;
                                                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                                            boolean zChanged10 = gapComposer4.changed(visiblePlaylistItem2) | gapComposer4.changedInstance(navHostController4);
                                                            Object objRememberedValue20 = gapComposer4.rememberedValue();
                                                            if (zChanged10 || objRememberedValue20 == neverEqualPolicy5) {
                                                                objRememberedValue20 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryPlaylistsScreenKt$LibraryPlaylistsScreen$5$1$1$6$1$1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        byte b9 = b8;
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                        NavHostController navHostController5 = navHostController4;
                                                                        VisiblePlaylistItem visiblePlaylistItem3 = visiblePlaylistItem2;
                                                                        switch (b9) {
                                                                            case 0:
                                                                                String str4 = visiblePlaylistItem3.route;
                                                                                if (str4 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str4);
                                                                                }
                                                                                break;
                                                                            default:
                                                                                String str5 = visiblePlaylistItem3.route;
                                                                                if (str5 != null) {
                                                                                    NavHostController.navigate$default(navHostController5, str5);
                                                                                }
                                                                                break;
                                                                        }
                                                                        return unit3;
                                                                    }
                                                                };
                                                                gapComposer4.updateRememberedValue(objRememberedValue20);
                                                            }
                                                            MenuKt.PlaylistGridItem(playlist8, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue20, 255)), true, null, true, gapComposer4, 24960, 8);
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.end(false);
                                                        } else {
                                                            gapComposer2 = gapComposer4;
                                                            gapComposer2.startReplaceGroup(2042027905);
                                                            LibraryKt.LibraryPlaylistGridItem(menuState3, coroutineScope5, visiblePlaylistItem2.playlist, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), gapComposer2, 0);
                                                            gapComposer2.end(false);
                                                        }
                                                        gapComposer2.end(false);
                                                    }
                                                    break;
                                            }
                                            return unit2;
                                        }
                                    }));
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState4;
                    obj = objRememberedValue19;
                }
                mutableState = mutableState2;
                GapComposer gapComposer2 = gapComposer;
                neverEqualPolicy2 = neverEqualPolicy4;
                LifecyclesKt.LazyVerticalGrid(gridCells$Adaptive, null, lazyGridState, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, null, (Function1) obj, gapComposer2, 0, 2034);
                gapComposer = gapComposer2;
                gapComposer.end(false);
                staticProvidableCompositionLocal = staticProvidableCompositionLocal3;
            }
            MutableState mutableState5 = mutableState;
            boolean zChanged9 = gapComposer.changed(mutableState5);
            Object objRememberedValue20 = gapComposer.rememberedValue();
            if (zChanged9 || objRememberedValue20 == neverEqualPolicy2) {
                z7 = true;
                objRememberedValue20 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState5, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue20);
            } else {
                z7 = true;
            }
            CardKt.m259FloatingActionButtonXz6DiA((Function0) objRememberedValue20, OffsetKt.m135padding3ABfNKs(OffsetKt.windowInsetsPadding(BoxScopeInstance.INSTANCE.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomEnd), new LimitInsets((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal), 47)), 16.0f), null, 0L, 0L, null, lambda$321452699, gapComposer, 12582912, 124);
            gapComposer.end(z7);
            z2 = z8;
        } else {
            gapComposer.skipToGroupEnd();
            z2 = z;
        }
        LibraryPlaylistsViewModel libraryPlaylistsViewModel4 = libraryPlaylistsViewModel;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda6(navHostController, composableLambdaImpl, libraryViewType, function1, libraryPlaylistsViewModel4, z2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0407  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void LibraryPodcastsScreen(final NavHostController navHostController, final Function0 function0, LibraryPodcastsViewModel libraryPodcastsViewModel, Composer composer, final int i) {
        final LibraryPodcastsViewModel libraryPodcastsViewModel2;
        LibraryPodcastsViewModel libraryPodcastsViewModel3;
        MutableState mutableStateCollectAsStateWithLifecycle;
        LazyListState lazyListState;
        MutableState mutableState;
        LibraryPodcastsViewModel libraryPodcastsViewModel4;
        PullToRefreshStateImpl pullToRefreshStateImpl;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        Object obj;
        PlayerConnection playerConnection;
        boolean zChangedInstance;
        Object objRememberedValue;
        SavedStateHandle savedStateHandle;
        navHostController.getClass();
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2143611688);
        int i2 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | 128;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                libraryPodcastsViewModel3 = (LibraryPodcastsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LibraryPodcastsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
            } else {
                gapComposer.skipToGroupEnd();
                libraryPodcastsViewModel3 = libraryPodcastsViewModel;
            }
            gapComposer.endDefaults();
            String strStringResource = MathKt.stringResource(R.string.downloaded_episodes, gapComposer);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final LibraryPodcastsViewModel libraryPodcastsViewModel5 = libraryPodcastsViewModel3;
                    final byte b = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, function0, libraryPodcastsViewModel5, i, b) { // from class: com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ Function0 f$1;
                        public final /* synthetic */ LibraryPodcastsViewModel f$2;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            LibraryPodcastsViewModel libraryPodcastsViewModel6 = this.f$2;
                            Function0 function1 = this.f$1;
                            NavHostController navHostController2 = this.f$0;
                            Composer composer2 = (Composer) obj2;
                            ((Integer) obj3).getClass();
                            switch (b2) {
                                case 0:
                                    LibraryScreenKt.LibraryPodcastsScreen(navHostController2, function1, libraryPodcastsViewModel6, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    LibraryScreenKt.LibraryPodcastsScreen(navHostController2, function1, libraryPodcastsViewModel6, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            LibraryPodcastsViewModel libraryPodcastsViewModel6 = libraryPodcastsViewModel3;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer);
            Preferences$Key preferences$Key = PreferenceKeysKt.PodcastFilterKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer.consume(staticProvidableCompositionLocal2);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 12));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, PodcastFilter.EPISODES, gapComposer, 48);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle4, coroutineScope, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2) objRememberedValue4;
            Preferences$Key preferences$Key2 = PreferenceKeysKt.SongSortTypeKey;
            Context context2 = (Context) gapComposer.consume(staticProvidableCompositionLocal2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue5;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key2, (byte) 13));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue6, SongSortType.CREATE_DATE, gapComposer, 48);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle5, coroutineScope2, context2, preferences$Key2);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4 libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4 = (LibraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4) objRememberedValue7;
            SongSortType songSortType = (SongSortType) libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$4, (byte) 21);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.SongSortDescendingKey, Boolean.TRUE, gapComposer, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(libraryPodcastsViewModel6.subscribedChannels, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(libraryPodcastsViewModel6.downloadedEpisodes, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(libraryPodcastsViewModel6.savedEpisodes, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(libraryPodcastsViewModel6.sePlaylist, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle10 = FileSystemsKt.collectAsStateWithLifecycle(libraryPodcastsViewModel6.podcastChannels, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle11 = FileSystemsKt.collectAsStateWithLifecycle(libraryPodcastsViewModel6.rdpnPlaylist, gapComposer);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            boolean zChangedInstance2 = gapComposer.changedInstance(libraryPodcastsViewModel6) | gapComposer.changedInstance(lifecycleOwner);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda4((Object) lifecycleOwner, (Object) libraryPodcastsViewModel6, (byte) 17);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            Stack.DisposableEffect(lifecycleOwner, (Function1) objRememberedValue8, gapComposer);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            Continuation continuation = null;
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop");
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(-1530817124);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(-1573401851);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                gapComposer.end(false);
            }
            Boolean bool = mutableStateCollectAsStateWithLifecycle != null ? (Boolean) mutableStateCollectAsStateWithLifecycle.getValue() : null;
            boolean zChanged = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
            MutableState mutableState2 = mutableStateCollectAsStateWithLifecycle;
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue9 == neverEqualPolicy) {
                lazyListState = lazyListStateRememberLazyListState;
                objRememberedValue9 = new HomeScreenKt$HomeScreen$3$1(mutableState2, lazyListState, mutableStateCurrentBackStackEntryAsState, continuation, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue9);
            } else {
                lazyListState = lazyListStateRememberLazyListState;
            }
            Stack.LaunchedEffect(gapComposer, bool, (Function2) objRememberedValue9);
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue10;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue11;
            PullToRefreshStateImpl pullToRefreshStateImplRememberPullToRefreshState = coil3.size.SizeKt.rememberPullToRefreshState(gapComposer);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            boolean zBooleanValue2 = ((Boolean) mutableState3.getValue()).booleanValue();
            boolean zChangedInstance3 = gapComposer.changedInstance(coroutineScope3) | gapComposer.changedInstance(libraryPodcastsViewModel6);
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = new QueueKt$$ExternalSyntheticLambda24((Object) coroutineScope3, (Object) mutableState3, (Object) libraryPodcastsViewModel6, (byte) 7);
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            Modifier modifierThen = fillElement.then(new PullToRefreshElement(zBooleanValue2, (Function0) objRememberedValue12, true, pullToRefreshStateImplRememberPullToRefreshState, PullToRefreshDefaults.PositionalThreshold));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
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
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1062067206, new EqScreenKt$$ExternalSyntheticLambda35(function0, libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2, (byte) 3), gapComposer);
            int iOrdinal = ((PodcastFilter) libraryPodcastsScreenKt$LibraryPodcastsScreen$$inlined$rememberEnumPreference$2.getValue()).ordinal();
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (iOrdinal == 0) {
                mutableState = mutableState3;
                libraryPodcastsViewModel4 = libraryPodcastsViewModel6;
                pullToRefreshStateImpl = pullToRefreshStateImplRememberPullToRefreshState;
                gapComposer.startReplaceGroup(127396673);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal3), gapComposer);
                boolean zChanged2 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle11) | gapComposer.changedInstance(navHostController) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle9) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle8) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle6) | gapComposer.changed(menuState) | gapComposer.changedInstance(musicDatabase);
                Object objRememberedValue13 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue13 == neverEqualPolicy) {
                    NewReleaseScreenKt$$ExternalSyntheticLambda1 newReleaseScreenKt$$ExternalSyntheticLambda1 = new NewReleaseScreenKt$$ExternalSyntheticLambda1(composableLambdaImplRememberComposableLambda, navHostController, mutableStateCollectAsStateWithLifecycle11, mutableStateCollectAsStateWithLifecycle9, mutableStateCollectAsStateWithLifecycle8, mutableStateCollectAsStateWithLifecycle6, menuState, musicDatabase);
                    gapComposer.updateRememberedValue(newReleaseScreenKt$$ExternalSyntheticLambda1);
                    objRememberedValue13 = newReleaseScreenKt$$ExternalSyntheticLambda1;
                }
                staticProvidableCompositionLocal = staticProvidableCompositionLocal3;
                IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue13, gapComposer, 0, 505);
                gapComposer.end(false);
            } else if (iOrdinal == 1) {
                mutableState = mutableState3;
                libraryPodcastsViewModel4 = libraryPodcastsViewModel6;
                pullToRefreshStateImpl = pullToRefreshStateImplRememberPullToRefreshState;
                LazyListState lazyListState2 = lazyListState;
                gapComposer.startReplaceGroup(130526960);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues2 = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal4), gapComposer);
                boolean zChanged3 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle10) | gapComposer.changedInstance(navHostController);
                Object objRememberedValue14 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue14 == neverEqualPolicy) {
                    objRememberedValue14 = new MainActivity$$ExternalSyntheticLambda21(composableLambdaImplRememberComposableLambda, mutableStateCollectAsStateWithLifecycle10, navHostController);
                    gapComposer.updateRememberedValue(objRememberedValue14);
                }
                staticProvidableCompositionLocal = staticProvidableCompositionLocal4;
                IntMath.LazyColumn(null, lazyListState2, insetsPaddingValuesAsPaddingValues2, null, null, null, false, null, (Function1) objRememberedValue14, gapComposer, 0, 505);
                gapComposer.end(false);
            } else {
                if (iOrdinal != 2) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1104263256, false);
                }
                gapComposer.startReplaceGroup(133765003);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal5 = MainActivityKt.LocalPlayerAwareWindowInsets;
                InsetsPaddingValues insetsPaddingValuesAsPaddingValues3 = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal5), gapComposer);
                boolean zChanged4 = gapComposer.changed(songSortType.ordinal()) | gapComposer.changed(zBooleanValue) | gapComposer.changed(anonymousClass2) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle7) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer.changedInstance(playerConnection2) | gapComposer.changed(strStringResource) | gapComposer.changed(menuState);
                Object objRememberedValue15 = gapComposer.rememberedValue();
                if (zChanged4) {
                    obj = neverEqualPolicy;
                } else {
                    obj = neverEqualPolicy;
                    if (objRememberedValue15 == obj) {
                    }
                    Object obj2 = obj;
                    playerConnection = playerConnection2;
                    mutableState = mutableState3;
                    pullToRefreshStateImpl = pullToRefreshStateImplRememberPullToRefreshState;
                    LazyListState lazyListState3 = lazyListState;
                    libraryPodcastsViewModel4 = libraryPodcastsViewModel6;
                    IntMath.LazyColumn(null, lazyListState3, insetsPaddingValuesAsPaddingValues3, null, null, null, false, null, (Function1) objRememberedValue15, gapComposer, 0, 505);
                    boolean z = !((List) mutableStateCollectAsStateWithLifecycle7.getValue()).isEmpty();
                    zChangedInstance = gapComposer.changedInstance(playerConnection) | gapComposer.changed(strStringResource) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle7);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == obj2) {
                        objRememberedValue = new QueueKt$$ExternalSyntheticLambda24(playerConnection, (Object) strStringResource, (Object) mutableStateCollectAsStateWithLifecycle7, (byte) 8);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    MenuKt.HideOnScrollFAB(boxScopeInstance, z, lazyListState3, R.drawable.shuffle, (Function0) objRememberedValue, null, gapComposer, 6, 16);
                    boxScopeInstance = boxScopeInstance;
                    gapComposer.end(false);
                    staticProvidableCompositionLocal = staticProvidableCompositionLocal5;
                }
                ArtistSongsScreenKt$$ExternalSyntheticLambda1 artistSongsScreenKt$$ExternalSyntheticLambda1 = new ArtistSongsScreenKt$$ExternalSyntheticLambda1(composableLambdaImplRememberComposableLambda, songSortType, zBooleanValue, anonymousClass2, mimesKt$$ExternalSyntheticLambda0, mutableStateCollectAsStateWithLifecycle7, mutableStateCollectAsStateWithLifecycle3, playerConnection2, strStringResource, mutableStateCollectAsStateWithLifecycle2, menuState);
                playerConnection2 = playerConnection2;
                gapComposer.updateRememberedValue(artistSongsScreenKt$$ExternalSyntheticLambda1);
                objRememberedValue15 = artistSongsScreenKt$$ExternalSyntheticLambda1;
                Object obj3 = obj;
                playerConnection = playerConnection2;
                mutableState = mutableState3;
                pullToRefreshStateImpl = pullToRefreshStateImplRememberPullToRefreshState;
                LazyListState lazyListState4 = lazyListState;
                libraryPodcastsViewModel4 = libraryPodcastsViewModel6;
                IntMath.LazyColumn(null, lazyListState4, insetsPaddingValuesAsPaddingValues3, null, null, null, false, null, (Function1) objRememberedValue15, gapComposer, 0, 505);
                boolean z2 = !((List) mutableStateCollectAsStateWithLifecycle7.getValue()).isEmpty();
                zChangedInstance = gapComposer.changedInstance(playerConnection) | gapComposer.changed(strStringResource) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle7);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new QueueKt$$ExternalSyntheticLambda24(playerConnection, (Object) strStringResource, (Object) mutableStateCollectAsStateWithLifecycle7, (byte) 8);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new QueueKt$$ExternalSyntheticLambda24(playerConnection, (Object) strStringResource, (Object) mutableStateCollectAsStateWithLifecycle7, (byte) 8);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MenuKt.HideOnScrollFAB(boxScopeInstance, z2, lazyListState4, R.drawable.shuffle, (Function0) objRememberedValue, null, gapComposer, 6, 16);
                boxScopeInstance = boxScopeInstance;
                gapComposer.end(false);
                staticProvidableCompositionLocal = staticProvidableCompositionLocal5;
            }
            PullToRefreshDefaults.INSTANCE.m378Indicator2poqoh4(pullToRefreshStateImpl, ((Boolean) mutableState.getValue()).booleanValue(), OffsetKt.padding(boxScopeInstance.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.TopCenter), OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(staticProvidableCompositionLocal), gapComposer)), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer, 1572864);
            gapComposer.end(true);
            libraryPodcastsViewModel2 = libraryPodcastsViewModel4;
        } else {
            gapComposer.skipToGroupEnd();
            libraryPodcastsViewModel2 = libraryPodcastsViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController, function0, libraryPodcastsViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.library.LibraryPodcastsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ LibraryPodcastsViewModel f$2;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    LibraryPodcastsViewModel libraryPodcastsViewModel7 = this.f$2;
                    Function0 function1 = this.f$1;
                    NavHostController navHostController2 = this.f$0;
                    Composer composer2 = (Composer) obj4;
                    ((Integer) obj5).getClass();
                    switch (b3) {
                        case 0:
                            LibraryScreenKt.LibraryPodcastsScreen(navHostController2, function1, libraryPodcastsViewModel7, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            LibraryScreenKt.LibraryPodcastsScreen(navHostController2, function1, libraryPodcastsViewModel7, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void LibraryScreen(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-418049397);
        final byte b = 1;
        final byte b2 = 0;
        if (gapComposer.shouldExecute(i & 1, i != 0)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Preferences$Key preferences$Key = PreferenceKeysKt.ChipSortTypeKey;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 14));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, LibraryFilter.LIBRARY, gapComposer, 48);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            final LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2) objRememberedValue3;
            Preferences$Key preferences$Key2 = PreferenceKeysKt.AlbumViewTypeKey;
            Context context2 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue4;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key2, (byte) 15));
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            LibraryViewType libraryViewType = LibraryViewType.GRID;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue5, libraryViewType, gapComposer, 48);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle2, coroutineScope2, context2, preferences$Key2);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4) objRememberedValue6;
            Preferences$Key preferences$Key3 = PreferenceKeysKt.PlaylistViewTypeKey;
            Context context3 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue7;
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context3).getData(), preferences$Key3, (byte) 16));
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue8, libraryViewType, gapComposer, 48);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6(mutableStateCollectAsStateWithLifecycle3, coroutineScope3, context3, preferences$Key3);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6) objRememberedValue9;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-917634110, new QueueKt$$ExternalSyntheticLambda39(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2, (byte) 10), gapComposer);
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
            int iOrdinal = ((LibraryFilter) libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2.getValue()).ordinal();
            if (iOrdinal != 0) {
                final byte b3 = 2;
                if (iOrdinal == 1) {
                    gapComposer.startReplaceGroup(-276024353);
                    boolean zChanged = gapComposer.changed(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2);
                    Object objRememberedValue10 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit = Unit.INSTANCE;
                                LibraryFilter libraryFilter = LibraryFilter.LIBRARY;
                                LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2;
                                switch (b4) {
                                    case 0:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                    case 1:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                    case 2:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                    default:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue10);
                    }
                    LibraryArtistsScreen(navHostController, (Function0) objRememberedValue10, null, gapComposer, 0);
                    gapComposer.end(false);
                } else if (iOrdinal != 2) {
                    final byte b4 = 3;
                    if (iOrdinal == 3) {
                        gapComposer.startReplaceGroup(-276043117);
                        LibraryViewType libraryViewType2 = (LibraryViewType) libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.getValue();
                        boolean zChanged2 = gapComposer.changed(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6);
                        Object objRememberedValue11 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue11 == neverEqualPolicy) {
                            objRememberedValue11 = new MimesKt$$ExternalSyntheticLambda0((byte) 12, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6);
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        }
                        LibraryPlaylistsScreen(navHostController, composableLambdaImplRememberComposableLambda, libraryViewType2, (Function1) objRememberedValue11, null, false, gapComposer, 48);
                        gapComposer = gapComposer;
                        gapComposer.end(false);
                    } else if (iOrdinal == 4) {
                        gapComposer.startReplaceGroup(-276019200);
                        boolean zChanged3 = gapComposer.changed(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2);
                        Object objRememberedValue12 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b5 = b4;
                                    Unit unit = Unit.INSTANCE;
                                    LibraryFilter libraryFilter = LibraryFilter.LIBRARY;
                                    LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2;
                                    switch (b5) {
                                        case 0:
                                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                            break;
                                        case 1:
                                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                            break;
                                        case 2:
                                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                            break;
                                        default:
                                            libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                            break;
                                    }
                                    return unit;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue12);
                        }
                        LibraryPodcastsScreen(navHostController, (Function0) objRememberedValue12, null, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        if (iOrdinal != 5) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer, -276052608, false);
                        }
                        gapComposer.startReplaceGroup(-276051765);
                        LibraryViewType libraryViewType3 = (LibraryViewType) libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.getValue();
                        boolean zChanged4 = gapComposer.changed(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4);
                        Object objRememberedValue13 = gapComposer.rememberedValue();
                        if (zChanged4 || objRememberedValue13 == neverEqualPolicy) {
                            objRememberedValue13 = new MimesKt$$ExternalSyntheticLambda0((byte) 11, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4);
                            gapComposer.updateRememberedValue(objRememberedValue13);
                        }
                        LibraryMixScreen(navHostController, composableLambdaImplRememberComposableLambda, libraryViewType3, (Function1) objRememberedValue13, null, gapComposer, 48);
                        gapComposer.end(false);
                    }
                } else {
                    gapComposer.startReplaceGroup(-276029442);
                    boolean zChanged5 = gapComposer.changed(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2);
                    Object objRememberedValue14 = gapComposer.rememberedValue();
                    if (zChanged5 || objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b5 = b;
                                Unit unit = Unit.INSTANCE;
                                LibraryFilter libraryFilter = LibraryFilter.LIBRARY;
                                LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2;
                                switch (b5) {
                                    case 0:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                    case 1:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                    case 2:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                    default:
                                        libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    }
                    LibraryAlbumsScreen(navHostController, (Function0) objRememberedValue14, null, gapComposer, 0);
                    gapComposer.end(false);
                }
            } else {
                gapComposer.startReplaceGroup(-276034467);
                boolean zChanged6 = gapComposer.changed(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2);
                Object objRememberedValue15 = gapComposer.rememberedValue();
                if (zChanged6 || objRememberedValue15 == neverEqualPolicy) {
                    objRememberedValue15 = new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b5 = b2;
                            Unit unit = Unit.INSTANCE;
                            LibraryFilter libraryFilter = LibraryFilter.LIBRARY;
                            LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3 = libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$2;
                            switch (b5) {
                                case 0:
                                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                    break;
                                case 1:
                                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                    break;
                                case 2:
                                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                    break;
                                default:
                                    libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$3.setValue((Enum) libraryFilter);
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue15);
                }
                LibrarySongsScreen(navHostController, (Function0) objRememberedValue15, null, gapComposer, 0);
                gapComposer.end(false);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LibraryScreenKt$$ExternalSyntheticLambda7(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.util.ArrayList] */
    public static final void LibrarySongsScreen(final NavHostController navHostController, final Function0 function0, LibrarySongsViewModel librarySongsViewModel, Composer composer, final int i) {
        int i2;
        LibrarySongsViewModel librarySongsViewModel2;
        int i3;
        Object librarySongsScreenKt$$ExternalSyntheticLambda2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        LibrarySongsViewModel librarySongsViewModel3;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableStateCollectAsStateWithLifecycle;
        LazyListState lazyListState;
        Continuation continuation;
        ?? arrayList;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0;
        boolean z;
        Object lyricsMenuKt$$ExternalSyntheticLambda8;
        boolean z2;
        boolean z3;
        ArrayList arrayList2;
        PlayerConnection playerConnection;
        String str;
        SavedStateHandle savedStateHandle;
        navHostController.getClass();
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-307091001);
        int i4 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | 128;
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                } else {
                    i2 = i4 & (-897);
                    librarySongsViewModel2 = (LibrarySongsViewModel) UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(LibrarySongsViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
                }
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i4 & (-897);
                librarySongsViewModel2 = librarySongsViewModel;
            }
            int i5 = i2;
            gapComposer.endDefaults();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            String strStringResource = MathKt.stringResource(R.string.upload_unsupported_format, gapComposer);
            String strStringResource2 = MathKt.stringResource(R.string.upload_file_too_large, gapComposer);
            String strStringResource3 = MathKt.stringResource(R.string.upload_failed, gapComposer);
            String strStringResource4 = MathKt.stringResource(R.string.upload_complete, gapComposer);
            String strStringResource5 = MathKt.stringResource(R.string.queue_all_songs, gapComposer);
            PlayerConnection playerConnection2 = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final byte b = 0;
                    final LibrarySongsViewModel librarySongsViewModel4 = librarySongsViewModel2;
                    recomposeScopeImplEndRestartGroup.block = new Function2(navHostController, function0, librarySongsViewModel4, i, b) { // from class: com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ NavHostController f$0;
                        public final /* synthetic */ Function0 f$1;
                        public final /* synthetic */ LibrarySongsViewModel f$2;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            LibrarySongsViewModel librarySongsViewModel5 = this.f$2;
                            Function0 function1 = this.f$1;
                            NavHostController navHostController2 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b2) {
                                case 0:
                                    LibraryScreenKt.LibrarySongsScreen(navHostController2, function1, librarySongsViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    LibraryScreenKt.LibrarySongsScreen(navHostController2, function1, librarySongsViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            LibrarySongsViewModel librarySongsViewModel5 = librarySongsViewModel2;
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.isEffectivelyPlaying, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection2.mediaMetadata, gapComposer);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Preferences$Key preferences$Key = PreferenceKeysKt.SongSortTypeKey;
            Context context2 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            PlayerConnection playerConnection3 = playerConnection2;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context2).getData(), preferences$Key, (byte) 17));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue3, SongSortType.CREATE_DATE, gapComposer, 48);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle4, coroutineScope2, context2, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2) objRememberedValue4;
            SongSortType songSortType = (SongSortType) librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2.component1();
            HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2 anonymousClass2 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2.AnonymousClass2(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$2, (byte) 25);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.SongSortDescendingKey;
            Boolean bool = Boolean.TRUE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key2, bool, gapComposer, 48);
            boolean zBooleanValue = ((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).booleanValue();
            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = new MimesKt$$ExternalSyntheticLambda0((byte) 18, dataStoreKt$rememberPreference$1$1RememberPreference);
            boolean zBooleanValue2 = ((Boolean) com.metrolist.music.utils.UtilsKt.rememberPreference(PreferenceKeysKt.YtmSyncKey, bool, gapComposer, 48).$state.getValue()).booleanValue();
            Preferences$Key preferences$Key3 = PreferenceKeysKt.HideExplicitKey;
            Boolean bool2 = Boolean.FALSE;
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = com.metrolist.music.utils.UtilsKt.rememberPreference(preferences$Key3, bool2, gapComposer, 48);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(librarySongsViewModel5.allSongs, gapComposer);
            Object[] objArr = new Object[0];
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState3 = (MutableState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue5, gapComposer, 48);
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(librarySongsViewModel5.searchQuery, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(librarySongsViewModel5.debouncedSearchQuery, gapComposer);
            boolean zChanged = gapComposer.changed((String) mutableStateCollectAsStateWithLifecycle7.getValue());
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = StringExtKt.normalizeForSearch((String) mutableStateCollectAsStateWithLifecycle7.getValue());
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            String str2 = (String) objRememberedValue6;
            Preferences$Key preferences$Key4 = PreferenceKeysKt.SongFilterKey;
            Context context3 = (Context) gapComposer.consume(staticProvidableCompositionLocal);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue7;
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(com.metrolist.music.utils.UtilsKt.getDataStore(context3).getData(), preferences$Key4, (byte) 18));
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue8, SongFilter.LIKED, gapComposer, 48);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4(mutableStateCollectAsStateWithLifecycle8, coroutineScope3, context3, preferences$Key4);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4 librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4 = (LibrarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4) objRememberedValue9;
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = Stack.mutableStateOf$default(bool2);
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue10;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                objRememberedValue11 = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue11;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                i3 = 0;
                objRememberedValue12 = Fragment$5$$ExternalSyntheticOutline0.m(0, gapComposer);
            } else {
                i3 = 0;
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) objRememberedValue12;
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = Fragment$5$$ExternalSyntheticOutline0.m(i3, gapComposer);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = (ParcelableSnapshotMutableIntState) objRememberedValue13;
            Object objRememberedValue14 = gapComposer.rememberedValue();
            if (objRememberedValue14 == neverEqualPolicy) {
                objRememberedValue14 = Stack.mutableStateOf$default("");
                gapComposer.updateRememberedValue(objRememberedValue14);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue14;
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (objRememberedValue15 == neverEqualPolicy) {
                objRememberedValue15 = Stack.mutableStateOf$default(bool2);
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            MutableState mutableState6 = (MutableState) objRememberedValue15;
            Object objRememberedValue16 = gapComposer.rememberedValue();
            if (objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue16);
            }
            MutableState mutableState7 = (MutableState) objRememberedValue16;
            FragmentManager.FragmentIntentSenderContract fragmentIntentSenderContract = new FragmentManager.FragmentIntentSenderContract((byte) 4);
            boolean zChangedInstance = gapComposer.changedInstance(context) | gapComposer.changedInstance(coroutineScope) | gapComposer.changed(strStringResource) | gapComposer.changed(strStringResource2) | gapComposer.changed(strStringResource3) | gapComposer.changed(strStringResource4) | gapComposer.changedInstance(librarySongsViewModel5);
            Object objRememberedValue17 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue17 == neverEqualPolicy) {
                parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState3;
                librarySongsScreenKt$$ExternalSyntheticLambda2 = new LibrarySongsScreenKt$$ExternalSyntheticLambda2(coroutineScope, context, strStringResource4, librarySongsViewModel5, mutableState6, mutableState4, parcelableSnapshotMutableIntState, strStringResource, strStringResource2, strStringResource3, parcelableSnapshotMutableIntState2, parcelableSnapshotMutableFloatState, mutableState5, mutableState7, (byte) 0);
                librarySongsViewModel3 = librarySongsViewModel5;
                mutableState = mutableState4;
                mutableState2 = mutableState7;
                parcelableSnapshotMutableFloatState = parcelableSnapshotMutableFloatState;
                gapComposer.updateRememberedValue(librarySongsScreenKt$$ExternalSyntheticLambda2);
            } else {
                mutableState = mutableState4;
                mutableState2 = mutableState7;
                librarySongsScreenKt$$ExternalSyntheticLambda2 = objRememberedValue17;
                librarySongsViewModel3 = librarySongsViewModel5;
                parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState3;
            }
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = LifecyclesKt.rememberLauncherForActivityResult(fragmentIntentSenderContract, (Function1) librarySongsScreenKt$$ExternalSyntheticLambda2, gapComposer, 0);
            boolean zChanged2 = gapComposer.changed(zBooleanValue2) | gapComposer.changed(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4) | gapComposer.changedInstance(librarySongsViewModel3);
            Object objRememberedValue18 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue18 == neverEqualPolicy) {
                objRememberedValue18 = new DataStoreKt$get$1(zBooleanValue2, librarySongsViewModel3, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4, (Continuation) null);
                gapComposer.updateRememberedValue(objRememberedValue18);
            }
            Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue18);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(bool2, "scrollToTop");
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(-260422851);
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                gapComposer.startReplaceGroup(1238525252);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                gapComposer.end(false);
            }
            Boolean bool3 = mutableStateCollectAsStateWithLifecycle != null ? (Boolean) mutableStateCollectAsStateWithLifecycle.getValue() : null;
            boolean zChanged3 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
            MutableState mutableState8 = mutableStateCollectAsStateWithLifecycle;
            Object objRememberedValue19 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue19 == neverEqualPolicy) {
                lazyListState = lazyListStateRememberLazyListState;
                continuation = null;
                objRememberedValue19 = new HomeScreenKt$HomeScreen$3$1(mutableState8, lazyListState, mutableStateCurrentBackStackEntryAsState, continuation, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue19);
            } else {
                lazyListState = lazyListStateRememberLazyListState;
                continuation = null;
            }
            Stack.LaunchedEffect(gapComposer, bool3, (Function2) objRememberedValue19);
            if (((Boolean) dataStoreKt$rememberPreference$1$1RememberPreference2.$state.getValue()).booleanValue()) {
                List list = (List) mutableStateCollectAsStateWithLifecycle5.getValue();
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!((Song) obj).song.explicit) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = (List) mutableStateCollectAsStateWithLifecycle5.getValue();
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Song song = (Song) next;
                List list2 = song.artists;
                Iterator it2 = it;
                PlayerConnection playerConnection4 = playerConnection3;
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(((ArtistEntity) it3.next()).name);
                }
                String[] strArr = (String[]) arrayList4.toArray(new String[0]);
                Headers.Builder builder = new Headers.Builder(3);
                builder.add(song.song.title);
                AlbumEntity albumEntity = song.album;
                builder.add(albumEntity != null ? albumEntity.title : continuation);
                builder.addSpread(strArr);
                ArrayList arrayList5 = builder.namesAndValues;
                if (StringExtKt.matchesNormalizedQuery(str2, (String[]) arrayList5.toArray(new String[arrayList5.size()]))) {
                    arrayList3.add(next);
                }
                it = it2;
                playerConnection3 = playerConnection4;
            }
            PlayerConnection playerConnection5 = playerConnection3;
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-259721320);
                Object objRememberedValue20 = gapComposer.rememberedValue();
                if (objRememberedValue20 == neverEqualPolicy) {
                    objRememberedValue20 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState6, mutableState2, mutableState, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue20);
                }
                mimesKt$$ExternalSyntheticLambda0 = mimesKt$$ExternalSyntheticLambda1;
                DialogKt.DefaultDialog((Function0) objRememberedValue20, null, f370lambda$1246923554, f372lambda$1662250371, Expect_jvmKt.rememberComposableLambda(1534444916, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(mutableState6, mutableState2, mutableState, (byte) 6), gapComposer), null, Expect_jvmKt.rememberComposableLambda(167417290, new LibrarySongsScreenKt$$ExternalSyntheticLambda5(parcelableSnapshotMutableIntState2, parcelableSnapshotMutableIntState, mutableState5, parcelableSnapshotMutableFloatState, (byte) 0), gapComposer), gapComposer, 1600902, 34);
                gapComposer = gapComposer;
                z = false;
                gapComposer.end(false);
            } else {
                mimesKt$$ExternalSyntheticLambda0 = r19;
                z = false;
                gapComposer.startReplaceGroup(-258180837);
                gapComposer.end(false);
            }
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, z);
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
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer);
            boolean zChanged4 = ((i5 & 112) == 32 ? true : z) | gapComposer.changed(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4) | gapComposer.changed(mutableState3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle6) | gapComposer.changedInstance(librarySongsViewModel3) | gapComposer.changed(r51) | gapComposer.changed(songSortType.ordinal()) | gapComposer.changed(zBooleanValue) | gapComposer.changed(r35) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer.changedInstance(arrayList3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle2) | gapComposer.changedInstance(playerConnection5) | gapComposer.changed(strStringResource5) | gapComposer.changed(menuState);
            Object objRememberedValue21 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue21 == neverEqualPolicy) {
                z2 = true;
                z3 = false;
                LibrarySongsViewModel librarySongsViewModel6 = librarySongsViewModel3;
                lyricsMenuKt$$ExternalSyntheticLambda8 = new LyricsMenuKt$$ExternalSyntheticLambda8(arrayList3, function0, librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4, librarySongsViewModel6, mutableState3, softwareKeyboardController, mutableStateCollectAsStateWithLifecycle6, songSortType, zBooleanValue, anonymousClass2, mimesKt$$ExternalSyntheticLambda0, mutableStateCollectAsStateWithLifecycle3, playerConnection5, strStringResource5, mutableStateCollectAsStateWithLifecycle2, menuState);
                arrayList2 = arrayList3;
                librarySongsViewModel3 = librarySongsViewModel6;
                playerConnection = playerConnection5;
                str = strStringResource5;
                gapComposer.updateRememberedValue(lyricsMenuKt$$ExternalSyntheticLambda8);
            } else {
                lyricsMenuKt$$ExternalSyntheticLambda8 = objRememberedValue21;
                str = strStringResource5;
                arrayList2 = arrayList3;
                z2 = true;
                z3 = false;
                playerConnection = playerConnection5;
            }
            GapComposer gapComposer2 = gapComposer;
            librarySongsViewModel = librarySongsViewModel3;
            IntMath.LazyColumn(null, lazyListState, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) lyricsMenuKt$$ExternalSyntheticLambda8, gapComposer2, 0, 505);
            gapComposer = gapComposer2;
            SongFilter songFilter = (SongFilter) librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4.getValue();
            SongFilter songFilter2 = SongFilter.UPLOADED;
            boolean z4 = (songFilter != songFilter2 && arrayList2.isEmpty()) ? z3 : true;
            int i6 = ((SongFilter) librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4.getValue()) == songFilter2 ? R.drawable.upload : R.drawable.shuffle;
            ArrayList arrayList6 = arrayList2;
            boolean zChanged5 = gapComposer.changed(librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4) | gapComposer.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | gapComposer.changedInstance(playerConnection) | gapComposer.changed(str) | gapComposer.changedInstance(arrayList6);
            Object objRememberedValue22 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue22 == neverEqualPolicy) {
                objRememberedValue22 = new SongMenuKt$$ExternalSyntheticLambda40((Object) managedActivityResultLauncherRememberLauncherForActivityResult, (Object) playerConnection, (Object) str, (Object) arrayList6, (Object) librarySongsScreenKt$LibrarySongsScreen$$inlined$rememberEnumPreference$4, (byte) 18);
                gapComposer.updateRememberedValue(objRememberedValue22);
            }
            MenuKt.HideOnScrollFAB(BoxScopeInstance.INSTANCE, z4, lazyListState, i6, (Function0) objRememberedValue22, null, gapComposer, 6, 16);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        final LibrarySongsViewModel librarySongsViewModel7 = librarySongsViewModel;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(navHostController, function0, librarySongsViewModel7, i, b2) { // from class: com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ NavHostController f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ LibrarySongsViewModel f$2;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    LibrarySongsViewModel librarySongsViewModel8 = this.f$2;
                    Function0 function1 = this.f$1;
                    NavHostController navHostController2 = this.f$0;
                    Composer composer2 = (Composer) obj2;
                    ((Integer) obj3).getClass();
                    switch (b3) {
                        case 0:
                            LibraryScreenKt.LibrarySongsScreen(navHostController2, function1, librarySongsViewModel8, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            LibraryScreenKt.LibrarySongsScreen(navHostController2, function1, librarySongsViewModel8, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    public static final void PodcastArtistChannelItem(String str, String str2, Modifier modifier, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1289713517);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(str2) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(modifier, 20.0f, 8.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
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
            String strResize = str != null ? YouTubeUtilsKt.resize(str, 168, 168) : null;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 56.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            AsyncImageKt.m849AsyncImage10Xjiaw(strResize, Format$$ExternalSyntheticOutline0.m(18.0f, 10.0f, gapComposer, modifierM151size3ABfNKs), ContentScale.Companion.Crop, gapComposer, 1572912, 1976);
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 12.0f));
            TextKt.m352TextNvy7gAk(str2, new LayoutWeightElement(1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer, (i2 >> 3) & 14, 24960, 110588);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 9, i, str, str2, modifier);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void PodcastEpisodePlaylistItem(PodcastEntity podcastEntity, Function0 function0, Function0 function1, Modifier modifier, Composer composer, int i) {
        GapComposer gapComposer;
        Modifier.Companion companion;
        int i2;
        Function0 function2;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        GapComposer gapComposer2;
        GapComposer gapComposer3;
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startRestartGroup(1946684975);
        int i3 = i | (gapComposer4.changed(podcastEntity) ? 4 : 2) | (gapComposer4.changedInstance(function0) ? 32 : 16) | (gapComposer4.changedInstance(function1) ? 256 : 128) | (gapComposer4.changed(modifier) ? 2048 : 1024);
        if (gapComposer4.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(modifier, false, null, function0, 15), 20.0f, 8.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer4, 48);
            int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM136paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            gapComposer4.startReusableNode();
            boolean z = gapComposer4.inserting;
            Function0 function3 = LayoutNode.Constructor;
            if (z) {
                gapComposer4.createNode(function3);
            } else {
                gapComposer4.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda1);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer4, numValueOf, updater$$ExternalSyntheticLambda3);
            Stack.m389reconcileimpl(gapComposer4);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda4);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 56.0f);
            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierM = Format$$ExternalSyntheticOutline0.m(18.0f, 10.0f, gapComposer4, modifierM151size3ABfNKs);
            ProvidableCompositionLocal providableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifierM, ((MaterialTheme$Values) gapComposer4.consume(providableCompositionLocal)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM39backgroundbw27NRU);
            gapComposer4.startReusableNode();
            if (gapComposer4.inserting) {
                gapComposer4.createNode(function3);
            } else {
                gapComposer4.useNode();
            }
            Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda1);
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda3, gapComposer4);
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda4);
            if (podcastEntity.thumbnailUrl != null) {
                gapComposer4.startReplaceGroup(2059452983);
                String str = podcastEntity.thumbnailUrl;
                companion = companion2;
                AsyncImageKt.m849AsyncImage10Xjiaw(str != null ? YouTubeUtilsKt.resize(str, 168, 168) : null, Format$$ExternalSyntheticOutline0.m(18.0f, 10.0f, gapComposer4, SizeKt.m151size3ABfNKs(companion2, 56.0f)), ContentScale.Companion.Crop, gapComposer4, 1572912, 1976);
                GapComposer gapComposer5 = gapComposer4;
                i2 = 0;
                gapComposer5.end(false);
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda1;
                function2 = function3;
                gapComposer2 = gapComposer5;
            } else {
                companion = companion2;
                i2 = 0;
                gapComposer4.startReplaceGroup(2059885216);
                function2 = function3;
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda1;
                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.queue_music, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 28.0f), ((MaterialTheme$Values) gapComposer4.consume(providableCompositionLocal)).colorScheme.onSurfaceVariant, gapComposer4, 440, 0);
                gapComposer4.end(false);
                gapComposer2 = gapComposer4;
            }
            gapComposer2.end(true);
            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, i2);
            int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(function2);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda3, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
            GapComposer gapComposer6 = gapComposer2;
            boolean z2 = i2;
            TextKt.m352TextNvy7gAk(podcastEntity.title, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(providableCompositionLocal)).typography.bodyLarge, gapComposer6, 0, 24960, 110590);
            GapComposer gapComposer7 = gapComposer6;
            String str2 = podcastEntity.author;
            if (str2 == null || StringsKt.isBlank(str2)) {
                gapComposer7.startReplaceGroup(-1583206823);
                gapComposer7.end(z2);
                gapComposer3 = gapComposer7;
            } else {
                gapComposer7.startReplaceGroup(-1583500362);
                TextKt.m352TextNvy7gAk(podcastEntity.author, null, ((MaterialTheme$Values) gapComposer7.consume(providableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer7.consume(providableCompositionLocal)).typography.bodyMedium, gapComposer7, 0, 24960, 110586);
                GapComposer gapComposer8 = gapComposer7;
                gapComposer8.end(z2);
                gapComposer3 = gapComposer8;
            }
            gapComposer3.end(true);
            GapComposer gapComposer9 = gapComposer3;
            CardKt.IconButton(function1, null, false, null, null, f368lambda$1107604815, gapComposer9, ((i3 >> 6) & 14) | 1572864, 62);
            GapComposer gapComposer10 = gapComposer9;
            gapComposer10.end(true);
            gapComposer = gapComposer10;
        } else {
            gapComposer4.skipToGroupEnd();
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda3(podcastEntity, function0, function1, modifier, i, (byte) 13);
        }
    }

    public static final void PodcastEpisodePlaylistMenu(PodcastEntity podcastEntity, MusicDatabase musicDatabase, Function0 function0, Composer composer, int i) {
        MusicDatabase musicDatabase2;
        boolean z;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-362447646);
        int i2 = i | (gapComposer.changed(podcastEntity) ? 4 : 2) | (gapComposer.changedInstance(musicDatabase) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            SyncUtils syncUtils = (SyncUtils) gapComposer.consume(MainActivityKt.LocalSyncUtils);
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.delegate.getSpeedDialDao().isPinned(podcastEntity.id), Boolean.FALSE, gapComposer, 48);
            String strConcat = "https://music.youtube.com/playlist?list=".concat(StringsKt.removePrefix(podcastEntity.id, "MPSP"));
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            int i5 = i2 & 896;
            boolean zChangedInstance = (i5 == 256) | gapComposer.changedInstance(coroutineScope) | (i3 == 32 || gapComposer.changedInstance(musicDatabase)) | (i4 == 4) | gapComposer.changedInstance(syncUtils);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                musicDatabase2 = musicDatabase;
                SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(coroutineScope, function0, musicDatabase2, syncUtils, podcastEntity);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda40;
            } else {
                musicDatabase2 = musicDatabase;
            }
            Material3MenuItemData material3MenuItemData = new Material3MenuItemData(lambda$2075926179, f381lambda$952970332, null, (Function0) objRememberedValue2, null, null, 52);
            boolean zChanged = gapComposer.changed(strConcat) | gapComposer.changedInstance(context) | (i5 == 256);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                z = true;
                objRememberedValue3 = new PlaylistMenuKt$$ExternalSyntheticLambda42(context, function0, strConcat, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                z = true;
            }
            Material3MenuItemData material3MenuItemData2 = new Material3MenuItemData(f380lambda$709019292, lambda$557051493, null, (Function0) objRememberedValue3, null, null, 52);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(801002533, new PlayerKt$$ExternalSyntheticLambda35(mutableStateCollectAsStateWithLifecycle, (byte) 5), gapComposer);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(2067073318, new PlayerKt$$ExternalSyntheticLambda35(mutableStateCollectAsStateWithLifecycle, (byte) 6), gapComposer);
            boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | ((i3 == 32 || gapComposer.changedInstance(musicDatabase2)) ? z : false) | (i4 == 4 ? z : false) | (i5 == 256 ? z : false);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda41 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope, function0, (Object) musicDatabase2, (Object) podcastEntity, (Object) mutableStateCollectAsStateWithLifecycle, (byte) 17);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda41);
                objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda41;
            }
            MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf((Object[]) new Material3MenuItemData[]{material3MenuItemData, material3MenuItemData2, new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue4, null, null, 52)}), gapComposer, 0);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 8, i, podcastEntity, musicDatabase, function0);
        }
    }
}
