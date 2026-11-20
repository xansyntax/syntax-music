package com.metrolist.music.viewmodels;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.AccountInfo;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.BrowseResult;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.innertube.pages.LibraryPage;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.QuickPicks;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.InternalDatabase;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.extensions.ContextExtKt$isSyncEnabled$1;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.component.OriginalLyricsKt;
import com.metrolist.music.ui.player.QueueKt$Queue$5$1$1;
import com.metrolist.music.ui.player.QueueKt$Queue$5$4$1$1$4$1$1$1;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.utils.SyncUtils$tryAutoSync$1;
import com.metrolist.music.utils.Updater$checkForUpdate$2;
import com.metrolist.music.utils.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HomeViewModel extends ViewModel {
    public final StateFlowImpl _isLoadingMore;
    public final StateFlowImpl accountImageUrl;
    public final StateFlowImpl accountName;
    public final StateFlowImpl accountPlaylists;
    public final StateFlowImpl allLocalItems;
    public final StateFlowImpl allYtItems;
    public final StateFlowImpl communityPlaylists;
    public final Context context;
    public final StateFlowImpl dailyDiscover;
    public final MusicDatabase database;
    public final StateFlowImpl episodesForLater;
    public final StateFlowImpl explorePage;
    public final StateFlowImpl forgottenFavorites;
    public final StateFlowImpl homePage;
    public boolean isHomeDataLoaded;
    public final StateFlowImpl isLoading;
    public final StateFlowImpl isRandomizing;
    public final StateFlowImpl isRefreshing;
    public final StateFlowImpl keepListening;
    public final NetworkConnectivityObserver networkConnectivity;
    public final ReadonlyStateFlow pinnedSpeedDialItems;
    public final StateFlowImpl previousHomePage;
    public final StateFlowImpl quickPicks;
    public final Flow quickPicksEnum;
    public final StateFlowImpl savedPodcastShows;
    public final StateFlowImpl selectedChip;
    public final StateFlowImpl similarRecommendations;
    public final ReadonlyStateFlow speedDialItems;
    public final SyncUtils syncUtils;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ HomeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(HomeViewModel homeViewModel, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = homeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            HomeViewModel homeViewModel = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1(homeViewModel, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1(homeViewModel, continuation, (byte) 1);
                default:
                    return new AnonymousClass1(homeViewModel, continuation, (byte) 2);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 1:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            byte b2 = 0;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = null;
            HomeViewModel homeViewModel = this.this$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    SyncUtils syncUtils = homeViewModel.syncUtils;
                    AwaitKt.launch$default(syncUtils.syncScope, null, null, new SyncUtils$tryAutoSync$1(syncUtils, continuation, b2), 3);
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    if (!homeViewModel.isHomeDataLoaded) {
                        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(homeViewModel);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new ArtistViewModel.AnonymousClass1(homeViewModel, continuation, (byte) 7), 2);
                    }
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    SyncUtils syncUtils2 = homeViewModel.syncUtils;
                    AwaitKt.launch$default(syncUtils2.syncScope, null, null, new SyncUtils$tryAutoSync$1(syncUtils2, continuation, b2), 3);
                    break;
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ HomeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(HomeViewModel homeViewModel, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = homeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            HomeViewModel homeViewModel = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 5);
                default:
                    return new AnonymousClass3(homeViewModel, continuation, (byte) 6);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            final HomeViewModel homeViewModel = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            final byte b2 = 1;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (z) {
                        if (z) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(homeViewModel.context).getData(), (byte) 4));
                    final byte b3 = 0;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.viewmodels.HomeViewModel.3.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) throws IOException {
                            Object objLoadAccountPlaylists;
                            byte b4 = b3;
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            HomeViewModel homeViewModel2 = homeViewModel;
                            Unit unit2 = Unit.INSTANCE;
                            switch (b4) {
                                case 0:
                                    Pair pair = (Pair) obj2;
                                    StateFlowImpl stateFlowImpl = homeViewModel2.accountName;
                                    String str = (String) pair.first;
                                    String str2 = (String) pair.second;
                                    if (str == null || str.length() == 0) {
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, "Guest");
                                        homeViewModel2.accountImageUrl.setValue(null);
                                        homeViewModel2.accountPlaylists.setValue(null);
                                        return unit2;
                                    }
                                    YouTube youTube = YouTube.INSTANCE;
                                    YouTube.setCookie(str);
                                    if (str2 == null) {
                                        str2 = "";
                                    }
                                    String str3 = StringsKt.isBlank(str2) ? "Guest" : str2;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, str3);
                                    Object objLoadAccountInfo = homeViewModel2.loadAccountInfo(continuation);
                                    return objLoadAccountInfo == coroutineSingletons2 ? objLoadAccountInfo : unit2;
                                default:
                                    ((Boolean) obj2).getClass();
                                    YouTube youTube2 = YouTube.INSTANCE;
                                    return (((InnerTube.SessionSnapshot) YouTube.innerTube.innerTubeX.session.get()).cookie == null || homeViewModel2.accountPlaylists.getValue() == null || (objLoadAccountPlaylists = homeViewModel2.loadAccountPlaylists(continuation)) != coroutineSingletons2) ? unit2 : objLoadAccountPlaylists;
                            }
                        }
                    };
                    this.label = true;
                    return flowDistinctUntilChanged.collect(flowCollector, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    boolean z2 = this.label;
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Flow flowDistinctUntilChanged2 = StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(homeViewModel.context).getData(), (byte) 5));
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: com.metrolist.music.viewmodels.HomeViewModel.3.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) throws IOException {
                            Object objLoadAccountPlaylists;
                            byte b4 = b2;
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            HomeViewModel homeViewModel2 = homeViewModel;
                            Unit unit2 = Unit.INSTANCE;
                            switch (b4) {
                                case 0:
                                    Pair pair = (Pair) obj2;
                                    StateFlowImpl stateFlowImpl = homeViewModel2.accountName;
                                    String str = (String) pair.first;
                                    String str2 = (String) pair.second;
                                    if (str == null || str.length() == 0) {
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, "Guest");
                                        homeViewModel2.accountImageUrl.setValue(null);
                                        homeViewModel2.accountPlaylists.setValue(null);
                                        return unit2;
                                    }
                                    YouTube youTube = YouTube.INSTANCE;
                                    YouTube.setCookie(str);
                                    if (str2 == null) {
                                        str2 = "";
                                    }
                                    String str3 = StringsKt.isBlank(str2) ? "Guest" : str2;
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, str3);
                                    Object objLoadAccountInfo = homeViewModel2.loadAccountInfo(continuation);
                                    return objLoadAccountInfo == coroutineSingletons2 ? objLoadAccountInfo : unit2;
                                default:
                                    ((Boolean) obj2).getClass();
                                    YouTube youTube2 = YouTube.INSTANCE;
                                    return (((InnerTube.SessionSnapshot) YouTube.innerTube.innerTubeX.session.get()).cookie == null || homeViewModel2.accountPlaylists.getValue() == null || (objLoadAccountPlaylists = homeViewModel2.loadAccountPlaylists(continuation)) != coroutineSingletons2) ? unit2 : objLoadAccountPlaylists;
                            }
                        }
                    };
                    this.label = true;
                    return flowDistinctUntilChanged2.collect(flowCollector2, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return homeViewModel.getQuickPicks(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return homeViewModel.loadAccountInfo(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    boolean z5 = this.label;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return homeViewModel.loadAccountPlaylists(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 5:
                    boolean z6 = this.label;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return homeViewModel.getDailyDiscover(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z7 = this.label;
                    if (!z7) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return homeViewModel.getCommunityPlaylists(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$fetchPodcastData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02021 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02021(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.fetchPodcastData(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$getCommunityPlaylists$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02031 extends ContinuationImpl {
        public LocalDateTime L$0;
        public List L$1;
        public List L$3;
        public List L$5;
        public int label;
        public /* synthetic */ Object result;

        public C02031(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.getCommunityPlaylists(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$getDailyDiscover$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02041 extends ContinuationImpl {
        public List L$2;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C02041(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.getDailyDiscover(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$getQuickPicks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02051 extends ContinuationImpl {
        public List L$0;
        public Object L$1;
        public List L$3;
        public Object L$5;
        public Iterator L$8;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C02051(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.getQuickPicks(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$getRandomItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02061 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02061(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.getRandomItem(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02071 extends ContinuationImpl {
        public LocalDateTime L$0;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public C02071(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.load(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$load$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass7 extends SuspendLambda implements Function2 {
        public final /* synthetic */ LocalDateTime $fromTimeStamp;
        public final /* synthetic */ boolean $hideExplicit;
        public final /* synthetic */ boolean $hideVideoSongs;
        public List L$0;
        public List L$1;
        public List L$10;
        public Collection L$2;
        public Collection L$3;
        public Object L$4;
        public Iterator L$5;
        public Iterator L$6;
        public Artist L$7;
        public Object L$8;
        public Album L$9;
        public boolean Z$0;
        public boolean Z$1;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(LocalDateTime localDateTime, boolean z, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.$fromTimeStamp = localDateTime;
            this.$hideExplicit = z;
            this.$hideVideoSongs = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HomeViewModel.this.new AnonymousClass7(this.$fromTimeStamp, this.$hideExplicit, this.$hideVideoSongs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass7) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x016a  */
        /* JADX WARN: Code duplicated, block: B:49:0x0220  */
        /* JADX WARN: Code duplicated, block: B:61:0x0297  */
        /* JADX WARN: Code duplicated, block: B:64:0x02d4  */
        /* JADX WARN: Code duplicated, block: B:67:0x02df  */
        /* JADX WARN: Code duplicated, block: B:70:0x02e4  */
        /* JADX WARN: Code duplicated, block: B:95:0x03cb  */
        /* JADX WARN: Code duplicated, block: B:97:0x03d3  */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.util.Collection, java.util.Iterator, java.util.List] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x049e -> B:130:0x04e1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x04a2 -> B:130:0x04e1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x04c9 -> B:125:0x04cc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x01a0 -> B:29:0x01a4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0313 -> B:77:0x0314). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 1484
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.viewmodels.HomeViewModel.AnonymousClass7.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$loadAccountInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02091 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02091(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.loadAccountInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$loadAccountPlaylists$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02101 extends ContinuationImpl {
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C02101(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.loadAccountPlaylists(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02111 extends SuspendLambda implements Function2 {
        public boolean Z$0;
        public boolean Z$1;
        public boolean Z$2;
        public byte label;

        public C02111(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HomeViewModel.this.new C02111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C02111) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0088  */
        /* JADX WARN: Code duplicated, block: B:25:0x008d  */
        /* JADX WARN: Code duplicated, block: B:27:0x0097  */
        /* JADX WARN: Code duplicated, block: B:28:0x009a  */
        /* JADX WARN: Code duplicated, block: B:32:0x00ac A[LOOP:0: B:30:0x00a6->B:32:0x00ac, LOOP_END] */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00de, code lost:
        
            if (r0.load(r10) == r2) goto L36;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            Object objM987home0E7RQCE$default;
            boolean z;
            boolean z2;
            HomePage homePage;
            HomePage homePage2;
            List list;
            ArrayList arrayList;
            HomeViewModel homeViewModel = HomeViewModel.this;
            Context context = homeViewModel.context;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                HomePage.Chip chip = (HomePage.Chip) homeViewModel.selectedChip.getValue();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (chip != null) {
                    DataStore dataStore = UtilsKt.getDataStore(context);
                    Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                    Boolean bool = Boolean.FALSE;
                    boolean zBooleanValue2 = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
                    boolean zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
                    zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
                    YouTube youTube = YouTube.INSTANCE;
                    BrowseEndpoint browseEndpoint = chip.endpoint;
                    String str = browseEndpoint != null ? browseEndpoint.params : null;
                    this.Z$0 = zBooleanValue2;
                    this.Z$1 = zBooleanValue3;
                    this.Z$2 = zBooleanValue;
                    this.label = (byte) 1;
                    objM987home0E7RQCE$default = YouTube.m987home0E7RQCE$default(null, str, this, 1);
                    if (objM987home0E7RQCE$default != coroutineSingletons) {
                        z = zBooleanValue2;
                        z2 = zBooleanValue3;
                        if (objM987home0E7RQCE$default instanceof Result.Failure) {
                            objM987home0E7RQCE$default = null;
                        }
                        homePage = (HomePage) objM987home0E7RQCE$default;
                        if (homePage != null) {
                            StateFlowImpl stateFlowImpl = homeViewModel.homePage;
                            homePage2 = (HomePage) stateFlowImpl.getValue();
                            if (homePage2 != null) {
                                list = homePage2.chips;
                            } else {
                                list = null;
                            }
                            List<HomePage.Section> list2 = homePage.sections;
                            arrayList = new ArrayList();
                            for (HomePage.Section section : list2) {
                                arrayList.add(HomePage.Section.copy$default(section, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(CollectionsKt.filterNotNull(section.items), z), z2), zBooleanValue)));
                            }
                            HomePage homePageCopy$default = HomePage.copy$default(homePage, list, arrayList, 4);
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, homePageCopy$default);
                        }
                    }
                } else {
                    this.label = (byte) 2;
                }
                return coroutineSingletons;
            }
            if (b == 1) {
                zBooleanValue = this.Z$2;
                z2 = this.Z$1;
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
                objM987home0E7RQCE$default = ((Result) obj).value;
                if (objM987home0E7RQCE$default instanceof Result.Failure) {
                    objM987home0E7RQCE$default = null;
                }
                homePage = (HomePage) objM987home0E7RQCE$default;
                if (homePage != null) {
                    StateFlowImpl stateFlowImpl2 = homeViewModel.homePage;
                    homePage2 = (HomePage) stateFlowImpl2.getValue();
                    if (homePage2 != null) {
                        list = homePage2.chips;
                    } else {
                        list = null;
                    }
                    List<HomePage.Section> list3 = homePage.sections;
                    arrayList = new ArrayList();
                    while (r6.hasNext()) {
                        arrayList.add(HomePage.Section.copy$default(section, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(CollectionsKt.filterNotNull(section.items), z), z2), zBooleanValue)));
                    }
                    HomePage homePageCopy$default2 = HomePage.copy$default(homePage, list, arrayList, 4);
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, homePageCopy$default2);
                }
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            StateFlowImpl stateFlowImpl3 = homeViewModel.isRefreshing;
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, bool2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$toggleChip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02121 extends SuspendLambda implements Function2 {
        public final /* synthetic */ HomePage.Chip $chip;
        public boolean Z$0;
        public boolean Z$1;
        public boolean Z$2;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02121(HomePage.Chip chip, Continuation continuation) {
            super(2, continuation);
            this.$chip = chip;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HomeViewModel.this.new C02121(this.$chip, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C02121) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            boolean zBooleanValue2;
            boolean zBooleanValue3;
            Object objM987home0E7RQCE$default;
            HomeViewModel homeViewModel = HomeViewModel.this;
            Context context = homeViewModel.context;
            byte b = this.label;
            Unit unit = Unit.INSTANCE;
            HomePage.Chip chip = this.$chip;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                DataStore dataStore = UtilsKt.getDataStore(context);
                Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                Boolean bool = Boolean.FALSE;
                zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
                zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
                zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
                YouTube youTube = YouTube.INSTANCE;
                BrowseEndpoint browseEndpoint = chip.endpoint;
                String str = browseEndpoint != null ? browseEndpoint.params : null;
                this.Z$0 = zBooleanValue;
                this.Z$1 = zBooleanValue2;
                this.Z$2 = zBooleanValue3;
                this.label = (byte) 1;
                objM987home0E7RQCE$default = YouTube.m987home0E7RQCE$default(null, str, this, 1);
                if (objM987home0E7RQCE$default != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (b != 1) {
                if (b == 2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            zBooleanValue3 = this.Z$2;
            zBooleanValue2 = this.Z$1;
            zBooleanValue = this.Z$0;
            ResultKt.throwOnFailure(obj);
            objM987home0E7RQCE$default = ((Result) obj).value;
            if (objM987home0E7RQCE$default instanceof Result.Failure) {
                objM987home0E7RQCE$default = null;
            }
            HomePage homePage = (HomePage) objM987home0E7RQCE$default;
            if (homePage != null) {
                StateFlowImpl stateFlowImpl = homeViewModel.homePage;
                HomePage homePage2 = (HomePage) stateFlowImpl.getValue();
                List list = homePage2 != null ? homePage2.chips : null;
                List<HomePage.Section> list2 = homePage.sections;
                ArrayList arrayList = new ArrayList();
                for (HomePage.Section section : list2) {
                    arrayList.add(HomePage.Section.copy$default(section, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(CollectionsKt.filterNotNull(section.items), zBooleanValue), zBooleanValue2), zBooleanValue3)));
                }
                HomePage homePageCopy$default = HomePage.copy$default(homePage, list, arrayList, 4);
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, homePageCopy$default);
                homeViewModel.selectedChip.setValue(chip);
                if (StringsKt.contains(chip.title, "Podcast", true)) {
                    this.Z$0 = zBooleanValue;
                    this.Z$1 = zBooleanValue2;
                    this.Z$2 = zBooleanValue3;
                    this.label = (byte) 2;
                    if (homeViewModel.fetchPodcastData(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            return unit;
        }
    }

    public HomeViewModel(Context context, MusicDatabase musicDatabase, SyncUtils syncUtils, NetworkConnectivityObserver networkConnectivityObserver) {
        musicDatabase.getClass();
        syncUtils.getClass();
        networkConnectivityObserver.getClass();
        this.context = context;
        this.database = musicDatabase;
        this.syncUtils = syncUtils;
        this.networkConnectivity = networkConnectivityObserver;
        Boolean bool = Boolean.FALSE;
        this.isRefreshing = StateFlowKt.MutableStateFlow(bool);
        this.isLoading = StateFlowKt.MutableStateFlow(bool);
        this.isRandomizing = StateFlowKt.MutableStateFlow(bool);
        byte b = 0;
        this.quickPicksEnum = StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), b));
        Continuation continuation = null;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.quickPicks = stateFlowImplMutableStateFlow;
        this.dailyDiscover = StateFlowKt.MutableStateFlow(null);
        this.forgottenFavorites = StateFlowKt.MutableStateFlow(null);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.keepListening = stateFlowImplMutableStateFlow2;
        this.similarRecommendations = StateFlowKt.MutableStateFlow(null);
        this.accountPlaylists = StateFlowKt.MutableStateFlow(null);
        StateFlowImpl stateFlowImplMutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.homePage = stateFlowImplMutableStateFlow3;
        this.explorePage = StateFlowKt.MutableStateFlow(null);
        this.communityPlaylists = StateFlowKt.MutableStateFlow(null);
        this.selectedChip = StateFlowKt.MutableStateFlow(null);
        this.previousHomePage = StateFlowKt.MutableStateFlow(null);
        EmptyList emptyList = EmptyList.INSTANCE;
        this.savedPodcastShows = StateFlowKt.MutableStateFlow(emptyList);
        this.episodesForLater = StateFlowKt.MutableStateFlow(emptyList);
        this.allLocalItems = StateFlowKt.MutableStateFlow(emptyList);
        this.allYtItems = StateFlowKt.MutableStateFlow(emptyList);
        InternalDatabase internalDatabase = musicDatabase.delegate;
        FlowUtil$createFlow$$inlined$map$1 all = internalDatabase.getSpeedDialDao().getAll();
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        this.pinnedSpeedDialItems = StateFlowKt.stateIn(all, viewModelScope, startedLazily, emptyList);
        this.speedDialItems = StateFlowKt.stateIn(new DownloadUtil$getDownload$$inlined$map$1(new Flow[]{internalDatabase.getSpeedDialDao().getAll(), stateFlowImplMutableStateFlow2, stateFlowImplMutableStateFlow, stateFlowImplMutableStateFlow3}, new HomeViewModel$speedDialItems$1(5, null), (byte) 10), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.accountName = StateFlowKt.MutableStateFlow("Guest");
        this.accountImageUrl = StateFlowKt.MutableStateFlow(null);
        this._isLoadingMore = StateFlowKt.MutableStateFlow(bool);
        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(this);
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(viewModelScope2, defaultIoScheduler, null, new AnonymousClass1(this, continuation, b), 2);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = !((Boolean) networkConnectivityObserver.networkStatus.$$delegate_0.getValue()).booleanValue();
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new DataStoreKt$get$1((Object) this, (Object) ref$BooleanRef, continuation, (byte) 23), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass3(this, continuation, b), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass3(this, continuation, (byte) 1), 2);
    }

    public static ArrayList filterOutNulls(List list) {
        list.getClass();
        return CollectionsKt.filterNotNull(list);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r7 == r5) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchPodcastData(ContinuationImpl continuationImpl) {
        C02021 c02021;
        Object objM1038savedPodcastShowsIoAF18A;
        Object objM1004episodesForLaterIoAF18A;
        if (continuationImpl instanceof C02021) {
            c02021 = (C02021) continuationImpl;
            int i = c02021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02021.label = i - Integer.MIN_VALUE;
            } else {
                c02021 = new C02021(continuationImpl);
            }
        } else {
            c02021 = new C02021(continuationImpl);
        }
        Object obj = c02021.result;
        int i2 = c02021.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            c02021.label = 1;
            objM1038savedPodcastShowsIoAF18A = youTube.m1038savedPodcastShowsIoAF18A(c02021);
            if (objM1038savedPodcastShowsIoAF18A != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
            objM1038savedPodcastShowsIoAF18A = ((Result) obj).value;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM1004episodesForLaterIoAF18A = ((Result) obj).value;
        }
        if (!(objM1004episodesForLaterIoAF18A instanceof Result.Failure)) {
            ArrayList arrayListFilterOutNulls = filterOutNulls((List) objM1004episodesForLaterIoAF18A);
            StateFlowImpl stateFlowImpl = this.episodesForLater;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayListFilterOutNulls);
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1004episodesForLaterIoAF18A);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
        if (!(objM1038savedPodcastShowsIoAF18A instanceof Result.Failure)) {
            ArrayList arrayListFilterOutNulls2 = filterOutNulls((List) objM1038savedPodcastShowsIoAF18A);
            StateFlowImpl stateFlowImpl2 = this.savedPodcastShows;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, arrayListFilterOutNulls2);
        }
        Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(objM1038savedPodcastShowsIoAF18A);
        if (thM1866exceptionOrNullimpl2 != null) {
            thM1866exceptionOrNullimpl2.printStackTrace();
        }
        YouTube youTube2 = YouTube.INSTANCE;
        c02021.label = 2;
        objM1004episodesForLaterIoAF18A = youTube2.m1004episodesForLaterIoAF18A(c02021);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:40:0x010e  */
    /* JADX WARN: Code duplicated, block: B:46:0x014b  */
    /* JADX WARN: Code duplicated, block: B:50:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object getCommunityPlaylists(ContinuationImpl continuationImpl) {
        C02031 c02031;
        LocalDateTime localDateTimeMinusWeeks;
        List list;
        List listSynchronizedList;
        CoroutineSingletons coroutineSingletons;
        QueueKt$Queue$5$1$1 queueKt$Queue$5$1$1;
        List list2;
        HashSet hashSet;
        ArrayList arrayList;
        List listSynchronizedList2;
        InnerTube$feedback$2 innerTube$feedback$2;
        List list3;
        if (continuationImpl instanceof C02031) {
            c02031 = (C02031) continuationImpl;
            int i = c02031.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02031.label = i - Integer.MIN_VALUE;
            } else {
                c02031 = new C02031(continuationImpl);
            }
        } else {
            c02031 = new C02031(continuationImpl);
        }
        Object objFirst = c02031.result;
        int i2 = c02031.label;
        MusicDatabase musicDatabase = this.database;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            localDateTimeMinusWeeks = LocalDateTime.now().minusWeeks(4L);
            localDateTimeMinusWeeks.getClass();
            Flow flowMostPlayedArtists$default = DatabaseDao.mostPlayedArtists$default(musicDatabase, localDateTimeMinusWeeks, 10, null, 12);
            c02031.L$0 = localDateTimeMinusWeeks;
            c02031.label = 1;
            objFirst = StateFlowKt.first(flowMostPlayedArtists$default, c02031);
            if (objFirst != coroutineSingletons2) {
            }
            return coroutineSingletons2;
        }
        if (i2 == 1) {
            localDateTimeMinusWeeks = c02031.L$0;
            ResultKt.throwOnFailure(objFirst);
        } else if (i2 == 2) {
            List list4 = c02031.L$1;
            ResultKt.throwOnFailure(objFirst);
            list = list4;
            List listTake = CollectionsKt.take(CollectionsKt__IterablesKt.shuffled((Iterable) objFirst), 2);
            listSynchronizedList = Collections.synchronizedList(new ArrayList());
            coroutineSingletons = coroutineSingletons2;
            queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1((Object) list, (Object) listTake, (Object) listSynchronizedList, continuation, (byte) 13);
            c02031.L$0 = null;
            c02031.L$1 = null;
            c02031.L$3 = listSynchronizedList;
            c02031.label = 3;
            if (AwaitKt.coroutineScope(queueKt$Queue$5$1$1, c02031) == coroutineSingletons) {
                return coroutineSingletons;
            }
            list2 = listSynchronizedList;
            list2.getClass();
            hashSet = new HashSet();
            arrayList = new ArrayList();
            for (Object obj : list2) {
                if (hashSet.add(((PlaylistItem) obj).id)) {
                    arrayList.add(obj);
                }
            }
            List mutableList = CollectionsKt.toMutableList((Iterable) arrayList);
            Collections.shuffle(mutableList);
            List listTake2 = CollectionsKt.take(mutableList, 5);
            listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
            innerTube$feedback$2 = new InnerTube$feedback$2(listTake2, listSynchronizedList2, null);
            c02031.L$0 = null;
            c02031.L$1 = null;
            c02031.L$3 = null;
            c02031.L$5 = listSynchronizedList2;
            c02031.label = 4;
            if (AwaitKt.coroutineScope(innerTube$feedback$2, c02031) == coroutineSingletons) {
                return coroutineSingletons;
            }
            list3 = listSynchronizedList2;
        } else if (i2 == 3) {
            list2 = c02031.L$3;
            ResultKt.throwOnFailure(objFirst);
            coroutineSingletons = coroutineSingletons2;
            list2.getClass();
            hashSet = new HashSet();
            arrayList = new ArrayList();
            while (r3.hasNext()) {
                if (hashSet.add(((PlaylistItem) obj).id)) {
                    arrayList.add(obj);
                }
            }
            List mutableList2 = CollectionsKt.toMutableList((Iterable) arrayList);
            Collections.shuffle(mutableList2);
            List listTake3 = CollectionsKt.take(mutableList2, 5);
            listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
            innerTube$feedback$2 = new InnerTube$feedback$2(listTake3, listSynchronizedList2, null);
            c02031.L$0 = null;
            c02031.L$1 = null;
            c02031.L$3 = null;
            c02031.L$5 = listSynchronizedList2;
            c02031.label = 4;
            if (AwaitKt.coroutineScope(innerTube$feedback$2, c02031) == coroutineSingletons) {
                return coroutineSingletons;
            }
            list3 = listSynchronizedList2;
        } else {
            if (i2 != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list3 = c02031.L$5;
            ResultKt.throwOnFailure(objFirst);
        }
        list3.getClass();
        List mutableList3 = CollectionsKt.toMutableList((Iterable) list3);
        Collections.shuffle(mutableList3);
        StateFlowImpl stateFlowImpl = this.communityPlaylists;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, mutableList3);
        return Unit.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : (Iterable) objFirst) {
            if (((Artist) obj2).artist.isYouTubeArtist()) {
                arrayList2.add(obj2);
            }
        }
        List mutableList4 = CollectionsKt.toMutableList((Iterable) arrayList2);
        Collections.shuffle(mutableList4);
        List listTake4 = CollectionsKt.take(mutableList4, 3);
        localDateTimeMinusWeeks.getClass();
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        musicDatabase.getClass();
        Flow flowMostPlayedSongs = musicDatabase.$$delegate_0.mostPlayedSongs(localDateTimeMinusWeeks, 5, 0, localDateTimeNow);
        c02031.L$0 = null;
        c02031.L$1 = listTake4;
        c02031.label = 2;
        Object objFirst2 = StateFlowKt.first(flowMostPlayedSongs, c02031);
        if (objFirst2 != coroutineSingletons2) {
            list = listTake4;
            objFirst = objFirst2;
            List listTake5 = CollectionsKt.take(CollectionsKt__IterablesKt.shuffled((Iterable) objFirst), 2);
            listSynchronizedList = Collections.synchronizedList(new ArrayList());
            coroutineSingletons = coroutineSingletons2;
            queueKt$Queue$5$1$1 = new QueueKt$Queue$5$1$1((Object) list, (Object) listTake5, (Object) listSynchronizedList, continuation, (byte) 13);
            c02031.L$0 = null;
            c02031.L$1 = null;
            c02031.L$3 = listSynchronizedList;
            c02031.label = 3;
            if (AwaitKt.coroutineScope(queueKt$Queue$5$1$1, c02031) == coroutineSingletons) {
                return coroutineSingletons;
            }
            list2 = listSynchronizedList;
            list2.getClass();
            hashSet = new HashSet();
            arrayList = new ArrayList();
            while (r3.hasNext()) {
                if (hashSet.add(((PlaylistItem) obj).id)) {
                    arrayList.add(obj);
                }
            }
            List mutableList5 = CollectionsKt.toMutableList((Iterable) arrayList);
            Collections.shuffle(mutableList5);
            List listTake6 = CollectionsKt.take(mutableList5, 5);
            listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
            innerTube$feedback$2 = new InnerTube$feedback$2(listTake6, listSynchronizedList2, null);
            c02031.L$0 = null;
            c02031.L$1 = null;
            c02031.L$3 = null;
            c02031.L$5 = listSynchronizedList2;
            c02031.label = 4;
            if (AwaitKt.coroutineScope(innerTube$feedback$2, c02031) == coroutineSingletons) {
                return coroutineSingletons;
            }
            list3 = listSynchronizedList2;
            list3.getClass();
            List mutableList6 = CollectionsKt.toMutableList((Iterable) list3);
            Collections.shuffle(mutableList6);
            StateFlowImpl stateFlowImpl2 = this.communityPlaylists;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, mutableList6);
            return Unit.INSTANCE;
        }
        return coroutineSingletons2;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getDailyDiscover(ContinuationImpl continuationImpl) {
        C02041 c02041;
        boolean zBooleanValue;
        List list;
        HashSet hashSet;
        ArrayList arrayList;
        if (continuationImpl instanceof C02041) {
            c02041 = (C02041) continuationImpl;
            int i = c02041.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02041.label = i - Integer.MIN_VALUE;
            } else {
                c02041 = new C02041(continuationImpl);
            }
        } else {
            c02041 = new C02041(continuationImpl);
        }
        Object objFirst = c02041.result;
        int i2 = c02041.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this.context), PreferenceKeysKt.HideVideoSongsKey, Boolean.FALSE)).booleanValue();
            Flow flowLikedSongsByCreateDateAsc = this.database.$$delegate_0.likedSongsByCreateDateAsc();
            c02041.Z$0 = zBooleanValue;
            c02041.label = 1;
            objFirst = StateFlowKt.first(flowLikedSongsByCreateDateAsc, c02041);
            if (objFirst != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            zBooleanValue = c02041.Z$0;
            ResultKt.throwOnFailure(objFirst);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list = c02041.L$2;
            ResultKt.throwOnFailure(objFirst);
        }
        list.getClass();
        List list2 = CollectionsKt.toList(list);
        hashSet = new HashSet();
        arrayList = new ArrayList();
        for (Object obj : list2) {
            if (hashSet.add(((DailyDiscoverItem) obj).recommendation.id)) {
                arrayList.add(obj);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Iterable) arrayList);
        Collections.shuffle(mutableList);
        StateFlowImpl stateFlowImpl = this.dailyDiscover;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, mutableList);
        return unit;
        List list3 = (List) objFirst;
        if (list3.isEmpty()) {
            return unit;
        }
        List mutableList2 = CollectionsKt.toMutableList((Iterable) list3);
        Collections.shuffle(mutableList2);
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = (ArrayList) mutableList2;
        int size = arrayList3.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList3.get(i3);
            i3++;
            if (hashSet2.add(((Song) obj2).song.id)) {
                arrayList2.add(obj2);
            }
        }
        List listTake = CollectionsKt.take(arrayList2, 5);
        List listSynchronizedList = Collections.synchronizedList(new ArrayList());
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(listTake, listSynchronizedList, zBooleanValue, null);
        c02041.L$2 = listSynchronizedList;
        c02041.Z$0 = zBooleanValue;
        c02041.label = 2;
        if (AwaitKt.coroutineScope(anonymousClass2, c02041) != coroutineSingletons) {
            list = listSynchronizedList;
            list.getClass();
            List list4 = CollectionsKt.toList(list);
            hashSet = new HashSet();
            arrayList = new ArrayList();
            while (r13.hasNext()) {
                if (hashSet.add(((DailyDiscoverItem) obj).recommendation.id)) {
                    arrayList.add(obj);
                }
            }
            List mutableList3 = CollectionsKt.toMutableList((Iterable) arrayList);
            Collections.shuffle(mutableList3);
            StateFlowImpl stateFlowImpl2 = this.dailyDiscover;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, mutableList3);
            return unit;
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x026a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x0255 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e8 A[PHI: r13 r14
      0x00e8: PHI (r13v26 boolean) = (r13v4 boolean), (r13v27 boolean) binds: [B:29:0x00e4, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r14v58 java.lang.Object) = (r14v16 java.lang.Object), (r14v1 java.lang.Object) binds: [B:29:0x00e4, B:13:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:42:0x012f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0133  */
    /* JADX WARN: Code duplicated, block: B:47:0x014a A[PHI: r13 r14
      0x014a: PHI (r13v6 boolean) = (r13v4 boolean), (r13v7 boolean) binds: [B:45:0x0146, B:19:0x0097] A[DONT_GENERATE, DONT_INLINE]
      0x014a: PHI (r14v17 java.lang.Object) = (r14v13 java.lang.Object), (r14v1 java.lang.Object) binds: [B:45:0x0146, B:19:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x0167  */
    /* JADX WARN: Code duplicated, block: B:54:0x018b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0193  */
    /* JADX WARN: Code duplicated, block: B:58:0x0196  */
    /* JADX WARN: Code duplicated, block: B:61:0x019e  */
    /* JADX WARN: Code duplicated, block: B:64:0x01be  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:81:0x0203  */
    /* JADX WARN: Code duplicated, block: B:90:0x0237  */
    /* JADX WARN: Code duplicated, block: B:91:0x023a A[PHI: r1 r3 r5
      0x023a: PHI (r1v15 java.util.List) = (r1v13 java.util.List), (r1v17 java.util.List) binds: [B:72:0x01cf, B:77:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r3v11 java.util.List) = (r3v8 java.util.List), (r3v13 java.util.List) binds: [B:72:0x01cf, B:77:0x01e7] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r5v7 java.util.List) = (r5v5 java.util.List), (r5v9 java.util.List) binds: [B:72:0x01cf, B:77:0x01e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0257  */
    /* JADX WARN: Code duplicated, block: B:99:0x027f  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0110, code lost:
    
        if (r14 == r8) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01e2, code lost:
    
        if (r14 == r8) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0224, code lost:
    
        if (r14 == r8) goto L83;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0224 -> B:84:0x0227). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getQuickPicks(ContinuationImpl continuationImpl) {
        C02051 c02051;
        boolean z;
        int iOrdinal;
        List listFilterVideoSongs;
        Object objFirst;
        List list;
        List listTake;
        Object objFirst2;
        List list2;
        List list3;
        EventWithSong eventWithSong;
        Song song;
        List arrayList;
        Object objM1024next0E7RQCE;
        List list4;
        List list5;
        List list6;
        NextResult nextResult;
        BrowseEndpoint browseEndpoint;
        Object objM1031relatedgIAlus;
        List list7;
        Iterator it;
        List list8;
        Object obj;
        ArrayList arrayListPlus;
        HashSet hashSet;
        ArrayList arrayList2;
        int size;
        int i;
        List listTake2;
        Object obj2;
        EventWithSong eventWithSong2;
        Song song2;
        SongEntity songEntity;
        Object obj3;
        if (continuationImpl instanceof C02051) {
            c02051 = (C02051) continuationImpl;
            int i2 = c02051.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c02051.label = i2 - Integer.MIN_VALUE;
            } else {
                c02051 = new C02051(continuationImpl);
            }
        } else {
            c02051 = new C02051(continuationImpl);
        }
        Object objFirst3 = c02051.result;
        int i3 = c02051.label;
        StateFlowImpl stateFlowImpl = this.quickPicks;
        MusicDatabase musicDatabase = this.database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i3) {
            case 0:
                ResultKt.throwOnFailure(objFirst3);
                boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this.context), PreferenceKeysKt.HideVideoSongsKey, Boolean.FALSE)).booleanValue();
                c02051.Z$0 = zBooleanValue;
                c02051.label = 1;
                Object objFirst4 = StateFlowKt.first(this.quickPicksEnum, c02051);
                if (objFirst4 != coroutineSingletons) {
                    objFirst3 = objFirst4;
                    z = zBooleanValue;
                    iOrdinal = ((QuickPicks) objFirst3).ordinal();
                    if (iOrdinal != 0) {
                        Flow flowQuickPicks = musicDatabase.$$delegate_0.quickPicks(System.currentTimeMillis());
                        c02051.Z$0 = z;
                        c02051.label = 2;
                        objFirst3 = StateFlowKt.first(flowQuickPicks, c02051);
                        if (objFirst3 != coroutineSingletons) {
                            listFilterVideoSongs = CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z);
                            Flow flowForgottenFavorites = musicDatabase.forgottenFavorites(System.currentTimeMillis());
                            c02051.L$0 = listFilterVideoSongs;
                            c02051.Z$0 = z;
                            c02051.label = 3;
                            objFirst = StateFlowKt.first(flowForgottenFavorites, c02051);
                            if (objFirst != coroutineSingletons) {
                                list = listFilterVideoSongs;
                                objFirst3 = objFirst;
                                listTake = CollectionsKt.take(CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z), 8);
                                Flow flowLatestEvent = musicDatabase.$$delegate_0.latestEvent();
                                c02051.L$0 = list;
                                c02051.L$1 = listTake;
                                c02051.Z$0 = z;
                                c02051.label = 4;
                                objFirst2 = StateFlowKt.first(flowLatestEvent, c02051);
                                if (objFirst2 != coroutineSingletons) {
                                    List list9 = list;
                                    list2 = listTake;
                                    objFirst3 = objFirst2;
                                    list3 = list9;
                                    eventWithSong = (EventWithSong) objFirst3;
                                    if (eventWithSong != null) {
                                        song = eventWithSong.song;
                                    } else {
                                        song = null;
                                    }
                                    arrayList = new ArrayList();
                                    if (song != null) {
                                        YouTube youTube = YouTube.INSTANCE;
                                        WatchEndpoint watchEndpoint = new WatchEndpoint(62, song.song.id, null, null);
                                        c02051.L$0 = list3;
                                        c02051.L$1 = list2;
                                        c02051.L$3 = arrayList;
                                        c02051.Z$0 = z;
                                        c02051.label = 5;
                                        objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, c02051);
                                        if (objM1024next0E7RQCE != coroutineSingletons) {
                                            List list10 = list3;
                                            list4 = list2;
                                            list5 = arrayList;
                                            list6 = list10;
                                            if (objM1024next0E7RQCE instanceof Result.Failure) {
                                                objM1024next0E7RQCE = null;
                                            }
                                            nextResult = (NextResult) objM1024next0E7RQCE;
                                            if (nextResult != null) {
                                                browseEndpoint = nextResult.relatedEndpoint;
                                            } else {
                                                browseEndpoint = null;
                                            }
                                            if (browseEndpoint != null) {
                                                YouTube youTube2 = YouTube.INSTANCE;
                                                c02051.L$0 = list6;
                                                c02051.L$1 = list4;
                                                c02051.L$3 = list5;
                                                c02051.Z$0 = z;
                                                c02051.label = 6;
                                                objM1031relatedgIAlus = youTube2.m1031relatedgIAlus(browseEndpoint, c02051);
                                            } else {
                                                List list11 = list6;
                                                arrayList = list5;
                                                list2 = list4;
                                                list3 = list11;
                                            }
                                        }
                                        break;
                                    }
                                    arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                                    hashSet = new HashSet();
                                    arrayList2 = new ArrayList();
                                    size = arrayListPlus.size();
                                    i = 0;
                                    while (i < size) {
                                        obj2 = arrayListPlus.get(i);
                                        i++;
                                        if (hashSet.add(((Song) obj2).song.id)) {
                                            arrayList2.add(obj2);
                                        }
                                    }
                                    List mutableList = CollectionsKt.toMutableList((Iterable) arrayList2);
                                    Collections.shuffle(mutableList);
                                    listTake2 = CollectionsKt.take(mutableList, 20);
                                    if (listTake2.isEmpty()) {
                                        List mutableList2 = CollectionsKt.toMutableList((Iterable) list3);
                                        Collections.shuffle(mutableList2);
                                        listTake2 = CollectionsKt.take(mutableList2, 20);
                                    }
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, listTake2);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    } else {
                        if (iOrdinal == 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        Flow flowLatestEvent2 = musicDatabase.$$delegate_0.latestEvent();
                        c02051.Z$0 = z;
                        c02051.label = 8;
                        objFirst3 = StateFlowKt.first(flowLatestEvent2, c02051);
                        if (objFirst3 != coroutineSingletons) {
                            eventWithSong2 = (EventWithSong) objFirst3;
                            if (eventWithSong2 != null) {
                                song2 = eventWithSong2.song;
                            } else {
                                song2 = null;
                            }
                            if (song2 != null) {
                                songEntity = song2.song;
                                if (musicDatabase.hasRelatedSongs(songEntity.id)) {
                                    Flow relatedSongs = musicDatabase.getRelatedSongs(songEntity.id);
                                    c02051.L$0 = null;
                                    c02051.L$1 = stateFlowImpl;
                                    c02051.Z$0 = z;
                                    c02051.label = 9;
                                    objFirst3 = StateFlowKt.first(relatedSongs, c02051);
                                }
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                obj3 = stateFlowImpl;
                return coroutineSingletons;
            case 1:
                z = c02051.Z$0;
                ResultKt.throwOnFailure(objFirst3);
                iOrdinal = ((QuickPicks) objFirst3).ordinal();
                if (iOrdinal != 0) {
                    Flow flowQuickPicks2 = musicDatabase.$$delegate_0.quickPicks(System.currentTimeMillis());
                    c02051.Z$0 = z;
                    c02051.label = 2;
                    objFirst3 = StateFlowKt.first(flowQuickPicks2, c02051);
                    if (objFirst3 != coroutineSingletons) {
                        listFilterVideoSongs = CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z);
                        Flow flowForgottenFavorites2 = musicDatabase.forgottenFavorites(System.currentTimeMillis());
                        c02051.L$0 = listFilterVideoSongs;
                        c02051.Z$0 = z;
                        c02051.label = 3;
                        objFirst = StateFlowKt.first(flowForgottenFavorites2, c02051);
                        if (objFirst != coroutineSingletons) {
                            list = listFilterVideoSongs;
                            objFirst3 = objFirst;
                            listTake = CollectionsKt.take(CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z), 8);
                            Flow flowLatestEvent3 = musicDatabase.$$delegate_0.latestEvent();
                            c02051.L$0 = list;
                            c02051.L$1 = listTake;
                            c02051.Z$0 = z;
                            c02051.label = 4;
                            objFirst2 = StateFlowKt.first(flowLatestEvent3, c02051);
                            if (objFirst2 != coroutineSingletons) {
                                List list12 = list;
                                list2 = listTake;
                                objFirst3 = objFirst2;
                                list3 = list12;
                                eventWithSong = (EventWithSong) objFirst3;
                                if (eventWithSong != null) {
                                    song = eventWithSong.song;
                                } else {
                                    song = null;
                                }
                                arrayList = new ArrayList();
                                if (song != null) {
                                    YouTube youTube3 = YouTube.INSTANCE;
                                    WatchEndpoint watchEndpoint2 = new WatchEndpoint(62, song.song.id, null, null);
                                    c02051.L$0 = list3;
                                    c02051.L$1 = list2;
                                    c02051.L$3 = arrayList;
                                    c02051.Z$0 = z;
                                    c02051.label = 5;
                                    objM1024next0E7RQCE = youTube3.m1024next0E7RQCE(watchEndpoint2, null, c02051);
                                    if (objM1024next0E7RQCE != coroutineSingletons) {
                                        List list13 = list3;
                                        list4 = list2;
                                        list5 = arrayList;
                                        list6 = list13;
                                        if (objM1024next0E7RQCE instanceof Result.Failure) {
                                            objM1024next0E7RQCE = null;
                                        }
                                        nextResult = (NextResult) objM1024next0E7RQCE;
                                        if (nextResult != null) {
                                            browseEndpoint = nextResult.relatedEndpoint;
                                        } else {
                                            browseEndpoint = null;
                                        }
                                        if (browseEndpoint != null) {
                                            YouTube youTube4 = YouTube.INSTANCE;
                                            c02051.L$0 = list6;
                                            c02051.L$1 = list4;
                                            c02051.L$3 = list5;
                                            c02051.Z$0 = z;
                                            c02051.label = 6;
                                            objM1031relatedgIAlus = youTube4.m1031relatedgIAlus(browseEndpoint, c02051);
                                        } else {
                                            List list14 = list6;
                                            arrayList = list5;
                                            list2 = list4;
                                            list3 = list14;
                                        }
                                    }
                                    break;
                                }
                                arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                                hashSet = new HashSet();
                                arrayList2 = new ArrayList();
                                size = arrayListPlus.size();
                                i = 0;
                                while (i < size) {
                                    obj2 = arrayListPlus.get(i);
                                    i++;
                                    if (hashSet.add(((Song) obj2).song.id)) {
                                        arrayList2.add(obj2);
                                    }
                                }
                                List mutableList3 = CollectionsKt.toMutableList((Iterable) arrayList2);
                                Collections.shuffle(mutableList3);
                                listTake2 = CollectionsKt.take(mutableList3, 20);
                                if (listTake2.isEmpty()) {
                                    List mutableList4 = CollectionsKt.toMutableList((Iterable) list3);
                                    Collections.shuffle(mutableList4);
                                    listTake2 = CollectionsKt.take(mutableList4, 20);
                                }
                                stateFlowImpl.getClass();
                                stateFlowImpl.updateState(null, listTake2);
                                return Unit.INSTANCE;
                            }
                        }
                    }
                } else {
                    if (iOrdinal == 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    Flow flowLatestEvent4 = musicDatabase.$$delegate_0.latestEvent();
                    c02051.Z$0 = z;
                    c02051.label = 8;
                    objFirst3 = StateFlowKt.first(flowLatestEvent4, c02051);
                    if (objFirst3 != coroutineSingletons) {
                        eventWithSong2 = (EventWithSong) objFirst3;
                        if (eventWithSong2 != null) {
                            song2 = eventWithSong2.song;
                        } else {
                            song2 = null;
                        }
                        if (song2 != null) {
                            songEntity = song2.song;
                            if (musicDatabase.hasRelatedSongs(songEntity.id)) {
                                Flow relatedSongs2 = musicDatabase.getRelatedSongs(songEntity.id);
                                c02051.L$0 = null;
                                c02051.L$1 = stateFlowImpl;
                                c02051.Z$0 = z;
                                c02051.label = 9;
                                objFirst3 = StateFlowKt.first(relatedSongs2, c02051);
                            }
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                }
                obj3 = stateFlowImpl;
                return coroutineSingletons;
            case 2:
                z = c02051.Z$0;
                ResultKt.throwOnFailure(objFirst3);
                listFilterVideoSongs = CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z);
                Flow flowForgottenFavorites3 = musicDatabase.forgottenFavorites(System.currentTimeMillis());
                c02051.L$0 = listFilterVideoSongs;
                c02051.Z$0 = z;
                c02051.label = 3;
                objFirst = StateFlowKt.first(flowForgottenFavorites3, c02051);
                if (objFirst != coroutineSingletons) {
                    list = listFilterVideoSongs;
                    objFirst3 = objFirst;
                    listTake = CollectionsKt.take(CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z), 8);
                    Flow flowLatestEvent5 = musicDatabase.$$delegate_0.latestEvent();
                    c02051.L$0 = list;
                    c02051.L$1 = listTake;
                    c02051.Z$0 = z;
                    c02051.label = 4;
                    objFirst2 = StateFlowKt.first(flowLatestEvent5, c02051);
                    if (objFirst2 != coroutineSingletons) {
                        List list15 = list;
                        list2 = listTake;
                        objFirst3 = objFirst2;
                        list3 = list15;
                        eventWithSong = (EventWithSong) objFirst3;
                        if (eventWithSong != null) {
                            song = eventWithSong.song;
                        } else {
                            song = null;
                        }
                        arrayList = new ArrayList();
                        if (song != null) {
                            YouTube youTube5 = YouTube.INSTANCE;
                            WatchEndpoint watchEndpoint3 = new WatchEndpoint(62, song.song.id, null, null);
                            c02051.L$0 = list3;
                            c02051.L$1 = list2;
                            c02051.L$3 = arrayList;
                            c02051.Z$0 = z;
                            c02051.label = 5;
                            objM1024next0E7RQCE = youTube5.m1024next0E7RQCE(watchEndpoint3, null, c02051);
                            if (objM1024next0E7RQCE != coroutineSingletons) {
                                List list16 = list3;
                                list4 = list2;
                                list5 = arrayList;
                                list6 = list16;
                                if (objM1024next0E7RQCE instanceof Result.Failure) {
                                    objM1024next0E7RQCE = null;
                                }
                                nextResult = (NextResult) objM1024next0E7RQCE;
                                if (nextResult != null) {
                                    browseEndpoint = nextResult.relatedEndpoint;
                                } else {
                                    browseEndpoint = null;
                                }
                                if (browseEndpoint != null) {
                                    YouTube youTube6 = YouTube.INSTANCE;
                                    c02051.L$0 = list6;
                                    c02051.L$1 = list4;
                                    c02051.L$3 = list5;
                                    c02051.Z$0 = z;
                                    c02051.label = 6;
                                    objM1031relatedgIAlus = youTube6.m1031relatedgIAlus(browseEndpoint, c02051);
                                } else {
                                    List list17 = list6;
                                    arrayList = list5;
                                    list2 = list4;
                                    list3 = list17;
                                }
                            }
                            break;
                        }
                        arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                        hashSet = new HashSet();
                        arrayList2 = new ArrayList();
                        size = arrayListPlus.size();
                        i = 0;
                        while (i < size) {
                            obj2 = arrayListPlus.get(i);
                            i++;
                            if (hashSet.add(((Song) obj2).song.id)) {
                                arrayList2.add(obj2);
                            }
                        }
                        List mutableList5 = CollectionsKt.toMutableList((Iterable) arrayList2);
                        Collections.shuffle(mutableList5);
                        listTake2 = CollectionsKt.take(mutableList5, 20);
                        if (listTake2.isEmpty()) {
                            List mutableList6 = CollectionsKt.toMutableList((Iterable) list3);
                            Collections.shuffle(mutableList6);
                            listTake2 = CollectionsKt.take(mutableList6, 20);
                        }
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, listTake2);
                        return Unit.INSTANCE;
                    }
                }
                obj3 = stateFlowImpl;
                return coroutineSingletons;
            case 3:
                z = c02051.Z$0;
                list = c02051.L$0;
                ResultKt.throwOnFailure(objFirst3);
                listTake = CollectionsKt.take(CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z), 8);
                Flow flowLatestEvent6 = musicDatabase.$$delegate_0.latestEvent();
                c02051.L$0 = list;
                c02051.L$1 = listTake;
                c02051.Z$0 = z;
                c02051.label = 4;
                objFirst2 = StateFlowKt.first(flowLatestEvent6, c02051);
                if (objFirst2 != coroutineSingletons) {
                    List list18 = list;
                    list2 = listTake;
                    objFirst3 = objFirst2;
                    list3 = list18;
                    eventWithSong = (EventWithSong) objFirst3;
                    if (eventWithSong != null) {
                        song = eventWithSong.song;
                    } else {
                        song = null;
                    }
                    arrayList = new ArrayList();
                    if (song != null) {
                        YouTube youTube7 = YouTube.INSTANCE;
                        WatchEndpoint watchEndpoint4 = new WatchEndpoint(62, song.song.id, null, null);
                        c02051.L$0 = list3;
                        c02051.L$1 = list2;
                        c02051.L$3 = arrayList;
                        c02051.Z$0 = z;
                        c02051.label = 5;
                        objM1024next0E7RQCE = youTube7.m1024next0E7RQCE(watchEndpoint4, null, c02051);
                        if (objM1024next0E7RQCE != coroutineSingletons) {
                            List list19 = list3;
                            list4 = list2;
                            list5 = arrayList;
                            list6 = list19;
                            if (objM1024next0E7RQCE instanceof Result.Failure) {
                                objM1024next0E7RQCE = null;
                            }
                            nextResult = (NextResult) objM1024next0E7RQCE;
                            if (nextResult != null) {
                                browseEndpoint = nextResult.relatedEndpoint;
                            } else {
                                browseEndpoint = null;
                            }
                            if (browseEndpoint != null) {
                                YouTube youTube8 = YouTube.INSTANCE;
                                c02051.L$0 = list6;
                                c02051.L$1 = list4;
                                c02051.L$3 = list5;
                                c02051.Z$0 = z;
                                c02051.label = 6;
                                objM1031relatedgIAlus = youTube8.m1031relatedgIAlus(browseEndpoint, c02051);
                            } else {
                                List list110 = list6;
                                arrayList = list5;
                                list2 = list4;
                                list3 = list110;
                            }
                        }
                        break;
                    }
                    arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                    hashSet = new HashSet();
                    arrayList2 = new ArrayList();
                    size = arrayListPlus.size();
                    i = 0;
                    while (i < size) {
                        obj2 = arrayListPlus.get(i);
                        i++;
                        if (hashSet.add(((Song) obj2).song.id)) {
                            arrayList2.add(obj2);
                        }
                    }
                    List mutableList7 = CollectionsKt.toMutableList((Iterable) arrayList2);
                    Collections.shuffle(mutableList7);
                    listTake2 = CollectionsKt.take(mutableList7, 20);
                    if (listTake2.isEmpty()) {
                        List mutableList8 = CollectionsKt.toMutableList((Iterable) list3);
                        Collections.shuffle(mutableList8);
                        listTake2 = CollectionsKt.take(mutableList8, 20);
                    }
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, listTake2);
                    return Unit.INSTANCE;
                }
                obj3 = stateFlowImpl;
                return coroutineSingletons;
            case 4:
                z = c02051.Z$0;
                list2 = (List) c02051.L$1;
                list3 = c02051.L$0;
                ResultKt.throwOnFailure(objFirst3);
                eventWithSong = (EventWithSong) objFirst3;
                if (eventWithSong != null) {
                    song = eventWithSong.song;
                } else {
                    song = null;
                }
                arrayList = new ArrayList();
                if (song != null) {
                    YouTube youTube9 = YouTube.INSTANCE;
                    WatchEndpoint watchEndpoint5 = new WatchEndpoint(62, song.song.id, null, null);
                    c02051.L$0 = list3;
                    c02051.L$1 = list2;
                    c02051.L$3 = arrayList;
                    c02051.Z$0 = z;
                    c02051.label = 5;
                    objM1024next0E7RQCE = youTube9.m1024next0E7RQCE(watchEndpoint5, null, c02051);
                    if (objM1024next0E7RQCE != coroutineSingletons) {
                        List list111 = list3;
                        list4 = list2;
                        list5 = arrayList;
                        list6 = list111;
                        if (objM1024next0E7RQCE instanceof Result.Failure) {
                            objM1024next0E7RQCE = null;
                        }
                        nextResult = (NextResult) objM1024next0E7RQCE;
                        if (nextResult != null) {
                            browseEndpoint = nextResult.relatedEndpoint;
                        } else {
                            browseEndpoint = null;
                        }
                        if (browseEndpoint != null) {
                            YouTube youTube10 = YouTube.INSTANCE;
                            c02051.L$0 = list6;
                            c02051.L$1 = list4;
                            c02051.L$3 = list5;
                            c02051.Z$0 = z;
                            c02051.label = 6;
                            objM1031relatedgIAlus = youTube10.m1031relatedgIAlus(browseEndpoint, c02051);
                        } else {
                            List list112 = list6;
                            arrayList = list5;
                            list2 = list4;
                            list3 = list112;
                        }
                        break;
                    }
                    obj3 = stateFlowImpl;
                    return coroutineSingletons;
                }
                arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                hashSet = new HashSet();
                arrayList2 = new ArrayList();
                size = arrayListPlus.size();
                i = 0;
                while (i < size) {
                    obj2 = arrayListPlus.get(i);
                    i++;
                    if (hashSet.add(((Song) obj2).song.id)) {
                        arrayList2.add(obj2);
                    }
                }
                List mutableList9 = CollectionsKt.toMutableList((Iterable) arrayList2);
                Collections.shuffle(mutableList9);
                listTake2 = CollectionsKt.take(mutableList9, 20);
                if (listTake2.isEmpty()) {
                    List mutableList10 = CollectionsKt.toMutableList((Iterable) list3);
                    Collections.shuffle(mutableList10);
                    listTake2 = CollectionsKt.take(mutableList10, 20);
                }
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, listTake2);
                return Unit.INSTANCE;
            case 5:
                z = c02051.Z$0;
                list5 = c02051.L$3;
                list4 = (List) c02051.L$1;
                list6 = c02051.L$0;
                ResultKt.throwOnFailure(objFirst3);
                objM1024next0E7RQCE = ((Result) objFirst3).value;
                if (objM1024next0E7RQCE instanceof Result.Failure) {
                    objM1024next0E7RQCE = null;
                }
                nextResult = (NextResult) objM1024next0E7RQCE;
                if (nextResult != null) {
                    browseEndpoint = nextResult.relatedEndpoint;
                } else {
                    browseEndpoint = null;
                }
                if (browseEndpoint != null) {
                    YouTube youTube11 = YouTube.INSTANCE;
                    c02051.L$0 = list6;
                    c02051.L$1 = list4;
                    c02051.L$3 = list5;
                    c02051.Z$0 = z;
                    c02051.label = 6;
                    objM1031relatedgIAlus = youTube11.m1031relatedgIAlus(browseEndpoint, c02051);
                    break;
                } else {
                    List list113 = list6;
                    arrayList = list5;
                    list2 = list4;
                    list3 = list113;
                }
                arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                hashSet = new HashSet();
                arrayList2 = new ArrayList();
                size = arrayListPlus.size();
                i = 0;
                while (i < size) {
                    obj2 = arrayListPlus.get(i);
                    i++;
                    if (hashSet.add(((Song) obj2).song.id)) {
                        arrayList2.add(obj2);
                    }
                }
                List mutableList11 = CollectionsKt.toMutableList((Iterable) arrayList2);
                Collections.shuffle(mutableList11);
                listTake2 = CollectionsKt.take(mutableList11, 20);
                if (listTake2.isEmpty()) {
                    List mutableList12 = CollectionsKt.toMutableList((Iterable) list3);
                    Collections.shuffle(mutableList12);
                    listTake2 = CollectionsKt.take(mutableList12, 20);
                }
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, listTake2);
                return Unit.INSTANCE;
            case 6:
                z = c02051.Z$0;
                list5 = c02051.L$3;
                list4 = (List) c02051.L$1;
                list6 = c02051.L$0;
                ResultKt.throwOnFailure(objFirst3);
                objM1031relatedgIAlus = ((Result) objFirst3).value;
                if (!(objM1031relatedgIAlus instanceof Result.Failure)) {
                    list7 = list6;
                    arrayList = list5;
                    it = CollectionsKt.take(((RelatedPage) objM1031relatedgIAlus).songs, 10).iterator();
                    list8 = list4;
                    obj = objM1031relatedgIAlus;
                    if (!it.hasNext()) {
                        Flow flowSong = musicDatabase.$$delegate_0.song(((SongItem) it.next()).id);
                        c02051.L$0 = list7;
                        c02051.L$1 = list8;
                        c02051.L$3 = arrayList;
                        c02051.L$5 = obj;
                        c02051.L$8 = it;
                        c02051.Z$0 = z;
                        c02051.label = 7;
                        objFirst3 = StateFlowKt.first(flowSong, c02051);
                    } else {
                        list2 = list8;
                        list3 = list7;
                    }
                    break;
                } else {
                    List list114 = list6;
                    arrayList = list5;
                    list2 = list4;
                    list3 = list114;
                }
                arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                hashSet = new HashSet();
                arrayList2 = new ArrayList();
                size = arrayListPlus.size();
                i = 0;
                while (i < size) {
                    obj2 = arrayListPlus.get(i);
                    i++;
                    if (hashSet.add(((Song) obj2).song.id)) {
                        arrayList2.add(obj2);
                    }
                }
                List mutableList13 = CollectionsKt.toMutableList((Iterable) arrayList2);
                Collections.shuffle(mutableList13);
                listTake2 = CollectionsKt.take(mutableList13, 20);
                if (listTake2.isEmpty()) {
                    List mutableList14 = CollectionsKt.toMutableList((Iterable) list3);
                    Collections.shuffle(mutableList14);
                    listTake2 = CollectionsKt.take(mutableList14, 20);
                }
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, listTake2);
                return Unit.INSTANCE;
            case 7:
                z = c02051.Z$0;
                it = c02051.L$8;
                obj = c02051.L$5;
                arrayList = c02051.L$3;
                list8 = (List) c02051.L$1;
                list7 = c02051.L$0;
                ResultKt.throwOnFailure(objFirst3);
                Song song3 = (Song) objFirst3;
                if (song3 != null && (!z || !song3.song.isVideo)) {
                    arrayList.add(song3);
                }
                if (!it.hasNext()) {
                    list2 = list8;
                    list3 = list7;
                    arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) list3));
                    hashSet = new HashSet();
                    arrayList2 = new ArrayList();
                    size = arrayListPlus.size();
                    i = 0;
                    while (i < size) {
                        obj2 = arrayListPlus.get(i);
                        i++;
                        if (hashSet.add(((Song) obj2).song.id)) {
                            arrayList2.add(obj2);
                        }
                    }
                    List mutableList15 = CollectionsKt.toMutableList((Iterable) arrayList2);
                    Collections.shuffle(mutableList15);
                    listTake2 = CollectionsKt.take(mutableList15, 20);
                    if (listTake2.isEmpty()) {
                        List mutableList16 = CollectionsKt.toMutableList((Iterable) list3);
                        Collections.shuffle(mutableList16);
                        listTake2 = CollectionsKt.take(mutableList16, 20);
                    }
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, listTake2);
                    return Unit.INSTANCE;
                }
                Flow flowSong2 = musicDatabase.$$delegate_0.song(((SongItem) it.next()).id);
                c02051.L$0 = list7;
                c02051.L$1 = list8;
                c02051.L$3 = arrayList;
                c02051.L$5 = obj;
                c02051.L$8 = it;
                c02051.Z$0 = z;
                c02051.label = 7;
                objFirst3 = StateFlowKt.first(flowSong2, c02051);
                break;
                break;
            case 8:
                z = c02051.Z$0;
                ResultKt.throwOnFailure(objFirst3);
                eventWithSong2 = (EventWithSong) objFirst3;
                if (eventWithSong2 != null) {
                    song2 = eventWithSong2.song;
                } else {
                    song2 = null;
                }
                if (song2 != null) {
                    songEntity = song2.song;
                    if (musicDatabase.hasRelatedSongs(songEntity.id)) {
                        Flow relatedSongs3 = musicDatabase.getRelatedSongs(songEntity.id);
                        c02051.L$0 = null;
                        c02051.L$1 = stateFlowImpl;
                        c02051.Z$0 = z;
                        c02051.label = 9;
                        objFirst3 = StateFlowKt.first(relatedSongs3, c02051);
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 9:
                z = c02051.Z$0;
                MutableStateFlow mutableStateFlow = (MutableStateFlow) c02051.L$1;
                ResultKt.throwOnFailure(objFirst3);
                obj3 = mutableStateFlow;
                obj3 = stateFlowImpl;
                List mutableList17 = CollectionsKt.toMutableList((Iterable) CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst3, z));
                Collections.shuffle(mutableList17);
                List listTake3 = CollectionsKt.take(mutableList17, 20);
                StateFlowImpl stateFlowImpl2 = (StateFlowImpl) obj3;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, listTake3);
                return Unit.INSTANCE;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x02ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0296 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:95:0x0287 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:11:0x0028, B:22:0x004d, B:25:0x0065, B:26:0x0072, B:28:0x0078, B:29:0x0093, B:31:0x0099, B:32:0x00af, B:36:0x00ba, B:37:0x00e3, B:38:0x00e6, B:40:0x00f0, B:41:0x00f4, B:43:0x00fa, B:60:0x0121, B:61:0x0147, B:65:0x015a, B:66:0x0175, B:68:0x017b, B:69:0x018e, B:73:0x01a2, B:74:0x01b0, B:75:0x01d2, B:77:0x01d8, B:78:0x01eb, B:82:0x01f8, B:46:0x0105, B:49:0x010b, B:52:0x0111, B:83:0x0227, B:85:0x0238, B:87:0x023e, B:89:0x0251, B:91:0x0262, B:93:0x0275, B:94:0x0279, B:102:0x02be, B:104:0x02c6, B:95:0x0287, B:97:0x0298, B:99:0x02ab, B:100:0x02af, B:18:0x0038), top: B:109:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0298 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:11:0x0028, B:22:0x004d, B:25:0x0065, B:26:0x0072, B:28:0x0078, B:29:0x0093, B:31:0x0099, B:32:0x00af, B:36:0x00ba, B:37:0x00e3, B:38:0x00e6, B:40:0x00f0, B:41:0x00f4, B:43:0x00fa, B:60:0x0121, B:61:0x0147, B:65:0x015a, B:66:0x0175, B:68:0x017b, B:69:0x018e, B:73:0x01a2, B:74:0x01b0, B:75:0x01d2, B:77:0x01d8, B:78:0x01eb, B:82:0x01f8, B:46:0x0105, B:49:0x010b, B:52:0x0111, B:83:0x0227, B:85:0x0238, B:87:0x023e, B:89:0x0251, B:91:0x0262, B:93:0x0275, B:94:0x0279, B:102:0x02be, B:104:0x02c6, B:95:0x0287, B:97:0x0298, B:99:0x02ab, B:100:0x02af, B:18:0x0038), top: B:109:0x0024 }] */
    public final Object getRandomItem(ContinuationImpl continuationImpl) {
        C02061 c02061;
        HashSet hashSet;
        ArrayList arrayList;
        int size;
        int i;
        YTItem yTItem;
        Object obj;
        byte b;
        if (continuationImpl instanceof C02061) {
            c02061 = (C02061) continuationImpl;
            int i2 = c02061.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c02061.label = i2 - Integer.MIN_VALUE;
            } else {
                c02061 = new C02061(continuationImpl);
            }
        } else {
            c02061 = new C02061(continuationImpl);
        }
        Object obj2 = c02061.result;
        int i3 = c02061.label;
        StateFlowImpl stateFlowImpl = this.isRandomizing;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj2);
                Boolean bool = Boolean.TRUE;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, bool);
                c02061.label = 1;
                Object objDelay = AwaitKt.delay(1000L, c02061);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDelay == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            List<Song> list = (List) this.quickPicks.getValue();
            int i4 = 10;
            if (list != null) {
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (Song song : list) {
                    SongEntity songEntity = song.song;
                    String str = songEntity.id;
                    String str2 = songEntity.title;
                    List<ArtistEntity> list2 = song.artists;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, i4));
                    for (ArtistEntity artistEntity : list2) {
                        arrayList5.add(new com.metrolist.innertube.models.Artist(artistEntity.name, artistEntity.id));
                    }
                    String str3 = song.song.thumbnailUrl;
                    arrayList4.add(new SongItem(str, str2, arrayList5, null, null, null, null, null, str3 == null ? "" : str3, false, null, null, null, null, null, false, null, 130296));
                    i4 = 10;
                }
                arrayList2.addAll(arrayList4);
            }
            List<LocalItem> list3 = (List) this.keepListening.getValue();
            if (list3 != null) {
                for (LocalItem localItem : list3) {
                    if (localItem == null) {
                        b = -1;
                    } else if (localItem instanceof Song) {
                        b = 0;
                    } else if (localItem instanceof Album) {
                        b = 1;
                    } else {
                        b = localItem instanceof Artist ? (byte) 2 : (byte) -2;
                    }
                    if (b == 0) {
                        String str4 = ((Song) localItem).song.id;
                        String str5 = ((Song) localItem).song.title;
                        List<ArtistEntity> list4 = ((Song) localItem).artists;
                        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                        for (ArtistEntity artistEntity2 : list4) {
                            arrayList6.add(new com.metrolist.innertube.models.Artist(artistEntity2.name, artistEntity2.id));
                        }
                        String str6 = ((Song) localItem).song.thumbnailUrl;
                        arrayList2.add(new SongItem(str4, str5, arrayList6, null, null, null, null, null, str6 == null ? "" : str6, false, null, null, null, null, null, false, null, 130296));
                    } else if (b == 1) {
                        String str7 = ((Album) localItem).album.id;
                        String str8 = ((Album) localItem).album.playlistId;
                        String str9 = str8 == null ? "" : str8;
                        String str10 = ((Album) localItem).album.title;
                        List<ArtistEntity> list5 = ((Album) localItem).artists;
                        ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                        for (ArtistEntity artistEntity3 : list5) {
                            arrayList7.add(new com.metrolist.innertube.models.Artist(artistEntity3.name, artistEntity3.id));
                        }
                        Integer num = ((Album) localItem).album.year;
                        String str11 = ((Album) localItem).album.thumbnailUrl;
                        arrayList3.add(new AlbumItem(str7, str9, str10, (List) arrayList7, num, str11 == null ? "" : str11, false, 132));
                    } else if (b == 2) {
                        arrayList3.add(new ArtistItem(((Artist) localItem).artist.id, ((Artist) localItem).artist.name, ((Artist) localItem).artist.thumbnailUrl, (String) null, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, 152));
                    }
                }
            }
            arrayList3.addAll((Collection) this.allYtItems.getValue());
            if (arrayList2.isEmpty()) {
                hashSet = new HashSet();
                arrayList = new ArrayList();
                size = arrayList3.size();
                i = 0;
                while (i < size) {
                    obj = arrayList3.get(i);
                    i++;
                    if (hashSet.add(((YTItem) obj).getId())) {
                        arrayList.add(obj);
                    }
                }
                List mutableList = CollectionsKt.toMutableList((Iterable) arrayList);
                Collections.shuffle(mutableList);
                yTItem = (YTItem) CollectionsKt.firstOrNull(mutableList);
            } else {
                if (!arrayList3.isEmpty()) {
                    AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                    if (Random.defaultRandom.getImpl().nextFloat() >= 0.8f) {
                        hashSet = new HashSet();
                        arrayList = new ArrayList();
                        size = arrayList3.size();
                        i = 0;
                        while (i < size) {
                            obj = arrayList3.get(i);
                            i++;
                            if (hashSet.add(((YTItem) obj).getId())) {
                                arrayList.add(obj);
                            }
                        }
                        List mutableList2 = CollectionsKt.toMutableList((Iterable) arrayList);
                        Collections.shuffle(mutableList2);
                        yTItem = (YTItem) CollectionsKt.firstOrNull(mutableList2);
                    }
                }
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList8 = new ArrayList();
                int size2 = arrayList2.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj3 = arrayList2.get(i5);
                    i5++;
                    if (hashSet2.add(((YTItem) obj3).getId())) {
                        arrayList8.add(obj3);
                    }
                }
                List mutableList3 = CollectionsKt.toMutableList((Iterable) arrayList8);
                Collections.shuffle(mutableList3);
                yTItem = (YTItem) CollectionsKt.firstOrNull(mutableList3);
            }
            if (yTItem == null && (yTItem = (YTItem) CollectionsKt.firstOrNull((List) arrayList2)) == null) {
                yTItem = (YTItem) CollectionsKt.firstOrNull((List) arrayList3);
            }
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool2);
            return yTItem;
        } catch (Throwable th) {
            Boolean bool3 = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool3);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object load(ContinuationImpl continuationImpl) {
        C02071 c02071;
        boolean z;
        LocalDateTime localDateTime;
        boolean z2;
        if (continuationImpl instanceof C02071) {
            c02071 = (C02071) continuationImpl;
            int i = c02071.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02071.label = i - Integer.MIN_VALUE;
            } else {
                c02071 = new C02071(continuationImpl);
            }
        } else {
            c02071 = new C02071(continuationImpl);
        }
        C02071 c02072 = c02071;
        Object obj = c02072.result;
        int i2 = c02072.label;
        StateFlowImpl stateFlowImpl = this.isLoading;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = Boolean.TRUE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
            Context context = this.context;
            DataStore dataStore = UtilsKt.getDataStore(context);
            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
            Boolean bool2 = Boolean.FALSE;
            boolean zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool2)).booleanValue();
            boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool2)).booleanValue();
            boolean zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool2)).booleanValue();
            LocalDateTime localDateTimeMinusWeeks = LocalDateTime.now().minusWeeks(2L);
            C02082 c02082 = new C02082(this, zBooleanValue2, localDateTimeMinusWeeks, zBooleanValue, zBooleanValue3, (Continuation) null);
            c02072.L$0 = localDateTimeMinusWeeks;
            c02072.Z$0 = zBooleanValue;
            c02072.Z$1 = zBooleanValue2;
            c02072.label = 1;
            Object objCoroutineScope = AwaitKt.coroutineScope(c02082, c02072);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCoroutineScope == coroutineSingletons) {
                return coroutineSingletons;
            }
            z = zBooleanValue2;
            localDateTime = localDateTimeMinusWeeks;
            z2 = zBooleanValue;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            boolean z3 = c02072.Z$1;
            z2 = c02072.Z$0;
            LocalDateTime localDateTime2 = c02072.L$0;
            ResultKt.throwOnFailure(obj);
            z = z3;
            localDateTime = localDateTime2;
        }
        List list = (List) this.quickPicks.getValue();
        List list2 = EmptyList.INSTANCE;
        if (list == null) {
            list = list2;
        }
        List list3 = (List) this.forgottenFavorites.getValue();
        if (list3 == null) {
            list3 = list2;
        }
        ArrayList arrayListPlus = CollectionsKt.plus((Iterable) list3, (Collection) list);
        List list4 = (List) this.keepListening.getValue();
        if (list4 != null) {
            list2 = list4;
        }
        ArrayList arrayListPlus2 = CollectionsKt.plus((Iterable) list2, (Collection) arrayListPlus);
        ArrayList arrayList = new ArrayList();
        int size = arrayListPlus2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayListPlus2.get(i3);
            i3++;
            LocalItem localItem = (LocalItem) obj2;
            if ((localItem instanceof Song) || (localItem instanceof Album)) {
                arrayList.add(obj2);
            }
        }
        StateFlowImpl stateFlowImpl2 = this.allLocalItems;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, arrayList);
        Boolean bool3 = Boolean.FALSE;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, bool3);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(viewModelScope, defaultIoScheduler, null, new AnonymousClass3(this, continuation, (byte) 5), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass3(this, continuation, (byte) 6), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new Updater$checkForUpdate$2((Object) this, z2, continuation, (byte) 10), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass7(localDateTime, z2, z, null), 2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadAccountInfo(Continuation continuation) {
        C02091 c02091;
        Object objM991accountInfoIoAF18A;
        if (continuation instanceof C02091) {
            c02091 = (C02091) continuation;
            int i = c02091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02091.label = i - Integer.MIN_VALUE;
            } else {
                c02091 = new C02091(continuation);
            }
        } else {
            c02091 = new C02091(continuation);
        }
        Object obj = c02091.result;
        int i2 = c02091.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            c02091.label = 1;
            objM991accountInfoIoAF18A = youTube.m991accountInfoIoAF18A(c02091);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM991accountInfoIoAF18A == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM991accountInfoIoAF18A = ((Result) obj).value;
        }
        if (!(objM991accountInfoIoAF18A instanceof Result.Failure)) {
            AccountInfo accountInfo = (AccountInfo) objM991accountInfoIoAF18A;
            this.accountName.setValue(accountInfo.name);
            this.accountImageUrl.setValue(accountInfo.thumbnailUrl);
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM991accountInfoIoAF18A);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadAccountPlaylists(Continuation continuation) {
        C02101 c02101;
        boolean z;
        Object obj;
        Object objCompletedPlaylist;
        boolean z2;
        Throwable thM1866exceptionOrNullimpl;
        ArrayList arrayList;
        ArrayList arrayListFilterNotNull;
        ArrayList arrayList2;
        int size;
        int i;
        Object obj2;
        if (continuation instanceof C02101) {
            c02101 = (C02101) continuation;
            int i2 = c02101.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c02101.label = i2 - Integer.MIN_VALUE;
            } else {
                c02101 = new C02101(continuation);
            }
        } else {
            c02101 = new C02101(continuation);
        }
        Object obj3 = c02101.result;
        int i3 = c02101.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this.context), PreferenceKeysKt.HideYoutubeShortsKey, Boolean.FALSE)).booleanValue();
            YouTube youTube = YouTube.INSTANCE;
            c02101.Z$0 = zBooleanValue;
            c02101.label = 1;
            Object objM1011library0E7RQCE = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_liked_playlists", 0, c02101);
            if (objM1011library0E7RQCE != coroutineSingletons) {
                z = zBooleanValue;
                obj = objM1011library0E7RQCE;
            }
            return coroutineSingletons;
        }
        if (i3 == 1) {
            z = c02101.Z$0;
            ResultKt.throwOnFailure(obj3);
            obj = ((Result) obj3).value;
        } else {
            if (i3 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z2 = c02101.Z$0;
            ResultKt.throwOnFailure(obj3);
            objCompletedPlaylist = ((Result) obj3).value;
        }
        if (!(objCompletedPlaylist instanceof Result.Failure)) {
            List list = ((LibraryPage) objCompletedPlaylist).items;
            arrayList = new ArrayList();
            for (Object obj4 : list) {
                if (obj4 instanceof PlaylistItem) {
                    arrayList.add(obj4);
                }
            }
            arrayListFilterNotNull = CollectionsKt.filterNotNull(arrayList);
            arrayList2 = new ArrayList();
            size = arrayListFilterNotNull.size();
            i = 0;
            while (i < size) {
                obj2 = arrayListFilterNotNull.get(i);
                i++;
                if (!Intrinsics.areEqual(((PlaylistItem) obj2).id, "SE")) {
                    arrayList2.add(obj2);
                }
            }
            List listFilterYoutubeShorts = HexFormatKt.filterYoutubeShorts(arrayList2, z2);
            StateFlowImpl stateFlowImpl = this.accountPlaylists;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, listFilterYoutubeShorts);
        }
        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCompletedPlaylist);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
        c02101.Z$0 = z;
        c02101.label = 2;
        objCompletedPlaylist = StringsKt__IndentKt.completedPlaylist(obj, c02101);
        if (objCompletedPlaylist != coroutineSingletons) {
            z2 = z;
            if (!(objCompletedPlaylist instanceof Result.Failure)) {
                List list2 = ((LibraryPage) objCompletedPlaylist).items;
                arrayList = new ArrayList();
                while (r1.hasNext()) {
                    if (obj4 instanceof PlaylistItem) {
                        arrayList.add(obj4);
                    }
                }
                arrayListFilterNotNull = CollectionsKt.filterNotNull(arrayList);
                arrayList2 = new ArrayList();
                size = arrayListFilterNotNull.size();
                i = 0;
                while (i < size) {
                    obj2 = arrayListFilterNotNull.get(i);
                    i++;
                    if (!Intrinsics.areEqual(((PlaylistItem) obj2).id, "SE")) {
                        arrayList2.add(obj2);
                    }
                }
                List listFilterYoutubeShorts2 = HexFormatKt.filterYoutubeShorts(arrayList2, z2);
                StateFlowImpl stateFlowImpl2 = this.accountPlaylists;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, listFilterYoutubeShorts2);
            }
            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCompletedPlaylist);
            if (thM1866exceptionOrNullimpl != null) {
                thM1866exceptionOrNullimpl.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        return coroutineSingletons;
    }

    public final void refresh() {
        StateFlowImpl stateFlowImpl = this.isRefreshing;
        if (((Boolean) stateFlowImpl.getValue()).booleanValue()) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, bool);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(viewModelScope, defaultIoScheduler, null, new C02111(null), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass1(this, null, (byte) 2), 2);
    }

    public final void toggleChip(HomePage.Chip chip) {
        StateFlowImpl stateFlowImpl = this.homePage;
        StateFlowImpl stateFlowImpl2 = this.selectedChip;
        StateFlowImpl stateFlowImpl3 = this.previousHomePage;
        if (chip == null || (chip.equals(stateFlowImpl2.getValue()) && stateFlowImpl3.getValue() != null)) {
            stateFlowImpl.setValue(stateFlowImpl3.getValue());
            stateFlowImpl3.setValue(null);
            stateFlowImpl2.setValue(null);
        } else {
            if (stateFlowImpl2.getValue() == null) {
                stateFlowImpl3.setValue(stateFlowImpl.getValue());
            }
            CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new C02121(chip, null), 2);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$load$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02082 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $fromTimeStamp;
        public boolean $hideExplicit;
        public boolean $hideVideoSongs;
        public boolean $hideYoutubeShorts;
        public final /* synthetic */ byte $r8$classId = 3;
        public /* synthetic */ Object L$0;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02082(HomeViewModel homeViewModel, boolean z, LocalDateTime localDateTime, boolean z2, boolean z3, Continuation continuation) {
            super(2, continuation);
            this.this$0 = homeViewModel;
            this.$hideVideoSongs = z;
            this.$fromTimeStamp = localDateTime;
            this.$hideExplicit = z2;
            this.$hideYoutubeShorts = z3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$fromTimeStamp;
            switch (b) {
                case 0:
                    C02082 c02082 = new C02082((HomeViewModel) this.this$0, this.$hideVideoSongs, (LocalDateTime) obj2, this.$hideExplicit, this.$hideYoutubeShorts, continuation);
                    c02082.L$0 = obj;
                    return c02082;
                case 1:
                    return new C02082((CoroutineContext) this.L$0, (RoomDatabase) this.this$0, this.$hideExplicit, this.$hideYoutubeShorts, (Function1) obj2, continuation);
                case 2:
                    return new C02082(this.$hideExplicit, (SongItem) this.L$0, (MusicDatabase) this.this$0, (SyncUtils) obj2, this.$hideYoutubeShorts, continuation);
                default:
                    C02082 c02083 = new C02082((CachePlaylistViewModel) obj2, continuation);
                    c02083.L$0 = obj;
                    return c02083;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((C02082) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 1:
                    return ((C02082) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((C02082) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((C02082) create((CachePlaylistViewModel.Inputs) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object setVideoId;
            boolean z;
            boolean z2;
            CachedSongPartition cachedSongPartition;
            CachedSongPartition cachedSongPartition2;
            boolean z3;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b2 = 1;
            Object obj2 = this.$fromTimeStamp;
            String str = 0;
            str = 0;
            switch (b) {
                case 0:
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    HomeViewModel homeViewModel = (HomeViewModel) this.this$0;
                    AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new AnonymousClass3(homeViewModel, str, (byte) 2), 2);
                    boolean z4 = this.$hideVideoSongs;
                    AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new MusicService.C01701(homeViewModel, z4, null), 2);
                    AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new SyncUtils$createPlaylist$1(homeViewModel, (LocalDateTime) obj2, z4, null), 2);
                    AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new AnonymousClass4(homeViewModel, this.$hideExplicit, this.$hideVideoSongs, this.$hideYoutubeShorts, null), 2);
                    YouTube youTube = YouTube.INSTANCE;
                    if (((InnerTube.SessionSnapshot) YouTube.innerTube.innerTubeX.session.get()).cookie != null) {
                        AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new AnonymousClass3(homeViewModel, str, (byte) 3), 2);
                        AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, new AnonymousClass3(homeViewModel, str, (byte) 4), 2);
                    }
                    return unit;
                case 1:
                    boolean z5 = this.$hideVideoSongs;
                    if (z5) {
                        if (z5) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = (CoroutineContext) this.L$0;
                    DBUtil__DBUtil_androidKt$performBlocking$1$1 dBUtil__DBUtil_androidKt$performBlocking$1$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$1((RoomDatabase) this.this$0, this.$hideExplicit, this.$hideYoutubeShorts, (Function1) obj2, (Continuation) null);
                    this.$hideVideoSongs = true;
                    Object objWithContext = AwaitKt.withContext(coroutineContext, dBUtil__DBUtil_androidKt$performBlocking$1$1, this);
                    return objWithContext == coroutineSingletons ? coroutineSingletons : objWithContext;
                case 2:
                    SongItem songItem = (SongItem) this.L$0;
                    boolean z6 = this.$hideVideoSongs;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        if (this.$hideExplicit) {
                            String str2 = songItem.setVideoId;
                            if (str2 == null) {
                                MusicDatabase musicDatabase = (MusicDatabase) this.this$0;
                                String str3 = songItem.id;
                                this.$hideVideoSongs = true;
                                setVideoId = musicDatabase.$$delegate_0.getSetVideoId(str3, this);
                                if (setVideoId == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                str = str2;
                            }
                        }
                        ((SyncUtils) obj2).saveEpisode(songItem.id, str, this.$hideYoutubeShorts);
                        return unit;
                    }
                    if (!z6) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    setVideoId = obj;
                    SetVideoIdEntity setVideoIdEntity = (SetVideoIdEntity) setVideoId;
                    if (setVideoIdEntity != null) {
                        str = setVideoIdEntity.setVideoId;
                    }
                    ((SyncUtils) obj2).saveEpisode(songItem.id, str, this.$hideYoutubeShorts);
                    return unit;
                default:
                    CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) obj2;
                    CachePlaylistViewModel.Inputs inputs = (CachePlaylistViewModel.Inputs) this.L$0;
                    boolean z7 = this.$hideYoutubeShorts;
                    if (!z7) {
                        ResultKt.throwOnFailure(obj);
                        List<Song> list = inputs.flagged;
                        z = inputs.hideExplicit;
                        z2 = inputs.hideVideoSongs;
                        JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, cachePlaylistViewModel, CachePlaylistViewModel.class, "cachedContentLength", "cachedContentLength(Lcom/metrolist/music/db/entities/Song;)Ljava/lang/Long;", 0, (byte) 4);
                        list.getClass();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (Song song : list) {
                            if (!song.song.isDownloaded) {
                                Long l = (Long) jobKt__JobKt$invokeOnCompletion$1.invoke(song);
                                if (l != null) {
                                    if (cachePlaylistViewModel.playerCache.isCached(0L, l.longValue(), song.song.id)) {
                                        arrayList.add(song);
                                    }
                                }
                                arrayList2.add(song);
                            }
                        }
                        cachedSongPartition = new CachedSongPartition(arrayList, arrayList2);
                        if (!arrayList2.isEmpty()) {
                            MusicDatabase musicDatabase2 = cachePlaylistViewModel.database;
                            InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(cachedSongPartition, str, (byte) 17);
                            this.L$0 = null;
                            this.this$0 = cachedSongPartition;
                            this.$hideVideoSongs = z;
                            this.$hideExplicit = z2;
                            this.$hideYoutubeShorts = true;
                            if (musicDatabase2.withTransaction(interruptibleKt$runInterruptible$2, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            cachedSongPartition2 = cachedSongPartition;
                            z3 = z;
                        }
                        return CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit(CollectionsKt.sortedWith(cachedSongPartition.stillCached, new LocalPlaylistViewModel$playlistSongs$2$invokeSuspend$$inlined$sortedBy$1(b2)), z), z2);
                    }
                    if (!z7) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    z2 = this.$hideExplicit;
                    z3 = this.$hideVideoSongs;
                    cachedSongPartition2 = (CachedSongPartition) this.this$0;
                    ResultKt.throwOnFailure(obj);
                    z = z3;
                    cachedSongPartition = cachedSongPartition2;
                    return CollectionsKt__IterablesKt.filterVideoSongs(CollectionsKt__IterablesKt.filterExplicit(CollectionsKt.sortedWith(cachedSongPartition.stillCached, new LocalPlaylistViewModel$playlistSongs$2$invokeSuspend$$inlined$sortedBy$1(b2)), z), z2);
            }
        }

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$load$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass4 extends SuspendLambda implements Function2 {
            public boolean $hideExplicit;
            public boolean $hideVideoSongs;
            public boolean $hideYoutubeShorts;
            public final /* synthetic */ byte $r8$classId = 0;
            public boolean label;
            public final /* synthetic */ ViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(HomeViewModel homeViewModel, boolean z, boolean z2, boolean z3, Continuation continuation) {
                super(2, continuation);
                this.this$0 = homeViewModel;
                this.$hideExplicit = z;
                this.$hideVideoSongs = z2;
                this.$hideYoutubeShorts = z3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                byte b = this.$r8$classId;
                ViewModel viewModel = this.this$0;
                switch (b) {
                    case 0:
                        return new AnonymousClass4((HomeViewModel) viewModel, this.$hideExplicit, this.$hideVideoSongs, this.$hideYoutubeShorts, continuation);
                    default:
                        return new AnonymousClass4((YouTubeBrowseViewModel) viewModel, continuation);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                byte b = this.$r8$classId;
                Unit unit = Unit.INSTANCE;
                CoroutineScope coroutineScope = (CoroutineScope) obj;
                Continuation continuation = (Continuation) obj2;
                switch (b) {
                    case 0:
                        break;
                }
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(unit);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objM987home0E7RQCE$default;
                boolean zBooleanValue;
                boolean zBooleanValue2;
                Object obj2;
                boolean z;
                byte b = this.$r8$classId;
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                ViewModel viewModel = this.this$0;
                switch (b) {
                    case 0:
                        boolean z2 = this.label;
                        if (!z2) {
                            ResultKt.throwOnFailure(obj);
                            YouTube youTube = YouTube.INSTANCE;
                            this.label = true;
                            objM987home0E7RQCE$default = YouTube.m987home0E7RQCE$default(null, null, this, 3);
                            if (objM987home0E7RQCE$default == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (!z2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            objM987home0E7RQCE$default = ((Result) obj).value;
                        }
                        HomeViewModel homeViewModel = (HomeViewModel) viewModel;
                        boolean z3 = this.$hideExplicit;
                        boolean z4 = this.$hideVideoSongs;
                        boolean z5 = this.$hideYoutubeShorts;
                        if (!(objM987home0E7RQCE$default instanceof Result.Failure)) {
                            HomePage homePage = (HomePage) objM987home0E7RQCE$default;
                            StateFlowImpl stateFlowImpl = homeViewModel.homePage;
                            List<HomePage.Section> list = homePage.sections;
                            ArrayList arrayList = new ArrayList();
                            for (HomePage.Section section : list) {
                                List listFilterYoutubeShorts = HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(CollectionsKt.filterNotNull(section.items), z3), z4), z5);
                                HomePage.Section sectionCopy$default = listFilterYoutubeShorts.isEmpty() ? null : HomePage.Section.copy$default(section, listFilterYoutubeShorts);
                                if (sectionCopy$default != null) {
                                    arrayList.add(sectionCopy$default);
                                }
                            }
                            HomePage homePageCopy$default = HomePage.copy$default(homePage, null, arrayList, 5);
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, homePageCopy$default);
                        }
                        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM987home0E7RQCE$default);
                        if (thM1866exceptionOrNullimpl == null) {
                            return unit;
                        }
                        thM1866exceptionOrNullimpl.printStackTrace();
                        return unit;
                    default:
                        YouTubeBrowseViewModel youTubeBrowseViewModel = (YouTubeBrowseViewModel) viewModel;
                        Context context = youTubeBrowseViewModel.context;
                        boolean z6 = this.$hideYoutubeShorts;
                        if (!z6) {
                            ResultKt.throwOnFailure(obj);
                            DataStore dataStore = UtilsKt.getDataStore(context);
                            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                            Boolean bool = Boolean.FALSE;
                            boolean zBooleanValue3 = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
                            zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
                            zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
                            YouTube youTube2 = YouTube.INSTANCE;
                            String str = youTubeBrowseViewModel.browseId;
                            String str2 = youTubeBrowseViewModel.params;
                            this.label = zBooleanValue3;
                            this.$hideExplicit = zBooleanValue;
                            this.$hideVideoSongs = zBooleanValue2;
                            this.$hideYoutubeShorts = true;
                            Object objM1001browse0E7RQCE = youTube2.m1001browse0E7RQCE(str, str2, this);
                            if (objM1001browse0E7RQCE == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            obj2 = objM1001browse0E7RQCE;
                            z = zBooleanValue3;
                        } else {
                            if (!z6) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            zBooleanValue2 = this.$hideVideoSongs;
                            zBooleanValue = this.$hideExplicit;
                            z = this.label;
                            ResultKt.throwOnFailure(obj);
                            obj2 = ((Result) obj).value;
                        }
                        if (!(obj2 instanceof Result.Failure)) {
                            BrowseResult browseResult = (BrowseResult) obj2;
                            StateFlowImpl stateFlowImpl2 = youTubeBrowseViewModel.result;
                            if (z) {
                                List<BrowseResult.Item> list2 = browseResult.items;
                                ArrayList arrayList2 = new ArrayList();
                                for (BrowseResult.Item item : list2) {
                                    List listFilterExplicit = HexFormatKt.filterExplicit(item.items, true);
                                    BrowseResult.Item item2 = listFilterExplicit.isEmpty() ? null : new BrowseResult.Item(item.title, listFilterExplicit);
                                    if (item2 != null) {
                                        arrayList2.add(item2);
                                    }
                                }
                                browseResult = new BrowseResult(browseResult.title, arrayList2);
                            } else {
                                browseResult.getClass();
                            }
                            if (zBooleanValue) {
                                List<BrowseResult.Item> list3 = browseResult.items;
                                ArrayList arrayList3 = new ArrayList();
                                for (BrowseResult.Item item3 : list3) {
                                    List listFilterVideoSongs = HexFormatKt.filterVideoSongs(item3.items, true);
                                    BrowseResult.Item item4 = listFilterVideoSongs.isEmpty() ? null : new BrowseResult.Item(item3.title, listFilterVideoSongs);
                                    if (item4 != null) {
                                        arrayList3.add(item4);
                                    }
                                }
                                browseResult = new BrowseResult(browseResult.title, arrayList3);
                            }
                            if (zBooleanValue2) {
                                List<BrowseResult.Item> list4 = browseResult.items;
                                ArrayList arrayList4 = new ArrayList();
                                for (BrowseResult.Item item5 : list4) {
                                    List listFilterYoutubeShorts2 = HexFormatKt.filterYoutubeShorts(item5.items, true);
                                    BrowseResult.Item item6 = listFilterYoutubeShorts2.isEmpty() ? null : new BrowseResult.Item(item5.title, listFilterYoutubeShorts2);
                                    if (item6 != null) {
                                        arrayList4.add(item6);
                                    }
                                }
                                browseResult = new BrowseResult(browseResult.title, arrayList4);
                            }
                            stateFlowImpl2.getClass();
                            stateFlowImpl2.updateState(null, browseResult);
                        }
                        Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(obj2);
                        if (thM1866exceptionOrNullimpl2 == null) {
                            return unit;
                        }
                        thM1866exceptionOrNullimpl2.printStackTrace();
                        return unit;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(YouTubeBrowseViewModel youTubeBrowseViewModel, Continuation continuation) {
                super(2, continuation);
                this.this$0 = youTubeBrowseViewModel;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02082(CachePlaylistViewModel cachePlaylistViewModel, Continuation continuation) {
            super(2, continuation);
            this.$fromTimeStamp = cachePlaylistViewModel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02082(CoroutineContext coroutineContext, RoomDatabase roomDatabase, boolean z, boolean z2, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.L$0 = coroutineContext;
            this.this$0 = roomDatabase;
            this.$hideExplicit = z;
            this.$hideYoutubeShorts = z2;
            this.$fromTimeStamp = function1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02082(boolean z, SongItem songItem, MusicDatabase musicDatabase, SyncUtils syncUtils, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.$hideExplicit = z;
            this.L$0 = songItem;
            this.this$0 = musicDatabase;
            this.$fromTimeStamp = syncUtils;
            this.$hideYoutubeShorts = z2;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HomeViewModel$getDailyDiscover$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ boolean $hideVideoSongs;
        public final /* synthetic */ Object $items;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object $seeds;
        public /* synthetic */ Object L$0;
        public Object L$2;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, LazyListState lazyListState, MutableState mutableState, List list, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 3;
            this.L$2 = parcelableSnapshotMutableIntState;
            this.L$0 = lazyListState;
            this.$items = mutableState;
            this.$seeds = list;
            this.$hideVideoSongs = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$items;
            Object obj3 = this.$seeds;
            switch (b) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((List) obj3, (List) obj2, this.$hideVideoSongs, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    return new AnonymousClass2(this.$hideVideoSongs, (Context) this.L$2, (String) this.L$0, (String) obj3, (MutableState) obj2, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass2(this.$hideVideoSongs, (MutableState) this.L$2, (MutableState) this.L$0, (SnapshotStateMap) obj3, (State) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass2((ParcelableSnapshotMutableIntState) this.L$2, (LazyListState) this.L$0, (MutableState) obj2, (List) obj3, this.$hideVideoSongs, continuation);
                case 4:
                    return new AnonymousClass2(this.$hideVideoSongs, (MutableState) this.L$2, (MutableState) this.L$0, (Function1) obj3, (Function1) obj2, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass2(this.$hideVideoSongs, (MutableState) this.L$2, (MutableState) this.L$0, (MutableState) obj3, (MusicDatabase) obj2, continuation, (byte) 5);
                default:
                    return new AnonymousClass2(this.$hideVideoSongs, (MutableState) this.L$2, (MutableState) this.L$0, (SnapshotStateList) obj3, (MusicDatabase) obj2, continuation, (byte) 6);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Object objWithContext;
            byte b = this.$r8$classId;
            EmptySet emptySet = EmptySet.INSTANCE;
            byte b2 = 2;
            boolean z = this.$hideVideoSongs;
            Object obj2 = this.$items;
            Object obj3 = this.$seeds;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        List<Song> list = (List) obj3;
                        List list2 = (List) obj2;
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        for (Song song : list) {
                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                            arrayList.add(AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new HomeViewModel$getDailyDiscover$2$1$1(song, list2, z, null), 2));
                        }
                        it = arrayList.iterator();
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        it = (Iterator) this.L$2;
                        ResultKt.throwOnFailure(obj);
                    }
                    while (it.hasNext()) {
                        Job job = (Job) it.next();
                        this.L$0 = null;
                        this.L$2 = it;
                        this.label = true;
                        if (job.join(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return unit;
                case 1:
                    MutableState mutableState = (MutableState) obj2;
                    Context context = (Context) this.L$2;
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context, continuation, b2);
                        this.label = true;
                        objWithContext = AwaitKt.withContext(defaultIoScheduler, contextExtKt$isSyncEnabled$1, this);
                        if (objWithContext == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objWithContext = obj;
                    }
                    boolean zBooleanValue = ((Boolean) objWithContext).booleanValue();
                    if (!z && !((Boolean) mutableState.getValue()).booleanValue()) {
                        Toast.makeText(context, (String) this.L$0, 0).show();
                    } else if (zBooleanValue) {
                        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                    } else {
                        Toast.makeText(context, (String) obj3, 0).show();
                    }
                    return unit;
                case 2:
                    MutableState mutableState2 = (MutableState) this.L$0;
                    MutableState mutableState3 = (MutableState) this.L$2;
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        if (z && !((List) mutableState3.getValue()).isEmpty()) {
                            mutableState2.setValue(Boolean.TRUE);
                            SafeFlow safeFlowSnapshotFlow = Stack.snapshotFlow(new GapComposer$$ExternalSyntheticLambda0((SnapshotStateMap) obj3, (State) obj2, mutableState3, (byte) 14));
                            DiscordRpcManager.C01441 c01441 = new DiscordRpcManager.C01441(b2, continuation, (byte) 6);
                            this.label = true;
                            if (StateFlowKt.first(safeFlowSnapshotFlow, c01441, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return unit;
                    }
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableState2.setValue(Boolean.FALSE);
                    return unit;
                case 3:
                    boolean z5 = this.label;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.L$2;
                        int i = OriginalLyricsKt.$r8$clinit;
                        int intValue = parcelableSnapshotMutableIntState.getIntValue();
                        this.label = true;
                        if (OriginalLyricsKt.OriginalLyrics$performSmoothPageScroll((LazyListState) this.L$0, (MutableState) obj2, (List) obj3, this.$hideVideoSongs, intValue, 1500, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                case 4:
                    MutableState mutableState4 = (MutableState) this.L$0;
                    boolean z6 = this.label;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        if (z && !((List) ((MutableState) this.L$2).getValue()).isEmpty() && ((List) mutableState4.getValue()) == null) {
                            DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                            DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                            NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(obj3, obj2, (Object) mutableState4, (Continuation) null, (byte) 8);
                            this.label = true;
                            if (AwaitKt.withContext(defaultIoScheduler2, navHostKt$NavHost$29$1, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    } else {
                        if (!z6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                case 5:
                    boolean z7 = this.label;
                    if (!z7) {
                        ResultKt.throwOnFailure(obj);
                        MutableState mutableState5 = (MutableState) this.L$2;
                        if (z) {
                            List list3 = (List) mutableState5.getValue();
                            if (list3 != null) {
                                DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                                DefaultIoScheduler defaultIoScheduler3 = DefaultIoScheduler.INSTANCE;
                                QueueKt$Queue$5$4$1$1$4$1$1$1 queueKt$Queue$5$4$1$1$4$1$1$1 = new QueueKt$Queue$5$4$1$1$4$1$1$1((MutableState) obj3, (MusicDatabase) obj2, list3, (MutableState) this.L$0, (Continuation) null);
                                this.label = true;
                                if (AwaitKt.withContext(defaultIoScheduler3, queueKt$Queue$5$4$1$1$4$1$1$1, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                        } else {
                            mutableState5.setValue(null);
                            ((MutableState) this.L$0).setValue(emptySet);
                        }
                    } else {
                        if (!z7) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                default:
                    MutableState mutableState6 = (MutableState) this.L$0;
                    boolean z8 = this.label;
                    if (!z8) {
                        ResultKt.throwOnFailure(obj);
                        MutableState mutableState7 = (MutableState) this.L$2;
                        if (z) {
                            mutableState7.setValue(emptySet);
                            if (!((List) mutableState6.getValue()).isEmpty()) {
                                DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                                DefaultIoScheduler defaultIoScheduler4 = DefaultIoScheduler.INSTANCE;
                                QueueKt$Queue$5$4$1$1$4$1$1$1 queueKt$Queue$5$4$1$1$4$1$1$2 = new QueueKt$Queue$5$4$1$1$4$1$1$1((SnapshotStateList) obj3, mutableState6, (MusicDatabase) obj2, (MutableState) this.L$2, (Continuation) null);
                                this.label = true;
                                if (AwaitKt.withContext(defaultIoScheduler4, queueKt$Queue$5$4$1$1$4$1$1$2, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                        } else {
                            mutableState7.setValue(emptySet);
                        }
                    } else {
                        if (!z8) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, List list2, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 0;
            this.$seeds = list;
            this.$items = list2;
            this.$hideVideoSongs = z;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(boolean z, Object obj, Object obj2, Object obj3, Object obj4, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$hideVideoSongs = z;
            this.L$2 = obj;
            this.L$0 = obj2;
            this.$seeds = obj3;
            this.$items = obj4;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
    }
}
