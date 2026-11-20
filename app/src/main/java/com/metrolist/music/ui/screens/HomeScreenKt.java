package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Fit$1;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import coil3.Extras;
import coil3.compose.AsyncImageKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.ExplorePage;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda63;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.CommunityPlaylistItem;
import com.metrolist.music.viewmodels.DailyDiscoverItem;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HomeScreenKt {
    public static final List DailyDiscoverMessages = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.daily_discover_sounds_like), Integer.valueOf(R.string.daily_discover_because_you_listen_to), Integer.valueOf(R.string.daily_discover_similar_to), Integer.valueOf(R.string.daily_discover_based_on), Integer.valueOf(R.string.daily_discover_for_fans_of)});

    /* JADX WARN: Code duplicated, block: B:107:0x04da  */
    /* JADX WARN: Code duplicated, block: B:108:0x04de  */
    /* JADX WARN: Code duplicated, block: B:111:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:112:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:115:0x060d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0612  */
    /* JADX WARN: Code duplicated, block: B:119:0x0615  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void CommunityPlaylistCard(final CommunityPlaylistItem communityPlaylistItem, Function0 function0, Function1 function1, Modifier modifier, Composer composer, int i) throws XmlPullParserException, IOException {
        Object obj;
        ContentScale$Companion$Fit$1 contentScale$Companion$Fit$1;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        Map map;
        String strResolve;
        RoundedCornerShape roundedCornerShape;
        Modifier modifierM39backgroundbw27NRU;
        boolean z;
        Modifier.Companion companion;
        Modifier modifier2;
        long j;
        Modifier modifierClip;
        Modifier.Companion companion2;
        Modifier modifier3;
        Modifier modifierClip2;
        Function0 function2;
        int i2;
        long j2;
        NeverEqualPolicy neverEqualPolicy;
        NeverEqualPolicy neverEqualPolicy2;
        GapComposer gapComposer;
        NeverEqualPolicy neverEqualPolicy3;
        boolean zChangedInstance;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy4;
        Integer num;
        String strResize;
        String str;
        FlowRowOverflow flowRowOverflow = OffsetKt.Center;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
        communityPlaylistItem.getClass();
        List list = communityPlaylistItem.songs;
        PlaylistItem playlistItem = communityPlaylistItem.playlist;
        function0.getClass();
        function1.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1907893318);
        int i3 = i | (gapComposer2.changedInstance(communityPlaylistItem) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128) | 3072;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            final PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer2.consume(MainActivityKt.LocalListenTogetherManager);
            boolean z2 = (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) ? false : true;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy5 = Composer.Companion.Empty;
            if (objRememberedValue2 == neverEqualPolicy5) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            Map map2 = (Map) gapComposer2.consume(MainActivityKt.LocalArtistNameAliases);
            String strStringResource = MathKt.stringResource(R.string.and, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(musicDatabase.playlistByBrowseId(playlistItem.id), null, gapComposer2, 48);
            Playlist playlist = (Playlist) mutableStateCollectAsStateWithLifecycle.getValue();
            boolean z3 = (playlist != null ? playlist.playlist.bookmarkedAt : null) != null;
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 8.0f, gapComposer2));
            RoundedCornerShape RoundedCornerShape = UiStyleKt.isGlassStyle(gapComposer2) ? RoundedCornerShapeKt.RoundedCornerShape(50) : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            long j3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
            final boolean z4 = z2;
            Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(GlassComponentsKt.glassCard(DialogKt.pressScale(SizeKt.m155width3ABfNKs(companion3, 300.0f), 0.98f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(28.0f, 12.0f, gapComposer2)), gapComposer2), false, null, function0, 255);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM48combinedClickablehoGz1lA$default);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z5 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
            if (z5) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion3, 1.0f), 16.0f);
            Integer num2 = 120;
            List list2 = list;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), vertical, gapComposer2, 54);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            Modifier modifierClip3 = ClipKt.clip(SizeKt.m151size3ABfNKs(companion3, 88.0f), roundedCornerShapeM185RoundedCornerShape0680j_4);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer2, 0);
            int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierClip3);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            gapComposer2.startReplaceGroup(1958032258);
            int i4 = 0;
            while (true) {
                contentScale$Companion$Fit$1 = ContentScale.Companion.Crop;
                if (i4 >= 2) {
                    break;
                }
                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                int i5 = i4;
                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer2, 0);
                int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda4);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                gapComposer2.startReplaceGroup(990747962);
                int i6 = 0;
                while (i6 < 2) {
                    List list3 = list2;
                    SongItem songItem = (SongItem) CollectionsKt.getOrNull((i5 * 2) + i6, list3);
                    if (songItem == null || (str = songItem.thumbnail) == null) {
                        num = num2;
                        strResize = null;
                    } else {
                        num = num2;
                        strResize = YouTubeUtilsKt.resize(str, num, num);
                    }
                    AsyncImageKt.m849AsyncImage10Xjiaw(strResize, new LayoutWeightElement(1.0f, true).then(SizeKt.FillWholeMaxSize), contentScale$Companion$Fit$1, gapComposer2, 1572912, 1976);
                    list2 = list3;
                    i6++;
                    num2 = num;
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShapeM185RoundedCornerShape0680j_4;
                    companion3 = companion3;
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda0;
                    textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda4;
                }
                gapComposer2.end(false);
                gapComposer2.end(true);
                i4 = i5 + 1;
            }
            RoundedCornerShape roundedCornerShape2 = roundedCornerShapeM185RoundedCornerShape0680j_4;
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda0;
            Modifier.Companion companion4 = companion3;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda5 = textKt$$ExternalSyntheticLambda4;
            String str2 = strStringResource;
            NeverEqualPolicy neverEqualPolicy6 = neverEqualPolicy5;
            Integer num3 = num2;
            gapComposer2.end(false);
            gapComposer2.end(true);
            LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(flowRowOverflow, horizontal, gapComposer2, 6);
            int iHashCode5 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer2, layoutWeightElement2);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda5;
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda5;
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy3, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
            Artist artist = playlistItem.author;
            if (artist != null) {
                ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                map = map2;
                strResolve = ArtistNameAliases.resolve(artist.id, artist.name, map);
            } else {
                map = map2;
                strResolve = null;
            }
            if (strResolve == null) {
                strResolve = "";
            }
            String str3 = strResolve;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda6 = textKt$$ExternalSyntheticLambda3;
            int i7 = i3;
            BiasAlignment.Vertical vertical2 = vertical;
            Map map3 = map;
            float f = 1.0f;
            DialogKt.m1469MicroLabelFNF3uiM(str3, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer2, 0, 2);
            OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion4, 4.0f));
            TextKt.m352TextNvy7gAk(playlistItem.title, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 3, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleLarge, gapComposer2, 0, 24960, 110586);
            GapComposer gapComposer3 = gapComposer2;
            gapComposer3.end(true);
            gapComposer3.end(true);
            DialogKt.m1467EditorialDivideriJQMabo(null, 0L, gapComposer3, 0, 3);
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion4, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer3, 0);
            int iHashCode6 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda6);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, columnMeasurePolicy4, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda3);
            gapComposer3.startReplaceGroup(1829671819);
            Iterator it = CollectionsKt.take(list2, 3).iterator();
            int i8 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
                }
                SongItem songItem2 = (SongItem) next;
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion4, f);
                int i10 = i7;
                boolean zChangedInstance2 = ((i10 & 896) == 256) | gapComposer3.changedInstance(songItem2);
                Object objRememberedValue3 = gapComposer3.rememberedValue();
                if (zChangedInstance2) {
                    neverEqualPolicy = neverEqualPolicy6;
                } else {
                    neverEqualPolicy = neverEqualPolicy6;
                    if (objRememberedValue3 != neverEqualPolicy) {
                        neverEqualPolicy2 = neverEqualPolicy;
                    }
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(DialogKt.m1473hairlineBottomiJQMabo(ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue3, 255), gapComposer3, 0), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    BiasAlignment.Vertical vertical3 = vertical2;
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), vertical3, gapComposer3, 54);
                    int iHashCode7 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    Iterator it2 = it;
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda6);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy3, updater$$ExternalSyntheticLambda4);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda3);
                    String strValueOf = String.valueOf(i9);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    gapComposer = gapComposer3;
                    neverEqualPolicy3 = neverEqualPolicy2;
                    i7 = i10;
                    TextKt.m352TextNvy7gAk(strValueOf, SizeKt.m155width3ABfNKs(companion4, 12.0f), ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.labelSmall, gapComposer, 48, 0, 131064);
                    AsyncImageKt.m849AsyncImage10Xjiaw(YouTubeUtilsKt.resize(songItem2.thumbnail, num3, num3), ClipKt.clip(SizeKt.m151size3ABfNKs(companion4, 40.0f), roundedCornerShape2), contentScale$Companion$Fit$1, gapComposer, 1572912, 1976);
                    LayoutWeightElement layoutWeightElement3 = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                    int iHashCode8 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement3);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda6);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy5, updater$$ExternalSyntheticLambda4);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(songItem2.title, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer, 0, 24960, 110586);
                    List list4 = songItem2.artists;
                    String str4 = str2;
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, str4, ServerSentEventKt.SPACE);
                    Map map4 = map3;
                    zChangedInstance = gapComposer.changedInstance(map4);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance) {
                        neverEqualPolicy4 = neverEqualPolicy3;
                    } else {
                        neverEqualPolicy4 = neverEqualPolicy3;
                        if (objRememberedValue == neverEqualPolicy4) {
                        }
                        neverEqualPolicy6 = neverEqualPolicy4;
                        map3 = map4;
                        TextKt.m352TextNvy7gAk(UtilsKt.joinToArtistString(list4, strM, (Function1) objRememberedValue), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer, 0, 24960, 110586);
                        gapComposer3 = gapComposer;
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                        arrangement$Top$1 = arrangement$Top$1;
                        it = it2;
                        i8 = i9;
                        vertical2 = vertical3;
                        horizontal = horizontal;
                        str2 = str4;
                        f = 1.0f;
                    }
                    objRememberedValue = new QueueKt$$ExternalSyntheticLambda40(map4, (byte) 11);
                    gapComposer.updateRememberedValue(objRememberedValue);
                    neverEqualPolicy6 = neverEqualPolicy4;
                    map3 = map4;
                    TextKt.m352TextNvy7gAk(UtilsKt.joinToArtistString(list4, strM, (Function1) objRememberedValue), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer, 0, 24960, 110586);
                    gapComposer3 = gapComposer;
                    gapComposer3.end(true);
                    gapComposer3.end(true);
                    arrangement$Top$1 = arrangement$Top$1;
                    it = it2;
                    i8 = i9;
                    vertical2 = vertical3;
                    horizontal = horizontal;
                    str2 = str4;
                    f = 1.0f;
                }
                neverEqualPolicy2 = neverEqualPolicy;
                objRememberedValue3 = new QueueKt$$ExternalSyntheticLambda16(function1, songItem2, (byte) 4);
                gapComposer3.updateRememberedValue(objRememberedValue3);
                Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(DialogKt.m1473hairlineBottomiJQMabo(ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue3, 255), gapComposer3, 0), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                BiasAlignment.Vertical vertical4 = vertical2;
                RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), vertical4, gapComposer3, 54);
                int iHashCode9 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default3);
                ComposeUiNode.Companion.getClass();
                gapComposer3.startReusableNode();
                Iterator it3 = it;
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(textKt$$ExternalSyntheticLambda6);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m390setimpl(gapComposer3, rowMeasurePolicy4, updater$$ExternalSyntheticLambda4);
                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode9, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier9, updater$$ExternalSyntheticLambda3);
                String strValueOf2 = String.valueOf(i9);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                gapComposer = gapComposer3;
                neverEqualPolicy3 = neverEqualPolicy2;
                i7 = i10;
                TextKt.m352TextNvy7gAk(strValueOf2, SizeKt.m155width3ABfNKs(companion4, 12.0f), ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).typography.labelSmall, gapComposer, 48, 0, 131064);
                AsyncImageKt.m849AsyncImage10Xjiaw(YouTubeUtilsKt.resize(songItem2.thumbnail, num3, num3), ClipKt.clip(SizeKt.m151size3ABfNKs(companion4, 40.0f), roundedCornerShape2), contentScale$Companion$Fit$1, gapComposer, 1572912, 1976);
                LayoutWeightElement layoutWeightElement4 = new LayoutWeightElement(1.0f, true);
                ColumnMeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                int iHashCode10 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement4);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda6);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, columnMeasurePolicy6, updater$$ExternalSyntheticLambda4);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode10, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier10, updater$$ExternalSyntheticLambda3);
                TextKt.m352TextNvy7gAk(songItem2.title, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).typography.bodyMedium, gapComposer, 0, 24960, 110586);
                List list5 = songItem2.artists;
                String str5 = str2;
                String strM2 = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, str5, ServerSentEventKt.SPACE);
                Map map5 = map3;
                zChangedInstance = gapComposer.changedInstance(map5);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    neverEqualPolicy4 = neverEqualPolicy3;
                    if (objRememberedValue == neverEqualPolicy4) {
                    }
                    neverEqualPolicy6 = neverEqualPolicy4;
                    map3 = map5;
                    TextKt.m352TextNvy7gAk(UtilsKt.joinToArtistString(list5, strM2, (Function1) objRememberedValue), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).typography.bodySmall, gapComposer, 0, 24960, 110586);
                    gapComposer3 = gapComposer;
                    gapComposer3.end(true);
                    gapComposer3.end(true);
                    arrangement$Top$1 = arrangement$Top$1;
                    it = it3;
                    i8 = i9;
                    vertical2 = vertical4;
                    horizontal = horizontal;
                    str2 = str5;
                    f = 1.0f;
                } else {
                    neverEqualPolicy4 = neverEqualPolicy3;
                }
                objRememberedValue = new QueueKt$$ExternalSyntheticLambda40(map5, (byte) 11);
                gapComposer.updateRememberedValue(objRememberedValue);
                neverEqualPolicy6 = neverEqualPolicy4;
                map3 = map5;
                TextKt.m352TextNvy7gAk(UtilsKt.joinToArtistString(list5, strM2, (Function1) objRememberedValue), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).typography.bodySmall, gapComposer, 0, 24960, 110586);
                gapComposer3 = gapComposer;
                gapComposer3.end(true);
                gapComposer3.end(true);
                arrangement$Top$1 = arrangement$Top$1;
                it = it3;
                i8 = i9;
                vertical2 = vertical4;
                horizontal = horizontal;
                str2 = str5;
                f = 1.0f;
            }
            BiasAlignment.Vertical vertical5 = vertical2;
            NeverEqualPolicy neverEqualPolicy7 = neverEqualPolicy6;
            gapComposer3.end(false);
            gapComposer3.end(true);
            Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion4, 1.0f), 16.0f);
            RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), vertical5, gapComposer3, 54);
            int iHashCode11 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope11 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier11 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM135padding3ABfNKs2);
            ComposeUiNode.Companion.getClass();
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda6);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, rowMeasurePolicy5, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope11, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode11, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier11, updater$$ExternalSyntheticLambda3);
            Modifier modifierPressScale = DialogKt.pressScale(SizeKt.m145height3ABfNKs(new LayoutWeightElement(1.0f, true), 44.0f), 0.95f);
            if (UiStyleKt.isGlassStyle(gapComposer3)) {
                gapComposer3.startReplaceGroup(1989149023);
                Modifier modifierM1481glassTintedFNF3uiM = GlassComponentsKt.m1481glassTintedFNF3uiM(companion4, RoundedCornerShapeKt.RoundedCornerShape(50), gapComposer3);
                gapComposer3.end(false);
                modifierM39backgroundbw27NRU = modifierM1481glassTintedFNF3uiM;
                roundedCornerShape = RoundedCornerShape;
            } else {
                gapComposer3.startReplaceGroup(1989262979);
                roundedCornerShape = RoundedCornerShape;
                modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(companion4, roundedCornerShape), ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, ColorKt.RectangleShape);
                gapComposer3.end(false);
            }
            Modifier modifierThen = modifierPressScale.then(modifierM39backgroundbw27NRU);
            int i11 = i7 & 14;
            boolean zChanged = gapComposer3.changed(z4) | (i11 == 4 || gapComposer3.changedInstance(communityPlaylistItem)) | gapComposer3.changedInstance(playerConnection);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy7) {
                z = false;
                final Object[] objArr = null == true ? 1 : 0;
                objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda110
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        WatchEndpoint watchEndpoint;
                        WatchEndpoint watchEndpoint2;
                        byte b = objArr;
                        Unit unit = Unit.INSTANCE;
                        PlayerConnection playerConnection2 = playerConnection;
                        CommunityPlaylistItem communityPlaylistItem2 = communityPlaylistItem;
                        boolean z6 = z4;
                        switch (b) {
                            case 0:
                                if (!z6 && (watchEndpoint = communityPlaylistItem2.playlist.playEndpoint) != null && playerConnection2 != null) {
                                    playerConnection2.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                                }
                                break;
                            default:
                                if (!z6 && (watchEndpoint2 = communityPlaylistItem2.playlist.radioEndpoint) != null && playerConnection2 != null) {
                                    playerConnection2.playQueue(new YouTubeQueue(watchEndpoint2, null, 2, null));
                                }
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer3.updateRememberedValue(objRememberedValue4);
            } else {
                z = false;
            }
            Modifier modifierM48combinedClickablehoGz1lA$default2 = ImageKt.m48combinedClickablehoGz1lA$default(modifierThen, z, null, (Function0) objRememberedValue4, 255);
            RowMeasurePolicy rowMeasurePolicy6 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical5, gapComposer3, 54);
            int iHashCode12 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope12 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier12 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM48combinedClickablehoGz1lA$default2);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda6);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, rowMeasurePolicy6, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope12, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode12, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier12, updater$$ExternalSyntheticLambda3);
            Painter painterPainterResource = IntMath.painterResource(R.drawable.play, 0, gapComposer3);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
            GapComposer gapComposer4 = gapComposer3;
            IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion4, 20.0f), ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.onPrimary, gapComposer4, 440, 0);
            String upperCase = Format$$ExternalSyntheticOutline0.m(companion4, 8.0f, gapComposer4, R.string.play, gapComposer4).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            TextKt.m352TextNvy7gAk(upperCase, null, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onPrimary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).typography.labelLarge, gapComposer4, 0, 0, 131066);
            gapComposer4.end(true);
            BiasAlignment biasAlignment = Alignment.Companion.Center;
            Modifier modifierPressScale2 = DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion4, 44.0f), 0.92f);
            if (UiStyleKt.isGlassStyle(gapComposer4)) {
                gapComposer4.startReplaceGroup(1726789417);
                companion = companion4;
                modifier2 = modifierPressScale2;
                Modifier modifierGlass = GlassComponentsKt.glass(companion, RoundedCornerShapeKt.CircleShape, false, gapComposer4, 6, 2);
                gapComposer4.end(false);
                modifierClip = modifierGlass;
                j = j3;
            } else {
                companion = companion4;
                modifier2 = modifierPressScale2;
                gapComposer4.startReplaceGroup(1726791624);
                gapComposer4.end(false);
                j = j3;
                modifierClip = ClipKt.clip(ImageKt.m42borderxT4_qwU(companion, 1.0f, j, roundedCornerShape), roundedCornerShape);
            }
            Modifier modifierThen2 = modifier2.then(modifierClip);
            boolean zChanged2 = gapComposer4.changed(z4) | (i11 == 4 || gapComposer4.changedInstance(communityPlaylistItem)) | gapComposer4.changedInstance(playerConnection);
            Object objRememberedValue5 = gapComposer4.rememberedValue();
            if (zChanged2 || objRememberedValue5 == neverEqualPolicy7) {
                final byte b = 1;
                objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda110
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        WatchEndpoint watchEndpoint;
                        WatchEndpoint watchEndpoint2;
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        PlayerConnection playerConnection2 = playerConnection;
                        CommunityPlaylistItem communityPlaylistItem2 = communityPlaylistItem;
                        boolean z6 = z4;
                        switch (b2) {
                            case 0:
                                if (!z6 && (watchEndpoint = communityPlaylistItem2.playlist.playEndpoint) != null && playerConnection2 != null) {
                                    playerConnection2.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                                }
                                break;
                            default:
                                if (!z6 && (watchEndpoint2 = communityPlaylistItem2.playlist.radioEndpoint) != null && playerConnection2 != null) {
                                    playerConnection2.playQueue(new YouTubeQueue(watchEndpoint2, null, 2, null));
                                }
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer4.updateRememberedValue(objRememberedValue5);
            }
            Modifier modifierM48combinedClickablehoGz1lA$default3 = ImageKt.m48combinedClickablehoGz1lA$default(modifierThen2, false, null, (Function0) objRememberedValue5, 255);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode13 = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope13 = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier13 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM48combinedClickablehoGz1lA$default3);
            gapComposer4.startReusableNode();
            if (gapComposer4.inserting) {
                gapComposer4.createNode(textKt$$ExternalSyntheticLambda6);
            } else {
                gapComposer4.useNode();
            }
            Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope13, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode13, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier13, updater$$ExternalSyntheticLambda3);
            long j4 = j;
            Modifier.Companion companion5 = companion;
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.radio, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 22.0f), ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onSurface, gapComposer4, 440, 0);
            gapComposer4.end(true);
            Modifier modifierPressScale3 = DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion5, 44.0f), 0.92f);
            if (UiStyleKt.isGlassStyle(gapComposer4)) {
                gapComposer4.startReplaceGroup(1726824105);
                companion2 = companion5;
                modifier3 = modifierPressScale3;
                modifierClip2 = GlassComponentsKt.glass(companion2, RoundedCornerShapeKt.CircleShape, false, gapComposer4, 6, 2);
                gapComposer4.end(false);
            } else {
                companion2 = companion5;
                modifier3 = modifierPressScale3;
                gapComposer4.startReplaceGroup(1726826312);
                gapComposer4.end(false);
                modifierClip2 = ClipKt.clip(ImageKt.m42borderxT4_qwU(companion2, 1.0f, j4, roundedCornerShape), roundedCornerShape);
            }
            Modifier modifierThen3 = modifier3.then(modifierClip2);
            boolean zChangedInstance3 = gapComposer4.changedInstance(coroutineScope) | gapComposer4.changed(mutableStateCollectAsStateWithLifecycle) | (i11 == 4 || gapComposer4.changedInstance(communityPlaylistItem)) | gapComposer4.changedInstance(musicDatabase);
            Object objRememberedValue6 = gapComposer4.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy7) {
                function2 = null;
                i2 = 255;
                SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope, (Object) communityPlaylistItem, musicDatabase, (Object) mutableStateCollectAsStateWithLifecycle, (byte) 26);
                gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                objRememberedValue6 = songMenuKt$$ExternalSyntheticLambda63;
            } else {
                function2 = null;
                i2 = 255;
            }
            Modifier modifierM48combinedClickablehoGz1lA$default4 = ImageKt.m48combinedClickablehoGz1lA$default(modifierThen3, false, function2, (Function0) objRememberedValue6, i2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode14 = Long.hashCode(gapComposer4.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope14 = gapComposer4.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier14 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM48combinedClickablehoGz1lA$default4);
            gapComposer4.startReusableNode();
            if (gapComposer4.inserting) {
                gapComposer4.createNode(textKt$$ExternalSyntheticLambda6);
            } else {
                gapComposer4.useNode();
            }
            Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda4);
            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope14, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode14, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier14, updater$$ExternalSyntheticLambda3);
            Painter painterPainterResource2 = IntMath.painterResource(z3 ? R.drawable.library_add_check : R.drawable.library_add, 0, gapComposer4);
            if (z3) {
                gapComposer4.startReplaceGroup(-100439109);
                j2 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.primary;
            } else {
                gapComposer4.startReplaceGroup(-100437859);
                j2 = ((MaterialTheme$Values) gapComposer4.consume(r18)).colorScheme.onSurface;
            }
            gapComposer4.end(false);
            Modifier.Companion companion6 = companion2;
            IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, SizeKt.m151size3ABfNKs(companion6, 22.0f), j2, gapComposer4, 440, 0);
            gapComposer2 = gapComposer4;
            Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, true, true, true);
            obj = companion6;
        } else {
            gapComposer2.skipToGroupEnd();
            obj = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda3(communityPlaylistItem, function0, function1, obj, i, (byte) 11);
        }
    }

    public static final void DailyDiscoverCard(DailyDiscoverItem dailyDiscoverItem, Function0 function0, Modifier modifier, Composer composer, int i) throws IOException {
        Modifier modifierM39backgroundbw27NRU;
        dailyDiscoverItem.getClass();
        Song song = dailyDiscoverItem.seed;
        SongItem songItem = dailyDiscoverItem.recommendation;
        String str = songItem.thumbnail;
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1638725177);
        int i2 = i | (gapComposer.changedInstance(dailyDiscoverItem) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(((MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase)).$$delegate_0.getLifetimePlayCount(songItem.id), 0, gapComposer, 48);
            MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            Map map = (Map) gapComposer.consume(MainActivityKt.LocalArtistNameAliases);
            String strStringResource = MathKt.stringResource(R.string.plays, gapComposer);
            String strStringResource2 = MathKt.stringResource(R.string.and, gapComposer);
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            boolean zChanged = gapComposer.changed(str);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            String strJoinToArtistString = null;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                ImageRequest.Builder builder = new ImageRequest.Builder(context);
                builder.data = str != null ? YouTubeUtilsKt.resize(str, 640, 640) : null;
                Extras.Key key = ImageRequestsKt.transformationsKey;
                ImageRequests_androidKt.crossfade(builder, 0);
                objRememberedValue = builder.build();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ImageRequest imageRequest = (ImageRequest) objRememberedValue;
            Modifier modifierGlassCard = GlassComponentsKt.glassCard(DialogKt.pressScale(modifier.then(SizeKt.FillWholeMaxSize), 0.98f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(28.0f, 12.0f, gapComposer)), gapComposer);
            boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback) | gapComposer.changedInstance(songItem) | gapComposer.changed(menuState);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda24((Object) hapticFeedback, (Object) songItem, (Object) menuState, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m48combinedClickablehoGz1lA$default(modifierGlassCard, false, (Function0) objRememberedValue2, function0, 239), UiStyleKt.m1516styledRadiusi1RSzL4(14.0f, 12.0f, gapComposer));
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            AsyncImageKt.m849AsyncImage10Xjiaw(imageRequest, Format$$ExternalSyntheticOutline0.m(20.0f, 8.0f, gapComposer, SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f)), ContentScale.Companion.Crop, gapComposer, 1572912, 1976);
            SongEntity songEntity = song.song;
            SongEntity songEntity2 = song.song;
            boolean zChanged2 = gapComposer.changed(songEntity.id);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                int iAbs = Math.abs(songEntity2.id.hashCode());
                List list = DailyDiscoverMessages;
                objRememberedValue3 = Integer.valueOf(((Number) list.get(iAbs % list.size())).intValue());
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            int iIntValue = ((Number) objRememberedValue3).intValue();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
            String str2 = songEntity2.title;
            List list2 = song.artists;
            String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, strStringResource2, ServerSentEventKt.SPACE);
            boolean zChangedInstance2 = gapComposer.changedInstance(map);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 12);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            String strStringResource3 = MathKt.stringResource(iIntValue, new Object[]{Fragment$5$$ExternalSyntheticOutline0.m(str2, " • ", UtilsKt.joinToArtistString(list2, strM, (Function1) objRememberedValue4))}, gapComposer);
            Locale locale = Locale.ROOT;
            String upperCase = strStringResource3.toUpperCase(locale);
            upperCase.getClass();
            TextKt.m352TextNvy7gAk(upperCase, null, CardKt.getColorScheme(gapComposer).primary, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer).labelSmall, gapComposer, 0, 24960, 110586);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 4.0f));
            TextKt.m352TextNvy7gAk(songItem.title, null, CardKt.getColorScheme(gapComposer).onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 2, 0, CardKt.getTypography(gapComposer).headlineSmall, gapComposer, 0, 24960, 110586);
            gapComposer.startReplaceGroup(-1235450762);
            StringBuilder sb = new StringBuilder();
            List list3 = songItem.artists;
            if (list3 == null) {
                gapComposer.startReplaceGroup(-2136204726);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(900921495);
                String str3 = ServerSentEventKt.SPACE + strStringResource2 + ServerSentEventKt.SPACE;
                boolean zChangedInstance3 = gapComposer.changedInstance(map);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 13);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                strJoinToArtistString = UtilsKt.joinToArtistString(list3, str3, (Function1) objRememberedValue5);
                gapComposer.end(false);
            }
            if (strJoinToArtistString == null) {
                strJoinToArtistString = "";
            }
            sb.append(strJoinToArtistString);
            if (((Number) mutableStateCollectAsStateWithLifecycle.getValue()).intValue() > 0) {
                sb.append(" | " + ((Number) mutableStateCollectAsStateWithLifecycle.getValue()).intValue() + ServerSentEventKt.SPACE + strStringResource);
            }
            String string = sb.toString();
            gapComposer.end(false);
            TextKt.m352TextNvy7gAk(string, null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer).bodyMedium, gapComposer, 0, 24960, 110586);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), UiStyleKt.m1516styledRadiusi1RSzL4(44.0f, 40.0f, gapComposer));
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(356723393);
                modifierM39backgroundbw27NRU = GlassComponentsKt.m1481glassTintedFNF3uiM(companion, RoundedCornerShapeKt.RoundedCornerShape(50), gapComposer);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(356829816);
                modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(companion, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), CardKt.getColorScheme(gapComposer).primary, ColorKt.RectangleShape);
                gapComposer.end(false);
            }
            Modifier modifierThen = modifierM145height3ABfNKs.then(modifierM39backgroundbw27NRU);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer, 54);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), CardKt.getColorScheme(gapComposer).onPrimary, gapComposer, 440, 0);
            String upperCase2 = Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer, R.string.play, gapComposer).toUpperCase(locale);
            upperCase2.getClass();
            TextKt.m352TextNvy7gAk(upperCase2, null, CardKt.getColorScheme(gapComposer).onPrimary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelLarge, gapComposer, 0, 0, 131066);
            gapComposer = gapComposer;
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlbumScreenKt$$ExternalSyntheticLambda8((byte) 6, i, dailyDiscoverItem, function0, modifier);
        }
    }

    public static final void HomeScreen(final SnackbarHostState snackbarHostState, HomeViewModel homeViewModel, Composer composer, final int i) {
        final HomeViewModel homeViewModel2;
        final HomeViewModel homeViewModel3;
        boolean z;
        float f;
        int i2;
        MutableState mutableStateCollectAsStateWithLifecycle;
        Continuation continuation;
        Continuation continuation2;
        Object dataStoreKt$get$2;
        MutableState mutableState;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        HomeViewModel homeViewModel4;
        SavedStateHandle savedStateHandle;
        ExplorePage explorePage;
        snackbarHostState.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1338740769);
        int i3 = i | 16;
        final byte b = 0;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 17) != 16)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
                if (viewModelStoreOwner == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    return;
                }
                homeViewModel3 = (HomeViewModel) coil3.util.UtilsKt.viewModel(Reflection.getOrCreateKotlinClass(HomeViewModel.class), viewModelStoreOwner, MathKt.rememberHiltViewModelFactory(ViewModelKt.getViewModelProviderFactory(viewModelStoreOwner), gapComposer), ViewModelKt.getViewModelCreationExtras(viewModelStoreOwner), gapComposer);
            } else {
                gapComposer.skipToGroupEnd();
                homeViewModel3 = homeViewModel;
            }
            gapComposer.endDefaults();
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            MenuState menuState = (MenuState) gapComposer.consume(BottomSheetMenuKt.LocalMenuState);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            PlayerConnection playerConnection = (PlayerConnection) gapComposer.consume(MainActivityKt.LocalPlayerConnection);
            if (playerConnection == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(snackbarHostState, homeViewModel3, i, b) { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ SnackbarHostState f$0;
                        public final /* synthetic */ HomeViewModel f$1;

                        {
                            this.$r8$classId = b;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b2 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            HomeViewModel homeViewModel5 = this.f$1;
                            SnackbarHostState snackbarHostState2 = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b2) {
                                case 0:
                                    HomeScreenKt.HomeScreen(snackbarHostState2, homeViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                                default:
                                    HomeScreenKt.HomeScreen(snackbarHostState2, homeViewModel5, composer2, Stack.updateChangedFlags(1));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            ListenTogetherManager listenTogetherManager = (ListenTogetherManager) gapComposer.consume(MainActivityKt.LocalListenTogetherManager);
            if (listenTogetherManager != null) {
                z = listenTogetherManager.client.isInRoom() && !listenTogetherManager.isHost();
            } else {
                z = false;
            }
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.isEffectivelyPlaying, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FileSystemsKt.collectAsStateWithLifecycle(playerConnection.mediaMetadata, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.quickPicks, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.forgottenFavorites, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle6 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.keepListening, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle7 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.similarRecommendations, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle8 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.accountPlaylists, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle9 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.homePage, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle10 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.explorePage, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle11 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.dailyDiscover, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle12 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.communityPlaylists, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle13 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.allLocalItems, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle14 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.allYtItems, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle15 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.speedDialItems, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle16 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.pinnedSpeedDialItems, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle17 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.selectedChip, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle18 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.savedPodcastShows, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle19 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.episodesForLater, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle20 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.isLoading, gapComposer);
            if (((Boolean) mutableStateCollectAsStateWithLifecycle20.getValue()).booleanValue() && (explorePage = (ExplorePage) mutableStateCollectAsStateWithLifecycle10.getValue()) != null) {
                List list8 = explorePage.moodAndGenres;
            }
            MutableState mutableStateCollectAsStateWithLifecycle21 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.isRefreshing, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle22 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.isRandomizing, gapComposer);
            PullToRefreshStateImpl pullToRefreshStateImplRememberPullToRefreshState = coil3.size.SizeKt.rememberPullToRefreshState(gapComposer);
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(gapComposer);
            LazyGridState lazyGridStateRememberLazyGridState2 = LazyGridStateKt.rememberLazyGridState(gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle23 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.accountName, gapComposer);
            MutableState mutableStateCollectAsStateWithLifecycle24 = FileSystemsKt.collectAsStateWithLifecycle(homeViewModel3.accountImageUrl, gapComposer);
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.InnerTubeCookieKey, "", gapComposer, 48);
            Preferences$Key preferences$Key = PreferenceKeysKt.RandomizeHomeOrderKey;
            Boolean bool = Boolean.TRUE;
            boolean zBooleanValue = ((Boolean) UtilsKt.rememberPreference(preferences$Key, bool, gapComposer, 48).$state.getValue()).booleanValue();
            DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference2 = UtilsKt.rememberPreference(PreferenceKeysKt.AutoRadioQueueKey, bool, gapComposer, 48);
            boolean zChangedInstance = gapComposer.changedInstance(homeViewModel3);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new HomeViewModel.AnonymousClass1(homeViewModel3, null, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Unit unit = Unit.INSTANCE;
            Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue);
            boolean zChanged = gapComposer.changed((String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue());
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Boolean.valueOf(StringsKt__IndentKt.parseCookieString((String) dataStoreKt$rememberPreference$1$1RememberPreference.$state.getValue()).containsKey("SAPISID"));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            String str = ((Boolean) objRememberedValue2).booleanValue() ? (String) mutableStateCollectAsStateWithLifecycle24.getValue() : null;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            Collection collectionTake = EmptyList.INSTANCE;
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(collectionTake);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            boolean zChanged2 = gapComposer.changed((HomePage) mutableStateCollectAsStateWithLifecycle9.getValue()) | gapComposer.changed((HomePage.Chip) mutableStateCollectAsStateWithLifecycle17.getValue());
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                if (((HomePage.Chip) mutableStateCollectAsStateWithLifecycle17.getValue()) == null) {
                    mutableState2.setValue(collectionTake);
                } else {
                    HomePage homePage = (HomePage) mutableStateCollectAsStateWithLifecycle9.getValue();
                    if (homePage != null) {
                        List list9 = homePage.sections;
                        ArrayList arrayList = new ArrayList();
                        Iterator it = list9.iterator();
                        while (it.hasNext()) {
                            CollectionsKt__MutableCollectionsKt.addAll(((HomePage.Section) it.next()).items, arrayList);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int size = arrayList.size();
                        int i4 = 0;
                        while (i4 < size) {
                            int i5 = size;
                            Object obj = arrayList.get(i4);
                            int i6 = i4 + 1;
                            if (obj instanceof EpisodeItem) {
                                arrayList2.add(obj);
                            }
                            size = i5;
                            i4 = i6;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        int size2 = arrayList2.size();
                        int i7 = 0;
                        while (i7 < size2) {
                            Object obj2 = arrayList2.get(i7);
                            int i8 = i7 + 1;
                            ArrayList arrayList4 = arrayList2;
                            EpisodeItem episodeItem = (EpisodeItem) obj2;
                            int i9 = size2;
                            Album album = episodeItem.podcast;
                            PodcastItem podcastItem = album != null ? new PodcastItem(album.id, album.name, episodeItem.author, null, episodeItem.thumbnail, null, null, null, null, null, 896) : null;
                            if (podcastItem != null) {
                                arrayList3.add(podcastItem);
                            }
                            size2 = i9;
                            arrayList2 = arrayList4;
                            i7 = i8;
                        }
                        HashSet hashSet = new HashSet();
                        ArrayList arrayList5 = new ArrayList();
                        int size3 = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size3) {
                            int i11 = size3;
                            Object obj3 = arrayList3.get(i10);
                            i10++;
                            ArrayList arrayList6 = arrayList3;
                            if (hashSet.add(((PodcastItem) obj3).id)) {
                                arrayList5.add(obj3);
                            }
                            size3 = i11;
                            arrayList3 = arrayList6;
                        }
                        List mutableList = CollectionsKt.toMutableList((Iterable) arrayList5);
                        Collections.shuffle(mutableList);
                        collectionTake = CollectionsKt.take(mutableList, 10);
                    }
                    if (!collectionTake.isEmpty()) {
                        mutableState2.setValue(collectionTake);
                    }
                    collectionTake = (List) mutableState2.getValue();
                }
                gapComposer.updateRememberedValue(collectionTake);
                objRememberedValue4 = collectionTake;
            }
            List list10 = (List) objRememberedValue4;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue6;
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            Preferences$Key preferences$Key2 = PreferenceKeysKt.GridItemsSizeKey;
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue7;
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key2, (byte) 23));
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            GridItemSize gridItemSize = GridItemSize.BIG;
            MutableState mutableStateCollectAsStateWithLifecycle25 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue8, gridItemSize, gapComposer, 48);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle25, coroutineScope2, context, preferences$Key2);
                gapComposer.updateRememberedValue(objRememberedValue9);
            }
            if (((GridItemSize) ((Enum) ((HomeScreenKt$HomeScreen$$inlined$rememberEnumPreference$2) objRememberedValue9).$state.getValue())) == gridItemSize) {
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                f = 128.0f;
            } else {
                SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                f = 104.0f;
            }
            float f2 = f;
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets(OffsetKt.current(gapComposer).systemBars, 15), gapComposer);
            PaddingValuesImpl paddingValuesImplM128PaddingValuesa9UjIt4$default = OffsetKt.m128PaddingValuesa9UjIt4$default(OffsetKt.calculateStartPadding(insetsPaddingValuesAsPaddingValues, layoutDirection) + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, OffsetKt.calculateEndPadding(insetsPaddingValuesAsPaddingValues, layoutDirection) + 8.0f + CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            MutableState mutableStateCurrentBackStackEntryAsState = IntMath.currentBackStackEntryAsState(navHostController, gapComposer);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableStateCurrentBackStackEntryAsState.getValue();
            ReadonlyStateFlow stateFlow = (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) ? null : savedStateHandle.getStateFlow(Boolean.FALSE, "scrollToTop");
            if (stateFlow == null) {
                gapComposer.startReplaceGroup(645992453);
                i2 = 0;
                gapComposer.end(false);
                mutableStateCollectAsStateWithLifecycle = null;
            } else {
                i2 = 0;
                gapComposer.startReplaceGroup(1960501116);
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(stateFlow, gapComposer);
                gapComposer.end(false);
            }
            Object[] objArr = new Object[i2];
            Object objRememberedValue10 = gapComposer.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new QueueKt$$ExternalSyntheticLambda2((byte) 29);
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue10, gapComposer, 48);
            Boolean bool2 = (Boolean) mutableStateCollectAsStateWithLifecycle21.getValue();
            bool2.getClass();
            boolean zChanged3 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle21) | gapComposer.changed(parcelableSnapshotMutableLongState);
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue11 == neverEqualPolicy) {
                continuation = null;
                objRememberedValue11 = new InterruptibleKt$runInterruptible$2(mutableStateCollectAsStateWithLifecycle21, parcelableSnapshotMutableLongState, continuation, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue11);
            } else {
                continuation = null;
            }
            Stack.LaunchedEffect(gapComposer, bool2, (Function2) objRememberedValue11);
            Object obj4 = mutableStateCollectAsStateWithLifecycle != null ? (Boolean) mutableStateCollectAsStateWithLifecycle.getValue() : continuation;
            boolean zChanged4 = gapComposer.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(mutableStateCurrentBackStackEntryAsState);
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue12 == neverEqualPolicy) {
                continuation2 = continuation;
                HomeScreenKt$HomeScreen$3$1 homeScreenKt$HomeScreen$3$1 = new HomeScreenKt$HomeScreen$3$1(mutableStateCollectAsStateWithLifecycle, lazyListStateRememberLazyListState, mutableStateCurrentBackStackEntryAsState, continuation2, (byte) 0);
                lazyListStateRememberLazyListState = lazyListStateRememberLazyListState;
                gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$3$1);
                objRememberedValue12 = homeScreenKt$HomeScreen$3$1;
            } else {
                continuation2 = continuation;
            }
            Stack.LaunchedEffect(gapComposer, obj4, (Function2) objRememberedValue12);
            boolean zChanged5 = gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changedInstance(homeViewModel3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle9);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
                dataStoreKt$get$2 = new DataStoreKt$get$2((Object) lazyListStateRememberLazyListState, (Object) homeViewModel3, (Object) mutableStateCollectAsStateWithLifecycle9, continuation2, (byte) 14);
                mutableState = mutableStateCollectAsStateWithLifecycle9;
                gapComposer.updateRememberedValue(dataStoreKt$get$2);
            } else {
                dataStoreKt$get$2 = objRememberedValue13;
                mutableState = mutableStateCollectAsStateWithLifecycle9;
            }
            Stack.LaunchedEffect(gapComposer, unit, (Function2) dataStoreKt$get$2);
            if (((HomePage.Chip) mutableStateCollectAsStateWithLifecycle17.getValue()) != null) {
                gapComposer.startReplaceGroup(646932002);
                boolean zChangedInstance2 = gapComposer.changedInstance(homeViewModel3) | gapComposer.changed(mutableStateCollectAsStateWithLifecycle17);
                Object objRememberedValue14 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue14 == neverEqualPolicy) {
                    objRememberedValue14 = new QueueKt$$ExternalSyntheticLambda16(homeViewModel3, mutableStateCollectAsStateWithLifecycle17, (byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue14);
                }
                coil3.util.UtilsKt.BackHandler(false, (Function0) objRememberedValue14, gapComposer, 0, 1);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(647086723);
                gapComposer.end(false);
            }
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1749070653, new HomeScreenKt$$ExternalSyntheticLambda3(hapticFeedback, menuState, z, mutableStateCollectAsStateWithLifecycle3, playerConnection, dataStoreKt$rememberPreference$1$1RememberPreference2, navHostController, coroutineScope, mutableStateCollectAsStateWithLifecycle2), gapComposer);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-128705445, new HomeScreenKt$$ExternalSyntheticLambda3(hapticFeedback, menuState, coroutineScope, z, playerConnection, dataStoreKt$rememberPreference$1$1RememberPreference2, navHostController, mutableStateCollectAsStateWithLifecycle3, mutableStateCollectAsStateWithLifecycle2), gapComposer);
            long longValue = parcelableSnapshotMutableLongState.getLongValue();
            HomePage.Chip chip = (HomePage.Chip) mutableStateCollectAsStateWithLifecycle17.getValue();
            List list11 = (List) mutableStateCollectAsStateWithLifecycle15.getValue();
            List list12 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
            MutableState mutableState4 = mutableState;
            List list13 = (List) mutableStateCollectAsStateWithLifecycle11.getValue();
            LazyListState lazyListState = lazyListStateRememberLazyListState;
            List list14 = (List) mutableStateCollectAsStateWithLifecycle6.getValue();
            List list15 = (List) mutableStateCollectAsStateWithLifecycle8.getValue();
            List list16 = (List) mutableStateCollectAsStateWithLifecycle5.getValue();
            List list17 = (List) mutableStateCollectAsStateWithLifecycle12.getValue();
            HomeViewModel homeViewModel5 = homeViewModel3;
            List list18 = (List) mutableStateCollectAsStateWithLifecycle7.getValue();
            HomePage homePage2 = (HomePage) mutableState4.getValue();
            List list19 = homePage2 != null ? homePage2.sections : null;
            ExplorePage explorePage2 = (ExplorePage) mutableStateCollectAsStateWithLifecycle10.getValue();
            boolean zChanged6 = gapComposer.changed(explorePage2 != null ? explorePage2.moodAndGenres : null) | gapComposer.changed(list13) | gapComposer.changed(chip) | gapComposer.changed(zBooleanValue) | gapComposer.changed(longValue) | gapComposer.changed(list11) | gapComposer.changed(list12) | gapComposer.changed(list14) | gapComposer.changed(list15) | gapComposer.changed(list16) | gapComposer.changed(list17) | gapComposer.changed(list18) | gapComposer.changed(list19);
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue15 == neverEqualPolicy) {
                ArrayList arrayList7 = new ArrayList();
                boolean z2 = ((HomePage.Chip) mutableStateCollectAsStateWithLifecycle17.getValue()) != null;
                HomeSection.SpeedDial speedDial = HomeSection.SpeedDial.INSTANCE;
                if (!z2 && !((List) mutableStateCollectAsStateWithLifecycle15.getValue()).isEmpty()) {
                    arrayList7.add(speedDial);
                }
                HomeSection.QuickPicks quickPicks = HomeSection.QuickPicks.INSTANCE;
                if (!z2 && (list7 = (List) mutableStateCollectAsStateWithLifecycle4.getValue()) != null && (!list7.isEmpty())) {
                    arrayList7.add(quickPicks);
                }
                HomeSection.FromTheCommunity fromTheCommunity = HomeSection.FromTheCommunity.INSTANCE;
                if (!z2 && (list6 = (List) mutableStateCollectAsStateWithLifecycle12.getValue()) != null && (!list6.isEmpty())) {
                    arrayList7.add(fromTheCommunity);
                }
                HomeSection.DailyDiscover dailyDiscover = HomeSection.DailyDiscover.INSTANCE;
                if (!z2 && (list5 = (List) mutableStateCollectAsStateWithLifecycle11.getValue()) != null && (!list5.isEmpty())) {
                    arrayList7.add(dailyDiscover);
                }
                HomeSection.KeepListening keepListening = HomeSection.KeepListening.INSTANCE;
                if (!z2 && (list4 = (List) mutableStateCollectAsStateWithLifecycle6.getValue()) != null && (!list4.isEmpty())) {
                    arrayList7.add(keepListening);
                }
                HomeSection.AccountPlaylists accountPlaylists = HomeSection.AccountPlaylists.INSTANCE;
                if (!z2 && (list3 = (List) mutableStateCollectAsStateWithLifecycle8.getValue()) != null && (!list3.isEmpty())) {
                    arrayList7.add(accountPlaylists);
                }
                HomeSection.ForgottenFavorites forgottenFavorites = HomeSection.ForgottenFavorites.INSTANCE;
                if (!z2 && (list2 = (List) mutableStateCollectAsStateWithLifecycle5.getValue()) != null && (!list2.isEmpty())) {
                    arrayList7.add(forgottenFavorites);
                }
                if (!z2 && (list = (List) mutableStateCollectAsStateWithLifecycle7.getValue()) != null) {
                    Iterator it2 = CollectionsKt__IterablesKt.getIndices(list).iterator();
                    while (((IntProgressionIterator) it2).hasNext) {
                        arrayList7.add(new HomeSection.SimilarRecommendation(((IntIterator) it2).nextInt()));
                    }
                }
                HomePage homePage3 = (HomePage) mutableState4.getValue();
                if (homePage3 != null) {
                    Iterator it3 = CollectionsKt__IterablesKt.getIndices(homePage3.sections).iterator();
                    while (((IntProgressionIterator) it3).hasNext) {
                        arrayList7.add(new HomeSection.HomePageSection(((IntIterator) it3).nextInt()));
                    }
                }
                ExplorePage explorePage3 = (ExplorePage) mutableStateCollectAsStateWithLifecycle10.getValue();
                List list20 = explorePage3 != null ? explorePage3.moodAndGenres : null;
                HomeSection.MoodAndGenres moodAndGenres = HomeSection.MoodAndGenres.INSTANCE;
                if (list20 != null) {
                    arrayList7.add(moodAndGenres);
                }
                objRememberedValue15 = zBooleanValue ? CollectionsKt.sortedWith(arrayList7, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 13, parcelableSnapshotMutableLongState)) : CollectionsKt.sortedWith(arrayList7, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 14, MapsKt__MapsKt.mapOf(new Pair(speedDial, 100), new Pair(quickPicks, 90), new Pair(fromTheCommunity, 80), new Pair(dailyDiscover, 70), new Pair(keepListening, 60), new Pair(accountPlaylists, 50), new Pair(forgottenFavorites, 40), new Pair(moodAndGenres, 10))));
                gapComposer.updateRememberedValue(objRememberedValue15);
            }
            List list21 = (List) objRememberedValue15;
            List list22 = (List) mutableStateCollectAsStateWithLifecycle4.getValue();
            boolean zChanged7 = gapComposer.changed(lazyGridStateRememberLazyGridState);
            Object objRememberedValue16 = gapComposer.rememberedValue();
            if (zChanged7 || objRememberedValue16 == neverEqualPolicy) {
                objRememberedValue16 = new HomeScreenKt$HomeScreen$6$1(lazyGridStateRememberLazyGridState, null, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue16);
            }
            Stack.LaunchedEffect(gapComposer, list22, (Function2) objRememberedValue16);
            List list23 = (List) mutableStateCollectAsStateWithLifecycle5.getValue();
            boolean zChanged8 = gapComposer.changed(lazyGridStateRememberLazyGridState2);
            Object objRememberedValue17 = gapComposer.rememberedValue();
            if (zChanged8 || objRememberedValue17 == neverEqualPolicy) {
                objRememberedValue17 = new HomeScreenKt$HomeScreen$6$1(lazyGridStateRememberLazyGridState2, null, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue17);
            }
            Stack.LaunchedEffect(gapComposer, list23, (Function2) objRememberedValue17);
            boolean zBooleanValue2 = ((Boolean) mutableStateCollectAsStateWithLifecycle21.getValue()).booleanValue();
            boolean zChangedInstance3 = gapComposer.changedInstance(homeViewModel5);
            Object objRememberedValue18 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue18 == neverEqualPolicy) {
                homeViewModel4 = homeViewModel5;
                HomeScreenKt$HomeScreen$8$1 homeScreenKt$HomeScreen$8$1 = new HomeScreenKt$HomeScreen$8$1(0, homeViewModel4, HomeViewModel.class, "refresh", "refresh()V", 0, (byte) 0);
                gapComposer.updateRememberedValue(homeScreenKt$HomeScreen$8$1);
                objRememberedValue18 = homeScreenKt$HomeScreen$8$1;
            } else {
                homeViewModel4 = homeViewModel5;
            }
            HomeViewModel homeViewModel6 = homeViewModel4;
            coil3.size.SizeKt.m862PullToRefreshBoxgMrHQkA(zBooleanValue2, (Function0) ((KFunction) objRememberedValue18), null, pullToRefreshStateImplRememberPullToRefreshState, null, Expect_jvmKt.rememberComposableLambda(-152566472, new AlbumMenuKt$$ExternalSyntheticLambda11(pullToRefreshStateImplRememberPullToRefreshState, mutableStateCollectAsStateWithLifecycle21, (byte) 21), gapComposer), false, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1574644421, new HomeScreenKt$$ExternalSyntheticLambda6(lazyGridStateRememberLazyGridState, lazyGridStateRememberLazyGridState2, lazyListState, homeViewModel6, mutableState4, mutableStateCollectAsStateWithLifecycle17, mutableStateCollectAsStateWithLifecycle20, paddingValuesImplM128PaddingValuesa9UjIt4$default, mutableStateCollectAsStateWithLifecycle18, navHostController, mutableStateCollectAsStateWithLifecycle19, list10, list21, mutableStateCollectAsStateWithLifecycle15, mutableStateCollectAsStateWithLifecycle22, z, coroutineScope, playerConnection, dataStoreKt$rememberPreference$1$1RememberPreference2, musicDatabase, mutableStateCollectAsStateWithLifecycle3, mutableStateCollectAsStateWithLifecycle2, hapticFeedback, menuState, mutableStateCollectAsStateWithLifecycle16, mutableStateCollectAsStateWithLifecycle4, insetsPaddingValuesAsPaddingValues, mutableStateCollectAsStateWithLifecycle12, mutableStateCollectAsStateWithLifecycle11, mutableStateCollectAsStateWithLifecycle6, f2, mutableStateCollectAsStateWithLifecycle8, mutableStateCollectAsStateWithLifecycle23, str, mutableStateCollectAsStateWithLifecycle5, mutableStateCollectAsStateWithLifecycle7, mutableStateCollectAsStateWithLifecycle10, mutableStateCollectAsStateWithLifecycle13, mutableStateCollectAsStateWithLifecycle14, composableLambdaImplRememberComposableLambda2, mutableState3, composableLambdaImplRememberComposableLambda, (byte) 0), gapComposer), gapComposer, 100859904);
            homeViewModel2 = homeViewModel6;
        } else {
            gapComposer.skipToGroupEnd();
            homeViewModel2 = homeViewModel;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final byte b2 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(snackbarHostState, homeViewModel2, i, b2) { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ SnackbarHostState f$0;
                public final /* synthetic */ HomeViewModel f$1;

                {
                    this.$r8$classId = b2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    byte b3 = this.$r8$classId;
                    Unit unit2 = Unit.INSTANCE;
                    HomeViewModel homeViewModel7 = this.f$1;
                    SnackbarHostState snackbarHostState2 = this.f$0;
                    Composer composer2 = (Composer) obj5;
                    ((Integer) obj6).getClass();
                    switch (b3) {
                        case 0:
                            HomeScreenKt.HomeScreen(snackbarHostState2, homeViewModel7, composer2, Stack.updateChangedFlags(1));
                            break;
                        default:
                            HomeScreenKt.HomeScreen(snackbarHostState2, homeViewModel7, composer2, Stack.updateChangedFlags(1));
                            break;
                    }
                    return unit2;
                }
            };
        }
    }
}
