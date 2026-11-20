package com.metrolist.music.ui.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.Formatter;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AndroidWindowInsets;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TopAppBarState;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerElement;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.unit.Dp;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.internal.NavControllerImpl;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.MediaInfo;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda39;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.Material3SettingsItem;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import io.ktor.http.ContentType;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.openapi.Responses$Companion$Serializer$$ExternalSyntheticLambda2;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppBarKt {

    /* JADX INFO: renamed from: lambda$-198912442, reason: not valid java name */
    public static final ComposableLambdaImpl f636lambda$198912442 = new ComposableLambdaImpl(false, -198912442, new HttpParserKt$$ExternalSyntheticLambda0(4));

    /* JADX INFO: renamed from: lambda$-330885606, reason: not valid java name */
    public static final ComposableLambdaImpl f638lambda$330885606 = new ComposableLambdaImpl(false, -330885606, new Responses$Companion$Serializer$$ExternalSyntheticLambda2(13));
    public static final ComposableLambdaImpl lambda$505359460 = new ComposableLambdaImpl(false, 505359460, new Responses$Companion$Serializer$$ExternalSyntheticLambda2(14));
    public static final ComposableLambdaImpl lambda$1991797331 = new ComposableLambdaImpl(false, 1991797331, new HttpParserKt$$ExternalSyntheticLambda0(5));
    public static final ComposableLambdaImpl lambda$456461423 = new ComposableLambdaImpl(false, 456461423, new HttpParserKt$$ExternalSyntheticLambda0(6));

    /* JADX INFO: renamed from: lambda$-325774682, reason: not valid java name */
    public static final ComposableLambdaImpl f637lambda$325774682 = new ComposableLambdaImpl(false, -325774682, new HttpParserKt$$ExternalSyntheticLambda0(7));

    public static final void ShowMediaInfo(String str, Composer composer, int i) {
        GapComposer gapComposer;
        ShowMediaInfoKt$$ExternalSyntheticLambda0 showMediaInfoKt$$ExternalSyntheticLambda0;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        MutableState mutableStateCollectAsState;
        MutableState mutableState;
        Continuation continuation;
        MutableState mutableState2;
        Unit unit;
        MusicDatabase musicDatabase;
        Object showMediaInfoKt$ShowMediaInfo$3$1;
        MutableState mutableState3;
        str.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(179077117);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            if (StringsKt.isBlank(str) || str.length() == 0) {
                recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                } else {
                    showMediaInfoKt$$ExternalSyntheticLambda0 = new ShowMediaInfoKt$$ExternalSyntheticLambda0(str, i, (byte) 0);
                }
            } else {
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                AndroidWindowInsets androidWindowInsets = OffsetKt.current(gapComposer2).systemBars;
                Object objRememberedValue = gapComposer2.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState4 = (MutableState) objRememberedValue;
                MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.mutableStateOf$default(null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue2;
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.mutableStateOf$default(null);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                MutableState mutableState6 = (MutableState) objRememberedValue3;
                final PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
                StateFlowImpl stateFlowImpl = playerConnection != null ? playerConnection.currentStreamClient : null;
                if (stateFlowImpl == null) {
                    gapComposer2.startReplaceGroup(537524276);
                    gapComposer2.end(false);
                    mutableStateCollectAsState = null;
                } else {
                    gapComposer2.startReplaceGroup(294434157);
                    mutableStateCollectAsState = Stack.collectAsState(stateFlowImpl, gapComposer2, 3);
                    gapComposer2.end(false);
                }
                if (mutableStateCollectAsState == null) {
                    gapComposer2.startReplaceGroup(537544644);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = Stack.mutableStateOf$default(null);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    mutableStateCollectAsState = (MutableState) objRememberedValue4;
                } else {
                    gapComposer2.startReplaceGroup(294432985);
                }
                gapComposer2.end(false);
                MutableState mutableState7 = mutableStateCollectAsState;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
                final Context context = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
                final Map map = (Map) gapComposer2.consume(MainActivityKt.LocalArtistNameAliases);
                Preferences$Key preferences$Key = PreferenceKeysKt.LoudnessLevelKey;
                Context context2 = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer2);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = StateFlowKt.distinctUntilChanged(new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context2).getData(), preferences$Key, (byte) 0));
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue6, LoudnessLevel.BALANCED, gapComposer2, 48);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context2, preferences$Key);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                final ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2 showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2 = (ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2) objRememberedValue7;
                final float f = ((LoudnessLevel) showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.getValue()).targetLufs;
                int i3 = i2 & 14;
                boolean z = i3 == 4;
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                if (z || objRememberedValue8 == neverEqualPolicy) {
                    mutableState = mutableState7;
                    continuation = null;
                    DataStoreKt$get$2 dataStoreKt$get$2 = new DataStoreKt$get$2((byte) 21, (Object) str, (Object) mutableState4, continuation, false);
                    mutableState2 = mutableState4;
                    gapComposer2.updateRememberedValue(dataStoreKt$get$2);
                    objRememberedValue8 = dataStoreKt$get$2;
                } else {
                    mutableState2 = mutableState4;
                    mutableState = mutableState7;
                    continuation = null;
                }
                Unit unit2 = Unit.INSTANCE;
                Stack.LaunchedEffect(unit2, str, (Function2) objRememberedValue8, gapComposer2);
                boolean zChangedInstance = gapComposer2.changedInstance(musicDatabase2) | (i3 == 4);
                Object objRememberedValue9 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue9 == neverEqualPolicy) {
                    unit = unit2;
                    musicDatabase = musicDatabase2;
                    ShowMediaInfoKt$ShowMediaInfo$3$1 showMediaInfoKt$ShowMediaInfo$3$2 = new ShowMediaInfoKt$ShowMediaInfo$3$1(musicDatabase, str, mutableState5, continuation, (byte) 0);
                    gapComposer2.updateRememberedValue(showMediaInfoKt$ShowMediaInfo$3$2);
                    objRememberedValue9 = showMediaInfoKt$ShowMediaInfo$3$2;
                } else {
                    musicDatabase = musicDatabase2;
                    unit = unit2;
                }
                Stack.LaunchedEffect(unit, str, (Function2) objRememberedValue9, gapComposer2);
                boolean zChangedInstance2 = gapComposer2.changedInstance(musicDatabase) | (i3 == 4);
                Object objRememberedValue10 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue10 == neverEqualPolicy) {
                    mutableState3 = mutableState6;
                    showMediaInfoKt$ShowMediaInfo$3$1 = new ShowMediaInfoKt$ShowMediaInfo$3$1(musicDatabase, str, mutableState3, continuation, (byte) 1);
                    gapComposer2.updateRememberedValue(showMediaInfoKt$ShowMediaInfo$3$1);
                } else {
                    showMediaInfoKt$ShowMediaInfo$3$1 = objRememberedValue10;
                    mutableState3 = mutableState6;
                }
                Stack.LaunchedEffect(unit, str, (Function2) showMediaInfoKt$ShowMediaInfo$3$1, gapComposer2);
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
                Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(OffsetKt.padding(Modifier.Companion.$$INSTANCE, OffsetKt.asPaddingValues(androidWindowInsets, gapComposer2)).then(SizeKt.FillWholeMaxSize), ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background, ColorKt.RectangleShape);
                boolean zChangedInstance3 = gapComposer2.changedInstance(map) | gapComposer2.changed(mutableState) | gapComposer2.changed(f) | gapComposer2.changed(showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changedInstance(context);
                Object objRememberedValue11 = gapComposer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue11 == neverEqualPolicy) {
                    final MutableState mutableState8 = mutableState2;
                    final MutableState mutableState9 = mutableState;
                    final MutableState mutableState10 = mutableState3;
                    Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                            lazyListIntervalContent.getClass();
                            final MutableState mutableState11 = mutableState8;
                            if (((MediaInfo) mutableState11.getValue()) != null) {
                                final Map map2 = map;
                                final PlayerConnection playerConnection2 = playerConnection;
                                final Context context3 = context;
                                final MutableState mutableState12 = mutableState5;
                                final MutableState mutableState13 = mutableState10;
                                final State state = mutableState9;
                                final float f2 = f;
                                final ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2 showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$3 = showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2;
                                LazyListIntervalContent.item$default(lazyListIntervalContent, null, "MediaDetails", new ComposableLambdaImpl(true, -32032563, new Function3() { // from class: com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
                                        String str2;
                                        String strJoinToString$default;
                                        String str3;
                                        Double dValueOf;
                                        Double d;
                                        Iterable iterableListOf;
                                        int i4;
                                        int i5;
                                        String str4;
                                        String str5;
                                        Integer num;
                                        Integer num2;
                                        Integer num3;
                                        Integer num4;
                                        String str6;
                                        Composer composer2 = (Composer) obj3;
                                        int iIntValue = ((Integer) obj4).intValue();
                                        Integer numValueOf = Integer.valueOf(R.drawable.volume_up);
                                        ((LazyItemScopeImpl) obj2).getClass();
                                        GapComposer gapComposer3 = (GapComposer) composer2;
                                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                                            int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                                            ComposeUiNode.Companion.getClass();
                                            gapComposer3.startReusableNode();
                                            if (gapComposer3.inserting) {
                                                gapComposer3.createNode(LayoutNode.Constructor);
                                            } else {
                                                gapComposer3.useNode();
                                            }
                                            Stack.m390setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                            Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                            Stack.m389reconcileimpl(gapComposer3);
                                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                            String strStringResource = MathKt.stringResource(R.string.song_title, gapComposer3);
                                            MutableState mutableState14 = mutableState11;
                                            MediaInfo mediaInfo = (MediaInfo) mutableState14.getValue();
                                            MutableState mutableState15 = mutableState12;
                                            if (mediaInfo == null || (str2 = mediaInfo.title) == null) {
                                                Song song = (Song) mutableState15.getValue();
                                                str2 = song != null ? song.song.title : null;
                                            }
                                            Pair pair = new Pair(strStringResource, str2);
                                            String strStringResource2 = MathKt.stringResource(R.string.song_artists, gapComposer3);
                                            Song song2 = (Song) mutableState15.getValue();
                                            List list = song2 != null ? song2.artists : null;
                                            Map map3 = map2;
                                            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                            if (list == null) {
                                                gapComposer3.startReplaceGroup(-43503967);
                                                gapComposer3.end(false);
                                                strJoinToString$default = null;
                                            } else {
                                                gapComposer3.startReplaceGroup(1938259296);
                                                boolean zChangedInstance4 = gapComposer3.changedInstance(map3);
                                                Object objRememberedValue12 = gapComposer3.rememberedValue();
                                                if (zChangedInstance4 || objRememberedValue12 == neverEqualPolicy2) {
                                                    objRememberedValue12 = new QueueKt$$ExternalSyntheticLambda40(map3, (byte) 14);
                                                    gapComposer3.updateRememberedValue(objRememberedValue12);
                                                }
                                                strJoinToString$default = CollectionsKt.joinToString$default(list, null, null, null, (Function1) objRememberedValue12, 31);
                                                gapComposer3.end(false);
                                            }
                                            if (strJoinToString$default == null) {
                                                MediaInfo mediaInfo2 = (MediaInfo) mutableState14.getValue();
                                                if (mediaInfo2 == null || (str6 = mediaInfo2.author) == null) {
                                                    strJoinToString$default = null;
                                                } else {
                                                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                                                    strJoinToString$default = ArtistNameAliases.resolve(null, str6, map3);
                                                }
                                            }
                                            Pair pair2 = new Pair(strStringResource2, strJoinToString$default);
                                            String strStringResource3 = MathKt.stringResource(R.string.media_id, gapComposer3);
                                            Song song3 = (Song) mutableState15.getValue();
                                            if (song3 == null || (str3 = song3.song.id) == null) {
                                                MediaInfo mediaInfo3 = (MediaInfo) mutableState14.getValue();
                                                str3 = mediaInfo3 != null ? mediaInfo3.videoId : null;
                                            }
                                            List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{pair, pair2, new Pair(strStringResource3, str3)});
                                            List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.music_note), Integer.valueOf(R.drawable.person), Integer.valueOf(R.drawable.media3_icon_bookmark_filled)});
                                            NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy2;
                                            List listListOf3 = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.media3_icon_feed), Integer.valueOf(R.drawable.media3_icon_thumb_up_unfilled), Integer.valueOf(R.drawable.media3_icon_thumb_down_unfilled), Integer.valueOf(R.drawable.key), Integer.valueOf(R.drawable.play), Integer.valueOf(R.drawable.info), Integer.valueOf(R.drawable.radio), Integer.valueOf(R.drawable.gradient), Integer.valueOf(R.drawable.contrast), numValueOf, numValueOf, Integer.valueOf(R.drawable.volume_mute), Integer.valueOf(R.drawable.content_copy)});
                                            MutableState mutableState16 = mutableState13;
                                            FormatEntity formatEntity = (FormatEntity) mutableState16.getValue();
                                            if (formatEntity == null || (dValueOf = formatEntity.perceptualLoudnessDb) == null) {
                                                FormatEntity formatEntity2 = (FormatEntity) mutableState16.getValue();
                                                dValueOf = (formatEntity2 == null || (d = formatEntity2.loudnessDb) == null) ? null : Double.valueOf(d.doubleValue() - 7.0d);
                                            }
                                            FormatEntity formatEntity3 = (FormatEntity) mutableState16.getValue();
                                            final Context context4 = context3;
                                            if (formatEntity3 != null) {
                                                gapComposer3.startReplaceGroup(-41894880);
                                                String strStringResource4 = MathKt.stringResource(R.string.views, gapComposer3);
                                                MediaInfo mediaInfo4 = (MediaInfo) mutableState14.getValue();
                                                String strNumberFormatter = (mediaInfo4 == null || (num4 = mediaInfo4.viewCount) == null) ? null : AppBarKt.numberFormatter(num4.intValue());
                                                if (strNumberFormatter == null) {
                                                    strNumberFormatter = "";
                                                }
                                                Pair pair3 = new Pair(strStringResource4, strNumberFormatter);
                                                String strStringResource5 = MathKt.stringResource(R.string.likes, gapComposer3);
                                                MediaInfo mediaInfo5 = (MediaInfo) mutableState14.getValue();
                                                String strNumberFormatter2 = (mediaInfo5 == null || (num3 = mediaInfo5.like) == null) ? null : AppBarKt.numberFormatter(num3.intValue());
                                                if (strNumberFormatter2 == null) {
                                                    strNumberFormatter2 = "";
                                                }
                                                Pair pair4 = new Pair(strStringResource5, strNumberFormatter2);
                                                String strStringResource6 = MathKt.stringResource(R.string.dislikes, gapComposer3);
                                                MediaInfo mediaInfo6 = (MediaInfo) mutableState14.getValue();
                                                String strNumberFormatter3 = (mediaInfo6 == null || (num2 = mediaInfo6.dislike) == null) ? null : AppBarKt.numberFormatter(num2.intValue());
                                                Pair pair5 = new Pair(strStringResource6, strNumberFormatter3 != null ? strNumberFormatter3 : "");
                                                FormatEntity formatEntity4 = (FormatEntity) mutableState16.getValue();
                                                Pair pair6 = new Pair("Itag", formatEntity4 != null ? String.valueOf(formatEntity4.itag) : null);
                                                Pair pair7 = new Pair(MathKt.stringResource(R.string.stream_client, gapComposer3), (String) state.getValue());
                                                String strStringResource7 = MathKt.stringResource(R.string.mime_type, gapComposer3);
                                                FormatEntity formatEntity5 = (FormatEntity) mutableState16.getValue();
                                                Pair pair8 = new Pair(strStringResource7, formatEntity5 != null ? formatEntity5.mimeType : null);
                                                String strStringResource8 = MathKt.stringResource(R.string.codecs, gapComposer3);
                                                FormatEntity formatEntity6 = (FormatEntity) mutableState16.getValue();
                                                Pair pair9 = new Pair(strStringResource8, formatEntity6 != null ? formatEntity6.codecs : null);
                                                String strStringResource9 = MathKt.stringResource(R.string.bitrate, gapComposer3);
                                                FormatEntity formatEntity7 = (FormatEntity) mutableState16.getValue();
                                                Pair pair10 = new Pair(strStringResource9, formatEntity7 != null ? (formatEntity7.bitrate / CIOKt.DEFAULT_HTTP_POOL_SIZE) + " Kbps" : null);
                                                String strStringResource10 = MathKt.stringResource(R.string.sample_rate, gapComposer3);
                                                FormatEntity formatEntity8 = (FormatEntity) mutableState16.getValue();
                                                Pair pair11 = new Pair(strStringResource10, (formatEntity8 == null || (num = formatEntity8.sampleRate) == null) ? null : num.intValue() + " Hz");
                                                String strStringResource11 = MathKt.stringResource(R.string.loudness, gapComposer3);
                                                if (dValueOf == null) {
                                                    gapComposer3.startReplaceGroup(-40939399);
                                                    gapComposer3.end(false);
                                                    str4 = null;
                                                } else {
                                                    gapComposer3.startReplaceGroup(-40939398);
                                                    str4 = String.format(((Locale) gapComposer3.consume(CompositionLocalsKt.LocalLocale)).platformLocale, "%.2f dB", Arrays.copyOf(new Object[]{Double.valueOf(dValueOf.doubleValue() - ((double) f2))}, 1));
                                                    gapComposer3.end(false);
                                                }
                                                Pair pair12 = new Pair(strStringResource11, str4);
                                                Pair pair13 = new Pair(MathKt.stringResource(R.string.loudness_level, gapComposer3), AppBarKt.getLoudnessLevelLabel((LoudnessLevel) showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$3.getValue(), gapComposer3));
                                                String strStringResource12 = MathKt.stringResource(R.string.volume, gapComposer3);
                                                PlayerConnection playerConnection3 = playerConnection2;
                                                if (playerConnection3 != null) {
                                                    ExoPlayerImpl playerSafe = playerConnection3.getPlayerSafe();
                                                    playerSafe.verifyApplicationThread();
                                                    str5 = ((int) (playerSafe.volume * 100.0f)) + "%";
                                                } else {
                                                    str5 = null;
                                                }
                                                Pair pair14 = new Pair(strStringResource12, str5);
                                                String strStringResource13 = MathKt.stringResource(R.string.file_size, gapComposer3);
                                                FormatEntity formatEntity9 = (FormatEntity) mutableState16.getValue();
                                                iterableListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, new Pair(strStringResource13, formatEntity9 != null ? Formatter.formatShortFileSize(context4, formatEntity9.contentLength) : null)});
                                                gapComposer3.end(false);
                                            } else {
                                                mutableState14 = mutableState14;
                                                gapComposer3.startReplaceGroup(-40092912);
                                                gapComposer3.end(false);
                                                iterableListOf = EmptyList.INSTANCE;
                                            }
                                            ArrayList arrayList = new ArrayList();
                                            ArrayList arrayList2 = new ArrayList();
                                            Object systemService = context4.getSystemService("clipboard");
                                            systemService.getClass();
                                            final ClipboardManager clipboardManager = (ClipboardManager) systemService;
                                            gapComposer3.startReplaceGroup(1938381291);
                                            int i6 = 0;
                                            for (Object obj5 : listListOf) {
                                                int i7 = i6 + 1;
                                                if (i6 < 0) {
                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                    throw null;
                                                }
                                                Pair pair15 = (Pair) obj5;
                                                String str7 = (String) pair15.first;
                                                final String strM = (String) pair15.second;
                                                if (strM == null) {
                                                    i5 = 0;
                                                    strM = Format$$ExternalSyntheticOutline0.m(gapComposer3, -65661094, R.string.unknown, gapComposer3, false);
                                                } else {
                                                    i5 = 0;
                                                    gapComposer3.startReplaceGroup(-65661342);
                                                    gapComposer3.end(false);
                                                }
                                                Painter painterPainterResource = IntMath.painterResource(((Number) listListOf2.get(i6)).intValue(), i5, gapComposer3);
                                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-399903096, new ShowMediaInfoKt$$ExternalSyntheticLambda0(str7, (byte) 16), gapComposer3);
                                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1104763417, new ShowMediaInfoKt$$ExternalSyntheticLambda0(strM, (byte) 17), gapComposer3);
                                                boolean zChangedInstance5 = gapComposer3.changedInstance(clipboardManager) | gapComposer3.changed(strM) | gapComposer3.changedInstance(context4);
                                                Object objRememberedValue13 = gapComposer3.rememberedValue();
                                                NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy3;
                                                if (zChangedInstance5 || objRememberedValue13 == neverEqualPolicy4) {
                                                    final byte b = 0;
                                                    objRememberedValue13 = new Function0() { // from class: com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda7
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            byte b2 = b;
                                                            Unit unit3 = Unit.INSTANCE;
                                                            Context context5 = context4;
                                                            String str8 = strM;
                                                            ClipboardManager clipboardManager2 = clipboardManager;
                                                            switch (b2) {
                                                                case 0:
                                                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str8));
                                                                    Toast.makeText(context5, R.string.copied, 0).show();
                                                                    break;
                                                                case 1:
                                                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str8));
                                                                    Toast.makeText(context5, R.string.copied, 0).show();
                                                                    break;
                                                                default:
                                                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str8));
                                                                    Toast.makeText(context5, R.string.copied, 0).show();
                                                                    break;
                                                            }
                                                            return unit3;
                                                        }
                                                    };
                                                    gapComposer3.updateRememberedValue(objRememberedValue13);
                                                }
                                                arrayList.add(new Material3SettingsItem(painterPainterResource, composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, false, false, (Function0) objRememberedValue13, 242));
                                                i6 = i7;
                                                neverEqualPolicy3 = neverEqualPolicy4;
                                            }
                                            NeverEqualPolicy neverEqualPolicy5 = neverEqualPolicy3;
                                            gapComposer3.end(false);
                                            gapComposer3.startReplaceGroup(1938404555);
                                            int i8 = 0;
                                            for (Object obj6 : iterableListOf) {
                                                int i9 = i8 + 1;
                                                if (i8 < 0) {
                                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                                    throw null;
                                                }
                                                Pair pair16 = (Pair) obj6;
                                                String str8 = (String) pair16.first;
                                                final String strM2 = (String) pair16.second;
                                                if (strM2 == null) {
                                                    i4 = 0;
                                                    strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer3, -1629191229, R.string.unknown, gapComposer3, false);
                                                } else {
                                                    i4 = 0;
                                                    gapComposer3.startReplaceGroup(-1629191477);
                                                    gapComposer3.end(false);
                                                }
                                                Painter painterPainterResource2 = IntMath.painterResource(((Number) listListOf3.get(i8)).intValue(), i4, gapComposer3);
                                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1704784463, new ShowMediaInfoKt$$ExternalSyntheticLambda0(str8, (byte) 18), gapComposer3);
                                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(-470720176, new ShowMediaInfoKt$$ExternalSyntheticLambda0(strM2, (byte) 19), gapComposer3);
                                                boolean zChangedInstance6 = gapComposer3.changedInstance(clipboardManager) | gapComposer3.changed(strM2) | gapComposer3.changedInstance(context4);
                                                Object objRememberedValue14 = gapComposer3.rememberedValue();
                                                if (zChangedInstance6 || objRememberedValue14 == neverEqualPolicy5) {
                                                    final byte b2 = 1;
                                                    objRememberedValue14 = new Function0() { // from class: com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda7
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            byte b3 = b2;
                                                            Unit unit3 = Unit.INSTANCE;
                                                            Context context5 = context4;
                                                            String str9 = strM2;
                                                            ClipboardManager clipboardManager2 = clipboardManager;
                                                            switch (b3) {
                                                                case 0:
                                                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str9));
                                                                    Toast.makeText(context5, R.string.copied, 0).show();
                                                                    break;
                                                                case 1:
                                                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str9));
                                                                    Toast.makeText(context5, R.string.copied, 0).show();
                                                                    break;
                                                                default:
                                                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str9));
                                                                    Toast.makeText(context5, R.string.copied, 0).show();
                                                                    break;
                                                            }
                                                            return unit3;
                                                        }
                                                    };
                                                    gapComposer3.updateRememberedValue(objRememberedValue14);
                                                }
                                                arrayList2.add(new Material3SettingsItem(painterPainterResource2, composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, null, false, false, (Function0) objRememberedValue14, 242));
                                                i8 = i9;
                                            }
                                            gapComposer3.end(false);
                                            MenuKt.Material3SettingsGroup(MathKt.stringResource(R.string.general, gapComposer3), arrayList, null, gapComposer3, 0, 12);
                                            MenuKt.Material3SettingsGroup(Format$$ExternalSyntheticOutline0.m$1(companion, 8.0f, gapComposer3, R.string.information, gapComposer3), arrayList2, null, gapComposer3, 0, 12);
                                            OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, 8.0f));
                                            MediaInfo mediaInfo7 = (MediaInfo) mutableState14.getValue();
                                            final String strM3 = mediaInfo7 != null ? mediaInfo7.description : null;
                                            if (strM3 == null) {
                                                strM3 = Format$$ExternalSyntheticOutline0.m(gapComposer3, 1938443095, R.string.unknown, gapComposer3, false);
                                            } else {
                                                gapComposer3.startReplaceGroup(1938442444);
                                                gapComposer3.end(false);
                                            }
                                            String strStringResource14 = MathKt.stringResource(R.string.description, gapComposer3);
                                            ComposableLambdaImpl composableLambdaImpl = AppBarKt.f636lambda$198912442;
                                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(533263013, new ShowMediaInfoKt$$ExternalSyntheticLambda0(strM3, (byte) 14), gapComposer3);
                                            boolean zChangedInstance7 = gapComposer3.changedInstance(clipboardManager) | gapComposer3.changed(strM3) | gapComposer3.changedInstance(context4);
                                            Object objRememberedValue15 = gapComposer3.rememberedValue();
                                            if (zChangedInstance7 || objRememberedValue15 == neverEqualPolicy5) {
                                                final byte b3 = 2;
                                                objRememberedValue15 = new Function0() { // from class: com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda7
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b4 = b3;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        Context context5 = context4;
                                                        String str9 = strM3;
                                                        ClipboardManager clipboardManager2 = clipboardManager;
                                                        switch (b4) {
                                                            case 0:
                                                                clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str9));
                                                                Toast.makeText(context5, R.string.copied, 0).show();
                                                                break;
                                                            case 1:
                                                                clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str9));
                                                                Toast.makeText(context5, R.string.copied, 0).show();
                                                                break;
                                                            default:
                                                                clipboardManager2.setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str9));
                                                                Toast.makeText(context5, R.string.copied, 0).show();
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer3.updateRememberedValue(objRememberedValue15);
                                            }
                                            MenuKt.Material3SettingsGroup(strStringResource14, CollectionsKt__IterablesKt.listOf(new Material3SettingsItem(null, composableLambdaImpl, composableLambdaImplRememberComposableLambda5, null, false, false, (Function0) objRememberedValue15, 243)), null, gapComposer3, 64, 12);
                                            gapComposer3.end(true);
                                        } else {
                                            gapComposer3.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), 1);
                            } else {
                                LazyListIntervalContent.item$default(lazyListIntervalContent, null, "MediaInfoLoader", AppBarKt.lambda$505359460, 1);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(function1);
                    objRememberedValue11 = function1;
                }
                gapComposer = gapComposer2;
                IntMath.LazyColumn(modifierM39backgroundbw27NRU, lazyListStateRememberLazyListState, null, null, null, null, false, null, (Function1) objRememberedValue11, gapComposer, 0, 508);
            }
            recomposeScopeImplEndRestartGroup.block = showMediaInfoKt$$ExternalSyntheticLambda0;
        }
        gapComposer = gapComposer2;
        gapComposer.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            showMediaInfoKt$$ExternalSyntheticLambda0 = new ShowMediaInfoKt$$ExternalSyntheticLambda0(str, i, (byte) 15);
            recomposeScopeImplEndRestartGroup.block = showMediaInfoKt$$ExternalSyntheticLambda0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0331  */
    /* JADX WARN: Code duplicated, block: B:63:0x0352  */
    /* JADX WARN: Code duplicated, block: B:66:0x0374  */
    /* JADX WARN: Code duplicated, block: B:69:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:71:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:77:0x03de  */
    /* JADX WARN: Code duplicated, block: B:81:0x042d  */
    /* JADX WARN: Code duplicated, block: B:85:0x045a  */
    /* JADX WARN: Code duplicated, block: B:88:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:90:0x04b1  */
    public static final void ShowOffsetDialog(Function0 function0, Composer composer, int i) {
        MutableState mutableState;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        NeverEqualPolicy neverEqualPolicy;
        boolean zChanged;
        Object objRememberedValue;
        char c;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        boolean z;
        function0.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(861167808);
        int i2 = i | (gapComposer.changedInstance(function0) ? 4 : 2);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
            SongEntity songEntity = (SongEntity) function0.invoke();
            Object[] objArr = new Object[0];
            boolean zChanged5 = gapComposer.changed(songEntity);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (zChanged5 || objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 17, songEntity);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue5, gapComposer, 0);
            Object[] objArr2 = new Object[0];
            boolean zChanged6 = gapComposer.changed(parcelableSnapshotMutableIntState2);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue6 == neverEqualPolicy2) {
                objRememberedValue6 = new ShowOffsetDialogKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableIntState2, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            MutableState mutableState2 = (MutableState) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue6, gapComposer, 0);
            Continuation continuation = null;
            String str = songEntity != null ? songEntity.id : null;
            boolean zChanged7 = gapComposer.changed(songEntity) | gapComposer.changed(parcelableSnapshotMutableIntState2) | gapComposer.changed(mutableState2);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged7 || objRememberedValue7 == neverEqualPolicy2) {
                mutableState = mutableState2;
                objRememberedValue7 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) songEntity, (Object) parcelableSnapshotMutableIntState2, (Object) mutableState, continuation, (byte) 19);
                gapComposer.updateRememberedValue(objRememberedValue7);
            } else {
                mutableState = mutableState2;
            }
            Stack.LaunchedEffect(gapComposer, str, (Function2) objRememberedValue7);
            Integer numValueOf = Integer.valueOf(parcelableSnapshotMutableIntState2.getIntValue());
            boolean zChangedInstance = ((i2 & 14) == 4) | gapComposer.changedInstance(musicDatabase) | gapComposer.changed(parcelableSnapshotMutableIntState2);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue8 == neverEqualPolicy2) {
                parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState2;
                SyncUtils$createPlaylist$1.AnonymousClass1 anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) function0, (Object) musicDatabase, (Object) parcelableSnapshotMutableIntState, continuation, (byte) 20);
                gapComposer.updateRememberedValue(anonymousClass1);
                objRememberedValue8 = anonymousClass1;
            } else {
                parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState2;
            }
            Stack.LaunchedEffect(gapComposer, numValueOf, (Function2) objRememberedValue8);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 24.0f, 20.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z2 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
            if (z2) {
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
            MutableState mutableState3 = mutableState;
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.fast_forward, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 40.0f), CardKt.getColorScheme(gapComposer).primary, gapComposer, 440, 0);
            String strM$1 = Format$$ExternalSyntheticOutline0.m$1(companion, 12.0f, gapComposer, R.string.lyrics_offset, gapComposer);
            TextStyle textStyle = CardKt.getTypography(gapComposer).headlineSmall;
            FontWeight fontWeight = FontWeight.Bold;
            TextKt.m352TextNvy7gAk(strM$1, null, 0L, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 1572864, 0, 131006);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            FlowRowOverflow flowRowOverflow = OffsetKt.Center;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer, 54);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            String str2 = (String) mutableState3.getValue();
            TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer).displaySmall, 0L, 0L, fontWeight, null, null, null, 0L, 0L, null, null, 16744443);
            Modifier modifierM156widthInVpY3zN4 = SizeKt.m156widthInVpY3zN4(companion, 120.0f, 160.0f);
            long j = CardKt.getColorScheme(gapComposer).primary;
            long j2 = CardKt.getColorScheme(gapComposer).primary;
            long j3 = CardKt.getColorScheme(gapComposer).onSurface;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda5 = textKt$$ExternalSyntheticLambda3;
            TextFieldColors textFieldColorsM348colors0hiis_0 = TextFieldDefaults.m348colors0hiis_0(j, j2, ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), 0.5f, Color.m483getColorSpaceimpl(j3)), CardKt.getColorScheme(gapComposer).error, gapComposer, 2147452623);
            KeyboardOptions keyboardOptions = new KeyboardOptions(3, 7, 115);
            boolean zChanged8 = gapComposer.changed(mutableState3) | gapComposer.changed(parcelableSnapshotMutableIntState);
            Object objRememberedValue9 = gapComposer.rememberedValue();
            if (zChanged8) {
                neverEqualPolicy = neverEqualPolicy2;
            } else {
                neverEqualPolicy = neverEqualPolicy2;
                if (objRememberedValue9 == neverEqualPolicy) {
                }
                NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy;
                ScrimKt.TextField(str2, (Function1) objRememberedValue9, modifierM156widthInVpY3zN4, false, textStyleM750copyp1EtxEg$default, null, null, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer, 384, 12779520, 4030424);
                OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
                TextKt.m352TextNvy7gAk("ms", null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).titleLarge, gapComposer, 1572870, 0, 131002);
                if (parcelableSnapshotMutableIntState.getIntValue() != 0) {
                    gapComposer.startReplaceGroup(1204826864);
                    OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    zChanged4 = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (!zChanged4 || objRememberedValue4 == neverEqualPolicy3) {
                        z = false;
                        objRememberedValue4 = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 0, mutableState3, parcelableSnapshotMutableIntState);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    } else {
                        z = false;
                    }
                    CardKt.IconButton((Function0) objRememberedValue4, null, false, null, null, lambda$1991797331, gapComposer, 1572864, 62);
                    gapComposer.end(z);
                } else {
                    gapComposer.startReplaceGroup(1205311208);
                    gapComposer.end(false);
                }
                gapComposer.end(true);
                OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
                Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth2);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda5);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                zChanged = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
                objRememberedValue = gapComposer.rememberedValue();
                if (!zChanged || objRememberedValue == neverEqualPolicy3) {
                    c = 2;
                    objRememberedValue = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 2, mutableState3, parcelableSnapshotMutableIntState);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    c = 2;
                }
                CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, lambda$456461423, gapComposer, 1572864, 62);
                float intValue = parcelableSnapshotMutableIntState.getIntValue();
                ClosedFloatRange closedFloatRange = new ClosedFloatRange(-3000.0f, 3000.0f);
                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                zChanged2 = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy3) {
                    objRememberedValue2 = new ShowOffsetDialogKt$$ExternalSyntheticLambda2(parcelableSnapshotMutableIntState, mutableState3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SliderKt.Slider(intValue, (Function1) objRememberedValue2, layoutWeightElement, false, closedFloatRange, 59, null, null, gapComposer, 196608, 456);
                zChanged3 = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == neverEqualPolicy3) {
                    objRememberedValue3 = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 3, mutableState3, parcelableSnapshotMutableIntState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, f637lambda$325774682, gapComposer, 1572864, 62);
                gapComposer.end(true);
                OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 8.0f));
                FlowRowOverflow flowRowOverflow2 = OffsetKt.SpaceBetween;
                Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 48.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(flowRowOverflow2, Alignment.Companion.Top, gapComposer, 6);
                int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda5);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                TextKt.m352TextNvy7gAk("-3000ms", null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelLarge, gapComposer, 6, 0, 131066);
                TextKt.m352TextNvy7gAk("+3000ms", null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelLarge, gapComposer, 6, 0, 131066);
                gapComposer = gapComposer;
                gapComposer.end(true);
                gapComposer.end(true);
            }
            objRememberedValue9 = new ShowOffsetDialogKt$$ExternalSyntheticLambda2(mutableState3, parcelableSnapshotMutableIntState);
            gapComposer.updateRememberedValue(objRememberedValue9);
            NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy;
            ScrimKt.TextField(str2, (Function1) objRememberedValue9, modifierM156widthInVpY3zN4, false, textStyleM750copyp1EtxEg$default, null, null, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer, 384, 12779520, 4030424);
            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
            TextKt.m352TextNvy7gAk("ms", null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).titleLarge, gapComposer, 1572870, 0, 131002);
            if (parcelableSnapshotMutableIntState.getIntValue() != 0) {
                gapComposer.startReplaceGroup(1204826864);
                OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
                zChanged4 = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged4) {
                    z = false;
                    objRememberedValue4 = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 0, mutableState3, parcelableSnapshotMutableIntState);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    z = false;
                    objRememberedValue4 = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 0, mutableState3, parcelableSnapshotMutableIntState);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                CardKt.IconButton((Function0) objRememberedValue4, null, false, null, null, lambda$1991797331, gapComposer, 1572864, 62);
                gapComposer.end(z);
            } else {
                gapComposer.startReplaceGroup(1205311208);
                gapComposer.end(false);
            }
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth3);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda5);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy4, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
            zChanged = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
            objRememberedValue = gapComposer.rememberedValue();
            if (zChanged) {
                c = 2;
                objRememberedValue = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 2, mutableState3, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                c = 2;
                objRememberedValue = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 2, mutableState3, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, lambda$456461423, gapComposer, 1572864, 62);
            float intValue2 = parcelableSnapshotMutableIntState.getIntValue();
            ClosedFloatRange closedFloatRange2 = new ClosedFloatRange(-3000.0f, 3000.0f);
            LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
            zChanged2 = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = new ShowOffsetDialogKt$$ExternalSyntheticLambda2(parcelableSnapshotMutableIntState, mutableState3);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new ShowOffsetDialogKt$$ExternalSyntheticLambda2(parcelableSnapshotMutableIntState, mutableState3);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            SliderKt.Slider(intValue2, (Function1) objRememberedValue2, layoutWeightElement2, false, closedFloatRange2, 59, null, null, gapComposer, 196608, 456);
            zChanged3 = gapComposer.changed(parcelableSnapshotMutableIntState) | gapComposer.changed(mutableState3);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged3) {
                objRememberedValue3 = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 3, mutableState3, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new ShowOffsetDialogKt$$ExternalSyntheticLambda3((byte) 3, mutableState3, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, f637lambda$325774682, gapComposer, 1572864, 62);
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 8.0f));
            FlowRowOverflow flowRowOverflow3 = OffsetKt.SpaceBetween;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 48.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(flowRowOverflow3, Alignment.Companion.Top, gapComposer, 6);
            int iHashCode6 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda5);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy5, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda3);
            TextKt.m352TextNvy7gAk("-3000ms", null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelLarge, gapComposer, 6, 0, 131066);
            TextKt.m352TextNvy7gAk("+3000ms", null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelLarge, gapComposer, 6, 0, 131066);
            gapComposer = gapComposer;
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 15);
        }
    }

    public static final NavDeepLinkRequest appBarScrollBehavior(Function0 function0, GapComposer gapComposer) {
        float f = androidx.compose.material3.AppBarKt.TopAppBarTitleInset;
        Object[] objArr = new Object[0];
        CallbackWrapper callbackWrapper = TopAppBarState.Saver;
        boolean zChanged = gapComposer.changed(-3.4028235E38f) | gapComposer.changed(CropImageView.DEFAULT_ASPECT_RATIO) | gapComposer.changed(CropImageView.DEFAULT_ASPECT_RATIO);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new TextKt$$ExternalSyntheticLambda3((byte) 1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return new NavDeepLinkRequest((TopAppBarState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue, (Composer) gapComposer, 0), ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer), function0);
    }

    public static final void backToMain(NavHostController navHostController) {
        String str;
        Object next;
        NavDestination navDestination;
        navHostController.getClass();
        NavControllerImpl navControllerImpl = navHostController.impl;
        List list = Screens.MainScreens;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Screens) it.next()).route);
        }
        while (true) {
            Iterator it2 = CollectionsKt.reversed(navControllerImpl.backQueue).iterator();
            if (it2.hasNext()) {
                it2.next();
            }
            Iterator it3 = ((ConstrainedOnceSequence) SequencesKt.asSequence(it2)).iterator();
            do {
                str = null;
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
            } while (((NavBackStackEntry) next).destination instanceof NavGraph);
            if (((NavBackStackEntry) next) == null) {
                return;
            }
            NavBackStackEntry currentBackStackEntry$navigation_runtime_release = navControllerImpl.getCurrentBackStackEntry$navigation_runtime_release();
            if (currentBackStackEntry$navigation_runtime_release != null && (navDestination = currentBackStackEntry$navigation_runtime_release.destination) != null) {
                str = (String) navDestination.impl.layoutNodes;
            }
            if (CollectionsKt.contains(arrayList, str)) {
                return;
            } else {
                navHostController.popBackStack();
            }
        }
    }

    /* JADX INFO: renamed from: fadingEdge-mnoPkCQ, reason: not valid java name */
    public static final Modifier m1517fadingEdgemnoPkCQ(Modifier modifier, Dp dp, Dp dp2) {
        modifier.getClass();
        return ClipKt.drawWithContent(modifier.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : 0.99f, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero)), new FileChannelsKt$$ExternalSyntheticLambda1(dp, dp2, (byte) 1));
    }

    public static final String getLoudnessLevelLabel(LoudnessLevel loudnessLevel, GapComposer gapComposer) {
        int i;
        int i2;
        loudnessLevel.getClass();
        int iOrdinal = loudnessLevel.ordinal();
        if (iOrdinal == 0) {
            i = 197986404;
            i2 = R.string.loudness_level_aggressive;
        } else if (iOrdinal == 1) {
            i = 197988990;
            i2 = R.string.loudness_level_loud;
        } else if (iOrdinal == 2) {
            i = 197991522;
            i2 = R.string.loudness_level_balanced;
        } else {
            if (iOrdinal != 3) {
                throw Format$$ExternalSyntheticOutline0.m(gapComposer, 197984816, false);
            }
            i = 197994079;
            i2 = R.string.loudness_level_quiet;
        }
        return Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false);
    }

    public static final boolean isScrollingUp(LazyListState lazyListState, Composer composer, int i) {
        lazyListState.getClass();
        int i2 = (i & 14) ^ 6;
        boolean z = (i2 > 4 && ((GapComposer) composer).changed(lazyListState)) || (i & 6) == 4;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (z || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Fragment$5$$ExternalSyntheticOutline0.m(lazyListState.getFirstVisibleItemIndex(), gapComposer);
        }
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue;
        boolean z2 = (i2 > 4 && gapComposer.changed(lazyListState)) || (i & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z2 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = Fragment$5$$ExternalSyntheticOutline0.m(lazyListState.getFirstVisibleItemScrollOffset(), gapComposer);
        }
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) objRememberedValue2;
        boolean z3 = (i2 > 4 && gapComposer.changed(lazyListState)) || (i & 6) == 4;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (z3 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new QueueKt$$ExternalSyntheticLambda24(lazyListState, parcelableSnapshotMutableIntState, parcelableSnapshotMutableIntState2));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        return ((Boolean) ((State) objRememberedValue3).getValue()).booleanValue();
    }

    public static final String numberFormatter(int i) {
        String str = new DecimalFormat("#,###").format(Integer.valueOf(i));
        str.getClass();
        return StringsKt__StringsJVMKt.replace(str, ",", ".", false);
    }

    public static final Object resetHeightOffset(TopAppBarState topAppBarState, SuspendLambda suspendLambda) {
        Object objAnimate$default;
        return (topAppBarState._heightOffset.getFloatValue() != CropImageView.DEFAULT_ASPECT_RATIO && (objAnimate$default = ArcSplineKt.animate$default(topAppBarState._heightOffset.getFloatValue(), CropImageView.DEFAULT_ASPECT_RATIO, null, new URLParserKt$$ExternalSyntheticLambda0((byte) 7, topAppBarState), suspendLambda, 12)) == CoroutineSingletons.COROUTINE_SUSPENDED) ? objAnimate$default : Unit.INSTANCE;
    }
}
