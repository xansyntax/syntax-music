package com.metrolist.music.ui.screens.search;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.ScrimKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.utils.YouTubeUrlParser;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Album;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Artist;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Playlist;
import com.metrolist.innertube.utils.YouTubeUrlParser$ParsedUrl$Video;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.SearchSource;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SearchScreenKt {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SearchSource.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Lifecycle.Event.values().length];
            try {
                iArr2[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void SearchScreen(boolean z, SavedStateHandle savedStateHandle, Composer composer, int i) {
        GapComposer gapComposer;
        FocusRequester focusRequester;
        boolean z2;
        SoftwareKeyboardController softwareKeyboardController;
        MutableState mutableState;
        long j;
        boolean z3 = z;
        savedStateHandle.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(309624708);
        int i2 = (gapComposer2.changed(z3) ? 4 : 2) | i | (gapComposer2.changedInstance(savedStateHandle) ? 32 : 16);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            final NavHostController navHostController = (NavHostController) gapComposer2.consume(MainActivityKt.LocalNavController);
            final MusicDatabase musicDatabase = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            final FocusOwner focusOwner = (FocusOwner) gapComposer2.consume(CompositionLocalsKt.LocalFocusManager);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FocusRequester();
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            FocusRequester focusRequester2 = (FocusRequester) objRememberedValue2;
            SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) gapComposer2.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            final PlayerConnection playerConnection = (PlayerConnection) gapComposer2.consume(MainActivityKt.LocalPlayerConnection);
            Boolean bool = (Boolean) gapComposer2.consume(MainActivityKt.LocalIsPlayerExpanded);
            boolean zBooleanValue = bool.booleanValue();
            LifecycleOwner lifecycleOwner = (LifecycleOwner) gapComposer2.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer2);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(savedStateHandle.getStateFlow(0, "scrollToTopCount"), 0, gapComposer2, 48);
            Object[] objArr = new Object[0];
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue4, gapComposer2, 48);
            boolean zChanged = gapComposer2.changed(zBooleanValue) | gapComposer2.changed(softwareKeyboardController2);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new MusicService.C01701(zBooleanValue, focusRequester2, softwareKeyboardController2, (Continuation) null);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue5);
            Integer numValueOf = Integer.valueOf(((Number) mutableStateCollectAsStateWithLifecycle.getValue()).intValue());
            boolean zChanged2 = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer2.changed(parcelableSnapshotMutableIntState) | gapComposer2.changed(zBooleanValue) | gapComposer2.changedInstance(focusOwner) | gapComposer2.changed(softwareKeyboardController2);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                focusRequester = focusRequester2;
                objRememberedValue6 = new SearchScreenKt$SearchScreen$2$1(zBooleanValue, focusOwner, focusRequester, softwareKeyboardController2, mutableStateCollectAsStateWithLifecycle, parcelableSnapshotMutableIntState, mutableState2, null);
                z2 = zBooleanValue;
                softwareKeyboardController = softwareKeyboardController2;
                mutableState = mutableState2;
                gapComposer2.updateRememberedValue(objRememberedValue6);
            } else {
                focusRequester = focusRequester2;
                softwareKeyboardController = softwareKeyboardController2;
                z2 = zBooleanValue;
                mutableState = mutableState2;
            }
            Stack.LaunchedEffect(gapComposer2, numValueOf, (Function2) objRememberedValue6);
            Preferences$Key preferences$Key = PreferenceKeysKt.SearchSourceKey;
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue7;
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = StateFlowKt.distinctUntilChanged(new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 0));
                gapComposer2.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue8, SearchSource.ONLINE, gapComposer2, 48);
            Object objRememberedValue9 = gapComposer2.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle2, coroutineScope2, context, preferences$Key);
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 = (SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2) objRememberedValue9;
            Object[] objArr2 = new Object[0];
            Object objRememberedValue10 = gapComposer2.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 25);
                gapComposer2.updateRememberedValue(objRememberedValue10);
            }
            MutableState mutableStateRememberSaveable = SaverKt.rememberSaveable(objArr2, (Saver) TextFieldValue.Saver, (Function0) objRememberedValue10, (Composer) gapComposer2, 384);
            final DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1RememberPreference = UtilsKt.rememberPreference(PreferenceKeysKt.PauseSearchHistoryKey, Boolean.FALSE, gapComposer2, 48);
            boolean zChangedInstance = gapComposer2.changedInstance(focusOwner) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(musicDatabase);
            Object objRememberedValue11 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue11 == neverEqualPolicy) {
                final byte b = 0;
                Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        switch (b2) {
                            case 0:
                                String str = (String) obj;
                                str.getClass();
                                SearchScreenKt.SearchScreen$handleSearch(focusOwner, playerConnection, navHostController, coroutineScope, dataStoreKt$rememberPreference$1$1RememberPreference, musicDatabase, str);
                                break;
                            default:
                                String str2 = (String) obj;
                                str2.getClass();
                                SearchScreenKt.SearchScreen$handleSearch(focusOwner, playerConnection, navHostController, coroutineScope, dataStoreKt$rememberPreference$1$1RememberPreference, musicDatabase, str2);
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer2.updateRememberedValue(function1);
                objRememberedValue11 = function1;
            }
            Function1 function2 = (Function1) objRememberedValue11;
            boolean zChangedInstance2 = gapComposer2.changedInstance(focusOwner) | gapComposer2.changedInstance(playerConnection) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1RememberPreference) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(musicDatabase);
            Object objRememberedValue12 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue12 == neverEqualPolicy) {
                final byte b2 = 1;
                objRememberedValue12 = new Function1() { // from class: com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        byte b3 = b2;
                        Unit unit = Unit.INSTANCE;
                        switch (b3) {
                            case 0:
                                String str = (String) obj;
                                str.getClass();
                                SearchScreenKt.SearchScreen$handleSearch(focusOwner, playerConnection, navHostController, coroutineScope, dataStoreKt$rememberPreference$1$1RememberPreference, musicDatabase, str);
                                break;
                            default:
                                String str2 = (String) obj;
                                str2.getClass();
                                SearchScreenKt.SearchScreen$handleSearch(focusOwner, playerConnection, navHostController, coroutineScope, dataStoreKt$rememberPreference$1$1RememberPreference, musicDatabase, str2);
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue12);
            }
            Function1 function3 = (Function1) objRememberedValue12;
            boolean z4 = z2;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1864507832, new ButtonKt$$ExternalSyntheticLambda6(z, focusRequester, function2, mutableStateRememberSaveable, searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2, navHostController), gapComposer2);
            if (z) {
                gapComposer2.startReplaceGroup(1196885737);
                gapComposer2.end(false);
                j = -72057594037927936L;
            } else {
                gapComposer2.startReplaceGroup(1196886926);
                long j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                gapComposer2.end(false);
                j = j2;
            }
            z3 = z;
            ScrimKt.m317ScaffoldTvnljyQ(null, composableLambdaImplRememberComposableLambda, null, null, null, 0, j, 0L, null, Expect_jvmKt.rememberComposableLambda(1711657107, new AlbumMenuKt$$ExternalSyntheticLambda16(navHostController, z, mutableStateRememberSaveable, function3, lazyListStateRememberLazyListState, searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2), gapComposer2), gapComposer2, 805306416, 445);
            gapComposer = gapComposer2;
            boolean zChanged3 = gapComposer.changed(z4) | gapComposer.changed(softwareKeyboardController) | gapComposer.changedInstance(focusOwner) | gapComposer.changedInstance(lifecycleOwner);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new MenuKt$$ExternalSyntheticLambda2(lifecycleOwner, z4, softwareKeyboardController, focusOwner, mutableState);
                gapComposer.updateRememberedValue(objRememberedValue13);
            }
            Stack.DisposableEffect(lifecycleOwner, bool, (Function1) objRememberedValue13, gapComposer);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringsKt__StringsKt$$ExternalSyntheticLambda1(z3, savedStateHandle, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void SearchScreen$handleSearch(FocusOwner focusOwner, PlayerConnection playerConnection, NavHostController navHostController, CoroutineScope coroutineScope, MutableState mutableState, MusicDatabase musicDatabase, String str) {
        if (str.length() == 0) {
            return;
        }
        ((FocusOwnerImpl) focusOwner).m409clearFocusI7lrPNg(8, false, true);
        Okio__OkioKt okio__OkioKt = YouTubeUrlParser.parse(str);
        int i = 2;
        Continuation continuation = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (okio__OkioKt == null) {
            Format$$ExternalSyntheticOutline0.m("search/", Uri.encode("__metrolist_search_query__".concat(str)), navHostController);
        } else if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Video) {
            if (playerConnection != null) {
                playerConnection.playQueue(new YouTubeQueue(new WatchEndpoint(62, ((YouTubeUrlParser$ParsedUrl$Video) okio__OkioKt).id, null, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0));
            }
        } else if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Playlist) {
            NavHostController.navigate$default(navHostController, "online_playlist/".concat(((YouTubeUrlParser$ParsedUrl$Playlist) okio__OkioKt).id));
        } else if (okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Album) {
            NavHostController.navigate$default(navHostController, "album/MPREb_".concat(((YouTubeUrlParser$ParsedUrl$Album) okio__OkioKt).id));
        } else {
            if (!(okio__OkioKt instanceof YouTubeUrlParser$ParsedUrl$Artist)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            NavHostController.navigate$default(navHostController, "artist/".concat(((YouTubeUrlParser$ParsedUrl$Artist) okio__OkioKt).id));
        }
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            return;
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new SearchScreenKt$SearchScreen$handleSearch$1(musicDatabase, str, continuation, (byte) 0), 2);
    }
}
